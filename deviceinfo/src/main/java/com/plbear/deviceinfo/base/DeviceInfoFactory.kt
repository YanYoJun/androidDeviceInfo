package com.plbear.deviceinfo.base

import android.content.Context
import android.os.Build
import com.plbear.deviceinfo.androidversion.*

/**
 * created by yanyongjun on 2019-05-23
 */
object DeviceInfoFactory {
    fun create(context: Context): IDeviceInfo {
        val sdk = Build.VERSION.SDK_INT
        return when (sdk) {
            Build.VERSION_CODES.ICE_CREAM_SANDWICH -> DeviceInfo_14(context)
            Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1 -> DeviceInfo_15(context)
            Build.VERSION_CODES.JELLY_BEAN -> DeviceInfo_16(context)
            Build.VERSION_CODES.JELLY_BEAN_MR1 -> DeviceInfo_17(context)
            Build.VERSION_CODES.JELLY_BEAN_MR2 -> DeviceInfo_18(context)
            Build.VERSION_CODES.KITKAT -> DeviceInfo_19(context)
            Build.VERSION_CODES.KITKAT_WATCH -> DeviceInfo_20(context)
            Build.VERSION_CODES.LOLLIPOP -> DeviceInfo_21(context)
            Build.VERSION_CODES.LOLLIPOP_MR1 -> DeviceInfo_22(context)
            Build.VERSION_CODES.M -> DeviceInfo_23(context)
            Build.VERSION_CODES.N -> DeviceInfo_24(context)
            Build.VERSION_CODES.N_MR1 -> DeviceInfo_25(context)
            Build.VERSION_CODES.O -> DeviceInfo_26(context)
            Build.VERSION_CODES.O_MR1 -> DeviceInfo_27(context)
            Build.VERSION_CODES.P -> DeviceInfo_28(context)
            else -> DeviceInfo_29(context)
        }
    }
}