package home.leftPanel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.AddressBook
import compose.icons.lineawesomeicons.Bell
import compose.icons.lineawesomeicons.FacebookMessenger
import compose.icons.lineawesomeicons.PhoneSolid
import widgets.IconWithLabelVertical

@Composable
fun LeftMenuActionsItems(expanded: Boolean) {
    if (expanded)
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            IconWithLabelVertical(LineAwesomeIcons.FacebookMessenger, "Chats", true)
            IconWithLabelVertical(LineAwesomeIcons.PhoneSolid, "Calls", false)
            IconWithLabelVertical(LineAwesomeIcons.AddressBook, "Contacts", false)
            IconWithLabelVertical(LineAwesomeIcons.Bell, "Notifications", false)
        }
}
