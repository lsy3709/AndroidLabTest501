package com.busanit501.androidlabtest501.ch3_4_5

class Test2 {
}
//class User constructor(name:String, age:Int){
class User(name:String, age:Int){
    init {
        println("해당 클래스 인스턴스 주 생성자 이용해서 호출시, 반드시 실행됨.")
    }
}

fun main() {
    val lsy = User("이상용", 30)

}