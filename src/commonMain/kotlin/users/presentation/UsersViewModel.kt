package users.presentation

import Resource
import ViewModel
import users.domain.FetchUsersUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import toMutableStateFlow
import users.data.model.UsersResponse

class UsersViewModel(private val usersUseCase: FetchUsersUseCase) : ViewModel() {
    val usersResponse: Flow<Resource<UsersResponse>> = MutableStateFlow(Resource.default())

    fun fetchUsers() {
        viewModelScope.launch {
            usersResponse.toMutableStateFlow()?.apply {
                value = Resource.loading()
                value = usersUseCase()
            }
        }
    }
}