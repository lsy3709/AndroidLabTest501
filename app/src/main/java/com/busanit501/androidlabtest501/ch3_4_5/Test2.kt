package com.busanit501.androidlabtest501.ch3_4_5

class Test2 {
}
//class User constructor(name:String, age:Int){
//
//class User(nameTest2:String, ageTest2:Int){
// 매개변수 앞에 키워드 val 붙이면, 함수 내부에서도, 멤버 처럼 사용 가능.
//    class User(val nameTest2:String, val ageTest2:Int){
class User(name: String){
    init {
        println("해당 클래스 인스턴스 주 생성자 이용해서 호출시, 반드시 실행됨.")
        // 주생성자의 매개변수는 , 기본은 init 영역 안에서 , 재사용가능.
//        println("init 안에서 사용, name : ${nameTest2}, age : ${ageTest2}")
        println("주 생성자 호출1 User(name: String) : ")
    }
    constructor(name: String, age:Int): this(name) {
        println("보조 생성자 호출2 constructor(name: String, age:Int) : ")
    }
    constructor(name: String, age: Int, email:String):this(name,age) {
        println("보조 생성자 호출3 constructor(name: String, age:Int, email:String) : ")
    }
    //
    fun exFun() {
        // 다른 함수 내부에서는 사용이 불가.
//        println("exFun 안에서 사용 name : ${nameTest2}, age : ${ageTest2}")
    } //exFun

} // User

//상속
open class Super(name:String) {

    init {
        println("Super 클래스의 주생성자 실행 부분")
    }
} // Super

//class Sub(name: String) : Super(name){
class Sub : Super{ // 자식 클래스에서 , 주생성자가 없음.
    init {
        println("Sub 클래스의 주생성자 실행 부분")
    }

    constructor(name: String) : super(name){
        println("Sub 클래스의 보조 생성자 실행 부분")
    }
}


fun main() {
//    val lsy = User("이상용", 30,"lsy@naver.com")
    val test = Sub("이상용")
//    lsy.exFun()



}