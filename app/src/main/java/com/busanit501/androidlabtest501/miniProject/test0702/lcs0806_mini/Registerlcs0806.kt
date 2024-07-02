package com.busanit501.androidlabtest501.miniProhect.test0702.lcs0806_mini

import java.util.Scanner

class Registerlcs0806 {
    private val users = mutableListOf<Userlcs0806>()

    fun registerUser(scanner: Scanner) {
        println("=== 회원가입 ===")
        print("ID: ")
        val id = scanner.nextLine().trim()
        print("Password: ")
        val pw = scanner.nextLine().trim()
        print("Email: ")
        val email = scanner.nextLine().trim()

        if (users.any { it.id == id }) {
            println("이미 존재하는 ID입니다. 다른 ID를 선택하세요.")
        } else {
            val user = Userlcs0806(id, pw, email)
            users.add(user)
            println("회원가입이 완료되었습니다!")
        }
    }
    fun getUsers(): List<Userlcs0806> {
        return users
    }
}

// 회원가입 생성

