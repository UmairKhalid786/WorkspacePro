package home

import DIM_TEXT_COLOR
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import home.chat.ChatThumbnailList
import home.leftPanel.LeftMenuActionsItems
import home.leftPanel.LeftMenuQuickActions


@Composable
fun LeftPanel() {
    var expanded by remember { mutableStateOf(true) }
    Column(modifier = Modifier.width(if (expanded) 350.dp else 70.dp)) {
        LeftMenuHeader(expanded)
        LeftMenuSearch(expanded = expanded) {
            expanded = it
        }
        LeftMenuActionsItems(expanded)
        Spacer(modifier = Modifier.size(16.dp))
        LeftMenuQuickActions(expanded)
        Spacer(modifier = Modifier.size(16.dp))
        Text("RECENT CHATS", modifier = Modifier.padding(horizontal = 16.dp), style = TextStyle(fontWeight = FontWeight.Medium), color = DIM_TEXT_COLOR)
        ChatThumbnailList(modifier = Modifier.fillMaxWidth().weight(1.0f, true), expanded)
    }
}