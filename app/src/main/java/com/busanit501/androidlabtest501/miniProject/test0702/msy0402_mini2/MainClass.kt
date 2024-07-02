package com.busanit501.androidlabtest501.miniProject.test0702.msy0402_mini2

import java.util.Scanner

// 메인 실행 클래스
class MainClass {
}

fun main() {
    // 사용자 정보를 담는 MutableMap 초기화
    val userMap = mutableMapOf<String, Msy0402_mini>()

    // Register 및 Login 객체 생성
    val register = Register()
    val login = Login()

    // 콘솔 입력을 위한 Scanner 객체 생성
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가
    userMap["admin"] = Msy0402_mini("admin", "1234", "admin@example.com")

    // 프로그램 실행 루프
    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        // 사용자 입력을 받아 기능 선택
        when (scanner.nextLine()) {
            "1" -> {
                register.registerUser(userMap) // 회원가입 기능 호출
            }
            "2" -> {
                login.loginUser(userMap) // 로그인 기능 호출
            }
            "3" -> {
                println("프로그램 종료함.")
                scanner.close() // Scanner 객체 닫기
                return // 프로그램 종료
            }
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}
