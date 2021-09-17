package me.pengj.navigation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNav(navController) }
    ) {
        Navigation(navController = navController)
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNav(navController: NavController) {
    val items = NavigationItem.values()
    BottomNavigation(
//        backgroundColor = Color.DarkGray,
//        contentColor = MaterialTheme.colors.primary
    ) {
        val navBackStackEntry = navController.currentBackStackEntry
        val currentRouteId = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { NavItemIcon(item) },
                label = { Text(stringResource(id = item.title), style = getStyle(item)
                ) },
                selected = currentRouteId == item.routeID,
                onClick = {
                    navController.navigate(item.routeID)
                },
                selectedContentColor = getColor(item = item)
            )
        }
    }
}

fun getColor(item: NavigationItem) = if (item.count == 99) {
    Color.White
} else {
    Color.Cyan
}
fun getStyle(item: NavigationItem): TextStyle {
    if (item.count == 99) {
        return TextStyle(
            color = Color.Yellow,
            fontSize = 16.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraLight,
            fontStyle = FontStyle.Normal,
            letterSpacing = 0.1.em,
            textDecoration = TextDecoration.None
        )
    }

    if (item.count == 999) {
        return TextStyle(
            color = Color.Green,
            fontSize = 12.sp,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Normal,
            letterSpacing = 0.2.em,
            textDecoration = TextDecoration.Underline
        )
    }

    return TextStyle(
        color = Color.Blue,
        fontSize = 14.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W800,
        fontStyle = FontStyle.Normal,
        letterSpacing = 0.3.em,
        textDecoration = TextDecoration.None
    )

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NavItemIcon(item: NavigationItem) {
    if (item.count == 0) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = stringResource(id = item.title)
        )
    } else {
        BadgeBox(badgeContent = { Text(item.count.toString(), style = TextStyle(color = Color.White)) }, backgroundColor = Color.Black) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = stringResource(id = item.title),
            )
        }
    }
}