package widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorView(error: String? = null, actionText: String? = null, onClick: () -> Unit) {
    Column {
        Text(error ?: "Something went wrong")
        Button(onClick = { onClick() }) {
            Text(actionText ?: "Try Again")
        }
    }
}
