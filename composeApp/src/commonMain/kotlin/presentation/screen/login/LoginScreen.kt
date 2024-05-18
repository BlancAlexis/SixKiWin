package presentation.screen.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import presentation.util.OutlinedSpinner

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel, content: (StartEvent) -> Unit = {}, next : () -> Unit ) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.fillMaxHeight(0.5f)) {
            Text("Connexion")
            if (uiState.listUser.isNotEmpty()) {
                OutlinedSpinner(
                    modifier = Modifier.fillMaxWidth(0.7f),
                    listMaintenanceName = uiState.listUser,
                    textLabel = "Qui êtes vous ?",
                    onItemSelect = {
                                   next()
                    },
                )
            } else {
                Text("Pas d'utilisateur")
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxHeight(0.5f).fillMaxWidth(1f).background(Color.Red)
        ) {
            Text("Inscription")
            Spacer(modifier = Modifier.fillMaxHeight(0.2f))
            BasicTextField2(
                state = uiState.textFieldState
            )
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            Button(
                modifier = Modifier.fillMaxWidth(0.6f),
                onClick = { content(StartEvent.create) }
            ) {
                Text("Ajout")
            }
        }
    }


}
