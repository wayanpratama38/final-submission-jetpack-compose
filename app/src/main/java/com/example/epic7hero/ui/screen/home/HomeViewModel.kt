package com.example.epic7hero.ui.screen.home

import android.app.DownloadManager.Query
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.model.Hero
import com.example.epic7hero.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HeroRepository):ViewModel() {
    private val _uiState : MutableStateFlow<UiState<List<Hero>>> = MutableStateFlow(UiState.Loading)
    val  uiState : StateFlow<UiState<List<Hero>>> get() = _uiState

    private val _query = mutableStateOf("")
    val query : State<String> get() = _query

    fun searchHero(newQuery: String){
        _query.value = newQuery
    }

    fun getAllHero(){
        viewModelScope.launch {
            repository.getAllHero()
                .catch{
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect{heroes->
                    _uiState.value = UiState.Success(heroes)
                }
        }
    }
}