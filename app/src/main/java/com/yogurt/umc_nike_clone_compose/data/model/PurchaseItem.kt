package com.yogurt.umc_nike_clone_compose.data.model

import com.yogurt.umc_nike_clone_compose.R

data class PurchaseItem(
    val id: Int,
    val image: Int,
    val name: String,
    val explain: String,
    val color: String,
    val price: String,
    val isBestSeller: Boolean = true
)

val samplePurchaseItems = listOf(
    PurchaseItem(
        id = 1,
        image = R.drawable.item1,
        name = "Air Jordan XXXVI",
        explain = "Men's Basketball Shoes",
        color = "1 Color",
        price = "US$185"
    ),
    PurchaseItem(
        id = 2,
        image = R.drawable.item2,
        name = "Nike Sportswear",
        explain = "Men's T-Shirt",
        color = "3 Colors",
        price = "US$45"
    ),
    PurchaseItem(
        id = 3,
        image = R.drawable.item3,
        name = "Air Jordan 2",
        explain = "Women's Shoes",
        color = "2 Colors",
        price = "US$186"
    ),
    PurchaseItem(
        id = 4,
        image = R.drawable.item4,
        name = "Air Jordan 3",
        explain = "Big Kids' Shoes",
        color = "1 Color",
        price = "US$187"
    ),
    PurchaseItem(
        id = 5,
        image = R.drawable.item5,
        name = "Nike Club",
        explain = "Men's Fleece Pullover",
        color = "4 Colors",
        price = "US$70"
    )
)
