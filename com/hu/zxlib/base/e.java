package com.hu.zxlib.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.os.AsyncTask;

public final class e {
  private static final String a = "e";
  
  private static final long b = 300000L;
  
  private final Activity c;
  
  private final BroadcastReceiver d;
  
  private boolean e;
  
  private AsyncTask<Object, Object, Object> f;
  
  public e(Activity paramActivity) {
    this.c = paramActivity;
    this.d = new h(this, null);
    this.e = false;
    a();
  }
  
  private void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Landroid/os/AsyncTask;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 22
    //   11: aload_1
    //   12: iconst_1
    //   13: invokevirtual cancel : (Z)Z
    //   16: pop
    //   17: aload_0
    //   18: aconst_null
    //   19: putfield f : Landroid/os/AsyncTask;
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	25	finally
    //   11	22	25	finally
  }
  
  @SuppressLint({"NewApi"})
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial f : ()V
    //   6: new com/hu/zxlib/base/g
    //   9: astore_1
    //   10: aload_1
    //   11: aload_0
    //   12: aconst_null
    //   13: invokespecial <init> : (Lcom/hu/zxlib/base/e;Lcom/hu/zxlib/base/f;)V
    //   16: aload_0
    //   17: aload_1
    //   18: putfield f : Landroid/os/AsyncTask;
    //   21: aload_0
    //   22: getfield f : Landroid/os/AsyncTask;
    //   25: iconst_0
    //   26: anewarray java/lang/Object
    //   29: invokevirtual execute : ([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   2	33	36	finally
  }
  
  public void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial f : ()V
    //   6: aload_0
    //   7: getfield e : Z
    //   10: ifeq -> 32
    //   13: aload_0
    //   14: getfield c : Landroid/app/Activity;
    //   17: aload_0
    //   18: getfield d : Landroid/content/BroadcastReceiver;
    //   21: invokevirtual unregisterReceiver : (Landroid/content/BroadcastReceiver;)V
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield e : Z
    //   29: goto -> 41
    //   32: getstatic com/hu/zxlib/base/e.a : Ljava/lang/String;
    //   35: ldc 'PowerStatusReceiver was never registered?'
    //   37: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	44	finally
    //   32	41	44	finally
  }
  
  public void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Z
    //   6: ifeq -> 21
    //   9: getstatic com/hu/zxlib/base/e.a : Ljava/lang/String;
    //   12: ldc 'PowerStatusReceiver was already registered?'
    //   14: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   17: pop
    //   18: goto -> 53
    //   21: aload_0
    //   22: getfield c : Landroid/app/Activity;
    //   25: astore_1
    //   26: aload_0
    //   27: getfield d : Landroid/content/BroadcastReceiver;
    //   30: astore_2
    //   31: new android/content/IntentFilter
    //   34: astore_3
    //   35: aload_3
    //   36: ldc 'android.intent.action.BATTERY_CHANGED'
    //   38: invokespecial <init> : (Ljava/lang/String;)V
    //   41: aload_1
    //   42: aload_2
    //   43: aload_3
    //   44: invokevirtual registerReceiver : (Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   47: pop
    //   48: aload_0
    //   49: iconst_1
    //   50: putfield e : Z
    //   53: aload_0
    //   54: invokevirtual a : ()V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	60	finally
    //   21	53	60	finally
    //   53	57	60	finally
  }
  
  public void d() {
    f();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\base\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */