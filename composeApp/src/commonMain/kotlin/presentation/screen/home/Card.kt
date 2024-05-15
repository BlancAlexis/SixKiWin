package presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun defaultCardView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.fillMaxSize(0.95f).fillMaxHeight(0.5f),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(Color.Red)
        ) {
            Row {
                Text("1800 points", fontSize = 23.sp)
                Text("Blanc Alexis", modifier = Modifier.padding(start = 20.dp))
            }


        }
    }
}

@Composable
fun previewCardView() {
    defaultCardView()
}