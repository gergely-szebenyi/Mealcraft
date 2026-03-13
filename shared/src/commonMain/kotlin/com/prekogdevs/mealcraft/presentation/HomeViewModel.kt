package com.prekogdevs.mealcraft.presentation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class UiState(
    val capturedImageUri: String? = null
)

class HomeViewModel(
    private val scope: CoroutineScope
) {
    private var pendingImageUri: String? = null

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    fun onPendingImageUri(uri: String) {
        pendingImageUri = uri
    }

    fun onImageCaptured(success: Boolean) {
        if (success && pendingImageUri != null) {
            _state.update { it.copy(capturedImageUri = pendingImageUri) }
        }
        pendingImageUri = null
    }
}
