package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Html;
import android.text.InputFilter;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.zz.sdk.ParamChain;
import com.zz.sdk.b.k;
import com.zz.sdk.b.o;
import com.zz.sdk.i.a;
import com.zz.sdk.i.bg;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.ci;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.df;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import com.zz.sdk.lib.widget.roundview.RoundLinearLayout;
import com.zz.sdk.lib.widget.roundview.c;
import java.util.ArrayList;

public class go extends k {
  private static final double[] x = new double[] { 10.0D, 20.0D, 30.0D, 50.0D, 100.0D, 200.0D, 300.0D, 500.0D };
  
  private double[] A = new double[] { 
      5.0D, 6.0D, 10.0D, 15.0D, 20.0D, 30.0D, 50.0D, 100.0D, 200.0D, 500.0D, 
      1000.0D };
  
  private Context B;
  
  private int C;
  
  private int D;
  
  private ArrayList E;
  
  private k[] F;
  
  private gy G;
  
  private p H;
  
  private r I;
  
  private double J;
  
  private double K;
  
  private double L = 0.0D;
  
  private String M = "0.0";
  
  private double N = 0.0D;
  
  private String O;
  
  private boolean P;
  
  private LinearLayout p;
  
  private TextView q;
  
  private LinearLayout r;
  
  private ImageButton s;
  
  private LinearLayout t = null;
  
  private TextView u;
  
  private boolean v = false;
  
  private boolean w = false;
  
  private double[] y = new double[] { 10.0D, 20.0D, 30.0D, 50.0D, 100.0D, 200.0D, 300.0D, 500.0D };
  
  private double[] z = new double[] { 
      5.0D, 10.0D, 15.0D, 25.0D, 30.0D, 35.0D, 45.0D, 50.0D, 100.0D, 350.0D, 
      1000.0D };
  
  public go(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    this.B = paramContext;
    a(this.E);
    c(paramContext);
    e(0);
  }
  
  private String A() {
    if (!this.v)
      return cg.bK.a(); 
    String str = b(gv.b, 1);
    if (str == null || str.length() == 0) {
      set_child_focuse(gv.b);
      return cg.bc.a();
    } 
    null = b(gv.c, 1);
    if (null == null || null.length() == 0) {
      set_child_focuse(gv.b);
      return cg.be.a();
    } 
    getEnv().add("global.paymentlist.pay_card_no", str);
    getEnv().add("global.paymentlist.pay_card_passwd", null);
    return null;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private void a(ParamChain paramParamChain, int paramInt) {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iload_2
    //   3: tableswitch default -> 24, 0 -> 305, 1 -> 311
    //   24: bipush #-2
    //   26: istore #4
    //   28: new com/zz/sdk/PaymentCallbackInfo
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #5
    //   37: aload_1
    //   38: ldc 'global.paymentlist.pay_result_price'
    //   40: invokeinterface remove : (Ljava/lang/String;)Ljava/lang/Object;
    //   45: astore #6
    //   47: aload #6
    //   49: instanceof java/lang/Double
    //   52: ifeq -> 317
    //   55: aload #6
    //   57: checkcast java/lang/Double
    //   60: astore #6
    //   62: aload #6
    //   64: ifnonnull -> 336
    //   67: aconst_null
    //   68: astore #6
    //   70: aload #5
    //   72: aload #6
    //   74: putfield amount : Ljava/lang/String;
    //   77: aload #5
    //   79: aload_1
    //   80: ldc 'global.paymentlist.pay_order_number'
    //   82: ldc java/lang/String
    //   84: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   89: checkcast java/lang/String
    //   92: putfield gameOrderNumber : Ljava/lang/String;
    //   95: aload #5
    //   97: iload #4
    //   99: putfield statusCode : I
    //   102: aload_1
    //   103: ldc 'global.paymentlist.pay_channel_type'
    //   105: ldc java/lang/Integer
    //   107: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   112: checkcast java/lang/Integer
    //   115: astore #6
    //   117: aload #6
    //   119: ifnonnull -> 349
    //   122: iload_3
    //   123: istore #4
    //   125: aload #5
    //   127: iload #4
    //   129: putfield payWayType : I
    //   132: aload #5
    //   134: aload_1
    //   135: ldc 'global.paymentlist.pay_channel_name'
    //   137: ldc java/lang/String
    //   139: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   144: checkcast java/lang/String
    //   147: putfield payWayName : Ljava/lang/String;
    //   150: aload #5
    //   152: ldc 'RMB'
    //   154: putfield currency : Ljava/lang/String;
    //   157: new com/zz/sdk/b/m
    //   160: dup
    //   161: invokespecial <init> : ()V
    //   164: astore #6
    //   166: aload #6
    //   168: aload_1
    //   169: ldc 'global.user.login_name'
    //   171: ldc java/lang/String
    //   173: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   178: checkcast java/lang/String
    //   181: invokevirtual c : (Ljava/lang/String;)V
    //   184: aload #6
    //   186: aload #5
    //   188: getfield gameOrderNumber : Ljava/lang/String;
    //   191: invokevirtual d : (Ljava/lang/String;)V
    //   194: aload #6
    //   196: aload #5
    //   198: getfield amount : Ljava/lang/String;
    //   201: invokevirtual a : (Ljava/lang/String;)V
    //   204: aload #6
    //   206: new java/text/SimpleDateFormat
    //   209: dup
    //   210: ldc 'yyyy-MM-dd HH:mm:ss'
    //   212: invokespecial <init> : (Ljava/lang/String;)V
    //   215: new java/util/Date
    //   218: dup
    //   219: invokestatic currentTimeMillis : ()J
    //   222: invokespecial <init> : (J)V
    //   225: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   228: invokevirtual e : (Ljava/lang/String;)V
    //   231: aload #6
    //   233: new java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: aload #5
    //   242: getfield payWayType : I
    //   245: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   248: ldc_w ''
    //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual toString : ()Ljava/lang/String;
    //   257: invokevirtual f : (Ljava/lang/String;)V
    //   260: aload #6
    //   262: ldc_w ''
    //   265: invokevirtual g : (Ljava/lang/String;)V
    //   268: aload #6
    //   270: aload #5
    //   272: getfield amount : Ljava/lang/String;
    //   275: invokevirtual b : (Ljava/lang/String;)V
    //   278: new com/zz/sdk/b/n
    //   281: dup
    //   282: aload_0
    //   283: getfield B : Landroid/content/Context;
    //   286: invokespecial <init> : (Landroid/content/Context;)V
    //   289: aload #6
    //   291: invokevirtual a : (Lcom/zz/sdk/b/m;)Z
    //   294: pop
    //   295: aload_0
    //   296: iconst_1
    //   297: iload_2
    //   298: aload #5
    //   300: invokevirtual a : (IILjava/lang/Object;)Z
    //   303: pop
    //   304: return
    //   305: iconst_0
    //   306: istore #4
    //   308: goto -> 28
    //   311: iconst_m1
    //   312: istore #4
    //   314: goto -> 28
    //   317: aload_1
    //   318: ldc_w 'global.paymentlist.pay_amount'
    //   321: ldc java/lang/Double
    //   323: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   328: checkcast java/lang/Double
    //   331: astore #6
    //   333: goto -> 62
    //   336: aload #6
    //   338: invokevirtual doubleValue : ()D
    //   341: invokestatic a : (D)Ljava/lang/String;
    //   344: astore #6
    //   346: goto -> 70
    //   349: aload #6
    //   351: invokevirtual intValue : ()I
    //   354: istore #4
    //   356: goto -> 125
  }
  
  private void a(ArrayList paramArrayList) {
    if (paramArrayList.size() > 0) {
      this.F = new k[paramArrayList.size()];
      this.F = (k[])paramArrayList.toArray((Object[])this.F);
    } 
  }
  
  private void a(double[] paramArrayOfdouble) {
    // Byte code:
    //   0: aload_0
    //   1: getfield I : Lcom/zz/sdk/e/r;
    //   4: ifnull -> 24
    //   7: aload_0
    //   8: getfield I : Lcom/zz/sdk/e/r;
    //   11: aload_1
    //   12: invokevirtual a : ([D)V
    //   15: aload_1
    //   16: ifnull -> 24
    //   19: aload_1
    //   20: arraylength
    //   21: ifne -> 25
    //   24: return
    //   25: iconst_0
    //   26: istore_2
    //   27: iload_2
    //   28: aload_1
    //   29: arraylength
    //   30: if_icmpge -> 307
    //   33: aload_0
    //   34: aload_0
    //   35: getfield I : Lcom/zz/sdk/e/r;
    //   38: iload_2
    //   39: invokevirtual b : (I)D
    //   42: invokestatic valueOf : (D)Ljava/lang/String;
    //   45: putfield M : Ljava/lang/String;
    //   48: aload_0
    //   49: aload_0
    //   50: getfield M : Ljava/lang/String;
    //   53: invokestatic parseDouble : (Ljava/lang/String;)D
    //   56: putfield L : D
    //   59: aload_0
    //   60: getfield L : D
    //   63: aload_0
    //   64: getfield K : D
    //   67: dcmpl
    //   68: iflt -> 119
    //   71: aload_0
    //   72: getfield L : D
    //   75: dstore_3
    //   76: aload_0
    //   77: getfield K : D
    //   80: dstore #5
    //   82: aload_0
    //   83: new java/text/DecimalFormat
    //   86: dup
    //   87: ldc_w '#.00'
    //   90: invokespecial <init> : (Ljava/lang/String;)V
    //   93: dload_3
    //   94: dload #5
    //   96: dsub
    //   97: invokevirtual format : (D)Ljava/lang/String;
    //   100: invokestatic parseDouble : (Ljava/lang/String;)D
    //   103: putfield N : D
    //   106: iload_2
    //   107: iconst_m1
    //   108: if_icmpne -> 125
    //   111: aload_0
    //   112: iconst_0
    //   113: putfield v : Z
    //   116: goto -> 24
    //   119: iinc #2, 1
    //   122: goto -> 27
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield v : Z
    //   130: aload_0
    //   131: getfield t : Landroid/widget/LinearLayout;
    //   134: ifnull -> 251
    //   137: getstatic com/zz/sdk/i/cg.N : Lcom/zz/sdk/i/cg;
    //   140: invokevirtual a : ()Ljava/lang/String;
    //   143: iconst_1
    //   144: anewarray java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_0
    //   150: getfield M : Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   157: astore_1
    //   158: aload_0
    //   159: getstatic com/zz/sdk/e/gv.j : Lcom/zz/sdk/e/gv;
    //   162: aload_1
    //   163: invokestatic fromHtml : (Ljava/lang/String;)Landroid/text/Spanned;
    //   166: invokevirtual a : (Lcom/zz/sdk/e/f;Ljava/lang/CharSequence;)V
    //   169: getstatic com/zz/sdk/i/cg.ag : Lcom/zz/sdk/i/cg;
    //   172: invokevirtual a : ()Ljava/lang/String;
    //   175: iconst_1
    //   176: anewarray java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload_0
    //   182: getfield M : Ljava/lang/String;
    //   185: aastore
    //   186: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   189: astore_1
    //   190: aload_0
    //   191: getstatic com/zz/sdk/e/gv.o : Lcom/zz/sdk/e/gv;
    //   194: invokevirtual a : ()I
    //   197: invokevirtual findViewById : (I)Landroid/view/View;
    //   200: checkcast com/zz/sdk/lib/widget/fancybuttons/FancyButton
    //   203: aload_1
    //   204: invokevirtual setText : (Ljava/lang/String;)V
    //   207: aload_0
    //   208: getfield t : Landroid/widget/LinearLayout;
    //   211: iconst_0
    //   212: invokevirtual setVisibility : (I)V
    //   215: invokestatic a : ()Z
    //   218: ifeq -> 262
    //   221: aload_0
    //   222: getfield u : Landroid/widget/TextView;
    //   225: new java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial <init> : ()V
    //   232: aload_0
    //   233: getfield N : D
    //   236: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   239: ldc_w '元余额将会存入你的游戏币账户'
    //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual toString : ()Ljava/lang/String;
    //   248: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   251: aload_0
    //   252: getfield I : Lcom/zz/sdk/e/r;
    //   255: iload_2
    //   256: invokevirtual a : (I)V
    //   259: goto -> 24
    //   262: aload_0
    //   263: getfield u : Landroid/widget/TextView;
    //   266: new java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial <init> : ()V
    //   273: aload_0
    //   274: getfield N : D
    //   277: invokevirtual append : (D)Ljava/lang/StringBuilder;
    //   280: ldc_w '元余额将会存入你的'
    //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w '游戏币'
    //   289: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc_w '账户'
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual toString : ()Ljava/lang/String;
    //   301: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   304: goto -> 251
    //   307: iconst_m1
    //   308: istore_2
    //   309: goto -> 106
  }
  
  private void a(double[] paramArrayOfdouble, LinearLayout paramLinearLayout) {
    LinearLayout linearLayout = new LinearLayout(this.B);
    gx gx = new gx(this.B);
    cd.e.a((View)gx);
    linearLayout.addView((View)gx, (ViewGroup.LayoutParams)a(3));
    gx.setSelector(17170445);
    gx.setColumnWidth(cc.a(80.0F));
    gx.setHorizontalSpacing(cc.a(2.0F));
    gx.setVerticalSpacing(cc.a(2.0F));
    gx.setNumColumns(-1);
    this.I = new r(this.B, this.d, cg.aa.a(), paramArrayOfdouble);
    gx.setAdapter((ListAdapter)this.I);
    gx.setOnItemClickListener(new gs(this));
    paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
  }
  
  private void a(k[] paramArrayOfk, LinearLayout paramLinearLayout) {
    LinearLayout linearLayout = new LinearLayout(this.B);
    gx gx = new gx(this.B);
    cd.e.a((View)gx);
    linearLayout.addView((View)gx, (ViewGroup.LayoutParams)a(3));
    gx.setSelector(17170445);
    gx.setColumnWidth(cc.a(80.0F));
    gx.setHorizontalSpacing(cc.a(4.0F));
    gx.setVerticalSpacing(cc.a(4.0F));
    gx.setNumColumns(-1);
    this.H = new p(this.B, paramArrayOfk);
    gx.setAdapter((ListAdapter)this.H);
    gx.setOnItemClickListener(new gt(this));
    if (paramArrayOfk != null && paramArrayOfk.length > 0)
      this.C = (paramArrayOfk[0]).B; 
    paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
  }
  
  private o b(Context paramContext, ParamChain paramParamChain) {
    o o = new o();
    o.a = (String)paramParamChain.get("global.user.login_name", String.class);
    o.b = (String)paramParamChain.get("global.caller.game_role", String.class);
    o.c = (String)paramParamChain.get("global.caller.game_server_id", String.class);
    o.e = cv.g(paramContext);
    o.d = cv.a(this.J);
    o.f = "";
    o.o = this.M;
    o.h = (String)paramParamChain.get("global.paymentlist.pay_card_no", String.class);
    o.i = (String)paramParamChain.get("global.paymentlist.pay_card_passwd", String.class);
    o.j = String.valueOf(this.C);
    o.t = this.O;
    o.s = (String)paramParamChain.get("global.caller.prop_name", String.class);
    o.r = (String)paramParamChain.get("global.caller.prop_id", String.class);
    o.p = (String)paramParamChain.get("global.caller.cporder", String.class);
    return o;
  }
  
  private void b(int paramInt) {
    this.G.a(paramInt);
  }
  
  private void b(ParamChain paramParamChain, int paramInt) {
    cg cg;
    switch (paramInt) {
      default:
        paramParamChain = null;
        if (paramParamChain != null) {
          a(false, (cg)paramParamChain);
          o();
          postDelayed(new gr(this), 1500L);
          return;
        } 
        break;
      case 0:
        if (this.P) {
          cg = cg.at;
        } else {
          cg = cg.as;
        } 
        if (cg != null) {
          a(false, cg);
          o();
          postDelayed(new gr(this), 1500L);
          return;
        } 
        break;
      case 1:
        cg = cg.av;
        if (cg != null) {
          a(false, cg);
          o();
          postDelayed(new gr(this), 1500L);
          return;
        } 
        break;
    } 
    g();
  }
  
  private Pair c(int paramInt) {
    switch (paramInt) {
      default:
        bp.a("unknown card type!");
        return null;
      case 3:
        return new Pair(Integer.valueOf(15), Integer.valueOf(19));
      case 6:
        return new Pair(Integer.valueOf(19), Integer.valueOf(18));
      case 4:
        return new Pair(Integer.valueOf(17), Integer.valueOf(18));
      case 79:
        return new Pair(Integer.valueOf(16), Integer.valueOf(16));
      case 78:
        break;
    } 
    return new Pair(Integer.valueOf(-1), Integer.valueOf(-1));
  }
  
  private void d(int paramInt) {
    switch (paramInt) {
      default:
        return;
      case 101:
        Toast.makeText(this.B, cg.bL.a(), 0).show();
      case 3:
      case 4:
      case 6:
        a(this.y);
      case 78:
        a(this.z);
      case 79:
        break;
    } 
    a(this.A);
  }
  
  private void d(boolean paramBoolean) {
    String str;
    gq gq;
    if (paramBoolean) {
      str = e(paramBoolean);
    } else {
      str = A();
    } 
    if (str == null) {
      a(cg.aj.a(), new gp(this));
      gq = new gq(this);
      setCurrentTask(gw.a(getConnectionUtil(), gq, this.C, b(this.B, getEnv())));
      return;
    } 
    b((String)gq);
  }
  
  private View e(Context paramContext) {
    EditText editText2;
    EditText editText1;
    int i;
    int j;
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    cd.b.a();
    linearLayout1.setPadding(0, cc.g.a(), 0, 0);
    LinearLayout linearLayout4 = new LinearLayout(paramContext);
    linearLayout1.addView((View)linearLayout4, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.e.a()));
    cd.d.a((View)linearLayout4);
    TextView textView2 = a(paramContext, (cg)null);
    cf.b.a(textView2);
    textView2.setTextColor(-13025984);
    textView2.setText("待支付金额: ");
    linearLayout4.addView((View)textView2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -1));
    textView2 = a(paramContext, (cg)null);
    cf.o.a(textView2);
    textView2.setTextColor(-1623778);
    textView2.setText(cv.a(this.K));
    LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -1);
    layoutParams7.leftMargin = cc.a(5.0F);
    linearLayout4.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams7);
    textView2 = a(paramContext, (cg)null);
    cf.b.a(textView2);
    textView2.setTextColor(-13025984);
    textView2.setText("元");
    linearLayout4.addView((View)textView2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    linearLayout4 = new LinearLayout(paramContext);
    linearLayout4.setId(gv.k.a());
    linearLayout4.setOrientation(1);
    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams4.topMargin = cc.g.a();
    linearLayout1.addView((View)linearLayout4, (ViewGroup.LayoutParams)layoutParams4);
    cd.d.a((View)linearLayout4);
    TextView textView1 = a(paramContext, (cg)null);
    cf.b.a(textView1);
    textView1.setTextColor(-12237494);
    textView1.setText("请选择充值卡类型");
    textView1.setId(gv.l.a());
    textView1.setOnClickListener(this);
    linearLayout4.addView((View)textView1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -1));
    a(this.F, linearLayout4);
    this.p = a(paramContext, linearLayout1);
    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)this.p.getLayoutParams();
    layoutParams2.topMargin = cc.g.a();
    this.p.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
    this.p.setId(gv.f.a());
    this.p.setOrientation(1);
    this.p.setGravity(16);
    cd.d.a((View)this.p);
    this.q = b(paramContext, (cg)null);
    this.q.setId(gv.g.a());
    this.q.setTextColor(-12237494);
    this.q.setText((CharSequence)Html.fromHtml(cg.bJ.a()));
    cf.b.a(this.q);
    layoutParams2 = new LinearLayout.LayoutParams(-2, df.a(paramContext, 45.0F));
    this.p.addView((View)this.q, (ViewGroup.LayoutParams)layoutParams2);
    cd.i.a((View)this.q);
    LinearLayout linearLayout3 = this.p;
    a(new double[0], linearLayout3);
    Pair pair = c(this.C);
    if (pair == null) {
      i = 0;
    } else {
      i = ((Integer)pair.first).intValue();
    } 
    if (pair == null) {
      j = 0;
    } else {
      j = ((Integer)pair.second).intValue();
    } 
    if (i == -1 && j == -1)
      this.w = true; 
    RoundLinearLayout roundLinearLayout = new RoundLinearLayout(paramContext);
    c c = roundLinearLayout.getDelegate();
    c.c(5);
    c.d(1);
    c.e(-1118479);
    roundLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams layoutParams1 = a(3);
    layoutParams1.topMargin = cc.g.a();
    layoutParams1.leftMargin = cc.a.a();
    layoutParams1.rightMargin = cc.a.a();
    cd.e.a((View)roundLinearLayout);
    linearLayout1.addView((View)roundLinearLayout, (ViewGroup.LayoutParams)layoutParams1);
    LinearLayout linearLayout6 = new LinearLayout(this.B);
    roundLinearLayout.addView((View)linearLayout6, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    linearLayout6.addView((View)a(this.B, cg.bM), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    if (i == -1) {
      editText2 = new EditText(paramContext);
      editText2.setSingleLine();
      editText2.setTextColor(ce.k.a());
      editText2.setGravity(16);
      editText2.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(16) });
      editText2.setTag(Integer.valueOf(16));
      cf.f.a((TextView)editText2);
      a((TextView)editText2);
    } else {
      editText2 = a(paramContext, (cg)null, ce.k, cf.f, i);
    } 
    linearLayout6.addView((View)editText2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, df.a(paramContext, 55.0F)));
    LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams)editText2.getLayoutParams();
    layoutParams6.topMargin = df.a(paramContext, 1.0F);
    layoutParams6.height = cc.c.a();
    editText2.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
    cf.b.a((TextView)editText2);
    editText2.setId(gv.b.a());
    if (i > 0)
      editText2.setInputType(2); 
    editText2.setBackgroundColor(-1);
    if (i > 0) {
      editText2.setHint(String.format(cg.bf.a(), new Object[] { Integer.valueOf(i) }));
    } else if (i == -1) {
      editText2.setHint("请输入卡号（15位或16位）");
    } 
    editText2.setHint("充值卡序列号");
    editText2.setHintTextColor(-6184543);
    cd.u.a((View)editText2);
    ImageView imageView2 = new ImageView(paramContext);
    imageView2.setBackgroundDrawable(ca.ar.a(paramContext));
    roundLinearLayout.addView((View)imageView2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.a(1.0F)));
    LinearLayout linearLayout5 = new LinearLayout(this.B);
    roundLinearLayout.addView((View)linearLayout5, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    linearLayout5.addView((View)a(this.B, cg.bN), (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    if (j == -1) {
      editText1 = new EditText(paramContext);
      editText1.setSingleLine();
      editText1.setTextColor(ce.k.a());
      editText1.setGravity(16);
      editText1.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(9) });
      editText1.setTag(Integer.valueOf(9));
      cf.f.a((TextView)editText1);
      a((TextView)editText1);
    } else {
      editText1 = a(paramContext, (cg)null, ce.k, cf.f, j);
    } 
    linearLayout5.addView((View)editText1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, df.a(paramContext, 55.0F)));
    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams)editText1.getLayoutParams();
    layoutParams3.topMargin = df.a(paramContext, 1.0F);
    layoutParams3.height = cc.c.a();
    editText1.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    cf.b.a((TextView)editText1);
    editText1.setId(gv.c.a());
    editText1.setInputType(2);
    if (j > 0)
      editText1.setInputType(2); 
    editText1.setBackgroundColor(-1);
    if (j > 0) {
      editText1.setHint(String.format(cg.bg.a(), new Object[] { Integer.valueOf(j) }));
    } else if (j == -1) {
      editText1.setHint("请输入卡密（8位或9位）");
    } 
    editText1.setHint("充值卡密码");
    editText1.setHintTextColor(-6184543);
    cd.u.a((View)editText1);
    this.t = a(paramContext, linearLayout1);
    this.t.setOrientation(0);
    this.t.setVisibility(4);
    this.t.setGravity(16);
    cd.d.a((View)this.t);
    ImageView imageView1 = new ImageView(paramContext);
    imageView1.setBackgroundDrawable(ca.cF.a(paramContext));
    imageView1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    layoutParams3 = new LinearLayout.LayoutParams(df.a(paramContext, 10.0F), df.a(paramContext, 10.0F));
    layoutParams3.setMargins(0, 0, df.a(paramContext, 5.0F), 0);
    this.t.addView((View)imageView1, (ViewGroup.LayoutParams)layoutParams3);
    this.u = a(paramContext, (cg)null);
    this.u.setTextColor(-12237494);
    this.u.setTextSize(2, 12.0F);
    if (a.a()) {
      this.u.setText(this.N + "元余额将会存入你的游戏币账户");
      this.t.addView((View)this.u, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
      LinearLayout linearLayout = a(paramContext, linearLayout1);
      FancyButton fancyButton1 = new FancyButton(paramContext);
      fancyButton1.setTextSize(16);
      fancyButton1.setTextColor(ce.o.a());
      fancyButton1.setId(gv.o.a());
      cd.v.a((View)fancyButton1);
      fancyButton1.setOnClickListener(this);
      fancyButton1.setRadius(cc.a(25.0F));
      fancyButton1.setBorderColor(this.B.getResources().getColor(ci.a(this.B, 2131034273)));
      fancyButton1.setBackgroundColor(this.B.getResources().getColor(ci.a(this.B, 2131034273)));
      fancyButton1.setFocusBackgroundColor(this.B.getResources().getColor(ci.a(this.B, 2131034274)));
      LinearLayout.LayoutParams layoutParams = a(3);
      layoutParams.setMargins(cc.l.a(), 0, cc.l.a(), df.a(paramContext, 10.0F));
      layoutParams.gravity = 1;
      linearLayout.addView((View)fancyButton1, (ViewGroup.LayoutParams)layoutParams);
      fancyButton1.setText(String.format(cg.ag.a(), new Object[] { this.M }));
      return (View)linearLayout1;
    } 
    this.u.setText(this.N + "元余额将会存入你的" + "游戏币" + "账户");
    this.t.addView((View)this.u, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    LinearLayout linearLayout2 = a(paramContext, linearLayout1);
    FancyButton fancyButton = new FancyButton(paramContext);
    fancyButton.setTextSize(16);
    fancyButton.setTextColor(ce.o.a());
    fancyButton.setId(gv.o.a());
    cd.v.a((View)fancyButton);
    fancyButton.setOnClickListener(this);
    fancyButton.setRadius(cc.a(25.0F));
    fancyButton.setBorderColor(this.B.getResources().getColor(ci.a(this.B, 2131034273)));
    fancyButton.setBackgroundColor(this.B.getResources().getColor(ci.a(this.B, 2131034273)));
    fancyButton.setFocusBackgroundColor(this.B.getResources().getColor(ci.a(this.B, 2131034274)));
    LinearLayout.LayoutParams layoutParams5 = a(3);
    layoutParams5.setMargins(cc.l.a(), 0, cc.l.a(), df.a(paramContext, 10.0F));
    layoutParams5.gravity = 1;
    linearLayout2.addView((View)fancyButton, (ViewGroup.LayoutParams)layoutParams5);
    fancyButton.setText(String.format(cg.ag.a(), new Object[] { this.M }));
    return (View)linearLayout1;
  }
  
  private String e(boolean paramBoolean) {
    if (!this.v)
      return cg.bK.a(); 
    String str = b(gv.b, 0);
    if (str == null || str.length() == 0) {
      set_child_focuse(gv.b);
      return cg.bc.a();
    } 
    if (str.length() != 15 && str.length() != 16) {
      set_child_focuse(gv.b);
      return "请输入正确的充值卡卡号";
    } 
    if (!str.matches("[A-HJ-NP-Z0-9]{5}[0-9]{10}") && !str.matches("[A-HJ-NP-Z0-9]{5}[0-9]{11}")) {
      set_child_focuse(gv.b);
      return "请输入正确的充值卡卡号";
    } 
    null = b(gv.c, 0);
    if (null == null || null.length() == 0) {
      set_child_focuse(gv.b);
      return cg.be.a();
    } 
    if (null.length() != 8 && null.length() != 9) {
      set_child_focuse(gv.b);
      return "请输入正确的充值卡密码";
    } 
    if (!null.matches("[0-9]{8}") && !null.matches("[0-9]{9}")) {
      set_child_focuse(gv.b);
      return "请输入正确的充值卡密码";
    } 
    getEnv().add("global.paymentlist.pay_card_no", str);
    getEnv().add("global.paymentlist.pay_card_passwd", null);
    return null;
  }
  
  private void e(int paramInt) {
    if (this.H != null && paramInt >= 0) {
      this.H.a(paramInt);
      d(this.C);
    } 
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    boolean bool1;
    double d;
    super.a(paramContext, paramParamChain);
    this.O = (String)paramParamChain.get("global.paymentlist.pay_state_way", String.class);
    this.C = ((Integer)paramParamChain.get("global.paymentlist.pay_channel_type", Integer.class)).intValue();
    this.E = bg.a;
    bg.a = null;
    Boolean bool = (Boolean)paramParamChain.get("global.paymentlist.pay_state_is_recharge", Boolean.class);
    if (bool != null && bool.booleanValue()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.P = bool1;
    this.J = ((Double)paramParamChain.get("global.paymentlist.pay_amount", Double.class)).doubleValue();
    Double double_ = (Double)paramParamChain.get("global.paymentlist.pay_amount_defect", Double.class);
    if (double_ == null) {
      d = this.J;
    } else {
      d = double_.doubleValue();
    } 
    this.K = d;
  }
  
  protected void b(Context paramContext) {
    w();
    FrameLayout frameLayout = getSubjectContainer();
    ScrollView scrollView = new ScrollView(paramContext);
    scrollView.setId(gv.a.a());
    scrollView.setVerticalScrollBarEnabled(false);
    frameLayout.addView((View)scrollView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    scrollView.addView(e(paramContext));
    setTileTypeText(((cg)getEnv().get("global.paymentlist.pay_title", cg.class)).a());
  }
  
  public boolean j() {
    y();
    return super.j();
  }
  
  public boolean l() {
    return super.l();
  }
  
  public void onClick(View paramView) {
    gv gv = gv.a(paramView.getId());
    switch (gu.a[gv.ordinal()]) {
      default:
        super.onClick(paramView);
      case 3:
      case 4:
      case 5:
        return;
      case 1:
      case 2:
        d(this.w);
      case 6:
      case 7:
      case 8:
      case 9:
        break;
    } 
    d(this.C);
  }
  
  protected void y() {
    a(-1L, (String)null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */