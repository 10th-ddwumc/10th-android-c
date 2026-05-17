package dduw.com.mobile.umc_7week.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dduw.com.mobile.umc_7week.R

data class WishItem(
    val id: Int,
    val image: Int,
    val title: String,
    val category: String,
    val colors: String,
    val price: String
)

@Composable
fun WishListScreen(
    onNavigateWishList: () -> Unit
) {

    val wishList = listOf(
        WishItem(
            1,
            R.drawable.wish_item_1,
            "Air Jordan 1 Mid",
            "",
            "",
            "US$125",
        ),
        WishItem(
            2,
            R.drawable.wish_item_2,
            "Nike Everyday Plus Cushioned",
            "Training Ankle Socks (6 Pairs)",
            "5 Colours",
            "US\$10"
        )
    )

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = "위시리스트",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.height(1000.dp)
        ) {

            items(
                items = wishList,
                key = { item -> item.id }
            ) { item ->

                WishItemCard(item)
            }
        }
    }
}

@Composable
fun WishItemCard(item: WishItem) {

    Column(
        modifier = Modifier
            .padding(8.dp)
            .width(180.dp)
    ) {

        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = item.category,
            color = Color.Gray
        )

        Text(
            text = item.colors,
            color = Color.Gray
        )
        Text(
            text = item.price,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WishListPreview() {

    WishListScreen(
        onNavigateWishList = {}
    )
}