package com.unionpay.mobile.android.hce;

import android.content.ServiceConnection;
import com.unionpay.mobile.android.hce.service.a;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;

public final class c implements d {
  private String a;
  
  private String b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private a g;
  
  private ServiceConnection h;
  
  public c(JSONObject paramJSONObject, String paramString, a parama, ServiceConnection paramServiceConnection) {
    this.a = j.a(paramJSONObject, "num");
    this.b = j.a(paramJSONObject, "name");
    this.d = j.a(paramJSONObject, "type");
    String str = j.a(paramJSONObject, "type");
    if (e.a.equals(str)) {
      str = e.e;
    } else if (e.b.equals(str)) {
      str = e.f;
    } else if (e.c.equals(str)) {
      str = e.g;
    } else if (e.d.equals(str)) {
      str = e.h;
    } else {
      str = "";
    } 
    this.c = str;
    this.e = j.a(paramJSONObject, "instNum");
    this.f = paramString;
    this.g = parama;
    this.h = paramServiceConnection;
  }
  
  public final String a() {
    return this.a;
  }
  
  public final String b() {
    return this.b;
  }
  
  public final String c() {
    return this.c;
  }
  
  public final String d() {
    return this.d;
  }
  
  public final String e() {
    return this.e;
  }
  
  public final String f() {
    return this.f;
  }
  
  public final a g() {
    return this.g;
  }
  
  public final ServiceConnection h() {
    return this.h;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */