package com.busanit501.androidlabtest501.miniProject.test0702.kcy0810_mini2
import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)

    fun registerUser(userMap: MutableMap<String,Kcy0810_mini>): Kcy0810_mini? {
        // 아이디 비밀번호 이메일 입력받기
        println("MID:")
        val mid = scanner.nextLine()
        println("MPW:")
        val mpw = scanner.nextLine()
        println("EMAIL:")
        val email = scanner.nextLine()
// 입력받은 아이디 user에 담기
        val user = userMap.containsKey(mid)

        // 중복된 값은 null 반환
        if(user){
            println("중복된 아이디입니다.")
            return null
        }
// newuser
        val newUser = Kcy0810_mini(mid, mpw, email)
        userMap.set(mid,newUser)

        println("회원 가입 완료")
        return newUser
    }
}