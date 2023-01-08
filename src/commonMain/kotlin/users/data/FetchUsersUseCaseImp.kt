package users.data

import users.domain.FetchUsersUseCase
import users.domain.UsersRepository

class FetchUsersUseCaseImp(private val usersRepository: UsersRepository): FetchUsersUseCase {
    override suspend fun invoke(numberOfUsers: Int) = usersRepository.getUsers(numberOfUsers)
}