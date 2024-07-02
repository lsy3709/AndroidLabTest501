package com.busanit501.androidlabtest501.miniProject.test0702.test01012

import java.util.Scanner
import java.util.StringTokenizer
import java.util.Vector


class MainClass {
}
fun main() {
    val userMap = mutableMapOf<String,Lsy1205_mini>()
    val register = Register()
    val login = Login()
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", Lsy1205_mini("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))

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