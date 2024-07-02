package com.busanit501.androidlabtest501.miniProject.test0702.lhj0815_mini

import java.util.Scanner

object Login {
    fun login(userList: List<UserLhj0815>, scanner: Scanner) {
        print("ID: ")
        val id = scanner.nextLine()
        print("PW: ")
        val password = scanner.nextLine()

        for (user in userList) {
            if (user.id == id && user.password == password) {
                println("로그인 성공! 환영합니다, $id 님!")
                return
            }
        }
        println("로그인 실패! ID 또는 PW가 잘못되었습니다.")
    }
}