package me.pengj.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.HOME.routeID) {
        composable(NavigationItem.HOME.routeID) {
            Screen("Home")
        }
        composable(NavigationItem.DASHBOARD.routeID) {
            Screen("Dashboard")
        }
        composable(NavigationItem.NOTIFICATION.routeID) {
            Screen("Notification")
        }
    }
}

@Composable
fun Screen(title: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

enum class NavigationItem(val routeID: String, val icon: Int, val title: Int, val count: Int) {
    HOME(
        "nav_home",
        R.drawable.ic_home_black_24dp,
        R.string.title_home,
        99
    ),
    DASHBOARD(
        "nav_dashboard",
        R.drawable.ic_dashboard_black_24dp,
        R.string.title_dashboard,
        0
    ),
    NOTIFICATION(
        "nav_notification",
        R.drawable.ic_notifications_black_24dp,
        R.string.title_notifications,
        999
    )
}
