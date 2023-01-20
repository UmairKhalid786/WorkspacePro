package screens.signup

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class SignupScreenComponent(
    private val componentContext: ComponentContext,
    private val onGoToHomeClicked: () -> Unit,
    private val onGoToSignupClicked: () -> Unit
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        SignupScreen(
            onGotoHomeClick = onGoToHomeClicked,
            onGotoSigninClick = onGoToSignupClicked
        )
    }
}
