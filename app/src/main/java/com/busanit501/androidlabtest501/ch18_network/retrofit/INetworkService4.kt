package com.busanit501.androidlabtest501.ch18_network.retrofit
import com.busanit501.androidlabtest501.ch18_network.model.Blog
import retrofit2.http.GET

// 통신 라이브러리 : retrofit2 이용해서,
// 인터페이스, 추상 메서드를 만들어서,
// 레트로핏한테 전달 : 인터페이스 통으로 전달하면,
// 여기에 정의된 함수를 이용해서, 통신을 함. crud.
interface INetworkService4 {
    // https://newsapi.org/v2/everything?q=Apple&from=2023-10-10&sortBy=popularity&apiKey=87af28a1123a4fcc9c869c0b81bd243c
    // baseurl :https://newsapi.org
    // 주소 기본값에 이어서 뒤에 추가 주소 설정. -> v2/everything
    // 쿼리 설정으로 파라미터값 설정.  ->?q=Apple&from=2023-10-10&sortBy=popularity&apiKey=87af28a1123a4fcc9c869c0b81bd243c

    //http://apis.data.go.kr/6260000/WalkingService/getWalkingKr?serviceKey=인증키&numOfRows=10&pageNo=1
    //예시
    //https://apis.data.go.kr/6260000/WalkingService/getWalkingKr?serviceKey=ALRX9GpugtvHxcIO%2FiPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH%2FAKv%2BA1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ%3D%3D&pageNo=1&numOfRows=100&resultType=json
    @GET("list")
    fun getList2(

    ): retrofit2.Call<List<Blog>>

}