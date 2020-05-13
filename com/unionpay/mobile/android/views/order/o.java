package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.resource.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class o extends LinearLayout {
  private Context a;
  
  private int b = l.a.intValue();
  
  private int c = l.a.intValue();
  
  private JSONObject d;
  
  private JSONObject e;
  
  private JSONObject f;
  
  private Drawable g;
  
  private JSONArray h;
  
  private List<Map<String, Object>> i;
  
  private String j;
  
  private AbstractMethod k;
  
  private CViewMethods l;
  
  private Drawable m;
  
  private boolean n;
  
  private o(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    setOrientation(1);
  }
  
  public static o a(Context paramContext, Drawable paramDrawable) {
    o o1 = new o(paramContext);
    o1.g = paramDrawable;
    return o1;
  }
  
  public static o a(Context paramContext, Drawable paramDrawable1, Drawable paramDrawable2) {
    o o1 = new o(paramContext);
    o1.m = paramDrawable2;
    o1.b = l.c.intValue();
    o1.c = l.c.intValue();
    o1.g = paramDrawable1;
    o1.c();
    return o1;
  }
  
  public static o a(Context paramContext, JSONArray paramJSONArray, List<Map<String, Object>> paramList, Drawable paramDrawable1, Drawable paramDrawable2, String paramString) {
    o o1 = new o(paramContext);
    o1.m = paramDrawable2;
    o1.b = l.b.intValue();
    o1.c = l.b.intValue();
    o1.g = paramDrawable1;
    o1.h = paramJSONArray;
    o1.i = paramList;
    o1.j = paramString;
    o1.c();
    return o1;
  }
  
  public static o b(Context paramContext, JSONArray paramJSONArray, List<Map<String, Object>> paramList, Drawable paramDrawable1, Drawable paramDrawable2, String paramString) {
    o o1 = new o(paramContext);
    o1.m = paramDrawable2;
    o1.b = l.e.intValue();
    o1.c = l.e.intValue();
    o1.g = paramDrawable1;
    o1.h = paramJSONArray;
    o1.i = paramList;
    o1.j = paramString;
    o1.c();
    return o1;
  }
  
  public final int a() {
    return this.b;
  }
  
  public final o a(int paramInt) {
    this.c = paramInt;
    return this;
  }
  
  public final o a(Drawable paramDrawable) {
    this.m = paramDrawable;
    return this;
  }
  
  public final o a(a parama) {
    if (this.k != null) {
      this.k.a(parama);
      this.k.a(parama);
      if (this.k instanceof b)
        ((b)this.k).a(parama); 
    } 
    if (this.l != null)
      this.l.a(parama); 
    return this;
  }
  
  public final o a(String paramString) {
    this.j = paramString;
    return this;
  }
  
  public final o a(List<Map<String, Object>> paramList) {
    this.i = paramList;
    return this;
  }
  
  public final o a(JSONArray paramJSONArray) {
    this.h = paramJSONArray;
    return this;
  }
  
  public final o a(JSONObject paramJSONObject) {
    this.d = paramJSONObject;
    if (this.k != null && this.k instanceof b)
      ((b)this.k).a(this.d); 
    return this;
  }
  
  public final o a(boolean paramBoolean) {
    this.n = paramBoolean;
    return this;
  }
  
  public final o b(int paramInt) {
    this.b = paramInt;
    return this;
  }
  
  public final o b(Drawable paramDrawable) {
    if (this.k != null)
      this.k.a(paramDrawable); 
    return this;
  }
  
  public final o b(JSONObject paramJSONObject) {
    this.e = paramJSONObject;
    if (this.k != null && this.k instanceof i)
      ((i)this.k).a(this.e); 
    return this;
  }
  
  public final String b() {
    String str1 = null;
    String str2 = str1;
    if (this.k != null) {
      str2 = str1;
      if (this.k instanceof i)
        str2 = ((i)this.k).h(); 
    } 
    return str2;
  }
  
  public final void b(String paramString) {
    ((b)this.k).b(paramString);
  }
  
  public final o c(JSONObject paramJSONObject) {
    this.f = paramJSONObject;
    if (this.k != null && this.k instanceof i)
      ((i)this.k).b(this.f); 
    return this;
  }
  
  public final void c() {
    this.k = null;
    if (this.b == l.b.intValue()) {
      this.c &= l.b.intValue() ^ 0xFFFFFFFF;
      b b = new b(this.a, this.i, this.j);
      b.d(c.bD.by);
      b.e(c.bD.bz);
      b.a(this.d);
      b.a(this.h);
      b.b(this.n);
      b.b(c.a(this.a).a(2014));
      c c = c.a(this.a);
      b.a(c.a(1015), c.a(1016), c.a(1002));
      this.k = b;
    } else if (this.b == l.c.intValue()) {
      this.c &= l.c.intValue() ^ 0xFFFFFFFF;
      i i = new i(this.a);
      i.b(c.bD.bA);
      i.d(c.bD.bB);
      i.a(this.e);
      i.b(this.f);
      this.k = i;
    } else if (this.b == l.e.intValue()) {
      this.c &= l.e.intValue() ^ 0xFFFFFFFF;
      b b = new b(this.a, this.i, "");
      b.d("");
      b.e(c.bD.bz);
      b.a((JSONObject)null);
      b.a(this.h);
      b.b(l.e.intValue());
      b.f("");
      b.b(c.a(this.a).a(2014));
      c c = c.a(this.a);
      b.a(c.a(1015), c.a(1016), c.a(1002));
      this.k = b;
    } 
    if (this.k != null) {
      this.k.a();
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
      layoutParams.topMargin = b.a;
      addView((View)this.k, (ViewGroup.LayoutParams)layoutParams);
    } 
    if (this.b != l.e.intValue()) {
      this.l = new CViewMethods(this.a);
      this.l.a(this.g);
      this.l.a(this.c);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      hashMap.put(l.b, c.bD.by);
      if (c.bD.bp != null && !TextUtils.isEmpty(c.bD.bp)) {
        hashMap.put(l.d, c.bD.bp);
      } else {
        hashMap.put(l.d, c.bD.bo);
      } 
      hashMap.put(l.c, c.bD.bA);
      if (c.bD.br != null && !TextUtils.isEmpty(c.bD.br)) {
        hashMap.put(l.e, c.bD.br);
      } else {
        hashMap.put(l.e, c.bD.bq);
      } 
      hashMap.put(l.f, c.bD.bt);
      this.l.a((HashMap)hashMap);
      hashMap = new HashMap<Object, Object>();
      hashMap.put(l.b, this.m);
      hashMap.put(l.d, this.m);
      hashMap.put(l.c, this.m);
      hashMap.put(l.e, this.m);
      hashMap.put(l.f, this.m);
      this.l.b((HashMap)hashMap);
      this.l.a(c.bD.bC).a();
      LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
      addView((View)this.l, (ViewGroup.LayoutParams)layoutParams);
    } 
  }
  
  public final void c(int paramInt) {
    if (this.k != null && this.k instanceof b)
      ((b)this.k).a(paramInt); 
  }
  
  public static interface a extends AbstractMethod.a, AbstractMethod.b, CViewMethods.a, b.b {}
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\views\order\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */