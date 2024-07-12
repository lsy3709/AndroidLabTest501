package com.busanit501.androidlabtest501.ch17_2_room.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.busanit501.androidlabtest501.ch17_2_room.entity.User
import com.busanit501.androidlabtest501.ch17_2_room.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val allUsers: LiveData<List<User>> = repository.allUsers

    val isLoading = MutableLiveData<Boolean>()

    fun insert(user: User) = viewModelScope.launch {
        isLoading.value = true
        try {
            repository.insert(user)
        } catch (e: Exception) {
            // Handle the exception
        } finally {
            isLoading.value = false
        }
    }

    fun update(user: User) = viewModelScope.launch {
        repository.update(user)
    }

    fun delete(user: User) = viewModelScope.launch {
        repository.delete(user)
    }

    fun getUsersByName(name: String): LiveData<List<User>> {
        return repository.getUsersByName(name)
    }
}
