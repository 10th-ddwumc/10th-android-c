package dduw.com.mobile.umc_7week.navigation

import kotlinx.serialization.Serializable

sealed interface AppDestination {
    @Serializable
    data object Home: AppDestination

    @Serializable
    data object Buy: AppDestination

    @Serializable
    data object  WishList: AppDestination

    @Serializable
    data object ShoppingBag : AppDestination

    @Serializable
    data object Profile: AppDestination
}