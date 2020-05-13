package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.b;
import com.tencent.open.utils.c;
import com.tencent.open.utils.d;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;

public class QQShare extends BaseApi {
  public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
  
  public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
  
  public static final String SHARE_TO_QQ_APP_NAME = "appName";
  
  public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
  
  public static final String SHARE_TO_QQ_EXT_INT = "cflag";
  
  public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
  
  public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
  
  public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
  
  public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
  
  public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
  
  public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
  
  public static final String SHARE_TO_QQ_SITE = "site";
  
  public static final String SHARE_TO_QQ_SUMMARY = "summary";
  
  public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
  
  public static final String SHARE_TO_QQ_TITLE = "title";
  
  public static final int SHARE_TO_QQ_TYPE_APP = 6;
  
  public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
  
  public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
  
  public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
  
  public String mViaShareQQType = "";
  
  public QQShare(Context paramContext, QQToken paramQQToken) {
    super(paramQQToken);
  }
  
  private void b(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
    String str1 = paramBundle.getString("imageUrl");
    String str2 = paramBundle.getString("title");
    String str3 = paramBundle.getString("summary");
    f.a("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + str1);
    if (!TextUtils.isEmpty(str1)) {
      if (i.g(str1)) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
          if (paramIUiListener != null) {
            paramIUiListener.onError(new UiError(-6, "分享图片失败，检测不到SD卡!", null));
            f.e("openSDK_LOG.QQShare", "分享图片失败，检测不到SD卡!");
          } 
          d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "分享图片失败，检测不到SD卡!");
          return;
        } 
        if (!i.f((Context)paramActivity, "4.3.0")) {
          c(paramActivity, paramBundle, paramIUiListener);
        } else {
          (new b(paramActivity)).a(str1, new c(this, paramBundle, str2, str3, paramIUiListener, paramActivity) {
                public void a(int param1Int, String param1String) {
                  if (param1Int == 0) {
                    this.a.putString("imageLocalUrl", param1String);
                  } else if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
                    if (this.d != null) {
                      this.d.onError(new UiError(-6, "获取分享图片失败!", null));
                      f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                    } 
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", QQShare.a(this.f).getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
                    return;
                  } 
                  QQShare.a(this.f, this.e, this.a, this.d);
                }
                
                public void a(int param1Int, ArrayList<String> param1ArrayList) {}
              });
        } 
      } else {
        paramBundle.putString("imageUrl", null);
        if (i.f((Context)paramActivity, "4.3.0")) {
          f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
          c(paramActivity, paramBundle, paramIUiListener);
        } else {
          f.b("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0 ");
          a.a((Context)paramActivity, str1, new c(this, paramBundle, str2, str3, paramIUiListener, paramActivity) {
                public void a(int param1Int, String param1String) {
                  if (param1Int == 0) {
                    this.a.putString("imageLocalUrl", param1String);
                  } else if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
                    if (this.d != null) {
                      this.d.onError(new UiError(-6, "获取分享图片失败!", null));
                      f.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                    } 
                    d.a().a(1, "SHARE_CHECK_SDK", "1000", QQShare.b(this.f).getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "获取分享图片失败!");
                    return;
                  } 
                  QQShare.a(this.f, this.e, this.a, this.d);
                }
                
                public void a(int param1Int, ArrayList<String> param1ArrayList) {}
              });
        } 
      } 
    } else {
      c(paramActivity, paramBundle, paramIUiListener);
    } 
    f.c("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
  }
  
  private void c(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    f.c("openSDK_LOG.QQShare", "doShareToQQ() -- start");
    StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
    String str3 = paramBundle.getString("imageUrl");
    String str4 = paramBundle.getString("title");
    String str5 = paramBundle.getString("summary");
    String str6 = paramBundle.getString("targetUrl");
    String str7 = paramBundle.getString("audio_url");
    int i = paramBundle.getInt("req_type", 1);
    int j = paramBundle.getInt("cflag", 0);
    String str8 = paramBundle.getString("share_qq_ext_str");
    String str9 = i.a((Context)paramActivity);
    String str10 = str9;
    if (str9 == null)
      str10 = paramBundle.getString("appName"); 
    String str11 = paramBundle.getString("imageLocalUrl");
    String str2 = this.b.getAppId();
    str9 = this.b.getOpenId();
    f.a("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + str9);
    if (!TextUtils.isEmpty(str3))
      stringBuffer.append("&image_url=" + Base64.encodeToString(i.i(str3), 2)); 
    if (!TextUtils.isEmpty(str11))
      stringBuffer.append("&file_data=" + Base64.encodeToString(i.i(str11), 2)); 
    if (!TextUtils.isEmpty(str4))
      stringBuffer.append("&title=" + Base64.encodeToString(i.i(str4), 2)); 
    if (!TextUtils.isEmpty(str5))
      stringBuffer.append("&description=" + Base64.encodeToString(i.i(str5), 2)); 
    if (!TextUtils.isEmpty(str2))
      stringBuffer.append("&share_id=" + str2); 
    if (!TextUtils.isEmpty(str6))
      stringBuffer.append("&url=" + Base64.encodeToString(i.i(str6), 2)); 
    if (!TextUtils.isEmpty(str10)) {
      str2 = str10;
      if (str10.length() > 20)
        str2 = str10.substring(0, 20) + "..."; 
      stringBuffer.append("&app_name=" + Base64.encodeToString(i.i(str2), 2));
    } 
    if (!TextUtils.isEmpty(str9))
      stringBuffer.append("&open_id=" + Base64.encodeToString(i.i(str9), 2)); 
    if (!TextUtils.isEmpty(str7))
      stringBuffer.append("&audioUrl=" + Base64.encodeToString(i.i(str7), 2)); 
    stringBuffer.append("&req_type=" + Base64.encodeToString(i.i(String.valueOf(i)), 2));
    if (!TextUtils.isEmpty(str8))
      stringBuffer.append("&share_qq_ext_str=" + Base64.encodeToString(i.i(str8), 2)); 
    stringBuffer.append("&cflag=" + Base64.encodeToString(i.i(String.valueOf(j)), 2));
    f.a("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
    a.a(d.a(), this.b, "requireApi", new String[] { "shareToNativeQQ" });
    Intent intent = new Intent("android.intent.action.VIEW");
    intent.setData(Uri.parse(stringBuffer.toString()));
    intent.putExtra("pkg_name", paramActivity.getPackageName());
    if (i.f((Context)paramActivity, "4.6.0")) {
      f.c("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
      if (a(intent)) {
        UIListenerManager.getInstance().setListenerWithRequestcode(11103, paramIUiListener);
        a(paramActivity, intent, 11103);
      } 
    } else {
      f.c("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
      if (UIListenerManager.getInstance().setListnerWithAction("shareToQQ", paramIUiListener) != null)
        f.c("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it."); 
      if (a(intent))
        a(paramActivity, 10103, intent, true); 
    } 
    String str1 = "10";
    if (j == 1)
      str1 = "11"; 
    if (a(intent)) {
      d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.SHARETOQQ.XX", str1, "3", "0", this.mViaShareQQType, "0", "1", "0");
      d.a().a(0, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
    } else {
      d.a().a(this.b.getOpenId(), this.b.getAppId(), "ANDROIDQQ.SHARETOQQ.XX", str1, "3", "1", this.mViaShareQQType, "0", "1", "0");
      d.a().a(1, "SHARE_CHECK_SDK", "1000", this.b.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
    } 
    f.c("openSDK_LOG.QQShare", "doShareToQQ() --end");
  }
  
  public void releaseResource() {}
  
  public void shareToQQ(Activity paramActivity, Bundle paramBundle, IUiListener paramIUiListener) {
    // Byte code:
    //   0: ldc 'openSDK_LOG.QQShare'
    //   2: ldc_w 'shareToQQ() -- start.'
    //   5: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_2
    //   9: ldc 'imageUrl'
    //   11: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   14: astore #4
    //   16: aload_2
    //   17: ldc 'title'
    //   19: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   22: astore #5
    //   24: aload_2
    //   25: ldc 'summary'
    //   27: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   30: astore #6
    //   32: aload_2
    //   33: ldc 'targetUrl'
    //   35: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   38: astore #7
    //   40: aload_2
    //   41: ldc 'imageLocalUrl'
    //   43: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   46: astore #8
    //   48: aload_2
    //   49: ldc 'req_type'
    //   51: iconst_1
    //   52: invokevirtual getInt : (Ljava/lang/String;I)I
    //   55: istore #9
    //   57: ldc 'openSDK_LOG.QQShare'
    //   59: new java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial <init> : ()V
    //   66: ldc_w 'shareToQQ -- type: '
    //   69: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload #9
    //   74: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   83: iload #9
    //   85: tableswitch default -> 124, 1 -> 202, 2 -> 212, 3 -> 124, 4 -> 124, 5 -> 222, 6 -> 232
    //   124: iload #9
    //   126: bipush #6
    //   128: if_icmpne -> 278
    //   131: aload_1
    //   132: ldc_w '5.0.0'
    //   135: invokestatic f : (Landroid/content/Context;Ljava/lang/String;)Z
    //   138: ifeq -> 242
    //   141: aload_3
    //   142: new com/tencent/tauth/UiError
    //   145: dup
    //   146: bipush #-15
    //   148: ldc_w '手Q版本过低，应用分享只支持手Q5.0及其以上版本'
    //   151: aconst_null
    //   152: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   155: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   160: ldc 'openSDK_LOG.QQShare'
    //   162: ldc_w 'shareToQQ, app share is not support below qq5.0.'
    //   165: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   168: invokestatic a : ()Lcom/tencent/open/b/d;
    //   171: iconst_1
    //   172: ldc 'SHARE_CHECK_SDK'
    //   174: ldc '1000'
    //   176: aload_0
    //   177: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   180: invokevirtual getAppId : ()Ljava/lang/String;
    //   183: iconst_0
    //   184: invokestatic valueOf : (I)Ljava/lang/String;
    //   187: invokestatic elapsedRealtime : ()J
    //   190: invokestatic valueOf : (J)Ljava/lang/Long;
    //   193: iconst_0
    //   194: iconst_1
    //   195: ldc_w 'shareToQQ, app share is not support below qq5.0.'
    //   198: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   201: return
    //   202: aload_0
    //   203: ldc_w '1'
    //   206: putfield mViaShareQQType : Ljava/lang/String;
    //   209: goto -> 124
    //   212: aload_0
    //   213: ldc_w '3'
    //   216: putfield mViaShareQQType : Ljava/lang/String;
    //   219: goto -> 124
    //   222: aload_0
    //   223: ldc_w '2'
    //   226: putfield mViaShareQQType : Ljava/lang/String;
    //   229: goto -> 124
    //   232: aload_0
    //   233: ldc_w '4'
    //   236: putfield mViaShareQQType : Ljava/lang/String;
    //   239: goto -> 124
    //   242: ldc_w 'http://fusion.qq.com/cgi-bin/qzapps/unified_jump?appid=%1$s&from=%2$s&isOpenAppID=1'
    //   245: iconst_2
    //   246: anewarray java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload_0
    //   252: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   255: invokevirtual getAppId : ()Ljava/lang/String;
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: ldc_w 'mqq'
    //   264: aastore
    //   265: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   268: astore #7
    //   270: aload_2
    //   271: ldc 'targetUrl'
    //   273: aload #7
    //   275: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   278: invokestatic b : ()Z
    //   281: ifne -> 356
    //   284: aload_1
    //   285: ldc_w '4.5.0'
    //   288: invokestatic f : (Landroid/content/Context;Ljava/lang/String;)Z
    //   291: ifeq -> 356
    //   294: aload_3
    //   295: new com/tencent/tauth/UiError
    //   298: dup
    //   299: bipush #-6
    //   301: ldc '分享图片失败，检测不到SD卡!'
    //   303: aconst_null
    //   304: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   307: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   312: ldc 'openSDK_LOG.QQShare'
    //   314: ldc_w 'shareToQQ sdcard is null--end'
    //   317: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   320: invokestatic a : ()Lcom/tencent/open/b/d;
    //   323: iconst_1
    //   324: ldc 'SHARE_CHECK_SDK'
    //   326: ldc '1000'
    //   328: aload_0
    //   329: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   332: invokevirtual getAppId : ()Ljava/lang/String;
    //   335: iconst_0
    //   336: invokestatic valueOf : (I)Ljava/lang/String;
    //   339: invokestatic elapsedRealtime : ()J
    //   342: invokestatic valueOf : (J)Ljava/lang/Long;
    //   345: iconst_0
    //   346: iconst_1
    //   347: ldc_w 'shareToQQ sdcard is null'
    //   350: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   353: goto -> 201
    //   356: iload #9
    //   358: iconst_5
    //   359: if_icmpne -> 505
    //   362: aload_1
    //   363: ldc '4.3.0'
    //   365: invokestatic f : (Landroid/content/Context;Ljava/lang/String;)Z
    //   368: ifeq -> 434
    //   371: aload_3
    //   372: new com/tencent/tauth/UiError
    //   375: dup
    //   376: bipush #-6
    //   378: ldc_w '低版本手Q不支持该项功能!'
    //   381: aconst_null
    //   382: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   385: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   390: ldc 'openSDK_LOG.QQShare'
    //   392: ldc_w 'shareToQQ, version below 4.3 is not support.'
    //   395: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   398: invokestatic a : ()Lcom/tencent/open/b/d;
    //   401: iconst_1
    //   402: ldc 'SHARE_CHECK_SDK'
    //   404: ldc '1000'
    //   406: aload_0
    //   407: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   410: invokevirtual getAppId : ()Ljava/lang/String;
    //   413: iconst_0
    //   414: invokestatic valueOf : (I)Ljava/lang/String;
    //   417: invokestatic elapsedRealtime : ()J
    //   420: invokestatic valueOf : (J)Ljava/lang/Long;
    //   423: iconst_0
    //   424: iconst_1
    //   425: ldc_w 'shareToQQ, version below 4.3 is not support.'
    //   428: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   431: goto -> 201
    //   434: aload #8
    //   436: invokestatic h : (Ljava/lang/String;)Z
    //   439: ifne -> 505
    //   442: aload_3
    //   443: new com/tencent/tauth/UiError
    //   446: dup
    //   447: bipush #-6
    //   449: ldc_w '非法的图片地址!'
    //   452: aconst_null
    //   453: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   456: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   461: ldc 'openSDK_LOG.QQShare'
    //   463: ldc_w 'shareToQQ -- error: 非法的图片地址!'
    //   466: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   469: invokestatic a : ()Lcom/tencent/open/b/d;
    //   472: iconst_1
    //   473: ldc 'SHARE_CHECK_SDK'
    //   475: ldc '1000'
    //   477: aload_0
    //   478: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   481: invokevirtual getAppId : ()Ljava/lang/String;
    //   484: iconst_0
    //   485: invokestatic valueOf : (I)Ljava/lang/String;
    //   488: invokestatic elapsedRealtime : ()J
    //   491: invokestatic valueOf : (J)Ljava/lang/Long;
    //   494: iconst_0
    //   495: iconst_1
    //   496: ldc_w '非法的图片地址!'
    //   499: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   502: goto -> 201
    //   505: iload #9
    //   507: iconst_5
    //   508: if_icmpeq -> 675
    //   511: aload #7
    //   513: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   516: ifne -> 541
    //   519: aload #7
    //   521: ldc_w 'http://'
    //   524: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   527: ifne -> 604
    //   530: aload #7
    //   532: ldc_w 'https://'
    //   535: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   538: ifne -> 604
    //   541: aload_3
    //   542: new com/tencent/tauth/UiError
    //   545: dup
    //   546: bipush #-6
    //   548: ldc_w '传入参数有误!'
    //   551: aconst_null
    //   552: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   555: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   560: ldc 'openSDK_LOG.QQShare'
    //   562: ldc_w 'shareToQQ, targetUrl is empty or illegal..'
    //   565: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   568: invokestatic a : ()Lcom/tencent/open/b/d;
    //   571: iconst_1
    //   572: ldc 'SHARE_CHECK_SDK'
    //   574: ldc '1000'
    //   576: aload_0
    //   577: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   580: invokevirtual getAppId : ()Ljava/lang/String;
    //   583: iconst_0
    //   584: invokestatic valueOf : (I)Ljava/lang/String;
    //   587: invokestatic elapsedRealtime : ()J
    //   590: invokestatic valueOf : (J)Ljava/lang/Long;
    //   593: iconst_0
    //   594: iconst_1
    //   595: ldc_w 'shareToQQ, targetUrl is empty or illegal..'
    //   598: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   601: goto -> 201
    //   604: aload #5
    //   606: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   609: ifeq -> 675
    //   612: aload_3
    //   613: new com/tencent/tauth/UiError
    //   616: dup
    //   617: bipush #-6
    //   619: ldc_w 'title不能为空!'
    //   622: aconst_null
    //   623: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   626: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   631: ldc 'openSDK_LOG.QQShare'
    //   633: ldc_w 'shareToQQ, title is empty.'
    //   636: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   639: invokestatic a : ()Lcom/tencent/open/b/d;
    //   642: iconst_1
    //   643: ldc 'SHARE_CHECK_SDK'
    //   645: ldc '1000'
    //   647: aload_0
    //   648: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   651: invokevirtual getAppId : ()Ljava/lang/String;
    //   654: iconst_0
    //   655: invokestatic valueOf : (I)Ljava/lang/String;
    //   658: invokestatic elapsedRealtime : ()J
    //   661: invokestatic valueOf : (J)Ljava/lang/Long;
    //   664: iconst_0
    //   665: iconst_1
    //   666: ldc_w 'shareToQQ, title is empty.'
    //   669: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   672: goto -> 201
    //   675: aload #4
    //   677: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   680: ifne -> 783
    //   683: aload #4
    //   685: ldc_w 'http://'
    //   688: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   691: ifne -> 783
    //   694: aload #4
    //   696: ldc_w 'https://'
    //   699: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   702: ifne -> 783
    //   705: new java/io/File
    //   708: dup
    //   709: aload #4
    //   711: invokespecial <init> : (Ljava/lang/String;)V
    //   714: invokevirtual exists : ()Z
    //   717: ifne -> 783
    //   720: aload_3
    //   721: new com/tencent/tauth/UiError
    //   724: dup
    //   725: bipush #-6
    //   727: ldc_w '非法的图片地址!'
    //   730: aconst_null
    //   731: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   734: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   739: ldc 'openSDK_LOG.QQShare'
    //   741: ldc_w 'shareToQQ, image url is emprty or illegal.'
    //   744: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   747: invokestatic a : ()Lcom/tencent/open/b/d;
    //   750: iconst_1
    //   751: ldc 'SHARE_CHECK_SDK'
    //   753: ldc '1000'
    //   755: aload_0
    //   756: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   759: invokevirtual getAppId : ()Ljava/lang/String;
    //   762: iconst_0
    //   763: invokestatic valueOf : (I)Ljava/lang/String;
    //   766: invokestatic elapsedRealtime : ()J
    //   769: invokestatic valueOf : (J)Ljava/lang/Long;
    //   772: iconst_0
    //   773: iconst_1
    //   774: ldc_w 'shareToQQ, image url is emprty or illegal.'
    //   777: invokevirtual a : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;IILjava/lang/String;)V
    //   780: goto -> 201
    //   783: aload #5
    //   785: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   788: ifne -> 818
    //   791: aload #5
    //   793: invokevirtual length : ()I
    //   796: sipush #128
    //   799: if_icmple -> 818
    //   802: aload_2
    //   803: ldc 'title'
    //   805: aload #5
    //   807: sipush #128
    //   810: aconst_null
    //   811: aconst_null
    //   812: invokestatic a : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   815: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   818: aload #6
    //   820: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   823: ifne -> 853
    //   826: aload #6
    //   828: invokevirtual length : ()I
    //   831: sipush #512
    //   834: if_icmple -> 853
    //   837: aload_2
    //   838: ldc 'summary'
    //   840: aload #6
    //   842: sipush #512
    //   845: aconst_null
    //   846: aconst_null
    //   847: invokestatic a : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   850: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   853: aload_2
    //   854: ldc 'cflag'
    //   856: iconst_0
    //   857: invokevirtual getInt : (Ljava/lang/String;I)I
    //   860: iconst_1
    //   861: if_icmpne -> 902
    //   864: iconst_1
    //   865: istore #10
    //   867: aload_1
    //   868: iload #10
    //   870: invokestatic a : (Landroid/content/Context;Z)Z
    //   873: ifeq -> 908
    //   876: ldc 'openSDK_LOG.QQShare'
    //   878: ldc_w 'shareToQQ, support share'
    //   881: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   884: aload_0
    //   885: aload_1
    //   886: aload_2
    //   887: aload_3
    //   888: invokespecial b : (Landroid/app/Activity;Landroid/os/Bundle;Lcom/tencent/tauth/IUiListener;)V
    //   891: ldc 'openSDK_LOG.QQShare'
    //   893: ldc_w 'shareToQQ() -- end.'
    //   896: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)V
    //   899: goto -> 201
    //   902: iconst_0
    //   903: istore #10
    //   905: goto -> 867
    //   908: ldc 'openSDK_LOG.QQShare'
    //   910: ldc_w 'shareToQQ, don't support share, will show download dialog'
    //   913: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)V
    //   916: new com/tencent/open/TDialog
    //   919: astore_2
    //   920: aload_2
    //   921: aload_1
    //   922: ldc ''
    //   924: aload_0
    //   925: ldc ''
    //   927: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   930: aconst_null
    //   931: aload_0
    //   932: getfield b : Lcom/tencent/connect/auth/QQToken;
    //   935: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/tauth/IUiListener;Lcom/tencent/connect/auth/QQToken;)V
    //   938: aload_2
    //   939: invokevirtual show : ()V
    //   942: goto -> 891
    //   945: astore_1
    //   946: ldc 'openSDK_LOG.QQShare'
    //   948: ldc_w ' shareToQQ, TDialog.show not in main thread'
    //   951: aload_1
    //   952: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   955: aload_1
    //   956: invokevirtual printStackTrace : ()V
    //   959: aload_3
    //   960: new com/tencent/tauth/UiError
    //   963: dup
    //   964: bipush #-6
    //   966: ldc_w '没有在主线程调用！'
    //   969: aconst_null
    //   970: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;)V
    //   973: invokeinterface onError : (Lcom/tencent/tauth/UiError;)V
    //   978: goto -> 891
    // Exception table:
    //   from	to	target	type
    //   908	942	945	java/lang/RuntimeException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\connect\share\QQShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */