package com.busanit501.androidlabtest501.miniProject.test0702.hjt0131_mini

import java.util.Scanner

class MainClass {
    private val scanner = Scanner(System.`in`)
    private val register = Register()
    private val login = Login(register.getUsers())

    fun run() {
        while (true) {
            println("--------------------------------------------------")
            println("1.회원가입")
            println("2.로그인")
            println("--------------------------------------------------")
            when (scanner.nextLine()) {
                "1" -> {
                    println("--------------------------------------------------")
                    print("ID : ")
                    val id = scanner.nextLine()
                    print("PW : ")
                    val pw = scanner.nextLine()
                    print("EMAIL : ")
                    val email = scanner.nextLine()
                    println("--------------------------------------------------")
                    register.register(id, pw, email)
                }
                "2" -> {
                    println("--------------------------------------------------")
                    print("ID: ")
                    val id = scanner.nextLine()
                    print("PW: ")
                    val pw = scanner.nextLine()
                    println("--------------------------------------------------")
                    if (login.login(id, pw)) {
                        println("--------------------------------------------------")
                        println("로그인 성공")
                        println("--------------------------------------------------")
                    } else {
                        println("--------------------------------------------------")
                        println("로그인 실패")
                        println("--------------------------------------------------")
                    }
                }
                else -> {
                    println("잘못된 입력입니다. 다시 시도해주세요.")
                }
            }
        }
    }
}

object App {
    @JvmStatic
    fun main(args: Array<String>) {
        val mainClass = MainClass()
        mainClass.run()
    }
}