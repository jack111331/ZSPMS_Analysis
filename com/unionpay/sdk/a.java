package com.unionpay.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.io.File;

public class a {
  private static volatile a a = null;
  
  private PackageInfo b = null;
  
  public static a a() {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/a.a : Lcom/unionpay/sdk/a;
    //   3: ifnonnull -> 30
    //   6: ldc com/unionpay/sdk/a
    //   8: monitorenter
    //   9: getstatic com/unionpay/sdk/a.a : Lcom/unionpay/sdk/a;
    //   12: ifnonnull -> 27
    //   15: new com/unionpay/sdk/a
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/unionpay/sdk/a.a : Lcom/unionpay/sdk/a;
    //   27: ldc com/unionpay/sdk/a
    //   29: monitorexit
    //   30: getstatic com/unionpay/sdk/a.a : Lcom/unionpay/sdk/a;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/unionpay/sdk/a
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
  }
  
  private boolean i(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/content/pm/PackageInfo;
    //   6: ifnonnull -> 26
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   14: aload_1
    //   15: invokevirtual getPackageName : ()Ljava/lang/String;
    //   18: bipush #64
    //   20: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   23: putfield b : Landroid/content/pm/PackageInfo;
    //   26: iconst_1
    //   27: istore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_2
    //   31: ireturn
    //   32: astore_1
    //   33: iconst_0
    //   34: istore_2
    //   35: goto -> 28
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	32	java/lang/Throwable
    //   2	26	38	finally
  }
  
  public String a(Context paramContext) {
    if (paramContext == null)
      return null; 
    i(paramContext);
    return paramContext.getPackageName();
  }
  
  public int b(Context paramContext) {
    byte b = -1;
    if (paramContext == null)
      return b; 
    int i = b;
    try {
      if (i(paramContext))
        i = this.b.versionCode; 
    } catch (Throwable throwable) {
      i = b;
    } 
    return i;
  }
  
  public String c(Context paramContext) {
    String str;
    if (paramContext == null)
      return "unknown"; 
    try {
      if (!i(paramContext))
        return "unknown"; 
      str = this.b.versionName;
    } catch (Throwable throwable) {
      str = "unknown";
    } 
    return str;
  }
  
  public long d(Context paramContext) {
    long l1 = -1L;
    if (paramContext == null)
      return l1; 
    long l2 = l1;
    try {
      if (i(paramContext)) {
        l2 = l1;
        if (k.a(9))
          l2 = this.b.firstInstallTime; 
      } 
    } catch (Throwable throwable) {
      l2 = l1;
    } 
    return l2;
  }
  
  public long e(Context paramContext) {
    long l1 = -1L;
    if (paramContext == null)
      return l1; 
    long l2 = l1;
    try {
      if (i(paramContext)) {
        l2 = l1;
        if (k.a(9))
          l2 = this.b.lastUpdateTime; 
      } 
    } catch (Throwable throwable) {
      l2 = l1;
    } 
    return l2;
  }
  
  public long f(Context paramContext) {
    long l2;
    long l1 = -1L;
    if (paramContext == null)
      return l1; 
    try {
      i(paramContext);
      String str = (paramContext.getApplicationInfo()).sourceDir;
      File file = new File();
      this(str);
      l2 = file.length();
    } catch (Throwable throwable) {
      l2 = l1;
    } 
    return l2;
  }
  
  public String g(Context paramContext) {
    String str1 = null;
    if (paramContext == null)
      return str1; 
    String str2 = str1;
    try {
      if (i(paramContext)) {
        Signature[] arrayOfSignature = this.b.signatures;
        str2 = str1;
        if (arrayOfSignature.length > 0) {
          StringBuffer stringBuffer = new StringBuffer();
          this();
          stringBuffer.append(arrayOfSignature[0].toCharsString());
          String str = stringBuffer.toString();
        } 
      } 
    } catch (Throwable throwable) {
      str2 = str1;
    } 
    return str2;
  }
  
  public String h(Context paramContext) {
    Context context1;
    Context context2 = null;
    if (paramContext == null)
      return (String)context2; 
    try {
      i(paramContext);
      String str = paramContext.getApplicationInfo().loadLabel(paramContext.getPackageManager()).toString();
    } catch (Throwable throwable) {
      context1 = context2;
    } 
    return (String)context1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */