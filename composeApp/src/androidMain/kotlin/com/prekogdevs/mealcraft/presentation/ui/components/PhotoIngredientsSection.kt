package com.prekogdevs.mealcraft.presentation.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.prekogdevs.mealcraft.R

@Composable
fun PhotoIngredientsSection(
    modifier: Modifier = Modifier,
    capturedImageUri: String?,
    onUploadClick: () -> Unit
) {
    MealCraftCard(
        modifier = modifier,
        title = stringResource(R.string.Label_Photo_Your_Ingredients),
        subtitle = stringResource(R.string.Label_Photo_Your_Ingredients_Desc)
    ) {
        PhotoUploadArea(
            capturedImageUri = capturedImageUri,
            onClick = onUploadClick
        )
    }
}