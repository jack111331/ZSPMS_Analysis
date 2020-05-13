package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.model.d;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.f;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.p;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.views.order.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class ao extends b implements a.b {
  private Handler A = new Handler(new ap(this));
  
  List<Map<String, Object>> r = new ArrayList<Map<String, Object>>(1);
  
  private int s = 0;
  
  private int t = -1;
  
  private Button u = null;
  
  private a v = null;
  
  private o w;
  
  private LinearLayout x;
  
  private boolean y = false;
  
  private Handler z = null;
  
  public ao(Context paramContext, e parame) {
    super(paramContext, parame);
    if (this.a.aE && this.a.az)
      this.a.aP = l.e.intValue(); 
    this.q = "order";
    setBackgroundColor(-1052684);
    int i = this.a.ah;
    e();
    if (!TextUtils.isEmpty(this.a.u) || this.a.aC)
      this.z = new Handler(new aq(this)); 
    if (!b.bl && this.a.aP == l.e.intValue() && this.a.az && !this.a.aC && !this.a.aD) {
      Message message = this.A.obtainMessage(500);
      this.A.sendMessageDelayed(message, 8000L);
      k.c("uppay", "mHceHandler.sendMessageDelayed(msg, 8000)");
    } 
  }
  
  private static Map<String, Object> b(d paramd) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    String str = paramd.a().substring(0, 4) + " **** " + paramd.a().substring(paramd.a().length() - 4);
    hashMap.put("text1", paramd.b() + paramd.c());
    hashMap.put("text2", str);
    return (Map)hashMap;
  }
  
  private void d(JSONObject paramJSONObject) {
    int i = f.a(this.a, paramJSONObject, false);
    if (i != 0) {
      b(i);
    } else {
      e e = f.a(paramJSONObject);
      if (this.a.z != null && this.a.z.length() > 0) {
        a(6, e);
      } else if (this.a.D != null && this.a.D.length() > 0) {
        d(5);
      } 
    } 
    this.s = 0;
  }
  
  private void e(JSONObject paramJSONObject) {
    int i = f.b(this.a, paramJSONObject);
    if (i != 0) {
      b(i);
      return;
    } 
    String str = j.a(paramJSONObject, "userId");
    if (!TextUtils.isEmpty(str))
      a(this.d, "_login", p.e, new Object[] { str }); 
    if (this.w != null) {
      str = this.w.b();
      if (!TextUtils.isEmpty(str))
        PreferenceUtils.d(this.d, str); 
    } 
    a(13, f.a(paramJSONObject));
    this.s = 0;
  }
  
  private void y() {
    if (this.a.aP == l.e.intValue() && this.a.az && !this.a.aC && !this.a.aD) {
      this.A.removeMessages(500);
      k.c("uppay", "mHceHandler remove Message");
    } 
  }
  
  protected void a(Handler paramHandler) {}
  
  protected final void a(com.unionpay.mobile.android.model.a parama) {
    this.a.br = true;
    this.a.bs = (c)parama;
    this.s = 2;
    this.b.a(c.bD.U);
    this.a.M = "0";
    String str = bh.b(this.a.M, "\"pan\":\"" + parama.b() + "\"", "2", "1\",\"carrier_tp\":\"10");
    this.e.c(bh.a(this.a.j), str);
  }
  
  public final void a(a.a parama) {}
  
  public final void a(JSONObject paramJSONObject) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Lcom/unionpay/mobile/android/widgets/m;
    //   4: invokevirtual c : ()V
    //   7: aload_0
    //   8: getfield s : I
    //   11: tableswitch default -> 48, 1 -> 65, 2 -> 49, 3 -> 137, 4 -> 294, 5 -> 310, 6 -> 405
    //   48: return
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual b : (Lorg/json/JSONObject;)Z
    //   54: ifne -> 48
    //   57: aload_0
    //   58: aload_1
    //   59: invokespecial d : (Lorg/json/JSONObject;)V
    //   62: goto -> 48
    //   65: aload_0
    //   66: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   69: astore_2
    //   70: aload_2
    //   71: aload_1
    //   72: ldc_w 'login_rules'
    //   75: invokestatic d : (Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONArray;
    //   78: putfield X : Lorg/json/JSONArray;
    //   81: aload_2
    //   82: aload_1
    //   83: ldc_w 'register_url'
    //   86: invokestatic c : (Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   89: putfield Y : Lorg/json/JSONObject;
    //   92: aload_2
    //   93: getfield X : Lorg/json/JSONArray;
    //   96: ifnull -> 109
    //   99: aload_2
    //   100: getfield X : Lorg/json/JSONArray;
    //   103: invokevirtual length : ()I
    //   106: ifgt -> 453
    //   109: iconst_2
    //   110: istore_3
    //   111: iload_3
    //   112: ifeq -> 128
    //   115: aload_0
    //   116: iconst_2
    //   117: invokevirtual b : (I)V
    //   120: aload_0
    //   121: iconst_0
    //   122: putfield s : I
    //   125: goto -> 48
    //   128: aload_0
    //   129: bipush #12
    //   131: invokevirtual d : (I)V
    //   134: goto -> 120
    //   137: aload_0
    //   138: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   141: astore_1
    //   142: aload_0
    //   143: getfield t : I
    //   146: istore_3
    //   147: aload_1
    //   148: getfield q : Ljava/util/List;
    //   151: ifnull -> 178
    //   154: iload_3
    //   155: aload_1
    //   156: getfield q : Ljava/util/List;
    //   159: invokeinterface size : ()I
    //   164: if_icmpge -> 178
    //   167: aload_1
    //   168: getfield q : Ljava/util/List;
    //   171: iload_3
    //   172: invokeinterface remove : (I)Ljava/lang/Object;
    //   177: pop
    //   178: aload_0
    //   179: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   182: getfield q : Ljava/util/List;
    //   185: ifnull -> 279
    //   188: aload_0
    //   189: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   192: getfield q : Ljava/util/List;
    //   195: invokeinterface size : ()I
    //   200: ifle -> 279
    //   203: aload_0
    //   204: getfield t : I
    //   207: aload_0
    //   208: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   211: getfield N : I
    //   214: if_icmpne -> 247
    //   217: aload_0
    //   218: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   221: iconst_0
    //   222: putfield N : I
    //   225: aload_0
    //   226: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   229: aload_0
    //   230: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   233: getfield N : I
    //   236: invokevirtual c : (I)V
    //   239: aload_0
    //   240: iconst_0
    //   241: putfield s : I
    //   244: goto -> 48
    //   247: aload_0
    //   248: getfield t : I
    //   251: aload_0
    //   252: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   255: getfield N : I
    //   258: if_icmpge -> 225
    //   261: aload_0
    //   262: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   265: astore_1
    //   266: aload_1
    //   267: aload_1
    //   268: getfield N : I
    //   271: iconst_1
    //   272: isub
    //   273: putfield N : I
    //   276: goto -> 225
    //   279: aload_0
    //   280: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   283: iconst_m1
    //   284: putfield N : I
    //   287: aload_0
    //   288: invokevirtual c : ()V
    //   291: goto -> 239
    //   294: aload_0
    //   295: aload_1
    //   296: invokevirtual b : (Lorg/json/JSONObject;)Z
    //   299: ifne -> 48
    //   302: aload_0
    //   303: aload_1
    //   304: invokespecial e : (Lorg/json/JSONObject;)V
    //   307: goto -> 48
    //   310: aload_0
    //   311: invokevirtual j : ()V
    //   314: aload_0
    //   315: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   318: aload_1
    //   319: iconst_0
    //   320: invokestatic a : (Lcom/unionpay/mobile/android/model/b;Lorg/json/JSONObject;Z)I
    //   323: istore_3
    //   324: iload_3
    //   325: ifeq -> 336
    //   328: aload_0
    //   329: iload_3
    //   330: invokevirtual b : (I)V
    //   333: goto -> 48
    //   336: aload_1
    //   337: invokestatic a : (Lorg/json/JSONObject;)Lcom/unionpay/mobile/android/model/e;
    //   340: astore_1
    //   341: aload_0
    //   342: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   345: getfield z : Lorg/json/JSONArray;
    //   348: ifnull -> 374
    //   351: aload_0
    //   352: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   355: getfield z : Lorg/json/JSONArray;
    //   358: invokevirtual length : ()I
    //   361: ifle -> 374
    //   364: aload_0
    //   365: bipush #6
    //   367: aload_1
    //   368: invokevirtual a : (ILcom/unionpay/mobile/android/model/e;)V
    //   371: goto -> 48
    //   374: aload_0
    //   375: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   378: getfield D : Lorg/json/JSONArray;
    //   381: ifnull -> 48
    //   384: aload_0
    //   385: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   388: getfield D : Lorg/json/JSONArray;
    //   391: invokevirtual length : ()I
    //   394: ifle -> 48
    //   397: aload_0
    //   398: iconst_5
    //   399: invokevirtual d : (I)V
    //   402: goto -> 48
    //   405: aload_0
    //   406: getfield b : Lcom/unionpay/mobile/android/widgets/m;
    //   409: invokevirtual c : ()V
    //   412: aload_0
    //   413: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   416: aload_1
    //   417: iconst_0
    //   418: invokestatic a : (Lcom/unionpay/mobile/android/model/b;Lorg/json/JSONObject;Z)I
    //   421: istore_3
    //   422: iload_3
    //   423: ifeq -> 434
    //   426: aload_0
    //   427: iload_3
    //   428: invokevirtual b : (I)V
    //   431: goto -> 48
    //   434: aload_1
    //   435: invokestatic a : (Lorg/json/JSONObject;)Lcom/unionpay/mobile/android/model/e;
    //   438: astore_1
    //   439: aload_0
    //   440: invokespecial y : ()V
    //   443: aload_0
    //   444: bipush #18
    //   446: aload_1
    //   447: invokevirtual a : (ILcom/unionpay/mobile/android/model/e;)V
    //   450: goto -> 48
    //   453: iconst_0
    //   454: istore_3
    //   455: goto -> 111
  }
  
  public final void a(boolean paramBoolean) {
    if (this.u != null && this.u != null) {
      Button button = this.u;
      if (!paramBoolean) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      button.setEnabled(paramBoolean);
    } 
  }
  
  protected final void b() {
    // Byte code:
    //   0: new android/widget/RelativeLayout$LayoutParams
    //   3: dup
    //   4: iconst_m1
    //   5: bipush #-2
    //   7: invokespecial <init> : (II)V
    //   10: astore_1
    //   11: aload_0
    //   12: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   15: getfield o : Ljava/lang/String;
    //   18: astore_2
    //   19: new com/unionpay/mobile/android/widgets/ay
    //   22: dup
    //   23: aload_0
    //   24: getfield d : Landroid/content/Context;
    //   27: aload_2
    //   28: aload_0
    //   29: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Lcom/unionpay/mobile/android/widgets/ay$a;)V
    //   32: astore_3
    //   33: aload_0
    //   34: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   37: getfield J : Z
    //   40: ifne -> 230
    //   43: aload_0
    //   44: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   47: getfield aE : Z
    //   50: ifeq -> 69
    //   53: aload_0
    //   54: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   57: getfield aP : I
    //   60: getstatic com/unionpay/mobile/android/views/order/l.e : Ljava/lang/Integer;
    //   63: invokevirtual intValue : ()I
    //   66: if_icmpeq -> 145
    //   69: aload_0
    //   70: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   73: getfield aP : I
    //   76: getstatic com/unionpay/mobile/android/views/order/l.a : Ljava/lang/Integer;
    //   79: invokevirtual intValue : ()I
    //   82: if_icmpeq -> 145
    //   85: aload_3
    //   86: astore #4
    //   88: aload_0
    //   89: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   92: getfield aP : I
    //   95: getstatic com/unionpay/mobile/android/views/order/l.c : Ljava/lang/Integer;
    //   98: invokevirtual intValue : ()I
    //   101: if_icmpne -> 180
    //   104: aload_3
    //   105: astore #4
    //   107: aload_0
    //   108: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   111: getfield aC : Z
    //   114: ifeq -> 180
    //   117: aload_0
    //   118: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   121: getfield q : Ljava/util/List;
    //   124: ifnull -> 145
    //   127: aload_3
    //   128: astore #4
    //   130: aload_0
    //   131: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   134: getfield q : Ljava/util/List;
    //   137: invokeinterface size : ()I
    //   142: ifgt -> 180
    //   145: new com/unionpay/mobile/android/widgets/ay
    //   148: dup
    //   149: aload_0
    //   150: getfield d : Landroid/content/Context;
    //   153: aload_2
    //   154: aload_0
    //   155: getfield c : Lcom/unionpay/mobile/android/resource/c;
    //   158: sipush #1030
    //   161: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   164: aload_0
    //   165: getfield d : Landroid/content/Context;
    //   168: ldc_w 20.0
    //   171: invokestatic a : (Landroid/content/Context;F)I
    //   174: aload_0
    //   175: invokespecial <init> : (Landroid/content/Context;Ljava/lang/String;Landroid/graphics/drawable/Drawable;ILcom/unionpay/mobile/android/widgets/ay$a;)V
    //   178: astore #4
    //   180: aload #4
    //   182: astore_3
    //   183: aload_0
    //   184: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   187: getfield aP : I
    //   190: getstatic com/unionpay/mobile/android/views/order/l.e : Ljava/lang/Integer;
    //   193: invokevirtual intValue : ()I
    //   196: if_icmpne -> 213
    //   199: aload #4
    //   201: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   204: getfield bq : Ljava/lang/String;
    //   207: invokevirtual a : (Ljava/lang/String;)V
    //   210: aload #4
    //   212: astore_3
    //   213: aload_1
    //   214: bipush #13
    //   216: iconst_m1
    //   217: invokevirtual addRule : (II)V
    //   220: aload_0
    //   221: getfield k : Landroid/widget/RelativeLayout;
    //   224: aload_3
    //   225: aload_1
    //   226: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   229: return
    //   230: aload_3
    //   231: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   234: getfield l : Ljava/lang/String;
    //   237: invokevirtual a : (Ljava/lang/String;)V
    //   240: goto -> 213
  }
  
  protected final void b(String paramString, JSONObject paramJSONObject) {
    if ("init".equals(paramString)) {
      if (this.a.J)
        n(); 
      return;
    } 
    if ("".equals(paramString)) {
      if (this.s == 2) {
        d(paramJSONObject);
        return;
      } 
      if (this.s == 4)
        e(paramJSONObject); 
      return;
    } 
    this.b.a(c.bD.U);
    this.j = false;
    this.s = 5;
    this.e.c(paramString, "");
  }
  
  protected final void c() {
    // Byte code:
    //   0: aload_0
    //   1: getfield m : Landroid/widget/RelativeLayout;
    //   4: invokevirtual removeAllViews : ()V
    //   7: aload_0
    //   8: getfield o : Lcom/unionpay/mobile/android/upwidget/UPScrollView;
    //   11: aload_0
    //   12: invokevirtual a : (Lcom/unionpay/mobile/android/upwidget/UPScrollView$a;)V
    //   15: aload_0
    //   16: getfield c : Lcom/unionpay/mobile/android/resource/c;
    //   19: sipush #2014
    //   22: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   25: astore_1
    //   26: aload_0
    //   27: getfield c : Lcom/unionpay/mobile/android/resource/c;
    //   30: sipush #1002
    //   33: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   36: astore_2
    //   37: aload_0
    //   38: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   41: getfield aP : I
    //   44: getstatic com/unionpay/mobile/android/views/order/l.b : Ljava/lang/Integer;
    //   47: invokevirtual intValue : ()I
    //   50: if_icmpeq -> 63
    //   53: aload_0
    //   54: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   57: getfield J : Z
    //   60: ifeq -> 564
    //   63: aload_0
    //   64: getfield d : Landroid/content/Context;
    //   67: aload_0
    //   68: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   71: getfield q : Ljava/util/List;
    //   74: iconst_1
    //   75: invokestatic a : (Landroid/content/Context;Ljava/util/List;Z)Ljava/util/List;
    //   78: astore_3
    //   79: aload_3
    //   80: astore #4
    //   82: aload_0
    //   83: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   86: getfield J : Z
    //   89: ifeq -> 130
    //   92: aload_0
    //   93: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   96: getfield aP : I
    //   99: getstatic com/unionpay/mobile/android/views/order/l.b : Ljava/lang/Integer;
    //   102: invokevirtual intValue : ()I
    //   105: if_icmpeq -> 127
    //   108: aload_3
    //   109: astore #4
    //   111: getstatic com/unionpay/mobile/android/views/order/l.a : Ljava/lang/Integer;
    //   114: invokevirtual intValue : ()I
    //   117: aload_0
    //   118: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   121: getfield aP : I
    //   124: if_icmpne -> 130
    //   127: aconst_null
    //   128: astore #4
    //   130: aload_0
    //   131: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   134: getfield w : Lorg/json/JSONObject;
    //   137: ldc_w 'label'
    //   140: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   143: astore_3
    //   144: aload_0
    //   145: aload_0
    //   146: getfield d : Landroid/content/Context;
    //   149: aload_0
    //   150: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   153: getfield t : Lorg/json/JSONArray;
    //   156: aload #4
    //   158: aload_1
    //   159: aload_2
    //   160: aload_3
    //   161: invokestatic a : (Landroid/content/Context;Lorg/json/JSONArray;Ljava/util/List;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Ljava/lang/String;)Lcom/unionpay/mobile/android/views/order/o;
    //   164: putfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   167: aload_0
    //   168: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   171: new com/unionpay/mobile/android/nocard/views/ao$a
    //   174: dup
    //   175: aload_0
    //   176: invokespecial <init> : (Lcom/unionpay/mobile/android/nocard/views/ao;)V
    //   179: invokevirtual a : (Lcom/unionpay/mobile/android/views/order/o$a;)Lcom/unionpay/mobile/android/views/order/o;
    //   182: pop
    //   183: aload_0
    //   184: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   187: aload_0
    //   188: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   191: getfield au : Lorg/json/JSONObject;
    //   194: invokevirtual b : (Lorg/json/JSONObject;)Lcom/unionpay/mobile/android/views/order/o;
    //   197: pop
    //   198: aload_0
    //   199: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   202: aload_0
    //   203: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   206: getfield Y : Lorg/json/JSONObject;
    //   209: invokevirtual c : (Lorg/json/JSONObject;)Lcom/unionpay/mobile/android/views/order/o;
    //   212: pop
    //   213: aload_0
    //   214: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   217: getfield s : Ljava/lang/String;
    //   220: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   223: ifne -> 292
    //   226: new org/json/JSONObject
    //   229: astore #4
    //   231: aload #4
    //   233: invokespecial <init> : ()V
    //   236: aload #4
    //   238: ldc_w 'href'
    //   241: aload_0
    //   242: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   245: getfield s : Ljava/lang/String;
    //   248: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   251: pop
    //   252: aload #4
    //   254: ldc_w 'title'
    //   257: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   260: getfield k : Ljava/lang/String;
    //   263: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   266: pop
    //   267: aload #4
    //   269: ldc_w 'label'
    //   272: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   275: getfield j : Ljava/lang/String;
    //   278: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   281: pop
    //   282: aload_0
    //   283: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   286: aload #4
    //   288: invokevirtual a : (Lorg/json/JSONObject;)Lcom/unionpay/mobile/android/views/order/o;
    //   291: pop
    //   292: aload_0
    //   293: getfield c : Lcom/unionpay/mobile/android/resource/c;
    //   296: sipush #2008
    //   299: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   302: astore #4
    //   304: aload_0
    //   305: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   308: aload #4
    //   310: invokevirtual b : (Landroid/graphics/drawable/Drawable;)Lcom/unionpay/mobile/android/views/order/o;
    //   313: pop
    //   314: new android/widget/RelativeLayout$LayoutParams
    //   317: dup
    //   318: iconst_m1
    //   319: iconst_m1
    //   320: invokespecial <init> : (II)V
    //   323: astore #4
    //   325: aload_0
    //   326: getfield m : Landroid/widget/RelativeLayout;
    //   329: aload_0
    //   330: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   333: aload #4
    //   335: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   338: aload_0
    //   339: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   342: getfield aP : I
    //   345: getstatic com/unionpay/mobile/android/views/order/l.e : Ljava/lang/Integer;
    //   348: invokevirtual intValue : ()I
    //   351: if_icmpne -> 563
    //   354: getstatic com/unionpay/mobile/android/model/b.bl : Z
    //   357: ifne -> 563
    //   360: aload_0
    //   361: aload_0
    //   362: getfield A : Landroid/os/Handler;
    //   365: invokevirtual a : (Landroid/os/Handler;)V
    //   368: aload_0
    //   369: new android/widget/LinearLayout
    //   372: dup
    //   373: aload_0
    //   374: getfield d : Landroid/content/Context;
    //   377: invokespecial <init> : (Landroid/content/Context;)V
    //   380: putfield x : Landroid/widget/LinearLayout;
    //   383: aload_0
    //   384: getfield x : Landroid/widget/LinearLayout;
    //   387: iconst_0
    //   388: invokevirtual setOrientation : (I)V
    //   391: getstatic com/unionpay/mobile/android/global/a.w : I
    //   394: istore #5
    //   396: new android/widget/LinearLayout$LayoutParams
    //   399: dup
    //   400: iload #5
    //   402: iload #5
    //   404: invokespecial <init> : (II)V
    //   407: astore #4
    //   409: aload #4
    //   411: bipush #17
    //   413: putfield gravity : I
    //   416: new android/widget/ProgressBar
    //   419: dup
    //   420: aload_0
    //   421: getfield d : Landroid/content/Context;
    //   424: invokespecial <init> : (Landroid/content/Context;)V
    //   427: astore_3
    //   428: aload_0
    //   429: getfield x : Landroid/widget/LinearLayout;
    //   432: aload_3
    //   433: aload #4
    //   435: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   438: new android/widget/TextView
    //   441: dup
    //   442: aload_0
    //   443: getfield d : Landroid/content/Context;
    //   446: invokespecial <init> : (Landroid/content/Context;)V
    //   449: astore_3
    //   450: aload_3
    //   451: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   454: getfield bs : Ljava/lang/String;
    //   457: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   460: aload_3
    //   461: getstatic com/unionpay/mobile/android/global/b.l : F
    //   464: invokevirtual setTextSize : (F)V
    //   467: aload_3
    //   468: ldc_w -10066330
    //   471: invokevirtual setTextColor : (I)V
    //   474: new android/widget/LinearLayout$LayoutParams
    //   477: dup
    //   478: bipush #-2
    //   480: bipush #-2
    //   482: invokespecial <init> : (II)V
    //   485: astore #4
    //   487: aload #4
    //   489: bipush #17
    //   491: putfield gravity : I
    //   494: aload #4
    //   496: getstatic com/unionpay/mobile/android/global/a.b : I
    //   499: putfield leftMargin : I
    //   502: aload_0
    //   503: getfield x : Landroid/widget/LinearLayout;
    //   506: aload_3
    //   507: aload #4
    //   509: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   512: aload_0
    //   513: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   516: bipush #8
    //   518: invokevirtual setVisibility : (I)V
    //   521: new android/widget/RelativeLayout$LayoutParams
    //   524: dup
    //   525: bipush #-2
    //   527: bipush #-2
    //   529: invokespecial <init> : (II)V
    //   532: astore #4
    //   534: aload #4
    //   536: getstatic com/unionpay/mobile/android/global/a.n : I
    //   539: putfield topMargin : I
    //   542: aload #4
    //   544: bipush #14
    //   546: iconst_m1
    //   547: invokevirtual addRule : (II)V
    //   550: aload_0
    //   551: getfield m : Landroid/widget/RelativeLayout;
    //   554: aload_0
    //   555: getfield x : Landroid/widget/LinearLayout;
    //   558: aload #4
    //   560: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   563: return
    //   564: aload_0
    //   565: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   568: getfield aP : I
    //   571: getstatic com/unionpay/mobile/android/views/order/l.c : Ljava/lang/Integer;
    //   574: invokevirtual intValue : ()I
    //   577: if_icmpne -> 596
    //   580: aload_0
    //   581: aload_0
    //   582: getfield d : Landroid/content/Context;
    //   585: aload_1
    //   586: aload_2
    //   587: invokestatic a : (Landroid/content/Context;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/unionpay/mobile/android/views/order/o;
    //   590: putfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   593: goto -> 167
    //   596: aload_0
    //   597: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   600: getfield aP : I
    //   603: getstatic com/unionpay/mobile/android/views/order/l.e : Ljava/lang/Integer;
    //   606: invokevirtual intValue : ()I
    //   609: if_icmpne -> 742
    //   612: new java/util/HashMap
    //   615: dup
    //   616: invokespecial <init> : ()V
    //   619: astore #4
    //   621: getstatic com/unionpay/mobile/android/model/b.bl : Z
    //   624: ifeq -> 700
    //   627: getstatic com/unionpay/mobile/android/model/b.bb : Ljava/util/List;
    //   630: ifnull -> 712
    //   633: getstatic com/unionpay/mobile/android/model/b.bb : Ljava/util/List;
    //   636: invokeinterface size : ()I
    //   641: ifle -> 712
    //   644: getstatic com/unionpay/mobile/android/model/b.bb : Ljava/util/List;
    //   647: invokeinterface size : ()I
    //   652: istore #6
    //   654: iconst_0
    //   655: istore #5
    //   657: iload #5
    //   659: iload #6
    //   661: if_icmpge -> 712
    //   664: getstatic com/unionpay/mobile/android/model/b.bb : Ljava/util/List;
    //   667: iload #5
    //   669: invokeinterface get : (I)Ljava/lang/Object;
    //   674: checkcast com/unionpay/mobile/android/model/d
    //   677: invokestatic b : (Lcom/unionpay/mobile/android/model/d;)Ljava/util/Map;
    //   680: astore #4
    //   682: aload_0
    //   683: getfield r : Ljava/util/List;
    //   686: aload #4
    //   688: invokeinterface add : (Ljava/lang/Object;)Z
    //   693: pop
    //   694: iinc #5, 1
    //   697: goto -> 657
    //   700: aload_0
    //   701: getfield r : Ljava/util/List;
    //   704: aload #4
    //   706: invokeinterface add : (Ljava/lang/Object;)Z
    //   711: pop
    //   712: aload_0
    //   713: aload_0
    //   714: getfield d : Landroid/content/Context;
    //   717: aload_0
    //   718: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   721: getfield t : Lorg/json/JSONArray;
    //   724: aload_0
    //   725: getfield r : Ljava/util/List;
    //   728: aload_1
    //   729: aload_2
    //   730: ldc_w ''
    //   733: invokestatic b : (Landroid/content/Context;Lorg/json/JSONArray;Ljava/util/List;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Ljava/lang/String;)Lcom/unionpay/mobile/android/views/order/o;
    //   736: putfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   739: goto -> 167
    //   742: aload_0
    //   743: aload_0
    //   744: getfield d : Landroid/content/Context;
    //   747: aload_1
    //   748: invokestatic a : (Landroid/content/Context;Landroid/graphics/drawable/Drawable;)Lcom/unionpay/mobile/android/views/order/o;
    //   751: putfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   754: aload_0
    //   755: getfield w : Lcom/unionpay/mobile/android/views/order/o;
    //   758: astore #4
    //   760: aload #4
    //   762: aload_2
    //   763: invokevirtual a : (Landroid/graphics/drawable/Drawable;)Lcom/unionpay/mobile/android/views/order/o;
    //   766: pop
    //   767: getstatic com/unionpay/mobile/android/views/order/l.a : Ljava/lang/Integer;
    //   770: invokevirtual intValue : ()I
    //   773: istore #7
    //   775: aload_0
    //   776: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   779: getfield t : Lorg/json/JSONArray;
    //   782: invokestatic a : (Lorg/json/JSONArray;)Z
    //   785: istore #8
    //   787: iload #7
    //   789: istore #5
    //   791: iload #8
    //   793: ifne -> 1139
    //   796: aload_0
    //   797: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   800: getfield v : Lorg/json/JSONObject;
    //   803: ldc_w 'label'
    //   806: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   809: astore_3
    //   810: iload #7
    //   812: istore #6
    //   814: aload_0
    //   815: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   818: getfield v : Lorg/json/JSONObject;
    //   821: ifnull -> 846
    //   824: iload #7
    //   826: istore #6
    //   828: aload_3
    //   829: invokevirtual length : ()I
    //   832: ifle -> 846
    //   835: iload #7
    //   837: getstatic com/unionpay/mobile/android/views/order/l.c : Ljava/lang/Integer;
    //   840: invokevirtual intValue : ()I
    //   843: ior
    //   844: istore #6
    //   846: ldc 'uppay'
    //   848: new java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial <init> : ()V
    //   855: iload #6
    //   857: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   860: invokevirtual toString : ()Ljava/lang/String;
    //   863: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   866: pop
    //   867: aload_0
    //   868: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   871: getfield w : Lorg/json/JSONObject;
    //   874: ldc_w 'label'
    //   877: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   880: astore_3
    //   881: aload_0
    //   882: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   885: getfield w : Lorg/json/JSONObject;
    //   888: ifnull -> 944
    //   891: aload_3
    //   892: invokevirtual length : ()I
    //   895: ifle -> 944
    //   898: aload_0
    //   899: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   902: getfield q : Ljava/util/List;
    //   905: ifnull -> 944
    //   908: aload_0
    //   909: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   912: getfield q : Ljava/util/List;
    //   915: invokeinterface size : ()I
    //   920: ifle -> 944
    //   923: aload #4
    //   925: aload_0
    //   926: getfield d : Landroid/content/Context;
    //   929: aload_0
    //   930: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   933: getfield q : Ljava/util/List;
    //   936: iconst_1
    //   937: invokestatic a : (Landroid/content/Context;Ljava/util/List;Z)Ljava/util/List;
    //   940: invokevirtual a : (Ljava/util/List;)Lcom/unionpay/mobile/android/views/order/o;
    //   943: pop
    //   944: iload #6
    //   946: istore #5
    //   948: aload_0
    //   949: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   952: getfield ax : Z
    //   955: ifeq -> 997
    //   958: iload #6
    //   960: istore #5
    //   962: aload_0
    //   963: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   966: getfield ay : Z
    //   969: ifeq -> 997
    //   972: iload #6
    //   974: istore #5
    //   976: aload_0
    //   977: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   980: getfield aC : Z
    //   983: ifne -> 997
    //   986: iload #6
    //   988: getstatic com/unionpay/mobile/android/views/order/l.d : Ljava/lang/Integer;
    //   991: invokevirtual intValue : ()I
    //   994: ior
    //   995: istore #5
    //   997: iload #5
    //   999: istore #6
    //   1001: aload_0
    //   1002: invokevirtual w : ()Z
    //   1005: ifeq -> 1047
    //   1008: iload #5
    //   1010: istore #6
    //   1012: aload_0
    //   1013: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1016: getfield az : Z
    //   1019: ifeq -> 1047
    //   1022: iload #5
    //   1024: istore #6
    //   1026: aload_0
    //   1027: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1030: getfield aC : Z
    //   1033: ifne -> 1047
    //   1036: iload #5
    //   1038: getstatic com/unionpay/mobile/android/views/order/l.e : Ljava/lang/Integer;
    //   1041: invokevirtual intValue : ()I
    //   1044: ior
    //   1045: istore #6
    //   1047: iload #6
    //   1049: istore #5
    //   1051: aload_0
    //   1052: invokevirtual w : ()Z
    //   1055: ifeq -> 1139
    //   1058: iload #6
    //   1060: istore #5
    //   1062: getstatic com/unionpay/mobile/android/model/b.aA : Z
    //   1065: ifeq -> 1139
    //   1068: iload #6
    //   1070: istore #5
    //   1072: getstatic com/unionpay/mobile/android/model/b.aB : Z
    //   1075: ifeq -> 1139
    //   1078: iload #6
    //   1080: istore #5
    //   1082: aload_0
    //   1083: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1086: getfield aP : I
    //   1089: getstatic com/unionpay/mobile/android/views/order/l.a : Ljava/lang/Integer;
    //   1092: invokevirtual intValue : ()I
    //   1095: if_icmpne -> 1139
    //   1098: iload #6
    //   1100: istore #5
    //   1102: ldc_w '1'
    //   1105: aload_0
    //   1106: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1109: getfield an : Ljava/lang/String;
    //   1112: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   1115: ifne -> 1139
    //   1118: ldc_w 'spay'
    //   1121: ldc_w 'in'
    //   1124: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   1127: pop
    //   1128: iload #6
    //   1130: getstatic com/unionpay/mobile/android/views/order/l.f : Ljava/lang/Integer;
    //   1133: invokevirtual intValue : ()I
    //   1136: ior
    //   1137: istore #5
    //   1139: aload_0
    //   1140: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1143: getfield aD : Z
    //   1146: ifeq -> 1157
    //   1149: getstatic com/unionpay/mobile/android/views/order/l.a : Ljava/lang/Integer;
    //   1152: invokevirtual intValue : ()I
    //   1155: istore #5
    //   1157: aload_0
    //   1158: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1161: getfield aC : Z
    //   1164: ifeq -> 1313
    //   1167: aload_0
    //   1168: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1171: getfield u : Ljava/lang/String;
    //   1174: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   1177: ifne -> 1313
    //   1180: aload_0
    //   1181: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1184: getfield q : Ljava/util/List;
    //   1187: ifnull -> 1205
    //   1190: aload_0
    //   1191: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1194: getfield q : Ljava/util/List;
    //   1197: invokeinterface size : ()I
    //   1202: ifgt -> 1313
    //   1205: getstatic com/unionpay/mobile/android/views/order/l.a : Ljava/lang/Integer;
    //   1208: invokevirtual intValue : ()I
    //   1211: istore #5
    //   1213: getstatic com/unionpay/mobile/android/views/order/l.a : Ljava/lang/Integer;
    //   1216: invokevirtual intValue : ()I
    //   1219: getstatic com/unionpay/mobile/android/views/order/l.c : Ljava/lang/Integer;
    //   1222: invokevirtual intValue : ()I
    //   1225: ior
    //   1226: istore #6
    //   1228: aload #4
    //   1230: iload #5
    //   1232: invokevirtual b : (I)Lcom/unionpay/mobile/android/views/order/o;
    //   1235: pop
    //   1236: aload #4
    //   1238: aload_0
    //   1239: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1242: getfield t : Lorg/json/JSONArray;
    //   1245: invokevirtual a : (Lorg/json/JSONArray;)Lcom/unionpay/mobile/android/views/order/o;
    //   1248: pop
    //   1249: ldc 'uppay'
    //   1251: new java/lang/StringBuilder
    //   1254: dup
    //   1255: invokespecial <init> : ()V
    //   1258: iload #6
    //   1260: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1263: invokevirtual toString : ()Ljava/lang/String;
    //   1266: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   1269: pop
    //   1270: aload #4
    //   1272: aload_0
    //   1273: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1276: getfield w : Lorg/json/JSONObject;
    //   1279: ldc_w 'label'
    //   1282: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   1285: invokevirtual a : (Ljava/lang/String;)Lcom/unionpay/mobile/android/views/order/o;
    //   1288: pop
    //   1289: aload #4
    //   1291: iload #6
    //   1293: invokevirtual a : (I)Lcom/unionpay/mobile/android/views/order/o;
    //   1296: pop
    //   1297: aload #4
    //   1299: iload #8
    //   1301: invokevirtual a : (Z)Lcom/unionpay/mobile/android/views/order/o;
    //   1304: pop
    //   1305: aload #4
    //   1307: invokevirtual c : ()V
    //   1310: goto -> 167
    //   1313: aload_0
    //   1314: getfield d : Landroid/content/Context;
    //   1317: aload_0
    //   1318: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1321: invokestatic a : (Landroid/content/Context;Lcom/unionpay/mobile/android/model/b;)I
    //   1324: iload #5
    //   1326: iand
    //   1327: istore #7
    //   1329: iload #7
    //   1331: istore #6
    //   1333: iload #7
    //   1335: ifne -> 1360
    //   1338: iload #7
    //   1340: istore #6
    //   1342: aload_0
    //   1343: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1346: getfield aD : Z
    //   1349: ifne -> 1360
    //   1352: getstatic com/unionpay/mobile/android/views/order/l.b : Ljava/lang/Integer;
    //   1355: invokevirtual intValue : ()I
    //   1358: istore #6
    //   1360: aload #4
    //   1362: iload #6
    //   1364: invokevirtual b : (I)Lcom/unionpay/mobile/android/views/order/o;
    //   1367: pop
    //   1368: iload #5
    //   1370: istore #6
    //   1372: aload_0
    //   1373: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1376: getfield aD : Z
    //   1379: ifne -> 1236
    //   1382: iload #5
    //   1384: getstatic com/unionpay/mobile/android/views/order/l.b : Ljava/lang/Integer;
    //   1387: invokevirtual intValue : ()I
    //   1390: ior
    //   1391: istore #6
    //   1393: goto -> 1236
    //   1396: astore #4
    //   1398: aload #4
    //   1400: invokevirtual printStackTrace : ()V
    //   1403: goto -> 292
    // Exception table:
    //   from	to	target	type
    //   226	292	1396	org/json/JSONException
  }
  
  public final void c(String paramString) {}
  
  public final void c(String paramString1, String paramString2) {}
  
  protected void d(String paramString1, String paramString2) {}
  
  protected final void e(String paramString1, String paramString2) {
    if (paramString2 != null && paramString2.length() > 0)
      this.a.I.f = paramString2; 
    a(paramString1, true);
  }
  
  public final void l() {
    if (!this.a.aE && this.a.J) {
      super.l();
      y();
      this.a.J = false;
      return;
    } 
    if (!this.a.aE && ((this.a.aP != l.a.intValue() && (this.a.aP != l.c.intValue() || !this.a.aC || (this.a.q != null && this.a.q.size() > 0))) || this.a.aP == l.e.intValue())) {
      super.l();
      y();
      this.a.aP = l.a.intValue();
      return;
    } 
    y();
    v();
  }
  
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (b.bm && this.a.aP == l.a.intValue() && !"1".equalsIgnoreCase(this.a.an)) {
      k.c("spay", "out");
      d(this.a.bp, this.a.bq);
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (this.v != null)
      this.v.clearFocus(); 
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    if (!this.y && this.z != null) {
      this.y = true;
      this.z.sendEmptyMessage(0);
    } 
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void u() {}
  
  protected final void v() {
    ar ar = new ar(this);
    as as = new as(this);
    this.b.a(ar, as);
    this.b.a(c.bD.Y, c.bD.av, c.bD.W, c.bD.X);
  }
  
  protected boolean w() {
    return false;
  }
  
  protected void x() {}
  
  public final class a implements o.a {
    public a(ao this$0) {}
    
    public final int a() {
      this.a.a.J = true;
      this.a.d(2);
      return 0;
    }
    
    public final int a(int param1Int) {
      ao.a(this.a, param1Int);
      ao.b(this.a, 3);
      this.a.j = false;
      this.a.b.a(c.bD.U);
      this.a.e.m(((c)this.a.a.q.get(param1Int)).a());
      return 0;
    }
    
    public final void a(int param1Int1, boolean param1Boolean, int param1Int2, a.a param1a) {
      if (ao.b(this.a) != null) {
        this.a.a.aQ = ao.b(this.a).a();
        k.c("functionEx", this.a.a.aQ);
      } 
      if (param1Int1 == l.e.intValue()) {
        ao.c(this.a, param1Int2);
        return;
      } 
      if (param1Boolean) {
        ao ao2 = this.a;
        ao.a(this.a.d, "bankpay_choose_bankcard_next");
        this.a.a.N = param1Int2;
        this.a.j = false;
        ao.b(this.a, 2);
        this.a.b.a(c.bD.U);
        if (((c)this.a.a.q.get(param1Int2)).c() == 0) {
          str = ((c)this.a.a.q.get(param1Int2)).a();
          this.a.a.M = "1";
          str = bh.a(this.a.a.M, str, "1", "1");
        } else {
          this.a.a.M = "0";
          str = ((c)this.a.a.q.get(param1Int2)).b();
          str = bh.b(this.a.a.M, "\"pan\":\"" + str + "\"", "2", "1\",\"carrier_tp\":\"2");
        } 
        this.a.e.c(bh.a(this.a.a.j), str);
        return;
      } 
      if (!str.a()) {
        this.a.a(((a.a)str).b);
        return;
      } 
      if (param1Int1 == l.c.intValue()) {
        ao ao2 = this.a;
        ao.a(this.a.d, "login");
        this.a.j = false;
        ao.b(this.a, 4);
        this.a.b.a(c.bD.U);
        this.a.e.n(((a.a)str).b);
        return;
      } 
      ao ao1 = this.a;
      ao.a(this.a.d, "bankpay_input_cardNO_next");
      this.a.j = false;
      ao.b(this.a, 2);
      this.a.b.a(c.bD.U);
      this.a.a.M = "0";
      String str = bh.b(this.a.a.M, ((a.a)str).b, "1", "1");
      this.a.e.c(bh.a(this.a.a.j), str);
    }
    
    public final void a(String param1String1, String param1String2) {
      this.a.a(param1String1, param1String2);
    }
    
    public final int b(int param1Int) {
      ao ao1 = this.a;
      ao.a(this.a.d, "bankpay_choose_bankcard", p.f, new Object[] { Integer.valueOf(param1Int) });
      return 0;
    }
    
    public final void c(int param1Int) {
      this.a.r();
      if (param1Int == l.b.intValue()) {
        ao ao1 = this.a;
        ao.a(this.a.d, "open_bankpay");
        this.a.a.aP = l.b.intValue();
        this.a.d(2);
        return;
      } 
      if (param1Int == l.c.intValue()) {
        ao ao1 = this.a;
        ao.a(this.a.d, "open_loginpay");
        ao.d(this.a);
        return;
      } 
      if (param1Int == l.d.intValue()) {
        ao ao1 = this.a;
        ao.a(this.a.d, "open_nfcpay");
        ao.e(this.a);
        return;
      } 
      if (param1Int == l.e.intValue()) {
        ao.f(this.a);
        return;
      } 
      if (param1Int == l.f.intValue())
        this.a.d(this.a.a.bp, this.a.a.bq); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */