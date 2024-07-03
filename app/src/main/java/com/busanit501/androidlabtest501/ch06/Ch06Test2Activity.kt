package com.busanit501.androidlabtest501.ch06

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh06Test2Binding

class Ch06Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // 뷰 바인딩을 사용하기전의 , 설정1
//        setContentView(R.layout.activity_ch06_test2)
        // 뷰 바인딩 사용 해보기.
        // xml, 레이아웃 파일명 확인: activity_ch06_test2
        val binding = ActivityCh06Test2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        // 뷰 바인딩 사용 해보기.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 뷰 바인딩 사용하기 전에.
        val ch06Mid : EditText = findViewById<EditText>(R.id.ch06Mid)
        val ch06Mpw : EditText = findViewById<EditText>(R.id.ch06Mpw)
        val ch6LoginBtn = findViewById<Button>(R.id.ch6LoginBtn)

        ch6LoginBtn.setOnClickListener {
            Toast.makeText(this@Ch06Test2Activity,"mid:${ch06Mid.text.toString()}, mpw:${ch06Mpw.text.toString()}",Toast.LENGTH_LONG).show()
        }

        //뷰바인딩 이용해서, 특정 요소를 선택후, 이벤트 리스너 이용해보기.
        val mid2 = binding.ch06Mid
        val mpw2 = binding.ch06Mpw
        val ch6LoginBtn2 = binding.ch6LoginBtn

        ch6LoginBtn2.setOnClickListener {
            Toast.makeText(this@Ch06Test2Activity,"mid:${mid2.text.toString()}, mpw:${mpw2.text.toString()}",Toast.LENGTH_LONG).show()
        }

    }
}