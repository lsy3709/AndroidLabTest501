package com.busanit501.androidlabtest501.miniProject.test0702.kdk1115_mini

import java.util.Scanner

class Register {
    fun registerUser(scanner: Scanner, userList: MutableList<Userkdk1115>) {
        println("ID:")
        val id = scanner.nextLine()
        println("PW:")
        val pw = scanner.nextLine()
        println("EMAIL:")
        val email = scanner.nextLine()
//죄송함돠
        val newUser = Userkdk1115(id, pw, email)
        userList.add(newUser)
        println("회원 가입 완료")
    }
}