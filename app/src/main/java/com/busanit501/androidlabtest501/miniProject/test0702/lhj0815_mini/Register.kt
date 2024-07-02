package com.busanit501.androidlabtest501.miniProject.test0702.lhj0815_mini

import java.util.Scanner

object Register {
    fun register(userList: MutableList<UserLhj0815>, scanner: Scanner) {
        println("=====================================")
        print("ID: ")
        val id = scanner.nextLine()
        print("PW: ")
        val password = scanner.nextLine()
        print("Email: ")
        val email = scanner.nextLine()
        println("=====================================")

        val newUser = UserLhj0815(id, password, email)
        userList.add(newUser)
        println("회원가입이 완료되었습니다.")
    }
}
//ㅎㅎ