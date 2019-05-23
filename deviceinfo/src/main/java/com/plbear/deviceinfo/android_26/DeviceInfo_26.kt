package com.plbear.deviceinfo.android_26

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import com.plbear.deviceinfo.base.BaseDeviceInfo

/**
 * created by yanyongjun on 2019-05-23
 */
open class DeviceInfo_26(context: Context) : BaseDeviceInfo(context) {
    override fun imei(): String {
        if (context.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            return getTelephonyManager().imei
        }
        return ""
    }
}