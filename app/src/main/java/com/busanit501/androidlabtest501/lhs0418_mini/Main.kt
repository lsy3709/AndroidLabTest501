package com.busanit501.androidlabtest501.miniProject.test0702.lhs0418_mini

import java.util.Scanner

fun main() {
    val register = Register()
    val login = Login(register.getUserList())
    val scanner = Scanner(System.`in`)

    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("--------------------------------------------------")

        when (scanner.nextInt()) {
            1 -> register.registerUser()
            2 -> login.loginUser()
            else -> println("잘못된 입력입니다. 다시 시도하세요.")
        }
    }
}