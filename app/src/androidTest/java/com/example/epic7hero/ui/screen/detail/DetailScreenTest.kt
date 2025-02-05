package com.example.epic7hero.ui.screen.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeUp
import com.example.epic7hero.R
import com.example.epic7hero.model.Hero
import com.example.epic7hero.model.Skill
import com.example.epic7hero.model.Stats
import com.example.epic7hero.onNodeWithStringId
import com.example.epic7hero.ui.theme.Epic7HeroTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailScreenTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val fakeHeroData = Hero(
        id = 1,
        name = "FakeHeroName",
        heroLore = "FakeHeroLore",
        profileImage = "FakeHeroProfileImageURL",
        portraitImage = "FakeHeroPortraitImageURL",
        element = "FakeElementURL",
        rarity = "FakeRarityURL",
        classes = "FakeClassesURL",
        zodiac = "FakeZodiacURL",
        heroStats = Stats(attack=830,defense=713,health=6619,speed=106),
        isFavorite = false,
        skills = listOf(
            Skill(
                skillName = "FakeSkillName",
                skillImage = "FakeSkillImageURL",
                skillDescription = "FakeSkillDescription",
                skillCooldown = 0,
                soulObtain = 1,
            )
        )
    )

    @Before
    fun setUp(){
        composeTestRule.setContent {
            Epic7HeroTheme {
                DetailContent(
                portraitImage= fakeHeroData.portraitImage,
                stats = fakeHeroData.heroStats,
                name=fakeHeroData.name,
                element = fakeHeroData.element,
                rarity = fakeHeroData.rarity,
                classes = fakeHeroData.classes,
                zodiac = fakeHeroData.zodiac,
                skills = fakeHeroData.skills,
                heroLore = fakeHeroData.heroLore,
                navigateBack = {}
                )
            }
        }
    }

    @Test
    // Cek apakah data informasi identitas hero tersedia
    fun checkAllHeroInformation(){
        composeTestRule.onNodeWithText("FakeHeroName").assertExists()
        composeTestRule.onNodeWithContentDescription("Classes").assertExists()
        composeTestRule.onNodeWithContentDescription("Zodiac").assertExists()
        composeTestRule.onNodeWithContentDescription("Element").assertExists()
        composeTestRule.onNodeWithContentDescription("Rarity").assertExists()
    }


    @Test
    // Cek apakah data status hero tersedia
    fun checkAllHeroStatus(){
        composeTestRule.onNodeWithStringId(R.string.attack).assertExists()
        composeTestRule.onNodeWithText("830").assertExists()

        composeTestRule.onNodeWithStringId(R.string.defense).assertExists()
        composeTestRule.onNodeWithText("713").assertExists()

        composeTestRule.onNodeWithStringId(R.string.health).assertExists()
        composeTestRule.onNodeWithText("6619").assertExists()

        composeTestRule.onNodeWithStringId(R.string.speed).assertExists()
        composeTestRule.onNodeWithText("106").assertExists()
    }

    @Test
    // Cek expandable card bisa di buka dan apakah hero lore tersedia
    fun checkHeroLore(){
        composeTestRule.onNodeWithStringId(R.string.hero_lore).performClick()
        composeTestRule.onNodeWithText("FakeHeroLore").assertExists()
    }

    @Test
    // Cek expandable card bisa di buka dan apakah hero skill tersedia
    fun checkHeroSkill(){
        composeTestRule.onNodeWithStringId(R.string.skills).performClick()
        composeTestRule.onNodeWithText("FakeSkillName").assertExists()
        composeTestRule.onNodeWithText("FakeSkillDescription").assertExists()
        composeTestRule.onNodeWithContentDescription("FakeSkillName").assertExists()
    }

    @Test
    // Cek back button, kemudian scroll ke bawah, lalu tes tombol scroll to top dan cek kembali back button
    fun checkBackButtonScrollDownAndScrollToTopButton(){
        composeTestRule.onNodeWithTag("backButton").assertExists()
        composeTestRule.onNodeWithStringId(R.string.hero_lore).performClick()
        composeTestRule.onNodeWithStringId(R.string.skills).performClick()
        composeTestRule.onNodeWithTag("screenScroll").performTouchInput {
            swipeUp()
        }
        composeTestRule.onNodeWithTag("scrollToTopButton").assertExists()
        composeTestRule.onNodeWithTag("scrollToTopButton").performClick()
        composeTestRule.onNodeWithTag("backButton").assertExists()
    }
}