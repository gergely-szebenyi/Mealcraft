package com.prekogdevs.mealcraft.domain

/**
 * Represents a single ingredient entered by the user.
 */
data class Ingredient(
    val id: Long = 0,
    val name: String = "",
    val amount: String = "",
    val unit: IngredientUnit = IngredientUnit.GRAM,
)