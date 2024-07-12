package com.busanit501.androidlabtest501.ch16_contentProvider

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh16ContactMainBinding

class Ch16ContactMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityCh16ContactMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh16ContactMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_ch16_contact_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 후처리 후, 자동 호출되는 함수
        val requestContactsLauncher = registerForActivityResult(
            // 후처리, 2번 앱에서 가져온 데이터를 처리하는 로직.
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                Log.d("lsy", "${it.data?.data}")
                //실제 데이터를 불러와서, 결과뷰에 넣어보기.
                val cursor = contentResolver.query(
                    it!!.data!!.data!!,
                    arrayOf<String>(
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER
                    ),
                    null,
                    null,
                    null,
                ) //cursor
                Log.d("lsy", "cursor size: ${cursor?.count}")
                // cursor 에는 , 마치 디비에서 select 를 하는 방법과 비슷
                if(cursor!!.moveToFirst()) {
                    val name = cursor?.getString(0)
                    val phone = cursor?.getString(1)
                    binding.ch16ResultView.text = "이름 : $name, 전화번호: $phone"
                }

            }
        }

        //이벤트 처리
        binding.ch16ContactBtn.setOnClickListener {
            // 연락처 앱으로 접근
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI)
            // 인텐트를 전달, 시스템에게, 후처리
            requestContactsLauncher.launch(intent)
        }



    }//onCreate

}