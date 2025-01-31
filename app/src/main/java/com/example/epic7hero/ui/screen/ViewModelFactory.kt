package com.example.epic7hero.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.ui.screen.home.HomeViewModel

class ViewModelFactory(val repository : HeroRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel>create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class: "+ modelClass.name)
    }
}