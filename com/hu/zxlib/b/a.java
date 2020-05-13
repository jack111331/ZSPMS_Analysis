package com.hu.zxlib.b;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.Collection;

final class a implements Camera.AutoFocusCallback {
  private static final String a = "a";
  
  private static final long b = 1000L;
  
  private static final Collection<String> c = new ArrayList<String>(2);
  
  private boolean d;
  
  private boolean e;
  
  private final boolean f;
  
  private final Camera g;
  
  private AsyncTask<?, ?, ?> h;
  
  static {
    c.add("auto");
    c.add("macro");
  }
  
  a(Camera paramCamera) {
    this.g = paramCamera;
    this.f = true;
    a();
  }
  
  @SuppressLint({"NewApi"})
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield d : Z
    //   6: ifne -> 57
    //   9: aload_0
    //   10: getfield h : Landroid/os/AsyncTask;
    //   13: ifnonnull -> 57
    //   16: new com/hu/zxlib/b/c
    //   19: astore_1
    //   20: aload_1
    //   21: aload_0
    //   22: aconst_null
    //   23: invokespecial <init> : (Lcom/hu/zxlib/b/a;Lcom/hu/zxlib/b/b;)V
    //   26: aload_1
    //   27: getstatic android/os/AsyncTask.THREAD_POOL_EXECUTOR : Ljava/util/concurrent/Executor;
    //   30: iconst_0
    //   31: anewarray java/lang/Object
    //   34: invokevirtual executeOnExecutor : (Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   37: pop
    //   38: aload_0
    //   39: aload_1
    //   40: putfield h : Landroid/os/AsyncTask;
    //   43: goto -> 57
    //   46: astore_1
    //   47: getstatic com/hu/zxlib/b/a.a : Ljava/lang/String;
    //   50: ldc 'Could not request auto focus'
    //   52: aload_1
    //   53: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   56: pop
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
    //   2	26	60	finally
    //   26	43	46	java/util/concurrent/RejectedExecutionException
    //   26	43	60	finally
    //   47	57	60	finally
  }
  
  private void d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield h : Landroid/os/AsyncTask;
    //   6: ifnull -> 36
    //   9: aload_0
    //   10: getfield h : Landroid/os/AsyncTask;
    //   13: invokevirtual getStatus : ()Landroid/os/AsyncTask$Status;
    //   16: getstatic android/os/AsyncTask$Status.FINISHED : Landroid/os/AsyncTask$Status;
    //   19: if_acmpeq -> 31
    //   22: aload_0
    //   23: getfield h : Landroid/os/AsyncTask;
    //   26: iconst_1
    //   27: invokevirtual cancel : (Z)Z
    //   30: pop
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield h : Landroid/os/AsyncTask;
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	39	finally
    //   31	36	39	finally
  }
  
  void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield f : Z
    //   6: ifeq -> 61
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield h : Landroid/os/AsyncTask;
    //   14: aload_0
    //   15: getfield d : Z
    //   18: ifne -> 61
    //   21: aload_0
    //   22: getfield e : Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne -> 61
    //   30: aload_0
    //   31: getfield g : Landroid/hardware/Camera;
    //   34: aload_0
    //   35: invokevirtual autoFocus : (Landroid/hardware/Camera$AutoFocusCallback;)V
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield e : Z
    //   43: goto -> 61
    //   46: astore_2
    //   47: getstatic com/hu/zxlib/b/a.a : Ljava/lang/String;
    //   50: ldc 'Unexpected exception while focusing'
    //   52: aload_2
    //   53: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   56: pop
    //   57: aload_0
    //   58: invokespecial c : ()V
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	64	finally
    //   30	43	46	java/lang/RuntimeException
    //   30	43	64	finally
    //   47	61	64	finally
  }
  
  void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield d : Z
    //   7: aload_0
    //   8: getfield f : Z
    //   11: ifeq -> 39
    //   14: aload_0
    //   15: invokespecial d : ()V
    //   18: aload_0
    //   19: getfield g : Landroid/hardware/Camera;
    //   22: invokevirtual cancelAutoFocus : ()V
    //   25: goto -> 39
    //   28: astore_1
    //   29: getstatic com/hu/zxlib/b/a.a : Ljava/lang/String;
    //   32: ldc 'Unexpected exception while cancelling focusing'
    //   34: aload_1
    //   35: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   38: pop
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	42	finally
    //   18	25	28	java/lang/RuntimeException
    //   18	25	42	finally
    //   29	39	42	finally
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: putfield e : Z
    //   7: aload_0
    //   8: invokespecial c : ()V
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	14	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\hu\zxlib\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */