package com.busanit501.androidlabtest501.ch3_4_5

class Test {
    //클래스 내부,선언과  할당 동시에 해주세요.
    var price = 1000
}
// 클래스 밖, 최상위. 선언과  할당 동시에 해주세요.
var name3 = 1
val name : String = "이상용"
var name2 : String = "이상용2"
// 타입이 없어도 알아서 추론해서 할당 해줌. 동적 할당.
var menu = "국수"

// var 만, 기본형 타입 안됨.
lateinit var name6:String

//늦게 초기화 놀이 2,
// lazy 뒤에 블록 부분은, 해당 상수가 최초로 이용 될 때, 사용됨.
val  data : String by lazy {
    println("val  data : String by lazy : 확인중")
    "오늘 뭐 먹죠?"
}

// 함수 내부
fun main() { // 선언만 해도 가능. 초기화를 조금 늦게 해도 됨.
    println("fun main() 실행")
//    val name4:String
//    val name = "이상용"
//    println("이름 : " + name)
//    name = "오늘 점심"
//    name2 = "오늘점심"
    println("by lazy 테스트")
    println(data)


}
//변경 테스트23