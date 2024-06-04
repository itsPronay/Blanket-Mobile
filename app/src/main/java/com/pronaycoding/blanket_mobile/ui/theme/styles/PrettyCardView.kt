package com.pronaycoding.blanket_mobile.ui.theme.styles

//import androidx.compose.foundation.layout.ColumnScopeInstance.align
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pronaycoding.blanket_mobile.ui.homeScreen.BlanketViewModel
import com.pronaycoding.blanket_mobile.ui.homeScreen.CardItems
import com.pronaycoding.blanket_mobile.ui.theme.BlanketmobileTheme

@Composable
fun PrettyCardView(
    cardItem: CardItems
) {
    var sliderValue by rememberSaveable {
        mutableStateOf(0F)
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
                    painter = painterResource(id = cardItem.icon),
                    contentDescription = "Icon",
                    modifier = Modifier.size(32.dp),
//                    tint = MaterialTheme.colorScheme.inverseOnSurface
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
                onValueChange = { sliderValue = it },
                valueRange = 0f..1f,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(20.dp)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewCard(modifier: Modifier = Modifier) {
    val viewmodel: BlanketViewModel = viewModel()
    var list = viewmodel.getCardList()

    BlanketmobileTheme {
        PrettyCardView(cardItem = list.get(3))
    }
}

