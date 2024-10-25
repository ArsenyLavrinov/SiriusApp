package com.github.barstu134.siriusapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.barstu134.siriusapp.ui.theme.SiriusAppTheme

@Composable
fun HistoryDetailsScreen(navController: NavHostController, type: String?, result: String?) {
    val operation = if (type == "take")
        "Пополнение"
    else
        "Вывод"
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Spacer(Modifier.weight(0.1f))
            TitleWithBackArrow("Детали") {
                navController.popBackStack()
            }
            Spacer(Modifier.weight(0.1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.timer_start),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .width(50.dp)
                        .padding(8.dp),
                )
                Column {
                    Text(  if (type == "take")
                        "Пополнение создано"
                    else
                        "Вывод создан")
                    GrayText("4.12.2024 19:02")
                }
            }
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.TopEnd)
                        .width(2.dp)
                        .background(veryLightBlue)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.timer_go),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .width(50.dp)
                        .padding(8.dp),
                )
                Column {
                    Text("$operation обрабатывается")
                    GrayText("24.12.2024 19:09")
                }
            }
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .background(Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.TopEnd)
                        .width(4.dp)
                        .background(customBlue)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id =  if(result=="success") R.drawable.ready else R.drawable.fail),
                    modifier = Modifier
                        .width(50.dp)
                        .padding(8.dp),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
                Column {
                    Text(
                        if(result=="success") {
                            if (type == "take")
                                "Пополнение выполнено"
                            else
                                "Вывод выполнен"
                        } else
                            "Операция была отменена"
                    )
                    GrayText("24.12.2024 19:12")
                }
            }
            Spacer(Modifier.weight(0.3f))
            Text(
                "Подать аппеляцию",
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Button(
                { navController.navigate("support_chat") },
                colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text("Написать в поддержку")
            }
        }

    }
}

@Composable
fun HistoryPaymentScreen(navController: NavHostController, type: String?, result: String?) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Spacer(Modifier.weight(0.1f))
            if (type == "take")
                TitleWithBackArrow("Пополнение #239231") {
                    navController.navigate("history")
                }
            else
                TitleWithBackArrow("Вывод #239231") {
                    navController.navigate("history")
                }
            Spacer(Modifier.weight(0.3f))
            Icon(
                painter = painterResource(id = if (result == "success") R.drawable.ready else R.drawable.fail),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .scale(2f),
                tint = Color.Unspecified
            )
            Spacer(Modifier.weight(0.15f))

            Text(
                if (type == "take")
                    if (result == "success") "Пополнение зачислено" else "Пополнение не выполнено"
                else
                    if (result == "success") "Вывод выполнен" else "Вывод не выполнен",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.weight(0.1f))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    GrayText("Дата и время операции")
                    Text("23.06.2024 18:34", modifier = Modifier.padding(4.dp))
                }
                Icon(
                    painter = painterResource(id = R.drawable.notepad_lines),
                    contentDescription = "Account",
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("history_details/$type/$result")
                        },
                    tint = Color.Gray
                )
            }
            GrayText("Тип операции")
            Row() {
                if (type == "take") {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowDown,
                        contentDescription = "More",
                        tint = Color.Green
                    )
                    Text("Получение")
                } else {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowUp,
                        contentDescription = "More",
                        tint = Color.Red
                    )
                    Text("Вывод")
                }
            }

            GrayText("Реквизиты")
            Text("+7 (901) 871-09-12", modifier = Modifier.padding(4.dp))
            GrayText("Т-Банк (Тинькофф)")
            GrayText("Сумма")
            Text("Сумма 12 573 ₽", modifier = Modifier.padding(4.dp))

            Spacer(Modifier.weight(0.3f))
            Text(
                "Подать аппеляцию",
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Button(
                { navController.navigate("support_chat") },
                colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text("Написать в поддержку")
            }
        }
    }
}

@Composable
fun HistoryScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            TitleWithBackArrow("История заданий") { navController.navigate("profile") }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Text("За день")
                Text("За месяц")
                Text("За всё время")
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                GrayText("Суммарно пополнений")
                Row {
                    Text("$", style = MaterialTheme.typography.headlineLarge, color = Color.Gray)
                    Text("1,320", style = MaterialTheme.typography.headlineLarge)
                }

                GrayText("≈ 110 240 ₽")
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("history_payment/take/success")
                    }
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Пополнение #239231")
                    Text(" 20.07.2023 19:00")
                }
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GrayText("2 573 ₽")
                    Text("+1 573 ₽", color = Color.Green)
                }
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("history_payment/take/fail")
                    }
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Пополнение #328293")
                    Text("20.07.2023 12:04")
                }
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GrayText("2 573 ₽")
                    Text("-1 573 ₽", color = Color.Green)
                }
            }
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable {
                        navController.navigate("history_payment/pay/success")
                    }
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Вывод #328293")
                    Text("20.07.2023 23:18")
                }
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GrayText("2 573 ₽")
                    Text("+1 573 ₽", color = Color.Red)
                }
            }
            Spacer(Modifier.weight(0.1f))
            LowPanel(navController)
            Spacer(Modifier.weight(0.01f))
        }
    }
}