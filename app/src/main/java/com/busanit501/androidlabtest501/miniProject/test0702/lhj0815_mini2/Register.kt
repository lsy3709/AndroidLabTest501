package com.busanit501.androidlabtest501.miniProject.test0702.lhj0815_mini2

import com.busanit501.androidlabtest501.miniProject.test0702.lsy1205_mini.Lsy1205_mini
import java.util.Scanner

class Register {   //출력값을 가져오기 위함
    private val scanner = Scanner(System.`in`)
   // 널안정성을 위해 UserLhj0815? 물음표 사용
    fun registerUser(userMap: MutableMap<String, UserLhj0815>): UserLhj0815? {
        println("MID:")   //UserLhj0815에 있는 id값 가져오기
        val mid = scanner.nextLine()
        println("MPW:")  //UserLhj0815에 있는 pw값 가져오기
        val mpw = scanner.nextLine()
        println("EMAIL:")  //UserLhj0815에 있는 email값 가져오기
        val email = scanner.nextLine()

        val user = userMap.containsKey(mid)

        if(user){  //중복이 되었을 경우를 확인 중복일 경우 널로 리턴
            println("중복된 아이디입니다.")
            return null
        }
   // 새로운 유저 가입을 시도 할시 나옴 유저맵안에 id, user로
        val newUser = UserLhj0815(mid, mpw, email)
        userMap.set(mid,newUser)

        println("회원 가입 완료")//가입이 정상화 되었을 시 나오는 값 출력
        return newUser
    }
}
//ㅎㅎ