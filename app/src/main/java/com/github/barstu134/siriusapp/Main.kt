package com.github.barstu134.siriusapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.barstu134.siriusapp.ui.theme.SiriusAppTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds


@Composable
fun MainTakenScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Spacer(Modifier.weight(0.1f))
            TitleWithBackArrow("Операция 9231") {
                navController.navigate("main")
            }
            Spacer(Modifier.weight(0.3f))
            Icon(
                painter = painterResource(id = R.drawable.ready),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .scale(2f),
                tint = Color.Unspecified
            )
            Spacer(Modifier.weight(0.15f))
            Text(
                "Платеж подтверждён",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Text(
                "Вы подтвердили получение средств",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.weight(0.1f))
            GrayText("Дата и время операции")
            Text("23.06.2024 18:34", modifier = Modifier.padding(4.dp))
            GrayText("Ваши реквизиты")
            Text("+7 (901) 871-09-12", modifier = Modifier.padding(4.dp))
            GrayText("Т-Банк (Тинькофф)")
            GrayText("Сумма")
            Text("42 530 ₽", modifier = Modifier.padding(4.dp))

            Spacer(Modifier.weight(0.3f))
            Button(
                { navController.navigate("main") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text("Подать аппеляцию", color = Color.Red, modifier = Modifier.padding(16.dp))
            }
            Button(
                { navController.navigate("main") },
                colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text("На главную")
            }
        }
    }
}


@Composable
fun MainTakeScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            TitleWithBackArrow("Операция 9231") {
                navController.navigate("main")
            }
            Row {
                Column(
                    modifier = Modifier.weight(0.45f)
                ) {
                    Text("Сумма")
                    Text(
                        "42 530 ₽",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
                Column(
                    modifier = Modifier.weight(0.45f)
                ) {
                    GrayText("Тип операции")
                    Row() {
                        Icon(
                            imageVector = Icons.Outlined.KeyboardArrowDown,
                            contentDescription = "More",
                            tint = Color.Green
                        )
                        Text("Поступление")
                    }
                }
            }
            Spacer(Modifier.weight(0.1f))

            Text("Придёт на:", style = MaterialTheme.typography.headlineLarge)
            GrayText("куда будет осуществлен перевод")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.tbank),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .height(IntrinsicSize.Min)
                        .weight(0.2f)
                        .scale(0.5f)
                        .clip(CircleShape),

                    tint = Color.Unspecified
                )
                Column(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .weight(0.5f)
                ) {
                    Text(
                        "+7 (901) 871-09-12",
                        fontWeight = FontWeight.Bold,
                    )
                    GrayText("Т-Банк (Тинькофф)")
                }
                Text(
                    "143 000 ₽",
                    fontWeight = FontWeight.Bold,
                )
            }
            Text("Откуда придет")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.tbank),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .height(IntrinsicSize.Min)
                        .weight(0.15f)
                        .scale(0.5f)
                        .clip(CircleShape),

                    tint = Color.Unspecified
                )
                Column(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .weight(0.5f)
                ) {
                    Text(
                        "+7 (901) 871-09-12",
                        fontWeight = FontWeight.Bold,
                    )
                    GrayText("Т-Банк (Тинькофф)")
                }
            }
            var ticks by remember { mutableStateOf(6 * 60 + 21) }
            LaunchedEffect(Unit) {
                while (ticks > 0) {
                    delay(1.seconds)
                    ticks-=1
                }
                ticks =0
            }
            Spacer(Modifier.weight(0.1f))
            Row {
                ComposeCircularProgressBar(
                    percentage = ticks / 600f,
                )
                Column {
                    Text(
                        if (ticks > 0) "Осталось: ${ticks / 60}:"+"${ticks % 60}".padStart(2,'0')
                        else
                            "Время истекло"
                        ,
                        fontWeight = FontWeight.Bold,
                    )
                    GrayText("выберите действие:")
                }
            }
            Button(
                { navController.navigate("main_taken") },
                colors = ButtonDefaults.buttonColors(containerColor = if (ticks > 0) customBlue else Color.Gray),
                enabled = ticks > 0,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text("Принять перевод")
            }
            Button(
                { navController.navigate("main") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "Отказатся от  перевода",
                    color = Color.Red,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Главная", style = MaterialTheme.typography.headlineLarge)
            }
            Column(
                modifier = Modifier
                    .background(customBlue, shape = RoundedCornerShape(16.dp))
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Суммарно поступлений", color = Color.White)
                Text("2 030 ₽", color = Color.White, style = MaterialTheme.typography.headlineLarge)
            }
            var checked by remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Присылать уведомления")
                Switch(checked,
                    onCheckedChange = { checked = it })
            }
            Spacer(Modifier.weight(0.1f))

            Text("Операция 9231", style = MaterialTheme.typography.headlineLarge)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "More",
                    tint = Color.Green
                )
                Text("Поступление")
            }
            Text("Сумма")
            Text("42 530 ₽", style = MaterialTheme.typography.headlineLarge)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.tbank),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .height(IntrinsicSize.Min)
                        .weight(0.15f)
                        .scale(0.5f)
                        .clip(CircleShape),

                    tint = Color.Unspecified
                )
                Column(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .weight(0.5f)
                ) {
                    Text(
                        "СПБ",
                        fontWeight = FontWeight.Bold,
                    )
                    GrayText("Т-Банк (Тинькофф)")
                }
            }
            Button(
                { navController.navigate("main_take") },
                colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text("Принять")
            }
            Spacer(Modifier.weight(0.1f))
            LowPanel(navController)
            Spacer(Modifier.weight(0.01f))
        }
    }


}