package screens.home

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class HomeScreenComponent(
    private val componentContext: ComponentContext,
    private val onGoToHomeClicked: () -> Unit,
    private val onGoToSignupClicked: () -> Unit
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        HomeScreen(
            onGotoHomeClick = onGoToHomeClicked,
            onGotoSignupClick = onGoToSignupClicked
        )
    }
}
