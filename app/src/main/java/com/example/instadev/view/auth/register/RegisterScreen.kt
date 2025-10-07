package com.example.instadev.view.auth.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R
import com.example.instadev.view.core.components.InstaButton
import com.example.instadev.view.core.components.InstaButtonSecondary
import com.example.instadev.view.core.components.InstaText
import com.example.instadev.view.core.components.InstaTextField

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel()) {

    val uiState = registerViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            )
        }
    ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                InstaText(text = stringResource(R.string.register),
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(4.dp))

                InstaText(text = stringResource(R.string.register_screen_subtitle),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(16.dp))
                InstaTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = "",
                    onValueChange = { },
                    label = stringResource(R.string.register_screen_textfield_register)
                )
                Spacer(modifier = Modifier.height(12.dp))
                InstaText(stringResource(R.string.register_screen_body))
                Spacer(modifier = Modifier.height(12.dp))

                InstaButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {},
                    title = stringResource(R.string.register_button))

                Spacer(modifier = Modifier.height(4.dp))
                InstaButtonSecondary(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {},
                    title = stringResource(R.string.register_screen_button_with_email),
                    titleColor = MaterialTheme.colorScheme.onBackground,
                    borderStroke = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
                )
                Spacer(modifier = Modifier.weight(1f))
                InstaText(
                    text = stringResource(R.string.register_screen_text_find_my_account),
                    color = MaterialTheme.colorScheme.primary)

            }
        }
    }