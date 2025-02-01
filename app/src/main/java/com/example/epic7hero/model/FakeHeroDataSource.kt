package com.example.epic7hero.model

import androidx.compose.ui.res.integerResource
import com.example.epic7hero.R

object FakeHeroDataSource {
    val heroData = listOf(
        Hero(
            id = 1,
            name = "Abigail",
            heroLore = "Before she left Erasia, Melissa Bloodrose gave her beloved little sister Abigail the vampiric power of extended youth. After the departure of Abigail's favorite sister came her family's fall to ruin. As Abigail wandered, lost amidst life's hardships, she one day crossed paths with Vampire Lord Kane an gained the complete power of a vampire.",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/profile/abigail.png",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/portrait/abigail.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/Fire-circle.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/warrior.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/aries.png",
            heroStats = Stats(83,322,73,113),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Ambush",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/skill/1_ambush.png",
                    skillDescription = "Attacks the enemy with bloodied wings, and increases Combat Readiness of the caster by 15%. When used on the caster's turn, has a 35% chance to activate Might as an extra effect. Damage dealt increases proportional to the caster's max Health. Might: Increases Combat Readiness of all allies by 15%.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Ambush",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/skill/1_ambush.png",
                    skillDescription = "Attacks the enemy with bloodied wings, and increases Combat Readiness of the caster by 15%. When used on the caster's turn, has a 35% chance to activate Might as an extra effect. Damage dealt increases proportional to the caster's max Health. Might: Increases Combat Readiness of all allies by 15%.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Ambush",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/skill/1_ambush.png",
                    skillDescription = "Attacks the enemy with bloodied wings, and increases Combat Readiness of the caster by 15%. When used on the caster's turn, has a 35% chance to activate Might as an extra effect. Damage dealt increases proportional to the caster's max Health. Might: Increases Combat Readiness of all allies by 15%.",
                    skillCooldown = 0,
                    soulObtain = 0,
                )
            )
        )
    )
}