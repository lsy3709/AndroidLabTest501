package com.busanit501.androidlabtest501.ch18_2_pagingTest

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit501.androidlabtest501.databinding.PagingItemBinding

class MyViewHolderPage (val binding: PagingItemBinding) : RecyclerView.ViewHolder(binding.root)

class PagingRecyclerAdapter  (val datas: MutableList<ItemModel2>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 리사이클러 뷰의 어댑터를 상속 받으면, 필수적으로 재정의 해야하는 함수들입니다.
    // 자동 완성으로 생성했음.

    // 뷰 생성해주는 역할
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        MyViewHolderPage(
            PagingItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false))

    // 출력할 목록 아이템의 크기 (사이즈), 더미 데이터를 사용할 예정.
    override fun getItemCount(): Int {
//        Log.d("lsy","getItemCount : ${datas.size}")
        return datas.size
    }

    // 뷰에 데이터를 연동(바인딩) 해주는 작업.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        Log.d("lsy", "onBindViewHolder : $position")
        val binding = (holder as MyViewHolderPage).binding

        // 뷰 데이터 출력

        binding.testTextId.text = datas[position].id
        binding.testText.text = datas[position].itemNm
        binding.testText2.text = datas[position].itemDetail

        binding.itemRootPage.setOnClickListener {
            Log.d("lsy", "item clicked : $position")
        }
    }

}
