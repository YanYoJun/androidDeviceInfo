package com.plbear.deviceinfo.base

/**
 * created by yanyongjun on 2019-05-23
 */
interface IDeviceInfo {
    fun imei(): String
    fun networkType(): String
    fun wifiSsid(): String
    fun wifiBssid(): String
    fun localWifiMac(): String
    fun serial(): String
    fun androidId(): String
    fun screenWidth(): Int
    fun screenHeight(): Int
    fun totalMemory(): Long
    fun availMemory(): Long
    fun imsi(): String
    fun iccid(): String
    fun ua(callback: (String) -> Unit)
    fun phoneName(): String
    fun osVersion(): String
    fun sdkVersion(): Int
    fun simReady(): Boolean
    fun simOperator(): String
}