package com.busanit501.androidlabtest501.ch17_2_room.repository

import androidx.lifecycle.LiveData
import com.busanit501.androidlabtest501.ch17_2_room.dao.UserDao
import com.busanit501.androidlabtest501.ch17_2_room.entity.User


class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insert(user: User) {
        userDao.insert(user)
    }
    suspend fun update(user: User) {
        userDao.update(user)
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }

    fun getUsersByName(name: String): LiveData<List<User>> {
        return userDao.getUsersByName(name)
    }
}