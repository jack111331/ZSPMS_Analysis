package com.alipay.sdk.app.statistic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.tid.b;
import com.alipay.sdk.util.a;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c {
  public static final String A = "BindWaitTimeoutEx";
  
  public static final String B = "CheckClientExistEx";
  
  public static final String C = "CheckClientSignEx";
  
  public static final String D = "GetInstalledAppEx";
  
  public static final String E = "GetInstalledAppEx";
  
  public static final String F = "partner";
  
  public static final String G = "out_trade_no";
  
  public static final String H = "trade_no";
  
  public static final String a = "net";
  
  public static final String b = "biz";
  
  public static final String c = "cp";
  
  public static final String d = "auth";
  
  public static final String e = "third";
  
  public static final String f = "FormatResultEx";
  
  public static final String g = "GetApdidEx";
  
  public static final String h = "GetApdidNull";
  
  public static final String i = "GetApdidTimeout";
  
  public static final String j = "GetUtdidEx";
  
  public static final String k = "GetPackageInfoEx";
  
  public static final String l = "NotIncludeSignatures";
  
  public static final String m = "GetInstalledPackagesEx";
  
  public static final String n = "GetPublicKeyFromSignEx";
  
  public static final String o = "H5PayNetworkError";
  
  public static final String p = "H5AuthNetworkError";
  
  public static final String q = "SSLError";
  
  public static final String r = "H5PayDataAnalysisError";
  
  public static final String s = "H5AuthDataAnalysisError";
  
  public static final String t = "PublicKeyUnmatch";
  
  public static final String u = "ClientBindFailed";
  
  public static final String v = "TriDesEncryptError";
  
  public static final String w = "TriDesDecryptError";
  
  public static final String x = "ClientBindException";
  
  public static final String y = "SaveTradeTokenError";
  
  public static final String z = "ClientBindServiceFailed";
  
  String I;
  
  String J;
  
  String K;
  
  String L;
  
  String M;
  
  String N;
  
  String O;
  
  String P;
  
  String Q = "";
  
  String R;
  
  public c(Context paramContext) {
    Context context = paramContext;
    if (paramContext != null)
      context = paramContext.getApplicationContext(); 
    this.I = String.format("123456789,%s", new Object[] { (new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss")).format(new Date()) });
    this.K = a(context);
    this.L = String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", new Object[] { a("15.5.2"), a("h.a.3.5.2") });
    this.M = String.format("%s,%s,-,-,-", new Object[] { a((b.a()).a), a(b.a().c()) });
    this.N = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[] { a(a.d(context)), "android", a(Build.VERSION.RELEASE), a(Build.MODEL), "-", a(a.a(context).a()), a((a.b(context)).p), "gw", a(a.a(context).b()) });
    this.O = "-";
    this.P = "-";
    this.R = "-";
  }
  
  private static String a(Context paramContext) {
    String str1 = "-";
    String str2 = "-";
    String str3 = str2;
    String str4 = str1;
    if (paramContext != null) {
      str4 = str1;
      try {
        Context context = paramContext.getApplicationContext();
        str4 = str1;
        String str5 = context.getPackageName();
        str4 = str5;
        String str6 = (context.getPackageManager().getPackageInfo(str5, 0)).versionName;
        str4 = str5;
      } catch (Throwable throwable) {
        str3 = str2;
      } 
    } 
    return String.format("%s,%s,-,-,-", new Object[] { str4, str3 });
  }
  
  static String a(String paramString) {
    return TextUtils.isEmpty(paramString) ? "" : paramString.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("-", "=").replace("^", "~");
  }
  
  static String a(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    try {
      stringBuffer.append(paramThrowable.getClass().getName()).append(":");
      stringBuffer.append(paramThrowable.getMessage());
      stringBuffer.append(" 》 ");
      StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
      if (arrayOfStackTraceElement != null)
        for (byte b = 0; b < arrayOfStackTraceElement.length; b++) {
          StringBuilder stringBuilder = new StringBuilder();
          this();
          stringBuffer.append(stringBuilder.append(arrayOfStackTraceElement[b].toString()).append(" 》 ").toString());
        }  
    } catch (Throwable throwable) {}
    return stringBuffer.toString();
  }
  
  private void a(String paramString1, String paramString2, Throwable paramThrowable, String paramString3) {
    a(paramString1, paramString2, a(paramThrowable), paramString3);
  }
  
  private boolean a() {
    return TextUtils.isEmpty(this.Q);
  }
  
  @SuppressLint({"SimpleDateFormat"})
  private static String b() {
    return String.format("123456789,%s", new Object[] { (new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss")).format(new Date()) });
  }
  
  private static String b(Context paramContext) {
    return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[] { a(a.d(paramContext)), "android", a(Build.VERSION.RELEASE), a(Build.MODEL), "-", a(a.a(paramContext).a()), a((a.b(paramContext)).p), "gw", a(a.a(paramContext).b()) });
  }
  
  private String b(String paramString) {
    String str3;
    String str1 = null;
    String str2 = null;
    if (TextUtils.isEmpty(this.Q))
      return ""; 
    String[] arrayOfString = paramString.split("&");
    if (arrayOfString != null) {
      int i = arrayOfString.length;
      byte b = 0;
      paramString = null;
      while (true) {
        str1 = str2;
        str3 = paramString;
        if (b < i) {
          String[] arrayOfString1 = arrayOfString[b].split("=");
          str3 = str2;
          str1 = paramString;
          if (arrayOfString1 != null) {
            str3 = str2;
            str1 = paramString;
            if (arrayOfString1.length == 2)
              if (arrayOfString1[0].equalsIgnoreCase("partner")) {
                arrayOfString1[1].replace("\"", "");
                str1 = paramString;
                str3 = str2;
              } else if (arrayOfString1[0].equalsIgnoreCase("out_trade_no")) {
                str1 = arrayOfString1[1].replace("\"", "");
                str3 = str2;
              } else {
                str3 = str2;
                str1 = paramString;
                if (arrayOfString1[0].equalsIgnoreCase("trade_no")) {
                  str3 = arrayOfString1[1].replace("\"", "");
                  str1 = paramString;
                } 
              }  
          } 
          b++;
          str2 = str3;
          paramString = str1;
          continue;
        } 
        break;
      } 
    } else {
      str3 = null;
    } 
    paramString = a(str1);
    str2 = a(str3);
    this.J = String.format("%s,%s,-,%s,-,-,-", new Object[] { paramString, str2, a(str2) });
    return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", new Object[] { this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R });
  }
  
  private static String c() {
    return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", new Object[] { a("15.5.2"), a("h.a.3.5.2") });
  }
  
  private static String c(String paramString) {
    String str3;
    String str1 = null;
    String str2 = null;
    String[] arrayOfString = paramString.split("&");
    if (arrayOfString != null) {
      int i = arrayOfString.length;
      byte b = 0;
      paramString = null;
      while (true) {
        str1 = str2;
        str3 = paramString;
        if (b < i) {
          String[] arrayOfString1 = arrayOfString[b].split("=");
          str3 = str2;
          str1 = paramString;
          if (arrayOfString1 != null) {
            str3 = str2;
            str1 = paramString;
            if (arrayOfString1.length == 2)
              if (arrayOfString1[0].equalsIgnoreCase("partner")) {
                arrayOfString1[1].replace("\"", "");
                str1 = paramString;
                str3 = str2;
              } else if (arrayOfString1[0].equalsIgnoreCase("out_trade_no")) {
                str1 = arrayOfString1[1].replace("\"", "");
                str3 = str2;
              } else {
                str3 = str2;
                str1 = paramString;
                if (arrayOfString1[0].equalsIgnoreCase("trade_no")) {
                  str3 = arrayOfString1[1].replace("\"", "");
                  str1 = paramString;
                } 
              }  
          } 
          b++;
          str2 = str3;
          paramString = str1;
          continue;
        } 
        break;
      } 
    } else {
      str3 = null;
    } 
    paramString = a(str1);
    str2 = a(str3);
    return String.format("%s,%s,-,%s,-,-,-", new Object[] { paramString, str2, a(str2) });
  }
  
  private static String d() {
    return String.format("%s,%s,-,-,-", new Object[] { a((b.a()).a), a(b.a().c()) });
  }
  
  public final void a(String paramString1, String paramString2, String paramString3) {
    a(paramString1, paramString2, paramString3, "-");
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4) {
    String str = "";
    if (!TextUtils.isEmpty(this.Q))
      str = "" + "^"; 
    paramString1 = str + String.format("%s,%s,%s,%s", new Object[] { paramString1, paramString2, a(paramString3), paramString4 });
    this.Q += paramString1;
  }
  
  public final void a(String paramString1, String paramString2, Throwable paramThrowable) {
    a(paramString1, paramString2, a(paramThrowable));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\app\statistic\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */