package com.example.epic7hero.model

data class Skill(
    val skillName : String,
    val skillImage : String,
    val skillDescription : String,
    val skillCooldown : Int = 0,
    val soulObtain : Int = 0
)
