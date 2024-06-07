package com.pronaycoding.blanket_mobile.ui.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.saveable
import com.pronaycoding.blanket_mobile.R
import com.pronaycoding.blanket_mobile.nav.Routes
import com.pronaycoding.blanket_mobile.ui.theme.styles.BlanketTopBar
import com.pronaycoding.blanket_mobile.ui.theme.styles.PrettyCardView
import com.pronaycoding.blanket_mobile.ui.theme.styles.TitleCardView
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


//@HiltViewModel
class BlanketViewModel(
//    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _homeUiState =
        MutableStateFlow<HomeUiState>(HomeUiState.Initial)
    val homeUiState: StateFlow<HomeUiState> get() = _homeUiState
    fun setLoading (){
        _homeUiState.value = HomeUiState.Loading
    }
    fun setInitial(){
        _homeUiState.value = HomeUiState.Initial
    }

//    fun initializePlayer
//    var playOrPause by savedStateHandle.saveable { mutableStateOf(true) }

//    var initializePlayer =
    val songList = mutableListOf(
        R.raw.nature_rain,
        R.raw.nature_summernight,
        R.raw.nature_wind,
        R.raw.nature_waves,
        R.raw.nature_stream,
        R.raw.nature_storm,
        R.raw.nature_birds,
        R.raw.travel_train,
        R.drawable.sailboat,
        R.raw.travel_city,
        R.raw.interior_coffeeshop,
        R.raw.interior_fireplace,
        R.raw.busy_restaurant,
        R.raw.noise_pink_noise,
        R.raw.noise_white_noise,
        R.raw.noise_white_noise,
    )
    fun getSongs() : List<Int>{
        return listOf(

        )
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




