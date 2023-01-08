package widgets

import ACCENT_DARK_COLOR
import DIM_TEXT_COLOR
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconWithLabelVertical(imageVector: ImageVector, label: String, active: Boolean) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        val color by remember { derivedStateOf { if (active) ACCENT_DARK_COLOR else DIM_TEXT_COLOR } }
        Icon(
            imageVector,
            label,
            tint = color,
            modifier = Modifier.size(40.dp)
                .background(shape = CircleShape, color = Color.Transparent)
                .padding(8.dp)
        )
        Text(label, color = color, style = MaterialTheme.typography.caption)
    }
}