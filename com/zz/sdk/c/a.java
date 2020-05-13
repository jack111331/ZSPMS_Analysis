package com.zz.sdk.c;

import android.content.Context;
import android.util.Log;
import com.zz.sdk.b.v;
import com.zz.sdk.i.cp;
import com.zz.sdk.i.cq;

public class a {
  private static String a = "zz_sdk.hpa";
  
  private static volatile a b;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/zz/sdk/c/a.b : Lcom/zz/sdk/c/a;
    //   3: ifnonnull -> 30
    //   6: ldc com/zz/sdk/c/a
    //   8: monitorenter
    //   9: getstatic com/zz/sdk/c/a.b : Lcom/zz/sdk/c/a;
    //   12: ifnonnull -> 27
    //   15: new com/zz/sdk/c/a
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/zz/sdk/c/a.b : Lcom/zz/sdk/c/a;
    //   27: ldc com/zz/sdk/c/a
    //   29: monitorexit
    //   30: getstatic com/zz/sdk/c/a.b : Lcom/zz/sdk/c/a;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/zz/sdk/c/a
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void a(Context paramContext, long paramLong, com.zz.sdk.listener.a parama) {
    Log.d(a, "uploadTouristStatus");
    z z = new z(this, paramContext, paramLong, parama);
    cp.a().a(z);
  }
  
  public void a(Context paramContext, v paramv, com.zz.sdk.listener.a parama) {
    Log.d(a, "doLogin 1");
    x x = new x(this, paramContext, paramv, parama);
    cp.a().a(x);
  }
  
  public void a(Context paramContext, com.zz.sdk.listener.a parama) {
    Log.d(a, "regGetCode");
    y y = new y(this, paramContext, parama);
    cp.a().a(y);
  }
  
  public void a(Context paramContext, com.zz.sdk.third.a.a parama, com.zz.sdk.listener.a parama1) {
    Log.d(a, "doLogin 2");
    ab ab = new ab(this, paramContext, parama, parama1);
    cp.a().a(ab);
  }
  
  public void a(Context paramContext, String paramString1, int paramInt, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "getVoiceCode");
    ag ag = new ag(this, paramContext, paramString1, paramInt, paramString2, parama);
    cp.a().a(ag);
  }
  
  public void a(Context paramContext, String paramString, com.zz.sdk.listener.a parama) {
    Log.d(a, "loginPhone");
    c c = new c(this, paramContext, paramString, parama);
    cp.a().a(c);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, int paramInt, com.zz.sdk.listener.a parama) {
    Log.d(a, "getPhoneCode");
    i i = new i(this, paramContext, paramString1, paramString2, paramInt, parama);
    cp.a().a(i);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "doLogin 3");
    ac ac = new ac(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(ac);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, com.zz.sdk.listener.a parama) {
    Log.d(a, "verifyPhoneCode");
    r r = new r(this, paramContext, paramString1, paramString2, paramString3, paramInt, parama);
    cp.a().a(r);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, com.zz.sdk.listener.a parama) {
    Log.d(a, "modifyPassword");
    ad ad = new ad(this, paramContext, paramString1, paramString2, paramString3, parama);
    cp.a().a(ad);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, com.zz.sdk.listener.a parama) {
    Log.d(a, "changePhone");
    w w = new w(this, paramContext, paramString1, paramString2, paramString3, paramString4, paramInt, parama);
    cp.a().a(w);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.zz.sdk.listener.a parama) {
    Log.d(a, "register");
    b b = new b(this, paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    cp.a().a(b);
  }
  
  public void a(cq paramcq, com.zz.sdk.listener.a parama) {
    Log.d(a, "quickLogin");
    ae ae = new ae(this, paramcq, parama);
    cp.a().a(ae);
  }
  
  public void b(Context paramContext, String paramString, com.zz.sdk.listener.a parama) {
    Log.d(a, "getPhoneCode");
    h h = new h(this, paramContext, paramString, parama);
    cp.a().a(h);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "loginPhone");
    af af = new af(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(af);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3, com.zz.sdk.listener.a parama) {
    Log.d(a, "installUser");
    d d = new d(this, paramContext, paramString1, paramString2, paramString3, parama);
    cp.a().a(d);
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.zz.sdk.listener.a parama) {
    Log.d(a, "registerPhone");
    m m = new m(this, paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    cp.a().a(m);
  }
  
  public void c(Context paramContext, String paramString, com.zz.sdk.listener.a parama) {
    Log.d(a, "getUserDetail");
    k k = new k(this, paramContext, paramString, parama);
    cp.a().a(k);
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "getCode");
    e e = new e(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(e);
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3, com.zz.sdk.listener.a parama) {
    Log.d(a, "reBindAccount");
    g g = new g(this, paramContext, paramString1, paramString2, paramString3, parama);
    cp.a().a(g);
  }
  
  public void c(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, com.zz.sdk.listener.a parama) {
    Log.d(a, "bindPhoneNum");
    j j = new j(this, paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, parama);
    cp.a().a(j);
  }
  
  public void d(Context paramContext, String paramString, com.zz.sdk.listener.a parama) {
    Log.d(a, "findPwdGetCode");
    p p = new p(this, paramContext, paramString, parama);
    cp.a().a(p);
  }
  
  public void d(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "getReBindPhoneCode");
    f f = new f(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(f);
  }
  
  public void d(Context paramContext, String paramString1, String paramString2, String paramString3, com.zz.sdk.listener.a parama) {
    Log.d(a, "getRealNameCode");
    q q = new q(this, paramContext, paramString1, paramString2, paramString3, parama);
    cp.a().a(q);
  }
  
  public void e(Context paramContext, String paramString, com.zz.sdk.listener.a parama) {
    Log.d(a, "registerGetCode");
    s s = new s(this, paramContext, paramString, parama);
    cp.a().a(s);
  }
  
  public void e(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "authCode");
    l l = new l(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(l);
  }
  
  public void f(Context paramContext, String paramString, com.zz.sdk.listener.a parama) {
    Log.d(a, "sendEmailCode");
    t t = new t(this, paramContext, paramString, parama);
    cp.a().a(t);
  }
  
  public void f(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "bindEmail");
    n n = new n(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(n);
  }
  
  public void g(Context paramContext, String paramString, com.zz.sdk.listener.a parama) {
    Log.d(a, "recentGame");
    v v = new v(this, paramContext, paramString, parama);
    cp.a().a(v);
  }
  
  public void g(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "getRealNameState");
    o o = new o(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(o);
  }
  
  public void h(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "verifyEmailCode");
    u u = new u(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(u);
  }
  
  public void i(Context paramContext, String paramString1, String paramString2, com.zz.sdk.listener.a parama) {
    Log.d(a, "kickOffRpt");
    aa aa = new aa(this, paramContext, paramString1, paramString2, parama);
    cp.a().a(aa);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */