package com.busanit501.androidlabtest501.miniProject.test0702.mjs1003_mini2

import java.util.Scanner

class Register {
    //스캐너 선언
    private val scanner = Scanner(System.`in`)

    fun registerUser(userMap: MutableMap<String, Mjs1003_mini>):Mjs1003_mini?{
        println("MID:")
        //mid 에 콘솔에 입력한 값 담기
        val mid = scanner.nextLine()
        println("MPW:")
        //mpw 에 콘솔에 입력한 값 담기
        val mpw = scanner.nextLine()
        println("EMAIL:")
        //email 에 콘솔에 입력한 값 담기
        val email = scanner.nextLine()
        //userMap에 mid와 동일한 키값의 내용이 있는지 판별 있으면 true 없으면 false
        val user = userMap.containsKey(mid)

        //동일한 키 값이 있으면 실행
        if(user){
            println("중복된 아이디입니다.")
            return null
        }
        //동일한 키 값이 없다면 newUser에 입력한 mid, mpw, email을 담고
        //mid를 키값으로 userMap에 저장
         val newUser = Mjs1003_mini(mid, mpw, email)
        userMap.set(mid,newUser)

        println("회원 가입 완료")
        return newUser
    }
}