package com.example.instadev.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = InstaBlue,
    onPrimary = Color.White,

    secondary = InstaBlue,
    onSecondary = Color.White,

    tertiary = InstaBlue,
    onTertiary = Color.White,

    background = Gray20,
    onBackground = Gray70,

    surface = Gray20,
    onSurface = Gray70,

    surfaceVariant = Gray30,
    onSurfaceVariant = Color.White,

    error = Color(0xFFCF6679),
    onError = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = InstaBlue,
    onPrimary = Color.White,

    secondary = InstaBlue,
    onSecondary = Color.White,

    tertiary = InstaBlue,
    onTertiary = Color.White,

    background = Gray100,
    onBackground = Gray80,

    surface = Gray100,
    onSurface = Gray80,

    surfaceVariant = Gray30,
    onSurfaceVariant = Gray30,

    error = Color(0xFFB00020),
    onError = Color.White,
)

@Composable
fun InstaDevTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // força usar só sua paleta
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}
