package com.prekogdevs.mealcraft.presentation.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prekogdevs.mealcraft.R
import com.prekogdevs.mealcraft.presentation.theme.MealCraftTheme

@Composable
fun PhotoUploadArea(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val borderColor = MealCraftTheme.colors.dashedBorder
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val cornerPx = 12.dp.toPx()
            drawRoundRect(
                color = borderColor,
                size = size,
                cornerRadius = CornerRadius(cornerPx),
                style = Stroke(
                    width = 2f,
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 8f)),
                ),
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier.size(36.dp),
                imageVector = Icons.Outlined.AddCircle,
                contentDescription = stringResource(R.string.Label_VO_Camera),
                tint = MealCraftTheme.colors.textTertiary,
            )
            Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space10))
            Text(
                text = stringResource(R.string.Label_Upload_Image),
                style = MealCraftTheme.typography.bodySmall,
                color = MealCraftTheme.colors.textSecondary,
            )
        }
    }
}