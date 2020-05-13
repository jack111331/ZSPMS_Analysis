package com.unionpay.mobile.android.nocard.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.PreferenceUtils;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.views.order.l;
import com.unionpay.mobile.android.widgets.ay;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bd extends b {
  private TextView r = null;
  
  private View.OnClickListener s = new be(this);
  
  private a t;
  
  public bd(Context paramContext) {
    super(paramContext);
    e();
    this.q = "result";
    this.a.aq = null;
    if (this.a.aV)
      this.e.c("bingopromotion", ""); 
  }
  
  private void u() {
    int i = this.a.aQ;
    k.c("functionEx", i);
    if (this.a.aQ == l.b.intValue() || this.a.aQ == l.c.intValue())
      PreferenceUtils.c(this.d, i); 
    this.a.I.f = "success";
    k();
  }
  
  public final void a(JSONObject paramJSONObject) {
    paramJSONObject = j.c(paramJSONObject, "luck_draw");
    if (paramJSONObject != null) {
      this.t.setVisibility(0);
      this.t.a(paramJSONObject);
    } 
  }
  
  protected final void b() {
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
    ay ay = new ay(getContext(), this.a.A, this);
    ay.a();
    layoutParams.addRule(13, -1);
    this.k.addView((View)ay, (ViewGroup.LayoutParams)layoutParams);
  }
  
  public final void b(int paramInt) {}
  
  protected final void c() {
    g();
    this.m.invalidate();
    if (this.o != null)
      this.o.setBackgroundColor(-1052684); 
    RelativeLayout relativeLayout1 = new RelativeLayout(this.d);
    relativeLayout1.setBackgroundColor(-1052684);
    relativeLayout1.setId(relativeLayout1.hashCode());
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    layoutParams1.addRule(10, -1);
    layoutParams1.topMargin = com.unionpay.mobile.android.global.a.d;
    this.m.addView((View)relativeLayout1, (ViewGroup.LayoutParams)layoutParams1);
    RelativeLayout relativeLayout2 = new RelativeLayout(this.d);
    relativeLayout2.setId(relativeLayout2.hashCode());
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams3.topMargin = com.unionpay.mobile.android.global.a.d;
    relativeLayout1.addView((View)relativeLayout2, (ViewGroup.LayoutParams)layoutParams3);
    int i = com.unionpay.mobile.android.global.a.n;
    Drawable drawable = this.c.a(2008);
    this.r = new TextView(this.d);
    this.r.setId(this.r.hashCode());
    this.r.setText(c.bD.E);
    this.r.setTextSize(b.i);
    this.r.setTextColor(p());
    this.r.setGravity(17);
    this.r.setOnClickListener(this.s);
    this.r.setBackgroundDrawable(drawable);
    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, i);
    i = g.a(this.d, 12.0F);
    layoutParams2.rightMargin = i;
    layoutParams2.leftMargin = i;
    layoutParams2.addRule(9, -1);
    layoutParams2.addRule(15, -1);
    relativeLayout2.addView((View)this.r, (ViewGroup.LayoutParams)layoutParams2);
    this.t = new a(this, this.d);
    this.t.setVisibility(8);
    layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
    layoutParams2.addRule(3, relativeLayout2.getId());
    layoutParams2.topMargin = g.a(this.d, 20.0F);
    relativeLayout1.addView((View)this.t, (ViewGroup.LayoutParams)layoutParams2);
  }
  
  protected final void f() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   8: getfield H : Lorg/json/JSONArray;
    //   11: ifnull -> 415
    //   14: new android/widget/LinearLayout
    //   17: dup
    //   18: aload_0
    //   19: getfield d : Landroid/content/Context;
    //   22: invokespecial <init> : (Landroid/content/Context;)V
    //   25: astore_1
    //   26: aload_1
    //   27: iconst_1
    //   28: invokevirtual setOrientation : (I)V
    //   31: aload_0
    //   32: getfield d : Landroid/content/Context;
    //   35: ldc_w 10.0
    //   38: invokestatic a : (Landroid/content/Context;F)I
    //   41: istore_3
    //   42: aload_0
    //   43: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   46: getfield B : Ljava/lang/String;
    //   49: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   52: ifne -> 211
    //   55: new android/widget/TextView
    //   58: dup
    //   59: aload_0
    //   60: getfield d : Landroid/content/Context;
    //   63: invokespecial <init> : (Landroid/content/Context;)V
    //   66: astore #4
    //   68: aload #4
    //   70: aload_0
    //   71: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   74: getfield B : Ljava/lang/String;
    //   77: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   80: aload #4
    //   82: ldc_w 24.0
    //   85: invokevirtual setTextSize : (F)V
    //   88: aload #4
    //   90: ldc_w -15365480
    //   93: invokevirtual setTextColor : (I)V
    //   96: aload #4
    //   98: iconst_1
    //   99: invokevirtual setGravity : (I)V
    //   102: aload #4
    //   104: iconst_0
    //   105: getstatic com/unionpay/mobile/android/global/a.d : I
    //   108: iconst_0
    //   109: iconst_0
    //   110: invokevirtual setPadding : (IIII)V
    //   113: aload #4
    //   115: invokevirtual getPaint : ()Landroid/text/TextPaint;
    //   118: iconst_1
    //   119: invokevirtual setFakeBoldText : (Z)V
    //   122: aload_1
    //   123: aload #4
    //   125: new android/widget/LinearLayout$LayoutParams
    //   128: dup
    //   129: iconst_m1
    //   130: bipush #-2
    //   132: invokespecial <init> : (II)V
    //   135: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   138: new android/widget/LinearLayout
    //   141: dup
    //   142: aload_0
    //   143: getfield d : Landroid/content/Context;
    //   146: invokespecial <init> : (Landroid/content/Context;)V
    //   149: astore #5
    //   151: aload #5
    //   153: iconst_0
    //   154: invokevirtual setOrientation : (I)V
    //   157: aload #5
    //   159: ldc_w -6958338
    //   162: invokevirtual setBackgroundColor : (I)V
    //   165: new android/widget/LinearLayout$LayoutParams
    //   168: dup
    //   169: iconst_m1
    //   170: iconst_1
    //   171: invokespecial <init> : (II)V
    //   174: astore #4
    //   176: getstatic com/unionpay/mobile/android/global/a.d : I
    //   179: istore #6
    //   181: aload #4
    //   183: iload #6
    //   185: putfield bottomMargin : I
    //   188: aload #4
    //   190: iload #6
    //   192: putfield topMargin : I
    //   195: aload_1
    //   196: aload #5
    //   198: aload #4
    //   200: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   203: aload_0
    //   204: getfield l : Landroid/view/ViewGroup;
    //   207: aload_1
    //   208: invokevirtual addView : (Landroid/view/View;)V
    //   211: aload_0
    //   212: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   215: getfield H : Lorg/json/JSONArray;
    //   218: astore_2
    //   219: aload_2
    //   220: ifnull -> 342
    //   223: aload_2
    //   224: invokevirtual length : ()I
    //   227: iconst_2
    //   228: if_icmplt -> 406
    //   231: iconst_2
    //   232: istore #6
    //   234: aload_0
    //   235: getfield d : Landroid/content/Context;
    //   238: aload_2
    //   239: iconst_0
    //   240: iload #6
    //   242: invokestatic a : (Landroid/content/Context;Lorg/json/JSONArray;II)Landroid/widget/LinearLayout;
    //   245: astore #4
    //   247: aload #4
    //   249: iconst_0
    //   250: invokevirtual setBackgroundColor : (I)V
    //   253: new android/widget/LinearLayout$LayoutParams
    //   256: dup
    //   257: iconst_m1
    //   258: bipush #-2
    //   260: invokespecial <init> : (II)V
    //   263: astore #5
    //   265: aload #5
    //   267: iload_3
    //   268: putfield rightMargin : I
    //   271: aload #5
    //   273: iload_3
    //   274: putfield leftMargin : I
    //   277: aload_1
    //   278: aload #4
    //   280: aload #5
    //   282: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   285: aload_2
    //   286: invokevirtual length : ()I
    //   289: istore #7
    //   291: aload_0
    //   292: getfield d : Landroid/content/Context;
    //   295: aload_2
    //   296: iload #6
    //   298: iload #7
    //   300: invokestatic a : (Landroid/content/Context;Lorg/json/JSONArray;II)Landroid/widget/LinearLayout;
    //   303: astore #4
    //   305: aload #4
    //   307: iconst_0
    //   308: invokevirtual setBackgroundColor : (I)V
    //   311: new android/widget/LinearLayout$LayoutParams
    //   314: dup
    //   315: iconst_m1
    //   316: bipush #-2
    //   318: invokespecial <init> : (II)V
    //   321: astore_1
    //   322: aload_1
    //   323: iload_3
    //   324: putfield rightMargin : I
    //   327: aload_1
    //   328: iload_3
    //   329: putfield leftMargin : I
    //   332: aload_0
    //   333: getfield l : Landroid/view/ViewGroup;
    //   336: aload #4
    //   338: aload_1
    //   339: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   342: new com/unionpay/mobile/android/widgets/as
    //   345: dup
    //   346: aload_0
    //   347: getfield d : Landroid/content/Context;
    //   350: invokespecial <init> : (Landroid/content/Context;)V
    //   353: astore_1
    //   354: aload_1
    //   355: aload_1
    //   356: invokevirtual hashCode : ()I
    //   359: invokevirtual setId : (I)V
    //   362: aload_0
    //   363: getfield l : Landroid/view/ViewGroup;
    //   366: new com/unionpay/mobile/android/nocard/views/bf
    //   369: dup
    //   370: aload_0
    //   371: invokespecial <init> : (Lcom/unionpay/mobile/android/nocard/views/bd;)V
    //   374: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   377: new android/widget/LinearLayout$LayoutParams
    //   380: dup
    //   381: iconst_m1
    //   382: bipush #-2
    //   384: invokespecial <init> : (II)V
    //   387: astore #4
    //   389: aload #4
    //   391: iconst_0
    //   392: putfield bottomMargin : I
    //   395: aload_0
    //   396: getfield l : Landroid/view/ViewGroup;
    //   399: aload_1
    //   400: aload #4
    //   402: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   405: return
    //   406: aload_2
    //   407: invokevirtual length : ()I
    //   410: istore #6
    //   412: goto -> 234
    //   415: aload_0
    //   416: getfield d : Landroid/content/Context;
    //   419: ldc_w 10.0
    //   422: invokestatic a : (Landroid/content/Context;F)I
    //   425: istore_3
    //   426: new android/widget/LinearLayout
    //   429: dup
    //   430: aload_0
    //   431: getfield d : Landroid/content/Context;
    //   434: invokespecial <init> : (Landroid/content/Context;)V
    //   437: astore #8
    //   439: aload #8
    //   441: iload_3
    //   442: iload_3
    //   443: iload_3
    //   444: iload_3
    //   445: invokevirtual setPadding : (IIII)V
    //   448: aload #8
    //   450: iconst_1
    //   451: invokevirtual setOrientation : (I)V
    //   454: aload #8
    //   456: iconst_m1
    //   457: invokevirtual setBackgroundColor : (I)V
    //   460: aload_0
    //   461: getfield l : Landroid/view/ViewGroup;
    //   464: aload #8
    //   466: invokevirtual addView : (Landroid/view/View;)V
    //   469: new android/widget/LinearLayout
    //   472: dup
    //   473: aload_0
    //   474: getfield d : Landroid/content/Context;
    //   477: invokespecial <init> : (Landroid/content/Context;)V
    //   480: astore #4
    //   482: aload #4
    //   484: iconst_0
    //   485: invokevirtual setOrientation : (I)V
    //   488: aload #8
    //   490: aload #4
    //   492: invokevirtual addView : (Landroid/view/View;)V
    //   495: aload_0
    //   496: getfield d : Landroid/content/Context;
    //   499: ldc_w 25.0
    //   502: invokestatic a : (Landroid/content/Context;F)I
    //   505: istore #6
    //   507: new android/widget/ImageView
    //   510: dup
    //   511: aload_0
    //   512: getfield d : Landroid/content/Context;
    //   515: invokespecial <init> : (Landroid/content/Context;)V
    //   518: astore #5
    //   520: aload #5
    //   522: aload_0
    //   523: getfield c : Lcom/unionpay/mobile/android/resource/c;
    //   526: sipush #1035
    //   529: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   532: invokevirtual setBackgroundDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   535: aload #4
    //   537: aload #5
    //   539: new android/widget/LinearLayout$LayoutParams
    //   542: dup
    //   543: iload #6
    //   545: iload #6
    //   547: invokespecial <init> : (II)V
    //   550: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   553: new android/widget/LinearLayout
    //   556: dup
    //   557: aload_0
    //   558: getfield d : Landroid/content/Context;
    //   561: invokespecial <init> : (Landroid/content/Context;)V
    //   564: astore #9
    //   566: aload #9
    //   568: iconst_1
    //   569: invokevirtual setOrientation : (I)V
    //   572: new android/widget/LinearLayout$LayoutParams
    //   575: dup
    //   576: bipush #-2
    //   578: bipush #-2
    //   580: invokespecial <init> : (II)V
    //   583: astore #5
    //   585: aload #5
    //   587: iload_3
    //   588: putfield leftMargin : I
    //   591: aload #4
    //   593: aload #9
    //   595: aload #5
    //   597: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   600: aload_0
    //   601: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   604: getfield aR : Ljava/lang/String;
    //   607: astore #5
    //   609: aload #5
    //   611: invokestatic b : (Ljava/lang/String;)Z
    //   614: ifne -> 755
    //   617: aload #5
    //   619: bipush #60
    //   621: invokevirtual indexOf : (I)I
    //   624: istore_3
    //   625: iconst_m1
    //   626: iload_3
    //   627: if_icmpeq -> 1144
    //   630: aload #5
    //   632: iconst_0
    //   633: iload_3
    //   634: invokevirtual substring : (II)Ljava/lang/String;
    //   637: astore_1
    //   638: aload #5
    //   640: bipush #62
    //   642: invokevirtual indexOf : (I)I
    //   645: iconst_1
    //   646: iadd
    //   647: istore #7
    //   649: iconst_m1
    //   650: iload #7
    //   652: if_icmpeq -> 1138
    //   655: aload #5
    //   657: iload #7
    //   659: invokevirtual substring : (I)Ljava/lang/String;
    //   662: astore #4
    //   664: iload_3
    //   665: iconst_1
    //   666: iadd
    //   667: istore #10
    //   669: iload #7
    //   671: iconst_1
    //   672: isub
    //   673: istore #6
    //   675: iconst_m1
    //   676: iload_3
    //   677: if_icmpeq -> 1132
    //   680: iload #10
    //   682: iload #6
    //   684: if_icmpge -> 1132
    //   687: iload #7
    //   689: iconst_m1
    //   690: if_icmpeq -> 1132
    //   693: aload #5
    //   695: iload #10
    //   697: iload #6
    //   699: invokevirtual substring : (II)Ljava/lang/String;
    //   702: astore #5
    //   704: aload #5
    //   706: invokestatic b : (Ljava/lang/String;)Z
    //   709: ifne -> 1132
    //   712: aload #5
    //   714: ldc_w '#'
    //   717: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   720: astore #11
    //   722: aload #11
    //   724: ifnull -> 1132
    //   727: aload #11
    //   729: arraylength
    //   730: iconst_2
    //   731: if_icmpne -> 1132
    //   734: aload #11
    //   736: iconst_0
    //   737: aaload
    //   738: astore #5
    //   740: aload #11
    //   742: iconst_1
    //   743: aaload
    //   744: astore_2
    //   745: aload_1
    //   746: aload #5
    //   748: aload_2
    //   749: aload #4
    //   751: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableString;
    //   754: astore_1
    //   755: aload_1
    //   756: ifnull -> 793
    //   759: new android/widget/TextView
    //   762: dup
    //   763: aload_0
    //   764: getfield d : Landroid/content/Context;
    //   767: invokespecial <init> : (Landroid/content/Context;)V
    //   770: astore #4
    //   772: aload #4
    //   774: ldc_w 20.0
    //   777: invokevirtual setTextSize : (F)V
    //   780: aload #4
    //   782: aload_1
    //   783: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   786: aload #9
    //   788: aload #4
    //   790: invokevirtual addView : (Landroid/view/View;)V
    //   793: aload_0
    //   794: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   797: getfield aS : Ljava/lang/String;
    //   800: invokestatic b : (Ljava/lang/String;)Z
    //   803: ifeq -> 849
    //   806: new android/widget/TextView
    //   809: dup
    //   810: aload_0
    //   811: getfield d : Landroid/content/Context;
    //   814: invokespecial <init> : (Landroid/content/Context;)V
    //   817: astore_1
    //   818: aload_1
    //   819: getstatic com/unionpay/mobile/android/global/b.l : F
    //   822: invokevirtual setTextSize : (F)V
    //   825: aload_1
    //   826: aload_0
    //   827: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   830: getfield aS : Ljava/lang/String;
    //   833: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   836: aload_1
    //   837: ldc_w -10066330
    //   840: invokevirtual setTextColor : (I)V
    //   843: aload #9
    //   845: aload_1
    //   846: invokevirtual addView : (Landroid/view/View;)V
    //   849: aload_0
    //   850: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   853: getfield aT : Ljava/lang/String;
    //   856: invokestatic b : (Ljava/lang/String;)Z
    //   859: ifeq -> 905
    //   862: new android/widget/TextView
    //   865: dup
    //   866: aload_0
    //   867: getfield d : Landroid/content/Context;
    //   870: invokespecial <init> : (Landroid/content/Context;)V
    //   873: astore_1
    //   874: aload_1
    //   875: getstatic com/unionpay/mobile/android/global/b.l : F
    //   878: invokevirtual setTextSize : (F)V
    //   881: aload_1
    //   882: ldc_w -10066330
    //   885: invokevirtual setTextColor : (I)V
    //   888: aload_1
    //   889: aload_0
    //   890: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   893: getfield aT : Ljava/lang/String;
    //   896: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   899: aload #9
    //   901: aload_1
    //   902: invokevirtual addView : (Landroid/view/View;)V
    //   905: aload_0
    //   906: getfield d : Landroid/content/Context;
    //   909: ldc_w 5.0
    //   912: invokestatic a : (Landroid/content/Context;F)I
    //   915: istore #6
    //   917: new android/widget/LinearLayout
    //   920: dup
    //   921: aload_0
    //   922: getfield d : Landroid/content/Context;
    //   925: invokespecial <init> : (Landroid/content/Context;)V
    //   928: astore_1
    //   929: aload_1
    //   930: iconst_1
    //   931: invokevirtual setOrientation : (I)V
    //   934: aload_1
    //   935: ldc -1052684
    //   937: invokevirtual setBackgroundColor : (I)V
    //   940: aload_1
    //   941: iload #6
    //   943: iload #6
    //   945: iload #6
    //   947: iload #6
    //   949: invokevirtual setPadding : (IIII)V
    //   952: new android/widget/LinearLayout$LayoutParams
    //   955: dup
    //   956: iconst_m1
    //   957: bipush #-2
    //   959: invokespecial <init> : (II)V
    //   962: astore #4
    //   964: aload #4
    //   966: aload_0
    //   967: getfield d : Landroid/content/Context;
    //   970: ldc_w 10.0
    //   973: invokestatic a : (Landroid/content/Context;F)I
    //   976: putfield topMargin : I
    //   979: aload #8
    //   981: aload_1
    //   982: aload #4
    //   984: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   987: aload_1
    //   988: bipush #8
    //   990: invokevirtual setVisibility : (I)V
    //   993: ldc_w '0'
    //   996: aload_0
    //   997: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1000: getfield aW : Ljava/lang/String;
    //   1003: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1006: ifeq -> 1066
    //   1009: aload_0
    //   1010: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1013: getfield aX : Ljava/lang/String;
    //   1016: invokestatic b : (Ljava/lang/String;)Z
    //   1019: ifeq -> 1066
    //   1022: new android/widget/TextView
    //   1025: dup
    //   1026: aload_0
    //   1027: getfield d : Landroid/content/Context;
    //   1030: invokespecial <init> : (Landroid/content/Context;)V
    //   1033: astore #4
    //   1035: aload #4
    //   1037: getstatic com/unionpay/mobile/android/global/b.l : F
    //   1040: invokevirtual setTextSize : (F)V
    //   1043: aload #4
    //   1045: aload_0
    //   1046: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   1049: getfield aX : Ljava/lang/String;
    //   1052: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   1055: aload_1
    //   1056: aload #4
    //   1058: invokevirtual addView : (Landroid/view/View;)V
    //   1061: aload_1
    //   1062: iconst_0
    //   1063: invokevirtual setVisibility : (I)V
    //   1066: aload_0
    //   1067: getfield c : Lcom/unionpay/mobile/android/resource/c;
    //   1070: sipush #1026
    //   1073: invokevirtual a : (I)Landroid/graphics/drawable/Drawable;
    //   1076: astore #4
    //   1078: new android/widget/LinearLayout
    //   1081: dup
    //   1082: aload_0
    //   1083: getfield d : Landroid/content/Context;
    //   1086: invokespecial <init> : (Landroid/content/Context;)V
    //   1089: astore_1
    //   1090: aload #4
    //   1092: ifnull -> 1101
    //   1095: aload_1
    //   1096: aload #4
    //   1098: invokevirtual setBackgroundDrawable : (Landroid/graphics/drawable/Drawable;)V
    //   1101: new android/widget/LinearLayout$LayoutParams
    //   1104: dup
    //   1105: iconst_m1
    //   1106: aload_0
    //   1107: getfield d : Landroid/content/Context;
    //   1110: fconst_2
    //   1111: invokestatic a : (Landroid/content/Context;F)I
    //   1114: invokespecial <init> : (II)V
    //   1117: astore #4
    //   1119: aload_0
    //   1120: getfield l : Landroid/view/ViewGroup;
    //   1123: aload_1
    //   1124: aload #4
    //   1126: invokevirtual addView : (Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1129: goto -> 405
    //   1132: aconst_null
    //   1133: astore #5
    //   1135: goto -> 745
    //   1138: aconst_null
    //   1139: astore #4
    //   1141: goto -> 664
    //   1144: aconst_null
    //   1145: astore_1
    //   1146: goto -> 638
  }
  
  public final void l() {
    u();
  }
  
  public final class a extends LinearLayout {
    private Context b;
    
    public a(bd this$0, Context param1Context) {
      super(param1Context);
      this.b = param1Context;
      setOrientation(1);
    }
    
    private void a(JSONArray param1JSONArray) {
      if (param1JSONArray != null && param1JSONArray.length() > 0) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(this.a.d);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        addView((View)linearLayout, (ViewGroup.LayoutParams)layoutParams);
        layoutParams = new LinearLayout.LayoutParams(-1, b.n);
        byte b = 0;
        while (true) {
          if (b < param1JSONArray.length()) {
            try {
              JSONObject jSONObject = param1JSONArray.getJSONObject(b);
              String str1 = j.a(jSONObject, "label");
              String str2 = j.a(jSONObject, "url");
              LinearLayout linearLayout1 = new LinearLayout();
              this(this.a.d);
              linearLayout1.setBackgroundColor(-3419943);
              LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams();
              this(-1, 1);
              if (b != 0)
                layoutParams3.leftMargin = g.a(this.a.d, 12.0F); 
              linearLayout.addView((View)linearLayout1, (ViewGroup.LayoutParams)layoutParams3);
              Context context = this.b;
              RelativeLayout relativeLayout = new RelativeLayout();
              this(this.b);
              relativeLayout.setBackgroundDrawable(this.a.c.a(2014));
              bg bg = new bg();
              this(this, b, str1, str2);
              relativeLayout.setOnClickListener(bg);
              TextView textView = new TextView();
              this(context);
              textView.setText(str1);
              textView.setTextSize(b.k);
              textView.setTextColor(-13421773);
              RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams();
              this(-2, -2);
              layoutParams1.addRule(15, -1);
              layoutParams1.addRule(9, -1);
              layoutParams1.leftMargin = g.a(context, 12.0F);
              relativeLayout.addView((View)textView, (ViewGroup.LayoutParams)layoutParams1);
              int i = g.a(context, 20.0F);
              Drawable drawable = this.a.c.a(1002);
              ImageView imageView = new ImageView();
              this(context);
              imageView.setBackgroundDrawable(drawable);
              RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams();
              this(i, i);
              layoutParams2.addRule(15, -1);
              layoutParams2.addRule(11, -1);
              layoutParams2.rightMargin = g.a(context, 12.0F);
              relativeLayout.addView((View)imageView, (ViewGroup.LayoutParams)layoutParams2);
              linearLayout.addView((View)relativeLayout, (ViewGroup.LayoutParams)layoutParams);
              if (b == param1JSONArray.length() - 1) {
                LinearLayout linearLayout2 = new LinearLayout();
                this(this.a.d);
                linearLayout2.setBackgroundColor(-3419943);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams();
                this(-1, 1);
                linearLayout.addView((View)linearLayout2, (ViewGroup.LayoutParams)layoutParams4);
              } 
            } catch (JSONException jSONException) {
              jSONException.printStackTrace();
            } 
            b++;
            continue;
          } 
          return;
        } 
      } 
    }
    
    public final void a(JSONObject param1JSONObject) {
      removeAllViews();
      String str = j.a(param1JSONObject, "label");
      bd bd1 = this.a;
      if (bd.b(str)) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = g.a(this.a.d, 12.0F);
        layoutParams.bottomMargin = com.unionpay.mobile.android.global.a.f;
        TextView textView = new TextView(this.b);
        textView.setText(str);
        textView.setTextSize(b.k);
        textView.setTextColor(-25009);
        addView((View)textView, (ViewGroup.LayoutParams)layoutParams);
      } 
      a(j.d(param1JSONObject, "options"));
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\nocard\views\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */