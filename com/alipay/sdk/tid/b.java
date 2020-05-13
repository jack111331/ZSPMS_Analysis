package com.alipay.sdk.tid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alipay.sdk.util.a;

public final class b {
  private static b c;
  
  public String a;
  
  public String b;
  
  public static b a() {
    // Byte code:
    //   0: ldc com/alipay/sdk/tid/b
    //   2: monitorenter
    //   3: getstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   6: ifnonnull -> 153
    //   9: new com/alipay/sdk/tid/b
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   21: invokestatic a : ()Lcom/alipay/sdk/sys/b;
    //   24: getfield a : Landroid/content/Context;
    //   27: astore_0
    //   28: new com/alipay/sdk/tid/a
    //   31: astore_1
    //   32: aload_1
    //   33: aload_0
    //   34: invokespecial <init> : (Landroid/content/Context;)V
    //   37: aload_0
    //   38: invokestatic a : (Landroid/content/Context;)Lcom/alipay/sdk/util/a;
    //   41: invokevirtual a : ()Ljava/lang/String;
    //   44: astore_2
    //   45: aload_0
    //   46: invokestatic a : (Landroid/content/Context;)Lcom/alipay/sdk/util/a;
    //   49: invokevirtual b : ()Ljava/lang/String;
    //   52: astore_3
    //   53: getstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   56: aload_1
    //   57: aload_2
    //   58: aload_3
    //   59: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   62: putfield a : Ljava/lang/String;
    //   65: getstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   68: aload_1
    //   69: aload_2
    //   70: aload_3
    //   71: invokevirtual b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: putfield b : Ljava/lang/String;
    //   77: getstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   80: getfield b : Ljava/lang/String;
    //   83: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   86: ifeq -> 135
    //   89: getstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   92: astore #4
    //   94: invokestatic currentTimeMillis : ()J
    //   97: invokestatic toHexString : (J)Ljava/lang/String;
    //   100: astore #5
    //   102: aload #5
    //   104: astore_0
    //   105: aload #5
    //   107: invokevirtual length : ()I
    //   110: bipush #10
    //   112: if_icmple -> 129
    //   115: aload #5
    //   117: aload #5
    //   119: invokevirtual length : ()I
    //   122: bipush #10
    //   124: isub
    //   125: invokevirtual substring : (I)Ljava/lang/String;
    //   128: astore_0
    //   129: aload #4
    //   131: aload_0
    //   132: putfield b : Ljava/lang/String;
    //   135: aload_1
    //   136: aload_2
    //   137: aload_3
    //   138: getstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   141: getfield a : Ljava/lang/String;
    //   144: getstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   147: getfield b : Ljava/lang/String;
    //   150: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   153: getstatic com/alipay/sdk/tid/b.c : Lcom/alipay/sdk/tid/b;
    //   156: astore_0
    //   157: ldc com/alipay/sdk/tid/b
    //   159: monitorexit
    //   160: aload_0
    //   161: areturn
    //   162: astore_0
    //   163: ldc com/alipay/sdk/tid/b
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    // Exception table:
    //   from	to	target	type
    //   3	102	162	finally
    //   105	129	162	finally
    //   129	135	162	finally
    //   135	153	162	finally
    //   153	157	162	finally
  }
  
  private void a(Context paramContext) {
    a a = new a(paramContext);
    try {
      a.a(a.a(paramContext).a(), a.a(paramContext).b(), this.a, this.b);
      return;
    } catch (Exception exception) {
      return;
    } finally {
      a.close();
    } 
  }
  
  private void a(String paramString) {
    this.a = paramString;
  }
  
  private String b() {
    return this.a;
  }
  
  private void b(String paramString) {
    this.b = paramString;
  }
  
  private String c() {
    return this.b;
  }
  
  private boolean d() {
    return TextUtils.isEmpty(this.a);
  }
  
  private static void e() {
    Context context = (com.alipay.sdk.sys.b.a()).a;
    String str1 = a.a(context).a();
    String str2 = a.a(context).b();
    a a = new a(context);
    SQLiteDatabase sQLiteDatabase = null;
    context = null;
    try {
      SQLiteDatabase sQLiteDatabase1 = a.getWritableDatabase();
      null = sQLiteDatabase1;
      sQLiteDatabase = sQLiteDatabase1;
      a.a(sQLiteDatabase1, str1, str2, "", "");
      null = sQLiteDatabase1;
      sQLiteDatabase = sQLiteDatabase1;
      a.a(sQLiteDatabase1, a.c(str1, str2));
      if (sQLiteDatabase1 != null && sQLiteDatabase1.isOpen())
        sQLiteDatabase1.close(); 
      return;
    } catch (Exception exception) {
      if (null != null && null.isOpen())
        null.close(); 
      return;
    } finally {
      if (exception != null && exception.isOpen())
        exception.close(); 
    } 
  }
  
  private static String f() {
    String str1 = Long.toHexString(System.currentTimeMillis());
    String str2 = str1;
    if (str1.length() > 10)
      str2 = str1.substring(str1.length() - 10); 
    return str2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\tid\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */