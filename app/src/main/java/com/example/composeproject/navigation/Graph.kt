import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composeproject.navigation.ButtonNavItem
import com.example.composeproject.screen.AllScreen
import com.example.composeproject.screen.CarScreen
import com.example.composeproject.screen.ChatScreen
import com.example.composeproject.screen.HomeScreen
import com.example.composeproject.screen.JobScreen
import com.example.composeproject.screen.LifeScreen
import com.example.composeproject.screen.MyScreen
import com.example.composeproject.screen.NearScreen
import com.example.composeproject.screen.RealEstateScreen

// 화면 이동 설정 하는 곳
// navHost -> 백 스텝을 추적 하는 navHostController
@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home_screen"){
        composable(ButtonNavItem.HomeScreen.route){
          HomeScreen(navController = navController)
        }
        composable(ButtonNavItem.AllScreen.route){
            AllScreen()
        }
        composable(ButtonNavItem.JobScreen.route){
            JobScreen()
        }
        composable(ButtonNavItem.RealEstateScreen.route){
            RealEstateScreen()
        }
        composable(ButtonNavItem.CarScreen.route){
            CarScreen()
        }
        composable(BottomNavItem.LifeScreen.route){
            LifeScreen()
        }
        composable(BottomNavItem.ChatScreen.route){
            ChatScreen()
        }
        composable(BottomNavItem.NearScreen.route){
            NearScreen()
        }
        composable(BottomNavItem.MyScreen.route){
            MyScreen()
        }
    }
}