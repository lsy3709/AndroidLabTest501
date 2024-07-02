package com.busanit501.androidlabtest501.miniProject.test0702.ksy1028_mini

class Login(private val joinMemberList: List<UserKsy1028>){
    fun login(id: String, pw: String): Boolean {
        val user = joinMemberList.find {it.id == id && it.pw == pw}
        return if (user != null) {
            println("--------------------------------------------------")
            println("로그인 성공")
            println("--------------------------------------------------")
            true
        } else {
            println("--------------------------------------------------")
            println("로그인 실패")
            println("--------------------------------------------------")
            false
        }
    }
}
