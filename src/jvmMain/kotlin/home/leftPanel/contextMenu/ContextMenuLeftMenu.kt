package home.leftPanel.contextMenu

import DIM_TEXT_COLOR
import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent

@Composable
fun ContextMenuLeftMenu() {
    ContextMenuArea(items = {
        listOf(
            ContextMenuItem("User-defined Action") {/*do something here*/ },
            ContextMenuItem("Another user-defined action") {/*do something else*/ }
        )
    }) {
        IconButton(onClick = {}){
            Icon(Icons.Default.MoreVert, "menu", tint = DIM_TEXT_COLOR,
                modifier = Modifier.onKeyEvent {
                    false
                })
        }
    }
}