package com.busanit501.androidlabtest501.miniProject.test0702.ksb0109_mini

class Login(private val userList: MutableList<UserKsb0109>) {
    fun login(id: String, pw: String): Boolean {
        for (user in userList) {
            if (user.id == id && user.pw == pw) {
                println("로그인 성공😊")
                return true
            }
        }
        println("로그인 실패😥")
        return false
    }
}