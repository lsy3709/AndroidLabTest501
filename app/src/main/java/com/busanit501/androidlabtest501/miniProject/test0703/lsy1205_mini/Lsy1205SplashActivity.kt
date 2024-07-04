package com.busanit501.androidlabtest501.miniProject.test0703.lsy1205_mini

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R

class Lsy1205SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //인트로 화면에서, 3초후, 메인 화면으로 이동하기.
        val handler = Handler()
        handler.postDelayed(Runnable {
            //intent:  시스템에게 무언가 요구할 때 전달할 메세지로 사용하는 용도
            // 시스템아 나 다른 페이지로 이동 시켜줘.
            //예) 시스템아 나 갤러리 화면에서 사진 선택하고 싶으니, 거기로 이동시켜줘.
            // 예2) 시스탐아 나 다른 화면에 데이터도 같이 전달할게, 전달해줘.
            val intent = Intent(this,Lsy1205MainActivity::class.java)
            // 메세지 전달하기.
            startActivity(intent)
            // 현재 액티비티를 종료한다.
            finish()
        }, 3000)

        enableEdgeToEdge()
        setContentView(R.layout.activity_lsy1205_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }//onCreate
}//Lsy1205SplashActivity