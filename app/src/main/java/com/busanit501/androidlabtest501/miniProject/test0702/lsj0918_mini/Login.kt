package com.busanit501.androidlabtest501.miniProject.test0702.lsj0918_mini

import java.util.Scanner

class Login(private val users: MutableList<UserLsj0918>) {
    fun login(scanner: Scanner) {
        print("ID: ")
        val ID = scanner.next()
        print("PW: ")
        val Password = scanner.next()

        // 사용자 확인
        val user = users.find { it.ID == ID && it.Password == Password }
        if (user != null) {
            println("로그인 성공 $ID!")
        } else {
            println("로그인 실패.")
        }
    }
}