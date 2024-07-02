package com.busanit501.androidlabtest501.miniProject.test0702.lcs0806_1mini

import java.util.Scanner

class Login {

    private val scanner = Scanner(System.`in`)
    // Scanner를 사용한다고 선언을 하여 실제 입력값을 scanner에 저장

    fun loginUser(userMap: MutableMap<String,Lcs0806_mini1>)
    // 로그인 유저라는 해쉬맵안에 MutableMap을 활용 가변성 map을 만들고 추후 유지보수 목적
    // String 키값을 활용하며 Lcs0806_mini 값을 맵에 넣음

    {
        println("ID:")
        // 실제 콘솔화면에 표기되는 글들
        val mid = scanner.nextLine()
        // 입력시 나오는 값을 mid 안에다 기입

        println("PW:")
        // 실제 콘솔화면에 표기되는 글들
        val mpw = scanner.nextLine()
        // // 입력시 나오는 값을 mpw 안에다 기입

        val user = userMap.containsKey(mid)
        // user값 중복체크를 위해 containsKey(mid)를 통한 비교진행

        if (user) {
            // 유저에 값이 있을 때
            val userMember: Lcs0806_mini1? = userMap.get(mid)
            // userMember의 Lcs0806_mini?에 대한 userMap.get(mid)를 넣음
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)) {
                // 해당 mid 및 mpw가 동일하면
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
                // 콘솔에 "로그인 성공, ${userMember?.mid}님 환영합니다."
            } else {
                // 아닐경우에는
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
                // 콘솔에 "로그인 실패, 아이디와 패스워드 확인해주세요" 문구표기
            }

        } else {
            // 유저에 값이 없을때
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
            // 콘솔에 "로그인 실패, 아이디와 패스워드 확인해주세요" 문구표기
        }
    }
}