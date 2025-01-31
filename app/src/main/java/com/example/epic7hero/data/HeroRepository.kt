package com.example.epic7hero.data

import com.example.epic7hero.model.FakeHeroDataSource
import com.example.epic7hero.model.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class HeroRepository {

    private val heroes  = mutableListOf<Hero>()

    private val _heroesData = MutableStateFlow<List<Hero>>(emptyList())
    val heroesData : StateFlow<List<Hero>> = _heroesData.asStateFlow()

    init{
//        if(heroes.isEmpty()){
//            FakeHeroDataSource.heroData.forEach {
//                heroes.add(it)
//            }
//        }
        if(_heroesData.value.isEmpty()){
            _heroesData.value = FakeHeroDataSource.heroData.toList()
        }
    }

    fun getAllHero():Flow<List<Hero>> = heroesData

    fun getFavoriteHero():Flow<List<Hero>>{
        return heroesData.map {heroes->
                heroes.filter{ hero->
                    hero.isFavorite
                }
        }
    }

    fun searchHero(query : String):Flow<List<Hero>>{
        return heroesData.map{
            heroes.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }

    fun updateHeroes(id:Long,newState:Boolean): Flow<Boolean> {
        val updatedHeroes = _heroesData.value.map {hero->
            if(hero.id == id) hero.copy(isFavorite = newState) else hero
        }
        _heroesData.value = updatedHeroes
        return flowOf(true)
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