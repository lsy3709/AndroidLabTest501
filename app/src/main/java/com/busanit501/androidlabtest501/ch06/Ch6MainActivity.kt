package com.busanit501.androidlabtest501.ch06

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R

// 부모 클래스를 상속 AppCompatActivity()
class Ch6MainActivity : AppCompatActivity() {
    // 부모 클래스에도 메서드가 재정의.
    override fun onCreate(savedInstanceState: Bundle?) {
        // savedInstanceState: Bundle?, 임시 저장소, 메모리상에,
        // 상속의 기본에서, 부모꺼 먼저 , 초기화 해야함. -> 자식이 이용가능함.
        super.onCreate(savedInstanceState)
        // 화면상에서, 각 버전마다, 모서리 부분의 처리 유무
        enableEdgeToEdge()
        // 액티비티 역할, 화면을 그려준다. 이 화면을 그려줘 : R.layout.activity_ch6_main
        setContentView(R.layout.activity_ch6_main)
        // 시스템 바, 이것의 패딩을 지정해서, 기본 공간 확보.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 화면을 그리는 용도 보다, 로직 처리를 한다.
        //예) xml 화면 요소를 그리기, 해당 요소를 선택해서, 이벤트 처리를 한다.
        // 예2) 데이터 송수신.

        // 샘플 버튼 클릭시 이벤트 처리,
        val sampleBtn : Button = findViewById<Button>(R.id.sampleBtn1)
        sampleBtn.setOnClickListener {
            println("sampleBtn 클릭 확인.")
        }

    }
}