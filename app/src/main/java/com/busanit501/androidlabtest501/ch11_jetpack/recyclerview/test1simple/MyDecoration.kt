package com.busanit501.androidlabtest501.ch11_jetpack.recyclerview.test1simple

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
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
    }

    // 각각 목록 요소를 꾸미기
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
    }

}