package users.domain

import Resource
import users.data.model.UsersResponse

interface UsersRepository {
    suspend fun getUsers(numberOfUsers: Int = 20): Resource<UsersResponse>
}