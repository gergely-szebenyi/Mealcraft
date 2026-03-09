package com.prekogdevs.mealcraft.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.prekogdevs.mealcraft.presentation.theme.MealCraftTheme

@Composable
fun AppScreen(
    screenContent : @Composable () -> Unit
) {
    MealCraftTheme(
        content = {
            Scaffold { paddingValues ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MealCraftTheme.colors.background)
                        .padding(paddingValues = paddingValues)
                        .padding(horizontal = MealCraftTheme.spacing.space16)
                ) {
                    screenContent()
                }
            }
        }
    )
}