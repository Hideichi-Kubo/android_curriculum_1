package com.example.yankeesroster.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.compose.*


private val LightColors = lightColorScheme(
    primary = primary_light,
    onPrimary = on_primary_light,
    primaryContainer = primary_container_light,
    onPrimaryContainer = on_primary_container_light,
    secondary = secondary_light,
    onSecondary = on_secondary_light,
    secondaryContainer = secondary_container_light,
    onSecondaryContainer = on_secondary_container_light,
    tertiary = tertiary_light,
    onTertiary = on_tertiary_light,
    tertiaryContainer = tertiary_container_light,
    onTertiaryContainer = on_tertiary_container_light,
    error = error_light,
    errorContainer = error_container_light,
    onError = on_error_light,
    onErrorContainer = on_error_container_light,
    background = background_light,
    onBackground = on_background_light,
    surface = surface_light,
    onSurface = on_surface_light,
    surfaceVariant = surface_variant_light,
    onSurfaceVariant = on_surface_variant_light,
    outline = outline_light,
    inverseOnSurface = inverse_on_surface_light,
    inverseSurface = inverse_surface_light,
    inversePrimary = inverse_primary_light,
    surfaceTint = primary_light, // 使用用途に合わせて適宜変更
    outlineVariant = outline_variant_light,
    scrim = scrim_light,
)

private val DarkColors = darkColorScheme(
    primary = primary_dark,
    onPrimary = on_primary_dark,
    primaryContainer = primary_container_dark,
    onPrimaryContainer = on_primary_container_dark,
    secondary = secondary_dark,
    onSecondary = on_secondary_dark,
    secondaryContainer = secondary_container_dark,
    onSecondaryContainer = on_secondary_container_dark,
    tertiary = tertiary_dark,
    onTertiary = on_tertiary_dark,
    tertiaryContainer = tertiary_container_dark,
    onTertiaryContainer = on_tertiary_container_dark,
    error = error_dark,
    errorContainer = error_container_dark,
    onError = on_error_dark,
    onErrorContainer = on_error_container_dark,
    background = background_dark,
    onBackground = on_background_dark,
    surface = surface_dark,
    onSurface = on_surface_dark,
    surfaceVariant = surface_variant_dark,
    onSurfaceVariant = on_surface_variant_dark,
    outline = outline_dark,
    inverseOnSurface = inverse_on_surface_dark,
    inverseSurface = inverse_surface_dark,
    inversePrimary = inverse_primary_dark,
    surfaceTint = primary_dark, // 使用用途に合わせて適宜変更
    outlineVariant = outline_variant_dark,
    scrim = scrim_dark,
)

@Composable
fun YankeesRosterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}