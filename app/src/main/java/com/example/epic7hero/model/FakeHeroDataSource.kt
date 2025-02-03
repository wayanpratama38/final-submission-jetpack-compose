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
        ),Hero(
            id = 4,
            name = "Aria",
            heroLore = "The leader of the Shadow Elves, a race that has cut all ties with the outside world and has chosen to live in Recluse's Forest. She is hard to read and gives off a cold impression, and is extremely hostile to everyone other than her people.",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/aria/portrait/aria.png",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/aria/profile/aria.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/Ice-circle.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/mage.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/taurus.png",
            heroStats = Stats(attack=1039,defense=673,health=5299,speed=115),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Shadow Call",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/aria/skill/1_shadow_call.png",
                    skillDescription = "Attacks two enemies with shadows, with a 40% chance to decrease Hit Chance for 1 turn. When it is not the caster's turn, increases effect chance by 20%. Damage dealt increases proportional to the caster's Defense.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Guide of Darkness",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/aria/skill/2_guide_of_darkness.png",
                    skillDescription = "Increases Critical Hit Chance by 20%. After using a skill, when Focus is full, consumes all Focus to activate Dark Shadow Phantom.Dark Shadow Phantom: Attacks all enemies, dispelling two buffs and decreasing Combat Readiness by 30%. Damage dealt increases proportional to the caster's Defense.",
                    skillCooldown = 0,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "The Umbral Hour",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/aria/skill/3_the_umbral_hour.png",
                    skillDescription = "Using the power of the shadows, increases Defense of the caster and adopts a counterattacking stance for 2 turns. Grants stealth and a barrier to all allies except for the caster for 2 turns. Barrier strength increases proportional to the caster's Defense.",
                    skillCooldown = 5,
                    soulObtain = 3,
                )
            )
        ),Hero(
            id = 5,
            name = "Immortal Wukong",
            heroLore = "An Automatic Doll developed in Politia. Though virtually indestructible, this model can be neutralized through a program called GINGOA. He was initially sealed away for some time after being deemed too risky for missions. However, he was later reactivated for a mission as he was the most suitable candidate.",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/immortal_wukong/portrait/immortal_wukong.png",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/immortal_wukong/profile/immortal_wukong.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/Earth-circle.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/warrior.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/scorpio.png",
            heroStats = Stats(attack=1208,defense=616,health=6488,speed=102),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Swing",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/immortal_wukong/skill/1_swing.png",
                    skillDescription = "Attacks the enemy with Ruyi Bang, and grants a barrier to the caster for 1 turn. Barrier strength increases proportional to the caster's Attack. When used on the caster's turn, attacks all enemies. The changed attack does not trigger a Dual Attack.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "The Immortal One",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/immortal_wukong/skill/2_the_immortal_one.png",
                    skillDescription = "Increases Critical Hit Resistance and Penetration Resistance by 35%. When attacked, if the caster suffers a non-critical hit, increases Attack and Speed by 20%. Can stack up to 3 times.",
                    skillCooldown = 0,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Heavenly Fighter's Strike",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/immortal_wukong/skill/3_heavenly_fighters_strike.png",
                    skillDescription = "Increases Attack of the caster for 2 turns, before attacking the enemy and stunning for 1 turn. When the caster's Attack is greater than the target's Attack, damage dealt increases proportional to the difference, up to a maximum of 70%. Unaffected by elemental disadvantage.",
                    skillCooldown = 4,
                    soulObtain = 2,
                )
            )
        ),Hero(
            id = 6,
            name = "Kane",
            heroLore = "Kane, an illegitimate child of the Drake family, was abandoned shortly after his birth. As a result, he grew up surrounded by violence, destruction, betrayal, and fierce competition from a young age. He had been oblivious to his true identity, as his thirst for blood and vampiric abilities manifested comparatively late in his life. It wasn't until a life-threatening encounter with the Vampire Slayers that he experienced an awakening and learned about his true nature.",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/kane/portrait/kane.png",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/kane/profile/kane.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/Fire-circle.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/warrior.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/leo.png",
            heroStats = Stats(attack=1359,defense=585,health=5542,speed=105),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Hammer Time",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/kane/skill/1_hammer_time.png",
                    skillDescription = "Attacks the enemy with a hammer, and increases Combat Readiness of the caster by 15%. When the caster is enraged, activates Rock Smash as an extra attack. Rock Smash can only be activated once per turn, during the caster’s turn.\n" +
                            "Rock Smash: Attacks all enemies by slamming the ground, and inflicts bleeding for 2 turns. Ignores Effect Resistance.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Force Awakening",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/kane/skill/2_force_awakening.png",
                    skillDescription = "Upon receiving lethal damage, grants immortality and vampirism for 1 turn and resets skill cooldown of Feast of Predation. Can be only activated once every 9 turns. After an ally attacks, if the target has a debuff, gains 10 Fighting Spirit and when Fighting Spirit is full, consumes all Fighting Spirit to make the caster enraged for 2 turns.",
                    skillCooldown = 9,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Feast of Predation",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/kane/skill/3_feast_of_predation.png",
                    skillDescription = "Attacks the enemy by unleashing their power, and grants increased Attack (Greater) to the caster for 2 turns. Damage dealt increases proportional to the number of debuffs inflicted on the target.",
                    skillCooldown = 4,
                    soulObtain = 3,
                )
            )
        ),
    )
}