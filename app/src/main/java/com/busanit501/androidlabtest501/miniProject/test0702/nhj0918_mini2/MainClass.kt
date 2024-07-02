package com.busanit501.androidlabtest501.miniProject.test0702.nhj0918_mini2

import java.util.Scanner

class MainClass {
}

fun main() {
    //userMap 사용자저장
    val userMap = mutableMapOf<String, nhj0918_mini>()
    val register = Register()
    val login = Login()
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", nhj0918_mini("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))


    // 사용자로부터 번호 입력받아 해당되는 메뉴 선택
    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

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