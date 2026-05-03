package com.yogurt.umc_work02.data.model

data class ItemData (
    val id: Int,
    val image: Int,
    val name: String,
    val explain: String,
    val price: String,
    val colorCount: Int,
    val isBestSeller: Boolean,
    var isWish: Boolean
)