package com.plbear.deviceinfo.androidversion

import android.Manifest
import android.content.Context
import android.net.NetworkCapabilities
import com.github.dfqin.grantor.PermissionsUtil

/**
 * created by yanyongjun on 2019-05-23
 */
open class DeviceInfo_23(context: Context) : DeviceInfo_22(context) {

    override fun networkType(): String {
        val networkCapabilities = getConnectivityManager().getNetworkCapabilities(getConnectivityManager().activeNetwork)
        if(networkCapabilities != null){
            if(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)){
                return "wifi"
            } else if(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)){
                return "cell"
            } else if(networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH)){
                return "bluetooth"
            }
        }
        return "other"
    }
}