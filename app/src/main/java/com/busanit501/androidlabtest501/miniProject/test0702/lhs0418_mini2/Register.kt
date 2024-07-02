package com.busanit501.androidlabtest501.miniProject.test0702.lhs0418_mini2

import com.busanit501.androidlabtest501.miniProject.test0702.lsy1205_mini.Lsy1205_mini
import java.util.Scanner

class Register {
    // Scanner 인스턴스를 생성하여 사용자 입력을 받기 위한 도구를 초기화합니다.
    private val scanner = Scanner(System.`in`)

    //userMap에 사용자의 정보를 담아 함수에 전달됩니다.
    //userMap은 가변 맵 입니다.
    fun registerUser(userMap: MutableMap<String, Lhs0418_mini>): Lhs0418_mini? {
        // 사용자에게 MID 입력을 요청하고 입력받습니다.
        println("MID:")
        val mid = scanner.nextLine()

        // 사용자에게 MPW 입력을 요청하고 입력받습니다.
        println("MPW:")
        val mpw = scanner.nextLine()

        // 사용자에게 EMAIL 입력을 요청하고 입력받습니다.
        println("EMAIL:")
        val email = scanner.nextLine()

        // 입력받은 MID가 이미 존재하는지 확인합니다.
        val user = userMap.containsKey(mid)

        // 만약 입력받은 MID가 이미 존재하면, 중복 메시지를 출력하고 null을 반환합니다.
        if(user){
            println("중복된 아이디입니다.")
            return null
        }

        // 새로운 사용자 정보를 담은 Lhs0418_mini 인스턴스를 생성합니다.
        val newUser = Lhs0418_mini(mid, mpw, email)

        // 생성한 사용자 정보를 userMap에 추가합니다.
        userMap[mid] = newUser

        // 회원 가입 완료 메시지를 출력합니다.
        println("회원 가입 완료")

        // 생성된 사용자 인스턴스를 반환합니다.
        return newUser
    }
}