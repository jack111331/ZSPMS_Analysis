package com.unionpay.mobile.android.pro.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.views.b;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.pboctransaction.nfc.a;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.upwidget.UPRadiationView;
import com.unionpay.mobile.android.upwidget.a;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.uppay.PayActivity;
import java.security.MessageDigest;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONObject;

public final class k extends b implements Handler.Callback, a.b {
  private static Date ab = new Date(System.currentTimeMillis());
  
  private static String ac = (new SimpleDateFormat("yyyyMMddhhmmss")).format(ab);
  
  private LinearLayout A = null;
  
  private LinearLayout B = null;
  
  private RelativeLayout C = null;
  
  private LinearLayout D = null;
  
  private LinearLayout E = null;
  
  private ay F;
  
  private UPRadiationView G;
  
  private ImageView H;
  
  private String I;
  
  private String J;
  
  private a K = null;
  
  private a L = null;
  
  private boolean M = true;
  
  private boolean N = false;
  
  private a O = null;
  
  private String P;
  
  private int Q = 5;
  
  private NfcAdapter R;
  
  private FrameLayout S;
  
  private View.OnClickListener T = new l(this);
  
  private View.OnClickListener U = new n(this);
  
  private View.OnClickListener V = new o(this);
  
  private View.OnClickListener W = new p(this);
  
  private View.OnClickListener Z = new q(this);
  
  private View.OnClickListener aa = new r(this);
  
  private String ad = null;
  
  private HashMap<String, String> ae = new HashMap<String, String>();
  
  public String r = "1.8";
  
  UPPayEngine s;
  
  a t;
  
  private int u = 20;
  
  private int v = 100;
  
  private TextView w = null;
  
  private boolean x = false;
  
  private a y = null;
  
  private Handler z = null;
  
  public k(Context paramContext, e parame, UPPayEngine paramUPPayEngine) {
    super(paramContext, parame);
    this.s = paramUPPayEngine;
    this.z = new Handler(this);
    this.x = this.a.K;
    setBackgroundColor(-11495169);
    e();
  }
  
  private void a(String paramString, StringBuffer paramStringBuffer) {
    String str1 = this.ae.get(paramString);
    byte[] arrayOfByte = new byte[1];
    arrayOfByte[0] = (byte)(byte)(str1.length() / 2);
    String str2 = e.a(arrayOfByte, arrayOfByte.length);
    paramStringBuffer.append(paramString);
    paramStringBuffer.append(str2);
    paramStringBuffer.append(str1);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap) {
    Object object = ((PayActivity)this.d).a(b.class.toString());
    if (object != null) {
      object = object;
    } else {
      object = null;
    } 
    if (object == null) {
      b(5);
      return;
    } 
    (new Thread(new s(this, paramString, paramHashMap))).start();
  }
  
  private Bundle c(String paramString, HashMap<String, String> paramHashMap) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic x : ()Landroid/os/Bundle;
    //   5: astore_3
    //   6: aload_0
    //   7: getfield ae : Ljava/util/HashMap;
    //   10: ldc_w 'PIN'
    //   13: aload_1
    //   14: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   17: pop
    //   18: new java/lang/StringBuffer
    //   21: astore_1
    //   22: aload_1
    //   23: invokespecial <init> : ()V
    //   26: aload_0
    //   27: ldc_w '9F26'
    //   30: aload_1
    //   31: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   34: aload_0
    //   35: ldc_w '9F27'
    //   38: aload_1
    //   39: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   42: aload_0
    //   43: ldc_w '9F10'
    //   46: aload_1
    //   47: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   50: aload_0
    //   51: ldc_w '9F37'
    //   54: aload_1
    //   55: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   58: aload_0
    //   59: ldc_w '9F36'
    //   62: aload_1
    //   63: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   66: aload_0
    //   67: ldc_w '95'
    //   70: aload_1
    //   71: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   74: aload_0
    //   75: ldc_w '9A'
    //   78: aload_1
    //   79: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   82: aload_0
    //   83: ldc_w '9C'
    //   86: aload_1
    //   87: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   90: aload_0
    //   91: ldc_w '9F02'
    //   94: aload_1
    //   95: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   98: aload_0
    //   99: ldc_w '5F2A'
    //   102: aload_1
    //   103: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   106: aload_0
    //   107: ldc_w '82'
    //   110: aload_1
    //   111: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   114: aload_0
    //   115: ldc_w '9F1A'
    //   118: aload_1
    //   119: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   122: aload_0
    //   123: ldc_w '9F03'
    //   126: aload_1
    //   127: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   130: aload_0
    //   131: ldc_w '9F33'
    //   134: aload_1
    //   135: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   138: aload_0
    //   139: ldc_w '9F34'
    //   142: aload_1
    //   143: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   146: aload_0
    //   147: ldc_w '9F35'
    //   150: aload_1
    //   151: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   154: aload_0
    //   155: ldc_w '9F1E'
    //   158: aload_1
    //   159: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   162: aload_0
    //   163: getfield ae : Ljava/util/HashMap;
    //   166: ldc_w '9F63'
    //   169: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   172: ifnull -> 202
    //   175: aload_0
    //   176: getfield ae : Ljava/util/HashMap;
    //   179: ldc_w '9F63'
    //   182: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   185: checkcast java/lang/CharSequence
    //   188: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   191: ifne -> 202
    //   194: aload_0
    //   195: ldc_w '9F63'
    //   198: aload_1
    //   199: invokespecial a : (Ljava/lang/String;Ljava/lang/StringBuffer;)V
    //   202: aload_1
    //   203: invokevirtual toString : ()Ljava/lang/String;
    //   206: astore_1
    //   207: aload_0
    //   208: getfield ae : Ljava/util/HashMap;
    //   211: ldc_w 'DCD'
    //   214: aload_1
    //   215: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   218: pop
    //   219: aload_0
    //   220: aload_0
    //   221: getfield I : Ljava/lang/String;
    //   224: aload_0
    //   225: getfield s : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   228: invokevirtual b : ()Ljava/lang/String;
    //   231: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   234: putfield I : Ljava/lang/String;
    //   237: new java/lang/StringBuilder
    //   240: astore_1
    //   241: aload_1
    //   242: invokespecial <init> : ()V
    //   245: aload_1
    //   246: ldc_w ''
    //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc_w 'pan='
    //   255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: getfield ae : Ljava/util/HashMap;
    //   262: ldc_w 'AN1'
    //   265: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   268: checkcast java/lang/String
    //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual toString : ()Ljava/lang/String;
    //   277: astore #4
    //   279: new java/lang/StringBuilder
    //   282: astore_1
    //   283: aload_1
    //   284: invokespecial <init> : ()V
    //   287: aload_1
    //   288: aload #4
    //   290: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc_w '&pin='
    //   296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: getfield ae : Ljava/util/HashMap;
    //   303: ldc_w 'PIN'
    //   306: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   309: checkcast java/lang/String
    //   312: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual toString : ()Ljava/lang/String;
    //   318: astore #4
    //   320: new java/lang/StringBuilder
    //   323: astore_1
    //   324: aload_1
    //   325: invokespecial <init> : ()V
    //   328: aload_1
    //   329: aload #4
    //   331: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc_w '&icc_data='
    //   337: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_0
    //   341: getfield ae : Ljava/util/HashMap;
    //   344: ldc_w 'DCD'
    //   347: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   350: checkcast java/lang/String
    //   353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual toString : ()Ljava/lang/String;
    //   359: astore_1
    //   360: new java/lang/StringBuilder
    //   363: astore #4
    //   365: aload #4
    //   367: invokespecial <init> : ()V
    //   370: aload #4
    //   372: aload_1
    //   373: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc_w '&card_seq_id='
    //   379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_0
    //   383: getfield ae : Ljava/util/HashMap;
    //   386: ldc_w '5F34'
    //   389: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   392: checkcast java/lang/String
    //   395: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: invokevirtual toString : ()Ljava/lang/String;
    //   401: astore_1
    //   402: new java/lang/StringBuilder
    //   405: astore #4
    //   407: aload #4
    //   409: invokespecial <init> : ()V
    //   412: aload #4
    //   414: aload_1
    //   415: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc_w '&auth_id='
    //   421: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: getfield J : Ljava/lang/String;
    //   428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual toString : ()Ljava/lang/String;
    //   434: astore #4
    //   436: ldc_w 'mac'
    //   439: aload #4
    //   441: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   444: pop
    //   445: aload #4
    //   447: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
    //   450: astore_1
    //   451: ldc_w 'md5'
    //   454: aload_1
    //   455: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   458: pop
    //   459: aload_0
    //   460: getfield e : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   463: aload_1
    //   464: invokevirtual h : (Ljava/lang/String;)Ljava/lang/String;
    //   467: astore_1
    //   468: ldc_w 'sig'
    //   471: aload_1
    //   472: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   475: pop
    //   476: new java/lang/StringBuilder
    //   479: astore #5
    //   481: aload #5
    //   483: invokespecial <init> : ()V
    //   486: aload #5
    //   488: aload #4
    //   490: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w '&'
    //   496: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_1
    //   500: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual toString : ()Ljava/lang/String;
    //   506: astore #4
    //   508: aload_0
    //   509: getfield e : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   512: aload #4
    //   514: aload_0
    //   515: getfield I : Ljava/lang/String;
    //   518: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   521: astore #6
    //   523: new org/json/JSONObject
    //   526: astore #4
    //   528: aload #4
    //   530: invokespecial <init> : ()V
    //   533: aload #4
    //   535: ldc_w 'v'
    //   538: aload_0
    //   539: getfield r : Ljava/lang/String;
    //   542: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   545: pop
    //   546: aload #4
    //   548: ldc_w 'cmd'
    //   551: ldc_w 'pay'
    //   554: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   557: pop
    //   558: new org/json/JSONObject
    //   561: astore #5
    //   563: aload #5
    //   565: invokespecial <init> : ()V
    //   568: aload #4
    //   570: ldc_w 'params'
    //   573: aload #5
    //   575: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   578: pop
    //   579: aload #5
    //   581: ldc_w 'encrypt_key_field'
    //   584: aload #6
    //   586: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   589: pop
    //   590: aload #5
    //   592: ldc_w 'pay_type'
    //   595: ldc_w '2'
    //   598: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   601: pop
    //   602: aload #5
    //   604: ldc_w 'pay_mode'
    //   607: ldc_w '1'
    //   610: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   613: pop
    //   614: aload #5
    //   616: ldc_w 'bind'
    //   619: ldc_w 'no'
    //   622: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   625: pop
    //   626: aload #5
    //   628: ldc_w 'carrier_tp'
    //   631: ldc_w '7'
    //   634: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   637: pop
    //   638: aload #5
    //   640: ldc_w 'carrier_app_tp'
    //   643: ldc_w '0'
    //   646: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   649: pop
    //   650: aload #5
    //   652: ldc_w 'sign'
    //   655: aload_1
    //   656: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   659: pop
    //   660: aload #5
    //   662: ldc_w 'pan'
    //   665: aload_0
    //   666: getfield ae : Ljava/util/HashMap;
    //   669: ldc_w 'AN1'
    //   672: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   675: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   678: pop
    //   679: aload_0
    //   680: getfield ae : Ljava/util/HashMap;
    //   683: ldc_w 'ED'
    //   686: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   689: ifnull -> 711
    //   692: aload #5
    //   694: ldc_w 'expire'
    //   697: aload_0
    //   698: getfield ae : Ljava/util/HashMap;
    //   701: ldc_w 'ED'
    //   704: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   707: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   710: pop
    //   711: aload_0
    //   712: getfield ae : Ljava/util/HashMap;
    //   715: ldc_w 'TD2'
    //   718: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   721: ifnull -> 743
    //   724: aload #5
    //   726: ldc_w 'track2_data'
    //   729: aload_0
    //   730: getfield ae : Ljava/util/HashMap;
    //   733: ldc_w 'TD2'
    //   736: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   739: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   742: pop
    //   743: aload_2
    //   744: ifnull -> 844
    //   747: aload_2
    //   748: invokevirtual keySet : ()Ljava/util/Set;
    //   751: ifnull -> 844
    //   754: aload_2
    //   755: invokevirtual keySet : ()Ljava/util/Set;
    //   758: invokeinterface size : ()I
    //   763: ifle -> 844
    //   766: aload_2
    //   767: ldc_w 'pan'
    //   770: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   773: pop
    //   774: aload_2
    //   775: ldc_w 'pin'
    //   778: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   781: pop
    //   782: aload_2
    //   783: invokevirtual keySet : ()Ljava/util/Set;
    //   786: invokeinterface iterator : ()Ljava/util/Iterator;
    //   791: astore #6
    //   793: aload #6
    //   795: invokeinterface hasNext : ()Z
    //   800: ifeq -> 844
    //   803: aload #6
    //   805: invokeinterface next : ()Ljava/lang/Object;
    //   810: checkcast java/lang/String
    //   813: astore_1
    //   814: aload #5
    //   816: aload_1
    //   817: aload_2
    //   818: aload_1
    //   819: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   822: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   825: pop
    //   826: goto -> 793
    //   829: astore_1
    //   830: aload_3
    //   831: ldc_w 'action_resp_code'
    //   834: ldc_w '10019'
    //   837: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   840: aload_0
    //   841: monitorexit
    //   842: aload_3
    //   843: areturn
    //   844: aload #4
    //   846: invokevirtual toString : ()Ljava/lang/String;
    //   849: astore_1
    //   850: aload_3
    //   851: ldc_w 'action_resp_message'
    //   854: aload_0
    //   855: getfield s : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   858: aload_1
    //   859: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   862: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   865: goto -> 840
    //   868: astore_1
    //   869: aload_0
    //   870: monitorexit
    //   871: aload_1
    //   872: athrow
    // Exception table:
    //   from	to	target	type
    //   2	202	868	finally
    //   202	523	868	finally
    //   523	711	829	org/json/JSONException
    //   523	711	868	finally
    //   711	743	829	org/json/JSONException
    //   711	743	868	finally
    //   747	793	829	org/json/JSONException
    //   747	793	868	finally
    //   793	826	829	org/json/JSONException
    //   793	826	868	finally
    //   830	840	868	finally
    //   844	850	829	org/json/JSONException
    //   844	850	868	finally
    //   850	865	868	finally
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
  
  private void d(String paramString1, String paramString2) {
    this.v = 8;
    if (TextUtils.isEmpty(paramString2)) {
      this.e.c(paramString1, "");
    } else {
      paramString2 = "\"uuid\":\"" + paramString2 + "\"";
      this.e.a(paramString1, paramString2, 10);
    } 
    this.Q--;
  }
  
  private static String e(String paramString1, String paramString2) {
    byte[] arrayOfByte1 = e.a(paramString1);
    byte[] arrayOfByte2 = e.a(paramString2);
    for (byte b1 = 0; b1 < arrayOfByte1.length; b1++)
      arrayOfByte1[b1] = (byte)(byte)(arrayOfByte1[b1] ^ arrayOfByte2[b1]); 
    return e.a(arrayOfByte1);
  }
  
  private void v() {
    this.v = 103;
    int i = this.u;
    this.e.a("query", this.a.aj, 3);
    this.u--;
  }
  
  private HashMap<String, String> w() {
    HashMap<?, ?> hashMap2;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (this.y != null)
      hashMap = this.y.c(); 
    HashMap<?, ?> hashMap1 = hashMap;
    if (this.O != null) {
      hashMap2 = this.O.c();
      if (hashMap2 != null && hashMap != null) {
        hashMap.putAll(hashMap2);
        return (HashMap)hashMap;
      } 
    } else {
      return (HashMap)hashMap1;
    } 
    hashMap1 = hashMap;
    if (hashMap2 != null) {
      hashMap1 = hashMap;
      if (hashMap == null)
        hashMap1 = hashMap2; 
    } 
    return (HashMap)hashMap1;
  }
  
  private static Bundle x() {
    Bundle bundle = new Bundle();
    bundle.putString("action_resp_code", "0000");
    return bundle;
  }
  
  private int y() {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    return displayMetrics.heightPixels;
  }
  
  public final Bundle a(String paramString, HashMap<String, String> paramHashMap) {
    return c(paramString, paramHashMap);
  }
  
  public final void a(NfcAdapter paramNfcAdapter) {
    this.R = paramNfcAdapter;
    if (this.R.isEnabled()) {
      this.B.setVisibility(8);
      if (this.M)
        this.D.setVisibility(0); 
      this.E.setVisibility(8);
      if (this.G != null)
        this.G.setVisibility(0); 
      return;
    } 
    this.B.setVisibility(0);
    this.D.setVisibility(8);
    this.E.setVisibility(0);
    if (this.G != null)
      this.G.setVisibility(4); 
  }
  
  public final void a(a parama) {
    boolean bool;
    this.t = parama;
    HashMap hashMap = this.a.p;
    String str3 = ac.substring(2, 8);
    long l = (new Date(System.currentTimeMillis())).getTime();
    String str1 = String.valueOf(l);
    if (str1.length() < 8) {
      str1 = String.format("%08d", new Object[] { Long.valueOf(l) });
    } else {
      str1 = str1.substring(str1.length() - 8, str1.length());
    } 
    this.ae.put("9F26", "");
    this.ae.put("9F27", "80");
    this.ae.put("9F10", "");
    this.ae.put("9F37", str1);
    this.ae.put("9F36", "");
    this.ae.put("95", "0000000800");
    this.ae.put("9A", str3);
    this.ae.put("9C", "45");
    this.ae.put("9F02", "000000000000");
    this.ae.put("5F2A", "0156");
    this.ae.put("82", "");
    this.ae.put("9F1A", "0156");
    this.ae.put("9F03", "000000000000");
    this.ae.put("9F33", "A04000");
    this.ae.put("9F34", "420300");
    this.ae.put("9F35", "34");
    this.ae.put("9F1E", "3030303030303030");
    this.ae.put("84", "");
    this.ae.put("9F09", "0001");
    this.ae.put("9F74", "");
    this.ae.put("9F63", "");
    this.ae.put("9F7A", "00");
    this.ae.put("9F21", ac.substring(8));
    this.ae.put("9F4E", "0000000000000000000000000000000000000000");
    this.ae.put("DF31", "0100000000");
    this.ae.put("9F66", "36800000");
    this.ae.put("DF60", "00");
    this.ae.put("9F02", (String)hashMap.get("trans_amt"));
    this.ae.put("9F1A", "0156");
    this.ae.put("5F2A", (String)hashMap.get("trans currcy code"));
    this.ae.put("9C", (String)hashMap.get("trans_type"));
    this.ae.put("CUR", this.ae.get("5F2A"));
    Bundle bundle = x();
    ab = new Date(System.currentTimeMillis());
    ac = (new SimpleDateFormat("yyyyMMddHHmmss")).format(ab);
    this.ad = new String(ac);
    String str2 = this.t.a();
    if (str2 == null || str2.length() == 0) {
      bundle.putString("action_resp_code", "10019");
    } else if ("noSupUnionpay".equals(str2)) {
      bundle.putString("action_resp_code", "10024");
    } else {
      str2 = this.t.a(str2, this.ae);
      if (str2 == null || str2.length() == 0) {
        bundle.putString("action_resp_code", "10020");
      } else {
        a a1 = this.t;
        a.b(str2, this.ae);
      } 
    } 
    if (bundle.getString("action_resp_code") != "0000") {
      Handler handler1 = this.z;
      Handler handler2 = this.z;
      if (bundle == null)
        bundle = null; 
      handler1.sendMessage(handler2.obtainMessage(0, bundle));
      bool = false;
    } else {
      bool = true;
    } 
    if (bool && this.M) {
      this.v = 102;
      this.j = false;
      this.b.a(c.bD.U);
      String str = this.ae.get("AN1");
      str = "\"pan\":\"" + str + "\",\"carrier_tp\":\"7\"";
      this.e.c("cardrules", str);
    } 
  }
  
  public final void a(a.a parama) {}
  
  protected final void a(String paramString, boolean paramBoolean) {
    m m = new m(this, paramBoolean);
    this.b.a(m, null);
    this.b.a(c.bD.Y, paramString, c.bD.W);
  }
  
  public final void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield v : I
    //   6: lookupswitch default -> 64, 7 -> 1555, 8 -> 1585, 101 -> 1078, 102 -> 65, 103 -> 1169, 104 -> 979
    //   64: return
    //   65: aload_0
    //   66: getfield b : Lcom/unionpay/mobile/android/widgets/m;
    //   69: invokevirtual c : ()V
    //   72: aload_0
    //   73: aload_1
    //   74: ldc_w 'encrypt_key'
    //   77: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   80: checkcast java/lang/String
    //   83: putfield I : Ljava/lang/String;
    //   86: aload_0
    //   87: aload_1
    //   88: ldc_w 'auth_id'
    //   91: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   94: checkcast java/lang/String
    //   97: putfield J : Ljava/lang/String;
    //   100: aload_0
    //   101: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   104: aload_1
    //   105: iconst_0
    //   106: invokestatic a : (Lcom/unionpay/mobile/android/model/b;Lorg/json/JSONObject;Z)I
    //   109: istore_3
    //   110: aload_0
    //   111: aload_1
    //   112: invokestatic a : (Lorg/json/JSONObject;)Lcom/unionpay/mobile/android/model/e;
    //   115: putfield p : Lcom/unionpay/mobile/android/model/e;
    //   118: iload_3
    //   119: ifeq -> 140
    //   122: aload_0
    //   123: iload_3
    //   124: invokevirtual b : (I)V
    //   127: goto -> 64
    //   130: astore #4
    //   132: aload #4
    //   134: invokevirtual printStackTrace : ()V
    //   137: goto -> 100
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield M : Z
    //   145: aload_0
    //   146: getfield S : Landroid/widget/FrameLayout;
    //   149: ldc_w -1052684
    //   152: invokevirtual setBackgroundColor : (I)V
    //   155: aload_0
    //   156: ldc_w -1052684
    //   159: invokevirtual setBackgroundColor : (I)V
    //   162: aload_0
    //   163: getfield F : Lcom/unionpay/mobile/android/widgets/ay;
    //   166: getstatic com/unionpay/mobile/android/global/a.M : I
    //   169: invokevirtual setBackgroundColor : (I)V
    //   172: aload_0
    //   173: getfield F : Lcom/unionpay/mobile/android/widgets/ay;
    //   176: bipush #8
    //   178: invokevirtual a : (I)V
    //   181: aload_0
    //   182: getfield A : Landroid/widget/LinearLayout;
    //   185: invokevirtual removeAllViews : ()V
    //   188: aload_0
    //   189: getfield B : Landroid/widget/LinearLayout;
    //   192: bipush #8
    //   194: invokevirtual setVisibility : (I)V
    //   197: aload_0
    //   198: getfield m : Landroid/widget/RelativeLayout;
    //   201: ldc_w -1052684
    //   204: invokevirtual setBackgroundColor : (I)V
    //   207: aload_0
    //   208: getfield l : Landroid/view/ViewGroup;
    //   211: iconst_0
    //   212: invokevirtual setVisibility : (I)V
    //   215: aload_0
    //   216: getfield H : Landroid/widget/ImageView;
    //   219: bipush #8
    //   221: invokevirtual setVisibility : (I)V
    //   224: aload_0
    //   225: getfield D : Landroid/widget/LinearLayout;
    //   228: bipush #8
    //   230: invokevirtual setVisibility : (I)V
    //   233: new android/widget/LinearLayout$LayoutParams
    //   236: dup
    //   237: iconst_m1
    //   238: bipush #-2
    //   240: invokespecial <init> : (II)V
    //   243: pop
    //   244: new org/json/JSONArray
    //   247: dup
    //   248: invokespecial <init> : ()V
    //   251: astore #4
    //   253: aload_0
    //   254: getfield p : Lcom/unionpay/mobile/android/model/e;
    //   257: ifnull -> 308
    //   260: aload_0
    //   261: getfield p : Lcom/unionpay/mobile/android/model/e;
    //   264: checkcast com/unionpay/mobile/android/model/f
    //   267: astore_1
    //   268: aload #4
    //   270: aload_1
    //   271: ldc_w 'promotion'
    //   274: invokevirtual a : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   277: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   280: pop
    //   281: aload #4
    //   283: aload_1
    //   284: ldc_w 'instalment'
    //   287: invokevirtual a : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   290: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   293: pop
    //   294: aload_0
    //   295: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   298: aload_1
    //   299: ldc_w 'promotion_instalment_msgbox'
    //   302: invokevirtual a : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   305: putfield aU : Lorg/json/JSONObject;
    //   308: aload #4
    //   310: invokevirtual length : ()I
    //   313: ifle -> 419
    //   316: aload_0
    //   317: new com/unionpay/mobile/android/upviews/a
    //   320: dup
    //   321: aload_0
    //   322: getfield d : Landroid/content/Context;
    //   325: aload #4
    //   327: aload_0
    //   328: aload_0
    //   329: getfield q : Ljava/lang/String;
    //   332: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONArray;Lcom/unionpay/mobile/android/upviews/a$b;Ljava/lang/String;)V
    //   335: putfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   338: aload_0
    //   339: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   342: aload_0
    //   343: getfield b : Lcom/unionpay/mobile/android/widgets/m;
    //   346: aload_0
    //   347: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   350: getfield aU : Lorg/json/JSONObject;
    //   353: invokevirtual a : (Lcom/unionpay/mobile/android/widgets/m;Lorg/json/JSONObject;)V
    //   356: aload_0
    //   357: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   360: aload_0
    //   361: getfield U : Landroid/view/View$OnClickListener;
    //   364: invokevirtual a : (Landroid/view/View$OnClickListener;)V
    //   367: aload_0
    //   368: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   371: aload_0
    //   372: getfield V : Landroid/view/View$OnClickListener;
    //   375: invokevirtual b : (Landroid/view/View$OnClickListener;)V
    //   378: aload_0
    //   379: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   382: aload_0
    //   383: getfield W : Landroid/view/View$OnClickListener;
    //   386: invokevirtual c : (Landroid/view/View$OnClickListener;)V
    //   389: new android/widget/LinearLayout$LayoutParams
    //   392: dup
    //   393: iconst_m1
    //   394: bipush #-2
    //   396: invokespecial <init> : (II)V
    //   399: astore_1
    //   400: aload_1
    //   401: getstatic com/unionpay/mobile/android/global/a.f : I
    //   404: putfield topMargin : I
    //   407: aload_0
    //   408: getfield A : Landroid/widget/LinearLayout;
    //   411: aload_0
    //   412: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   415: aload_1
    //   416: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   419: aload_0
    //   420: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   423: ifnull -> 437
    //   426: aload_0
    //   427: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   430: ldc_w 'instalment'
    //   433: invokevirtual c : (Ljava/lang/String;)Lcom/unionpay/mobile/android/widgets/z;
    //   436: pop
    //   437: aload_0
    //   438: new com/unionpay/mobile/android/upviews/a
    //   441: dup
    //   442: aload_0
    //   443: getfield d : Landroid/content/Context;
    //   446: aload_0
    //   447: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   450: getfield z : Lorg/json/JSONArray;
    //   453: aload_0
    //   454: getfield e : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   457: invokevirtual c : ()J
    //   460: aload_0
    //   461: aload_0
    //   462: getfield ae : Ljava/util/HashMap;
    //   465: ldc_w 'AN1'
    //   468: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   471: checkcast java/lang/String
    //   474: iconst_1
    //   475: aload_0
    //   476: getfield q : Ljava/lang/String;
    //   479: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONArray;JLcom/unionpay/mobile/android/upviews/a$b;Ljava/lang/String;ZLjava/lang/String;)V
    //   482: putfield y : Lcom/unionpay/mobile/android/upviews/a;
    //   485: new android/widget/LinearLayout$LayoutParams
    //   488: dup
    //   489: iconst_m1
    //   490: bipush #-2
    //   492: invokespecial <init> : (II)V
    //   495: astore_1
    //   496: aload_1
    //   497: getstatic com/unionpay/mobile/android/global/a.f : I
    //   500: putfield topMargin : I
    //   503: aload_0
    //   504: getfield A : Landroid/widget/LinearLayout;
    //   507: aload_0
    //   508: getfield y : Lcom/unionpay/mobile/android/upviews/a;
    //   511: aload_1
    //   512: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   515: new android/widget/LinearLayout
    //   518: dup
    //   519: aload_0
    //   520: getfield d : Landroid/content/Context;
    //   523: invokespecial <init> : (Landroid/content/Context;)V
    //   526: astore_1
    //   527: aload_1
    //   528: iconst_1
    //   529: invokevirtual setOrientation : (I)V
    //   532: aload_1
    //   533: aload_1
    //   534: invokevirtual hashCode : ()I
    //   537: invokevirtual setId : (I)V
    //   540: new android/widget/LinearLayout$LayoutParams
    //   543: dup
    //   544: iconst_m1
    //   545: bipush #-2
    //   547: invokespecial <init> : (II)V
    //   550: pop
    //   551: new android/widget/LinearLayout$LayoutParams
    //   554: dup
    //   555: iconst_m1
    //   556: bipush #-2
    //   558: invokespecial <init> : (II)V
    //   561: astore #4
    //   563: aload #4
    //   565: getstatic com/unionpay/mobile/android/global/a.f : I
    //   568: putfield topMargin : I
    //   571: aload #4
    //   573: aload_0
    //   574: getfield d : Landroid/content/Context;
    //   577: ldc_w 10.0
    //   580: invokestatic a : (Landroid/content/Context;F)I
    //   583: putfield leftMargin : I
    //   586: aload_0
    //   587: getfield A : Landroid/widget/LinearLayout;
    //   590: aload_1
    //   591: aload #4
    //   593: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   596: aload_0
    //   597: invokevirtual i : ()Z
    //   600: ifne -> 623
    //   603: aload_0
    //   604: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   607: getfield al : Lorg/json/JSONObject;
    //   610: ifnonnull -> 623
    //   613: aload_0
    //   614: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   617: getfield am : Lorg/json/JSONObject;
    //   620: ifnull -> 777
    //   623: aload_0
    //   624: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   627: getfield al : Lorg/json/JSONObject;
    //   630: ifnull -> 690
    //   633: aload_0
    //   634: new com/unionpay/mobile/android/upwidget/a
    //   637: dup
    //   638: aload_0
    //   639: getfield d : Landroid/content/Context;
    //   642: aload_0
    //   643: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   646: getfield al : Lorg/json/JSONObject;
    //   649: aload_0
    //   650: getfield aa : Landroid/view/View$OnClickListener;
    //   653: new java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial <init> : ()V
    //   660: aload_0
    //   661: getfield q : Ljava/lang/String;
    //   664: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w '_agree_user_protocol'
    //   670: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual toString : ()Ljava/lang/String;
    //   676: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;Landroid/view/View$OnClickListener;Ljava/lang/String;)V
    //   679: putfield L : Lcom/unionpay/mobile/android/upwidget/a;
    //   682: aload_1
    //   683: aload_0
    //   684: getfield L : Lcom/unionpay/mobile/android/upwidget/a;
    //   687: invokevirtual addView : (Landroid/view/View;)V
    //   690: aload_0
    //   691: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   694: getfield am : Lorg/json/JSONObject;
    //   697: ifnull -> 777
    //   700: aload_0
    //   701: new com/unionpay/mobile/android/upwidget/a
    //   704: dup
    //   705: aload_0
    //   706: getfield d : Landroid/content/Context;
    //   709: aload_0
    //   710: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   713: getfield am : Lorg/json/JSONObject;
    //   716: aconst_null
    //   717: new java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial <init> : ()V
    //   724: aload_0
    //   725: getfield q : Ljava/lang/String;
    //   728: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: ldc_w '_remember_bankNO'
    //   734: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: invokevirtual toString : ()Ljava/lang/String;
    //   740: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;Landroid/view/View$OnClickListener;Ljava/lang/String;)V
    //   743: putfield K : Lcom/unionpay/mobile/android/upwidget/a;
    //   746: new android/widget/LinearLayout$LayoutParams
    //   749: dup
    //   750: bipush #-2
    //   752: bipush #-2
    //   754: invokespecial <init> : (II)V
    //   757: astore #4
    //   759: aload #4
    //   761: getstatic com/unionpay/mobile/android/global/a.f : I
    //   764: putfield topMargin : I
    //   767: aload_1
    //   768: aload_0
    //   769: getfield K : Lcom/unionpay/mobile/android/upwidget/a;
    //   772: aload #4
    //   774: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   777: new android/widget/LinearLayout$LayoutParams
    //   780: dup
    //   781: iconst_m1
    //   782: bipush #-2
    //   784: invokespecial <init> : (II)V
    //   787: pop
    //   788: aload_0
    //   789: new android/widget/TextView
    //   792: dup
    //   793: aload_0
    //   794: getfield d : Landroid/content/Context;
    //   797: invokespecial <init> : (Landroid/content/Context;)V
    //   800: putfield w : Landroid/widget/TextView;
    //   803: aload_0
    //   804: getfield w : Landroid/widget/TextView;
    //   807: aload_0
    //   808: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   811: getfield C : Lorg/json/JSONObject;
    //   814: ldc_w 'label'
    //   817: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   820: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   823: aload_0
    //   824: getfield w : Landroid/widget/TextView;
    //   827: getstatic com/unionpay/mobile/android/global/b.i : F
    //   830: invokevirtual setTextSize : (F)V
    //   833: aload_0
    //   834: getfield w : Landroid/widget/TextView;
    //   837: invokestatic p : ()Landroid/content/res/ColorStateList;
    //   840: invokevirtual setTextColor : (Landroid/content/res/ColorStateList;)V
    //   843: aload_0
    //   844: getfield w : Landroid/widget/TextView;
    //   847: bipush #17
    //   849: invokevirtual setGravity : (I)V
    //   852: aload_0
    //   853: getfield w : Landroid/widget/TextView;
    //   856: astore_1
    //   857: iload_2
    //   858: istore #5
    //   860: aload_0
    //   861: getfield y : Lcom/unionpay/mobile/android/upviews/a;
    //   864: ifnull -> 880
    //   867: aload_0
    //   868: getfield y : Lcom/unionpay/mobile/android/upviews/a;
    //   871: invokevirtual e : ()Z
    //   874: ifeq -> 973
    //   877: iload_2
    //   878: istore #5
    //   880: aload_1
    //   881: iload #5
    //   883: invokevirtual setEnabled : (Z)V
    //   886: getstatic com/unionpay/mobile/android/global/a.n : I
    //   889: istore_3
    //   890: aload_0
    //   891: getfield c : Lcom/unionpay/mobile/android/resource/c;
    //   894: sipush #2008
    //   897: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   900: astore_1
    //   901: aload_0
    //   902: getfield w : Landroid/widget/TextView;
    //   905: aload_1
    //   906: invokevirtual setBackgroundDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   909: aload_0
    //   910: getfield w : Landroid/widget/TextView;
    //   913: aload_0
    //   914: getfield T : Landroid/view/View$OnClickListener;
    //   917: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   920: new android/widget/LinearLayout$LayoutParams
    //   923: dup
    //   924: iconst_m1
    //   925: iload_3
    //   926: invokespecial <init> : (II)V
    //   929: astore_1
    //   930: aload_1
    //   931: getstatic com/unionpay/mobile/android/global/a.f : I
    //   934: putfield topMargin : I
    //   937: aload_0
    //   938: getfield d : Landroid/content/Context;
    //   941: ldc_w 10.0
    //   944: invokestatic a : (Landroid/content/Context;F)I
    //   947: istore_3
    //   948: aload_1
    //   949: iload_3
    //   950: putfield rightMargin : I
    //   953: aload_1
    //   954: iload_3
    //   955: putfield leftMargin : I
    //   958: aload_0
    //   959: getfield A : Landroid/widget/LinearLayout;
    //   962: aload_0
    //   963: getfield w : Landroid/widget/TextView;
    //   966: aload_1
    //   967: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   970: goto -> 64
    //   973: iconst_0
    //   974: istore #5
    //   976: goto -> 880
    //   979: aload_0
    //   980: aload_1
    //   981: ldc_w 'encrypt_key'
    //   984: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   987: checkcast java/lang/String
    //   990: putfield I : Ljava/lang/String;
    //   993: aload_0
    //   994: aload_1
    //   995: ldc_w 'auth_id'
    //   998: invokevirtual get : (Ljava/lang/String;)Ljava/lang/Object;
    //   1001: checkcast java/lang/String
    //   1004: putfield J : Ljava/lang/String;
    //   1007: aload_0
    //   1008: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1011: getfield p : Ljava/util/HashMap;
    //   1014: ifnull -> 64
    //   1017: aload_0
    //   1018: getfield y : Lcom/unionpay/mobile/android/upviews/a;
    //   1021: invokevirtual a : ()Lcom/unionpay/mobile/android/upviews/a$a;
    //   1024: astore_1
    //   1025: aload_1
    //   1026: invokevirtual a : ()Z
    //   1029: ifne -> 1051
    //   1032: aload_0
    //   1033: aload_1
    //   1034: getfield b : Ljava/lang/String;
    //   1037: invokevirtual a : (Ljava/lang/String;)V
    //   1040: goto -> 64
    //   1043: astore_1
    //   1044: aload_1
    //   1045: invokevirtual printStackTrace : ()V
    //   1048: goto -> 1007
    //   1051: aload_0
    //   1052: bipush #101
    //   1054: putfield v : I
    //   1057: aload_0
    //   1058: aload_0
    //   1059: getfield y : Lcom/unionpay/mobile/android/upviews/a;
    //   1062: invokevirtual a : ()Lcom/unionpay/mobile/android/upviews/a$a;
    //   1065: getfield b : Ljava/lang/String;
    //   1068: aload_0
    //   1069: invokespecial w : ()Ljava/util/HashMap;
    //   1072: invokespecial b : (Ljava/lang/String;Ljava/util/HashMap;)V
    //   1075: goto -> 64
    //   1078: aload_0
    //   1079: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1082: aload_1
    //   1083: invokevirtual toString : ()Ljava/lang/String;
    //   1086: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   1089: putfield aj : Ljava/lang/String;
    //   1092: aload_1
    //   1093: ldc_w 'qn'
    //   1096: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1099: astore_1
    //   1100: aload_1
    //   1101: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1104: ifne -> 1125
    //   1107: aload_0
    //   1108: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1111: aload_0
    //   1112: getfield e : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   1115: aload_1
    //   1116: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   1119: invokevirtual i : (Ljava/lang/String;)Ljava/lang/String;
    //   1122: putfield n : Ljava/lang/String;
    //   1125: aload_0
    //   1126: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1129: getfield aj : Ljava/lang/String;
    //   1132: ifnull -> 1148
    //   1135: aload_0
    //   1136: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1139: getfield aj : Ljava/lang/String;
    //   1142: invokevirtual length : ()I
    //   1145: ifgt -> 1156
    //   1148: aload_0
    //   1149: iconst_2
    //   1150: invokevirtual b : (I)V
    //   1153: goto -> 64
    //   1156: aload_0
    //   1157: bipush #20
    //   1159: putfield u : I
    //   1162: aload_0
    //   1163: invokespecial v : ()V
    //   1166: goto -> 64
    //   1169: aload_1
    //   1170: ldc_w 'status'
    //   1173: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1176: astore #6
    //   1178: aload_1
    //   1179: ldc_w 'fail_msg'
    //   1182: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1185: astore #4
    //   1187: aload_0
    //   1188: getfield u : I
    //   1191: ifle -> 1212
    //   1194: aload #6
    //   1196: ldc_w '01'
    //   1199: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   1202: ifeq -> 1212
    //   1205: aload_0
    //   1206: invokespecial v : ()V
    //   1209: goto -> 64
    //   1212: aload_0
    //   1213: bipush #100
    //   1215: putfield v : I
    //   1218: aload #6
    //   1220: ldc_w '00'
    //   1223: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   1226: ifeq -> 1450
    //   1229: aload_0
    //   1230: invokevirtual j : ()V
    //   1233: aload_0
    //   1234: bipush #100
    //   1236: putfield v : I
    //   1239: aload_0
    //   1240: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1243: aload_1
    //   1244: ldc_w 'result'
    //   1247: invokestatic d : (Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   1250: putfield H : Lorg/json/JSONArray;
    //   1253: aload_0
    //   1254: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1257: aload_1
    //   1258: ldc_w 'openupgrade_flag'
    //   1261: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1264: putfield P : Ljava/lang/String;
    //   1267: aload_0
    //   1268: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1271: aload_1
    //   1272: ldc_w 'temporary_pay_flag'
    //   1275: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1278: putfield Q : Ljava/lang/String;
    //   1281: aload_0
    //   1282: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1285: aload_1
    //   1286: ldc_w 'temporary_pay_info'
    //   1289: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1292: putfield R : Ljava/lang/String;
    //   1295: aload_0
    //   1296: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1299: aload_1
    //   1300: ldc_w 'front_url'
    //   1303: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1306: putfield V : Ljava/lang/String;
    //   1309: aload_0
    //   1310: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1313: aload_1
    //   1314: ldc_w 'front_request'
    //   1317: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1320: putfield W : Ljava/lang/String;
    //   1323: aload_0
    //   1324: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1327: aload_1
    //   1328: ldc_w 'title'
    //   1331: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1334: putfield A : Ljava/lang/String;
    //   1337: aload_0
    //   1338: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1341: aload_1
    //   1342: ldc_w 'succ_info'
    //   1345: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1348: putfield B : Ljava/lang/String;
    //   1351: aload_1
    //   1352: aload_0
    //   1353: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1356: invokestatic b : (Lorg/json/JSONObject;Lcom/unionpay/mobile/android/model/b;)V
    //   1359: aload_1
    //   1360: aload_0
    //   1361: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1364: invokestatic a : (Lorg/json/JSONObject;Lcom/unionpay/mobile/android/model/b;)V
    //   1367: aload_0
    //   1368: getfield y : Lcom/unionpay/mobile/android/upviews/a;
    //   1371: ifnull -> 1381
    //   1374: aload_0
    //   1375: getfield y : Lcom/unionpay/mobile/android/upviews/a;
    //   1378: invokevirtual f : ()V
    //   1381: aload_0
    //   1382: getfield d : Landroid/content/Context;
    //   1385: new java/lang/StringBuilder
    //   1388: dup
    //   1389: invokespecial <init> : ()V
    //   1392: aload_0
    //   1393: getfield q : Ljava/lang/String;
    //   1396: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1399: ldc_w '_succeed'
    //   1402: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: invokevirtual toString : ()Ljava/lang/String;
    //   1408: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   1411: aload_0
    //   1412: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1415: getfield f : Z
    //   1418: ifeq -> 1441
    //   1421: aload_0
    //   1422: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1425: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   1428: ldc_w 'success'
    //   1431: putfield f : Ljava/lang/String;
    //   1434: aload_0
    //   1435: invokevirtual k : ()V
    //   1438: goto -> 64
    //   1441: aload_0
    //   1442: bipush #8
    //   1444: invokevirtual d : (I)V
    //   1447: goto -> 64
    //   1450: aload_0
    //   1451: invokevirtual j : ()V
    //   1454: aload #6
    //   1456: ldc_w '03'
    //   1459: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   1462: ifeq -> 1534
    //   1465: aload_0
    //   1466: getfield d : Landroid/content/Context;
    //   1469: new java/lang/StringBuilder
    //   1472: dup
    //   1473: invokespecial <init> : ()V
    //   1476: aload_0
    //   1477: getfield q : Ljava/lang/String;
    //   1480: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: ldc_w '_fail'
    //   1486: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1489: invokevirtual toString : ()Ljava/lang/String;
    //   1492: getstatic com/unionpay/mobile/android/utils/p.j : [Ljava/lang/String;
    //   1495: iconst_2
    //   1496: anewarray java/lang/String
    //   1499: dup
    //   1500: iconst_0
    //   1501: aload #6
    //   1503: aastore
    //   1504: dup
    //   1505: iconst_1
    //   1506: aload #4
    //   1508: aastore
    //   1509: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Object;)V
    //   1512: aload_0
    //   1513: new java/lang/StringBuilder
    //   1516: dup
    //   1517: invokespecial <init> : ()V
    //   1520: aload #4
    //   1522: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: invokevirtual toString : ()Ljava/lang/String;
    //   1528: invokevirtual a : (Ljava/lang/String;)V
    //   1531: goto -> 64
    //   1534: aload_0
    //   1535: getfield u : I
    //   1538: ifgt -> 64
    //   1541: aload_0
    //   1542: aload_0
    //   1543: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1546: getfield ak : Ljava/lang/String;
    //   1549: invokevirtual a : (Ljava/lang/String;)V
    //   1552: goto -> 64
    //   1555: aload_0
    //   1556: invokevirtual j : ()V
    //   1559: aload_1
    //   1560: ldc_w 'options'
    //   1563: invokestatic d : (Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   1566: astore_1
    //   1567: aload_0
    //   1568: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   1571: ifnull -> 64
    //   1574: aload_0
    //   1575: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   1578: aload_1
    //   1579: invokevirtual a : (Lorg/json/JSONArray;)V
    //   1582: goto -> 64
    //   1585: aload_1
    //   1586: ldc_w 'status'
    //   1589: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1592: astore #4
    //   1594: aload #4
    //   1596: ifnull -> 1663
    //   1599: ldc_w '01'
    //   1602: aload #4
    //   1604: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1607: ifeq -> 1663
    //   1610: aload_1
    //   1611: ldc_w 'uuid'
    //   1614: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1617: astore_1
    //   1618: aload_0
    //   1619: getfield Q : I
    //   1622: iflt -> 1637
    //   1625: aload_0
    //   1626: aload_0
    //   1627: getfield P : Ljava/lang/String;
    //   1630: aload_1
    //   1631: invokespecial d : (Ljava/lang/String;Ljava/lang/String;)V
    //   1634: goto -> 64
    //   1637: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   1640: getfield D : Ljava/lang/String;
    //   1643: astore_1
    //   1644: aload_0
    //   1645: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   1648: ifnull -> 64
    //   1651: aload_0
    //   1652: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   1655: aconst_null
    //   1656: aload_1
    //   1657: invokevirtual a : (Lorg/json/JSONArray;Ljava/lang/String;)V
    //   1660: goto -> 64
    //   1663: aload_1
    //   1664: ldc_w 'options'
    //   1667: invokestatic d : (Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   1670: astore #4
    //   1672: aload_1
    //   1673: ldc_w 'empty_info'
    //   1676: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1679: astore_1
    //   1680: aload_0
    //   1681: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   1684: ifnull -> 64
    //   1687: aload_0
    //   1688: getfield O : Lcom/unionpay/mobile/android/upviews/a;
    //   1691: aload #4
    //   1693: aload_1
    //   1694: invokevirtual a : (Lorg/json/JSONArray;Ljava/lang/String;)V
    //   1697: goto -> 64
    // Exception table:
    //   from	to	target	type
    //   72	100	130	org/json/JSONException
    //   979	1007	1043	org/json/JSONException
  }
  
  public final void a(boolean paramBoolean) {
    if (this.w != null) {
      TextView textView = this.w;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      textView.setEnabled(paramBoolean);
    } 
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    if (this.a.aD) {
      this.F = new ay(this.d, c.bD.bo, this.c.a(1030), g.a(this.d, 20.0F), (ay.a)this);
    } else {
      this.F = new ay(getContext(), c.bD.bo, (ay.a)this);
    } 
    this.F.setBackgroundColor(-16686660);
    this.F.a(0);
    layoutParams.addRule(13, -1);
    this.k.addView((View)this.F, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final void b(int paramInt) {
    int i = this.v;
    super.b(paramInt);
  }
  
  protected final void c() {
    setBackgroundColor(-11495169);
    this.l.setVisibility(8);
    this.S = new FrameLayout(this.d);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
    this.m.addView((View)this.S, (ViewGroup.LayoutParams)layoutParams3);
    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, y() - b.n - b.n / 2);
    this.A = new LinearLayout(this.d);
    this.A.setId(this.A.hashCode());
    this.A.setOrientation(1);
    this.S.addView((View)this.A, (ViewGroup.LayoutParams)layoutParams2);
    FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(b.n * 2, b.n * 2);
    DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity)this.d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    layoutParams5.leftMargin = displayMetrics.widthPixels / 2 - b.n;
    layoutParams5.topMargin = y() / 2 - b.n * 2;
    this.H = new ImageView(this.d);
    this.H.setBackgroundDrawable(this.c.a(1032));
    this.S.addView((View)this.H, (ViewGroup.LayoutParams)layoutParams5);
    this.E = new LinearLayout(this.d);
    this.E.setBackgroundColor(-1342177280);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    this.S.addView((View)this.E, (ViewGroup.LayoutParams)layoutParams1);
    this.C = new RelativeLayout(this.d);
    layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    this.S.addView((View)this.C, (ViewGroup.LayoutParams)layoutParams1);
    this.m.setBackgroundColor(-11495169);
    LinearLayout linearLayout = this.A;
    this.A.removeAllViews();
    this.G = new UPRadiationView(this.d);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
    linearLayout.addView((View)this.G, (ViewGroup.LayoutParams)layoutParams);
    RelativeLayout relativeLayout = this.C;
    relativeLayout.setGravity(1);
    int i = g.a(this.d, 10.0F);
    this.B = new LinearLayout(this.d);
    this.B.setId(this.B.hashCode());
    this.B.setOrientation(0);
    this.B.setPadding(i * 2, i, i * 2, i);
    Drawable drawable = this.c.a(1033);
    this.B.setBackgroundDrawable(drawable);
    String str1 = c.bD.bl;
    TextView textView3 = new TextView(this.d);
    textView3.setTextColor(-1);
    textView3.setText(str1);
    textView3.setTextSize(b.k);
    this.B.addView((View)textView3);
    String str3 = c.bD.bm;
    TextView textView2 = new TextView(this.d);
    textView2.setTextColor(-16729682);
    textView2.setText(str3);
    textView2.setTextSize(b.k);
    textView2.setOnClickListener(this.Z);
    this.B.addView((View)textView2);
    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams6.addRule(10, -1);
    layoutParams6.topMargin = b.n;
    relativeLayout.addView((View)this.B, (ViewGroup.LayoutParams)layoutParams6);
    this.D = new LinearLayout(this.d);
    this.D.setId(this.D.hashCode());
    this.D.setOrientation(0);
    this.D.setGravity(17);
    this.D.setPadding(i * 2, i, i * 2, i);
    this.D.setBackgroundDrawable(drawable);
    String str2 = c.bD.bn;
    TextView textView1 = new TextView(this.d);
    textView1.setTextColor(-1);
    textView1.setText(str2);
    textView1.setTextSize(b.k);
    this.D.addView((View)textView1);
    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams4.addRule(12, -1);
    layoutParams4.bottomMargin = b.n;
    relativeLayout.addView((View)this.D, (ViewGroup.LayoutParams)layoutParams4);
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  public final boolean handleMessage(Message paramMessage) {
    String str;
    if (paramMessage.obj != null) {
      Bundle bundle = (Bundle)paramMessage.obj;
      str = bundle.getString("action_resp_code");
      String str1 = bundle.getString("action_resp_message");
      if ("0000".equalsIgnoreCase(str)) {
        if (str1 != null)
          a(0, str1); 
        return true;
      } 
    } else {
      return true;
    } 
    "10024".equalsIgnoreCase(str);
    a(this.a.ap, false);
    return true;
  }
  
  public final void l() {
    if (this.a.aD) {
      t t = new t(this);
      u u = new u(this);
      this.b.a(t, u);
      this.b.a(c.bD.Y, c.bD.av, c.bD.W, c.bD.X);
      return;
    } 
    if (this.y == null || !this.y.d()) {
      if (this.a.K && this.x) {
        this.a.K = false;
        n();
        return;
      } 
      this.a.K = false;
      this.M = false;
      a(2);
    } 
  }
  
  protected final void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.y != null)
      this.y.d(); 
    if (this.G != null)
      this.G.a(); 
    this.G = null;
    this.b = null;
  }
  
  public final void u() {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */