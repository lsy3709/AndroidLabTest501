package com.busanit501.androidlabtest501.miniProject.test0702.kms0828_mini2

import java.lang.reflect.Member
import java.nio.file.Files.find
import java.util.Scanner

class Login {
    // scanner 사용
    private val scanner = Scanner(System.`in`)
    // userMap을 매개변수로 사용하는 로그인 함수
    fun loginUser(userMap: MutableMap<String,Lsy1205_mini>) {
        println("ID:")
        // 아이디 입력
        val mid = scanner.nextLine()
        println("PW:")
        // 패스워드 입력
        val mpw = scanner.nextLine()
        // userMap에 mid 존재하는지 확인하여 user에 담기
        val user = userMap.containsKey(mid)
        // user가 존재한다면
        if (user) {
            // userMap의 데이터 받아옴
            val userMember: Lsy1205_mini? = userMap.get(mid)
            // userMap에서 받아온 데이터와 콘솔에 입력한 데이터가 같으면
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)) {
                // 같으면 로그인 성공
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else {
                // 다르면 로그인 실패
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }
        // user가 존재하지 않는다면 로그인 실패
        } else {
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}