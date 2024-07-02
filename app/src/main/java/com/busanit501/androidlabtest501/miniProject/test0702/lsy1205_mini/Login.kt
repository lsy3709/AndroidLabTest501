package com.busanit501.androidlabtest501.miniProject.test0702.lsy1205_mini

import java.lang.reflect.Member
import java.nio.file.Files.find
import java.util.Scanner

class Login {
    private val scanner = Scanner(System.`in`)

    fun loginUser(userMap: MutableMap<String,Lsy1205_mini>) {
        println("ID:")
        val mid = scanner.nextLine()
        println("PW:")
        val mpw = scanner.nextLine()

        val user = userMap.containsKey(mid)

        if (user) {
            val userMember: Lsy1205_mini? = userMap.get(mid)
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