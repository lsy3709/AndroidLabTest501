package com.busanit501.androidlabtest501.ch11_jetpack.viewpage2.adapter

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh11Viewpager2TestFragmentMainBinding

class Ch11Viewpager2TestFragmentMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityCh11Viewpager2TestFragmentMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh11Viewpager2TestFragmentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_ch11_viewpager2_test_fragment_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}