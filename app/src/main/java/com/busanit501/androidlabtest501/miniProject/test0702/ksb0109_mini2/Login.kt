package com.busanit501.androidlabtest501.miniProject.test0702.ksb0109_mini2

import com.busanit501.androidlabtest501.miniProject.test0702.ksb0109_mini.UserKsb0109

// 로그인 처리 클래스
// 사용자 목록을 받아 로그인 기능을 제공하는 클래스입니다.
class Login(private val userList: MutableList<UserKsb0109>) {

    // 로그인 함수
    // 주어진 ID와 PW를 사용하여 사용자 목록을 검사하고,
    // 일치하는 사용자가 있으면 true를 반환하고 "로그인 성공"을 출력합니다.
    // 일치하는 사용자가 없으면 false를 반환하고 "로그인 실패"를 출력합니다.
    fun login(id: String, pw: String): Boolean {
        for (user in userList) {
            if (user.id == id && user.pw == pw) {
                println("로그인 성공😊")
                return true
            }
        }
        println("로그인 실패😥")
        return false
    }
}
