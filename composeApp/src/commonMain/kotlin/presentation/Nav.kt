package presentation

import androidx.compose.runtime.Composable
import moe.tlaster.precompose.koin.koinViewModel
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import presentation.screen.home.HomeScreen
import presentation.screen.login.LoginScreen
import presentation.screen.StartGameScreen
import presentation.screen.StartGameViewModel
import presentation.screen.home.HomeViewModel
import presentation.screen.login.LoginViewModel

@Composable
fun Nav() {
    val navigator = rememberNavigator()
    NavHost(
        initialRoute = "/login",
        navigator = navigator,
        navTransition = NavTransition()
    ) {
        scene(
            navTransition = NavTransition(),
            route = Route.LOGIN.path
        ) {
            val viewModel = koinViewModel(LoginViewModel::class)
            LoginScreen(viewModel) {
                navigator.navigate(Route.HOME.path)
                // Route de transition a faire
            }
        }
        scene(
            navTransition = NavTransition(),
            route = Route.HOME.path
        ) {
            val viewModel = koinViewModel(HomeViewModel::class)
            HomeScreen(viewModel) {
                navigator.navigate(Route.START.path)
                // Route de transition a faire
            }
        }
        scene(
            navTransition = NavTransition(),
            route = Route.START.path
        ) {
            val viewModel = koinViewModel(StartGameViewModel::class)
            StartGameScreen(viewModel)
        }
        scene(
            navTransition = NavTransition(),
            route = Route.RESULT_MANCHE.path
        ) {
            val viewModel = koinViewModel(HomeViewModel::class)
            HomeScreen(viewModel) {
                navigator.navigate(Route.LOGIN.path)
                // Route de transition a faire
            }
        }
    }
}

enum class Route(val path: String) {
    LOGIN("/login"),
    HOME("/home"),
    START("/start"),
    RESULT_MANCHE("/result_manche"),
}


