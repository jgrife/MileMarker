package com.example.core.presentation.designsystem

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = MileMarkerGreen,
    background = MileMarkerBlack,
    surface = MileMarkerDarkGray,
    secondary = MileMarkerWhite,
    tertiary = MileMarkerWhite,
    primaryContainer = MileMarkerGreen30,
    onPrimary = MileMarkerBlack,
    onBackground = MileMarkerWhite,
    onSurface = MileMarkerWhite,
    onSurfaceVariant = MileMarkerGray
)

@Composable
fun MileMarkerTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}