import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import moe.tlaster.precompose.PreComposeApp
import org.koin.compose.KoinContext
import presentation.Nav


@Composable
fun App() {
    PreComposeApp {
        KoinContext {

            SixKiWinTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Nav()
                }
            }
        }
    }

}

private val LightColorsScheme = lightColorScheme(
    primary = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    onPrimary = Color.White,
    error = Color.Blue,
)

private val DarkColorsScheme = darkColorScheme(
    primary = Color.White,
    surface = Color.Black,
    onSurface = Color.White,
    onPrimary = Color.Black,
    error = Color.LightGray,
)


@Composable
fun SixKiWinTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme = if (isSystemInDarkTheme()) {
            DarkColorsScheme
        } else {
            LightColorsScheme
        },
        shapes = Shapes(
            small = RoundedCornerShape(8.dp),
            medium = RoundedCornerShape(12.dp),
            large = RoundedCornerShape(16.dp)
        )
    ) {
        content()
    }
}