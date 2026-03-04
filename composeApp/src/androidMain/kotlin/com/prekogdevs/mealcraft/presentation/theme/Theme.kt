package com.prekogdevs.mealcraft.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun MealCraftTheme(
    colors: MealCraftColorScheme     = LightColorScheme,
    typography: MealCraftTypography  = DefaultTypography,
    shapes: MealCraftShapes          = DefaultShapes,
    spacing: MealCraftSpacing        = DefaultSpacing,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalMealCraftColors     provides colors,
        LocalMealCraftTypography provides typography,
        LocalMealCraftShapes     provides shapes,
        LocalMealCraftSpacing    provides spacing,
    ) {
        // Wrap in MaterialTheme so M3 widgets (TextField, Surface…) inherit
        // reasonable defaults while we override visuals via our own tokens.
        MaterialTheme(content = content)
    }
}

/**
 * Convenience accessor so every composable can write:
 *
 *   MealCraftTheme.colors.brand
 *   MealCraftTheme.typography.titleMedium
 *   MealCraftTheme.shapes.large
 *   MealCraftTheme.spacing.xl
 */
object MealCraftTheme {
    val colors: MealCraftColorScheme
        @Composable @ReadOnlyComposable
        get() = LocalMealCraftColors.current

    val typography: MealCraftTypography
        @Composable @ReadOnlyComposable
        get() = LocalMealCraftTypography.current

    val shapes: MealCraftShapes
        @Composable @ReadOnlyComposable
        get() = LocalMealCraftShapes.current

    val spacing: MealCraftSpacing
        @Composable @ReadOnlyComposable
        get() = LocalMealCraftSpacing.current
}