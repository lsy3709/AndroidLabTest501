package com.busanit501.androidlabtest501.miniProject.test0702.ksy1028_mini2

import java.util.Scanner

class Register {
    // 스캐너 생성
    private val scanner = Scanner(System.`in`)

    // 유저 회원가입 처리 함수
    fun registerUser(userMap: MutableMap<String,Ksy1028_mini>): Ksy1028_mini? {
        // ID 입력 요청
        println("MID:")
        // 입력값 저장
        val mid = scanner.nextLine()
        // PW 입력 요청
        println("MPW:")
        // 입력값 저장
        val mpw = scanner.nextLine()
        // EMAIL 입력 요청
        println("EMAIL:")
        // 입력값 저장
        val email = scanner.nextLine()

        // 중복된 ID 체크
        val user = userMap.containsKey(mid)

        //이미 ID가 존재한다면
        if(user){
            println("중복된 아이디입니다.")
            // null 반환
            return null
        }

        // 새로운 유저 생성
        val newUser = Ksy1028_mini(mid, mpw, email)
        // userMap에 유저 추가
        userMap.set(mid,newUser)
        //회원가입 완료 메세지 출력
        println("회원 가입 완료")
        // 새로 추가된 유저 객체 반환
        return newUser
    }
}