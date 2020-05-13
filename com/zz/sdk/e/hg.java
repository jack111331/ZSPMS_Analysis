package com.zz.sdk.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zz.sdk.ParamChain;
import com.zz.sdk.a.bs;
import com.zz.sdk.a.lj;
import com.zz.sdk.b.a.a;
import com.zz.sdk.b.a.af;
import com.zz.sdk.b.a.al;
import com.zz.sdk.b.a.am;
import com.zz.sdk.b.k;
import com.zz.sdk.b.o;
import com.zz.sdk.g;
import com.zz.sdk.h;
import com.zz.sdk.i.bp;
import com.zz.sdk.i.ca;
import com.zz.sdk.i.cc;
import com.zz.sdk.i.cd;
import com.zz.sdk.i.ce;
import com.zz.sdk.i.cf;
import com.zz.sdk.i.cg;
import com.zz.sdk.i.cv;
import com.zz.sdk.i.df;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;

public class hg extends k {
  private static final int v = 65536;
  
  private boolean A;
  
  private String B;
  
  private LinearLayout C;
  
  private lj D;
  
  private ListView E;
  
  private Handler F = new hh(this);
  
  private int p = 0;
  
  private String q;
  
  private String r;
  
  private boolean s;
  
  private int t;
  
  private DecimalFormat u;
  
  private co w;
  
  private double x;
  
  private dk y;
  
  private int z;
  
  public hg(Context paramContext, ParamChain paramParamChain) {
    super(paramContext, paramParamChain.grow(cr.class.getName()));
    b(paramContext);
    Drawable drawable = cv.r(paramContext);
    if (drawable == null) {
      setBackgroundColor(0);
      return;
    } 
    setBackgroundDrawable(drawable);
  }
  
  private boolean A() {
    return (this.y == dk.c);
  }
  
  private boolean B() {
    return (this.z <= 0);
  }
  
  private void C() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getHost : ()Lcom/zz/sdk/e/bf;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield w : Lcom/zz/sdk/e/co;
    //   14: ifnull -> 87
    //   17: aload_0
    //   18: getfield w : Lcom/zz/sdk/e/co;
    //   21: aload_0
    //   22: getfield E : Landroid/widget/ListView;
    //   25: invokevirtual getCheckedItemPosition : ()I
    //   28: invokevirtual b : (I)Lcom/zz/sdk/b/k;
    //   31: astore_2
    //   32: aload_2
    //   33: instanceof com/zz/sdk/b/k
    //   36: ifeq -> 87
    //   39: aload_2
    //   40: checkcast com/zz/sdk/b/k
    //   43: astore_2
    //   44: aload_2
    //   45: ifnonnull -> 58
    //   48: aload_0
    //   49: getstatic com/zz/sdk/i/cg.bt : Lcom/zz/sdk/i/cg;
    //   52: invokevirtual b : (Lcom/zz/sdk/i/cg;)V
    //   55: goto -> 9
    //   58: aload_0
    //   59: aload_1
    //   60: aload_2
    //   61: invokespecial a : (Lcom/zz/sdk/e/bf;Lcom/zz/sdk/b/k;)Ljava/lang/String;
    //   64: astore_3
    //   65: aload_3
    //   66: ifnull -> 77
    //   69: aload_0
    //   70: aload_3
    //   71: invokevirtual b : (Ljava/lang/String;)V
    //   74: goto -> 9
    //   77: aload_0
    //   78: aload_1
    //   79: aload_2
    //   80: invokespecial c : (Lcom/zz/sdk/e/bf;Lcom/zz/sdk/b/k;)Z
    //   83: pop
    //   84: goto -> 9
    //   87: aconst_null
    //   88: astore_2
    //   89: goto -> 44
  }
  
  private void D() {
    hl hl = new hl(this);
    o o = b(this.f, getEnv());
    setCurrentTask(hx.a(getConnectionUtil(), hl, this, o));
  }
  
  private boolean E() {
    Boolean bool = (Boolean)getEnv().get("global.user.login_state_success", Boolean.class);
    if (bool != null && bool.booleanValue())
      return true; 
    bp.a("D: auto login in background...");
    hm hm = new hm(this);
    ParamChain paramChain = getEnv().getParent(g.class.getName());
    setCurrentTask(hw.a(this.f, hm, this, paramChain, false));
    return false;
  }
  
  private void F() {
    if (!B()) {
      double d1;
      if (this.A) {
        d1 = this.z;
      } else {
        d1 = b(this.z);
      } 
      double d2 = d1;
      if (B())
        d2 = c(d1); 
      String str = this.u.format(d2 / 100.0D);
      b(hv.j, str);
    } 
  }
  
  private void G() {
    double d;
    Object object = a(ds.b);
    if (object instanceof Double) {
      d = ((Double)object).doubleValue();
    } else {
      d = 0.0D;
    } 
    e(d);
  }
  
  private String H() {
    return "0";
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
    double d;
    null = getEnv();
    if (paramk.B == 7) {
      d = ((Double)a(ds.a)).doubleValue();
    } else {
      d = ((Double)a(ds.b)).doubleValue();
    } 
    if (!d(d)) {
      set_child_focuse(hv.j);
      return cg.S.a();
    } 
    if ((this.t == 6 || this.t == 3 || this.t == 4) && d > 500.0D)
      return cg.T.a(); 
    null.add("global.paymentlist.pay_amount", Double.valueOf(d), h.b);
    null.add("global.paymentlist.pay_amount_defect", Double.valueOf(d), h.b);
    null.add("global.paymentlist.pay_channel_type", Integer.valueOf(paramk.B), h.b);
    null.add("global.paymentlist.pay_channel_name", paramk.x, h.b);
    null.add("global.paymentlist.pay_state_is_recharge", Boolean.valueOf(A()), h.b);
    null.add("global.paymentlist.pay_state_way", H(), h.b);
    switch (paramk.B) {
      default:
        return "暂不支持";
      case 0:
      case 2:
      case 9:
      case 10:
      case 15:
        return null;
      case 1:
      case 100:
        return null;
      case 3:
      case 4:
      case 6:
      case 78:
      case 79:
        return null;
      case 7:
        return (d > getCoinBalance()) ? String.format(cg.bk.a(), new Object[] { getCoinName() }) : null;
      case 5:
        break;
    } 
    return null;
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private void a(ParamChain paramParamChain, int paramInt) {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iload_2
    //   3: tableswitch default -> 24, 0 -> 320, 1 -> 326
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
    //   53: ifeq -> 332
    //   56: aload #6
    //   58: checkcast java/lang/Double
    //   61: astore #6
    //   63: aload #6
    //   65: ifnonnull -> 351
    //   68: aconst_null
    //   69: astore #6
    //   71: aload #5
    //   73: aload #6
    //   75: putfield amount : Ljava/lang/String;
    //   78: aload #5
    //   80: aload_1
    //   81: ldc_w 'global.paymentlist.pay_order_number'
    //   84: ldc java/lang/String
    //   86: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   91: checkcast java/lang/String
    //   94: putfield gameOrderNumber : Ljava/lang/String;
    //   97: aload #5
    //   99: iload #4
    //   101: putfield statusCode : I
    //   104: aload_1
    //   105: ldc_w 'global.paymentlist.pay_channel_type'
    //   108: ldc_w java/lang/Integer
    //   111: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   116: checkcast java/lang/Integer
    //   119: astore #6
    //   121: aload #6
    //   123: ifnonnull -> 364
    //   126: iload_3
    //   127: istore #4
    //   129: aload #5
    //   131: iload #4
    //   133: putfield payWayType : I
    //   136: aload #5
    //   138: aload_1
    //   139: ldc_w 'global.paymentlist.pay_channel_name'
    //   142: ldc java/lang/String
    //   144: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   149: checkcast java/lang/String
    //   152: putfield payWayName : Ljava/lang/String;
    //   155: aload #5
    //   157: ldc_w 'RMB'
    //   160: putfield currency : Ljava/lang/String;
    //   163: aload_0
    //   164: iconst_1
    //   165: iload_2
    //   166: aload #5
    //   168: invokevirtual a : (IILjava/lang/Object;)Z
    //   171: pop
    //   172: aload #5
    //   174: getfield gameOrderNumber : Ljava/lang/String;
    //   177: ifnull -> 319
    //   180: new com/zz/sdk/b/m
    //   183: dup
    //   184: invokespecial <init> : ()V
    //   187: astore #6
    //   189: aload #6
    //   191: aload_1
    //   192: ldc 'global.user.login_name'
    //   194: ldc java/lang/String
    //   196: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   201: checkcast java/lang/String
    //   204: invokevirtual c : (Ljava/lang/String;)V
    //   207: aload #6
    //   209: aload #5
    //   211: getfield gameOrderNumber : Ljava/lang/String;
    //   214: invokevirtual d : (Ljava/lang/String;)V
    //   217: aload #6
    //   219: aload #5
    //   221: getfield amount : Ljava/lang/String;
    //   224: invokevirtual a : (Ljava/lang/String;)V
    //   227: aload #6
    //   229: new java/text/SimpleDateFormat
    //   232: dup
    //   233: ldc_w 'yyyy-MM-dd HH:mm:ss'
    //   236: invokespecial <init> : (Ljava/lang/String;)V
    //   239: new java/util/Date
    //   242: dup
    //   243: invokestatic currentTimeMillis : ()J
    //   246: invokespecial <init> : (J)V
    //   249: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   252: invokevirtual e : (Ljava/lang/String;)V
    //   255: aload #6
    //   257: new java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial <init> : ()V
    //   264: aload #5
    //   266: getfield payWayType : I
    //   269: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   272: ldc_w ''
    //   275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual toString : ()Ljava/lang/String;
    //   281: invokevirtual f : (Ljava/lang/String;)V
    //   284: aload #6
    //   286: ldc_w ''
    //   289: invokevirtual g : (Ljava/lang/String;)V
    //   292: aload #6
    //   294: aload #5
    //   296: getfield amount : Ljava/lang/String;
    //   299: invokevirtual b : (Ljava/lang/String;)V
    //   302: new com/zz/sdk/b/n
    //   305: dup
    //   306: aload_0
    //   307: getfield f : Landroid/content/Context;
    //   310: invokespecial <init> : (Landroid/content/Context;)V
    //   313: aload #6
    //   315: invokevirtual a : (Lcom/zz/sdk/b/m;)Z
    //   318: pop
    //   319: return
    //   320: iconst_0
    //   321: istore #4
    //   323: goto -> 28
    //   326: iconst_m1
    //   327: istore #4
    //   329: goto -> 28
    //   332: aload_1
    //   333: ldc_w 'global.paymentlist.pay_amount'
    //   336: ldc java/lang/Double
    //   338: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   343: checkcast java/lang/Double
    //   346: astore #6
    //   348: goto -> 63
    //   351: aload #6
    //   353: invokevirtual doubleValue : ()D
    //   356: invokestatic a : (D)Ljava/lang/String;
    //   359: astore #6
    //   361: goto -> 71
    //   364: aload #6
    //   366: invokevirtual intValue : ()I
    //   369: istore #4
    //   371: goto -> 129
  }
  
  private void a(a parama) {
    if (parama != null && parama.c()) {
      D();
      return;
    } 
    bp.a("D: login failed(2)!");
    d(false);
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
    (new Thread(new ht(this, str2 + "&sign=\"" + str1 + "\""))).start();
    return true;
  }
  
  private boolean a(bf parambf, k paramk, a parama) {
    boolean bool = false;
    if (parama == null || !parama.e()) {
      a(cg.al);
      return bool;
    } 
    if (parambf != null && paramk != null && parama instanceof al && parama.c()) {
      g();
      return a(parambf, paramk, (al)parama);
    } 
    if (parama.i != null) {
      a(parama.i);
      return bool;
    } 
    if (paramk != null && paramk.B == 5) {
      a(cg.az);
      return bool;
    } 
    a(cg.ao);
    return bool;
  }
  
  private boolean a(bf parambf, k paramk, al paramal) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getEnv : ()Lcom/zz/sdk/ParamChain;
    //   4: astore #4
    //   6: aconst_null
    //   7: astore #5
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: ldc_w '订单号------>'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_3
    //   23: getfield n : Ljava/lang/String;
    //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual toString : ()Ljava/lang/String;
    //   32: invokestatic a : (Ljava/lang/Object;)V
    //   35: aload_3
    //   36: invokevirtual c : ()Z
    //   39: ifne -> 56
    //   42: aload_0
    //   43: aload_3
    //   44: invokevirtual f : ()Ljava/lang/String;
    //   47: invokevirtual b : (Ljava/lang/String;)V
    //   50: iconst_0
    //   51: istore #6
    //   53: iload #6
    //   55: ireturn
    //   56: aload #4
    //   58: ldc_w 'global.paymentlist.pay_order_number'
    //   61: aload_3
    //   62: getfield n : Ljava/lang/String;
    //   65: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   68: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   73: pop
    //   74: aload_2
    //   75: getfield B : I
    //   78: lookupswitch default -> 200, 0 -> 283, 1 -> 345, 2 -> 291, 3 -> 374, 4 -> 374, 5 -> 400, 6 -> 374, 7 -> 382, 9 -> 291, 10 -> 291, 15 -> 452, 78 -> 374, 79 -> 374, 100 -> 345
    //   200: aload #5
    //   202: ifnull -> 256
    //   205: aload #4
    //   207: astore_3
    //   208: aload_2
    //   209: getfield z : Ljava/lang/String;
    //   212: ifnull -> 237
    //   215: aload #4
    //   217: invokeinterface grow : ()Lcom/zz/sdk/ParamChain;
    //   222: astore_3
    //   223: aload_3
    //   224: ldc_w 'global.help_topic'
    //   227: aload_2
    //   228: getfield z : Ljava/lang/String;
    //   231: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   236: pop
    //   237: aload_1
    //   238: aload_0
    //   239: invokevirtual getClass : ()Ljava/lang/Class;
    //   242: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   245: aload #5
    //   247: invokevirtual getName : ()Ljava/lang/String;
    //   250: aload_3
    //   251: invokeinterface a : (Ljava/lang/ClassLoader;Ljava/lang/String;Lcom/zz/sdk/ParamChain;)V
    //   256: aload_0
    //   257: getfield D : Lcom/zz/sdk/a/lj;
    //   260: invokevirtual hide : ()V
    //   263: aload_0
    //   264: getstatic com/zz/sdk/i/cg.ar : Lcom/zz/sdk/i/cg;
    //   267: invokevirtual a : ()Ljava/lang/String;
    //   270: aload_0
    //   271: getfield n : Lcom/zz/sdk/e/h;
    //   274: invokevirtual a : (Ljava/lang/CharSequence;Lcom/zz/sdk/e/h;)V
    //   277: iconst_0
    //   278: istore #6
    //   280: goto -> 53
    //   283: aload_0
    //   284: aload_3
    //   285: invokespecial a : (Lcom/zz/sdk/b/a/al;)Z
    //   288: ifne -> 200
    //   291: aload_3
    //   292: checkcast com/zz/sdk/b/a/am
    //   295: astore #5
    //   297: aload #5
    //   299: getfield t : Ljava/lang/String;
    //   302: astore_3
    //   303: aload #4
    //   305: ldc_w 'global.paymentlist.pay_online_url'
    //   308: aload #5
    //   310: getfield s : Ljava/lang/String;
    //   313: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   316: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   321: pop
    //   322: aload #4
    //   324: ldc_w 'global.paymentlist.pay_online_url_guard'
    //   327: aload_3
    //   328: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   331: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   336: pop
    //   337: ldc_w com/zz/sdk/e/du
    //   340: astore #5
    //   342: goto -> 200
    //   345: aload #4
    //   347: ldc_w 'global.paymentlist.pay_union_tn'
    //   350: aload_3
    //   351: checkcast com/zz/sdk/b/a/ar
    //   354: getfield p : Ljava/lang/String;
    //   357: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   360: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   365: pop
    //   366: ldc_w com/zz/sdk/e/fu
    //   369: astore #5
    //   371: goto -> 200
    //   374: ldc_w com/zz/sdk/e/go
    //   377: astore #5
    //   379: goto -> 200
    //   382: aload_0
    //   383: aload #4
    //   385: iconst_0
    //   386: invokespecial a : (Lcom/zz/sdk/ParamChain;I)V
    //   389: aload_0
    //   390: iconst_0
    //   391: invokespecial c : (I)V
    //   394: iconst_1
    //   395: istore #6
    //   397: goto -> 53
    //   400: ldc_w com/zz/sdk/e/eo
    //   403: astore #5
    //   405: aload_3
    //   406: checkcast com/zz/sdk/b/a/ap
    //   409: astore_3
    //   410: aload #4
    //   412: ldc_w 'global.paymentlist.pay_sms_confirm_enabled'
    //   415: aload_3
    //   416: getfield r : Z
    //   419: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   422: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   425: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   430: pop
    //   431: aload #4
    //   433: ldc_w 'global.paymentlist.pay_sms_channel_message'
    //   436: aload_3
    //   437: getfield q : [Lcom/zz/sdk/b/u;
    //   440: getstatic com/zz/sdk/h.b : Lcom/zz/sdk/h;
    //   443: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;Lcom/zz/sdk/h;)Z
    //   448: pop
    //   449: goto -> 200
    //   452: ldc_w com/zz/sdk/e/fz
    //   455: astore #5
    //   457: aload #4
    //   459: ldc_w 'global.paymentlist.pay_args'
    //   462: aload_3
    //   463: invokeinterface add : (Ljava/lang/String;Ljava/lang/Object;)Z
    //   468: pop
    //   469: goto -> 200
  }
  
  private double b(double paramDouble) {
    return this.x * paramDouble;
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
  
  private String b(f paramf) {
    null = this.C.findViewById(paramf.a());
    if (null instanceof TextView) {
      CharSequence charSequence = ((TextView)null).getText();
      if (charSequence != null)
        return charSequence.toString().trim(); 
    } 
    return null;
  }
  
  private void b(int paramInt) {
    if (paramInt == hv.j.a())
      G(); 
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
          c(hv.z, 0);
          b(hv.A, (CharSequence)Html.fromHtml(af.v));
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
  
  private void b(f paramf, cg paramcg) {
    if (this.C != null) {
      View view = this.C.findViewById(paramf.a());
      if (view != null && view instanceof TextView)
        ((TextView)view).setText(paramcg.a()); 
    } 
  }
  
  private void b(f paramf, CharSequence paramCharSequence) {
    if (this.C != null) {
      View view = this.C.findViewById(paramf.a());
      if (view != null && view instanceof TextView)
        ((TextView)view).setText(paramCharSequence); 
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
    return paramDouble / this.x;
  }
  
  private void c(int paramInt) {
    cg cg;
    switch (paramInt) {
      default:
        cg = null;
        if (this.D != null)
          this.D.show(); 
        if (cg != null) {
          o();
          postDelayed(new hr(this), 1000L);
          a((Double)null);
          y();
          return;
        } 
        break;
      case 0:
        c(hv.d, 0);
        c(hv.x, 0);
        c(hv.c, 8);
        if (A()) {
          cg = cg.at;
        } else {
          cg = cg.as;
        } 
        b(hv.x, cg);
        if (this.D != null)
          this.D.show(); 
        if (cg != null) {
          o();
          postDelayed(new hr(this), 1000L);
          a((Double)null);
          y();
          return;
        } 
        break;
      case 1:
        c(hv.c, 8);
        c(hv.d, 0);
        c(hv.y, 0);
        cg = cg.av;
        b(hv.y, cg);
        if (this.D != null)
          this.D.show(); 
        if (cg != null) {
          o();
          postDelayed(new hr(this), 1000L);
          a((Double)null);
          y();
          return;
        } 
        break;
      case 2:
        this.D.show();
    } 
    g();
  }
  
  private boolean c(bf parambf, k paramk) {
    // Byte code:
    //   0: aload_2
    //   1: getfield B : I
    //   4: istore_3
    //   5: iload_3
    //   6: lookupswitch default -> 128, 0 -> 141, 1 -> 236, 2 -> 184, 3 -> 187, 4 -> 187, 5 -> 239, 6 -> 187, 7 -> 242, 9 -> 245, 10 -> 248, 15 -> 251, 78 -> 187, 79 -> 187, 100 -> 236
    //   128: aload_0
    //   129: ldc_w '暂不支持'
    //   132: invokevirtual b : (Ljava/lang/String;)V
    //   135: iconst_0
    //   136: istore #4
    //   138: iload #4
    //   140: ireturn
    //   141: aload_0
    //   142: aload_0
    //   143: getfield f : Landroid/content/Context;
    //   146: aload_0
    //   147: invokevirtual getEnv : ()Lcom/zz/sdk/ParamChain;
    //   150: iload_3
    //   151: invokespecial a : (Landroid/content/Context;Lcom/zz/sdk/ParamChain;I)Lcom/zz/sdk/b/o;
    //   154: astore_1
    //   155: iload_3
    //   156: iconst_5
    //   157: if_icmpne -> 254
    //   160: aload_1
    //   161: ifnull -> 171
    //   164: aload_1
    //   165: getfield n : Ljava/lang/String;
    //   168: ifnonnull -> 254
    //   171: aload_0
    //   172: getstatic com/zz/sdk/i/cg.ay : Lcom/zz/sdk/i/cg;
    //   175: invokevirtual a : (Lcom/zz/sdk/i/cg;)V
    //   178: iconst_0
    //   179: istore #4
    //   181: goto -> 138
    //   184: goto -> 141
    //   187: aload_0
    //   188: invokevirtual getEnv : ()Lcom/zz/sdk/ParamChain;
    //   191: ldc_w 'global.paymentlist.pay_amount_defect'
    //   194: ldc java/lang/Double
    //   196: invokeinterface get : (Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   201: checkcast java/lang/Double
    //   204: astore_1
    //   205: aload_1
    //   206: ifnull -> 220
    //   209: aload_0
    //   210: aload_1
    //   211: invokevirtual doubleValue : ()D
    //   214: invokespecial d : (D)Z
    //   217: ifeq -> 141
    //   220: aload_0
    //   221: aload_0
    //   222: invokevirtual getHost : ()Lcom/zz/sdk/e/bf;
    //   225: aload_2
    //   226: invokespecial b : (Lcom/zz/sdk/e/bf;Lcom/zz/sdk/b/k;)Z
    //   229: pop
    //   230: iconst_1
    //   231: istore #4
    //   233: goto -> 138
    //   236: goto -> 141
    //   239: goto -> 141
    //   242: goto -> 141
    //   245: goto -> 141
    //   248: goto -> 141
    //   251: goto -> 141
    //   254: aload_0
    //   255: ldc2_w -1
    //   258: getstatic com/zz/sdk/i/cg.aj : Lcom/zz/sdk/i/cg;
    //   261: invokevirtual a : ()Ljava/lang/String;
    //   264: invokevirtual a : (JLjava/lang/String;)V
    //   267: aload_0
    //   268: getstatic com/zz/sdk/i/cg.aj : Lcom/zz/sdk/i/cg;
    //   271: invokevirtual a : ()Ljava/lang/String;
    //   274: new com/zz/sdk/e/hi
    //   277: dup
    //   278: aload_0
    //   279: invokespecial <init> : (Lcom/zz/sdk/e/hg;)V
    //   282: invokevirtual a : (Ljava/lang/CharSequence;Lcom/zz/sdk/e/h;)V
    //   285: new com/zz/sdk/e/hj
    //   288: dup
    //   289: aload_0
    //   290: invokespecial <init> : (Lcom/zz/sdk/e/hg;)V
    //   293: astore #5
    //   295: aload_0
    //   296: aload_0
    //   297: invokevirtual getConnectionUtil : ()Lcom/zz/sdk/i/t;
    //   300: aload #5
    //   302: aload_2
    //   303: aload_2
    //   304: getfield B : I
    //   307: aload_1
    //   308: invokestatic a : (Lcom/zz/sdk/i/t;Lcom/zz/sdk/e/g;Ljava/lang/Object;ILcom/zz/sdk/b/o;)Landroid/os/AsyncTask;
    //   311: invokevirtual setCurrentTask : (Landroid/os/AsyncTask;)V
    //   314: iconst_0
    //   315: istore #4
    //   317: goto -> 138
  }
  
  private View d(Context paramContext, LinearLayout paramLinearLayout) {
    paramLinearLayout = a(paramContext, paramLinearLayout);
    TextView textView = a(paramContext, (cg)null);
    textView.setId(hv.t.a());
    cf.g.a(textView);
    paramLinearLayout.addView((View)textView, (ViewGroup.LayoutParams)a(3));
    return (View)paramLinearLayout;
  }
  
  private void d(int paramInt) {
    k k1 = e(paramInt);
    if (k1 != null) {
      this.t = k1.B;
      f(this.t);
      if (this.w != null)
        this.w.a(paramInt); 
    } 
  }
  
  private boolean d(double paramDouble) {
    return (paramDouble >= 0.009D);
  }
  
  private View e(Context paramContext) {
    if (paramContext == null)
      return null; 
    this.C = new LinearLayout(paramContext);
    this.C.setOrientation(1);
    this.C.setBackgroundColor(ce.u.a());
    RelativeLayout relativeLayout = new RelativeLayout(paramContext);
    WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
    int i = windowManager.getDefaultDisplay().getHeight() / 10;
    int j = (int)(windowManager.getDefaultDisplay().getWidth() / 1.2D);
    this.C.addView((View)relativeLayout, j, i);
    relativeLayout.setBackgroundColor(ce.n.a());
    LinearLayout linearLayout3 = new LinearLayout(paramContext);
    linearLayout3.setOrientation(1);
    linearLayout3.setBackgroundDrawable(ca.aq.a(paramContext));
    linearLayout3.setId(hv.c.a());
    this.C.addView((View)linearLayout3);
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    linearLayout2.setOrientation(1);
    linearLayout2.setId(hv.d.a());
    linearLayout2.setBackgroundDrawable(ca.aq.a(paramContext));
    linearLayout2.setVisibility(8);
    this.C.addView((View)linearLayout2);
    TextView textView2 = a(paramContext, cg.aZ);
    textView2.setGravity(17);
    textView2.setId(hv.a.a());
    textView2.setTextColor(ce.o.a());
    cf.n.a(textView2);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
    layoutParams.addRule(13, -1);
    relativeLayout.addView((View)textView2, (ViewGroup.LayoutParams)layoutParams);
    ImageView imageView = new ImageView(paramContext);
    imageView.setBackgroundDrawable(ca.ap.a(paramContext));
    imageView.setId(hv.b.a());
    imageView.setOnClickListener(this);
    layoutParams = new RelativeLayout.LayoutParams(cc.a(30.0F), cc.a(30.0F));
    layoutParams.addRule(11);
    layoutParams.addRule(15, -1);
    layoutParams.rightMargin = cc.a(30.0F);
    relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams);
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout3.addView((View)linearLayout1, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
    linearLayout1.setId(hv.e.a());
    linearLayout1.setGravity(17);
    linearLayout1.setVisibility(0);
    linearLayout1.setOrientation(1);
    ProgressBar progressBar = new ProgressBar(paramContext);
    progressBar.setIndeterminate(true);
    progressBar.setId(hv.s.a());
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(df.a(paramContext, 300.0F), df.a(paramContext, 72.0F));
    layoutParams2.topMargin = df.a(paramContext, 20.0F);
    layoutParams2.gravity = 17;
    linearLayout1.addView((View)progressBar, (ViewGroup.LayoutParams)layoutParams2);
    TextView textView3 = a(paramContext, cg.aY);
    textView3.setGravity(17);
    linearLayout1.addView((View)textView3, (ViewGroup.LayoutParams)a(3));
    textView3.setTextColor(ce.h.a());
    (new LinearLayout.LayoutParams(df.a(paramContext, 300.0F), 1000)).topMargin = df.a(paramContext, 5.0F);
    linearLayout3.addView(f(paramContext));
    textView3 = c(paramContext, cg.bs);
    textView3.setVisibility(8);
    textView3.setId(hv.g.a());
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, df.a(paramContext, 200.0F));
    layoutParams1.topMargin = df.a(paramContext, 20.0F);
    layoutParams1.gravity = 17;
    linearLayout3.addView((View)textView3, (ViewGroup.LayoutParams)layoutParams1);
    textView3.setTextColor(ce.l.a());
    textView3.setTextSize(18.0F);
    textView3.setGravity(17);
    TextView textView1 = new TextView(paramContext);
    textView1.setSingleLine(false);
    textView1.setTextColor(-16777216);
    textView1.setVisibility(8);
    textView1.setId(hv.x.a());
    layoutParams1 = new LinearLayout.LayoutParams(-1, df.a(paramContext, 200.0F));
    layoutParams1.topMargin = df.a(paramContext, 50.0F);
    layoutParams1.gravity = 17;
    layoutParams1.bottomMargin = df.a(paramContext, 20.0F);
    layoutParams1.rightMargin = df.a(paramContext, 10.0F);
    layoutParams1.leftMargin = df.a(paramContext, 15.0F);
    cf.d.a(textView1);
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams1);
    textView1 = new TextView(paramContext);
    textView1.setSingleLine(false);
    textView1.setId(hv.y.a());
    textView1.setTextColor(-65536);
    textView1.setVisibility(8);
    layoutParams1 = new LinearLayout.LayoutParams(-1, df.a(paramContext, 200.0F));
    layoutParams1.topMargin = df.a(paramContext, 80.0F);
    layoutParams1.gravity = 17;
    layoutParams1.bottomMargin = df.a(paramContext, 20.0F);
    layoutParams1.rightMargin = df.a(paramContext, 10.0F);
    layoutParams1.leftMargin = df.a(paramContext, 15.0F);
    cf.d.a(textView1);
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)layoutParams1);
    Button button = new Button(paramContext);
    layoutParams1 = a(3);
    layoutParams1.setMargins(5, 0, 5, 25);
    linearLayout2.addView((View)button, (ViewGroup.LayoutParams)layoutParams1);
    button.setVisibility(0);
    button.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.bj, ca.bk));
    button.setId(hv.r.a());
    button.setText(cg.br.a());
    button.setTextColor(ce.o.a());
    cd.l.a((View)button);
    cf.i.a((TextView)button);
    button.setOnClickListener(this);
    a(e.e, 0);
    F();
    G();
    d(-1);
    return (View)this.C;
  }
  
  private k e(int paramInt) {
    if (this.w != null) {
      k k1 = this.w.b(paramInt);
      if (k1 instanceof k)
        return k1; 
    } 
    return null;
  }
  
  private void e(double paramDouble) {
    double d = b(paramDouble);
    if (getCoinBalance() < d);
    String str = String.format(cg.F.a(), new Object[] { this.u.format(d), getCoinName() });
    b(hv.n, (CharSequence)Html.fromHtml(str));
    d = c(d);
    if (!d(paramDouble) || d(d)) {
      a(hv.w, 0);
      str = this.u.format(d);
      str = String.format(cg.M.a(), new Object[] { str });
      b(hv.t, (CharSequence)Html.fromHtml(str));
      f(this.t);
      return;
    } 
    a(hv.w, 8);
    b(hv.t, (CharSequence)Html.fromHtml(cg.O.a()));
    f(7);
  }
  
  private View f(Context paramContext) {
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    linearLayout1.setVisibility(8);
    linearLayout1.setId(hv.f.a());
    Rect rect = cd.b.a();
    linearLayout1.setPadding(rect.left, 0, rect.right, 0);
    linearLayout1.addView(g(paramContext));
    d(paramContext, linearLayout1);
    LinearLayout linearLayout2 = a(paramContext, linearLayout1);
    linearLayout2.setId(hv.w.a());
    this.E = new ListView(paramContext);
    this.E.setChoiceMode(1);
    this.E.setVerticalScrollBarEnabled(false);
    this.E.setSelector((Drawable)new ColorDrawable(0));
    this.E.setId(hv.h.a());
    this.E.setDividerHeight(0);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, df.a(paramContext, 130.0F));
    linearLayout2.addView((View)this.E, (ViewGroup.LayoutParams)layoutParams1);
    hs hs = new hs(this);
    this.E.setOnItemClickListener(hs);
    this.w = new co(paramContext, null);
    this.E.setAdapter((ListAdapter)this.w);
    linearLayout2 = a(paramContext, linearLayout2);
    Button button = new Button(paramContext);
    LinearLayout.LayoutParams layoutParams2 = a(3);
    layoutParams2.height = cc.a(40.0F);
    layoutParams2.setMargins(0, 10, 0, 10);
    linearLayout2.addView((View)button, 0, (ViewGroup.LayoutParams)layoutParams2);
    button.setVisibility(0);
    button.setBackgroundDrawable((Drawable)ca.a(paramContext, ca.bj, ca.bk));
    button.setId(hv.q.a());
    button.setText("确认支付");
    button.setTextColor(ce.o.a());
    cd.l.a((View)button);
    cf.i.a((TextView)button);
    button.setOnClickListener(this);
    return (View)linearLayout1;
  }
  
  private void f(int paramInt) {
    switch (paramInt) {
      default:
        b(hv.q, cg.bm);
        return;
      case 3:
      case 4:
      case 6:
      case 78:
      case 79:
        break;
    } 
    b(hv.q, cg.bn);
  }
  
  private View g(Context paramContext) {
    LinearLayout linearLayout1 = new LinearLayout(paramContext);
    linearLayout1.setOrientation(1);
    linearLayout1.setPadding(0, 5, (cd.d.a()).right, 0);
    if (this.r != null && this.r.length() > 0) {
      TextView textView = a(paramContext, (cg)null);
      cf.i.a(textView);
      textView.setText((CharSequence)Html.fromHtml(String.format(cg.A.a(), new Object[] { this.r })));
      linearLayout1.addView((View)textView, (ViewGroup.LayoutParams)a(3));
      ImageView imageView = new ImageView(paramContext);
      imageView.setBackgroundDrawable(ca.ar.a(paramContext));
      linearLayout1.addView((View)imageView, (ViewGroup.LayoutParams)a(3));
    } 
    LinearLayout linearLayout2 = new LinearLayout(paramContext);
    linearLayout2.setOrientation(0);
    TextView textView2 = a(paramContext, cg.G);
    cf.i.a(textView2);
    linearLayout2.addView((View)textView2);
    textView2 = a(paramContext, (cg)null);
    cf.g.a(textView2);
    textView2.setId(hv.j.a());
    linearLayout2.addView((View)textView2);
    TextView textView1 = a(paramContext, (cg)null);
    textView1.setText(getCoinName());
    cf.g.a(textView1);
    linearLayout2.addView((View)textView1, (ViewGroup.LayoutParams)a(3));
    textView1.setPadding(cc.a(6.0F), 0, 0, 0);
    linearLayout1.addView((View)linearLayout2, (ViewGroup.LayoutParams)a(3));
    return (View)linearLayout1;
  }
  
  private void setChannelMessages(k[] paramArrayOfk) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic getPaySequenceTop : ()I
    //   5: istore_3
    //   6: new java/util/ArrayList
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore #4
    //   15: aload_1
    //   16: arraylength
    //   17: istore #5
    //   19: iconst_0
    //   20: istore #6
    //   22: iload #6
    //   24: iload #5
    //   26: if_icmpge -> 122
    //   29: aload_1
    //   30: iload #6
    //   32: aaload
    //   33: astore #7
    //   35: aload #7
    //   37: invokevirtual c : ()Z
    //   40: ifne -> 49
    //   43: iinc #6, 1
    //   46: goto -> 22
    //   49: aload #7
    //   51: getfield B : I
    //   54: bipush #7
    //   56: if_icmpne -> 73
    //   59: aload_0
    //   60: getfield s : Z
    //   63: ifne -> 43
    //   66: aload_0
    //   67: invokespecial A : ()Z
    //   70: ifne -> 43
    //   73: aload #7
    //   75: getfield B : I
    //   78: bipush #7
    //   80: if_icmpeq -> 43
    //   83: iload_3
    //   84: iflt -> 109
    //   87: aload #7
    //   89: getfield B : I
    //   92: iload_3
    //   93: if_icmpne -> 109
    //   96: aload #4
    //   98: iconst_0
    //   99: aload #7
    //   101: invokeinterface add : (ILjava/lang/Object;)V
    //   106: goto -> 43
    //   109: aload #4
    //   111: aload #7
    //   113: invokeinterface add : (Ljava/lang/Object;)Z
    //   118: pop
    //   119: goto -> 43
    //   122: aload #4
    //   124: aload #4
    //   126: invokeinterface size : ()I
    //   131: anewarray com/zz/sdk/b/k
    //   134: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   139: checkcast [Lcom/zz/sdk/b/k;
    //   142: astore_1
    //   143: invokestatic getPayAutoStart : ()Z
    //   146: ifeq -> 340
    //   149: iload_3
    //   150: iflt -> 340
    //   153: aload_0
    //   154: invokespecial B : ()Z
    //   157: ifne -> 340
    //   160: iconst_0
    //   161: istore #6
    //   163: iload #6
    //   165: aload_1
    //   166: arraylength
    //   167: if_icmpge -> 340
    //   170: iload #6
    //   172: istore #5
    //   174: aload_1
    //   175: iload #6
    //   177: aaload
    //   178: getfield D : I
    //   181: iconst_1
    //   182: if_icmpeq -> 200
    //   185: aload_1
    //   186: iload #6
    //   188: aaload
    //   189: getfield B : I
    //   192: iload_3
    //   193: if_icmpne -> 310
    //   196: iload #6
    //   198: istore #5
    //   200: iload #5
    //   202: iconst_m1
    //   203: if_icmpne -> 337
    //   206: aload_1
    //   207: arraylength
    //   208: iconst_1
    //   209: if_icmpne -> 337
    //   212: iload_2
    //   213: istore #5
    //   215: aload_0
    //   216: getfield w : Lcom/zz/sdk/e/co;
    //   219: ifnonnull -> 316
    //   222: aload_0
    //   223: new com/zz/sdk/e/co
    //   226: dup
    //   227: aload_0
    //   228: getfield f : Landroid/content/Context;
    //   231: aload_1
    //   232: invokespecial <init> : (Landroid/content/Context;[Lcom/zz/sdk/b/k;)V
    //   235: putfield w : Lcom/zz/sdk/e/co;
    //   238: aload_0
    //   239: getfield C : Landroid/widget/LinearLayout;
    //   242: getstatic com/zz/sdk/e/hv.h : Lcom/zz/sdk/e/hv;
    //   245: invokevirtual a : ()I
    //   248: invokevirtual findViewById : (I)Landroid/view/View;
    //   251: astore_1
    //   252: aload_1
    //   253: instanceof android/widget/ListView
    //   256: ifeq -> 270
    //   259: aload_1
    //   260: checkcast android/widget/ListView
    //   263: aload_0
    //   264: getfield w : Lcom/zz/sdk/e/co;
    //   267: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   270: aload_0
    //   271: iload #5
    //   273: invokespecial d : (I)V
    //   276: iload #5
    //   278: iflt -> 309
    //   281: aload_0
    //   282: getfield E : Landroid/widget/ListView;
    //   285: iload #5
    //   287: iconst_1
    //   288: invokevirtual setItemChecked : (IZ)V
    //   291: aload_0
    //   292: getfield F : Landroid/os/Handler;
    //   295: new com/zz/sdk/e/hn
    //   298: dup
    //   299: aload_0
    //   300: iload #5
    //   302: invokespecial <init> : (Lcom/zz/sdk/e/hg;I)V
    //   305: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   308: pop
    //   309: return
    //   310: iinc #6, 1
    //   313: goto -> 163
    //   316: aload_0
    //   317: getfield C : Landroid/widget/LinearLayout;
    //   320: getstatic com/zz/sdk/e/hv.h : Lcom/zz/sdk/e/hv;
    //   323: invokestatic a : (Landroid/view/View;Lcom/zz/sdk/e/f;)V
    //   326: aload_0
    //   327: getfield w : Lcom/zz/sdk/e/co;
    //   330: aload_1
    //   331: invokevirtual a : ([Lcom/zz/sdk/b/k;)V
    //   334: goto -> 270
    //   337: goto -> 215
    //   340: iconst_m1
    //   341: istore #5
    //   343: goto -> 200
  }
  
  public Object a(ds paramds) {
    // Byte code:
    //   0: getstatic com/zz/sdk/e/hk.a : [I
    //   3: aload_1
    //   4: invokevirtual ordinal : ()I
    //   7: iaload
    //   8: tableswitch default -> 36, 1 -> 40, 2 -> 40, 3 -> 150
    //   36: aconst_null
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: dconst_0
    //   41: dstore_2
    //   42: aload_0
    //   43: getstatic com/zz/sdk/e/hv.j : Lcom/zz/sdk/e/hv;
    //   46: invokespecial b : (Lcom/zz/sdk/e/f;)Ljava/lang/String;
    //   49: astore #4
    //   51: dload_2
    //   52: dstore #5
    //   54: aload #4
    //   56: ifnull -> 141
    //   59: dload_2
    //   60: dstore #5
    //   62: aload #4
    //   64: invokevirtual length : ()I
    //   67: ifle -> 141
    //   70: aload #4
    //   72: invokestatic parseDouble : (Ljava/lang/String;)D
    //   75: dstore #5
    //   77: dload #5
    //   79: dstore #7
    //   81: dload #5
    //   83: dstore_2
    //   84: aload_0
    //   85: invokespecial B : ()Z
    //   88: ifeq -> 116
    //   91: dload #5
    //   93: dstore #7
    //   95: dload #5
    //   97: dstore_2
    //   98: aload_0
    //   99: invokespecial A : ()Z
    //   102: ifne -> 116
    //   105: dload #5
    //   107: dstore_2
    //   108: aload_0
    //   109: dload #5
    //   111: invokespecial b : (D)D
    //   114: dstore #7
    //   116: dload #7
    //   118: dstore #5
    //   120: dload #7
    //   122: dstore_2
    //   123: aload_1
    //   124: getstatic com/zz/sdk/e/ds.b : Lcom/zz/sdk/e/ds;
    //   127: if_acmpne -> 141
    //   130: dload #7
    //   132: dstore_2
    //   133: aload_0
    //   134: dload #7
    //   136: invokespecial c : (D)D
    //   139: dstore #5
    //   141: dload #5
    //   143: invokestatic valueOf : (D)Ljava/lang/Double;
    //   146: astore_1
    //   147: goto -> 38
    //   150: iconst_m1
    //   151: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   154: astore_1
    //   155: goto -> 38
    //   158: astore_1
    //   159: dload_2
    //   160: dstore #5
    //   162: goto -> 141
    // Exception table:
    //   from	to	target	type
    //   70	77	158	java/lang/NumberFormatException
    //   84	91	158	java/lang/NumberFormatException
    //   98	105	158	java/lang/NumberFormatException
    //   108	116	158	java/lang/NumberFormatException
    //   123	130	158	java/lang/NumberFormatException
    //   133	141	158	java/lang/NumberFormatException
  }
  
  protected void a(double paramDouble) {
    super.a(paramDouble);
    G();
  }
  
  protected void a(Context paramContext, ParamChain paramParamChain) {
    dk dk1;
    cg cg;
    int i;
    boolean bool1;
    double d;
    super.a(paramContext, paramParamChain);
    this.u = new DecimalFormat(cg.a.a());
    this.B = (String)paramParamChain.get("global.device.imsi", String.class);
    if (this.B != null && !cv.l(this.f))
      this.B = null; 
    Double double_ = (Double)paramParamChain.get("global.user.coin_rate", Double.class);
    if (double_ != null) {
      this.x = double_.doubleValue();
    } else {
      this.x = 1.0D;
    } 
    Integer integer = (Integer)paramParamChain.get("global.caller.amount", Integer.class);
    if (integer == null) {
      i = 0;
    } else {
      i = integer.intValue();
    } 
    this.z = i;
    Boolean bool = (Boolean)paramParamChain.get("global.caller.coin_count", Boolean.class);
    if (bool != null && bool.booleanValue()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.A = bool1;
    bool = (Boolean)paramParamChain.get("global.caller.payment_zycoin_disabled", Boolean.class);
    if (bool != null && bool.booleanValue()) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.s = bool1;
    bool = (Boolean)paramParamChain.get("global.caller.pay_is_buy_mode", Boolean.class);
    if (bool != null && bool.booleanValue()) {
      dk1 = dk.d;
    } else {
      dk1 = dk.c;
    } 
    this.y = dk1;
    this.q = (String)paramParamChain.get("global.caller.prop_id", String.class);
    this.r = (String)paramParamChain.get("global.caller.prop_name", String.class);
    if (A()) {
      cg = cg.w;
    } else {
      cg = cg.x;
    } 
    paramParamChain.add("global.paymentlist.pay_title", cg, h.b);
    if (this.r == null && !B()) {
      if (A()) {
        if (this.A) {
          d = this.z;
        } else {
          d = b(this.z);
        } 
        this.r = String.format(cg.D.a(), new Object[] { this.u.format(d / 100.0D), getCoinName() });
        return;
      } 
    } else {
      return;
    } 
    if (this.A) {
      d = c(this.z);
    } else {
      d = this.z;
    } 
    this.r = String.format(cg.E.a(), new Object[] { this.u.format(d / 100.0D) });
  }
  
  public boolean a() {
    boolean bool = super.a();
    View view = e();
    if (view == null || view.getVisibility() != 0)
      getHost().a(getClass().getClassLoader(), ce.class.getName(), getEnv()); 
    return bool;
  }
  
  protected void b(Context paramContext) {
    a(e.i, 8);
    View view = e(paramContext);
    int i = (int)(((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getWidth() / 1.2D);
    this.D = bs.a(paramContext).a();
    this.D.show();
    this.D.setContentView(view, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(i, -2));
    this.D.getWindow().clearFlags(131072);
    this.D.setCancelable(false);
    this.D.setOnKeyListener(new ho(this, paramContext));
    this.D.setOnDismissListener(new hp(this));
  }
  
  protected void c(f paramf, int paramInt) {
    View view = this.C.findViewById(paramf.a());
    if (view != null)
      view.setVisibility(paramInt); 
  }
  
  public void d(boolean paramBoolean) {
    byte b2;
    byte b1 = 8;
    View view = this.C.findViewById(hv.e.a());
    if (view != null && view.getVisibility() == 0) {
      view.setVisibility(8);
      if (view instanceof ViewGroup)
        ((ViewGroup)view).removeAllViews(); 
    } 
    hv hv = hv.q;
    if (paramBoolean) {
      b2 = 0;
    } else {
      b2 = 8;
    } 
    c(hv, b2);
    hv = hv.f;
    if (paramBoolean) {
      b2 = 0;
    } else {
      b2 = 8;
    } 
    c(hv, b2);
    hv = hv.g;
    if (paramBoolean) {
      b2 = b1;
    } else {
      b2 = 0;
    } 
    c(hv, b2);
  }
  
  public boolean j() {
    boolean bool = super.j();
    if (bool) {
      y();
      if (E())
        D(); 
    } 
    return bool;
  }
  
  public boolean l() {
    boolean bool = super.l();
    if (bool) {
      a((View)this.C, hv.h);
      Object object = getEnv().getParent(cr.class.getName()).remove("global.paymentlist.pay_result");
      if (object != null && object instanceof Integer) {
        int i = ((Integer)object).intValue();
        bp.b("state" + i);
        a(getEnv(), i);
        c(i);
      } 
    } 
    return bool;
  }
  
  protected void m() {
    a(1, 3, (Object)null);
    super.m();
  }
  
  public boolean n() {
    return super.n();
  }
  
  public void onClick(View paramView) {
    hv hv = hv.a(paramView.getId());
    switch (hk.b[hv.ordinal()]) {
      default:
        super.onClick(paramView);
        return;
      case 1:
        C();
        return;
      case 2:
        z();
        return;
      case 3:
        break;
    } 
    z();
  }
  
  protected void y() {
    a(-1L, (String)null);
  }
  
  public void z() {
    if (this.D != null) {
      this.D.dismiss();
      this.D = null;
      this.C = null;
      this.E = null;
      b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */