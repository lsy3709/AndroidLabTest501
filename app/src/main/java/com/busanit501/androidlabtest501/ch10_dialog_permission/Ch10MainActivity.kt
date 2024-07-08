package com.busanit501.androidlabtest501.ch10_dialog_permission

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.SystemClock
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
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh10MainBinding
import com.busanit501.androidlabtest501.miniProject.test0703.lsy1205_mini.Lsy1205MainActivity
import kotlin.concurrent.thread

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
        var tempList2 = mutableListOf<Int>()


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
//
                            tempList2.add(which)
                            Log.d(TAG,"선택한 점심 메뉴1, add ${which}")
                            Log.d(TAG,"선택한 점심 메뉴2, add ${tempList2.toString()}")

                        } else  {
//
                            tempList2.remove(which)
                            Log.d(TAG,"선택한 점심 메뉴3, remove ${which}")
                            Log.d(TAG,"선택한 점심 메뉴4, remove ${tempList2.toString()}")


                        }

                        val selectedItemsString = tempList2.joinToString { items[it] }
                        Log.d(TAG, "Currently selected items: $selectedItemsString")


                        Log.d(TAG,"선택한 점심 메뉴 결과 :${selectedItemsString} ")
//                        binding.ch10customResultTextView2.text = "${items[which]}"
                        binding.ch10customResultTextView2.text = selectedItemsString
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
                // 기본 진동이고
//                vibrator.vibrate(
//                    VibrationEffect.createOneShot(500,
//                        VibrationEffect.DEFAULT_AMPLITUDE)
//                )

                // 진동에 특정 패턴 주기.
                vibrator.vibrate(VibrationEffect.createWaveform(longArrayOf(500,1000,500,2000), intArrayOf(0,50,0,200), 1))
            } else {
                vibrator.vibrate(500)
            }
        }

        // 알림음 관련 설정.

        binding.ch10NotificationBtn.setOnClickListener {
            //알림 채널 설정.
            // 시스템 클래스 이용해서, 준비물1
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            // 시스템 클래스 이용해서, 준비물2
            val builder : NotificationCompat.Builder
            // api 레벨 26 이상일 때, 채널 설정 코드가 추가되어서, 변경됨.
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // 26 이상은 채널을 이용해서, 추가 옵션.
                val channelId = "one-channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelId,channelName,NotificationManager.IMPORTANCE_HIGH
                )

                // 채널 정보 설정.
                channel.description = "My Channel Test"
                // 아이콘 대각선 상단에 작은 알림 갯수 표시
                channel.setShowBadge(true)
                // 소리 , 알림음 설정.
                val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val audioAttributes = AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()

                // 옵션에 추가, 소리 관련 옵션
                channel.setSound(uri,audioAttributes)
                // 후레쉬 부분은 led 표기 여부
                channel.enableLights(true)
                // 액정 화면에 알림 왔을 때, 색깔 여부.
                channel.lightColor = Color.RED
                // 진동 여부.
                channel.enableVibration(true)
                channel.vibrationPattern = longArrayOf(100,200,100,200)

                // 채널 옵션을 장착
                manager.createNotificationChannel(channel)
// this : 화면에서 본인 화면,
                builder = NotificationCompat.Builder(this@Ch10MainActivity,channelId)
            } else {
                // api 레벨 26 미만일 경우, 핸드폰의 sdk의 버전을 고려해주기. , 채널 사용 안함.
                builder = NotificationCompat.Builder(this@Ch10MainActivity)
            }

            // 알림 옵션 넣기
            //알림 왔을 때, 클릭시, 특정 액티비티 화면 이동해보기.
            //1
            // 화면 이동시, 인텐트를 이용해서, 시스템에게 주문,
            // 현재화면, 이동할 화면, -> 단순 화면이동, 조금 있다. 데이터도 같이 전달할 예정.
            //
//            val intent = Intent(this@Ch10MainActivity,Lsy1205MainActivity::class.java)
//            val pendingIntent = PendingIntent.getActivity(this@Ch10MainActivity,10, intent, PendingIntent.FLAG_IMMUTABLE)
//            builder.setContentIntent(pendingIntent)

            // 2, 추가 액션 기능 넣기.

//            val actionIntent = Intent(this@Ch10MainActivity,OneReceiver::class.java )
//            val actionPendingIntent = PendingIntent.getBroadcast(this@Ch10MainActivity,20,actionIntent,PendingIntent.FLAG_IMMUTABLE)
//            builder.addAction(
//                NotificationCompat.Action.Builder(
//                    android.R.drawable.stat_notify_more,
//                    "추가 액션1",
//                    actionPendingIntent
//                ).build()
//            )
//            builder.setContentIntent(actionPendingIntent)

            // 3
            // 추가 액션 넣기, 답글 입력폼 추가
            // 통신을 하기 위한 정해둔 키, 서로가 일치 해야함.
//            val KEY_TEXT_REPLY = "key_text_reply"
//            // 알림 창에 표기할 액션의 이름
//            val replyLabel : String = "답장"
//            // 시스템에서 제공 해주는 원격지, 채팅 입력창 비슷.
//            var remoteInput : RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
//                setLabel(replyLabel)
//                build()
//            }
//
//            // 현재 페이지, 2번째 매개변수 페이지로 이동 해주세요. 시스템에게 전달하기.
//            // 편지봉투, 주문서
//            val replyIntent = Intent(this@Ch10MainActivity, ReplyReceiver::class.java)
//            //오타 주의, PendingIntent.FLAG_MUTABLE
//            // getBroadcast -> 브로드캐스트 리시버, 4대 컴포넌트, 용도 : 전체 시스템에게 전달하는 용도.
//            val replyPendingIntent = PendingIntent.getBroadcast(this@Ch10MainActivity,30,replyIntent,PendingIntent.FLAG_MUTABLE)
//            // 답장 액션 추가하기.
//            builder.addAction(
//                NotificationCompat.Action.Builder(
//                    android.R.drawable.stat_notify_more,
//                    "답장",
//                    replyPendingIntent
//                ).addRemoteInput(remoteInput).build()
//            )
//            builder.setContentIntent(replyPendingIntent)
            // 옵션 닫기

            // 옵션4
            // 프로그레스바 이용하기.
//            builder.setProgress(100,0,false)
//            //스레드 이용해서, 상태바의 게이지 올라가는 부분을 임시로 구현.
//            thread {
//                for (i in 1..100){
////                    setProgress(max,progress,false)
//                    builder.setProgress(100,i,false)
//                    manager.notify(11,builder.build())
//                    SystemClock.sleep(100)
//                }
//            }

            // 옵션 5, 큰 이미지 넣기
            val bigImg = BitmapFactory.decodeResource(resources, R.drawable.food1)
            val bigImgStyle = NotificationCompat.BigPictureStyle()
            bigImgStyle.bigPicture(bigImg)
            builder.setStyle(bigImgStyle)

            // 옵션 6, 긴 글 넣기

            // 옵션 7 , 박스 형태 넣기.


            // 공통 내용.
            // 알림음 아이콘 표기
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
            // 알림 온 시간
            builder.setWhen(System.currentTimeMillis())
            // 알림의 메세지 , 제목
            builder.setContentTitle("날씨가 매운 습도가 높습니다. 강의장 쾌적해요.!!")
            builder.setContentText("오늘 점심 뭐 먹죠?")

            // 알림 발생 시키기
            // 퍼미션 추가 필요해요. 매니페스트 파일
            manager.notify(11, builder.build())
        }






    }// onCreate
}