package com.example.uikit.components.controls

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.theme.ColorAccent
import com.example.uikit.theme.ColorInputStroke
import com.example.uikit.theme.ColorWhite

@Composable
fun Toogle(switchCheck: Boolean, switchCheckChance: (Boolean) -> Unit) {
    Switch(
        modifier = Modifier.size(32.dp),
        checked = switchCheck,
        onCheckedChange = { switchCheckChance(switchCheck) },
        colors = SwitchDefaults.colors(
            checkedThumbColor = ColorWhite,
            checkedTrackColor = ColorAccent,
            uncheckedTrackColor = ColorInputStroke,
            uncheckedThumbColor = ColorWhite
        )
    )
}

@Preview
@Composable
private fun Aaaa() {
    Toogle(true) { }
}