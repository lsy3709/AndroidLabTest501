package com.busanit501.androidlabtest501.ch18_2_pagingTest

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityPagingTestBinding
import com.example.myapp_test_7_8_9_10_11_12.ch18_Test.retrofit.MyApplication4
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PagingTestActivity : AppCompatActivity() {
    lateinit var binding : ActivityPagingTestBinding

    lateinit var datas: MutableList<String>
    lateinit var datasSpring: MutableList<ItemModel2>

    lateinit var layoutManager : LinearLayoutManager

    val recycler: RecyclerView by lazy {
        binding.pagingRecyclerView
    }


    var cnt : Int = 10;
    var page : Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagingTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 더미 데이터로 텍스트만 임시로 사용하지만,
        // 공공데이터, 사용자 정의한 데이터를 가지고 와서,
        // 원하는 뷰에 데이터를 넣는 , 바인딩 작업을 함.
        datas = mutableListOf<String>()

        datasSpring = mutableListOf<ItemModel2>()

        layoutManager = LinearLayoutManager(this@PagingTestActivity)

        //로컬 테스트 , 더미데이터
        for(i in 1..10) {
            datas.add("라바 $i")
        }

        // 레트로핏 데이터 받아오기.
        // 변경1
        val networkService = (applicationContext as MyApplication4).networkServiceSpringShop

        Log.d("lsy", "최초 page 번호============================= : ${page}")
        val shopMainListCall = networkService.getList(page)

        //변경3
        // 실제 통신이 시작이 되는 부분, 이 함수를 통해서 데이터를 받아옴.
        shopMainListCall.enqueue(object : Callback<ItemListModel> {
            //익명 클래스가, Callback , 레트로핏2에서 제공하는 인터페이스를 구현했고,
            // 반드시 재정의해야하는 함수들이 있음.
            // 변경4
            override fun onResponse(call: Call<ItemListModel>, response: Response<ItemListModel>) {
                // 데이터를 성공적으로 받았을 때 수행되는 함수
                val shopMainList = response.body()

                // 변경8
                Log.d("lsy","데이터 받기 성공=========================================================================")
                Log.d("lsy","shopMainList 값 : ${shopMainList?.items?.content}")
                Log.d("lsy","shopMainList 값 : ${shopMainList?.items?.content?.get(0)?.itemNm}")


                // 데이터를 성공적으로 받았다면, 여기서 리사이클러 뷰 어댑터에 연결하면 됨.
                // 리사이클러뷰 의 레이아웃 정하는 부분, 기본인 LinearLayoutManager 이용했고,

                // 기본 값으로 세로 방향 출력.
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
                // 가로 방향으로 출력 해보기.
//                layoutManager = LinearLayoutManager(this@PagingTestActivity)
                recycler.layoutManager = layoutManager
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                shopMainList?.items?.content?.let { datasSpring.addAll(it) }
//             recycler.adapter = shopMainList?.items?.content?.let { PagingRecyclerAdapter(it) }

                Log.d("lsy","최초 어댑터 추가하기 전 datasSpring.size  =========================================  : ${datasSpring.size}")
                recycler.adapter = PagingRecyclerAdapter(datasSpring)
                Log.d("lsy","최초 어댑터 추가하기 후 datasSpring.size  =========================================  : ${datasSpring.size}")


                // 구분선 넣기, 나중에 옵션으로 배경이미지도 넣기 가능.
                recycler.addItemDecoration(
                    DividerItemDecoration(this@PagingTestActivity,
                        LinearLayoutManager.VERTICAL)
                )

            }

            //변경5
            override fun onFailure(call: Call<ItemListModel>, t: Throwable) {
                Log.d("lsy"," 통신실패")
                // 데이터를 못 받았을 때 수행되는 함수
                call.cancel()
            }

        })



        // 로컬 , 임시 더미 데이터로 , 스크롤 리스너 테스트
        // 스프링, shop에서, main 부분 , 페이징으로 받아와서 추가하기.
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val lastVisibleItemPosition =
                    layoutManager!!.findLastCompletelyVisibleItemPosition() // 화면에 보이는 마지막 아이템의 position
                Log.d("lsy", "lastVisibleItemPosition =========================== : ${lastVisibleItemPosition}")
                val itemTotalCount =
                    recyclerView.adapter!!.itemCount - 1 // 어댑터에 등록된 아이템의 총 개수 -1
                Log.d("lsy", "itemTotalCount =========================== : ${itemTotalCount}")
                // 스크롤이 끝에 도달했는지 확인
                if (lastVisibleItemPosition == itemTotalCount) {
//                        isLoading = true
                    Log.d("lsy", "스크롤 끝")
                    page += 1
//                    Log.d("lsy", "pageNO : ${pageNo}, numOfRows: ${numOfRows}")
//                    for(i in 1..10) {
//                        datas.add("라바 $i + $cnt")
//                        cnt++
//                    }
                    Log.d("lsy", "데이터 추가됨.")
                    Log.d("lsy", "page 스크롤 이벤트 후 페이지 ====================================================: ${page}")
                    // 로컬 데이터 추가.
//                    getData()
//                    (binding.pagingRecyclerView.adapter as PagingRecyclerAdapter).notifyDataSetChanged()

                    // 스프링 데이터 추가 부분.
                    retrofitGetData(page)


                }
            }
        })



    } // onCreate
    // 샘플 더미 데이터
    fun getData() {
        for(i in 1..10) {
            datas.add("라바 $i + $cnt")
            cnt++
        }
    }

    fun getData2(datas2: MutableList<ItemModel2>?) {
        Log.d("lsy","getData2 함수 호출 시작.")
        Log.d("lsy","getData2 함수 호출 시작2.datasSpring size 값 : ${datasSpring?.size} ")
        datasSpring?.size?.let {
            recycler.adapter?.notifyItemInserted(
                it.minus(1)
            )
        }
        if (datasSpring?.size != null){
            datasSpring?.addAll(datas2 as Collection<ItemModel2>)
        }
        recycler.adapter?.notifyDataSetChanged()

    }

    // retrofit , 스프링로 부터 데이터 받기, 각 페이지 마다, 데이터 받기.
    fun retrofitGetData(page2 : Int) {
        // 레트로핏 데이터 받아오기.
        // 변경1
        val networkService = (applicationContext as MyApplication4).networkServiceSpringShop

        val shopMainListCall = networkService.getList(page2)

        //변경3
        // 실제 통신이 시작이 되는 부분, 이 함수를 통해서 데이터를 받아옴.
        shopMainListCall.enqueue(object : Callback<ItemListModel> {
            //익명 클래스가, Callback , 레트로핏2에서 제공하는 인터페이스를 구현했고,
            // 반드시 재정의해야하는 함수들이 있음.
            // 변경4
            override fun onResponse(call: Call<ItemListModel>, response: Response<ItemListModel>) {
                // 데이터를 성공적으로 받았을 때 수행되는 함수
                val shopMainList = response.body()
                // 변경8
                Log.d("lsy","shopMainList 이벤트 스크롤 후 ========================================= 값 : ${shopMainList?.items?.content}")
//                            Log.d("lsy","shopMainList 이벤트 스크롤 후 ========================================= 값 : ${shopMainList?.items?.content?.get(0)?.id}")
                if(shopMainList != null && shopMainList.items.content?.isNotEmpty() == true) {
                    Log.d("lsy","getData2 호출전 size 이벤트 스크롤 후 =========================================  : ${shopMainList?.items?.content.size}")
                    Log.d("lsy","getData2 호출전 datasSpring.size 이벤트 스크롤 후 =========================================  : ${datasSpring.size}")
                    getData2(shopMainList?.items?.content)
                }


            }

            //변경5
            override fun onFailure(call: Call<ItemListModel>, t: Throwable) {
                Log.d("lsy"," 통신실패")
                // 데이터를 못 받았을 때 수행되는 함수
                call.cancel()
            }

        })
    }




}