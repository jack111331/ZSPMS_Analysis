package com.unionpay.mobile.android.hce;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.c;
import com.unionpay.mobile.android.utils.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
  private static final Object w = new Object();
  
  private Context a;
  
  private a b;
  
  private Handler c;
  
  private String d;
  
  private String e;
  
  private int f = 0;
  
  private int g = 0;
  
  private int h = 10;
  
  private int i = 1000;
  
  private String j = "hce";
  
  private String k = "";
  
  private String l;
  
  private String m = "";
  
  private HashMap<String, k> n = new HashMap<String, k>(0);
  
  private List<k> o = new ArrayList<k>(0);
  
  private HashMap<Integer, k> p = new HashMap<Integer, k>(0);
  
  private int q = 0;
  
  private int r = 1;
  
  private int s = 0;
  
  private int t = 5;
  
  private ConcurrentHashMap<String, d> u = new ConcurrentHashMap<String, d>(0);
  
  private ConcurrentHashMap<String, l> v = new ConcurrentHashMap<String, l>(0);
  
  private final Handler.Callback x = new g(this);
  
  private Handler y;
  
  public f(Context paramContext) {
    this.a = paramContext;
    this.y = new Handler(this.x);
    this.l = "20150801000000000000";
    this.b = (a)((BaseActivity)paramContext).a(UPPayEngine.class.toString());
  }
  
  private Bundle a(String paramString, int paramInt1, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putString("action_resp_code", "0000");
    try {
      JSONObject jSONObject1 = new JSONObject();
      this();
      jSONObject1.put("v", "1.9");
      jSONObject1.put("cmd", this.j);
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject1.put("params", jSONObject2);
      jSONObject2.put("base_version", paramString);
      jSONObject2.put("page", paramInt1);
      jSONObject2.put("size", paramInt2);
      paramString = jSONObject1.toString();
      bundle.putString("action_resp_message", this.b.a(paramString));
      a(bundle);
      this.f++;
      if (this.f <= this.g)
        a(this.l, this.f, this.h); 
    } catch (JSONException jSONException) {
      bundle.putString("action_resp_code", "10019");
    } 
    return bundle;
  }
  
  private boolean a(Bundle paramBundle) {
    String str1 = paramBundle.getString("action_resp_code");
    String str2 = paramBundle.getString("action_resp_message");
    if ("0000".equalsIgnoreCase(str1) && str2 != null)
      try {
        JSONObject jSONObject = new JSONObject();
        this(str2);
        str2 = j.a(jSONObject, "resp");
        j.a(jSONObject, "msg");
        jSONObject = j.c(jSONObject, "params");
        if (str2.equalsIgnoreCase("00")) {
          this.d = j.c(jSONObject, "signature").toString();
          JSONArray jSONArray = j.d(jSONObject, "configs");
          if (jSONArray != null)
            for (byte b = 0; b < jSONArray.length(); b++) {
              JSONObject jSONObject1 = jSONArray.getJSONObject(b);
              List<k> list = this.o;
              k k = new k();
              this(jSONObject1);
              list.add(k);
              this.m = j.a(jSONObject, "version");
            }  
          int i = Integer.decode(j.a(jSONObject, "total_count")).intValue();
          if (i > this.h)
            this.g = i / this.h; 
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  private boolean a(String paramString1, String paramString2) {
    boolean bool;
    i i = new i(this, paramString1, paramString2);
    d d = new d(paramString1);
    d.a(i);
    this.u.put(paramString1, d);
    try {
      Intent intent = new Intent();
      this();
      intent.setAction("com.unionpay.uppay.action.HCE");
      intent.setPackage(paramString1);
      this.a.startService(intent);
      bool = this.a.bindService(intent, i, 1);
    } catch (Exception exception) {
      bool = false;
    } 
    return bool;
  }
  
  public final void a() {
    this.f = 1;
  }
  
  public final void a(int paramInt) {
    this.h = paramInt;
  }
  
  public final void a(Handler paramHandler) {
    this.c = paramHandler;
  }
  
  public final void a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      this.j = paramString; 
  }
  
  public final void b() {
    if (this.q == 0) {
      b.bl = true;
      if (this.c != null) {
        Message message = this.c.obtainMessage(0);
        this.c.sendMessage(message);
      } 
      return;
    } 
    synchronized (w) {
      for (int i = this.r; i <= this.q && this.s < this.t; i++) {
        k k = this.p.get(Integer.valueOf(i));
        String str2 = k.b();
        String str1 = k.d();
        this.s++;
        h h = new h();
        this(this, str2, str1);
        h.start();
        this.r++;
      } 
      return;
    } 
  }
  
  public final void b(int paramInt) {
    if (paramInt > 0)
      this.i = paramInt; 
  }
  
  public final void b(String paramString) {
    this.e = paramString;
  }
  
  public final void c() {
    if (b.bb != null) {
      b.bb.clear();
      b.bb = null;
    } 
    String str1 = PreferenceUtils.a(this.a, "hce_version");
    if (!TextUtils.isEmpty(str1))
      this.l = str1; 
    String str2 = PreferenceUtils.a(this.a, "hce_info");
    str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = "[{\"package\":\"com.yitong.mbank0408\",\"issuer\":\"64083300\",\"syn_key\":\"0123456789ABCDEF1010101010101010\",\"pub_key\":\"268576AF6F50DA40196E18D6E059D2A721373638\",\"status\":\"I\",\"priority\":\"1\"}]"; 
    try {
      JSONArray jSONArray = new JSONArray();
      this(str1);
      for (byte b = 0; b < jSONArray.length(); b++) {
        JSONObject jSONObject = jSONArray.getJSONObject(b);
        k k = new k();
        this(jSONObject);
        this.n.put(k.b(), k);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    (new Thread(new j(this))).start();
  }
  
  public final void c(int paramInt) {
    if (paramInt > 0)
      this.t = paramInt; 
  }
  
  public final void c(String paramString) {
    this.k = paramString;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\hce\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */