package com.busanit501.androidlabtest501.ch3_4_5

class Test3 {
}

fun main() {
    // 함수의 반환 타입이 없이 할당.
    val some = {no:Int -> println("no : $no") }
    some(10)

    //it
    // 함수타입 존재
    // 우리가 구현 한 코드를, it 버전으로 굉장히 변환을 자동으로 많이 해줌.
    // 구조를 잘 봐두어야 함.
    // 네트워크 프로그래밍 구현시,
    val some2:(Int) -> Unit = {println("no : $it") }
    some2(100)

}