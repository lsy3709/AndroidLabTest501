package com.busanit501.androidlabtest501.miniProject.test0702.mjs1003_mini2

import java.util.Scanner

class Login {
    //스캐너 선언 : 콘솔에 입력한 값을 사용하겠다.
    private val scanner = Scanner(System.`in`)

    //loginUser 함수 userMap을 매개변수로 받고
    // MutableMap 타입 String : 키값, Mjs1003_mini : 밸류
    fun loginUser(userMap: MutableMap<String, Mjs1003_mini>){
        println("ID:")
        //스캐너로 입력한 값을 mid 에 담기
        val mid = scanner.nextLine()
        println("PW:")
        //스캐너로 입력한 값을 mpw 에 담기
        val mpw = scanner.nextLine()
        //userMap에 mid와 같은 키값이 있는지 확인 있으면 true 없으면 false를
        //user에 담음
        val user = userMap.containsKey(mid)
        //user가 true면 실행
        if(user){
            //userMember에 mid 키값의 해당하는 Mjs1003_mini의 키값과 벨류값 넣음
            val userMember: Mjs1003_mini? = userMap.get(mid)
            //mid와 mpw의 값이 userMember의 값과 동일하다면 통과
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)){
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            }else {
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }
        } else {
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }

    }
}