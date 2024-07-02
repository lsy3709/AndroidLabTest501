package com.busanit501.androidlabtest501.miniProject.test0702.kms0828_mini

import java.util.Scanner

class MainClass {

}

fun main() {
    val scanner = Scanner(System.`in`)
    val register = Register()
    var loggedIn = false

    while(true) {
        println("1: 회원가입")
        println("2: 로그인")
        print("선택: ")
        when (scanner.nextLine()) {
            "1" -> {
                register.registerUser(scanner)
            }

            "2" -> {
                val login = Login(register.getUsers())
                loggedIn = login.loginUser(scanner)
                if (loggedIn) {
                    break
                }
            }

            else -> println("다시 선택")
        }

    }
}