package com.busanit501.androidlabtest501.miniProject.test0702.lcs0806_1mini

import java.util.Scanner


class MainClass {
}
fun main() {
    // 메인실행창
    val userMap = mutableMapOf<String,Lcs0806_mini1>()
    // valuable 형식값을 가진 userMap을 mutableMapof 형식으로 변경
    // 키값은 String 문자형이고 value 값은 Lcs0806_mini1 형식으로 변경
    val register = Register()
    // valuable 형식값을 가진 register는  Register() 함수형식으로 변경
    val login = Login()
    // valuable 형식값을 가진 login는  Login() 함수형식으로 변경
    val scanner = Scanner(System.`in`)
    // 콘솔에 데이터를 입력하기위해 scanner라는 공간생성

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", Lcs0806_mini1("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))

    while (true) {
        // 해당 구문이 참이라면
        println("--------------------------------------------------")
        // 한줄 띄어쓰기 줄넘김 할때 주로사용
        println("1.회원가입")
        // 콘솔에 표시되는 데이터값을 1.회원가입으로 표기
        println("2.로그인")
        // 콘솔에 표시되는 데이터값을 2.로그인으로 표기
        println("3.종료")
        // 콘솔에 표시되는 데이터값을 3.종료로 표기
        println("--------------------------------------------------")
        // 한줄 띄어쓰기 줄넘김 할때 주로사용

        when (scanner.nextLine()) {
            "1" -> {
                register.registerUser(userMap)
            // 스캐너에서 1번을 입력할시 회원가입 생성 페이지로 이동(register탭)
            }
            "2" -> {
                login.loginUser(userMap)
                // 스캐너에서 2번을 입력할시 로그인 페이지로 이동(login탭)
            }
            "3" -> {
                println("프로그램 종료함.")
                scanner.close()
                break
                // 해당 콘솔프로세스 종료 break 활용
            }
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
            // 그 외 다른번호를 입력시 "잘못된 입력입니다. 다시 시도해주세요." 표시
        }
    }
}