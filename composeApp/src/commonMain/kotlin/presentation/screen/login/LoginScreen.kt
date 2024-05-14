package presentation.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import presentation.util.OutlinedSpinner

@Composable
fun LoginScreen(viewModel: LoginViewModel, content: () -> Unit) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(uiState.listUser.isNotEmpty()){
            OutlinedSpinner(
                modifier = Modifier.fillMaxWidth(0.7f),
                listMaintenanceName = uiState.listUser,
                textLabel = "Qui êtes vous ?"
            )
        }
        BasicTextField(
            onValueChange = {},
            value = "d"
        )
        Button(
            modifier = Modifier.fillMaxWidth(0.7f),
            onClick = { content() }
        ) {
            Text("d")
        }
        Button(
            onClick = {
            }
        ){

        }
    }

}
