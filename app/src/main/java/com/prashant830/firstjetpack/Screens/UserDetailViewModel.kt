package com.prashant830.firstjetpack.Screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prashant830.firstjetpack.Model.Message
import com.prashant830.firstjetpack.Model.recycler
import com.prashant830.firstjetpack.R
import com.prashant830.firstjetpack.network.ApiManagement
import kotlinx.coroutines.launch

class UserDetailViewModel : ViewModel() {

    var respose: List<Message> by mutableStateOf(listOf())


    fun getSendSmsResponse(map: Map<String,String>, name : String , msgg : String, num : String ,dateandtime : String , index : String){
        viewModelScope.launch {
            val response = ApiManagement.sendSmsApi?.sendMessage(map)
            Log.d("respose", response?.body().toString())
            if(response?.isSuccessful == true){
                //  Toast.makeText(context, "message send successfully !!", Toast.LENGTH_SHORT).show()
                val new = recycler(
                    Name = name,
                    description = msgg,
                    imageId = R.drawable.person,
                    PhoneNumber = num,
                    dateandtime = dateandtime,
                    index = index,
                )
                if(sendOtpList.List != null)
                    sendOtpList.List!!.add(new)

                Log.d("dndm", sendOtpList.List.toString())
                respose = response.body()!!.messages
            }
        }
    }

}