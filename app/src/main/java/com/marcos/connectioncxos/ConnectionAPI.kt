package com.marcos.connectioncxos

import okhttp3.ResponseBody
import retrofit2.http.GET

interface ConnectionAPI {

    @GET("v2/")
    suspend fun getData(): ResponseBody
}