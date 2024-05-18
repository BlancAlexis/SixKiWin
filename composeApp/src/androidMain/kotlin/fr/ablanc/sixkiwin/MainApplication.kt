package fr.ablanc.sixkiwin

import android.app.Application
import com.google.firebase.FirebaseApp
import data.di.setupKoin
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        setupKoin()
    }
}