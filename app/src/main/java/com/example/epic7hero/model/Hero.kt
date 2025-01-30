package com.example.epic7hero.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Hero(
    val id : Long,
    val name : String,
    val heroLore : String,
    val profileImage : Int,
    val portraitImage : Int,
    val element : Int,
    val rarity : Int,
    val classes : Int,
    val zodiac : Int,
    val heroStats : Stats,
    val skills : List<Skill>,
)
