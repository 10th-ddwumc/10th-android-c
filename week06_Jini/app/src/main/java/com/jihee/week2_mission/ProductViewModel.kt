package com.jihee.week2_mission

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jihee.week2_mission.data.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    fun getProducts(context: Context): Flow<List<ProductData>> {
        return repository.getProducts(context)
    }

    fun getHomeProducts(context: Context): Flow<List<ProductData>> {
        return repository.getHomeProducts(context)
    }

    fun getWishlist(context: Context): Flow<List<ProductData>> {
        return repository.getWishlist(context)
    }

    fun saveWishlist(context: Context, list: List<ProductData>) {
        viewModelScope.launch {
            repository.saveWishlist(context, list)
        }
    }

    fun saveProducts(context: Context, list: List<ProductData>) {
        viewModelScope.launch {
            repository.saveProducts(context, list)
        }
    }

    fun saveHomeProducts(context: Context, list: List<ProductData>) {
        viewModelScope.launch {
            repository.saveHomeProducts(context, list)
        }
    }
}