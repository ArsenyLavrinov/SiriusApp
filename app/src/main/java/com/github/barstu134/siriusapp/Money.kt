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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.barstu134.siriusapp.ui.theme.SiriusAppTheme

@Composable
fun MoneyTakeScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            TitleWithBackArrow("Вывод средств\nс депозита") {
                navController.navigate("money")
            }

            Icon(
                painter = painterResource(id = R.drawable.qrcode),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .scale(2f)
                    .padding(32.dp)
                    .align(Alignment.CenterHorizontally),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.weight(0.2f))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Column {
                    GrayText("Доступны для вывода:")
                    Text(
                        "21 265 ₽ ≈ \$ 250",
                        color = customBlue,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Column {
                    GrayText("Депозит")
                    Text(
                        "42 530 ₽ ≈ \$ 500",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.Gray
                    )
                }
            }
            GrayText("Информация для вывода")
            CurrencySelect()
            GrayText("Реквизиты")
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "ZmRnZGZnZmdmZ2hnaGpqa2psa2pyZXRnNTQ2NTRmZ2hnaGdo",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = customBlue,
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.link),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp),
                    tint = customBlue
                )
            }
            var target by remember { mutableStateOf("") }
            var count by remember { mutableStateOf("") }
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                value = target,
                onValueChange = { target = it },
                placeholder = { Text("Реквизиты") },
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
                value = count,
                onValueChange = { count = it },
                placeholder = { Text("Сумма") },
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
            )
            Spacer(Modifier.weight(0.5f))
            Button(
                { navController.navigate("money_taken") },
                colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text("Вывод средств")
            }

        }
    }
}


@Composable
fun MoneyPutScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            TitleWithBackArrow("Пополнение депозита") {
                navController.navigate("money")
            }

            Icon(
                painter = painterResource(id = R.drawable.qrcode),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .scale(2f)
                    .padding(32.dp)
                    .align(Alignment.CenterHorizontally),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.weight(0.2f))
            GrayText("Валюта пополнения")
            CurrencySelect()
            GrayText("Номер счёта")
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "ZmRnZGZnZmdmZ2hnaGpqa2psa2pyZXRnNTQ2NTRmZ2hnaGdo",
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = customBlue,
                    modifier = Modifier.fillMaxWidth(0.9f)
                )
                Icon(
                    painter = painterResource(id = R.drawable.link),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp),
                    tint = customBlue
                )
            }
            Spacer(Modifier.weight(0.5f))
            Button(
                { navController.navigate("money") },
                colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text("Вернуться к “Счета и депозит”")
            }
        }
    }
}

@Composable
fun MoneyScreen(navController: NavHostController) {
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
                Text("Счета и депозит", style = MaterialTheme.typography.headlineLarge)
            }
            Spacer(Modifier.weight(0.1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Column {
                    GrayText("Депозит")
                    Text(
                        "42 530 ₽",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    GrayText("≈ \$ 500")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
            ) {
                Column {
                    GrayText("Доступны мне:")
                    Text(
                        "21 265 ₽",
                        color = Color.Green,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    GrayText("≈ \$ 250")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Button(
                    { navController.navigate("money_put") },
                    colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(0.5f)
                        .height(IntrinsicSize.Max)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Пополнить")
                        Icon(
                            painter = painterResource(id = R.drawable.putin),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
                Button(
                    { navController.navigate("money_take") },
                    colors = ButtonDefaults.buttonColors(containerColor = veryLightGray),
                    modifier = Modifier
                        .padding(16.dp)
                        .weight(0.5f)
                        .height(IntrinsicSize.Max)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Вывести",
                            color = customBlue
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.send_right_side),
                            contentDescription = "",
                            tint = customBlue
                        )
                    }
                }
            }
            GrayText("Мои счета:")
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
                        .clip(CircleShape),
                    tint = Color.Unspecified
                )
                Column(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .weight(0.5f)
                ) {
                    Text(
                        "Т-Банк (Тинькофф)",
                        fontWeight = FontWeight.Bold,
                    )
                    GrayText("*9898")
                }
                Column(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .weight(0.3f)
                ) {
                    Text(
                        "143 000 ₽",
                    )
                    GrayText("≈ \$ 1322")
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.alphabank),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(0.15f)
                        .padding(8.dp)
                        .height(IntrinsicSize.Min)
                        .clip(CircleShape),

                    tint = Color.Unspecified
                )
                Column(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .weight(0.5f)
                ) {
                    Text(
                        "Альфа-банк",
                        fontWeight = FontWeight.Bold,
                    )
                    GrayText("*9842")
                }
                Column(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .weight(0.3f)
                ) {
                    Text(
                        "106 540 ₽",
                        fontWeight = FontWeight.Bold,
                    )
                    GrayText("≈ \$ 1000")
                }
            }
            Spacer(Modifier.weight(0.1f))
            LowPanel(navController)
            Spacer(Modifier.weight(0.01f))
        }
    }


}

@Composable
fun CurrencySelect() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Доллар США (USD)", "Евро (EU)", "Рубли (₽)")
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                items[selectedIndex], fontWeight = FontWeight.Bold,
            )
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowDown,
                contentDescription = "More"
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(text = { Text(s) }, onClick = {
                    selectedIndex = index
                    expanded = false
                })
            }
        }
    }
}
@Composable
fun MoneyTakenScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Spacer(Modifier.weight(0.3f))
            Icon(
                painter = painterResource(id = R.drawable.ready),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .scale(2f),
                tint = Color.Unspecified
            )
            Spacer(Modifier.weight(0.1f))
            Text(
                "Заявка на вывод –\n создана",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            Text(
                "В течение 2 часов на реквизиты\n будет отправлена сумма",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.weight(0.3f))
            Button(
                { navController.navigate("money") },
                colors = ButtonDefaults.buttonColors(containerColor = customBlue),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
            ) {
                Text("Вернуться к “Счета и депозит”")
            }
        }
    }
}

