package com.pronaycoding.blanket_mobile.ui.homeScreen

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pronaycoding.blanket_mobile.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    cardLists: List<CardItems>,
    drawerItems: List<DrawerItems>,
//    onSettingsClicked :
) {
    val snackbarHostState = remember { SnackbarHostState() }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    ModalNavigationDrawer(
        modifier = Modifier
            .width(20.dp)
            .background(Color.LightGray),
        drawerState = drawerState,
        drawerContent = {
            Box(
                modifier = Modifier.width(300.dp)
            ) {
                ModalDrawerSheet() {

                    Text("Blanket", modifier = Modifier.padding(16.dp))
                    Divider()

                    drawerItems.forEachIndexed { index, drawerItem ->
                        NavigationDrawerItem(
                            modifier = Modifier
                                .padding(2.dp)
                                .height(45.dp),
                            label = {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    var color: Color =
                                        MaterialTheme.colorScheme.inverseSurface.copy(0.6f)
                                    if (selectedIndex == index) {
                                        color = MaterialTheme.colorScheme.inverseSurface
                                    }
                                    Icon(imageVector = drawerItem.icon, contentDescription = "")
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        text = drawerItem.title,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = FontWeight.W400,
                                        color = color
                                    )
                                }
                            },
                            selected = index == selectedIndex,
                            onClick = { selectedIndex = index })
                    }
                }
            }
        },
    ) {
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            topBar = {
                TopAppBar(title = {
                    Text(text = "Blanket")
                },

                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                        }

                    },
                    actions = {
                        IconButton(onClick = {

                        }) {
                            var icon: Painter = painterResource(id = R.drawable.play)
//                        if (isPlaying){ icon = painterResource(id = R.drawable.pause)}
                            Icon(
                                painter = icon,
                                contentDescription = "",
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    })
            }) {
            LazyColumn(
                modifier = Modifier.padding(it),
            ) {

                items(cardLists) { cardItem ->
                    if (cardItem.firstInType) {
                        TypeView(typeText = cardItem.type)
                    }
                    if(cardItem.title != ""){
                        CardItemsView(
                            cardItem = cardItem
                        )
                    }
                    if (cardItem.type == "Custom") {
                        AddCustomSound(
                            detectButtonClick = {
                                scope.launch {
                                    snackbarHostState.showSnackbar(
                                        "This feature is yet to be implemented",
                                        "OK",
                                        duration = SnackbarDuration.Short
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CardItemsView(
    cardItem: CardItems
) {
    val context = LocalContext.current
    val audio = remember(cardItem.audioSource) {
        MediaPlayer.create(context, cardItem.audioSource).apply {
            isLooping = true
        }
    }
    var audioSlider by rememberSaveable {
        mutableFloatStateOf(0f)
    }

    //to set the tint of icon
    var inverseSurfaceColor = MaterialTheme.colorScheme.inverseSurface
    var primaryColor = MaterialTheme.colorScheme.primary
    var iconTintColor by remember { mutableStateOf(inverseSurfaceColor) }

    // Release the MediaPlayer when the composable is disposed
    DisposableEffect(Unit) {
        onDispose {
            audio.release()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(top = 8.dp)
                .padding(horizontal = 5.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = cardItem.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(.2f),
                    tint = iconTintColor
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(.8f)
                ) {
                    Text(text = cardItem.title)
                    Slider(
                        colors = SliderDefaults.colors(
                            activeTrackColor = MaterialTheme.colorScheme.primary,
                            inactiveTrackColor = Color.LightGray
                        ), value = audioSlider, onValueChange = {
                            audioSlider = it
                            if (audioSlider != 0F) {
                                audio.start()
                                iconTintColor = primaryColor
                            } else{
                                audio.pause()
                                iconTintColor = inverseSurfaceColor
                            }
                            audio.setVolume(
                                audioSlider, audioSlider
                            ) // Set volume for left and right channels


                        }, modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}


@Composable
//@Preview (showBackground = true)
fun TypeView(
    modifier: Modifier = Modifier,
    typeText: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 16.dp)
            .padding(8.dp),

        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    ) {
        Text(
            text = typeText,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
//            fontFamily = FontFamily.Monospace
        )
        Divider()
    }
}

@Composable
fun AddCustomSound(
    detectButtonClick: () -> Unit
) {
    Column {
        TypeView(typeText = "Custom")
        OutlinedButton(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            onClick = { detectButtonClick.invoke() }) {
            Text(text = "Add custom sound")

        }
    }
}
