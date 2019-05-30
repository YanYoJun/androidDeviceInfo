package com.plbear.deviceinfo.androidversion

import android.Manifest
import android.content.Context
import android.webkit.WebSettings

/**
 * created by yanyongjun on 2019-05-23
 */
open class DeviceInfo_17(context: Context) : DeviceInfo_16(context) {
    override fun ua(): String {
        return try {
            WebSettings.getDefaultUserAgent(context)
        } catch (e: Exception) {
            super.ua()
        }
    }
}