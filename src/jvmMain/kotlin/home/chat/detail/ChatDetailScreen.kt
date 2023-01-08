import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import home.chat.ChatView
import home.chat.detail.MessageTypeView
import home.chat.detail.DetailScreenHeader

@Composable
fun ChatDetailScreen(name: String, modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth().background(color = Color.White)) {
        DetailScreenHeader(name, modifier)
        Divider(modifier.background(DIM_TEXT_COLOR.copy(alpha = 0.1f)).height(1.dp))
        ChatView(modifier.weight(1.0f, true))
        Divider(modifier.background(DIM_TEXT_COLOR.copy(alpha = 0f)).height(1.dp))
        MessageTypeView()
    }
}