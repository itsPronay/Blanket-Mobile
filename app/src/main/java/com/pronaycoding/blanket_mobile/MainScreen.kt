package com.pronaycoding.blanket_mobile

import android.content.Intent
import android.media.MediaPlayer
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    cardLists: List<CardItems>
) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Blanket")
            },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "")
                    }
                })
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = {


                },
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }) {
        LazyColumn(
            modifier = Modifier.padding(it),
        ) {
            items(cardLists) { cardItem ->
                CardItemsView(cardItem = cardItem)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItemsView(
    cardItem: CardItems
) {
    val context = LocalContext.current
    val audio: MediaPlayer = MediaPlayer.create(context, cardItem.audioSource)

    var audioSlider by rememberSaveable {
        mutableFloatStateOf(0f)
    }

    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(top = 8.dp), onClick = {}) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = cardItem.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(.2f)
                )
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .weight(.8f)
                ) {
                    Text(text = cardItem.title)
                    Slider(
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color.Green, inactiveTrackColor = Color.LightGray
                        ), value = audioSlider, onValueChange = {
                            if (audioSlider != 0F) {
                                audio.start()
                            }
                            audioSlider = it
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
