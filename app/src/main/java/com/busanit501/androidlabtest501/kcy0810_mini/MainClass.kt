package com.busanit501.androidlabtest501.kcy0810_mini

import java.util.Scanner

class MainClass {
    fun main() {
        val joinMemberList: MutableList<UserKcy0810> = mutableListOf()

        // 임시로 기본 사용자 추가
        joinMemberList.add(UserKcy0810("admin", "1234", "admin@example.com"))

        val register = Register(joinMemberList)
        val login = Login(joinMemberList)

        val scanner = Scanner(System.`in`)

        while (true) {
            println("--------------------------------------------------")
            println("1.회원가입")
            println("2.로그인")
            println("--------------------------------------------------")

            when (scanner.nextLine()) {
                "1" -> register.register()
                "2" -> login.login()
                else -> println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}