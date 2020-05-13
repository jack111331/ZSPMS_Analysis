package com.unionpay.mobile.android.nocard.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.net.c;
import com.unionpay.mobile.android.net.d;
import com.unionpay.mobile.android.nocard.views.bh;
import com.unionpay.mobile.android.utils.f;
import com.unionpay.mobile.android.utils.i;
import com.unionpay.mobile.android.utils.k;
import java.lang.ref.WeakReference;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class UPPayEngine implements Handler.Callback, a, Runnable {
  protected c a = null;
  
  private d b = null;
  
  private String c = null;
  
  private String d = null;
  
  private Context e = null;
  
  private Handler f = null;
  
  private WeakReference<a> g = null;
  
  private com.unionpay.mobile.android.model.b h = null;
  
  private long i = 0L;
  
  public UPPayEngine(Context paramContext) {
    this.e = paramContext;
    this.f = new Handler(this);
  }
  
  private native String commonMessage(long paramLong, String paramString1, String paramString2, String paramString3);
  
  private native String decryptResponse(long paramLong, String paramString);
  
  private native String desEncryptMessage(long paramLong, String paramString1, String paramString2);
  
  private native String encryptMessage(long paramLong, String paramString);
  
  private native String followRulesMessage(long paramLong, String paramString1, String paramString2);
  
  private native String getServerUrl(int paramInt1, int paramInt2, int paramInt3);
  
  private native String getTalkingDataId(int paramInt);
  
  private native String getUserInfo(long paramLong, String paramString1, String paramString2);
  
  protected static String i() {
    Date date = new Date(System.currentTimeMillis());
    return (new SimpleDateFormat("yyyyMMddhhmmss")).format(date);
  }
  
  private native String initMessage(long paramLong, String paramString1, String paramString2);
  
  private void o(String paramString) {
    (new Thread(this, paramString)).start();
  }
  
  private native String openupgradeMessage(long paramLong, String paramString1, String paramString2);
  
  private native String payingMessage(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  private native String retrieveInitializeKey(long paramLong);
  
  private native String rsaEncryptMessageForHFT(long paramLong, String paramString);
  
  private native String rsaPrivateEncryptMessage(long paramLong, String paramString);
  
  private native String ruleMessage(long paramLong, String paramString1, String paramString2);
  
  private native void setSessionKey(long paramLong, String paramString);
  
  private native String unBoundMessage(long paramLong, String paramString1, String paramString2);
  
  public String a(String paramString) {
    // Byte code:
    //   0: new org/json/JSONObject
    //   3: astore_2
    //   4: aload_2
    //   5: aload_1
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: aload_2
    //   10: ldc 'reqtm'
    //   12: invokestatic i : ()Ljava/lang/String;
    //   15: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual toString : ()Ljava/lang/String;
    //   23: astore_2
    //   24: ldc 'uppay'
    //   26: new java/lang/StringBuilder
    //   29: dup
    //   30: ldc 'post message = '
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: aload_1
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual toString : ()Ljava/lang/String;
    //   42: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: aload_0
    //   47: aload_0
    //   48: getfield i : J
    //   51: aload_2
    //   52: invokespecial encryptMessage : (JLjava/lang/String;)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_0
    //   57: getfield b : Lcom/unionpay/mobile/android/net/d;
    //   60: aload_1
    //   61: invokevirtual a : (Ljava/lang/String;)V
    //   64: new java/util/HashMap
    //   67: dup
    //   68: iconst_1
    //   69: invokespecial <init> : (I)V
    //   72: astore_1
    //   73: aload_1
    //   74: ldc 'sid'
    //   76: aload_0
    //   77: getfield c : Ljava/lang/String;
    //   80: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: aload_0
    //   85: getfield b : Lcom/unionpay/mobile/android/net/d;
    //   88: aload_1
    //   89: invokevirtual a : (Ljava/util/HashMap;)V
    //   92: aload_0
    //   93: invokevirtual g : ()V
    //   96: aload_0
    //   97: getfield a : Lcom/unionpay/mobile/android/net/c;
    //   100: ifnonnull -> 122
    //   103: aload_0
    //   104: new com/unionpay/mobile/android/net/c
    //   107: dup
    //   108: aload_0
    //   109: getfield b : Lcom/unionpay/mobile/android/net/d;
    //   112: aload_0
    //   113: getfield e : Landroid/content/Context;
    //   116: invokespecial <init> : (Lcom/unionpay/mobile/android/net/d;Landroid/content/Context;)V
    //   119: putfield a : Lcom/unionpay/mobile/android/net/c;
    //   122: aload_0
    //   123: getfield a : Lcom/unionpay/mobile/android/net/c;
    //   126: invokevirtual a : ()I
    //   129: istore_3
    //   130: aload_0
    //   131: getfield a : Lcom/unionpay/mobile/android/net/c;
    //   134: invokevirtual c : ()Ljava/lang/String;
    //   137: astore_1
    //   138: iload_3
    //   139: ifne -> 182
    //   142: aload_0
    //   143: aload_0
    //   144: getfield i : J
    //   147: aload_1
    //   148: invokespecial decryptResponse : (JLjava/lang/String;)Ljava/lang/String;
    //   151: astore_1
    //   152: ldc 'uppay'
    //   154: new java/lang/StringBuilder
    //   157: dup
    //   158: ldc '[ response msg ] '
    //   160: invokespecial <init> : (Ljava/lang/String;)V
    //   163: aload_1
    //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual toString : ()Ljava/lang/String;
    //   170: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   173: pop
    //   174: aload_1
    //   175: areturn
    //   176: astore_2
    //   177: aload_1
    //   178: astore_2
    //   179: goto -> 24
    //   182: aload_0
    //   183: getfield f : Landroid/os/Handler;
    //   186: iconst_2
    //   187: invokevirtual obtainMessage : (I)Landroid/os/Message;
    //   190: astore_1
    //   191: aload_1
    //   192: iload_3
    //   193: putfield arg1 : I
    //   196: aload_0
    //   197: getfield f : Landroid/os/Handler;
    //   200: aload_1
    //   201: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   204: pop
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -> 174
    // Exception table:
    //   from	to	target	type
    //   0	24	176	org/json/JSONException
  }
  
  public final String a(String paramString1, String paramString2) {
    return desEncryptMessage(this.i, paramString1, paramString2);
  }
  
  public final void a() {
    String str;
    byte b1 = 2;
    if (!TextUtils.isEmpty(this.h.bk)) {
      if (this.h.f) {
        str = this.h.bk + "/app/mobile/hft";
      } else if (this.h.c) {
        str = this.h.bk + "/app/mobile/json";
      } else {
        str = this.h.bk + "/gateway/mobile/json";
      } 
    } else {
      boolean bool;
      if (this.h.I.c.equalsIgnoreCase("01")) {
        bool = true;
      } else if (this.h.I.c.equalsIgnoreCase("02")) {
        bool = true;
      } else if (this.h.I.c.equalsIgnoreCase("98")) {
        bool = true;
      } else if (this.h.I.c.equalsIgnoreCase("99")) {
        bool = true;
      } else if ("95".equalsIgnoreCase(this.h.I.c)) {
        bool = true;
      } else {
        bool = false;
      } 
      k.a("uppay", "idx  is : " + bool + ", isNewTypeTn :" + this.h.c);
      if (!this.h.f)
        if (this.h.c) {
          b1 = 1;
        } else {
          b1 = 0;
        }  
      str = getServerUrl(b1, bool, this.h.aO);
    } 
    k.a("uppay", "url  is : " + str);
    this.b = new d(str);
  }
  
  public final void a(long paramLong) {
    this.i = paramLong;
  }
  
  public final void a(com.unionpay.mobile.android.model.b paramb) {
    if (this.h == null || this.h != paramb)
      this.h = paramb; 
  }
  
  public final void a(a parama) {
    this.g = new WeakReference<a>(parama);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt) {
    paramString2 = commonMessage(this.i, paramString1, paramString2, i());
    this.b.a(paramString2);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("sid", this.c);
    this.b.a(hashMap);
    if (paramInt <= 0) {
      o(paramString1);
      return;
    } 
    Message message = this.f.obtainMessage(1, paramString1);
    this.f.sendMessageDelayed(message, (paramInt * 1000));
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    paramString1 = payingMessage(this.i, paramString1, paramString2, paramString3, paramString4, i());
    this.b.a(paramString1);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("sid", this.c);
    this.b.a(hashMap);
    o("pay");
  }
  
  public final String b() {
    return this.d;
  }
  
  public final String b(String paramString) {
    if (!i.c(paramString))
      paramString = "00"; 
    return getTalkingDataId(Integer.decode(paramString).intValue());
  }
  
  public final void b(String paramString1, String paramString2) {
    if (this.h.f) {
      paramString1 = bh.b(this.e, paramString1, "android", this.h.a(), this.h.g, this.h.d);
    } else {
      paramString1 = bh.a(this.e, paramString1, "android", this.h.a(), this.h.g, paramString2);
    } 
    paramString1 = initMessage(this.i, paramString1, i());
    this.b.a(paramString1);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("secret", retrieveInitializeKey(this.i));
    this.b.a(hashMap);
    o("init");
  }
  
  public final long c() {
    return this.i;
  }
  
  public final void c(String paramString) {
    this.c = paramString;
  }
  
  public final void c(String paramString1, String paramString2) {
    a(paramString1, paramString2, 0);
  }
  
  public final d d() {
    return this.b;
  }
  
  public final void d(String paramString) {
    this.d = paramString;
  }
  
  public final Handler e() {
    return this.f;
  }
  
  public final boolean e(String paramString) {
    setSessionKey(this.i, paramString);
    return true;
  }
  
  public final String f() {
    return this.c;
  }
  
  public final String f(String paramString) {
    return encryptMessage(this.i, paramString);
  }
  
  public final String g(String paramString) {
    return decryptResponse(this.i, paramString);
  }
  
  protected final void g() {
    String str = this.b.c();
    if (!TextUtils.isEmpty(str)) {
      str = g(str);
      try {
        JSONObject jSONObject = new JSONObject();
        this(str);
        str = jSONObject.getString("cmd");
        String str1 = jSONObject.getString("reqtm");
        d d1 = this.b;
        Context context = this.e;
        StringBuilder stringBuilder = new StringBuilder();
        this();
        d1.a(context, str, stringBuilder.append(this.h.b).append(str1).append(f.d(this.e)).toString());
      } catch (JSONException jSONException) {
        this.b.a(this.e, "uppay", "1234567890");
      } 
    } 
  }
  
  public final String h(String paramString) {
    return rsaPrivateEncryptMessage(this.i, paramString);
  }
  
  public final void h() {
    this.e = null;
    this.f.removeCallbacksAndMessages(null);
    this.f = null;
    this.b = null;
    this.h = null;
    this.a = null;
  }
  
  public boolean handleMessage(Message paramMessage) {
    if (paramMessage.what == 0) {
      b b1 = (b)paramMessage.obj;
      if (b1.a == 0) {
        String str = decryptResponse(this.i, b1.b);
        k.a("uppay", "resp is:" + str);
      } else {
        paramMessage = null;
      } 
      if (this.g != null && this.g.get() != null) {
        ((a)this.g.get()).a(b1.a, (String)paramMessage);
        k.b("uppayEx", "UPPayEngine:" + this.g.toString());
      } 
      return true;
    } 
    if (paramMessage.what == 1) {
      o((String)paramMessage.obj);
      return true;
    } 
    if (paramMessage.what == 2 && this.g != null && this.g.get() != null)
      ((a)this.g.get()).a(paramMessage.arg1, null); 
    return true;
  }
  
  public final String i(String paramString) {
    return rsaEncryptMessageForHFT(this.i, paramString);
  }
  
  public native long initJNIEnv(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, int paramInt3, String paramString2);
  
  public final void j(String paramString) {
    paramString = ruleMessage(this.i, paramString, i());
    this.b.a(paramString);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("sid", this.c);
    this.b.a(hashMap);
    o("rule");
  }
  
  public final void k(String paramString) {
    paramString = followRulesMessage(this.i, paramString, i());
    this.b.a(paramString);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("sid", this.c);
    this.b.a(hashMap);
    o("followRule");
  }
  
  public final void l(String paramString) {
    paramString = openupgradeMessage(this.i, paramString, i());
    this.b.a(paramString);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("sid", this.c);
    this.b.a(hashMap);
    o("openupgrade");
  }
  
  public final void m(String paramString) {
    paramString = unBoundMessage(this.i, paramString, i());
    this.b.a(paramString);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("sid", this.c);
    this.b.a(hashMap);
    o("unbindcard");
  }
  
  public final void n(String paramString) {
    paramString = getUserInfo(this.i, paramString, i());
    k.a("uppay", "actEntrust msg:" + paramString);
    this.b.a(paramString);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(1);
    hashMap.put("sid", this.c);
    this.b.a(hashMap);
    o("getuserinfo");
  }
  
  public void run() {
    try {
      if (this.h != null && this.h.aO > 0 && this.h.aO <= 5) {
        this.b.d().put("magic_number", "20150423");
      } else {
        this.b.d().put("magic_number", "20131120");
      } 
      g();
      if (this.a == null) {
        c c1 = new c();
        this(this.b, this.e);
        this.a = c1;
      } 
      int i = this.a.a();
      String str = this.a.c();
      b b1 = new b();
      this(this, i, str);
      if (this.f != null) {
        Message message = this.f.obtainMessage();
        message.what = 0;
        message.obj = b1;
        this.f.sendMessage(message);
      } 
    } catch (NullPointerException nullPointerException) {
    
    } catch (Exception exception) {}
  }
  
  public static interface a {
    void a(int param1Int, String param1String);
  }
  
  final class b {
    public int a;
    
    public String b;
    
    public b(UPPayEngine this$0, int param1Int, String param1String) {
      this.a = param1Int;
      this.b = param1String;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocar\\utils\UPPayEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */