package com.plbear.deviceinfo.androidversion

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.NetworkCapabilities

/**
 * created by yanyongjun on 2019-05-23
 */
open class DeviceInfo_23(context: Context) : DeviceInfo_22(context) {

    override fun networkType(): String {
        val networkCapabilities =
            getConnectivityManager().getNetworkCapabilities(getConnectivityManager().activeNetwork)
        if (networkCapabilities != null) {
            if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return "wifi"
            } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return "cell"
            } else if (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH)) {
                return "bluetooth"
            }
        }
        return "other"
    }

    override fun imsi(): String {
        if (checkPermission(Manifest.permission.READ_PHONE_STATE)) {
            return super.imsi()
        }
        return ""
    }

    override fun iccid(): String {
        if (checkPermission(Manifest.permission.READ_PHONE_STATE)) {
            return super.iccid()
        }
        return ""
    }

    override fun imei(): String {
        if (checkPermission(Manifest.permission.READ_PHONE_STATE)) {
            return super.imei()
        }
        return ""
    }

    protected fun checkPermission(vararg permissiones: String): Boolean {
        for (permission in permissiones) {
            if (context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                return false
            }
        }
        return true
    }
}