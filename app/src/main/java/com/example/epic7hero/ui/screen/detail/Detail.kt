package com.example.epic7hero.ui.screen.detail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.di.Injection
import com.example.epic7hero.ui.common.UiState
import com.example.epic7hero.ui.screen.ViewModelFactory


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
            AsyncImage(
                model = portraitImage,
                contentScale = ContentScale.Fit,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .parallaxLayoutModifier(scrollState,15)
            )

            HeroDetailContent()
        }

    }
}


@Composable
fun HeroDetailContent(
    modifier : Modifier = Modifier,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        Text(text = "Lorem ipsum odor amet, consectetuer adipiscing elit. Ultrices morbi porta fermentum interdum cubilia efficitur placerat nec ad. Habitasse natoque suspendisse; per feugiat venenatis inceptos venenatis habitasse. Non sapien leo aliquam dis potenti elit dis. Commodo enim penatibus fames malesuada vehicula imperdiet justo. Accumsan dapibus justo non semper ligula ut cras dui. Dis consectetur natoque tellus sagittis varius parturient dis ex. Eget inceptos sollicitudin potenti sollicitudin class. Curabitur quam ornare ipsum dis, sed viverra ad.\n" +
                "\n" +
                "Ut orci hac quis integer nulla non venenatis eleifend aptent. Mauris elementum cras praesent hendrerit integer ligula tempus etiam nullam. Habitant nec phasellus eu semper quam. Habitant pulvinar tempor taciti dignissim habitasse auctor maximus tristique. Habitant posuere mus vel nibh proin vel quis ultricies faucibus. Feugiat in litora amet cras orci; eu nisl fermentum. Cras vivamus eu volutpat; taciti sapien venenatis gravida imperdiet.\n" +
                "\n" +
                "Convallis mauris massa sociosqu malesuada in. Vitae himenaeos elit nullam non, massa dui. Pulvinar commodo auctor conubia platea consequat vulputate. Odio finibus nibh aenean feugiat maximus. Malesuada feugiat malesuada quam tincidunt interdum magnis lobortis neque integer. Adipiscing tincidunt placerat venenatis condimentum penatibus urna erat; mollis tempor. Urna blandit at donec consectetur eros libero integer vivamus.\n" +
                "\n" +
                "Luctus imperdiet hendrerit ultrices nisl suspendisse malesuada. Quisque nullam adipiscing luctus etiam malesuada. Donec elit cras maecenas; vestibulum vivamus tempus. Porttitor suspendisse donec placerat pretium pharetra natoque eget suscipit. Sem aliquam molestie nunc; lorem suscipit blandit. Nibh consectetur tellus ultrices felis, sollicitudin sapien ut ipsum et. Facilisi potenti cras hac faucibus montes. Nulla lacus finibus dis dictumst interdum.\n" +
                "\n" +
                "Vel volutpat class ornare dapibus sodales ex. Molestie arcu ipsum est mus dapibus. Accumsan libero nullam maximus eu; sociosqu posuere odio. Aenean posuere erat risus eu est accumsan. Etiam conubia ipsum facilisis sociosqu aptent lobortis. Nunc condimentum cras scelerisque curae tortor. Venenatis convallis mi taciti quam hendrerit. Velit nisi metus fames porttitor sodales.\n" +
                "\n" +
                "Efficitur tempus integer porta et maecenas. Enim condimentum risus fames etiam pellentesque quisque iaculis nullam. Luctus inceptos nulla ultricies sagittis himenaeos bibendum luctus praesent. Non magnis primis primis porta fermentum turpis feugiat congue. Dui volutpat sit eget facilisis orci a placerat suspendisse sodales. Fermentum montes urna per diam ante eu metus viverra.\n" +
                "\n" +
                "Gravida pellentesque ornare vitae pulvinar quisque elementum. Nisl cubilia fusce bibendum scelerisque senectus augue hac aptent ac. Malesuada dis placerat mi elementum tempor ligula dictum bibendum varius. Cras vehicula massa nunc cubilia integer. Platea tempus laoreet feugiat; pretium aliquam vehicula. Neque nascetur amet nullam eget dui ultrices justo erat? Tempor arcu mauris conubia metus vehicula. Etiam habitant nostra tempor cras suspendisse mi.\n" +
                "\n" +
                "Habitant dignissim ac dictum posuere et id tempor suspendisse. Diam odio sit quam; diam rhoncus purus. Eu vulputate velit metus himenaeos pharetra enim semper justo rutrum. Consectetur parturient varius fames suscipit turpis nostra. Adipiscing parturient nisi libero scelerisque ex condimentum suscipit. Erat eros dictum torquent; finibus faucibus neque nisl. Non per diam mollis duis nunc finibus semper fusce. Dapibus himenaeos in id velit pretium natoque litora. Purus sapien ultricies mi scelerisque tempor posuere.\n" +
                "\n" +
                "Turpis suscipit ornare tortor; condimentum ullamcorper facilisi mi porta. Eu placerat taciti hac potenti primis consequat. Risus mi imperdiet ligula ridiculus efficitur sit. Orci ullamcorper dignissim phasellus ullamcorper platea himenaeos cubilia taciti. Mollis ultrices pretium risus sapien taciti mus dis suscipit. Convallis ridiculus ut auctor eget fusce fringilla. Magna suscipit mi ultricies, viverra pharetra proin conubia rhoncus urna. Dictum leo lectus dapibus nibh netus dis. Diam arcu tempor eros tempor pulvinar, fusce netus condimentum.\n" +
                "\n" +
                "Laoreet fringilla luctus curae lacinia tristique, habitant finibus et. Quam urna vulputate, sagittis taciti luctus penatibus. Mollis magna curae mattis auctor consectetur justo bibendum. Lobortis diam sit sollicitudin augue nibh proin. Torquent taciti ad condimentum feugiat et amet curabitur. Pretium nullam integer ultricies magnis diam fusce. Taciti habitasse vehicula; pulvinar pellentesque eu imperdiet augue. Amet ultrices torquent phasellus leo massa praesent.",
            modifier = Modifier.padding(16.dp))
    }
}