package com.busanit501.androidlabtest501.miniProject.test0702.lsj0918_mini2

import java.util.Scanner


class MainClass {
    // MainClass는 프로그램 실행의 진입점 역할을 하는 클래스
}
fun main() {
    // 사용자 정보를 저장하는 MutableMap 초기화
    val userMap = mutableMapOf<String,Lsj0918_mini>()

    // Register와 Login 클래스의 인스턴스 생성
    val register = Register()
    val login = Login()

    // Scanner 객체를 사용하여 사용자 입력을 받는다.
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가
    userMap.set("admin", Lsj0918_mini("admin", "1234", "admin@example.com"))

    // 무한 루프를 사용하여 사용자에게 선택지를 제공
    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        // 사용자의 선택을 입력받는다.
        when (scanner.nextLine()) {
            "1" -> {
                // 회원가입 선택 시 registerUser 메서드 호출한다.
                register.registerUser(userMap)
            }
            "2" -> {
                // 로그인 선택 시 loginUser 메서드 호출한다.
                login.loginUser(userMap)
            }
            "3" -> {
                // 종료 선택 시 프로그램 종료한다.
                println("프로그램 종료함.")
                scanner.close()
                break
            }
            else -> {
                // 잘못된 입력 시 메시지 출력한다.
                println("잘못된 입력입니다. 다시 시도해주세요.")

            }
        }
    }
}