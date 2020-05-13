package com.herosdk.d;

import android.app.Activity;
import android.util.Log;
import com.herosdk.error.ErrorUtils;

public class v {
  private static final String a = "frameLib.lgsu";
  
  private static volatile v b;
  
  private static String c = "";
  
  private static Activity e = null;
  
  private String d = "";
  
  private v() {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      this.d = stringBuilder.append(x.a().y()).append(o.b("oqQAP2uOT+8NhHwMoT7/dw==", o.b())).append(k.a().d()).append(o.b("dA3C12cQWy0s1pDUpEq1RQ==", o.b())).toString();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
  
  public static v a(Activity paramActivity) {
    // Byte code:
    //   0: getstatic com/herosdk/d/v.b : Lcom/herosdk/d/v;
    //   3: ifnonnull -> 72
    //   6: ldc com/herosdk/d/v
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/v.b : Lcom/herosdk/d/v;
    //   12: ifnonnull -> 69
    //   15: aload_0
    //   16: putstatic com/herosdk/d/v.e : Landroid/app/Activity;
    //   19: new com/herosdk/d/v
    //   22: astore_0
    //   23: aload_0
    //   24: invokespecial <init> : ()V
    //   27: aload_0
    //   28: putstatic com/herosdk/d/v.b : Lcom/herosdk/d/v;
    //   31: new java/lang/StringBuilder
    //   34: astore_0
    //   35: aload_0
    //   36: invokespecial <init> : ()V
    //   39: aload_0
    //   40: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   43: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: getstatic java/io/File.separator : Ljava/lang/String;
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 'AvwldmPBPOceReYKHd4hxQ=='
    //   54: invokestatic b : ()Ljava/lang/String;
    //   57: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual toString : ()Ljava/lang/String;
    //   66: putstatic com/herosdk/d/v.c : Ljava/lang/String;
    //   69: ldc com/herosdk/d/v
    //   71: monitorexit
    //   72: getstatic com/herosdk/d/v.b : Lcom/herosdk/d/v;
    //   75: areturn
    //   76: astore_0
    //   77: ldc ''
    //   79: putstatic com/herosdk/d/v.c : Ljava/lang/String;
    //   82: goto -> 69
    //   85: astore_0
    //   86: ldc com/herosdk/d/v
    //   88: monitorexit
    //   89: aload_0
    //   90: athrow
    // Exception table:
    //   from	to	target	type
    //   9	31	85	finally
    //   31	69	76	java/lang/Exception
    //   31	69	85	finally
    //   69	72	85	finally
    //   77	82	85	finally
    //   86	89	85	finally
  }
  
  public void a() {
    try {
      Log.d("frameLib.lgsu", "cl");
      ba ba = ba.a();
      w w = new w();
      this(this);
      ba.a(w);
    } catch (Exception exception) {}
  }
  
  public void a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'frameLib.lgsu'
    //   4: ldc 'ds'
    //   6: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: new java/io/File
    //   13: astore_2
    //   14: aload_2
    //   15: getstatic com/herosdk/d/v.c : Ljava/lang/String;
    //   18: invokespecial <init> : (Ljava/lang/String;)V
    //   21: aload_2
    //   22: invokevirtual exists : ()Z
    //   25: ifeq -> 57
    //   28: aload_2
    //   29: invokevirtual isDirectory : ()Z
    //   32: ifeq -> 57
    //   35: ldc 'frameLib.lgsu'
    //   37: ldc 'ds...do'
    //   39: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: invokestatic a : ()Lcom/herosdk/d/p;
    //   46: getstatic com/herosdk/d/v.c : Ljava/lang/String;
    //   49: aload_0
    //   50: getfield d : Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual printStackTrace : ()V
    //   65: goto -> 57
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   2	57	60	java/lang/Exception
    //   2	57	68	finally
    //   61	65	68	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */