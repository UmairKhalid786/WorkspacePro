package home.chat.detail

import DIM_TEXT_COLOR
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.*
import widgets.ActionButton

@Composable
fun DetailScreenHeader(name: String, modifier: Modifier) {
    Row(
        modifier = modifier.padding(horizontal = 26.dp, vertical = 16.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NameAndGallery(name)
        ActionButtons()
    }
}

@Composable
fun NameAndGallery(name: String) {
    Column {
        Text(name, style = MaterialTheme.typography.h4, fontWeight = FontWeight.Medium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Last seen 18h ago", fontWeight = FontWeight.Medium)
            NameAndGalleryDivider()
            LeadingIconText(LineAwesomeIcons.Image, "Gallery")
            NameAndGalleryDivider()
            LeadingIconText(Icons.Outlined.Search, "Find")
        }
    }
}

@Composable
fun ActionButtons() {
    Row {
        ActionButton(LineAwesomeIcons.VideoSolid, "phone")
        ActionButton(LineAwesomeIcons.PhoneSolid, "call")
        ActionButton(LineAwesomeIcons.UserPlusSolid, "add")
    }
}

@Composable
fun LeadingIconText(imageVector: ImageVector, text: String) {
    Icon(imageVector, contentDescription = text, modifier = Modifier.size(16.dp), tint = DIM_TEXT_COLOR.copy(alpha = 0.7F))
    Spacer(modifier = Modifier.size(4.dp))
    Text(text, fontWeight = FontWeight.Medium)
}

@Composable
fun NameAndGalleryDivider(){
    Divider(
        modifier = Modifier.height(26.dp).padding(horizontal = 8.dp).width(1.dp).background(Color.LightGray)
    )
}