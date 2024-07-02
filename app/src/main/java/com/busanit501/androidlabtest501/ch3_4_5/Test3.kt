package com.busanit501.androidlabtest501.ch3_4_5

class Test3 {
}
// arg, 매개변수, 타입: 함수 타입, 모양은 정수 -> true,false
// 함수의 반환 타입 : 또 함수 , 모양 : () -> String
// fun sum (number:Int, number2:Int) : Int {}
// 고차 함수, : 매개변수 또는 반환 타입에 함수 모양이 온다.
fun hofFun(arg:(Int) -> Boolean):() -> String {
    val result = if(arg(10)){
        "valid"
    } else {
        "invalid"
    }
    return {"결과 : $result"}
}

fun main() {
    // 함수의 반환 타입이 없이 할당.
    val some = {no:Int -> println("no : $no") }
//    some(10)

    //it
    // 함수타입 존재
    // 우리가 구현 한 코드를, it 버전으로 굉장히 변환을 자동으로 많이 해줌.
    // 구조를 잘 봐두어야 함.
    // 네트워크 프로그래밍 구현시,
    val some2:(Int) -> Unit = {println("no : $it") }
//    some2(100)

    //고차 함수 사용하기, 인자 : 함수를 넣기
    val result = hofFun ({no -> no > 0  })
    println("고차함수 결괏값 조회 : ${result}")

}