package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.utils.d;
import java.io.File;

public class f {
  public static f a = null;
  
  protected static final b c;
  
  private static boolean d = false;
  
  protected a b = new a(c);
  
  static {
    int i = c.m;
    long l = c.n;
    c = new b(c(), i, c.g, c.h, c.c, c.i, 10, c.e, l);
  }
  
  public static f a() {
    // Byte code:
    //   0: getstatic com/tencent/open/a/f.a : Lcom/tencent/open/a/f;
    //   3: ifnonnull -> 34
    //   6: ldc com/tencent/open/a/f
    //   8: monitorenter
    //   9: getstatic com/tencent/open/a/f.a : Lcom/tencent/open/a/f;
    //   12: ifnonnull -> 31
    //   15: new com/tencent/open/a/f
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/tencent/open/a/f.a : Lcom/tencent/open/a/f;
    //   27: iconst_1
    //   28: putstatic com/tencent/open/a/f.d : Z
    //   31: ldc com/tencent/open/a/f
    //   33: monitorexit
    //   34: getstatic com/tencent/open/a/f.a : Lcom/tencent/open/a/f;
    //   37: areturn
    //   38: astore_0
    //   39: ldc com/tencent/open/a/f
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   9	31	38	finally
    //   31	34	38	finally
    //   39	42	38	finally
  }
  
  public static final void a(String paramString1, String paramString2) {
    a().a(1, paramString1, paramString2, null);
  }
  
  public static final void a(String paramString1, String paramString2, Throwable paramThrowable) {
    a().a(2, paramString1, paramString2, paramThrowable);
  }
  
  public static void b() {
    // Byte code:
    //   0: ldc com/tencent/open/a/f
    //   2: monitorenter
    //   3: invokestatic a : ()Lcom/tencent/open/a/f;
    //   6: invokevirtual d : ()V
    //   9: getstatic com/tencent/open/a/f.a : Lcom/tencent/open/a/f;
    //   12: ifnull -> 19
    //   15: aconst_null
    //   16: putstatic com/tencent/open/a/f.a : Lcom/tencent/open/a/f;
    //   19: ldc com/tencent/open/a/f
    //   21: monitorexit
    //   22: return
    //   23: astore_0
    //   24: ldc com/tencent/open/a/f
    //   26: monitorexit
    //   27: aload_0
    //   28: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	23	finally
    //   19	22	23	finally
    //   24	27	23	finally
  }
  
  public static final void b(String paramString1, String paramString2) {
    a().a(2, paramString1, paramString2, null);
  }
  
  public static final void b(String paramString1, String paramString2, Throwable paramThrowable) {
    a().a(16, paramString1, paramString2, paramThrowable);
  }
  
  protected static File c() {
    boolean bool = false;
    String str = c.d;
    try {
      d.c c = d.b.b();
      boolean bool1 = bool;
      if (c != null) {
        long l1 = c.c();
        long l2 = c.f;
        bool1 = bool;
        if (l1 > l2)
          bool1 = true; 
      } 
      if (bool1)
        return new File(Environment.getExternalStorageDirectory(), str); 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      boolean bool1 = bool;
      if (bool1)
        return new File(Environment.getExternalStorageDirectory(), str); 
    } 
    return new File(d.c(), str);
  }
  
  public static final void c(String paramString1, String paramString2) {
    a().a(4, paramString1, paramString2, null);
  }
  
  public static final void d(String paramString1, String paramString2) {
    a().a(8, paramString1, paramString2, null);
  }
  
  public static final void e(String paramString1, String paramString2) {
    a().a(16, paramString1, paramString2, null);
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable) {
    if (d) {
      String str = d.b();
      if (!TextUtils.isEmpty(str)) {
        str = str + " SDK_VERSION:" + "3.3.0.lite";
        if (this.b != null) {
          e.a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str, null);
          this.b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str, null);
          d = false;
        } else {
          return;
        } 
      } 
    } 
    e.a.b(paramInt, Thread.currentThread(), System.currentTimeMillis(), paramString1, paramString2, paramThrowable);
    if (d.a.a(c.b, paramInt) && this.b != null)
      this.b.b(paramInt, Thread.currentThread(), System.currentTimeMillis(), paramString1, paramString2, paramThrowable); 
  }
  
  protected void d() {
    if (this.b != null) {
      this.b.a();
      this.b.b();
      this.b = null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\open\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */