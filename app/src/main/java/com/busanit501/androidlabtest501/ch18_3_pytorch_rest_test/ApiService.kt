package com.busanit501.androidlabtest501.ch18_3_pytorch_rest_test

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @Multipart
    @POST("api/classify/")
    fun uploadImage(@Part image: MultipartBody.Part): Call<ResponseBody>
}