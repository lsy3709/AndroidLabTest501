package com.busanit501.androidlabtest501.ch17_2_room.recycler_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.ch17_2_room.entity.User
import androidx.recyclerview.widget.ListAdapter
import com.busanit501.androidlabtest501.ch3_4_5.name

class UserAdapter : ListAdapter<User, UserAdapter.UserViewHolder>(UsersComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.id, current.name, current.age)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userItemIdView: TextView = itemView.findViewById(R.id.textViewId)
        private val userItemNameView: TextView = itemView.findViewById(R.id.textViewName)
        private val userItemAgeView: TextView = itemView.findViewById(R.id.textViewAge)
        fun bind(id:Int, name: String?, age: Int) {
            userItemIdView.text = id.toString()
            userItemNameView.text = name
            userItemAgeView.text = age.toString()
        }

        companion object {
            fun create(parent: ViewGroup): UserViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return UserViewHolder(view)
            }
        }
    }

    class UsersComparator : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
    }
}