package com.yogurt.umc_nike_clone_compose.ui.screen.wishlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yogurt.umc_nike_clone_compose.ui.theme.UMC_NIKE_clone_composeTheme

@Composable
fun WishListScreen() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = "위시리스트",
            fontSize = 28.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WishListScreenPreview() {
    UMC_NIKE_clone_composeTheme {
        WishListScreen()
    }
}
