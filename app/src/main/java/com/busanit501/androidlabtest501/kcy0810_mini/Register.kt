package com.busanit501.androidlabtest501.kcy0810_mini

import java.util.Scanner

class Register(private val userList: MutableList<UserKcy0810>) {
    fun register() {
        val scanner = Scanner(System.`in`)

        println("--------------------------------------------------")
        println("ID:")
        val id = scanner.nextLine()
        println("PW:")
        val pw = scanner.nextLine()
        println("EMAIL:")
        val email = scanner.nextLine()
        println("--------------------------------------------------")

        val newUser = UserKcy0810(id, pw, email)
        userList.add(newUser)

        println("회원 가입 완료")
        println("--------------------------------------------------")
    }
}