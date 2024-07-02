package com.busanit501.androidlabtest501.miniProject.test0702.msy0402

import java.util.Scanner

fun main() {
    val userList = mutableListOf<UserMsy0402>()
    val register = Register()
    val login = Login()
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userList.add(UserMsy0402("admin", "1234", "admin@example.com"))

    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("--------------------------------------------------")

        when (scanner.nextLine()) {
            "1" -> {
                register.registerUser(userList)
            }
            "2" -> {
                login.loginUser(userList)
            }
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}
