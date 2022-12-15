package com.jordroid.android.cloud2021.architecture

import android.app.Application
import androidx.room.Room

// This class allow to modify Application configuration before load the firsdt activity
class CustomApplication : Application() {

    // Create unique instance of this class
    companion object {
        lateinit var instance: CustomApplication
    }

    // Create an instance of the application database
    val mApplicationDatabase: CustomRoomDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            CustomRoomDatabase::class.java,
            "MyDatabaseName"
        ).fallbackToDestructiveMigration().build()
    }

    // When application goes to onCreate, this means we can set the instance
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
