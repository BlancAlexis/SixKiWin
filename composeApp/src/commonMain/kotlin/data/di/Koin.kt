package data.di

import org.koin.core.context.startKoin


fun setupKoin() = startKoin {
    modules(firebaseModule)
    modules(dataModule)
    modules(vmModule)
}
