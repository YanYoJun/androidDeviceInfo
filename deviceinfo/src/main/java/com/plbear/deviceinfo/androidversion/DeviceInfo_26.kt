package com.plbear.deviceinfo.androidversion

import android.Manifest
import android.content.Context
import android.os.Build
import com.github.dfqin.grantor.PermissionsUtil

/**
 * created by yanyongjun on 2019-05-23
 */
open class DeviceInfo_26(context: Context) : DeviceInfo_25(context) {
    override fun imei(): String {
        if (PermissionsUtil.hasPermission(context,Manifest.permission.READ_PHONE_STATE)) {
            return getTelephonyManager().imei
        }
        return ""
    }

    override fun serial(): String {
        if(PermissionsUtil.hasPermission(context,Manifest.permission.READ_PHONE_STATE)) {
            return Build.getSerial()
        }
        return super.serial()
    }
}