package screens.welcome

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class WelcomeScreenComponent(
    private val componentContext: ComponentContext,
    private val onGoToHomeClicked: () -> Unit,
    private val onGoToSignupClicked: () -> Unit
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        WelcomeScreen(
            onGotoHomeClick = onGoToHomeClicked,
            onGotoSignupClick = onGoToSignupClicked
        )
    }
}
