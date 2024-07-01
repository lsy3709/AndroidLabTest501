package com.busanit501.androidlabtest501.ch3_4_5

import com.busanit501.androidlabtest501.ch3_4_5.DataClass.SuperClass

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
    //접근 지정자 확인 테스트.
    var publicData = 10
    protected var protectedData = 20
    private  var privateDate = 30

    var name = ""
    open var data1 = 30
    open fun exFun() {
        println("Super exFun() 함수 실행 : data1 : ${data1}, name: ${name}" )
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

class Sub2:Super(name) {
    init {
        println("Sub2 클래스의  주 생성자 실행 부분")
    }
    override var data1 =100
    override fun exFun() {
//        super.exFun()
        println("재정의한 함수 호출 :  ${data1}, name : ${name}")
    }

}

class Sub3: Super(name) {
    fun sampleFun() {
        publicData++
        protectedData++
        //privateData++
    }
}

// data 클래스 확인,
class NonDataClass(val name: String, val age: Int)

data class DataClass(val name: String, val age: Int) {
    lateinit var email : String
    init {
        println("주생성자 호출시 실행되는 영역")
    }
    constructor(name: String,age: Int, email: String): this(name,age){
        println("보조 생성자 호출시 실행되는 영역")
        this.email = email
    }

    //익명 클래스

    open class SuperClass {
        open var data = 10
        open fun ex() {
            println("SuperClass 호출 ex() :  $data")
        }
    }

}


fun main() {
//    val lsy = User("이상용", 30,"lsy@naver.com")
//    val test = Sub("이상용")
//    val test = Sub2()
//    test.exFun()
//    lsy.exFun()
//    val obj = Super("lsy")
//    obj.publicData
//
//    val obj2 = Sub3()
//    obj2.publicData
//    obj2.protectedData

    // data vs NonData class
    val non1 = NonDataClass("이상용",30)
    val non2 = NonDataClass("이상용",30)

    val dataClass1 = DataClass("이상용",30)
    val dataClass2 = DataClass("이상용",30)


//    println("non data class equals non1.equals(non2) : ${non1.equals(non2)}")
//    println("data class equals dataClass1.equals(dataClass2) : ${dataClass1.equals(dataClass2)}")

    val testData1 = DataClass("이상용",30,"lsy@naver.com")
    val testData2 = DataClass("이상용",30,"lsy2@naver.com")
//    println("data class equals testData1.equals(testData2) : ${testData1.equals(testData2)}")
//    println("non1 toString() : ${non1.toString()}, dataClass1 toString() : ${dataClass1.toString()} " )

    // 익명 클래스 만들기. object 이용, 상속 및 , 타입 지정하기.
    val obj = object : SuperClass() {
        override var  data = 100
        override fun ex() {
            println("익명 클래스에서, ex() 재정의 호출 : $data")
        }
    }
    obj.data = 200
    obj.ex()


}