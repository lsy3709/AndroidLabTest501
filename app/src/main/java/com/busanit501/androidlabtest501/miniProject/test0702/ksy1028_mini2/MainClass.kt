package com.busanit501.androidlabtest501.miniProject.test0702.ksy1028_mini2

import java.util.Scanner


class MainClass {
}
fun main() {
    // 유저 정보를 저장할 mutableMap 생성
    val userMap = mutableMapOf<String,Ksy1028_mini>()
    // Register 인스턴스 생성
    val register = Register()
    // Login 인스턴스 생성
    val login = Login()
    // 스캐너 객체 생성
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", Ksy1028_mini("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))

    // 반복문
    while (true) {
        // 메뉴 출력
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        // 스캐너로 유저 입력 받기
        when (scanner.nextLine()) {
            "1" -> {
                // 유저 회원가입 처리
                register.registerUser(userMap)
            }
            "2" -> {
                // 유저 로그인 처리
                login.loginUser(userMap)
            }
            "3" -> {
                // 스캐너 닫고 종료
                println("프로그램 종료함.")
                scanner.close()
                break
            }
            else -> {
                //잘못된 입력 처리
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}