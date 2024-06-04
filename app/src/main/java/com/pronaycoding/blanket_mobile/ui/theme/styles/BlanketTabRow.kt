package com.pronaycoding.blanket_mobile.ui.homeScreen

//import androidx.compose.foundation.layout.ColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.sharp.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pronaycoding.blanket_mobile.R
import com.pronaycoding.blanket_mobile.ui.theme.styles.PrettyCardView

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlanketTabRow(modifier: Modifier = Modifier) {
    val titles = listOf("Home", "Settings")
    var state by remember { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TabRow(selectedTabIndex = state, divider = {},
            indicator = {

            }
            ) {
            titles.forEachIndexed { index, title ->
                Tab(selectedContentColor = Color(0xFF27a157).copy(alpha = .5f),
                    selected = (index == state),
                    onClick = { state = index },
                    text = {
                        Text(
                            text = title,
                            color = if (state == index) Color(0xFF27a157) else MaterialTheme.colorScheme.inverseSurface.copy(
                                alpha = .7f
                            )
                        )
                    })
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBlanketTabRow() {
    BlanketTabRow()
}
