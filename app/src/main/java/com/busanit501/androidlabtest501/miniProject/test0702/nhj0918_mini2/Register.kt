package com.busanit501.androidlabtest501.miniProject.test0702.nhj0918_mini2

import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)

    // 회원정보를 scanner로 입력받아서 사용자를 등록
    // userMap은 등록된 사용자 정보 저장
    fun registerUser(userMap: MutableMap<String, nhj0918_mini>): nhj0918_mini? {
        println("MID:")
        val mid = scanner.nextLine()
        println("MPW:")
        val mpw = scanner.nextLine()
        println("EMAIL:")
        val email = scanner.nextLine()

        // 입력받은 mid가 이미 저장돼있는 지 확인
        val user = userMap.containsKey(mid)

        if(user){
            println("중복된 아이디입니다.")
            return null
        }

        val newUser = nhj0918_mini(mid, mpw, email)
        userMap.set(mid,newUser)
        // 새로운유저를 userMap에 저장함


        println("회원 가입 완료")
        return newUser
    }
}
