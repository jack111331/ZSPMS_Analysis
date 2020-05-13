package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
  protected static g a;
  
  protected Random b = new Random();
  
  protected List<Serializable> c = Collections.synchronizedList(new ArrayList<Serializable>());
  
  protected List<Serializable> d = Collections.synchronizedList(new ArrayList<Serializable>());
  
  protected HandlerThread e = null;
  
  protected Handler f;
  
  protected Executor g = h.b();
  
  protected Executor h = h.b();
  
  private g() {
    if (this.e == null) {
      this.e = new HandlerThread("opensdk.report.handlerthread", 10);
      this.e.start();
    } 
    if (this.e.isAlive() && this.e.getLooper() != null)
      this.f = new Handler(this, this.e.getLooper()) {
          public void handleMessage(Message param1Message) {
            switch (param1Message.what) {
              default:
                super.handleMessage(param1Message);
                return;
              case 1000:
                this.a.b();
              case 1001:
                break;
            } 
            this.a.e();
          }
        }; 
  }
  
  public static g a() {
    // Byte code:
    //   0: ldc com/tencent/open/b/g
    //   2: monitorenter
    //   3: getstatic com/tencent/open/b/g.a : Lcom/tencent/open/b/g;
    //   6: ifnonnull -> 21
    //   9: new com/tencent/open/b/g
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/tencent/open/b/g.a : Lcom/tencent/open/b/g;
    //   21: getstatic com/tencent/open/b/g.a : Lcom/tencent/open/b/g;
    //   24: astore_0
    //   25: ldc com/tencent/open/b/g
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/tencent/open/b/g
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  protected int a(int paramInt) {
    if (paramInt == 0) {
      int j = e.a(d.a(), null).a("Common_CGIReportFrequencySuccess");
      paramInt = j;
      if (j == 0)
        paramInt = 10; 
      return paramInt;
    } 
    int i = e.a(d.a(), null).a("Common_CGIReportFrequencyFailed");
    paramInt = i;
    if (i == 0)
      paramInt = 100; 
    return paramInt;
  }
  
  public void a(Bundle paramBundle, String paramString, boolean paramBoolean) {
    if (paramBundle != null) {
      f.a("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + paramBundle.toString());
      if (a("report_via", paramString) || paramBoolean)
        this.g.execute(new Runnable(this, paramBundle, paramBoolean) {
              public void run() {
                try {
                  Bundle bundle = new Bundle();
                  this();
                  bundle.putString("uin", "1000");
                  bundle.putString("imei", c.b(d.a()));
                  bundle.putString("imsi", c.c(d.a()));
                  bundle.putString("android_id", c.d(d.a()));
                  bundle.putString("mac", c.a());
                  bundle.putString("platform", "1");
                  bundle.putString("os_ver", Build.VERSION.RELEASE);
                  bundle.putString("position", i.c(d.a()));
                  bundle.putString("network", a.a(d.a()));
                  bundle.putString("language", c.b());
                  bundle.putString("resolution", c.a(d.a()));
                  bundle.putString("apn", a.b(d.a()));
                  bundle.putString("model_name", Build.MODEL);
                  bundle.putString("timezone", TimeZone.getDefault().getID());
                  bundle.putString("sdk_ver", "3.3.0.lite");
                  bundle.putString("qz_ver", i.d(d.a(), "com.qzone"));
                  bundle.putString("qq_ver", i.c(d.a(), "com.tencent.mobileqq"));
                  bundle.putString("qua", i.e(d.a(), d.b()));
                  bundle.putString("packagename", d.b());
                  bundle.putString("app_ver", i.d(d.a(), d.b()));
                  if (this.a != null)
                    bundle.putAll(this.a); 
                  b b = new b();
                  this(bundle);
                  this.c.d.add(b);
                  int i = this.c.d.size();
                  int j = e.a(d.a(), null).a("Agent_ReportTimeInterval");
                  int k = j;
                  if (j == 0)
                    k = 10000; 
                  if (this.c.a("report_via", i) || this.b) {
                    this.c.e();
                    this.c.f.removeMessages(1001);
                    return;
                  } 
                  if (!this.c.f.hasMessages(1001)) {
                    Message message = Message.obtain();
                    message.what = 1001;
                    this.c.f.sendMessageDelayed(message, k);
                  } 
                } catch (Exception exception) {
                  f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", exception);
                } 
              }
            }); 
    } 
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, long paramLong3, int paramInt) {
    a(paramString, paramLong1, paramLong2, paramLong3, paramInt, "", false);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString2, boolean paramBoolean) {
    f.a("openSDK_LOG.ReportManager", "-->reportCgi, command: " + paramString1 + " | startTime: " + paramLong1 + " | reqSize:" + paramLong2 + " | rspSize: " + paramLong3 + " | responseCode: " + paramInt + " | detail: " + paramString2);
    if (a("report_cgi", "" + paramInt) || paramBoolean)
      this.h.execute(new Runnable(this, paramLong1, paramString1, paramString2, paramInt, paramLong2, paramLong3, paramBoolean) {
            public void run() {
              int i = 1;
              try {
                long l1 = SystemClock.elapsedRealtime();
                long l2 = this.a;
                Bundle bundle = new Bundle();
                this();
                String str = a.a(d.a());
                bundle.putString("apn", str);
                bundle.putString("appid", "1000067");
                bundle.putString("commandid", this.b);
                bundle.putString("detail", this.c);
                StringBuilder stringBuilder2 = new StringBuilder();
                this();
                stringBuilder2.append("network=").append(str).append('&');
                StringBuilder stringBuilder1 = stringBuilder2.append("sdcard=");
                if (Environment.getExternalStorageState().equals("mounted")) {
                  j = 1;
                } else {
                  j = 0;
                } 
                stringBuilder1.append(j).append('&');
                stringBuilder2.append("wifi=").append(a.e(d.a()));
                bundle.putString("deviceInfo", stringBuilder2.toString());
                int j = 100 / this.h.a(this.d);
                if (j <= 0) {
                  j = i;
                } else if (j > 100) {
                  j = 100;
                } 
                stringBuilder2 = new StringBuilder();
                this();
                bundle.putString("frequency", stringBuilder2.append(j).append("").toString());
                stringBuilder2 = new StringBuilder();
                this();
                bundle.putString("reqSize", stringBuilder2.append(this.e).append("").toString());
                stringBuilder2 = new StringBuilder();
                this();
                bundle.putString("resultCode", stringBuilder2.append(this.d).append("").toString());
                stringBuilder2 = new StringBuilder();
                this();
                bundle.putString("rspSize", stringBuilder2.append(this.f).append("").toString());
                stringBuilder2 = new StringBuilder();
                this();
                bundle.putString("timeCost", stringBuilder2.append(l1 - l2).append("").toString());
                bundle.putString("uin", "1000");
                b b = new b();
                this(bundle);
                this.h.c.add(b);
                int k = this.h.c.size();
                i = e.a(d.a(), null).a("Agent_ReportTimeInterval");
                j = i;
                if (i == 0)
                  j = 10000; 
                if (this.h.a("report_cgi", k) || this.g) {
                  this.h.b();
                  this.h.f.removeMessages(1000);
                  return;
                } 
                if (!this.h.f.hasMessages(1000)) {
                  Message message = Message.obtain();
                  message.what = 1000;
                  this.h.f.sendMessageDelayed(message, j);
                } 
              } catch (Exception exception) {
                f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", exception);
              } 
            }
          }); 
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean) {
    h.a(new Runnable(this, paramBundle, paramString1, paramBoolean, paramString2) {
          public void run() {
            // Byte code:
            //   0: iconst_0
            //   1: istore_1
            //   2: aload_0
            //   3: getfield a : Landroid/os/Bundle;
            //   6: ifnonnull -> 17
            //   9: ldc 'openSDK_LOG.ReportManager'
            //   11: ldc '-->httpRequest, params is null!'
            //   13: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
            //   16: return
            //   17: invokestatic a : ()I
            //   20: istore_2
            //   21: iload_2
            //   22: ifne -> 255
            //   25: iconst_3
            //   26: istore_2
            //   27: new java/lang/StringBuilder
            //   30: astore_3
            //   31: aload_3
            //   32: invokespecial <init> : ()V
            //   35: ldc 'openSDK_LOG.ReportManager'
            //   37: aload_3
            //   38: ldc '-->httpRequest, retryCount: '
            //   40: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   43: iload_2
            //   44: invokevirtual append : (I)Ljava/lang/StringBuilder;
            //   47: invokevirtual toString : ()Ljava/lang/String;
            //   50: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   53: invokestatic a : ()Landroid/content/Context;
            //   56: aconst_null
            //   57: aload_0
            //   58: getfield b : Ljava/lang/String;
            //   61: invokestatic getHttpClient : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
            //   64: astore #4
            //   66: aload_0
            //   67: getfield a : Landroid/os/Bundle;
            //   70: invokestatic encodeUrl : (Landroid/os/Bundle;)Ljava/lang/String;
            //   73: astore_3
            //   74: aload_0
            //   75: getfield c : Z
            //   78: ifeq -> 425
            //   81: aload_3
            //   82: invokestatic encode : (Ljava/lang/String;)Ljava/lang/String;
            //   85: astore_3
            //   86: aload_0
            //   87: getfield d : Ljava/lang/String;
            //   90: invokevirtual toUpperCase : ()Ljava/lang/String;
            //   93: ldc 'GET'
            //   95: invokevirtual equals : (Ljava/lang/Object;)Z
            //   98: ifeq -> 258
            //   101: new java/lang/StringBuffer
            //   104: astore #5
            //   106: aload #5
            //   108: aload_0
            //   109: getfield b : Ljava/lang/String;
            //   112: invokespecial <init> : (Ljava/lang/String;)V
            //   115: aload #5
            //   117: aload_3
            //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
            //   121: pop
            //   122: new org/apache/http/client/methods/HttpGet
            //   125: astore_3
            //   126: aload_3
            //   127: aload #5
            //   129: invokevirtual toString : ()Ljava/lang/String;
            //   132: invokespecial <init> : (Ljava/lang/String;)V
            //   135: aload_3
            //   136: ldc 'Accept-Encoding'
            //   138: ldc 'gzip'
            //   140: invokeinterface addHeader : (Ljava/lang/String;Ljava/lang/String;)V
            //   145: aload_3
            //   146: ldc 'Content-Type'
            //   148: ldc 'application/x-www-form-urlencoded'
            //   150: invokeinterface addHeader : (Ljava/lang/String;Ljava/lang/String;)V
            //   155: iconst_0
            //   156: istore #6
            //   158: iload #6
            //   160: iconst_1
            //   161: iadd
            //   162: istore #7
            //   164: aload #4
            //   166: aload_3
            //   167: invokeinterface execute : (Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
            //   172: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
            //   177: invokeinterface getStatusCode : ()I
            //   182: istore #8
            //   184: new java/lang/StringBuilder
            //   187: astore #5
            //   189: aload #5
            //   191: invokespecial <init> : ()V
            //   194: ldc 'openSDK_LOG.ReportManager'
            //   196: aload #5
            //   198: ldc '-->httpRequest, statusCode: '
            //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   203: iload #8
            //   205: invokevirtual append : (I)Ljava/lang/StringBuilder;
            //   208: invokevirtual toString : ()Ljava/lang/String;
            //   211: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   214: iload #8
            //   216: sipush #200
            //   219: if_icmpeq -> 326
            //   222: ldc 'openSDK_LOG.ReportManager'
            //   224: ldc '-->ReportCenter httpRequest : HttpStatuscode != 200'
            //   226: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   229: iload_1
            //   230: iconst_1
            //   231: if_icmpne -> 395
            //   234: ldc 'openSDK_LOG.ReportManager'
            //   236: ldc '-->ReportCenter httpRequest Thread request success'
            //   238: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   241: goto -> 16
            //   244: astore_3
            //   245: ldc 'openSDK_LOG.ReportManager'
            //   247: ldc '-->httpRequest, exception in serial executor.'
            //   249: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   252: goto -> 16
            //   255: goto -> 27
            //   258: aload_0
            //   259: getfield d : Ljava/lang/String;
            //   262: invokevirtual toUpperCase : ()Ljava/lang/String;
            //   265: ldc 'POST'
            //   267: invokevirtual equals : (Ljava/lang/Object;)Z
            //   270: ifeq -> 316
            //   273: new org/apache/http/client/methods/HttpPost
            //   276: astore #5
            //   278: aload #5
            //   280: aload_0
            //   281: getfield b : Ljava/lang/String;
            //   284: invokespecial <init> : (Ljava/lang/String;)V
            //   287: aload_3
            //   288: invokestatic i : (Ljava/lang/String;)[B
            //   291: astore_3
            //   292: new org/apache/http/entity/ByteArrayEntity
            //   295: astore #9
            //   297: aload #9
            //   299: aload_3
            //   300: invokespecial <init> : ([B)V
            //   303: aload #5
            //   305: aload #9
            //   307: invokevirtual setEntity : (Lorg/apache/http/HttpEntity;)V
            //   310: aload #5
            //   312: astore_3
            //   313: goto -> 135
            //   316: ldc 'openSDK_LOG.ReportManager'
            //   318: ldc '-->httpRequest unkonw request method return.'
            //   320: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
            //   323: goto -> 16
            //   326: ldc 'openSDK_LOG.ReportManager'
            //   328: ldc '-->ReportCenter httpRequest Thread success'
            //   330: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   333: iconst_1
            //   334: istore_1
            //   335: goto -> 229
            //   338: astore #5
            //   340: ldc 'openSDK_LOG.ReportManager'
            //   342: ldc '-->ReportCenter httpRequest ConnectTimeoutException'
            //   344: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   347: iload_1
            //   348: istore #8
            //   350: iload #8
            //   352: istore_1
            //   353: iload #7
            //   355: istore #6
            //   357: iload #7
            //   359: iload_2
            //   360: if_icmplt -> 158
            //   363: iload #8
            //   365: istore_1
            //   366: goto -> 229
            //   369: astore #5
            //   371: ldc 'openSDK_LOG.ReportManager'
            //   373: ldc '-->ReportCenter httpRequest SocketTimeoutException'
            //   375: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   378: iload_1
            //   379: istore #8
            //   381: goto -> 350
            //   384: astore_3
            //   385: ldc 'openSDK_LOG.ReportManager'
            //   387: ldc '-->ReportCenter httpRequest Exception'
            //   389: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   392: goto -> 229
            //   395: ldc 'openSDK_LOG.ReportManager'
            //   397: ldc '-->ReportCenter httpRequest Thread request failed'
            //   399: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   402: goto -> 16
            //   405: astore_3
            //   406: iconst_1
            //   407: istore_1
            //   408: goto -> 385
            //   411: astore #5
            //   413: iconst_1
            //   414: istore_1
            //   415: goto -> 371
            //   418: astore #5
            //   420: iconst_1
            //   421: istore_1
            //   422: goto -> 340
            //   425: goto -> 86
            // Exception table:
            //   from	to	target	type
            //   2	16	244	java/lang/Exception
            //   17	21	244	java/lang/Exception
            //   27	86	244	java/lang/Exception
            //   86	135	244	java/lang/Exception
            //   135	155	244	java/lang/Exception
            //   164	214	338	org/apache/http/conn/ConnectTimeoutException
            //   164	214	369	java/net/SocketTimeoutException
            //   164	214	384	java/lang/Exception
            //   222	229	338	org/apache/http/conn/ConnectTimeoutException
            //   222	229	369	java/net/SocketTimeoutException
            //   222	229	384	java/lang/Exception
            //   234	241	244	java/lang/Exception
            //   258	310	244	java/lang/Exception
            //   316	323	244	java/lang/Exception
            //   326	333	418	org/apache/http/conn/ConnectTimeoutException
            //   326	333	411	java/net/SocketTimeoutException
            //   326	333	405	java/lang/Exception
            //   340	347	244	java/lang/Exception
            //   371	378	244	java/lang/Exception
            //   385	392	244	java/lang/Exception
            //   395	402	244	java/lang/Exception
          }
        });
  }
  
  protected boolean a(String paramString, int paramInt) {
    int i = 5;
    boolean bool = false;
    if (paramString.equals("report_cgi")) {
      int j = e.a(d.a(), null).a("Common_CGIReportMaxcount");
      if (j != 0)
        i = j; 
    } else if (paramString.equals("report_via")) {
      int j = e.a(d.a(), null).a("Agent_ReportBatchCount");
      if (j != 0)
        i = j; 
    } else {
      i = 0;
    } 
    f.b("openSDK_LOG.ReportManager", "-->availableCount, report: " + paramString + " | dataSize: " + paramInt + " | maxcount: " + i);
    if (paramInt >= i)
      bool = true; 
    return bool;
  }
  
  protected boolean a(String paramString1, String paramString2) {
    byte b;
    boolean bool1 = true;
    boolean bool2 = false;
    boolean bool3 = false;
    f.b("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + paramString1 + " | ext: " + paramString2);
    if (TextUtils.isEmpty(paramString1))
      return bool3; 
    if (paramString1.equals("report_cgi")) {
      try {
        b = Integer.parseInt(paramString2);
        b = a(b);
        if (this.b.nextInt(100) >= b)
          bool1 = false; 
        f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + bool1 + " | frequency: " + b);
      } catch (Exception exception) {
        bool1 = bool3;
      } 
      return bool1;
    } 
    if (exception.equals("report_via")) {
      b = e.a(paramString2);
      if (this.b.nextInt(100) < b) {
        bool1 = true;
      } else {
        bool1 = bool2;
      } 
    } else {
      b = 100;
      bool1 = bool2;
    } 
    f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + bool1 + " | frequency: " + b);
  }
  
  protected void b() {
    this.h.execute(new Runnable(this) {
          public void run() {
            // Byte code:
            //   0: iconst_0
            //   1: istore_1
            //   2: aload_0
            //   3: getfield a : Lcom/tencent/open/b/g;
            //   6: invokevirtual c : ()Landroid/os/Bundle;
            //   9: astore_2
            //   10: aload_2
            //   11: ifnonnull -> 15
            //   14: return
            //   15: invokestatic a : ()Landroid/content/Context;
            //   18: aconst_null
            //   19: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/open/utils/e;
            //   22: ldc 'Common_HttpRetryCount'
            //   24: invokevirtual a : (Ljava/lang/String;)I
            //   27: istore_3
            //   28: iload_3
            //   29: ifne -> 261
            //   32: iconst_3
            //   33: istore_3
            //   34: new java/lang/StringBuilder
            //   37: astore #4
            //   39: aload #4
            //   41: invokespecial <init> : ()V
            //   44: ldc 'openSDK_LOG.ReportManager'
            //   46: aload #4
            //   48: ldc '-->doReportCgi, retryCount: '
            //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   53: iload_3
            //   54: invokevirtual append : (I)Ljava/lang/StringBuilder;
            //   57: invokevirtual toString : ()Ljava/lang/String;
            //   60: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   63: iconst_0
            //   64: istore #5
            //   66: iload #5
            //   68: iconst_1
            //   69: iadd
            //   70: istore #6
            //   72: invokestatic a : ()Landroid/content/Context;
            //   75: aconst_null
            //   76: ldc 'http://wspeed.qq.com/w.cgi'
            //   78: invokestatic getHttpClient : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/client/HttpClient;
            //   81: astore #7
            //   83: new org/apache/http/client/methods/HttpPost
            //   86: astore #8
            //   88: aload #8
            //   90: ldc 'http://wspeed.qq.com/w.cgi'
            //   92: invokespecial <init> : (Ljava/lang/String;)V
            //   95: aload #8
            //   97: ldc 'Accept-Encoding'
            //   99: ldc 'gzip'
            //   101: invokevirtual addHeader : (Ljava/lang/String;Ljava/lang/String;)V
            //   104: aload #8
            //   106: ldc 'Content-Type'
            //   108: ldc 'application/x-www-form-urlencoded'
            //   110: invokevirtual setHeader : (Ljava/lang/String;Ljava/lang/String;)V
            //   113: aload_2
            //   114: invokestatic encodeUrl : (Landroid/os/Bundle;)Ljava/lang/String;
            //   117: invokestatic i : (Ljava/lang/String;)[B
            //   120: astore #4
            //   122: new org/apache/http/entity/ByteArrayEntity
            //   125: astore #9
            //   127: aload #9
            //   129: aload #4
            //   131: invokespecial <init> : ([B)V
            //   134: aload #8
            //   136: aload #9
            //   138: invokevirtual setEntity : (Lorg/apache/http/HttpEntity;)V
            //   141: aload #7
            //   143: aload #8
            //   145: invokeinterface execute : (Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
            //   150: invokeinterface getStatusLine : ()Lorg/apache/http/StatusLine;
            //   155: invokeinterface getStatusCode : ()I
            //   160: istore #10
            //   162: new java/lang/StringBuilder
            //   165: astore #4
            //   167: aload #4
            //   169: invokespecial <init> : ()V
            //   172: ldc 'openSDK_LOG.ReportManager'
            //   174: aload #4
            //   176: ldc '-->doReportCgi, statusCode: '
            //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   181: iload #10
            //   183: invokevirtual append : (I)Ljava/lang/StringBuilder;
            //   186: invokevirtual toString : ()Ljava/lang/String;
            //   189: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   192: iload_1
            //   193: istore #5
            //   195: iload #10
            //   197: sipush #200
            //   200: if_icmpne -> 214
            //   203: invokestatic a : ()Lcom/tencent/open/b/f;
            //   206: ldc 'report_cgi'
            //   208: invokevirtual b : (Ljava/lang/String;)V
            //   211: iconst_1
            //   212: istore #5
            //   214: iload #5
            //   216: ifne -> 234
            //   219: invokestatic a : ()Lcom/tencent/open/b/f;
            //   222: ldc 'report_cgi'
            //   224: aload_0
            //   225: getfield a : Lcom/tencent/open/b/g;
            //   228: getfield c : Ljava/util/List;
            //   231: invokevirtual a : (Ljava/lang/String;Ljava/util/List;)V
            //   234: aload_0
            //   235: getfield a : Lcom/tencent/open/b/g;
            //   238: getfield c : Ljava/util/List;
            //   241: invokeinterface clear : ()V
            //   246: goto -> 14
            //   249: astore_2
            //   250: ldc 'openSDK_LOG.ReportManager'
            //   252: ldc '-->doReportCgi, doupload exception out.'
            //   254: aload_2
            //   255: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   258: goto -> 14
            //   261: goto -> 34
            //   264: astore #4
            //   266: ldc 'openSDK_LOG.ReportManager'
            //   268: ldc '-->doReportCgi, doupload exception'
            //   270: aload #4
            //   272: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   275: iload #6
            //   277: istore #5
            //   279: iload #6
            //   281: iload_3
            //   282: if_icmplt -> 66
            //   285: iload_1
            //   286: istore #5
            //   288: goto -> 214
            //   291: astore #4
            //   293: ldc 'openSDK_LOG.ReportManager'
            //   295: ldc '-->doReportCgi, doupload exception'
            //   297: aload #4
            //   299: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   302: goto -> 275
            //   305: astore_2
            //   306: ldc 'openSDK_LOG.ReportManager'
            //   308: ldc '-->doReportCgi, doupload exception'
            //   310: aload_2
            //   311: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   314: iload_1
            //   315: istore #5
            //   317: goto -> 214
            // Exception table:
            //   from	to	target	type
            //   2	10	249	java/lang/Exception
            //   15	28	249	java/lang/Exception
            //   34	63	249	java/lang/Exception
            //   72	192	264	org/apache/http/conn/ConnectTimeoutException
            //   72	192	291	java/net/SocketTimeoutException
            //   72	192	305	java/lang/Exception
            //   203	211	264	org/apache/http/conn/ConnectTimeoutException
            //   203	211	291	java/net/SocketTimeoutException
            //   203	211	305	java/lang/Exception
            //   219	234	249	java/lang/Exception
            //   234	246	249	java/lang/Exception
            //   266	275	249	java/lang/Exception
            //   293	302	249	java/lang/Exception
            //   306	314	249	java/lang/Exception
          }
        });
  }
  
  protected Bundle c() {
    if (this.c.size() == 0)
      return null; 
    b b = (b)this.c.get(0);
    if (b == null) {
      f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
      return null;
    } 
    String str = b.a.get("appid");
    List<Serializable> list = f.a().a("report_cgi");
    if (list != null)
      this.c.addAll(list); 
    f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
    if (this.c.size() == 0)
      return null; 
    Bundle bundle = new Bundle();
    try {
      bundle.putString("appid", str);
      bundle.putString("releaseversion", "OpenSdk_3.3.0.lite");
      bundle.putString("device", Build.DEVICE);
      bundle.putString("qua", "V1_AND_OpenSDK_3.3.0.lite_1077_RDM_B");
      bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
      for (byte b1 = 0; b1 < this.c.size(); b1++) {
        b b2 = (b)this.c.get(b1);
        StringBuilder stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_1").toString(), b2.a.get("apn"));
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_2").toString(), b2.a.get("frequency"));
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_3").toString(), b2.a.get("commandid"));
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_4").toString(), b2.a.get("resultCode"));
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_5").toString(), b2.a.get("timeCost"));
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_6").toString(), b2.a.get("reqSize"));
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_7").toString(), b2.a.get("rspSize"));
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_8").toString(), b2.a.get("detail"));
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_9").toString(), b2.a.get("uin"));
        stringBuilder = new StringBuilder();
        this();
        String str1 = stringBuilder.append(c.e(d.a())).append("&").append(b2.a.get("deviceInfo")).toString();
        stringBuilder = new StringBuilder();
        this();
        bundle.putString(stringBuilder.append(b1).append("_10").toString(), str1);
      } 
    } catch (Exception null) {
      f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", null);
      return null;
    } 
    f.a("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
    return bundle;
  }
  
  protected Bundle d() {
    List<Serializable> list = f.a().a("report_via");
    if (list != null)
      this.d.addAll(list); 
    f.b("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
    if (this.d.size() == 0)
      return null; 
    JSONArray jSONArray = new JSONArray();
    for (Serializable serializable : this.d) {
      JSONObject jSONObject1 = new JSONObject();
      b b = (b)serializable;
      for (String str : b.a.keySet()) {
        try {
          String str1 = b.a.get(str);
          serializable = str1;
          if (str1 == null)
            serializable = ""; 
          jSONObject1.put(str, serializable);
        } catch (JSONException null) {
          f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", (Throwable)jSONException);
        } 
      } 
      jSONArray.put(jSONObject1);
    } 
    f.a("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
    Bundle bundle = new Bundle();
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("data", jSONArray);
      bundle.putString("data", jSONObject.toString());
    } catch (JSONException jSONException) {
      f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", (Throwable)jSONException);
      jSONException = null;
    } 
    return (Bundle)jSONException;
  }
  
  protected void e() {
    this.g.execute(new Runnable(this) {
          public void run() {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Lcom/tencent/open/b/g;
            //   4: invokevirtual d : ()Landroid/os/Bundle;
            //   7: astore_1
            //   8: aload_1
            //   9: ifnonnull -> 13
            //   12: return
            //   13: new java/lang/StringBuilder
            //   16: astore_2
            //   17: aload_2
            //   18: invokespecial <init> : ()V
            //   21: ldc 'openSDK_LOG.ReportManager'
            //   23: aload_2
            //   24: ldc '-->doReportVia, params: '
            //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   29: aload_1
            //   30: invokevirtual toString : ()Ljava/lang/String;
            //   33: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   36: invokevirtual toString : ()Ljava/lang/String;
            //   39: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
            //   42: invokestatic a : ()I
            //   45: istore_3
            //   46: iconst_0
            //   47: istore #4
            //   49: iconst_0
            //   50: istore #5
            //   52: invokestatic elapsedRealtime : ()J
            //   55: lstore #6
            //   57: lconst_0
            //   58: lstore #8
            //   60: lconst_0
            //   61: lstore #10
            //   63: iconst_0
            //   64: istore #12
            //   66: iload #4
            //   68: iconst_1
            //   69: iadd
            //   70: istore #13
            //   72: iload #5
            //   74: istore #14
            //   76: iload #13
            //   78: istore #15
            //   80: iload #5
            //   82: istore #16
            //   84: iload #13
            //   86: istore #4
            //   88: iload #5
            //   90: istore #17
            //   92: iload #13
            //   94: istore #18
            //   96: iload #5
            //   98: istore #19
            //   100: iload #5
            //   102: istore #20
            //   104: iload #13
            //   106: istore #21
            //   108: iload #5
            //   110: istore #22
            //   112: invokestatic a : ()Landroid/content/Context;
            //   115: ldc 'http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report'
            //   117: ldc 'POST'
            //   119: aload_1
            //   120: invokestatic openUrl2 : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Lcom/tencent/open/utils/i$a;
            //   123: astore_2
            //   124: iload #5
            //   126: istore #14
            //   128: iload #13
            //   130: istore #15
            //   132: iload #5
            //   134: istore #16
            //   136: iload #13
            //   138: istore #4
            //   140: iload #5
            //   142: istore #17
            //   144: iload #13
            //   146: istore #18
            //   148: iload #5
            //   150: istore #19
            //   152: iload #5
            //   154: istore #20
            //   156: iload #13
            //   158: istore #21
            //   160: iload #5
            //   162: istore #22
            //   164: aload_2
            //   165: getfield a : Ljava/lang/String;
            //   168: invokestatic d : (Ljava/lang/String;)Lorg/json/JSONObject;
            //   171: astore #23
            //   173: iload #5
            //   175: istore #14
            //   177: iload #13
            //   179: istore #15
            //   181: iload #5
            //   183: istore #16
            //   185: iload #13
            //   187: istore #4
            //   189: iload #5
            //   191: istore #19
            //   193: iload #5
            //   195: istore #20
            //   197: iload #13
            //   199: istore #21
            //   201: iload #5
            //   203: istore #22
            //   205: aload #23
            //   207: ldc 'ret'
            //   209: invokevirtual getInt : (Ljava/lang/String;)I
            //   212: istore #24
            //   214: iload #24
            //   216: ifeq -> 277
            //   219: iload #5
            //   221: istore #25
            //   223: iload #13
            //   225: istore #24
            //   227: iload #5
            //   229: istore #14
            //   231: iload #13
            //   233: istore #15
            //   235: iload #5
            //   237: istore #16
            //   239: iload #13
            //   241: istore #4
            //   243: iload #5
            //   245: istore #17
            //   247: iload #13
            //   249: istore #18
            //   251: iload #5
            //   253: istore #19
            //   255: iload #5
            //   257: istore #20
            //   259: iload #13
            //   261: istore #21
            //   263: iload #5
            //   265: istore #22
            //   267: aload_2
            //   268: getfield a : Ljava/lang/String;
            //   271: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
            //   274: ifne -> 283
            //   277: iconst_1
            //   278: istore #25
            //   280: iload_3
            //   281: istore #24
            //   283: iload #25
            //   285: istore #14
            //   287: iload #24
            //   289: istore #15
            //   291: iload #25
            //   293: istore #16
            //   295: iload #24
            //   297: istore #4
            //   299: iload #25
            //   301: istore #17
            //   303: iload #24
            //   305: istore #18
            //   307: iload #25
            //   309: istore #19
            //   311: iload #25
            //   313: istore #20
            //   315: iload #24
            //   317: istore #21
            //   319: iload #25
            //   321: istore #22
            //   323: aload_2
            //   324: getfield b : J
            //   327: lstore #26
            //   329: iload #25
            //   331: istore #14
            //   333: iload #24
            //   335: istore #15
            //   337: iload #25
            //   339: istore #16
            //   341: iload #24
            //   343: istore #4
            //   345: iload #25
            //   347: istore #17
            //   349: iload #24
            //   351: istore #18
            //   353: iload #25
            //   355: istore #20
            //   357: iload #24
            //   359: istore #21
            //   361: iload #25
            //   363: istore #22
            //   365: aload_2
            //   366: getfield c : J
            //   369: lstore #8
            //   371: iload #24
            //   373: istore #13
            //   375: lload #6
            //   377: lstore #28
            //   379: lload #26
            //   381: lstore #30
            //   383: lload #8
            //   385: lstore #26
            //   387: iload #12
            //   389: istore #24
            //   391: iload #24
            //   393: istore #12
            //   395: iload #25
            //   397: istore #5
            //   399: lload #26
            //   401: lstore #10
            //   403: lload #30
            //   405: lstore #8
            //   407: lload #28
            //   409: lstore #6
            //   411: iload #13
            //   413: istore #4
            //   415: iload #13
            //   417: iload_3
            //   418: if_icmplt -> 66
            //   421: lload #26
            //   423: lstore #10
            //   425: aload_0
            //   426: getfield a : Lcom/tencent/open/b/g;
            //   429: ldc 'mapp_apptrace_sdk'
            //   431: lload #28
            //   433: lload #30
            //   435: lload #10
            //   437: iload #24
            //   439: aconst_null
            //   440: iconst_0
            //   441: invokevirtual a : (Ljava/lang/String;JJJILjava/lang/String;Z)V
            //   444: iload #25
            //   446: ifeq -> 716
            //   449: invokestatic a : ()Lcom/tencent/open/b/f;
            //   452: ldc 'report_via'
            //   454: invokevirtual b : (Ljava/lang/String;)V
            //   457: aload_0
            //   458: getfield a : Lcom/tencent/open/b/g;
            //   461: getfield d : Ljava/util/List;
            //   464: invokeinterface clear : ()V
            //   469: new java/lang/StringBuilder
            //   472: astore_1
            //   473: aload_1
            //   474: invokespecial <init> : ()V
            //   477: ldc 'openSDK_LOG.ReportManager'
            //   479: aload_1
            //   480: ldc '-->doReportVia, uploadSuccess: '
            //   482: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   485: iload #25
            //   487: invokevirtual append : (Z)Ljava/lang/StringBuilder;
            //   490: invokevirtual toString : ()Ljava/lang/String;
            //   493: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   496: goto -> 12
            //   499: astore_1
            //   500: ldc 'openSDK_LOG.ReportManager'
            //   502: ldc '-->doReportVia, exception in serial executor.'
            //   504: aload_1
            //   505: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
            //   508: goto -> 12
            //   511: astore #23
            //   513: bipush #-4
            //   515: istore #24
            //   517: goto -> 214
            //   520: astore_2
            //   521: invokestatic elapsedRealtime : ()J
            //   524: lstore #28
            //   526: iload #15
            //   528: istore #13
            //   530: bipush #-7
            //   532: istore #24
            //   534: lconst_0
            //   535: lstore #26
            //   537: lconst_0
            //   538: lstore #30
            //   540: iload #14
            //   542: istore #25
            //   544: goto -> 391
            //   547: astore_2
            //   548: invokestatic elapsedRealtime : ()J
            //   551: lstore #28
            //   553: lconst_0
            //   554: lstore #30
            //   556: lconst_0
            //   557: lstore #26
            //   559: bipush #-8
            //   561: istore #24
            //   563: iload #16
            //   565: istore #25
            //   567: iload #4
            //   569: istore #13
            //   571: goto -> 391
            //   574: astore_2
            //   575: lconst_0
            //   576: lstore #30
            //   578: lconst_0
            //   579: lstore #26
            //   581: bipush #-4
            //   583: istore #24
            //   585: iload #17
            //   587: istore #25
            //   589: lload #6
            //   591: lstore #28
            //   593: iload #18
            //   595: istore #13
            //   597: goto -> 391
            //   600: astore_1
            //   601: aload_0
            //   602: getfield a : Lcom/tencent/open/b/g;
            //   605: getfield d : Ljava/util/List;
            //   608: invokeinterface clear : ()V
            //   613: ldc 'openSDK_LOG.ReportManager'
            //   615: ldc 'doReportVia, NetworkUnavailableException.'
            //   617: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
            //   620: goto -> 12
            //   623: astore_1
            //   624: iload #19
            //   626: istore #25
            //   628: aload_1
            //   629: invokevirtual getMessage : ()Ljava/lang/String;
            //   632: ldc 'http status code error:'
            //   634: ldc ''
            //   636: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
            //   639: invokestatic parseInt : (Ljava/lang/String;)I
            //   642: istore #24
            //   644: iload #24
            //   646: istore #12
            //   648: iload #12
            //   650: istore #24
            //   652: lload #6
            //   654: lstore #28
            //   656: lload #8
            //   658: lstore #30
            //   660: goto -> 425
            //   663: astore_2
            //   664: lconst_0
            //   665: lstore #30
            //   667: lconst_0
            //   668: lstore #26
            //   670: aload_2
            //   671: invokestatic getErrorCodeFromException : (Ljava/io/IOException;)I
            //   674: istore #24
            //   676: iload #20
            //   678: istore #25
            //   680: lload #6
            //   682: lstore #28
            //   684: iload #21
            //   686: istore #13
            //   688: goto -> 391
            //   691: astore_2
            //   692: lconst_0
            //   693: lstore #30
            //   695: lconst_0
            //   696: lstore #26
            //   698: bipush #-6
            //   700: istore #24
            //   702: iload_3
            //   703: istore #13
            //   705: iload #22
            //   707: istore #25
            //   709: lload #6
            //   711: lstore #28
            //   713: goto -> 391
            //   716: invokestatic a : ()Lcom/tencent/open/b/f;
            //   719: ldc 'report_via'
            //   721: aload_0
            //   722: getfield a : Lcom/tencent/open/b/g;
            //   725: getfield d : Ljava/util/List;
            //   728: invokevirtual a : (Ljava/lang/String;Ljava/util/List;)V
            //   731: goto -> 457
            //   734: astore_1
            //   735: goto -> 648
            //   738: astore_1
            //   739: lload #26
            //   741: lstore #8
            //   743: goto -> 628
            // Exception table:
            //   from	to	target	type
            //   0	8	499	java/lang/Exception
            //   13	46	499	java/lang/Exception
            //   52	57	499	java/lang/Exception
            //   112	124	520	org/apache/http/conn/ConnectTimeoutException
            //   112	124	547	java/net/SocketTimeoutException
            //   112	124	574	org/json/JSONException
            //   112	124	600	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
            //   112	124	623	com/tencent/open/utils/HttpUtils$HttpStatusException
            //   112	124	663	java/io/IOException
            //   112	124	691	java/lang/Exception
            //   164	173	520	org/apache/http/conn/ConnectTimeoutException
            //   164	173	547	java/net/SocketTimeoutException
            //   164	173	574	org/json/JSONException
            //   164	173	600	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
            //   164	173	623	com/tencent/open/utils/HttpUtils$HttpStatusException
            //   164	173	663	java/io/IOException
            //   164	173	691	java/lang/Exception
            //   205	214	511	org/json/JSONException
            //   205	214	520	org/apache/http/conn/ConnectTimeoutException
            //   205	214	547	java/net/SocketTimeoutException
            //   205	214	600	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
            //   205	214	623	com/tencent/open/utils/HttpUtils$HttpStatusException
            //   205	214	663	java/io/IOException
            //   205	214	691	java/lang/Exception
            //   267	277	520	org/apache/http/conn/ConnectTimeoutException
            //   267	277	547	java/net/SocketTimeoutException
            //   267	277	574	org/json/JSONException
            //   267	277	600	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
            //   267	277	623	com/tencent/open/utils/HttpUtils$HttpStatusException
            //   267	277	663	java/io/IOException
            //   267	277	691	java/lang/Exception
            //   323	329	520	org/apache/http/conn/ConnectTimeoutException
            //   323	329	547	java/net/SocketTimeoutException
            //   323	329	574	org/json/JSONException
            //   323	329	600	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
            //   323	329	623	com/tencent/open/utils/HttpUtils$HttpStatusException
            //   323	329	663	java/io/IOException
            //   323	329	691	java/lang/Exception
            //   365	371	520	org/apache/http/conn/ConnectTimeoutException
            //   365	371	547	java/net/SocketTimeoutException
            //   365	371	574	org/json/JSONException
            //   365	371	600	com/tencent/open/utils/HttpUtils$NetworkUnavailableException
            //   365	371	738	com/tencent/open/utils/HttpUtils$HttpStatusException
            //   365	371	663	java/io/IOException
            //   365	371	691	java/lang/Exception
            //   425	444	499	java/lang/Exception
            //   449	457	499	java/lang/Exception
            //   457	496	499	java/lang/Exception
            //   521	526	499	java/lang/Exception
            //   548	553	499	java/lang/Exception
            //   601	620	499	java/lang/Exception
            //   628	644	734	java/lang/Exception
            //   670	676	499	java/lang/Exception
            //   716	731	499	java/lang/Exception
          }
        });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */