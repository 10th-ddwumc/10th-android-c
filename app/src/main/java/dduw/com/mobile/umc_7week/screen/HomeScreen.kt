package com.example.myapp.screen

import android.R.attr.top
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dduw.com.mobile.umc_7week.R

@Composable
fun HomeScreen(
    onNavigateProfile: () -> Unit
) {

    Column(
        modifier = Modifier.padding(30.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top=70.dp)
    ) {
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
            modifier = Modifier
                .size(378.dp)
                .padding(top = 20.dp)
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