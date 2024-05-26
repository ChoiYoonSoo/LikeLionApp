import com.example.composeproject.R

// sealed class 와 enum class의 차이
sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
){
    // Route는 소문자로만 작성
    object HomeScreen: BottomNavItem("home_screen","홈", R.drawable.home)
    object LifeScreen: BottomNavItem("life_screen","동네생활", R.drawable.note)
    object NearScreen: BottomNavItem("near_screen","내 근처", R.drawable.gps)
    object ChatScreen: BottomNavItem("chat_screen","채팅", R.drawable.chat)
    object MyScreen: BottomNavItem("my_screen","나의 당근", R.drawable.human)
}