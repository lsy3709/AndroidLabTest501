package com.busanit501.androidlabtest501.miniProject.test0702.ngy0428_mini2

import java.util.Scanner

class Register {
    // 입력받는다
    private val scanner = Scanner(System.`in`)

    //함수 registerUser는 파라미터 값으로 userMap을 받는다. UserNgy0428이 널인지 확인한다.
    fun registerUser(userMap: MutableMap<String, UserNgy0428>): UserNgy0428? {
        // ID, PW, EMAIL을 입력받는다.
        println("ID:")
        val mid = scanner.nextLine()
        println("PW:")
        val mpw = scanner.nextLine()
        println("EMAIL:")
        val email = scanner.nextLine()

        // 입력받은 mid(ID)를 userMap의 키로 넣고, user라는 곳에 담는다.
        val user = userMap.containsKey(mid)

        // 만약 user가 있다면,(userMap의 키인 mid가 있다면)
        if(user){
            println("중복된 아이디입니다.") //중복된다고 알려주고
            return null // null을 리턴한다.
        }

        //데이터클래스에 입력받은 id,pw, email을 넣고 newUser에 담는다.
        val newUser = UserNgy0428(mid, mpw, email)
        //userMap은 키를 mid로 두고 값을 newUser로 받는다
        userMap.set(mid,newUser)

        // 회원가입완료되었다고 알려주고 newUser를 리턴해준다.
        println("회원 가입 완료")
        return newUser
    }
}