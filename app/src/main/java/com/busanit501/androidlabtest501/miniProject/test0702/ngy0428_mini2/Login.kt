package com.busanit501.androidlabtest501.miniProject.test0702.ngy0428_mini2

import java.util.Scanner

class Login {
    // 입력받음
    private val scanner = Scanner(System.`in`)

    // 함수 loginUser는 userMap을 파라미터로 받는다, 이때, userMap은 MutableMap타입
    fun loginUser(userMap: MutableMap<String, UserNgy0428>) {
        //ID, PW를 입력받고 mid, mpw에 값을 넣는다
        println("ID:")
        val mid = scanner.nextLine()
        println("PW:")
        val mpw = scanner.nextLine()

        // user에는 userMap의 키가 입력 받은 mid를 넣는다.
        val user = userMap.containsKey(mid)

        // 만약 user가 있다면.
        if (user) {
            // userMember는 userMap에서 키가 mid인 값을 가져온다.
            val userMember: UserNgy0428? = userMap.get(mid)
            // 만약 userMember의 id가 입력받은 mid와 같고 pw가 입력받은 mpw와 같다면
            if(mid.equals(userMember?.id) && mpw.equals(userMember?.pw)) {
                // userMember의 id님의 환영한다고 알려줌.
                println("로그인 성공, ${userMember?.id}님 환영합니다.")
            } else {
                // 아니라면 아이디 비번을 확인해달라고 알림.
                println("로그인 실패, 아이디와 패스워드 확인해주세요")
            }

        // 있는 user가 없다면 로그인 실패되었다고 알려줌.
        } else {
            println("로그인 실패, 아이디와 패스워드 확인해주세요")
        }
    }
}