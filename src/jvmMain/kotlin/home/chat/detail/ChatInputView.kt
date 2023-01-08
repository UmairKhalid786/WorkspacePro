package home.chat.detail

import BG_COLOR
import DIM_TEXT_COLOR
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.Smile

@Composable
fun ChatInputView(modifier: Modifier) {
    var text by remember { mutableStateOf("") }
    Row(
        modifier = modifier.padding(8.dp).fillMaxWidth()
            .background(color = BG_COLOR, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(LineAwesomeIcons.Smile, "Emoji", modifier = Modifier.size(24.dp), tint = DIM_TEXT_COLOR)
        Spacer(modifier = Modifier.size(8.dp))
        BasicTextField(
            modifier = modifier.fillMaxWidth().weight(1.0f, true),
            value = text,
            onValueChange = {
                text = it
            },
            textStyle = TextStyle(
                color = if (isSystemInDarkTheme()) Color(0xFF969EBD) else Color.Gray
            ),
            decorationBox = { innerTextField ->
                if (text.isEmpty()) {
                    Text(
                        text = "Type a message",
                        color = if (isSystemInDarkTheme()) Color(0xFF969EBD) else Color.Gray,
                        fontSize = 14.sp
                    )
                }
                innerTextField()
            }
        )
    }
}