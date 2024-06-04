package com.pronaycoding.blanket_mobile.ui.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.sharp.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pronaycoding.blanket_mobile.R
import com.pronaycoding.blanket_mobile.ui.theme.styles.BlanketTopBar
import com.pronaycoding.blanket_mobile.ui.theme.styles.PrettyCardView
import com.pronaycoding.blanket_mobile.ui.theme.styles.TitleCardView

@Composable
@Preview(showSystemUi = true)
fun PreviewScreen(
    viewModel: BlanketViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Dashboard(cardLists = viewModel.getCardList(), drawerItems = viewModel.getDrawerItems()) {}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
    cardLists: List<CardItems>, drawerItems: List<DrawerItems>, navigateTo: (route: String) -> Unit
) {
    var scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BlanketTopBar(scrollBehavior)
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            BlanketTabRow()

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(cardLists) { cardItem ->
                    if (cardItem.firstInType) {
                        TitleCardView(cardItem.type)
                    }
                    if (cardItem.title != "") {
                        PrettyCardView(
                            cardItem = cardItem
                        )
                    }
                }


            }
        }
    }

}

//
//@Composable
//fun CardItemsView(
//    cardItem: CardItems,
////    viewModel: MediaPlayerViewModel = viewModel() // Assuming Hilt is being used for DI
//) {
////    val context = LocalContext.current
////    var audioSlider by rememberSaveable { mutableFloatStateOf(0f) }
////    val inverseSurfaceColor = MaterialTheme.colorScheme.inverseSurface
////    val primaryColor = MaterialTheme.colorScheme.primary
////    var iconTintColor by remember { mutableStateOf(inverseSurfaceColor) }
////
////    // Initialize the media player when the composable is first composed
////    LaunchedEffect(key1 = cardItem.audioSource) {
////        viewModel.initializeMediaPlayer(cardItem.audioSource)
////    }
////
////    // Update the media player based on slider value
////    LaunchedEffect(key1 = audioSlider) {
////        if (audioSlider != 0f) {
////            viewModel.play(cardItem.audioSource)
////            iconTintColor = primaryColor
////        } else {
////            viewModel.pause(cardItem.audioSource)
////            iconTintColor = inverseSurfaceColor
////        }
////        viewModel.setVolume(cardItem.audioSource, audioSlider)
////        while(true){
////
////        }
////    }
//
//    val context = LocalContext.current
//    var initializeAudio by rememberSaveable {
//        mutableStateOf(false)
//    }
//    val audio = remember(cardItem.audioSource) {
//        MediaPlayer.create(context, cardItem.audioSource).apply {
//            isLooping = true
//        }
//    }
//    var audioSlider by rememberSaveable {
//        mutableFloatStateOf(0f)
//    }
//    //to set the tint of icon
//    var normalTextColor = if (isSystemInDarkTheme()) Color.White else Color.White
//    var cardActiveColor = if (isSystemInDarkTheme()) Color.White else Color(0xFFc49450)
//
//
//    var iconTintColor by remember { mutableStateOf(normalTextColor) }
//
//    LaunchedEffect(key1 = audioSlider) {
//        if (initializeAudio) {
//            while (true) {
//                if (audioSlider != 0F) {
//                    audio.start()
//                    iconTintColor = cardActiveColor
//                } else {
//                    audio.pause()
//                    iconTintColor = normalTextColor
//                }
//                if (initializeAudio) {
//// TODO
//                }
//            }
//        }
//    }
//    var scope = rememberCoroutineScope()
//    scope
//    Column(
//        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(80.dp)
//                .padding(top = 8.dp)
//                .padding(horizontal = 5.dp),
//            shape = RoundedCornerShape(20.dp),
//            elevation = CardDefaults.cardElevation(5.dp),
//            colors = CardDefaults.cardColors(
//                containerColor = MaterialTheme.colorScheme.background
//            )
//        ) {
//
//            var color: Color = Color.Black
//            if (isSystemInDarkTheme()) {
//                color = MaterialTheme.colorScheme.onPrimary
//            } else MaterialTheme.colorScheme.primary
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .background(
//                        brush = Brush.linearGradient(
//                            colors = if (isSystemInDarkTheme()) listOf(
////                                Color.,
//                                Color(0xFFa2c0e6),
//                                Color(0xFF3076ce),
//
////                                MaterialTheme.colorScheme.surface,
//////                                MaterialTheme.colorScheme.onPrimary.copy(alpha = .f),
////                                MaterialTheme.colorScheme.onPrimary
//
//                            ) else listOf(
////                                Color(0xFF202224).copy(alpha = .3f),
//                                Color.White, Color.White
////                                Color.Black
//
////                                        MaterialTheme.colorScheme.surface,
////                                MaterialTheme.colorScheme.primary.copy(alpha = .3f)
//                            )
//                        )
//                    )
//            ) {
//                Icon(
//                    painter = painterResource(id = cardItem.icon),
//                    contentDescription = "",
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .weight(.2f),
//                    tint = iconTintColor
//                )
//                Column(
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .weight(.8f)
//                ) {
//                    Text(text = cardItem.title)
//                    Slider(
//                        colors = SliderDefaults.colors(
//                            activeTrackColor = MaterialTheme.colorScheme.primary,
//                            inactiveTrackColor = Color.LightGray
//                        ), value = audioSlider, onValueChange = {
//                            initializeAudio = true
//                            audioSlider = it
//                            audio.setVolume(
//                                audioSlider, audioSlider
//                            ) // Set volume for left and right channels
//
//                        }, modifier = Modifier.fillMaxWidth()
//                    )
//                }
//            }
//        }
//    }
//}


@Composable
fun AddCustomSound(
    detectButtonClick: () -> Unit
) {
    Column {
        Text(text = "hey")
    }
}
