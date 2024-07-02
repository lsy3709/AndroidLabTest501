package com.busanit501.androidlabtest501.miniProject.test0702.lsy1205_mini.kcy0810_mini

import java.util.Scanner

class Login(private val userList: MutableList<UserKcy0810>) {
    fun login() {
        val scanner = Scanner(System.`in`)

        println("--------------------------------------------------")
        println("ID:")
        val id = scanner.nextLine()
        println("PW:")
        val pw = scanner.nextLine()
        println("--------------------------------------------------")

        val user = userList.find { it.id == id && it.pw == pw }
        if (user != null) {
            println("로그인 성공")
        } else {
            println("로그인 실패")
        }
    }
}