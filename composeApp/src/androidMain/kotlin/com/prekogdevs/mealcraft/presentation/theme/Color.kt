package com.prekogdevs.mealcraft.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// ── Raw Color Tokens ───────────────────────────────────────────────────────────
object MealCraftColors {
    // Brand
    val Orange          = Color(0xFFE86A33)
    val OrangeLight     = Color(0xFFFFF0E8)

    // Neutrals
    val Dark            = Color(0xFF2D2D3A)
    val DarkSecondary   = Color(0xFF3E3E4E)
    val Gray            = Color(0xFF7A7A8E)
    val GrayLight       = Color(0xFF9E9CAE)
    val GrayLighter     = Color(0xFFCBC8C3)

    // Surfaces
    val Background      = Color(0xFFFAF8F5)
    val Surface         = Color(0xFFFFFFFF)
    val SurfaceBorder   = Color(0xFFF0EDE8)
    val InputBackground = Color(0xFFF5F3F0)

    // Accents
    val GreenTint       = Color(0xFFE8F5E9)

    // Utility
    val White           = Color(0xFFFFFFFF)
    val Transparent     = Color.Transparent
}

// ── Semantic Color Scheme ──────────────────────────────────────────────────────
@Immutable
data class MealCraftColorScheme(
    val brand: Color,
    val brandLight: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val background: Color,
    val surface: Color,
    val surfaceBorder: Color,
    val inputBackground: Color,
    val dashedBorder: Color,
    val buttonBackground: Color,
    val buttonForeground: Color,
    val gradientTint: Color,
)

val LightColorScheme = MealCraftColorScheme(
    brand            = MealCraftColors.Orange,
    brandLight       = MealCraftColors.OrangeLight,
    textPrimary      = MealCraftColors.Dark,
    textSecondary    = MealCraftColors.Gray,
    textTertiary     = MealCraftColors.GrayLight,
    background       = MealCraftColors.Background,
    surface          = MealCraftColors.Surface,
    surfaceBorder    = MealCraftColors.SurfaceBorder,
    inputBackground  = MealCraftColors.InputBackground,
    dashedBorder     = MealCraftColors.GrayLighter,
    buttonBackground = MealCraftColors.Dark,
    buttonForeground = MealCraftColors.White,
    gradientTint     = MealCraftColors.GreenTint,
)

// CompositionLocal so any composable can read `MealCraftTheme.colors`
val LocalMealCraftColors = staticCompositionLocalOf { LightColorScheme }