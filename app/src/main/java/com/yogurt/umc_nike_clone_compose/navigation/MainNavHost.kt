package com.yogurt.umc_nike_clone_compose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yogurt.umc_nike_clone_compose.ui.screen.cart.CartScreen
import com.yogurt.umc_nike_clone_compose.ui.screen.home.HomeScreen
import com.yogurt.umc_nike_clone_compose.ui.screen.my.MyScreen
import com.yogurt.umc_nike_clone_compose.ui.screen.search.SearchScreen
import com.yogurt.umc_nike_clone_compose.ui.screen.wishlist.WishListScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    wishlistIds: List<Int>,
    onWishClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Search.route) {
            SearchScreen(
                wishlistIds = wishlistIds,
                onWishClick = onWishClick
            )
        }
        composable(BottomNavItem.WishList.route) {
            WishListScreen(wishlistIds = wishlistIds)
        }
        composable(BottomNavItem.Cart.route) {
            CartScreen(
                onOrderClick = {
                    navController.navigate(BottomNavItem.Search.route) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(BottomNavItem.My.route) {
            MyScreen()
        }
    }
}
