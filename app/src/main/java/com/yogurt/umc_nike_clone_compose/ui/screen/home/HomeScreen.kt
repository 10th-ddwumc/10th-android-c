package com.yogurt.umc_nike_clone_compose.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yogurt.umc_nike_clone_compose.R
import com.yogurt.umc_nike_clone_compose.ui.theme.UMC_NIKE_clone_composeTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(34.dp),
    ) {
        Text(
            text = "Discover",
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 50.dp)
        )

        Text(
            text = "9월 4일 목요일",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 50.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.home_logo),
            contentDescription = "홈 로고",
            modifier = Modifier.width(378.dp).height(505.dp)
        )


    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    UMC_NIKE_clone_composeTheme() {
        HomeScreen()
    }
}