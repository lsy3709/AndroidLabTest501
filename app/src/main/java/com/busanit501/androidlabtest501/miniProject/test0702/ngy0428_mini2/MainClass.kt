package com.busanit501.androidlabtest501.miniProject.test0702.ngy0428_mini2

import java.util.Scanner
//Map으로 하기
class MainClass{
}
fun main(){
    // Map 선언. mutableMapof<키는 string이며, 값은 만들어놓은 데이터 클래스인 UserNgy0428>
    val userMap = mutableMapOf<String, UserNgy0428>()
    // 변수 register는 Register클래스를 가져옴.
    val register = Register()
    // 변수 login은 Login클래스를 가져옴.
    val login = Login()
    // 입력을 받기 위해 Scanner을 사용함.
    val scanner = Scanner(System.`in`)

    // 반복문(계속 돌아감. false가 되면 나감)
    while (true) {
        println("--------------------------------------------------")
        println("1.회원가입")
        println("2.로그인")
        println("3.종료")
        println("--------------------------------------------------")

        // 키보드로 한줄을 읽을 때,
        when (scanner.nextLine()) {
            // 입력한 값이 문자열 1이면, 클래스 Register의 registerUser함수에 파라미터값(userMap)을 넣은 것을 작동함.
            "1" -> {
                register.registerUser(userMap)
            }
            // 입력한 값이 문자열 2라면, 클래스 Login의 loginUser함수에 useMap 파라미터값을 넣은 것을 작동함.
            "2" -> {
                login.loginUser(userMap)
            }
            // 입력한 값이 문자열 3이면, 프로그램 종료를 콘솔에 찍고, scanner를 닫는다(자원반납), break를 통해 while문을 빠져온다.
            "3" -> {
                println("프로그램 종료함.")
                scanner.close()
                break
            }
            // 문자열 1,2,3이 아닌 다른 것이면 잘못된 입력이라고 알려준다.
            else -> {
                println("잘못된 입력입니다. 다시 시도해주세요.")
            }
        }
        // 다시 while문 젤 위로 올라간다.
    }

}