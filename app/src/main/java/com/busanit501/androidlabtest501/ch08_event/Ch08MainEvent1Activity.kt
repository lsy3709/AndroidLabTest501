package com.busanit501.androidlabtest501.ch08_event

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
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
                Log.d(TAG,"ACTION_DOWN : Down key 동작 확인,좌표 : x : ${event.x}, y:${event.y} , rawX : ${event.rawX}, rawY : ${event.rawY}")
            }

            MotionEvent.ACTION_UP -> {
                Log.d(TAG,"ACTION_UP : Up key 동작 확인")
            }
        }

        return super.onTouchEvent(event)

    } // onTouchEvent

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_0 -> Log.d(TAG,"KEYCODE_0, 숫자 0번 동작 확인")
            KeyEvent.KEYCODE_A -> Log.d(TAG,"KEYCODE_A, A 키 동작 확인")
            KeyEvent.KEYCODE_ENTER -> Log.d(TAG,"KEYCODE_ENTER, enter 키 동작 확인")
            KeyEvent.KEYCODE_BACK -> Log.d(TAG,"KEYCODE_BACK, 뒤로가기 키 동작 확인")
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d(TAG,"KEYCODE_VOLUME_UP, 볼륨업 키 동작 확인")
            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d(TAG,"KEYCODE_VOLUME_DOWN, 볼륨다운 키 동작 확인")
        }
        return super.onKeyDown(keyCode, event)
    }
}