import DependenciesManager.provideUsersUseCase
import users.data.FetchUsersUseCaseImp
import users.data.UsersNetworkSource
import users.data.UsersRepositoryImp
import users.domain.FetchUsersUseCase
import users.domain.UsersRepository
import users.presentation.UsersViewModel

object DependenciesManager {
    private val usersNetworkSource: UsersNetworkSource by lazy { UsersNetworkSource() }
    private val usersRepository: UsersRepository by lazy { UsersRepositoryImp(usersNetworkSource) }
    fun provideUsersUseCase(): FetchUsersUseCase  = FetchUsersUseCaseImp(usersRepository)
}

object StaticViewModels {
    private val usersViewModel : UsersViewModel by lazy { UsersViewModel(provideUsersUseCase()) }
    fun provideUsersViewModel() = usersViewModel
}