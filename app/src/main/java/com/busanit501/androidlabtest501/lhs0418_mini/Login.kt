package com.busanit501.androidlabtest501.miniProject.test0702.lhs0418_mini

import java.util.Scanner

class Login(private val userList: MutableList<UserLhs0418>) {
    private val scanner = Scanner(System.`in`)

    fun loginUser() {
        println("--------------------------------------------------")
        println("ID:")
        val id = scanner.nextLine()
        println("PW:")
        val pw = scanner.nextLine()

        val user = userList.find { it.id == id && it.pw == pw }
        if (user != null) {
            println("--------------------------------------------------")
            println("로그인 성공")
            println("--------------------------------------------------")
        } else {
            println("--------------------------------------------------")
            println("로그인 실패")
            println("--------------------------------------------------")
        }
    }
}