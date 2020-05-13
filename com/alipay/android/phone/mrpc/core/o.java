package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

public final class o extends t {
  private String b;
  
  private byte[] c;
  
  private String d;
  
  private ArrayList<Header> e;
  
  private Map<String, String> f;
  
  private boolean g;
  
  public o(String paramString) {
    this.b = paramString;
    this.e = new ArrayList<Header>();
    this.f = new HashMap<String, String>();
    this.d = "application/x-www-form-urlencoded";
  }
  
  public final String a() {
    return this.b;
  }
  
  public final void a(String paramString) {
    this.d = paramString;
  }
  
  public final void a(String paramString1, String paramString2) {
    if (this.f == null)
      this.f = new HashMap<String, String>(); 
    this.f.put(paramString1, paramString2);
  }
  
  public final void a(Header paramHeader) {
    this.e.add(paramHeader);
  }
  
  public final void a(boolean paramBoolean) {
    this.g = paramBoolean;
  }
  
  public final void a(byte[] paramArrayOfbyte) {
    this.c = paramArrayOfbyte;
  }
  
  public final String b(String paramString) {
    return (this.f == null) ? null : this.f.get(paramString);
  }
  
  public final byte[] b() {
    return this.c;
  }
  
  public final String c() {
    return this.d;
  }
  
  public final ArrayList<Header> d() {
    return this.e;
  }
  
  public final boolean e() {
    return this.g;
  }
  
  public final boolean equals(Object paramObject) {
    boolean bool = true;
    if (this != paramObject) {
      if (paramObject == null)
        return false; 
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      if (this.c == null) {
        if (((o)paramObject).c != null)
          return false; 
      } else if (!this.c.equals(((o)paramObject).c)) {
        return false;
      } 
      if (this.b == null) {
        if (((o)paramObject).b != null)
          bool = false; 
        return bool;
      } 
      if (!this.b.equals(((o)paramObject).b))
        bool = false; 
    } 
    return bool;
  }
  
  public final int hashCode() {
    int i = 1;
    int j = i;
    if (this.f != null) {
      j = i;
      if (this.f.containsKey("id"))
        j = ((String)this.f.get("id")).hashCode() + 31; 
    } 
    if (this.b == null) {
      i = 0;
      return i + j * 31;
    } 
    i = this.b.hashCode();
    return i + j * 31;
  }
  
  public final String toString() {
    return String.format("Url : %s,HttpHeader: %s", new Object[] { this.b, this.e });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\android\phone\mrpc\core\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */