package com.example.composeproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composeproject.screen.Person

class MainScreenViewModel: ViewModel() {
    fun getAllPerson(): List<Person>{
        return listOf(
            Person(1,"최윤수",20),
            Person(2,"최윤수",20),
            Person(3,"최윤수",20),
            Person(4,"최윤수",20),
            Person(5,"최윤수",20),
            Person(6,"최윤수",20),
            Person(7,"최윤수",20),
            Person(8,"최윤수",20),
            Person(9,"최윤수",20),
            Person(10,"최윤수",20),
            Person(11,"최윤수",20),
            Person(12,"최윤수",20),
            Person(13,"최윤수",20),
        )
    }
}