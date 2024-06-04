package com.pronaycoding.blanket_mobile

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pronaycoding.blanket_mobile.nav.Navigation
import com.pronaycoding.blanket_mobile.ui.homeScreen.BlanketViewModel
import com.pronaycoding.blanket_mobile.ui.theme.BlanketmobileTheme

class MainActivity : ComponentActivity() {
    private lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlanketmobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val viewmodel: BlanketViewModel = viewModel()
                    Navigation(
                        cardItems = viewmodel.getCardList(),
                        drawerItems = viewmodel.getDrawerItems()
                    )
                }
            }
        }
    }
}
