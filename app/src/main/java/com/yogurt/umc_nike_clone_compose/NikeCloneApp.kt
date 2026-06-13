package com.yogurt.umc_nike_clone_compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.yogurt.umc_nike_clone_compose.navigation.MainNavHost
import com.yogurt.umc_nike_clone_compose.ui.component.NikeBottomBar

@Composable
fun NikeCloneApp() {
    val navController = rememberNavController()
    val wishlistIds = remember { mutableStateListOf<Int>() }

    Scaffold(
        bottomBar = {
            NikeBottomBar(navController = navController)
        }
    ) { innerPadding ->
        MainNavHost(
            navController = navController,
            wishlistIds = wishlistIds,
            onWishClick = { itemId ->
                if (itemId in wishlistIds) {
                    wishlistIds.remove(itemId)
                } else {
                    wishlistIds.add(itemId)
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
