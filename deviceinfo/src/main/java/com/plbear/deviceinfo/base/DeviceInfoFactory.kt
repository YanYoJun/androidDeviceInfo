package com.plbear.deviceinfo.base

import android.content.Context
import android.os.Build
import com.plbear.deviceinfo.android_26.DeviceInfo_26

/**
 * created by yanyongjun on 2019-05-23
 */
object DeviceInfoFactory {
    fun create(context: Context): IDeviceInfo {
        val sdk = Build.VERSION.SDK_INT
        val board = Build.BOARD.toLowerCase()
        return when (sdk) {
            Build.VERSION_CODES.O -> DeviceInfo_26(context)
            else -> BaseDeviceInfo(context)
        }
    }

}