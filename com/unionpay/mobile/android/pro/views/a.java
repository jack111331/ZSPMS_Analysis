package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import android.content.ServiceConnection;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.hce.b;
import com.unionpay.mobile.android.hce.c;
import com.unionpay.mobile.android.hce.service.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.model.f;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.b;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.uppay.PayActivity;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b implements Handler.Callback, a.b {
  private static Date M = new Date(System.currentTimeMillis());
  
  private static String N = (new SimpleDateFormat("yyyyMMddhhmmss")).format(M);
  
  private static HashMap<String, String> P = new HashMap<String, String>();
  
  private static HashMap<String, String> Q = new HashMap<String, String>();
  
  private ay A;
  
  private String B;
  
  private c C;
  
  private int D = 5;
  
  private String E;
  
  private boolean F = false;
  
  private Handler.Callback G = new b(this);
  
  private Handler H = new Handler(this.G);
  
  private View.OnClickListener I = new c(this);
  
  private View.OnClickListener J = new d(this);
  
  private View.OnClickListener K = new e(this);
  
  private View.OnClickListener L = new f(this);
  
  private String O = null;
  
  public String r = "1.9";
  
  UPPayEngine s;
  
  private int t = 20;
  
  private int u = 100;
  
  private TextView v = null;
  
  private boolean w = false;
  
  private a x = null;
  
  private a y = null;
  
  private Handler z = null;
  
  public a(Context paramContext, e parame, UPPayEngine paramUPPayEngine) {
    super(paramContext, parame);
    this.s = paramUPPayEngine;
    this.z = new Handler(this);
    this.C = b.bb.get(this.a.bc);
    this.w = this.a.K;
    setBackgroundColor(-1052684);
    e();
  }
  
  private void a(LinearLayout paramLinearLayout) {
    z z = null;
    if (this.y != null)
      z = this.y.c("instalment"); 
    int i = this.a.z.length();
    JSONArray jSONArray = new JSONArray();
    for (byte b1 = 0; b1 < i; b1++) {
      Object object = j.b(this.a.z, b1);
      if (object != null)
        try {
          JSONObject jSONObject = (JSONObject)object;
          if ("pan".equals(j.a(jSONObject, "type"))) {
            object = new StringBuilder();
            super();
            jSONObject.put("label", object.append(this.C.b()).append(this.C.c()).toString());
          } 
          jSONArray.put(jSONObject);
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        }  
    } 
    this.x = new a(this.d, jSONArray, this.e.c(), this, this.C.a(), true, false, z, this.a.ad, this.q);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramLinearLayout.addView((View)this.x, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private static void a(StringBuffer paramStringBuffer) {
    for (String str1 : P.keySet()) {
      String str2 = P.get(str1);
      if (!TextUtils.isEmpty(str2)) {
        byte[] arrayOfByte = new byte[1];
        arrayOfByte[0] = (byte)(byte)(str2.length() / 2);
        String str = e.a(arrayOfByte, arrayOfByte.length);
        paramStringBuffer.append(str1);
        paramStringBuffer.append(str);
        paramStringBuffer.append(str2);
      } 
    } 
  }
  
  private Bundle b(String paramString, HashMap<String, String> paramHashMap) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic w : ()Landroid/os/Bundle;
    //   5: astore_3
    //   6: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   9: ldc_w 'PIN'
    //   12: aload_1
    //   13: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   16: pop
    //   17: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   20: ldc_w 'AN1'
    //   23: aload_0
    //   24: getfield C : Lcom/unionpay/mobile/android/hce/c;
    //   27: invokevirtual a : ()Ljava/lang/String;
    //   30: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   33: pop
    //   34: new java/lang/StringBuffer
    //   37: astore_1
    //   38: aload_1
    //   39: invokespecial <init> : ()V
    //   42: aload_1
    //   43: invokestatic a : (Ljava/lang/StringBuffer;)V
    //   46: aload_1
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: astore_1
    //   51: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   54: ldc_w 'DCD'
    //   57: aload_1
    //   58: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_0
    //   63: aload_0
    //   64: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   67: getfield bf : Ljava/lang/String;
    //   70: aload_0
    //   71: getfield s : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   74: invokevirtual b : ()Ljava/lang/String;
    //   77: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: putfield B : Ljava/lang/String;
    //   83: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   86: ldc_w '5F34'
    //   89: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   92: ifnull -> 227
    //   95: new java/lang/StringBuffer
    //   98: astore_1
    //   99: aload_1
    //   100: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   103: ldc_w '5F34'
    //   106: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast java/lang/String
    //   112: invokespecial <init> : (Ljava/lang/String;)V
    //   115: aload_1
    //   116: iconst_0
    //   117: ldc_w '0'
    //   120: invokevirtual insert : (ILjava/lang/String;)Ljava/lang/StringBuffer;
    //   123: pop
    //   124: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   127: ldc_w '5F34'
    //   130: aload_1
    //   131: invokevirtual toString : ()Ljava/lang/String;
    //   134: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   141: ldc_w '57'
    //   144: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   147: ifnull -> 357
    //   150: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   153: ldc_w '57'
    //   156: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   159: checkcast java/lang/String
    //   162: invokevirtual toUpperCase : ()Ljava/lang/String;
    //   165: astore_1
    //   166: aload_1
    //   167: aload_1
    //   168: invokevirtual length : ()I
    //   171: iconst_1
    //   172: isub
    //   173: aload_1
    //   174: invokevirtual length : ()I
    //   177: invokevirtual substring : (II)Ljava/lang/String;
    //   180: ldc_w 'f'
    //   183: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   186: ifne -> 212
    //   189: aload_1
    //   190: aload_1
    //   191: invokevirtual length : ()I
    //   194: iconst_1
    //   195: isub
    //   196: aload_1
    //   197: invokevirtual length : ()I
    //   200: invokevirtual substring : (II)Ljava/lang/String;
    //   203: ldc_w 'F'
    //   206: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   209: ifeq -> 248
    //   212: aload_1
    //   213: iconst_0
    //   214: aload_1
    //   215: invokevirtual length : ()I
    //   218: iconst_1
    //   219: isub
    //   220: invokevirtual substring : (II)Ljava/lang/String;
    //   223: astore_1
    //   224: goto -> 166
    //   227: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   230: ldc_w '5F34'
    //   233: ldc_w ''
    //   236: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   239: pop
    //   240: goto -> 138
    //   243: astore_1
    //   244: aload_0
    //   245: monitorexit
    //   246: aload_1
    //   247: athrow
    //   248: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   251: ldc_w 'TD2'
    //   254: aload_1
    //   255: invokevirtual toString : ()Ljava/lang/String;
    //   258: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: aload_1
    //   263: ldc_w 'D'
    //   266: invokevirtual indexOf : (Ljava/lang/String;)I
    //   269: istore #4
    //   271: aload_1
    //   272: iconst_0
    //   273: iload #4
    //   275: invokevirtual substring : (II)Ljava/lang/String;
    //   278: astore #5
    //   280: aload #5
    //   282: ldc_w 'F'
    //   285: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   288: ifne -> 306
    //   291: aload #5
    //   293: astore #6
    //   295: aload #5
    //   297: ldc_w 'f'
    //   300: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   303: ifeq -> 321
    //   306: aload #5
    //   308: iconst_0
    //   309: aload #5
    //   311: invokevirtual length : ()I
    //   314: iconst_1
    //   315: isub
    //   316: invokevirtual substring : (II)Ljava/lang/String;
    //   319: astore #6
    //   321: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   324: ldc_w 'AN1'
    //   327: aload #6
    //   329: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   332: pop
    //   333: aload_1
    //   334: iload #4
    //   336: iconst_1
    //   337: iadd
    //   338: iload #4
    //   340: iconst_5
    //   341: iadd
    //   342: invokevirtual substring : (II)Ljava/lang/String;
    //   345: astore_1
    //   346: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   349: ldc_w 'ED'
    //   352: aload_1
    //   353: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   356: pop
    //   357: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   360: ldc_w 'AMT'
    //   363: getstatic com/unionpay/mobile/android/pro/views/a.P : Ljava/util/HashMap;
    //   366: ldc_w '9F02'
    //   369: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   372: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   375: pop
    //   376: new java/lang/StringBuilder
    //   379: astore_1
    //   380: aload_1
    //   381: invokespecial <init> : ()V
    //   384: aload_1
    //   385: ldc_w ''
    //   388: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: ldc_w 'pan='
    //   394: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   400: ldc_w 'AN1'
    //   403: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   406: checkcast java/lang/String
    //   409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: invokevirtual toString : ()Ljava/lang/String;
    //   415: astore #6
    //   417: new java/lang/StringBuilder
    //   420: astore_1
    //   421: aload_1
    //   422: invokespecial <init> : ()V
    //   425: aload_1
    //   426: aload #6
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc_w '&pin='
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   440: ldc_w 'PIN'
    //   443: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   446: checkcast java/lang/String
    //   449: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual toString : ()Ljava/lang/String;
    //   455: astore #6
    //   457: new java/lang/StringBuilder
    //   460: astore_1
    //   461: aload_1
    //   462: invokespecial <init> : ()V
    //   465: aload_1
    //   466: aload #6
    //   468: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: ldc_w '&icc_data='
    //   474: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   480: ldc_w 'DCD'
    //   483: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   486: checkcast java/lang/String
    //   489: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: invokevirtual toString : ()Ljava/lang/String;
    //   495: astore #6
    //   497: new java/lang/StringBuilder
    //   500: astore_1
    //   501: aload_1
    //   502: invokespecial <init> : ()V
    //   505: aload_1
    //   506: aload #6
    //   508: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: ldc_w '&card_seq_id='
    //   514: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   520: ldc_w '5F34'
    //   523: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   526: checkcast java/lang/String
    //   529: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: invokevirtual toString : ()Ljava/lang/String;
    //   535: astore #6
    //   537: new java/lang/StringBuilder
    //   540: astore_1
    //   541: aload_1
    //   542: invokespecial <init> : ()V
    //   545: aload_1
    //   546: aload #6
    //   548: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: ldc_w '&auth_id='
    //   554: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: aload_0
    //   558: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   561: getfield bg : Ljava/lang/String;
    //   564: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual toString : ()Ljava/lang/String;
    //   570: astore #6
    //   572: ldc_w 'mac'
    //   575: aload #6
    //   577: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   580: pop
    //   581: aload #6
    //   583: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
    //   586: astore_1
    //   587: ldc_w 'md5'
    //   590: aload_1
    //   591: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   594: pop
    //   595: aload_0
    //   596: getfield e : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   599: aload_1
    //   600: invokevirtual h : (Ljava/lang/String;)Ljava/lang/String;
    //   603: astore_1
    //   604: ldc_w 'sig'
    //   607: aload_1
    //   608: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   611: pop
    //   612: new java/lang/StringBuilder
    //   615: astore #5
    //   617: aload #5
    //   619: invokespecial <init> : ()V
    //   622: aload #5
    //   624: aload #6
    //   626: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: ldc_w '&'
    //   632: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: aload_1
    //   636: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: invokevirtual toString : ()Ljava/lang/String;
    //   642: astore #6
    //   644: aload_0
    //   645: getfield e : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   648: aload #6
    //   650: aload_0
    //   651: getfield B : Ljava/lang/String;
    //   654: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   657: astore #7
    //   659: new org/json/JSONObject
    //   662: astore #6
    //   664: aload #6
    //   666: invokespecial <init> : ()V
    //   669: aload #6
    //   671: ldc_w 'v'
    //   674: aload_0
    //   675: getfield r : Ljava/lang/String;
    //   678: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   681: pop
    //   682: aload #6
    //   684: ldc_w 'cmd'
    //   687: ldc_w 'pay'
    //   690: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   693: pop
    //   694: new org/json/JSONObject
    //   697: astore #5
    //   699: aload #5
    //   701: invokespecial <init> : ()V
    //   704: aload #6
    //   706: ldc_w 'params'
    //   709: aload #5
    //   711: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   714: pop
    //   715: aload #5
    //   717: ldc_w 'encrypt_key_field'
    //   720: aload #7
    //   722: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   725: pop
    //   726: aload #5
    //   728: ldc_w 'pay_type'
    //   731: ldc_w '2'
    //   734: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   737: pop
    //   738: aload #5
    //   740: ldc_w 'pay_mode'
    //   743: ldc_w '1'
    //   746: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   749: pop
    //   750: aload #5
    //   752: ldc_w 'bind'
    //   755: ldc_w 'no'
    //   758: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   761: pop
    //   762: aload #5
    //   764: ldc_w 'carrier_tp'
    //   767: ldc_w '9'
    //   770: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   773: pop
    //   774: aload #5
    //   776: ldc_w 'carrier_app_tp'
    //   779: ldc_w '0'
    //   782: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   785: pop
    //   786: aload #5
    //   788: ldc_w 'sign'
    //   791: aload_1
    //   792: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   795: pop
    //   796: aload #5
    //   798: ldc 'pan'
    //   800: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   803: ldc_w 'AN1'
    //   806: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   809: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   812: pop
    //   813: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   816: ldc_w 'ED'
    //   819: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   822: ifnull -> 843
    //   825: aload #5
    //   827: ldc_w 'expire'
    //   830: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   833: ldc_w 'ED'
    //   836: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   839: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   842: pop
    //   843: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   846: ldc_w 'TD2'
    //   849: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   852: ifnull -> 873
    //   855: aload #5
    //   857: ldc_w 'track2_data'
    //   860: getstatic com/unionpay/mobile/android/pro/views/a.Q : Ljava/util/HashMap;
    //   863: ldc_w 'TD2'
    //   866: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   869: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   872: pop
    //   873: aload_2
    //   874: ifnull -> 973
    //   877: aload_2
    //   878: invokevirtual keySet : ()Ljava/util/Set;
    //   881: ifnull -> 973
    //   884: aload_2
    //   885: invokevirtual keySet : ()Ljava/util/Set;
    //   888: invokeinterface size : ()I
    //   893: ifle -> 973
    //   896: aload_2
    //   897: ldc 'pan'
    //   899: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   902: pop
    //   903: aload_2
    //   904: ldc_w 'pin'
    //   907: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   910: pop
    //   911: aload_2
    //   912: invokevirtual keySet : ()Ljava/util/Set;
    //   915: invokeinterface iterator : ()Ljava/util/Iterator;
    //   920: astore_1
    //   921: aload_1
    //   922: invokeinterface hasNext : ()Z
    //   927: ifeq -> 973
    //   930: aload_1
    //   931: invokeinterface next : ()Ljava/lang/Object;
    //   936: checkcast java/lang/String
    //   939: astore #7
    //   941: aload #5
    //   943: aload #7
    //   945: aload_2
    //   946: aload #7
    //   948: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   951: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   954: pop
    //   955: goto -> 921
    //   958: astore_1
    //   959: aload_3
    //   960: ldc_w 'action_resp_code'
    //   963: ldc_w '10019'
    //   966: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   969: aload_0
    //   970: monitorexit
    //   971: aload_3
    //   972: areturn
    //   973: aload #6
    //   975: invokevirtual toString : ()Ljava/lang/String;
    //   978: astore_1
    //   979: aload_3
    //   980: ldc_w 'action_resp_message'
    //   983: aload_0
    //   984: getfield s : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   987: aload_1
    //   988: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   991: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   994: goto -> 969
    // Exception table:
    //   from	to	target	type
    //   2	138	243	finally
    //   138	166	243	finally
    //   166	212	243	finally
    //   212	224	243	finally
    //   227	240	243	finally
    //   248	291	243	finally
    //   295	306	243	finally
    //   306	321	243	finally
    //   321	357	243	finally
    //   357	659	243	finally
    //   659	843	958	org/json/JSONException
    //   659	843	243	finally
    //   843	873	958	org/json/JSONException
    //   843	873	243	finally
    //   877	921	958	org/json/JSONException
    //   877	921	243	finally
    //   921	955	958	org/json/JSONException
    //   921	955	243	finally
    //   959	969	243	finally
    //   973	979	958	org/json/JSONException
    //   973	979	243	finally
    //   979	994	243	finally
  }
  
  private boolean b(HashMap<String, String> paramHashMap) {
    String str3 = N.substring(2, 8);
    long l = (new Date(System.currentTimeMillis())).getTime();
    String str4 = String.valueOf(l);
    if (str4.length() < 8) {
      str4 = String.format("%08d", new Object[] { Long.valueOf(l) });
    } else {
      str4 = str4.substring(str4.length() - 8, str4.length());
    } 
    P.put("9F26", "");
    P.put("9F27", "80");
    P.put("9F10", "");
    P.put("9F37", str4);
    P.put("9F36", "");
    P.put("95", "0000000800");
    P.put("9A", str3);
    P.put("9C", "45");
    P.put("9F02", "000000000000");
    P.put("5F2A", "0156");
    P.put("82", "");
    P.put("9F1A", "0156");
    P.put("9F03", "000000000000");
    P.put("9F33", "A04000");
    P.put("9F34", "420300");
    P.put("9F35", "34");
    P.put("9F1E", "3030303030303030");
    P.put("84", "");
    P.put("9F09", "0001");
    P.put("9F41", "");
    P.put("91", "");
    P.put("71", "");
    P.put("72", "");
    P.put("DF31", "");
    P.put("9F74", "");
    P.put("9F63", "");
    P.put("8A", "");
    Q.put("9F66", "26C00000");
    w();
    P.put("9F02", paramHashMap.get("trans_amt"));
    P.put("9F1A", "0156");
    P.put("5F2A", paramHashMap.get("trans currcy code"));
    P.put("9C", paramHashMap.get("trans_type"));
    Q.put("CUR", P.get("5F2A"));
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("9F66", Q.get("9F66"));
      jSONObject.put("9F02", P.get("9F02"));
      jSONObject.put("9F03", P.get("9F03"));
      jSONObject.put("9F1A", P.get("9F1A"));
      jSONObject.put("95", P.get("95"));
      jSONObject.put("5F2A", P.get("5F2A"));
      jSONObject.put("9A", P.get("9A"));
      jSONObject.put("9C", P.get("9C"));
      jSONObject.put("9F37", P.get("9F37"));
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    String str5 = this.C.f();
    com.unionpay.mobile.android.hce.service.a a1 = this.C.g();
    String str1 = com.unionpay.mobile.android.hce.a.b(this.C.a(), str5);
    String str2 = com.unionpay.mobile.android.hce.a.b(jSONObject.toString(), str5);
    try {
      b b1 = new b();
      this(2004, "", this.H);
      a1.a(str1, str2, "", (b)b1);
      Message message = this.H.obtainMessage(2006);
      this.H.sendMessageDelayed(message, this.a.be);
      boolean bool = true;
    } catch (RemoteException remoteException) {
      remoteException.printStackTrace();
      a(this.a.ap, false);
      boolean bool = false;
    } 
  }
  
  private static final String d(String paramString) {
    try {
      byte[] arrayOfByte = paramString.getBytes();
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(arrayOfByte);
      String str = e.a(messageDigest.digest());
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String)exception;
  }
  
  private static String d(String paramString1, String paramString2) {
    byte[] arrayOfByte1 = e.a(paramString1);
    byte[] arrayOfByte2 = e.a(paramString2);
    for (byte b1 = 0; b1 < arrayOfByte1.length; b1++)
      arrayOfByte1[b1] = (byte)(byte)(arrayOfByte1[b1] ^ arrayOfByte2[b1]); 
    return e.a(arrayOfByte1);
  }
  
  private void e(String paramString1, String paramString2) {
    this.u = 9;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    } else {
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    } 
    this.D--;
  }
  
  private void v() {
    this.u = 103;
    int i = this.t;
    this.e.a("query", this.a.aj, 3);
    this.t--;
  }
  
  private static Bundle w() {
    Bundle bundle = new Bundle();
    bundle.putString("action_resp_code", "0000");
    return bundle;
  }
  
  public final Bundle a(String paramString, HashMap<String, String> paramHashMap) {
    return b(paramString, paramHashMap);
  }
  
  public final void a(a.a parama) {}
  
  public final void a(JSONObject paramJSONObject) {
    a.a a1;
    String str2;
    Iterator<c> iterator;
    JSONArray jSONArray1;
    String str4;
    String str5;
    switch (this.u) {
      default:
        return;
      case 104:
        try {
          this.a.bf = (String)paramJSONObject.get("encrypt_key");
          this.a.bg = (String)paramJSONObject.get("auth_id");
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        if (this.a.p != null) {
          a1 = this.x.a();
          if (!a1.a()) {
            this.F = true;
            a(a1.b);
          } 
          this.u = 101;
          a(this.a.p);
        } 
      case 101:
        this.a.aj = i.a(a1.toString());
        str2 = j.a((JSONObject)a1, "qn");
        if (!TextUtils.isEmpty(str2))
          this.a.n = this.e.i(c.b(str2)); 
        if (this.a.aj == null || this.a.aj.length() <= 0)
          b(2); 
        this.t = 20;
        v();
      case 103:
        str4 = j.a((JSONObject)str2, "status");
        str5 = j.a((JSONObject)str2, "fail_msg");
        if (this.t > 0 && str4.equalsIgnoreCase("01"))
          v(); 
        this.u = 100;
        if (str4.equalsIgnoreCase("00")) {
          j();
          this.u = 100;
          this.a.H = j.d((JSONObject)str2, "result");
          this.a.P = j.a((JSONObject)str2, "openupgrade_flag");
          this.a.Q = j.a((JSONObject)str2, "temporary_pay_flag");
          this.a.R = j.a((JSONObject)str2, "temporary_pay_info");
          this.a.V = j.a((JSONObject)str2, "front_url");
          this.a.W = j.a((JSONObject)str2, "front_request");
          this.a.A = j.a((JSONObject)str2, "title");
          this.a.B = j.a((JSONObject)str2, "succ_info");
          b.b((JSONObject)str2, this.a);
          b.a((JSONObject)str2, this.a);
          if (this.x != null)
            this.x.f(); 
          a(this.d, this.q + "_succeed");
          iterator = b.bb.iterator();
          while (iterator.hasNext()) {
            ServiceConnection serviceConnection = ((c)iterator.next()).h();
            try {
              this.d.unbindService(serviceConnection);
            } catch (IllegalArgumentException illegalArgumentException) {}
          } 
          if (this.a.f) {
            this.a.I.f = "success";
            k();
          } 
          d(8);
        } 
        j();
        this.F = true;
        if (illegalArgumentException.equalsIgnoreCase("03")) {
          a(this.d, this.q + "_fail", p.j, (Object[])new String[] { (String)illegalArgumentException, str5 });
          a(str5);
        } 
        if (this.t <= 0)
          b(19); 
      case 8:
        j();
        jSONArray1 = j.d((JSONObject)iterator, "options");
        if (this.y != null)
          this.y.a(jSONArray1); 
      case 9:
        break;
    } 
    String str3 = j.a((JSONObject)jSONArray1, "status");
    if (str3 != null && "01".equals(str3)) {
      str1 = j.a((JSONObject)jSONArray1, "uuid");
      if (this.D >= 0)
        e(this.E, str1); 
      str1 = c.bD.D;
      if (this.y != null)
        this.y.a(null, str1); 
    } 
    JSONArray jSONArray2 = j.d((JSONObject)str1, "options");
    String str1 = j.a((JSONObject)str1, "empty_info");
    if (this.y != null)
      this.y.a(jSONArray2, str1); 
  }
  
  public final void a(boolean paramBoolean) {
    if (this.v != null) {
      TextView textView = this.v;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      textView.setEnabled(paramBoolean);
    } 
  }
  
  public final boolean a(HashMap<String, String> paramHashMap) {
    M = new Date(System.currentTimeMillis());
    N = (new SimpleDateFormat("yyyyMMddHHmmss")).format(M);
    this.O = new String(N);
    return b(paramHashMap);
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.A = new ay(getContext(), c.bD.bq, (ay.a)this);
    layoutParams.addRule(13, -1);
    this.k.addView((View)this.A, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final void b(int paramInt) {
    switch (this.u) {
      default:
        super.b(paramInt);
        return;
      case 101:
      case 103:
      case 104:
        break;
    } 
    this.F = true;
  }
  
  protected final void c() {
    boolean bool;
    this.m.removeAllViews();
    this.o.a((UPScrollView.a)this);
    LinearLayout linearLayout = new LinearLayout(this.d);
    linearLayout.setOrientation(1);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams1.topMargin = com.unionpay.mobile.android.global.a.f;
    layoutParams1.addRule(10, -1);
    this.m.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams1);
    JSONArray jSONArray = new JSONArray();
    if (this.p != null) {
      f f = (f)this.p;
      jSONArray.put(f.a("promotion"));
      jSONArray.put(f.a("instalment"));
      this.a.aU = f.a("promotion_instalment_msgbox");
    } 
    if (jSONArray.length() > 0) {
      this.y = new a(this.d, jSONArray, this, this.q);
      this.y.a(this.I);
      this.y.b(this.J);
      this.y.c(this.K);
      this.y.a(this.b, this.a.aU);
      LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
      layoutParams2.bottomMargin = com.unionpay.mobile.android.global.a.f;
      linearLayout.addView((View)this.y, (ViewGroup.LayoutParams)layoutParams2);
    } 
    a(linearLayout);
    new LinearLayout.LayoutParams(-1, -2);
    this.v = new TextView(this.d);
    this.v.setText(j.a(this.a.C, "label"));
    this.v.setTextSize(b.i);
    this.v.setTextColor(p());
    this.v.setGravity(17);
    TextView textView = this.v;
    if (this.x == null || this.x.e()) {
      bool = true;
    } else {
      bool = false;
    } 
    textView.setEnabled(bool);
    int i = com.unionpay.mobile.android.global.a.n;
    Drawable drawable = this.c.a(2008);
    this.v.setBackgroundDrawable(drawable);
    this.v.setOnClickListener(this.L);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i);
    layoutParams.topMargin = com.unionpay.mobile.android.global.a.f;
    i = g.a(this.d, 10.0F);
    layoutParams.rightMargin = i;
    layoutParams.leftMargin = i;
    linearLayout.addView((View)this.v, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final boolean handleMessage(Message paramMessage) {
    if (paramMessage.obj != null) {
      Bundle bundle = (Bundle)paramMessage.obj;
      String str1 = bundle.getString("action_resp_code");
      String str2 = bundle.getString("action_resp_message");
      if ("0000".equalsIgnoreCase(str1)) {
        if (str2 != null)
          a(0, str2); 
        return true;
      } 
    } else {
      return true;
    } 
    a(this.a.ap, false);
    return true;
  }
  
  public final void l() {
    if (this.x == null || !this.x.d()) {
      if (this.a.K && this.w) {
        this.a.K = false;
        n();
        return;
      } 
      this.a.K = false;
      a(2);
    } 
  }
  
  protected final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.x != null)
      this.x.d(); 
    this.b = null;
  }
  
  public final void u() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */