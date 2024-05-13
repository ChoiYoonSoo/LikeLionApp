package com.example.composeproject.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    // BottomNavigation은 고정된 값을 사용하기 위해 listOf를 사용
    val item = listOf(
        BottomNavItem.MainScreen,
        BottomNavItem.Screen2,
        BottomNavItem.Screen3
    )

    var isSelectedTab by remember { mutableStateOf("main_screen") }

    NavigationBar(
        modifier = Modifier.
            height(60.dp),
        containerColor = Color.Red,
        contentColor = Color.White

    ) {
        item.forEach { item ->
            NavigationBarItem(
                selected = item.route == navController.currentDestination?.route,
                onClick = {
                    navController.navigate(item.route){

                    }
                    isSelectedTab = item.route
                },
                icon = {
//                    Image(painter = painterResource(id = item.icon), contentDescription = "")
                },
                label = {
                    Text(text = item.title)
                }
            )
        }
    }

}