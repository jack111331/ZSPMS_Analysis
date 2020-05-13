package com.unionpay.mobile.android.nocard.views;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.nocard.utils.d;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.upwidget.UPScrollView;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.views.order.m;
import com.unionpay.mobile.android.widgets.UPWidget;
import com.unionpay.mobile.android.widgets.aa;
import com.unionpay.mobile.android.widgets.ad;
import com.unionpay.mobile.android.widgets.ae;
import com.unionpay.mobile.android.widgets.af;
import com.unionpay.mobile.android.widgets.ah;
import com.unionpay.mobile.android.widgets.ao;
import com.unionpay.mobile.android.widgets.ap;
import com.unionpay.mobile.android.widgets.as;
import com.unionpay.mobile.android.widgets.at;
import com.unionpay.mobile.android.widgets.au;
import com.unionpay.mobile.android.widgets.av;
import com.unionpay.mobile.android.widgets.ay;
import com.unionpay.mobile.android.widgets.e;
import com.unionpay.mobile.android.widgets.f;
import com.unionpay.mobile.android.widgets.g;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.u;
import com.unionpay.mobile.android.widgets.y;
import com.unionpay.mobile.android.widgets.z;
import com.unionpay.sdk.UPAgent;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

public abstract class b extends RelativeLayout implements UPPayEngine.a, a, UPScrollView.a, aa.a, ay.a {
  protected com.unionpay.mobile.android.model.b a = null;
  
  protected m b = null;
  
  protected c c = null;
  
  protected Context d = null;
  
  protected UPPayEngine e = null;
  
  protected int f = 0;
  
  protected String g = null;
  
  protected String h = null;
  
  protected String i = null;
  
  protected boolean j = true;
  
  protected RelativeLayout k = null;
  
  protected ViewGroup l = null;
  
  protected RelativeLayout m = null;
  
  protected as n = null;
  
  protected UPScrollView o = null;
  
  protected e p;
  
  protected String q = "uppay";
  
  private LinearLayout r;
  
  private LinearLayout s;
  
  private LinearLayout t;
  
  private int u;
  
  private int v;
  
  private Activity w = null;
  
  public b(Context paramContext) {
    this(paramContext, (e)null);
  }
  
  public b(Context paramContext, e parame) {
    super(paramContext);
    this.d = paramContext;
    if (this.d instanceof Activity)
      this.w = (Activity)this.d; 
    this.p = parame;
    this.e = (UPPayEngine)((BaseActivity)paramContext).a(UPPayEngine.class.toString());
    this.a = (com.unionpay.mobile.android.model.b)((BaseActivity)paramContext).a(null);
    this.b = (m)((BaseActivity)paramContext).a(m.class.toString());
    this.c = c.a(paramContext);
    setId(8888);
    setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    setBackgroundColor(-1);
    k.b("uppayEx", "UPViewBase:" + toString());
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    boolean bool;
    BaseActivity baseActivity = (BaseActivity)this.d;
    switch (paramInt) {
      default:
        b1 = null;
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 2:
        b1 = baseActivity.a(paramInt, null);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 6:
        bool = false;
        paramInt = bool;
        if (this.a.q != null) {
          paramInt = bool;
          if (this.a.q.size() > 0)
            paramInt = ((c)this.a.q.get(this.a.N)).c(); 
        } 
        if ((i() || paramInt == 0) && !this.a.br) {
          b1 = new at(this.d);
        } else {
          b1 = baseActivity.a(6, null);
        } 
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 8:
        b1 = new bd(this.d);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 5:
        b1 = new g(this.d);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 10:
        b1 = new ak(this.d);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 11:
        b1 = new ai(this.d);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 12:
        b1 = new af(this.d);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 13:
        b1 = new o(this.d, null);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 14:
        b1 = new bi(this.d, paramBoolean1, paramBoolean2);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 17:
        b1 = baseActivity.a(paramInt, null);
        if (b1 != null)
          baseActivity.a(b1); 
        return;
      case 18:
        break;
    } 
    b b1 = baseActivity.a(paramInt, null);
    if (b1 != null)
      baseActivity.a(b1); 
  }
  
  public static void a(Context paramContext, String paramString) {
    a(paramContext, paramString, (String[])null, (Object[])null);
  }
  
  public static void a(Context paramContext, String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject) {
    if (a.L) {
      k.a("uppay-TD", "event:" + paramString + ", keys:" + Arrays.toString((Object[])paramArrayOfString) + ", values:" + Arrays.toString(paramArrayOfObject));
      if (paramArrayOfString != null && paramArrayOfObject != null) {
        if (paramArrayOfString.length != paramArrayOfObject.length || paramArrayOfString.length > 10)
          throw new IllegalArgumentException(); 
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        for (byte b1 = 0; b1 < paramArrayOfString.length; b1++)
          hashMap.put(paramArrayOfString[b1], paramArrayOfObject[b1]); 
        UPAgent.onEvent(paramContext, paramString, paramString, hashMap);
        return;
      } 
    } else {
      return;
    } 
    UPAgent.onEvent(paramContext, paramString);
  }
  
  protected static boolean b(String paramString) {
    return (paramString != null && paramString.length() > 0);
  }
  
  protected static ColorStateList p() {
    return h.a(com.unionpay.mobile.android.global.b.b, com.unionpay.mobile.android.global.b.c, com.unionpay.mobile.android.global.b.c, com.unionpay.mobile.android.global.b.d);
  }
  
  private RelativeLayout u() {
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    if (this.k != null) {
      layoutParams2.addRule(3, this.k.getId());
      layoutParams2.addRule(12, -1);
    } 
    FrameLayout frameLayout = new FrameLayout(this.d);
    addView((View)frameLayout, (ViewGroup.LayoutParams)layoutParams2);
    FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    this.o = new UPScrollView(this.d);
    this.o.setPadding(0, 0, 0, 0);
    frameLayout.addView((View)this.o, (ViewGroup.LayoutParams)layoutParams1);
    FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
    int i = g.a(this.d, 10.0F);
    this.t = new LinearLayout(this.d);
    this.t.setId(this.t.hashCode());
    this.t.setOrientation(1);
    if (this.a.aM && !com.unionpay.mobile.android.model.b.bm) {
      this.t.setBackgroundColor(-34177);
    } else {
      this.t.setBackgroundColor(-267336);
    } 
    this.t.setPadding(i, i, i, i);
    String str = "";
    if (b(this.a.ar))
      str = "" + this.a.ar; 
    if (b(str)) {
      TextView textView = new TextView(this.d);
      if (this.a.aM && !com.unionpay.mobile.android.model.b.bm) {
        textView.setTextColor(-1);
      } else {
        textView.setTextColor(-10066330);
      } 
      textView.setText(str);
      textView.setTextSize(com.unionpay.mobile.android.global.b.k);
      this.t.addView((View)textView);
      this.t.setVisibility(8);
      frameLayout.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams4);
      RelativeLayout relativeLayout1 = new RelativeLayout(this.d);
      relativeLayout1.setBackgroundColor(-1052684);
      layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
      this.o.addView((View)relativeLayout1, (ViewGroup.LayoutParams)layoutParams3);
      return relativeLayout1;
    } 
    this.t.setVisibility(8);
    this.t.setVisibility(8);
    layoutParams3.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams4);
    RelativeLayout relativeLayout = new RelativeLayout(this.d);
    relativeLayout.setBackgroundColor(-1052684);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
    this.o.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams3);
    return relativeLayout;
  }
  
  protected final RelativeLayout a() {
    RelativeLayout relativeLayout = new RelativeLayout(getContext());
    relativeLayout.setId(relativeLayout.hashCode());
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams.addRule(10, -1);
    addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
    return relativeLayout;
  }
  
  protected final z a(JSONObject paramJSONObject, String paramString) {
    ao ao;
    af af = null;
    String str = j.a(paramJSONObject, "type");
    int i = a.I - a.f * 4;
    if ("pan".equalsIgnoreCase(str)) {
      af = new af(this.d, i, paramJSONObject, paramString);
    } else if ("mobile".equalsIgnoreCase(str)) {
      ah ah = new ah(this.d, i, paramJSONObject, paramString);
    } else if ("sms".equalsIgnoreCase(str)) {
      ap ap = new ap(this.d, i, paramJSONObject, paramString);
    } else if ("cvn2".equalsIgnoreCase(str)) {
      e e1 = new e(this.d, i, paramJSONObject, paramString);
    } else if ("expire".equalsIgnoreCase(str)) {
      av av = new av(this.d, i, paramJSONObject, paramString);
    } else if ("pwd".equalsIgnoreCase(str)) {
      UPWidget uPWidget = new UPWidget(this.d, this.e.c(), i, paramJSONObject, paramString);
    } else if ("text".equalsIgnoreCase(str)) {
      at at = new at(this.d, i, paramJSONObject, paramString);
    } else if ("string".equalsIgnoreCase(str)) {
      ad ad = new ad(this.d, paramJSONObject, paramString);
    } else if ("cert_id".equalsIgnoreCase(str)) {
      f f = new f(this.d, i, paramJSONObject, paramString);
    } else if ("cert_type".equalsIgnoreCase(str)) {
      g g = new g(this.d, paramJSONObject, paramString);
    } else if ("name".equalsIgnoreCase(str)) {
      ae ae = new ae(this.d, i, paramJSONObject, paramString);
    } else if ("hidden".equalsIgnoreCase(str)) {
      y y = new y(this.d, paramJSONObject, paramString);
    } else if ("user_name".equalsIgnoreCase(str)) {
      au au = new au(this.d, i, paramJSONObject, paramString);
    } else if ("password".equalsIgnoreCase(str)) {
      ao = new ao(this.d, i, paramJSONObject, paramString);
    } 
    if (ao != null && ao instanceof aa)
      ((aa)ao).a(this); 
    return (z)ao;
  }
  
  public final void a(int paramInt) {
    ((BaseActivity)this.d).a(paramInt);
  }
  
  protected final void a(int paramInt, e parame) {
    boolean bool;
    BaseActivity baseActivity = (BaseActivity)this.d;
    b b1 = null;
    b b2 = b1;
    switch (paramInt) {
      default:
        b2 = b1;
      case 3:
      case 4:
      case 7:
      case 9:
      case 15:
      case 16:
        if (b2 != null)
          baseActivity.a(b2); 
        return;
      case 2:
        b2 = baseActivity.a(paramInt, parame);
      case 6:
        bool = false;
        paramInt = bool;
        if (this.a.q != null) {
          paramInt = bool;
          if (this.a.q.size() > 0)
            paramInt = ((c)this.a.q.get(this.a.N)).c(); 
        } 
        if ((i() || paramInt == 0 || this.a.aP == l.c.intValue()) && !this.a.br) {
          b2 = new at(this.d, parame);
        } else {
          b2 = baseActivity.a(6, parame);
        } 
      case 8:
        b2 = new bd(this.d);
      case 5:
        b2 = new g(this.d);
      case 10:
        b2 = new ak(this.d);
      case 11:
        b2 = new ai(this.d);
      case 12:
        b2 = new af(this.d);
      case 13:
        b2 = new o(this.d, parame);
      case 14:
        b2 = new bi(this.d);
      case 17:
        b2 = baseActivity.a(paramInt, parame);
      case 18:
        break;
    } 
    b2 = baseActivity.a(paramInt, parame);
  }
  
  public final void a(int paramInt, String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield j : Z
    //   7: ldc 'uppay'
    //   9: new java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w ' '
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual toString : ()Ljava/lang/String;
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   32: pop
    //   33: iload_1
    //   34: ifne -> 592
    //   37: ldc 'uppay'
    //   39: ldc_w 'parserResponseMesage() +++'
    //   42: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   45: pop
    //   46: aconst_null
    //   47: astore #4
    //   49: aconst_null
    //   50: astore #5
    //   52: aload_2
    //   53: ifnull -> 63
    //   56: aload_2
    //   57: invokevirtual length : ()I
    //   60: ifne -> 114
    //   63: ldc 'uppay'
    //   65: ldc_w ' ERROR_MSG_FORMAT'
    //   68: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: iconst_2
    //   73: istore_1
    //   74: aload #5
    //   76: astore_2
    //   77: iload_1
    //   78: ifeq -> 584
    //   81: aload_0
    //   82: getfield g : Ljava/lang/String;
    //   85: astore #5
    //   87: aload_0
    //   88: aload_0
    //   89: getfield h : Ljava/lang/String;
    //   92: aload_2
    //   93: invokevirtual a : (Ljava/lang/String;Lorg/json/JSONObject;)Z
    //   96: ifne -> 104
    //   99: aload_0
    //   100: iload_1
    //   101: invokevirtual b : (I)V
    //   104: ldc 'uppay'
    //   106: ldc_w 'parserResponseMesage() ---'
    //   109: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   112: pop
    //   113: return
    //   114: aload #4
    //   116: astore #5
    //   118: new org/json/JSONObject
    //   121: astore #6
    //   123: aload #4
    //   125: astore #5
    //   127: aload #6
    //   129: aload_2
    //   130: invokespecial <init> : (Ljava/lang/String;)V
    //   133: aload #4
    //   135: astore #5
    //   137: aload_0
    //   138: aload #6
    //   140: ldc_w 'resp'
    //   143: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   146: putfield g : Ljava/lang/String;
    //   149: aload #4
    //   151: astore #5
    //   153: aload_0
    //   154: aload #6
    //   156: ldc_w 'msg'
    //   159: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   162: putfield h : Ljava/lang/String;
    //   165: aload #4
    //   167: astore #5
    //   169: aload_0
    //   170: aload #6
    //   172: ldc_w 'cmd'
    //   175: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   178: putfield i : Ljava/lang/String;
    //   181: aload #4
    //   183: astore #5
    //   185: aload #6
    //   187: ldc_w 'params'
    //   190: invokestatic c : (Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   193: astore #4
    //   195: iload_3
    //   196: istore_1
    //   197: aload #4
    //   199: astore_2
    //   200: aload #4
    //   202: astore #5
    //   204: aload_0
    //   205: getfield g : Ljava/lang/String;
    //   208: ldc_w '00'
    //   211: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   214: ifne -> 77
    //   217: aload #4
    //   219: astore #5
    //   221: ldc_w 'pay'
    //   224: aload_0
    //   225: getfield i : Ljava/lang/String;
    //   228: invokevirtual equals : (Ljava/lang/Object;)Z
    //   231: ifne -> 286
    //   234: aload #4
    //   236: astore #5
    //   238: aload_0
    //   239: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   242: getfield E : Ljava/lang/String;
    //   245: ifnull -> 360
    //   248: aload #4
    //   250: astore #5
    //   252: aload_0
    //   253: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   256: getfield E : Ljava/lang/String;
    //   259: invokevirtual length : ()I
    //   262: ifle -> 360
    //   265: aload #4
    //   267: astore #5
    //   269: aload_0
    //   270: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   273: getfield E : Ljava/lang/String;
    //   276: aload_0
    //   277: getfield i : Ljava/lang/String;
    //   280: invokevirtual equals : (Ljava/lang/Object;)Z
    //   283: ifeq -> 360
    //   286: aload #4
    //   288: astore #5
    //   290: aload_0
    //   291: getfield d : Landroid/content/Context;
    //   294: astore_2
    //   295: aload #4
    //   297: astore #5
    //   299: new java/lang/StringBuilder
    //   302: astore #6
    //   304: aload #4
    //   306: astore #5
    //   308: aload #6
    //   310: invokespecial <init> : ()V
    //   313: aload #4
    //   315: astore #5
    //   317: aload_2
    //   318: aload #6
    //   320: aload_0
    //   321: getfield q : Ljava/lang/String;
    //   324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w '_fail'
    //   330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual toString : ()Ljava/lang/String;
    //   336: getstatic com/unionpay/mobile/android/utils/p.j : [Ljava/lang/String;
    //   339: iconst_2
    //   340: anewarray java/lang/String
    //   343: dup
    //   344: iconst_0
    //   345: aload_0
    //   346: getfield g : Ljava/lang/String;
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: aload_0
    //   353: getfield h : Ljava/lang/String;
    //   356: aastore
    //   357: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: aload #4
    //   362: astore #5
    //   364: ldc_w 'rules'
    //   367: aload_0
    //   368: getfield i : Ljava/lang/String;
    //   371: invokevirtual equals : (Ljava/lang/Object;)Z
    //   374: ifeq -> 450
    //   377: aload #4
    //   379: astore #5
    //   381: aload_0
    //   382: getfield d : Landroid/content/Context;
    //   385: astore #6
    //   387: aload #4
    //   389: astore #5
    //   391: new java/lang/StringBuilder
    //   394: astore_2
    //   395: aload #4
    //   397: astore #5
    //   399: aload_2
    //   400: invokespecial <init> : ()V
    //   403: aload #4
    //   405: astore #5
    //   407: aload #6
    //   409: aload_2
    //   410: aload_0
    //   411: getfield q : Ljava/lang/String;
    //   414: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: ldc_w '_cardNO_fail'
    //   420: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual toString : ()Ljava/lang/String;
    //   426: getstatic com/unionpay/mobile/android/utils/p.j : [Ljava/lang/String;
    //   429: iconst_2
    //   430: anewarray java/lang/String
    //   433: dup
    //   434: iconst_0
    //   435: aload_0
    //   436: getfield g : Ljava/lang/String;
    //   439: aastore
    //   440: dup
    //   441: iconst_1
    //   442: aload_0
    //   443: getfield h : Ljava/lang/String;
    //   446: aastore
    //   447: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Object;)V
    //   450: aload #4
    //   452: astore #5
    //   454: ldc_w 'getuserinfo'
    //   457: aload_0
    //   458: getfield i : Ljava/lang/String;
    //   461: invokevirtual equals : (Ljava/lang/Object;)Z
    //   464: ifeq -> 502
    //   467: aload #4
    //   469: astore #5
    //   471: aload_0
    //   472: getfield d : Landroid/content/Context;
    //   475: ldc_w 'login_fail'
    //   478: getstatic com/unionpay/mobile/android/utils/p.j : [Ljava/lang/String;
    //   481: iconst_2
    //   482: anewarray java/lang/String
    //   485: dup
    //   486: iconst_0
    //   487: aload_0
    //   488: getfield g : Ljava/lang/String;
    //   491: aastore
    //   492: dup
    //   493: iconst_1
    //   494: aload_0
    //   495: getfield h : Ljava/lang/String;
    //   498: aastore
    //   499: invokestatic a : (Landroid/content/Context;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/Object;)V
    //   502: aload #4
    //   504: astore #5
    //   506: aload_0
    //   507: getfield g : Ljava/lang/String;
    //   510: ldc_w '21'
    //   513: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   516: ifeq -> 563
    //   519: bipush #17
    //   521: istore_1
    //   522: aload #4
    //   524: astore #5
    //   526: ldc 'uppay'
    //   528: ldc_w ' ERROR_ORDER_TIMEOUT'
    //   531: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   534: pop
    //   535: aload #4
    //   537: astore_2
    //   538: goto -> 77
    //   541: astore_2
    //   542: aload_2
    //   543: invokevirtual printStackTrace : ()V
    //   546: ldc 'uppay'
    //   548: ldc_w ' ERROR_MSG_FORMAT'
    //   551: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   554: pop
    //   555: iconst_2
    //   556: istore_1
    //   557: aload #5
    //   559: astore_2
    //   560: goto -> 77
    //   563: iconst_3
    //   564: istore_1
    //   565: aload #4
    //   567: astore #5
    //   569: ldc 'uppay'
    //   571: ldc_w ' ERROR_TRANSACTION'
    //   574: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   577: pop
    //   578: aload #4
    //   580: astore_2
    //   581: goto -> 77
    //   584: aload_0
    //   585: aload_2
    //   586: invokevirtual a : (Lorg/json/JSONObject;)V
    //   589: goto -> 104
    //   592: aload_0
    //   593: iload_1
    //   594: invokevirtual b : (I)V
    //   597: goto -> 113
    // Exception table:
    //   from	to	target	type
    //   118	123	541	org/json/JSONException
    //   127	133	541	org/json/JSONException
    //   137	149	541	org/json/JSONException
    //   153	165	541	org/json/JSONException
    //   169	181	541	org/json/JSONException
    //   185	195	541	org/json/JSONException
    //   204	217	541	org/json/JSONException
    //   221	234	541	org/json/JSONException
    //   238	248	541	org/json/JSONException
    //   252	265	541	org/json/JSONException
    //   269	286	541	org/json/JSONException
    //   290	295	541	org/json/JSONException
    //   299	304	541	org/json/JSONException
    //   308	313	541	org/json/JSONException
    //   317	360	541	org/json/JSONException
    //   364	377	541	org/json/JSONException
    //   381	387	541	org/json/JSONException
    //   391	395	541	org/json/JSONException
    //   399	403	541	org/json/JSONException
    //   407	450	541	org/json/JSONException
    //   454	467	541	org/json/JSONException
    //   471	502	541	org/json/JSONException
    //   506	519	541	org/json/JSONException
    //   526	535	541	org/json/JSONException
    //   569	578	541	org/json/JSONException
  }
  
  public final void a(u paramu, String paramString) {}
  
  protected final void a(String paramString) {
    a(paramString, false);
  }
  
  protected final void a(String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2) {
    this.b.a(paramOnClickListener1, paramOnClickListener2);
    if (this.w != null && !this.w.isFinishing() && c.bD != null)
      this.b.a(c.bD.Y, paramString, c.bD.W, c.bD.X, false); 
  }
  
  protected final void a(String paramString1, String paramString2) {
    a(paramString1, paramString2, false, false);
  }
  
  protected final void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
    ((InputMethodManager)this.d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    this.a.ag = paramString2;
    this.a.af = paramString1;
    a(14, paramBoolean1, paramBoolean2);
  }
  
  protected void a(String paramString, boolean paramBoolean) {
    d d = new d(this, paramBoolean);
    k.a("uppay", " showErrDialog(msg, boolean)  ");
    this.b.a(d, null);
    if (this.w != null && !this.w.isFinishing() && c.bD != null)
      this.b.a(c.bD.Y, paramString, c.bD.W); 
  }
  
  protected boolean a(String paramString, JSONObject paramJSONObject) {
    return false;
  }
  
  protected void b() {}
  
  public void b(int paramInt) {
    if (paramInt == 8 || paramInt == 17 || paramInt == 19) {
      this.a.I.f = "fail";
      k.a("uppay", "showErrDialog 1");
      a(c(paramInt), true);
      return;
    } 
    k.a("uppay", "showErrDialog 2");
    a(c(paramInt), false);
  }
  
  protected final void b(String paramString1, String paramString2) {
    a(paramString1, paramString2, true, true);
  }
  
  protected void b(String paramString, JSONObject paramJSONObject) {}
  
  protected final boolean b(JSONObject paramJSONObject) {
    boolean bool = false;
    if (f.c(this.a, paramJSONObject)) {
      c(paramJSONObject);
      bool = true;
    } 
    return bool;
  }
  
  protected final String c(int paramInt) {
    switch (paramInt) {
      default:
        return c.bD.aA;
      case 2:
        return c.bD.aB;
      case 7:
        return c.bD.aG;
      case 5:
        return c.bD.aH;
      case 6:
        return c.bD.aI;
      case 4:
        return c.bD.az;
      case 8:
        return c.bD.aJ;
      case 9:
        return c.bD.aK;
      case 21:
        return c.bD.aL;
      case 16:
        return c.bD.aM;
      case 19:
        return c.bD.aN;
      case 20:
        return c.bD.aO;
      case 18:
        return c.bD.aP;
      case 3:
      case 17:
        break;
    } 
    return this.h;
  }
  
  protected void c() {}
  
  protected final void c(JSONObject paramJSONObject) {
    e e1 = new e(this, paramJSONObject);
    f f = new f(this, paramJSONObject);
    this.b.a(e1, f);
    if (this.w != null && !this.w.isFinishing() && this.a != null)
      this.b.a(this.a.aG, this.a.aH, this.a.aI, this.a.aK); 
  }
  
  protected void d() {
    this.m = u();
  }
  
  protected final void d(int paramInt) {
    a(paramInt, false, false);
  }
  
  protected final void e() {
    this.k = a();
    b();
    RelativeLayout relativeLayout1 = u();
    LinearLayout linearLayout = new LinearLayout(this.d);
    linearLayout.setOrientation(1);
    linearLayout.setId(linearLayout.hashCode());
    linearLayout.setBackgroundColor(-1114114);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.addRule(10, -1);
    relativeLayout1.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams2);
    this.l = (ViewGroup)linearLayout;
    this.l.setBackgroundColor(0);
    f();
    int i = this.l.getId();
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams1.addRule(12, -1);
    layoutParams1.addRule(3, i);
    RelativeLayout relativeLayout2 = new RelativeLayout(this.d);
    relativeLayout1.addView((View)relativeLayout2, (ViewGroup.LayoutParams)layoutParams1);
    this.m = relativeLayout2;
    c();
  }
  
  public final void e(int paramInt) {
    if (paramInt >= this.v) {
      if (this.t.getVisibility() != 0 && this.t != null && this.r.getVisibility() == 0)
        this.t.setVisibility(0); 
      return;
    } 
    if (paramInt <= this.v + this.u && this.t.getVisibility() == 0 && this.t != null)
      this.t.setVisibility(8); 
  }
  
  protected void f() {
    boolean bool;
    this.s = new LinearLayout(this.d);
    this.s.setOrientation(1);
    if (this.a.aM && !com.unionpay.mobile.android.model.b.bm) {
      this.s.setBackgroundColor(-34177);
    } else {
      this.s.setBackgroundColor(-267336);
    } 
    int i = g.a(this.d, 10.0F);
    if (b(this.a.ar)) {
      this.s.setPadding(i, i, i, 0);
    } else {
      this.s.setPadding(i, i, i, i);
    } 
    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams2.topMargin = 0;
    this.l.addView((View)this.s, (ViewGroup.LayoutParams)layoutParams2);
    String str2 = "";
    if (b(this.a.at))
      str2 = "" + this.a.at; 
    if (b(str2)) {
      TextView textView = new TextView(this.d);
      if (this.a.aM && !com.unionpay.mobile.android.model.b.bm) {
        textView.setTextColor(-1);
      } else {
        textView.setTextColor(-10066330);
      } 
      textView.setText(str2);
      textView.setTextSize(com.unionpay.mobile.android.global.b.k);
      this.s.addView((View)textView);
    } else {
      this.s.setVisibility(8);
    } 
    this.r = new LinearLayout(this.d);
    this.r.setOrientation(1);
    if (this.a.aM && !com.unionpay.mobile.android.model.b.bm) {
      this.r.setBackgroundColor(-34177);
    } else {
      this.r.setBackgroundColor(-267336);
    } 
    this.r.setPadding(i, i, i, i);
    LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    layoutParams1.topMargin = 0;
    this.l.addView((View)this.r, (ViewGroup.LayoutParams)layoutParams1);
    String str1 = "";
    if (b(this.a.ar))
      str1 = "" + this.a.ar; 
    if (b(str1)) {
      TextView textView = new TextView(this.d);
      if (this.a.aM && !com.unionpay.mobile.android.model.b.bm) {
        textView.setTextColor(-1);
      } else {
        textView.setTextColor(-10066330);
      } 
      textView.setText(str1);
      textView.setTextSize(com.unionpay.mobile.android.global.b.k);
      this.r.addView((View)textView);
    } else {
      this.r.setVisibility(8);
    } 
    this.r.getViewTreeObserver().addOnPreDrawListener(new c(this));
    m m1 = new m(this.d);
    m1.a(this.c.a(1003), this.c.a(1001));
    if (this instanceof ao) {
      bool = false;
    } else {
      bool = true;
    } 
    m1.a(bool, this.a.h, this.a.i);
    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
    this.l.addView((View)m1, (ViewGroup.LayoutParams)layoutParams4);
    Drawable drawable = this.c.a(1026);
    LinearLayout linearLayout = new LinearLayout(this.d);
    if (drawable != null)
      linearLayout.setBackgroundDrawable(drawable); 
    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, g.a(this.d, 2.0F));
    this.l.addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams3);
  }
  
  protected final void g() {
    RelativeLayout relativeLayout = this.m;
  }
  
  public final int h() {
    return this.f;
  }
  
  protected final boolean i() {
    return (this.a.J || this.a.q == null || this.a.q.size() == 0);
  }
  
  protected final void j() {
    if (this.b != null && this.b.a())
      this.b.c(); 
  }
  
  public final void k() {
    d.a(this.d, this.a);
  }
  
  public void l() {
    if (this.j)
      n(); 
  }
  
  public final void m() {
    l();
  }
  
  public final void n() {
    ((BaseActivity)this.d).b();
  }
  
  protected final boolean o() {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (this.b != null) {
      bool2 = bool1;
      if (this.b.a())
        bool2 = true; 
    } 
    k.a("uppay", " dialog showing:" + bool2);
    return bool2;
  }
  
  protected void onAttachedToWindow() {
    k.b("uppayEx", toString() + " onAttachedToWindow()");
    super.onAttachedToWindow();
    this.e.a(this);
  }
  
  protected final boolean q() {
    return !this.a.c;
  }
  
  public final void r() {
    if (this.d != null)
      ((InputMethodManager)this.d.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0); 
  }
  
  public final void s() {
    if (a.L && !TextUtils.isEmpty(this.q) && this.w != null) {
      k.a("uppay-TD", "page start: " + this.q + "_View");
      UPAgent.onPageStart((Context)this.w, this.q + "_View");
    } 
  }
  
  public final void t() {
    if (a.L && !TextUtils.isEmpty(this.q) && this.w != null) {
      k.a("uppay-TD", "page end: " + this.q + "_View");
      UPAgent.onPageEnd((Context)this.w, this.q + "_View");
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */