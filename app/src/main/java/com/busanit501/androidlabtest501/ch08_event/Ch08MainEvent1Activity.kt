package com.busanit501.androidlabtest501.ch08_event

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R

class Ch08MainEvent1Activity : AppCompatActivity() {

    val TAG = "Ch08MainEvent1Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ch08_main_event1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }//onCreate

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        // key , 터치 확인, 수정
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d(TAG,"ACTION_DOWN : Down key 동작 확인")
            }

            MotionEvent.ACTION_UP -> {
                Log.d(TAG,"ACTION_UP : Up key 동작 확인")
            }
        }

        return super.onTouchEvent(event)

    }
}