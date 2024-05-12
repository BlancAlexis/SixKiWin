package data.di

import org.koin.dsl.module
import presentation.screen.StartGameViewModel
import presentation.screen.home.HomeViewModel
import presentation.screen.login.LoginViewModel

val vmModule = module {
    factory { LoginViewModel() }
    factory { HomeViewModel() }
    factory { StartGameViewModel() }
}