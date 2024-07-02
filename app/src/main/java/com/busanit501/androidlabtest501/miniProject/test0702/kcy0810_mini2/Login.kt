package com.busanit501.androidlabtest501.miniProject.test0702.kcy0810_mini2

import java.lang.reflect.Member
import java.nio.file.Files.find
import java.util.Scanner

class Login {
    // 스캐너
    private val scanner = Scanner(System.`in`)

    fun loginUser(userMap: MutableMap<String,Kcy0810_mini>) {
        // 아이디랑 로그인 입력받기
        println("ID:")
        val mid = scanner.nextLine()
        println("PW:")
        val mpw = scanner.nextLine()

        val user = userMap.containsKey(mid)

        if (user) {
            val userMember: Kcy0810_mini? = userMap.get(mid)
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)) {
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else {
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }

        } else {
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}