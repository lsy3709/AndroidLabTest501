package com.example.exercise.test0702.ohj0106_mini2

import com.example.exercise.test0702.ohj0106_mini2.UserOhj0106
import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)

    fun registerUser(userMap: MutableMap<String, UserOhj0106>): UserOhj0106? {
        //id,pw,email을 받고
        println("Id:")
        val Id = scanner.nextLine()
        println("Pw:")
        val Pw = scanner.nextLine()
        println("EMAIL:")
        val Email = scanner.nextLine()
        //userMap에 Id키가 있는지 확인
        val user = userMap.containsKey(Id)

        //만약 아이디가 중복이면 널로 보낸다
        if(user){
            println("중복된 아이디입니다.")
            return null
        }

        //중복이 아니라면 정보를 newUser에 담아서 맵에 넣는다
        val newUser = UserOhj0106(Id, Pw, Email)
        userMap.set(Id,newUser)

        println("회원 가입 완료")
        return newUser
    }
}