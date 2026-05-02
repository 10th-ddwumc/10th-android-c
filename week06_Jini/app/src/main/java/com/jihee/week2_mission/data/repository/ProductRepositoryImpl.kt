package com.jihee.week2_mission.data.repository

import android.content.Context
import com.jihee.week2_mission.ProductData
import com.jihee.week2_mission.ProductDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor() : ProductRepository {

    override fun getProducts(context: Context): Flow<List<ProductData>> {
        return ProductDataStore.getProducts(context)
    }

    override suspend fun saveProducts(context: Context, list: List<ProductData>) {
        ProductDataStore.saveProducts(context, list)
    }

    override fun getWishlist(context: Context): Flow<List<ProductData>> {
        return ProductDataStore.getWishlist(context)
    }

    override suspend fun saveWishlist(context: Context, list: List<ProductData>) {
        ProductDataStore.saveWishlist(context, list)
    }

    override fun getHomeProducts(context: Context): Flow<List<ProductData>> {
        return ProductDataStore.getHomeProducts(context)
    }

    override suspend fun saveHomeProducts(context: Context, list: List<ProductData>) {
        ProductDataStore.saveHomeProducts(context, list)
    }
}