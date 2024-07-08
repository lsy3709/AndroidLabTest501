package com.busanit501.androidlabtest501.ch11_jetpack.fragmentSample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.busanit501.androidlabtest501.MainActivity
import com.busanit501.androidlabtest501.R

class SecondFragment : Fragment() {

    lateinit var TAG: String

    // 생명주기 확인을 위한, 로그 달기.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = "Ch11OneFragment"
        Log.d(TAG,"생명주기 onCreate")
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG,"생명주기 onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"생명주기 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"생명주기 onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"생명주기 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"생명주기 onDestroy")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val nextButton: Button = view.findViewById(R.id.button_next_fragment)
        val prevButton: Button = view.findViewById(R.id.button_prev_fragment)

        nextButton.setOnClickListener {
            (activity as Ch11FragmentSampleMainActivity).showNextFragment()
        }

        prevButton.setOnClickListener {
            (activity as Ch11FragmentSampleMainActivity).showPreviousFragment()
        }

        return view
    }
}