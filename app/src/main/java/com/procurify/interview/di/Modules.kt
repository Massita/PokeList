package com.procurify.interview.di

import com.procurify.interview.data.network.API
import com.procurify.interview.data.repository.PokemonRepositoryImpl
import com.procurify.interview.domain.PokemonRepository
import com.procurify.interview.ui.pokemon.list.PokemonListViewModel
import com.procurify.interview.utils.BASE_URL
import okhttp3.OkHttpClient
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .build()
    }
    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API::class.java)
    }
}

val appModules = module {
    singleOf(::PokemonRepositoryImpl) { bind<PokemonRepository>() }
    viewModelOf(::PokemonListViewModel)
}