package com.marcos.connectioncxos

import android.net.TrafficStats
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ConnectionVM @Inject constructor(val repo: ConnectionRepository): ViewModel() {

    suspend fun getData(): String {
        return repo.getData()
    }

    fun getWifiInfo(): Long {
        val rxBytes = TrafficStats.getTotalRxBytes()
        val txBytes = TrafficStats.getTotalTxBytes()

        return rxBytes + txBytes
    }
}