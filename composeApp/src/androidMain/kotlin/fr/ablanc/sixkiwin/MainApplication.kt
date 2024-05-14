package fr.ablanc.sixkiwin

import android.app.Application
import data.di.setupKoin
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.FirebaseApp
import dev.gitlive.firebase.initialize

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //stopKoin()
        setupKoin()
      //  this.androidContext(this)
    }
}