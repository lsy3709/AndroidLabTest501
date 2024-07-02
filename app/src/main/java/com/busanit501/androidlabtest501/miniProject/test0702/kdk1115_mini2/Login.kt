package com.busanit501.androidlabtest501.miniProject.test0702.kdk1115_mini2

import com.busanit501.androidlabtest501.miniProject.test0702.kdk1115_mini2.kdk1115_mini
import java.util.Scanner

class Login {
    //정보를 받기 위한 스캐너 불러 오기
    private val scanner = Scanner(System.`in`)

    fun loginUser(userMap: MutableMap<String, kdk1115_mini>) {
        //정보(id, pw) 받고
        println("ID:")
        val mid = scanner.nextLine()
        println("PW:")
        val mpw = scanner.nextLine()

        //mid를 user에 담아
        val user = userMap.containsKey(mid)


        if (user) {
            //kdk1115_mini에 있는 mid를 호출해서
            val userMember: kdk1115_mini? = userMap.get(mid)
            //kdk1115_mini의 mid와 user안에 있는 mid가 일치하고,
            //kdk1115_mini의 mpw와 user안에 있는 mpw가 일치하면
            //로그인 성공,ㅎㅎ
            //일치하지 않으면 로그인 실패
            if(mid.equals(userMember?.mid) && mpw.equals(userMember?.mpw)) {
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else {
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }

        } else {
            //kdk1115_mini에 호출 정보가 없다면, 로그인 실패
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}