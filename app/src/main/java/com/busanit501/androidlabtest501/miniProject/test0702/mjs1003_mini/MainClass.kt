package com.busanit501.androidlaptest2.miniProject.test0702.mjs1003_mini

class MainClass {
}
fun main() {
    val joinMemberList = mutableListOf<UserMjs1003>()

    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("--------------------------------------------------")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                val register = Register()
                val newUser = register.register()
                joinMemberList.add(newUser)
            }
            2 -> {
                val login = Login(joinMemberList)
                login.login()
            }
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
    }
}