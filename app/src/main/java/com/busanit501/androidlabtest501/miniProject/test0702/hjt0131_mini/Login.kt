package com.busanit501.androidlabtest501.miniProject.test0702.hjt0131_mini

class Login(private val users: List<hjt0131_mini.User>) {
    fun login(id: String, pw: String): Boolean {
        return users.any { it.id == id && it.pw == pw }
    }
}