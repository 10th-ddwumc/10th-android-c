    package dduw.com.mobile.umc_2week_mission

    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import dduw.com.mobile.umc_2week_mission.data.User
    import kotlinx.coroutines.flow.MutableStateFlow
    import kotlinx.coroutines.flow.StateFlow
    import kotlinx.coroutines.launch

    class UserViewModel : ViewModel() {

        private val repository = UserRepository()

        private val _user = MutableStateFlow<User?>(null)
        val user: StateFlow<User?> = _user

        private val _userList = MutableStateFlow<List<User>>(emptyList())
        val userList: StateFlow<List<User>> = _userList

        fun fetchUsers() {
            viewModelScope.launch {
                _userList.value = repository.getUsers()
            }
        }
        fun fetchUser() {
            viewModelScope.launch {
                val result = repository.getUser()
                _user.value = result?.data
            }
        }
    }