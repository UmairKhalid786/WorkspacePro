package screens.signin

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class SigninScreenComponent(
    private val componentContext: ComponentContext,
    private val onGoToHomeClicked: () -> Unit,
    private val onGoToSignupClicked: () -> Unit
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        SigninScreen(
            onGotoHomeClick = onGoToHomeClicked,
            onGotoSignupClick = onGoToSignupClicked
        )
    }
}
