package presentation.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
        if (uiState.listUser.isNotEmpty()) {
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
        ) {

        }
        FloatingActionButton(
            modifier = Modifier.fillMaxWidth(0.2f).align(Alignment.End).padding(bottom = 20.dp),
            onClick = {  }
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add something")  // You can customize the icon here
        }
    }

}
