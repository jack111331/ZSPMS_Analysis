package com.unionpay.mobile.android.upviews;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.upwidget.q;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.aa;
import com.unionpay.mobile.android.widgets.ah;
import com.unionpay.mobile.android.widgets.aj;
import com.unionpay.mobile.android.widgets.ap;
import com.unionpay.mobile.android.widgets.m;
import com.unionpay.mobile.android.widgets.p;
import com.unionpay.mobile.android.widgets.u;
import com.unionpay.mobile.android.widgets.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends LinearLayout implements q.a, aa.a, ah.a, aj.a, ap.a {
  private Context a = null;
  
  private m b = null;
  
  private ArrayList<z> c = null;
  
  private long d = 0L;
  
  private b e = null;
  
  private boolean f = false;
  
  private boolean g = true;
  
  private JSONObject h = null;
  
  private String i = "";
  
  public a(Context paramContext, JSONArray paramJSONArray, long paramLong, b paramb, String paramString1, boolean paramBoolean, String paramString2) {
    this(paramContext, paramJSONArray, paramLong, paramb, paramString1, paramBoolean, paramString2, (byte)0);
  }
  
  private a(Context paramContext, JSONArray paramJSONArray, long paramLong, b paramb, String paramString1, boolean paramBoolean, String paramString2, byte paramByte) {
    this(paramContext, paramJSONArray, paramLong, paramb, paramString1, paramBoolean, paramString2, false);
  }
  
  private a(Context paramContext, JSONArray paramJSONArray, long paramLong, b paramb, String paramString1, boolean paramBoolean, String paramString2, char paramChar) {
    this(paramContext, paramJSONArray, paramLong, paramb, paramString1, paramBoolean, false, (z)null, (JSONArray)null, paramString2);
  }
  
  public a(Context paramContext, JSONArray paramJSONArray1, long paramLong, b paramb, String paramString1, boolean paramBoolean1, boolean paramBoolean2, z paramz, JSONArray paramJSONArray2, String paramString2) {
    super(paramContext);
    this.a = paramContext;
    this.d = paramLong;
    this.e = paramb;
    this.f = paramBoolean2;
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = com.unionpay.mobile.android.global.a.f;
    layoutParams.bottomMargin = i;
    layoutParams.topMargin = i;
    setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    setPadding(0, 0, 0, 0);
    setOrientation(1);
    setBackgroundColor(0);
    a(paramJSONArray1, paramString1, paramBoolean1, paramz, paramJSONArray2, paramString2);
  }
  
  public a(Context paramContext, JSONArray paramJSONArray, b paramb, String paramString) {
    this(paramContext, paramJSONArray, -1L, paramb, (String)null, true, paramString);
  }
  
  private a a(boolean paramBoolean) {
    // Byte code:
    //   0: new com/unionpay/mobile/android/upviews/a$a
    //   3: dup
    //   4: aload_0
    //   5: ldc ''
    //   7: invokespecial <init> : (Lcom/unionpay/mobile/android/upviews/a;Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_0
    //   12: getfield c : Ljava/util/ArrayList;
    //   15: ifnull -> 164
    //   18: aload_0
    //   19: getfield c : Ljava/util/ArrayList;
    //   22: invokevirtual iterator : ()Ljava/util/Iterator;
    //   25: astore_3
    //   26: aload_3
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 164
    //   35: aload_3
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast com/unionpay/mobile/android/widgets/z
    //   44: astore #4
    //   46: aload #4
    //   48: instanceof com/unionpay/mobile/android/widgets/af
    //   51: ifeq -> 130
    //   54: aload #4
    //   56: invokevirtual c : ()Z
    //   59: ifne -> 92
    //   62: aload_2
    //   63: iconst_m1
    //   64: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   67: getfield aC : Ljava/lang/String;
    //   70: iconst_1
    //   71: anewarray java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   79: getfield aE : Ljava/lang/String;
    //   82: aastore
    //   83: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual a : (ILjava/lang/String;)V
    //   89: goto -> 26
    //   92: aload #4
    //   94: invokevirtual b : ()Z
    //   97: ifne -> 26
    //   100: aload_2
    //   101: iconst_m1
    //   102: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   105: getfield aD : Ljava/lang/String;
    //   108: iconst_1
    //   109: anewarray java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   117: getfield aE : Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   124: invokevirtual a : (ILjava/lang/String;)V
    //   127: goto -> 26
    //   130: aload #4
    //   132: invokevirtual c : ()Z
    //   135: ifne -> 173
    //   138: aload_2
    //   139: iconst_m1
    //   140: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   143: getfield aC : Ljava/lang/String;
    //   146: iconst_1
    //   147: anewarray java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload #4
    //   154: invokevirtual r : ()Ljava/lang/String;
    //   157: aastore
    //   158: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   161: invokevirtual a : (ILjava/lang/String;)V
    //   164: aload_2
    //   165: invokevirtual a : ()Z
    //   168: ifne -> 210
    //   171: aload_2
    //   172: areturn
    //   173: aload #4
    //   175: invokevirtual b : ()Z
    //   178: ifne -> 26
    //   181: aload_2
    //   182: iconst_m1
    //   183: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   186: getfield aD : Ljava/lang/String;
    //   189: iconst_1
    //   190: anewarray java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload #4
    //   197: invokevirtual r : ()Ljava/lang/String;
    //   200: aastore
    //   201: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   204: invokevirtual a : (ILjava/lang/String;)V
    //   207: goto -> 164
    //   210: new java/lang/StringBuffer
    //   213: dup
    //   214: invokespecial <init> : ()V
    //   217: astore_3
    //   218: aload_0
    //   219: getfield c : Ljava/util/ArrayList;
    //   222: ifnull -> 346
    //   225: iconst_0
    //   226: istore #5
    //   228: iload #5
    //   230: aload_0
    //   231: getfield c : Ljava/util/ArrayList;
    //   234: invokevirtual size : ()I
    //   237: if_icmpge -> 346
    //   240: aload_0
    //   241: getfield c : Ljava/util/ArrayList;
    //   244: iload #5
    //   246: invokevirtual get : (I)Ljava/lang/Object;
    //   249: checkcast com/unionpay/mobile/android/widgets/z
    //   252: astore #4
    //   254: aload #4
    //   256: instanceof com/unionpay/mobile/android/widgets/ad
    //   259: ifne -> 340
    //   262: aload #4
    //   264: instanceof com/unionpay/mobile/android/widgets/UPWidget
    //   267: ifeq -> 274
    //   270: iload_1
    //   271: ifeq -> 340
    //   274: aload_0
    //   275: getfield c : Ljava/util/ArrayList;
    //   278: iload #5
    //   280: invokevirtual get : (I)Ljava/lang/Object;
    //   283: checkcast com/unionpay/mobile/android/widgets/z
    //   286: invokevirtual h : ()Ljava/lang/String;
    //   289: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   292: ifne -> 340
    //   295: aload_0
    //   296: getfield c : Ljava/util/ArrayList;
    //   299: iload #5
    //   301: invokevirtual get : (I)Ljava/lang/Object;
    //   304: checkcast com/unionpay/mobile/android/widgets/z
    //   307: invokevirtual f : ()Z
    //   310: ifeq -> 340
    //   313: aload_3
    //   314: ldc ','
    //   316: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   319: pop
    //   320: aload_3
    //   321: aload_0
    //   322: getfield c : Ljava/util/ArrayList;
    //   325: iload #5
    //   327: invokevirtual get : (I)Ljava/lang/Object;
    //   330: checkcast com/unionpay/mobile/android/widgets/z
    //   333: invokevirtual h : ()Ljava/lang/String;
    //   336: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   339: pop
    //   340: iinc #5, 1
    //   343: goto -> 228
    //   346: aload_3
    //   347: invokevirtual toString : ()Ljava/lang/String;
    //   350: astore_3
    //   351: aload_3
    //   352: astore #4
    //   354: aload_3
    //   355: invokevirtual length : ()I
    //   358: iconst_1
    //   359: if_icmple -> 369
    //   362: aload_3
    //   363: iconst_1
    //   364: invokevirtual substring : (I)Ljava/lang/String;
    //   367: astore #4
    //   369: aload_2
    //   370: iconst_0
    //   371: aload #4
    //   373: invokevirtual a : (ILjava/lang/String;)V
    //   376: goto -> 171
  }
  
  private static z a(List<z> paramList, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface iterator : ()Ljava/util/Iterator;
    //   6: astore_2
    //   7: aload_2
    //   8: invokeinterface hasNext : ()Z
    //   13: ifeq -> 39
    //   16: aload_2
    //   17: invokeinterface next : ()Ljava/lang/Object;
    //   22: checkcast com/unionpay/mobile/android/widgets/z
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual n : ()Ljava/lang/String;
    //   30: aload_1
    //   31: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   34: ifeq -> 7
    //   37: aload_0
    //   38: areturn
    //   39: aconst_null
    //   40: astore_0
    //   41: goto -> 37
  }
  
  public final a a() {
    a a1 = new a(this, "");
    z z = a(this.c, "pin");
    if (z != null) {
      if (!z.c()) {
        a1.a(-1, String.format(c.bD.aC, new Object[] { z.r() }));
      } else if (!z.b()) {
        a1.a(-1, String.format(c.bD.aD, new Object[] { z.r() }));
      } 
      if (a1.a())
        a1.b = z.a(); 
    } 
    return a1;
  }
  
  public final String a(String paramString) {
    z z = a(this.c, paramString);
    String str = "";
    if (z != null)
      str = z.h(); 
    k.a("uppay", " name:" + paramString + ", value:" + str);
    return str;
  }
  
  public final void a(int paramInt) {
    z z = a(this.c, "sms");
    if (z != null)
      ((ap)z).a(paramInt); 
  }
  
  public final void a(View.OnClickListener paramOnClickListener) {
    z z = c("promotion");
    if (z != null && z instanceof aj)
      ((aj)z).b(paramOnClickListener); 
  }
  
  public final void a(m paramm, JSONObject paramJSONObject) {
    this.b = paramm;
    this.h = paramJSONObject;
  }
  
  public final void a(u paramu, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield e : Lcom/unionpay/mobile/android/upviews/a$b;
    //   4: ifnull -> 30
    //   7: aload_2
    //   8: ifnull -> 18
    //   11: aload_2
    //   12: invokevirtual length : ()I
    //   15: ifgt -> 31
    //   18: iconst_1
    //   19: istore_3
    //   20: aload_0
    //   21: getfield e : Lcom/unionpay/mobile/android/upviews/a$b;
    //   24: iload_3
    //   25: invokeinterface a : (Z)V
    //   30: return
    //   31: aload_0
    //   32: getfield c : Ljava/util/ArrayList;
    //   35: ifnull -> 102
    //   38: aload_0
    //   39: getfield c : Ljava/util/ArrayList;
    //   42: invokevirtual iterator : ()Ljava/util/Iterator;
    //   45: astore_2
    //   46: aload_2
    //   47: invokeinterface hasNext : ()Z
    //   52: ifeq -> 102
    //   55: aload_2
    //   56: invokeinterface next : ()Ljava/lang/Object;
    //   61: checkcast com/unionpay/mobile/android/widgets/z
    //   64: astore #4
    //   66: aload #4
    //   68: instanceof com/unionpay/mobile/android/widgets/aa
    //   71: ifeq -> 46
    //   74: aload #4
    //   76: checkcast com/unionpay/mobile/android/widgets/aa
    //   79: aload_1
    //   80: invokevirtual a : (Lcom/unionpay/mobile/android/widgets/u;)Z
    //   83: ifne -> 46
    //   86: aload #4
    //   88: checkcast com/unionpay/mobile/android/widgets/aa
    //   91: invokevirtual c : ()Z
    //   94: ifne -> 46
    //   97: iconst_1
    //   98: istore_3
    //   99: goto -> 20
    //   102: iconst_0
    //   103: istore_3
    //   104: goto -> 20
  }
  
  public final void a(z paramz) {
    boolean bool = paramz instanceof ap;
    if (this.e != null && bool) {
      d();
      a a1 = new a(this, "");
      z z1 = a(this.c, "mobile");
      z z2 = a(this.c, "pan");
      z z3 = a(this.c, "card");
      z z4 = a(this.c, "area_code");
      String str2 = "";
      String str1 = str2;
      if (z2 != null)
        if (!z2.c()) {
          a1.a(-1, String.format(c.bD.aC, new Object[] { c.bD.aE }));
          str1 = str2;
        } else if (!z2.b()) {
          a1.a(-1, String.format(c.bD.aD, new Object[] { c.bD.aE }));
          str1 = str2;
        } else {
          str1 = "" + z2.h();
        }  
      if (!a1.a()) {
        this.e.a(a1);
        return;
      } 
      str2 = str1;
      if (z1 != null)
        if (!z1.c()) {
          a1.a(-1, String.format(c.bD.aC, new Object[] { z1.r() }));
          str2 = str1;
        } else if (!z1.b()) {
          a1.a(-1, String.format(c.bD.aD, new Object[] { z1.r() }));
          str2 = str1;
        } else {
          StringBuilder stringBuilder = (new StringBuilder()).append(str1);
          if (str1.length() == 0) {
            str1 = "";
          } else {
            str1 = ",";
          } 
          str1 = stringBuilder.append(str1).toString();
          str2 = str1 + z1.h();
        }  
      if (!a1.a()) {
        this.e.a(a1);
        return;
      } 
      str1 = str2;
      if (z3 != null) {
        str1 = str2;
        if (z3.h().length() > 0) {
          StringBuilder stringBuilder = (new StringBuilder()).append(str2);
          if (str2.length() == 0) {
            str1 = "";
          } else {
            str1 = ",";
          } 
          str1 = stringBuilder.append(str1).toString();
          str1 = str1 + z3.h();
        } 
      } 
      str2 = str1;
      if (z4 != null) {
        str2 = str1;
        if (z4.h().length() > 0) {
          StringBuilder stringBuilder = (new StringBuilder()).append(str1);
          if (str1.length() == 0) {
            str1 = "";
          } else {
            str1 = ",";
          } 
          str1 = stringBuilder.append(str1).toString();
          str2 = str1 + z4.h();
        } 
      } 
      a1.a(0, str2);
      this.e.a(a1);
    } 
  }
  
  public final void a(String paramString1, String paramString2) {
    if (this.e != null) {
      d();
      this.e.c(paramString1, paramString2);
    } 
  }
  
  public final void a(String paramString, boolean paramBoolean) {
    String str;
    if ("promotion".equalsIgnoreCase(paramString)) {
      str = "instalment";
    } else {
      str = "promotion";
    } 
    z z1 = c(paramString);
    z z2 = c(str);
    if (z1 != null) {
      if (z1 instanceof aj) {
        ((aj)z1).a(paramBoolean);
        if (z2 != null && ((p)z2).g()) {
          Toast.makeText(this.a, this.i, 1).show();
          ((p)z2).b(false);
        } 
        return;
      } 
      if (z1 instanceof p) {
        if (paramBoolean)
          this.e.u(); 
        ((p)z1).b(paramBoolean);
      } 
    } 
  }
  
  public final void a(JSONArray paramJSONArray) {
    z z = c("promotion");
    if (z != null && z instanceof aj)
      ((aj)z).a(paramJSONArray); 
  }
  
  public final void a(JSONArray paramJSONArray, String paramString) {
    z z = c("promotion");
    if (z != null && z instanceof aj)
      ((aj)z).a(paramJSONArray, paramString); 
  }
  
  public final void a(JSONArray paramJSONArray1, String paramString1, boolean paramBoolean, z paramz, JSONArray paramJSONArray2, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 11
    //   4: aload_1
    //   5: invokevirtual length : ()I
    //   8: ifgt -> 12
    //   11: return
    //   12: aload_0
    //   13: getfield c : Ljava/util/ArrayList;
    //   16: ifnonnull -> 432
    //   19: aload_0
    //   20: new java/util/ArrayList
    //   23: dup
    //   24: iconst_1
    //   25: invokespecial <init> : (I)V
    //   28: putfield c : Ljava/util/ArrayList;
    //   31: aload_0
    //   32: invokevirtual removeAllViews : ()V
    //   35: aload_0
    //   36: iconst_m1
    //   37: invokevirtual setBackgroundColor : (I)V
    //   40: new android/widget/LinearLayout$LayoutParams
    //   43: dup
    //   44: iconst_m1
    //   45: bipush #-2
    //   47: invokespecial <init> : (II)V
    //   50: pop
    //   51: getstatic com/unionpay/mobile/android/global/a.f : I
    //   54: istore #7
    //   56: getstatic com/unionpay/mobile/android/global/a.I : I
    //   59: getstatic com/unionpay/mobile/android/global/a.f : I
    //   62: iconst_4
    //   63: imul
    //   64: isub
    //   65: istore #8
    //   67: iconst_0
    //   68: istore #7
    //   70: aconst_null
    //   71: astore #9
    //   73: ldc ''
    //   75: astore #10
    //   77: iload #7
    //   79: aload_1
    //   80: invokevirtual length : ()I
    //   83: if_icmpge -> 11
    //   86: aload_1
    //   87: iload #7
    //   89: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   92: astore #11
    //   94: aload #11
    //   96: ldc_w 'type'
    //   99: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   102: astore #12
    //   104: aload_0
    //   105: getfield a : Landroid/content/Context;
    //   108: astore #13
    //   110: aconst_null
    //   111: astore #10
    //   113: aload #11
    //   115: ldc_w 'type'
    //   118: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   121: astore #14
    //   123: ldc_w 'pan'
    //   126: aload #14
    //   128: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   131: ifeq -> 442
    //   134: new com/unionpay/mobile/android/widgets/af
    //   137: astore #10
    //   139: aload #10
    //   141: aload #13
    //   143: iload #8
    //   145: aload #11
    //   147: aload #6
    //   149: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   152: new android/widget/LinearLayout$LayoutParams
    //   155: astore #11
    //   157: aload #11
    //   159: iconst_m1
    //   160: bipush #-2
    //   162: invokespecial <init> : (II)V
    //   165: aload #10
    //   167: astore #9
    //   169: aload #12
    //   171: astore #10
    //   173: aload #11
    //   175: astore #12
    //   177: aload #9
    //   179: ifnull -> 422
    //   182: aload #9
    //   184: instanceof com/unionpay/mobile/android/widgets/UPWidget
    //   187: ifeq -> 1024
    //   190: aload #9
    //   192: checkcast com/unionpay/mobile/android/widgets/UPWidget
    //   195: aload_0
    //   196: getfield d : J
    //   199: invokevirtual a : (J)V
    //   202: aload #9
    //   204: checkcast com/unionpay/mobile/android/widgets/UPWidget
    //   207: aload_2
    //   208: invokevirtual b : (Ljava/lang/String;)V
    //   211: aload #9
    //   213: checkcast com/unionpay/mobile/android/widgets/UPWidget
    //   216: iload_3
    //   217: invokevirtual b : (Z)V
    //   220: aload #9
    //   222: instanceof com/unionpay/mobile/android/widgets/aa
    //   225: ifeq -> 245
    //   228: aload #9
    //   230: instanceof com/unionpay/mobile/android/widgets/bd
    //   233: ifne -> 245
    //   236: aload #9
    //   238: checkcast com/unionpay/mobile/android/widgets/aa
    //   241: aload_0
    //   242: invokevirtual a : (Lcom/unionpay/mobile/android/widgets/aa$a;)V
    //   245: ldc_w 'instalment'
    //   248: aload #10
    //   250: invokevirtual equals : (Ljava/lang/Object;)Z
    //   253: ifne -> 412
    //   256: new android/widget/LinearLayout
    //   259: dup
    //   260: aload_0
    //   261: getfield a : Landroid/content/Context;
    //   264: invokespecial <init> : (Landroid/content/Context;)V
    //   267: astore #13
    //   269: aload #13
    //   271: ldc_w -3419943
    //   274: invokevirtual setBackgroundColor : (I)V
    //   277: new android/widget/LinearLayout$LayoutParams
    //   280: dup
    //   281: iconst_m1
    //   282: iconst_1
    //   283: invokespecial <init> : (II)V
    //   286: astore #11
    //   288: iload #7
    //   290: ifeq -> 1064
    //   293: aload #11
    //   295: aload_0
    //   296: getfield a : Landroid/content/Context;
    //   299: ldc_w 10.0
    //   302: invokestatic a : (Landroid/content/Context;F)I
    //   305: putfield leftMargin : I
    //   308: aload_0
    //   309: getfield f : Z
    //   312: ifeq -> 1097
    //   315: iload #7
    //   317: ifne -> 1097
    //   320: aload #4
    //   322: ifnull -> 1097
    //   325: aload_0
    //   326: aload #4
    //   328: aload #12
    //   330: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   333: aload #9
    //   335: invokevirtual getVisibility : ()I
    //   338: ifne -> 349
    //   341: aload_0
    //   342: aload #13
    //   344: aload #11
    //   346: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   349: aload_0
    //   350: aload #9
    //   352: aload #12
    //   354: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   357: iload #7
    //   359: aload_1
    //   360: invokevirtual length : ()I
    //   363: iconst_1
    //   364: isub
    //   365: if_icmpeq -> 376
    //   368: aload #9
    //   370: instanceof com/unionpay/mobile/android/widgets/aj
    //   373: ifeq -> 412
    //   376: new android/widget/LinearLayout
    //   379: dup
    //   380: aload_0
    //   381: getfield a : Landroid/content/Context;
    //   384: invokespecial <init> : (Landroid/content/Context;)V
    //   387: astore #11
    //   389: aload #11
    //   391: ldc_w -3419943
    //   394: invokevirtual setBackgroundColor : (I)V
    //   397: aload_0
    //   398: aload #11
    //   400: new android/widget/LinearLayout$LayoutParams
    //   403: dup
    //   404: iconst_m1
    //   405: iconst_1
    //   406: invokespecial <init> : (II)V
    //   409: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   412: aload_0
    //   413: getfield c : Ljava/util/ArrayList;
    //   416: aload #9
    //   418: invokevirtual add : (Ljava/lang/Object;)Z
    //   421: pop
    //   422: iinc #7, 1
    //   425: aload #12
    //   427: astore #9
    //   429: goto -> 77
    //   432: aload_0
    //   433: getfield c : Ljava/util/ArrayList;
    //   436: invokevirtual clear : ()V
    //   439: goto -> 31
    //   442: ldc_w 'mobile'
    //   445: aload #14
    //   447: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   450: ifeq -> 506
    //   453: new com/unionpay/mobile/android/widgets/ah
    //   456: dup
    //   457: aload #13
    //   459: iload #8
    //   461: aload #11
    //   463: aload #6
    //   465: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   468: astore #10
    //   470: goto -> 152
    //   473: astore #10
    //   475: aconst_null
    //   476: astore #10
    //   478: ldc 'uppay'
    //   480: ldc_w 'json parser exception!!! - UPRuleView'
    //   483: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   486: pop
    //   487: aload #9
    //   489: astore #11
    //   491: aload #10
    //   493: astore #9
    //   495: aload #12
    //   497: astore #10
    //   499: aload #11
    //   501: astore #12
    //   503: goto -> 177
    //   506: ldc_w 'sms'
    //   509: aload #14
    //   511: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   514: ifeq -> 538
    //   517: new com/unionpay/mobile/android/widgets/ap
    //   520: dup
    //   521: aload #13
    //   523: iload #8
    //   525: aload #11
    //   527: aload #6
    //   529: iconst_0
    //   530: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;B)V
    //   533: astore #10
    //   535: goto -> 152
    //   538: ldc_w 'cvn2'
    //   541: aload #14
    //   543: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   546: ifeq -> 569
    //   549: new com/unionpay/mobile/android/widgets/e
    //   552: dup
    //   553: aload #13
    //   555: iload #8
    //   557: aload #11
    //   559: aload #6
    //   561: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   564: astore #10
    //   566: goto -> 152
    //   569: ldc_w 'expire'
    //   572: aload #14
    //   574: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   577: ifeq -> 600
    //   580: new com/unionpay/mobile/android/widgets/av
    //   583: dup
    //   584: aload #13
    //   586: iload #8
    //   588: aload #11
    //   590: aload #6
    //   592: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   595: astore #10
    //   597: goto -> 152
    //   600: ldc_w 'pwd'
    //   603: aload #14
    //   605: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   608: ifeq -> 635
    //   611: new com/unionpay/mobile/android/widgets/UPWidget
    //   614: dup
    //   615: aload #13
    //   617: aload_0
    //   618: getfield d : J
    //   621: iload #8
    //   623: aload #11
    //   625: aload #6
    //   627: invokespecial <init> : (Landroid/content/Context;JILorg/json/JSONObject;Ljava/lang/String;)V
    //   630: astore #10
    //   632: goto -> 152
    //   635: ldc_w 'text'
    //   638: aload #14
    //   640: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   643: ifeq -> 666
    //   646: new com/unionpay/mobile/android/widgets/at
    //   649: dup
    //   650: aload #13
    //   652: iload #8
    //   654: aload #11
    //   656: aload #6
    //   658: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   661: astore #10
    //   663: goto -> 152
    //   666: ldc_w 'string'
    //   669: aload #14
    //   671: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   674: ifeq -> 695
    //   677: new com/unionpay/mobile/android/widgets/ad
    //   680: dup
    //   681: aload #13
    //   683: aload #11
    //   685: aload #6
    //   687: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   690: astore #10
    //   692: goto -> 152
    //   695: ldc_w 'cert_id'
    //   698: aload #14
    //   700: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   703: ifeq -> 726
    //   706: new com/unionpay/mobile/android/widgets/f
    //   709: dup
    //   710: aload #13
    //   712: iload #8
    //   714: aload #11
    //   716: aload #6
    //   718: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   721: astore #10
    //   723: goto -> 152
    //   726: ldc_w 'cert_type'
    //   729: aload #14
    //   731: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   734: ifeq -> 755
    //   737: new com/unionpay/mobile/android/widgets/g
    //   740: dup
    //   741: aload #13
    //   743: aload #11
    //   745: aload #6
    //   747: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   750: astore #10
    //   752: goto -> 152
    //   755: ldc_w 'name'
    //   758: aload #14
    //   760: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   763: ifeq -> 786
    //   766: new com/unionpay/mobile/android/widgets/ae
    //   769: dup
    //   770: aload #13
    //   772: iload #8
    //   774: aload #11
    //   776: aload #6
    //   778: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   781: astore #10
    //   783: goto -> 152
    //   786: ldc_w 'hidden'
    //   789: aload #14
    //   791: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   794: ifeq -> 815
    //   797: new com/unionpay/mobile/android/widgets/y
    //   800: dup
    //   801: aload #13
    //   803: aload #11
    //   805: aload #6
    //   807: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   810: astore #10
    //   812: goto -> 152
    //   815: ldc_w 'user_name'
    //   818: aload #14
    //   820: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   823: ifeq -> 846
    //   826: new com/unionpay/mobile/android/widgets/au
    //   829: dup
    //   830: aload #13
    //   832: iload #8
    //   834: aload #11
    //   836: aload #6
    //   838: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   841: astore #10
    //   843: goto -> 152
    //   846: ldc_w 'password'
    //   849: aload #14
    //   851: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   854: ifeq -> 877
    //   857: new com/unionpay/mobile/android/widgets/ao
    //   860: dup
    //   861: aload #13
    //   863: iload #8
    //   865: aload #11
    //   867: aload #6
    //   869: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   872: astore #10
    //   874: goto -> 152
    //   877: ldc_w 'point'
    //   880: aload #14
    //   882: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   885: ifeq -> 908
    //   888: new com/unionpay/mobile/android/widgets/bd
    //   891: dup
    //   892: aload #13
    //   894: iload #8
    //   896: aload #11
    //   898: aload #6
    //   900: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   903: astore #10
    //   905: goto -> 152
    //   908: ldc_w 'instalment'
    //   911: aload #14
    //   913: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   916: ifeq -> 949
    //   919: new com/unionpay/mobile/android/widgets/p
    //   922: astore #10
    //   924: aload #10
    //   926: aload_0
    //   927: getfield a : Landroid/content/Context;
    //   930: aload #11
    //   932: aload #6
    //   934: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   937: aload #10
    //   939: checkcast com/unionpay/mobile/android/widgets/p
    //   942: aload_0
    //   943: invokevirtual a : (Lcom/unionpay/mobile/android/upwidget/q$a;)V
    //   946: goto -> 152
    //   949: ldc_w 'promotion'
    //   952: aload #14
    //   954: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   957: ifeq -> 991
    //   960: new com/unionpay/mobile/android/widgets/aj
    //   963: astore #10
    //   965: aload #10
    //   967: aload_0
    //   968: getfield a : Landroid/content/Context;
    //   971: aload #11
    //   973: aload #6
    //   975: aload_0
    //   976: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;Ljava/lang/String;Lcom/unionpay/mobile/android/widgets/aj$a;)V
    //   979: aload #10
    //   981: checkcast com/unionpay/mobile/android/widgets/aj
    //   984: aload_0
    //   985: invokevirtual a : (Lcom/unionpay/mobile/android/upwidget/q$a;)V
    //   988: goto -> 152
    //   991: ldc_w 'area_code'
    //   994: aload #14
    //   996: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   999: ifeq -> 152
    //   1002: new com/unionpay/mobile/android/widgets/a
    //   1005: dup
    //   1006: aload_0
    //   1007: getfield a : Landroid/content/Context;
    //   1010: aload #11
    //   1012: aload #5
    //   1014: aload #6
    //   1016: invokespecial <init> : (Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONArray;Ljava/lang/String;)V
    //   1019: astore #10
    //   1021: goto -> 152
    //   1024: aload #9
    //   1026: instanceof com/unionpay/mobile/android/widgets/ap
    //   1029: ifeq -> 1044
    //   1032: aload #9
    //   1034: checkcast com/unionpay/mobile/android/widgets/ap
    //   1037: aload_0
    //   1038: invokevirtual a : (Lcom/unionpay/mobile/android/widgets/ap$a;)V
    //   1041: goto -> 220
    //   1044: aload #9
    //   1046: instanceof com/unionpay/mobile/android/widgets/ah
    //   1049: ifeq -> 220
    //   1052: aload #9
    //   1054: checkcast com/unionpay/mobile/android/widgets/ah
    //   1057: aload_0
    //   1058: invokevirtual a : (Lcom/unionpay/mobile/android/widgets/ah$a;)V
    //   1061: goto -> 220
    //   1064: aload_0
    //   1065: getfield f : Z
    //   1068: ifeq -> 308
    //   1071: aload #11
    //   1073: aload_0
    //   1074: getfield a : Landroid/content/Context;
    //   1077: ldc_w 10.0
    //   1080: invokestatic a : (Landroid/content/Context;F)I
    //   1083: putfield leftMargin : I
    //   1086: aload_0
    //   1087: iconst_0
    //   1088: iconst_0
    //   1089: iconst_0
    //   1090: iconst_0
    //   1091: invokevirtual setPadding : (IIII)V
    //   1094: goto -> 308
    //   1097: aload #9
    //   1099: invokevirtual getVisibility : ()I
    //   1102: ifne -> 357
    //   1105: aload_0
    //   1106: aload #13
    //   1108: aload #11
    //   1110: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1113: aload_0
    //   1114: aload #9
    //   1116: aload #12
    //   1118: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1121: aload #9
    //   1123: instanceof com/unionpay/mobile/android/widgets/af
    //   1126: ifeq -> 357
    //   1129: aload #4
    //   1131: ifnull -> 357
    //   1134: aload_0
    //   1135: aload #4
    //   1137: aload #12
    //   1139: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1142: goto -> 357
    //   1145: astore #12
    //   1147: aload #10
    //   1149: astore #12
    //   1151: aconst_null
    //   1152: astore #10
    //   1154: goto -> 478
    //   1157: astore #11
    //   1159: goto -> 478
    // Exception table:
    //   from	to	target	type
    //   86	104	1145	org/json/JSONException
    //   104	110	473	org/json/JSONException
    //   113	152	473	org/json/JSONException
    //   152	165	1157	org/json/JSONException
    //   442	470	473	org/json/JSONException
    //   506	535	473	org/json/JSONException
    //   538	566	473	org/json/JSONException
    //   569	597	473	org/json/JSONException
    //   600	632	473	org/json/JSONException
    //   635	663	473	org/json/JSONException
    //   666	692	473	org/json/JSONException
    //   695	723	473	org/json/JSONException
    //   726	752	473	org/json/JSONException
    //   755	783	473	org/json/JSONException
    //   786	812	473	org/json/JSONException
    //   815	843	473	org/json/JSONException
    //   846	874	473	org/json/JSONException
    //   877	905	473	org/json/JSONException
    //   908	946	473	org/json/JSONException
    //   949	988	473	org/json/JSONException
    //   991	1021	473	org/json/JSONException
  }
  
  public final void a(JSONObject paramJSONObject) {
    if (paramJSONObject != null) {
      String str = j.a(paramJSONObject, "instalment_empty_info");
      if (!TextUtils.isEmpty(str)) {
        ((p)c("instalment")).a(false);
        ((p)c("instalment")).b(false);
        Toast.makeText(this.a, str, 1).show();
        return;
      } 
      ((p)c("instalment")).a(true);
      ((p)c("instalment")).b(true);
      ((p)a(this.c, "instalment_policy")).a(j.d(paramJSONObject, "new_instalments"));
    } 
  }
  
  public final a b() {
    return a(true);
  }
  
  public final String b(String paramString) {
    z z = a(this.c, paramString);
    paramString = "";
    if (z != null)
      paramString = z.a(); 
    return paramString;
  }
  
  public final void b(View.OnClickListener paramOnClickListener) {
    z z = c("promotion");
    if (z != null && z instanceof aj)
      ((aj)z).c(paramOnClickListener); 
  }
  
  public final z c(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Ljava/util/ArrayList;
    //   4: ifnull -> 24
    //   7: aload_0
    //   8: getfield c : Ljava/util/ArrayList;
    //   11: invokevirtual size : ()I
    //   14: ifle -> 24
    //   17: aload_1
    //   18: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   21: ifeq -> 28
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: getfield c : Ljava/util/ArrayList;
    //   32: invokevirtual iterator : ()Ljava/util/Iterator;
    //   35: astore_2
    //   36: aload_2
    //   37: invokeinterface hasNext : ()Z
    //   42: ifeq -> 71
    //   45: aload_2
    //   46: invokeinterface next : ()Ljava/lang/Object;
    //   51: checkcast com/unionpay/mobile/android/widgets/z
    //   54: astore_3
    //   55: aload_3
    //   56: invokevirtual o : ()Ljava/lang/String;
    //   59: aload_1
    //   60: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   63: ifeq -> 36
    //   66: aload_3
    //   67: astore_1
    //   68: goto -> 26
    //   71: aconst_null
    //   72: astore_1
    //   73: goto -> 26
  }
  
  public final HashMap<String, String> c() {
    if (!a(false).a())
      return null; 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (this.c != null) {
      byte b1 = 0;
      while (true) {
        if (b1 < this.c.size()) {
          z z = this.c.get(b1);
          if (!(z instanceof com.unionpay.mobile.android.widgets.ad) && !(z instanceof com.unionpay.mobile.android.widgets.UPWidget) && !TextUtils.isEmpty(z.a()))
            hashMap.put(z.n(), z.a()); 
          b1++;
          continue;
        } 
        return (HashMap)hashMap;
      } 
    } 
    return (HashMap)hashMap;
  }
  
  public final void c(View.OnClickListener paramOnClickListener) {
    z z = c("promotion");
    if (z != null && z instanceof aj)
      ((aj)z).a(paramOnClickListener); 
  }
  
  public final void d(String paramString) {
    this.i = paramString;
  }
  
  public final boolean d() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Ljava/util/ArrayList;
    //   4: ifnull -> 84
    //   7: aload_0
    //   8: getfield c : Ljava/util/ArrayList;
    //   11: invokevirtual iterator : ()Ljava/util/Iterator;
    //   14: astore_1
    //   15: aload_1
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 84
    //   24: aload_1
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: checkcast com/unionpay/mobile/android/widgets/z
    //   33: astore_2
    //   34: aload_2
    //   35: instanceof com/unionpay/mobile/android/widgets/UPWidget
    //   38: ifeq -> 15
    //   41: aload_2
    //   42: checkcast com/unionpay/mobile/android/widgets/UPWidget
    //   45: invokevirtual j : ()Z
    //   48: ifeq -> 15
    //   51: aload_2
    //   52: checkcast com/unionpay/mobile/android/widgets/UPWidget
    //   55: invokevirtual k : ()V
    //   58: iconst_1
    //   59: istore_3
    //   60: aload_0
    //   61: getfield a : Landroid/content/Context;
    //   64: ldc_w 'input_method'
    //   67: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   70: checkcast android/view/inputmethod/InputMethodManager
    //   73: aload_0
    //   74: invokevirtual getWindowToken : ()Landroid/os/IBinder;
    //   77: iconst_0
    //   78: invokevirtual hideSoftInputFromWindow : (Landroid/os/IBinder;I)Z
    //   81: pop
    //   82: iload_3
    //   83: ireturn
    //   84: iconst_0
    //   85: istore_3
    //   86: goto -> 60
  }
  
  public final void e(String paramString) {
    if (this.e != null)
      this.e.c(paramString); 
  }
  
  public final boolean e() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Ljava/util/ArrayList;
    //   4: ifnull -> 63
    //   7: aload_0
    //   8: getfield c : Ljava/util/ArrayList;
    //   11: invokevirtual iterator : ()Ljava/util/Iterator;
    //   14: astore_1
    //   15: aload_1
    //   16: invokeinterface hasNext : ()Z
    //   21: ifeq -> 63
    //   24: aload_1
    //   25: invokeinterface next : ()Ljava/lang/Object;
    //   30: checkcast com/unionpay/mobile/android/widgets/z
    //   33: astore_2
    //   34: aload_2
    //   35: instanceof com/unionpay/mobile/android/widgets/aa
    //   38: ifeq -> 15
    //   41: aload_2
    //   42: checkcast com/unionpay/mobile/android/widgets/aa
    //   45: invokevirtual c : ()Z
    //   48: ifne -> 15
    //   51: iconst_1
    //   52: istore_3
    //   53: iload_3
    //   54: ifne -> 68
    //   57: iconst_1
    //   58: istore #4
    //   60: iload #4
    //   62: ireturn
    //   63: iconst_0
    //   64: istore_3
    //   65: goto -> 53
    //   68: iconst_0
    //   69: istore #4
    //   71: goto -> 60
  }
  
  public final void f() {
    if (this.c != null && this.c.size() > 0) {
      Iterator<z> iterator = this.c.iterator();
      while (true) {
        if (iterator.hasNext()) {
          z z = iterator.next();
          if (z instanceof com.unionpay.mobile.android.widgets.UPWidget || z instanceof com.unionpay.mobile.android.widgets.e || z instanceof com.unionpay.mobile.android.widgets.av)
            ((aa)z).g(); 
          continue;
        } 
        return;
      } 
    } 
  }
  
  public final void g() {
    z z = c("instalment");
    if (z != null && ((p)z).g()) {
      Toast.makeText(this.a, this.i, 1).show();
      ((p)z).b(false);
    } 
  }
  
  public final class a {
    public int a = 0;
    
    public String b;
    
    a(a this$0, String param1String) {
      this.b = param1String;
    }
    
    public final void a(int param1Int, String param1String) {
      this.b = param1String;
      this.a = param1Int;
    }
    
    public final boolean a() {
      return (this.a == 0);
    }
  }
  
  public static interface b {
    void a(a.a param1a);
    
    void a(boolean param1Boolean);
    
    void c(String param1String);
    
    void c(String param1String1, String param1String2);
    
    void u();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\upviews\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */