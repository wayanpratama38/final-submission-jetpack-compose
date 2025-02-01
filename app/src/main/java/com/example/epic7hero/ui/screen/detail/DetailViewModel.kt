package com.example.epic7hero.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.model.Hero
import com.example.epic7hero.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: HeroRepository) : ViewModel() {
    private val _uiState : MutableStateFlow<UiState<Hero>> = MutableStateFlow(UiState.Loading)
    val uiState : StateFlow<UiState<Hero>> get() = _uiState


    fun getHeroById(id : Long)=viewModelScope.launch {
        _uiState.value = UiState.Loading
        _uiState.value = UiState.Success(repository.getHeroById(id))
    }

    fun updateHeroes(id:Long,newState:Boolean) = viewModelScope.launch {
        repository.updateHeroes(id,newState)
            .catch {
                _uiState.value = UiState.Error(it.message.toString())
            }
    }
}