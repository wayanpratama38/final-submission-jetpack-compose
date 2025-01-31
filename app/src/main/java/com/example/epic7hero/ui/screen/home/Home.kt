package com.example.epic7hero.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.epic7hero.ui.theme.Epic7HeroTheme

@Composable
fun Home(
    modifier : Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("Home")
    }
}

@Composable
@Preview(showBackground = true,device = Devices.PIXEL_4)
fun HomePreview(){
    Epic7HeroTheme {
        Home()
    }
}