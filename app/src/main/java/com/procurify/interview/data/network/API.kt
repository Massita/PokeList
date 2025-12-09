package com.procurify.interview.data.network

import com.procurify.interview.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface API {
    @GET("pokemon/")
    suspend fun getPokemons(@Query("limit") limit: Int?,
                            @Query("offset") offset: Int?): PokemonResponse

}