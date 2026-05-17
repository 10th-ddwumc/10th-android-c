package com.yogurt.umc_nike_clone_compose.ui.screen.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yogurt.umc_nike_clone_compose.R
import com.yogurt.umc_nike_clone_compose.ui.theme.UMC_NIKE_clone_composeTheme

@Composable
fun CartScreen(
    onOrderClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.bagcircle),
                contentDescription = "카트 로고",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = "장바구니가 비어 있습니다.\n제품을 추가하면 여기에 표시됩니다.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        }

        Button(
            onClick = onOrderClick,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
                .width(331.dp)
                .height(51.dp)
        ) {
            Text(text = "주문하기")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    UMC_NIKE_clone_composeTheme {
        CartScreen()
    }
}
