package com.prekogdevs.mealcraft.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.prekogdevs.mealcraft.R
import com.prekogdevs.mealcraft.domain.IngredientUnit

@Composable
fun ManualEntrySection(
    modifier: Modifier = Modifier,
    ingredientName: String,
    amount: String,
    selectedUnit: IngredientUnit,
    isUnitExpanded: Boolean,
    onNameChanged: (String) -> Unit,
    onAmountChanged: (String) -> Unit,
    onUnitSelected: (IngredientUnit) -> Unit,
    onUnitDropdownToggle: () -> Unit,
    onUnitDropdownDismiss: () -> Unit,
    onAddClick: () -> Unit
) {
    MealCraftCard(
        modifier = modifier,
        title = stringResource(R.string.Label_Add_Manually),
        subtitle = stringResource(R.string.Label_Enter_Ingredients_Manually),
    ) {
        IngredientInput(
            ingredientName        = ingredientName,
            amount                = amount,
            selectedUnit          = selectedUnit,
            isUnitExpanded        = isUnitExpanded,
            onNameChanged         = onNameChanged,
            onAmountChanged       = onAmountChanged,
            onUnitSelected        = onUnitSelected,
            onUnitDropdownToggle  = onUnitDropdownToggle,
            onUnitDropdownDismiss = onUnitDropdownDismiss,
            onAddClick            = onAddClick,
        )
    }
}