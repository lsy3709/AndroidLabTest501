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

class Ch06Test2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ch06_test2)
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

    }
}