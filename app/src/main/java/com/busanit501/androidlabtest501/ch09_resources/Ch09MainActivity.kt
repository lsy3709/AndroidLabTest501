package com.busanit501.androidlabtest501.ch09_resources

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowMetrics
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R

class Ch09MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ch09_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 본인 실물 기기, 에뮬레이터에서, 해당 기기 지원하는 가로 세로 크기 정보 조회.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            val windowMetrics: WindowMetrics = windowManager.currentWindowMetrics
            Log.d("Ch09MainActivity","width : ${windowMetrics.bounds.width()}" +
                    ", heigt : ${windowMetrics.bounds.height()}")
        }
    }
}