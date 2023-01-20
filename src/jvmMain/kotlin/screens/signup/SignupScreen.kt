package screens.signup

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun SignupScreen(
    onGotoHomeClick: () -> Unit,
    onGotoSigninClick: () -> Unit,
) {
    var loaded by remember { mutableStateOf(false) }
    val animatedSize by animateDpAsState(
        targetValue = if (loaded) 150.dp else 200.dp, animationSpec = tween(
            durationMillis = 500,
            easing = LinearEasing
        )
    )

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var passwordVisibility: Boolean by remember { mutableStateOf(false) }


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
        Text("Signup to WorkspacePro", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.size(25.dp))

        TextField(email, onValueChange = {
            email = it
        }, placeholder = {
            Text("demo@gmail.com", color = MaterialTheme.colors.onSecondary.copy(0.3F))
        })

        Spacer(modifier = Modifier.size(12.dp))

        val image = if (passwordVisibility)
            Icons.Filled.Visibility
        else
            Icons.Filled.VisibilityOff

        TextField(value = password,
            placeholder = {
                Text("Password", color = MaterialTheme.colors.onSecondary.copy(0.3F))
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(image, "Password eye")
                }
            },
            onValueChange = {
                password = it
            })

        Spacer(modifier = Modifier.size(30.dp))

        // Go back button
        Button(onClick = onGotoHomeClick, enabled = email.isNotBlank() && password.isNotEmpty()) {
            Text(text = "Signup")
        }
        // Go back button
        TextButton(onClick = onGotoSigninClick) {
            Text(text = "SignIn if you already have account")
        }
    }
}