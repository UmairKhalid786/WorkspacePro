package theme

import DIM_TEXT_COLOR
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp

val primary = Color(48, 163, 230)
val secondary = Color(24, 25, 29)
val opacWhite = Color.White.copy(alpha = 0.8F)

private val DarkColors = darkColors(
    primary = primary,
    secondary = secondary,
    surface = secondary,
    onPrimary = Color.White,
    onSecondary = Color.White
)

private val LightColors = lightColors(
    primary = opacWhite,
    secondary = primary,
    surface = primary,
    onPrimary = DIM_TEXT_COLOR,
    onSecondary = opacWhite,
    onSurface = DIM_TEXT_COLOR
)

@Composable
fun DecomposeDesktopExampleTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColors,
        typography = Typography(
            defaultFontFamily = FontFamily(Font("google_sans_regular.ttf")),
            body1 = TextStyle(
                fontSize = 14.sp
            )
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            content()
        }
    }
}