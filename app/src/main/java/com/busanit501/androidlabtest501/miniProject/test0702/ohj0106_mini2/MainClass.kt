package com.example.exercise.test0702.ohj0106_mini2



import com.example.exercise.test0702.ohj0106_mini2.Login
import com.example.exercise.test0702.ohj0106_mini2.UserOhj0106
import java.util.Scanner

class MainClass {
}

fun main() {
    val userMap = mutableMapOf<String, UserOhj0106>()
    val register = Register()
    val login = com.example.exercise.test0702.ohj0106_mini2.Login()
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", UserOhj0106("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))

    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        when (scanner.nextLine()) {
            "1" -> {
                //register클래스 안에있는 registerUser 함수 실생
                register.registerUser(userMap)
            }
            "2" -> {
                //login클래스 안에있는, loginUser 함수 실행
                login.loginUser(userMap)
            }
            "3" -> {
                //프로그램 종료 시키기
                println("프로그램 종료함.")
                scanner.close()
                break
            }
            else -> {
                //다른 번호 입력시 다시 번호 입력란으로 이동
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}