package com.plbear.androiddeviceinfo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.plbear.deviceinfo.DeviceInfoManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imei.text = DeviceInfoManager(this).imei()
    }
}
