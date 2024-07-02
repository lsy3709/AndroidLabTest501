package com.busanit501.androidlabtest501.miniProject.test0702.hjt0131_mini

class Register {
        private val users = mutableListOf<hjt0131_mini.User>()

        fun register(id: String, pw: String, email: String) {
            users.add(hjt0131_mini.User(id, pw, email))
            println("--------------------------------------------------")
            println("회원 가입 완료")
            println("--------------------------------------------------")
        }

        fun getUsers(): List<hjt0131_mini.User> {
            return users
        }
    }

