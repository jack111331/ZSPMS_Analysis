package com.unionpay.mobile.android.net;

import android.content.Context;
import android.text.TextUtils;
import com.unionpay.mobile.android.utils.c;
import java.util.HashMap;

public final class d {
  private int a;
  
  private String b;
  
  private HashMap<String, String> c;
  
  private byte[] d;
  
  private String e;
  
  private String f;
  
  public d(int paramInt, String paramString, byte[] paramArrayOfbyte) {
    this.a = paramInt;
    this.b = paramString;
    this.c = null;
    this.d = paramArrayOfbyte;
  }
  
  public d(String paramString) {
    this.a = 1;
    this.b = paramString;
    this.c = null;
    this.d = null;
  }
  
  public final int a() {
    return this.a;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2) {
    this.f = "?" + c.d(paramString1) + "&0," + c.b(paramContext) + "&" + c.e(paramString2);
  }
  
  public final void a(String paramString) {
    if (paramString != null) {
      this.e = paramString;
      this.d = paramString.getBytes();
    } 
  }
  
  public final void a(HashMap<String, String> paramHashMap) {
    this.c = paramHashMap;
  }
  
  public final String b() {
    return !TextUtils.isEmpty(this.f) ? (this.b + this.f) : this.b;
  }
  
  public final String c() {
    return this.e;
  }
  
  public final HashMap<String, String> d() {
    return this.c;
  }
  
  public final byte[] e() {
    return this.d;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\net\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */