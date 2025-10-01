package com.example.instadev.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R
import com.example.instadev.view.core.components.InstaText
import androidx.compose.ui.res.stringResource

@Preview(showBackground = true)
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            InstaText(
                text = stringResource(id = R.string.language),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 22.dp),
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(id = R.drawable.instadev_logo),
                contentDescription = "InstaDev Logo Header"
            )

            Spacer(modifier = Modifier.weight(1f))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    cursorColor = MaterialTheme.colorScheme.primary,
                ),
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = uiState.email,
                label = { InstaText(text = stringResource(id = R.string.username_email_phone)) },
                onValueChange = { loginViewModel.onEmailChanged(it) },
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    cursorColor = MaterialTheme.colorScheme.primary,
                ),
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = uiState.password,
                label = { InstaText(text = stringResource(id = R.string.password)) },
                onValueChange = { loginViewModel.onPasswordChanged(it) },
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                onClick = { },
                enabled = uiState.isLoginEnabled,
                shape = MaterialTheme.shapes.extraLarge
            ) {
                InstaText(
                    Modifier.padding(vertical = 4.dp),
                    text = stringResource(id = R.string.login),
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }

            TextButton(onClick = { }) {
                InstaText(
                    text = stringResource(id = R.string.forgot_password),
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }

            Spacer(modifier = Modifier.weight(1.3f))

            OutlinedButton(
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                InstaText(
                    text = stringResource(id = R.string.create_account),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 24.dp),
                painter = painterResource(id = R.drawable.ic_meta),
                contentDescription = "meta logo",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
