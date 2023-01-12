// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.window.*
import home.LeftPanel


@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {

    var isOpen by remember { mutableStateOf(true) }
    if (isOpen.not()) return@application

    Window(
        onCloseRequest = {
            isOpen = false
        },
        title = "Skype Clone",
    ) {
        MenuBar {
            Menu("Actions", mnemonic = 'A') {
                Item("About", onClick = { })
                Separator()
                Item("Exit", onClick = { isOpen = false }, shortcut = KeyShortcut(Key.Escape), mnemonic = 'E')
            }
        }

        Row(modifier = Modifier.fillMaxWidth().background(color = BG_COLOR)) {
            LeftPanel()
            ChatDetailScreen("Mark", Modifier.fillMaxWidth())
        }
    }
}

fun openAboutMeWindow() {

}


