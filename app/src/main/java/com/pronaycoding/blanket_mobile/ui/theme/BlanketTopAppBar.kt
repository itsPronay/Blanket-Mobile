package com.pronaycoding.blanket_mobile.ui.theme

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BlanketTopBar(modifier: Modifier = Modifier) {
    Row {
        Text(text = "Blanket")

    }
}