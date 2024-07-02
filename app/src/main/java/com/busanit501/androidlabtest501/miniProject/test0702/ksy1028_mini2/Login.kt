package com.busanit501.androidlabtest501.miniProject.test0702.ksy1028_mini2

import java.util.Scanner

class Login {
    // 스캐너 불러오기
    private val scanner = Scanner(System.`in`)
    // 로그인 함수 정의, userMap을 매개변수로 받음
    fun loginUser(userMap: MutableMap<String,Ksy1028_mini>) {
        // ID 입력 요청
        println("ID:")
        // 입력값을 저장
        val mid = scanner.nextLine()
        // PW 입력 요청
        println("PW:")
        // 입력값을 저장
        val mpw = scanner.nextLine()
        // 입력 받은 ID가 userMap에 있는지 확인
        val user = userMap.containsKey(mid)

        if (user) {
            // user가 true면 userMap에서 입력 받은 ID로 Ksy1028_mini 객체를 가져옴
            val userMember: Ksy1028_mini? = userMap.get(mid)
            // 입력 받은 id와 pw가 맞는지 확인
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)) {
                // 로그인에 성공하면 성공 메세지
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else {
                // 로그인에 실패하면 실패 메세지(ID는 맞을 때)
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }

        } else {
            // 로그인에 실패하면 실패 메세지(ID, PW 둘 다 틀렸을 때)
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}