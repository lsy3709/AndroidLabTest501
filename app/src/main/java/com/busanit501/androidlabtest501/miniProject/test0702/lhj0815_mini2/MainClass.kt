package com.busanit501.androidlabtest501.miniProject.test0702.lhj0815_mini2

import java.util.Scanner

class MainClass {
}
fun main() {  //문자열과 UserLhj0815 값 가져오기
    val userMap = mutableMapOf<String, UserLhj0815>() //유저맵 선언
    val register = Register()  //레지스터 선언
    val login = Login()  //로그인 선언
    val scanner = Scanner(System.`in`)  //scanner로 출력을 할것임.

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", UserLhj0815("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))

    while (true) { //실행시 나오는 문구 안내
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        when (scanner.nextLine()) {
            "1" -> {   //레지스터를 통해 값을 출력
                register.registerUser(userMap)
            }
            "2" -> {  //레지스터를 통해서 값을 출력
                login.loginUser(userMap)
            }
            "3" -> {  //종료하기
                println("프로그램 종료함.")
                scanner.close()
                break  //출력 종료
            }
            else -> {  //1,2 에서 올바른 값을 입력 안했을 시 출력
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}
