package dduw.com.mobile.umc_7week.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dduw.com.mobile.umc_7week.data.response.User
import dduw.com.mobile.umc_7week.network.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val repository = UserRepository()

    var user = mutableStateOf<User?>(null)

    init {
        getUser()
    }

    private fun getUser() {

        viewModelScope.launch {

            val result = repository.getUser(1)

            result.onSuccess {

                user.value = it
            }

            result.onFailure {

                it.printStackTrace()
            }
        }
    }
}