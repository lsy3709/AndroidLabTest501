package com.busanit501.androidlabtest501.miniProject.test0702.lhs0418_mini2

import com.busanit501.androidlabtest501.miniProject.test0702.lsy1205_mini.Lsy1205_mini
import java.lang.reflect.Member
import java.nio.file.Files.find
import java.util.Scanner

class Login {
    // Scanner 인스턴스를 생성하여 사용자 입력을 받기 위한 도구를 초기화합니다.
    private val scanner = Scanner(System.`in`)

    //userMap에 사용자의 정보를 담아 함수에 전달됩니다.
    //userMap은 가변 맵 입니다.
    fun loginUser(userMap: MutableMap<String, Lhs0418_mini>) {
        // 사용자에게 ID 입력을 요청하고 입력받습니다.
        println("ID:")
        val mid = scanner.nextLine()

        // 사용자에게 PW 입력을 요청하고 입력받습니다.
        println("PW:")
        val mpw = scanner.nextLine()

        // 입력받은 ID가 userMap에 존재하는지 확인합니다.
        val user = userMap.containsKey(mid)

        // 만약 ID가 존재한다면
        if (user) {
            // ID에 해당하는 사용자 정보를 userMap에서 가져옵니다.
            val userMember: Lhs0418_mini? = userMap[mid]

            // 입력받은 ID와 비밀번호가 저장된 사용자 정보와 일치하는지 확인합니다.
            if(mid == userMember?.mid && mpw == userMember?.mpw) {
                // 일치한다면 로그인 성공 메시지를 출력합니다.
                println("로그인 성공, ${userMember?.mid}님 환영합니다.")
            } else {
                // 일치하지 않는다면 로그인 실패 메시지를 출력합니다.
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }
        } else {
            // ID가 존재하지 않는다면 로그인 실패 메시지를 출력합니다.
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}