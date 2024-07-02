package com.busanit501.androidlabtest501.miniProject.test0702.lsj0918_mini

import java.util.Scanner

val users = mutableListOf<UserLsj0918>()

fun main() {
    val scanner = Scanner(System.`in`)
    val register = Register(users)
    val login = Login(users)

    while (true) {
        println("-------------------------")
        println("1. 회원가입")
        println("2. 로그인")
        println("3. 종료")
        println("-------------------------")

        when (scanner.nextInt().toInt()) {
            1 -> register.register(scanner)
            2 -> login.login(scanner)
            3 -> return
            else -> println("다시 시도하세요.")

        }
    }
}
