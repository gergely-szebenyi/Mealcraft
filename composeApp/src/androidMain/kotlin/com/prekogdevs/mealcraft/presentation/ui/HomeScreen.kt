package com.prekogdevs.mealcraft.presentation.ui

import android.Manifest
import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prekogdevs.mealcraft.domain.IngredientUnit
import com.prekogdevs.mealcraft.presentation.theme.MealCraftTheme
import com.prekogdevs.mealcraft.presentation.ui.components.AppScreen
import com.prekogdevs.mealcraft.presentation.ui.components.HeaderSection
import com.prekogdevs.mealcraft.presentation.ui.components.ManualEntrySection
import com.prekogdevs.mealcraft.presentation.ui.components.PhotoIngredientsSection
import org.koin.androidx.compose.koinViewModel
import java.io.File

// Create the URI (location) for the image we will take with the camera.
private fun createImageUri(context: Context): Uri {
    val cacheDir = File(context.cacheDir, "camera").also { it.mkdirs() }
    val file = File(cacheDir, "photo_${System.currentTimeMillis()}.jpg")
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
}

@Composable
fun HomeScreen(viewModel: AndroidHomeViewModel = koinViewModel()) {
    val state by viewModel.shared.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { result ->
            viewModel.shared.onImageCaptured(result)
        }
    )

    // TODO: Handle permission rationale / declined permissions / open settings
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            if (granted) {
                val uri = createImageUri(context)
                viewModel.shared.onPendingImageUri(uri.toString())
                // uri for camera app: "here's an address, put the photo there"
                // The camera writes the photo bytes into the URI
                cameraLauncher.launch(uri)
            }
        }
    )
    AppScreen {
        HomeScreenContent(
            capturedImageUri = state.capturedImageUri,
            onUploadClick = {
                permissionLauncher.launch(Manifest.permission.CAMERA)
            }
        )
    }
}

@Composable
private fun HomeScreenContent(
    capturedImageUri: String?,
    onUploadClick: () -> Unit
) {
    Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space16))
    HeaderSection(
        onWeeklyMenuClick = { /* open weekly menu screen */ }
    )
    Spacer(modifier = Modifier.height(MealCraftTheme.spacing.space24))
    PhotoIngredientsSection(
        capturedImageUri = capturedImageUri,
        onUploadClick = onUploadClick,
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
    HomeScreenContent(
        capturedImageUri = null,
        onUploadClick = {}
    )
}