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

val name7 : Int? = null

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
    // 모든 타입이 객체이다.
//    name7.
    val data2: String = """
        안녕하세요,
        월요일입니다.
        힘내서 할까요?
        힘이 안나죠? 
        배도 고프고, 그죠?
        집에도 가고 싶고, 
        돈도 벌어야 하고, 
        놀기도 하고, 
        누구는 여름철 휴가 간다고 하던데, 나는? 
    """.trimIndent()
//    println(data2)
    println("힘이 없네, 잠도 오고, 잠이 계속 오네 어쩌지, ㅠㅠ, 그냥 이야기함,오해 금지 :$data2")

    fun showLunchMember(member : String) : String {
        val lunchMemberParty : String = "이상용"
        return "$lunchMemberParty, $member"
    }
//     val lunchMemberParty = showLunchMember("재범쌤 , 동진쌤")
    val lunchMemberParty = showLunchMember("")
//    println("오늘 점심 누구랑 먹지 : $lunchMemberParty" )

    //배열 만들기
    // 담기, set
    val data3 : Array<String> = Array(3,{""})
    data3[0] = "lsy1"
    data3[1] = "lsy2"
    data3.set(2,"lsy3")
    // 가져오기, get
    println("data3 배열 가져오기 테스트 : 사이즈 : ${data3.size}, data[0] : ${data3[0]}" +
            "data3.get(1) : ${data3.get(1)}")


}
//변경 테스트23