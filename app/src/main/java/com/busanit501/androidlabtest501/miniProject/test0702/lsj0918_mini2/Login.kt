package com.busanit501.androidlabtest501.miniProject.test0702.lsj0918_mini2

import java.util.Scanner
//사용자 로그인을 처리하는 메서드
class Login {
    // Scanner 객체를 사용하여 사용자 입력을 받음
    private val scanner = Scanner(System.`in`)

    fun loginUser(userMap: MutableMap<String,Lsj0918_mini>) {
        println("ID:")
        val mid = scanner.nextLine()
        println("PW:")
        val mpw = scanner.nextLine()
        // 입력한 아이디가 userMap에 있는지 확인
        val user = userMap.containsKey(mid)

        if (user) {
            // 아이디가 존재하는 경우 사용자 정보를 가져옴
            val userMember: Lsj0918_mini? = userMap.get(mid)
            // 아이디와 비밀번호가 일치하는지 확인
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)) {
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else {
                // 아이디가 존재하지 않는 경우
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }

        } else {
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}