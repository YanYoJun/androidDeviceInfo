package com.plbear.deviceinfo.androidversion

import android.app.ActivityManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Handler
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.DisplayMetrics
import android.view.WindowManager
import com.plbear.deviceinfo.base.IDeviceInfo
import java.net.NetworkInterface
import java.util.*

/**
 * created by yanyongjun on 2019-05-23
 */
open class DeviceInfo_14(var context: Context) : IDeviceInfo {
    private var mTelephonyManager: TelephonyManager? = null
    private var mConnectivityManager: ConnectivityManager? = null
    private var mWifiManager: WifiManager? = null
    private var mActivityManager: ActivityManager? = null
    private var mScreenWidth = 0
    private var mScreenHeight = 0
    private var mHandler: Handler? = null
    private var mWindowsManager: WindowManager? = null

    override fun imei(): String {
        return getTelephonyManager().deviceId
    }

    override fun networkType(): String {
        val info = getConnectivityManager().activeNetworkInfo
        if (info != null && info.isConnected) {
            return when (info.type) {
                ConnectivityManager.TYPE_WIFI -> "wifi"
                ConnectivityManager.TYPE_MOBILE -> "cell"
                ConnectivityManager.TYPE_BLUETOOTH -> "bluetooth"
                else -> "other"
            }
        }
        return "other"
    }

    override fun wifiSsid(): String {
        return getWifiManager().connectionInfo.ssid
    }

    override fun wifiBssid(): String {
        return getWifiManager().connectionInfo.bssid ?: ""
    }

    override fun localWifiMac(): String {
        try {
            val all = Collections.list(NetworkInterface.getNetworkInterfaces())
            for (nif in all) {
                if (!nif.name.equals("wlan0", ignoreCase = true)) continue
                val macBytes = nif.hardwareAddress ?: return ""
                val res1 = StringBuilder()
                for (b in macBytes) {
                    res1.append(String.format("%02x:", b))
                }
                if (res1.length > 0) {
                    res1.deleteCharAt(res1.length - 1)
                }
                return res1.toString()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    override fun serial(): String {
        return Build.SERIAL
    }

    protected fun getTelephonyManager(): TelephonyManager {
        if (mTelephonyManager == null) {
            mTelephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        }
        return mTelephonyManager!!
    }

    protected fun getConnectivityManager(): ConnectivityManager {
        if (mConnectivityManager == null) {
            mConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        }
        return mConnectivityManager!!
    }

    protected fun getActivityManager(): ActivityManager {
        if (mActivityManager == null) {
            mActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        }
        return mActivityManager!!
    }

    protected fun getWifiManager(): WifiManager {
        if (mWifiManager == null) {
            mWifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
        }
        return mWifiManager!!
    }

    protected fun getWindowsManager(): WindowManager {
        if (mWindowsManager == null) {
            mWindowsManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
        return mWindowsManager!!
    }

    override fun androidId(): String {
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
    }

    override fun screenWidth(): Int {
        if (mScreenWidth != 0) {
            return mScreenWidth
        }
        val dm = DisplayMetrics()
        getWindowsManager().defaultDisplay.getMetrics(dm)
        mScreenWidth = dm.widthPixels
        return mScreenWidth
    }

    override fun screenHeight(): Int {
        if (mScreenHeight != 0) {
            return mScreenHeight
        }
        val dm = DisplayMetrics()
        getWindowsManager().defaultDisplay.getMetrics(dm)
        mScreenHeight = dm.heightPixels
        return mScreenHeight
    }

    override fun totalMemory(): Long {
        return 0
    }

    override fun availMemory(): Long {
        val mem = ActivityManager.MemoryInfo()
        getActivityManager().getMemoryInfo(mem)
        return mem.availMem
    }

    override fun imsi(): String {
        return getTelephonyManager().subscriberId ?: ""
    }

    override fun iccid(): String {
        return getTelephonyManager().simSerialNumber ?: ""
    }

    override fun ua(): String {
        return System.getProperty("http.agent")
    }

    override fun phoneName(): String {
        return Build.MODEL
    }

    override fun osVersion(): String {
        return Build.VERSION.RELEASE
    }

    override fun sdkVersion(): Int {
        return Build.VERSION.SDK_INT
    }

    override fun simReady(): Boolean {
        return getTelephonyManager().simState == TelephonyManager.SIM_STATE_READY
    }

    override fun simOperator(): String {
        return getTelephonyManager().simOperator
    }
}