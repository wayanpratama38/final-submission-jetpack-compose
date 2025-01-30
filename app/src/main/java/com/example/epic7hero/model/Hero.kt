package com.example.epic7hero.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Hero(
    val id : Long,
    val name : String,
    val heroLore : String,
    val profileImage : String,
    val portraitImage : String,
    val rarity : String,
    val classes : String,
    val zodiac : String,
    val heroStats : Stats,
    val skills : List<Skill>,
)
