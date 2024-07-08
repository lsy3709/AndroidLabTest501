package com.busanit501.androidlabtest501.ch11_jetpack

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh11MainBinding

class Ch11MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityCh11MainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh11MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_ch11_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //업버튼 화면 붙이기, 이벤트 작업 해보기.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



    } //onCreate

    // 액션바의 업버튼(뒤로가기 버튼)이벤트 처리기 붙이기.
    override fun onSupportNavigateUp(): Boolean {
        Toast.makeText(this@Ch11MainActivity,"백버튼 동작여부",Toast.LENGTH_LONG).show()
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}