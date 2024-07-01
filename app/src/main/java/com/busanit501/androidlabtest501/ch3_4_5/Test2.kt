package com.busanit501.androidlabtest501.ch3_4_5

class Test2 {
}
//class User constructor(name:String, age:Int){
//
//class User(nameTest2:String, ageTest2:Int){
// 매개변수 앞에 키워드 val 붙이면, 함수 내부에서도, 멤버 처럼 사용 가능.
    class User(val nameTest2:String, val ageTest2:Int){
    init {
        println("해당 클래스 인스턴스 주 생성자 이용해서 호출시, 반드시 실행됨.")
        // 주생성자의 매개변수는 , 기본은 init 영역 안에서 , 재사용가능.
        println("name : ${nameTest2}, age : ${ageTest2}")
    }
    //
    fun exFun() {
        // 다른 함수 내부에서는 사용이 불가.
        println("name : ${nameTest2}, age : ${ageTest2}")
    }
}

fun main() {
    val lsy = User("이상용", 30)
    lsy.exFun()

}