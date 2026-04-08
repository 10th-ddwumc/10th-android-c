package dduw.com.mobile.umc_2week_mission.data

data class WishData(
    val buyImage: Int,
    val buyItemName: String,
    val buyItemSub: String,
    val buyItemColor: String,
    val buyItemPrice: String,
    var isLiked: Boolean = true
)