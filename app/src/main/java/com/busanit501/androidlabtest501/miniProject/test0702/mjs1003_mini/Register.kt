package com.busanit501.androidlaptest2.miniProject.test0702.mjs1003_mini

import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)

    fun register(): UserMjs1003 {
        println("ID :")
        val id = scanner.nextLine()
        println("PW :")
        val pw = scanner.nextLine()
        println("EMAIL :")
        val email = scanner.nextLine()

        println("회원 가입 완료")
        return UserMjs1003(id, pw, email)
    }
}