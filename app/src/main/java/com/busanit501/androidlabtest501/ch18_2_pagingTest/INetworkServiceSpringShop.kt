package com.busanit501.androidlabtest501.ch18_2_pagingTest

import retrofit2.http.GET
import retrofit2.http.Path

// 통신 라이브러리 : retrofit2 이용해서,
// 인터페이스, 추상 메서드를 만들어서,
// 레트로핏한테 전달 : 인터페이스 통으로 전달하면,
// 여기에 정의된 함수를 이용해서, 통신을 함. crud.
// package com.example.myapp_test_7_8_9_10_11_12.ch18_Test.retrofit
// 위에 MyApplication4 사용하기.
interface INetworkServiceSpringShop {
    // 모델링 확인.
    // {
    //    "items": {
    //        "content": [
    //            {
    //                "id": 26,
    //                "itemNm": "테스트4",
    //                "itemDetail": "444",
    //                "imgUrl": "/images/item/c13c689b-63b8-4ded-8969-e7e3da7e2e76.png",
    //                "price": 444
    //            },
    //            {
    //                "id": 20,
    //                "itemNm": "테스트3",
    //                "itemDetail": "333",
    //                "imgUrl": "/images/item/6e27af0f-c752-4d3a-8c40-419545b56522.jpg",
    //                "price": 333
    //            },
    @GET("/main2/{page}")
    fun getList(
        @Path("page") page: Int,
    ): retrofit2.Call<ItemListModel>

}