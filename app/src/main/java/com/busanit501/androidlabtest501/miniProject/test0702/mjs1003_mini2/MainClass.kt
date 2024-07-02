package com.busanit501.androidlabtest501.miniProject.test0702.mjs1003_mini2

import java.util.Scanner

class MainClass {
}
fun main() {
    //만들었던 파츠들 주입?
    val userMap = mutableMapOf<String, Mjs1003_mini>()
    val register = Register()
    val login = Login()
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", Mjs1003_mini("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))

    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        //콘솔에 1 입력시 가입,
        //2 입력시 로그인
        //3 입력시 프로그램 종료
        //4 입력시 오류 처리
        when (scanner.nextLine()) {
            "1" -> {
                register.registerUser(userMap)
            }
            "2" -> {
                login.loginUser(userMap)
            }
            "3" -> {
                println("프로그램 종료함.")
                scanner.close()
                break
            }
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}