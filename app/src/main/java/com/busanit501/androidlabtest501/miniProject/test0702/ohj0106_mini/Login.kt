package com.example.exercise.test0702.ohj0106_mini

class Login (private val userList: List<UserOhj0106>){
    fun login(Id: String, Pw: String) : Boolean{
        for (user in userList) {
            if (user.Id == Id && user.Pw == Pw) {
                println("로그인 성공")
                return true
            }
        }
        println("로그인 실패")
        return false
    }

}