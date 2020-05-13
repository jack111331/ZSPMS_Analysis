package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.a;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.mobile.android.utils.q;
import com.unionpay.mobile.android.utils.r;
import com.unionpay.sdk.UPAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l extends b implements r.a {
  private String A = null;
  
  private int B = 0;
  
  private volatile int C = 0;
  
  private boolean D = false;
  
  private boolean E = false;
  
  private JSONArray F;
  
  private e G;
  
  private long H;
  
  private Activity I;
  
  private boolean J;
  
  private boolean K = false;
  
  public List<c> r = null;
  
  public List<c> s = null;
  
  int t = 0;
  
  String u = "";
  
  String v = "";
  
  String w = "";
  
  int x = 500;
  
  int y = 5;
  
  private ProgressBar z = null;
  
  public l(Context paramContext) {
    super(paramContext);
    d();
    this.I = (Activity)paramContext;
    Intent intent = this.I.getIntent();
    try {
      this.J = a.a(intent, this.a);
    } catch (Exception exception) {
      this.J = false;
    } 
    if (this.a.aM) {
      setVisibility(8);
      this.b.a(c.bD.c);
    } 
    u();
  }
  
  private final boolean D() {
    boolean bool2;
    boolean bool1 = false;
    try {
      String str;
      if (this.F != null) {
        str = this.F.getString(3);
      } else {
        str = null;
      } 
      bool2 = bool1;
      if (str != null) {
        bool2 = bool1;
        if (str.length() > 0) {
          boolean bool = "null".equalsIgnoreCase(str);
          bool2 = bool1;
          if (!bool)
            bool2 = true; 
        } 
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      bool2 = bool1;
    } 
    return bool2;
  }
  
  private final void E() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: new java/lang/StringBuilder
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 'showContentView() +++'
    //   11: invokespecial <init> : (Ljava/lang/String;)V
    //   14: ldc 'uppay'
    //   16: aload_2
    //   17: aload_0
    //   18: getfield C : I
    //   21: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   24: invokevirtual toString : ()Ljava/lang/String;
    //   27: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   30: pop
    //   31: aload_0
    //   32: getfield C : I
    //   35: iconst_2
    //   36: if_icmpeq -> 150
    //   39: aload_0
    //   40: getfield E : Z
    //   43: ifne -> 145
    //   46: iconst_1
    //   47: istore_3
    //   48: iload_1
    //   49: istore #4
    //   51: aload_0
    //   52: getfield E : Z
    //   55: ifeq -> 133
    //   58: iload_1
    //   59: istore #4
    //   61: ldc '1'
    //   63: aload_0
    //   64: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   67: getfield an : Ljava/lang/String;
    //   70: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   73: ifne -> 133
    //   76: aload_0
    //   77: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   80: getfield ao : I
    //   83: istore #5
    //   85: aload_0
    //   86: iload #5
    //   88: invokespecial f : (I)Z
    //   91: ifeq -> 1108
    //   94: iload #5
    //   96: ldc 69889
    //   98: iand
    //   99: ifne -> 1108
    //   102: iconst_1
    //   103: istore #5
    //   105: iload_1
    //   106: istore #4
    //   108: iload #5
    //   110: ifne -> 133
    //   113: aload_0
    //   114: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   117: getfield aD : Z
    //   120: istore #6
    //   122: iload_1
    //   123: istore #4
    //   125: iload #6
    //   127: ifne -> 133
    //   130: iconst_1
    //   131: istore #4
    //   133: iload_3
    //   134: ifne -> 142
    //   137: iload #4
    //   139: ifeq -> 150
    //   142: aload_0
    //   143: monitorexit
    //   144: return
    //   145: iconst_0
    //   146: istore_3
    //   147: goto -> 48
    //   150: aload_0
    //   151: getfield D : Z
    //   154: ifne -> 142
    //   157: aload_0
    //   158: iconst_1
    //   159: putfield D : Z
    //   162: aload_0
    //   163: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   166: getfield aM : Z
    //   169: ifeq -> 179
    //   172: aload_0
    //   173: getfield b : Lcom/unionpay/mobile/android/widgets/m;
    //   176: invokevirtual c : ()V
    //   179: aload_0
    //   180: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   183: getfield ao : I
    //   186: istore_3
    //   187: ldc '1'
    //   189: aload_0
    //   190: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   193: getfield an : Ljava/lang/String;
    //   196: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   199: ifeq -> 303
    //   202: aload_0
    //   203: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   206: getfield aC : Z
    //   209: ifeq -> 289
    //   212: aload_0
    //   213: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   216: aconst_null
    //   217: putfield q : Ljava/util/List;
    //   220: ldc '0'
    //   222: aload_0
    //   223: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   226: getfield an : Ljava/lang/String;
    //   229: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   232: ifeq -> 601
    //   235: aload_0
    //   236: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   239: getfield q : Ljava/util/List;
    //   242: ifnull -> 260
    //   245: aload_0
    //   246: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   249: getfield q : Ljava/util/List;
    //   252: invokeinterface size : ()I
    //   257: ifgt -> 601
    //   260: aload_0
    //   261: iload_3
    //   262: invokespecial f : (I)Z
    //   265: ifne -> 601
    //   268: aload_0
    //   269: aload_0
    //   270: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   273: getfield ap : Ljava/lang/String;
    //   276: ldc 'fail'
    //   278: invokespecial c : (Ljava/lang/String;Ljava/lang/String;)V
    //   281: goto -> 142
    //   284: astore_2
    //   285: aload_0
    //   286: monitorexit
    //   287: aload_2
    //   288: athrow
    //   289: aload_0
    //   290: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   293: aload_0
    //   294: getfield r : Ljava/util/List;
    //   297: putfield q : Ljava/util/List;
    //   300: goto -> 220
    //   303: getstatic com/unionpay/mobile/android/model/b.aA : Z
    //   306: ifeq -> 386
    //   309: getstatic com/unionpay/mobile/android/model/b.aB : Z
    //   312: ifeq -> 386
    //   315: getstatic com/unionpay/mobile/android/model/b.bn : Z
    //   318: ifne -> 386
    //   321: aload_0
    //   322: getfield s : Ljava/util/List;
    //   325: ifnull -> 386
    //   328: aload_0
    //   329: getfield s : Ljava/util/List;
    //   332: invokeinterface size : ()I
    //   337: ifle -> 386
    //   340: aload_0
    //   341: getfield s : Ljava/util/List;
    //   344: invokeinterface iterator : ()Ljava/util/Iterator;
    //   349: astore_2
    //   350: aload_2
    //   351: invokeinterface hasNext : ()Z
    //   356: ifeq -> 386
    //   359: aload_2
    //   360: invokeinterface next : ()Ljava/lang/Object;
    //   365: checkcast com/unionpay/mobile/android/model/c
    //   368: invokeinterface c : ()I
    //   373: iconst_1
    //   374: if_icmpne -> 350
    //   377: aload_2
    //   378: invokeinterface remove : ()V
    //   383: goto -> 350
    //   386: ldc '0'
    //   388: aload_0
    //   389: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   392: getfield an : Ljava/lang/String;
    //   395: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   398: ifeq -> 502
    //   401: aload_0
    //   402: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   405: aload_0
    //   406: getfield s : Ljava/util/List;
    //   409: putfield q : Ljava/util/List;
    //   412: aload_0
    //   413: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   416: getfield q : Ljava/util/List;
    //   419: ifnull -> 220
    //   422: aload_0
    //   423: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   426: getfield q : Ljava/util/List;
    //   429: invokeinterface size : ()I
    //   434: ifle -> 220
    //   437: aload_0
    //   438: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   441: getfield q : Ljava/util/List;
    //   444: invokeinterface iterator : ()Ljava/util/Iterator;
    //   449: astore #7
    //   451: aload #7
    //   453: invokeinterface hasNext : ()Z
    //   458: ifeq -> 220
    //   461: aload #7
    //   463: invokeinterface next : ()Ljava/lang/Object;
    //   468: checkcast com/unionpay/mobile/android/model/c
    //   471: astore_2
    //   472: aload_2
    //   473: invokeinterface c : ()I
    //   478: ifeq -> 451
    //   481: aload_2
    //   482: invokeinterface c : ()I
    //   487: iload_3
    //   488: iand
    //   489: ifne -> 451
    //   492: aload #7
    //   494: invokeinterface remove : ()V
    //   499: goto -> 451
    //   502: aload_0
    //   503: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   506: getfield aC : Z
    //   509: ifeq -> 526
    //   512: aload_0
    //   513: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   516: aload_0
    //   517: getfield s : Ljava/util/List;
    //   520: putfield q : Ljava/util/List;
    //   523: goto -> 412
    //   526: aload_0
    //   527: getfield s : Ljava/util/List;
    //   530: ifnull -> 562
    //   533: aload_0
    //   534: getfield s : Ljava/util/List;
    //   537: invokeinterface size : ()I
    //   542: ifle -> 562
    //   545: aload_0
    //   546: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   549: getfield q : Ljava/util/List;
    //   552: aload_0
    //   553: getfield s : Ljava/util/List;
    //   556: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   561: pop
    //   562: aload_0
    //   563: getfield r : Ljava/util/List;
    //   566: ifnull -> 412
    //   569: aload_0
    //   570: getfield r : Ljava/util/List;
    //   573: invokeinterface size : ()I
    //   578: ifle -> 412
    //   581: aload_0
    //   582: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   585: getfield q : Ljava/util/List;
    //   588: aload_0
    //   589: getfield r : Ljava/util/List;
    //   592: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   597: pop
    //   598: goto -> 412
    //   601: ldc '1'
    //   603: aload_0
    //   604: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   607: getfield an : Ljava/lang/String;
    //   610: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   613: istore #6
    //   615: iload #6
    //   617: ifne -> 812
    //   620: aload_0
    //   621: getfield F : Lorg/json/JSONArray;
    //   624: ifnull -> 852
    //   627: aload_0
    //   628: getfield F : Lorg/json/JSONArray;
    //   631: iconst_0
    //   632: invokevirtual getString : (I)Ljava/lang/String;
    //   635: astore #7
    //   637: aload_0
    //   638: getfield F : Lorg/json/JSONArray;
    //   641: ifnull -> 863
    //   644: aload_0
    //   645: getfield F : Lorg/json/JSONArray;
    //   648: iconst_1
    //   649: invokevirtual getString : (I)Ljava/lang/String;
    //   652: astore #8
    //   654: aload_0
    //   655: getfield F : Lorg/json/JSONArray;
    //   658: ifnull -> 874
    //   661: aload_0
    //   662: getfield F : Lorg/json/JSONArray;
    //   665: iconst_2
    //   666: invokevirtual getString : (I)Ljava/lang/String;
    //   669: astore #9
    //   671: aload_0
    //   672: invokespecial D : ()Z
    //   675: ifeq -> 885
    //   678: aload_0
    //   679: getfield F : Lorg/json/JSONArray;
    //   682: iconst_3
    //   683: invokevirtual getString : (I)Ljava/lang/String;
    //   686: astore #10
    //   688: aload_0
    //   689: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   692: getfield q : Ljava/util/List;
    //   695: ifnull -> 812
    //   698: aload_0
    //   699: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   702: getfield q : Ljava/util/List;
    //   705: invokeinterface iterator : ()Ljava/util/Iterator;
    //   710: astore #11
    //   712: aload #11
    //   714: invokeinterface hasNext : ()Z
    //   719: ifeq -> 812
    //   722: aload #11
    //   724: invokeinterface next : ()Ljava/lang/Object;
    //   729: checkcast com/unionpay/mobile/android/model/c
    //   732: astore #12
    //   734: aload #12
    //   736: invokeinterface c : ()I
    //   741: ifeq -> 712
    //   744: ldc ''
    //   746: astore_2
    //   747: aload #12
    //   749: invokeinterface c : ()I
    //   754: lookupswitch default -> 796, 1 -> 914, 4 -> 908, 8 -> 902, 16 -> 896
    //   796: aload #12
    //   798: aload_2
    //   799: invokeinterface a : (Ljava/lang/String;)V
    //   804: goto -> 712
    //   807: astore_2
    //   808: aload_2
    //   809: invokevirtual printStackTrace : ()V
    //   812: getstatic com/unionpay/mobile/android/model/b.bn : Z
    //   815: ifne -> 830
    //   818: getstatic com/unionpay/mobile/android/model/b.aA : Z
    //   821: ifeq -> 830
    //   824: getstatic com/unionpay/mobile/android/model/b.aB : Z
    //   827: ifne -> 920
    //   830: getstatic com/unionpay/mobile/android/model/b.bm : Z
    //   833: ifeq -> 920
    //   836: aload_0
    //   837: aload_0
    //   838: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   841: getfield ap : Ljava/lang/String;
    //   844: ldc 'fail'
    //   846: invokespecial c : (Ljava/lang/String;Ljava/lang/String;)V
    //   849: goto -> 142
    //   852: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   855: getfield ak : Ljava/lang/String;
    //   858: astore #7
    //   860: goto -> 637
    //   863: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   866: getfield aj : Ljava/lang/String;
    //   869: astore #8
    //   871: goto -> 654
    //   874: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   877: getfield ai : Ljava/lang/String;
    //   880: astore #9
    //   882: goto -> 671
    //   885: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   888: getfield al : Ljava/lang/String;
    //   891: astore #10
    //   893: goto -> 688
    //   896: aload #9
    //   898: astore_2
    //   899: goto -> 796
    //   902: aload #7
    //   904: astore_2
    //   905: goto -> 796
    //   908: aload #8
    //   910: astore_2
    //   911: goto -> 796
    //   914: aload #10
    //   916: astore_2
    //   917: goto -> 796
    //   920: aload_0
    //   921: invokevirtual w : ()Z
    //   924: ifeq -> 985
    //   927: aload_0
    //   928: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   931: getfield az : Z
    //   934: ifeq -> 985
    //   937: aload_0
    //   938: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   941: getfield aC : Z
    //   944: ifne -> 985
    //   947: aload_0
    //   948: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   951: getfield aD : Z
    //   954: ifne -> 985
    //   957: aload_0
    //   958: aload_0
    //   959: getfield t : I
    //   962: aload_0
    //   963: getfield x : I
    //   966: aload_0
    //   967: getfield u : Ljava/lang/String;
    //   970: aload_0
    //   971: getfield v : Ljava/lang/String;
    //   974: aload_0
    //   975: getfield y : I
    //   978: aload_0
    //   979: getfield w : Ljava/lang/String;
    //   982: invokevirtual a : (IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   985: aload_0
    //   986: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   989: getfield ax : Z
    //   992: ifeq -> 1033
    //   995: aload_0
    //   996: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   999: getfield aD : Z
    //   1002: ifeq -> 1033
    //   1005: aload_0
    //   1006: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1009: getfield ay : Z
    //   1012: ifeq -> 1033
    //   1015: aload_0
    //   1016: bipush #17
    //   1018: invokevirtual d : (I)V
    //   1021: ldc 'uppay'
    //   1023: ldc_w 'showContentView() ---'
    //   1026: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   1029: pop
    //   1030: goto -> 142
    //   1033: aload_0
    //   1034: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1037: getfield aE : Z
    //   1040: ifeq -> 1096
    //   1043: aload_0
    //   1044: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1047: getfield az : Z
    //   1050: ifeq -> 1096
    //   1053: getstatic com/unionpay/mobile/android/model/b.bl : Z
    //   1056: ifeq -> 1096
    //   1059: getstatic com/unionpay/mobile/android/model/b.bb : Ljava/util/List;
    //   1062: ifnull -> 1076
    //   1065: getstatic com/unionpay/mobile/android/model/b.bb : Ljava/util/List;
    //   1068: invokeinterface size : ()I
    //   1073: ifgt -> 1096
    //   1076: aload_0
    //   1077: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   1080: getfield bq : Ljava/lang/String;
    //   1083: aload_0
    //   1084: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1087: getfield bh : Ljava/lang/String;
    //   1090: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)V
    //   1093: goto -> 1021
    //   1096: aload_0
    //   1097: iconst_2
    //   1098: aload_0
    //   1099: getfield G : Lcom/unionpay/mobile/android/model/e;
    //   1102: invokevirtual a : (ILcom/unionpay/mobile/android/model/e;)V
    //   1105: goto -> 1021
    //   1108: iconst_0
    //   1109: istore #5
    //   1111: goto -> 105
    // Exception table:
    //   from	to	target	type
    //   4	46	284	finally
    //   51	58	284	finally
    //   61	94	284	finally
    //   113	122	284	finally
    //   150	179	284	finally
    //   179	220	284	finally
    //   220	260	284	finally
    //   260	281	284	finally
    //   289	300	284	finally
    //   303	350	284	finally
    //   350	383	284	finally
    //   386	412	284	finally
    //   412	451	284	finally
    //   451	499	284	finally
    //   502	523	284	finally
    //   526	562	284	finally
    //   562	598	284	finally
    //   601	615	284	finally
    //   620	637	807	org/json/JSONException
    //   620	637	284	finally
    //   637	654	807	org/json/JSONException
    //   637	654	284	finally
    //   654	671	807	org/json/JSONException
    //   654	671	284	finally
    //   671	688	807	org/json/JSONException
    //   671	688	284	finally
    //   688	712	807	org/json/JSONException
    //   688	712	284	finally
    //   712	744	807	org/json/JSONException
    //   712	744	284	finally
    //   747	796	807	org/json/JSONException
    //   747	796	284	finally
    //   796	804	807	org/json/JSONException
    //   796	804	284	finally
    //   808	812	284	finally
    //   812	830	284	finally
    //   830	849	284	finally
    //   852	860	807	org/json/JSONException
    //   852	860	284	finally
    //   863	871	807	org/json/JSONException
    //   863	871	284	finally
    //   874	882	807	org/json/JSONException
    //   874	882	284	finally
    //   885	893	807	org/json/JSONException
    //   885	893	284	finally
    //   920	985	284	finally
    //   985	1021	284	finally
    //   1021	1030	284	finally
    //   1033	1076	284	finally
    //   1076	1093	284	finally
    //   1096	1105	284	finally
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    boolean bool;
    m m = new m(this, paramString3);
    n n = new n(this);
    if (paramString1.equalsIgnoreCase("01")) {
      bool = false;
    } else {
      bool = true;
    } 
    if (bool) {
      this.b.a(m, n);
      this.b.a(c.bD.ae, paramString2, c.bD.af, c.bD.ag);
      return;
    } 
    this.b.a(m, n);
    this.b.a(c.bD.Y, paramString2, c.bD.af, c.bD.ag);
  }
  
  private void b(int paramInt, String paramString) {
    if (paramString != null && paramString.length() > 0)
      this.a.I.f = paramString; 
    this.z.setVisibility(4);
    a(c(paramInt), true);
  }
  
  private void c(String paramString1, String paramString2) {
    if (paramString2 != null && paramString2.length() > 0)
      this.a.I.f = paramString2; 
    this.z.setVisibility(4);
    a(paramString1, true);
  }
  
  private boolean f(int paramInt) {
    null = true;
    if ((paramInt & 0x2) != 0) {
      this.a.aw = true;
      return null;
    } 
    return false;
  }
  
  protected final void A() {
    this.C++;
    E();
  }
  
  public final void B() {
    removeAllViews();
    this.z = null;
  }
  
  public void C() {
    d("000");
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, String paramString3) {}
  
  public final void a(int paramInt, byte[] paramArrayOfbyte) {
    j();
    if (paramInt != 0)
      b(paramInt, (String)null); 
    k.a("uppay", "status = " + paramInt);
    if (paramArrayOfbyte != null) {
      paramInt = 0;
      if ("mounted".equals(Environment.getExternalStorageState()))
        paramInt = 1; 
      if (paramInt == 0) {
        b(9, (String)null);
        return;
      } 
    } else {
      return;
    } 
    if (q.a(paramArrayOfbyte) == true) {
      Intent intent = new Intent();
      intent.setAction("android.intent.action.VIEW");
      String str = Environment.getExternalStorageDirectory() + File.separator + "UPPay" + File.separator + "UPPayPluginEx.apk";
      k.a("uppay", "apk path:" + str);
      intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
      ((BaseActivity)this.d).startActivityForResult(intent, 100);
      return;
    } 
    b(21, (String)null);
  }
  
  public final void a(JSONObject paramJSONObject) {
    String str1;
    String str3;
    JSONObject jSONObject;
    String str4;
    String str5;
    k.a("uppay", "init.parserParamJsonObj() +++");
    if (paramJSONObject == null) {
      b(2);
      return;
    } 
    switch (this.B) {
      default:
        k.a("uppay", "init.parserParamJsonObj() ---");
        return;
      case 1:
        str3 = j.a(paramJSONObject, "secret");
        j.a(paramJSONObject, "sec_sign");
        this.e.e(str3);
        str3 = j.a(paramJSONObject, "talking_data_flag");
        if (!TextUtils.isEmpty(str3))
          a.L = "0".equals(str3); 
        str4 = j.a(paramJSONObject, "mer_id");
        str3 = "002";
        if (!TextUtils.isEmpty(str4))
          str3 = str4; 
        if (!this.a.I.d)
          str3 = "001"; 
        if (a.L) {
          UPAgent.init(this.d, this.e.b(this.a.I.c), str3);
          UPAgent.setReportUncaughtExceptions(true);
          UPAgent.setAdditionalVersionNameAndCode(c.bD.a, 57L);
        } 
        a(this.d, "tn", p.a, (Object[])new String[] { this.a.b });
        a(this.d, "merch_id", p.b, (Object[])new String[] { str4 });
        a(this.d, "MID_" + str4);
        a(this.d, "package_version", p.c, (Object[])new String[] { c.bD.a });
        jSONObject = j.c(paramJSONObject, "upgrade_info");
        this.A = j.a(jSONObject, "type");
        str4 = j.a(jSONObject, "desc");
        str5 = j.a(jSONObject, "url");
        if (this.A.equalsIgnoreCase("02")) {
          a(this.A, str4, str5);
        } else {
          this.a.o = j.a(paramJSONObject, "title");
          this.a.j = j.c(paramJSONObject, "init_button");
          this.a.h = j.d(paramJSONObject, "order");
          HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
          int j;
          for (j = 0; j < this.a.h.length(); j++) {
            Object object = j.b(this.a.h, j);
            if (object != null) {
              object = object;
              hashMap.put(j.a((JSONObject)object, "label"), j.a((JSONObject)object, "value"));
            } 
          } 
          a(this.d, "basic_info", p.d, (Object[])new String[] { hashMap.toString() });
          this.a.i = j.c(paramJSONObject, "risk_info");
          List<JSONArray> list = j.e(paramJSONObject, "cards");
          if (list != null && list.size() > 0)
            this.r = new ArrayList<c>(list.size()); 
          for (j = 0; list != null && j < list.size(); j++) {
            a a1 = new a(j.a(list.get(j), 0), j.a(list.get(j), 1), j.a(list.get(j), 2), (byte)0);
            this.r.add(a1);
          } 
          this.a.s = j.a(paramJSONObject, "bank_url");
          this.a.t = j.d(paramJSONObject, "input_info");
          this.a.v = j.c(paramJSONObject, "account_info");
          this.a.w = j.c(paramJSONObject, "other_card_info");
          this.a.u = j.a(paramJSONObject, "user_id");
          this.e.c(j.a(paramJSONObject, "sid"));
          this.e.d(j.a(paramJSONObject, "secret"));
          String str = j.a(paramJSONObject, "sid");
          if (!TextUtils.isEmpty(str))
            this.a.k = this.e.i(c.b(str)); 
          str = j.a(paramJSONObject, "secret");
          if (!TextUtils.isEmpty(str)) {
            this.a.l = this.e.i(c.b(str));
            this.a.m = str;
          } 
          str = j.a(paramJSONObject, "uid");
          if (str != null && !TextUtils.isEmpty(str))
            PreferenceUtils.b(this.d, str); 
          if (x()) {
            if (w()) {
              this.a.x = j.c(paramJSONObject, "kalefu_info");
              this.a.y = j.a(paramJSONObject, "kalefu_button_label");
              if ((this.a.y == null || this.a.y.length() <= 0) && c.bD != null)
                this.a.y = c.bD.am; 
            } 
            this.F = j.d(paramJSONObject, "cards_desc");
            this.a.an = j.a(paramJSONObject, "trade_privilege");
            this.a.ap = j.a(paramJSONObject, "upcard_msg");
            this.a.ao = 0;
            str = j.a(paramJSONObject, "upcard_support_type");
            if (!"1".equalsIgnoreCase(this.a.an) && str != null && str.length() > 0)
              this.a.ao = Integer.parseInt(str, 2); 
            f(this.a.ao);
          } 
          this.a.ar = j.a(paramJSONObject, "ad");
          this.a.at = j.a(paramJSONObject, "pay_tip");
          str = j.a(paramJSONObject, "sup_pay_method");
          if (!TextUtils.isEmpty(str)) {
            this.a.aC = "01".equals(str);
            this.a.aD = "001".equals(str);
          } 
          str = j.a(paramJSONObject, "default_pay_type");
          if (!TextUtils.isEmpty(str))
            this.a.aE = "0501".equals(str); 
          this.a.au = j.c(paramJSONObject, "find_pwd_url");
          this.a.Y = j.c(paramJSONObject, "reg_url");
          this.a.ay = "1".equals(j.a(paramJSONObject, "sup_nfc"));
          this.a.az = "1".equals(j.a(paramJSONObject, "sup_hce"));
          b.aA = "1".equals(j.a(paramJSONObject, "sup_samsung_pay"));
          this.a.bh = j.a(paramJSONObject, "hce_introduction_url");
          if (w() && this.a.ay && !this.a.aC) {
            str = j.a(paramJSONObject, "nfc_title");
            if (!TextUtils.isEmpty(str))
              c.bD.bo = str; 
            JSONObject jSONObject2 = j.c(paramJSONObject, "nfc_button");
            if (jSONObject2 != null) {
              String str6 = j.a(jSONObject2, "label");
              if (str6 != null && !TextUtils.isEmpty(str6))
                c.bD.bp = str6; 
            } 
          } 
          if (w() && this.a.az && !this.a.aC && !this.a.aD) {
            str = j.a(paramJSONObject, "hce_title");
            this.t = j.b(paramJSONObject, "hce_page_size");
            JSONObject jSONObject2 = j.c(paramJSONObject, "hce_button");
            String str6 = j.a(jSONObject2, "label");
            String str7 = j.a(jSONObject2, "htmlLabel");
            if (!TextUtils.isEmpty(str)) {
              c.bD.bq = str;
            } else {
              c.bD.bq = str6;
            } 
            if (!TextUtils.isEmpty(str7)) {
              c.bD.br = str7;
            } else {
              c.bD.br = str6;
            } 
            this.u = j.a(jSONObject2, "action");
            this.v = j.a(jSONObject2, "reserved");
            this.w = j.a(paramJSONObject, "iss_ins_code");
            this.x = j.b(paramJSONObject, "hce_bank_timeout");
            this.y = j.b(paramJSONObject, "hce_concurrent_count");
            j = j.b(paramJSONObject, "hce_pay_timeout");
            if (j != 0) {
              this.a.be = j;
            } else {
              this.a.be = 5000;
            } 
            this.a.bi = j.a(paramJSONObject, "no_hce_card_msg");
          } 
          b b1 = this.a;
          b1.p = new HashMap<Object, Object>();
          JSONObject jSONObject1 = j.c(paramJSONObject, "f55");
          str = j.a(jSONObject1, "order_amount");
          HashMap<String, String> hashMap2 = b1.p;
          if (str != null && str.length() > 0) {
            str1 = str;
          } else {
            str1 = "000000000000";
          } 
          hashMap2.put("trans_amt", str1);
          b1.bp = c.c(str);
          str = j.a(jSONObject1, "order_currency");
          hashMap2 = b1.p;
          if (str != null && str.length() > 0) {
            str1 = str;
          } else {
            str1 = "0156";
          } 
          hashMap2.put("trans currcy code", str1);
          b1.bq = str;
          str1 = j.a(jSONObject1, "trans_type");
          HashMap<String, String> hashMap1 = b1.p;
          if (str1 == null || str1.length() <= 0)
            str1 = "00"; 
          hashMap1.put("trans_type", str1);
          str1 = j.a(jSONObject1, "mer_name");
          hashMap1 = b1.p;
          if (str1 == null || str1.length() <= 0)
            str1 = ""; 
          hashMap1.put("mer_name", str1);
          if (this.a.aD)
            this.a.u = ""; 
          if (!this.A.equalsIgnoreCase("00")) {
            a(this.A, str4, str5);
          } else if (b(this.a.u)) {
            this.B = 2;
            str1 = String.format("\"user_id\":\"%s\"", new Object[] { this.a.u });
            this.e.n(str1);
          } else {
            y();
          } 
        } 
      case 2:
        break;
    } 
    f.c(this.a, (JSONObject)str1);
    int i = f.b(this.a, (JSONObject)str1);
    if (i != 0)
      b(i); 
    String str2 = j.a((JSONObject)str1, "userId");
    if (!TextUtils.isEmpty(str2))
      a(this.d, "_login", p.e, new Object[] { str2 }); 
    this.G = f.a((JSONObject)str1);
    y();
  }
  
  public final void a(boolean paramBoolean) {
    this.a.ax = paramBoolean;
  }
  
  public final void b(int paramInt) {
    k.a("uppay", toString() + "doErrHappended() +++");
    b(paramInt, "fail");
    k.a("uppay", toString() + "doErrHappended() ---");
  }
  
  public final void c(String paramString) {
    this.b.a(c.bD.U);
    (new r(this.d, paramString, this)).a();
  }
  
  protected final void d() {
    super.d();
    this.m.setBackgroundColor(-1);
    setBackgroundDrawable(this.c.a(3008));
    int i = a.I / 2;
    ImageView imageView = new ImageView(getContext());
    imageView.setImageDrawable(this.c.a(1027, i, -1));
    imageView.setId(imageView.hashCode());
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, -2);
    layoutParams.addRule(14);
    layoutParams.leftMargin = a.j;
    layoutParams.topMargin = (int)(0.3F * a.t);
    addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
    this.z = new ProgressBar(getContext(), null, 16843399);
    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(14, -1);
    layoutParams.addRule(3, imageView.getId());
    layoutParams.topMargin = a.d * 3;
    addView((View)this.z, (ViewGroup.LayoutParams)layoutParams);
    LinearLayout linearLayout = new LinearLayout(this.d);
    linearLayout.setOrientation(1);
    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams.addRule(14, -1);
    layoutParams.addRule(12, -1);
    layoutParams.bottomMargin = a.b;
    addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    TextView textView = new TextView(this.d);
    textView.setText(c.bD.a);
    textView.setTextColor(-1);
    textView.setTextSize(14.0F);
    textView.setGravity(1);
    (new LinearLayout.LayoutParams(-2, -2)).gravity = 14;
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    textView = new TextView(getContext());
    textView.setText(c.bD.b);
    textView.setTextColor(-1);
    textView.setTextSize(16.0F);
    textView.setGravity(1);
    (new LinearLayout.LayoutParams(-2, -2)).gravity = 14;
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final void d(String paramString) {
    this.B = 1;
    this.e.a(this.H);
    if (this.a.f) {
      this.e.b(this.a.e, paramString);
    } else {
      this.e.b(this.a.b, paramString);
    } 
    this.e.a(this);
  }
  
  public final void l() {}
  
  protected void u() {
    v();
  }
  
  public final void v() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield K : Z
    //   6: ifne -> 193
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield K : Z
    //   14: aload_0
    //   15: invokevirtual z : ()V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield E : Z
    //   23: aload_0
    //   24: getfield I : Landroid/app/Activity;
    //   27: astore_2
    //   28: aload_0
    //   29: getfield J : Z
    //   32: istore_3
    //   33: aload_0
    //   34: getfield e : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   37: invokevirtual a : ()V
    //   40: aload_0
    //   41: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   44: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   47: getfield c : Ljava/lang/String;
    //   50: invokestatic parseInt : (Ljava/lang/String;)I
    //   53: istore #4
    //   55: ldc_w 'com.unionpay.uppay'
    //   58: aload_0
    //   59: getfield d : Landroid/content/Context;
    //   62: invokestatic b : (Landroid/content/Context;)Ljava/lang/String;
    //   65: invokevirtual equals : (Ljava/lang/Object;)Z
    //   68: ifne -> 202
    //   71: iconst_1
    //   72: istore #5
    //   74: aload_0
    //   75: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   78: getfield f : Z
    //   81: ifeq -> 208
    //   84: aload_0
    //   85: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   88: astore #6
    //   90: iconst_2
    //   91: istore_1
    //   92: aload_0
    //   93: getfield e : Lcom/unionpay/mobile/android/nocard/utils/UPPayEngine;
    //   96: astore #7
    //   98: aload_0
    //   99: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   102: getfield a : Ljava/lang/String;
    //   105: astore #8
    //   107: aload_0
    //   108: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   111: getfield aO : I
    //   114: istore #9
    //   116: aload_0
    //   117: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   120: getfield f : Z
    //   123: ifeq -> 238
    //   126: aload_0
    //   127: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   130: getfield d : Ljava/lang/String;
    //   133: astore #6
    //   135: aload_0
    //   136: aload #7
    //   138: aload_2
    //   139: iload_1
    //   140: iload #4
    //   142: iload #5
    //   144: aload #8
    //   146: iload #9
    //   148: aload #6
    //   150: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   153: invokevirtual initJNIEnv : (Landroid/app/Activity;IIZLjava/lang/String;ILjava/lang/String;)J
    //   156: putfield H : J
    //   159: iload_3
    //   160: ifeq -> 250
    //   163: aload_0
    //   164: getfield H : J
    //   167: lconst_0
    //   168: lcmp
    //   169: ifeq -> 250
    //   172: aload_0
    //   173: getfield H : J
    //   176: ldc2_w -1
    //   179: lcmp
    //   180: ifeq -> 250
    //   183: aload_0
    //   184: getfield d : Landroid/content/Context;
    //   187: astore #6
    //   189: aload_0
    //   190: invokevirtual C : ()V
    //   193: return
    //   194: astore #6
    //   196: iconst_0
    //   197: istore #4
    //   199: goto -> 55
    //   202: iconst_0
    //   203: istore #5
    //   205: goto -> 74
    //   208: aload_0
    //   209: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   212: getfield c : Z
    //   215: ifeq -> 227
    //   218: aload_0
    //   219: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   222: astore #6
    //   224: goto -> 92
    //   227: aload_0
    //   228: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   231: astore #6
    //   233: iconst_0
    //   234: istore_1
    //   235: goto -> 92
    //   238: aload_0
    //   239: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   242: getfield b : Ljava/lang/String;
    //   245: astore #6
    //   247: goto -> 135
    //   250: aload_0
    //   251: getfield H : J
    //   254: ldc2_w -1
    //   257: lcmp
    //   258: ifne -> 271
    //   261: aload_0
    //   262: bipush #7
    //   264: aconst_null
    //   265: invokespecial b : (ILjava/lang/String;)V
    //   268: goto -> 193
    //   271: iload_3
    //   272: ifne -> 193
    //   275: aload_0
    //   276: iconst_5
    //   277: aconst_null
    //   278: invokespecial b : (ILjava/lang/String;)V
    //   281: goto -> 193
    // Exception table:
    //   from	to	target	type
    //   40	55	194	java/lang/NumberFormatException
  }
  
  public boolean w() {
    return false;
  }
  
  public boolean x() {
    return false;
  }
  
  public final void y() {
    if (this.A.equalsIgnoreCase("02")) {
      k();
      return;
    } 
    this.C++;
    this.E = true;
    E();
  }
  
  public void z() {
    A();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */