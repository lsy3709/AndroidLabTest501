package com.busanit501.androidlabtest501.miniProject.test0702.ngy0428_mini

class Login(private val userList: MutableList<UserNgy0428>) {
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