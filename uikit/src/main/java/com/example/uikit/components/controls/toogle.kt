package com.example.uikit.components.controls

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorInputStroke
import com.example.uikit.theme.ColorWhite

@Composable
fun Toogle(switchCheck: Boolean, switchCheckChance: (Boolean) -> Unit) {
    Switch(
        checked = switchCheck,
        onCheckedChange = switchCheckChance,
        colors = SwitchDefaults.colors(
            checkedThumbColor = ColorWhite,
            checkedTrackColor = ColorAccent,
            uncheckedTrackColor = ColorInputStroke,
            uncheckedThumbColor = ColorWhite
        )
    )
}