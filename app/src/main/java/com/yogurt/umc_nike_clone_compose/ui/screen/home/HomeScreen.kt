package com.yogurt.umc_nike_clone_compose.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import com.yogurt.umc_nike_clone_compose.R
import com.yogurt.umc_nike_clone_compose.ui.theme.UMC_NIKE_clone_composeTheme

private data class HomeProduct(
    val image: Int,
    val title: String,
    val description: String
)

private val sampleProducts = listOf(
    HomeProduct(R.drawable.item1,"Air Jordan XXXVI", "US\$185"),
    HomeProduct(R.drawable.item3,"Air Jordan 2", "US\$186"),
    HomeProduct(R.drawable.item4,"Air Jordan 3", "US\$187")
)

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 34.dp,
            top = 50.dp,
            end = 34.dp,
            bottom = 100.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Discover",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Text(
                text = "3월 22일",
                fontSize = 16.sp
            )
        }

        item {
            Image(
                painter = painterResource(id = R.drawable.home_logo),
                contentDescription = "홈 로고",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(464.dp)
            )
        }

        item {
            Column(
                modifier = Modifier.padding(top = 14.dp)
            ) {
                Text(
                    text = "What's New",
                    fontSize = 16.sp
                )
                Text(
                    text = "나이키 최신 상품",
                    color = Color(0xFF767676),
                    fontSize = 28.sp
                )
            }
        }

        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(sampleProducts) { product ->
                    HomeProductItem(product = product)
                }
            }
        }
    }
}

@Composable
private fun HomeProductItem(product: HomeProduct) {
    Column(
        modifier = Modifier
            .width(314.dp)
            .padding(vertical = 12.dp)
    ) {
        Image(
            painter = painterResource(id = product.image),
            contentDescription = product.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(314.dp)
        )
        Text(
            text = product.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = product.description,
            color = Color(0xFF767676),
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    UMC_NIKE_clone_composeTheme {
        HomeScreen()
    }
}
