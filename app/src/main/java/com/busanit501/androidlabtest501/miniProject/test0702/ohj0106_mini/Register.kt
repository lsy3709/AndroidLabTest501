package com.example.exercise.test0702.ohj0106_mini

class Register(private val userList: MutableList<UserOhj0106>) {
    fun register(Id: String, Pw: String, Email: String) {
        val newUser = UserOhj0106(Id, Pw, Email)
        userList.add(newUser)
        println("회원 가입 완료")
    }
}