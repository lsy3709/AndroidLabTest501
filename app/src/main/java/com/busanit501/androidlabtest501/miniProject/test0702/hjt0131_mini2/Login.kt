package com.busanit501.androidlabtest501.miniProject.test0702.hjt0131_mini2

import java.lang.reflect.Member
import java.nio.file.Files.find
import java.util.Scanner

class Login {
    //스캐너 삽입
    private val scanner = Scanner(System.`in`)
    //로그인 유저 맵 사용해서 추가
    fun loginUser(userMap: MutableMap<String,Lsy1205_mini>) {
        println("ID:")
        //콘솔에서 스캐너를 이용하여 받은 값 저장 아이디
        val mid = scanner.nextLine()
        println("PW:")
        //콘솔에서 스캐너를 이용해서 받은 값 저장 비밀번호
        val mpw = scanner.nextLine()
        //userMap에 mid 가 있는지 확인
        val user = userMap.containsKey(mid)
        //if 사용하여 유저의 존재 여부 확인
        if (user) {
            //널 가능 연산자를 사용하여 유저맵에서 mid 값을 가져와서 유저맴버 확인
            val userMember: Lsy1205_mini? = userMap.get(mid)
            //이퀄 사용하여 mid 와 mpw 가 있는지 확인 있으면 님 환영합니다 없으면 로그인 실패
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)) {
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else {
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }
        //유저에 값이 널이면은 로그인 실패
        } else {
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}