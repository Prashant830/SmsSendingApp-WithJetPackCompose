package com.prashant830.firstjetpack.network

import android.util.Base64
import com.prashant830.firstjetpack.network.sevices.SendSmsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManagement {

    var okHttp: OkHttpClient? = null
    private val BASE_URL = "https://rest.nexmo.com/"

    fun getRetrofit() : Retrofit?{
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = (HttpLoggingInterceptor.Level.BODY)
        okHttp = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    // api declarations...
    val sendSmsApi = getRetrofit()
        ?.create(SendSmsApi::class.java)


}