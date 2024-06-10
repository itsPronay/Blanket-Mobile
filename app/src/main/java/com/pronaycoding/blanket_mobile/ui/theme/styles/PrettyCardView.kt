package com.pronaycoding.blanket_mobile.ui.theme.styles

//import androidx.compose.foundation.layout.ColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.pronaycoding.blanket_mobile.R
import com.pronaycoding.blanket_mobile.ui.homeScreen.BlanketViewModel
import com.pronaycoding.blanket_mobile.ui.homeScreen.CardItems
import com.pronaycoding.blanket_mobile.ui.theme.BlanketmobileTheme
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun PrettyCardView(
    cardItem: CardItems,
    viewModel: BlanketViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var isPlaying by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    var sliderValue by rememberSaveable { mutableFloatStateOf(0F) }

    LaunchedEffect(Unit) {
        viewModel.initializeSoundPool(context, viewModel.getSongs())
    }

    LaunchedEffect(sliderValue) {
        if (sliderValue > 0F) {
            viewModel.playSound(R.raw.a_nature_thunder, sliderValue)
            isPlaying = true
        } else {
            viewModel.pauseSound(cardItem.audioSource)
            isPlaying = false
        }
        viewModel.setVolume(cardItem.audioSource, sliderValue)
    }

    Card(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 4.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Unspecified)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = cardItem.icon),
                    contentDescription = "Icon",
                    modifier = Modifier.size(32.dp),
                    tint = if (isPlaying) Color(0xFF27a157) else MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = cardItem.title,
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
                value = sliderValue,
                onValueChange = { newValue ->
                    sliderValue = newValue
                    viewModel.setVolume(cardItem.audioSource, newValue)
                },
                valueRange = 0f..1f,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(20.dp)
            )
        }
    }
}
