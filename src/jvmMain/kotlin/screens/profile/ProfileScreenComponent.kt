package screens.profile

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class ProfileScreenComponent(
    private val componentContext: ComponentContext,
    private val profileId: String,
    private val onGoToHomeClicked: () -> Unit,
    private val onGoToSignupClicked: () -> Unit
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        ProfileScreen(
            onGotoHomeClick = onGoToHomeClicked,
            onGoToSignupClicked = onGoToSignupClicked,
            profileId = profileId
        )
    }
}
