package com.github.barstu134.siriusapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun LowPanel(navController: NavHostController) {

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "Account",
            modifier = Modifier.padding(8.dp).clickable {
                navController.navigate("main")
            }
        )
        Icon(
            painter = painterResource(id = R.drawable.notepad_black),
            contentDescription = "Account",
            modifier = Modifier.padding(8.dp).clickable {
                navController.navigate("history")
            }
        )
        Icon(
            painter = painterResource(id = R.drawable.chat),
            contentDescription = "Account",
            modifier = Modifier.padding(8.dp).clickable {
                navController.navigate("support")
            }
        )
        Icon(
            painter = painterResource(id = R.drawable.card),
            contentDescription = "Account",
            modifier = Modifier.padding(8.dp).clickable {
                navController.navigate("money")
            }
        )
        Icon(
            imageVector = Icons.Filled.Person,
            contentDescription = "Account",
            modifier = Modifier.padding(8.dp).clickable {
                navController.navigate("profile")
            }
        )
    }
}