package com.busanit501.androidlabtest501.miniProject.test0702.lhs_mini2

import com.busanit501.androidlabtest501.miniProject.test0702.lhs0418_mini2.Lhs0418_mini
import com.busanit501.androidlabtest501.miniProject.test0702.lhs0418_mini2.Login
import com.busanit501.androidlabtest501.miniProject.test0702.lhs0418_mini2.Register
import com.busanit501.androidlabtest501.miniProject.test0702.lsy1205_mini.Lsy1205_mini
import java.util.Scanner
import java.util.StringTokenizer
import java.util.Vector


class MainClass {
}
// 프로그램의 시작 지점인 main 함수를 정의합니다.
fun main() {
    // 사용자의 정보를 저장할 가변 맵을 초기화합니다.
    val userMap = mutableMapOf<String, Lhs0418_mini>()
    // 회원가입을 위한 객체를 생성합니다.
    val register = Register()
    // 로그인 처리를 위한 객체를 생성합니다.
    val login = Login()
    // 콘솔 입력을 받기 위한 Scanner 객체를 초기화합니다.
    val scanner = Scanner(System.`in`)

    // 임의적으로 사용자를 추가합니다. (예: ID는 admin, 비밀번호는 1234)
    userMap["admin"] = Lhs0418_mini("admin", "1234", "admin@example.com")

    // while문을 통해 사용자 입력을 계속 받습니다.
    while (true) {
        // 메뉴를 출력합니다.
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        // 사용자의 입력을 받습니다.
        when (scanner.nextLine()) {
            // 사용자가 "1"을 입력한 경우, 회원가입을 처리합니다.
            "1" -> {
                register.registerUser(userMap)
            }
            // 사용자가 "2"를 입력한 경우, 로그인을 처리합니다.
            "2" -> {
                login.loginUser(userMap)
            }
            // 사용자가 "3"을 입력한 경우, 프로그램을 종료합니다.
            "3" -> {
                println("프로그램 종료함.")
                // Scanner 객체를 닫습니다.
                scanner.close()
                // 루프를 빠져나와 프로그램을 종료합니다.
                break
            }
            // 그 외의 입력이 들어오면 잘못된 입력 메시지를 출력합니다.
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}