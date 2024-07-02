package com.busanit501.androidlabtest501.miniProject.test0702.lcs0806_1mini

import java.util.Scanner

class Register {
    private val scanner = Scanner(System.`in`)
    // 회원가입을 하기위해 스캐너에 데이터 기입

    fun registerUser(userMap: MutableMap<String,Lcs0806_mini1>): Lcs0806_mini1? {
        // registerUser 부분을 함수로 사용하여 userMap을 MutableMap으로 하여 가변성으로 활용
        // String 문자열 키값을 활용하여 Lcs0806_mini1의 값을 가져옴: Lcs0806_mini1의 값은 ?로
        // null을 허용함
        println("MID:")
        // 콘솔에 "MID:" 문자로 표시
        val mid = scanner.nextLine()
        // mid 부분에 scanner 도구 활용하여 데이터입력 후 다음줄로 넘김
        println("MPW:")
        // 콘솔에 "MPW:" 문자로 표시
        val mpw = scanner.nextLine()
        // mpw 부분에 scanner 도구 활용하여 데이터입력 후 다음줄로 넘김
        println("EMAIL:")
        // 콘솔에 "EMAIL:" 문자로 표시
        val email = scanner.nextLine()
        // email 부분에 scanner 도구 활용하여 데이터입력 후 다음줄로 넘김
        val user = userMap.containsKey(mid)
        // user 중복체크 containsKey에 존재하는 mid값 확인

        if(user){
            // 만약 해당 user 값이 존재한다면
            println("중복된 아이디입니다.")
            // 콘솔에 "중복된 아이디입니다." 문자로 표시
            return null
            // 해당 반환값은 null로 받음 따로 return id값을 받을필요가 없기때문에
        }

        val newUser = Lcs0806_mini1(mid, mpw, email)
        // 해당 Lcs0806_mini1에 존재하는
        // mid, mpw, email을 매개변수로 사용하는 newUser 생성
        userMap.set(mid,newUser)
        // mid와,newUser 값을 기입
        println("회원 가입 완료")
        // 콘솔에 "회원가입완료" 문자로 표시
        return newUser
        // 위의 값과 다르게 반환값을 받아야 해당 새로운유저가 등록되기때문에 newUser를 반환값으로 받음
    }
}