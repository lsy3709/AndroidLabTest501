package com.busanit501.androidlaptest2.miniProject.test0702.mjs1003_mini

import java.util.Scanner

class Login(private val users: List<UserMjs1003>) {
    private val scanner = Scanner(System.`in`)

    fun login() {
        println("ID:")
        val id = scanner.nextLine()
        println("PW:")
        val pw = scanner.nextLine()

        val user = users.find { it.id == id && it.pw == pw }
        if (user != null) {
            println("로그인 성공")
        } else {
            println("로그인 실패")
        }
    }
}