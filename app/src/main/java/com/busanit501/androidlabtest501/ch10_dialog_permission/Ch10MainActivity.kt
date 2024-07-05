package com.busanit501.androidlabtest501.ch10_dialog_permission

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh10MainBinding
import com.busanit501.androidlabtest501.miniProject.test0703.lsy1205_mini.Lsy1205MainActivity

class Ch10MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityCh10MainBinding
    lateinit var TAG:String

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityCh10MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        TAG = "Ch10MainActivity"

//        setContentView(R.layout.activity_ch10_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //퍼미션 체크 해보기.
        val status = ContextCompat.checkSelfPermission(this@Ch10MainActivity,
            "android.permission.ACCESS_FINE_LOCATION")

        if(status == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this@Ch10MainActivity,"위치 권한 승인됨", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this@Ch10MainActivity,"위치 권한 승인 안됨", Toast.LENGTH_LONG).show()
        }

        //후처리 작업 , 1) 권한, 2) 데이터
        // 정의
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            isGranted ->
            if(isGranted) {
                Toast.makeText(this@Ch10MainActivity,"권한이 승인됨, 후처리 콜백 요청", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@Ch10MainActivity,"권한이 승인 안됨, 후처리 콜백 요청", Toast.LENGTH_LONG).show()
            }
        }

        //이용
        requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")

        // 버튼 , 클릭시, 토스트 메세지 후처리 확인 해보기
        binding.ch10sampleBtn.setOnClickListener {
            // 토스트 메시지가 뜨고나서 후처리 액션, 사라지고 나서 후처리 액션,
            val toast = Toast.makeText(this@Ch10MainActivity,"토스트 메세지 출력 또는 사라질 경우 후처리 동작 확인", Toast.LENGTH_LONG)

            //콜백 함수 추가하기.
            toast.addCallback(
                @RequiresApi(Build.VERSION_CODES.R)
                object : Toast.Callback() {
                    //나타 날 때, 후처리 동작 추가
                    override fun onToastShown() {
                        super.onToastShown()
                        Log.d(TAG,"토스트가 나타날 때 동작하는 로그")
                        //화면 이동도 추가해보기.
                        val intent = Intent(this@Ch10MainActivity, Lsy1205MainActivity::class.java)
                        startActivity(intent)
                    }
                    //사라질 때, 후처리 동작 추가
                    override fun onToastHidden() {
                        super.onToastHidden()
                        Log.d(TAG,"토스트가 사라질 때 동작하는 로그")
                    }
                }
            )
            toast.show()
        }


        // 날 짜 데이터 피커 확인 해보기.
        binding.ch10dateBtn2.setOnClickListener {
            // object, 익명 클래스, 1회용 클래스, 이벤트 처리시 자주 사용됨.
            DatePickerDialog(this@Ch10MainActivity, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayofMonth: Int) {
                    Log.d(TAG,"년도 : ${year}년, 월 : ${month+1}월 , 일 : ${dayofMonth}일")
                    Toast.makeText(this@Ch10MainActivity,"년도 : ${year}년, 월 : ${month+1}월 , 일 : ${dayofMonth}일", Toast.LENGTH_LONG).show()
                    binding.ch10dateResultTextView.text = "${year}년, ${month+1}월 , ${dayofMonth}일"
                }

            },2024,6,5).show()
        }


        // 시간 데이터 피커 확인 해보기.
        binding.ch10timeBtn2.setOnClickListener {
            TimePickerDialog(this@Ch10MainActivity, object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
                    Log.d(TAG,"시간 , ${hour}시, ${minute}분")
                    Toast.makeText(this@Ch10MainActivity,"시간 , ${hour}시, ${minute}분", Toast.LENGTH_LONG).show()
                    binding.ch10timeResultTextView.text = "시간 , ${hour}시, ${minute}분"
                }
            }, 11,40,true).show()
        } // 닫기

    }// onCreate
}