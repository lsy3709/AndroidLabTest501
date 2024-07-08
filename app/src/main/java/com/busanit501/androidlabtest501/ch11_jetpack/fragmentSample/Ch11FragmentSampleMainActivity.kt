package com.busanit501.androidlabtest501.ch11_jetpack.fragmentSample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.busanit501.androidlabtest501.R

class Ch11FragmentSampleMainActivity : AppCompatActivity() {
    private val fragments = listOf(SecondFragment(), ThirdFragment(), FourthFragment())
    private var currentFragmentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ch11_fragment_sample_main)

        // 초기 프래그먼트 설정
        if (savedInstanceState == null) {
            val initialFragment = FirstFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, initialFragment)
                .commit()
        }
    }

    // 프래그먼트 전환 메서드
    private fun showFragment(index: Int) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragments[index])
        transaction.addToBackStack(null) // 백스택에 추가
        transaction.commit()
    }

    // 다음 프래그먼트로 이동
    fun showNextFragment() {
        if (currentFragmentIndex < fragments.size - 1) {
            currentFragmentIndex++
            showFragment(currentFragmentIndex)
        }
    }

    // 이전 프래그먼트로 이동
    fun showPreviousFragment() {
        if (currentFragmentIndex > 0) {
            currentFragmentIndex--
            showFragment(currentFragmentIndex)
        }
    }
}