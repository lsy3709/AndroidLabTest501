package com.busanit501.androidlabtest501.ch11_jetpack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.ch11_jetpack.fragments.Ch11OneFragment
import com.busanit501.androidlabtest501.ch11_jetpack.fragments.Ch11ThreeFragment
import com.busanit501.androidlabtest501.ch11_jetpack.fragments.Ch11TwoFragment
import com.busanit501.androidlabtest501.databinding.ActivityCh11MainFragmentBinding

class Ch11MainFragmentActivity : AppCompatActivity() {

    lateinit var binding: ActivityCh11MainFragmentBinding

    //순서1, 프래그먼트 그리기 위한 빈 도화지 역할. 액티비티 만들기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh11MainFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_ch11_main_fragment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 액티비티 위에, 프래그먼트를, fragment 정적 태그 이용해서 단순 출력도 가능하고,
        // 코틀린파일에서, 제어도 가능, 프래그먼트, 추가, 교체, 삭제등 제어가 가능.

        val fragmentManager : FragmentManager = supportFragmentManager
        val transaction : FragmentTransaction = fragmentManager.beginTransaction()

        // 각각 3개의 프래그먼트 인스턴스 생성하기.
        val oneFragment = Ch11OneFragment()
        val twoFragment = Ch11TwoFragment()
        val threeFragment = Ch11ThreeFragment()

        // 기본은 정적인 뷰에 순서대로 붙이기 작업.
        // 화면에, 동적으로, 프래그먼트 붙이기 작업.
        transaction.add(R.id.ch11FragmentView1, threeFragment)
        transaction.add(R.id.ch11FragmentView2, twoFragment)
        transaction.add(R.id.ch11FragmentView3, oneFragment)

        // 뷰 페이저2, 프래그먼트 전달시, 다시 재확인
        // 생명주기랑 관련이 있음.
        // 잠시 대기.
        // 교체 작업시, 사용 다시 해보기.
//        transaction.addToBackStack(null)


        // 화면에 반영하기.
        transaction.commit()


    } //onCreate
} //