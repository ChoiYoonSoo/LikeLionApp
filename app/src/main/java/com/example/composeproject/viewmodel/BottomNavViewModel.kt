package com.example.composeproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BottomNavViewModel : ViewModel(){

    var isSelectedTab by mutableStateOf("home_screen")

}