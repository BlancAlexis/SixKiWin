package presentation.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(viewModel: HomeViewModel, function: () -> Unit) {
    //val loginUserUiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Row {
            DropdownMenu(
                expanded = false,
                onDismissRequest = {
                }
            ) {
                for (text in sort.values()) {
                    DropdownMenuItem(
                        text = { Text(text = text.name) },
                        onClick = {
                        }
                    )
                }
            }
            Button(
                onClick = {
                    function()
                }
            ) {
                Text(text = "Nouvelle partie")
            }
        }
        LazyColumn {
            items(1_000) {
                Row(
                    modifier = Modifier.padding(8.dp)
                ) {
                    defaultCardView()
                }
            }
        }
    }
}

enum class sort {
    DEBUT, MOIS, SEMAINE, JOUR

}