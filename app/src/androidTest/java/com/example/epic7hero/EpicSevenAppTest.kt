package com.example.epic7hero

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.epic7hero.model.FakeHeroDataSource
import com.example.epic7hero.ui.navigation.Screen
import com.example.epic7hero.ui.theme.Epic7HeroTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EpicSevenAppTest {
    // set rule awal
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    private lateinit var navController : TestNavHostController


    // Set sebelum testing
    @Before
    fun setUp(){
        composeTestRule.setContent {
            Epic7HeroTheme {
                navController = TestNavHostController(LocalContext.current)
                navController.navigatorProvider.addNavigator(ComposeNavigator())
                EpicSevenApp(navController = navController)
            }
        }
    }

    @Test
    // Test verifikasi bahwa ketika aplikasi dibuka langsung home scren
    fun navHoststartDestinationVerify(){
        navController.assertCurrentRouteName(Screen.Home.route)
    }

    @Test
    // Test ketika menekan item, apakah sudah sesuai dengan id nya di detail screen
    fun checkHomeScreenToDetailScreenCorrectness(){
        composeTestRule.onNodeWithTag("lazyColumn").performScrollToIndex(2)
        composeTestRule.onNodeWithText(FakeHeroDataSource.heroData[3].name).performClick()
        navController.assertCurrentRouteName(Screen.DetailHero.route)
        composeTestRule.onNodeWithText(FakeHeroDataSource.heroData[3].name).assertIsDisplayed()
    }

    @Test
    // Navigasi ke beberapa bottom bar screen
    fun navHostNavigateToEveryBottomBarScreen(){
        composeTestRule.onNodeWithStringId(R.string.home_bottom_name).performClick()
        navController.assertCurrentRouteName(Screen.Home.route)
        composeTestRule.onNodeWithStringId(R.string.favorite_bottom_name).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithStringId(R.string.profile_bottom_name).performClick()
        navController.assertCurrentRouteName(Screen.Profile.route)
    }

    @Test
    // Mencari nama yang benar, kemudian memastikan bahawa ada nama tersebut
    fun searchCorrectName(){
        val input = "cidd"
        composeTestRule.onNodeWithStringId(R.string.search_bar_placeholder).performTextInput(input)
        composeTestRule.onNodeWithText("cidd").assertIsDisplayed()
    }

    @Test
    // Mencari nama yang salah, kemudian memastikan bahwa tidak ada nama tersebut
    fun searchIncorrectName(){
        val input = "kjfsbgsjsng"
        composeTestRule.onNodeWithStringId(R.string.search_bar_placeholder).performTextInput(input)
        composeTestRule.onNodeWithTag("emptySearch").assertIsDisplayed()
    }


    @Test
    // Klik tombol favorite dan navigasi ke favorite screen
    fun clickFavoriteNavigateFavoriteScreen(){
        composeTestRule.onNodeWithTag("lazyColumn").performScrollToIndex(1)
        composeTestRule.onNodeWithText(FakeHeroDataSource.heroData[1].name).assertIsDisplayed()
        composeTestRule.onAllNodesWithTag("favoriteButton").onFirst().performClick()
        composeTestRule.onNodeWithStringId(R.string.favorite_bottom_name).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithText(FakeHeroDataSource.heroData[1].name).assertIsDisplayed()
    }

    @Test
    // Tambah hero ke favorite, kemudian ke favorite screen lalu hapus dan cek apakah kosong atau tidak
    fun clickFavoriteNavigateFavoriteScreenDeleteFavoriteStatus(){
        composeTestRule.onNodeWithTag("lazyColumn").performScrollToIndex(1)
        composeTestRule.onNodeWithText(FakeHeroDataSource.heroData[1].name).assertIsDisplayed()
        composeTestRule.onAllNodesWithTag("favoriteButton").onFirst().performClick()
        composeTestRule.onNodeWithStringId(R.string.favorite_bottom_name).performClick()
        navController.assertCurrentRouteName(Screen.Favorite.route)
        composeTestRule.onNodeWithText(FakeHeroDataSource.heroData[1].name).assertIsDisplayed()
        composeTestRule.onAllNodesWithTag("favoriteButton").onFirst().performClick()
        composeTestRule.onNodeWithTag("emptyFavorite").assertIsDisplayed()
    }

    @Test
    // Cek profile screen apakah ada foto, nama dan Email
    fun profileScreenCheck(){
        composeTestRule.onNodeWithStringId(R.string.profile_bottom_name).performClick()
        navController.assertCurrentRouteName(Screen.Profile.route)
        composeTestRule.onNodeWithTag("photoProfile").assertIsDisplayed()
        composeTestRule.onNodeWithTag("fullName").assertIsDisplayed()
        composeTestRule.onNodeWithTag("dicodingGmail").assertIsDisplayed()
    }
}