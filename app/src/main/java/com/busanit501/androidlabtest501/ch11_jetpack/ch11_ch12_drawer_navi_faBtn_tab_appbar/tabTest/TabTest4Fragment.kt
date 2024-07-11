package com.busanit501.androidlabtest501.ch11_jetpack.ch11_ch12_drawer_navi_faBtn_tab_appbar.tabTest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.FragmentTabTest3Binding
import com.busanit501.androidlabtest501.databinding.FragmentTabTest4Binding

class TabTest4Fragment : Fragment() {
    lateinit var binding: FragmentTabTest4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentTabTest4Binding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTabTest4Binding.inflate(layoutInflater,container,false)
        // 이 데이터 들은 , 외부에서, 레트로핏 , 통신 라이브러리 이용해서, 데이터 받아와야함.
        return binding.root
    }
}