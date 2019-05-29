package com.plbear.deviceinfo.androidversion

import android.Manifest
import android.content.Context
import com.github.dfqin.grantor.PermissionsUtil

/**
 * created by yanyongjun on 2019-05-23
 */
open class DeviceInfo_27(context: Context) : DeviceInfo_26(context) {
    override fun imei(): String {
        if (PermissionsUtil.hasPermission(context, Manifest.permission.READ_PHONE_STATE)) {
            return getTelephonyManager().imei
        }
        return ""
    }

    override fun wifiSsid(): String {
        if (networkType() == "wifi") {
            return getConnectivityManager().activeNetworkInfo?.extraInfo ?: ""
        }
        return super.wifiSsid()
    }
}