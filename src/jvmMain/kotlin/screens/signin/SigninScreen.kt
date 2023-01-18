package screens.signin

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SigninScreen(
    onGotoHomeClick: () -> Unit,
    onGotoSignupClick: () -> Unit,
) {

    var loaded by remember { mutableStateOf(false) }
    val animatedSize by animateDpAsState(
        targetValue = if (loaded) 150.dp else 200.dp , animationSpec = tween(
            durationMillis = 500,
            easing = LinearEasing
        )
    )

    var email by remember { mutableStateOf("") }


    LaunchedEffect(Unit) {
        loaded = true
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource("icons/web/icon.png"),
            contentDescription = "Logo",
            modifier = Modifier.width(animatedSize.value.dp)
        )
        Spacer(modifier = Modifier.size(50.dp))
        Text("Signin to WorkspacePro", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.size(25.dp))

        TextField(email, onValueChange = {
            email = it
        }, placeholder = {
            Text("demo@gmail.com", color = MaterialTheme.colors.onSecondary.copy(0.3F))
        })

        Spacer(modifier = Modifier.size(50.dp))

        // Go back button
        Button(onClick = onGotoHomeClick, enabled = email.isNotBlank()) {
            Text(text = "Login")
        }
        // Go back button
        TextButton(onClick = onGotoSignupClick) {
            Text(text = "Signup if you haven't created account yet !!")
        }
    }
}