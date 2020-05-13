package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.data.c;
import com.alipay.sdk.protocol.b;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import java.util.HashMap;
import java.util.Map;

public class PayTask {
  static final Object a = e.class;
  
  private Activity b;
  
  private com.alipay.sdk.widget.a c;
  
  private String d = "wappaygw.alipay.com/service/rest.htm";
  
  private String e = "mclient.alipay.com/service/rest.htm";
  
  private String f = "mclient.alipay.com/home/exterfaceAssign.htm";
  
  private Map<String, a> g = new HashMap<String, a>();
  
  public PayTask(Activity paramActivity) {
    this.b = paramActivity;
    b b = b.a();
    Activity activity = this.b;
    c.a();
    b.a((Context)activity);
    a.a((Context)paramActivity);
    this.c = new com.alipay.sdk.widget.a(paramActivity, "去支付宝付款");
  }
  
  private e.a a() {
    return new h(this);
  }
  
  private String a(b paramb) {
    String[] arrayOfString = paramb.b;
    Intent intent = new Intent((Context)this.b, H5PayActivity.class);
    null = new Bundle();
    null.putString("url", arrayOfString[0]);
    if (arrayOfString.length == 2)
      null.putString("cookie", arrayOfString[1]); 
    intent.putExtras(null);
    this.b.startActivity(intent);
    synchronized (a) {
      a.wait();
      null = i.a;
      Object object = null;
      if (TextUtils.isEmpty((CharSequence)null))
        object = i.a(); 
      return (String)object;
    } 
  }
  
  private String a(String paramString) {
    String str = (new com.alipay.sdk.sys.a((Context)this.b)).a(paramString);
    if (str.contains("paymethod=\"expressGateway\""))
      return b(str); 
    if (l.c((Context)this.b)) {
      e e = new e(this.b, new h(this));
      String str2 = e.a(str);
      e.a = null;
      if (TextUtils.equals(str2, "failed"))
        return b(str); 
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = i.a(); 
      return str1;
    } 
    return b(str);
  }
  
  private static String a(String paramString1, String paramString2) {
    paramString2 = paramString2 + "={";
    int i = paramString1.indexOf(paramString2);
    return paramString1.substring(paramString2.length() + i, paramString1.lastIndexOf("}"));
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString, StringBuilder paramStringBuilder, Map<String, String> paramMap, String... paramVarArgs) {
    // Byte code:
    //   0: aload #5
    //   2: arraylength
    //   3: istore #6
    //   5: iconst_0
    //   6: istore #7
    //   8: iload #7
    //   10: iload #6
    //   12: if_icmpge -> 135
    //   15: aload #5
    //   17: iload #7
    //   19: aaload
    //   20: astore #8
    //   22: aload #4
    //   24: aload #8
    //   26: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast java/lang/CharSequence
    //   34: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   37: ifne -> 70
    //   40: aload #4
    //   42: aload #8
    //   44: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast java/lang/String
    //   52: astore #4
    //   54: aload #4
    //   56: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   59: ifeq -> 76
    //   62: iload_1
    //   63: ifeq -> 106
    //   66: iconst_0
    //   67: istore_0
    //   68: iload_0
    //   69: ireturn
    //   70: iinc #7, 1
    //   73: goto -> 8
    //   76: iload_0
    //   77: ifeq -> 111
    //   80: aload_3
    //   81: ldc '&'
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc '="'
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload #4
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc '"'
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: iconst_1
    //   107: istore_0
    //   108: goto -> 68
    //   111: aload_3
    //   112: aload_2
    //   113: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc '="'
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload #4
    //   123: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc '"'
    //   128: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: goto -> 106
    //   135: ldc ''
    //   137: astore #4
    //   139: goto -> 54
  }
  
  private String b(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokespecial b : ()V
    //   6: new com/alipay/sdk/packet/impl/d
    //   9: astore_3
    //   10: aload_3
    //   11: invokespecial <init> : ()V
    //   14: aload_3
    //   15: aload_0
    //   16: getfield b : Landroid/app/Activity;
    //   19: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   22: aload_1
    //   23: invokevirtual a : (Landroid/content/Context;Ljava/lang/String;)Lcom/alipay/sdk/packet/b;
    //   26: invokevirtual a : ()Lorg/json/JSONObject;
    //   29: ldc 'form'
    //   31: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   34: ldc 'onload'
    //   36: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   39: invokestatic a : (Lorg/json/JSONObject;)Ljava/util/List;
    //   42: astore_3
    //   43: iconst_0
    //   44: istore #4
    //   46: iload #4
    //   48: aload_3
    //   49: invokeinterface size : ()I
    //   54: if_icmpge -> 307
    //   57: aload_3
    //   58: iload #4
    //   60: invokeinterface get : (I)Ljava/lang/Object;
    //   65: checkcast com/alipay/sdk/protocol/b
    //   68: getfield a : Lcom/alipay/sdk/protocol/a;
    //   71: getstatic com/alipay/sdk/protocol/a.c : Lcom/alipay/sdk/protocol/a;
    //   74: if_acmpne -> 141
    //   77: aload_3
    //   78: iload #4
    //   80: invokeinterface get : (I)Ljava/lang/Object;
    //   85: checkcast com/alipay/sdk/protocol/b
    //   88: getfield b : [Ljava/lang/String;
    //   91: astore_1
    //   92: aload_1
    //   93: arraylength
    //   94: iconst_3
    //   95: if_icmpne -> 141
    //   98: ldc_w 'tid'
    //   101: aload_1
    //   102: iconst_0
    //   103: aaload
    //   104: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   107: ifeq -> 141
    //   110: invokestatic a : ()Lcom/alipay/sdk/sys/b;
    //   113: getfield a : Landroid/content/Context;
    //   116: astore #5
    //   118: invokestatic a : ()Lcom/alipay/sdk/tid/b;
    //   121: astore #6
    //   123: aload_1
    //   124: iconst_1
    //   125: aaload
    //   126: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   129: ifne -> 141
    //   132: aload_1
    //   133: iconst_2
    //   134: aaload
    //   135: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   138: ifeq -> 147
    //   141: iinc #4, 1
    //   144: goto -> 46
    //   147: aload #6
    //   149: aload_1
    //   150: iconst_1
    //   151: aaload
    //   152: putfield a : Ljava/lang/String;
    //   155: aload #6
    //   157: aload_1
    //   158: iconst_2
    //   159: aaload
    //   160: putfield b : Ljava/lang/String;
    //   163: new com/alipay/sdk/tid/a
    //   166: astore_1
    //   167: aload_1
    //   168: aload #5
    //   170: invokespecial <init> : (Landroid/content/Context;)V
    //   173: aload_1
    //   174: aload #5
    //   176: invokestatic a : (Landroid/content/Context;)Lcom/alipay/sdk/util/a;
    //   179: invokevirtual a : ()Ljava/lang/String;
    //   182: aload #5
    //   184: invokestatic a : (Landroid/content/Context;)Lcom/alipay/sdk/util/a;
    //   187: invokevirtual b : ()Ljava/lang/String;
    //   190: aload #6
    //   192: getfield a : Ljava/lang/String;
    //   195: aload #6
    //   197: getfield b : Ljava/lang/String;
    //   200: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_1
    //   204: invokevirtual close : ()V
    //   207: goto -> 141
    //   210: astore_3
    //   211: getstatic com/alipay/sdk/app/j.d : Lcom/alipay/sdk/app/j;
    //   214: getfield h : I
    //   217: invokestatic a : (I)Lcom/alipay/sdk/app/j;
    //   220: astore_1
    //   221: ldc_w 'net'
    //   224: aload_3
    //   225: invokestatic a : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_0
    //   229: invokespecial c : ()V
    //   232: aload_1
    //   233: astore_3
    //   234: aload_1
    //   235: ifnonnull -> 248
    //   238: getstatic com/alipay/sdk/app/j.b : Lcom/alipay/sdk/app/j;
    //   241: getfield h : I
    //   244: invokestatic a : (I)Lcom/alipay/sdk/app/j;
    //   247: astore_3
    //   248: aload_3
    //   249: getfield h : I
    //   252: aload_3
    //   253: getfield i : Ljava/lang/String;
    //   256: ldc ''
    //   258: invokestatic a : (ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   261: astore_1
    //   262: aload_1
    //   263: areturn
    //   264: astore #5
    //   266: aload_1
    //   267: invokevirtual close : ()V
    //   270: goto -> 141
    //   273: astore_1
    //   274: ldc_w 'biz'
    //   277: ldc_w 'H5PayDataAnalysisError'
    //   280: aload_1
    //   281: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   284: aload_0
    //   285: invokespecial c : ()V
    //   288: aconst_null
    //   289: astore_1
    //   290: goto -> 232
    //   293: astore_3
    //   294: aload_1
    //   295: invokevirtual close : ()V
    //   298: aload_3
    //   299: athrow
    //   300: astore_1
    //   301: aload_0
    //   302: invokespecial c : ()V
    //   305: aload_1
    //   306: athrow
    //   307: aload_0
    //   308: invokespecial c : ()V
    //   311: iload_2
    //   312: istore #4
    //   314: iload #4
    //   316: aload_3
    //   317: invokeinterface size : ()I
    //   322: if_icmpge -> 374
    //   325: aload_3
    //   326: iload #4
    //   328: invokeinterface get : (I)Ljava/lang/Object;
    //   333: checkcast com/alipay/sdk/protocol/b
    //   336: getfield a : Lcom/alipay/sdk/protocol/a;
    //   339: getstatic com/alipay/sdk/protocol/a.b : Lcom/alipay/sdk/protocol/a;
    //   342: if_acmpne -> 368
    //   345: aload_0
    //   346: aload_3
    //   347: iload #4
    //   349: invokeinterface get : (I)Ljava/lang/Object;
    //   354: checkcast com/alipay/sdk/protocol/b
    //   357: invokespecial a : (Lcom/alipay/sdk/protocol/b;)Ljava/lang/String;
    //   360: astore_1
    //   361: aload_0
    //   362: invokespecial c : ()V
    //   365: goto -> 262
    //   368: iinc #4, 1
    //   371: goto -> 314
    //   374: aload_0
    //   375: invokespecial c : ()V
    //   378: aconst_null
    //   379: astore_1
    //   380: goto -> 232
    // Exception table:
    //   from	to	target	type
    //   6	43	210	java/io/IOException
    //   6	43	273	java/lang/Throwable
    //   6	43	300	finally
    //   46	141	210	java/io/IOException
    //   46	141	273	java/lang/Throwable
    //   46	141	300	finally
    //   147	173	210	java/io/IOException
    //   147	173	273	java/lang/Throwable
    //   147	173	300	finally
    //   173	203	264	java/lang/Exception
    //   173	203	293	finally
    //   203	207	210	java/io/IOException
    //   203	207	273	java/lang/Throwable
    //   203	207	300	finally
    //   211	228	300	finally
    //   266	270	210	java/io/IOException
    //   266	270	273	java/lang/Throwable
    //   266	270	300	finally
    //   274	284	300	finally
    //   294	300	210	java/io/IOException
    //   294	300	273	java/lang/Throwable
    //   294	300	300	finally
    //   307	311	210	java/io/IOException
    //   307	311	273	java/lang/Throwable
    //   307	311	300	finally
    //   314	361	210	java/io/IOException
    //   314	361	273	java/lang/Throwable
    //   314	361	300	finally
  }
  
  private void b() {
    if (this.c != null)
      this.c.a(); 
  }
  
  private void c() {
    if (this.c != null) {
      this.c.b();
      this.c = null;
    } 
  }
  
  public String fetchOrderInfoFromH5PayUrl(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifne -> 1062
    //   9: aload_1
    //   10: invokevirtual trim : ()Ljava/lang/String;
    //   13: astore_2
    //   14: new java/lang/StringBuilder
    //   17: astore_3
    //   18: aload_3
    //   19: ldc_w 'https://'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: aload_2
    //   26: aload_3
    //   27: aload_0
    //   28: getfield d : Ljava/lang/String;
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   40: ifne -> 72
    //   43: new java/lang/StringBuilder
    //   46: astore_3
    //   47: aload_3
    //   48: ldc_w 'http://'
    //   51: invokespecial <init> : (Ljava/lang/String;)V
    //   54: aload_2
    //   55: aload_3
    //   56: aload_0
    //   57: getfield d : Ljava/lang/String;
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual toString : ()Ljava/lang/String;
    //   66: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   69: ifeq -> 204
    //   72: new java/lang/StringBuilder
    //   75: astore_3
    //   76: aload_3
    //   77: ldc_w '(http|https)://'
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: aload_2
    //   84: aload_3
    //   85: aload_0
    //   86: getfield d : Ljava/lang/String;
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w '\?'
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual toString : ()Ljava/lang/String;
    //   101: ldc ''
    //   103: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: invokevirtual trim : ()Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   114: ifne -> 204
    //   117: ldc_w '<request_token>'
    //   120: ldc_w '</request_token>'
    //   123: aload_3
    //   124: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   127: ldc_w 'req_data'
    //   130: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast java/lang/String
    //   138: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore_3
    //   142: new java/lang/StringBuilder
    //   145: astore_1
    //   146: aload_1
    //   147: ldc_w '_input_charset="utf-8"&ordertoken="'
    //   150: invokespecial <init> : (Ljava/lang/String;)V
    //   153: aload_1
    //   154: aload_3
    //   155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w '"&pay_channel_id="alipay_sdk"&bizcontext="'
    //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: astore_3
    //   165: new com/alipay/sdk/sys/a
    //   168: astore_1
    //   169: aload_1
    //   170: aload_0
    //   171: getfield b : Landroid/app/Activity;
    //   174: invokespecial <init> : (Landroid/content/Context;)V
    //   177: aload_3
    //   178: aload_1
    //   179: ldc_w 'sc'
    //   182: ldc_w 'h5tonative'
    //   185: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc '"'
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual toString : ()Ljava/lang/String;
    //   199: astore_1
    //   200: aload_0
    //   201: monitorexit
    //   202: aload_1
    //   203: areturn
    //   204: new java/lang/StringBuilder
    //   207: astore_3
    //   208: aload_3
    //   209: ldc_w 'https://'
    //   212: invokespecial <init> : (Ljava/lang/String;)V
    //   215: aload_2
    //   216: aload_3
    //   217: aload_0
    //   218: getfield e : Ljava/lang/String;
    //   221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual toString : ()Ljava/lang/String;
    //   227: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   230: ifne -> 262
    //   233: new java/lang/StringBuilder
    //   236: astore_3
    //   237: aload_3
    //   238: ldc_w 'http://'
    //   241: invokespecial <init> : (Ljava/lang/String;)V
    //   244: aload_2
    //   245: aload_3
    //   246: aload_0
    //   247: getfield e : Ljava/lang/String;
    //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual toString : ()Ljava/lang/String;
    //   256: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   259: ifeq -> 393
    //   262: new java/lang/StringBuilder
    //   265: astore_3
    //   266: aload_3
    //   267: ldc_w '(http|https)://'
    //   270: invokespecial <init> : (Ljava/lang/String;)V
    //   273: aload_2
    //   274: aload_3
    //   275: aload_0
    //   276: getfield e : Ljava/lang/String;
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w '\?'
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual toString : ()Ljava/lang/String;
    //   291: ldc ''
    //   293: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: invokevirtual trim : ()Ljava/lang/String;
    //   299: astore_3
    //   300: aload_3
    //   301: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   304: ifne -> 393
    //   307: ldc_w '<request_token>'
    //   310: ldc_w '</request_token>'
    //   313: aload_3
    //   314: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   317: ldc_w 'req_data'
    //   320: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   325: checkcast java/lang/String
    //   328: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   331: astore_3
    //   332: new java/lang/StringBuilder
    //   335: astore_1
    //   336: aload_1
    //   337: ldc_w '_input_charset="utf-8"&ordertoken="'
    //   340: invokespecial <init> : (Ljava/lang/String;)V
    //   343: aload_1
    //   344: aload_3
    //   345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: ldc_w '"&pay_channel_id="alipay_sdk"&bizcontext="'
    //   351: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: astore_3
    //   355: new com/alipay/sdk/sys/a
    //   358: astore_1
    //   359: aload_1
    //   360: aload_0
    //   361: getfield b : Landroid/app/Activity;
    //   364: invokespecial <init> : (Landroid/content/Context;)V
    //   367: aload_3
    //   368: aload_1
    //   369: ldc_w 'sc'
    //   372: ldc_w 'h5tonative'
    //   375: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   378: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc '"'
    //   383: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual toString : ()Ljava/lang/String;
    //   389: astore_1
    //   390: goto -> 200
    //   393: new java/lang/StringBuilder
    //   396: astore_3
    //   397: aload_3
    //   398: ldc_w 'https://'
    //   401: invokespecial <init> : (Ljava/lang/String;)V
    //   404: aload_2
    //   405: aload_3
    //   406: aload_0
    //   407: getfield f : Ljava/lang/String;
    //   410: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokevirtual toString : ()Ljava/lang/String;
    //   416: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   419: ifne -> 451
    //   422: new java/lang/StringBuilder
    //   425: astore_3
    //   426: aload_3
    //   427: ldc_w 'http://'
    //   430: invokespecial <init> : (Ljava/lang/String;)V
    //   433: aload_2
    //   434: aload_3
    //   435: aload_0
    //   436: getfield f : Ljava/lang/String;
    //   439: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: invokevirtual toString : ()Ljava/lang/String;
    //   445: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   448: ifeq -> 599
    //   451: aload_2
    //   452: ldc_w 'alipay.wap.create.direct.pay.by.user'
    //   455: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   458: ifne -> 471
    //   461: aload_2
    //   462: ldc_w 'create_forex_trade_wap'
    //   465: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   468: ifeq -> 599
    //   471: new java/lang/StringBuilder
    //   474: astore_3
    //   475: aload_3
    //   476: ldc_w '(http|https)://'
    //   479: invokespecial <init> : (Ljava/lang/String;)V
    //   482: aload_2
    //   483: aload_3
    //   484: aload_0
    //   485: getfield f : Ljava/lang/String;
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc_w '\?'
    //   494: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual toString : ()Ljava/lang/String;
    //   500: ldc ''
    //   502: invokevirtual replaceFirst : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   505: invokevirtual trim : ()Ljava/lang/String;
    //   508: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   511: istore #4
    //   513: iload #4
    //   515: ifne -> 599
    //   518: new org/json/JSONObject
    //   521: astore_3
    //   522: aload_3
    //   523: invokespecial <init> : ()V
    //   526: aload_3
    //   527: ldc 'url'
    //   529: aload_1
    //   530: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   533: pop
    //   534: new com/alipay/sdk/sys/a
    //   537: astore #5
    //   539: aload #5
    //   541: aload_0
    //   542: getfield b : Landroid/app/Activity;
    //   545: invokespecial <init> : (Landroid/content/Context;)V
    //   548: aload_3
    //   549: ldc_w 'bizcontext'
    //   552: aload #5
    //   554: ldc_w 'sc'
    //   557: ldc_w 'h5tonative'
    //   560: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   563: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   566: pop
    //   567: new java/lang/StringBuilder
    //   570: astore #5
    //   572: aload #5
    //   574: ldc_w 'new_external_info=='
    //   577: invokespecial <init> : (Ljava/lang/String;)V
    //   580: aload #5
    //   582: aload_3
    //   583: invokevirtual toString : ()Ljava/lang/String;
    //   586: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual toString : ()Ljava/lang/String;
    //   592: astore_3
    //   593: aload_3
    //   594: astore_1
    //   595: goto -> 200
    //   598: astore_3
    //   599: ldc_w '^(http|https)://(maliprod\.alipay\.com\/w\/trade_pay\.do.?|mali\.alipay\.com\/w\/trade_pay\.do.?|mclient\.alipay\.com\/w\/trade_pay\.do.?)'
    //   602: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   605: aload_1
    //   606: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   609: invokevirtual find : ()Z
    //   612: ifeq -> 1068
    //   615: ldc_w '?'
    //   618: ldc ''
    //   620: aload_1
    //   621: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   624: astore_1
    //   625: aload_1
    //   626: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   629: ifne -> 1068
    //   632: aload_1
    //   633: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   636: astore #6
    //   638: new java/lang/StringBuilder
    //   641: astore #5
    //   643: aload #5
    //   645: invokespecial <init> : ()V
    //   648: iconst_0
    //   649: iconst_1
    //   650: ldc_w 'trade_no'
    //   653: aload #5
    //   655: aload #6
    //   657: iconst_2
    //   658: anewarray java/lang/String
    //   661: dup
    //   662: iconst_0
    //   663: ldc_w 'trade_no'
    //   666: aastore
    //   667: dup
    //   668: iconst_1
    //   669: ldc_w 'alipay_trade_no'
    //   672: aastore
    //   673: invokestatic a : (ZZLjava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;[Ljava/lang/String;)Z
    //   676: ifeq -> 1068
    //   679: iconst_1
    //   680: iconst_0
    //   681: ldc_w 'pay_phase_id'
    //   684: aload #5
    //   686: aload #6
    //   688: iconst_3
    //   689: anewarray java/lang/String
    //   692: dup
    //   693: iconst_0
    //   694: ldc_w 'payPhaseId'
    //   697: aastore
    //   698: dup
    //   699: iconst_1
    //   700: ldc_w 'pay_phase_id'
    //   703: aastore
    //   704: dup
    //   705: iconst_2
    //   706: ldc_w 'out_relation_id'
    //   709: aastore
    //   710: invokestatic a : (ZZLjava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;[Ljava/lang/String;)Z
    //   713: pop
    //   714: aload #5
    //   716: ldc_w '&biz_sub_type="TRADE"'
    //   719: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: pop
    //   723: aload #5
    //   725: ldc_w '&biz_type="trade"'
    //   728: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload #6
    //   734: ldc_w 'app_name'
    //   737: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   742: checkcast java/lang/String
    //   745: astore_3
    //   746: aload_3
    //   747: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   750: ifeq -> 855
    //   753: aload #6
    //   755: ldc_w 'cid'
    //   758: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   763: checkcast java/lang/CharSequence
    //   766: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   769: ifne -> 855
    //   772: ldc_w 'ali1688'
    //   775: astore_1
    //   776: new java/lang/StringBuilder
    //   779: astore_3
    //   780: aload_3
    //   781: ldc_w '&app_name="'
    //   784: invokespecial <init> : (Ljava/lang/String;)V
    //   787: aload #5
    //   789: aload_3
    //   790: aload_1
    //   791: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: ldc '"'
    //   796: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: invokevirtual toString : ()Ljava/lang/String;
    //   802: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: iconst_1
    //   807: iconst_1
    //   808: ldc_w 'extern_token'
    //   811: aload #5
    //   813: aload #6
    //   815: iconst_4
    //   816: anewarray java/lang/String
    //   819: dup
    //   820: iconst_0
    //   821: ldc_w 'extern_token'
    //   824: aastore
    //   825: dup
    //   826: iconst_1
    //   827: ldc_w 'cid'
    //   830: aastore
    //   831: dup
    //   832: iconst_2
    //   833: ldc_w 'sid'
    //   836: aastore
    //   837: dup
    //   838: iconst_3
    //   839: ldc_w 's_id'
    //   842: aastore
    //   843: invokestatic a : (ZZLjava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;[Ljava/lang/String;)Z
    //   846: ifne -> 911
    //   849: ldc ''
    //   851: astore_1
    //   852: goto -> 200
    //   855: aload_3
    //   856: astore_1
    //   857: aload_3
    //   858: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   861: ifeq -> 776
    //   864: aload #6
    //   866: ldc_w 'sid'
    //   869: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   874: checkcast java/lang/CharSequence
    //   877: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   880: ifeq -> 904
    //   883: aload_3
    //   884: astore_1
    //   885: aload #6
    //   887: ldc_w 's_id'
    //   890: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   895: checkcast java/lang/CharSequence
    //   898: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   901: ifne -> 776
    //   904: ldc_w 'tb'
    //   907: astore_1
    //   908: goto -> 776
    //   911: iconst_1
    //   912: iconst_0
    //   913: ldc_w 'appenv'
    //   916: aload #5
    //   918: aload #6
    //   920: iconst_1
    //   921: anewarray java/lang/String
    //   924: dup
    //   925: iconst_0
    //   926: ldc_w 'appenv'
    //   929: aastore
    //   930: invokestatic a : (ZZLjava/lang/String;Ljava/lang/StringBuilder;Ljava/util/Map;[Ljava/lang/String;)Z
    //   933: pop
    //   934: aload #5
    //   936: ldc_w '&pay_channel_id="alipay_sdk"'
    //   939: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: new com/alipay/sdk/app/PayTask$a
    //   946: astore_3
    //   947: aload_3
    //   948: aload_0
    //   949: iconst_0
    //   950: invokespecial <init> : (Lcom/alipay/sdk/app/PayTask;B)V
    //   953: aload_3
    //   954: aload #6
    //   956: ldc_w 'return_url'
    //   959: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   964: checkcast java/lang/String
    //   967: putfield a : Ljava/lang/String;
    //   970: aload_3
    //   971: aload #6
    //   973: ldc_w 'pay_order_id'
    //   976: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   981: checkcast java/lang/String
    //   984: putfield b : Ljava/lang/String;
    //   987: new java/lang/StringBuilder
    //   990: astore_1
    //   991: aload_1
    //   992: invokespecial <init> : ()V
    //   995: aload_1
    //   996: aload #5
    //   998: invokevirtual toString : ()Ljava/lang/String;
    //   1001: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: ldc_w '&bizcontext="'
    //   1007: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: astore_2
    //   1011: new com/alipay/sdk/sys/a
    //   1014: astore_1
    //   1015: aload_1
    //   1016: aload_0
    //   1017: getfield b : Landroid/app/Activity;
    //   1020: invokespecial <init> : (Landroid/content/Context;)V
    //   1023: aload_2
    //   1024: aload_1
    //   1025: ldc_w 'sc'
    //   1028: ldc_w 'h5tonative'
    //   1031: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1034: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: ldc '"'
    //   1039: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual toString : ()Ljava/lang/String;
    //   1045: astore_1
    //   1046: aload_0
    //   1047: getfield g : Ljava/util/Map;
    //   1050: aload_1
    //   1051: aload_3
    //   1052: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1057: pop
    //   1058: goto -> 200
    //   1061: astore_1
    //   1062: ldc ''
    //   1064: astore_1
    //   1065: goto -> 200
    //   1068: aload_2
    //   1069: ldc_w 'mclient.alipay.com/cashier/mobilepay.htm'
    //   1072: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1075: ifne -> 1094
    //   1078: invokestatic isSandBox : ()Z
    //   1081: ifeq -> 1062
    //   1084: aload_2
    //   1085: ldc_w 'mobileclientgw.alipaydev.com/cashier/mobilepay.htm'
    //   1088: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   1091: ifeq -> 1062
    //   1094: new com/alipay/sdk/sys/a
    //   1097: astore_1
    //   1098: aload_1
    //   1099: aload_0
    //   1100: getfield b : Landroid/app/Activity;
    //   1103: invokespecial <init> : (Landroid/content/Context;)V
    //   1106: aload_1
    //   1107: ldc_w 'sc'
    //   1110: ldc_w 'h5tonative'
    //   1113: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1116: astore_1
    //   1117: new org/json/JSONObject
    //   1120: astore_3
    //   1121: aload_3
    //   1122: invokespecial <init> : ()V
    //   1125: aload_3
    //   1126: ldc 'url'
    //   1128: aload_2
    //   1129: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1132: pop
    //   1133: aload_3
    //   1134: ldc_w 'bizcontext'
    //   1137: aload_1
    //   1138: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1141: pop
    //   1142: ldc_w 'new_external_info==%s'
    //   1145: iconst_1
    //   1146: anewarray java/lang/Object
    //   1149: dup
    //   1150: iconst_0
    //   1151: aload_3
    //   1152: invokevirtual toString : ()Ljava/lang/String;
    //   1155: aastore
    //   1156: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1159: astore_1
    //   1160: goto -> 200
    //   1163: astore_1
    //   1164: aload_0
    //   1165: monitorexit
    //   1166: aload_1
    //   1167: athrow
    // Exception table:
    //   from	to	target	type
    //   2	72	1061	java/lang/Throwable
    //   2	72	1163	finally
    //   72	200	1061	java/lang/Throwable
    //   72	200	1163	finally
    //   204	262	1061	java/lang/Throwable
    //   204	262	1163	finally
    //   262	390	1061	java/lang/Throwable
    //   262	390	1163	finally
    //   393	451	1061	java/lang/Throwable
    //   393	451	1163	finally
    //   451	471	1061	java/lang/Throwable
    //   451	471	1163	finally
    //   471	513	1061	java/lang/Throwable
    //   471	513	1163	finally
    //   518	593	598	java/lang/Throwable
    //   518	593	1163	finally
    //   599	772	1061	java/lang/Throwable
    //   599	772	1163	finally
    //   776	849	1061	java/lang/Throwable
    //   776	849	1163	finally
    //   857	883	1061	java/lang/Throwable
    //   857	883	1163	finally
    //   885	904	1061	java/lang/Throwable
    //   885	904	1163	finally
    //   911	1058	1061	java/lang/Throwable
    //   911	1058	1163	finally
    //   1068	1094	1061	java/lang/Throwable
    //   1068	1094	1163	finally
    //   1094	1160	1061	java/lang/Throwable
    //   1094	1160	1163	finally
  }
  
  public String fetchTradeToken() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/app/Activity;
    //   6: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   9: ldc_w 'pref_trade_token'
    //   12: ldc ''
    //   14: invokestatic b : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_1
    //   21: areturn
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	22	finally
  }
  
  public String getVersion() {
    return "15.5.2";
  }
  
  public H5PayResultModel h5Pay(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new com/alipay/sdk/util/H5PayResultModel
    //   7: astore #4
    //   9: aload #4
    //   11: invokespecial <init> : ()V
    //   14: aload_1
    //   15: invokevirtual trim : ()Ljava/lang/String;
    //   18: pop
    //   19: aload_0
    //   20: aload_1
    //   21: iload_2
    //   22: invokevirtual pay : (Ljava/lang/String;Z)Ljava/lang/String;
    //   25: ldc_w ';'
    //   28: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   31: astore #5
    //   33: new java/util/HashMap
    //   36: astore #6
    //   38: aload #6
    //   40: invokespecial <init> : ()V
    //   43: aload #5
    //   45: arraylength
    //   46: istore #7
    //   48: iload_3
    //   49: iload #7
    //   51: if_icmpge -> 147
    //   54: aload #5
    //   56: iload_3
    //   57: aaload
    //   58: astore #8
    //   60: aload #8
    //   62: iconst_0
    //   63: aload #8
    //   65: ldc '={'
    //   67: invokevirtual indexOf : (Ljava/lang/String;)I
    //   70: invokevirtual substring : (II)Ljava/lang/String;
    //   73: astore #9
    //   75: new java/lang/StringBuilder
    //   78: astore #10
    //   80: aload #10
    //   82: invokespecial <init> : ()V
    //   85: aload #10
    //   87: aload #9
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc '={'
    //   94: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: astore #10
    //   102: aload #8
    //   104: aload #10
    //   106: invokevirtual indexOf : (Ljava/lang/String;)I
    //   109: istore #11
    //   111: aload #6
    //   113: aload #9
    //   115: aload #8
    //   117: aload #10
    //   119: invokevirtual length : ()I
    //   122: iload #11
    //   124: iadd
    //   125: aload #8
    //   127: ldc '}'
    //   129: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   132: invokevirtual substring : (II)Ljava/lang/String;
    //   135: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   140: pop
    //   141: iinc #3, 1
    //   144: goto -> 48
    //   147: aload #6
    //   149: ldc_w 'resultStatus'
    //   152: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   157: ifeq -> 178
    //   160: aload #4
    //   162: aload #6
    //   164: ldc_w 'resultStatus'
    //   167: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   172: checkcast java/lang/String
    //   175: invokevirtual setResultCode : (Ljava/lang/String;)V
    //   178: aload #6
    //   180: ldc_w 'callBackUrl'
    //   183: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   188: ifeq -> 214
    //   191: aload #4
    //   193: aload #6
    //   195: ldc_w 'callBackUrl'
    //   198: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast java/lang/String
    //   206: invokevirtual setReturnUrl : (Ljava/lang/String;)V
    //   209: aload_0
    //   210: monitorexit
    //   211: aload #4
    //   213: areturn
    //   214: aload #6
    //   216: ldc_w 'result'
    //   219: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   224: istore_2
    //   225: iload_2
    //   226: ifeq -> 209
    //   229: aload #6
    //   231: ldc_w 'result'
    //   234: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   239: checkcast java/lang/String
    //   242: astore #5
    //   244: aload #5
    //   246: invokevirtual length : ()I
    //   249: bipush #15
    //   251: if_icmple -> 523
    //   254: aload_0
    //   255: getfield g : Ljava/util/Map;
    //   258: aload_1
    //   259: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   264: checkcast com/alipay/sdk/app/PayTask$a
    //   267: astore #6
    //   269: aload #6
    //   271: ifnull -> 338
    //   274: aload #6
    //   276: getfield b : Ljava/lang/String;
    //   279: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   282: ifeq -> 309
    //   285: aload #4
    //   287: aload #6
    //   289: getfield a : Ljava/lang/String;
    //   292: invokevirtual setReturnUrl : (Ljava/lang/String;)V
    //   295: aload_0
    //   296: getfield g : Ljava/util/Map;
    //   299: aload_1
    //   300: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   305: pop
    //   306: goto -> 209
    //   309: aload #4
    //   311: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   314: getfield j : Ljava/lang/String;
    //   317: ldc_w '$OrderId$'
    //   320: aload #6
    //   322: getfield b : Ljava/lang/String;
    //   325: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   328: invokevirtual setReturnUrl : (Ljava/lang/String;)V
    //   331: goto -> 295
    //   334: astore_1
    //   335: goto -> 209
    //   338: ldc_w '&callBackUrl="'
    //   341: ldc '"'
    //   343: aload #5
    //   345: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   348: astore #6
    //   350: aload #6
    //   352: astore_1
    //   353: aload #6
    //   355: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   358: ifeq -> 453
    //   361: ldc_w '&call_back_url="'
    //   364: ldc '"'
    //   366: aload #5
    //   368: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   371: astore #6
    //   373: aload #6
    //   375: astore_1
    //   376: aload #6
    //   378: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   381: ifeq -> 453
    //   384: ldc_w '&return_url="'
    //   387: ldc '"'
    //   389: aload #5
    //   391: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   394: astore #6
    //   396: aload #6
    //   398: astore_1
    //   399: aload #6
    //   401: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   404: ifeq -> 453
    //   407: ldc_w '&return_url='
    //   410: ldc '&'
    //   412: aload #5
    //   414: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   417: ldc_w 'utf-8'
    //   420: invokestatic decode : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   423: astore #6
    //   425: aload #6
    //   427: astore_1
    //   428: aload #6
    //   430: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   433: ifeq -> 453
    //   436: ldc_w '&callBackUrl='
    //   439: ldc '&'
    //   441: aload #5
    //   443: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   446: ldc_w 'utf-8'
    //   449: invokestatic decode : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   452: astore_1
    //   453: aload_1
    //   454: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   457: ifeq -> 571
    //   460: aload #5
    //   462: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   465: ifne -> 571
    //   468: aload #5
    //   470: ldc_w 'call_back_url'
    //   473: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   476: ifeq -> 571
    //   479: ldc_w 'call_back_url="'
    //   482: ldc '"'
    //   484: aload #5
    //   486: invokestatic b : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   489: astore_1
    //   490: aload_1
    //   491: astore #6
    //   493: aload_1
    //   494: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   497: ifeq -> 508
    //   500: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   503: getfield j : Ljava/lang/String;
    //   506: astore #6
    //   508: aload #4
    //   510: aload #6
    //   512: invokevirtual setReturnUrl : (Ljava/lang/String;)V
    //   515: goto -> 209
    //   518: astore_1
    //   519: aload_0
    //   520: monitorexit
    //   521: aload_1
    //   522: athrow
    //   523: aload_0
    //   524: getfield g : Ljava/util/Map;
    //   527: aload_1
    //   528: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   533: checkcast com/alipay/sdk/app/PayTask$a
    //   536: astore #6
    //   538: aload #6
    //   540: ifnull -> 209
    //   543: aload #4
    //   545: aload #6
    //   547: getfield a : Ljava/lang/String;
    //   550: invokevirtual setReturnUrl : (Ljava/lang/String;)V
    //   553: aload_0
    //   554: getfield g : Ljava/util/Map;
    //   557: aload_1
    //   558: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   563: pop
    //   564: goto -> 209
    //   567: astore_1
    //   568: goto -> 209
    //   571: goto -> 490
    // Exception table:
    //   from	to	target	type
    //   4	14	518	finally
    //   14	48	567	java/lang/Throwable
    //   14	48	518	finally
    //   60	141	567	java/lang/Throwable
    //   60	141	518	finally
    //   147	178	567	java/lang/Throwable
    //   147	178	518	finally
    //   178	209	567	java/lang/Throwable
    //   178	209	518	finally
    //   214	225	567	java/lang/Throwable
    //   214	225	518	finally
    //   229	269	334	java/lang/Throwable
    //   229	269	518	finally
    //   274	295	334	java/lang/Throwable
    //   274	295	518	finally
    //   295	306	334	java/lang/Throwable
    //   295	306	518	finally
    //   309	331	334	java/lang/Throwable
    //   309	331	518	finally
    //   338	350	334	java/lang/Throwable
    //   338	350	518	finally
    //   353	373	334	java/lang/Throwable
    //   353	373	518	finally
    //   376	396	334	java/lang/Throwable
    //   376	396	518	finally
    //   399	425	334	java/lang/Throwable
    //   399	425	518	finally
    //   428	453	334	java/lang/Throwable
    //   428	453	518	finally
    //   453	490	334	java/lang/Throwable
    //   453	490	518	finally
    //   493	508	334	java/lang/Throwable
    //   493	508	518	finally
    //   508	515	334	java/lang/Throwable
    //   508	515	518	finally
    //   523	538	334	java/lang/Throwable
    //   523	538	518	finally
    //   543	564	334	java/lang/Throwable
    //   543	564	518	finally
  }
  
  public String pay(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aload_0
    //   6: monitorenter
    //   7: iload_2
    //   8: ifeq -> 15
    //   11: aload_0
    //   12: invokespecial b : ()V
    //   15: aload_1
    //   16: ldc_w 'service=alipay.acquire.mr.ord.createandpay'
    //   19: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   22: ifeq -> 29
    //   25: iconst_1
    //   26: putstatic com/alipay/sdk/cons/a.r : Z
    //   29: aload_1
    //   30: astore #5
    //   32: getstatic com/alipay/sdk/cons/a.r : Z
    //   35: ifeq -> 64
    //   38: aload_1
    //   39: ldc_w 'https://wappaygw.alipay.com/home/exterfaceAssign.htm?'
    //   42: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   45: ifeq -> 239
    //   48: aload_1
    //   49: aload_1
    //   50: ldc_w 'https://wappaygw.alipay.com/home/exterfaceAssign.htm?'
    //   53: invokevirtual indexOf : (Ljava/lang/String;)I
    //   56: bipush #53
    //   58: iadd
    //   59: invokevirtual substring : (I)Ljava/lang/String;
    //   62: astore #5
    //   64: new com/alipay/sdk/sys/a
    //   67: astore_1
    //   68: aload_1
    //   69: aload_0
    //   70: getfield b : Landroid/app/Activity;
    //   73: invokespecial <init> : (Landroid/content/Context;)V
    //   76: aload_1
    //   77: aload #5
    //   79: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_1
    //   83: aload_1
    //   84: ldc 'paymethod="expressGateway"'
    //   86: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   89: ifne -> 271
    //   92: aload_0
    //   93: getfield b : Landroid/app/Activity;
    //   96: invokestatic c : (Landroid/content/Context;)Z
    //   99: ifeq -> 271
    //   102: new com/alipay/sdk/util/e
    //   105: astore #6
    //   107: aload_0
    //   108: getfield b : Landroid/app/Activity;
    //   111: astore #7
    //   113: new com/alipay/sdk/app/h
    //   116: astore #8
    //   118: aload #8
    //   120: aload_0
    //   121: invokespecial <init> : (Lcom/alipay/sdk/app/PayTask;)V
    //   124: aload #6
    //   126: aload #7
    //   128: aload #8
    //   130: invokespecial <init> : (Landroid/app/Activity;Lcom/alipay/sdk/util/e$a;)V
    //   133: aload #6
    //   135: aload_1
    //   136: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   139: astore #7
    //   141: aload #6
    //   143: aconst_null
    //   144: putfield a : Landroid/app/Activity;
    //   147: aload #7
    //   149: ldc 'failed'
    //   151: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   154: ifne -> 271
    //   157: aload #7
    //   159: astore_1
    //   160: aload #7
    //   162: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   165: ifeq -> 172
    //   168: invokestatic a : ()Ljava/lang/String;
    //   171: astore_1
    //   172: aload_0
    //   173: getfield b : Landroid/app/Activity;
    //   176: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   179: astore #7
    //   181: aload_1
    //   182: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   185: ifeq -> 280
    //   188: aload #4
    //   190: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   193: ifne -> 206
    //   196: aload #7
    //   198: ldc_w 'pref_trade_token'
    //   201: aload #4
    //   203: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   206: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   209: aload_0
    //   210: getfield b : Landroid/app/Activity;
    //   213: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   216: invokevirtual a : (Landroid/content/Context;)V
    //   219: aload_0
    //   220: invokespecial c : ()V
    //   223: aload_0
    //   224: getfield b : Landroid/app/Activity;
    //   227: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   230: aload #5
    //   232: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   235: aload_0
    //   236: monitorexit
    //   237: aload_1
    //   238: areturn
    //   239: aload_1
    //   240: astore #5
    //   242: aload_1
    //   243: ldc_w 'https://mclient.alipay.com/home/exterfaceAssign.htm?'
    //   246: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   249: ifeq -> 64
    //   252: aload_1
    //   253: aload_1
    //   254: ldc_w 'https://mclient.alipay.com/home/exterfaceAssign.htm?'
    //   257: invokevirtual indexOf : (Ljava/lang/String;)I
    //   260: bipush #52
    //   262: iadd
    //   263: invokevirtual substring : (I)Ljava/lang/String;
    //   266: astore #5
    //   268: goto -> 64
    //   271: aload_0
    //   272: aload_1
    //   273: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   276: astore_1
    //   277: goto -> 172
    //   280: aload_1
    //   281: ldc_w ';'
    //   284: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   287: astore #6
    //   289: iconst_0
    //   290: istore #9
    //   292: aload_3
    //   293: astore #4
    //   295: iload #9
    //   297: aload #6
    //   299: arraylength
    //   300: if_icmpge -> 188
    //   303: aload_3
    //   304: astore #4
    //   306: aload #6
    //   308: iload #9
    //   310: aaload
    //   311: ldc_w 'result={'
    //   314: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   317: ifeq -> 426
    //   320: aload_3
    //   321: astore #4
    //   323: aload #6
    //   325: iload #9
    //   327: aaload
    //   328: ldc '}'
    //   330: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   333: ifeq -> 426
    //   336: aload #6
    //   338: iload #9
    //   340: aaload
    //   341: bipush #8
    //   343: aload #6
    //   345: iload #9
    //   347: aaload
    //   348: invokevirtual length : ()I
    //   351: iconst_1
    //   352: isub
    //   353: invokevirtual substring : (II)Ljava/lang/String;
    //   356: ldc '&'
    //   358: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   361: astore #8
    //   363: iconst_0
    //   364: istore #10
    //   366: aload_3
    //   367: astore #4
    //   369: iload #10
    //   371: aload #8
    //   373: arraylength
    //   374: if_icmpge -> 426
    //   377: aload #8
    //   379: iload #10
    //   381: aaload
    //   382: ldc_w 'trade_token="'
    //   385: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   388: ifeq -> 435
    //   391: aload #8
    //   393: iload #10
    //   395: aaload
    //   396: ldc '"'
    //   398: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   401: ifeq -> 435
    //   404: aload #8
    //   406: iload #10
    //   408: aaload
    //   409: bipush #13
    //   411: aload #8
    //   413: iload #10
    //   415: aaload
    //   416: invokevirtual length : ()I
    //   419: iconst_1
    //   420: isub
    //   421: invokevirtual substring : (II)Ljava/lang/String;
    //   424: astore #4
    //   426: iinc #9, 1
    //   429: aload #4
    //   431: astore_3
    //   432: goto -> 292
    //   435: aload #8
    //   437: iload #10
    //   439: aaload
    //   440: ldc_w 'trade_token='
    //   443: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   446: ifeq -> 464
    //   449: aload #8
    //   451: iload #10
    //   453: aaload
    //   454: bipush #12
    //   456: invokevirtual substring : (I)Ljava/lang/String;
    //   459: astore #4
    //   461: goto -> 426
    //   464: iinc #10, 1
    //   467: goto -> 366
    //   470: astore_3
    //   471: ldc_w 'biz'
    //   474: ldc_w 'SaveTradeTokenError'
    //   477: aload_3
    //   478: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   481: goto -> 206
    //   484: astore_1
    //   485: invokestatic a : ()Ljava/lang/String;
    //   488: astore_1
    //   489: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   492: aload_0
    //   493: getfield b : Landroid/app/Activity;
    //   496: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   499: invokevirtual a : (Landroid/content/Context;)V
    //   502: aload_0
    //   503: invokespecial c : ()V
    //   506: aload_0
    //   507: getfield b : Landroid/app/Activity;
    //   510: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   513: aload #5
    //   515: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   518: goto -> 235
    //   521: astore_1
    //   522: aload_0
    //   523: monitorexit
    //   524: aload_1
    //   525: athrow
    //   526: astore_1
    //   527: invokestatic b : ()Lcom/alipay/sdk/data/a;
    //   530: aload_0
    //   531: getfield b : Landroid/app/Activity;
    //   534: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   537: invokevirtual a : (Landroid/content/Context;)V
    //   540: aload_0
    //   541: invokespecial c : ()V
    //   544: aload_0
    //   545: getfield b : Landroid/app/Activity;
    //   548: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   551: aload #5
    //   553: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)V
    //   556: aload_1
    //   557: athrow
    // Exception table:
    //   from	to	target	type
    //   11	15	521	finally
    //   15	29	521	finally
    //   32	64	521	finally
    //   64	157	484	java/lang/Throwable
    //   64	157	526	finally
    //   160	172	484	java/lang/Throwable
    //   160	172	526	finally
    //   172	181	484	java/lang/Throwable
    //   172	181	526	finally
    //   181	188	470	java/lang/Throwable
    //   181	188	526	finally
    //   188	206	470	java/lang/Throwable
    //   188	206	526	finally
    //   206	235	521	finally
    //   242	268	521	finally
    //   271	277	484	java/lang/Throwable
    //   271	277	526	finally
    //   280	289	470	java/lang/Throwable
    //   280	289	526	finally
    //   295	303	470	java/lang/Throwable
    //   295	303	526	finally
    //   306	320	470	java/lang/Throwable
    //   306	320	526	finally
    //   323	363	470	java/lang/Throwable
    //   323	363	526	finally
    //   369	426	470	java/lang/Throwable
    //   369	426	526	finally
    //   435	461	470	java/lang/Throwable
    //   435	461	526	finally
    //   471	481	484	java/lang/Throwable
    //   471	481	526	finally
    //   485	489	526	finally
    //   489	518	521	finally
    //   527	558	521	finally
  }
  
  public boolean payInterceptorWithUrl(String paramString, boolean paramBoolean, H5PayCallback paramH5PayCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual fetchOrderInfoFromH5PayUrl : (Ljava/lang/String;)Ljava/lang/String;
    //   7: astore #4
    //   9: aload #4
    //   11: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   14: ifne -> 46
    //   17: new java/lang/Thread
    //   20: astore_1
    //   21: new com/alipay/sdk/app/g
    //   24: astore #5
    //   26: aload #5
    //   28: aload_0
    //   29: aload #4
    //   31: iload_2
    //   32: aload_3
    //   33: invokespecial <init> : (Lcom/alipay/sdk/app/PayTask;Ljava/lang/String;ZLcom/alipay/sdk/app/H5PayCallback;)V
    //   36: aload_1
    //   37: aload #5
    //   39: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   42: aload_1
    //   43: invokevirtual start : ()V
    //   46: aload #4
    //   48: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   51: istore_2
    //   52: iload_2
    //   53: ifne -> 62
    //   56: iconst_1
    //   57: istore_2
    //   58: aload_0
    //   59: monitorexit
    //   60: iload_2
    //   61: ireturn
    //   62: iconst_0
    //   63: istore_2
    //   64: goto -> 58
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Exception table:
    //   from	to	target	type
    //   2	46	67	finally
    //   46	52	67	finally
  }
  
  public Map<String, String> payV2(String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: iload_2
    //   5: invokevirtual pay : (Ljava/lang/String;Z)Ljava/lang/String;
    //   8: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
  
  private final class a {
    String a = "";
    
    String b = "";
    
    private a(PayTask this$0) {}
    
    private String a() {
      return this.a;
    }
    
    private void a(String param1String) {
      this.a = param1String;
    }
    
    private String b() {
      return this.b;
    }
    
    private void b(String param1String) {
      this.b = param1String;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\PayTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */