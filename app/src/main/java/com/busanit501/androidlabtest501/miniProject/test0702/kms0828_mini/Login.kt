package com.busanit501.androidlabtest501.miniProject.test0702.kms0828_mini

import java.util.Scanner

class Login(private val registeredUsers:List<kms0828_mini>) {
    fun loginUser(scanner: Scanner):Boolean {
        println("로그인 정보 입력")
        print("ID: ")
        val id = scanner.nextLine()
        print("PW: ")
        val pw = scanner.nextLine()

        val user = registeredUsers.find {it.id==id && it.pw==pw }
        return if (user != null){
            println("로그인 성공")
            true
        } else {
            println("로그인 실패")
            false
        }
    }
}