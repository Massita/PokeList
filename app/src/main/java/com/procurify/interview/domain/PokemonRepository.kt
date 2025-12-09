package com.procurify.interview.domain

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.procurify.interview.data.model.Pokemon
import kotlinx.coroutines.flow.Flow


interface PokemonRepository {
    fun getPokemonList(): Flow<PagingData<Pokemon>>
}
