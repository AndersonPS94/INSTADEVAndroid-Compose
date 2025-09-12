package com.example.instadev.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instadev.R

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold { padding ->

        Column(
            Modifier
                .background(Color.White)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Português (Brasil)",
                color = Color.Gray,
                modifier = Modifier.padding(top = 22.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(
                    id = R.drawable.instadev_logo
                ),
                contentDescription = "InstaDev Logo Header"
            )

            Spacer(modifier = Modifier.weight(1f))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF3797EF),
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color(0xFF3797EF),
                    unfocusedLabelColor = Color.Gray,
                    cursorColor = Color(0xFF3797EF),
                ),
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = email,
                label = { Text("Usuário, Email ou Telefone") },
                onValueChange = { email = it },
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF3797EF),
                    unfocusedBorderColor = Color.Gray,
                    focusedLabelColor = Color(0xFF3797EF),
                    unfocusedLabelColor = Color.Gray,
                    cursorColor = Color(0xFF3797EF),
                ),
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = password,
                label = { Text("Senha") },
                onValueChange = { password = it },
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3797EF), // Azul padrão Instagram
                    contentColor = Color.White
                ),
                onClick = { }
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "Iniciar Sessão"
                )
            }

            TextButton(onClick = { }) {
                Text(
                    "Esqueci minha senha",
                    color = Color(0xFF3797EF)
                )
            }

            Spacer(modifier = Modifier.weight(1.3f))

            OutlinedButton(
                border = BorderStroke(1.dp, Color(0xFF3797EF)),
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFF3797EF),
                    containerColor = Color.White,

                )
            ) {
                Text(
                    "Criar uma conta",
                    color = Color(0xFF3797EF)
                )
            }

            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 24.dp),
                painter = painterResource(id = R.drawable.ic_meta),
                contentDescription = "meta logo",
                tint = Color.Gray,
            )
        }
    }
}
