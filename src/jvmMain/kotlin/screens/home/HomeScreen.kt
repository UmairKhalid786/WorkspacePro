package screens.home

import ChatDetailScreen
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import home.leftPanel.LeftPanel

@Composable
fun HomeScreen(
    onGotoHomeClick: () -> Unit,
    onGotoSignupClick: () -> Unit,
) {
    Surface(color = MaterialTheme.colors.primary) {
        Row(modifier = Modifier.fillMaxWidth()) {
            LeftPanel()
            ChatDetailScreen("Mark", Modifier.fillMaxWidth())
        }
    }
}