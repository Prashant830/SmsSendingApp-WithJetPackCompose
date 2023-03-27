package com.prashant830.firstjetpack.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class UserDetails : ComponentActivity() {

    val userDetailViewModel by viewModels<UserDetailViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userName = intent.getStringExtra("user_name")
            val userNumber = intent.getStringExtra("user_number")
            val userIndex  = intent.getStringExtra("user_index")

            if (userIndex != null) {
                UserDetailScreen(userName.toString(), userNumber.toString(), userIndex)
            }
        }
    }
}

