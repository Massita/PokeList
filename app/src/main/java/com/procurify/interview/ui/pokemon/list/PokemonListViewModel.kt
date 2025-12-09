package com.procurify.interview.ui.pokemon.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.procurify.interview.domain.PokemonRepository

class PokemonListViewModel(pokemonRepository: PokemonRepository) : ViewModel() {
    val pokemonList = pokemonRepository.getPokemonList().cachedIn(viewModelScope)
}