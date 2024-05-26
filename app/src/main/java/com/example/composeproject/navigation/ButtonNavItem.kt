package com.example.composeproject.navigation

sealed class ButtonNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    object HomeScreen : ButtonNavItem("home_screen", "홈", android.R.drawable.btn_radio)
    object AllScreen : ButtonNavItem("all_screen", "전체", android.R.drawable.btn_radio)
    object JobScreen : ButtonNavItem("job_screen", "알바", android.R.drawable.btn_radio)
    object RealEstateScreen : ButtonNavItem("real_estate_screen", "부동산", android.R.drawable.btn_radio)
    object CarScreen : ButtonNavItem("car_screen", "중고차", android.R.drawable.btn_radio)
}