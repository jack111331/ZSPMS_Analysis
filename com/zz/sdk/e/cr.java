package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.zz.sdk.ParamChain;
import com.zz.sdk.a.bv;
import com.zz.sdk.a.hu;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.af;
import com.zz.sdk.b.a.al;
import com.zz.sdk.b.a.am;
import com.zz.sdk.b.k;
import com.zz.sdk.b.l;
import com.zz.sdk.b.o;
import com.zz.sdk.g;
import com.zz.sdk.h;
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
import com.zz.sdk.i.t;
import com.zz.sdk.i.v;
import com.zz.sdk.lib.widget.fancybuttons.FancyButton;
import com.zz.sdk.lib.widget.roundview.RoundLinearLayout;
import com.zz.sdk.lib.widget.roundview.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class cr extends k {
  private static final int r = 65536;
  
  private static final String s = "last_channel";
  
  private String A;
  
  private String B;
  
  private double C;
  
  private dk D;
  
  private String E;
  
  private ImageView F;
  
  private TextView G;
  
  private int H;
  
  private ArrayList I = null;
  
  private Handler J = new cs(this);
  
  private int K = 0;
  
  private int L = 2;
  
  private k[] M;
  
  public Double[] p = null;
  
  public ft q = null;
  
  private int t;
  
  private int u;
  
  private boolean v;
  
  private DecimalFormat w;
  
  private cm x;
  
  private int y;
  
  private boolean z;
  
  public cr(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain);
    getActivity().setRequestedOrientation(3);
    this.K = cv.t(this.f);
    bp.a("mOrientation=" + this.K);
    if (this.K == 2) {
      this.L = 20;
    } else {
      this.L = 20;
    } 
    c(paramContext);
  }
  
  private boolean A() {
    Boolean bool = (Boolean)getEnv().get("global.user.login_state_success", Boolean.class);
    if (bool != null && bool.booleanValue())
      return true; 
    bp.a("D: auto login in background...");
    dc dc = new dc(this);
    ParamChain paramChain = getEnv().getParent(g.class.getName());
    setCurrentTask(dn.a(this.f, dc, this, paramChain, false));
    return false;
  }
  
  private boolean B() {
    return (this.y <= 0);
  }
  
  private boolean C() {
    return (this.D == dk.c);
  }
  
  private void D() {
    double d1;
    if (B()) {
      a(dl.f, "10.0");
      return;
    } 
    if (this.z) {
      d1 = this.y;
    } else {
      d1 = b(this.y);
    } 
    double d2 = d1;
    if (B())
      d2 = c(d1); 
    String str = this.w.format(d2 / 100.0D);
    a(dl.f, str);
  }
  
  private boolean E() {
    if (d(getCoinBalance())) {
      View view = findViewById(dl.v.a());
      if (view instanceof CheckedTextView && view.isEnabled())
        return ((CheckedTextView)view).isChecked(); 
    } 
    return false;
  }
  
  private void F() {
    double d;
    Object object = a(ds.b);
    if (object instanceof Double) {
      d = ((Double)object).doubleValue();
    } else {
      d = 0.0D;
    } 
    e(d);
  }
  
  private void G() {
    TextView textView = (TextView)findViewById(dl.E.a());
    textView.setText("收起支付方式");
    Drawable drawable = ca.dh.a(this.f);
    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    textView.setCompoundDrawables(null, null, drawable, null);
    k[] arrayOfK = new k[this.M.length];
    for (byte b = 0; b < this.M.length; b++)
      arrayOfK[b] = this.M[b]; 
    this.x.a(arrayOfK);
  }
  
  private String H() {
    return E() ? "2" : (C() ? "1" : "0");
  }
  
  private void I() {
    bf bf = getHost();
    if (bf != null) {
      k k1 = null;
      k k2 = k1;
      if (this.x != null) {
        Object object = this.x.getItem(this.t);
        k2 = k1;
        if (object instanceof k)
          k2 = (k)object; 
      } 
      if (k2 == null) {
        b(cg.bt);
        return;
      } 
      String str = a(bf, k2);
      if (str != null) {
        b(str);
        return;
      } 
      if (E()) {
        double d = c(getCoinBalance());
        if (((Double)a(ds.b)).doubleValue() < d && this.x != null) {
          Object object = this.x.getItem(0);
          if (object instanceof k)
            k2 = (k)object; 
        } 
      } 
      c(bf, k2);
    } 
  }
  
  private o a(Context paramContext, ParamChain paramParamChain, int paramInt) {
    double d;
    o o = new o();
    o.a = (String)paramParamChain.get("global.user.login_name", String.class);
    o.b = (String)paramParamChain.get("global.caller.game_role", String.class);
    o.c = (String)paramParamChain.get("global.caller.game_server_id", String.class);
    o.q = (String)paramParamChain.get("global.user.access_token", String.class);
    o.s = (String)paramParamChain.get("global.caller.prop_name", String.class);
    o.r = (String)paramParamChain.get("global.caller.prop_id", String.class);
    o.e = cv.g(paramContext);
    o.p = (String)paramParamChain.get("global.caller.cporder", String.class);
    Double double_ = (Double)paramParamChain.get("global.paymentlist.pay_amount", Double.class);
    if (double_ == null) {
      d = 0.0D;
    } else {
      d = double_.doubleValue();
    } 
    o.d = cv.a(d);
    o.t = H();
    o.f = "";
    switch (paramInt) {
      default:
        return o;
      case 3:
      case 4:
        o.j = String.valueOf(paramInt);
        o.h = (String)paramParamChain.get("global.paymentlist.pay_card_no", String.class);
        o.i = (String)paramParamChain.get("global.paymentlist.pay_card_passwd", String.class);
      case 5:
        o.n = (String)paramParamChain.get("global.device.imsi", String.class);
      case 1001:
        break;
    } 
    o.n = (String)paramParamChain.get("global.device.imsi", String.class);
  }
  
  private String a(bf parambf, k paramk) {
    double d1;
    double d2;
    ParamChain paramChain = getEnv();
    if (paramk.B == 7) {
      d1 = ((Double)a(ds.a)).doubleValue();
    } else {
      d1 = ((Double)a(ds.b)).doubleValue();
    } 
    if (!d(d1)) {
      set_child_focuse(dl.f);
      return cg.S.a();
    } 
    if (E()) {
      d2 = c(getCoinBalance());
      if (d1 < d2) {
        if (this.x != null) {
          Object object = this.x.getItem(0);
          if (object instanceof k) {
            object = object;
          } else {
            object = paramk;
          } 
          d2 = 0.0D;
        } else {
          d2 = 0.0D;
          k k1 = paramk;
        } 
      } else {
        d2 = d1 - d2;
        k k1 = paramk;
      } 
    } else {
      d2 = d1;
      k k1 = paramk;
    } 
    if ((this.H == 6 || this.H == 3 || this.H == 4) && d2 > 500.0D)
      return cg.T.a(); 
    paramChain.add("global.paymentlist.pay_amount", Double.valueOf(d1), h.b);
    paramChain.add("global.paymentlist.pay_amount_defect", Double.valueOf(d2), h.b);
    paramChain.add("global.paymentlist.pay_channel_type", Integer.valueOf(((k)parambf).B), h.b);
    paramChain.add("global.paymentlist.pay_channel_name", ((k)parambf).x, h.b);
    paramChain.add("global.paymentlist.pay_state_is_recharge", Boolean.valueOf(C()), h.b);
    paramChain.add("global.paymentlist.pay_state_way", H(), h.b);
    if (((k)parambf).B == 101)
      bg.a = this.I; 
    switch (((k)parambf).B) {
      default:
        return "暂不支持";
      case 0:
      case 2:
      case 9:
      case 10:
      case 15:
      case 17:
      case 80:
      case 81:
        return null;
      case 1:
      case 100:
        return null;
      case 3:
      case 4:
      case 6:
      case 78:
      case 79:
      case 101:
        return null;
      case 7:
        return (d1 > getCoinBalance()) ? String.format(cg.bk.a(), new Object[] { getCoinName() }) : null;
      case 5:
        break;
    } 
    return null;
  }
  
  private void a(double paramDouble, LinearLayout paramLinearLayout) {
    Object object1;
    Object object2 = paramLinearLayout.getTag();
    if (object2 == null || !(object2 instanceof Integer));
    switch (((Integer)object2).intValue()) {
      default:
        return;
      case 7:
        break;
    } 
    if (paramLinearLayout.getChildCount() == 1) {
      object1 = paramLinearLayout.getChildAt(0);
    } else {
      object2 = new TextView(this.f);
      object1.addView((View)object2, (ViewGroup.LayoutParams)a(3));
      object1 = object2;
    } 
    double d = getCoinBalance() - paramDouble;
    if (d < 0.0D) {
      object1.setText(String.format(cg.bk.a(), new Object[] { getCoinName() }));
      object1.setTextColor(ce.j.a());
    } else {
      object1.setText(String.format(cg.bj.a(), new Object[] { this.w.format(paramDouble), getCoinName(), this.w.format(d) }));
      object1.setTextColor(ce.h.a());
    } 
    cf.b.a((TextView)object1);
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private void a(ParamChain paramParamChain, int paramInt) {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iload_2
    //   3: tableswitch default -> 24, 0 -> 324, 1 -> 330
    //   24: bipush #-2
    //   26: istore #4
    //   28: new com/zz/sdk/PaymentCallbackInfo
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #5
    //   37: aload_1
    //   38: ldc_w 'global.paymentlist.pay_result_price'
    //   41: invokeinterface remove : (Ljava/lang/String;)Ljava/lang/Object;
    //   46: astore #6
    //   48: aload #6
    //   50: instanceof java/lang/Double
    //   53: ifeq -> 336
    //   56: aload #6
    //   58: checkcast java/lang/Double
    //   61: astore #6
    //   63: aload #6
    //   65: ifnonnull -> 355
    //   68: aconst_null
    //   69: astore #6
    //   71: aload #5
    //   73: aload #6
    //   75: putfield amount : Ljava/lang/String;
    //   78: aload #5
    //   80: aload_1
    //   81: ldc_w 'global.paymentlist.pay_order_number'
    //   84: ldc_w java/lang/String
    //   87: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   92: checkcast java/lang/String
    //   95: putfield gameOrderNumber : Ljava/lang/String;
    //   98: aload #5
    //   100: iload #4
    //   102: putfield statusCode : I
    //   105: aload_1
    //   106: ldc_w 'global.paymentlist.pay_channel_type'
    //   109: ldc_w java/lang/Integer
    //   112: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   117: checkcast java/lang/Integer
    //   120: astore #6
    //   122: aload #6
    //   124: ifnonnull -> 368
    //   127: iload_3
    //   128: istore #4
    //   130: aload #5
    //   132: iload #4
    //   134: putfield payWayType : I
    //   137: aload #5
    //   139: aload_1
    //   140: ldc_w 'global.paymentlist.pay_channel_name'
    //   143: ldc_w java/lang/String
    //   146: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   151: checkcast java/lang/String
    //   154: putfield payWayName : Ljava/lang/String;
    //   157: aload #5
    //   159: ldc_w 'RMB'
    //   162: putfield currency : Ljava/lang/String;
    //   165: aload_0
    //   166: iconst_1
    //   167: iload_2
    //   168: aload #5
    //   170: invokevirtual a : (IILjava/lang/Object;)Z
    //   173: pop
    //   174: aload #5
    //   176: getfield gameOrderNumber : Ljava/lang/String;
    //   179: ifnull -> 323
    //   182: new com/zz/sdk/b/m
    //   185: dup
    //   186: invokespecial <init> : ()V
    //   189: astore #6
    //   191: aload #6
    //   193: aload_1
    //   194: ldc_w 'global.user.login_name'
    //   197: ldc_w java/lang/String
    //   200: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   205: checkcast java/lang/String
    //   208: invokevirtual c : (Ljava/lang/String;)V
    //   211: aload #6
    //   213: aload #5
    //   215: getfield gameOrderNumber : Ljava/lang/String;
    //   218: invokevirtual d : (Ljava/lang/String;)V
    //   221: aload #6
    //   223: aload #5
    //   225: getfield amount : Ljava/lang/String;
    //   228: invokevirtual a : (Ljava/lang/String;)V
    //   231: aload #6
    //   233: new java/text/SimpleDateFormat
    //   236: dup
    //   237: ldc_w 'yyyy-MM-dd HH:mm:ss'
    //   240: invokespecial <init> : (Ljava/lang/String;)V
    //   243: new java/util/Date
    //   246: dup
    //   247: invokestatic currentTimeMillis : ()J
    //   250: invokespecial <init> : (J)V
    //   253: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   256: invokevirtual e : (Ljava/lang/String;)V
    //   259: aload #6
    //   261: new java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial <init> : ()V
    //   268: aload #5
    //   270: getfield payWayType : I
    //   273: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   276: ldc_w ''
    //   279: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual toString : ()Ljava/lang/String;
    //   285: invokevirtual f : (Ljava/lang/String;)V
    //   288: aload #6
    //   290: ldc_w ''
    //   293: invokevirtual g : (Ljava/lang/String;)V
    //   296: aload #6
    //   298: aload #5
    //   300: getfield amount : Ljava/lang/String;
    //   303: invokevirtual b : (Ljava/lang/String;)V
    //   306: new com/zz/sdk/b/n
    //   309: dup
    //   310: aload_0
    //   311: getfield f : Landroid/content/Context;
    //   314: invokespecial <init> : (Landroid/content/Context;)V
    //   317: aload #6
    //   319: invokevirtual a : (Lcom/zz/sdk/b/m;)Z
    //   322: pop
    //   323: return
    //   324: iconst_0
    //   325: istore #4
    //   327: goto -> 28
    //   330: iconst_m1
    //   331: istore #4
    //   333: goto -> 28
    //   336: aload_1
    //   337: ldc_w 'global.paymentlist.pay_amount'
    //   340: ldc java/lang/Double
    //   342: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   347: checkcast java/lang/Double
    //   350: astore #6
    //   352: goto -> 63
    //   355: aload #6
    //   357: invokevirtual doubleValue : ()D
    //   360: invokestatic a : (D)Ljava/lang/String;
    //   363: astore #6
    //   365: goto -> 71
    //   368: aload #6
    //   370: invokevirtual intValue : ()I
    //   373: istore #4
    //   375: goto -> 130
  }
  
  private void a(a parama) {
    if (parama != null && parama.c()) {
      z();
      return;
    } 
    bp.a("D: login failed(2)!");
    d(false);
  }
  
  private void a(al paramal, String paramString) {
    a(-1L, cg.aj.a());
    a(cg.aj.a(), new cw(this));
    cx cx = new cx(this);
    setCurrentTask(dt.a(getConnectionUtil(), cx, paramal, paramString));
  }
  
  private void a(dk paramdk) {
    View view;
    if (paramdk == dk.d) {
      if (B()) {
        a(dl.e, cg.I);
        view = findViewById(dl.f.a());
        if (view instanceof TextView)
          ((TextView)view).setHint(cg.J.a()); 
        a(dl.g, cg.K);
      } 
      a(dl.w, 0);
      return;
    } 
    if (view == dk.c) {
      if (B()) {
        a(dl.e, cg.Q);
        view = findViewById(dl.f.a());
        if (view instanceof TextView)
          ((TextView)view).setHint(cg.R.a()); 
        a(dl.g, getCoinName());
      } 
      a(dl.w, 8);
    } 
  }
  
  private void a(double[] paramArrayOfdouble) {
    Context context = this.f;
    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setPadding(cc.a(48.0F), cc.a(5.0F), cc.a(48.0F), cc.a(30.0F));
    if (paramArrayOfdouble == null || paramArrayOfdouble.length == 0) {
      linearLayout.addView((View)a(context, cg.bw), (ViewGroup.LayoutParams)a(2));
    } else {
      dr dr = new dr(this.f);
      dr.setBackgroundDrawable(ca.t.a(context));
      cd.e.a((View)dr);
      linearLayout.addView((View)dr, (ViewGroup.LayoutParams)a(3));
      dr.setSelector(17170445);
      dr.setColumnWidth(cc.a(80.0F));
      dr.setHorizontalSpacing(cc.a(2.0F));
      dr.setVerticalSpacing(cc.a(2.0F));
      dr.setNumColumns(-1);
      dr.setAdapter((ListAdapter)new r(this.f, this.w, cg.aa.a(), paramArrayOfdouble));
      dr.setOnItemClickListener(new cz(this));
    } 
    a((View)linearLayout);
  }
  
  private boolean a(al paramal) {
    am am = (am)paramal;
    String str2 = am.u;
    String str1 = am.v;
    try {
      String str = URLEncoder.encode(str1, "UTF-8");
      str1 = str;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
    } 
    (new Thread(new di(this, str2 + "&sign=\"" + str1 + "\""))).start();
    return true;
  }
  
  private boolean a(bf parambf, k paramk, a parama) {
    String str;
    if (parama == null || !parama.e()) {
      a(cg.al);
      return false;
    } 
    if (parambf != null && paramk != null && parama instanceof al && parama.c()) {
      ParamChain paramChain;
      Double double_ = (Double)getEnv().get("global.paymentlist.pay_amount_defect", Double.class);
      if (E()) {
        if (parama instanceof al && parama.h == l.a.b() && (double_ == null || !d(double_.doubleValue()))) {
          al al = (al)parama;
          str = al.n;
          getEnv().add("global.paymentlist.pay_order_number", str, h.b);
          a(al, str);
          return false;
        } 
        if (parama instanceof al && parama.h == l.b.b()) {
          paramChain = getEnv();
          paramChain.add("global.paymentlist.pay_order_number", ((al)parama).n, h.b);
          g();
          a(paramChain, 0);
          b(paramChain, 0);
          return false;
        } 
        if (parama.h == l.d.b()) {
          g();
          a(getEnv(), 1);
          if (parama.i != null) {
            set_child_focuse(dl.d);
            a(true, parama.i);
            y();
          } else {
            b(getEnv(), 1);
          } 
          return false;
        } 
      } 
      g();
      return a((bf)paramChain, (k)str, (al)parama);
    } 
    if (parama.i != null) {
      a(parama.i);
      return false;
    } 
    if (str != null && ((k)str).B == 5) {
      a(cg.az);
    } else {
      a(cg.ao);
    } 
    return false;
  }
  
  private boolean a(bf parambf, k paramk, al paramal) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getEnv : ()Lcom/zz/sdk/ParamChain;
    //   4: astore #4
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: ldc_w '订单号------>'
    //   16: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_3
    //   20: getfield n : Ljava/lang/String;
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: invokestatic a : (Ljava/lang/Object;)V
    //   32: aload_3
    //   33: invokevirtual c : ()Z
    //   36: ifne -> 53
    //   39: aload_0
    //   40: aload_3
    //   41: invokevirtual f : ()Ljava/lang/String;
    //   44: invokevirtual b : (Ljava/lang/String;)V
    //   47: iconst_0
    //   48: istore #5
    //   50: iload #5
    //   52: ireturn
    //   53: aload #4
    //   55: ldc_w 'global.paymentlist.pay_order_number'
    //   58: aload_3
    //   59: getfield n : Ljava/lang/String;
    //   62: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   65: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   70: pop
    //   71: aload_2
    //   72: getfield B : I
    //   75: lookupswitch default -> 220, 0 -> 314, 1 -> 463, 2 -> 411, 3 -> 491, 4 -> 491, 5 -> 572, 6 -> 491, 7 -> 498, 9 -> 411, 10 -> 411, 15 -> 627, 17 -> 518, 78 -> 491, 79 -> 491, 80 -> 327, 81 -> 650, 100 -> 463
    //   220: aconst_null
    //   221: astore_3
    //   222: aload_3
    //   223: ifnull -> 280
    //   226: aload #4
    //   228: astore #6
    //   230: aload_2
    //   231: getfield z : Ljava/lang/String;
    //   234: ifnull -> 261
    //   237: aload #4
    //   239: invokeinterface grow : ()Lcom/zz/sdk/ParamChain;
    //   244: astore #6
    //   246: aload #6
    //   248: ldc_w 'global.help_topic'
    //   251: aload_2
    //   252: getfield z : Ljava/lang/String;
    //   255: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   260: pop
    //   261: aload_1
    //   262: aload_0
    //   263: invokevirtual getClass : ()Ljava/lang/Class;
    //   266: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   269: aload_3
    //   270: invokevirtual getName : ()Ljava/lang/String;
    //   273: aload #6
    //   275: invokeinterface a : (Ljava/lang/ClassLoader;Ljava/lang/String;Lcom/zz/sdk/ParamChain;)V
    //   280: aload_0
    //   281: getstatic com/zz/sdk/i/cg.ar : Lcom/zz/sdk/i/cg;
    //   284: invokevirtual a : ()Ljava/lang/String;
    //   287: aload_0
    //   288: getfield n : Lcom/zz/sdk/e/h;
    //   291: invokevirtual a : (Ljava/lang/CharSequence;Lcom/zz/sdk/e/h;)V
    //   294: aload_0
    //   295: getfield f : Landroid/content/Context;
    //   298: ldc 'last_channel'
    //   300: aload_2
    //   301: getfield B : I
    //   304: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)Z
    //   307: pop
    //   308: iconst_0
    //   309: istore #5
    //   311: goto -> 50
    //   314: aload_0
    //   315: aload_3
    //   316: invokespecial a : (Lcom/zz/sdk/b/a/al;)Z
    //   319: ifeq -> 327
    //   322: aconst_null
    //   323: astore_3
    //   324: goto -> 222
    //   327: aload_0
    //   328: getfield f : Landroid/content/Context;
    //   331: invokestatic i : (Landroid/content/Context;)Ljava/lang/String;
    //   334: astore #6
    //   336: aload #6
    //   338: ifnull -> 352
    //   341: ldc_w ''
    //   344: aload #6
    //   346: invokevirtual equals : (Ljava/lang/Object;)Z
    //   349: ifeq -> 378
    //   352: ldc_w 'Not Config JD AppId!'
    //   355: invokestatic b : (Ljava/lang/Object;)V
    //   358: aload_0
    //   359: aload #4
    //   361: iconst_1
    //   362: invokespecial a : (Lcom/zz/sdk/ParamChain;I)V
    //   365: aload_0
    //   366: aload #4
    //   368: iconst_1
    //   369: invokespecial b : (Lcom/zz/sdk/ParamChain;I)V
    //   372: iconst_0
    //   373: istore #5
    //   375: goto -> 50
    //   378: aload_3
    //   379: checkcast com/zz/sdk/b/a/an
    //   382: astore_3
    //   383: aload_3
    //   384: aload #6
    //   386: putfield r : Ljava/lang/String;
    //   389: aload #4
    //   391: ldc_w 'global.paymentlist.pay_jd'
    //   394: aload_3
    //   395: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   398: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   403: pop
    //   404: ldc_w com/zz/sdk/e/cj
    //   407: astore_3
    //   408: goto -> 222
    //   411: aload_3
    //   412: checkcast com/zz/sdk/b/a/am
    //   415: astore_3
    //   416: aload_3
    //   417: getfield t : Ljava/lang/String;
    //   420: astore #6
    //   422: aload #4
    //   424: ldc_w 'global.paymentlist.pay_online_url'
    //   427: aload_3
    //   428: getfield s : Ljava/lang/String;
    //   431: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   434: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   439: pop
    //   440: aload #4
    //   442: ldc_w 'global.paymentlist.pay_online_url_guard'
    //   445: aload #6
    //   447: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   450: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   455: pop
    //   456: ldc_w com/zz/sdk/e/du
    //   459: astore_3
    //   460: goto -> 222
    //   463: aload #4
    //   465: ldc_w 'global.paymentlist.pay_union_tn'
    //   468: aload_3
    //   469: checkcast com/zz/sdk/b/a/ar
    //   472: getfield p : Ljava/lang/String;
    //   475: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   478: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   483: pop
    //   484: ldc_w com/zz/sdk/e/fu
    //   487: astore_3
    //   488: goto -> 222
    //   491: ldc_w com/zz/sdk/e/go
    //   494: astore_3
    //   495: goto -> 222
    //   498: aload_0
    //   499: aload #4
    //   501: iconst_0
    //   502: invokespecial a : (Lcom/zz/sdk/ParamChain;I)V
    //   505: aload_0
    //   506: aload #4
    //   508: iconst_0
    //   509: invokespecial b : (Lcom/zz/sdk/ParamChain;I)V
    //   512: iconst_1
    //   513: istore #5
    //   515: goto -> 50
    //   518: aload_3
    //   519: checkcast com/zz/sdk/b/a/ao
    //   522: astore_1
    //   523: invokestatic getInstance : ()Lcom/xy/whf/pay/WhfPay;
    //   526: aload_0
    //   527: invokevirtual getActivity : ()Landroid/app/Activity;
    //   530: aload_0
    //   531: getfield f : Landroid/content/Context;
    //   534: invokestatic h : (Landroid/content/Context;)Ljava/lang/String;
    //   537: aload_1
    //   538: getfield p : Ljava/lang/String;
    //   541: new com/zz/sdk/e/ct
    //   544: dup
    //   545: aload_0
    //   546: invokespecial <init> : (Lcom/zz/sdk/e/cr;)V
    //   549: invokevirtual whfPay : (Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/xy/whf/pay/ResultListener;)V
    //   552: aload_0
    //   553: getfield f : Landroid/content/Context;
    //   556: ldc 'last_channel'
    //   558: aload_2
    //   559: getfield B : I
    //   562: invokestatic a : (Landroid/content/Context;Ljava/lang/String;I)Z
    //   565: pop
    //   566: iconst_1
    //   567: istore #5
    //   569: goto -> 50
    //   572: ldc_w com/zz/sdk/e/eo
    //   575: astore #6
    //   577: aload_3
    //   578: checkcast com/zz/sdk/b/a/ap
    //   581: astore_3
    //   582: aload #4
    //   584: ldc_w 'global.paymentlist.pay_sms_confirm_enabled'
    //   587: aload_3
    //   588: getfield r : Z
    //   591: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   594: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   597: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   602: pop
    //   603: aload #4
    //   605: ldc_w 'global.paymentlist.pay_sms_channel_message'
    //   608: aload_3
    //   609: getfield q : [Lcom/zz/sdk/b/u;
    //   612: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   615: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   620: pop
    //   621: aload #6
    //   623: astore_3
    //   624: goto -> 222
    //   627: ldc_w com/zz/sdk/e/fz
    //   630: astore #6
    //   632: aload #4
    //   634: ldc_w 'global.paymentlist.pay_args'
    //   637: aload_3
    //   638: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   643: pop
    //   644: aload #6
    //   646: astore_3
    //   647: goto -> 222
    //   650: ldc_w com/zz/sdk/e/gg
    //   653: astore #6
    //   655: aload #4
    //   657: ldc_w 'global.paymentlist.pay_args'
    //   660: aload_3
    //   661: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   666: pop
    //   667: aload #6
    //   669: astore_3
    //   670: goto -> 222
  }
  
  private boolean a(bf parambf, List paramList) {
    ParamChain paramChain = getEnv().grow();
    parambf.a(getClass().getClassLoader(), go.class.getName(), paramChain);
    return true;
  }
  
  private double b(double paramDouble) {
    return this.C * paramDouble;
  }
  
  private static o b(Context paramContext, ParamChain paramParamChain) {
    o o = new o();
    o.c = (String)paramParamChain.get("global.caller.game_server_id", String.class);
    o.n = (String)paramParamChain.get("global.device.imsi", String.class);
    o.a = (String)paramParamChain.get("global.user.login_name", String.class);
    o.q = (String)paramParamChain.get("global.user.access_token", String.class);
    o.s = (String)paramParamChain.get("global.caller.prop_name", String.class);
    o.r = (String)paramParamChain.get("global.caller.prop_id", String.class);
    return o;
  }
  
  private void b(int paramInt) {
    if (paramInt == dl.f.a())
      F(); 
  }
  
  private void b(ParamChain paramParamChain, int paramInt) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: iload_2
    //   3: tableswitch default -> 24, 0 -> 77, 1 -> 142
    //   24: iconst_0
    //   25: istore_2
    //   26: aconst_null
    //   27: astore #4
    //   29: aload #4
    //   31: ifnull -> 169
    //   34: aload_0
    //   35: getstatic com/zz/sdk/e/dl.d : Lcom/zz/sdk/e/dl;
    //   38: invokevirtual set_child_focuse : (Lcom/zz/sdk/e/f;)V
    //   41: iload_2
    //   42: ifne -> 152
    //   45: aload_0
    //   46: iload_3
    //   47: aload #4
    //   49: invokevirtual a : (ZLcom/zz/sdk/i/cg;)V
    //   52: iload_2
    //   53: ifeq -> 157
    //   56: aload_0
    //   57: invokevirtual o : ()V
    //   60: aload_0
    //   61: new com/zz/sdk/e/dd
    //   64: dup
    //   65: aload_0
    //   66: invokespecial <init> : (Lcom/zz/sdk/e/cr;)V
    //   69: ldc2_w 1500
    //   72: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
    //   75: pop
    //   76: return
    //   77: aload_0
    //   78: invokespecial C : ()Z
    //   81: ifeq -> 111
    //   84: getstatic com/zz/sdk/i/cg.at : Lcom/zz/sdk/i/cg;
    //   87: astore #4
    //   89: aload_1
    //   90: ifnonnull -> 119
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull -> 137
    //   99: aload_1
    //   100: invokevirtual booleanValue : ()Z
    //   103: ifeq -> 137
    //   106: iconst_1
    //   107: istore_2
    //   108: goto -> 29
    //   111: getstatic com/zz/sdk/i/cg.as : Lcom/zz/sdk/i/cg;
    //   114: astore #4
    //   116: goto -> 89
    //   119: aload_1
    //   120: ldc_w 'global.caller.is_close_window'
    //   123: ldc java/lang/Boolean
    //   125: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   130: checkcast java/lang/Boolean
    //   133: astore_1
    //   134: goto -> 95
    //   137: iconst_0
    //   138: istore_2
    //   139: goto -> 29
    //   142: getstatic com/zz/sdk/i/cg.av : Lcom/zz/sdk/i/cg;
    //   145: astore #4
    //   147: iconst_0
    //   148: istore_2
    //   149: goto -> 29
    //   152: iconst_0
    //   153: istore_3
    //   154: goto -> 45
    //   157: aload_0
    //   158: aconst_null
    //   159: invokespecial a : (Ljava/lang/Double;)V
    //   162: aload_0
    //   163: invokevirtual y : ()V
    //   166: goto -> 76
    //   169: aload_0
    //   170: invokevirtual g : ()V
    //   173: aload_0
    //   174: getstatic com/zz/sdk/e/dl.d : Lcom/zz/sdk/e/dl;
    //   177: invokevirtual set_child_focuse : (Lcom/zz/sdk/e/f;)V
    //   180: goto -> 76
  }
  
  private void b(a parama) {
    if (h()) {
      if (parama instanceof af && parama.c()) {
        af af = (af)parama;
        ParamChain paramChain = getEnv();
        if (af.s != null)
          paramChain.add("global.help_topic", af.s); 
        setCoinBalance(af.u);
        if (af.v != null && af.v.length() > 0) {
          a(dl.y, 0);
          this.F.setVisibility(0);
          a(dl.z, (CharSequence)Html.fromHtml(af.v));
          a(dl.y, 0);
        } else {
          a(dl.y, 8);
        } 
        if (af.t != null && af.t.length > 0) {
          bp.a("获取列表成功!");
          setChannelMessages(af.t);
          d(true);
          return;
        } 
      } 
      d(false);
    } 
  }
  
  private boolean b(bf parambf, k paramk) {
    ParamChain paramChain = getEnv().grow();
    if (paramk.z != null)
      paramChain.add("global.help_topic", paramk.z); 
    parambf.a(getClass().getClassLoader(), go.class.getName(), paramChain);
    return true;
  }
  
  private double c(double paramDouble) {
    return paramDouble / this.C;
  }
  
  private void c(int paramInt) {
    if ((paramInt == 7 && this.u != 7) || (paramInt != 7 && this.u == 7)) {
      double d;
      Object object = a(ds.a);
      if (object instanceof Double) {
        d = ((Double)object).doubleValue();
      } else {
        d = 0.0D;
      } 
      if (paramInt == 7) {
        String.format(cg.Y.a(), new Object[] { this.w.format(d), getCoinName() });
      } else {
        String.format(cg.X.a(), new Object[] { this.w.format(d / this.C) });
      } 
    } 
    this.u = paramInt;
  }
  
  private void c(a parama) {
    y();
    g();
    if (parama != null && parama.e()) {
      if (parama.c()) {
        a(getEnv(), 0);
        b(getEnv(), 0);
        return;
      } 
      a(getEnv(), 1);
      a(parama.f());
      return;
    } 
    super.a((Double)null);
    a(cg.al);
  }
  
  private boolean c(bf parambf, k paramk) {
    // Byte code:
    //   0: aload_2
    //   1: getfield B : I
    //   4: istore_3
    //   5: iload_3
    //   6: lookupswitch default -> 160, 0 -> 173, 1 -> 326, 2 -> 222, 3 -> 225, 4 -> 225, 5 -> 329, 6 -> 225, 7 -> 332, 9 -> 335, 10 -> 338, 15 -> 341, 17 -> 344, 78 -> 225, 79 -> 225, 80 -> 219, 81 -> 341, 100 -> 326, 101 -> 274
    //   160: aload_0
    //   161: ldc_w '暂不支持'
    //   164: invokevirtual b : (Ljava/lang/String;)V
    //   167: iconst_0
    //   168: istore #4
    //   170: iload #4
    //   172: ireturn
    //   173: aload_0
    //   174: aload_0
    //   175: getfield f : Landroid/content/Context;
    //   178: aload_0
    //   179: invokevirtual getEnv : ()Lcom/zz/sdk/ParamChain;
    //   182: iload_3
    //   183: invokespecial a : (Landroid/content/Context;Lcom/zz/sdk/ParamChain;I)Lcom/zz/sdk/b/o;
    //   186: astore #5
    //   188: iload_3
    //   189: iconst_5
    //   190: if_icmpne -> 347
    //   193: aload #5
    //   195: ifnull -> 206
    //   198: aload #5
    //   200: getfield n : Ljava/lang/String;
    //   203: ifnonnull -> 347
    //   206: aload_0
    //   207: getstatic com/zz/sdk/i/cg.ay : Lcom/zz/sdk/i/cg;
    //   210: invokevirtual a : (Lcom/zz/sdk/i/cg;)V
    //   213: iconst_0
    //   214: istore #4
    //   216: goto -> 170
    //   219: goto -> 173
    //   222: goto -> 173
    //   225: aload_0
    //   226: invokevirtual getEnv : ()Lcom/zz/sdk/ParamChain;
    //   229: ldc_w 'global.paymentlist.pay_amount_defect'
    //   232: ldc java/lang/Double
    //   234: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   239: checkcast java/lang/Double
    //   242: astore_1
    //   243: aload_1
    //   244: ifnull -> 258
    //   247: aload_0
    //   248: aload_1
    //   249: invokevirtual doubleValue : ()D
    //   252: invokespecial d : (D)Z
    //   255: ifeq -> 173
    //   258: aload_0
    //   259: aload_0
    //   260: invokevirtual getHost : ()Lcom/zz/sdk/e/bf;
    //   263: aload_2
    //   264: invokespecial b : (Lcom/zz/sdk/e/bf;Lcom/zz/sdk/b/k;)Z
    //   267: pop
    //   268: iconst_1
    //   269: istore #4
    //   271: goto -> 170
    //   274: aload_0
    //   275: invokevirtual getEnv : ()Lcom/zz/sdk/ParamChain;
    //   278: ldc_w 'global.paymentlist.pay_amount_defect'
    //   281: ldc java/lang/Double
    //   283: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   288: checkcast java/lang/Double
    //   291: astore_1
    //   292: aload_1
    //   293: ifnull -> 307
    //   296: aload_0
    //   297: aload_1
    //   298: invokevirtual doubleValue : ()D
    //   301: invokespecial d : (D)Z
    //   304: ifeq -> 173
    //   307: aload_0
    //   308: aload_0
    //   309: invokevirtual getHost : ()Lcom/zz/sdk/e/bf;
    //   312: aload_0
    //   313: getfield I : Ljava/util/ArrayList;
    //   316: invokespecial a : (Lcom/zz/sdk/e/bf;Ljava/util/List;)Z
    //   319: pop
    //   320: iconst_1
    //   321: istore #4
    //   323: goto -> 170
    //   326: goto -> 173
    //   329: goto -> 173
    //   332: goto -> 173
    //   335: goto -> 173
    //   338: goto -> 173
    //   341: goto -> 173
    //   344: goto -> 173
    //   347: aload_0
    //   348: ldc2_w -1
    //   351: getstatic com/zz/sdk/i/cg.aj : Lcom/zz/sdk/i/cg;
    //   354: invokevirtual a : ()Ljava/lang/String;
    //   357: invokevirtual a : (JLjava/lang/String;)V
    //   360: aload_0
    //   361: getstatic com/zz/sdk/i/cg.aj : Lcom/zz/sdk/i/cg;
    //   364: invokevirtual a : ()Ljava/lang/String;
    //   367: new com/zz/sdk/e/cu
    //   370: dup
    //   371: aload_0
    //   372: invokespecial <init> : (Lcom/zz/sdk/e/cr;)V
    //   375: invokevirtual a : (Ljava/lang/CharSequence;Lcom/zz/sdk/e/h;)V
    //   378: new com/zz/sdk/e/cv
    //   381: dup
    //   382: aload_0
    //   383: invokespecial <init> : (Lcom/zz/sdk/e/cr;)V
    //   386: astore_1
    //   387: aload_0
    //   388: aload_0
    //   389: invokevirtual getConnectionUtil : ()Lcom/zz/sdk/i/t;
    //   392: aload_1
    //   393: aload_2
    //   394: aload_2
    //   395: getfield B : I
    //   398: aload #5
    //   400: invokestatic a : (Lcom/zz/sdk/i/t;Lcom/zz/sdk/e/g;Ljava/lang/Object;ILcom/zz/sdk/b/o;)Landroid/os/AsyncTask;
    //   403: invokevirtual setCurrentTask : (Landroid/os/AsyncTask;)V
    //   406: iconst_0
    //   407: istore #4
    //   409: goto -> 170
  }
  
  private void d(int paramInt) {
    // Byte code:
    //   0: iload_1
    //   1: iconst_m1
    //   2: if_icmpne -> 33
    //   5: aload_0
    //   6: getfield t : I
    //   9: iflt -> 28
    //   12: aload_0
    //   13: getfield t : I
    //   16: istore_2
    //   17: aload_0
    //   18: iload_2
    //   19: invokespecial f : (I)Lcom/zz/sdk/b/k;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull -> 46
    //   27: return
    //   28: iconst_0
    //   29: istore_2
    //   30: goto -> 17
    //   33: iload_1
    //   34: istore_2
    //   35: iload_1
    //   36: aload_0
    //   37: getfield t : I
    //   40: if_icmpne -> 17
    //   43: goto -> 27
    //   46: aload_0
    //   47: aload_3
    //   48: getfield B : I
    //   51: putfield H : I
    //   54: aload_0
    //   55: getfield t : I
    //   58: iload_2
    //   59: if_icmpeq -> 101
    //   62: aload_0
    //   63: getstatic com/zz/sdk/e/dl.n : Lcom/zz/sdk/e/dl;
    //   66: invokevirtual a : ()I
    //   69: invokevirtual findViewById : (I)Landroid/view/View;
    //   72: astore_3
    //   73: aload_3
    //   74: instanceof android/widget/ViewSwitcher
    //   77: ifne -> 122
    //   80: aload_0
    //   81: iload_2
    //   82: putfield t : I
    //   85: aload_0
    //   86: aload_0
    //   87: getfield H : I
    //   90: invokespecial c : (I)V
    //   93: aload_0
    //   94: aload_0
    //   95: getfield H : I
    //   98: invokespecial e : (I)V
    //   101: aload_0
    //   102: getfield x : Lcom/zz/sdk/e/cm;
    //   105: ifnull -> 27
    //   108: aload_0
    //   109: getfield x : Lcom/zz/sdk/e/cm;
    //   112: aload_0
    //   113: getfield t : I
    //   116: invokevirtual a : (I)V
    //   119: goto -> 27
    //   122: aload_3
    //   123: checkcast android/widget/ViewSwitcher
    //   126: astore_3
    //   127: aload_0
    //   128: getfield t : I
    //   131: iflt -> 178
    //   134: aload_3
    //   135: invokevirtual getCurrentView : ()Landroid/view/View;
    //   138: astore #4
    //   140: aload #4
    //   142: instanceof android/widget/LinearLayout
    //   145: ifeq -> 178
    //   148: aload #4
    //   150: invokevirtual getTag : ()Ljava/lang/Object;
    //   153: astore #4
    //   155: aload #4
    //   157: instanceof java/lang/Integer
    //   160: ifeq -> 178
    //   163: aload #4
    //   165: checkcast java/lang/Integer
    //   168: invokevirtual intValue : ()I
    //   171: aload_0
    //   172: getfield H : I
    //   175: if_icmpeq -> 80
    //   178: aload_3
    //   179: invokevirtual getNextView : ()Landroid/view/View;
    //   182: astore #4
    //   184: aload #4
    //   186: instanceof android/widget/LinearLayout
    //   189: ifeq -> 80
    //   192: aload #4
    //   194: invokevirtual getTag : ()Ljava/lang/Object;
    //   197: astore #5
    //   199: aload #5
    //   201: ifnull -> 227
    //   204: aload #5
    //   206: instanceof java/lang/Integer
    //   209: ifeq -> 227
    //   212: aload #5
    //   214: checkcast java/lang/Integer
    //   217: invokevirtual intValue : ()I
    //   220: aload_0
    //   221: getfield H : I
    //   224: if_icmpeq -> 247
    //   227: aload #4
    //   229: checkcast android/widget/LinearLayout
    //   232: invokevirtual removeAllViews : ()V
    //   235: aload #4
    //   237: aload_0
    //   238: getfield H : I
    //   241: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   244: invokevirtual setTag : (Ljava/lang/Object;)V
    //   247: aload_3
    //   248: invokevirtual showNext : ()V
    //   251: goto -> 80
  }
  
  private void d(Context paramContext, LinearLayout paramLinearLayout) {
    LinearLayout.LayoutParams layoutParams1 = a(3);
    layoutParams1.topMargin = cc.C.a();
    layoutParams1.leftMargin = cc.l.a();
    layoutParams1.rightMargin = cc.l.a();
    TextView textView2 = new TextView(paramContext);
    textView2.setText(cg.aZ.a());
    textView2.setTextColor(-7564906);
    cf.h.a(textView2);
    LinearLayout.LayoutParams layoutParams3 = a(3);
    if (this.K != 2)
      layoutParams3.topMargin = cc.a.a(); 
    layoutParams3.leftMargin = cc.l.a();
    layoutParams3.rightMargin = cc.l.a();
    paramLinearLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams3);
    RoundLinearLayout roundLinearLayout = new RoundLinearLayout(this.f);
    roundLinearLayout.setOrientation(1);
    c c = roundLinearLayout.getDelegate();
    c.a(ce.o.a());
    c.c(5);
    c.d(1);
    if (this.K == 2)
      c.e(Color.parseColor("#ffeeeef1")); 
    roundLinearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    roundLinearLayout.setId(dl.x.a());
    paramLinearLayout.addView((View)roundLinearLayout, (ViewGroup.LayoutParams)layoutParams1);
    GridView gridView = (GridView)LayoutInflater.from(paramContext).inflate(ci.a(this.f).a(2130903144), null, true);
    gridView.setId(dl.d.a());
    gridView.setVerticalSpacing(cc.n.a());
    if (this.K == 2)
      gridView.setPadding(0, cc.C.a(), cc.C.a(), cc.C.a()); 
    gridView.setNumColumns(1);
    gridView.setScrollbarFadingEnabled(false);
    gridView.setSelector(17170445);
    roundLinearLayout.addView((View)gridView, (ViewGroup.LayoutParams)a(3));
    gridView.setOnItemClickListener(new de(this));
    this.x = new cm(paramContext, null, this.K);
    gridView.setAdapter((ListAdapter)this.x);
    LinearLayout linearLayout2 = a(this.f, (LinearLayout)roundLinearLayout);
    linearLayout2.setId(dl.D.a());
    linearLayout2.setClickable(true);
    linearLayout2.setOnClickListener(this);
    TextView textView1 = new TextView(this.f);
    textView1.setId(dl.E.a());
    textView1.setText("更多支付方式");
    textView1.setTextColor(Color.parseColor("#ff8a9098"));
    textView1.setCompoundDrawablePadding(cc.a(3.0F));
    textView1.setGravity(16);
    Drawable drawable = ca.dg.a(this.f);
    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    textView1.setCompoundDrawables(null, null, drawable, null);
    LinearLayout.LayoutParams layoutParams2 = a(2);
    layoutParams2.gravity = 1;
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout2.setVisibility(8);
    LinearLayout linearLayout4 = a(paramContext, (LinearLayout)roundLinearLayout);
    ViewSwitcher viewSwitcher = new ViewSwitcher(paramContext);
    linearLayout4.addView((View)viewSwitcher, (ViewGroup.LayoutParams)a(3));
    viewSwitcher.setId(dl.n.a());
    viewSwitcher.setMeasureAllChildren(false);
    AnimationSet animationSet = new AnimationSet(true);
    animationSet.addAnimation((Animation)new AlphaAnimation(0.2F, 1.0F));
    animationSet.setDuration(300L);
    viewSwitcher.setInAnimation((Animation)animationSet);
    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    alphaAnimation.setDuration(250L);
    viewSwitcher.setOutAnimation((Animation)alphaAnimation);
    LinearLayout linearLayout3 = new LinearLayout(paramContext);
    linearLayout3.setOrientation(1);
    viewSwitcher.addView((View)linearLayout3, new ViewGroup.LayoutParams(-1, -1));
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    viewSwitcher.addView((View)linearLayout1, new ViewGroup.LayoutParams(-1, -1));
  }
  
  private boolean d(double paramDouble) {
    return (paramDouble >= 0.009D);
  }
  
  private View e(Context paramContext) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setOrientation(1);
    if (B()) {
      linearLayout.addView(g(paramContext), (ViewGroup.LayoutParams)a(3));
      i(paramContext, linearLayout);
      return (View)linearLayout;
    } 
    linearLayout.addView(f(paramContext), (ViewGroup.LayoutParams)a(3));
    i(paramContext, linearLayout);
    return (View)linearLayout;
  }
  
  private void e(double paramDouble) {
    double d3;
    double d1 = b(paramDouble);
    double d2 = getCoinBalance();
    if (d2 < d1) {
      d3 = d2;
    } else {
      d3 = d1;
    } 
    String str = String.format(cg.F.a(), new Object[] { this.w.format(d1), getCoinName() });
    a(dl.i, (CharSequence)Html.fromHtml(str));
    if (d(d2) && !C()) {
      a(dl.w, 0);
      View view = findViewById(dl.v.a());
      if (view instanceof CheckedTextView) {
        CheckedTextView checkedTextView = (CheckedTextView)view;
        String str1 = this.w.format(d3);
        checkedTextView.setText((CharSequence)Html.fromHtml(String.format(cg.L.a(), new Object[] { str1, getCoinName() })));
        if (d(d3)) {
          if (!checkedTextView.isEnabled())
            checkedTextView.setChecked(true); 
          checkedTextView.setEnabled(true);
        } else {
          checkedTextView.setEnabled(false);
          checkedTextView.setChecked(false);
        } 
      } 
    } else {
      a(dl.w, 8);
    } 
    d2 = d1;
    if (E())
      d2 = d1 - d3; 
    d1 = c(d2);
    if (!d(paramDouble) || d(d1)) {
      a(dl.x, 0);
      str = this.w.format(d1);
      String str1 = String.format(cg.M.a(), new Object[] { str });
      a(dl.u, (CharSequence)Html.fromHtml(str1));
      e(this.H);
      a(dl.q, 0);
      str1 = String.format(cg.N.a(), new Object[] { str });
      a(dl.r, (CharSequence)Html.fromHtml(str1));
      str = String.format(cg.ag.a(), new Object[] { str });
      ((FancyButton)findViewById(dl.l.a())).setText(str);
      f(d1);
      return;
    } 
    a(dl.x, 8);
    a(dl.u, (CharSequence)Html.fromHtml(cg.O.a()));
    e(7);
    a(dl.q, 4);
    str = String.format(cg.ag.a(), new Object[] { Integer.valueOf(0) });
    ((FancyButton)findViewById(dl.l.a())).setText(str);
  }
  
  private void e(int paramInt) {
    switch (paramInt) {
      default:
        a(dl.l, cg.bl);
        return;
      case 3:
      case 4:
      case 6:
      case 78:
      case 79:
      case 101:
        break;
    } 
    a(dl.l, cg.bn);
  }
  
  private void e(Context paramContext, LinearLayout paramLinearLayout) {
    FancyButton fancyButton = new FancyButton(paramContext);
    fancyButton.setTextSize(16);
    fancyButton.setTextColor(ce.o.a());
    fancyButton.setVisibility(8);
    fancyButton.setId(dl.l.a());
    cd.v.a((View)fancyButton);
    fancyButton.setOnClickListener(this);
    fancyButton.setRadius(cc.a(25.0F));
    fancyButton.setBorderColor(this.f.getResources().getColor(ci.a(this.f, 2131034273)));
    fancyButton.setBackgroundColor(this.f.getResources().getColor(ci.a(this.f, 2131034273)));
    fancyButton.setFocusBackgroundColor(this.f.getResources().getColor(ci.a(this.f, 2131034274)));
    LinearLayout.LayoutParams layoutParams = a(3);
    if (this.K == 2) {
      layoutParams.setMargins(cc.d.a(), df.a(paramContext, 10.0F), cc.d.a(), df.a(paramContext, 20.0F));
    } else {
      layoutParams.setMargins(cc.e.a(), df.a(paramContext, 10.0F), cc.e.a(), df.a(paramContext, 20.0F));
    } 
    layoutParams.gravity = 1;
    paramLinearLayout.addView((View)fancyButton, (ViewGroup.LayoutParams)layoutParams);
  }
  
  private View f(Context paramContext) {
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    if (this.K == 2) {
      linearLayout1.setOrientation(0);
      linearLayout1.setBackgroundColor(-1);
      LinearLayout linearLayout4 = new LinearLayout(paramContext);
      linearLayout4.setOrientation(1);
      LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -1, 1.0F);
      layoutParams8.topMargin = cc.l.a();
      linearLayout1.addView((View)linearLayout4, (ViewGroup.LayoutParams)layoutParams8);
      double d1 = (cv.c(paramContext) / 2 - cc.l.a() * 2) / 1.97D;
      RelativeLayout relativeLayout1 = new RelativeLayout(paramContext);
      LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, (int)d1);
      layoutParams9.leftMargin = cc.l.a();
      layoutParams9.rightMargin = cc.l.a();
      relativeLayout1.setBackgroundResource(ci.a(paramContext, 2130837667));
      linearLayout4.addView((View)relativeLayout1, (ViewGroup.LayoutParams)layoutParams9);
      LinearLayout linearLayout7 = new LinearLayout(paramContext);
      linearLayout7.setOrientation(0);
      RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams11.addRule(14);
      layoutParams11.topMargin = (int)(d1 / 3.0D);
      relativeLayout1.addView((View)linearLayout7, (ViewGroup.LayoutParams)layoutParams11);
      TextView textView7 = new TextView(paramContext);
      textView7.setText(cg.G.a());
      textView7.setTextColor(-11840933);
      cf.h.a(textView7);
      linearLayout7.addView((View)textView7);
      textView7 = new TextView(paramContext);
      textView7.setId(dl.f.a());
      textView7.setTextColor(-837048);
      cf.n.a(textView7);
      linearLayout7.addView((View)textView7);
      textView7 = new TextView(paramContext);
      textView7.setText(getCoinName());
      textView7.setTextColor(-11840933);
      cf.h.a(textView7);
      linearLayout7.addView((View)textView7);
      TextView textView5 = new TextView(paramContext);
      textView5.setText(cg.bu.a());
      textView5.setTextColor(-1);
      textView5.setOnClickListener(new df(this));
      cf.j.a(textView5);
      RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
      layoutParams10.addRule(11);
      layoutParams10.addRule(12);
      layoutParams10.rightMargin = cc.l.a();
      layoutParams10.bottomMargin = cc.x.a();
      relativeLayout1.addView((View)textView5, (ViewGroup.LayoutParams)layoutParams10);
      LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
      layoutParams7.topMargin = cc.a.a();
      layoutParams7.leftMargin = cc.h.a();
      layoutParams7.rightMargin = cc.h.a();
      LinearLayout linearLayout6 = new LinearLayout(paramContext);
      linearLayout6.setOrientation(0);
      linearLayout6.setGravity(19);
      linearLayout4.addView((View)linearLayout6, (ViewGroup.LayoutParams)layoutParams7);
      TextView textView6 = new TextView(paramContext);
      textView6.setText(cg.C.a());
      textView6.setTextColor(-13421773);
      cf.h.a(textView6);
      linearLayout6.addView((View)textView6);
      textView6 = new TextView(paramContext);
      textView6.setText(this.B);
      textView6.setTextColor(-837048);
      cf.h.a(textView6);
      linearLayout6.addView((View)textView6);
      linearLayout6 = new LinearLayout(paramContext);
      linearLayout6.setOrientation(0);
      linearLayout6.setGravity(19);
      linearLayout4.addView((View)linearLayout6, (ViewGroup.LayoutParams)layoutParams7);
      textView6 = new TextView(paramContext);
      textView6.setText(cg.ad.a());
      textView6.setTextColor(-13421773);
      cf.h.a(textView6);
      linearLayout6.addView((View)textView6);
      textView6 = new TextView(paramContext);
      textView6.setId(dl.F.a());
      textView6.setText(String.valueOf(getCoinBalance()));
      textView6.setTextColor(-837048);
      cf.h.a(textView6);
      linearLayout6.addView((View)textView6);
      textView6 = new TextView(paramContext);
      textView6.setText(getCoinName());
      textView6.setTextColor(-13421773);
      cf.h.a(textView6);
      linearLayout6.addView((View)textView6);
      if (v.z != null && !v.z.f().equals("")) {
        linearLayout6 = new LinearLayout(paramContext);
        linearLayout6.setOrientation(0);
        linearLayout6.setGravity(19);
        linearLayout4.addView((View)linearLayout6, (ViewGroup.LayoutParams)layoutParams7);
        TextView textView = new TextView(paramContext);
        textView.setText(cg.ai.a());
        textView.setTextColor(-11840933);
        cf.h.a(textView);
        linearLayout6.addView((View)textView);
        textView = new TextView(paramContext);
        textView.setText(v.z.f());
        textView.setTextColor(-7564906);
        cf.h.a(textView);
        linearLayout6.addView((View)textView);
      } 
      h(paramContext, linearLayout4);
      linearLayout4 = new LinearLayout(paramContext);
      linearLayout4.setOrientation(1);
      layoutParams7 = new LinearLayout.LayoutParams(0, -1, 1.0F);
      layoutParams7.topMargin = cc.l.a();
      linearLayout1.addView((View)linearLayout4, (ViewGroup.LayoutParams)layoutParams7);
      LinearLayout linearLayout5 = new LinearLayout(paramContext);
      linearLayout5.setOrientation(1);
      linearLayout4.addView((View)linearLayout5, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 0, 1.0F));
      d(paramContext, linearLayout5);
      e(paramContext, linearLayout4);
      return (View)linearLayout1;
    } 
    linearLayout1.setOrientation(1);
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    linearLayout2.setOrientation(1);
    linearLayout2.setBackgroundColor(-1);
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 0, 1.0F));
    linearLayout2.setOrientation(1);
    linearLayout2.setBackgroundColor(-1);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, cc.d.a());
    layoutParams2.leftMargin = cc.l.a();
    layoutParams2.rightMargin = cc.l.a();
    if (v.z != null && !v.z.f().equals("")) {
      LinearLayout linearLayout = new LinearLayout(paramContext);
      linearLayout.setOrientation(0);
      linearLayout.setGravity(19);
      linearLayout2.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
      TextView textView = new TextView(paramContext);
      textView.setText(cg.ai.a());
      textView.setTextColor(-11840933);
      cf.h.a(textView);
      linearLayout.addView((View)textView);
      textView = new TextView(paramContext);
      textView.setText(v.z.f());
      textView.setTextColor(-7564906);
      cf.h.a(textView);
      linearLayout.addView((View)textView);
    } 
    double d = (cv.c(paramContext) - cc.u.a() * 2) / 1.97D;
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int)d);
    layoutParams4.leftMargin = cc.u.a();
    layoutParams4.rightMargin = cc.u.a();
    relativeLayout.setBackgroundResource(ci.a(paramContext, 2130837667));
    linearLayout2.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams4);
    LinearLayout linearLayout3 = new LinearLayout(paramContext);
    linearLayout3.setOrientation(0);
    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams6.addRule(14);
    layoutParams6.topMargin = (int)(d / 3.0D);
    relativeLayout.addView((View)linearLayout3, (ViewGroup.LayoutParams)layoutParams6);
    TextView textView4 = new TextView(paramContext);
    textView4.setText(cg.G.a());
    textView4.setTextColor(-11840933);
    cf.h.a(textView4);
    linearLayout3.addView((View)textView4);
    textView4 = new TextView(paramContext);
    textView4.setId(dl.f.a());
    textView4.setTextColor(-837048);
    cf.n.a(textView4);
    linearLayout3.addView((View)textView4);
    textView4 = new TextView(paramContext);
    textView4.setText(getCoinName());
    textView4.setTextColor(-11840933);
    cf.h.a(textView4);
    linearLayout3.addView((View)textView4);
    textView4 = new TextView(paramContext);
    textView4.setText(cg.bu.a());
    textView4.setTextColor(-1);
    textView4.setOnClickListener(new dg(this));
    cf.j.a(textView4);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(11);
    layoutParams3.addRule(12);
    layoutParams3.rightMargin = cc.l.a();
    layoutParams3.bottomMargin = cc.x.a();
    relativeLayout.addView((View)textView4, (ViewGroup.LayoutParams)layoutParams3);
    relativeLayout = new RelativeLayout(paramContext);
    linearLayout2.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams2);
    TextView textView2 = new TextView(paramContext);
    textView2.setId(776);
    textView2.setText(cg.C.a());
    textView2.setTextColor(-13421773);
    cf.h.a(textView2);
    layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(15);
    relativeLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams3);
    textView4 = new TextView(paramContext);
    textView4.setText(this.B);
    textView4.setTextColor(-837048);
    cf.h.a(textView4);
    layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams3.addRule(15);
    layoutParams3.addRule(1, textView2.getId());
    relativeLayout.addView((View)textView4, (ViewGroup.LayoutParams)layoutParams3);
    TextView textView3 = new TextView(paramContext);
    textView3.setId(777);
    textView3.setText(getCoinName());
    textView3.setTextColor(-13421773);
    cf.h.a(textView3);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams1.addRule(15);
    layoutParams1.addRule(11);
    relativeLayout.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams1);
    TextView textView1 = new TextView(paramContext);
    textView1.setId(dl.F.a());
    textView1.setText(String.valueOf(getCoinBalance()));
    textView1.setTextColor(-837048);
    cf.h.a(textView1);
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams5.addRule(15);
    layoutParams5.addRule(0, textView3.getId());
    relativeLayout.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams5);
    textView3 = new TextView(paramContext);
    textView3.setText(cg.ad.a());
    textView3.setTextColor(-13421773);
    cf.h.a(textView3);
    layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams5.addRule(15);
    layoutParams5.addRule(0, textView1.getId());
    relativeLayout.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams5);
    h(paramContext, linearLayout2);
    g(paramContext, linearLayout2);
    f(paramContext, linearLayout2);
    d(paramContext, linearLayout2);
    e(paramContext, linearLayout1);
    return (View)linearLayout1;
  }
  
  private k f(int paramInt) {
    if (this.x != null) {
      Object object = this.x.getItem(paramInt);
      if (object instanceof k)
        return (k)object; 
    } 
    return null;
  }
  
  private void f(double paramDouble) {
    View view = findViewById(dl.n.a());
    if (view instanceof ViewSwitcher) {
      ViewSwitcher viewSwitcher = (ViewSwitcher)view;
      View view2 = viewSwitcher.getCurrentView();
      if (view2 != null && view2 instanceof LinearLayout)
        a(paramDouble, (LinearLayout)view2); 
      View view1 = viewSwitcher.getNextView();
      if (view1 != null && view1 instanceof LinearLayout)
        a(paramDouble, (LinearLayout)view1); 
    } 
  }
  
  private void f(Context paramContext, LinearLayout paramLinearLayout) {
    View view = new View(paramContext);
    view.setBackgroundColor(-854533);
    paramLinearLayout.addView(view, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, cc.C.a()));
  }
  
  private View g(Context paramContext) {
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    linearLayout1.setBackgroundDrawable(ca.aq.a(paramContext));
    cd.d.a((View)linearLayout1);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cc.c.a());
    RelativeLayout relativeLayout1 = new RelativeLayout(paramContext);
    linearLayout1.addView((View)relativeLayout1, (ViewGroup.LayoutParams)layoutParams);
    TextView textView3 = a(paramContext, cg.I);
    cf.b.a(textView3);
    textView3.setTextColor(-7105642);
    relativeLayout1.addView((View)textView3, (ViewGroup.LayoutParams)a(0));
    textView3.setId(dl.e.a());
    RelativeLayout relativeLayout2 = new RelativeLayout(paramContext);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-2, -1);
    layoutParams1.addRule(11);
    layoutParams1.addRule(15);
    relativeLayout1.addView((View)relativeLayout2, (ViewGroup.LayoutParams)layoutParams1);
    ImageButton imageButton = new ImageButton(paramContext);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(df.a(paramContext, 7.0F), df.a(paramContext, 12.0F));
    layoutParams2.addRule(11);
    layoutParams2.addRule(15);
    relativeLayout2.addView((View)imageButton, (ViewGroup.LayoutParams)layoutParams2);
    imageButton.setBackgroundDrawable(ca.aD.a(paramContext));
    imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    imageButton.setId(dl.h.a());
    imageButton.setOnClickListener(this);
    TextView textView4 = new TextView(paramContext);
    cf.b.a(textView4);
    textView4.setTextColor(-1623778);
    textView4.setId(dl.f.a());
    textView4.setBackgroundDrawable(null);
    textView4.setClickable(true);
    textView4.setOnClickListener(this);
    textView4.setGravity(5);
    layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams2.addRule(0, imageButton.getId());
    layoutParams2.addRule(15);
    layoutParams2.rightMargin = df.a(paramContext, 7.0F);
    relativeLayout2.addView((View)textView4, (ViewGroup.LayoutParams)layoutParams2);
    textView4.addTextChangedListener(new do(this, textView4.getId()));
    TextView textView2 = a(paramContext, cg.K);
    relativeLayout1.addView((View)textView2, (ViewGroup.LayoutParams)a(0));
    textView2.setId(dl.g.a());
    textView2.setVisibility(8);
    ImageView imageView = new ImageView(paramContext);
    imageView.setBackgroundDrawable(ca.ar.a(paramContext));
    linearLayout1.addView((View)imageView, (ViewGroup.LayoutParams)a(3));
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    linearLayout2.setGravity(16);
    linearLayout2.setOrientation(0);
    TextView textView1 = a(paramContext, (cg)null);
    cf.b.a(textView1);
    textView1.setTextColor(-7105642);
    textView1.setId(dl.i.a());
    linearLayout2.addView((View)textView1);
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams);
    h(paramContext, linearLayout1);
    return (View)linearLayout1;
  }
  
  private void g(int paramInt) {
    paramInt = 65536 + paramInt;
    this.J.removeMessages(paramInt);
    this.J.sendEmptyMessageDelayed(paramInt, 300L);
  }
  
  private void g(Context paramContext, LinearLayout paramLinearLayout) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, cc.f.a());
    layoutParams2.leftMargin = cc.l.a();
    layoutParams2.rightMargin = cc.l.a();
    paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    linearLayout.setOrientation(0);
    linearLayout.setGravity(16);
    linearLayout.setId(dl.y.a());
    linearLayout.setVisibility(0);
    this.F = new ImageView(paramContext);
    this.F.setImageDrawable(ca.aA.a(paramContext));
    this.F.setScaleType(ImageView.ScaleType.FIT_CENTER);
    this.F.setVisibility(0);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(df.a(paramContext, 13.0F), df.a(paramContext, 13.0F));
    layoutParams1.leftMargin = df.a(paramContext, 0.0F);
    linearLayout.addView((View)this.F, (ViewGroup.LayoutParams)layoutParams1);
    TextView textView = a(paramContext, (cg)null);
    textView.setTextSize(2, 12.0F);
    textView.setTextColor(-1623778);
    textView.setId(dl.z.a());
    layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
    layoutParams2.leftMargin = df.a(paramContext, 5.0F);
    linearLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams2);
    textView.setSingleLine(false);
    cd.i.a((View)textView);
  }
  
  private View h(Context paramContext) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setGravity(5);
    TextView textView = new TextView(paramContext);
    textView.setId(dl.C.a());
    textView.setVisibility(8);
    textView.setText("其它支付方式");
    textView.getPaint().setFlags(8);
    textView.setTextColor(Color.rgb(3, 148, 225));
    textView.setOnClickListener(this);
    linearLayout.addView((View)textView);
    linearLayout.setPadding(cc.a(10.0F), cc.a(5.0F), 0, cc.a(5.0F));
    return (View)linearLayout;
  }
  
  private View h(Context paramContext, LinearLayout paramLinearLayout) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    if (this.K == 2) {
      layoutParams.topMargin = cc.a.a();
      layoutParams.leftMargin = cc.h.a();
      layoutParams.rightMargin = cc.h.a();
      paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
      linearLayout.setOrientation(0);
      linearLayout.setGravity(16);
      linearLayout.setId(dl.w.a());
      cd.f.a((View)linearLayout);
      checkedTextView = new CheckedTextView(paramContext);
      checkedTextView.setId(dl.v.a());
      checkedTextView.setCheckMarkDrawable((Drawable)ca.b(paramContext, ca.at, ca.aw));
      checkedTextView.setGravity(16);
      checkedTextView.setTextColor(-11840933);
      cf.h.a((TextView)checkedTextView);
      checkedTextView.setEnabled(false);
      checkedTextView.setChecked(true);
      checkedTextView.setOnClickListener(this);
      linearLayout.addView((View)checkedTextView, (ViewGroup.LayoutParams)a(3));
      return (View)linearLayout;
    } 
    layoutParams.leftMargin = cc.l.a();
    layoutParams.rightMargin = cc.l.a();
    layoutParams.bottomMargin = cc.x.a();
    checkedTextView.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    linearLayout.setOrientation(0);
    linearLayout.setGravity(16);
    linearLayout.setId(dl.w.a());
    cd.f.a((View)linearLayout);
    CheckedTextView checkedTextView = new CheckedTextView(paramContext);
    checkedTextView.setId(dl.v.a());
    checkedTextView.setCheckMarkDrawable((Drawable)ca.b(paramContext, ca.at, ca.aw));
    checkedTextView.setGravity(16);
    checkedTextView.setTextColor(-11840933);
    cf.h.a((TextView)checkedTextView);
    checkedTextView.setEnabled(false);
    checkedTextView.setChecked(true);
    checkedTextView.setOnClickListener(this);
    linearLayout.addView((View)checkedTextView, (ViewGroup.LayoutParams)a(3));
    return (View)linearLayout;
  }
  
  private View i(Context paramContext, LinearLayout paramLinearLayout) {
    LinearLayout linearLayout = new LinearLayout(paramContext);
    linearLayout.setGravity(16);
    linearLayout.setOrientation(1);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cc.c.a());
    layoutParams.leftMargin = cc.l.a();
    layoutParams.rightMargin = cc.l.a();
    paramLinearLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
    linearLayout.setBackgroundColor(-1);
    cd.d.a((View)linearLayout);
    TextView textView = new TextView(paramContext);
    textView.setSingleLine();
    textView.setTextColor(-12237494);
    textView.setGravity(19);
    cf.b.a(textView);
    textView.setId(dl.u.a());
    linearLayout.addView((View)textView);
    linearLayout.setVisibility(8);
    return (View)linearLayout;
  }
  
  private void setChannelMessages(k[] paramArrayOfk) {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_2
    //   2: aload_0
    //   3: new java/util/ArrayList
    //   6: dup
    //   7: invokespecial <init> : ()V
    //   10: putfield I : Ljava/util/ArrayList;
    //   13: invokestatic getPaySequenceTop : ()I
    //   16: istore_3
    //   17: new java/util/ArrayList
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: astore #4
    //   26: aload_1
    //   27: arraylength
    //   28: istore #5
    //   30: iconst_0
    //   31: istore #6
    //   33: iload #6
    //   35: iload #5
    //   37: if_icmpge -> 194
    //   40: aload_1
    //   41: iload #6
    //   43: aaload
    //   44: astore #7
    //   46: aload #7
    //   48: invokevirtual c : ()Z
    //   51: ifne -> 60
    //   54: iinc #6, 1
    //   57: goto -> 33
    //   60: aload #7
    //   62: getfield B : I
    //   65: bipush #7
    //   67: if_icmpne -> 84
    //   70: aload_0
    //   71: getfield v : Z
    //   74: ifne -> 54
    //   77: aload_0
    //   78: invokespecial C : ()Z
    //   81: ifne -> 54
    //   84: aload #7
    //   86: getfield B : I
    //   89: bipush #7
    //   91: if_icmpeq -> 54
    //   94: aload #7
    //   96: getfield B : I
    //   99: bipush #79
    //   101: if_icmpeq -> 142
    //   104: aload #7
    //   106: getfield B : I
    //   109: bipush #78
    //   111: if_icmpeq -> 142
    //   114: aload #7
    //   116: getfield B : I
    //   119: iconst_4
    //   120: if_icmpeq -> 142
    //   123: aload #7
    //   125: getfield B : I
    //   128: iconst_3
    //   129: if_icmpeq -> 142
    //   132: aload #7
    //   134: getfield B : I
    //   137: bipush #6
    //   139: if_icmpne -> 155
    //   142: aload_0
    //   143: getfield I : Ljava/util/ArrayList;
    //   146: aload #7
    //   148: invokevirtual add : (Ljava/lang/Object;)Z
    //   151: pop
    //   152: goto -> 54
    //   155: iload_3
    //   156: iflt -> 181
    //   159: aload #7
    //   161: getfield B : I
    //   164: iload_3
    //   165: if_icmpne -> 181
    //   168: aload #4
    //   170: iconst_0
    //   171: aload #7
    //   173: invokeinterface add : (ILjava/lang/Object;)V
    //   178: goto -> 54
    //   181: aload #4
    //   183: aload #7
    //   185: invokeinterface add : (Ljava/lang/Object;)Z
    //   190: pop
    //   191: goto -> 54
    //   194: aload_0
    //   195: getfield I : Ljava/util/ArrayList;
    //   198: invokevirtual size : ()I
    //   201: ifle -> 234
    //   204: new com/zz/sdk/b/k
    //   207: dup
    //   208: invokespecial <init> : ()V
    //   211: astore_1
    //   212: aload_1
    //   213: bipush #101
    //   215: putfield B : I
    //   218: aload_1
    //   219: ldc_w '充值卡'
    //   222: putfield x : Ljava/lang/String;
    //   225: aload #4
    //   227: aload_1
    //   228: invokeinterface add : (Ljava/lang/Object;)Z
    //   233: pop
    //   234: aload_0
    //   235: aload #4
    //   237: invokeinterface size : ()I
    //   242: anewarray com/zz/sdk/b/k
    //   245: putfield M : [Lcom/zz/sdk/b/k;
    //   248: aload_0
    //   249: aload #4
    //   251: aload_0
    //   252: getfield M : [Lcom/zz/sdk/b/k;
    //   255: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   260: checkcast [Lcom/zz/sdk/b/k;
    //   263: putfield M : [Lcom/zz/sdk/b/k;
    //   266: aload_0
    //   267: getfield M : [Lcom/zz/sdk/b/k;
    //   270: arraylength
    //   271: aload_0
    //   272: getfield L : I
    //   275: if_icmple -> 453
    //   278: aload_0
    //   279: getfield L : I
    //   282: anewarray com/zz/sdk/b/k
    //   285: astore_1
    //   286: iconst_0
    //   287: istore #6
    //   289: iload #6
    //   291: aload_0
    //   292: getfield L : I
    //   295: if_icmpge -> 315
    //   298: aload_1
    //   299: iload #6
    //   301: aload_0
    //   302: getfield M : [Lcom/zz/sdk/b/k;
    //   305: iload #6
    //   307: aaload
    //   308: aastore
    //   309: iinc #6, 1
    //   312: goto -> 289
    //   315: aload_0
    //   316: getstatic com/zz/sdk/e/dl.D : Lcom/zz/sdk/e/dl;
    //   319: iconst_0
    //   320: invokevirtual a : (Lcom/zz/sdk/e/f;I)V
    //   323: invokestatic getPayAutoStart : ()Z
    //   326: ifeq -> 774
    //   329: iload_3
    //   330: iflt -> 774
    //   333: aload_0
    //   334: invokespecial B : ()Z
    //   337: ifne -> 774
    //   340: iconst_0
    //   341: istore #6
    //   343: iload #6
    //   345: aload_0
    //   346: getfield M : [Lcom/zz/sdk/b/k;
    //   349: arraylength
    //   350: if_icmpge -> 774
    //   353: aload_0
    //   354: getfield M : [Lcom/zz/sdk/b/k;
    //   357: iload #6
    //   359: aaload
    //   360: getfield B : I
    //   363: iload_3
    //   364: if_icmpne -> 504
    //   367: aload_0
    //   368: getfield x : Lcom/zz/sdk/e/cm;
    //   371: ifnonnull -> 510
    //   374: aload_0
    //   375: new com/zz/sdk/e/cm
    //   378: dup
    //   379: aload_0
    //   380: getfield f : Landroid/content/Context;
    //   383: aload_1
    //   384: aload_0
    //   385: getfield K : I
    //   388: invokespecial <init> : (Landroid/content/Context;[Lcom/zz/sdk/b/k;I)V
    //   391: putfield x : Lcom/zz/sdk/e/cm;
    //   394: aload_0
    //   395: getstatic com/zz/sdk/e/dl.d : Lcom/zz/sdk/e/dl;
    //   398: invokevirtual a : ()I
    //   401: invokevirtual findViewById : (I)Landroid/view/View;
    //   404: astore_1
    //   405: aload_1
    //   406: instanceof android/widget/GridView
    //   409: ifeq -> 423
    //   412: aload_1
    //   413: checkcast android/widget/GridView
    //   416: aload_0
    //   417: getfield x : Lcom/zz/sdk/e/cm;
    //   420: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   423: aload_0
    //   424: iload #6
    //   426: invokespecial d : (I)V
    //   429: iload #6
    //   431: iflt -> 521
    //   434: aload_0
    //   435: getfield J : Landroid/os/Handler;
    //   438: new com/zz/sdk/e/dh
    //   441: dup
    //   442: aload_0
    //   443: iload #6
    //   445: invokespecial <init> : (Lcom/zz/sdk/e/cr;I)V
    //   448: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   451: pop
    //   452: return
    //   453: aload_0
    //   454: getfield M : [Lcom/zz/sdk/b/k;
    //   457: arraylength
    //   458: anewarray com/zz/sdk/b/k
    //   461: astore_1
    //   462: iconst_0
    //   463: istore #6
    //   465: iload #6
    //   467: aload_0
    //   468: getfield M : [Lcom/zz/sdk/b/k;
    //   471: arraylength
    //   472: if_icmpge -> 492
    //   475: aload_1
    //   476: iload #6
    //   478: aload_0
    //   479: getfield M : [Lcom/zz/sdk/b/k;
    //   482: iload #6
    //   484: aaload
    //   485: aastore
    //   486: iinc #6, 1
    //   489: goto -> 465
    //   492: aload_0
    //   493: getstatic com/zz/sdk/e/dl.D : Lcom/zz/sdk/e/dl;
    //   496: bipush #8
    //   498: invokevirtual a : (Lcom/zz/sdk/e/f;I)V
    //   501: goto -> 323
    //   504: iinc #6, 1
    //   507: goto -> 343
    //   510: aload_0
    //   511: getfield x : Lcom/zz/sdk/e/cm;
    //   514: aload_1
    //   515: invokevirtual a : ([Lcom/zz/sdk/b/k;)V
    //   518: goto -> 423
    //   521: aload_0
    //   522: getfield f : Landroid/content/Context;
    //   525: ldc 'last_channel'
    //   527: iconst_m1
    //   528: invokestatic b : (Landroid/content/Context;Ljava/lang/String;I)I
    //   531: istore #5
    //   533: iload #5
    //   535: iconst_m1
    //   536: if_icmpeq -> 452
    //   539: iconst_0
    //   540: istore #6
    //   542: iload_2
    //   543: istore_3
    //   544: iload #6
    //   546: aload_0
    //   547: getfield M : [Lcom/zz/sdk/b/k;
    //   550: arraylength
    //   551: if_icmpge -> 572
    //   554: aload_0
    //   555: getfield M : [Lcom/zz/sdk/b/k;
    //   558: iload #6
    //   560: aaload
    //   561: getfield B : I
    //   564: iload #5
    //   566: if_icmpne -> 620
    //   569: iload #6
    //   571: istore_3
    //   572: iload_3
    //   573: iflt -> 452
    //   576: new java/util/ArrayList
    //   579: dup
    //   580: invokespecial <init> : ()V
    //   583: astore_1
    //   584: aload_1
    //   585: aload_0
    //   586: getfield M : [Lcom/zz/sdk/b/k;
    //   589: iload_3
    //   590: aaload
    //   591: invokevirtual add : (Ljava/lang/Object;)Z
    //   594: pop
    //   595: iconst_0
    //   596: istore #6
    //   598: iload #6
    //   600: aload_0
    //   601: getfield M : [Lcom/zz/sdk/b/k;
    //   604: arraylength
    //   605: if_icmpge -> 641
    //   608: iload #6
    //   610: iload_3
    //   611: if_icmpne -> 626
    //   614: iinc #6, 1
    //   617: goto -> 598
    //   620: iinc #6, 1
    //   623: goto -> 542
    //   626: aload_1
    //   627: aload_0
    //   628: getfield M : [Lcom/zz/sdk/b/k;
    //   631: iload #6
    //   633: aaload
    //   634: invokevirtual add : (Ljava/lang/Object;)Z
    //   637: pop
    //   638: goto -> 614
    //   641: aload_0
    //   642: aload_1
    //   643: invokevirtual size : ()I
    //   646: anewarray com/zz/sdk/b/k
    //   649: putfield M : [Lcom/zz/sdk/b/k;
    //   652: aload_0
    //   653: aload_1
    //   654: aload_0
    //   655: getfield M : [Lcom/zz/sdk/b/k;
    //   658: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   661: checkcast [Lcom/zz/sdk/b/k;
    //   664: putfield M : [Lcom/zz/sdk/b/k;
    //   667: aload_0
    //   668: getfield M : [Lcom/zz/sdk/b/k;
    //   671: arraylength
    //   672: aload_0
    //   673: getfield L : I
    //   676: if_icmple -> 732
    //   679: aload_0
    //   680: getfield L : I
    //   683: anewarray com/zz/sdk/b/k
    //   686: astore_1
    //   687: iconst_0
    //   688: istore #6
    //   690: iload #6
    //   692: aload_0
    //   693: getfield L : I
    //   696: if_icmpge -> 716
    //   699: aload_1
    //   700: iload #6
    //   702: aload_0
    //   703: getfield M : [Lcom/zz/sdk/b/k;
    //   706: iload #6
    //   708: aaload
    //   709: aastore
    //   710: iinc #6, 1
    //   713: goto -> 690
    //   716: aload_0
    //   717: getfield x : Lcom/zz/sdk/e/cm;
    //   720: aload_1
    //   721: invokevirtual a : ([Lcom/zz/sdk/b/k;)V
    //   724: aload_0
    //   725: iconst_0
    //   726: invokespecial d : (I)V
    //   729: goto -> 452
    //   732: aload_0
    //   733: getfield M : [Lcom/zz/sdk/b/k;
    //   736: arraylength
    //   737: anewarray com/zz/sdk/b/k
    //   740: astore_1
    //   741: iconst_0
    //   742: istore #6
    //   744: iload #6
    //   746: aload_0
    //   747: getfield M : [Lcom/zz/sdk/b/k;
    //   750: arraylength
    //   751: if_icmpge -> 771
    //   754: aload_1
    //   755: iload #6
    //   757: aload_0
    //   758: getfield M : [Lcom/zz/sdk/b/k;
    //   761: iload #6
    //   763: aaload
    //   764: aastore
    //   765: iinc #6, 1
    //   768: goto -> 744
    //   771: goto -> 716
    //   774: iconst_m1
    //   775: istore #6
    //   777: goto -> 367
  }
  
  private void z() {
    db db = new db(this);
    o o = b(this.f, getEnv());
    setCurrentTask(dp.a(getConnectionUtil(), db, this, o));
  }
  
  public Object a(ds paramds) {
    // Byte code:
    //   0: getstatic com/zz/sdk/e/da.a : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 44, 1 -> 48, 2 -> 48, 3 -> 158, 4 -> 169, 5 -> 184
    //   44: aconst_null
    //   45: astore_1
    //   46: aload_1
    //   47: areturn
    //   48: dconst_0
    //   49: dstore_2
    //   50: aload_0
    //   51: getstatic com/zz/sdk/e/dl.f : Lcom/zz/sdk/e/dl;
    //   54: invokevirtual a : (Lcom/zz/sdk/e/f;)Ljava/lang/String;
    //   57: astore #4
    //   59: dload_2
    //   60: dstore #5
    //   62: aload #4
    //   64: ifnull -> 149
    //   67: dload_2
    //   68: dstore #5
    //   70: aload #4
    //   72: invokevirtual length : ()I
    //   75: ifle -> 149
    //   78: aload #4
    //   80: invokestatic parseDouble : (Ljava/lang/String;)D
    //   83: dstore #5
    //   85: dload #5
    //   87: dstore #7
    //   89: dload #5
    //   91: dstore_2
    //   92: aload_0
    //   93: invokespecial B : ()Z
    //   96: ifeq -> 124
    //   99: dload #5
    //   101: dstore #7
    //   103: dload #5
    //   105: dstore_2
    //   106: aload_0
    //   107: invokespecial C : ()Z
    //   110: ifne -> 124
    //   113: dload #5
    //   115: dstore_2
    //   116: aload_0
    //   117: dload #5
    //   119: invokespecial b : (D)D
    //   122: dstore #7
    //   124: dload #7
    //   126: dstore #5
    //   128: dload #7
    //   130: dstore_2
    //   131: aload_1
    //   132: getstatic com/zz/sdk/e/ds.b : Lcom/zz/sdk/e/ds;
    //   135: if_acmpne -> 149
    //   138: dload #7
    //   140: dstore_2
    //   141: aload_0
    //   142: dload #7
    //   144: invokespecial c : (D)D
    //   147: dstore #5
    //   149: dload #5
    //   151: invokestatic valueOf : (D)Ljava/lang/Double;
    //   154: astore_1
    //   155: goto -> 46
    //   158: aload_0
    //   159: getfield t : I
    //   162: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   165: astore_1
    //   166: goto -> 46
    //   169: aload_0
    //   170: getstatic com/zz/sdk/e/dl.n : Lcom/zz/sdk/e/dl;
    //   173: getstatic com/zz/sdk/e/dl.o : Lcom/zz/sdk/e/dl;
    //   176: iconst_1
    //   177: invokevirtual a : (Lcom/zz/sdk/e/f;Lcom/zz/sdk/e/f;I)Ljava/lang/String;
    //   180: astore_1
    //   181: goto -> 46
    //   184: aload_0
    //   185: getstatic com/zz/sdk/e/dl.n : Lcom/zz/sdk/e/dl;
    //   188: getstatic com/zz/sdk/e/dl.p : Lcom/zz/sdk/e/dl;
    //   191: iconst_1
    //   192: invokevirtual a : (Lcom/zz/sdk/e/f;Lcom/zz/sdk/e/f;I)Ljava/lang/String;
    //   195: astore_1
    //   196: goto -> 46
    //   199: astore_1
    //   200: dload_2
    //   201: dstore #5
    //   203: goto -> 149
    // Exception table:
    //   from	to	target	type
    //   78	85	199	java/lang/NumberFormatException
    //   92	99	199	java/lang/NumberFormatException
    //   106	113	199	java/lang/NumberFormatException
    //   116	124	199	java/lang/NumberFormatException
    //   131	138	199	java/lang/NumberFormatException
    //   141	149	199	java/lang/NumberFormatException
  }
  
  protected void a(double paramDouble) {
    super.a(paramDouble);
    a(dl.F, String.valueOf(paramDouble));
    F();
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    dk dk1;
    cg cg;
    int i;
    boolean bool1;
    double d;
    super.a(paramContext, paramParamChain);
    this.t = -1;
    this.u = -1;
    this.w = new DecimalFormat(cg.a.a());
    this.E = (String)paramParamChain.get("global.device.imsi", String.class);
    if (this.E != null && !cv.l(this.f))
      this.E = null; 
    Double double_ = (Double)paramParamChain.get("global.user.coin_rate", Double.class);
    if (double_ != null) {
      this.C = double_.doubleValue();
    } else {
      this.C = 1.0D;
    } 
    Integer integer = (Integer)paramParamChain.get("global.caller.amount", Integer.class);
    if (integer == null) {
      i = 0;
    } else {
      i = integer.intValue();
    } 
    this.y = i;
    Boolean bool = (Boolean)paramParamChain.get("global.caller.coin_count", Boolean.class);
    if (bool != null && bool.booleanValue()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.z = bool1;
    bool = (Boolean)paramParamChain.get("global.caller.payment_zycoin_disabled", Boolean.class);
    if (bool != null && bool.booleanValue()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.v = bool1;
    bool = (Boolean)paramParamChain.get("global.caller.pay_is_buy_mode", Boolean.class);
    if (bool != null && bool.booleanValue()) {
      dk1 = dk.d;
    } else {
      dk1 = dk.c;
    } 
    this.D = dk1;
    this.A = (String)paramParamChain.get("global.caller.prop_id", String.class);
    this.B = (String)paramParamChain.get("global.caller.prop_name", String.class);
    if (C()) {
      cg = cg.w;
    } else {
      cg = cg.x;
    } 
    paramParamChain.add("global.paymentlist.pay_title", cg, h.b);
    if (this.B == null && !B()) {
      if (C()) {
        if (this.z) {
          d = this.y;
        } else {
          d = b(this.y);
        } 
        this.B = String.format(cg.D.a(), new Object[] { this.w.format(d / 100.0D), getCoinName() });
        return;
      } 
    } else {
      return;
    } 
    if (this.z) {
      d = c(this.y);
    } else {
      d = this.y;
    } 
    this.B = String.format(cg.E.a(), new Object[] { this.w.format(d / 100.0D) });
  }
  
  protected void a(Double paramDouble) {
    double d;
    if (paramDouble == null) {
      d = 0.0D;
    } else {
      d = paramDouble.doubleValue();
    } 
    super.a(Double.valueOf(d));
  }
  
  public boolean a() {
    boolean bool = super.a();
    View view = e();
    if (view == null || view.getVisibility() != 0)
      getHost().a(getClass().getClassLoader(), ce.class.getName(), getEnv()); 
    return bool;
  }
  
  protected void b(Context paramContext) {
    d(paramContext);
    getHeaderContainer().setVisibility(8);
    FrameLayout frameLayout = getSubjectContainer();
    LinearLayout linearLayout = new LinearLayout(paramContext);
    frameLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2, 17));
    linearLayout.setId(dl.a.a());
    linearLayout.setVisibility(0);
    linearLayout.setOrientation(1);
    ProgressBar progressBar = new ProgressBar(paramContext);
    progressBar.setIndeterminate(true);
    progressBar.setId(dl.s.a());
    LinearLayout.LayoutParams layoutParams = a(2);
    layoutParams.gravity = 1;
    linearLayout.addView((View)progressBar, (ViewGroup.LayoutParams)layoutParams);
    TextView textView2 = a(paramContext, cg.aY);
    textView2.setGravity(17);
    linearLayout.addView((View)textView2, (ViewGroup.LayoutParams)a(3));
    textView2.setTextColor(ce.h.a());
    linearLayout = new LinearLayout(paramContext);
    linearLayout.setId(dl.b.a());
    linearLayout.setVisibility(8);
    linearLayout.setOrientation(1);
    linearLayout.setVerticalScrollBarEnabled(false);
    frameLayout.addView((View)linearLayout, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    linearLayout.addView(e(paramContext));
    TextView textView1 = c(paramContext, cg.bs);
    textView1.setVisibility(8);
    textView1.setId(dl.c.a());
    frameLayout.addView((View)textView1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    textView1.setTextColor(ce.l.a());
    textView1.setTextSize(18.0F);
    textView1.setGravity(17);
    setTileTypeText(cv.s(this.f));
    a(e.e, 0);
    a(this.D);
    D();
    F();
    d(-1);
  }
  
  public boolean c(boolean paramBoolean) {
    if (!paramBoolean || !f())
      bv.a((Activity)this.f, hu.class, (Map)bv.a().a("payLayout", this)); 
    return false;
  }
  
  public void d(boolean paramBoolean) {
    byte b2;
    byte b1 = 8;
    View view = findViewById(dl.a.a());
    if (view != null && view.getVisibility() == 0) {
      view.setVisibility(8);
      if (view instanceof ViewGroup)
        ((ViewGroup)view).removeAllViews(); 
    } 
    dl dl = dl.l;
    if (paramBoolean) {
      b2 = 0;
    } else {
      b2 = 8;
    } 
    a(dl, b2);
    dl = dl.b;
    if (paramBoolean) {
      b2 = 0;
    } else {
      b2 = 8;
    } 
    a(dl, b2);
    dl = dl.c;
    if (paramBoolean) {
      b2 = b1;
    } else {
      b2 = 0;
    } 
    a(dl, b2);
  }
  
  public void e(boolean paramBoolean) {
    a(paramBoolean);
  }
  
  public boolean j() {
    t.a(this.f).b("Pay_platform", "start_pay", 1);
    boolean bool = super.j();
    if (bool) {
      y();
      if (A())
        z(); 
    } 
    return bool;
  }
  
  public boolean l() {
    boolean bool = super.l();
    if (bool) {
      set_child_focuse(dl.d);
      ParamChain paramChain = getEnv();
      Object object = paramChain.remove("global.paymentlist.pay_result");
      if (object != null && object instanceof Integer) {
        int i = ((Integer)object).intValue();
        a(paramChain, i);
        b(paramChain, i);
      } 
    } 
    return bool;
  }
  
  protected void m() {
    a(1, 3, (Object)null);
    super.m();
  }
  
  public boolean n() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial n : ()Z
    //   4: istore_1
    //   5: iload_1
    //   6: ifeq -> 9
    //   9: aload_0
    //   10: getfield p : [Ljava/lang/Double;
    //   13: ifnull -> 21
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield p : [Ljava/lang/Double;
    //   21: aload_0
    //   22: getfield q : Lcom/zz/sdk/e/ft;
    //   25: ifnull -> 33
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield q : Lcom/zz/sdk/e/ft;
    //   33: iload_1
    //   34: ireturn
  }
  
  public void onClick(View paramView) {
    byte b = 0;
    if (paramView instanceof CheckedTextView && paramView.isEnabled())
      ((CheckedTextView)paramView).toggle(); 
    dl dl = dl.a(paramView.getId());
    switch (da.b[dl.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        F();
        return;
      case 2:
        t.a(this.f).b("Pay_platform", "pay", 1);
        if (this.x != null) {
          object = this.x.getItem(this.t);
          if (object instanceof k) {
            object = object;
          } else {
            break;
          } 
        } else {
          break;
        } 
        if (object != null)
          this.J.postDelayed(new cy(this, (k)object), 600L); 
        I();
        return;
      case 3:
      case 4:
        a(new double[] { 1.0D, 10.0D, 50.0D, 100.0D, 300.0D, 500.0D });
        return;
      case 5:
        if (this.x != null) {
          object = findViewById(dl.E.a());
          if (this.x.getCount() > this.L) {
            object.setText("更多支付方式");
            Drawable drawable1 = ca.dg.a(this.f);
            drawable1.setBounds(0, 0, drawable1.getIntrinsicWidth(), drawable1.getIntrinsicHeight());
            object.setCompoundDrawables(null, null, drawable1, null);
            object = new k[this.L];
            for (b = 0; b < this.L; b++)
              object[b] = this.M[b]; 
            this.x.a((k[])object);
            if (this.t >= this.L) {
              this.H = 0;
              d(0);
            } 
            return;
          } 
          object.setText("收起支付方式");
          Drawable drawable = ca.dh.a(this.f);
          drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
          object.setCompoundDrawables(null, null, drawable, null);
          object = new k[this.M.length];
          while (b < this.M.length) {
            object[b] = this.M[b];
            b++;
          } 
          this.x.a((k[])object);
        } 
        return;
    } 
    Object object = null;
    if (object != null)
      this.J.postDelayed(new cy(this, (k)object), 600L); 
    I();
  }
  
  protected void y() {
    a(-1L, (String)null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */