package com.busanit501.androidlabtest501.miniProject.test0702.kms0828_mini2

import java.util.Scanner
import java.util.StringTokenizer
import java.util.Vector


class MainClass {
}
fun main() {
    // userMap, Register, Login, scanner 선언
    val userMap = mutableMapOf<String,Lsy1205_mini>()
    val register = Register()
    val login = Login()
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", Lsy1205_mini("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))
    // 무한 반복
    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")
        // 콘솔에 입력한 내용이
        when (scanner.nextLine()) {
            // 1이라면
            "1" -> {
                // register 사용
                register.registerUser(userMap)
            }
            // 2라면
            "2" -> {
                // login 사용
                login.loginUser(userMap)
            }
            // 3이라면
            "3" -> {
                // 프로그램 종료
                println("프로그램 종료함.")
                scanner.close()
                break
            }
            // 1,2,3이 아니라면 (잘못된 입력) 출력
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}