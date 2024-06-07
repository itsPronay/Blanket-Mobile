package com.pronaycoding.blanket_mobile

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pronaycoding.blanket_mobile.ui.homeScreen.BlanketTabRow
import com.pronaycoding.blanket_mobile.ui.homeScreen.BlanketViewModel
import com.pronaycoding.blanket_mobile.ui.homeScreen.Dashboard
import com.pronaycoding.blanket_mobile.ui.theme.BlanketmobileTheme
import com.pronaycoding.blanket_mobile.ui.theme.styles.BlanketTopBar
import com.pronaycoding.blanket_mobile.ui.theme.styles.TitleCardView

class MainActivity : ComponentActivity() {
    //    private var soundId3: Int = 0
    private lateinit var audio1: MediaPlayer
    private lateinit var audio2: MediaPlayer
    private lateinit var audio3: MediaPlayer
    private lateinit var audio4: MediaPlayer
    private lateinit var audio5: MediaPlayer
    private lateinit var audio6: MediaPlayer
    private lateinit var audio7: MediaPlayer
    private lateinit var audio8: MediaPlayer
    private lateinit var audio9: MediaPlayer
    private lateinit var audio10: MediaPlayer
    private lateinit var audio11: MediaPlayer
    private lateinit var audio12: MediaPlayer
    private lateinit var audio13: MediaPlayer
    private lateinit var audio14: MediaPlayer
    private lateinit var audio15: MediaPlayer

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        audio1 = MediaPlayer.create(this, R.raw.nature_rain).apply {
            isLooping = true
        }
        audio2 = MediaPlayer.create(this, R.raw.nature_wind).apply {
            isLooping = true
        }
        audio3 = MediaPlayer.create(this, R.raw.nature_storm).apply {
            isLooping = true
        }
        audio4 = MediaPlayer.create(this, R.raw.nature_waves).apply {
            isLooping = true
        }
        audio5 = MediaPlayer.create(this, R.raw.nature_stream).apply {
            isLooping = true
        }
        audio6 = MediaPlayer.create(this, R.raw.nature_birds).apply {
            isLooping = true
        }
        audio7 = MediaPlayer.create(this, R.raw.nature_summernight).apply {
            isLooping = true
        }




        audio8 = MediaPlayer.create(this, R.raw.travel_train).apply {
            isLooping = true
        }
        audio9 = MediaPlayer.create(this, R.raw.boat).apply {
            isLooping = true
        }
        audio10 = MediaPlayer.create(this, R.raw.travel_train).apply {
            isLooping = true
        }


        audio11 = MediaPlayer.create(this, R.raw.interior_coffeeshop).apply {
            isLooping = true
        }
        audio12 = MediaPlayer.create(this, R.raw.interior_fireplace).apply {
            isLooping = true
        }
        audio13 = MediaPlayer.create(this, R.raw.busy_restaurant).apply {
            isLooping = true
        }
        audio14 = MediaPlayer.create(this, R.raw.noise_pink_noise).apply {
            isLooping = true
        }
        audio15 = MediaPlayer.create(this, R.raw.noise_white_noise).apply {
            isLooping = true
        }


//        enableEdgeToEdge()
        setContent {

            BlanketmobileTheme {
                // A surface container using the 'background' color from the theme
                val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
//                Scaffold(
//                    topBar = {
//                        BlanketTopBar(scrollBehavior = scrollBehavior)
//                    }
//                ) {
                Surface {
                    val viewModel : BlanketViewModel = viewModel()

                    Dashboard(cardLists = viewModel.getCardList() , drawerItems = viewModel.getDrawerItems()
                        , navigateTo = {} )

//                    MainScreen(
//                        modifier = Modifier,
//                        audio1 = audio1,
//                        audio2,
//                        audio3,
//                        audio4,
//                        audio5,
//                        audio6,
//                        audio7,
//                        audio8,
//                        audio9,
//                        audio10,
//                        audio11,
//                        audio12,
//                        audio13,
//                        audio14,
//                        audio15,
//                    )
                }
            }
//                    val viewmodel: BlanketViewModel = viewModel()
//                    Navigation(
//                        cardItems = viewmodel.getCardList(),
//                        drawerItems = viewmodel.getDrawerItems(),
//                        audioPlayer = audioPlayer
//                    )

        }
    }
//    }

    override fun onDestroy() {
        super.onDestroy()
        audio1.release() // Ensure audioPlayer is released properly
        audio2.release()
        audio3.release()
        audio4.release()
        audio4.release()
        audio5.release()
        audio6.release()
        audio7.release()
        audio8.release()
        audio9.release()
        audio10.release()
        audio11.release()
        audio12.release()
        audio13.release()
        audio14.release()
        audio15.release()
    }
}

@Composable
fun test(
    modifier: Modifier = Modifier,
    p: MediaPlayer
) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    audio1: MediaPlayer,
    sound2: MediaPlayer,
    sound3: MediaPlayer,
    sound4: MediaPlayer,
    sound5: MediaPlayer,
    sound6: MediaPlayer,
    sound7: MediaPlayer,
    sound8: MediaPlayer,
    sound9: MediaPlayer,
    sound10: MediaPlayer,
    sound11: MediaPlayer,
    sound12: MediaPlayer,
    sound13: MediaPlayer,
    sound14: MediaPlayer,
    sound15: MediaPlayer,

    ) {
//    var isPlaying1 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying2 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying3 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying1 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying2 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying3 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying1 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying2 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying3 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying1 by rememberSaveable {
//        mutableStateOf(false)
//    }
//    var isPlaying1 by rememberSaveable {
//        mutableStateOf(false)
//    }


    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        topBar = {
            BlanketTopBar(scrollBehavior = scrollBehavior)
        }
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            item {
                BlanketTabRow()


                var sliderValue1 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue2 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue3 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue4 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue5 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue6 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue7 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue8 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue9 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue10 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue12 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue13 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue11 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue14 by rememberSaveable {
                    mutableStateOf(0F)
                }
                var sliderValue15 by rememberSaveable {
                    mutableStateOf(0F)
                }
//    }var sliderValue1 by rememberSaveable {
//        mutableStateOf(0F)
//    }var sliderValue1 by rememberSaveable {
//        mutableStateOf(0F)
//    }var sliderValue1 by rememberSaveable {
//        mutableStateOf(0F)
//    }
                val context = LocalContext.current





                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.rain),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Rain",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue1,
                            onValueChange = {
                                sliderValue1 = it

                                if (sliderValue1 != 0F) {
                                    audio1.start()
                                } else {
                                    audio1.pause()
                                }
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }





                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.wind),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Wind",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue2,
                            onValueChange = {
                                sliderValue2 = it

                                if (sliderValue2 != 0F) {
                                    sound2.start()
                                } else {
                                    sound2.stop()
                                }
                                sound2.setVolume(sliderValue2, sliderValue2)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.storm),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Storm",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue3,
                            onValueChange = {
                                sliderValue3 = it

                                if (sliderValue3 != 0F) {
                                    sound3.start()
                                } else {
                                    sound3.pause()
                                }
                                sound3.setVolume(sliderValue3, sliderValue3)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.wave),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Waves",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue4,
                            onValueChange = {
                                sliderValue4 = it

                                if (sliderValue4 != 0F) {
                                    sound4.start()
                                } else {
                                    sound4.pause()
                                }
                                sound4.setVolume(sliderValue4, sliderValue4)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.stream),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Streams",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue5,
                            onValueChange = {
                                sliderValue5 = it

                                if (sliderValue5 != 0F) {
                                    sound5.start()
                                } else {
                                    sound5.pause()
                                }
                                sound5.setVolume(sliderValue5, sliderValue5)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }



                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.birds),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Birds",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue6,
                            onValueChange = {
                                sliderValue6 = it

                                if (sliderValue6 != 0F) {
                                    sound6.start()
                                } else {
                                    sound6.pause()
                                }
                                sound6.setVolume(sliderValue6, sliderValue6)

                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.day),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Summer night",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue7,
                            onValueChange = {
                                sliderValue7 = it

                                if (sliderValue7 != 0F) {
                                    sound7.start()
                                } else {
                                    sound7.pause()
                                }
                                sound7.setVolume(sliderValue7, sliderValue7)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }

                TitleCardView(text = "Travel")

                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.train),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Train",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue8,
                            onValueChange = {
                                sliderValue8 = it

                                if (sliderValue8 != 0F) {
                                    sound8.start()
                                } else {
                                    sound8.pause()
                                }
                                sound8.setVolume(sliderValue8, sliderValue8)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.sailboat),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Boat",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue9,
                            onValueChange = {
                                sliderValue9 = it

                                if (sliderValue9 != 0F) {
                                    sound9.start()
                                } else {
                                    sound9.pause()
                                }
                                sound9.setVolume(sliderValue9, sliderValue9)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }


                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.city),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "City",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue10,
                            onValueChange = {
                                sliderValue10 = it

                                if (sliderValue10 != 0F) {
                                    sound10.start()
                                } else {
                                    sound10.pause()
                                }
                                sound10.setVolume(sliderValue10, sliderValue10)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }


                TitleCardView(text = "Interiors")
                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.coffee),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Coffee Shop",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue11,
                            onValueChange = {
                                sliderValue11 = it

                                if (sliderValue11 != 0F) {
                                    sound11.start()
                                } else {
                                    sound11.pause()
                                }
                                sound11.setVolume(sliderValue11, sliderValue11)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }


                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.fireplace),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Fireplace",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue12,
                            onValueChange = {
                                sliderValue12 = it

                                if (sliderValue12 != 0F) {
                                    sound12.start()
                                } else {
                                    sound12.pause()
                                }
                                sound12.setVolume(sliderValue12, sliderValue12)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }


                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.food_delivery),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Busy Restaurant",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue13,
                            onValueChange = {
                                sliderValue13 = it

                                if (sliderValue13 != 0F) {
                                    sound13.start()
                                } else {
                                    sound13.pause()
                                }
                                sound13.setVolume(sliderValue13, sliderValue13)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }

                TitleCardView(text = "Noise")


                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.pink_noise),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Pink noise",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue14,
                            onValueChange = {
                                sliderValue14 = it

                                if (sliderValue14 != 0F) {
                                    sound14.start()
                                } else {
                                    sound14.pause()
                                }
                                sound14.setVolume(sliderValue14, sliderValue14)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .padding(horizontal = 24.dp, vertical = 4.dp)
                        .fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Unspecified

                    ),
//        elevation = CardDefaults.cardElevation(1.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.white_noise),
                                contentDescription = "Icon",
                                modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "White noise",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))

                        Slider(
                            colors = SliderDefaults.colors(
                                thumbColor = Color(0xFF27a157),
                                activeTrackColor = Color(0xFF27a157),
                                inactiveTrackColor = Color(0xFF27a157).copy(alpha = .2f)
                            ),
                            value = sliderValue15,
                            onValueChange = {
                                sliderValue15 = it

                                if (sliderValue15 != 0F) {
                                    sound15.start()
                                } else {
                                    sound15.pause()
                                }
                                sound15.setVolume(sliderValue15, sliderValue15)
                            },
                            valueRange = 0f..1f,
                            modifier = Modifier
                                .fillMaxWidth()
                                .size(20.dp)
                        )
                    }
                }
            }
        }
    }


}

