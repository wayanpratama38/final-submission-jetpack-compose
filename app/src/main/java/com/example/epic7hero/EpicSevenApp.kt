package com.example.epic7hero

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.epic7hero.ui.navigation.BottomBarItem
import com.example.epic7hero.ui.navigation.Screen
import com.example.epic7hero.ui.screen.home.Home
import com.example.epic7hero.ui.theme.Epic7HeroTheme

@Composable
fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
){
    NavigationBar(
        modifier = modifier
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
                icon = Icons.Default.Star,
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
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(item.title)
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
        },
        topBar = {
            com.example.epic7hero.ui.components.SearchBar(
                "test",
                onQueryChange = { }
            )
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