package com.github.barstu134.siriusapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.github.barstu134.siriusapp.ui.theme.SiriusAppTheme



@Composable
fun ProfileReferralsScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            TitleWithBackArrow("Реферальная\nпрограмма") { navController.navigate("profile") }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Пригласить", color = Color.Gray)
                Spacer(modifier = Modifier.weight(0.5f))
                Icon(
                    painter = painterResource(id = R.drawable.add_person),
                    contentDescription = "Account",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                for (i in listOf(1, 2, 6, 6, 9)) {
                    Text(
                        "$i",
                        style = MaterialTheme.typography.headlineLarge,
                        color = customBlue,
                        modifier = Modifier.padding(24.dp)
                    )
                }
            }
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
                    contentDescription = "Account",
                    modifier = Modifier
                        .padding(8.dp),
                    tint = customBlue
                )
            }
            Spacer(Modifier.weight(0.3f))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Приглашённые", color = Color.Gray)
                Icon(
                    painter = painterResource(id = R.drawable.many_person),
                    contentDescription = "Account",
                    modifier = Modifier
                        .padding(8.dp),
                    tint = Color.Gray
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    "schooltalents@urfu.ru",
                    color = Color.Black,
                    style = MaterialTheme.typography.titleMedium,
                )
                Text("24.05.2024", color = Color.Gray)
            }
            Spacer(Modifier.weight(0.3f))
        }
    }
}

@Composable
fun ProfileDeleteScreen(navController: NavHostController) {
    SiriusAppTheme {
        Column(modifier = Modifier
            .padding(16.dp)
            .clickable {
                navController.navigate("profile")
            }) {
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Профиль", style = MaterialTheme.typography.headlineLarge)
                Icon(
                    painter = painterResource(id = R.drawable.exit),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        navController.navigate("login")
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GrayText("Мои данные")
                Icon(
                    painter = painterResource(id = R.drawable.person_gray),
                    contentDescription = "",
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(
                        color = veryLightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Email ")
                Text("e1@e1.ru")
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Account",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(
                        color = veryLightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Пароль")
                Text("e1@e1.ru")
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Account",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Spacer(Modifier.weight(0.25f))
            Text("Вы уверены, что хотите", style = MaterialTheme.typography.headlineLarge)
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("удалить аккаунт", style = MaterialTheme.typography.headlineLarge)
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Fint",
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                )
                Text("?", style = MaterialTheme.typography.headlineLarge)
                Spacer(Modifier.weight(0.5f))
            }
            Text(
                "С аккаунтом удалится вся история транзакций, привязки к счетам и баланс депозита",
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Button(
                { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text("Удалить аккаунт", color = Color.White, modifier = Modifier.padding(16.dp))
            }
        }

    }
}

@Composable
fun ProfileScreen(navController: NavHostController) {
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
                Text("Профиль", style = MaterialTheme.typography.headlineLarge)
                Icon(
                    painter = painterResource(id = R.drawable.exit),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        navController.navigate("login")
                    }
                )
            }
            Spacer(Modifier.weight(0.1f))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GrayText("Мои данные")
                Icon(
                    painter = painterResource(id = R.drawable.person_gray),
                    contentDescription = "",
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(
                        color = veryLightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Email")
                Text("e1@e1.ru")
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Account",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(
                        color = veryLightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Пароль")
                Text("***********")
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "Account",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Spacer(Modifier.weight(0.1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                GrayText("Реферальная программа")
                Icon(
                    painter = painterResource(id = R.drawable.many_person),
                    contentDescription = "",
                    tint = Color.Gray
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(
                        color = veryLightGray,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
                    .clickable {
                        navController.navigate("profile_referrals")
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("Приглашения")
                    GrayText("Приглашенные рефералы")
                }
                Icon(
                    painter = painterResource(id = R.drawable.many_person),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
            Spacer(Modifier.weight(0.5f))
            Button(
                { navController.navigate("profile_delete") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text("Удалить аккаунт", color = Color.Red, modifier = Modifier.padding(16.dp))
            }
            Spacer(Modifier.weight(0.1f))
            LowPanel(navController)
            Spacer(Modifier.weight(0.01f))
        }
    }
}


