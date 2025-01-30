package com.example.epic7hero

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.epic7hero.ui.theme.Epic7HeroTheme


@Composable
fun EpicSevenApp(
    modifier : Modifier = Modifier
){
    Scaffold(
        modifier = modifier.fillMaxSize(),

    ) { innerPadding->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Home"
            )
        }

    }
}

@Composable
@Preview(showBackground = true, device = Devices.PIXEL_4)
fun EpicSevenAppPreview(){
    Epic7HeroTheme {
        EpicSevenApp()
    }
}