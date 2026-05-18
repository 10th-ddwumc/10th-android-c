package com.yogurt.umc_nike_clone_compose.ui.screen.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
import com.yogurt.umc_nike_clone_compose.R

private val purchaseTabs = listOf("전체", "Tops & T-Shirts", "Shoes")

@Composable
fun SearchScreen(
    wishlistIds: List<Int> = emptyList(),
    onWishClick: (Int) -> Unit = {}
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = Color.Black
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 34.dp, top = 24.dp, end = 34.dp)
        ) {
            purchaseTabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = title,
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 20.dp,
                end = 12.dp,
                bottom = 100.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(samplePurchaseItems) { item ->
                PurchaseGridItem(
                    item = item,
                    isWished = item.id in wishlistIds,
                    onWishClick = onWishClick
                )
            }
        }
    }
}

@Composable
private fun PurchaseGridItem(
    item: PurchaseItem,
    isWished: Boolean,
    onWishClick: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
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

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 8.dp, end = 8.dp)
                    .size(32.dp)
                    .background(Color.White, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = { onWishClick(item.id) }) {
                    Icon(
                        painter = painterResource(
                            if (isWished) R.drawable.heart_filled
                            else R.drawable.heartstraight
                        ),
                        contentDescription = "위시리스트",
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        if (item.isBestSeller) {
            Text(
                text = "BestSeller",
                color = Color(0xFFFC5100),
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        Text(
            text = item.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
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
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    UMC_NIKE_clone_composeTheme {
        SearchScreen()
    }
}
