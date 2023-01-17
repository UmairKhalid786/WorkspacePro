package screens.signin

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SigninScreen(
    onGotoHomeClick: () -> Unit,
    onGotoSignupClick: () -> Unit,
) {

    var email by remember { mutableStateOf("") }

    var loaded by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if (loaded)  0.8f else 1f)

    LaunchedEffect(Unit){
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
            modifier = Modifier.size(200.dp).scale(scale.value)
        )
        Spacer(modifier = Modifier.size(50.dp))
        Text("Welcome to WorkspacePro", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.size(25.dp))

        TextField(email, onValueChange = {
            email = it
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