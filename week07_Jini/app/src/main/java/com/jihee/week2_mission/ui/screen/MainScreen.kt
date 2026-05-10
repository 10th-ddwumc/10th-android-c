package com.jihee.week2_mission.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jihee.week2_mission.ui.navigation.BottomNavBar
import com.jihee.week2_mission.ui.navigation.BottomNavItem

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Purchase,
        BottomNavItem.Wishlist,
        BottomNavItem.Cart,
        BottomNavItem.Profile
    )

    Scaffold(
        bottomBar = {
            BottomNavBar(
                items = items,
                navController = navController
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {

            composable("home") {
                HomeScreen()
            }

            composable("purchase") {
                PurchaseScreen()
            }

            composable("wishlist") {
                WishlistScreen()
            }

            composable("cart") {
                CartScreen(
                    onOrderClick = {
                        navController.navigate("purchase")
                    }
                )
            }

            composable("profile") {
                ProfileScreen()
            }
        }
    }
}