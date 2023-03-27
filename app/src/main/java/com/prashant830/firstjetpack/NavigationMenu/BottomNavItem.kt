package com.prashant830.firstjetpack.NavigationMenu

import com.prashant830.firstjetpack.R


sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

    object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
    object SendOtp: BottomNavItem("SentOtp", R.drawable.ic_otp,"my_network")

}