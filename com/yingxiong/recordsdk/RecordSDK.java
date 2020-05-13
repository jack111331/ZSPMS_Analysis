package com.yingxiong.recordsdk;

import android.app.Activity;
import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.yingxiong.action.RecordAction;
import com.yingxiong.common.ConfigSDK;
import com.yingxiong.common.EventRuleCheck;
import com.yingxiong.fpslibrary.TinyCoach;
import com.yingxiong.until.MLog;
import java.util.Map;

public class RecordSDK implements RecordAction.OnInitListener, RecordAction.OnRecordUpdateListener {
  public static String TIME_ZONE_STRING = "UTC+0800";
  
  public static boolean isUTC;
  
  private static volatile RecordSDK mInstance;
  
  private Context context;
  
  String mAppChannelIdx;
  
  String mChannelIdx;
  
  String mChannelNamex;
  
  String oaidx = null;
  
  private OnInitListener onInitListener;
  
  private OnRecordUpdateListener onRecordUpdateListener;
  
  public static RecordSDK getInstance() {
    // Byte code:
    //   0: ldc com/yingxiong/recordsdk/RecordSDK
    //   2: monitorenter
    //   3: getstatic com/yingxiong/recordsdk/RecordSDK.mInstance : Lcom/yingxiong/recordsdk/RecordSDK;
    //   6: ifnonnull -> 42
    //   9: ldc com/yingxiong/recordsdk/RecordSDK
    //   11: monitorenter
    //   12: getstatic com/yingxiong/recordsdk/RecordSDK.mInstance : Lcom/yingxiong/recordsdk/RecordSDK;
    //   15: ifnonnull -> 30
    //   18: new com/yingxiong/recordsdk/RecordSDK
    //   21: astore_0
    //   22: aload_0
    //   23: invokespecial <init> : ()V
    //   26: aload_0
    //   27: putstatic com/yingxiong/recordsdk/RecordSDK.mInstance : Lcom/yingxiong/recordsdk/RecordSDK;
    //   30: ldc com/yingxiong/recordsdk/RecordSDK
    //   32: monitorexit
    //   33: goto -> 42
    //   36: astore_0
    //   37: ldc com/yingxiong/recordsdk/RecordSDK
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    //   42: getstatic com/yingxiong/recordsdk/RecordSDK.mInstance : Lcom/yingxiong/recordsdk/RecordSDK;
    //   45: astore_0
    //   46: ldc com/yingxiong/recordsdk/RecordSDK
    //   48: monitorexit
    //   49: aload_0
    //   50: areturn
    //   51: astore_0
    //   52: ldc com/yingxiong/recordsdk/RecordSDK
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	12	51	finally
    //   12	30	36	finally
    //   30	33	36	finally
    //   37	40	36	finally
    //   40	42	51	finally
    //   42	46	51	finally
  }
  
  public void init(Activity paramActivity, String paramString1, String paramString2, String paramString3) {
    try {
      isUTC = false;
      ConfigSDK.init((Context)paramActivity);
      RecordAction.getInstance().setOnRecordUpdateListener(this);
      RecordAction.getInstance().setOnInitListener(this);
      this.context = (Context)paramActivity;
      this.mChannelNamex = paramString1;
      this.mChannelIdx = paramString2;
      this.mAppChannelIdx = paramString3;
      RecordAction.getInstance().doInit((Context)paramActivity, paramString1, paramString2, paramString3);
    } catch (Exception exception) {
      RecordAction.getInstance().doInit((Context)paramActivity, paramString1, paramString2, paramString3);
      exception.printStackTrace();
    } 
  }
  
  public void init(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4) {
    try {
      isUTC = true;
      TIME_ZONE_STRING = paramString4;
      ConfigSDK.init((Context)paramActivity);
      RecordAction.getInstance().setOnRecordUpdateListener(this);
      RecordAction.getInstance().setOnInitListener(this);
      this.context = (Context)paramActivity;
      this.mChannelNamex = paramString1;
      this.mChannelIdx = paramString2;
      this.mAppChannelIdx = paramString3;
      RecordAction.getInstance().doInit((Context)paramActivity, paramString1, paramString2, paramString3);
    } catch (Exception exception) {
      RecordAction.getInstance().doInit((Context)paramActivity, paramString1, paramString2, paramString3);
      exception.printStackTrace();
    } 
  }
  
  public void onDBUpdateListener(boolean paramBoolean, long paramLong) {
    if (this.onRecordUpdateListener != null)
      this.onRecordUpdateListener.onDBUpdateListener(paramBoolean, paramLong); 
  }
  
  public void onDataUpdateListener(boolean paramBoolean, long paramLong) {
    if (this.onRecordUpdateListener != null)
      this.onRecordUpdateListener.onDataUpdateListener(paramBoolean, paramLong); 
  }
  
  public void onFail(String paramString) {
    if (this.onInitListener != null)
      this.onInitListener.onFail(paramString); 
  }
  
  public void onPause() {
    RecordAction.getInstance().onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt) {
    if (paramInt == 100001 || paramInt == 100002)
      try {
        RecordAction.getInstance().doInit(this.context, this.mChannelNamex, this.mChannelIdx, this.mAppChannelIdx);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void onResume() {
    RecordAction.getInstance().onResume();
  }
  
  public void onSuccess() {
    if (this.onInitListener != null)
      this.onInitListener.onSuccess(); 
  }
  
  public void recordUserInfoAction(String paramString) {
    RecordAction.getInstance().recordErrorAction(paramString);
  }
  
  public void setOnInitListener(OnInitListener paramOnInitListener) {
    this.onInitListener = paramOnInitListener;
  }
  
  public void setOnRecordUpdateListener(OnRecordUpdateListener paramOnRecordUpdateListener) {
    this.onRecordUpdateListener = paramOnRecordUpdateListener;
  }
  
  public void toRecordAction(Map<String, String> paramMap) {
    try {
      String str = JSON.toJSONString(paramMap);
      if (EventRuleCheck.getInstance().checkString(str))
        RecordAction.getInstance().recordAction(paramMap); 
    } catch (Exception exception) {
      exception.printStackTrace();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Log转换异常，请检查格式是否正确\n");
      stringBuilder.append(exception);
      MLog.e("RecordSDK", stringBuilder.toString());
    } 
  }
  
  public void toRecordActionByJson(String paramString) {
    try {
      if (EventRuleCheck.getInstance().checkString(paramString))
        RecordAction.getInstance().recordActionByJson(paramString); 
    } catch (Exception exception) {
      exception.printStackTrace();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Log转换异常，请检查格式是否正确\n");
      stringBuilder1.append(exception);
      MLog.e("RecordSDK", stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("FPS=");
    stringBuilder.append(TinyCoach.fpsNum);
    MLog.e("RecordSDK", stringBuilder.toString());
  }
  
  public void updataOaid(String paramString) {
    this.oaidx = paramString;
    RecordAction.getInstance().updataOaid(paramString);
  }
  
  public static interface OnInitListener {
    void onFail(String param1String);
    
    void onSuccess();
  }
  
  public static interface OnRecordUpdateListener {
    void onDBUpdateListener(boolean param1Boolean, long param1Long);
    
    void onDataUpdateListener(boolean param1Boolean, long param1Long);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\yingxiong\recordsdk\RecordSDK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */