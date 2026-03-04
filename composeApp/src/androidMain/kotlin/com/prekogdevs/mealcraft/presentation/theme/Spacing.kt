package com.prekogdevs.mealcraft.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class MealCraftSpacing(
    val space2: Dp,
    val space4: Dp,
    val space6: Dp,
    val space8: Dp,
    val space10: Dp,
    val space12: Dp,
    val space16: Dp,
    val space20: Dp,
    val space24: Dp,
    val space32: Dp
)

val DefaultSpacing = MealCraftSpacing(
    space2  = 2.dp,
    space4  = 4.dp,
    space6  = 6.dp,
    space8  = 8.dp,
    space10 = 10.dp,
    space12 = 12.dp,
    space16 = 16.dp,
    space20 = 20.dp,
    space24 = 24.dp,
    space32 = 32.dp,
)

val LocalMealCraftSpacing = staticCompositionLocalOf { DefaultSpacing }