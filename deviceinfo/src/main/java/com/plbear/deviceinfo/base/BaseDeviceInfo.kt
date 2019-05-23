package com.plbear.deviceinfo.base

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.TelephonyManager

/**
 * created by yanyongjun on 2019-05-23
 */
open class BaseDeviceInfo(val context: Context) : IDeviceInfo {
    private var mTelephonyManager: TelephonyManager? = null

    override fun imei(): String {
        if (context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            return getTelephonyManager().deviceId
        }
        return ""
    }

    protected fun getTelephonyManager(): TelephonyManager {
        if (mTelephonyManager == null) {
            mTelephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        }
        return mTelephonyManager!!
    }
}