package com.busanit501.androidlabtest501.ch11_jetpack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh11Main2Binding

class Ch11MainToolBarActivity : AppCompatActivity() {
    lateinit var binding: ActivityCh11Main2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh11Main2Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_ch11_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //툴바 붙이기 작업.
        setSupportActionBar(binding.ch11toolbarSample)


    } //onCreate




} //Ch11MainToolBarActivity