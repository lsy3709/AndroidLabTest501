package com.busanit501.androidlabtest501.miniProject.test0702.lhs0418_mini

import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)
    private val userList: MutableList<UserLhs0418> = mutableListOf()

    fun registerUser() {
        println("--------------------------------------------------")
        println("ID :")
        val id = scanner.nextLine()
        println("PW :")
        val pw = scanner.nextLine()
        println("EMAIL :")
        val email = scanner.nextLine()
        val newUser = UserLhs0418(id, pw, email)
        userList.add(newUser)
        println("--------------------------------------------------")
        println("회원 가입 완료")
        println("--------------------------------------------------")
    }

    fun getUserList(): MutableList<UserLhs0418> {
        return userList
    }
}