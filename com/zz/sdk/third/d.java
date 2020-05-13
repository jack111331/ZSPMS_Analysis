package com.zz.sdk.third;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.zz.sdk.i.cv;
import com.zz.sdk.third.b.a;
import com.zz.sdk.third.b.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class d implements a {
  private static final Map a = new HashMap<Object, Object>();
  
  private final Map b = new HashMap<Object, Object>();
  
  private b c = null;
  
  private Activity d;
  
  public d(Activity paramActivity) {
    this.d = paramActivity;
  }
  
  public static void a(Activity paramActivity) {
    if (paramActivity != null) {
      a a1 = (a)a.get(paramActivity);
      if (a1 != null)
        a1.a(); 
    } 
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramActivity != null) {
      a a1 = (a)a.get(paramActivity);
      if (a1 != null)
        a1.a(paramInt1, paramInt2, paramIntent); 
    } 
  }
  
  public static void a(Activity paramActivity, Intent paramIntent) {
    if (paramActivity != null) {
      a a1 = (a)a.get(paramActivity);
      if (a1 != null)
        a1.a(paramIntent); 
    } 
  }
  
  public static void a(Activity paramActivity, @NonNull c paramc, c paramc1) {
    if (paramActivity == null) {
      if (paramc1 != null)
        paramc1.a(paramc, null); 
      return;
    } 
    a a1 = (a)a.get(paramActivity);
    a a2 = a1;
    if (a1 == null) {
      a2 = new d(paramActivity);
      a.put(paramActivity, a2);
    } 
    a2.a(paramc, paramc1);
  }
  
  public static void b(Activity paramActivity) {
    if (paramActivity != null) {
      a a1 = (a)a.get(paramActivity);
      if (a1 != null)
        a1.b(); 
    } 
  }
  
  public static void c(Activity paramActivity) {
    if (paramActivity != null) {
      a a1 = (a)a.get(paramActivity);
      if (a1 != null)
        a1.c(); 
    } 
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {
    if (this.c != null)
      this.c.a(paramInt1, paramInt2, paramIntent); 
  }
  
  public void a(Intent paramIntent) {
    if (this.c != null)
      this.c.a(paramIntent); 
  }
  
  public void a(c paramc, c paramc1) {
    if (this.b.containsKey(paramc)) {
      this.c = (b)this.b.get(paramc);
      if (this.c == null) {
        paramc1.a(paramc, null);
        return;
      } 
      this.c.a(paramc1);
      return;
    } 
    this.c = e.a(this.d, paramc, cv.g());
    if (this.c == null) {
      paramc1.a(paramc, null);
    } else {
      this.c.a(paramc1);
    } 
    this.b.put(paramc, this.c);
  }
  
  public void b() {}
  
  public void c() {
    Iterator<Map.Entry> iterator = this.b.entrySet().iterator();
    while (iterator.hasNext()) {
      b b1 = (b)((Map.Entry)iterator.next()).getValue();
      if (b1 != null)
        b1.b(); 
    } 
    this.b.clear();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\third\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */