package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class Dispatcher {
  private ExecutorService executorService;
  
  private int maxRequests = 64;
  
  private int maxRequestsPerHost = 5;
  
  private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque<RealCall.AsyncCall>();
  
  private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque<RealCall.AsyncCall>();
  
  private final Deque<RealCall> runningSyncCalls = new ArrayDeque<RealCall>();
  
  public Dispatcher() {}
  
  public Dispatcher(ExecutorService paramExecutorService) {
    this.executorService = paramExecutorService;
  }
  
  private void promoteCalls() {
    if (this.runningAsyncCalls.size() < this.maxRequests && !this.readyAsyncCalls.isEmpty()) {
      Iterator<RealCall.AsyncCall> iterator = this.readyAsyncCalls.iterator();
      while (true) {
        if (iterator.hasNext()) {
          RealCall.AsyncCall asyncCall = iterator.next();
          if (runningCallsForHost(asyncCall) < this.maxRequestsPerHost) {
            iterator.remove();
            this.runningAsyncCalls.add(asyncCall);
            executorService().execute((Runnable)asyncCall);
          } 
          if (this.runningAsyncCalls.size() >= this.maxRequests)
            return; 
          continue;
        } 
        return;
      } 
    } 
  }
  
  private int runningCallsForHost(RealCall.AsyncCall paramAsyncCall) {
    byte b = 0;
    Iterator<RealCall.AsyncCall> iterator = this.runningAsyncCalls.iterator();
    while (iterator.hasNext()) {
      if (((RealCall.AsyncCall)iterator.next()).host().equals(paramAsyncCall.host()))
        b++; 
    } 
    return b;
  }
  
  public void cancelAll() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readyAsyncCalls : Ljava/util/Deque;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 41
    //   21: aload_1
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast okhttp3/RealCall$AsyncCall
    //   30: invokevirtual cancel : ()V
    //   33: goto -> 12
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: aload_0
    //   42: getfield runningAsyncCalls : Ljava/util/Deque;
    //   45: invokeinterface iterator : ()Ljava/util/Iterator;
    //   50: astore_1
    //   51: aload_1
    //   52: invokeinterface hasNext : ()Z
    //   57: ifeq -> 75
    //   60: aload_1
    //   61: invokeinterface next : ()Ljava/lang/Object;
    //   66: checkcast okhttp3/RealCall$AsyncCall
    //   69: invokevirtual cancel : ()V
    //   72: goto -> 51
    //   75: aload_0
    //   76: getfield runningSyncCalls : Ljava/util/Deque;
    //   79: invokeinterface iterator : ()Ljava/util/Iterator;
    //   84: astore_1
    //   85: aload_1
    //   86: invokeinterface hasNext : ()Z
    //   91: ifeq -> 109
    //   94: aload_1
    //   95: invokeinterface next : ()Ljava/lang/Object;
    //   100: checkcast okhttp3/RealCall
    //   103: invokevirtual cancel : ()V
    //   106: goto -> 85
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    // Exception table:
    //   from	to	target	type
    //   2	12	36	finally
    //   12	33	36	finally
    //   41	51	36	finally
    //   51	72	36	finally
    //   75	85	36	finally
    //   85	106	36	finally
  }
  
  void enqueue(RealCall.AsyncCall paramAsyncCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningAsyncCalls : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: aload_0
    //   12: getfield maxRequests : I
    //   15: if_icmpge -> 54
    //   18: aload_0
    //   19: aload_1
    //   20: invokespecial runningCallsForHost : (Lokhttp3/RealCall$AsyncCall;)I
    //   23: aload_0
    //   24: getfield maxRequestsPerHost : I
    //   27: if_icmpge -> 54
    //   30: aload_0
    //   31: getfield runningAsyncCalls : Ljava/util/Deque;
    //   34: aload_1
    //   35: invokeinterface add : (Ljava/lang/Object;)Z
    //   40: pop
    //   41: aload_0
    //   42: invokevirtual executorService : ()Ljava/util/concurrent/ExecutorService;
    //   45: aload_1
    //   46: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield readyAsyncCalls : Ljava/util/Deque;
    //   58: aload_1
    //   59: invokeinterface add : (Ljava/lang/Object;)Z
    //   64: pop
    //   65: goto -> 51
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	68	finally
    //   54	65	68	finally
  }
  
  void executed(RealCall paramRealCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningSyncCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface add : (Ljava/lang/Object;)Z
    //   12: pop
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
  
  public ExecutorService executorService() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield executorService : Ljava/util/concurrent/ExecutorService;
    //   6: ifnonnull -> 48
    //   9: new java/util/concurrent/ThreadPoolExecutor
    //   12: astore_1
    //   13: getstatic java/util/concurrent/TimeUnit.SECONDS : Ljava/util/concurrent/TimeUnit;
    //   16: astore_2
    //   17: new java/util/concurrent/SynchronousQueue
    //   20: astore_3
    //   21: aload_3
    //   22: invokespecial <init> : ()V
    //   25: aload_1
    //   26: iconst_0
    //   27: ldc 2147483647
    //   29: ldc2_w 60
    //   32: aload_2
    //   33: aload_3
    //   34: ldc 'OkHttp Dispatcher'
    //   36: iconst_0
    //   37: invokestatic threadFactory : (Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;
    //   40: invokespecial <init> : (IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/concurrent/ThreadFactory;)V
    //   43: aload_0
    //   44: aload_1
    //   45: putfield executorService : Ljava/util/concurrent/ExecutorService;
    //   48: aload_0
    //   49: getfield executorService : Ljava/util/concurrent/ExecutorService;
    //   52: astore_3
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_3
    //   56: areturn
    //   57: astore_3
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_3
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   2	48	57	finally
    //   48	53	57	finally
  }
  
  void finished(Call paramCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningSyncCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: ifne -> 32
    //   15: new java/lang/AssertionError
    //   18: astore_1
    //   19: aload_1
    //   20: ldc 'Call wasn't in-flight!'
    //   22: invokespecial <init> : (Ljava/lang/Object;)V
    //   25: aload_1
    //   26: athrow
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    // Exception table:
    //   from	to	target	type
    //   2	27	27	finally
  }
  
  void finished(RealCall.AsyncCall paramAsyncCall) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningAsyncCalls : Ljava/util/Deque;
    //   6: aload_1
    //   7: invokeinterface remove : (Ljava/lang/Object;)Z
    //   12: ifne -> 32
    //   15: new java/lang/AssertionError
    //   18: astore_1
    //   19: aload_1
    //   20: ldc 'AsyncCall wasn't running!'
    //   22: invokespecial <init> : (Ljava/lang/Object;)V
    //   25: aload_1
    //   26: athrow
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //   32: aload_0
    //   33: invokespecial promoteCalls : ()V
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    // Exception table:
    //   from	to	target	type
    //   2	27	27	finally
    //   32	36	27	finally
  }
  
  public int getMaxRequests() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxRequests : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public int getMaxRequestsPerHost() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield maxRequestsPerHost : I
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public List<Call> queuedCalls() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: astore_1
    //   6: aload_1
    //   7: invokespecial <init> : ()V
    //   10: aload_0
    //   11: getfield readyAsyncCalls : Ljava/util/Deque;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface hasNext : ()Z
    //   26: ifeq -> 56
    //   29: aload_1
    //   30: aload_2
    //   31: invokeinterface next : ()Ljava/lang/Object;
    //   36: checkcast okhttp3/RealCall$AsyncCall
    //   39: invokevirtual get : ()Lokhttp3/RealCall;
    //   42: invokeinterface add : (Ljava/lang/Object;)Z
    //   47: pop
    //   48: goto -> 20
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    //   56: aload_1
    //   57: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: areturn
    // Exception table:
    //   from	to	target	type
    //   2	20	51	finally
    //   20	48	51	finally
    //   56	61	51	finally
  }
  
  public int queuedCallsCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readyAsyncCalls : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: iload_1
    //   15: ireturn
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	16	finally
  }
  
  public List<Call> runningCalls() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: astore_1
    //   6: aload_1
    //   7: invokespecial <init> : ()V
    //   10: aload_1
    //   11: aload_0
    //   12: getfield runningSyncCalls : Ljava/util/Deque;
    //   15: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   20: pop
    //   21: aload_0
    //   22: getfield runningAsyncCalls : Ljava/util/Deque;
    //   25: invokeinterface iterator : ()Ljava/util/Iterator;
    //   30: astore_2
    //   31: aload_2
    //   32: invokeinterface hasNext : ()Z
    //   37: ifeq -> 67
    //   40: aload_1
    //   41: aload_2
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: checkcast okhttp3/RealCall$AsyncCall
    //   50: invokevirtual get : ()Lokhttp3/RealCall;
    //   53: invokeinterface add : (Ljava/lang/Object;)Z
    //   58: pop
    //   59: goto -> 31
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    //   67: aload_1
    //   68: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: areturn
    // Exception table:
    //   from	to	target	type
    //   2	31	62	finally
    //   31	59	62	finally
    //   67	72	62	finally
  }
  
  public int runningCallsCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield runningAsyncCalls : Ljava/util/Deque;
    //   6: invokeinterface size : ()I
    //   11: istore_1
    //   12: aload_0
    //   13: getfield runningSyncCalls : Ljava/util/Deque;
    //   16: invokeinterface size : ()I
    //   21: istore_2
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_1
    //   25: iload_2
    //   26: iadd
    //   27: ireturn
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	28	finally
  }
  
  public void setMaxRequests(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_1
    //   4: if_icmpge -> 43
    //   7: new java/lang/IllegalArgumentException
    //   10: astore_2
    //   11: new java/lang/StringBuilder
    //   14: astore_3
    //   15: aload_3
    //   16: invokespecial <init> : ()V
    //   19: aload_2
    //   20: aload_3
    //   21: ldc 'max < 1: '
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_1
    //   27: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: invokespecial <init> : (Ljava/lang/String;)V
    //   36: aload_2
    //   37: athrow
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    //   43: aload_0
    //   44: iload_1
    //   45: putfield maxRequests : I
    //   48: aload_0
    //   49: invokespecial promoteCalls : ()V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    // Exception table:
    //   from	to	target	type
    //   7	38	38	finally
    //   43	52	38	finally
  }
  
  public void setMaxRequestsPerHost(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: iconst_1
    //   4: if_icmpge -> 43
    //   7: new java/lang/IllegalArgumentException
    //   10: astore_2
    //   11: new java/lang/StringBuilder
    //   14: astore_3
    //   15: aload_3
    //   16: invokespecial <init> : ()V
    //   19: aload_2
    //   20: aload_3
    //   21: ldc 'max < 1: '
    //   23: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_1
    //   27: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   30: invokevirtual toString : ()Ljava/lang/String;
    //   33: invokespecial <init> : (Ljava/lang/String;)V
    //   36: aload_2
    //   37: athrow
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    //   43: aload_0
    //   44: iload_1
    //   45: putfield maxRequestsPerHost : I
    //   48: aload_0
    //   49: invokespecial promoteCalls : ()V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    // Exception table:
    //   from	to	target	type
    //   7	38	38	finally
    //   43	52	38	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\Dispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */