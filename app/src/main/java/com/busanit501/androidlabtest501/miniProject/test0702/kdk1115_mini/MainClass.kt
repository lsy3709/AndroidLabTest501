package com.busanit501.androidlabtest501.miniProject.test0702.kdk1115_mini

import java.util.Scanner

class MainClass{
}

fun main(){
    val scanner = Scanner(System.`in`)
    val joinMemberList: MutableList<Userkdk1115> = mutableListOf()
    val dummyUser = Userkdk1115("admin", "1234", "admin@example.com")
    joinMemberList.add(dummyUser)

    val register = Register()
    val login = Login(joinMemberList)
//죄송함돠
    while (true){
        println("==========================")
        println("고도균 미니실습 회원가입,로그인")
        println("1.회원가입, 2.로그인 3.종료")
        println("==========================")

        when (scanner.nextLine().toInt()) {
            1 -> register.registerUser(scanner, joinMemberList)
            2 -> {
                if (login.attemptLogin(scanner)) {
                }
            }
            3 -> {println("종료됩니다.")
                break
            }
            else -> println("잘못된 입력입니다. 다시 시도해주세요.")
        }
    }
}
