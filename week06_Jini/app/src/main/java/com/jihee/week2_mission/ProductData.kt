package com.jihee.week2_mission

data class ProductData(
    val image: Int,
    val name: String,
    val kind: String,
    val explain: String,
    val price: String,
    var heart: Boolean = false,
    val isBestSeller: Boolean = false
)
