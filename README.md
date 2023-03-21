
# react-native-zr-um

## Getting started

`$ npm install react-native-zr-um --save`


#### iOS
在 Info.plist 添加

```
<key>UM_APPKEY</key>
<string>友盟appkey</string>
<key>UM_CHANNEL</key>
<string>App Store</string>
```

#### Android

在 android/app/build.gradle 添加

```
android {
	defaultConfig {
		manifestPlaceholders = [
            UM_APPKEY: "友盟appkey",
            UM_CHANNEL: "渠道"
        ]
	}
}

```

在 android/app/src/main/AndroidManifest.xml 添加

```
<application>
    	<meta-data
                android:name="UM_APPKEY"
                android:value="${UM_APPKEY}" />
        <meta-data
                android:name="UM_CHANNEL"
                android:value="${UM_CHANNEL}" />
</application>

```



## Usage
```javascript
import {initUM} from 'react-native-zr-um';

initUM()

```
  