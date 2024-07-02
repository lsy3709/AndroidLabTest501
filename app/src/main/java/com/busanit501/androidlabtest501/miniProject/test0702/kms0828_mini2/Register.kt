package com.busanit501.androidlabtest501.miniProject.test0702.kms0828_mini2

import java.util.Scanner

class Register {
    // scanner 사용
    private val scanner = Scanner(System.`in`)
    // 회원가입 함수, Map 사용 MutableMap: 가변클래스, 데이터를 추가하거나 변경 가능
    fun registerUser(userMap: MutableMap<String,Lsy1205_mini>): Lsy1205_mini? {
        println("MID:")
        // 아이디 입력
        val mid = scanner.nextLine()
        println("MPW:")
        // 패스워드 입력
        val mpw = scanner.nextLine()
        println("EMAIL:")
        // 이메일 입력
        val email = scanner.nextLine()
        // userMap의 mid 있는지 확인
        val user = userMap.containsKey(mid)
        // user가 존재한다면 중복된 아이디, null 반환
        if(user){
            println("중복된 아이디입니다.")
            return null
        }
        // newUser에 입력받은 mid, mpw, email 저장
        val newUser = Lsy1205_mini(mid, mpw, email)
        // newUser를 userMap에 세팅
        userMap.set(mid,newUser)

        println("회원 가입 완료")
        // newUser 반환
        return newUser
    }
}