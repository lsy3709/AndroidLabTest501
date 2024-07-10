package com.busanit501.androidlabtest501.ch11_jetpack.recyclerview.test1simple

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.busanit501.androidlabtest501.R

class MyDecoration(val context:Context) : RecyclerView.ItemDecoration() {

    // 목록요소 그리기 전에 출력
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        c.drawBitmap(
            BitmapFactory.decodeResource(context.resources, R.drawable.food1),
            0f,0f,null
        )
    }

    // 목록요소 그리기 후에 출력
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        // 가운데 정렬하는 계산,
        // 뷰사이즈 계산
        val width = parent.width
        val height = parent.height
        Log.d("lsy", "뷰사이즈 계산 parent.width : $width, parent.height : $height")

        // 이미지 사이즈 계산
        // 리소스에서 이미지 가져오기
        val drawable : Drawable? =
            ResourcesCompat.getDrawable(context.resources, R.drawable.test, null)

        // 실제 이미지의 크기
        val drawableWidth = drawable?.intrinsicWidth
        val drawableHeigt = drawable?.intrinsicHeight
        Log.d("lsy", "실제 이미지의 크기 계산 drawable?.intrinsicWidth : $drawableWidth, " +
                " drawable?.intrinsicHeight : $drawableHeigt")

        // 이미지가 그려질 위치 계산, -> 정 중앙에 배치
        // drawableWidth?.div(2) , 실제 이미지의 크기를 2로 나눈값을 정수로 표현.
        val left = width / 2 - drawableWidth?.div(2) as Int
        val top = height / 2 - drawableHeigt?.div(2) as Int
        Log.d("lsy", "출력할 좌표  left : $left, " +
                " top : $top")
        c.drawBitmap(
            BitmapFactory.decodeResource(context.resources, R.drawable.test),
            left.toFloat(),
            top.toFloat(),
            null
        )

    }

    // 각각 목록 요소를 꾸미기
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val index = parent.getChildAdapterPosition(view) + 1

        // 목록 요소를 3개씩 끊어서 출력 꾸미기
        if( index % 3 == 0) {
            // 동, 서, 남 , 북 마진값이다.
            outRect.set(10, 10, 10, 60)
        } else {
            outRect.set(10, 10, 10, 0)
        }

        // 구분선 색깔
        view.setBackgroundColor(Color.WHITE)
        // 고도, 위로 올라오는 효과
        ViewCompat.setElevation(view,30.0f)

    }

}