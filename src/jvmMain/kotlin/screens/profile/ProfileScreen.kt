package screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    profileId: String,
    onGotoHomeClick: () -> Unit,
    onGoToSignupClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Greeting
        Text(
            text = "Profile $profileId",
            fontSize = 40.sp
        )

        // Spacing between text and button
        Spacer(modifier = Modifier.height(30.dp))

        // Go back button
        Button(onClick = onGotoHomeClick) {
            Text(text = "Signup!")
        }
        // Go back button
        Button(onClick = onGoToSignupClicked) {
            Text(text = "Signin")
        }
    }
}