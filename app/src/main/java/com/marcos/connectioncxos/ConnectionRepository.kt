package com.marcos.connectioncxos

class ConnectionRepository(private val connectionRetrofitService: ConnectionRetrofitService) {

    suspend fun getData(): String {
        return connectionRetrofitService.getRetrofit().getData().string()
    }
}