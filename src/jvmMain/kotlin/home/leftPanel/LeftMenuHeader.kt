package home

import DIM_TEXT_COLOR
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import home.leftPanel.contextMenu.ContextMenuLeftMenu
import widgets.CircularNetworkIcon
import java.net.URL

@Composable
fun LeftMenuHeader(expanded: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularNetworkIcon(
            URL("https://randomuser.me/api/portraits/med/men/1.jpg"),
            modifier = Modifier
        )
        if (expanded) {
            Spacer(modifier = Modifier.size(8.dp))
            Text("Umair Khalid", style = TextStyle(fontWeight = FontWeight.Medium), color = DIM_TEXT_COLOR)
            Spacer(modifier = Modifier.size(8.dp))
            Text("$0.00", style = MaterialTheme.typography.caption, color = DIM_TEXT_COLOR.copy(alpha = 0.7F))
            Spacer(Modifier.weight(1.0f, true))
            ContextMenuLeftMenu()
        }
    }
}