package com.busanit501.androidlabtest501.ch18_network

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.busanit501.androidlabtest501.ch18_network.adapter.MyAdapterRetrofit3
import com.busanit501.androidlabtest501.ch18_network.model.PublicModel.ItemListModel
import com.busanit501.androidlabtest501.ch18_network.model.publicmodel2.PriceListModel
import com.busanit501.androidlabtest501.ch18_network.retrofit.MyApplication5
import com.busanit501.androidlabtest501.databinding.ActivityPriceMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PriceMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityPriceMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPriceMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // rest 리팩토링, 테스트
        // 부산 도보 여행
//        restGetData(1)
        // 부산 맛집 정보 서비스
//        restGetData(2)
        // 뉴스 API
//        restGetData(3)

        // 공공 데이터 착한가격업소 API
        restGetData(4)

    } // onCreate

    //리팩토링 재료
    // 1) ItemListModel 1,2 , 2) getWalkingKr,getFoodKr 3) retrofitRecyclerView 3,4
    private fun restGetData(status : Int) {


        if (status == 4) {
            val networkService = (applicationContext as MyApplication5).networkService5
            val serviceKey3 =
                "ALRX9GpugtvHxcIO/iPg1vXIQKi0E6Kk1ns4imt8BLTgdvSlH/AKv+A1GcGUQgzuzqM3Uv1ZGgpG5erOTDcYRQ=="
            val resultType = "json"
            val userListCall = networkService.getList2(serviceKey3, 1, 100, resultType)
            userListCall.enqueue(object : Callback<PriceListModel> {
                //익명 클래스가, Callback , 레트로핏2에서 제공하는 인터페이스를 구현했고,
                // 반드시 재정의해야하는 함수들이 있음.
                // 변경4
                override fun onResponse(
                    call: Call<PriceListModel>,
                    response: Response<PriceListModel>
                ) {
                    // 데이터를 성공적으로 받았을 때 수행되는 함수
                    val userList = response.body()
                    // 변경8
                    Log.d("lsy", "userList의 값 : ${userList?.getWalkingKr}")

                    // 데이터를 성공적으로 받았다면, 여기서 리사이클러 뷰 어댑터에 연결하면 됨.
                    // 리사이클러뷰 의 레이아웃 정하는 부분, 기본인 LinearLayoutManager 이용했고,

                    //변경6


                    val layoutManager = LinearLayoutManager(
                        this@PublicDataTestActivity
                    )
                    layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                    // 리사이클러뷰에 어댑터 연결
                    // 인자값은 : 현재 context : this@HttpTestReqResActivity
                    // 2번째 인자값은 : 데이터 , 네트워크 ,레트로핏2 통신으로 받아온 데이터 리스트

                    //변경7
                    binding.retrofitRecyclerView3.layoutManager = layoutManager
                    // 변경9 주의사항, 객체 안에 배열 또 있다.
                    binding.retrofitRecyclerView3.adapter =
                        MyAdapterRetrofit3(
                            this@PublicDataTestActivity,
                            userList?.getWalkingKr?.item
                        )

                }

                //변경5
                override fun onFailure(call: Call<ItemListModel>, t: Throwable) {

                    // 데이터를 못 받았을 때 수행되는 함수
                    call.cancel()
                }

            })

        }
    }
} // 함수 끝