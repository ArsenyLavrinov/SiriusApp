package com.github.barstu134.siriusapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.barstu134.siriusapp.ui.theme.SupportChatScreen
import com.github.barstu134.siriusapp.ui.theme.SupportScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //LoginScreen()
            NavGraph()
        }
    }
}

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("profile_delete") {
            ProfileDeleteScreen(navController = navController)
        }
        this.composable("profile_referrals") {
            ProfileReferralsScreen(navController = navController)
        }
        this.composable("support") {
            SupportScreen(navController = navController)
        }
        this.composable("support_chat") {
            SupportChatScreen(navController = navController)
        }
        this.composable("money") {
            MoneyScreen(navController = navController)
        }
        this.composable("money_put") {
            MoneyPutScreen(navController = navController)
        }
        this.composable("money_take") {
            MoneyTakeScreen(navController = navController)
        }
        this.composable("money_taken") {
            MoneyTakenScreen(navController = navController)
        }
        this.composable("main") {
            MainScreen(navController = navController)
        }
        this.composable("main_take") {
            MainTakeScreen(navController = navController)
        }
        this.composable("main_taken") {
            MainTakenScreen(navController = navController)
        }
        this.composable("history") {
            HistoryScreen(navController = navController)
        }
        this.composable("history_payment/{type}/{result}") { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type")
            val result = backStackEntry.arguments?.getString("result")
            HistoryPaymentScreen(navController = navController, type, result)
        }
        this.composable("history_details/{type}/{result}") { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type")
            val result = backStackEntry.arguments?.getString("result")
            HistoryDetailsScreen(navController = navController, type, result)
        }

    }
}




