package com.unionpay.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import java.io.ByteArrayOutputStream;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

class c {
  private static volatile c f = null;
  
  private static i g = null;
  
  private static Handler n = null;
  
  private static HandlerThread o;
  
  private final String a = "140.207.168.45";
  
  private final String b = "140.207.168.45";
  
  private final String c = "http";
  
  private final String d = "http://140.207.168.45/g/d";
  
  private volatile boolean e = false;
  
  private ar h = new a(this, "140.207.168.45", "140.207.168.45", "http://140.207.168.45/g/d");
  
  private final int i = 30000;
  
  private int j = 30000;
  
  private boolean k = false;
  
  private long l = SystemClock.elapsedRealtime() - this.j;
  
  private Random m = new Random();
  
  private FileLock p = null;
  
  private final String q = "";
  
  static {
    HandlerThread handlerThread = new HandlerThread("prepareSubmitHandlerThread");
    o = handlerThread;
    handlerThread.start();
    n = new q(o.getLooper());
    try {
      ah.a().register(a());
    } catch (Throwable throwable) {}
  }
  
  static c a() {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/c.f : Lcom/unionpay/sdk/c;
    //   3: ifnonnull -> 30
    //   6: ldc com/unionpay/sdk/c
    //   8: monitorenter
    //   9: getstatic com/unionpay/sdk/c.f : Lcom/unionpay/sdk/c;
    //   12: ifnonnull -> 27
    //   15: new com/unionpay/sdk/c
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/unionpay/sdk/c.f : Lcom/unionpay/sdk/c;
    //   27: ldc com/unionpay/sdk/c
    //   29: monitorexit
    //   30: getstatic com/unionpay/sdk/c.f : Lcom/unionpay/sdk/c;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/unionpay/sdk/c
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic com/unionpay/sdk/ab.d : Ljava/nio/channels/FileChannel;
    //   17: ifnull -> 30
    //   20: aload_0
    //   21: getstatic com/unionpay/sdk/ab.d : Ljava/nio/channels/FileChannel;
    //   24: invokevirtual tryLock : ()Ljava/nio/channels/FileLock;
    //   27: putfield p : Ljava/nio/channels/FileLock;
    //   30: aload_0
    //   31: getfield p : Ljava/nio/channels/FileLock;
    //   34: ifnull -> 218
    //   37: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   40: invokestatic c : (Landroid/content/Context;)Z
    //   43: ifeq -> 11
    //   46: invokestatic d : ()Lcom/unionpay/sdk/bc;
    //   49: invokestatic a : (Lcom/unionpay/sdk/as;)Lcom/unionpay/sdk/m$f;
    //   52: astore_2
    //   53: new com/unionpay/sdk/ba
    //   56: astore_3
    //   57: aload_3
    //   58: invokespecial <init> : ()V
    //   61: aload_3
    //   62: aload_0
    //   63: getfield h : Lcom/unionpay/sdk/ar;
    //   66: getfield b : Ljava/lang/String;
    //   69: putfield c : Ljava/lang/String;
    //   72: aload_3
    //   73: aload_0
    //   74: getfield h : Lcom/unionpay/sdk/ar;
    //   77: getfield c : Ljava/lang/String;
    //   80: putfield b : Ljava/lang/String;
    //   83: aload_3
    //   84: aload_0
    //   85: getfield h : Lcom/unionpay/sdk/ar;
    //   88: getfield d : Ljava/lang/String;
    //   91: putfield a : Ljava/lang/String;
    //   94: aload_3
    //   95: ldc 'Analytics'
    //   97: putfield d : Ljava/lang/String;
    //   100: aload_3
    //   101: ldc ''
    //   103: putfield e : Ljava/lang/String;
    //   106: aload_3
    //   107: aload_2
    //   108: putfield g : Ljava/lang/Object;
    //   111: aload_2
    //   112: ifnonnull -> 173
    //   115: ldc 'No new data found!'
    //   117: invokestatic a : (Ljava/lang/String;)V
    //   120: aload_3
    //   121: aconst_null
    //   122: putfield f : [B
    //   125: invokestatic obtain : ()Landroid/os/Message;
    //   128: astore #4
    //   130: aload #4
    //   132: aload_3
    //   133: putfield obj : Ljava/lang/Object;
    //   136: aload #4
    //   138: bipush #103
    //   140: putfield what : I
    //   143: invokestatic a : ()Landroid/os/Handler;
    //   146: aload #4
    //   148: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   151: pop
    //   152: aload_0
    //   153: iconst_1
    //   154: putfield e : Z
    //   157: goto -> 11
    //   160: astore_3
    //   161: aload_0
    //   162: invokespecial c : ()V
    //   165: goto -> 11
    //   168: astore_3
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_3
    //   172: athrow
    //   173: ldc 'New data found, Submitting...'
    //   175: invokestatic a : (Ljava/lang/String;)V
    //   178: new java/util/HashMap
    //   181: astore #4
    //   183: aload #4
    //   185: invokespecial <init> : ()V
    //   188: aload #4
    //   190: ldc 'entity'
    //   192: aload_2
    //   193: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   196: pop
    //   197: aload_3
    //   198: aload_0
    //   199: getfield h : Lcom/unionpay/sdk/ar;
    //   202: aload #4
    //   204: invokevirtual a : (Ljava/util/HashMap;)[B
    //   207: putfield f : [B
    //   210: aload_3
    //   211: iconst_1
    //   212: putfield h : Z
    //   215: goto -> 125
    //   218: getstatic com/unionpay/sdk/UPAgent.LOG_ON : Z
    //   221: ifeq -> 11
    //   224: ldc 'UPLog'
    //   226: ldc 'Aborted submitting, file cannot be accessed due to lock.'
    //   228: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   231: pop
    //   232: goto -> 11
    // Exception table:
    //   from	to	target	type
    //   2	7	168	finally
    //   14	30	160	java/lang/Throwable
    //   14	30	168	finally
    //   30	111	160	java/lang/Throwable
    //   30	111	168	finally
    //   115	125	160	java/lang/Throwable
    //   115	125	168	finally
    //   125	157	160	java/lang/Throwable
    //   125	157	168	finally
    //   161	165	168	finally
    //   173	215	160	java/lang/Throwable
    //   173	215	168	finally
    //   218	232	160	java/lang/Throwable
    //   218	232	168	finally
  }
  
  private void c() {
    if (this.p != null)
      try {
        this.p.release();
      } catch (Throwable throwable) {} 
  }
  
  final void a(boolean paramBoolean) {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: iconst_1
    //   3: istore #4
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic obtain : ()Landroid/os/Message;
    //   10: astore #5
    //   12: iload_1
    //   13: ifeq -> 104
    //   16: aload #5
    //   18: iload #4
    //   20: putfield what : I
    //   23: iload_1
    //   24: ifne -> 110
    //   27: invokestatic elapsedRealtime : ()J
    //   30: aload_0
    //   31: getfield l : J
    //   34: lsub
    //   35: lstore #6
    //   37: lload #6
    //   39: lconst_0
    //   40: lcmp
    //   41: iflt -> 101
    //   44: lload_2
    //   45: lstore #8
    //   47: aload_0
    //   48: getfield l : J
    //   51: lconst_0
    //   52: lcmp
    //   53: ifle -> 76
    //   56: lload_2
    //   57: lstore #8
    //   59: lload #6
    //   61: ldc2_w 120000
    //   64: lcmp
    //   65: ifge -> 76
    //   68: ldc2_w 120000
    //   71: lload #6
    //   73: lsub
    //   74: lstore #8
    //   76: getstatic com/unionpay/sdk/c.n : Landroid/os/Handler;
    //   79: iconst_0
    //   80: invokevirtual removeMessages : (I)V
    //   83: getstatic com/unionpay/sdk/c.n : Landroid/os/Handler;
    //   86: iconst_1
    //   87: invokevirtual removeMessages : (I)V
    //   90: getstatic com/unionpay/sdk/c.n : Landroid/os/Handler;
    //   93: aload #5
    //   95: lload #8
    //   97: invokevirtual sendMessageDelayed : (Landroid/os/Message;J)Z
    //   100: pop
    //   101: aload_0
    //   102: monitorexit
    //   103: return
    //   104: iconst_0
    //   105: istore #4
    //   107: goto -> 16
    //   110: aload_0
    //   111: getfield k : Z
    //   114: ifeq -> 124
    //   117: aload_0
    //   118: sipush #30000
    //   121: putfield j : I
    //   124: invokestatic elapsedRealtime : ()J
    //   127: aload_0
    //   128: getfield l : J
    //   131: lsub
    //   132: aload_0
    //   133: getfield j : I
    //   136: i2l
    //   137: lcmp
    //   138: ifle -> 101
    //   141: getstatic com/unionpay/sdk/c.n : Landroid/os/Handler;
    //   144: iconst_0
    //   145: invokevirtual removeMessages : (I)V
    //   148: getstatic com/unionpay/sdk/c.n : Landroid/os/Handler;
    //   151: iconst_1
    //   152: invokevirtual removeMessages : (I)V
    //   155: getstatic com/unionpay/sdk/c.n : Landroid/os/Handler;
    //   158: aload #5
    //   160: invokevirtual sendMessage : (Landroid/os/Message;)Z
    //   163: pop
    //   164: goto -> 101
    //   167: astore #5
    //   169: aload_0
    //   170: monitorexit
    //   171: aload #5
    //   173: athrow
    // Exception table:
    //   from	to	target	type
    //   7	12	167	finally
    //   16	23	167	finally
    //   27	37	167	finally
    //   47	56	167	finally
    //   76	101	167	finally
    //   110	124	167	finally
    //   124	164	167	finally
  }
  
  public final void onTDEBEventResponse(bb parambb) {
    try {
      this.l = SystemClock.elapsedRealtime();
      if (parambb != null) {
        if (parambb.a != null && String.valueOf(parambb.a.get("action")).equals("Analytics"))
          if (Integer.valueOf(String.valueOf(parambb.a.get("statusCode"))).intValue() == 200) {
            ay.a("Data submitting Succeed!");
            m.f f1 = null;
            m.f f2 = f1;
            if (parambb.b != null) {
              f2 = f1;
              if (parambb.b instanceof m.f)
                f2 = (m.f)parambb.b; 
            } 
            r.a(f2, bc.d());
            this.j = 120000;
            this.k = true;
          } else {
            this.j = this.m.nextInt(60000) - 30000 + 120000;
            ay.a("Data submitting Failed!");
            this.k = false;
          }  
        f.c(ab.mContext);
        if (az.g() != null && !az.g().equals("2"))
          a(false); 
      } 
      c();
      this.e = false;
    } catch (Throwable throwable) {}
  }
  
  final class a extends ar {
    a(c this$0, String param1String1, String param1String2, String param1String3) {
      this.b = param1String1;
      this.c = param1String2;
      this.d = param1String3;
      this.e = 1;
    }
    
    final byte[] a(HashMap param1HashMap) {
      try {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this(1024);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream();
        this(byteArrayOutputStream);
        p p = new p();
        this(gZIPOutputStream);
        if (param1HashMap.containsKey("entity") && param1HashMap.get("entity") != null && param1HashMap.get("entity") instanceof m.f) {
          p.a((m.f)param1HashMap.get("entity"));
          gZIPOutputStream.finish();
          gZIPOutputStream.close();
          return byteArrayOutputStream.toByteArray();
        } 
        param1HashMap = null;
      } catch (Throwable throwable) {
        throwable.printStackTrace();
        throwable = null;
      } 
      return (byte[])throwable;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */