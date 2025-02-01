package com.example.epic7hero.ui.screen.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.di.Injection
import com.example.epic7hero.ui.common.UiState
import com.example.epic7hero.ui.screen.ViewModelFactory

@Composable
fun Detail(
    modifier : Modifier = Modifier,
    heroId : Long,
    viewModel : DetailViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateBack : ()->Unit
){
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState->
        when(uiState){
            is UiState.Loading->{viewModel.getHeroById(id = heroId )}
            is UiState.Success->{
                DetailContent(
                    portraitImage = uiState.data.portraitImage,
                    onFavoriteClick = { id,newState->
                        viewModel.updateFavorite(id,newState)
                    },
                    navigateBack = navigateBack
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    portraitImage : String,
    onFavoriteClick : (Long,Boolean)->Unit,
    navigateBack: () -> Unit
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        AsyncImage(
            model = portraitImage,
            contentScale = ContentScale.Fit,
            contentDescription = null,
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        )
    }
}