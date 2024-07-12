package com.busanit501.androidlabtest501.ch18_network

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.ch18_network.model.Blog
import com.busanit501.androidlabtest501.ch18_network.retrofit.MyApplication4
import com.busanit501.androidlabtest501.databinding.ActivityTestSpringBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestSpringActivity : AppCompatActivity() {
    lateinit var binding : ActivityTestSpringBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestSpringBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // spring에서 데이터 받아와서 결과 뷰에 넣기.

        // 변경1
        val networkService = (applicationContext as MyApplication4).networkService

        val userListCall = networkService.getList2()

        userListCall.enqueue(object : Callback<List<Blog>> {
            //익명 클래스가, Callback , 레트로핏2에서 제공하는 인터페이스를 구현했고,
            // 반드시 재정의해야하는 함수들이 있음.
            // 변경4
            override fun onResponse(call: Call<List<Blog>>, response: Response<List<Blog>>) {
                // 데이터를 성공적으로 받았을 때 수행되는 함수
                val userList = response.body()
                // 변경8
                Log.d("lsy","userList의 값 : ${userList}")
                binding.springTestResultView.text = userList?.get(0)?.content

                // 데이터를 성공적으로 받았다면, 여기서 리사이클러 뷰 어댑터에 연결하면 됨.
                // 리사이클러뷰 의 레이아웃 정하는 부분, 기본인 LinearLayoutManager 이용했고,


            }

            //변경5
            override fun onFailure(call: Call<List<Blog>>, t: Throwable) {

                // 데이터를 못 받았을 때 수행되는 함수
                call.cancel()
                Log.d("lsy","cancel")
            }

        })

    }
}