package screens.signin

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SigninScreen(
    onGotoHomeClick: () -> Unit,
    onGotoSignupClick: () -> Unit,
) {
    var scale = animateFloatAsState(0.5f)

    LaunchedEffect(Unit){

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource("icons/web/icon.png"),
            contentDescription = "Logo",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.size(50.dp))
        Text("Welcome to WorkspacePro", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.size(25.dp))
        TextField("", onValueChange = {

        })

        Spacer(modifier = Modifier.size(50.dp))

        // Go back button
        Button(onClick = onGotoHomeClick) {
            Text(text = "Home")
        }
        // Go back button
        TextButton(onClick = onGotoSignupClick) {
            Text(text = "Signup if you haven't created account yet !!")
        }
    }
}