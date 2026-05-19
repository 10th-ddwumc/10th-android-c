package com.jihee.week2_mission

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jihee.week2_mission.data.repository.ProductRepository

class ProductViewModelFactory(
    private val repository: ProductRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }
}