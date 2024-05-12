package fr.ablanc.sixkiwin

import android.app.Application
import data.di.setupKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        //stopKoin()
        setupKoin()
      //  this.androidContext(this)
    }
}