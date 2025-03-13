package com.marcos.connectioncxos

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class ConnectionRetrofitService(private val context: Context) {

    fun getRetrofit(): ConnectionAPI {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(200, TimeUnit.SECONDS)
            .connectTimeout(200, TimeUnit.SECONDS)
            .callTimeout(200, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(okHttpClient)
            .build()
            .create(ConnectionAPI::class.java)
    }
}