package com.procurify.interview.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.procurify.interview.data.model.Pokemon
import com.procurify.interview.data.network.API
import com.procurify.interview.domain.PokemonRepository
import kotlinx.coroutines.flow.Flow

class PokemonRepositoryImpl(private val api: API) : PokemonRepository {
    override fun getPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 10,
            )
        ) {
            PokemonListSource(api)
        }.flow
    }
}