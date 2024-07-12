package com.busanit501.androidlabtest501.ch17_SQLiteDB

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivitySharedPrefDetailTestBinding

class SharedPrefDetailTestActivity : AppCompatActivity() {
    //2번 화면
    // 공유프리퍼런스 파일에 데이터 가져오기
    lateinit var binding : ActivitySharedPrefDetailTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPrefDetailTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 조회 버튼 누르면 공유된 프리퍼런스 파일에 저장된 값 가져오기,
        binding.getSharedPreferBtnTest.setOnClickListener {
            // 값 가져오기
            // 저장된 파일명 : userInfo
            // key, value 형태로 저장됨.,
            // key 로 해당 값을 불러오기.
            val pref = getSharedPreferences("userInfo", MODE_PRIVATE)
            val email = pref.getString("email", "Default EMAIL")
            val password = pref.getString("password", "Default PASSWORD")
            // 라디오 값 가져오기.
            val pickRadio = pref.getString("pickRadio", "Default pickRadio")
            val email2 = pref.getString("email2", "Default EMAIL")
            val password2 = pref.getString("password2", "Default PASSWORD")
            val email3 = pref.getString("email3", "Default EMAIL")
            val password3 = pref.getString("password3", "Default PASSWORD")

            // 결과 뷰에 데이터 넣기.
            binding.resultEmailSP.text = email
            binding.resultPasswordSP.text = password
            // 라디오 값 결과 뷰에 넣기.
            binding.resultRadioSP.text = pickRadio

            // 삭제 테스트1 - 부분 삭제
            binding.deleteSharedPreferBtnTest.setOnClickListener {
                val pref = getSharedPreferences("userInfo", MODE_PRIVATE)
                val editor = pref.edit()
                editor.remove("email")
                editor.remove("password")
                editor.commit()
            }

            // 삭제 테스트2 - 파일 전체 삭제
            binding.deleteFileSharedPreferBtnTest.setOnClickListener {
                val pref = getSharedPreferences("userInfo", MODE_PRIVATE)
                val editor = pref.edit()
                editor.clear()
                editor.commit()
            }

        }
    }
}