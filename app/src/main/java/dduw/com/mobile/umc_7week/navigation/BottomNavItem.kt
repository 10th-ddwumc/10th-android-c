package dduw.com.mobile.umc_7week.navigation

import dduw.com.mobile.umc_7week.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Home : BottomNavItem("home", "홈", R.drawable.nav_home)
    object Buy : BottomNavItem("buy", "구매하기", R.drawable.nav_buy)

    object WishList : BottomNavItem("wishlist", "위시리스트", R.drawable.nav_wish)

    object Bag : BottomNavItem("bag", "장바구니",R.drawable.nav_bag)

    object Profile : BottomNavItem("profile", "프로필",R.drawable.nav_profile)
}