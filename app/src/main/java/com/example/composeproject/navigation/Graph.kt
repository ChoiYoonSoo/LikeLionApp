import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// 화면 이동 설정하는 곳
// navHost -> BackStep을 추적하는 navHostController
@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "main_screen"){
        composable(BottomNavItem.MainScreen.route){
          Screen1(navController = navController)
        }
        composable(BottomNavItem.Screen2.route){
            Screen2()
        }
        composable(BottomNavItem.Screen3.route){
            Screen3()
        }
    }
}