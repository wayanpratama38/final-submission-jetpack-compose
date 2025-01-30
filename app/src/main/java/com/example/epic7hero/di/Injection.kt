package com.example.epic7hero.di

import com.example.epic7hero.data.HeroRepository

object Injection {
    fun provideRepository() : HeroRepository{
        return HeroRepository.getInstance()
    }
}