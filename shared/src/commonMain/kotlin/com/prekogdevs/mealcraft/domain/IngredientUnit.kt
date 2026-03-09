package com.prekogdevs.mealcraft.domain

enum class IngredientUnit(val label: String) {
    GRAM("g"),
    KILOGRAM("kg"),
    MILLILITER("ml"),
    LITER("l"),
    CUP("cup"),
    TABLESPOON("tbsp"),
    TEASPOON("tsp"),
    PIECE("pcs");

    companion object {
        fun fromLabel(label: String): IngredientUnit =
            entries.firstOrNull { it.label == label } ?: GRAM
    }
}