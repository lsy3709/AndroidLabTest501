package com.busanit501.androidlabtest501.miniProject.test0702.kdk1115_mini

import java.util.Scanner

class Login(private val users: List<Userkdk1115>) {
    fun attemptLogin(scanner: Scanner): Boolean {
        println("ID를 입력하세요.")
        val id = scanner.nextLine()
        println("PW를 입력하세요")
        val pw = scanner.nextLine()
//죄송함돠
        val user = users.find { it.ID == id && it.PW == pw }

        return if (user != null) {
            println("로그인 성공")
            true
        } else {
            println("로그인 실패")
            false
        }
    }
}