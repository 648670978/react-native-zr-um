
package com.RNZrUm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.umcrash.UMCrash;

public class RNZrUmModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private String appkey;
  private String channel;

  public RNZrUmModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    try {
      ApplicationInfo appInfo = reactContext.getPackageManager().getApplicationInfo(reactContext.getPackageName(), PackageManager.GET_META_DATA);
      Bundle bundle = appInfo.metaData;
      appkey = bundle.getString("UM_APPKEY");
      channel = bundle.getString("UM_CHANNEL");
      UMConfigure.preInit(reactContext,appkey,channel);
    } catch (PackageManager.NameNotFoundException e) {
      Log.e("RNZrUmModule", "RNZrUmModule: "+e );
    }
  }

  @Override
  public String getName() {
    return "RNZrUm";
  }

  @ReactMethod
  public void initUM() {
   UMConfigure.init(reactContext,appkey,channel,UMConfigure.DEVICE_TYPE_PHONE, "");
  }

  @ReactMethod
  public void setCrash(String error) {
    UMCrash.generateCustomLog(error,"UmengException");
  }

  @ReactMethod
  public void onKillProcess() {
    MobclickAgent.onKillProcess(reactContext);
  }


}