// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import aboutMe.AboutMe
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import navigation.NavHostComponent
import theme.DecomposeDesktopExampleTheme
import javax.swing.SwingUtilities
import kotlin.system.exitProcess


/**
 * Where all magic starts ;)
 */
@OptIn(ExperimentalDecomposeApi::class, ExperimentalComposeUiApi::class)
fun main() {
    val windowState = WindowState()
    val lifecycle = LifecycleRegistry()
    val root = runOnMainThreadBlocking { NavHostComponent(DefaultComponentContext(lifecycle)) }

    singleWindowApplication(
        state = windowState,
        title = "WorkspacePro",
    ) {
        var isAboutMeOpen by remember { mutableStateOf(false) }

        MenuBar {
            Menu("Actions", mnemonic = 'A') {
                Item("About", onClick = {
                    isAboutMeOpen = true
                })
                Separator()
                Item("Exit", onClick = { exitProcess(0) }, shortcut = KeyShortcut(Key.Escape), mnemonic = 'E')
            }
        }

        LifecycleController(lifecycle, windowState)
        DecomposeDesktopExampleTheme {
            root.render()

            if (isAboutMeOpen) {
                AboutMe {
                    isAboutMeOpen = false
                }
            }
        }
    }
}

private inline fun <T : Any> runOnMainThreadBlocking(crossinline block: () -> T): T {
    lateinit var result: T
    SwingUtilities.invokeAndWait { result = block() }
    return result
}
