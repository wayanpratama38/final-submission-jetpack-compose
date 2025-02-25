package com.example.epic7hero.data

import com.example.epic7hero.model.FakeHeroDataSource
import com.example.epic7hero.model.Hero
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class HeroRepository {


    private val _heroesData = MutableStateFlow<List<Hero>>(emptyList())
    private val heroesData : StateFlow<List<Hero>> = _heroesData.asStateFlow()

    init{
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

    fun getHeroById(id : Long):Hero{
        return heroesData.value.let {
            heroesList -> heroesList.first {
                it.id==id
            }
        }
    }

    fun searchHero(query : String):Flow<List<Hero>>{
        return heroesData
            .map { heroesList ->
                heroesList.filter { hero ->
                    hero.name.contains(query,ignoreCase = true)
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