package com.example.exercise.test0702.ohj0106_mini2


import com.example.exercise.test0702.ohj0106_mini2.UserOhj0106
import java.util.Scanner

class Login {
    private val scanner = Scanner(System.`in`)

    fun loginUser(userMap: MutableMap<String, UserOhj0106>) {
        //Id,Pw를 받는다
        println("ID:")
        val Id = scanner.nextLine()
        println("PW:")
        val Pw = scanner.nextLine()
        //user에 담는다
        val user = userMap.containsKey(Id)

        if (user) {
            //id와 pw가 일치하면 로그인 성공
            val userMember: UserOhj0106? = userMap.get(Id)
            if(Id.equals(userMember?.Id) && Pw.equals(userMember?.Pw)) {
                println("로그인 성공, ${userMember?.Id}님 환영합니다.")
            } else {
                //일치하지 않으면 로그인 실패
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }

        } else {
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }

}