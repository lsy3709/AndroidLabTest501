package com.busanit501.androidlabtest501.miniProject.test0702.ngy0428_mini

import java.util.Scanner

class Register(private val userList: MutableList<UserNgy0428>) {
    fun register(scanner: Scanner){
        println("==========================")
        println("회원 가입을 진행합니다.")
        print("ID : ")
        val id = scanner.nextLine()
        print("PW : ")
        val pw = scanner.nextLine()
        print("EMAIL : ")
        val email = scanner.nextLine()
        println("==========================")

        val newUser = UserNgy0428(id, pw, email)
        userList.add(newUser)
        println("회원 가입 완료!")
    }
}