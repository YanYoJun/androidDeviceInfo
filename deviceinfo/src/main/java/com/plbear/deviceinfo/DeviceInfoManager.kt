package com.plbear.deviceinfo

import android.content.Context
import com.plbear.deviceinfo.base.DeviceInfoFactory
import com.plbear.deviceinfo.base.IDeviceInfo
import java.lang.Exception

/**
 * created by yanyongjun on 2019-05-23
 */
class DeviceInfoManager(val context: Context) {
    private val deviceInfo: IDeviceInfo

    init {
        deviceInfo = DeviceInfoFactory.create(context)
    }

    /**
     * 当没有对应权限的时候, 直接返回""
     * @permission android.permission.READ_PHONE_STATE
     */
    fun imei(): String {
        try {
            return deviceInfo.imei()
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    /**
     * 当没有对应权限的时候, 会自动申请权限. 申请成功后, 回调listener告知结果
     * @permission android.permission.READ_PHONE_STATE
     */
    fun imei(listener: OnGetListener) {
    }
}