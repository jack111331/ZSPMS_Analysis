package com.cmic.sso.sdk.auth;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import com.cmic.sso.sdk.b;
import com.cmic.sso.sdk.b.b.b;
import com.cmic.sso.sdk.utils.ac;
import com.cmic.sso.sdk.utils.c;
import com.cmic.sso.sdk.utils.f;
import com.cmic.sso.sdk.utils.h;
import com.cmic.sso.sdk.utils.n;
import com.cmic.sso.sdk.utils.q;
import com.cmic.sso.sdk.utils.r;
import com.cmic.sso.sdk.utils.s;
import com.cmic.sso.sdk.utils.w;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
  @SuppressLint({"StaticFieldLeak"})
  private static a c = null;
  
  private com.cmic.sso.sdk.b.b.a a;
  
  private Context b;
  
  private Runnable d = null;
  
  private a(Context paramContext) {
    this.b = paramContext.getApplicationContext();
    this.a = com.cmic.sso.sdk.b.b.a.a(this.b);
  }
  
  public static a a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/cmic/sso/sdk/auth/a.c : Lcom/cmic/sso/sdk/auth/a;
    //   3: ifnonnull -> 31
    //   6: ldc com/cmic/sso/sdk/auth/a
    //   8: monitorenter
    //   9: getstatic com/cmic/sso/sdk/auth/a.c : Lcom/cmic/sso/sdk/auth/a;
    //   12: ifnonnull -> 28
    //   15: new com/cmic/sso/sdk/auth/a
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/cmic/sso/sdk/auth/a.c : Lcom/cmic/sso/sdk/auth/a;
    //   28: ldc com/cmic/sso/sdk/auth/a
    //   30: monitorexit
    //   31: getstatic com/cmic/sso/sdk/auth/a.c : Lcom/cmic/sso/sdk/auth/a;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/cmic/sso/sdk/auth/a
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
    //   36	39	35	finally
  }
  
  private void a(Bundle paramBundle, String paramString, int paramInt, b paramb) {
    r.a(this.b, "phonetimes", System.currentTimeMillis());
    this.a.a(this.b, paramBundle, new b(this, paramBundle, paramb, paramInt, paramString) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Landroid/os/Bundle;
            //   4: ldc 'interfacecode'
            //   6: ldc ''
            //   8: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   11: astore #4
            //   13: aload_0
            //   14: getfield a : Landroid/os/Bundle;
            //   17: ldc 'interfacecode'
            //   19: new java/lang/StringBuilder
            //   22: dup
            //   23: invokespecial <init> : ()V
            //   26: aload #4
            //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   31: aload_1
            //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   35: ldc ';'
            //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   40: invokevirtual toString : ()Ljava/lang/String;
            //   43: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   46: invokestatic currentTimeMillis : ()J
            //   49: lstore #5
            //   51: lload #5
            //   53: aload_0
            //   54: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   57: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   60: ldc 'phonetimes'
            //   62: lconst_0
            //   63: invokestatic b : (Landroid/content/Context;Ljava/lang/String;J)J
            //   66: lsub
            //   67: lstore #7
            //   69: aload_0
            //   70: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   73: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   76: ldc 'phonebetweentimes'
            //   78: lload #7
            //   80: invokestatic a : (Landroid/content/Context;Ljava/lang/String;J)V
            //   83: aload_0
            //   84: getfield a : Landroid/os/Bundle;
            //   87: ldc 'interfaceelasped'
            //   89: ldc ''
            //   91: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   94: astore #4
            //   96: aload_0
            //   97: getfield a : Landroid/os/Bundle;
            //   100: ldc 'interfaceelasped'
            //   102: new java/lang/StringBuilder
            //   105: dup
            //   106: invokespecial <init> : ()V
            //   109: aload #4
            //   111: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   114: lload #7
            //   116: invokevirtual append : (J)Ljava/lang/StringBuilder;
            //   119: ldc ';'
            //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   124: invokevirtual toString : ()Ljava/lang/String;
            //   127: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   130: ldc '103119'
            //   132: aload_1
            //   133: invokevirtual equals : (Ljava/lang/Object;)Z
            //   136: ifne -> 166
            //   139: ldc '103101'
            //   141: aload_1
            //   142: invokevirtual equals : (Ljava/lang/Object;)Z
            //   145: ifne -> 166
            //   148: ldc '105302'
            //   150: aload_1
            //   151: invokevirtual equals : (Ljava/lang/Object;)Z
            //   154: ifne -> 166
            //   157: ldc '105019'
            //   159: aload_1
            //   160: invokevirtual equals : (Ljava/lang/Object;)Z
            //   163: ifeq -> 183
            //   166: aload_0
            //   167: getfield b : Lcom/cmic/sso/sdk/auth/b;
            //   170: aload_1
            //   171: aload_2
            //   172: aload_0
            //   173: getfield a : Landroid/os/Bundle;
            //   176: aload_3
            //   177: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)V
            //   182: return
            //   183: ldc '103000'
            //   185: aload_1
            //   186: invokevirtual equals : (Ljava/lang/Object;)Z
            //   189: ifeq -> 750
            //   192: aload_3
            //   193: ldc 'resultdata'
            //   195: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   198: astore_1
            //   199: aload_1
            //   200: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   203: ifne -> 215
            //   206: aload_1
            //   207: ldc ''
            //   209: invokevirtual equals : (Ljava/lang/Object;)Z
            //   212: ifeq -> 629
            //   215: aload_3
            //   216: invokevirtual toString : ()Ljava/lang/String;
            //   219: astore_3
            //   220: aconst_null
            //   221: astore #9
            //   223: aconst_null
            //   224: astore #4
            //   226: aload #4
            //   228: astore_1
            //   229: aload #9
            //   231: astore_2
            //   232: new org/json/JSONObject
            //   235: astore #10
            //   237: aload #4
            //   239: astore_1
            //   240: aload #9
            //   242: astore_2
            //   243: aload #10
            //   245: aload_3
            //   246: invokespecial <init> : (Ljava/lang/String;)V
            //   249: aload #4
            //   251: astore_1
            //   252: aload #9
            //   254: astore_2
            //   255: aload #10
            //   257: ldc 'phonescrip'
            //   259: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   262: astore_3
            //   263: aload #4
            //   265: astore_1
            //   266: aload_3
            //   267: astore_2
            //   268: aload_0
            //   269: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   272: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   275: aload_3
            //   276: aload #10
            //   278: ldc 'phonescripED'
            //   280: invokevirtual optLong : (Ljava/lang/String;)J
            //   283: aload_0
            //   284: getfield a : Landroid/os/Bundle;
            //   287: ldc 'imsi'
            //   289: ldc ''
            //   291: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   294: invokestatic a : (Landroid/content/Context;Ljava/lang/String;JLjava/lang/String;)V
            //   297: aload #4
            //   299: astore_1
            //   300: aload_3
            //   301: astore_2
            //   302: aload #10
            //   304: ldc 'securityphone'
            //   306: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   309: astore #4
            //   311: aload #4
            //   313: astore_1
            //   314: aload_3
            //   315: astore_2
            //   316: aload_0
            //   317: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   320: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   323: ldc 'securityphone'
            //   325: aload #4
            //   327: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
            //   330: aload #4
            //   332: astore_1
            //   333: aload_3
            //   334: astore_2
            //   335: aload #10
            //   337: ldc 'openId'
            //   339: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   342: astore #9
            //   344: aload #10
            //   346: ldc 'sourceid'
            //   348: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   351: astore_2
            //   352: aload_0
            //   353: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   356: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   359: ldc 'sourceid'
            //   361: aload_2
            //   362: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
            //   365: aload #9
            //   367: invokevirtual isEmpty : ()Z
            //   370: ifeq -> 891
            //   373: aload #10
            //   375: ldc 'pcid'
            //   377: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   380: astore_1
            //   381: aload #10
            //   383: ldc 'capaids'
            //   385: ldc 'acd'
            //   387: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   390: astore #9
            //   392: aload_0
            //   393: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   396: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   399: ldc 'allcapaids'
            //   401: aload #9
            //   403: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
            //   406: aload_0
            //   407: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   410: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   413: ldc 'validated'
            //   415: iconst_1
            //   416: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Z)V
            //   419: aload #4
            //   421: astore #9
            //   423: aload_0
            //   424: getfield a : Landroid/os/Bundle;
            //   427: ldc 'openId'
            //   429: aload_1
            //   430: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   433: aload_0
            //   434: getfield a : Landroid/os/Bundle;
            //   437: ldc 'phonescrip'
            //   439: aload_3
            //   440: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   443: aload_0
            //   444: getfield a : Landroid/os/Bundle;
            //   447: ldc 'securityphone'
            //   449: aload #9
            //   451: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   454: aload_0
            //   455: getfield a : Landroid/os/Bundle;
            //   458: ldc 'sourceid'
            //   460: aload_2
            //   461: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   464: aload_0
            //   465: getfield a : Landroid/os/Bundle;
            //   468: ldc 'logintype'
            //   470: invokevirtual getInt : (Ljava/lang/String;)I
            //   473: iconst_3
            //   474: if_icmpne -> 684
            //   477: ldc 'AuthBusiness'
            //   479: ldc '预取号==>'
            //   481: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
            //   484: aload_0
            //   485: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   488: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   491: ldc 'preopenid'
            //   493: aload_1
            //   494: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
            //   497: aload_0
            //   498: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   501: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   504: ldc 'prephonescrip'
            //   506: aload_3
            //   507: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
            //   510: aload_0
            //   511: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   514: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   517: ldc 'securityphone'
            //   519: aload #9
            //   521: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
            //   524: aload_0
            //   525: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   528: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   531: ldc 'pretimestamp'
            //   533: invokestatic currentTimeMillis : ()J
            //   536: invokestatic a : (Landroid/content/Context;Ljava/lang/String;J)V
            //   539: aload_0
            //   540: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   543: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   546: ldc 'phonetimes'
            //   548: lconst_0
            //   549: invokestatic b : (Landroid/content/Context;Ljava/lang/String;J)J
            //   552: lstore #7
            //   554: ldc 'AuthBusiness'
            //   556: new java/lang/StringBuilder
            //   559: dup
            //   560: invokespecial <init> : ()V
            //   563: ldc 'displayTimes : '
            //   565: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   568: lload #5
            //   570: lload #7
            //   572: lsub
            //   573: invokevirtual append : (J)Ljava/lang/StringBuilder;
            //   576: invokevirtual toString : ()Ljava/lang/String;
            //   579: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
            //   582: new org/json/JSONObject
            //   585: dup
            //   586: invokespecial <init> : ()V
            //   589: astore_1
            //   590: aload_1
            //   591: ldc 'resultCode'
            //   593: ldc '103000'
            //   595: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            //   598: pop
            //   599: aload_1
            //   600: ldc 'desc'
            //   602: ldc 'true'
            //   604: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            //   607: pop
            //   608: aload_0
            //   609: getfield b : Lcom/cmic/sso/sdk/auth/b;
            //   612: ldc '103000'
            //   614: ldc 'true'
            //   616: aload_0
            //   617: getfield a : Landroid/os/Bundle;
            //   620: aload_1
            //   621: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)V
            //   626: goto -> 182
            //   629: aload_0
            //   630: getfield a : Landroid/os/Bundle;
            //   633: getstatic com/cmic/sso/sdk/a$a.a : Ljava/lang/String;
            //   636: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
            //   639: aload_1
            //   640: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   643: astore_3
            //   644: goto -> 220
            //   647: astore_3
            //   648: aconst_null
            //   649: astore #10
            //   651: aconst_null
            //   652: astore #11
            //   654: aload_2
            //   655: astore #4
            //   657: aload_1
            //   658: astore #9
            //   660: aload #11
            //   662: astore_1
            //   663: aload #10
            //   665: astore_2
            //   666: aload_3
            //   667: invokevirtual printStackTrace : ()V
            //   670: aload #4
            //   672: astore_3
            //   673: goto -> 423
            //   676: astore_2
            //   677: aload_2
            //   678: invokevirtual printStackTrace : ()V
            //   681: goto -> 608
            //   684: iconst_1
            //   685: aload_0
            //   686: getfield a : Landroid/os/Bundle;
            //   689: ldc 'logintype'
            //   691: invokevirtual getInt : (Ljava/lang/String;)I
            //   694: if_icmpne -> 732
            //   697: aload_0
            //   698: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   701: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   704: ldc 'securityphone'
            //   706: aload #9
            //   708: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
            //   711: aload_0
            //   712: getfield b : Lcom/cmic/sso/sdk/auth/b;
            //   715: ldc '103000'
            //   717: ldc '显示登录取号成功'
            //   719: aload_0
            //   720: getfield a : Landroid/os/Bundle;
            //   723: aconst_null
            //   724: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)V
            //   729: goto -> 182
            //   732: aload_0
            //   733: getfield e : Lcom/cmic/sso/sdk/auth/a;
            //   736: aload_0
            //   737: getfield a : Landroid/os/Bundle;
            //   740: aload_0
            //   741: getfield b : Lcom/cmic/sso/sdk/auth/b;
            //   744: invokevirtual a : (Landroid/os/Bundle;Lcom/cmic/sso/sdk/auth/b;)V
            //   747: goto -> 182
            //   750: aload_0
            //   751: getfield c : I
            //   754: iconst_3
            //   755: if_icmpne -> 819
            //   758: invokestatic a : ()Ljava/lang/String;
            //   761: ldc '2'
            //   763: invokevirtual contains : (Ljava/lang/CharSequence;)Z
            //   766: ifeq -> 819
            //   769: aload_0
            //   770: getfield d : Ljava/lang/String;
            //   773: ldc '2'
            //   775: invokevirtual contains : (Ljava/lang/CharSequence;)Z
            //   778: ifeq -> 819
            //   781: ldc 'AuthBusiness'
            //   783: ldc '取号失败， 跳到短信验证码登录'
            //   785: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
            //   788: aload_0
            //   789: getfield a : Landroid/os/Bundle;
            //   792: ldc 'transCode'
            //   794: aload_1
            //   795: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   798: aload_0
            //   799: getfield b : Lcom/cmic/sso/sdk/auth/b;
            //   802: ldc '200012'
            //   804: ldc '取号失败，跳到短信验证码登录'
            //   806: aload_0
            //   807: getfield a : Landroid/os/Bundle;
            //   810: aconst_null
            //   811: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)V
            //   816: goto -> 182
            //   819: aload_0
            //   820: getfield b : Lcom/cmic/sso/sdk/auth/b;
            //   823: aload_1
            //   824: aload_2
            //   825: aload_0
            //   826: getfield a : Landroid/os/Bundle;
            //   829: aload_3
            //   830: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)V
            //   835: goto -> 182
            //   838: astore #10
            //   840: aconst_null
            //   841: astore_2
            //   842: aload #9
            //   844: astore_1
            //   845: aload #4
            //   847: astore #9
            //   849: aload_3
            //   850: astore #4
            //   852: aload #10
            //   854: astore_3
            //   855: goto -> 666
            //   858: astore #10
            //   860: aload #9
            //   862: astore_1
            //   863: aload #4
            //   865: astore #9
            //   867: aload_3
            //   868: astore #4
            //   870: aload #10
            //   872: astore_3
            //   873: goto -> 666
            //   876: astore #10
            //   878: aload #4
            //   880: astore #9
            //   882: aload_3
            //   883: astore #4
            //   885: aload #10
            //   887: astore_3
            //   888: goto -> 666
            //   891: aload #9
            //   893: astore_1
            //   894: goto -> 381
            // Exception table:
            //   from	to	target	type
            //   232	237	647	org/json/JSONException
            //   243	249	647	org/json/JSONException
            //   255	263	647	org/json/JSONException
            //   268	297	647	org/json/JSONException
            //   302	311	647	org/json/JSONException
            //   316	330	647	org/json/JSONException
            //   335	344	647	org/json/JSONException
            //   344	352	838	org/json/JSONException
            //   352	381	858	org/json/JSONException
            //   381	419	876	org/json/JSONException
            //   590	608	676	org/json/JSONException
          }
        });
  }
  
  public void a(Bundle paramBundle, b paramb) {
    r.a(this.b, "tokentimes", System.currentTimeMillis());
    h.c("AuthBusiness", "获取平台token》》》》");
    n.a(this.b, true);
    if (paramBundle.getInt("logintype") == 1)
      paramBundle.putString("userCapaid", "200"); 
    this.a.c(paramBundle, new b(this, paramBundle, paramb) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {
            h.c("AuthBusiness", "获取平台token 》》》》" + param1JSONObject.toString());
            String str = this.a.getString("interfacecode", "");
            this.a.putString("interfacecode", str + param1String1 + ";");
            if (param1String1.equals("103000")) {
              long l1 = param1JSONObject.optLong("phonescripED");
              str = param1JSONObject.optString("phonescrip");
              this.a.putString("phonescrip", str);
              n.a(a.a(this.c), str, l1, this.a.getString("imsi", ""));
              str = param1JSONObject.optString("openId");
              this.a.putString("openId", str);
            } 
            long l = System.currentTimeMillis() - r.b(a.a(this.c), "tokentimes", 0L);
            r.a(a.a(this.c), "tokenbetweentimes", l);
            str = this.a.getString("interfaceelasped", "");
            this.a.putString("interfaceelasped", str + l + ";");
            this.b.a(param1String1, param1String2, this.a, param1JSONObject);
          }
        });
  }
  
  public void a(Bundle paramBundle, String paramString, b paramb, boolean paramBoolean) {
    h.c("AuthBusiness", "进行取号查询》》》》authtype=" + paramString);
    new f(this.b);
    String str1 = this.b.getPackageName();
    String str2 = c.a(s.a(this.b, str1));
    paramBundle.putString("apppackage", str1);
    paramBundle.putString("appsign", str2);
    str1 = UUID.randomUUID().toString().substring(0, 16);
    paramBundle.putString(com.cmic.sso.sdk.a.a.a, str1);
    int i = w.b(this.b);
    paramBundle.putInt("networkType", i);
    if (!paramBoolean) {
      if (b.a().contains("3") && paramString.contains("3") && (i == 1 || i == 3)) {
        paramBundle.putString("authtype", "3");
      } else {
        if (paramBundle.getInt("logintype") == 1) {
          if (b.a().contains("2") && paramString.contains("2")) {
            h.a("AuthBusiness", "不支持的登录类型， 跳到短信验证码登录");
            paramb.a("200007", "不支持的认证方式 跳到短信验证码登录", paramBundle, null);
            return;
          } 
          h.a("AuthBusiness", "不支持的登录类型,没有短信验证码登录功能");
          paramb.a("200008", "不支持的认证方式 没有短信验证码登录功能", paramBundle, null);
          return;
        } 
        paramb.a("200010", "不支持的认证方式", paramBundle, null);
        return;
      } 
    } else {
      paramBundle.putString("authtype", "3");
    } 
    paramBundle.putString("operatorType", w.a(this.b) + "");
    a(paramBundle, paramString, 3, paramb);
  }
  
  public void a(String paramString, Bundle paramBundle, b paramb) {
    int i = paramBundle.getInt("logintype", 0);
    if (paramBundle.getBoolean("isCacheScrip", false)) {
      if (i == 3) {
        JSONObject jSONObject = new JSONObject();
        try {
          jSONObject.put("resultCode", "103000");
          jSONObject.put("desc", "true");
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        paramb.a("103000", "true", paramBundle, jSONObject);
        return;
      } 
      paramString = n.a(this.b);
      paramBundle.putString("sourceid", r.b(this.b, "sourceid", ""));
      paramBundle.putString("phonescrip", paramString);
      if (1 == i) {
        paramBundle.putString("securityphone", r.b(this.b, "securityphone", ""));
        paramb.a("103000", "显示登录取号成功", paramBundle, null);
        return;
      } 
      a(paramBundle, paramb);
      return;
    } 
    a(paramBundle, paramString, paramb, false);
  }
  
  public void b(Bundle paramBundle, b paramb) {
    r.a(this.b, "authrequesttimes", System.currentTimeMillis());
    this.a.b(paramBundle, new b(this, paramBundle, paramb) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {
            String str = this.a.getString("interfacecode", "");
            this.a.putString("interfacecode", str + param1String1 + ";");
            long l = System.currentTimeMillis() - r.b(a.a(this.c), "authrequesttimes", 0L);
            r.a(a.a(this.c), "tokenbetweentimes", l);
            str = this.a.getString("interfaceelasped", "");
            this.a.putString("interfaceelasped", str + l + ";");
            if ("103000".equals(param1String1)) {
              param1String1 = param1JSONObject.optString("pcid", "");
              param1String2 = param1JSONObject.optString("phonescrip", null);
              this.a.putString("phonescrip", param1String2);
              this.a.putString("openId", param1String1);
              this.a.putString("userCapaid", "200");
              this.c.a(this.a, this.b);
              return;
            } 
            this.b.a(param1String1, param1String2, this.a, param1JSONObject);
          }
        });
  }
  
  public void b(String paramString, Bundle paramBundle, b paramb) {
    h.c("AuthBusiness", "进行获取应用信息查询》》》》");
    paramBundle.putString("keyid", q.a(this.b).c() + ac.a());
    String str1 = this.b.getPackageName();
    String str2 = c.a(s.a(this.b, str1));
    paramBundle.putString("apppackage", str1);
    paramBundle.putString("appsign", str2);
    r.a(this.b, "authrequesttimes", System.currentTimeMillis());
    this.a.a(paramBundle, new b(this, paramBundle, paramString, paramb) {
          public void a(String param1String1, String param1String2, JSONObject param1JSONObject) {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Landroid/os/Bundle;
            //   4: ldc 'interfacecode'
            //   6: ldc ''
            //   8: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   11: astore #4
            //   13: aload_0
            //   14: getfield a : Landroid/os/Bundle;
            //   17: ldc 'interfacecode'
            //   19: new java/lang/StringBuilder
            //   22: dup
            //   23: invokespecial <init> : ()V
            //   26: aload #4
            //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   31: aload_1
            //   32: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   35: ldc ';'
            //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   40: invokevirtual toString : ()Ljava/lang/String;
            //   43: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   46: invokestatic currentTimeMillis : ()J
            //   49: aload_0
            //   50: getfield d : Lcom/cmic/sso/sdk/auth/a;
            //   53: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   56: ldc 'authrequesttimes'
            //   58: lconst_0
            //   59: invokestatic b : (Landroid/content/Context;Ljava/lang/String;J)J
            //   62: lsub
            //   63: lstore #5
            //   65: aload_0
            //   66: getfield d : Lcom/cmic/sso/sdk/auth/a;
            //   69: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   72: ldc 'tokenbetweentimes'
            //   74: lload #5
            //   76: invokestatic a : (Landroid/content/Context;Ljava/lang/String;J)V
            //   79: aload_0
            //   80: getfield a : Landroid/os/Bundle;
            //   83: ldc 'interfaceelasped'
            //   85: ldc ''
            //   87: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   90: astore #4
            //   92: aload_0
            //   93: getfield a : Landroid/os/Bundle;
            //   96: ldc 'interfaceelasped'
            //   98: new java/lang/StringBuilder
            //   101: dup
            //   102: invokespecial <init> : ()V
            //   105: aload #4
            //   107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   110: lload #5
            //   112: invokevirtual append : (J)Ljava/lang/StringBuilder;
            //   115: ldc ';'
            //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   120: invokevirtual toString : ()Ljava/lang/String;
            //   123: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   126: ldc '103000'
            //   128: aload_1
            //   129: invokevirtual equals : (Ljava/lang/Object;)Z
            //   132: ifeq -> 486
            //   135: aload_3
            //   136: ldc 'CTCC'
            //   138: invokevirtual has : (Ljava/lang/String;)Z
            //   141: ifeq -> 209
            //   144: aload_3
            //   145: ldc 'CTCC'
            //   147: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
            //   150: astore #7
            //   152: new org/json/JSONObject
            //   155: astore #4
            //   157: aload #4
            //   159: aload #7
            //   161: invokespecial <init> : (Ljava/lang/String;)V
            //   164: ldc '1'
            //   166: aload #4
            //   168: ldc 'wap'
            //   170: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   173: invokevirtual equals : (Ljava/lang/Object;)Z
            //   176: putstatic com/cmic/sso/sdk/b.g : Z
            //   179: ldc '1'
            //   181: aload #4
            //   183: ldc 'sms'
            //   185: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   188: invokevirtual equals : (Ljava/lang/Object;)Z
            //   191: putstatic com/cmic/sso/sdk/b.h : Z
            //   194: ldc '1'
            //   196: aload #4
            //   198: ldc 'upSms'
            //   200: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   203: invokevirtual equals : (Ljava/lang/Object;)Z
            //   206: putstatic com/cmic/sso/sdk/b.i : Z
            //   209: aload_3
            //   210: ldc 'CMCC'
            //   212: invokevirtual has : (Ljava/lang/String;)Z
            //   215: ifeq -> 283
            //   218: aload_3
            //   219: ldc 'CMCC'
            //   221: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
            //   224: astore #7
            //   226: new org/json/JSONObject
            //   229: astore #4
            //   231: aload #4
            //   233: aload #7
            //   235: invokespecial <init> : (Ljava/lang/String;)V
            //   238: ldc '1'
            //   240: aload #4
            //   242: ldc 'wap'
            //   244: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   247: invokevirtual equals : (Ljava/lang/Object;)Z
            //   250: putstatic com/cmic/sso/sdk/b.a : Z
            //   253: ldc '1'
            //   255: aload #4
            //   257: ldc 'sms'
            //   259: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   262: invokevirtual equals : (Ljava/lang/Object;)Z
            //   265: putstatic com/cmic/sso/sdk/b.b : Z
            //   268: ldc '1'
            //   270: aload #4
            //   272: ldc 'upSms'
            //   274: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   277: invokevirtual equals : (Ljava/lang/Object;)Z
            //   280: putstatic com/cmic/sso/sdk/b.c : Z
            //   283: aload_3
            //   284: ldc 'CUCC'
            //   286: invokevirtual has : (Ljava/lang/String;)Z
            //   289: ifeq -> 357
            //   292: aload_3
            //   293: ldc 'CUCC'
            //   295: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
            //   298: astore #4
            //   300: new org/json/JSONObject
            //   303: astore #7
            //   305: aload #7
            //   307: aload #4
            //   309: invokespecial <init> : (Ljava/lang/String;)V
            //   312: ldc '1'
            //   314: aload #7
            //   316: ldc 'wap'
            //   318: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   321: invokevirtual equals : (Ljava/lang/Object;)Z
            //   324: putstatic com/cmic/sso/sdk/b.d : Z
            //   327: ldc '1'
            //   329: aload #7
            //   331: ldc 'sms'
            //   333: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   336: invokevirtual equals : (Ljava/lang/Object;)Z
            //   339: putstatic com/cmic/sso/sdk/b.e : Z
            //   342: ldc '1'
            //   344: aload #7
            //   346: ldc 'upSms'
            //   348: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   351: invokevirtual equals : (Ljava/lang/Object;)Z
            //   354: putstatic com/cmic/sso/sdk/b.f : Z
            //   357: aload_3
            //   358: ldc 'capaids'
            //   360: ldc 'acd'
            //   362: invokevirtual optString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
            //   365: astore #7
            //   367: aload_3
            //   368: ldc 'privateKey'
            //   370: invokevirtual optString : (Ljava/lang/String;)Ljava/lang/String;
            //   373: astore #4
            //   375: aload_0
            //   376: getfield a : Landroid/os/Bundle;
            //   379: ldc 'privateKey'
            //   381: aload #4
            //   383: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   386: aload_0
            //   387: getfield a : Landroid/os/Bundle;
            //   390: ldc 'capaids'
            //   392: aload #7
            //   394: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   397: aload_0
            //   398: getfield d : Lcom/cmic/sso/sdk/auth/a;
            //   401: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   404: ldc 'allcapaids'
            //   406: aload #7
            //   408: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
            //   411: aload_0
            //   412: getfield d : Lcom/cmic/sso/sdk/auth/a;
            //   415: invokestatic a : (Lcom/cmic/sso/sdk/auth/a;)Landroid/content/Context;
            //   418: ldc 'validated'
            //   420: iconst_1
            //   421: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Z)V
            //   424: aload_0
            //   425: getfield b : Ljava/lang/String;
            //   428: ldc '2'
            //   430: invokevirtual equals : (Ljava/lang/Object;)Z
            //   433: ifeq -> 463
            //   436: aload_0
            //   437: getfield c : Lcom/cmic/sso/sdk/auth/b;
            //   440: aload_1
            //   441: aload_2
            //   442: aload_0
            //   443: getfield a : Landroid/os/Bundle;
            //   446: aload_3
            //   447: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)V
            //   452: return
            //   453: astore #4
            //   455: aload #4
            //   457: invokevirtual printStackTrace : ()V
            //   460: goto -> 357
            //   463: aload_0
            //   464: getfield d : Lcom/cmic/sso/sdk/auth/a;
            //   467: aload_0
            //   468: getfield a : Landroid/os/Bundle;
            //   471: aload_0
            //   472: getfield b : Ljava/lang/String;
            //   475: aload_0
            //   476: getfield c : Lcom/cmic/sso/sdk/auth/b;
            //   479: iconst_0
            //   480: invokevirtual a : (Landroid/os/Bundle;Ljava/lang/String;Lcom/cmic/sso/sdk/auth/b;Z)V
            //   483: goto -> 452
            //   486: invokestatic a : ()Ljava/lang/String;
            //   489: ldc '3'
            //   491: invokevirtual contains : (Ljava/lang/CharSequence;)Z
            //   494: ifeq -> 520
            //   497: aload_0
            //   498: getfield b : Ljava/lang/String;
            //   501: ldc '3'
            //   503: invokevirtual contains : (Ljava/lang/CharSequence;)Z
            //   506: ifeq -> 520
            //   509: aload_0
            //   510: getfield a : Landroid/os/Bundle;
            //   513: ldc 'authtype'
            //   515: ldc '3'
            //   517: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
            //   520: aload_0
            //   521: getfield c : Lcom/cmic/sso/sdk/auth/b;
            //   524: aload_1
            //   525: aload_2
            //   526: aload_0
            //   527: getfield a : Landroid/os/Bundle;
            //   530: aload_3
            //   531: invokeinterface a : (Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lorg/json/JSONObject;)V
            //   536: goto -> 452
            // Exception table:
            //   from	to	target	type
            //   135	209	453	java/lang/Throwable
            //   209	283	453	java/lang/Throwable
            //   283	357	453	java/lang/Throwable
          }
        });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\auth\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */