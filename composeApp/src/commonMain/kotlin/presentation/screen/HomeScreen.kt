package presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.viewmodel.HomeViewModel


class HomeScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<HomeViewModel>()
        val loginUserUiState by viewModel.uiState.collectAsState()

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(title = { Text("home") })
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Icon"
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                Row {
                    DropdownMenu(
                        expanded = false,
                        onDismissRequest = { /*TODO*/ }
                    ) {
                        for (text in sort.values()) {
                            DropdownMenuItem(
                                text = { Text(text = text.name) },
                                onClick = { /*TODO*/ }
                            )
                        }
                    }
                        Button(
                            onClick = {

                            }
                        ) {
                            Text(text = "Nouvelle partie")
                        }
                    }
                    LazyColumn {
                        items(loginUserUiState.list.size) {
                            Row(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(text = "Item ${loginUserUiState.list[it]}", fontSize = 20.sp)
                            }
                        }
                    }
                }
            }
        }
    }
enum class sort{
    DEBUT,MOIS,SEMAINE,JOUR
}