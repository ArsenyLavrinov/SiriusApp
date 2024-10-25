package com.github.barstu134.siriusapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.barstu134.siriusapp.ui.theme.SiriusAppTheme

@Composable
fun LoginScreen(navController: NavHostController) {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    SiriusAppTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(Modifier.weight(0.5f))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Fint",
                modifier = Modifier.width(IntrinsicSize.Max)
            )
            Spacer(Modifier.weight(0.6f))
            Text("Войти", style = MaterialTheme.typography.headlineLarge)
            Text("Добро пожаловать!\nВойдите чтобы продолжить")
            Spacer(Modifier.weight(0.3f))
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Email") },
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
            )
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Введите пароль") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = MaterialTheme.shapes.small,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
            )
            Button(
                { navController.navigate("profile") },
                colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Войти", style = MaterialTheme.typography.headlineLarge)
            }
            Spacer(Modifier.weight(0.1f))
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color.LightGray)
                )
                Text(
                    "Или войти через",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(Color.White)
                        .padding(8.dp)
                )
            }
            Spacer(Modifier.weight(0.1f))
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier
                    .width(IntrinsicSize.Max)
                    .align(Alignment.CenterHorizontally)
                    .scale(0.75f)
            )
            Spacer(Modifier.weight(0.1f))
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Нет аккаунта. ")
                Text("Зарегистрируйтесь", color = customBlue)
            }
            Spacer(Modifier.weight(0.5f))
        }
    }
}