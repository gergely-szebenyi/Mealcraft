package com.prekogdevs.mealcraft.presentation.ui.components

import androidx.compose.ui.res.stringResource
import com.prekogdevs.mealcraft.R
import com.prekogdevs.mealcraft.presentation.theme.MealCraftTheme
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier,
    onWeeklyMenuClick: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.app_logo),
                    contentDescription = stringResource(R.string.Label_VO_App_Logo),
                    tint = MealCraftTheme.colors.brand
                )
                Spacer(modifier = Modifier.width(MealCraftTheme.spacing.space8))
                Text(
                    text = stringResource(R.string.app_name),
                    style = MealCraftTheme.typography.displayLarge,
                    color = MealCraftTheme.colors.textPrimary
                )
                Spacer(modifier = Modifier.weight(1f))
                WeeklyMenu(onWeeklyMenuClick = onWeeklyMenuClick)
            }
            Text(
                text = stringResource(R.string.Label_Header_Title),
                style = MealCraftTheme.typography.bodyMedium,
                color = MealCraftTheme.colors.textSecondary
            )
        }
    }
}

@Composable
private fun WeeklyMenu(
    onWeeklyMenuClick: () -> Unit
) {
    Surface(
        shape = MealCraftTheme.shapes.medium,
        border = BorderStroke(1.dp, MealCraftTheme.colors.surfaceBorder),
        color = MealCraftTheme.colors.surface,
        onClick = onWeeklyMenuClick
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = MealCraftTheme.spacing.space12,
                vertical = MealCraftTheme.spacing.space10
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MealCraftTheme.spacing.space6)
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = Icons.Outlined.DateRange,
                contentDescription = null,
                tint = MealCraftTheme.colors.textPrimary
            )
            Text(
                text = stringResource(R.string.Label_Weekly_Menu),
                style = MealCraftTheme.typography.labelMedium,
                color = MealCraftTheme.colors.textPrimary
            )
        }
    }
}

@Preview
@Composable
private fun HeaderSectionPreview() {
    MealCraftTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MealCraftTheme.colors.background)
        ) {
            HeaderSection(
                onWeeklyMenuClick = {

                }
            )
        }
    }
}