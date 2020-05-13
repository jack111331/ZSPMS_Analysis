package com.sina.weibo.sdk.cmd;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.AesEncrypt;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WbAppActivator {
  private static final String TAG = "com.sina.weibo.sdk.cmd.WbAppActivator";
  
  private static WbAppActivator mInstance;
  
  private String mAppkey;
  
  private Context mContext;
  
  private AppInstallCmdExecutor mInstallExecutor;
  
  private AppInvokeCmdExecutor mInvokeExecutor;
  
  private volatile ReentrantLock mLock = new ReentrantLock(true);
  
  private WbAppActivator(Context paramContext, String paramString) {
    this.mContext = paramContext.getApplicationContext();
    this.mInvokeExecutor = new AppInvokeCmdExecutor(this.mContext);
    this.mInstallExecutor = new AppInstallCmdExecutor(this.mContext);
    this.mAppkey = paramString;
  }
  
  public static WbAppActivator getInstance(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/cmd/WbAppActivator
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/cmd/WbAppActivator.mInstance : Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   6: ifnonnull -> 23
    //   9: new com/sina/weibo/sdk/cmd/WbAppActivator
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;)V
    //   19: aload_2
    //   20: putstatic com/sina/weibo/sdk/cmd/WbAppActivator.mInstance : Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   23: getstatic com/sina/weibo/sdk/cmd/WbAppActivator.mInstance : Lcom/sina/weibo/sdk/cmd/WbAppActivator;
    //   26: astore_0
    //   27: ldc com/sina/weibo/sdk/cmd/WbAppActivator
    //   29: monitorexit
    //   30: aload_0
    //   31: areturn
    //   32: astore_0
    //   33: ldc com/sina/weibo/sdk/cmd/WbAppActivator
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	32	finally
    //   23	27	32	finally
  }
  
  private void handleInstallCmd(List<AppInstallCmd> paramList) {
    if (paramList != null) {
      this.mInstallExecutor.start();
      Iterator<AppInstallCmd> iterator = paramList.iterator();
      while (true) {
        if (!iterator.hasNext()) {
          this.mInstallExecutor.stop();
          break;
        } 
        AppInstallCmd appInstallCmd = iterator.next();
        this.mInstallExecutor.doExecutor(appInstallCmd);
      } 
    } 
  }
  
  private void handleInvokeCmd(List<AppInvokeCmd> paramList) {
    if (paramList != null)
      for (AppInvokeCmd appInvokeCmd : paramList)
        this.mInvokeExecutor.doExecutor(appInvokeCmd);  
  }
  
  private static String requestCmdInfo(Context paramContext, String paramString) {
    String str1 = paramContext.getPackageName();
    String str2 = Utility.getSign(paramContext, str1);
    WeiboParameters weiboParameters = new WeiboParameters(paramString);
    weiboParameters.put("appkey", paramString);
    weiboParameters.put("packagename", str1);
    weiboParameters.put("key_hash", str2);
    weiboParameters.put("version", "0031105000");
    return NetUtils.internalHttpRequest(paramContext, "http://api.weibo.cn/2/client/common_config", "GET", weiboParameters);
  }
  
  public void activateApp() {
    final SharedPreferences sdkSp = FrequencyHelper.getWeiboSdkSp(this.mContext);
    long l1 = FrequencyHelper.getFrequency(this.mContext, sharedPreferences);
    long l2 = FrequencyHelper.getLastTime(this.mContext, sharedPreferences);
    l2 = System.currentTimeMillis() - l2;
    if (l2 < l1) {
      LogUtil.v(TAG, String.format("it's only %d ms from last time get cmd", new Object[] { Long.valueOf(l2) }));
      return;
    } 
    (new Thread(new Runnable() {
          public void run() {
            StringBuilder stringBuilder1;
            String str1 = WbAppActivator.TAG;
            StringBuilder stringBuilder2 = new StringBuilder("mLock.isLocked()--->");
            stringBuilder2.append(WbAppActivator.this.mLock.isLocked());
            LogUtil.v(str1, stringBuilder2.toString());
            if (!WbAppActivator.this.mLock.tryLock())
              return; 
            StringBuilder stringBuilder3 = null;
            String str2 = null;
            str1 = null;
            stringBuilder2 = stringBuilder3;
            try {
              StringBuilder stringBuilder;
              String str4 = WbAppActivator.requestCmdInfo(WbAppActivator.this.mContext, WbAppActivator.this.mAppkey);
              String str3 = str1;
              if (str4 != null) {
                stringBuilder = stringBuilder3;
                str4 = AesEncrypt.Decrypt(str4);
                stringBuilder = stringBuilder3;
                CmdInfo cmdInfo = new CmdInfo();
                stringBuilder = stringBuilder3;
                this(str4);
                try {
                  WbAppActivator.this.handleInstallCmd(cmdInfo.getInstallCmds());
                  WbAppActivator.this.handleInvokeCmd(cmdInfo.getInvokeCmds());
                  CmdInfo cmdInfo1 = cmdInfo;
                } catch (WeiboException weiboException1) {
                  WeiboException weiboException2 = weiboException1;
                } finally {}
              } 
              WbAppActivator.this.mLock.unlock();
              if (stringBuilder != null) {
                WbAppActivator.FrequencyHelper.saveFrequency(WbAppActivator.this.mContext, sdkSp, stringBuilder.getFrequency());
                WbAppActivator.FrequencyHelper.saveLastTime(WbAppActivator.this.mContext, sdkSp, System.currentTimeMillis());
              } 
            } catch (WeiboException weiboException) {
              str1 = str2;
              String str = str1;
              LogUtil.e(WbAppActivator.TAG, weiboException.getMessage());
              WbAppActivator.this.mLock.unlock();
              if (str1 != null) {
                WbAppActivator.FrequencyHelper.saveFrequency(WbAppActivator.this.mContext, sdkSp, str1.getFrequency());
                WbAppActivator.FrequencyHelper.saveLastTime(WbAppActivator.this.mContext, sdkSp, System.currentTimeMillis());
              } 
            } finally {
              stringBuilder3 = null;
              stringBuilder1 = stringBuilder2;
            } 
            stringBuilder2.append(WbAppActivator.this.mLock.isLocked());
            LogUtil.v((String)stringBuilder1, stringBuilder2.toString());
          }
        })).start();
  }
  
  private static class FrequencyHelper {
    private static final int DEFAULT_FREQUENCY = 3600000;
    
    private static final String KEY_FREQUENCY = "frequency_get_cmd";
    
    private static final String KEY_LAST_TIME_GET_CMD = "last_time_get_cmd";
    
    private static final String WEIBO_SDK_PREFERENCES_NAME = "com_sina_weibo_sdk";
    
    public static long getFrequency(Context param1Context, SharedPreferences param1SharedPreferences) {
      return (param1SharedPreferences != null) ? param1SharedPreferences.getLong("frequency_get_cmd", 3600000L) : 3600000L;
    }
    
    public static long getLastTime(Context param1Context, SharedPreferences param1SharedPreferences) {
      return (param1SharedPreferences != null) ? param1SharedPreferences.getLong("last_time_get_cmd", 0L) : 0L;
    }
    
    public static SharedPreferences getWeiboSdkSp(Context param1Context) {
      return param1Context.getSharedPreferences("com_sina_weibo_sdk", 0);
    }
    
    public static void saveFrequency(Context param1Context, SharedPreferences param1SharedPreferences, long param1Long) {
      if (param1SharedPreferences != null && param1Long > 0L) {
        SharedPreferences.Editor editor = param1SharedPreferences.edit();
        editor.putLong("frequency_get_cmd", param1Long);
        editor.commit();
      } 
    }
    
    public static void saveLastTime(Context param1Context, SharedPreferences param1SharedPreferences, long param1Long) {
      if (param1SharedPreferences != null) {
        SharedPreferences.Editor editor = param1SharedPreferences.edit();
        editor.putLong("last_time_get_cmd", param1Long);
        editor.commit();
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\sina\weibo\sdk\cmd\WbAppActivator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */