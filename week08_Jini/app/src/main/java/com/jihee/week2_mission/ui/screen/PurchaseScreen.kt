package com.jihee.week2_mission.ui.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jihee.week2_mission.ProductData
import com.jihee.week2_mission.R

val PurchaseProductList = listOf(
    ProductData(1, R.drawable.ic_product1, "Nike Elite Creq", "16$"),
    ProductData(2,R.drawable.ic_product2,"Nike Everyday Plus Cushioned","10$"),
    ProductData(3,R.drawable.ic_product3,"Nike Air Force woman","115$"),
    ProductData(4,R.drawable.ic_product4,"Jordan ENike Air Force","115$")
)
@Composable
fun PurchaseScreen() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(
            items = PurchaseProductList,
            key = { it.id }
        ) { product ->
            ProductItem(product)
        }
    }
}

