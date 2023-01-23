package home.leftPanel.contextMenu

import BG_COLOR
import DIM_TEXT_COLOR
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.*
import widgets.CircularNetworkIcon
import java.net.URL

@Composable
fun ContextMenuLeftMenu() {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = {
        expanded = true
    }) {
        Icon(Icons.Default.MoreVert, "menu", tint = DIM_TEXT_COLOR)
    }

    // tmp fix for https://github.com/JetBrains/compose-jb/issues/2012
    var renderCount by remember { mutableStateOf(0) }
    listOf(renderCount, renderCount - 1).forEach { renderId ->
        val isActive = renderId == renderCount
        key(renderId) {
            CursorDropdownMenu(
                expanded = expanded && isActive,
                onDismissRequest = {
                    if (isActive) {
                        renderCount += 1
                        expanded = false
                    }
                },
                modifier = Modifier.width(400.dp)
            ) {
                DropdownMenuItem({}) {
                    MenuHeader()
                }
                DropdownMenuItem({}) {
                    Column {
                        Profile()
                        UserStatus()
                    }
                }
                Text("MANAGE", color = Color.Gray, modifier = Modifier.background(BG_COLOR).padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth())
                DropdownMenuItem({}) {
                    IconText(LineAwesomeIcons.UserAltSolid, "WorkspacePro profile")
                }
                DropdownMenuItem({}) {
                    IconText(LineAwesomeIcons.DollarSignSolid, "WorkspacePro to Phone", "Credit: 3.76 | No subscription")
                }
                DropdownMenuItem({}) {
                    IconText(LineAwesomeIcons.MobileAltSolid, "WorkspacePro Number", "Get a second number")
                }
                DropdownMenuItem({}) {
                    IconText(LineAwesomeIcons.CogSolid, "Settings")
                }
                DropdownMenuItem({}) {
                    IconText(LineAwesomeIcons.CloudDownloadAltSolid, "Get WorkspacePro App")
                }
            }
        }
    }
}

@Composable
fun MenuHeader() {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 16.dp)) {
        Icon(LineAwesomeIcons.Microsoft, "Test",  modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(4.dp))
        Text("Microsoft")
        Spacer(modifier = Modifier.weight(1f))
        Text("Logout", style = MaterialTheme.typography.caption)
    }
}

@Composable
fun Profile() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularNetworkIcon(
            URL("https://randomuser.me/api/portraits/med/men/1.jpg"),
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text("Umair Khalid", style = TextStyle(fontWeight = FontWeight.Medium))
            Spacer(modifier = Modifier.size(8.dp))
            Text("$0.00", style = MaterialTheme.typography.caption)
            Spacer(modifier = Modifier.size(8.dp))
            Text("My microsoft account", style = MaterialTheme.typography.caption)
        }
    }
}


@Composable
fun UserStatus() {
    IconText(LineAwesomeIcons.CircleSolid, "Active")
}

@Composable
fun IconText(imageVector: ImageVector, menuTitle: String, subtitle: String? = null) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 16.dp)) {
        Icon(imageVector, "Menu Icon", modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(menuTitle)
            subtitle?.let {
                Text(subtitle, style = MaterialTheme.typography.caption)
            }
        }
    }
}

