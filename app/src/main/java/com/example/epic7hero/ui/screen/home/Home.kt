package com.example.epic7hero.ui.screen.home

import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.epic7hero.R
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.model.Hero
import com.example.epic7hero.ui.common.UiState
import com.example.epic7hero.ui.components.HeroCard
import com.example.epic7hero.ui.components.SearchBar
import com.example.epic7hero.ui.screen.ViewModelFactory
import com.example.epic7hero.ui.theme.Epic7HeroTheme

@Composable
fun Home(
    modifier : Modifier = Modifier,
    viewModel: HomeViewModel  = viewModel(
        factory = ViewModelFactory(HeroRepository.getInstance())
    ),
    navigateToDetail : (Long) -> Unit,
    ){
    val query by viewModel.query
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState->
        when(uiState){
            is UiState.Loading -> {
                if(query!=""){
                    viewModel.searchHero(query)
                }else{
                    viewModel.getAllHero()
                }
            }
            is UiState.Success -> {
                HomeContent(
                    heroes = uiState.data,
                    modifier = modifier,
                    navigateToDetail = { id ->
                        navigateToDetail(id)
                    },
                    query = query,
                    onQueryChange = {
                        viewModel.searchHero(it)
                    },
                    onFavoriteClick = {id,newState->
                        viewModel.updateHeroes(id,newState)
                    }
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    heroes : List<Hero>,
    query : String,
    modifier : Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
    onQueryChange : (String) -> Unit,
    onFavoriteClick: (id: Long, newState: Boolean) -> Unit
){
    Column{
        SearchBar(
            query = query,
            onQueryChange = onQueryChange
        )
        if(heroes.isNotEmpty()){
            HeroesCard(
                heroes = heroes,
                onFavoriteClick = onFavoriteClick,
                navigateToDetail =  navigateToDetail
            )
        }else{
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = stringResource(R.string.hero_not_found),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}

@Composable
fun HeroesCard(
    heroes : List<Hero>,
    onFavoriteClick : (id : Long,newState : Boolean)->Unit,
    navigateToDetail: (Long) -> Unit,
    modifier : Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ) {
        items(heroes,key= {it.id}){ data->
            HeroCard(
                id = data.id,
                name = data.name,
                profileImage = data.profileImage,
                element = data.element,
                rarity = data.rarity,
                classes = data.classes,
                zodiac = data.zodiac,
                isFavorite = data.isFavorite,
                onFavoriteClick = onFavoriteClick,
                modifier = modifier.clickable {
                    navigateToDetail(data.id)
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true,device = Devices.PIXEL_4)
fun HomePreview(){
    Epic7HeroTheme {
        Home(navigateToDetail = {})
    }
}