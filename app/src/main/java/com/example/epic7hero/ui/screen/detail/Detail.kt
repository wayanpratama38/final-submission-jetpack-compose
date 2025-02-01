package com.example.epic7hero.ui.screen.detail

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.epic7hero.R
import com.example.epic7hero.data.HeroRepository
import com.example.epic7hero.di.Injection
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
            is UiState.Loading->{viewModel.getHeroById(id = heroId )}
            is UiState.Success->{
                DetailContent(
                    portraitImage = uiState.data.portraitImage,
                    stats = uiState.data.heroStats,
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
    stats: Stats,
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

            HeroDetailContent(stats = stats)
        }

    }
}


@Composable
fun HeroDetailContent(
    modifier : Modifier = Modifier,
    stats: Stats
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray, shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        Text("Lorem ipsum odor amet, consectetuer adipiscing elit. Consectetur taciti dui bibendum ultricies ex. Arcu aliquet eget purus massa lacus ornare eget. Bibendum aliquet a ante enim fermentum a. Rhoncus augue aenean magnis laoreet lacus velit vestibulum congue. Eros congue taciti faucibus ultricies dui integer elit accumsan. Facilisi etiam ridiculus sociosqu magna mollis felis. Maximus adipiscing luctus bibendum accumsan neque nisl montes consectetur sed.\n" +
                "\n" +
                "Vitae ex vulputate nec dui ante at feugiat. Venenatis accumsan mollis quis tempus eu hac. Sodales dui nulla urna; consectetur netus eget. Quis imperdiet sed auctor et ante in bibendum. Nullam leo ultrices; egestas conubia ipsum ridiculus scelerisque. Volutpat arcu egestas velit urna suscipit. Rutrum consequat pretium senectus laoreet, ornare aptent pulvinar et curae. Nisi semper luctus malesuada nibh dis lacinia. Habitant risus commodo etiam malesuada venenatis phasellus. Tellus dictum ante himenaeos blandit nullam.\n" +
                "\n" +
                "Cras lobortis sit suspendisse suscipit dictumst vitae consectetur. Facilisis sollicitudin nostra tincidunt dictum senectus aenean morbi. Ullamcorper ligula orci ullamcorper convallis velit tempus maecenas metus. Magna ad ad torquent porttitor taciti fermentum. Senectus interdum enim orci conubia iaculis. Praesent enim viverra; faucibus aliquam habitasse neque. Diam inceptos mus pellentesque auctor felis. Bibendum ornare semper dignissim, semper dis proin suspendisse. Sem senectus quisque facilisis dis bibendum; ornare sed. Sed habitasse accumsan faucibus ante porttitor.\n" +
                "\n" +
                "Accumsan fusce faucibus sit ultricies; at ac. Curabitur conubia etiam nam habitasse lacus finibus felis. Mauris curae quis tempor taciti elit montes rutrum iaculis. Scelerisque consequat diam scelerisque gravida integer eros conubia curae. Augue mattis volutpat maximus vitae cubilia parturient. Semper risus sapien imperdiet sociosqu, ligula senectus justo. Consequat sed elit; nostra tempor dis vestibulum. Curabitur nisl sollicitudin fusce consectetur, dolor platea cras.\n" +
                "\n" +
                "Nostra leo rhoncus sociosqu commodo posuere maecenas. Odio urna tempor volutpat; turpis in mi. Rhoncus neque vivamus commodo class suspendisse elit mus magna nascetur. Condimentum quisque per et, elit vel quam eget leo. Senectus cras sagittis nunc sollicitudin id eleifend ullamcorper nisi torquent. Sem arcu a venenatis augue, nullam facilisis eros eleifend finibus. Scelerisque senectus maecenas fusce hac vel orci, quam tempus condimentum. Euismod parturient conubia suscipit at diam suscipit felis. Ridiculus maecenas suspendisse risus posuere ad orci senectus cras.\n" +
                "\n" +
                "Eleifend volutpat tellus mus luctus dapibus maecenas; per magna. Hendrerit erat curae non dapibus dictumst. Imperdiet duis dis morbi ligula egestas laoreet fusce curae. Odio semper morbi nibh, potenti mauris enim tempus ipsum. Suscipit hac sed donec felis quam netus ad senectus. Velit blandit bibendum phasellus dui montes tempor vestibulum. Dictum proin ultrices aenean accumsan sem aptent fermentum. Vestibulum mus molestie felis porta; nibh pulvinar. Augue adipiscing hac euismod, finibus cubilia ut.\n" +
                "\n" +
                "In tempus urna lobortis commodo dignissim. Platea at cubilia quis parturient congue efficitur congue fusce lobortis. Platea venenatis phasellus fermentum maximus aptent; netus venenatis dapibus cursus. Vivamus ante quis est; dapibus sapien penatibus. Etiam condimentum vivamus diam; purus iaculis eget. Curae cursus nam metus tellus leo dis. Lorem condimentum maximus sed primis sapien tempus scelerisque. Augue fames arcu per augue integer nibh ac.\n" +
                "\n" +
                "Nullam nunc porttitor feugiat pharetra montes ultricies maecenas. Non mollis lacus luctus hac vivamus. Eget bibendum dis hendrerit sit justo dolor velit. Mattis dictum at habitasse vel malesuada vivamus arcu. Nostra tristique dis semper dictum imperdiet hac donec metus ad. Velit venenatis hac commodo proin viverra curabitur feugiat.\n" +
                "\n" +
                "Dolor amet arcu ultrices nec nisi mus tortor cursus. Ut sapien erat id ornare at suscipit lobortis iaculis. Sodales nisl curae dictum ipsum dictum neque eros curabitur. Neque metus cras taciti torquent nibh. Efficitur ultricies a pretium magnis diam at nunc quis sodales. Habitasse dapibus tempor eu senectus dui.\n" +
                "\n" +
                "Condimentum ultrices torquent nisl aenean ipsum. Varius ex odio ut vivamus ridiculus dignissim nisi potenti sem. Auctor in vivamus urna ad nascetur malesuada volutpat id. Nam rutrum vulputate congue elit lobortis dolor. Dictumst tellus natoque accumsan orci; ipsum cubilia eros. Himenaeos sem nam consectetur varius aliquam iaculis. Tempus platea laoreet, interdum tristique elit interdum molestie condimentum. Eget lobortis rhoncus cursus amet accumsan in suspendisse ante.",)
        ExpandableCard(
            title = "Stat",
        ) {
            Row(
              verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(R.drawable.attack),
                    contentDescription = null,
                )
                Text(
                    text = stats.attack.toString(),
                    fontSize = 12.sp
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun DetailPreview(){
    Epic7HeroTheme {
        Detail(heroId = 1, navigateBack = {})
    }
}