package com.busanit501.androidlabtest501.ch10_dialog_permission

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import android.util.Log
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
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

        // 커스텀 한 다이얼로그 창 띄우기.
        binding.ch10customDialBtn.setOnClickListener {
            AlertDialog.Builder(this@Ch10MainActivity).run {
                setTitle("커스텀 다이얼로그")
                setIcon(android.R.drawable.ic_dialog_info)
                setMessage("커스텀 다이얼로그 확인중~~~")
                setPositiveButton("수락", null)
                setNegativeButton("취소", null)
                setNeutralButton("더보기", null)
                show()
            }

        }

        // 커스텀 다이얼로그, 목록 요소 선택 처리.
        val items = arrayOf<String>("초밥","칼국수","두루치기","된장찌개")
        var checkItems = mutableMapOf<Int,Int>()
        var checkItems2 = mutableSetOf<Int>()
        var tempList = mutableListOf<String>()
        var resultStr :String =""

        binding.ch10customDialBtn2.setOnClickListener {
            AlertDialog.Builder(this@Ch10MainActivity).run {
                setTitle("커스텀 다이얼로그 목록")
                setIcon(android.R.drawable.ic_dialog_info)

                // 추가사항 , 메뉴 목록 추가
                val objectListener = object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Log.d(TAG,"선택한 점심 메뉴 : ${items[p1]}")
                        binding.ch10customResultTextView.text = "${items[p1]}"
                    }
                } //objectListener

                // 이벤트 핸들러 추가 및 목록 넣기
                setItems(items,objectListener)
                setPositiveButton("수락", null)
                setNegativeButton("취소", null)
                setNeutralButton("더보기", null)
                show()

            }
        }

        // 커스텀 다이얼로그, 중복 체크
        binding.ch10customDialBtn3.setOnClickListener {
            AlertDialog.Builder(this@Ch10MainActivity).run {
                setTitle("커스텀 다이얼로그 중복 체크")
                setIcon(android.R.drawable.ic_dialog_info)

                // 추가사항 , 메뉴 목록 추가
                // 목록 요소를 클릭 할 때마다, 익명 클래스의 이벤트 리스너가 동작을함.
                // 예) 체크, 언체크 반응을함.
                // 클릭한 목록의 인덱스 의 번호 , 체크의 여부
                val objectListener = object : DialogInterface.OnMultiChoiceClickListener {
                    override fun onClick(p0: DialogInterface?, which: Int, isChecked: Boolean) {
                        Log.d(TAG,"선택한 점심 메뉴 : ${items[which]}  ${if(isChecked) "선택됨" else "선택해제됨"}")
                        if(isChecked){
//                            checkItems.set(which,which)
                            checkItems2.add(which)
                            // 초밥 선택
                            // checkItems2 = {0}
                            // 칼국수 선택
                            // checkItems2 = {0, 1}
//                            for (i in 1..checkItems.size){
//                                resultStr += "${items[checkItems.get(i)!!]}"
//                            }
                        } else if (checkItems2.size > 0) {
//                            checkItems.remove(which)
                            checkItems2.remove(which)
                            // 초밥 선택 해제한 경우
                            // checkItems2 = {1}

                        }
                        // checkItems2 = {1}
                        resultStr =""
                        for(index in checkItems2){
                            if(checkItems2.size == 1 ) {
                                resultStr += items[index]
                            } else if(checkItems2.size == 2){
                                resultStr += items[index] + ", "
                                if(index == 1) {
                                    resultStr += items[index]
                                }

                            } else if(checkItems2.size == 3){
                                resultStr += items[index] + ", "
                                if(index == 2) {
                                    resultStr += items[index]
                                }

                            }  else if(checkItems2.size == 4){
                                resultStr += items[index] + ", "
                                if(index == 3) {
                                    resultStr += items[index]
                                }

                            }

                        }
//                        for (i in 1..checkItems2.size){
//                            resultStr += "${items[checkItems2.get(i)!!]}"
//                        }

                        Log.d(TAG,"선택한 점심 메뉴 :${resultStr} ")
//                        binding.ch10customResultTextView2.text = "${items[which]}"
                        binding.ch10customResultTextView2.text = resultStr
                    }
                } //objectListener

                // 이벤트 핸들러 추가 및 목록 넣기
//                setItems(items,objectListener)
                setMultiChoiceItems(items, booleanArrayOf(false,false,false,false),objectListener)
                setPositiveButton("수락", null)
                setNegativeButton("취소", null)
                setNeutralButton("더보기", null)
                show()
            }
        }

        // 하나 선택하기.
        binding.ch10customDialBtn4.setOnClickListener {
            AlertDialog.Builder(this@Ch10MainActivity).run {
                setTitle("커스텀 다이얼로그 하나 체크")
                setIcon(android.R.drawable.ic_dialog_info)

                // 추가사항 , 메뉴 목록 추가
                val objectListener = object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Log.d(TAG,"선택한 점심 메뉴 : ${items[p1]}")
                        binding.ch10customResultTextView3.text = "${items[p1]}"
                    }
                } //objectListener

//                setMultiChoiceItems(items, booleanArrayOf(false,false,false,false),objectListener)
                // 뒤로 가기 버튼 터치시 알림창 끄기 옵션
                setCancelable(false)
                setSingleChoiceItems(items,1,objectListener)
                setPositiveButton("수락", null)
                setNegativeButton("취소", null)
                setNeutralButton("더보기", null)
                show()

            }.setCanceledOnTouchOutside(false) // 알림 창 바깥부분 터치시 알림창 끄는 옵션
        }


        // 소리 알림음 테스트

        binding.ch10soundBtn.setOnClickListener {
            val notification : Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            // this@Ch10MainActivity -> applicationContext, Context
            val ringtone = RingtoneManager.getRingtone(this@Ch10MainActivity, notification)
            ringtone.play()
        }

        // resources -> raw -> mp3 음원 재생 해보기.
        binding.ch10soundBtn2.setOnClickListener {
            val player: MediaPlayer = MediaPlayer.create(this@Ch10MainActivity, R.raw.test_music)
            player.start()
        }


        // 진동 테스트
        binding.ch10vibrateBtn.setOnClickListener {
            val vibrator = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE)
                as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                getSystemService(VIBRATOR_SERVICE) as Vibrator
            }

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(500,
                        VibrationEffect.DEFAULT_AMPLITUDE)
                )
            } else {
                vibrator.vibrate(500)
            }
        }

    }// onCreate
}