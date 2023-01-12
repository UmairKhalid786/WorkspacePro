// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberTrayState
import compose.icons.LineAwesomeIcons
import compose.icons.lineawesomeicons.*
import home.LeftPanel
import topMenu.TrayIcon
import widgets.IconWithLabelVertical
import widgets.IconWithLabelHorizontal


fun main() = application {

    var isOpen by remember { mutableStateOf(true) }
    if (isOpen.not()) return@application

    val trayState = rememberTrayState()

    Tray(
        state = trayState,
        icon = TrayIcon,
        menu = {
            Item(
                "About Me",
                onClick = {
                    openAboutMeWindow()
                }
            )
            Item(
                "Exit",
                onClick = {
                    isOpen = false
                }
            )
        }
    )

    Window(
        onCloseRequest = {
            isOpen = false
        },
        title = "Skype Clone",
    ) {
        Row(modifier = Modifier.fillMaxWidth().background(color = BG_COLOR)) {
            LeftPanel()
            ChatDetailScreen("Mark", Modifier.fillMaxWidth())
        }
    }
}

fun openAboutMeWindow() {

}


