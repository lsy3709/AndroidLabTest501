package com.busanit501.androidlabtest501.ch18_network.retrofit

import android.app.Application
import com.busanit501.androidlabtest501.ch18_2_pagingTest.INetworkServiceSpringShop
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 자주 사용이 될 네트워크 인터페이스를 , 미리 시스템에 등록.
// 메니페스트에 등록해서,
// 앱이 실행이 되면, 해당 MyApplication 의 기능이
// 메모리 등록이 되어서 사용하기 편함.
class MyApplication4 : Application(){


        val BASE_URL = "http://10.100.104.27:8083/blog/"
    // 레스트 통신 테스트 샘플
    // spring 서버 레스트 용.
    val BASE_URL_SPRING_SHOP = "http://10.100.104.27:80/"

    // 강사실 내자리 , 내부 아이피 , 192.168.0.22
    val BASE_URL_SPRING_SHOP2 = "http://192.168.0.22:80/"

    // spring 서버 레스트 용.
    var networkServiceSpringShop: INetworkServiceSpringShop
    // spring 서버 레스트 용.
    val retrofitSpring: Retrofit
        get() = Retrofit.Builder()
            // 필요시, 강의실, 내자리 스위치하면서 사용하기.
            .baseUrl(BASE_URL_SPRING_SHOP2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //add....................................
        var networkService: INetworkService4
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        init {
            networkService = retrofit.create(INetworkService4::class.java)
            // spring 서버 레스트 용.
            networkServiceSpringShop = retrofitSpring.create(INetworkServiceSpringShop::class.java)
        }


}