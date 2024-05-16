package com.pronaycoding.blanket_mobile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.saveable


//@HiltViewModel
class BlanketViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var setMusicValue by savedStateHandle.saveable { mutableStateOf(true) }

    fun getCardList() : List<CardItems>{
        return listOf(
            CardItems.wind,
            CardItems.thunder,
            CardItems.mountainSpring,
            CardItems.springBirds,
            CardItems.busyRestaurant
            )
    }

}

sealed class CardItems(
    var title : String,
    var icon : Int,
    val audioSource : Int,
    val type : String = "",
    var isPlaying : Boolean = false,
){
    data object wind : CardItems(
        title = "Wind",
        icon = R.drawable.wind,
        audioSource = R.raw.wind_sound,
        type = "Nature"
//        isPlaying = false,
        )


    data object springBirds : CardItems(
        title = "Spring Birds",
        icon = R.drawable.dove,
        audioSource = R.raw.springbirds,
        type = "Nature"
//        isPlaying = false,
    )
    data object mountainSpring : CardItems(
        title = "Mountain Spring",
        icon = R.drawable.hot_spring,
        audioSource = R.raw.mountain_spring,
        type = "Nature"
//        isPlaying = false,
    )

    data object busyRestaurant : CardItems(
        title = "Busy Restaurant",
        icon = R.drawable.food_delivery,
        audioSource = R.raw.busy_restaurant,
        type = "Interiors"
//        isPlaying = false,
    )

    data object thunder : CardItems(
        title = "Thunder",
        icon = R.drawable.thunder,
        audioSource = R.raw.loudthunder,
        type = "Nature"
//        isPlaying = false,
    )
}