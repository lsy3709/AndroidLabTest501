package com.busanit501.androidlabtest501.ch11_jetpack.recyclerview.test1simple

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.busanit501.androidlabtest501.ch3_4_5.data
import com.busanit501.androidlabtest501.databinding.Ch11ItemSimpleRecyclerBinding

// 더미 데이터를 넣기, 단순, 텍스트 타입의 리스트를 매개변수로 정하기. ex) List<String>
// 네트워크 통신 이용해서, 모델 타입의 리스트를 받기. ex) List<BoardDto>
class Ch11MyAdapterSample(val datas: MutableList<String> ) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    // 어댑터에 뷰홀더 연결하기.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder  =
        Ch11MyViewHolder(Ch11ItemSimpleRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent, false))

    // 목록 요소의 갯수
    override fun getItemCount(): Int {
        return datas.size
    }

    // 해당 연결 된 뷰에, 데이터 넣기.
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // 어댑터에 연결된 뷰 바인딩 -> 용도, 뷰를 선택하기.
        val binding = (holder as Ch11MyViewHolder).binding
        // 더미 데이터로 , food2 같은 이미지로 재사용.
//        binding.ch11RecyclerItemImg =
        // 더미 데이터로, 문자열만, 내가 정한 임의의 데이터를 넣기.
        binding.ch11RecyclerItemTextView.text = datas[position]
        // 해당 아이템 요소 클릭시 , 발생하는 이벤트 리스너 추가하기.
//        binding.itemRoot.setOn
    }
}