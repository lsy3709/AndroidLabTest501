package com.busanit501.androidlabtest501.miniProject.test0702.hjt0131_mini2

import java.util.Scanner

class Register {
    //스캐너 삽입
    private val scanner = Scanner(System.`in`)
    //registerUser 함수에 userMap 매개변수를 받고 Lsy1205_mini에 널 가능 연산자를 사용
    fun registerUser(userMap: MutableMap<String,Lsy1205_mini>): Lsy1205_mini? {
        println("MID:")
        //콘솔에 mid 값을 받기
        val mid = scanner.nextLine()
        println("MPW:")
        //콘솔에 비밀번호 값 받기
        val mpw = scanner.nextLine()
        println("EMAIL:")
        //콘솔에 이메일 값 받기
        val email = scanner.nextLine()
        //userMap에 mid 가 있는지 확인
        val user = userMap.containsKey(mid)
        //if 사용하여 값이 같다면 중복된 아이디 입니다
        if(user){
            println("중복된 아이디입니다.")
            //널을 반환
            return null
        }
        //Lsy1205_mini에 담긴 newUser 안에는 mid, mpw, email
        val newUser = Lsy1205_mini(mid, mpw, email)
        //userMap에 mid와 newUser 넣기
        userMap.set(mid,newUser)

        println("회원 가입 완료")
        //newuser 반환
        return newUser
    }
}