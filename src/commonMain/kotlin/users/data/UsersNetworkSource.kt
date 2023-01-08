package users.data

import users.data.model.UsersResponse
import network.NetworkClient

class UsersNetworkSource {
    suspend operator fun invoke(numberOfUsers: Int) = NetworkClient.safeGet<UsersResponse>("https://randomuser.me/api/?results=$numberOfUsers")
}