package home.chat.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.*
import widgets.ActionButton

@Composable
fun MessageTypeView() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().background(color = Color.White).padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        ChatInputView(Modifier.weight(1.0f, true))
        MessageTypeActionButtons()
    }
}

@Composable
fun MessageTypeActionButtons() {
    Row {
        ActionButton(LineAwesomeIcons.File, "phone")
        ActionButton(LineAwesomeIcons.MicrophoneSolid, "call")
        ActionButton(LineAwesomeIcons.AddressCard, "add")
    }
}