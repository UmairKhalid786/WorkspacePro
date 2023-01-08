package home

import BG_COLOR
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.Keyboard

@Composable
fun LeftMenuSearch(modifier: Modifier = Modifier, expanded: Boolean, onChangeExpandable: (Boolean) -> Unit) {
    var text by remember { mutableStateOf("") }
    Row(
        modifier = modifier.padding(horizontal = 8.dp, vertical = 0.dp)
            .padding(8.dp)
            .fillMaxWidth()
            .background(color = Color.White, shape = if (expanded) RoundedCornerShape(2.dp) else CircleShape)
            .padding(horizontal = if (expanded) 12.dp else 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Rounded.Search, "Emoji", modifier = Modifier.size(20.dp).clickable {
            onChangeExpandable(true)
        }, tint = Color.Gray)
        if (expanded) {
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
            Divider(modifier = Modifier.width(1.dp).height(20.dp).background(color = BG_COLOR))
            Spacer(modifier = Modifier.size(8.dp))
            Icon(LineAwesomeIcons.Keyboard, "Emoji", modifier = Modifier.size(20.dp), tint = Color.Gray)
        }
    }
}