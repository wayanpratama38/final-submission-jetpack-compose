package com.example.epic7hero

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.epic7hero.ui.navigation.BottomBarItem
import com.example.epic7hero.ui.navigation.Screen
import com.example.epic7hero.ui.screen.detail.Detail
import com.example.epic7hero.ui.screen.favorite.Favorite
import com.example.epic7hero.ui.screen.home.Home
import com.example.epic7hero.ui.screen.profile.Profile
import com.example.epic7hero.ui.theme.Epic7HeroTheme

@Composable
fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
){
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceContainer
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val bottomBarItem = listOf(
            BottomBarItem(
                title = stringResource(R.string.home_bottom_name),
                icon = Icons.Default.Home,
                screen = Screen.Home,
            ),
            BottomBarItem(
                title = stringResource(R.string.favorite_bottom_name),
                icon = Icons.Outlined.Favorite,
                screen = Screen.Favorite,
            ),
            BottomBarItem(
                title = stringResource(R.string.profile_bottom_name),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile,
            )
        )
        bottomBarItem.map{ item->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelMedium
                    )
                },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route){
                        popUpTo(navController.graph.findStartDestination().id){
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}


@Composable
fun EpicSevenApp(
    modifier : Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if(currentRoute!=Screen.DetailHero.route){
                BottomBar(navController)
            }
        }
    ) { innerPadding->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route){
                Home(navigateToDetail ={ id->
                    navController.navigate(Screen.DetailHero.createRoute(id))
                })
            }
            composable(Screen.Favorite.route){
                Favorite(navigateToDetail = {id->
                    navController.navigate(Screen.DetailHero.createRoute(id))
                })
            }

            composable(Screen.Profile.route){
                Profile()
            }

            composable(
                route = Screen.DetailHero.route,
                arguments = listOf(navArgument("id"){type = NavType.LongType}))
            {
                val id = it.arguments?.getLong("id")?:-1L
                Detail(
                    heroId = id,
                    navigateBack = { navController.navigateUp() }
                )

            }
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