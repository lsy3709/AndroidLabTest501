package com.busanit501.androidlabtest501.miniProject.test0702.lhj0815_mini

import java.util.Scanner

fun main() {
    val joinMemberList: MutableList<UserLhj0815> = ArrayList()
    val scanner = Scanner(System.`in`)
    while (true) {
        println("1. 회원가입")
        println("2. 로그인")
        println("3. 종료")
        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine() // 개행 문자 제거
                Register.register(joinMemberList, scanner)
            }
            2 -> {
                scanner.nextLine() // 개행 문자 제거
                Login.login(joinMemberList, scanner)
            }
            3 -> {
                println("프로그램을 종료합니다.")
                break
            }
            else -> println("잘못된 선택입니다. 다시 시도해주세요.")
        }
    }
    scanner.close()
}