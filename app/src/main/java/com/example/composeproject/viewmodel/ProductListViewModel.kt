package com.example.composeproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.composeproject.model.Product

class ProductListViewModel : ViewModel() {

    fun getAllProduct(): List<Product>{
        return listOf(
            Product("갤럭시 울트라 24 개통한지 한달 안되었어요","두정동","2시간 전","200만원",1,5,2,"https://i.pravatar.cc/300"),
            Product("로드자전거","천안시 동남구 신방동","1시간 전","30,000원",2,3,5,"https://i.pravatar.cc/300"),
            Product("콘스탄틴 어베인 판매/대차 합니다","서북구 성거읍","끌올 1분전","350,000원",0,0,3,"https://i.pravatar.cc/300"),
            Product("갤럭시 S23 512기가","성정동","1시간 전","570,000원",0,0,0,"https://i.pravatar.cc/300"),
            Product("아이폰 12프로","신부동","2시간 전","650,000원",0,1,2,"https://i.pravatar.cc/300"),
        )
    }
}