package com.unionpay.mobile.android.pro.pboc.engine;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.unionpay.mobile.android.fully.a;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.icfcc.a;
import com.unionpay.mobile.android.pboctransaction.remoteapdu.a;
import com.unionpay.mobile.android.pboctransaction.samsung.f;
import com.unionpay.mobile.android.pboctransaction.sdapdu.a;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
import java.util.HashMap;

public class b implements Handler.Callback, f.a {
  private a A = null;
  
  private boolean B = false;
  
  private final int a = 0;
  
  private final int b = 1;
  
  private final int c = 2;
  
  private final int d = 4;
  
  private final int e = 8;
  
  private int f = 0;
  
  private Context g = null;
  
  private Handler h = null;
  
  private ArrayList<c> i = null;
  
  private ArrayList<c> j = null;
  
  private ArrayList<c> k = null;
  
  private ArrayList<c> l = null;
  
  private ArrayList<c> m = null;
  
  private d n = null;
  
  private c o = null;
  
  private final com.unionpay.mobile.android.pboctransaction.b p = new c(this);
  
  private d q = null;
  
  private a r = null;
  
  private final com.unionpay.mobile.android.pboctransaction.b s = new d(this);
  
  private d t = null;
  
  private com.unionpay.mobile.android.pboctransaction.simapdu.b u = null;
  
  private final com.unionpay.mobile.android.pboctransaction.b v = new e(this);
  
  private d w = null;
  
  private com.unionpay.mobile.android.pboctransaction.samsung.b x = null;
  
  private f y = null;
  
  private final com.unionpay.mobile.android.pboctransaction.b z = new f(this);
  
  public b(Context paramContext, String paramString) {
    this.g = paramContext;
    this.h = new Handler(this);
    this.i = new ArrayList<c>(1);
    a a1 = (a)((BaseActivity)paramContext).a(UPPayEngine.class.toString());
    if (a("cn.gov.pbc.tsm.client.mobile.andorid", 1)) {
      this.o = (c)new a();
    } else {
      this.o = (c)new a();
    } 
    this.n = new d(this.o, a1, paramString);
    try {
      Class.forName("org.simalliance.openmobileapi.SEService");
      a a2 = new a();
      this();
      this.r = a2;
      d d2 = new d();
      this((c)this.r, a1, paramString);
      this.q = d2;
      this.u = com.unionpay.mobile.android.pboctransaction.simapdu.b.e();
      d2 = new d();
      this((c)this.u, a1, paramString);
      this.t = d2;
      if (a("com.unionpay.tsmservice", 18)) {
        f f1 = new f();
        this(this);
        this.y = f1;
        this.y.a(this.h);
        d d3 = new d();
        this((c)this.y, a1, paramString);
        this.w = d3;
        return;
      } 
      com.unionpay.mobile.android.model.b.aB = false;
      com.unionpay.mobile.android.pboctransaction.samsung.b b1 = new com.unionpay.mobile.android.pboctransaction.samsung.b();
      this();
      this.x = b1;
      d d1 = new d();
      this((c)this.x, a1, paramString);
      this.w = d1;
      this.z.b();
    } catch (ClassNotFoundException classNotFoundException) {
      this.s.b();
      this.v.b();
      this.z.b();
    } catch (Exception exception) {
      this.s.b();
      this.v.b();
      this.z.b();
    } 
  }
  
  private final void a(int paramInt) {
    switch (paramInt) {
      default:
        k.c("UPCardEngine", "sd");
        if (this.o != null)
          this.o.a(this.p, this.g); 
      case 8:
        return;
      case 1:
        k.c("UPCardEngine", "cmcc");
        if (a("com.unionpay.mobile.tsm", 12))
          if (this.r != null) {
            this.r.a(this.B);
            this.r.a(this.s, this.g);
          }  
        this.s.b();
      case 2:
        k.c("UPCardEngine", "ic");
        if (this.u != null) {
          if (b().contains("ZTE"))
            this.u.a(this.v, this.g); 
          this.v.b();
        } 
      case 4:
        break;
    } 
    k.c("UPCardEngine", "se");
    if (a("com.unionpay.tsmservice", 18) && this.y != null) {
      Log.e("uppay-spay", "type se  start init");
      this.y.a(this.z, this.g);
    } 
    if (this.x != null)
      this.z.b(); 
  }
  
  private boolean a(String paramString, int paramInt) {
    PackageManager.NameNotFoundException nameNotFoundException1;
    PackageManager.NameNotFoundException nameNotFoundException2 = null;
    boolean bool1 = false;
    try {
      PackageInfo packageInfo = this.g.getPackageManager().getPackageInfo(paramString, 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException null) {
      nameNotFoundException1 = nameNotFoundException2;
    } catch (Exception exception) {
      nameNotFoundException1 = nameNotFoundException2;
    } 
    boolean bool2 = bool1;
    if (nameNotFoundException1 != null) {
      k.a("tsm-client", "tsm version code=" + ((PackageInfo)nameNotFoundException1).versionCode);
      bool2 = bool1;
      if (((PackageInfo)nameNotFoundException1).versionCode >= paramInt)
        bool2 = true; 
    } 
    return bool2;
  }
  
  private static String b() {
    return Build.BRAND + "_" + Build.MODEL;
  }
  
  private void b(int paramInt) {
    if (paramInt == 1) {
      (new Thread(new g(this))).start();
      return;
    } 
    if (paramInt == 2) {
      (new Thread(new h(this))).start();
      return;
    } 
    if (paramInt == 4) {
      if (b().contains("ZTE"))
        (new Thread(new i(this))).start(); 
      return;
    } 
    if (paramInt == 8)
      (new Thread(new j(this))).start(); 
  }
  
  public final Bundle a(c paramc, String paramString1, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, String paramString2) {
    Bundle bundle = null;
    if (paramc != null) {
      String str;
      int i = paramc.c();
      int j = paramc.d();
      if (j == 1) {
        AppIdentification appIdentification = new AppIdentification(paramc.a(), null);
        if (paramc.d() == 1) {
          str = "2";
        } else {
          str = "1";
        } 
        if (i == 8)
          return this.n.a(appIdentification, paramString1, str, paramHashMap1, paramHashMap2, paramString2); 
        if (i == 4)
          return this.q.a(appIdentification, paramString1, str, paramHashMap1, paramHashMap2, paramString2); 
        if (i == 16)
          return this.t.a(appIdentification, paramString1, str, paramHashMap1, paramHashMap2, paramString2); 
        if (i == 1)
          return this.w.a(appIdentification, paramString1, str, paramHashMap1, paramHashMap2, paramString2); 
        if (i == 32)
          bundle = this.w.a(appIdentification, paramString1, "10", paramHashMap1, paramHashMap2, paramString2); 
        return bundle;
      } 
      if (j == 2) {
        str = str.a();
        bundle = this.n.a(Integer.parseInt(str), paramString1, paramHashMap2, paramString2);
      } 
    } 
    return bundle;
  }
  
  public final void a() {
    if (this.r != null) {
      this.r.a();
      this.r = null;
    } 
    if (this.o != null) {
      this.o.a();
      this.o = null;
    } 
    if (this.u != null) {
      this.u.a();
      this.u = null;
    } 
    if (this.x != null) {
      this.x.a();
      this.x = null;
    } 
    if (this.y != null) {
      this.y.a();
      this.y = null;
    } 
    this.g = null;
    this.A = null;
    this.h.removeCallbacksAndMessages(null);
    this.h = null;
    this.w = null;
    this.n = null;
    this.q = null;
    this.t = null;
    this.f = 0;
  }
  
  public final void a(Handler paramHandler, String paramString1, String paramString2) {
    if (com.unionpay.mobile.android.model.b.aA && com.unionpay.mobile.android.model.b.aB) {
      com.unionpay.mobile.android.model.b.bo = true;
      if (this.y != null && this.w != null) {
        this.y.a(paramHandler);
        this.y.b(paramString1);
        this.y.c(paramString2);
        Log.e("uppay-spay", "tsmservice  get spay card list");
        this.w.b();
      } 
    } 
  }
  
  public final void a(a parama, boolean paramBoolean) {
    this.B = paramBoolean;
    this.A = parama;
    this.f = 0;
    a(0);
  }
  
  public final void a(boolean paramBoolean) {
    k.c("uppay", "startReadList  spay");
    com.unionpay.mobile.android.model.b.aB = paramBoolean;
    b(8);
  }
  
  public boolean handleMessage(Message paramMessage) {
    k.c("UPCardEngine", " msg.what = " + paramMessage.what);
    if (paramMessage.what == 1 || paramMessage.what == 2 || paramMessage.what == 4 || paramMessage.what == 8) {
      this.f ^= paramMessage.what;
      k.c("UPCardEngine", " mTag = " + this.f);
      if (paramMessage.obj != null)
        if (paramMessage.what == 1) {
          this.j = (ArrayList<c>)paramMessage.obj;
        } else if (paramMessage.what == 2) {
          this.k = (ArrayList<c>)paramMessage.obj;
        } else if (paramMessage.what == 4) {
          this.l = (ArrayList<c>)paramMessage.obj;
        } else if (paramMessage.what == 8) {
          this.m = (ArrayList<c>)paramMessage.obj;
        }  
      a(paramMessage.what);
    } 
    if (this.f == 15 && this.A != null) {
      if (this.j != null && this.j.size() > 0)
        this.i.addAll(this.j); 
      if (this.k != null && this.k.size() > 0)
        this.i.addAll(this.k); 
      if (this.l != null && this.l.size() > 0)
        this.i.addAll(this.l); 
      if (this.m != null && this.m.size() > 0)
        this.i.addAll(this.m); 
      this.A.a(this.i);
    } 
    return true;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\pboc\engine\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */