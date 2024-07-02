package com.busanit501.androidlabtest501.miniProhect.test0702.lcs0806_mini

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val register = Registerlcs0806()

    while (true) {
        println("----------------------------")
        println("1. 회원가입")
        println("2. 로그인")
        println("3. 종료")
        println("----------------------------")
        print("선택: ")

        when (scanner.nextLine().trim()) {
            "1" -> register.registerUser(scanner)
            "2" -> {
                val login = Loginlcs0806(register.getUsers())
                login.loginUser(scanner)
            }
            "3" -> {
                println("프로그램을 종료합니다.")
                break
            }
            else -> println("잘못된 선택입니다. 다시 시도하세요.")
        }
    }
}

//로그인 생성