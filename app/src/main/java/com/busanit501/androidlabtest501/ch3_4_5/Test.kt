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
            ", data3.get(1) : ${data3.get(1)}")
    //깃 테스트2, 새롭게 포크 후 확인

    // 배열에서, 기본형 선언시, 선언과 할당 동시에, 기초 타입의 배열을 생성하기.
    val arrayData2 = intArrayOf(1,2,3)
    val arrayData3 = booleanArrayOf(true,false,true)

    //
    val arrayData4 = arrayOf<String>("국수","국밥","된장찌개")
    val arrayData5 = arrayOf<Int>(1,2,3)

    //List, Set, Map, 2가지 , 고정, 가변
    // 고정
    //
    var list1 = listOf<Int>(1,2,3)
    var list2 = listOf<String>("1","2","3")

    // 가변, 앞에 mutable 접두어 있음.
    var mutableList1 = mutableListOf<Int>(1,2,3)
    var mutableList2 = mutableListOf<String>("1","2","3")
    mutableList1.add(4)
    mutableList1.add(4,100)
    mutableList2.add("100")
    mutableList2.add(4,"200")
    println("""
        확인, ${mutableList1}
        확인2, ${mutableList2}
        확인3, ${mutableList2.get(3)}
    """.trimIndent())

    // Map ,고정 길이
    var map1 = mapOf<String,String>(Pair("1","one"), Pair("2","two"), "3" to "three")
    // 가변 길이.
    var mutableMap1 = mutableMapOf<String,String>(Pair("1","one"), Pair("2","two"), "3" to "three")

//when
    var data = 1
    when(data) {
        1 -> println("1번 국수")
        2 -> println("2번 국밥")
        else -> {
            println("기본 된장찌개 ")
        }
    }

    var data4 = "1"
    when(data4) {
        "1" -> println("1번 국수")
        "2" -> println("2번 국밥")
        else -> {
            println("기본 된장찌개 ")
        }
    }

    var data5:Any = 123
    when(data5) {
        is String -> println(" 문자열 타입입니다.")
        20,30 -> println("20,30 번의 숫자 타입입니다.")
        in 1..10 -> println("1이상, 10이하의 숫자 타입입니다.")
        else -> {
            println("해당 범위에 없는 타입입니다. ")
        }
    }

    //when 이용해서, 표현식으로 사용하기.
    var data6 = 100
    val result = when {
        data6 <= 0 -> "데이터는 0 이하입니다."
        data6 >= 10 -> "데이터는 10 이상입니다."
        else -> {
            "지정됨 범위의 타입이 아닙니다."
        }
    }
    println("result : ${result}")


    //for
    var sum:Int = 0
    for(i in 1..3){
        sum += i
    }
    println("sum : $sum")

    var sum2:Int = 0
    for(i in 1..10 step 2){
        sum2 += i
    }
    println("sum2 : $sum2")

    var sum3:Int = 0
    for(i in 1 until 3){
        sum3 += i
    }
    println("sum3 : $sum3")

    var sum4:Int = 0
    for(i in 10 downTo  8){
        sum4 += i
    }
    println("sum4 : $sum4")


    var data7 = arrayOf<Int>(1,2,3)
    for (i in data7.indices) {
        print(data7[i])
        if ( i !== data7.size - 1) {
            print(",")
        }
    }
println()
    var data8 = arrayOf<Int>(1,2,3)
    for ((index, value )in data8.withIndex()) {
        print("data8의 index : data8[index] : ${index} : ${data8[index]}")
        if ( index !== data8.size - 1) {
            print(",")
        }
    }

}
//변경 테스트23