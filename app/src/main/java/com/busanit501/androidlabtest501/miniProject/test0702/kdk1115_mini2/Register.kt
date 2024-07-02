package com.busanit501.androidlabtest501.miniProject.test0702.kdk1115_mini2

import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)

    fun registerUser(userMap: MutableMap<String,kdk1115_mini>): kdk1115_mini? {
        //각 정보를 입력 받고,
        println("MID:")
        val mid = scanner.nextLine()
        println("MPW:")
        val mpw = scanner.nextLine()
        println("EMAIL:")
        val email = scanner.nextLine()

        //입력받은 mid를 user에 담아
        val user = userMap.containsKey(mid)

        //있다면 중복된 아이디입니다 출력 후 kdk1115_mini를 null로 리턴ㅎㅎ
        if(user){
            println("중복된 아이디입니다.")
            return null
        }

        //중복 된 아이디가 아니라면 newUser에 받은 정보를 담아
        val newUser = kdk1115_mini(mid, mpw, email)
        //맵으로 삽입
        userMap.set(mid,newUser)

        println("회원 가입 완료")
        return newUser
    }
}