package navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import screens.chat.ChatScreenComponent
import screens.home.HomeScreenComponent
import screens.profile.ProfileScreenComponent
import screens.signin.SigninScreenComponent
import screens.sinup.SignupScreenComponent
import screens.welcome.WelcomeScreenComponent

/**
 * Navigator
 */
class NavHostComponent(
    componentContext: ComponentContext
) : Component, ComponentContext by componentContext {
    private val navigation = StackNavigation<ScreenConfig>()
    private val stack = childStack(
        source = navigation,
        initialConfiguration = ScreenConfig.Welcome,
        childFactory = ::createScreenComponent
    )

    /**
     * Factory function to create screen from given ScreenConfig
     */
    private fun createScreenComponent(
        screenConfig: ScreenConfig,
        componentContext: ComponentContext
    ): Component {
        return when (screenConfig) {

            is ScreenConfig.Signin -> SigninScreenComponent(
                componentContext,
                ::gotToHome,
                ::gotToSignupClick
            )

            is ScreenConfig.Signup -> SignupScreenComponent(
                componentContext,
                ::gotToHome,
                ::gotToSignupClick
            )

            is ScreenConfig.Welcome -> WelcomeScreenComponent(
                componentContext,
                ::gotToHome,
                ::gotToSignupClick
            )

            is ScreenConfig.Chat -> ChatScreenComponent(
                componentContext,
                screenConfig.id,
                ::gotToProfile,
                ::onGoBackClicked
            )

            is ScreenConfig.Home -> HomeScreenComponent(
                componentContext,
                ::gotToHome,
                ::gotToSignupClick
            )

            is ScreenConfig.Profile -> ProfileScreenComponent(
                componentContext,
                screenConfig.id,
                ::gotToHome,
                ::gotToSignupClick
            )
        }
    }


    /**
     * Invoked when `GO` button clicked (InputScreen)
     */
    private fun gotToHome() {
        navigation.push(ScreenConfig.Home)
    }

    /**
     * Invoked when `GO` button clicked (InputScreen)
     */
    private fun gotToSignupClick() {
        navigation.push(ScreenConfig.Signup)
    }

    /**
     * Invoked when `GO` button clicked (InputScreen)
     */
    private fun gotToHome(name: String) {
        navigation.push(ScreenConfig.Chat(name))
    }

    /**
     * Invoked when `GO` button clicked (InputScreen)
     */
    private fun gotToProfile(id: String) {
        navigation.push(ScreenConfig.Profile(id))
    }

    /**
     * Invoked when `GO BACK` button clicked (GreetingScreen)
     */
    private fun onGoBackClicked() {
        navigation.pop()
    }

    /**
     * Renders screen as per request
     */
    @OptIn(ExperimentalDecomposeApi::class)
    @Composable
    override fun render() {
        Children(
            stack = stack,
            animation = stackAnimation(fade() + scale()),
        ) {
            it.instance.render()
        }
    }

    private sealed class ScreenConfig : Parcelable {
        object Signin : ScreenConfig()
        object Signup : ScreenConfig()
        object Home : ScreenConfig()
        object Welcome : ScreenConfig()
        data class Profile(val id: String) : ScreenConfig()
        data class Chat(val id: String) : ScreenConfig()
    }
}