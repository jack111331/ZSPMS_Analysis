package com.chuanglan.shanyan_sdk.tool;

import android.content.Context;
import android.os.Build;
import com.chuanglan.shanyan_sdk.b.a;
import com.chuanglan.shanyan_sdk.b.b;
import com.chuanglan.shanyan_sdk.b.g;
import com.chuanglan.shanyan_sdk.utils.AbObtainUtil;
import com.chuanglan.shanyan_sdk.utils.AbUniqueCodeUtil;
import com.chuanglan.shanyan_sdk.utils.AppStringUtils;
import com.chuanglan.shanyan_sdk.utils.AppSysMgr;
import com.chuanglan.shanyan_sdk.utils.RomUtils;
import com.chuanglan.shanyan_sdk.utils.SPTool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
  private static e a = null;
  
  private Context b;
  
  private String c;
  
  private String d;
  
  private com.chuanglan.shanyan_sdk.a.e e;
  
  private List<c> f;
  
  private List<d> g;
  
  private long h;
  
  private boolean i = false;
  
  private int j = 10000;
  
  private int k = 1;
  
  private ExecutorService l = Executors.newSingleThreadExecutor();
  
  private Long m;
  
  public static e a() {
    // Byte code:
    //   0: getstatic com/chuanglan/shanyan_sdk/tool/e.a : Lcom/chuanglan/shanyan_sdk/tool/e;
    //   3: ifnonnull -> 30
    //   6: ldc com/chuanglan/shanyan_sdk/tool/i
    //   8: monitorenter
    //   9: getstatic com/chuanglan/shanyan_sdk/tool/e.a : Lcom/chuanglan/shanyan_sdk/tool/e;
    //   12: ifnonnull -> 27
    //   15: new com/chuanglan/shanyan_sdk/tool/e
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/chuanglan/shanyan_sdk/tool/e.a : Lcom/chuanglan/shanyan_sdk/tool/e;
    //   27: ldc com/chuanglan/shanyan_sdk/tool/i
    //   29: monitorexit
    //   30: getstatic com/chuanglan/shanyan_sdk/tool/e.a : Lcom/chuanglan/shanyan_sdk/tool/e;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/chuanglan/shanyan_sdk/tool/i
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  private void a(c paramc, boolean paramBoolean) {
    this.l.execute(new Runnable(this, paramc, paramBoolean) {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   4: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;)Lcom/chuanglan/shanyan_sdk/a/e;
            //   7: ifnonnull -> 36
            //   10: aload_0
            //   11: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   14: astore_1
            //   15: new com/chuanglan/shanyan_sdk/a/e
            //   18: astore_2
            //   19: aload_2
            //   20: aload_0
            //   21: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   24: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   27: invokespecial <init> : (Landroid/content/Context;)V
            //   30: aload_1
            //   31: aload_2
            //   32: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;Lcom/chuanglan/shanyan_sdk/a/e;)Lcom/chuanglan/shanyan_sdk/a/e;
            //   35: pop
            //   36: ldc '4'
            //   38: aload_0
            //   39: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   42: getfield l : Ljava/lang/String;
            //   45: invokevirtual equals : (Ljava/lang/Object;)Z
            //   48: ifeq -> 66
            //   51: ldc '4'
            //   53: aload_0
            //   54: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   57: getfield m : Ljava/lang/String;
            //   60: invokevirtual equals : (Ljava/lang/Object;)Z
            //   63: ifne -> 141
            //   66: ldc '4'
            //   68: aload_0
            //   69: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   72: getfield l : Ljava/lang/String;
            //   75: invokevirtual equals : (Ljava/lang/Object;)Z
            //   78: ifeq -> 96
            //   81: ldc '0'
            //   83: aload_0
            //   84: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   87: getfield q : Ljava/lang/String;
            //   90: invokevirtual equals : (Ljava/lang/Object;)Z
            //   93: ifne -> 141
            //   96: ldc '3'
            //   98: aload_0
            //   99: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   102: getfield l : Ljava/lang/String;
            //   105: invokevirtual equals : (Ljava/lang/Object;)Z
            //   108: ifeq -> 164
            //   111: ldc '0'
            //   113: aload_0
            //   114: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   117: getfield q : Ljava/lang/String;
            //   120: invokevirtual equals : (Ljava/lang/Object;)Z
            //   123: ifeq -> 164
            //   126: ldc '1031'
            //   128: aload_0
            //   129: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   132: getfield r : Ljava/lang/String;
            //   135: invokevirtual equals : (Ljava/lang/Object;)Z
            //   138: ifne -> 164
            //   141: aload_0
            //   142: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   145: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   148: astore_1
            //   149: new java/lang/String
            //   152: astore_2
            //   153: aload_2
            //   154: invokespecial <init> : ()V
            //   157: aload_1
            //   158: ldc 'uuid'
            //   160: aload_2
            //   161: invokestatic put : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)V
            //   164: new com/chuanglan/shanyan_sdk/tool/d
            //   167: astore_1
            //   168: aload_1
            //   169: invokespecial <init> : ()V
            //   172: aload_1
            //   173: invokestatic a : ()Lcom/chuanglan/shanyan_sdk/tool/i;
            //   176: invokevirtual e : ()Ljava/lang/String;
            //   179: putfield b : Ljava/lang/String;
            //   182: aload_1
            //   183: aload_0
            //   184: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   187: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   190: invokestatic getIMSI : (Landroid/content/Context;)Ljava/lang/String;
            //   193: putfield c : Ljava/lang/String;
            //   196: aload_1
            //   197: aload_0
            //   198: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   201: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   204: invokestatic getSIMSerial : (Landroid/content/Context;)Ljava/lang/String;
            //   207: putfield d : Ljava/lang/String;
            //   210: aload_1
            //   211: aload_0
            //   212: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   215: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   218: invokestatic getMac : (Landroid/content/Context;)Ljava/lang/String;
            //   221: putfield e : Ljava/lang/String;
            //   224: aload_1
            //   225: ldc '2'
            //   227: putfield f : Ljava/lang/String;
            //   230: aload_1
            //   231: getstatic android/os/Build.MODEL : Ljava/lang/String;
            //   234: putfield g : Ljava/lang/String;
            //   237: aload_1
            //   238: getstatic android/os/Build.BRAND : Ljava/lang/String;
            //   241: putfield h : Ljava/lang/String;
            //   244: new java/lang/StringBuilder
            //   247: astore_2
            //   248: aload_2
            //   249: invokespecial <init> : ()V
            //   252: aload_1
            //   253: aload_2
            //   254: aload_1
            //   255: getfield b : Ljava/lang/String;
            //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   261: aload_1
            //   262: getfield c : Ljava/lang/String;
            //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   268: aload_1
            //   269: getfield d : Ljava/lang/String;
            //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   275: aload_1
            //   276: getfield e : Ljava/lang/String;
            //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   282: invokevirtual toString : ()Ljava/lang/String;
            //   285: invokestatic md5 : (Ljava/lang/String;)Ljava/lang/String;
            //   288: putfield a : Ljava/lang/String;
            //   291: aload_0
            //   292: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   295: aload_1
            //   296: getfield a : Ljava/lang/String;
            //   299: putfield a : Ljava/lang/String;
            //   302: aload_0
            //   303: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   306: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   309: ldc 'DID'
            //   311: aload_1
            //   312: getfield a : Ljava/lang/String;
            //   315: invokestatic put : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)V
            //   318: aload_0
            //   319: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   322: astore_2
            //   323: new java/lang/StringBuilder
            //   326: astore_3
            //   327: aload_3
            //   328: invokespecial <init> : ()V
            //   331: aload_2
            //   332: aload_3
            //   333: aload_0
            //   334: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   337: getfield a : Ljava/lang/String;
            //   340: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   343: aload_0
            //   344: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   347: getfield b : Ljava/lang/String;
            //   350: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   353: aload_0
            //   354: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   357: getfield c : Ljava/lang/String;
            //   360: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   363: aload_0
            //   364: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   367: getfield d : Ljava/lang/String;
            //   370: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   373: aload_0
            //   374: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   377: getfield f : Ljava/lang/String;
            //   380: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   383: aload_0
            //   384: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   387: getfield l : Ljava/lang/String;
            //   390: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   393: aload_0
            //   394: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   397: getfield m : Ljava/lang/String;
            //   400: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   403: aload_0
            //   404: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   407: getfield r : Ljava/lang/String;
            //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   413: aload_0
            //   414: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   417: getfield s : Ljava/lang/String;
            //   420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   423: aload_0
            //   424: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   427: getfield t : Ljava/lang/String;
            //   430: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   433: aload_0
            //   434: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   437: getfield u : Ljava/lang/String;
            //   440: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   443: invokevirtual toString : ()Ljava/lang/String;
            //   446: invokestatic md5 : (Ljava/lang/String;)Ljava/lang/String;
            //   449: putfield w : Ljava/lang/String;
            //   452: aload_0
            //   453: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   456: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   459: ldc 'reportTimestart'
            //   461: lconst_1
            //   462: invokestatic valueOf : (J)Ljava/lang/Long;
            //   465: invokestatic get : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
            //   468: checkcast java/lang/Long
            //   471: invokevirtual longValue : ()J
            //   474: lconst_1
            //   475: lcmp
            //   476: ifne -> 497
            //   479: aload_0
            //   480: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   483: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   486: ldc 'reportTimestart'
            //   488: invokestatic currentTimeMillis : ()J
            //   491: invokestatic valueOf : (J)Ljava/lang/Long;
            //   494: invokestatic put : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)V
            //   497: aload_0
            //   498: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   501: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   504: ldc 'reportFlag'
            //   506: ldc2_w 600
            //   509: invokestatic valueOf : (J)Ljava/lang/Long;
            //   512: invokestatic get : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
            //   515: checkcast java/lang/Long
            //   518: astore_2
            //   519: aload_2
            //   520: invokevirtual longValue : ()J
            //   523: ldc2_w -1
            //   526: lcmp
            //   527: ifne -> 531
            //   530: return
            //   531: aload_2
            //   532: invokevirtual longValue : ()J
            //   535: lconst_0
            //   536: lcmp
            //   537: ifne -> 563
            //   540: aload_0
            //   541: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   544: aload_1
            //   545: aload_0
            //   546: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   549: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;Lcom/chuanglan/shanyan_sdk/tool/d;Lcom/chuanglan/shanyan_sdk/tool/c;)V
            //   552: goto -> 530
            //   555: astore_1
            //   556: aload_1
            //   557: invokevirtual printStackTrace : ()V
            //   560: goto -> 530
            //   563: aload_0
            //   564: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   567: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;)Lcom/chuanglan/shanyan_sdk/a/e;
            //   570: aload_1
            //   571: invokevirtual a : (Lcom/chuanglan/shanyan_sdk/tool/d;)V
            //   574: aload_0
            //   575: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   578: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;)Lcom/chuanglan/shanyan_sdk/a/e;
            //   581: aload_0
            //   582: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   585: aload_0
            //   586: getfield b : Z
            //   589: invokevirtual a : (Lcom/chuanglan/shanyan_sdk/tool/c;Z)V
            //   592: ldc '4'
            //   594: aload_0
            //   595: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   598: getfield l : Ljava/lang/String;
            //   601: invokevirtual equals : (Ljava/lang/Object;)Z
            //   604: ifeq -> 622
            //   607: ldc '4'
            //   609: aload_0
            //   610: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   613: getfield m : Ljava/lang/String;
            //   616: invokevirtual equals : (Ljava/lang/Object;)Z
            //   619: ifne -> 700
            //   622: ldc '4'
            //   624: aload_0
            //   625: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   628: getfield l : Ljava/lang/String;
            //   631: invokevirtual equals : (Ljava/lang/Object;)Z
            //   634: ifeq -> 652
            //   637: ldc '0'
            //   639: aload_0
            //   640: getfield a : Lcom/chuanglan/shanyan_sdk/tool/c;
            //   643: getfield q : Ljava/lang/String;
            //   646: invokevirtual equals : (Ljava/lang/Object;)Z
            //   649: ifne -> 700
            //   652: invokestatic currentTimeMillis : ()J
            //   655: lstore #4
            //   657: aload_0
            //   658: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   661: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   664: ldc 'reportTimestart'
            //   666: ldc2_w -1
            //   669: invokestatic valueOf : (J)Ljava/lang/Long;
            //   672: invokestatic get : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
            //   675: checkcast java/lang/Long
            //   678: invokevirtual longValue : ()J
            //   681: lstore #6
            //   683: lload #4
            //   685: aload_2
            //   686: invokevirtual longValue : ()J
            //   689: ldc2_w 1000
            //   692: lmul
            //   693: lload #6
            //   695: ladd
            //   696: lcmp
            //   697: ifle -> 530
            //   700: aload_0
            //   701: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   704: aload_0
            //   705: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   708: invokestatic b : (Lcom/chuanglan/shanyan_sdk/tool/e;)Landroid/content/Context;
            //   711: ldc 'reportCount'
            //   713: ldc2_w 100
            //   716: invokestatic valueOf : (J)Ljava/lang/Long;
            //   719: invokestatic get : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
            //   722: checkcast java/lang/Long
            //   725: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;Ljava/lang/Long;)Ljava/lang/Long;
            //   728: pop
            //   729: aload_0
            //   730: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   733: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;)Lcom/chuanglan/shanyan_sdk/a/e;
            //   736: invokevirtual b : ()J
            //   739: lconst_0
            //   740: lcmp
            //   741: ifle -> 530
            //   744: aload_0
            //   745: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   748: aload_0
            //   749: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   752: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;)Lcom/chuanglan/shanyan_sdk/a/e;
            //   755: invokevirtual b : ()J
            //   758: l2f
            //   759: aload_0
            //   760: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   763: invokestatic c : (Lcom/chuanglan/shanyan_sdk/tool/e;)Ljava/lang/Long;
            //   766: invokevirtual longValue : ()J
            //   769: l2f
            //   770: fdiv
            //   771: f2d
            //   772: invokestatic ceil : (D)D
            //   775: d2i
            //   776: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;I)I
            //   779: pop
            //   780: aload_0
            //   781: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   784: invokestatic d : (Lcom/chuanglan/shanyan_sdk/tool/e;)V
            //   787: aload_0
            //   788: getfield c : Lcom/chuanglan/shanyan_sdk/tool/e;
            //   791: iconst_0
            //   792: invokestatic a : (Lcom/chuanglan/shanyan_sdk/tool/e;Z)Z
            //   795: pop
            //   796: goto -> 530
            // Exception table:
            //   from	to	target	type
            //   0	36	555	java/lang/Exception
            //   36	66	555	java/lang/Exception
            //   66	96	555	java/lang/Exception
            //   96	141	555	java/lang/Exception
            //   141	164	555	java/lang/Exception
            //   164	497	555	java/lang/Exception
            //   497	530	555	java/lang/Exception
            //   531	552	555	java/lang/Exception
            //   563	622	555	java/lang/Exception
            //   622	652	555	java/lang/Exception
            //   652	700	555	java/lang/Exception
            //   700	796	555	java/lang/Exception
          }
        });
  }
  
  private void a(d paramd, c paramc) {
    try {
      ArrayList<c> arrayList1 = new ArrayList();
      this();
      this.f = arrayList1;
      this.f.add(paramc);
      ArrayList<d> arrayList = new ArrayList();
      this();
      this.g = arrayList;
      this.g.add(paramd);
      JSONArray jSONArray3 = AbObtainUtil.getBehaviorJsonArray(this.f);
      JSONArray jSONArray2 = AbObtainUtil.getDeviceJsonArray(this.g);
      JSONObject jSONObject = new JSONObject();
      this();
      JSONArray jSONArray1 = new JSONArray();
      this("[\"DID\", \"telcom\", \"sdkMode\", \"osVersion\", \"romVersion\", \"sdkVersion\", \"uuid\", \"ip\", \"network\", \"dbm\",\"wifidbm\", \"processName\", \"method\", \"beginTime\", \"costTime\", \"stepTime\", \"status\", \"resCode\", \"resDesc\", \"innerCode\", \"innerDesc\", \"count\", \"sid\"]");
      JSONArray jSONArray4 = new JSONArray();
      this("[\"DID\", \"IMEI\", \"IMSI\", \"ICCID\", \"MAC\", \"appPlatform\", \"device\", \"deviceName\"]");
      jSONObject.put("body", jSONArray3);
      jSONObject.put("bodyTitle", jSONArray1);
      jSONObject.put("header", jSONArray2);
      jSONObject.put("headerTitle", jSONArray4);
      if (jSONArray3 != null && jSONArray2 != null && jSONArray3.length() != 0 && jSONArray2.length() != 0)
        a(jSONObject.toString(), false); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void a(String paramString, boolean paramBoolean) {
    this.j = ((Integer)SPTool.get(this.b, "reportMax", Integer.valueOf(10000))).intValue();
    String str1 = (String)SPTool.get(this.b, "appId", "");
    String str2 = (String)SPTool.get(this.b, "appKey", "");
    if (!AppStringUtils.isNotEmpty(str1) || !AppStringUtils.isNotEmpty(str2)) {
      str1 = this.c;
      str2 = this.d;
    } 
    String str3 = (String)SPTool.get(this.b, "pks", "0MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJaqWkyQhbQ6EbYBFaxhfblDc3wmzSV27D/CncV6b1dG9DW/9rPqKLP9TvpcxA8OTgQR/WZ1YKwtcHJurR83spkCAwEAAQ==");
    String str4 = AbUniqueCodeUtil.getUUID();
    String str5 = f.a(this.b);
    String str6 = f.b(this.b);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("appId", str1);
    hashMap.put("randoms", str4);
    hashMap.put("packageName", str5);
    hashMap.put("packageSign", str6);
    String str7 = AbObtainUtil.getSignFullReport(hashMap, str2);
    if (AppStringUtils.isNotEmpty(str1) && AppStringUtils.isNotEmpty(str2) && AppStringUtils.isNotEmpty(str4)) {
      Map map = g.a().a(str1, str4, paramString, str7, str5, str6);
      (new a("https://ulflash.253.com/flash/fdr/v2", this.b)).a(map, (b)new com.chuanglan.shanyan_sdk.b.e(this, paramBoolean, paramString) {
            public void a(String param1String) {
              try {
                if (AppStringUtils.isNotEmpty(param1String)) {
                  JSONObject jSONObject = new JSONObject();
                  this(param1String);
                  if (jSONObject.optInt("retCode") == 0) {
                    if (this.a) {
                      e.a(this.c).a(e.a(this.c).c());
                      e.e(this.c);
                      if (e.f(this.c) > 0)
                        e.d(this.c); 
                    } 
                    return;
                  } 
                  if (this.a)
                    e.g(this.c); 
                  return;
                } 
              } catch (JSONException jSONException) {
                jSONException.printStackTrace();
                if (this.a)
                  e.g(this.c); 
                return;
              } 
              if (this.a)
                e.g(this.c); 
            }
            
            public void a(String param1String1, String param1String2) {
              try {
                if (!e.h(this.c)) {
                  e.a(this.c, true);
                  e.a(this.c, this.b, this.a);
                  return;
                } 
                if (this.a)
                  e.g(this.c); 
              } catch (Exception exception) {
                exception.printStackTrace();
              } 
            }
          }Boolean.valueOf(true), str3);
    } 
  }
  
  private void b() {
    try {
      SPTool.put(this.b, "reportTimestart", Long.valueOf(System.currentTimeMillis()));
      ArrayList<c> arrayList1 = new ArrayList();
      this();
      this.f = arrayList1;
      Long long_ = (Long)SPTool.get(this.b, "reportCount", Long.valueOf(100L));
      this.f.addAll(this.e.a(String.valueOf(long_)));
      ArrayList<d> arrayList = new ArrayList();
      this();
      this.g = arrayList;
      this.g.addAll(this.e.a());
      JSONArray jSONArray2 = AbObtainUtil.getBehaviorJsonArray(this.f);
      JSONArray jSONArray1 = AbObtainUtil.getDeviceJsonArray(this.g);
      JSONObject jSONObject = new JSONObject();
      this();
      JSONArray jSONArray3 = new JSONArray();
      this("[\"DID\", \"telcom\", \"sdkMode\", \"osVersion\", \"romVersion\", \"sdkVersion\", \"uuid\", \"ip\", \"network\", \"dbm\",\"wifidbm\", \"processName\", \"method\", \"beginTime\", \"costTime\",\"stepTime\", \"status\", \"resCode\", \"resDesc\", \"innerCode\", \"innerDesc\", \"count\", \"sid\"]");
      JSONArray jSONArray4 = new JSONArray();
      this("[\"DID\", \"IMEI\", \"IMSI\", \"ICCID\", \"MAC\", \"appPlatform\", \"device\", \"deviceName\"]");
      jSONObject.put("body", jSONArray2);
      jSONObject.put("bodyTitle", jSONArray3);
      jSONObject.put("header", jSONArray1);
      jSONObject.put("headerTitle", jSONArray4);
      if (jSONArray2 != null && jSONArray1 != null && jSONArray2.length() != 0 && jSONArray1.length() != 0)
        a(jSONObject.toString(), true); 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void c() {
    try {
      if (this.e.a(this.j)) {
        int i = (int)(this.j * 0.1D);
        this.e.a(String.valueOf(i));
        this.e.a(this.e.c());
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2) {
    c c;
    try {
      c = new c();
      this();
      c.b = AppSysMgr.getOperatorType(this.b);
      c.c = "0";
      c.d = Build.VERSION.RELEASE;
      String str = RomUtils.getVersion();
      if (AppStringUtils.isNotEmpty(str)) {
        c.e = str;
      } else {
        c.e = AppSysMgr.getDisplayVersion();
      } 
      c.f = "2.2.1.0";
      if (paramBoolean1) {
        c.g = "";
      } else {
        c.g = (String)SPTool.get(this.b, "uuid", "");
      } 
      c.h = AppSysMgr.getIP(this.b);
      c.i = i.a().b();
      c.j = String.valueOf(i.a().d());
      c.k = String.valueOf(i.a().c());
      c.l = String.valueOf(paramInt2);
      c.m = String.valueOf(paramString1);
      c.n = paramString4;
      c.o = paramLong1;
      c.p = paramLong2;
      c.q = String.valueOf(paramString2);
      c.r = String.valueOf(paramInt1);
      c.s = paramString3;
      c.t = paramString5;
      c.u = paramString6;
      c.v = 1;
      if (!"check_error".equals(paramString6) && !"cache".equals(paramString6) && paramInt1 != 1011) {
        c.u = paramString3;
        c.s = paramString6;
      } 
      if (paramInt1 != 1032) {
        if ("1".equals(paramString1) && "0".equals(paramString2) && paramInt2 != 3) {
          a().a(c, true);
          return;
        } 
      } else {
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
    a().a(c, paramBoolean2);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2) {
    this.b = paramContext;
    this.c = paramString1;
    this.d = paramString2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\chuanglan\shanyan_sdk\tool\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */