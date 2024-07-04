package com.busanit501.androidlabtest501.ch07

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh07MainFrameBinding

class Ch07MainFrameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //바인딩, 뷰들을 , 하나의 인스턴스에 담아서, 꺼내서 사용하기.
        val binding = ActivityCh07MainFrameBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_ch07_main_frame)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val testBtn = binding.ch07FrameBtn1
        val img1 = binding.ch07FrameImg1
        val img2 = binding.ch07FrameImg2
        val img3 = binding.ch07FrameImg3

        img1.visibility = View.VISIBLE
        img2.visibility = View.INVISIBLE
        img3.visibility = View.INVISIBLE

        val imgList : MutableList<ImageView> = mutableListOf<ImageView>(img1,img2,img3)

        var imgCheck: Int = 1

        testBtn.setOnClickListener {
            //
            if(imgCheck == 0) {
                img1.visibility = View.VISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.INVISIBLE
                imgCheck++
            } else if (imgCheck == 1) {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.VISIBLE
                img3.visibility = View.INVISIBLE
                imgCheck++
            }
            else if (imgCheck == 2) {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.VISIBLE
                imgCheck = 0;
            }
        }


        img1.setOnClickListener {
            //
            if(imgCheck == 0) {
                img1.visibility = View.VISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.INVISIBLE
                imgCheck++
            } else if (imgCheck == 1) {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.VISIBLE
                img3.visibility = View.INVISIBLE
                imgCheck++
            }
            else if (imgCheck == 2) {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.VISIBLE
                imgCheck = 0;
            }
        }

        img2.setOnClickListener {
            //
            if(imgCheck == 0) {
                img1.visibility = View.VISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.INVISIBLE
                imgCheck++
            } else if (imgCheck == 1) {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.VISIBLE
                img3.visibility = View.INVISIBLE
                imgCheck++
            }
            else if (imgCheck == 2) {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.VISIBLE
                imgCheck = 0;
            }
        }

        img3.setOnClickListener {
            //
            if(imgCheck == 0) {
                img1.visibility = View.VISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.INVISIBLE
                imgCheck++
            } else if (imgCheck == 1) {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.VISIBLE
                img3.visibility = View.INVISIBLE
                imgCheck++
            }
            else if (imgCheck == 2) {
                img1.visibility = View.INVISIBLE
                img2.visibility = View.INVISIBLE
                img3.visibility = View.VISIBLE
                imgCheck = 0;
            }
        }



    }// onCreate
}