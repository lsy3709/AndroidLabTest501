package com.busanit501.androidlabtest501.miniProject.test0702.lsy1205_mini.msy0402

import java.util.Scanner

// 회원가입 처리 클래스
class Register {
    private val scanner = Scanner(System.`in`)

    fun registerUser(userList: MutableList<UserMsy0402>): UserMsy0402 {
        println("ID:")
        val id = scanner.nextLine()
        println("PW:")
        val pw = scanner.nextLine()
        println("EMAIL:")
        val email = scanner.nextLine()

        val newUser = UserMsy0402(id, pw, email)
        userList.add(newUser)

        println("회원 가입 완료")
        return newUser
    }
}
