package screens.chat

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChatScreen(
    onGotoProfileClick: (id: String) -> Unit,
    onGotoBackClick: () -> Unit,
    chatId: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Greeting
        Text(
            text = "Chat$chatId",
            fontSize = 40.sp
        )

        // Spacing between text and button
        Spacer(modifier = Modifier.height(30.dp))

        // Go back button
        Button(onClick = { onGotoProfileClick("profile_a") }) {
            Text(text = "Signin!")
        }
        // Go back button
        Button(onClick = onGotoBackClick) {
            Text(text = "Go Back")
        }
    }
}