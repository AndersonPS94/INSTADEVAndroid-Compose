package com.example.instadev.view.core.components

import android.graphics.Paint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun InstaText(

    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    style: TextStyle= MaterialTheme.typography.bodyLarge
    ) {
    Text(text = text, color = color, style = style)
}