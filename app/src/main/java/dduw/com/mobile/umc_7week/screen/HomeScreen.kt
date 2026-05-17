package com.example.myapp.screen

import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dduw.com.mobile.umc_7week.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.lazy.items

data class ShoeItem(
    val id: Int,
    val image: Int,
    val name: String,
    val price: String
)
@Composable
fun HomeScreen(
    onNavigateProfile: () -> Unit
) {

    val shoeList = listOf(
        ShoeItem(1,R.drawable.shoe_image1,"Air Jordan XXXVI","US\$185"),
        ShoeItem(2,R.drawable.shoe_image2,"Nike Air Force 1 '07","US\$115")
    )

    LazyColumn(
        modifier = Modifier.padding(20.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top=70.dp)
    ) {
        item {
            Text(
                text = "Discover",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = "9월 4일 목요일",
                fontSize = 16.sp,
            )
            Image(
                painter = painterResource(id = R.drawable.home_img),
                contentDescription = "홈 사진",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            )
            Text(
                text = "What's new",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 40.dp)
            )
            Text(
                text = "나이키 최신 상품",
                fontSize = 28.sp,
                color = Color.DarkGray
            )
            LazyRow(
                modifier = Modifier.padding(top = 20.dp)
            ) {

                items(
                    items = shoeList,
                    key = { shoe -> shoe.id }
                ) { shoe ->

                    ShoeItem(shoe)
                }
            }
        }
    }
}

@Composable
fun ShoeItem(shoe: ShoeItem){

    Column(
        modifier = Modifier
            .width(250.dp)
            .padding(end = 16.dp)
    ){
        Image(
            painter = painterResource(id = shoe.image),
            contentDescription =  shoe.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = shoe.name,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = shoe.price,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }

}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {

    HomeScreen(
        onNavigateProfile = {}
    )
}