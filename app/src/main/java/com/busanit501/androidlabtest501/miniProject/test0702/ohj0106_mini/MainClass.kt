package com.example.exercise.test0702.ohj0106_mini

import java.util.Scanner

class MainClass {
}

fun main(){
    val scanner = Scanner(System.`in`)
    val joinMemberList: MutableList<UserOhj0106> = mutableListOf()
    val register = Register(joinMemberList)
    val login = Login(joinMemberList)

    while (true) {
        println("1.회원가입")
        println("2.로그인")

        when (scanner.nextLine()) {
            "1" -> {
                print("ID: ")
                val Id = scanner.nextLine()
                print("PW: ")
                val Pw = scanner.nextLine()
                print("EMAIL: ")
                val Email = scanner.nextLine()

                register.register( Id, Pw, Email)
            }

            "2" -> {
                print("ID: ")
                val Id = scanner.nextLine()
                print("PW: ")
                val Pw = scanner.nextLine()

                login.login(Id, Pw)
            }

            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}