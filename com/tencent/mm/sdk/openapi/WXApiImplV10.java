package com.tencent.mm.sdk.openapi;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.a.a;
import com.tencent.mm.sdk.a.a.a;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.sdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.sdk.modelmsg.LaunchFromWX;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.sdk.modelpay.PayResp;
import com.tencent.wxop.stat.a;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.d;
import com.tencent.wxop.stat.e;

final class WXApiImplV10 implements IWXAPI {
  private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
  
  private static ActivityLifecycleCb activityCb = null;
  
  private static String wxappPayEntryClassname = null;
  
  private String appId;
  
  private boolean checkSignature = false;
  
  private Context context;
  
  private boolean detached = false;
  
  WXApiImplV10(Context paramContext, String paramString, boolean paramBoolean) {
    a.d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + paramString + ", checkSignature = " + paramBoolean);
    this.context = paramContext;
    this.appId = paramString;
    this.checkSignature = paramBoolean;
  }
  
  private boolean checkSumConsistent(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnull -> 20
    //   6: aload_1
    //   7: arraylength
    //   8: ifeq -> 20
    //   11: aload_2
    //   12: ifnull -> 20
    //   15: aload_2
    //   16: arraylength
    //   17: ifne -> 33
    //   20: ldc 'MicroMsg.SDK.WXApiImplV10'
    //   22: ldc 'checkSumConsistent fail, invalid arguments'
    //   24: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   27: iload_3
    //   28: istore #4
    //   30: iload #4
    //   32: ireturn
    //   33: aload_1
    //   34: arraylength
    //   35: aload_2
    //   36: arraylength
    //   37: if_icmpeq -> 53
    //   40: ldc 'MicroMsg.SDK.WXApiImplV10'
    //   42: ldc 'checkSumConsistent fail, length is different'
    //   44: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   47: iload_3
    //   48: istore #4
    //   50: goto -> 30
    //   53: iconst_0
    //   54: istore #5
    //   56: iload #5
    //   58: aload_1
    //   59: arraylength
    //   60: if_icmpge -> 83
    //   63: iload_3
    //   64: istore #4
    //   66: aload_1
    //   67: iload #5
    //   69: baload
    //   70: aload_2
    //   71: iload #5
    //   73: baload
    //   74: if_icmpne -> 30
    //   77: iinc #5, 1
    //   80: goto -> 56
    //   83: iconst_1
    //   84: istore #4
    //   86: goto -> 30
  }
  
  private void initMta(Context paramContext, String paramString) {
    paramString = "AWXOP" + paramString;
    c.b(paramContext, paramString);
    c.w();
    c.a(d.aG);
    c.t();
    c.c(paramContext, "Wechat_Sdk");
    try {
      e.a(paramContext, paramString, "2.0.3");
    } catch (a a) {
      a.printStackTrace();
    } 
  }
  
  private boolean sendAddCardToWX(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_add_card_to_wx_card_list"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendJumpToBizProfileReq(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg"), paramBundle.getInt("_wxapi_jump_to_biz_profile_req_scene"), paramBundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type") }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendJumpToBizWebviewReq(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name"), paramBundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg"), paramBundle.getInt("_wxapi_jump_to_biz_webview_req_scene") }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendPayReq(Context paramContext, Bundle paramBundle) {
    if (wxappPayEntryClassname == null) {
      wxappPayEntryClassname = (new MMSharedPreferences(paramContext)).getString("_wxapp_pay_entry_classname_", null);
      a.d("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
      if (wxappPayEntryClassname == null) {
        a.a("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
        return false;
      } 
    } 
    a.a a = new a.a();
    a.n = paramBundle;
    a.k = "com.tencent.mm";
    a.l = wxappPayEntryClassname;
    return a.a(paramContext, a);
  }
  
  public final void detach() {
    a.d("MicroMsg.SDK.WXApiImplV10", "detach");
    this.detached = true;
    if (activityCb != null && Build.VERSION.SDK_INT >= 14) {
      if (this.context instanceof Activity) {
        ((Activity)this.context).getApplication().unregisterActivityLifecycleCallbacks(activityCb);
      } else if (this.context instanceof Service) {
        ((Service)this.context).getApplication().unregisterActivityLifecycleCallbacks(activityCb);
      } 
      activityCb.detach();
    } 
    this.context = null;
  }
  
  public final int getWXAppSupportAPI() {
    null = 0;
    if (this.detached)
      throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached"); 
    if (!isWXAppInstalled()) {
      a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return null;
    } 
    return (new MMSharedPreferences(this.context)).getInt("_build_info_sdk_int_", 0);
  }
  
  public final boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler) {
    null = false;
    if (!WXApiImplComm.isIntentFromWx(paramIntent, "com.tencent.mm.openapi.token")) {
      a.c("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
      return null;
    } 
    if (this.detached)
      throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached"); 
    String str1 = paramIntent.getStringExtra("_mmessage_content");
    int i = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
    String str2 = paramIntent.getStringExtra("_mmessage_appPackage");
    if (str2 == null || str2.length() == 0) {
      a.a("MicroMsg.SDK.WXApiImplV10", "invalid argument");
      return null;
    } 
    if (!checkSumConsistent(paramIntent.getByteArrayExtra("_mmessage_checksum"), b.a(str1, i, str2))) {
      a.a("MicroMsg.SDK.WXApiImplV10", "checksum fail");
      return null;
    } 
    i = paramIntent.getIntExtra("_wxapi_command_type", 0);
    switch (i) {
      default:
        a.a("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + i);
        return null;
      case 1:
        paramIWXAPIEventHandler.onResp((BaseResp)new SendAuth.Resp(paramIntent.getExtras()));
        return true;
      case 2:
        paramIWXAPIEventHandler.onResp((BaseResp)new SendMessageToWX.Resp(paramIntent.getExtras()));
        return true;
      case 3:
        paramIWXAPIEventHandler.onReq((BaseReq)new GetMessageFromWX.Req(paramIntent.getExtras()));
        return true;
      case 4:
        paramIWXAPIEventHandler.onReq((BaseReq)new ShowMessageFromWX.Req(paramIntent.getExtras()));
        return true;
      case 5:
        paramIWXAPIEventHandler.onResp((BaseResp)new PayResp(paramIntent.getExtras()));
        return true;
      case 6:
        paramIWXAPIEventHandler.onReq((BaseReq)new LaunchFromWX.Req(paramIntent.getExtras()));
        return true;
      case 9:
        break;
    } 
    paramIWXAPIEventHandler.onResp((BaseResp)new AddCardToWXCardPackage.Resp(paramIntent.getExtras()));
    return true;
  }
  
  public final boolean isWXAppInstalled() {
    boolean bool2;
    boolean bool1 = false;
    if (this.detached)
      throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached"); 
    try {
      PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
      if (packageInfo == null)
        return bool1; 
      bool2 = WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      bool2 = bool1;
    } 
    return bool2;
  }
  
  public final boolean isWXAppSupportAPI() {
    if (this.detached)
      throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached"); 
    return (getWXAppSupportAPI() >= 570490883);
  }
  
  public final boolean openWXApp() {
    boolean bool = false;
    if (this.detached)
      throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached"); 
    if (!isWXAppInstalled()) {
      a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
      return bool;
    } 
    try {
      this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
      bool = true;
    } catch (Exception exception) {
      a.a("MicroMsg.SDK.WXApiImplV10", "startActivity fail, exception = " + exception.getMessage());
    } 
    return bool;
  }
  
  public final boolean registerApp(String paramString) {
    if (this.detached)
      throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached"); 
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
      a.a("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
      return false;
    } 
    if (activityCb == null && Build.VERSION.SDK_INT >= 14)
      if (this.context instanceof Activity) {
        initMta(this.context, paramString);
        activityCb = new ActivityLifecycleCb(this.context);
        ((Activity)this.context).getApplication().registerActivityLifecycleCallbacks(activityCb);
      } else if (this.context instanceof Service) {
        initMta(this.context, paramString);
        activityCb = new ActivityLifecycleCb(this.context);
        ((Service)this.context).getApplication().registerActivityLifecycleCallbacks(activityCb);
      } else {
        a.b("MicroMsg.SDK.WXApiImplV10", "context is not instanceof Activity or Service, disable WXStat");
      }  
    a.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + paramString);
    if (paramString != null)
      this.appId = paramString; 
    a.d("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
    a.a a = new a.a();
    a.o = "com.tencent.mm";
    a.p = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
    a.m = "weixin://registerapp?appid=" + this.appId;
    return a.a(this.context, a);
  }
  
  public final boolean sendReq(BaseReq paramBaseReq) {
    null = false;
    if (this.detached)
      throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached"); 
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
      a.a("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
      return null;
    } 
    if (!paramBaseReq.checkArgs()) {
      a.a("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
      return null;
    } 
    a.d("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + paramBaseReq.getType());
    Bundle bundle = new Bundle();
    paramBaseReq.toBundle(bundle);
    if (paramBaseReq.getType() == 5)
      return sendPayReq(this.context, bundle); 
    if (paramBaseReq.getType() == 7)
      return sendJumpToBizProfileReq(this.context, bundle); 
    if (paramBaseReq.getType() == 8)
      return sendJumpToBizWebviewReq(this.context, bundle); 
    if (paramBaseReq.getType() == 9)
      return sendAddCardToWX(this.context, bundle); 
    a.a a = new a.a();
    a.n = bundle;
    a.m = "weixin://sendreq?appid=" + this.appId;
    a.k = "com.tencent.mm";
    a.l = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    return a.a(this.context, a);
  }
  
  public final boolean sendResp(BaseResp paramBaseResp) {
    null = false;
    if (this.detached)
      throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached"); 
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
      a.a("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
      return null;
    } 
    if (!paramBaseResp.checkArgs()) {
      a.a("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
      return null;
    } 
    Bundle bundle = new Bundle();
    paramBaseResp.toBundle(bundle);
    a.a a = new a.a();
    a.n = bundle;
    a.m = "weixin://sendresp?appid=" + this.appId;
    a.k = "com.tencent.mm";
    a.l = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    return a.a(this.context, a);
  }
  
  public final void unregisterApp() {
    if (this.detached)
      throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached"); 
    if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
      a.a("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
      return;
    } 
    a.d("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
    if (this.appId == null || this.appId.length() == 0) {
      a.a("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
      return;
    } 
    a.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
    a.a a = new a.a();
    a.o = "com.tencent.mm";
    a.p = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
    a.m = "weixin://unregisterapp?appid=" + this.appId;
    a.a(this.context, a);
  }
  
  private static final class ActivityLifecycleCb implements Application.ActivityLifecycleCallbacks {
    private static final int DELAYED = 800;
    
    private static final String TAG = "MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb";
    
    private Context context;
    
    private Handler handler = new Handler(Looper.getMainLooper());
    
    private boolean isForeground = false;
    
    private Runnable onPausedRunnable = new WXApiImplV10$ActivityLifecycleCb$1(this);
    
    private Runnable onResumedRunnable = new WXApiImplV10$ActivityLifecycleCb$2(this);
    
    private ActivityLifecycleCb(Context param1Context) {
      this.context = param1Context;
    }
    
    public final void detach() {
      this.handler.removeCallbacks(this.onResumedRunnable);
      this.handler.removeCallbacks(this.onPausedRunnable);
      this.context = null;
    }
    
    public final void onActivityCreated(Activity param1Activity, Bundle param1Bundle) {}
    
    public final void onActivityDestroyed(Activity param1Activity) {}
    
    public final void onActivityPaused(Activity param1Activity) {
      Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", param1Activity.getComponentName().getClassName() + "  onActivityPaused");
      this.handler.removeCallbacks(this.onResumedRunnable);
      this.handler.postDelayed(this.onPausedRunnable, 800L);
    }
    
    public final void onActivityResumed(Activity param1Activity) {
      Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", param1Activity.getComponentName().getClassName() + "  onActivityResumed");
      this.handler.removeCallbacks(this.onPausedRunnable);
      this.handler.postDelayed(this.onResumedRunnable, 800L);
    }
    
    public final void onActivitySaveInstanceState(Activity param1Activity, Bundle param1Bundle) {}
    
    public final void onActivityStarted(Activity param1Activity) {}
    
    public final void onActivityStopped(Activity param1Activity) {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\sdk\openapi\WXApiImplV10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */