package dduw.com.mobile.umc_7week.screen
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun WishListScreen(
    onNavigateWishList: () -> Unit
) {
    Text(
        text = "위시리스트",
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )
}
@Preview(showBackground = true)
@Composable
fun WishListPreview() {

    WishListScreen(
        onNavigateWishList = {}
    )
}