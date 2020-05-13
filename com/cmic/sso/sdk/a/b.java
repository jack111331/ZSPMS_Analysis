package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.utils.h;
import java.util.Iterator;
import java.util.List;

public class b {
  private static b a;
  
  private static long b = 0L;
  
  private b c = null;
  
  private SubscriptionInfo a(Object paramObject, String paramString, Object[] paramArrayOfObject) {
    return (SubscriptionInfo)a(paramObject, paramString, paramArrayOfObject, null);
  }
  
  @SuppressLint({"NewApi"})
  private SubscriptionInfo a(List<SubscriptionInfo> paramList, int paramInt) {
    SubscriptionInfo subscriptionInfo2 = paramList.get(0);
    Iterator<SubscriptionInfo> iterator = paramList.iterator();
    SubscriptionInfo subscriptionInfo1 = subscriptionInfo2;
    while (iterator.hasNext()) {
      subscriptionInfo2 = iterator.next();
      if (subscriptionInfo2.getSimSlotIndex() == paramInt)
        subscriptionInfo1 = subscriptionInfo2; 
    } 
    return subscriptionInfo1;
  }
  
  public static b a() {
    if (a == null)
      a = new b(); 
    return a;
  }
  
  private Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass) {
    try {
      Class<?> clazz = Class.forName(paramObject.getClass().getName());
      return (paramArrayOfObject != null && paramArrayOfClass != null) ? clazz.getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject) : clazz.getMethod(paramString, new Class[0]).invoke(paramObject, new Object[0]);
    } catch (Exception exception) {
      exception.printStackTrace();
      throw new a(paramString);
    } 
  }
  
  private String a(TelephonyManager paramTelephonyManager, String paramString, int paramInt) {
    String str;
    TelephonyManager telephonyManager = null;
    Class<int> clazz = int.class;
    Object object = a(paramTelephonyManager, paramString, new Object[] { Integer.valueOf(paramInt) }, new Class[] { clazz });
    paramTelephonyManager = telephonyManager;
    if (object != null)
      str = object.toString(); 
    return str;
  }
  
  @SuppressLint({"NewApi"})
  private void a(List<SubscriptionInfo> paramList, TelephonyManager paramTelephonyManager) {
    SubscriptionInfo subscriptionInfo;
    int i;
    boolean bool = true;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    } 
    if (i == 1) {
      subscriptionInfo = paramList.get(0);
    } else if (i > 1) {
      subscriptionInfo = a((List<SubscriptionInfo>)subscriptionInfo, 0);
    } else {
      return;
    } 
    this.c.b(subscriptionInfo.getSimSlotIndex());
    this.c.d(subscriptionInfo.getSubscriptionId());
    try {
      this.c.a(a(paramTelephonyManager, "getDeviceId", subscriptionInfo.getSimSlotIndex()));
    } catch (a a) {}
    try {
      b.a(this.c, b(paramTelephonyManager, "getSimState", subscriptionInfo.getSimSlotIndex()));
    } catch (a a) {}
    if (a.a() == 0) {
      i = subscriptionInfo.getSimSlotIndex();
    } else {
      i = subscriptionInfo.getSubscriptionId();
    } 
    try {
      this.c.c(a(paramTelephonyManager, "getSubscriberId", subscriptionInfo.getSubscriptionId()));
    } catch (a a) {}
    try {
      this.c.e(a(paramTelephonyManager, "getSimOperator", subscriptionInfo.getSubscriptionId()));
    } catch (a a) {}
  }
  
  @SuppressLint({"NewApi"})
  private void b(List<SubscriptionInfo> paramList, TelephonyManager paramTelephonyManager) {
    int i;
    byte b1 = 1;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    } 
    if (i > 1) {
      try {
        this.c.b(a(paramTelephonyManager, "getDeviceId", 1));
      } catch (a a) {}
    } else {
      return;
    } 
    try {
      b.b(this.c, b(paramTelephonyManager, "getSimState", 1));
    } catch (a a) {}
    SubscriptionInfo subscriptionInfo = a(paramList, 1);
    this.c.c(subscriptionInfo.getSimSlotIndex());
    this.c.e(subscriptionInfo.getSubscriptionId());
    if (a.a() == 0) {
      i = b1;
    } else {
      i = subscriptionInfo.getSubscriptionId();
    } 
    try {
      this.c.d(a(paramTelephonyManager, "getSubscriberId", subscriptionInfo.getSubscriptionId()));
    } catch (a a) {}
    try {
      this.c.f(a(paramTelephonyManager, "getSimOperator", subscriptionInfo.getSubscriptionId()));
    } catch (a a) {}
  }
  
  private boolean b(TelephonyManager paramTelephonyManager, String paramString, int paramInt) {
    boolean bool = true;
    Class<int> clazz = int.class;
    Object object = a(paramTelephonyManager, paramString, new Object[] { Integer.valueOf(paramInt) }, new Class[] { clazz });
    if (object == null || Integer.parseInt(object.toString()) != 5)
      bool = false; 
    return bool;
  }
  
  @SuppressLint({"NewApi"})
  private void d(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 22) {
      SubscriptionManager subscriptionManager = SubscriptionManager.from(paramContext.getApplicationContext());
      if (subscriptionManager != null)
        try {
          SubscriptionInfo subscriptionInfo = a(subscriptionManager, "getDefaultDataSubscriptionInfo", (Object[])null);
          if (subscriptionInfo != null)
            b.a(this.c, subscriptionInfo.getSimSlotIndex()); 
        } catch (Exception exception) {
          exception.printStackTrace();
        }  
      return;
    } 
    b.a(this.c, -1);
  }
  
  private void e(Context paramContext) {
    NetworkInfo networkInfo;
    ConnectivityManager connectivityManager = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (connectivityManager != null) {
      networkInfo = connectivityManager.getActiveNetworkInfo();
      if (networkInfo != null) {
        if (networkInfo.getType() == 1 && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
          b.b(this.c, 1);
          return;
        } 
      } else {
        return;
      } 
    } else {
      return;
    } 
    if (networkInfo.getType() == 0 && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
      b.b(this.c, 0);
      return;
    } 
    b.b(this.c, -1);
  }
  
  @SuppressLint({"NewApi"})
  private void f(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (telephonyManager != null) {
      List<SubscriptionInfo> list = h(paramContext);
      a(list, telephonyManager);
      b(list, telephonyManager);
    } 
  }
  
  private void g(Context paramContext) {
    boolean bool = true;
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    this.c.b(0);
    this.c.c(1);
    this.c.a(-1);
    try {
      String str = a(telephonyManager, "getDeviceId", 0);
      this.c.a(str);
      str = a(telephonyManager, "getDeviceId", 1);
      this.c.b(str);
    } catch (a a) {}
    try {
      String str = a(telephonyManager, "getSubscriberId", 0);
      this.c.c(str);
      str = a(telephonyManager, "getSubscriberId", 1);
      this.c.d(str);
    } catch (a a) {}
    try {
      boolean bool1 = b(telephonyManager, "getSimState", 0);
      this.c.a(bool1);
      bool1 = b(telephonyManager, "getSimState", 1);
      this.c.b(bool1);
    } catch (a a) {}
    try {
      String str = a(telephonyManager, "getSimOperator", 0);
      this.c.e(str);
      str = a(telephonyManager, "getSimOperator", 1);
      this.c.f(str);
      if (TextUtils.isEmpty(this.c.b()) && !TextUtils.isEmpty(this.c.c())) {
        this.c.a(this.c.a());
        this.c.b("");
        this.c.c(this.c.c());
        this.c.d("");
        this.c.b(this.c.h());
        this.c.c(-1);
        this.c.a(this.c.e());
        this.c.b(false);
        this.c.e(this.c.d());
        this.c.f("");
        this.c.a(this.c.g());
        return;
      } 
    } catch (a a) {}
  }
  
  @SuppressLint({"NewApi"})
  private List<SubscriptionInfo> h(Context paramContext) {
    List<SubscriptionInfo> list;
    SubscriptionManager subscriptionManager = SubscriptionManager.from(paramContext.getApplicationContext());
    paramContext = null;
    if (subscriptionManager != null)
      list = subscriptionManager.getActiveSubscriptionInfoList(); 
    return list;
  }
  
  private int i(Context paramContext) {
    byte b1;
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getApplicationContext().getSystemService("phone");
    if (telephonyManager == null)
      return -1; 
    try {
      String str = a(telephonyManager, "getDataNetworkType", a(paramContext).f());
      StringBuilder stringBuilder = new StringBuilder();
      this();
      h.b("UMCTelephonyManagement", stringBuilder.append("data dataNetworkType ---------").append(str).toString());
      b1 = Integer.parseInt(str);
      stringBuilder = new StringBuilder();
      this();
      h.b("UMCTelephonyManagement", stringBuilder.append("data dataNetworkType ---------").append(b1).toString());
    } catch (Exception exception) {
      h.a("UMCTelephonyManagement", "data dataNetworkType ----反射出错-----");
      exception.printStackTrace();
      b1 = -1;
    } 
    return b1;
  }
  
  public b a(Context paramContext) {
    if (this.c == null)
      b(paramContext); 
    return this.c;
  }
  
  public b b(Context paramContext) {
    if (System.currentTimeMillis() - b >= 5000L) {
      this.c = new b();
      if (Build.VERSION.SDK_INT >= 22) {
        f(paramContext);
      } else {
        g(paramContext);
      } 
      d(paramContext);
      e(paramContext);
      b = System.currentTimeMillis();
    } 
    return this;
  }
  
  public String c(Context paramContext) {
    switch (i(paramContext)) {
      default:
        return "0";
      case 1:
      case 2:
      case 4:
      case 7:
      case 11:
      case 16:
        return "1";
      case 3:
      case 5:
      case 6:
      case 8:
      case 9:
      case 10:
      case 12:
      case 14:
      case 15:
      case 17:
        return "2";
      case 13:
      case 18:
      case 19:
        break;
    } 
    return "3";
  }
  
  public static class a extends Exception {
    public a(String param1String) {
      super(param1String);
    }
  }
  
  public static class b {
    private String a = "";
    
    private String b = "";
    
    private String c = "";
    
    private String d = "";
    
    private boolean e = false;
    
    private boolean f = false;
    
    private int g = -1;
    
    private int h = -1;
    
    private int i = -1;
    
    private int j = -1;
    
    private String k = "";
    
    private String l = "";
    
    private int m = -1;
    
    private int n = -1;
    
    public String a() {
      return this.b;
    }
    
    protected void a(int param1Int) {
      this.m = param1Int;
    }
    
    protected void a(String param1String) {
      if (param1String != null)
        this.a = param1String; 
    }
    
    protected void a(boolean param1Boolean) {
      this.e = param1Boolean;
    }
    
    public String b() {
      return this.c;
    }
    
    protected void b(int param1Int) {
      this.g = param1Int;
    }
    
    protected void b(String param1String) {
      if (param1String != null)
        this.b = param1String; 
    }
    
    protected void b(boolean param1Boolean) {
      this.f = param1Boolean;
    }
    
    public String c() {
      return this.d;
    }
    
    protected void c(int param1Int) {
      this.h = param1Int;
    }
    
    protected void c(String param1String) {
      if (param1String != null)
        this.c = param1String; 
    }
    
    public String d() {
      return this.l;
    }
    
    protected void d(int param1Int) {
      this.i = param1Int;
    }
    
    protected void d(String param1String) {
      if (param1String != null)
        this.d = param1String; 
    }
    
    protected void e(int param1Int) {
      this.j = param1Int;
    }
    
    protected void e(String param1String) {
      if (param1String != null)
        this.k = param1String; 
    }
    
    public boolean e() {
      return this.f;
    }
    
    public int f() {
      return this.m;
    }
    
    public String f(int param1Int) {
      return (this.g == param1Int) ? this.c : ((this.h == param1Int) ? this.d : "");
    }
    
    protected void f(String param1String) {
      this.l = param1String;
    }
    
    public int g() {
      return this.g;
    }
    
    public String g(int param1Int) {
      return (this.g == param1Int) ? this.a : ((this.h == param1Int) ? this.b : "");
    }
    
    public int h() {
      return this.h;
    }
    
    public String h(int param1Int) {
      return (this.g == param1Int) ? this.k : ((this.h == param1Int) ? this.l : "");
    }
    
    public int i() {
      return ((!TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(this.c)) || (!TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.l))) ? 2 : ((!TextUtils.isEmpty(this.c) || !TextUtils.isEmpty(this.d) || !TextUtils.isEmpty(this.k) || !TextUtils.isEmpty(this.l)) ? 1 : 0);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sdk\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */