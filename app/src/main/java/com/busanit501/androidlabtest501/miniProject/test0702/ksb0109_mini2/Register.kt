package com.busanit501.androidlabtest501.miniProject.test0702.ksb0109_mini2

import com.busanit501.androidlabtest501.miniProject.test0702.ksb0109_mini.UserKsb0109
import java.util.Scanner

// 회원 가입 처리 클래스
class Register(private val userList: MutableList<UserKsb0109>) {

    // 회원 가입 메서드
    // 사용자로부터 ID, PW, EMAIL을 입력받아 새로운 사용자 객체를 생성하고 userList에 추가합니다.
    fun register(scanner: Scanner) {
        println("==========================")
        println("회원 가입을 진행합니다.")

        // 사용자 입력 받기
        print("ID : ")
        val id = scanner.nextLine()
        print("PW : ")
        val pw = scanner.nextLine()
        print("EMAIL : ")
        val email = scanner.nextLine()
        println("==========================")

        // 새로운 사용자 객체 생성 및 리스트에 추가
        val newUser = UserKsb0109(id, pw, email)
        userList.add(newUser)

        println("회원 가입 완료!")
    }
}
