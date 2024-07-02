package com.busanit501.androidlabtest501.miniProject.test0702.ksb0109_mini2

import com.busanit501.androidlabtest501.miniProject.test0702.ksb0109_mini.UserKsb0109
import java.util.Scanner

// 메인 실행 클래스
class MainClass {

}

fun main() {
    val sc = Scanner(System.`in`) // 콘솔 입력을 받기 위한 Scanner 객체 생성
    val joinMemberList: MutableList<UserKsb0109> = mutableListOf() // 회원 가입 정보를 저장할 리스트 생성

    // Register 클래스와 Login 클래스 인스턴스 생성
    val register = Register(joinMemberList)
    val login = Login(joinMemberList)

    // 메뉴 출력 및 사용자 입력을 처리하는 루프
    while (true) {
        println("==========================")
        println("1. 회원가입")
        println("2. 로그인")
        println("3. 종료")
        print("메뉴를 선택하세요: ")

        // 사용자가 선택한 메뉴에 따라 처리
        when (sc.nextLine()) {
            "1" -> register.register(sc) // 회원가입 메뉴 선택 시 Register 클래스의 register 메서드 호출

            "2" -> {
                print("ID : ")
                val id = sc.nextLine()
                print("PW : ")
                val pw = sc.nextLine()
                println("==========================")
                login.login(id, pw) // 로그인 메뉴 선택 시 Login 클래스의 login 메서드 호출
            }

            "3" -> {
                println("종료합니다.")
                break // 종료 메뉴 선택 시 루프 종료
            }

            else -> println("잘못된 입력입니다. 1~3을 선택해주세요.")
        }
    }
}
