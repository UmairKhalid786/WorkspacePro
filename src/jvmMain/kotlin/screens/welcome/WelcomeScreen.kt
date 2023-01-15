package screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

const val SPLASH_FAKE_DELAY = 2000L

@Composable
fun WelcomeScreen(
    onGotoHomeClick: () -> Unit,
    onGotoSignupClick: () -> Unit,
) {

    LaunchedEffect(Unit){
        delay(SPLASH_FAKE_DELAY)
        onGotoHomeClick()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource("icons/web/icon.png"),
            contentDescription = "Logo",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.size(50.dp))
        Text("Welcome to WorkspacePro", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.size(25.dp))
        Text("A skype clone")
        Spacer(modifier = Modifier.size(50.dp))
        CircularProgressIndicator()
    }
}