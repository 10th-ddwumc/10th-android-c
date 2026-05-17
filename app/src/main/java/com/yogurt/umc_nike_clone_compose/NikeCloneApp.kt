package com.yogurt.umc_nike_clone_compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.yogurt.umc_nike_clone_compose.navigation.MainNavHost
import com.yogurt.umc_nike_clone_compose.ui.component.NikeBottomBar

@Composable
fun NikeCloneApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NikeBottomBar(navController = navController)
        }
    ) { innerPadding ->
        MainNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
