
// sealed class 와 enum class의 차이
sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
){
    // Route는 소문자로만 작성
    object MainScreen: BottomNavItem("main_screen","메인",android.R.drawable.btn_radio)
    object Screen2: BottomNavItem("screen2","스크린2",android.R.drawable.btn_radio)
    object Screen3: BottomNavItem("screen3","스크린3",android.R.drawable.btn_radio)
}