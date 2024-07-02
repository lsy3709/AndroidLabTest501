package com.busanit501.androidlabtest501.miniProject.test0702.nhj0918_mini

import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)

    fun registerUser(userList: MutableList<UserNhj0918>): UserNhj0918 {
        println("ID: ")
        val id = scanner.nextLine()
        println("PW: ")
        val pw = scanner.nextLine()
        println("EMAIL: ")
        val email = scanner.nextLine()

        val newUser = UserNhj0918(id, pw, email)
        userList.add(newUser)

        println("회원가입완료~")
        return newUser
    }
}
