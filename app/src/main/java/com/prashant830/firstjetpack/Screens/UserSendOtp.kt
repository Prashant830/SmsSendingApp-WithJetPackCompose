package com.prashant830.firstjetpack.Screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels


class UserSendOtp : ComponentActivity() {
    val userDetailViewModel by viewModels<UserDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userNumber = intent.getStringExtra("number")
            val otp = generateOTP()
            val text = "Hi. Your OTP is : $otp for that $userNumber number. \n" +
                    "Thank you!"
            val userIndex  = intent.getStringExtra("index")
            val userName = intent.getStringExtra("name")
            SendOtpScreen(text, userNumber.toString() , userIndex.toString() , userName.toString() , userDetailViewModel)
        }


    }
}

fun generateOTP(): String {
    val randomPin = (Math.random() * 90000).toInt() + 100000
    return randomPin.toString()
}