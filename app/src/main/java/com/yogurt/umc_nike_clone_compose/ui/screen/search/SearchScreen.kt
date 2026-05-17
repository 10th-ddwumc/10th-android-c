package com.yogurt.umc_nike_clone_compose.ui.screen.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.yogurt.umc_nike_clone_compose.ui.theme.UMC_NIKE_clone_composeTheme

@Composable
fun SearchScreen() {
    Column (
        modifier = Modifier.fillMaxSize(),
    )
    {

    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    UMC_NIKE_clone_composeTheme {
        SearchScreen()
    }
}
