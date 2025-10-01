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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R

@Preview(showBackground = true)
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel() ) {
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

            Text(
                "Português (Brasil)",
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(top = 22.dp),
                style = MaterialTheme.typography.bodyLarge
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
                label = { Text("Usuário, Email ou Telefone", color = MaterialTheme.colorScheme.onBackground) },
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
                label = { Text("Senha", color = MaterialTheme.colorScheme.onBackground) },
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
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "Iniciar Sessão",
                    color = MaterialTheme.colorScheme.onPrimary,
                )
            }

            TextButton(onClick = { }) {
                Text(
                    "Esqueci minha senha",
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
                Text(
                    "Criar uma conta",
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
