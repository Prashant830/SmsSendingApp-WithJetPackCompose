package com.prashant830.firstjetpack.network.sevices

import com.prashant830.firstjetpack.Model.SendSmsModel
import retrofit2.Response
import retrofit2.http.*

interface SendSmsApi {

    @FormUrlEncoded
     @POST("sms/json")
     suspend fun sendMessage(@FieldMap metadata : Map<String,String>)
    : Response<SendSmsModel>

}