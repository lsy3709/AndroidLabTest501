package com.busanit501.androidlabtest501.miniProject.test0702.msy0402_mini2

import java.util.Scanner

// 로그인 처리 클래스
class Login {

    // Scanner 객체 초기화
    private val scanner = Scanner(System.`in`)

    // 로그인 함수
    fun loginUser(userMap: MutableMap<String, Msy0402_mini>) {
        println("ID:")
        val mid = scanner.nextLine() // 사용자로부터 ID 입력 받기
        println("PW:")
        val mpw = scanner.nextLine() // 사용자로부터 PW 입력 받기

        val user = userMap.containsKey(mid) // 입력받은 ID가 Map에 있는지 확인

        if (user) { // ID가 Map에 있는 경우
            val userMember: Msy0402_mini? = userMap[mid] // Map에서 해당 ID의 사용자 정보 가져오기
            if (mid == userMember?.mid && mpw == userMember?.mpw) { // ID와 PW가 일치하는지 확인
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else {
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }
        } else { // ID가 Map에 없는 경우
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}
