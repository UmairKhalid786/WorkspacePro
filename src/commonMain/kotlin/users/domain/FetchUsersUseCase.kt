package users.domain

import Resource
import users.data.model.UsersResponse

interface FetchUsersUseCase {
    suspend operator fun invoke(numberOfUsers: Int = 20): Resource<UsersResponse>
}