package com.busanit501.androidlabtest501.miniProject.test0702.ksy1028_mini

import java.util.Scanner

class Register(private val joinMemberList: MutableList<UserKsy1028>){
    fun joinus(scanner: Scanner) {
        println("--------------------------------------------------")
        println("ID : ")
        val id = scanner.nextLine()
        println("PW : ")
        val pw = scanner.nextLine()
        println("EMAIL : ")
        val email = scanner.nextLine()

        joinMemberList.add(UserKsy1028(id, pw, email))
        println("--------------------------------------------------")
    }



}

