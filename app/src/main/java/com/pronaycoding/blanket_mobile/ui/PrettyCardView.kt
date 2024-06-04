//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.unit.dp
//import java.lang.reflect.Modifier
//
//@Composable
//fun PrettyTabs(
//    selectedTab: String, // "Sounds" or "Extra"
//    onTabClick: (String) -> Unit // Callback for tab clicks
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(MaterialTheme.colors.background),
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//        PrettyTab(
//            text = "Sounds",
//            isSelected = selectedTab == "Sounds",
//            onClick = { onTabClick("Sounds") }
//        )
//        PrettyTab(
//            text = "Extra",
//            isSelected = selectedTab == "Extra",
//            onClick = { onTabClick("Extra") }
//        )
//    }
//}
//
//@Composable
//fun PrettyTab(
//    text: String,
//    isSelected: Boolean,
//    onClick: () -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .clip(RoundedCornerShape(16.dp))
//            .clickable(onClick = onClick)
//            .background(
//                color = if (isSelected) MaterialTheme.colors.primary else Color.LightGray,
//                shape = RoundedCornerShape(16.dp)
//            )
//            .padding(vertical = 8.dp, horizontal = 16.dp)
//    ) {
//        Text(
//            text = text,
//            style = MaterialTheme.typography.bodyLarge,
//            color = if (isSelected) Color.White else Color.Black
//        )
//    }
//}