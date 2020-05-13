package com.zz.sdk.e;

import android.app.AlertDialog;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.o;
import com.zz.sdk.b.u;
import com.zz.sdk.h;
import com.zz.sdk.i.ay;
import com.zz.sdk.i.bt;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;
import java.io.File;
import java.util.HashMap;

class eo extends k {
  protected static final boolean p = false;
  
  public static final String q = "service_type";
  
  public static final String r = "price";
  
  private hd A;
  
  private fi B;
  
  private fd C;
  
  private o D;
  
  private String E;
  
  private int s;
  
  private int t;
  
  private u u;
  
  private u[] v;
  
  private String w;
  
  private int x;
  
  private String y;
  
  private String z;
  
  public eo(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    c(paramContext);
  }
  
  private void A() {
    a(cg.al);
    C();
    this.B = fi.a;
  }
  
  private void B() {
    this.B = fi.b;
    a(cg.aI.a(), new ey(this));
  }
  
  private void C() {
    if (this.B != fi.a) {
      a(-1L, cg.aJ.a());
      return;
    } 
    a(-1L, (String)null);
  }
  
  private void D() {
    a(cg.aK);
    C();
    this.B = fi.a;
  }
  
  private void E() {
    this.B = fi.d;
    a(cg.aL.a(), new ez(this));
  }
  
  private void F() {
    this.B = fi.g;
    C();
    a(false, (CharSequence)Html.fromHtml(cg.aM.a()));
  }
  
  private void G() {
    AlertDialog alertDialog = (new AlertDialog.Builder((Context)getActivity())).setIcon(ca.a(this.x).a(getContext())).setTitle(cg.aV.a()).setMessage(a(this.D)).setPositiveButton(17039370, new eq(this)).setNegativeButton(cg.aW.a(), new fa(this)).create();
    alertDialog.setCancelable(true);
    alertDialog.setCanceledOnTouchOutside(true);
    alertDialog.show();
  }
  
  private void H() {
    this.B = fi.e;
    er er = new er(this);
    setCurrentTask(fg.a(getConnectionUtil(), er, this, this.D));
    I();
  }
  
  private void I() {
    a(cg.aN.a(), new es(this));
  }
  
  private void J() {
    this.B = fi.g;
    a(false, (CharSequence)Html.fromHtml(cg.aO.a()));
    C();
  }
  
  private void K() {
    b(0);
  }
  
  private void L() {
    b(2);
  }
  
  private void M() {
    b(1);
  }
  
  private void N() {
    if (this.s != 3) {
      ParamChain paramChain = getEnv().getParent(cr.class.getName());
      if (paramChain != null) {
        paramChain.add("global.paymentlist.pay_result", Integer.valueOf(this.s), h.b);
        if (this.u != null && this.t == 0)
          paramChain.add("global.paymentlist.pay_result_price", Double.valueOf(this.u.d / 100.0D), h.b); 
        if (this.s != 0);
      } 
    } 
  }
  
  protected static View a(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener, f paramf1, f paramf2) {
    Rect rect = cd.b.a();
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -2, 17);
    layoutParams1.setMargins(rect.left, rect.top, rect.right, rect.bottom);
    linearLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    linearLayout1.setBackgroundDrawable(ca.t.a(paramContext));
    linearLayout1.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    TextView textView = a(paramContext, (cg)null);
    linearLayout1.addView((View)textView, (ViewGroup.LayoutParams)a(2));
    textView.setSingleLine(false);
    textView.setGravity(17);
    textView.setText(cg.h.a());
    textView.setCompoundDrawablesWithIntrinsicBounds(ca.a(paramInt).a(paramContext), null, null, null);
    textView.setTextSize(24.0F);
    textView.setPadding(0, rect.top, 0, rect.bottom);
    textView = a(paramContext, (cg)null);
    linearLayout1.addView((View)textView, (ViewGroup.LayoutParams)a(3));
    textView.setSingleLine(false);
    textView.setBackgroundDrawable(ca.ac.a(paramContext));
    textView.setText(cg.aP.a());
    textView.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    FrameLayout frameLayout = new FrameLayout(paramContext);
    linearLayout1.addView((View)frameLayout, (ViewGroup.LayoutParams)a(3));
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    frameLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 17));
    linearLayout2.setOrientation(0);
    linearLayout2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    Button button2 = new Button(paramContext);
    button2.setId(paramf1.a());
    LinearLayout.LayoutParams layoutParams = a(2);
    layoutParams.setMargins(0, 0, cc.t.a(), 0);
    linearLayout2.addView((View)button2, (ViewGroup.LayoutParams)layoutParams);
    button2.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.x, ca.y));
    button2.setTextColor(ce.o.a());
    cd.l.a((View)button2);
    cf.i.a((TextView)button2);
    button2.setOnClickListener(paramOnClickListener);
    button2.setText("详情");
    Button button1 = new Button(paramContext);
    button1.setId(paramf2.a());
    linearLayout2.addView((View)button1, (ViewGroup.LayoutParams)a(2));
    button1.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.v, ca.w));
    button1.setTextColor(ce.o.a());
    cd.l.a((View)button1);
    cf.i.a((TextView)button1);
    button1.setOnClickListener(paramOnClickListener);
    button1.setText("重试");
    return (View)linearLayout1;
  }
  
  private o a(ParamChain paramParamChain, u paramu) {
    o o1 = new o();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("dueFee", String.valueOf(paramu.d));
    hashMap.put("serviceType", paramu.a);
    hashMap.put("status", "0");
    hashMap.put("platformOrderNum", this.w);
    o1.a = (String)paramParamChain.get("global.user.login_name", String.class);
    o1.n = (String)paramParamChain.get("global.device.imsi", String.class);
    o1.u = hashMap;
    return o1;
  }
  
  private String a(o paramo) {
    HashMap hashMap = paramo.a(1001);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bt.a(String.valueOf(ay.g.nextDouble())));
    char c = File.pathSeparatorChar;
    for (String str : hashMap.keySet())
      stringBuilder.append(c).append(str).append('=').append((String)hashMap.get(str)); 
    stringBuilder.append(c).append(bt.a(stringBuilder.toString() + "zzsdk"));
    return stringBuilder.toString();
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    paramFrameLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)a(3));
    linearLayout.setOrientation(1);
    cd.q.a((View)linearLayout);
    TextView textView = c(paramContext, cg.h);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)a(2));
    textView.setSingleLine(false);
    textView.setGravity(17);
    ca ca = ca.a(this.x);
    if (ca != null) {
      textView.setCompoundDrawablesWithIntrinsicBounds(ca.a(paramContext), null, null, null);
      textView.setCompoundDrawablePadding(cc.a(8.0F));
    } 
    textView.setTextSize(24.0F);
    cd.q.a((View)textView);
    textView = a(paramContext, (cg)null);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)a(3));
    textView.setId(fc.f.a());
    textView.setSingleLine(false);
    textView.setBackgroundDrawable(ca.ac.a(paramContext));
    cd.q.a((View)textView);
    textView.setTextColor(ce.q.a());
    cf.l.a(textView);
  }
  
  private void a(Context paramContext, ScrollView paramScrollView) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    paramScrollView.addView((View)linearLayout, (ViewGroup.LayoutParams)a(3));
    linearLayout.setOrientation(1);
    cd.b.a((View)linearLayout);
    linearLayout.addView((View)a(paramContext, cg.aC), (ViewGroup.LayoutParams)a(3));
    dr dr = new dr(this.f);
    LinearLayout.LayoutParams layoutParams = a(2);
    layoutParams.gravity = 17;
    linearLayout.addView((View)dr, (ViewGroup.LayoutParams)layoutParams);
    cd.q.a((View)dr);
    dr.setSelector(17170445);
    dr.setColumnWidth(cc.a(100.0F));
    dr.setHorizontalSpacing(cc.a(5.0F));
    dr.setVerticalSpacing(cc.a(5.0F));
    dr.setNumColumns(-1);
    this.A = new hd(paramContext, cg.aF.a(), null);
    dr.setAdapter((ListAdapter)this.A);
    dr.setOnItemClickListener(new ep(this));
    TextView textView = a(paramContext, cg.aD);
    layoutParams = a(2);
    layoutParams.gravity = 5;
    layoutParams.topMargin = cc.a.a();
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
    textView.setId(fc.g.a());
    textView.getPaint().setFlags(1);
    textView.setTextSize(16.0F);
    textView.setGravity(5);
    cd.b.a((View)textView);
    textView.setTextColor(-16777216);
    textView.setOnClickListener(this);
  }
  
  private void a(a parama) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial C : ()V
    //   4: aload_0
    //   5: getstatic com/zz/sdk/e/fi.a : Lcom/zz/sdk/e/fi;
    //   8: putfield B : Lcom/zz/sdk/e/fi;
    //   11: aload_0
    //   12: invokevirtual g : ()V
    //   15: aload_1
    //   16: instanceof com/zz/sdk/b/a/ap
    //   19: ifeq -> 147
    //   22: aload_1
    //   23: invokevirtual c : ()Z
    //   26: ifeq -> 147
    //   29: aload_1
    //   30: checkcast com/zz/sdk/b/a/ap
    //   33: astore_2
    //   34: aload_2
    //   35: getfield q : [Lcom/zz/sdk/b/u;
    //   38: ifnull -> 147
    //   41: aload_2
    //   42: getfield q : [Lcom/zz/sdk/b/u;
    //   45: arraylength
    //   46: ifle -> 147
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: ldc_w 'D: fmm size='
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_2
    //   63: getfield q : [Lcom/zz/sdk/b/u;
    //   66: arraylength
    //   67: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokestatic a : (Ljava/lang/Object;)V
    //   76: aload_2
    //   77: getfield q : [Lcom/zz/sdk/b/u;
    //   80: iconst_0
    //   81: aaload
    //   82: astore_2
    //   83: aload_1
    //   84: invokevirtual c : ()Z
    //   87: ifne -> 125
    //   90: aload_1
    //   91: getfield h : I
    //   94: sipush #1011
    //   97: if_icmpne -> 125
    //   100: ldc_w 'zz_sdk'
    //   103: ldc_w 'cpOrder repeat'
    //   106: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   109: pop
    //   110: aload_0
    //   111: aload_1
    //   112: invokevirtual f : ()Ljava/lang/String;
    //   115: invokevirtual b : (Ljava/lang/String;)V
    //   118: aload_0
    //   119: iconst_1
    //   120: invokevirtual a : (Z)Z
    //   123: pop
    //   124: return
    //   125: aload_2
    //   126: ifnull -> 137
    //   129: aload_0
    //   130: aload_2
    //   131: invokespecial a : (Lcom/zz/sdk/b/u;)V
    //   134: goto -> 124
    //   137: aload_0
    //   138: getstatic com/zz/sdk/i/cg.al : Lcom/zz/sdk/i/cg;
    //   141: invokevirtual a : (Lcom/zz/sdk/i/cg;)V
    //   144: goto -> 124
    //   147: aconst_null
    //   148: astore_2
    //   149: goto -> 83
  }
  
  private void a(u paramu) {
    String str4;
    this.u = paramu;
    if (paramu.c()) {
      b(paramu);
      return;
    } 
    if ("0".equals(paramu.f)) {
      d(paramu);
      return;
    } 
    String str2 = "??";
    String str3 = "??";
    if (paramu.e == null) {
      str4 = this.E;
    } else {
      str4 = paramu.e;
    } 
    String str5 = str3;
    String str6 = str2;
    if (str4 != null) {
      String[] arrayOfString = str4.split(",");
      str5 = str3;
      str6 = str2;
      if (arrayOfString != null) {
        str5 = str3;
        str6 = str2;
        if (arrayOfString.length >= 2) {
          str6 = arrayOfString[0];
          str5 = arrayOfString[1];
        } 
      } 
    } 
    String str1 = String.format(cg.aG.a(), new Object[] { str6, str5, cv.a(paramu.d / 100.0D) });
    a(fc.h, (CharSequence)Html.fromHtml(str1));
    a(fc.d);
  }
  
  private void a(fc paramfc) {
    a(fc.b, paramfc);
    a(fc.c, paramfc);
    a(fc.d, paramfc);
  }
  
  private void a(fc paramfc1, fc paramfc2) {
    byte b;
    if (paramfc1 == paramfc2) {
      b = 0;
    } else {
      b = 8;
    } 
    a(paramfc1, b);
  }
  
  private boolean a(String paramString, int paramInt, o paramo) {
    if (!paramString.startsWith(this.w))
      return false; 
    paramString.substring(this.w.length() + 1);
    this.D = paramo;
    if (paramInt == -1) {
      H();
    } else {
      switch (paramInt) {
      
      } 
      c(cg.aB);
    } 
    return true;
  }
  
  private void b(int paramInt) {
    this.s = paramInt;
    o();
    b();
  }
  
  private void b(Context paramContext, ScrollView paramScrollView) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    paramScrollView.addView((View)linearLayout, (ViewGroup.LayoutParams)a(3));
    linearLayout.setOrientation(1);
    cd.q.a((View)linearLayout);
    TextView textView = new TextView(paramContext);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)a(3));
    textView.setId(fc.h.a());
    textView.setTextColor(ce.q.a());
    textView.setAutoLinkMask(4);
    textView.setLinkTextColor(ce.s.a());
    textView.setBackgroundDrawable(ca.ac.a(paramContext));
    cd.q.a((View)textView);
    cf.l.a(textView);
    Button button = new Button(paramContext);
    LinearLayout.LayoutParams layoutParams = a(3);
    layoutParams.gravity = 1;
    cd.q.a((ViewGroup.MarginLayoutParams)layoutParams);
    layoutParams.topMargin = cc.a(30.0F);
    linearLayout.addView((View)button, (ViewGroup.LayoutParams)layoutParams);
    button.setId(fc.i.a());
    button.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.v, ca.w));
    button.setTextColor(ce.o.a());
    button.setOnClickListener(this);
    button.setText(cg.bo.a());
    cd.l.a((View)button);
    cf.i.a((TextView)button);
  }
  
  private void b(a parama) {
    if (parama.e()) {
      this.B = fi.f;
      K();
      return;
    } 
    this.B = fi.g;
    this.s = 1;
    C();
    a(false, a(this.f, this.x, this, fc.k, fc.j));
  }
  
  private void b(u paramu) {
    if (paramu.e != null && paramu.e.length() > 0)
      this.E = paramu.e; 
    this.B = fi.c;
    eu eu = new eu(this);
    setCurrentTask(fb.a(getConnectionUtil(), eu, this, c(paramu)));
    C();
    z();
  }
  
  private o c(u paramu) {
    o o1 = new o();
    ParamChain paramChain = getEnv();
    o1.a = (String)paramChain.get("global.user.login_name", String.class);
    o1.n = (String)paramChain.get("global.device.imsi", String.class);
    o1.e = cv.g(getContext());
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("ua", paramChain.get("global.device.phone_model", String.class));
    hashMap.put("serviceType", paramu.a);
    hashMap.put("command", paramu.c);
    hashMap.put("spCode", paramu.b);
    hashMap.put("price", cv.a(paramu.d));
    o1.u = hashMap;
    o1.p = (String)paramChain.get("global.caller.cporder", String.class);
    return o1;
  }
  
  private void c(cg paramcg) {
    this.B = fi.g;
    this.s = 1;
    a(fc.b);
    a(fc.f, paramcg);
    o();
  }
  
  private void d(u paramu) {
    if (this.B == fi.a) {
      if (this.C == null) {
        this.C = fd.a();
        this.C.a(new ev(this));
      } 
      this.D = a(getEnv(), paramu);
      this.z = this.C.a(this.w + "\n" + paramu.c, this.D);
      this.f.registerReceiver(this.C, new IntentFilter(this.z));
      B();
      setCurrentTask(fh.a(this.f, new ew(this), this, this.z, paramu));
    } 
  }
  
  private void d(boolean paramBoolean) {
    if (paramBoolean) {
      E();
      return;
    } 
    c(cg.aB);
    g();
    o();
  }
  
  private void y() {
    if (this.A != null)
      this.A.a(this.v); 
    a(fc.c);
  }
  
  private void z() {
    a(cg.aj.a(), new ex(this));
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: invokespecial a : (Landroid/content/Context;Lcom/zz/sdk/ParamChain;)V
    //   8: aload_0
    //   9: iconst_3
    //   10: putfield s : I
    //   13: aload_0
    //   14: getstatic com/zz/sdk/e/fi.a : Lcom/zz/sdk/e/fi;
    //   17: putfield B : Lcom/zz/sdk/e/fi;
    //   20: aload_0
    //   21: aload_2
    //   22: ldc_w 'global.paymentlist.pay_order_number'
    //   25: ldc_w java/lang/String
    //   28: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   33: checkcast java/lang/String
    //   36: putfield w : Ljava/lang/String;
    //   39: aload_0
    //   40: aload_2
    //   41: ldc_w 'global.paymentlist.pay_channel_type'
    //   44: ldc java/lang/Integer
    //   46: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   51: checkcast java/lang/Integer
    //   54: invokevirtual intValue : ()I
    //   57: putfield x : I
    //   60: aload_0
    //   61: aload_2
    //   62: ldc_w 'global.paymentlist.pay_channel_name'
    //   65: ldc_w java/lang/String
    //   68: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   73: checkcast java/lang/String
    //   76: putfield y : Ljava/lang/String;
    //   79: aload_2
    //   80: ldc_w 'global.paymentlist.pay_amount'
    //   83: ldc_w java/lang/Double
    //   86: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   91: checkcast java/lang/Double
    //   94: astore_1
    //   95: aload_2
    //   96: ldc_w 'global.paymentlist.pay_amount_defect'
    //   99: ldc_w java/lang/Double
    //   102: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   107: checkcast java/lang/Double
    //   110: astore #4
    //   112: aload #4
    //   114: ifnull -> 339
    //   117: aload #4
    //   119: astore_1
    //   120: aload_1
    //   121: ifnonnull -> 220
    //   124: iconst_0
    //   125: istore #5
    //   127: aload_0
    //   128: iload #5
    //   130: putfield t : I
    //   133: aload_2
    //   134: ldc_w 'global.paymentlist.pay_sms_channel_message'
    //   137: ldc_w [Lcom/zz/sdk/b/u;
    //   140: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   145: checkcast [Lcom/zz/sdk/b/u;
    //   148: astore #4
    //   150: aload #4
    //   152: ifnull -> 325
    //   155: aload #4
    //   157: astore_1
    //   158: aload_0
    //   159: getfield t : I
    //   162: ifle -> 261
    //   165: new java/util/ArrayList
    //   168: dup
    //   169: invokespecial <init> : ()V
    //   172: astore #6
    //   174: aload #4
    //   176: arraylength
    //   177: istore #7
    //   179: iconst_0
    //   180: istore #5
    //   182: iload #5
    //   184: iload #7
    //   186: if_icmpge -> 234
    //   189: aload #4
    //   191: iload #5
    //   193: aaload
    //   194: astore_1
    //   195: aload_1
    //   196: getfield d : D
    //   199: d2i
    //   200: aload_0
    //   201: getfield t : I
    //   204: if_icmpne -> 214
    //   207: aload #6
    //   209: aload_1
    //   210: invokevirtual add : (Ljava/lang/Object;)Z
    //   213: pop
    //   214: iinc #5, 1
    //   217: goto -> 182
    //   220: aload_1
    //   221: invokevirtual doubleValue : ()D
    //   224: ldc2_w 100.0
    //   227: dmul
    //   228: d2i
    //   229: istore #5
    //   231: goto -> 127
    //   234: aload #6
    //   236: aload #6
    //   238: invokevirtual size : ()I
    //   241: anewarray com/zz/sdk/b/u
    //   244: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   247: checkcast [Lcom/zz/sdk/b/u;
    //   250: astore #4
    //   252: aload #4
    //   254: astore_1
    //   255: aload #4
    //   257: arraylength
    //   258: ifne -> 261
    //   261: aload_2
    //   262: ldc_w 'global.paymentlist.pay_sms_confirm_enabled'
    //   265: ldc_w java/lang/Boolean
    //   268: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   273: checkcast java/lang/Boolean
    //   276: astore #4
    //   278: aload #4
    //   280: ifnull -> 293
    //   283: aload_1
    //   284: astore_2
    //   285: aload #4
    //   287: invokevirtual booleanValue : ()Z
    //   290: ifne -> 328
    //   293: aload_1
    //   294: arraylength
    //   295: istore #7
    //   297: iload_3
    //   298: istore #5
    //   300: aload_1
    //   301: astore_2
    //   302: iload #5
    //   304: iload #7
    //   306: if_icmpge -> 328
    //   309: aload_1
    //   310: iload #5
    //   312: aaload
    //   313: ldc_w '1'
    //   316: putfield f : Ljava/lang/String;
    //   319: iinc #5, 1
    //   322: goto -> 300
    //   325: aload #4
    //   327: astore_2
    //   328: aload_0
    //   329: aconst_null
    //   330: putfield u : Lcom/zz/sdk/b/u;
    //   333: aload_0
    //   334: aload_2
    //   335: putfield v : [Lcom/zz/sdk/b/u;
    //   338: return
    //   339: goto -> 120
  }
  
  protected void b(Context paramContext) {
    FrameLayout frameLayout1 = getSubjectContainer();
    d(paramContext);
    FrameLayout frameLayout2 = new FrameLayout(paramContext);
    frameLayout1.addView((View)frameLayout2, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    frameLayout2.setId(fc.b.a());
    frameLayout2.setVisibility(8);
    a(paramContext, frameLayout2);
    ScrollView scrollView = new ScrollView(paramContext);
    frameLayout1.addView((View)scrollView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    scrollView.setId(fc.c.a());
    scrollView.setVisibility(0);
    a(paramContext, scrollView);
    scrollView = new ScrollView(paramContext);
    frameLayout1.addView((View)scrollView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    scrollView.setId(fc.d.a());
    scrollView.setVisibility(8);
    b(paramContext, scrollView);
    cg cg = (cg)getEnv().get("global.paymentlist.pay_title", cg.class);
    if (cg != null) {
      String str;
      if (this.y != null) {
        str = String.format(cg.y.a(), new Object[] { cg.a(), this.y });
      } else {
        str = str.a();
      } 
      setTileTypeText(str);
    } 
  }
  
  public boolean c(boolean paramBoolean) {
    boolean bool = false;
    if (this.B == fi.d || this.B == fi.b || this.B == fi.e) {
      b(cg.aH);
      return bool;
    } 
    if (this.B == fi.a && paramBoolean && findViewById(fc.d.a()).getVisibility() == 0) {
      a(fc.c);
      return bool;
    } 
    return super.c(paramBoolean);
  }
  
  public boolean j() {
    boolean bool = super.j();
    if (!bool)
      return false; 
    this.s = 2;
    if (this.v == null) {
      c(cg.az);
      return bool;
    } 
    if (this.v.length == 0) {
      c(cg.aA);
      return bool;
    } 
    a(-1L, (String)null);
    y();
    return bool;
  }
  
  protected void m() {
    N();
    if (this.C != null) {
      this.C.b((ff)null);
      this.f.unregisterReceiver(this.C);
      this.C = null;
    } 
    this.D = null;
    super.m();
    this.x = -1;
    this.y = null;
    this.s = 3;
    this.A = null;
    this.u = null;
    this.v = null;
    this.w = null;
    this.E = null;
  }
  
  public void onClick(View paramView) {
    fc fc = fc.a(paramView.getId());
    switch (et.a[fc.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        L();
        return;
      case 2:
        d(this.u);
        return;
      case 3:
        H();
        return;
      case 4:
        break;
    } 
    G();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\eo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */