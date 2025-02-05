package com.example.epic7hero.ui.screen.favorite

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.epic7hero.R
import com.example.epic7hero.di.Injection
import com.example.epic7hero.model.Hero
import com.example.epic7hero.ui.common.UiState
import com.example.epic7hero.ui.screen.ViewModelFactory
import com.example.epic7hero.ui.screen.home.HeroesCard
import com.example.epic7hero.ui.theme.Epic7HeroTheme

@Composable
fun Favorite(
    viewModel: FavoriteViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail : (Long)->Unit
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState->
        when(uiState){
            is UiState.Loading ->{
                viewModel.getFavoriteHeroes()
            }
            is UiState.Success -> {
                FavoriteContent(
                    heroes = uiState.data,
                    navigateToDetail = {id->
                        navigateToDetail(id)
                    },
                    onFavoriteClick = { id,newState->
                        viewModel.updateHeroes(id,newState)
                    }
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun FavoriteContent(
    heroes : List<Hero>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
    onFavoriteClick: (Long, Boolean) -> Unit
){
    Column{
        if(heroes.isNotEmpty()){
            HeroesCard(
                heroes = heroes,
                navigateToDetail =  navigateToDetail,
                onFavoriteClick =  onFavoriteClick
            )
        }else{
            Box(
                modifier = modifier.fillMaxSize().
                testTag("emptyFavorite"),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text= stringResource(R.string.no_favorite_hero),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

            }

        }
    }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun FavoritePreview(){
    Epic7HeroTheme {
        Favorite(navigateToDetail = {})
    }
}