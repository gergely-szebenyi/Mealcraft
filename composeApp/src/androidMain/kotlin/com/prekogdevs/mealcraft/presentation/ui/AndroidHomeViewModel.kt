package com.prekogdevs.mealcraft.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prekogdevs.mealcraft.presentation.HomeViewModel

class AndroidHomeViewModel : ViewModel() {
    val shared = HomeViewModel(scope = viewModelScope)
}
