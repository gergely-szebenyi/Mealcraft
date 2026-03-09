package com.prekogdevs.mealcraft.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prekogdevs.mealcraft.domain.IngredientUnit
import com.prekogdevs.mealcraft.presentation.theme.MealCraftTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)
@Composable
fun IngredientInput(
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
    onAddClick: () -> Unit,
) {
    val inputColors = TextFieldDefaults.colors(
        focusedContainerColor   = MealCraftTheme.colors.inputBackground,
        unfocusedContainerColor = MealCraftTheme.colors.inputBackground,
        focusedIndicatorColor   = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(MealCraftTheme.spacing.space10),
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Ingredient\nName",
                style = MealCraftTheme.typography.labelSmall,
                color = MealCraftTheme.colors.textPrimary,
            )
            Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space6))
            TextField(
                value = ingredientName,
                onValueChange = onNameChanged,
                modifier = Modifier.fillMaxWidth().height(48.dp),
                colors = inputColors,
                shape = MealCraftTheme.shapes.small,
                singleLine = true,
                textStyle = MealCraftTheme.typography.input,
            )
        }

        // ── Amount ─────────────────────────────────────────────────────────
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Amount",
                style = MealCraftTheme.typography.labelSmall,
                color = MealCraftTheme.colors.textPrimary,
            )
            Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space6))
            TextField(
                value = amount,
                onValueChange = onAmountChanged,
                modifier = Modifier.fillMaxWidth().height(48.dp),
                colors = inputColors,
                shape = MealCraftTheme.shapes.small,
                singleLine = true,
                textStyle = MealCraftTheme.typography.input,
            )
        }

        // ── Unit Dropdown ──────────────────────────────────────────────────
        Column(modifier = Modifier.weight(0.8f)) {
            Text(
                text = "Unit",
                style = MealCraftTheme.typography.labelSmall,
                color = MealCraftTheme.colors.textPrimary,
            )
            Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space6))

            ExposedDropdownMenuBox(
                expanded = isUnitExpanded,
                onExpandedChange = { onUnitDropdownToggle() },
            ) {
                TextField(
                    value = selectedUnit.label,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .height(48.dp),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isUnitExpanded)
                    },
                    colors = inputColors,
                    shape = MealCraftTheme.shapes.small,
                    singleLine = true,
                    textStyle = MealCraftTheme.typography.input,
                )

                ExposedDropdownMenu(
                    expanded = isUnitExpanded,
                    onDismissRequest = onUnitDropdownDismiss,
                ) {
                    IngredientUnit.entries.forEach { unit ->
                        DropdownMenuItem(
                            text = { Text(unit.label) },
                            onClick = { onUnitSelected(unit) },
                        )
                    }
                }
            }
        }

        Surface(
            modifier = Modifier.size(48.dp),
            shape = MealCraftTheme.shapes.medium,
            color = MealCraftTheme.colors.buttonBackground,
            onClick = onAddClick,
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Add ingredient",
                    tint = MealCraftTheme.colors.buttonForeground,
                    modifier = Modifier.size(22.dp),
                )
            }
        }
    }
}
