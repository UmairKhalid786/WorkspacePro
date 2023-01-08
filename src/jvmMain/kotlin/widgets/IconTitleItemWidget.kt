package widgets

import ACCENT_COLOR
import DIM_TEXT_COLOR
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.dp
import java.net.URL

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun IconTitleItemWidget(title: String, description: String, url: URL, expanded: Boolean) {
    var color by remember { mutableStateOf(Color.Transparent) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().background(color).padding(16.dp).hoverable(
            MutableInteractionSource(), true
        ).onPointerEvent(PointerEventType.Enter) {
            color = ACCENT_COLOR
        }.onPointerEvent(PointerEventType.Exit) {
            color = Color.Transparent
        }) {
        CircularNetworkIcon(url)
        if (expanded) {
            Spacer(Modifier.padding(8.dp))
            Column(modifier = Modifier.weight(1.0f, true)) {
                Text(title, modifier = Modifier, color = DIM_TEXT_COLOR)
                Spacer(Modifier.padding(4.dp))
                Text(description, modifier = Modifier, color = DIM_TEXT_COLOR.copy(alpha = 0.6F))
            }
            Text("20/1/2021", modifier = Modifier, color = DIM_TEXT_COLOR.copy(alpha = 0.6F))
        }
    }
}

fun loadImage(url: String) =
    org.jetbrains.skia.Image.makeFromEncoded(URL(url).readBytes())
        .toComposeImageBitmap()
