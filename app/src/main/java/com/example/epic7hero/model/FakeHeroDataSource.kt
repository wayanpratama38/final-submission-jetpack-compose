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
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/fire.png",
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
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/dark.png",
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
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/light.png",
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
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/ice.png",
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
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/earth.png",
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
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/fire.png",
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
        ),Hero(
            id = 7,
            name = "Last Rider Krau",
            heroLore = "Leader of the Mechanical Empire Taranor's Special Force Team 7 and Heir to the mobile weapon Ziegfried. He's uncontrollable and does everything his way, but his skill is undeniable. Central Division has granted him the code number 00 as a symbol of his right to act independently.",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/last_rider_krau/portrait/last_rider_krau.png",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/last_rider_krau/profile/last_rider_krau.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/light.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/knight.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/pisces.png",
            heroStats = Stats(attack=839,defense=752,health=6405,speed=100),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Punishment",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/last_rider_krau/skill/1_punishment.png",
                    skillDescription = "Attacks the enemy with a swordstorm, before increasing Speed of the caster for 1 turn. Damage dealt increases proportional to the caster's max Health.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Code Number 00",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/last_rider_krau/skill/2_code_number_00.png",
                    skillDescription = "After being attacked, decreases skill cooldowns by 1 turn. After suffering an attack that targets all allies, decreases skill cooldowns by an additional 1 turn, and grants a barrier to all allies for 2 turns. Barrier strength increases proportional to the caster's max Health. Barrier effect can only be activated once per turn.",
                    skillCooldown = 0,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Mobile Weapon Ziegfried",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/last_rider_krau/skill/3_mobile_weapon_ziegfried.png",
                    skillDescription = "Summons Ziegfried to attack all enemies, before granting immunity to all allies for 2 turns and decreasing skill cooldowns by 1 turn. Penetrates Defense, and cannot trigger a critical hit. Damage dealt increases proportional to the caster's max Health and Speed. Damage dealt increases every time this skill is used and can stack up to 3 times.",
                    skillCooldown = 9,
                    soulObtain = 3,
                )
            )
        ),Hero(
            id = 8,
            name = "Rimuru",
            heroLore = "Leader of the world of monsters, Jura Tempest Federation. Although its base form is a Slime, Rimuru possesses extreme strength and skills. It's not interested in invading or occupying other lands, and just wants everyone to get along.",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/rimuru/portrait/rimuru.png",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/rimuru/profile/rimuru.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/earth.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/5star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/warrior.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/libra.png",
            heroStats = Stats(attack=1119,defense=627,health=6266,speed=109),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Okay, Shall I Get Started?",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/rimuru/skill/1_okay_shall_i_get_started.png",
                    skillDescription = "Cuts the enemy to attack, granting a random buff to the caster for 1 turn.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Analyze and Assess",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/rimuru/skill/2_analyze_and_assess.png",
                    skillDescription = "After attacking with a non-basic skill, copies two buffs when the target is buffed, regardless of whether the attack hits and grants their effects to all allies. This effect is not applied to undispellable buffs. When an ally is attacked by a buffed enemy, activates Be Ready! against the attacker. Be Ready! can only be activated once every 3 turns.\n" +
                            "Be Ready!: Quickly approaches the enemy and attacks, increasing Combat Readiness of the caster by 30%.",
                    skillCooldown = 3,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Devour It, Black Flame!",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/rimuru/skill/3_devour_it_black_flame.png",
                    skillDescription = "Attacks the enemy with black flame, and a successful attack will inflict 5,000 additional fixed damage to the target. Fixed damage increases proportional to the number of buffs granted to all allies, up to a maximum of 10,000 fixed damage. When the target is buffed, decreases Defense of all enemies for 2 turns. Unaffected by elemental disadvantage.",
                    skillCooldown = 5,
                    soulObtain = 3,
                )
            )
        ),Hero(
            id = 9,
            name = "Wandering Prince Cidd",
            heroLore = "The fourteenth prince of a far, faraway kingdom. While traveling around the world and collecting interesting tales, Wandering Prince Cidd was taken hostage by pirates because he knew about the story related to the Jewel of the Sea. It's unclear whether the feeling of exhilaration in his heart stems from this precarious situation or the thrill of an exhilarating adventure.",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/wandering_prince_cidd/portrait/wandering_prince_cidd.png",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/wandering_prince_cidd/profile/wandering_prince_cidd.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/light.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/4star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/mage.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/pisces.png",
            heroStats = Stats(attack=1021,defense=610,health=5474,speed=117),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Spiral Cut",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/wandering_prince_cidd/skill/1_spiral_cut.png",
                    skillDescription = "Attacks the enemy with a machete, with a 65% chance to decrease Defense for 1 turn.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = "Natural Storyteller",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/wandering_prince_cidd/skill/2_natural_storyteller.png",
                    skillDescription = "After an ally uses an attack that targets all enemies, activates Continuous Strike against the enemy with the highest Combat Readiness. Can only be activated once every 3 turns.\n" +
                            "Continuous Strike: Attacks the enemy, decreasing Combat Readiness by 20%, and increases Combat Readiness of the ally with the highest Combat Readiness except for the caster by 20%.",
                    skillCooldown = 3,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Narrative Retcon",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/wandering_prince_cidd/skill/3_narrative_retcon.png",
                    skillDescription = "Plants a bomb on all enemies and decreases Speed for 2 turns. At the end of the turn detonates bombs inflicted on the target.",
                    skillCooldown = 5,
                    soulObtain = 3,
                )
            )
        ),Hero(
            id = 10,
            name = "Watcher Schuri",
            heroLore = "A member of the Sicar assassin organization, Watcher Schuri is an outstanding fighter, but ignorant of the ways of the world. Though his rigid way of speaking gives off an air of unapproachability, he is surprisingly straightforward and open to granting people's requests. However, he hides a secret he cannot share with others.",
            portraitImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/watcher_schuri/portrait/watcher_schuri.png",
            profileImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/watcher_schuri/profile/watcher_schuri.png",
            element = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ElementImages/light.png",
            rarity = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroeRarityImages/4star.png",
            classes = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/JobImages/ranger.png",
            zodiac = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/ZodiacImages/scorpio.png",
            heroStats = Stats(attack=970,defense=557,health=5935,speed=106),
            isFavorite = false,
            skills = listOf(
                Skill(
                    skillName = "Sniper",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/watcher_schuri/skill/1_sniper.png",
                    skillDescription = "Shoots the enemy with a rifle, with a 35% chance to target them for 2 turns.",
                    skillCooldown = 0,
                    soulObtain = 1,
                ),
                Skill(
                    skillName = " Quickfire",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/watcher_schuri/skill/2_quickfire.png",
                    skillDescription = "Shoots all enemies with a rifle, with a 75% chance to dispel one buff, and increases Speed of the caster for 2 turns. ",
                    skillCooldown = 4,
                    soulObtain = 0,
                ),
                Skill(
                    skillName = "Finishing Shot",
                    skillImage = "https://raw.githubusercontent.com/wayanpratama38/e7-heroes/main/asset/HeroImages/watcher_schuri/skill/3_finishing_shot.png",
                    skillDescription = "Shoots a magic bullet at the enemy penetrating their Defense.",
                    skillCooldown = 6,
                    soulObtain = 3,
                )
            )
        ),
    )
}