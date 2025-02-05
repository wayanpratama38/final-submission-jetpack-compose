package com.example.epic7hero.ui.screen.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.SubcomposeAsyncImage
import com.example.epic7hero.R
import com.example.epic7hero.di.Injection
import com.example.epic7hero.model.Skill
import com.example.epic7hero.model.Stats
import com.example.epic7hero.ui.common.UiState
import com.example.epic7hero.ui.components.ExpandableCard
import com.example.epic7hero.ui.screen.ViewModelFactory
import com.example.epic7hero.ui.theme.Epic7HeroTheme
import kotlinx.coroutines.launch

// Menambahkan extension parralaxLayoutModifier ke Modifier
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
    // deklarasi scrollState
    val scrollState = rememberScrollState()

    // State simpanan dan deklarasi coroutine scope
    val coroutineScope = rememberCoroutineScope()
    val showButton : Boolean by remember {
        derivedStateOf { scrollState.value>100 }
    }

    val showBack : Boolean by remember {
        derivedStateOf { scrollState.value<100 }
    }

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .testTag("screenScroll"),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            // Portrait image dari hero
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), // Beri tinggi tetap agar layout di bawahnya tidak bergeser
                contentAlignment = Alignment.Center
            ) {
                SubcomposeAsyncImage(
                    model = portraitImage,
                    contentScale = ContentScale.Fit,
                    contentDescription = name,
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                        .parallaxLayoutModifier(scrollState, 15),
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(64.dp),
                                color = MaterialTheme.colorScheme.onPrimary,
                                trackColor = MaterialTheme.colorScheme.onSurface,
                                strokeWidth = 1.dp,
                            )
                        }
                    }
                )
            }

            // Column utama dari detail
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = MaterialTheme.colorScheme.onSurface,
                        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                    )
                    .padding(bottom = 40.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                HeroInformationContent(
                    name = name,
                    rarity = rarity,
                    zodiac = zodiac,
                    classes = classes,
                    element= element)

                // invoke hero stat
                HeroStatInvoke(stats = stats)
                // invoke hero lore
                HeroLoreInvoke(heroLore = heroLore)
                // invoke hero skill
                HeroSkillsInvoke(skills = skills)
            }
        }

        // Animasi Visibilitas dari tombol back
        AnimatedVisibility(
            visible = showBack,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.TopStart)
                .testTag("backButton")
        ) {
            IconButton(
                onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    tint = MaterialTheme.colorScheme.surface,
                    modifier = Modifier
                        .size(32.dp)
                        .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.onSurface)
                        .padding(8.dp)

                )
            }
        }

        // animasi visibilitas dari tombol scroll to top
        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)
                .testTag("scrollToTopButton")
        ) {
            ScrollToTopButton(
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollTo(0)
                    }
                }
            )
        }
    }
}

@Composable
fun HeroSkillsInvoke(
    skills: List<Skill>
){
    ExpandableCard(
        title = stringResource(R.string.skills)
    ) {
        skills.forEach { skill ->
            HeroSkillUi(
                skillImage = skill.skillImage,
                skillName = skill.skillName,
                skillDescription = skill.skillDescription,
                skillCooldown = skill.skillCooldown,
                soulObtain = skill.soulObtain
            )
        }
    }
}

@Composable
fun HeroSkillUi(
    skillImage : String,
    skillName : String,
    skillDescription : String,
    skillCooldown : Int,
    soulObtain : Int,
){
    Row(
        modifier = Modifier
            .wrapContentSize()
            .padding(8.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(width = 1.dp, color = Color.Black, shape = RectangleShape)
            .background(MaterialTheme.colorScheme.onSecondary),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            SubcomposeAsyncImage(
                model = skillImage,
                contentDescription = skillName,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(width = 82.dp, height = 84.dp),
                loading = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.onPrimary,
                            trackColor = MaterialTheme.colorScheme.onSurface,
                            strokeWidth = 1.dp,
                        )
                    }
                }
            )
            Text(
                text = skillName,
                modifier = Modifier.width(82.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Column (
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Description",
                fontWeight = FontWeight.Bold,
                modifier  = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.titleSmall
            )
            Text(text = skillDescription,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium
            )
            if(soulObtain>0){
                Row(
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(text = "Cooldown : $skillCooldown Turn",
                        modifier = Modifier.weight(3f),
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(text = "Souls Obtain : $soulObtain",
                        color = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.weight(2f),
                        textAlign = TextAlign.Right,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }else{
                Text(text = "Cooldown : $skillCooldown",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyMedium
                )
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
    val statNames = listOf(
        stringResource(R.string.attack),
        stringResource(R.string.health),
        stringResource(R.string.defense),
        stringResource(R.string.speed)
    )
    val statValues = listOf(stats.attack,stats.health,stats.defense,stats.speed)

    Text(text = stringResource(R.string.status),
        modifier = Modifier
            .fillMaxWidth(),
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onSecondary,
        textAlign = TextAlign.Center
    )
    statIcons.zip(statNames.zip(statValues)).forEach { (icon,pair)->
        val (name,value ) = pair
        StatDetailContent(icon=icon, stats = value, iconName = name)
    }
}

// fungsi untuk invoke lore hero
@Composable
fun HeroLoreInvoke(
    heroLore : String
){
    ExpandableCard(
        title = stringResource(R.string.hero_lore)
    ) {
        Row (
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                .background(MaterialTheme.colorScheme.onSecondary),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = heroLore,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

// fungsi untuk menampilkan informasi dasar hero
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
            .background
                (
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            ),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row{
                SubcomposeAsyncImage(
                    model = classes,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Classes",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary),
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.onPrimary,
                                trackColor = MaterialTheme.colorScheme.onSurface,
                                strokeWidth = 1.dp,
                            )
                        }
                    }
                )
                Text(text = name,
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.titleLarge)
            }
            Row{
                SubcomposeAsyncImage(
                    model = zodiac,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Zodiac",
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondary),
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.onPrimary,
                                trackColor = MaterialTheme.colorScheme.onSurface,
                                strokeWidth = 1.dp,
                            )
                        }
                    }
                )
                SubcomposeAsyncImage(
                    model = element,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Element",
                    modifier = Modifier.size(24.dp),
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.onPrimary,
                                trackColor = MaterialTheme.colorScheme.onSurface,
                                strokeWidth = 1.dp,
                            )
                        }
                    }
                )
                SubcomposeAsyncImage(
                    model = rarity,
                    contentScale = ContentScale.Fit,
                    contentDescription = "Rarity",
                    modifier = Modifier.size(width = 91.dp, height = 21.dp),
                    loading = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.onPrimary,
                                trackColor = MaterialTheme.colorScheme.onSurface,
                                strokeWidth = 1.dp,
                            )
                        }
                    }
                )
            }
        }
    }
}

// fungsi untuk menampilkan detail status hero
@Composable
fun StatDetailContent(
    stats: Long,
    icon : Int,
    iconName : String
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            painter = painterResource(icon),
            contentDescription = iconName,
            modifier = Modifier.weight(1f),
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = iconName,
            modifier = Modifier.weight(4f),
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.bodyLarge
        )
        Text(text = stats.toString(),
            modifier = Modifier.weight(1f),
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

// fungsi untuk scroll kembali ke atas
@Composable
fun ScrollToTopButton(
    onClick : () -> Unit,
    modifier: Modifier = Modifier
){
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowUp,
            contentDescription = "Scroll to Top"
        )
    }
}

// fungsi preview
@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun DetailPreview(){
    Epic7HeroTheme {
        Detail(heroId = 1, navigateBack = {})
    }
}