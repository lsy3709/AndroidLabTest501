package com.busanit501.androidlabtest501.ch18_network.retrofit
import com.busanit501.androidlabtest501.ch18_network.model.Blog
import com.busanit501.androidlabtest501.ch18_network.model.PublicModel.ItemListModel
import com.busanit501.androidlabtest501.ch18_network.model.publicmodel2.PriceListModel
import retrofit2.http.GET
import retrofit2.http.Query

// 통신 라이브러리 : retrofit2 이용해서,
// 인터페이스, 추상 메서드를 만들어서,
// 레트로핏한테 전달 : 인터페이스 통으로 전달하면,
// 여기에 정의된 함수를 이용해서, 통신을 함. crud.
interface INetworkService5 {

//
//    부산착한가게업소
//
//    http://apis.data.go.kr/6260000/GoodPriceStoreService/getGoodPirceStore
//
//    인코딩 키
//    ALRX9GpugtvHxcIO/iPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH/AKv+A1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ==
//
//    브라우저에서, 데이터를 잘 받는지 확인용.
//    https://apis.data.go.kr/6260000/GoodPriceStoreService/getGoodPriceStore?serviceKey=ALRX9GpugtvHxcIO%2FiPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH%2FAKv%2BA1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ%3D%3D&pageNo=1&numOfRows=100&resultType=json
//

    @GET("GoodPriceStoreService/getGoodPriceStore")
    fun getList2(
        @Query("serviceKey") serviceKey: String?,
        @Query("pageNo") pageNo: Int,
        @Query("numOfRows") numOfRows: Int,
        @Query("resultType") resultType : String
    ): retrofit2.Call<PriceListModel>
}