package com.busanit501.androidlabtest501.miniProject.test0702.lsj0918_mini

import java.util.Scanner

class Register(private val users: MutableList<UserLsj0918>) {
    fun register(scanner: Scanner) {
        print("ID: ")
        val ID = scanner.next()
        print("PW: ")
        val Password = scanner.next()
        print("Email: ")
        val Email = scanner.next()

        // 사용자 이름 중복 확인
        if (users.any { it.ID == ID }) {
            println("중복.")
        } else {
            users.add(UserLsj0918(ID, Password,Email))
            println("회원가입이 완료되었습니다.")

        }
    }
}