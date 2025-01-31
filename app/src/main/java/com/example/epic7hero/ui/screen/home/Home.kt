package com.example.epic7hero.ui.screen.home

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.model.Hero
import com.example.epic7hero.ui.common.UiState
import com.example.epic7hero.ui.components.HeroCard
import com.example.epic7hero.ui.screen.ViewModelFactory
import com.example.epic7hero.ui.theme.Epic7HeroTheme

@Composable
fun Home(
    modifier : Modifier = Modifier,
    viewModel: HomeViewModel  = viewModel(
        factory = ViewModelFactory(HeroRepository.getInstance())
    ),
    navigateToDetail : (Long) -> Unit
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState->
        when(uiState){
            is UiState.Loading -> viewModel.getAllHero()
            is UiState.Success -> HomeContent(uiState.data,modifier,navigateToDetail)
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    heroes : List<Hero>,
    modifier : Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
){
    LazyColumn(
            modifier = modifier
    ) {
        items(heroes){ data->
            HeroCard(
                name = data.name,
                profileImage = data.profileImage,
                element = data.element,
                rarity = data.rarity,
                classes = data.classes,
                zodiac = data.zodiac,
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