package com.busanit501.androidlabtest501.miniProject.test0702.nhj0918_mini

import java.util.Scanner

class Login {
    private val scanner = Scanner(System.`in`)

    fun loginUser(userList: MutableList<UserNhj0918>) {
        println("ID: ")
        val id = scanner.nextLine()
        println("PW: ")
        val pw = scanner.nextLine()

        val user = userList.find { it.id == id && it.pw == pw }
        if (user != null) {
            println("로그인 성공")
        } else {
            println("로그인 실패")

        }
    }
}