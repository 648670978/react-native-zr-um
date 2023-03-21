
package com.RNZrUm;

import android.content.Context;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

public class RNZrUmModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private String appkey;
  private String channel;

  public RNZrUmModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    Context context = reactContext.getApplicationContext();
    appkey = context.getApplicationInfo().metaData.getString("UM_APPKEY");
    channel = context.getApplicationInfo().metaData.getString("UM_CHANNEL");
    UMConfigure.preInit(reactContext,appkey,channel);
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
  public void onKillProcess() {
    MobclickAgent.onKillProcess(reactContext);
  }


}