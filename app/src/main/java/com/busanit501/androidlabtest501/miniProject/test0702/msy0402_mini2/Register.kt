package com.busanit501.androidlabtest501.miniProject.test0702.msy0402_mini2

import java.util.Scanner

// 회원가입 처리 클래스
class Register {
    // Scanner 객체 초기화
    private val scanner = Scanner(System.`in`)

    // 회원가입 함수
    // userMap: 사용자 정보를 담는 MutableMap
    // 반환값: 회원 가입 성공 시 생성된 사용자 정보 객체(Msy0402_mini), 실패 시 null
    fun registerUser(userMap: MutableMap<String, Msy0402_mini>): Msy0402_mini? {
        println("MID:") // 사용자에게 MID(사용자 ID)를 입력받으라는 메시지 출력
        val mid = scanner.nextLine() // 사용자가 입력한 ID를 변수 mid에 저장
        println("MPW:") // 사용자에게 MPW(비밀번호)를 입력받으라는 메시지 출력
        val mpw = scanner.nextLine() // 사용자가 입력한 비밀번호를 변수 mpw에 저장
        println("EMAIL:") // 사용자에게 EMAIL(이메일)을 입력받으라는 메시지 출력
        val email = scanner.nextLine() // 사용자가 입력한 이메일 주소를 변수 email에 저장

        val userExists = userMap.containsKey(mid) // 입력받은 ID가 이미 userMap에 존재하는지 확인

        if (userExists) { // 이미 존재하는 경우
            println("중복된 아이디입니다.")
            return null // null을 반환하여 회원가입 실패를 나타냄
        }

        // 새로운 사용자 객체 생성
        val newUser = Msy0402_mini(mid, mpw, email)
        userMap[mid] = newUser // userMap에 새로운 사용자 객체를 추가

        println("회원 가입 완료") // 회원 가입 완료 메시지 출력
        return newUser // 회원 가입 성공 시 생성된 사용자 객체를 반환
    }
}
