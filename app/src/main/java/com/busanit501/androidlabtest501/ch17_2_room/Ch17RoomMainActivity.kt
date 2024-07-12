package com.busanit501.androidlabtest501.ch17_2_room

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.ch17_2_room.application.UserApplication
import com.busanit501.androidlabtest501.ch17_2_room.entity.User
import com.busanit501.androidlabtest501.ch17_2_room.recycler_adapter.UserAdapter
import com.busanit501.androidlabtest501.ch17_2_room.recycler_adapter.UserListAdapter
import com.busanit501.androidlabtest501.ch17_2_room.viewmodel.UserViewModel
import com.busanit501.androidlabtest501.ch17_2_room.viewmodel.UserViewModelFactory
import com.busanit501.androidlabtest501.databinding.ActivityCh17RoomMainBinding


class Ch17RoomMainActivity : AppCompatActivity() {
    lateinit var binding : ActivityCh17RoomMainBinding
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory((application as UserApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCh17RoomMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = UserAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.allUsers.observe(this, Observer { users ->
            users?.let { adapter.submitList(it) }
        })

        binding.buttonAdd.setOnClickListener {
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString().toIntOrNull() ?: 0
            userViewModel.insert(User(name = name, age = age))
        }

        binding.buttonUpdate.setOnClickListener {
            val id = binding.editTextId.text.toString().toIntOrNull() ?: return@setOnClickListener
            val name = binding.editTextName.text.toString()
            val age = binding.editTextAge.text.toString().toIntOrNull() ?: 0
            userViewModel.update(User(id = id, name = name, age = age))
        }

        binding.buttonDelete.setOnClickListener {
            val id = binding.editTextId.text.toString().toIntOrNull() ?: return@setOnClickListener
            userViewModel.delete(User(id = id, name = "", age = 0))
        }
        // 예시로 데이터 삽입
//        userViewModel.insert(User(name = "John Doe", age = 25))
    } // onCreate

}
