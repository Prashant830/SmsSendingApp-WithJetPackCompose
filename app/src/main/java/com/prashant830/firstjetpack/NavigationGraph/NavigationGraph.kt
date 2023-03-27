package com.prashant830.firstjetpack.NavigationGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prashant830.firstjetpack.Model.allfooditems
import com.prashant830.firstjetpack.NavigationMenu.BottomNavItem
import com.prashant830.firstjetpack.Screens.HomeScreen
import com.prashant830.firstjetpack.Screens.ReceiveOtpScreen
import com.prashant830.firstjetpack.Screens.sendOtpList

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeScreen(allfooditems.recyclerList())
        }
        composable(BottomNavItem.SendOtp.screen_route) {
            if(sendOtpList!!.List != null)
            ReceiveOtpScreen(sendOtpList!!.List)
        }
    }
}