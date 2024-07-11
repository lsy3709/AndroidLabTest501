package com.busanit501.androidlabtest501.ch11_jetpack.ch11_ch12_drawer_navi_faBtn_tab_appbar.tabTest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.FragmentTabTest1Binding
import com.busanit501.androidlabtest501.databinding.FragmentTabTest2Binding

class TabTest2Fragment : Fragment() {
    lateinit var binding: FragmentTabTest2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTabTest2Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabTest2Binding.inflate(layoutInflater,container,false)
        // 이 데이터 들은 , 외부에서, 레트로핏 , 통신 라이브러리 이용해서, 데이터 받아와야함.
        return binding.root
    }
}