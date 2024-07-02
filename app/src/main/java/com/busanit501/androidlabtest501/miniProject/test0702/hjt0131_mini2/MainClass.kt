package com.busanit501.androidlabtest501.miniProject.test0702.hjt0131_mini2

import java.util.Scanner
import java.util.StringTokenizer
import java.util.Vector


class MainClass {
}
//메인 실행
fun main() {
    //유즈맵으로 lsy1205_mini 스트링 타입으로 받기
    val userMap = mutableMapOf<String,Lsy1205_mini>()
    //레지스터 매개변수 받기
    val register = Register()
    //로그인 매개변수 받기
    val login = Login()
    //스캐너 삽입
    val scanner = Scanner(System.`in`)

    // 테스트용 임시 사용자 추가 (예: admin/1234)
    userMap.set("admin", Lsy1205_mini("admin", "1234", "admin@example.com"))
    //(Lsy1205_mini("admin", "1234", "admin@example.com"))
    //while 반복문 이용
    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")
        //콘솔에서 입력값 받기
        when (scanner.nextLine()) {
            //1을 입력하여 회원가입 정보 불러오기
            "1" -> {
                register.registerUser(userMap)
            }
            //2를 입력하여 로그인 정보 불러오기
            "2" -> {
                login.loginUser(userMap)
            }
            //3을 입력하여 프로그램 닫기
            "3" -> {
                println("프로그램 종료함.")
                scanner.close()
                break
            }
            //그외를 입력하면
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}