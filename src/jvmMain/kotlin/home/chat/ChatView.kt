package home.chat

import ACCENT_COLOR
import BG_COLOR
import DIM_TEXT_COLOR
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import widgets.CircularNetworkIcon
import java.net.URL
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun ChatView(modifier: Modifier = Modifier) {
    LazyColumn(reverseLayout = true, modifier = modifier.fillMaxWidth().fillMaxHeight().background(Color.White)) {
        items(60) {
            ChatItem(it % 2 == 0)
        }
    }
}

@Composable
fun ChatItem(myChat: Boolean) {
    if (myChat) MyChatItem(true) else TheirChatItem(true)
}

@Composable
fun MyChatItem(isFirstChat: Boolean) {
    ChatItemContainer(isFirstChat, Alignment.End) {
        ChatBubble("Hello your chat", Modifier, Alignment.End, BG_COLOR, DIM_TEXT_COLOR)
    }
}

@Composable
fun TheirChatItem(isFirstChat: Boolean) {
    ChatItemContainer(isFirstChat, Alignment.Start) {
        ChatBubble("Hello my chat", it, Alignment.Start, ACCENT_COLOR, textColor = DIM_TEXT_COLOR)
    }
}

@Composable
fun ChatItemContainer(
    isFirstChat: Boolean,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable (modifier: Modifier) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 8.dp),
        horizontalAlignment = horizontalAlignment
    ) {
        if (isFirstChat) {
            CircularNetworkIcon(
                URL("https://randomuser.me/api/portraits/med/men/1.jpg"),
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        content(Modifier)
    }
}

@Composable
fun ChatBubble(
    text: String,
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal,
    color: Color,
    textColor: Color
) {
    val date by remember { derivedStateOf { SimpleDateFormat("hh:mm dd-MM-yyyy").format(Date(System.currentTimeMillis())) } }
    Column(
        modifier = modifier.background(color = color, shape = RoundedCornerShape(12.dp)).padding(16.dp),
        horizontalAlignment = horizontalAlignment
    ) {
        Text(text, color = textColor)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(date, style = MaterialTheme.typography.caption, color = textColor.copy(alpha = 0.7F))
    }
}

