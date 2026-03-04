package com.prekogdevs.mealcraft.presentation.theme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class MealCraftShapes(
    /** Input fields, small buttons */
    val small: RoundedCornerShape,
    /** Cards, dialogs */
    val medium: RoundedCornerShape,
    /** Bottom sheets, modals */
    val large: RoundedCornerShape,
)

val DefaultShapes = MealCraftShapes(
    small  = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(12.dp),
    large  = RoundedCornerShape(16.dp),
)

val LocalMealCraftShapes = staticCompositionLocalOf { DefaultShapes }