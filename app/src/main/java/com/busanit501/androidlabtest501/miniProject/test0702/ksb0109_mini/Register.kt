package com.busanit501.androidlabtest501.miniProject.test0702.ksb0109_mini

import com.busanit501.androidlabtest501.miniProject.test0702.ngy0428_mini.UserNgy0428
import java.util.Scanner

class Register(private val userList: MutableList<UserKsb0109>) {
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

        val newUser = UserKsb0109(id, pw, email)
        userList.add(newUser)
        println("회원 가입 완료!")
    }
}