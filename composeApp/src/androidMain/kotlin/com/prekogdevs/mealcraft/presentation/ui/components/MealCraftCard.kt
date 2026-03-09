package com.prekogdevs.mealcraft.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prekogdevs.mealcraft.presentation.theme.MealCraftTheme

@Composable
fun MealCraftCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MealCraftTheme.shapes.large,
        color = MealCraftTheme.colors.surface,
        border = BorderStroke(1.dp, MealCraftTheme.colors.surfaceBorder),
    ) {
        Column(modifier = Modifier.padding(MealCraftTheme.spacing.space20)) {
            Text(
                text = title,
                style = MealCraftTheme.typography.titleMedium,
                color = MealCraftTheme.colors.textPrimary,
            )
            Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space4))
            Text(
                text = subtitle,
                style = MealCraftTheme.typography.bodySmall,
                color = MealCraftTheme.colors.textSecondary,
            )
            Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space20))
            content()
        }
    }
}