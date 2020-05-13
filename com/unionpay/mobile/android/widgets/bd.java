package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.unionpay.mobile.android.languages.c;
import java.math.BigDecimal;
import org.json.JSONObject;

public class bd extends aa implements u.a {
  private static final String c = bd.class.getSimpleName();
  
  private String o;
  
  private String p;
  
  private String q;
  
  private String r;
  
  private String s;
  
  public bd(Context paramContext, int paramInt, JSONObject paramJSONObject, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: aload_3
    //   4: aload #4
    //   6: invokespecial <init> : (Landroid/content/Context;ILorg/json/JSONObject;Ljava/lang/String;)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield o : Ljava/lang/String;
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield p : Ljava/lang/String;
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield q : Ljava/lang/String;
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield r : Ljava/lang/String;
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield s : Ljava/lang/String;
    //   34: aload_0
    //   35: aload_3
    //   36: ldc 'point'
    //   38: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield r : Ljava/lang/String;
    //   44: aload_0
    //   45: aload_3
    //   46: ldc 'max_use_point'
    //   48: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   51: putfield q : Ljava/lang/String;
    //   54: aload_0
    //   55: aload_3
    //   56: ldc 'min_use_point'
    //   58: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   61: putfield p : Ljava/lang/String;
    //   64: aload_0
    //   65: aload_3
    //   66: ldc 'ratio'
    //   68: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   71: putfield s : Ljava/lang/String;
    //   74: aload_0
    //   75: aload_3
    //   76: ldc 'ordr_amnt'
    //   78: invokestatic a : (Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   81: putfield o : Ljava/lang/String;
    //   84: aload_0
    //   85: getfield b : Lcom/unionpay/mobile/android/widgets/u;
    //   88: sipush #8194
    //   91: invokevirtual a : (I)V
    //   94: aload_0
    //   95: getfield b : Lcom/unionpay/mobile/android/widgets/u;
    //   98: ldc '0123456789.'
    //   100: invokestatic getInstance : (Ljava/lang/String;)Landroid/text/method/DigitsKeyListener;
    //   103: invokevirtual a : (Landroid/text/InputFilter;)V
    //   106: new java/math/BigDecimal
    //   109: astore_1
    //   110: aload_1
    //   111: aload_0
    //   112: getfield p : Ljava/lang/String;
    //   115: invokespecial <init> : (Ljava/lang/String;)V
    //   118: aload_1
    //   119: iconst_2
    //   120: bipush #6
    //   122: invokevirtual setScale : (II)Ljava/math/BigDecimal;
    //   125: astore_1
    //   126: new java/math/BigDecimal
    //   129: astore_3
    //   130: aload_3
    //   131: aload_0
    //   132: getfield q : Ljava/lang/String;
    //   135: invokespecial <init> : (Ljava/lang/String;)V
    //   138: aload_3
    //   139: iconst_2
    //   140: bipush #6
    //   142: invokevirtual setScale : (II)Ljava/math/BigDecimal;
    //   145: astore_3
    //   146: aload_0
    //   147: getfield b : Lcom/unionpay/mobile/android/widgets/u;
    //   150: new com/unionpay/mobile/android/widgets/bd$a
    //   153: dup
    //   154: aload_0
    //   155: aload_0
    //   156: getfield b : Lcom/unionpay/mobile/android/widgets/u;
    //   159: aload_1
    //   160: aload_3
    //   161: invokespecial <init> : (Lcom/unionpay/mobile/android/widgets/bd;Lcom/unionpay/mobile/android/widgets/u;Ljava/math/BigDecimal;Ljava/math/BigDecimal;)V
    //   164: invokevirtual a : (Landroid/text/InputFilter;)V
    //   167: aload_0
    //   168: aconst_null
    //   169: aconst_null
    //   170: invokespecial a : (Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_0
    //   174: invokevirtual q : ()Ljava/lang/String;
    //   177: ifnull -> 190
    //   180: aload_0
    //   181: invokevirtual q : ()Ljava/lang/String;
    //   184: invokevirtual length : ()I
    //   187: ifne -> 225
    //   190: aload_0
    //   191: invokevirtual u : ()V
    //   194: aload_0
    //   195: getstatic com/unionpay/mobile/android/languages/c.bD : Lcom/unionpay/mobile/android/languages/c;
    //   198: getfield ay : Ljava/lang/String;
    //   201: iconst_2
    //   202: anewarray java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload_0
    //   208: getfield r : Ljava/lang/String;
    //   211: aastore
    //   212: dup
    //   213: iconst_1
    //   214: aload_0
    //   215: getfield s : Ljava/lang/String;
    //   218: aastore
    //   219: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   222: invokevirtual c : (Ljava/lang/String;)V
    //   225: aload_0
    //   226: getfield b : Lcom/unionpay/mobile/android/widgets/u;
    //   229: aload_0
    //   230: invokevirtual a : (Lcom/unionpay/mobile/android/widgets/u$a;)V
    //   233: return
    //   234: astore_1
    //   235: getstatic java/math/BigDecimal.ZERO : Ljava/math/BigDecimal;
    //   238: astore_1
    //   239: aload_1
    //   240: iconst_2
    //   241: bipush #6
    //   243: invokevirtual setScale : (II)Ljava/math/BigDecimal;
    //   246: astore_1
    //   247: goto -> 126
    //   250: astore_1
    //   251: new java/lang/NullPointerException
    //   254: dup
    //   255: invokespecial <init> : ()V
    //   258: athrow
    //   259: astore_3
    //   260: new java/math/BigDecimal
    //   263: dup
    //   264: ldc2_w 3.4028234663852886E38
    //   267: invokespecial <init> : (D)V
    //   270: astore_3
    //   271: aload_3
    //   272: iconst_2
    //   273: bipush #6
    //   275: invokevirtual setScale : (II)Ljava/math/BigDecimal;
    //   278: astore_3
    //   279: goto -> 146
    //   282: astore_1
    //   283: new java/lang/NullPointerException
    //   286: dup
    //   287: invokespecial <init> : ()V
    //   290: athrow
    // Exception table:
    //   from	to	target	type
    //   106	118	234	java/lang/Exception
    //   106	118	250	finally
    //   126	138	259	java/lang/Exception
    //   126	138	282	finally
    //   235	239	250	finally
    //   260	271	282	finally
  }
  
  private void a(String paramString1, String paramString2) {
    if (p() == null || p().length() == 0) {
      SpannableString spannableString;
      t();
      if (paramString1 == null) {
        paramString2 = String.format(c.bD.aw, new Object[] { this.q });
        spannableString = new SpannableString(paramString2);
        spannableString.setSpan(new ForegroundColorSpan(-15958150), 0, paramString2.length(), 0);
      } else {
        String str = String.format(c.bD.aw + spannableString, new Object[] { this.q, paramString2 });
        spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(-15958150), 0, str.length() - (paramString2 + "元").length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(-44462), str.length() - (paramString2 + "元").length(), str.length(), 0);
      } 
      v();
      a((CharSequence)spannableString, TextView.BufferType.SPANNABLE);
    } 
  }
  
  public final String a() {
    String str1 = null;
    String str2 = super.a();
    String str3 = str1;
    if (str2 != null) {
      if (str2.length() == 0)
        return str1; 
    } else {
      return str3;
    } 
    try {
      BigDecimal bigDecimal = new BigDecimal();
      this(str2);
      bigDecimal.setScale(2, 6);
      str3 = str1;
      if (bigDecimal.compareTo(BigDecimal.ZERO) == 1)
        str3 = bigDecimal.toString(); 
    } catch (Exception exception) {
      str3 = str1;
    } 
    return str3;
  }
  
  public final void a(Editable paramEditable) {
    super.a(paramEditable);
    if (p() == null || p().length() == 0)
      try {
        BigDecimal bigDecimal1 = new BigDecimal();
        this(this.s);
        bigDecimal1 = bigDecimal1.setScale(2, 6);
        BigDecimal bigDecimal2 = new BigDecimal();
        this(this.o);
        BigDecimal bigDecimal3 = bigDecimal2.setScale(2, 6);
        bigDecimal2 = new BigDecimal();
        this(a());
        bigDecimal1 = bigDecimal3.subtract(bigDecimal2.setScale(2, 6).multiply(bigDecimal1).setScale(2, 6));
        a(c.bD.ax, bigDecimal1.toString());
      } catch (Exception exception) {
        a((String)null, (String)null);
      }  
  }
  
  public final void a(boolean paramBoolean) {
    if (paramBoolean)
      a((View)this.l); 
  }
  
  public final boolean b() {
    return true;
  }
  
  public final boolean c() {
    return true;
  }
  
  public final String h() {
    null = a();
    return (null == null || null.length() == 0) ? null : super.h();
  }
  
  public final class a implements InputFilter {
    private u b = null;
    
    private BigDecimal c = null;
    
    private BigDecimal d = null;
    
    public a(bd this$0, u param1u, BigDecimal param1BigDecimal1, BigDecimal param1BigDecimal2) {
      this.b = param1u;
      this.c = param1BigDecimal1;
      this.d = param1BigDecimal2;
      if (this.c.compareTo(BigDecimal.ZERO) == 1)
        c(this.c.toString()); 
    }
    
    private static int a(String param1String) {
      return (param1String == null || !b(param1String)) ? 0 : (param1String.length() - param1String.indexOf(".") - 1);
    }
    
    private CharSequence a(String param1String, boolean param1Boolean1, boolean param1Boolean2) {
      String str1;
      String str2 = this.d.toString();
      String str3 = this.c.toString();
      try {
        BigDecimal bigDecimal = new BigDecimal();
        this(param1String);
        bigDecimal.setScale(2, 6);
        if (param1Boolean1 && param1Boolean2 && bigDecimal.compareTo(this.c) == -1)
          c(str3); 
        if (bigDecimal.compareTo(this.d) == 1)
          c(str2); 
        param1String = null;
      } catch (Exception exception) {
        str1 = "";
      } 
      return str1;
    }
    
    private static boolean b(String param1String) {
      return (param1String != null && param1String.contains("."));
    }
    
    private void c(String param1String) {
      this.b.c(param1String);
      Selection.setSelection((Spannable)this.b.c(), this.b.b().length());
    }
    
    public final CharSequence filter(CharSequence param1CharSequence, int param1Int1, int param1Int2, Spanned param1Spanned, int param1Int3, int param1Int4) {
      boolean bool1 = true;
      boolean bool2 = false;
      if (param1CharSequence != null && param1CharSequence.equals("")) {
        param1CharSequence = param1Spanned.subSequence(0, param1Int3).toString() + param1CharSequence.subSequence(param1Int1, param1Int2).toString() + param1Spanned.subSequence(param1Int4, param1Spanned.length());
        bool1 = bool2;
        if (param1Int4 - param1Int3 != 1)
          bool1 = true; 
        return a((String)param1CharSequence, true, bool1);
      } 
      int i = param1Int2 - param1Int1;
      boolean bool3 = b(param1Spanned.toString());
      if (1 == i) {
        if (!bool3 && param1Spanned.length() == 1 && param1Spanned.charAt(0) == '0')
          return "."; 
        if ('0' == param1CharSequence.charAt(0) && param1Int3 == 0 && param1Int4 == 0 && param1Spanned.length() != 0)
          return ""; 
        if ('.' == param1CharSequence.charAt(0)) {
          if (param1Spanned.length() == 0)
            return ""; 
          if (param1Spanned.length() != 0 && param1Spanned.length() - param1Int3 > 2)
            return ""; 
        } 
        if (bool3 && param1Int3 > param1Spanned.toString().indexOf(".") && a(param1Spanned.toString()) > 2 - i)
          return ""; 
      } else {
        bool2 = b(param1CharSequence.toString());
        if (bool2 && bool3)
          return ""; 
        if (bool2 && (a(param1CharSequence.toString()) > 2 || param1Spanned.toString().length() != param1Int4))
          return ""; 
      } 
      param1CharSequence = param1Spanned.subSequence(0, param1Int3).toString() + param1CharSequence.subSequence(param1Int1, param1Int2).toString() + param1Spanned.subSequence(param1Int4, param1Spanned.length());
      if (a((String)param1CharSequence) != 2)
        bool1 = false; 
      return a((String)param1CharSequence, false, bool1);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\widgets\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */