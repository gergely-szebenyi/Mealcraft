package com.prekogdevs.mealcraft.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// ── Typography Tokens ──────────────────────────────────────────────────────────
// For now we fall back to the platform default which is clean and readable.
// TODO: Find a suitable font.
val MealCraftFontFamily = FontFamily.Default

@Immutable
data class MealCraftTypography(
    /** App name / hero text – 28sp Bold */
    val displayLarge: TextStyle,
    /** Card titles – 18sp SemiBold */
    val titleMedium: TextStyle,
    /** Body / subtitle – 14sp Regular */
    val bodyMedium: TextStyle,
    /** Card descriptions – 13sp Regular */
    val bodySmall: TextStyle,
    /** Field labels – 12sp Medium */
    val labelSmall: TextStyle,
    /** Button / chip text – 13sp Medium */
    val labelMedium: TextStyle,
    /** Input field text – 14sp Regular */
    val input: TextStyle,
)

val DefaultTypography = MealCraftTypography(
    displayLarge = TextStyle(
        fontFamily = MealCraftFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize   = 28.sp,
        letterSpacing = (-0.5).sp,
    ),
    titleMedium = TextStyle(
        fontFamily = MealCraftFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize   = 18.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = MealCraftFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 14.sp,
        lineHeight = 20.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = MealCraftFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 13.sp,
        lineHeight = 19.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = MealCraftFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize   = 12.sp,
        lineHeight = 16.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = MealCraftFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize   = 13.sp,
    ),
    input = TextStyle(
        fontFamily = MealCraftFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize   = 14.sp,
    )
)

val LocalMealCraftTypography = staticCompositionLocalOf { DefaultTypography }