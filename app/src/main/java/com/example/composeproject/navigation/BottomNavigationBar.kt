package com.example.composeproject.navigation

import BottomNavItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composeproject.viewmodel.BottomNavViewModel

@Composable
fun BottomNavigationBar(navController: NavHostController, viewModel: BottomNavViewModel) {

    // BottomNavigation은 고정된 값을 사용 하기 위해 listOf를 사용
    val item = listOf(
        BottomNavItem.HomeScreen,
        BottomNavItem.LifeScreen,
        BottomNavItem.NearScreen,
        BottomNavItem.ChatScreen,
        BottomNavItem.MyScreen
    )

    NavigationBar(
        modifier = Modifier.height(60.dp),
        containerColor = Color.White,
        contentColor = Color.Black

    ) {
        item.forEach { item ->
            NavigationBarItem(
                selected = item.route == navController.currentDestination?.route,
                onClick = {
                    navController.navigate(item.route) {
                    }
                    viewModel.isSelectedTab = item.route
                },
                icon = {
                    Column(
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = item.icon), contentDescription = "")
                        Text(
                            text = item.title,
                            style = androidx.compose.ui.text.TextStyle(fontSize = 10.sp)
                        )
                    }
                },
                label = {
                    null
                }
            )
        }
    }

}