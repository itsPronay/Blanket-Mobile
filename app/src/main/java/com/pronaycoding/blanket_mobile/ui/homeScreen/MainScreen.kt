package com.pronaycoding.blanket_mobile.ui.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.pronaycoding.blanket_mobile.ui.theme.styles.BlanketTopBar
import com.pronaycoding.blanket_mobile.ui.theme.styles.PrettyCardView
import com.pronaycoding.blanket_mobile.ui.theme.styles.TitleCardView

@Composable
@Preview(showSystemUi = true)
fun PreviewScreen(
    viewModel: BlanketViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {


    Dashboard(
        cardLists = viewModel.getCardList(),
        drawerItems = viewModel.getDrawerItems(),
        navigateTo = {},
//        audioPlayer = null
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(
    cardLists: List<CardItems>,
    drawerItems: List<DrawerItems>,
    navigateTo: (route: String) -> Unit,
//    audioPlayer: ExoPlayer?,

) {

    var scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BlanketTopBar(scrollBehavior)
        }
    ) {

//        LinearProgressIndicator()

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
                            cardItem = cardItem,
//                            playerq = audioPlayer
                        )
                    }
                }


            }
        }


    }

}





