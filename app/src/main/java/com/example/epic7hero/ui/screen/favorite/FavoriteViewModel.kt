package com.example.epic7hero.ui.screen.favorite

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.model.Hero
import com.example.epic7hero.ui.common.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: HeroRepository) : ViewModel() {
    private val _uiState : MutableStateFlow<UiState<List<Hero>>> = MutableStateFlow(UiState.Loading)
    val uiState : StateFlow<UiState<List<Hero>>> get() = _uiState

    fun getFavoriteHeroes(): Flow<List<Hero>> {
        return repository.getFavoriteHero()
    }

    fun updateHeroes(id:Long,newState:Boolean) = viewModelScope.launch {
        repository.updateHeroes(id,newState)
            .catch {
                _uiState.value = UiState.Error(it.message.toString())
            }
    }

}