package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.zz.sdk.ParamChain;
import com.zz.sdk.g.a;
import com.zz.sdk.h;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;
import java.util.ArrayList;
import java.util.List;

class du extends a {
  private WebView o;
  
  private String p;
  
  private String q;
  
  private int r;
  
  private String s;
  
  private String t;
  
  private List u;
  
  private String v;
  
  private BroadcastReceiver w;
  
  private List x;
  
  private int y;
  
  private boolean z;
  
  public du(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    c(paramContext);
  }
  
  private boolean A() {
    boolean bool = true;
    if (this.z)
      return false; 
    dx dx = new dx(this);
    dy dy = new dy(this);
    AlertDialog alertDialog = (new AlertDialog.Builder((Context)getActivity())).setIcon(ca.a(this.r).a(getContext())).setTitle(cg.h.a()).setMessage(cg.aq.a()).setPositiveButton(17039379, dx).setNegativeButton(17039360, dy).create();
    alertDialog.setCancelable(true);
    alertDialog.setCanceledOnTouchOutside(true);
    alertDialog.show();
    a((Dialog)alertDialog);
    return bool;
  }
  
  private void a(Intent paramIntent) {
    String str1;
    ei[] arrayOfEi = eg.a(paramIntent);
    paramIntent = null;
    Intent intent = null;
    StringBuilder stringBuilder = new StringBuilder();
    if (arrayOfEi != null) {
      int i = arrayOfEi.length;
      byte b = 0;
      while (true) {
        paramIntent = intent;
        if (b < i) {
          ei ei = arrayOfEi[b];
          paramIntent = intent;
          if (intent == null)
            str1 = ei.a; 
          stringBuilder.append(ei.b);
          b++;
          String str = str1;
          continue;
        } 
        break;
      } 
    } 
    if (stringBuilder.length() > 0) {
      if (!h()) {
        bp.a(stringBuilder.toString());
        return;
      } 
    } else {
      return;
    } 
    this.x.add(stringBuilder.toString());
    AlertDialog.Builder builder = (new AlertDialog.Builder((Context)getActivity())).setIcon(ca.a(this.r).a(getContext()));
    String str2 = str1;
    if (str1 == null)
      str2 = cg.h.a(); 
    AlertDialog alertDialog = builder.setTitle(str2).setMessage(stringBuilder.toString()).setPositiveButton(17039370, new ea(this)).create();
    alertDialog.setCancelable(true);
    alertDialog.setCanceledOnTouchOutside(true);
    alertDialog.show();
  }
  
  private void b(int paramInt) {
    this.y = paramInt;
    o();
    b();
  }
  
  private boolean c(String paramString) {
    if (paramString != null) {
      if (this.q != null && paramString.startsWith(this.q)) {
        w();
        return false;
      } 
      if (d(paramString));
    } 
    return true;
  }
  
  private void d(Context paramContext) {
    if (cv.m(paramContext) && this.w == null) {
      eg eg = new eg(null);
      eg.a(this, new dz(this));
      paramContext.registerReceiver(eg, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
      this.w = eg;
      this.x = new ArrayList();
    } 
  }
  
  private boolean d(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield u : Ljava/util/List;
    //   4: astore_2
    //   5: aload_1
    //   6: ifnull -> 77
    //   9: aload_2
    //   10: ifnull -> 77
    //   13: aload_2
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface hasNext : ()Z
    //   26: ifeq -> 77
    //   29: aload_2
    //   30: invokeinterface next : ()Ljava/lang/Object;
    //   35: checkcast android/util/Pair
    //   38: astore_3
    //   39: aload_3
    //   40: getfield first : Ljava/lang/Object;
    //   43: ifnull -> 20
    //   46: aload_1
    //   47: aload_3
    //   48: getfield first : Ljava/lang/Object;
    //   51: checkcast java/lang/String
    //   54: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   57: ifeq -> 20
    //   60: aload_0
    //   61: aload_3
    //   62: getfield second : Ljava/lang/Object;
    //   65: checkcast java/lang/String
    //   68: putfield v : Ljava/lang/String;
    //   71: iconst_1
    //   72: istore #4
    //   74: iload #4
    //   76: ireturn
    //   77: iconst_0
    //   78: istore #4
    //   80: goto -> 74
  }
  
  private void w() {
    b(0);
  }
  
  private void x() {
    b(2);
  }
  
  private void y() {
    b(1);
  }
  
  private void z() {
    if (this.y != 3) {
      getEnv().getParent(cr.class.getName()).add("global.paymentlist.pay_result", Integer.valueOf(this.y), h.b);
      if (this.y != 0 && this.v != null && this.t != null)
        (new dw(this, "cancel-pay")).start(); 
    } 
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    this.z = false;
    this.p = (String)paramParamChain.get("global.paymentlist.pay_online_url", String.class);
    this.q = (String)paramParamChain.get("global.paymentlist.pay_online_url_guard", String.class);
    this.r = ((Integer)paramParamChain.get("global.paymentlist.pay_channel_type", Integer.class)).intValue();
    this.s = (String)paramParamChain.get("global.paymentlist.pay_channel_name", String.class);
    this.t = (String)paramParamChain.get("global.paymentlist.pay_order_number", String.class);
    Double double_ = (Double)paramParamChain.get("global.paymentlist.pay_amount", Double.class);
    double_ = (Double)paramParamChain.get("global.paymentlist.pay_amount_defect", Double.class);
    this.y = 3;
    this.u = null;
    if (this.p == null || this.q == null || this.r < 0);
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  protected void b(Context paramContext) {
    FrameLayout frameLayout1 = getSubjectContainer();
    FrameLayout frameLayout2 = new FrameLayout(paramContext);
    frameLayout1.addView((View)frameLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    frameLayout2.setId(ef.b.a());
    frameLayout2.setVisibility(8);
    LinearLayout linearLayout = new LinearLayout(paramContext);
    frameLayout1.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    linearLayout.setId(ef.c.a());
    linearLayout.setVisibility(8);
    WebView webView = new WebView((Context)getActivity());
    LinearLayout.LayoutParams layoutParams = a(1);
    webView.setId(ef.d.a());
    linearLayout.addView((View)webView, (ViewGroup.LayoutParams)layoutParams);
    webView.setWebViewClient(new dv(this));
    webView.getSettings().setJavaScriptEnabled(true);
    this.o = webView;
    cg cg = (cg)getEnv().get("global.paymentlist.pay_title", cg.class);
    if (cg != null) {
      String str;
      if (this.s != null) {
        str = String.format(cg.y.a(), new Object[] { cg.a(), this.s });
      } else {
        str = str.a();
      } 
      setTileTypeText(str);
    } 
  }
  
  public boolean c(boolean paramBoolean) {
    if (!paramBoolean && A())
      return false; 
    boolean bool = super.c(paramBoolean);
    paramBoolean = bool;
    if (bool)
      paramBoolean = bool; 
    return paramBoolean;
  }
  
  public void d(boolean paramBoolean) {
    byte b2;
    byte b1 = 8;
    View view = findViewById(ef.a.a());
    if (view != null && view.getVisibility() == 0) {
      view.setVisibility(8);
      if (view instanceof ViewGroup)
        ((ViewGroup)view).removeAllViews(); 
    } 
    ef ef = ef.c;
    if (paramBoolean) {
      b2 = 0;
    } else {
      b2 = 8;
    } 
    a(ef, b2);
    ef = ef.b;
    if (paramBoolean) {
      b2 = b1;
    } else {
      b2 = 0;
    } 
    a(ef, b2);
  }
  
  public boolean j() {
    boolean bool = super.j();
    if (!bool)
      return false; 
    this.y = 2;
    setActivityControlInterface((a)new eb(this));
    ec ec = new ec(this);
    setCurrentTask(ee.a(getConnectionUtil(), ec, null));
    a(cg.aj.a(), new ed(this));
    a(-1L, cg.aj.a());
    return bool;
  }
  
  protected void m() {
    z();
    if (this.w != null) {
      this.f.unregisterReceiver(this.w);
      this.w = null;
    } 
    if (this.x != null) {
      this.x.clear();
      this.x = null;
    } 
    if (this.o != null) {
      ViewParent viewParent = this.o.getParent();
      if (viewParent != null && viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView((View)this.o); 
      this.o.removeAllViews();
      this.o.destroy();
      this.o = null;
    } 
    super.m();
    this.p = null;
    this.q = null;
    this.r = -1;
    this.u = null;
    this.v = null;
    this.t = null;
    this.s = null;
    this.y = 3;
  }
  
  protected WebView v() {
    return (this.o != null) ? this.o : null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */