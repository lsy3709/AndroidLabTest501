package com.busanit501.androidlabtest501.miniProject.test0702.lsj0918_mini2

import java.util.Scanner

class Register {
   // 사용자 회원가입을 처리하는 메서드
    private val scanner = Scanner(System.`in`)

    fun registerUser(userMap: MutableMap<String,Lsj0918_mini>): Lsj0918_mini? {
        // 사용자 아이디 입력
        println("MID:")
        val mid = scanner.nextLine()
        // 사용자 비밀번호 입력
        println("MPW:")
        val mpw = scanner.nextLine()
        // 사용자 이메일 입력
        println("EMAIL:")
        val email = scanner.nextLine()

        val user = userMap.containsKey(mid)

        // 아이디 중복 시 처리
        if(user){
            println("중복된 아이디입니다.")
            return null
        }
        // 새로운 사용자 객체 생성
        val newUser = Lsj0918_mini(mid, mpw, email)
        userMap.set(mid,newUser)

        // 회원가입 완료 메시지 출력
        println("회원 가입 완료")
        // 등록된 사용자 객체 반환
        return newUser

    }
}