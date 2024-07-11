package com.busanit501.androidlabtest501.ch11_jetpack.ch11_ch12_drawer_navi_faBtn_tab_appbar.tabTest

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.ch11_jetpack.ch11_ch12_drawer_navi_faBtn_tab_appbar.ViewPageAdapterTest
import com.busanit501.androidlabtest501.databinding.ActivityCh1112TabTestMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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
        binding.ch1112TabViewpager1.adapter = ViewPageAdapterTest2(this@Ch11_12TabTestMainActivity)

        val viewPager: ViewPager2 = findViewById(R.id.ch11_12_Tab_viewpager1)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        //탭 아이콘 꾸미기, 이미지 추가.
        val tabIcons = arrayOf(
            R.drawable.home_icon,
            R.drawable.favorite_icon,
            R.drawable.multi_view_comfy_icon,
            R.drawable.share_icon
        )

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(tabIcons[position])
        }.attach()

        // 탭 레이아웃 이벤트 및 탭 연결 작업 필요.

        // 탭에 우리가 지정한 아이콘 붙이기 작업.




    } //onCreate
}