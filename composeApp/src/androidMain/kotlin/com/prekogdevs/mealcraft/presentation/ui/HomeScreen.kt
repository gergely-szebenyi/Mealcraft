package com.prekogdevs.mealcraft.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.prekogdevs.mealcraft.presentation.ui.components.AppScreen
import com.prekogdevs.mealcraft.presentation.ui.components.HeaderSection

@Composable
fun HomeScreen() {
    AppScreen {
        HeaderSection(
            onWeeklyMenuClick = {

            }
        )
    }
}

@Composable
@Preview
private fun HomeScreenPreview() {
    HomeScreen()
}