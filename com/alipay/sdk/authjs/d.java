package com.alipay.sdk.authjs;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
  c a;
  
  Context b;
  
  public d(Context paramContext, c paramc) {
    this.b = paramContext;
    this.a = paramc;
  }
  
  private static void a(Runnable paramRunnable) {
    boolean bool;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      paramRunnable.run();
      return;
    } 
    (new Handler(Looper.getMainLooper())).post(paramRunnable);
  }
  
  private void a(String paramString) {
    try {
      JSONObject jSONObject = new JSONObject();
      this(paramString);
      String str = jSONObject.getString("clientId");
      try {
        if (!TextUtils.isEmpty(str)) {
          JSONObject jSONObject1 = jSONObject.getJSONObject("param");
          if (jSONObject1 instanceof JSONObject) {
            jSONObject1 = jSONObject1;
          } else {
            jSONObject1 = null;
          } 
          String str1 = jSONObject.getString("func");
          String str2 = jSONObject.getString("bundleName");
          a a = new a();
          this("call");
          a.j = str2;
          a.k = str1;
          a.m = jSONObject1;
          a.i = str;
          a(a);
        } 
        return;
      } catch (Exception exception1) {
        String str1 = str;
      } 
    } catch (Exception exception) {
      exception = null;
    } 
    if (!TextUtils.isEmpty((CharSequence)exception))
      try {
        a((String)exception, a.a.d);
      } catch (JSONException jSONException) {} 
  }
  
  private int b(a parama) {
    if (parama != null && "toast".equals(parama.k)) {
      JSONObject jSONObject = parama.m;
      String str = jSONObject.optString("content");
      int i = jSONObject.optInt("duration");
      boolean bool = true;
      if (i < 2500)
        bool = false; 
      Toast.makeText(this.b, str, bool).show();
      (new Timer()).schedule(new f(this, parama), bool);
    } 
    return a.a.a;
  }
  
  private void c(a parama) {
    JSONObject jSONObject = parama.m;
    String str = jSONObject.optString("content");
    int i = jSONObject.optInt("duration");
    boolean bool = true;
    if (i < 2500)
      bool = false; 
    Toast.makeText(this.b, str, bool).show();
    (new Timer()).schedule(new f(this, parama), bool);
  }
  
  public final void a(a parama) throws JSONException {
    boolean bool;
    if (TextUtils.isEmpty(parama.k)) {
      a(parama.i, a.a.c);
      return;
    } 
    e e = new e(this, parama);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool) {
      e.run();
      return;
    } 
    (new Handler(Looper.getMainLooper())).post(e);
  }
  
  public final void a(String paramString, int paramInt) throws JSONException {
    if (!TextUtils.isEmpty(paramString)) {
      JSONObject jSONObject = new JSONObject();
      jSONObject.put("error", paramInt - 1);
      a a = new a("callback");
      a.m = jSONObject;
      a.i = paramString;
      this.a.a(a);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\authjs\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */