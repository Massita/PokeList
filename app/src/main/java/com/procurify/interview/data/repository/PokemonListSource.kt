package com.procurify.interview.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.procurify.interview.data.model.Pokemon
import com.procurify.interview.data.network.API

class PokemonListSource(private val api: API) : PagingSource<Int, Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val offset = params.key ?: 0
            val response = api.getPokemons(params.loadSize, offset)
            val next = if (response.next == null) {
                null
            } else {
                offset + params.loadSize
            }

            LoadResult.Page(
                data = response.results,
                prevKey = null,
                nextKey = next,
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}