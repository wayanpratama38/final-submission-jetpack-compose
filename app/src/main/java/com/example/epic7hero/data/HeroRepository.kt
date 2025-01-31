package com.example.epic7hero.data

import com.example.epic7hero.model.FakeHeroDataSource
import com.example.epic7hero.model.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class HeroRepository {

    private val heroes  = mutableListOf<Hero>()

    init{
        if(heroes.isEmpty()){
            FakeHeroDataSource.heroData.forEach {
                heroes.add(it)
            }
        }
    }

    fun getAllHero():Flow<List<Hero>>{
        return flowOf(heroes)
    }

    fun getFavoriteHero():Flow<List<Hero>>{
        return getAllHero().map {heroes->
                heroes.filter{ hero->
                    hero.isFavorite
                }
        }
    }


    companion object {
        @Volatile
        private var instance: HeroRepository? = null

        fun getInstance(): HeroRepository =
            instance ?: synchronized(this) {
                HeroRepository().apply {
                    instance = this
                }
            }
    }
}