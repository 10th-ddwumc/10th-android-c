package com.yogurt.umc_nike_clone_compose.ui.screen.wishlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.yogurt.umc_nike_clone_compose.data.model.PurchaseItem
import com.yogurt.umc_nike_clone_compose.data.model.samplePurchaseItems
import com.yogurt.umc_nike_clone_compose.ui.theme.UMC_NIKE_clone_composeTheme

@Composable
fun WishListScreen(
    wishlistIds: List<Int> = emptyList()
) {
    val wishlistItems = samplePurchaseItems.filter { item -> item.id in wishlistIds }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "위시리스트",
            fontSize = 28.sp,
            modifier = Modifier.padding(start = 27.dp, top = 53.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 10.dp,
                end = 12.dp,
                bottom = 100.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(wishlistItems) { item ->
                WishGridItem(item = item)
            }
        }
    }
}

@Composable
private fun WishGridItem(item: PurchaseItem) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        Text(
            text = item.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 12.dp)
        )
        Text(
            text = item.explain,
            color = Color(0xFF767676),
            fontSize = 14.sp
        )
        Text(
            text = item.color,
            color = Color(0xFF767676),
            fontSize = 14.sp
        )
        Text(
            text = item.price,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WishListScreenPreview() {
    UMC_NIKE_clone_composeTheme {
        WishListScreen(wishlistIds = listOf(1, 3, 5))
    }
}
