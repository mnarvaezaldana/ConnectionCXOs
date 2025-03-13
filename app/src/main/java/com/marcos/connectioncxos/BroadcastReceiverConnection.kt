package com.marcos.connectioncxos

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast


class BroadcastReceiverConnection: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        try {
            if (ConnectivityManager.CONNECTIVITY_ACTION == intent.action) {
                if (isThereInternetConnection(context)) {
                    Toast.makeText(context, "yes connection", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "no connection", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "no connection", Toast.LENGTH_SHORT).show()
            }
        } catch (exception: Exception) {
            Toast.makeText(context, "error " + exception.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun isThereInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activityNetwork = connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return when {
            activityNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activityNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            activityNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}