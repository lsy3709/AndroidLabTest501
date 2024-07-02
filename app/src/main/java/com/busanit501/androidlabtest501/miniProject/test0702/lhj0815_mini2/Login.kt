package com.busanit501.androidlabtest501.miniProject.test0702.lhj0815_mini2

import java.util.Scanner

class Login {
    //로그인 함수 , 정보를 받기 위해서 sacnner 불러오는것
    private val scanner = Scanner(System.`in`)
     //userMap를 통해 문자열, UserLhj0815가지고 오기
    fun loginUser(userMap: MutableMap<String, UserLhj0815>) {
        println("ID:")   //ID에 대한 정보
        val mid = scanner.nextLine()  //정보 출력
        println("PW:") //pw에 대한 정보
        val mpw = scanner.nextLine()  //정보 출력

        val user = userMap.containsKey(mid)

        if (user) {  //get로 가져오기 널안정성을 위해 UserLhj0815? 투입
            val userMember: UserLhj0815? = userMap.get(mid)
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)) {
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else { //널값이 없을때 해당 문구 출력
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }

        } else {
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}
