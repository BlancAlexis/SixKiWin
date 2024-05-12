package presentation.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import presentation.util.OutlinedSpinner

@Composable
fun LoginScreen(viewModel: LoginViewModel, content: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedSpinner(
            modifier = Modifier.fillMaxWidth(0.7f),
            listMaintenanceName = listOf("Julien", "Emilien", "Alexis"),
            textLabel = "Qui êtes vous ?"
        )
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
    }

}
