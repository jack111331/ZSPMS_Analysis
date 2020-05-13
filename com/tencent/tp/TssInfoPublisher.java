package com.tencent.tp;

import java.util.ArrayList;

public class TssInfoPublisher implements Runnable {
  public static final int TSS_INFO_TYPE_DETECT_RESULT = 1;
  
  public static final int TSS_INFO_TYPE_HEARTBEAT = 2;
  
  private static volatile TssInfoPublisher a;
  
  private static Thread b;
  
  private static volatile boolean c;
  
  private ArrayList d = new ArrayList();
  
  public static TssInfoPublisher a() {
    // Byte code:
    //   0: getstatic com/tencent/tp/TssInfoPublisher.a : Lcom/tencent/tp/TssInfoPublisher;
    //   3: ifnonnull -> 39
    //   6: ldc com/tencent/tp/TssInfoPublisher
    //   8: monitorenter
    //   9: getstatic com/tencent/tp/TssInfoPublisher.a : Lcom/tencent/tp/TssInfoPublisher;
    //   12: ifnonnull -> 27
    //   15: new com/tencent/tp/TssInfoPublisher
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/tencent/tp/TssInfoPublisher.a : Lcom/tencent/tp/TssInfoPublisher;
    //   27: ldc com/tencent/tp/TssInfoPublisher
    //   29: monitorexit
    //   30: goto -> 39
    //   33: astore_0
    //   34: ldc com/tencent/tp/TssInfoPublisher
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    //   39: getstatic com/tencent/tp/TssInfoPublisher.a : Lcom/tencent/tp/TssInfoPublisher;
    //   42: areturn
    // Exception table:
    //   from	to	target	type
    //   9	27	33	finally
    //   27	30	33	finally
    //   34	37	33	finally
  }
  
  private void a(int paramInt, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull -> 5
    //   4: return
    //   5: new java/util/ArrayList
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore_3
    //   13: ldc com/tencent/tp/TssInfoPublisher
    //   15: monitorenter
    //   16: aload_3
    //   17: aload_0
    //   18: getfield d : Ljava/util/ArrayList;
    //   21: invokevirtual addAll : (Ljava/util/Collection;)Z
    //   24: pop
    //   25: ldc com/tencent/tp/TssInfoPublisher
    //   27: monitorexit
    //   28: aload_3
    //   29: invokevirtual iterator : ()Ljava/util/Iterator;
    //   32: astore_3
    //   33: aload_3
    //   34: invokeinterface hasNext : ()Z
    //   39: ifeq -> 61
    //   42: aload_3
    //   43: invokeinterface next : ()Ljava/lang/Object;
    //   48: checkcast com/tencent/tp/TssInfoPublisher$TssInfoReceiver
    //   51: iload_1
    //   52: aload_2
    //   53: invokeinterface onReceive : (ILjava/lang/String;)V
    //   58: goto -> 33
    //   61: return
    //   62: astore_2
    //   63: ldc com/tencent/tp/TssInfoPublisher
    //   65: monitorexit
    //   66: aload_2
    //   67: athrow
    // Exception table:
    //   from	to	target	type
    //   16	28	62	finally
    //   63	66	62	finally
  }
  
  private static int b() {
    try {
      return Integer.parseInt(v.a("ilc_open_pipe"));
    } catch (Exception exception) {
      return -1;
    } 
  }
  
  private static void c() {
    try {
      v.a("ilc_close_pipe");
    } catch (Exception exception) {}
  }
  
  private static String d() {
    try {
      return v.a("ilc_recv_pipe");
    } catch (Exception exception) {
      return "-1";
    } 
  }
  
  public void a(TssInfoReceiver paramTssInfoReceiver) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: ldc com/tencent/tp/TssInfoPublisher
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield d : Ljava/util/ArrayList;
    //   12: aload_1
    //   13: invokevirtual add : (Ljava/lang/Object;)Z
    //   16: pop
    //   17: ldc com/tencent/tp/TssInfoPublisher
    //   19: monitorexit
    //   20: getstatic com/tencent/tp/TssInfoPublisher.c : Z
    //   23: ifne -> 72
    //   26: ldc com/tencent/tp/TssSdk
    //   28: monitorenter
    //   29: getstatic com/tencent/tp/TssInfoPublisher.c : Z
    //   32: ifne -> 60
    //   35: iconst_1
    //   36: putstatic com/tencent/tp/TssInfoPublisher.c : Z
    //   39: new java/lang/Thread
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic a : ()Lcom/tencent/tp/TssInfoPublisher;
    //   47: invokespecial <init> : (Ljava/lang/Runnable;)V
    //   50: aload_1
    //   51: putstatic com/tencent/tp/TssInfoPublisher.b : Ljava/lang/Thread;
    //   54: getstatic com/tencent/tp/TssInfoPublisher.b : Ljava/lang/Thread;
    //   57: invokevirtual start : ()V
    //   60: ldc com/tencent/tp/TssSdk
    //   62: monitorexit
    //   63: goto -> 72
    //   66: astore_1
    //   67: ldc com/tencent/tp/TssSdk
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    //   72: return
    //   73: astore_1
    //   74: ldc com/tencent/tp/TssInfoPublisher
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Exception table:
    //   from	to	target	type
    //   8	20	73	finally
    //   29	60	66	finally
    //   60	63	66	finally
    //   67	70	66	finally
    //   74	77	73	finally
  }
  
  public void run() {
    if (b() == -1) {
      c = false;
      return;
    } 
    while (true) {
      try {
      
      } catch (Exception exception) {
      
      } finally {
        c();
        c = false;
      } 
      c();
      c = false;
      return;
    } 
  }
  
  public static interface TssInfoReceiver {
    void onReceive(int param1Int, String param1String);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\TssInfoPublisher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */