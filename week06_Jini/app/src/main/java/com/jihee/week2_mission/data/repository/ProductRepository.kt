package com.jihee.week2_mission.data.repository

import android.content.Context
import com.jihee.week2_mission.ProductData
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProducts(context: Context): Flow<List<ProductData>>
    suspend fun saveProducts(context: Context, list: List<ProductData>)

    fun getWishlist(context: Context): Flow<List<ProductData>>
    suspend fun saveWishlist(context: Context, list: List<ProductData>)

    fun getHomeProducts(context: Context): Flow<List<ProductData>>
    suspend fun saveHomeProducts(context: Context, list: List<ProductData>)
}