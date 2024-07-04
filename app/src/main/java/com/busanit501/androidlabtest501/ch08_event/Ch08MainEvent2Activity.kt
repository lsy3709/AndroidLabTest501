package com.busanit501.androidlabtest501.ch08_event

import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh06Test2Binding
import com.busanit501.androidlabtest501.databinding.ActivityCh08MainEvent2Binding

//방법1, 인터페이스 구현으로 이벤트 처리하기.  : CompoundButton.OnCheckedChangeListener
class Ch08MainEvent2Activity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var binding :ActivityCh08MainEvent2Binding
    lateinit var TAG:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        TAG = "Ch08MainEvent2Activity"

        binding = ActivityCh08MainEvent2Binding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_ch08_main_event2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        방법1
        //해당 체크박스 뷰 요소와, 이벤트 리스너 연결해주기.
        binding.ch08CheckBox1.setOnCheckedChangeListener(this)

        // 방법2
        //해당 체크박스 뷰 요소와, 이벤트 리스너 연결해주기.
        binding.ch08CheckBox2.setOnCheckedChangeListener(MyEventHandler())

    } //onCreate

//    방법1
    //체크 박스 리스너
    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        Log.d(TAG,"checked Chaged 리스너 확인 중. 방법1 체크박스클릭. ${p1}")
    }

} //Ch08MainEvent2Activity


//방법2 , 클래스를 이용한 이벤트 리스너 사용하기.
class MyEventHandler : CompoundButton.OnCheckedChangeListener {
    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        Log.d("Ch08MainEvent2Activity","checked Chaged 리스너 확인 중.  방법2 체크박스클릭. ${p1}")
    }

}