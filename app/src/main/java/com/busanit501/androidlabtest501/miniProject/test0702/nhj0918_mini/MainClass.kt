package com.busanit501.androidlabtest501.miniProject.test0702.nhj0918_mini

import java.util.Scanner

fun main() {
    val userList = mutableListOf<UserNhj0918>()
    val register = Register()
    val login = Login()
    val scanner = Scanner(System.`in`)


    userList.add(UserNhj0918("admin", "1234", "admin@example.com"))

    while (true) {
        println("-------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("-------------------------------")

        when (scanner.nextLine()) {
            "1" -> {
                register.registerUser(userList)
            }

            "2" -> {
                login.loginUser(userList)
            }

            else -> {
                println("잘못된 입력입니다. 1,2번중에서만 선택해주세요")
            }

        }
    }
}