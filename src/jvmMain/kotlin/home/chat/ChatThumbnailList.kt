package home.chat

import StaticViewModels.provideUsersViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import users.presentation.UsersViewModel
import widgets.ErrorView
import widgets.IconTitleItemWidget
import widgets.Loading
import java.net.URL

@Composable
fun ChatThumbnailList(modifier: Modifier, expanded: Boolean, viewModel: UsersViewModel = provideUsersViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    val state by viewModel.usersResponse.collectAsState(Resource.default())

    when (state.status) {
        Resource.Status.SUCCESS -> {
            val result = state.data?.results
            val size = result?.size ?: 0
            LazyColumn(
                reverseLayout = true,
                modifier = modifier.fillMaxWidth()
            ) {
                repeat(size) {
                    item(key = {
                        it.toString()
                    }) {
                        val user = result?.get(it) ?: return@item

                        IconTitleItemWidget(
                            title = "${user.name?.first}",
                            description = user.email ?: "",
                            url = URL(user.picture?.thumbnail),
                            expanded = expanded
                        )
                    }
                }
            }
        }
        Resource.Status.LOADING -> {
            Loading(modifier.fillMaxWidth())
        }
        Resource.Status.ERROR -> {
            ErrorView {
                viewModel.fetchUsers()
            }
        }
        Resource.Status.DEFAULT -> {

        }
    }
}