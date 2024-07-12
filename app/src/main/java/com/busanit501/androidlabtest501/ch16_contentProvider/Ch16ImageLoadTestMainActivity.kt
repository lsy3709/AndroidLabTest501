package com.busanit501.androidlabtest501.ch16_contentProvider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh16ImageLoadTestMainBinding

class Ch16ImageLoadTestMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityCh16ImageLoadTestMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh16ImageLoadTestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_ch16_image_load_test_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 사진을 가지고 왔을 때, 자동 호출되는 함수를 정의

        // 갤러리 호출하는 버튼, 이벤트 처리 후처리 함수를 호출

        // 뷰에 버튼 추가, 결과 이미지 넣을 이미지 뷰 추가.


    } //onCreate
}