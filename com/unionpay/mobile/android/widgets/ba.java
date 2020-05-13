package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.sdk.UPAgent;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

abstract class ba extends LinearLayout {
  private String a;
  
  private String b;
  
  private String c;
  
  protected Context d;
  
  protected int e;
  
  protected int f;
  
  protected String g;
  
  protected String h;
  
  protected boolean i;
  
  protected String j;
  
  protected LinearLayout k;
  
  protected TextView l;
  
  protected RelativeLayout m;
  
  protected JSONObject n;
  
  private String o;
  
  private TextView p;
  
  private ImageView q;
  
  private boolean r;
  
  private String s;
  
  public ba(Context paramContext, JSONObject paramJSONObject, String paramString) {
    super(paramContext);
    boolean bool;
    this.d = null;
    this.e = -16777216;
    this.f = -7829368;
    this.a = null;
    this.g = null;
    this.b = null;
    this.h = null;
    this.c = null;
    this.o = null;
    this.i = false;
    this.j = null;
    this.p = null;
    this.k = null;
    this.l = null;
    this.q = null;
    this.m = null;
    this.r = false;
    this.s = "uppay";
    this.n = paramJSONObject;
    this.d = paramContext;
    this.h = j.a(paramJSONObject, "label");
    this.o = j.a(paramJSONObject, "placeholder");
    this.c = j.a(paramJSONObject, "tip");
    this.a = j.a(paramJSONObject, "name");
    this.g = j.a(paramJSONObject, "value");
    this.b = j.a(paramJSONObject, "type");
    this.j = j.a(paramJSONObject, "regexp");
    String str = j.a(paramJSONObject, "readonly");
    if (str != null && str.equalsIgnoreCase("true"))
      this.i = true; 
    if (j.a(paramJSONObject, "margin").length() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    this.r = bool;
    this.s = paramString;
    Context context = this.d;
    setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    setBackgroundColor(0);
    setOrientation(1);
    setPadding(2, 2, 2, 2);
    if (!this.b.equalsIgnoreCase("string")) {
      if (!a(this, this.h)) {
        this.p = new TextView(this.d);
        this.p.setTextSize(20.0F);
        this.p.setText("");
        this.p.setTextColor(this.e);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = com.unionpay.mobile.android.global.a.f;
        addView((View)this.p, (ViewGroup.LayoutParams)layoutParams);
        if (this.h == null || this.h.length() == 0) {
          this.p.setVisibility(8);
        } else {
          this.p.setText(this.h);
          this.p.setVisibility(8);
        } 
      } 
      a();
      if (!b_()) {
        this.k = new LinearLayout(this.d);
        this.k.setBackgroundColor(-267336);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        addView((View)this.k, (ViewGroup.LayoutParams)layoutParams);
        this.l = new TextView(this.d);
        this.l.setTextSize(15.0F);
        this.l.setTextColor(this.f);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = g.a(this.d, 10.0F);
        layoutParams.rightMargin = i;
        layoutParams.leftMargin = i;
        i = g.a(this.d, 5.0F);
        layoutParams.bottomMargin = i;
        layoutParams.topMargin = i;
        this.k.addView((View)this.l, (ViewGroup.LayoutParams)layoutParams);
        if (this.c == null || this.c.length() <= 0) {
          this.k.setVisibility(8);
          this.q.setVisibility(8);
          return;
        } 
      } else {
        return;
      } 
      this.q.setVisibility(0);
      this.l.setText(this.c);
      return;
    } 
    a();
  }
  
  private void a() {
    FrameLayout frameLayout = new FrameLayout(this.d);
    addView((View)frameLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    this.m = new RelativeLayout(this.d);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
    frameLayout.addView((View)this.m, (ViewGroup.LayoutParams)layoutParams);
    this.q = new ImageView(this.d);
    this.q.setBackgroundDrawable(c.a(this.d).a(1038));
    layoutParams = new FrameLayout.LayoutParams(g.a(this.d, 10.0F), g.a(this.d, 5.0F));
    layoutParams.gravity = 80;
    layoutParams.leftMargin = g.a(this.d, 20.0F);
    this.q.setVisibility(8);
    frameLayout.addView((View)this.q, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public void a(Context paramContext, String paramString) {
    a(paramContext, paramString, (String[])null, (Object[])null);
  }
  
  public void a(Context paramContext, String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject) {
    if (com.unionpay.mobile.android.global.a.L) {
      k.a("uppay-TD", "event:" + paramString + ", keys:" + Arrays.toString((Object[])paramArrayOfString) + ", values:" + Arrays.toString(paramArrayOfObject));
      if (paramArrayOfString != null && paramArrayOfObject != null) {
        if (paramArrayOfString.length != paramArrayOfObject.length || paramArrayOfString.length > 10)
          throw new IllegalArgumentException(); 
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        for (byte b = 0; b < paramArrayOfString.length; b++)
          hashMap.put(paramArrayOfString[b], paramArrayOfObject[b]); 
        UPAgent.onEvent(paramContext, paramString, paramString, hashMap);
        return;
      } 
    } else {
      return;
    } 
    UPAgent.onEvent(paramContext, paramString);
  }
  
  protected final void a(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
    if (this.p != null && paramCharSequence != null && paramCharSequence.length() > 0)
      this.p.setText(paramCharSequence, paramBufferType); 
  }
  
  protected boolean a(LinearLayout paramLinearLayout, String paramString) {
    return false;
  }
  
  public boolean a(String paramString) {
    return (paramString == null || paramString.length() == 0);
  }
  
  protected boolean b_() {
    return false;
  }
  
  protected final void c(String paramString) {
    if (this.l != null && paramString != null && paramString.length() > 0)
      this.l.setText(paramString); 
  }
  
  protected String d() {
    return "_input_method";
  }
  
  public boolean f() {
    return true;
  }
  
  public String i() {
    return this.g;
  }
  
  public final String n() {
    return this.a;
  }
  
  public final String o() {
    return this.b;
  }
  
  public final String p() {
    return this.h;
  }
  
  public final String q() {
    return this.c;
  }
  
  public final String r() {
    return this.o;
  }
  
  protected final String s() {
    return this.s;
  }
  
  protected final void t() {
    if (this.p != null)
      this.p.setVisibility(0); 
  }
  
  protected final void u() {
    if (this.l != null) {
      this.l.setVisibility(0);
      this.q.setVisibility(0);
    } 
  }
  
  protected final void v() {
    if (this.p != null)
      this.p.setTextSize(16.0F); 
  }
  
  public static interface a {
    String a();
    
    boolean b();
    
    boolean c();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */