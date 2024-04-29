package com.example.composeproject.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel(){

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var textField by mutableStateOf("")
    var isEmailValidate by mutableStateOf(false)
    var isPasswordVisible by mutableStateOf(false)
    var isEmailSuccess by mutableStateOf(false)
    var isPasswordSuccess by mutableStateOf(false)
    var isEmailFocused by mutableStateOf(false)
    var isPasswordFocused by mutableStateOf(false)
}