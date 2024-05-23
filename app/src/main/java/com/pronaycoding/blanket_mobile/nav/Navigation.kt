package com.pronaycoding.blanket_mobile.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pronaycoding.blanket_mobile.ui.homeScreen.CardItems
import com.pronaycoding.blanket_mobile.ui.homeScreen.DrawerItems
import com.pronaycoding.blanket_mobile.ui.homeScreen.MainScreen

@Composable
fun Navigation(
    cardItems: List<CardItems>,
    drawerItems: List<DrawerItems>
) {
    val navController : NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Home.name ) {
        composable(Routes.Home.name){
            MainScreen(cardLists = cardItems
                , drawerItems = drawerItems )
        }

        composable(Routes.Settings.name){

        }
    }

}