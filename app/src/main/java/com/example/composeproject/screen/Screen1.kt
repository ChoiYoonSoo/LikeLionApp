import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun Screen1(navController : NavHostController){
    Text(text = "Screen1")
    Button(onClick = { navController.navigate(BottomNavItem.Screen2.route) }) {
        Text(text = "Screen2로 이동하기 ")
    }
}