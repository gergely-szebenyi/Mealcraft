package com.prekogdevs.mealcraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.prekogdevs.mealcraft.di.androidModule
import com.prekogdevs.mealcraft.di.sharedModule
import com.prekogdevs.mealcraft.presentation.ui.HomeScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(sharedModule, androidModule)
        }

        setContent {
            HomeScreen()
        }
    }
}