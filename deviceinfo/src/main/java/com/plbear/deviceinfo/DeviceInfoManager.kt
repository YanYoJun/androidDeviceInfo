package com.plbear.deviceinfo

import android.Manifest
import android.content.Context
import com.plbear.deviceinfo.base.DeviceInfoFactory
import com.plbear.deviceinfo.base.IDeviceInfo
import java.lang.Exception

/**
 * created by yanyongjun on 2019-05-23
 */
class DeviceInfoManager(val context: Context) {
    private val deviceInfo: IDeviceInfo = DeviceInfoFactory.create(context)

    companion object {
        private var instance: DeviceInfoManager? = null
        fun get(context: Context): DeviceInfoManager {
            if (instance == null) {
                synchronized(DeviceInfoManager::class.java) {
                    if (instance == null) {
                        instance = DeviceInfoManager(context)
                    }
                }
            }
            return instance!!
        }
    }

    /**
     * 当没有对应权限的时候, 直接返回""
     * @permission android.permiussion.READ_PHONE_STATE
     */
    fun imei(): String {
        return try {
            deviceInfo.imei()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * 读取网络类型
     * @permission android.permission.ACCESS_NETWORK_STATE
     * @return "wifi" "cell" "bluetooth" "other"
     */
    fun networkType(): String {
        return try {
            deviceInfo.networkType()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * 读取WIFI的ssid,即WIFI名称
     * @permission android.permission.ACCESS_NETWORK_STATE
     * @return String
     */
    fun wifiSsid(): String {
        return try {
            deviceInfo.wifiSsid()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * 获取wifi的bssid, 即远端路由器的mac地址
     */
    fun wifiBssid(): String {
        return try {
            deviceInfo.wifiBssid()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * 读取本地的wifi mac地址
     */
    fun wifiLocalMac(): String {
        return try {
            deviceInfo.localWifiMac()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * Android 6.0以上, 如果没有权限,则不会去尝试申请权限, 而直接返回""
     * serial
     * @permission android.permission.READ_PHONE_STATE
     */
    fun serial(): String {
        return try {
            deviceInfo.serial()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * android_id
     */
    fun androidId(): String {
        return try {
            deviceInfo.androidId()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * 屏幕尺寸, 宽
     */
    fun screenWidth(): Int {
        return try {
            deviceInfo.screenWidth()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    /**
     * 屏幕尺寸 高
     */
    fun screenHeight(): Int {
        return try {
            deviceInfo.screenHeight()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    /**
     * 总内存
     */
    fun totalMemory(): Long {
        return try {
            deviceInfo.totalMemory()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    /**
     * 可用内存
     */
    fun availMemory(): Long {
        return try {
            deviceInfo.availMemory()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    /**
     * 不会去申请权限, 当没有权限后, 则返回""
     * imsi 与你的手机卡是绑定关系 用于区别移动用户的有效信息 IMSI是用户的标识。
     * @permission android.permission.READ_PHONE_STATE
     */
    fun imsi(): String {
        return try {
            deviceInfo.imsi()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * Android6.0以上, 如果没有权限, 则不会尝试去申请权限, 直接返回""
     * ICCID是卡的标识，由20位数字组成
     * @permission android.permission.READ_PHONE_STATE
     */
    fun iccid(): String {
        return try {
            deviceInfo.iccid()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * 获取WebView的userAgent
     */
    fun ua(): String {
        return try {
            deviceInfo.ua()
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    /**
     * 返回手机名称
     */
    fun phoneName(): String {
        return try {
            deviceInfo.phoneName()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * osVersion
     */
    fun osVersion(): String {
        return try {
            deviceInfo.osVersion()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    /**
     * sdk version
     */
    fun sdkVersion(): Int {
        return try {
            deviceInfo.sdkVersion()
        } catch (e: Exception) {
            e.printStackTrace()
            0
        }
    }

    /**
     * 看一下sim卡是否插好了
     */
    fun isSimReady(): Boolean {
        return try {
            deviceInfo.simReady()
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    /**
     * 运营商
     */
    fun simOperator(): String {
        return try {
            deviceInfo.simOperator()
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
}