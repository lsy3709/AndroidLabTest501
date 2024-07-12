package com.busanit501.androidlabtest501.ch18_2_pagingTest


// 받아온 데이터 형식을 보고 정해야함.
// 중요함.
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
class ItemListModel (
    // 변수명, 넘어온 데이터 변수명 일치하기.
    val items : Items
)

class Items (
    val content : MutableList<ItemModel2>?
)

class ItemModel2 {
    var id : String? = null
    var itemNm : String? = null
    var itemDetail : String? = null

}