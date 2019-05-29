# androidDeviceInfo
获取Android手机设备信息,
目前包括获取以下信息
- imei 国际移动设备识别码
- imsi 国际移动用户识别码
- networkType 包括四种类型, "wifi" "cell" "bluetooth" "other
- wifiSsid 连接的wifi名称
- wifiBssid 连接路由器的mac地址
- serial 串码
- android Id
- screenWidth 屏幕宽
- screenHeight 屏幕高
- totalMemory 总内存
- availMemory 可用内存
- iccid sim卡标识
- ua  WebView的UserAgent
- phoneName 手机型号名称
- osVersion Android版本
- sdkVersion Android SDK版本
- isSimReady 是否插入sim卡
- simOperator 运营商ID

# 使用办法
在工程目录下添加
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
在模块目录下添加
```
implementation 'com.github.YanYoJun:androidDeviceInfo:1.0.6
```
# 当前最新版本
1.0.6
