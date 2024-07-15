package com.busanit501.androidlabtest501.ch18_3_pytorch_rest_test

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
//    작업시, 장고에서, 해당 아이피 허용하고, 여기서 내부 네트워크로 테스트시 , 로컬호스트 또는 루프백 주소 외에
//    현재 사용중인 네트워크로 사용하기. 예) 192.168.219.200
    private const val BASE_URL = "http://192.168.219.200:8000/"  // Replace with your server URL

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val httpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}