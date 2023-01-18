package screens.home

import BG_COLOR
import ChatDetailScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import home.LeftPanel

@Composable
fun HomeScreen(
    onGotoHomeClick: () -> Unit,
    onGotoSignupClick: () -> Unit,
) {

    Row(modifier = Modifier.fillMaxWidth().background(color = BG_COLOR)) {
        LeftPanel()
        ChatDetailScreen("Mark", Modifier.fillMaxWidth())
    }
}