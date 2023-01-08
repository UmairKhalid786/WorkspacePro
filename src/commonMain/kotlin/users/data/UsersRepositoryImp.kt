package users.data

import users.domain.UsersRepository

class UsersRepositoryImp(private val usersNetworkSource: UsersNetworkSource) : UsersRepository {
    override suspend fun getUsers(numberOfUsers: Int) = usersNetworkSource(numberOfUsers)
}
