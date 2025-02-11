package com.safwan.jewel

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.intui.standalone.theme.IntUiTheme
import org.jetbrains.jewel.intui.standalone.theme.lightThemeDefinition
import org.jetbrains.jewel.intui.window.decoratedWindow
import org.jetbrains.jewel.intui.window.styling.light
import org.jetbrains.jewel.intui.window.styling.lightWithLightHeader
import org.jetbrains.jewel.ui.ComponentStyling
import org.jetbrains.jewel.ui.component.DefaultButton
import org.jetbrains.jewel.ui.component.OutlinedButton
import org.jetbrains.jewel.ui.component.Text
import org.jetbrains.jewel.window.DecoratedWindow
import org.jetbrains.jewel.window.TitleBar
import org.jetbrains.jewel.window.newFullscreenControls
import org.jetbrains.jewel.window.styling.DecoratedWindowStyle
import org.jetbrains.jewel.window.styling.TitleBarStyle


fun main() = application {

    var showDialog by remember { mutableStateOf(false) }

    IntUiTheme(
        theme = JewelTheme.lightThemeDefinition(),
        styling = ComponentStyling.decoratedWindow(titleBarStyle = TitleBarStyle.light(), windowStyle = DecoratedWindowStyle.light()),
        swingCompatMode = false
    ) {
        DecoratedWindow(
            onCloseRequest = { exitApplication() },
            title = "Jewel standalone",
            state = WindowState(
                position = WindowPosition.Aligned(Alignment.Center),
            ),
            content = {

                TitleBar(
                    style = TitleBarStyle.lightWithLightHeader(),
                    modifier = Modifier.newFullscreenControls(),
                ) {
                    Text(text = "Jewel standalone starter", textAlign = TextAlign.Center)
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("By @safwa1")

                    Spacer(Modifier.height(10.dp))

                    OutlinedButton(
                        onClick = {
                            exitApplication()
                        }
                    ) {
                        Text("Close Application")
                    }

                    Spacer(Modifier.height(10.dp))

                    DefaultButton(
                        onClick = {
                            showDialog = true
                        }
                    ) {
                        Text("Close Application ?")
                    }
                }

                if (showDialog) {
                    confirmationDialog(
                        onClose = { showDialog = false },
                        onConfirm = {
                            showDialog = false
                            exitApplication()
                        }
                    )
                }
            },
        )
    }




}
