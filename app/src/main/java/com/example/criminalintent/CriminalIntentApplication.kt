package com.example.izotov_criminalintent

import android.app.Application
import com.example.izotov_criminalintent.database.CrimeRepository

class CriminalIntentApplication : Application()
{
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}