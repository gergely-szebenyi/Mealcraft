package com.prekogdevs.mealcraft.di

import com.prekogdevs.mealcraft.presentation.ui.AndroidHomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { AndroidHomeViewModel() }
}
