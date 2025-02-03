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
            heroStats = Stats(attack = 984,health = 6266 ,defense = 637,speed = 117),
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
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/skill/2_blood_banquet.png",
                    skillDescription = "At the start of the turn, curses the enemy with the highest Attack for 1 turn. When the ally in the back row except for the caster receives lethal damage, consumes 30% of the caster's current Health, dispelling all debuffs from the target, before granting immortality and vampirism for 1 turn. Can only be activated once every 5 turns",
                    skillCooldown = 5,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Ambush",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abigail/skill/3_scarlet_garden.png",
                    skillDescription = "After dispelling all buffs from the enemy, attacks with a field of bloody thorns, inflicting injuries. Increases Effectiveness of this attack by 50% and damage dealt increases proportional to the caster's max Health. The severity of injuries increases proportional to damage dealt. Injuries decrease max Health of the target by up to 25% every time this skill is used.",
                    skillCooldown = 5,
                    soulObtain = 3,
                )
            )
        ),Hero(
            id = 2,
            name = "Abyssal Yufine",
            heroLore = "A pure-blooded Dragon who had been holding onto hope even throughout the long-lasting war. But one day, the Dragons started to experiment with dark magic stones they brought from the village of the Karoons. One by one, she is losing all her friends, family, and even herself.",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abyssal_yufine/profile/abyssal_yufine.png",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abyssal_yufine/portrait/abyssal_yufine.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/Dark-circle.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/knight.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/aquarius.png",
            heroStats = Stats(attack=830,defense=713,health=6619,speed=106),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Dragon's Breath",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abyssal_yufine/skill/1_dragons_breath.png",
                    skillDescription = "Attacks all enemies with dragon's breath, with a 45% chance to decrease Attack for 1 turn. Damage dealt increases proportional to the caster's Defense. When the caster is inflicted with trauma, activates Unbridled Outburst instead of Dragon's Breath. Unbridled Outburst: Attacks the enemy with a massive blade. Penetrates the target's Defense by 70%.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Inner Abyss",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abyssal_yufine/skill/2_inner_abyss.png",
                    skillDescription = "When the enemy is not an Elite or Boss monster, reduces the effect of Combat Readiness increases granted to the enemy by 30%. This effect does not stack with other passive effects of the same name. When attacked, gains 20 Fighting Spirit and has a 30% chance to counterattack. At the start of the turn, when Fighting Spirit is full, dispels all debuffs from the caster.",
                    skillCooldown = 0,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Frenzied Strike",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/abyssal_yufine/skill/3_frenzied_strike.png",
                    skillDescription = "Inflicts trauma on the caster for 3 turns, before attacking all enemies, dispelling all buffs and decreasing Combat Readiness by 50%. Ignores Effect Resistance.",
                    skillCooldown = 5,
                    soulObtain = 3,
                )
            )
        ),Hero(
            id = 3,
            name = "Ambitious Tywin",
            heroLore = "Arrogant and cruel, he sees others only as pawns to be used for his own ends. He's so skilled at managing his reputation that he's known as a reliable and loyal knight despite his true nature.",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/ambitious_tywin/portrait/ambitious_tywin.png",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/ambitious_tywin/profile/ambitious_tywin.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/Light-circle.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/knight.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/sagittarius.png",
            heroStats = Stats(attack=894,defense=694,health=6840,speed=104),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Icy Sword Storm",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/ambitious_tywin/skill/1_icy_sword_storm.png",
                    skillDescription = "Attacks with a sword, with a 60% chance to provoke for 1 turn. Removes 4 Souls from the opponent. When the caster is enraged, ignores Effect Resistance. Damage dealt increases proportional to the caster's max Health.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Battle Command",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/ambitious_tywin/skill/2_battle_command.png",
                    skillDescription = "After being attacked, when an ally has a debuff, has a 75% chance to dispel one debuff from all allies, and enrages the caster for 1 turn. Can only activate once per turn.",
                    skillCooldown = 0,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Flash",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/ambitious_tywin/skill/3_flash.png",
                    skillDescription = "Attacks all enemies with an instant swordstorm, with a 65% chance each to stun for 1 turn and decrease Defense for 2 turns. When the caster is enraged, ignores Effect Resistance. Damage dealt increases proportional to the caster's max Health.",
                    skillCooldown = 5,
                    soulObtain = 3,
                )
            )
        ),

    )
}