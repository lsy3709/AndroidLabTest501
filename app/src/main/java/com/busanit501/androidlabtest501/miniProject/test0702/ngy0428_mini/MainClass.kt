package com.busanit501.androidlabtest501.miniProject.test0702.ngy0428_mini

import java.util.Scanner

class MainClass{

}
fun main(){
    val sc = Scanner(System.`in`)
    val joinMemberList: MutableList<UserNgy0428> = mutableListOf()

    val register = Register(joinMemberList)
    val login = Login(joinMemberList)

    while (true) {
        println("==========================")
        println("1. 회원가입")
        println("2. 로그인")
        println("3. 종료")
        print("메뉴를 선택하세요: ")

        when (sc.nextLine()) {
            "1" -> register.register(sc)

            "2" -> {
                print("ID : ")
                val id = sc.nextLine()
                print("PW : ")
                val pw = sc.nextLine()
                println("==========================")
                login.login(id, pw)
            }

            "3" -> {
                println("종료합니다.")
                break
            }

            else -> println("잘못된 입력입니다. 1~3을 선택해주세요.")
        }
    }
}