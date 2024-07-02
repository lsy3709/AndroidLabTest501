package com.busanit501.androidlabtest501.miniProject.test0702.kms0828_mini

import java.util.Scanner

class Register {
    private val users = mutableListOf<kms0828_mini>()

    fun registerUser(scanner: Scanner): kms0828_mini {
        println("==========================================")
        println("회원가입 정보 입력")
        println("==========================================")
        print("ID : ")
        val id = scanner.nextLine()
        print("PW : ")
        val pw = scanner.nextLine()
        print("EMAIL : ")
        val email = scanner.nextLine()
        println("==========================================")

        val newUser = kms0828_mini(id, pw, email)
        users.add(newUser)
        println("가입 완료")
        return newUser
    }

    fun getUsers() : List<kms0828_mini>{
        return users
    }
}

