package com.busanit501.androidlabtest501.ch18_network.retrofit

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// 자주 사용이 될 네트워크 인터페이스를 , 미리 시스템에 등록.
// 메니페스트에 등록해서,
// 앱이 실행이 되면, 해당 MyApplication 의 기능이
// 메모리 등록이 되어서 사용하기 편함.
class MyApplication2 : Application(){


        val QUERY = "travel"
        val QUERY2 = "Apple"
        val from ="2024-06-22"
        val sortBy ="popularity"
        val API_KEY = "b7adb4f936494b3bac62f446ab7686cb"
        val BASE_URL = "https://newsapi.org"
        val USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36"


        //add....................................
        var networkService: INetworkService2
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        init {
            networkService = retrofit.create(INetworkService2::class.java)
        }


}