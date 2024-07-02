package com.busanit501.androidlabtest501.miniProject.test0702.kdk1115_mini2

import java.util.Scanner


class MainClass {
}
fun main() {
    val userMap = mutableMapOf<String,kdk1115_mini>()
    val register = Register()
    val login = Login()
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", kdk1115_mini("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))

    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        //스캐너로 각 번호를 받았을 때 실행
        when (scanner.nextLine()) {
            "1" -> {
                //레지스터 클래스 안의 registerUser 실행
                register.registerUser(userMap)
            }
            "2" -> {
                //로그인 클래스 안의 loginUser 실행
                login.loginUser(userMap)
            }
            "3" -> {
                println("프로그램 종료함.")
                //스캐너는 사용 후 close 해줘야 데이터 낭비 방지할 수 있음
                scanner.close()
                break
            }
            else -> {
                //1,2,3이 아닌 다른 번호를 입력 시 println 출력 후 번호입력 다시 받으러 돌아감
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}