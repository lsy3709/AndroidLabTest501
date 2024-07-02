package com.busanit501.androidlabtest501.miniProject.test0702.test01012

import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)

    fun registerUser(userMap: MutableMap<String,Lsy1205_mini>): Lsy1205_mini? {
        println("MID:")
        val mid = scanner.nextLine()
        println("MPW:")
        val mpw = scanner.nextLine()
        println("EMAIL:")
        val email = scanner.nextLine()

        val user = userMap.containsKey(mid)

        if(user){
            println("중복된 아이디입니다.")
            return null
        }

        val newUser = Lsy1205_mini(mid, mpw, email)
        userMap.set(mid,newUser)

        println("회원 가입 완료")
        return newUser
    }
}