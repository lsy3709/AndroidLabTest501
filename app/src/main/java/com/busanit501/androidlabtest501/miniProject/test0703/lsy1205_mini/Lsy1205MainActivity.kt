package com.busanit501.androidlabtest501.miniProject.test0703.lsy1205_mini

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityLsy1205MainBinding


class Lsy1205MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityLsy1205MainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
//        setContentView(R.layout.activity_lsy1205_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //버튼 요소 선택하기. 로그인 이동하기
        binding.ch06LsyLoginBtn.setOnClickListener {
            //로그인 버튼 클릭시, 로그인 페이지 이동하기.
            val intent = Intent(this,Lsy1205LoginActivity::class.java)
            // 메세지 전달하기.
            startActivity(intent)
        }

        //버튼 요소 선택하기. 회원가입 이동하기
        binding.ch06LsyJoinBtn.setOnClickListener {
            //회원가입 버튼 클릭시, 회원가입 페이지 이동하기.
            val intent = Intent(this,Lsy1205JoinActivity::class.java)
            // 메세지 전달하기.
            startActivity(intent)
        }


    }
}