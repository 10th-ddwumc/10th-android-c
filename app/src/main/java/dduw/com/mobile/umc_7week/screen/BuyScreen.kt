package dduw.com.mobile.umc_7week.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dduw.com.mobile.umc_7week.R

data class BuyItem(
    val id:Int,
    val image: Int,
    val title:String,
    val category: String,
    val colorText:String,
    val price : String
)
@Composable
fun BuyScreen(
    onNavigateBuy: () -> Unit
) {
    val buyList = listOf(
        BuyItem(
            1,
            R.drawable.buy_item_1,
            "Nike Everyday Plus Cushioned",
            "Training Ankle Socks (6 Pairs)",
            "5 Colours",
            "US\$10"
        ),
        BuyItem(
            2,
           R.drawable.buy_item_2,
            "Nike Everyday Plus Cushioned",
            "Training Ankle Socks (6 Pairs)",
            "5 Colours",
            "US\$10"
        )
    )
    LazyColumn {

        item {

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "전체",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(end = 10.dp)
                )

                Text(
                    text = "Top&T-Shirts",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(end = 10.dp)
                )

                Text(
                    text = "Shoes",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(1000.dp)
            ) {

                items(
                    items = buyList,
                    key = { item -> item.id }
                ) { item ->
                    BuyItemCard(item)
                }
            }
        }
    }
}
@Composable
fun BuyItemCard(item: BuyItem) {

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
            fontWeight = FontWeight.Bold
        )

        Text(
            text = item.category,
            color = Color.Gray
        )

        Text(
            text = item.colorText,
            color = Color.Gray
        )

        Text(
            text = item.price,
            fontWeight = FontWeight.Bold
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BuyPreview() {

   BuyScreen(
       onNavigateBuy = {}
    )
}