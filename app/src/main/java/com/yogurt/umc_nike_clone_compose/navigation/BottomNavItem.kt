package com.yogurt.umc_nike_clone_compose.navigation

import com.yogurt.umc_nike_clone_compose.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
) {
    data object Home : BottomNavItem(
        route = "home",
        label = "홈",
        icon = R.drawable.housesimple
    )

    data object Search : BottomNavItem(
        route = "search",
        label = "구매하기",
        icon = R.drawable.listmagnifyingglass
    )

    data object WishList : BottomNavItem(
        route = "wishlist",
        label = "위시리스트",
        icon = R.drawable.heartstraight
    )

    data object Cart : BottomNavItem(
        route = "cart",
        label = "장바구니",
        icon = R.drawable.bagsimple
    )

    data object My : BottomNavItem(
        route = "my",
        label = "프로필",
        icon = R.drawable.user
    )
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Search,
    BottomNavItem.WishList,
    BottomNavItem.Cart,
    BottomNavItem.My
)
