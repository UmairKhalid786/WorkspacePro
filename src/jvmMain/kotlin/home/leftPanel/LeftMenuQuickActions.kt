package home.leftPanel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.EditSolid
import compose.icons.lineawesomeicons.VideoSolid
import widgets.IconWithLabelHorizontal

@Composable
fun LeftMenuQuickActions(expanded: Boolean) {
    if (expanded)
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            IconWithLabelHorizontal(LineAwesomeIcons.VideoSolid, "Meet Now", false)
            IconWithLabelHorizontal(LineAwesomeIcons.EditSolid, "Create Chat", false)
        }
}