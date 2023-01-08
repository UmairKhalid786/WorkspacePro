package widgets

import BG_COLOR
import DIM_TEXT_COLOR
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ActionButton(imageVector: ImageVector, description: String) {
    Icon(
        imageVector,
        description,
        tint = DIM_TEXT_COLOR,
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
            .background(shape = CircleShape, color = BG_COLOR)
            .padding(8.dp)
    )
}
