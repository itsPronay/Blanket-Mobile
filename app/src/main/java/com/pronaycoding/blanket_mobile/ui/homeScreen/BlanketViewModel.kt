package com.pronaycoding.blanket_mobile.ui.homeScreen

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pronaycoding.blanket_mobile.R
import com.pronaycoding.blanket_mobile.nav.Routes
import kotlinx.coroutines.launch


//@HiltViewModel
class BlanketViewModel(
//    context : Context
//    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var soundPool: SoundPool? = null
    private val soundMap = mutableMapOf<Int, Int>()

    fun initializeSoundPool(context: Context, audioSources: List<Int>) {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()

        audioSources.forEach { audioSource ->
            val soundId = soundPool?.load(context, audioSource, 1)
            soundId?.let {
                soundMap[audioSource] = it
            }
        }
    }

    fun playSound(audioSource: Int, volume: Float) {
        soundMap[audioSource]?.let { soundId ->
            soundPool?.play(soundId, volume, volume, 1, 0, 1f)
        }
    }

    fun pauseSound(audioSource: Int) {
        // SoundPool does not have a direct pause method for specific sound IDs.
        // Consider implementing a mechanism to keep track of the stream ID.
    }

    fun setVolume(audioSource: Int, volume: Float) {
        // SoundPool does not have a direct method to set volume for specific sound IDs.
        // Consider re-playing the sound with the new volume.
    }

    fun resumeSound(audioSource: Int) {
        // SoundPool does not have a direct resume method for specific sound IDs.
        // Implementing a mechanism to track and resume streams is necessary.
    }

    fun releaseSoundPool() {
        soundPool?.release()
        soundPool = null
        soundMap.clear()
    }




//    private var mediaPlayer: MediaPlayer? = null
//
////    init {
////        mediaPlayer.isLooping = true // Set looping if desired
////    }
//    fun initializeMediaplyer(context: Context, sound : Int) : Boolean{
//        var player : MediaPlayer? = null
//        viewModelScope.launch {
//            player = MediaPlayer.create(context, sound) // Replace with your audio source
//            mediaPlayer = (player as MediaPlayer?)!!
//        }
//        return if (player == null) false else true
//    }
//
//
//    fun setSound(sliderValue : Float){
//        mediaPlayer?.setVolume(sliderValue, sliderValue)
//    }
//    fun start(){
//        mediaPlayer?.start()
//    }
//    fun stop(){
//        mediaPlayer?.stop()
//    }
//    fun pause(){
//        mediaPlayer?.pause()
//    }
//     mediaPlayer = MediaPlayer.create(context, R.raw.your_audio_source) // Replace with your audio source
//



//    fun initializePlayer
//    var playOrPause by savedStateHandle.saveable { mutableStateOf(true) }

//    var initializePlayer =
    val songList = mutableListOf(


//    R.raw.nature_rain,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
    R.raw.a_nature_thunder,
//        R.raw.nature_wind,
//        R.raw.nature_waves,
//        R.raw.nature_stream,
//        R.raw.nature_storm,
//        R.raw.nature_birds,
//        R.raw.travel_train,
//        R.drawable.sailboat,
//        R.raw.travel_city,
//        R.raw.interior_coffeeshop,
//        R.raw.interior_fireplace,
//        R.raw.busy_restaurant,
//        R.raw.noise_pink_noise,
//        R.raw.noise_white_noise,
//        R.raw.noise_white_noise,
    )
    fun getSongs() : List<Int>{
        return songList
    }
    fun getDrawerItems(): List<DrawerItems> {
        return listOf(
            DrawerItems.Home,
            DrawerItems.SourceCode,
            DrawerItems.RequestFeature,
            DrawerItems.About,
            DrawerItems.Settings,
            DrawerItems.Quit,
        )
    }

    fun getCardList(): List<CardItems> {
        return listOf(
            CardItems.Rain,
            CardItems.Wind,
            CardItems.Storm,
            CardItems.Wave,
            CardItems.Stream,
            CardItems.Birds,
            CardItems.SummerNight,

            CardItems.Train,
            CardItems.Boat,
            CardItems.City,

            CardItems.CoffeeShop,
            CardItems.FirePlace,
//            CardItems.BusyRestaurant,

            CardItems.PinkNoise,
            CardItems.WhiteNoise,

            CardItems.Custom
        )
    }

}
sealed class HomeUiState {
    data object Initial : HomeUiState()
    data object Loading : HomeUiState()
//    object DeletedSuccessfully : HomeUiState()
    data class ShowError(val message: Int) : HomeUiState()
}

sealed class CardItems(
    var title: String,
    var icon: Int,
    val audioSource: Int,
    val type: String = "",
    val firstInType: Boolean = false
) {
    /*
     * Nature
     */
    data object Rain : CardItems(
        title = "Rain",
        icon = R.drawable.rain,
        audioSource = R.raw.nature_rain,
        type = "Nature",
        firstInType = true
    )

    data object SummerNight : CardItems(
        title = "Summer night",
        icon = R.drawable.moon,
        audioSource = R.raw.nature_summernight,
        type = "Nature"
    )

    data object Wind : CardItems(
        title = "Wind",
        icon = R.drawable.wind,
        audioSource = R.raw.nature_wind,
        type = "Nature"
    )

    data object Wave : CardItems(
        title = "Waves",
        icon = R.drawable.wave,
        audioSource = R.raw.nature_waves,
        type = "Nature"
    )

    data object Stream : CardItems(
        title = "Stream",
        icon = R.drawable.stream,
        audioSource = R.raw.nature_stream,
        type = "Nature"
    )

    data object Storm : CardItems(
        title = "Storm",
        icon = R.drawable.storm,
        audioSource = R.raw.nature_storm,
        type = "Nature"
    )

    data object Birds : CardItems(
        title = "Birds",
        icon = R.drawable.birds,
        audioSource = R.raw.nature_birds,
        type = "Nature"
    )

    /*
    Travel
     */

    data object Train : CardItems(
        title = "Train",
        icon = R.drawable.train,
        audioSource = R.raw.travel_train,
        type = "Travel",
        firstInType = true
    )

    data object Boat : CardItems(
        title = "Boat",
        icon = R.drawable.sailboat,
        audioSource = R.raw.boat,
        type = "Travel"
    )

    data object City : CardItems(
        title = "City",
        icon = R.drawable.city,
        audioSource = R.raw.travel_city,
        type = "Travel"
    )


    /*
    Interiors
     */
    data object CoffeeShop : CardItems(
        title = "Coffee Shop",
        icon = R.drawable.coffee,
        audioSource = R.raw.interior_coffeeshop,
        type = "Interiors",
        firstInType = true
    )

    data object FirePlace : CardItems(
        title = "Fireplace",
        icon = R.drawable.fireplace,
        audioSource = R.raw.interior_fireplace,
        type = "Interiors"
    )

    data object BusyRestaurant : CardItems(
        title = "Busy Restaurant",
        icon = R.drawable.food_delivery,
        audioSource = R.raw.busy_restaurant,
        type = "Interiors"
    )


    /*
    Noise
     */
    data object PinkNoise : CardItems(
        title = "Pink Noise",
        icon = R.drawable.pink_noise,
        audioSource = R.raw.noise_pink_noise,
        type = "Noise",
        firstInType = true
    )

    data object WhiteNoise : CardItems(
        title = "White Noise",
        icon = R.drawable.white_noise,
        audioSource = R.raw.noise_white_noise,
        type = "Noise"
    )

    /*
    custom
     */
    data object Custom : CardItems(
        title = "",
        icon = R.drawable.white_noise,
        audioSource = R.raw.noise_white_noise,
        type = "Custom"
    )
}


sealed class DrawerItems(
    val title: String,
    val icon: ImageVector,
    val route : String = ""
) {
    data object Home : DrawerItems(
        title = "Home",
        icon = Icons.Default.Home,
        route = Routes.Home.name
    )

    data object SourceCode : DrawerItems(
        title = "Source code",
        icon = Icons.Filled.Build
    )

    data object About : DrawerItems(
        title = "About",
        icon = Icons.Default.Info,
        route = Routes.AboutUs.name
    )

    data object RequestFeature : DrawerItems(
        title = "Request feature",
        icon = Icons.Default.MailOutline
    )

    data object Quit : DrawerItems(
        title = "Quit",
        icon = Icons.Default.ExitToApp
    )

    data object Settings : DrawerItems(
        title = "Settings",
        icon = Icons.Default.Settings,
        route = Routes.Settings.name
    )


}




