package screens.chat

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class ChatScreenComponent(
    private val componentContext: ComponentContext,
    private val chatId: String,
    private val onGoToProfileClick: (id: String) -> Unit,
    private val onGoToBackClicked: () -> Unit
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        ChatScreen(
            onGotoProfileClick = onGoToProfileClick,
            onGotoBackClick = onGoToBackClicked,
            chatId
        )
    }
}
