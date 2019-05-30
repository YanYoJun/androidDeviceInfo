package com.plbear.deviceinfo.androidversion

import android.Manifest
import android.app.ActivityManager
import android.content.Context

/**
 * created by yanyongjun on 2019-05-23
 */
open class DeviceInfo_16(context: Context) : DeviceInfo_15(context) {
    override fun totalMemory(): Long {
        val mem = ActivityManager.MemoryInfo()
        getActivityManager().getMemoryInfo(mem)
        return mem.totalMem
    }
}