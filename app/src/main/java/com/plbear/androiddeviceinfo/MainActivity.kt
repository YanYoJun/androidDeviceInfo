package com.plbear.androiddeviceinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.plbear.deviceinfo.DeviceInfoManager
import com.plbear.deviceinfo.OnGetListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearlayout.addView(createTextView("imei: ${DeviceInfoManager.get(this).imei()}"))
        linearlayout.addView(createTextView("imsi: ${DeviceInfoManager.get(this).imsi()}"))
        linearlayout.addView(createTextView("androidId: ${DeviceInfoManager.get(this).androidId()}"))
        linearlayout.addView(createTextView("availMemory: ${DeviceInfoManager.get(this).availMemory()}"))
        linearlayout.addView(createTextView("iccid: ${DeviceInfoManager.get(this).iccid()}"))
        linearlayout.addView(createTextView("isSimReady: ${DeviceInfoManager.get(this).isSimReady()}"))
        linearlayout.addView(createTextView("networkType: ${DeviceInfoManager.get(this).networkType()}"))
        linearlayout.addView(createTextView("osVersion: ${DeviceInfoManager.get(this).osVersion()}"))
        linearlayout.addView(createTextView("phoneName: ${DeviceInfoManager.get(this).phoneName()}"))
        linearlayout.addView(createTextView("screenHeight: ${DeviceInfoManager.get(this).screenHeight()}"))
        linearlayout.addView(createTextView("screenWidth: ${DeviceInfoManager.get(this).screenWidth()}"))
        linearlayout.addView(createTextView("sdkVersion: ${DeviceInfoManager.get(this).sdkVersion()}"))
        linearlayout.addView(createTextView("serial: ${DeviceInfoManager.get(this).serial()}"))
        linearlayout.addView(createTextView("simOperator: ${DeviceInfoManager.get(this).simOperator()}"))
        linearlayout.addView(createTextView("totalMemory: ${DeviceInfoManager.get(this).totalMemory()}"))
    }

    fun createTextView(txt: String): TextView {
        val textView = TextView(this)
        textView.text = txt
        return textView
    }
}
