package com.busanit501.androidlabtest501.miniProhect.test0702.lcs0806_mini

import java.util.Scanner

class Loginlcs0806(private val users: List<Userlcs0806>) {
    fun loginUser(scanner: Scanner) {
        println("=== 로그인 ===")
        print("ID: ")
        val id = scanner.nextLine().trim()
        print("Password: ")
        val pw = scanner.nextLine().trim()

        val user = users.find { it.id == id && it.pw == pw }
        if (user != null) {
            println("로그인 성공! 환영합니다, ${user.id}.")
        } else {
            println("로그인 실패. ID 또는 비밀번호가 올바르지 않습니다.")
        }
    }
}

// 로그인 클래스 생성