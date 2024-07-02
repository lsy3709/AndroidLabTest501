package com.busanit501.androidlabtest501.miniProject.test0702.ksy1028_mini

import java.util.Scanner

    fun main() {
        val joinMemberList: MutableList<UserKsy1028> = mutableListOf()
        val scanner = Scanner(System.`in`)
        val register = Register(joinMemberList)
        val login = Login(joinMemberList)

        while (true) {
            println("--------------------------------------------------")
            println("1. 회원가입")
            println("2. 로그인")
            println("--------------------------------------------------")

            when (scanner.nextLine().toInt()) {
                1 -> register.joinus(scanner)
                2 -> {
                    println("ID : ")
                    val id = scanner.nextLine()
                    println("PW : ")
                    val pw = scanner.nextLine()
                    login.login(id, pw)
                }
            }
        }
    }
