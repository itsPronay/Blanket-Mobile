package com.pronaycoding.blanket_mobile

import androidx.lifecycle.ViewModel

class Viewmodel: ViewModel() {
    fun getCardList() : List<CardItems>{
        return listOf(
            CardItems.wind,
            CardItems.busyRestaurant,
            CardItems.springBirds
        )
    }

}

sealed class CardItems(
    var title : String,
    var icon : Int,
    val audioSource : Int,
    var isPlaying : Boolean = false,
){
    data object wind : CardItems(
        title = "Wind",
        icon = R.drawable.wind,
        audioSource = R.raw.wind_sound,
        isPlaying = false,
        )
    data object busyRestaurant : CardItems(
        title = "Busy Restaurant",
        icon = R.drawable.food_delivery,
        audioSource = R.raw.busy_restaurant,
        isPlaying = false,
    )
    data object springBirds : CardItems(
        title = "Spring Birds",
        icon = R.drawable.dove,
        audioSource = R.raw.springbirds,
        isPlaying = false,
    )




}