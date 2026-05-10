package dduw.com.mobile.umc_7week.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.myapp.screen.HomeScreen
import dduw.com.mobile.umc_7week.navigation.AppDestination
import androidx.navigation.compose.composable
import dduw.com.mobile.umc_7week.BottomNavBar

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") { HomeScreen( onNavigateProfile = {}) }
            composable("buy") { BuyScreen( onNavigateBuy = {} ) }
            composable("wishlist") { WishListScreen(onNavigateWishList = {} ) }
            composable("bag") { ShoppingBagScreen( navController) }
            composable("profile") { ProfileScreen( onNavigateProfile = {} ) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}