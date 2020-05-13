package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.opensdk.a.a;
import com.tencent.mm.opensdk.a.a.a;
import com.tencent.mm.opensdk.a.a.b;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelpay.PayResp;

final class WXApiImplV10 implements IWXAPI {
  private static final String TAG = "MicroMsg.SDK.WXApiImplV10";
  
  private static String wxappPayEntryClassname;
  
  private String appId;
  
  private boolean checkSignature = false;
  
  private Context context;
  
  private boolean detached = false;
  
  WXApiImplV10(Context paramContext, String paramString, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder("<init>, appId = ");
    stringBuilder.append(paramString);
    stringBuilder.append(", checkSignature = ");
    stringBuilder.append(paramBoolean);
    Log.d("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
    this.context = paramContext;
    this.appId = paramString;
    this.checkSignature = paramBoolean;
  }
  
  private boolean checkSumConsistent(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    String str;
    if (paramArrayOfbyte1 == null || paramArrayOfbyte1.length == 0 || paramArrayOfbyte2 == null || paramArrayOfbyte2.length == 0) {
      str = "checkSumConsistent fail, invalid arguments";
      Log.e("MicroMsg.SDK.WXApiImplV10", str);
      return false;
    } 
    if (str.length != paramArrayOfbyte2.length) {
      str = "checkSumConsistent fail, length is different";
      Log.e("MicroMsg.SDK.WXApiImplV10", str);
      return false;
    } 
    for (byte b = 0; b < str.length; b++) {
      if (str[b] != paramArrayOfbyte2[b])
        return false; 
    } 
    return true;
  }
  
  private boolean createChatroom(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_create_chatroom_group_id", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_name", ""), paramBundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_create_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean joinChatroom(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_basereq_transaction", ""), paramBundle.getString("_wxapi_join_chatroom_group_id", ""), paramBundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), paramBundle.getString("_wxapi_join_chatroom_ext_msg", ""), paramBundle.getString("_wxapi_basereq_openid", "") }null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendAddCardToWX(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_add_card_to_wx_card_list"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendChooseCardFromWX(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[] { paramBundle.getString("_wxapi_choose_card_from_wx_card_app_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_location_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), paramBundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), paramBundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_id"), paramBundle.getString("_wxapi_choose_card_from_wx_card_card_type"), paramBundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendJumpToBizProfileReq(Context paramContext, Bundle paramBundle) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    Uri uri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
    String str2 = this.appId;
    String str3 = paramBundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
    String str1 = paramBundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBundle.getInt("_wxapi_jump_to_biz_profile_req_scene"));
    String str4 = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramBundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type"));
    Cursor cursor = contentResolver.query(uri, null, null, new String[] { str2, str3, str1, str4, stringBuilder.toString() }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendJumpToBizTempSessionReq(Context paramContext, Bundle paramBundle) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    Uri uri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizTempSession");
    String str2 = this.appId;
    String str3 = paramBundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
    String str1 = paramBundle.getString("_wxapi_jump_to_biz_webview_req_session_from");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBundle.getInt("_wxapi_jump_to_biz_webview_req_show_type"));
    Cursor cursor = contentResolver.query(uri, null, null, new String[] { str2, str3, str1, stringBuilder.toString() }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendJumpToBizWebviewReq(Context paramContext, Bundle paramBundle) {
    ContentResolver contentResolver = paramContext.getContentResolver();
    Uri uri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
    String str1 = this.appId;
    String str2 = paramBundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
    String str3 = paramBundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramBundle.getInt("_wxapi_jump_to_biz_webview_req_scene"));
    Cursor cursor = contentResolver.query(uri, null, null, new String[] { str1, str2, str3, stringBuilder.toString() }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendOpenBusiLuckyMoney(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), paramBundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), paramBundle.getString("_wxapi_open_busi_lucky_money_signType"), paramBundle.getString("_wxapi_open_busi_lucky_money_signature"), paramBundle.getString("_wxapi_open_busi_lucky_money_package") }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendOpenRankListReq(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendOpenWebview(Context paramContext, Bundle paramBundle) {
    Cursor cursor = paramContext.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[] { this.appId, paramBundle.getString("_wxapi_jump_to_webview_url"), paramBundle.getString("_wxapi_basereq_transaction") }, null);
    if (cursor != null)
      cursor.close(); 
    return true;
  }
  
  private boolean sendPayReq(Context paramContext, Bundle paramBundle) {
    if (wxappPayEntryClassname == null) {
      wxappPayEntryClassname = (new MMSharedPreferences(paramContext)).getString("_wxapp_pay_entry_classname_", null);
      StringBuilder stringBuilder = new StringBuilder("pay, set wxappPayEntryClassname = ");
      stringBuilder.append(wxappPayEntryClassname);
      Log.d("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
      if (wxappPayEntryClassname == null)
        try {
          wxappPayEntryClassname = (paramContext.getPackageManager().getApplicationInfo("com.tencent.mm", 128)).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
        } catch (Exception exception) {
          stringBuilder = new StringBuilder("get from metaData failed : ");
          stringBuilder.append(exception.getMessage());
          Log.e("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
        }  
      if (wxappPayEntryClassname == null) {
        Log.e("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
        return false;
      } 
    } 
    a.a a = new a.a();
    a.d = paramBundle;
    a.a = "com.tencent.mm";
    a.b = wxappPayEntryClassname;
    return a.a(paramContext, a);
  }
  
  public final void detach() {
    Log.d("MicroMsg.SDK.WXApiImplV10", "detach");
    this.detached = true;
    this.context = null;
  }
  
  public final int getWXAppSupportAPI() {
    if (!this.detached) {
      if (!isWXAppInstalled()) {
        Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
        return 0;
      } 
      int i = (new MMSharedPreferences(this.context)).getInt("_build_info_sdk_int_", 0);
      int j = i;
      if (i == 0)
        try {
          j = (this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128)).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder("get from metaData failed : ");
          stringBuilder.append(exception.getMessage());
          Log.e("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
          j = i;
        }  
      return j;
    } 
    throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
  }
  
  public final boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler) {
    try {
      if (!WXApiImplComm.isIntentFromWx(paramIntent, "com.tencent.mm.openapi.token")) {
        Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
        return false;
      } 
      if (!this.detached) {
        ChooseCardFromWXCardPackage.Resp resp6;
        JoinChatroom.Resp resp5;
        CreateChatroom.Resp resp4;
        OpenWebview.Resp resp3;
        AddCardToWXCardPackage.Resp resp2;
        LaunchFromWX.Req req2;
        PayResp payResp;
        ShowMessageFromWX.Req req1;
        GetMessageFromWX.Req req;
        SendMessageToWX.Resp resp1;
        SendAuth.Resp resp;
        String str1 = paramIntent.getStringExtra("_mmessage_content");
        int i = paramIntent.getIntExtra("_mmessage_sdkVersion", 0);
        String str2 = paramIntent.getStringExtra("_mmessage_appPackage");
        if (str2 == null || str2.length() == 0) {
          Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
          return false;
        } 
        if (!checkSumConsistent(paramIntent.getByteArrayExtra("_mmessage_checksum"), b.a(str1, i, str2))) {
          Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
          return false;
        } 
        i = paramIntent.getIntExtra("_wxapi_command_type", 0);
        switch (i) {
          case 16:
            resp6 = new ChooseCardFromWXCardPackage.Resp();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onResp((BaseResp)resp6);
            return true;
          case 15:
            resp5 = new JoinChatroom.Resp();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onResp((BaseResp)resp5);
            return true;
          case 14:
            resp4 = new CreateChatroom.Resp();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onResp((BaseResp)resp4);
            return true;
          case 12:
            resp3 = new OpenWebview.Resp();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onResp((BaseResp)resp3);
            return true;
          case 9:
            resp2 = new AddCardToWXCardPackage.Resp();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onResp((BaseResp)resp2);
            return true;
          case 6:
            req2 = new LaunchFromWX.Req();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onReq((BaseReq)req2);
            return true;
          case 5:
            payResp = new PayResp();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onResp((BaseResp)payResp);
            return true;
          case 4:
            req1 = new ShowMessageFromWX.Req();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onReq((BaseReq)req1);
            return true;
          case 3:
            req = new GetMessageFromWX.Req();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onReq((BaseReq)req);
            return true;
          case 2:
            resp1 = new SendMessageToWX.Resp();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onResp((BaseResp)resp1);
            return true;
          case 1:
            resp = new SendAuth.Resp();
            this(paramIntent.getExtras());
            paramIWXAPIEventHandler.onResp((BaseResp)resp);
            return true;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        this("unknown cmd = ");
        stringBuilder.append(i);
        Log.e("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
      } else {
        IllegalStateException illegalStateException = new IllegalStateException();
        this("handleIntent fail, WXMsgImpl has been detached");
        throw illegalStateException;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("handleIntent fail, ex = ");
      stringBuilder.append(exception.getMessage());
      Log.e("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
    } 
    return false;
  }
  
  public final boolean isWXAppInstalled() {
    if (!this.detached)
      try {
        PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
        return (packageInfo == null) ? false : WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        return false;
      }  
    throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
  }
  
  public final boolean isWXAppSupportAPI() {
    if (!this.detached)
      return (getWXAppSupportAPI() >= 603979778); 
    throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
  }
  
  public final boolean openWXApp() {
    if (!this.detached) {
      if (!isWXAppInstalled()) {
        Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
        return false;
      } 
      try {
        this.context.startActivity(this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
        return true;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("startActivity fail, exception = ");
        stringBuilder.append(exception.getMessage());
        Log.e("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
        return false;
      } 
    } 
    throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
  }
  
  public final boolean registerApp(String paramString) {
    return registerApp(paramString, 0L);
  }
  
  public final boolean registerApp(String paramString, long paramLong) {
    if (!this.detached) {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
        Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
        return false;
      } 
      StringBuilder stringBuilder2 = new StringBuilder("registerApp, appId = ");
      stringBuilder2.append(paramString);
      Log.d("MicroMsg.SDK.WXApiImplV10", stringBuilder2.toString());
      if (paramString != null)
        this.appId = paramString; 
      stringBuilder2 = new StringBuilder("registerApp, appId = ");
      stringBuilder2.append(paramString);
      Log.d("MicroMsg.SDK.WXApiImplV10", stringBuilder2.toString());
      if (paramString != null)
        this.appId = paramString; 
      StringBuilder stringBuilder1 = new StringBuilder("register app ");
      stringBuilder1.append(this.context.getPackageName());
      Log.d("MicroMsg.SDK.WXApiImplV10", stringBuilder1.toString());
      a.a a = new a.a();
      a.e = "com.tencent.mm";
      a.f = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
      stringBuilder2 = new StringBuilder("weixin://registerapp?appid=");
      stringBuilder2.append(this.appId);
      a.c = stringBuilder2.toString();
      a.g = paramLong;
      return a.a(this.context, a);
    } 
    throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
  }
  
  public final boolean sendReq(BaseReq paramBaseReq) {
    if (!this.detached) {
      String str;
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
        str = "sendReq failed for wechat app signature check failed";
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
      } 
      if (!str.checkArgs()) {
        str = "sendReq checkArgs fail";
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
      } 
      StringBuilder stringBuilder2 = new StringBuilder("sendReq, req type = ");
      stringBuilder2.append(str.getType());
      Log.d("MicroMsg.SDK.WXApiImplV10", stringBuilder2.toString());
      Bundle bundle = new Bundle();
      str.toBundle(bundle);
      if (str.getType() == 5)
        return sendPayReq(this.context, bundle); 
      if (str.getType() == 7)
        return sendJumpToBizProfileReq(this.context, bundle); 
      if (str.getType() == 8)
        return sendJumpToBizWebviewReq(this.context, bundle); 
      if (str.getType() == 10)
        return sendJumpToBizTempSessionReq(this.context, bundle); 
      if (str.getType() == 9)
        return sendAddCardToWX(this.context, bundle); 
      if (str.getType() == 16)
        return sendChooseCardFromWX(this.context, bundle); 
      if (str.getType() == 11)
        return sendOpenRankListReq(this.context, bundle); 
      if (str.getType() == 12)
        return sendOpenWebview(this.context, bundle); 
      if (str.getType() == 13)
        return sendOpenBusiLuckyMoney(this.context, bundle); 
      if (str.getType() == 14)
        return createChatroom(this.context, bundle); 
      if (str.getType() == 15)
        return joinChatroom(this.context, bundle); 
      a.a a = new a.a();
      a.d = bundle;
      StringBuilder stringBuilder1 = new StringBuilder("weixin://sendreq?appid=");
      stringBuilder1.append(this.appId);
      a.c = stringBuilder1.toString();
      a.a = "com.tencent.mm";
      a.b = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
      return a.a(this.context, a);
    } 
    throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
  }
  
  public final boolean sendResp(BaseResp paramBaseResp) {
    if (!this.detached) {
      String str;
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
        str = "sendResp failed for wechat app signature check failed";
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
      } 
      if (!str.checkArgs()) {
        str = "sendResp checkArgs fail";
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
      } 
      Bundle bundle = new Bundle();
      str.toBundle(bundle);
      a.a a = new a.a();
      a.d = bundle;
      StringBuilder stringBuilder = new StringBuilder("weixin://sendresp?appid=");
      stringBuilder.append(this.appId);
      a.c = stringBuilder.toString();
      a.a = "com.tencent.mm";
      a.b = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
      return a.a(this.context, a);
    } 
    throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
  }
  
  public final void unregisterApp() {
    if (!this.detached) {
      if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
        Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder("unregisterApp, appId = ");
      stringBuilder.append(this.appId);
      Log.d("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
      if (this.appId == null || this.appId.length() == 0) {
        Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
        return;
      } 
      stringBuilder = new StringBuilder("unregister app ");
      stringBuilder.append(this.context.getPackageName());
      Log.d("MicroMsg.SDK.WXApiImplV10", stringBuilder.toString());
      a.a a = new a.a();
      a.e = "com.tencent.mm";
      a.f = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
      stringBuilder = new StringBuilder("weixin://unregisterapp?appid=");
      stringBuilder.append(this.appId);
      a.c = stringBuilder.toString();
      a.a(this.context, a);
      return;
    } 
    throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\openapi\WXApiImplV10.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */