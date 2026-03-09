package com.prekogdevs.mealcraft.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prekogdevs.mealcraft.domain.IngredientUnit
import com.prekogdevs.mealcraft.presentation.theme.MealCraftTheme
import com.prekogdevs.mealcraft.presentation.ui.components.AppScreen
import com.prekogdevs.mealcraft.presentation.ui.components.HeaderSection
import com.prekogdevs.mealcraft.presentation.ui.components.ManualEntrySection
import com.prekogdevs.mealcraft.presentation.ui.components.PhotoIngredientsSection

@Composable
fun HomeScreen() {
    AppScreen {
        HomeScreenContent()
    }
}

@Composable
private fun HomeScreenContent() {
    Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space16))
    HeaderSection(
        onWeeklyMenuClick = { /* open weekly menu screen */ }
    )
    Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space24))
    PhotoIngredientsSection(
        onUploadClick = { /* launch photo picker */ },
    )
    Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space16))

    // TODO
    ManualEntrySection(
        ingredientName        = "ingredientName",
        amount                = "currentAmount",
        selectedUnit          = IngredientUnit.GRAM,
        isUnitExpanded        = false,
        onNameChanged         = {  },
        onAmountChanged       = {  },
        onUnitSelected        = {  },
        onUnitDropdownToggle  = {  },
        onUnitDropdownDismiss = {  },
        onAddClick            = {  }
    )

    Spacer(modifier = Modifier.height(80.dp))
}

@Composable
@Preview
private fun HomeScreenPreview() {
    HomeScreen()
}