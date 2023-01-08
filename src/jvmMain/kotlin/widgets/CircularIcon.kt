package widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import java.net.URL

@Composable
fun CircularNetworkIcon(url: URL, modifier: Modifier = Modifier) {
    Card(shape = CircleShape, modifier = modifier) {
        Image(
            bitmap = loadImage(url.toString()),
            contentDescription = "Menu icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(42.dp)
        )
    }
}