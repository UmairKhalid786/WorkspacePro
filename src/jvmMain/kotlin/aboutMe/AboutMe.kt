package aboutMe

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberDialogState

@Composable
fun AboutMe(onClose: () -> Unit) {
    Dialog(
        resizable = false,
        title = "About WorkspacePro",
        onCloseRequest = { onClose() },
        state = rememberDialogState(position = WindowPosition(Alignment.Center))
    ) {
        // Dialog's content
        Surface(color = MaterialTheme.colors.primary) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Welcome to WorkspacePro️", style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text("WorkspacePro is a open source project built for you ♥️")
                    Spacer(modifier = Modifier.height(20.dp))
                    // Dynamic version will only be displayed if executed from
                    // Tasks -> compose desktop -> runDistribution
                    Text("v${System.getProperty("jpackage.app-version") ?: "1.0.0 debug"}")
                }
            }
        }
    }
}