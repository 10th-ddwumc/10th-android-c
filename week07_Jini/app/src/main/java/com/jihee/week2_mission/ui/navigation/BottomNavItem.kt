package com.jihee.week2_mission.ui.navigation

import com.jihee.week2_mission.R

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {

    object Home : BottomNavItem(
        "home",
        "홈",
        R.drawable.ic_housesimple
    )

    object Purchase : BottomNavItem(
        "purchase",
        "구매하기",
        R.drawable.ic_listmagnifyingglass
    )

    object Wishlist : BottomNavItem(
        "wishlist",
        "위시리스트",
        R.drawable.ic_heartstraight
    )

    object Cart : BottomNavItem(
        "cart",
        "장바구니",
        R.drawable.ic_bagsimple
    )

    object Profile : BottomNavItem(
        "profile",
        "프로필",
        R.drawable.ic_user
    )
}