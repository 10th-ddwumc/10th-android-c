package com.jihee.week2_mission.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jihee.week2_mission.ProductData
import com.jihee.week2_mission.R

val HomeProductList = listOf(
    ProductData(1, R.drawable.ic_jordan, "Air Jordan XXXVI", "185$"),
    ProductData(2,R.drawable.ic_force,"Nike Air Force 1'08","115$"),
)
@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp)
        ) {

            Text(
                text = "Discover",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "9월 4일 목요일",
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_homelogo),
            contentDescription = null,
            modifier = Modifier
                .size(width = 360.dp, height = 450.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        LazyRow (
            modifier = Modifier
                .fillMaxWidth()//가로 꽉 채우고
                .height(320.dp)
                .padding(horizontal = 16.dp)//양옆 여백 16.dp
        ) {
            items(
                items = HomeProductList,
                key = { it.id }
            ) { product ->
                ProductItem(product)
            }
        }
    }
}

@Composable
fun ProductItem(product: ProductData) {
    Column (
        modifier = Modifier.padding(16.dp),
        horizontalAlignment= Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = product.image),
            contentDescription = product.name,
            modifier = Modifier.size(width = 220.dp, height = 220.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = product.name)
            Text(text = product.price)
        }
    }
}