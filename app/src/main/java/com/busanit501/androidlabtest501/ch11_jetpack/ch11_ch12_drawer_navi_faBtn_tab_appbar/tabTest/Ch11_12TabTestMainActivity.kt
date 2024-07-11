package com.busanit501.androidlabtest501.ch11_jetpack.ch11_ch12_drawer_navi_faBtn_tab_appbar.tabTest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.ch11_jetpack.ch11_ch12_drawer_navi_faBtn_tab_appbar.ViewPageAdapterTest
import com.busanit501.androidlabtest501.databinding.ActivityCh1112TabTestMainBinding

class Ch11_12TabTestMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityCh1112TabTestMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh1112TabTestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_ch1112_tab_test_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 뷰페이저 어댑터 연결 필요. 어댑터 어제 만들었던 뷰페이저용, 어댑터 재사용.
        binding.ch1112TabViewpager1.adapter = ViewPageAdapterTest(this@Ch11_12TabTestMainActivity)


        // 탭 레이아웃 이벤트 및 탭 연결 작업 필요.

        // 탭에 우리가 지정한 아이콘 붙이기 작업.




    } //onCreate
}