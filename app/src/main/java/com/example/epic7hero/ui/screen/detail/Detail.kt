package com.example.epic7hero.ui.screen.detail

import android.graphics.drawable.Drawable
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.epic7hero.R
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.di.Injection
import com.example.epic7hero.model.Skill
import com.example.epic7hero.model.Stats
import com.example.epic7hero.ui.common.UiState
import com.example.epic7hero.ui.components.ExpandableCard
import com.example.epic7hero.ui.screen.ViewModelFactory
import com.example.epic7hero.ui.theme.Epic7HeroTheme


fun Modifier.parallaxLayoutModifier(scrollState : ScrollState , rate : Int)=
    layout{ measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val height =  if(rate > 0) scrollState.value / rate else scrollState.value
        layout(placeable.width,placeable.height){
            placeable.place(0,height)
        }
    }

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
            is UiState.Loading->{viewModel.getHeroById(id =heroId)}
            is UiState.Success->{
                val data = uiState.data
                DetailContent(
                    portraitImage = data.portraitImage,
                    stats = data.heroStats,
                    heroLore = data.heroLore,
                    name = data.name,
                    element = data.element,
                    rarity = data.rarity,
                    classes = data.classes,
                    zodiac = data.zodiac,
                    skills = data.skills,
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
    stats: Stats,
    name : String,
    element : String,
    rarity : String,
    classes : String,
    zodiac : String,
    skills : List<Skill>,
    heroLore : String,
    navigateBack: () -> Unit
){
    val scrollState = rememberScrollState()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            // Portrait image dari hero
            AsyncImage(
                model = portraitImage,
                contentScale = ContentScale.Fit,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .parallaxLayoutModifier(scrollState, 15)
            )

            // Column utama dari detail
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.LightGray,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
            ){
                HeroInformationContent(
                    name = name,
                    rarity = rarity,
                    zodiac = zodiac,
                    classes = classes,
                    element= element)

                HeroDetailContent(stats = stats,heroLore = heroLore)

                // agar parallax bisa terjadi meskipun konten lebih sedikit
                Spacer(modifier = Modifier.height(600.dp))

            }
        }

    }
}

// Fungsi untuk invoke status detail content
@Composable
fun HeroStatInvoke(
    stats: Stats
) {
    val statIcons = listOf(
        R.drawable.attack,
        R.drawable.health,
        R.drawable.defense,
        R.drawable.speed
    )
    val statNames = listOf("Attack","Health","Defense","Speed")
    val statValues = listOf(stats.attack,stats.health,stats.defense,stats.speed)

    statIcons.zip(statNames.zip(statValues)).forEach { (icon,pair)->
        val (name,value ) = pair
        StatDetailContent(icon=icon, stats = value, iconName = name)
    }
}

//
@Composable
fun HeroDetailContent(
    modifier : Modifier = Modifier,
    stats: Stats,
    heroLore: String

){
    Text(text = "Status",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.Center)
    Spacer(modifier = Modifier.padding(8.dp))
    HeroStatInvoke(stats = stats)
    Spacer(modifier = Modifier.padding(8.dp))
    ExpandableCard(
        title = "Hero Lore"
    ) {
        Text(text = heroLore)
    }

}

@Composable
fun HeroInformationContent(
    name : String,
    rarity: String,
    zodiac: String,
    classes: String,
    element: String
){

    Box(
        modifier = Modifier
            .wrapContentSize()
            .border(
                1.dp,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                color = Color.Black
            )
            .background(Color.Green, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(){
                AsyncImage(
                    model = classes,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Classes",
                    modifier = Modifier.size(24.dp)
                )
                Text(text = name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold)
            }
            Row(){
                AsyncImage(
                    model = zodiac,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Zodiac",
                    modifier = Modifier.size(24.dp)
                )
                AsyncImage(
                    model = element,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Element",
                    modifier = Modifier.size(24.dp)
                )
                AsyncImage(
                    model = rarity,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Rarity",
                    modifier = Modifier.size(width = 91.dp, height = 21.dp)
                )
            }

        }
    }
}

@Composable
fun StatDetailContent(
    stats: Long,
    icon : Int,
    iconName : String
){
    Row (
        modifier = Modifier.fillMaxWidth(),
    ){
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = iconName,
            modifier = Modifier.weight(4f)
        )
        Text(text = stats.toString(),
            modifier = Modifier.weight(1f))
    }
}


@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun DetailPreview(){
    Epic7HeroTheme {
        Detail(heroId = 1, navigateBack = {})
    }
}