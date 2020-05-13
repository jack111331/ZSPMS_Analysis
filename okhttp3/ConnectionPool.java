package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.Util;
import okhttp3.internal.http.StreamAllocation;
import okhttp3.internal.io.RealConnection;

public final class ConnectionPool {
  private static final Executor executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp ConnectionPool", true));
  
  private final Runnable cleanupRunnable = new Runnable() {
      public void run() {
        while (true) {
          long l = ConnectionPool.this.cleanup(System.nanoTime());
          if (l == -1L)
            return; 
          if (l > 0L) {
            long l1 = l / 1000000L;
            synchronized (ConnectionPool.this) {
              ConnectionPool.this.wait(l1, (int)(l - l1 * 1000000L));
            } 
            /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_5} */
          } 
        } 
      }
    };
  
  boolean cleanupRunning;
  
  private final Deque<RealConnection> connections = new ArrayDeque<RealConnection>();
  
  private final long keepAliveDurationNs;
  
  private final int maxIdleConnections;
  
  final RouteDatabase routeDatabase = new RouteDatabase();
  
  public ConnectionPool() {
    this(5, 5L, TimeUnit.MINUTES);
  }
  
  public ConnectionPool(int paramInt, long paramLong, TimeUnit paramTimeUnit) {
    this.maxIdleConnections = paramInt;
    this.keepAliveDurationNs = paramTimeUnit.toNanos(paramLong);
    if (paramLong <= 0L)
      throw new IllegalArgumentException("keepAliveDuration <= 0: " + paramLong); 
  }
  
  private int pruneAndGetAllocationCount(RealConnection paramRealConnection, long paramLong) {
    // Byte code:
    //   0: aload_1
    //   1: getfield allocations : Ljava/util/List;
    //   4: astore #4
    //   6: iconst_0
    //   7: istore #5
    //   9: iload #5
    //   11: aload #4
    //   13: invokeinterface size : ()I
    //   18: if_icmpge -> 127
    //   21: aload #4
    //   23: iload #5
    //   25: invokeinterface get : (I)Ljava/lang/Object;
    //   30: checkcast java/lang/ref/Reference
    //   33: invokevirtual get : ()Ljava/lang/Object;
    //   36: ifnull -> 45
    //   39: iinc #5, 1
    //   42: goto -> 9
    //   45: invokestatic get : ()Lokhttp3/internal/Platform;
    //   48: iconst_5
    //   49: new java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial <init> : ()V
    //   56: ldc 'A connection to '
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual route : ()Lokhttp3/Route;
    //   65: invokevirtual address : ()Lokhttp3/Address;
    //   68: invokevirtual url : ()Lokhttp3/HttpUrl;
    //   71: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: ldc ' was leaked. Did you forget to close a response body?'
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual toString : ()Ljava/lang/String;
    //   82: aconst_null
    //   83: invokevirtual log : (ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: aload #4
    //   88: iload #5
    //   90: invokeinterface remove : (I)Ljava/lang/Object;
    //   95: pop
    //   96: aload_1
    //   97: iconst_1
    //   98: putfield noNewStreams : Z
    //   101: aload #4
    //   103: invokeinterface isEmpty : ()Z
    //   108: ifeq -> 9
    //   111: aload_1
    //   112: lload_2
    //   113: aload_0
    //   114: getfield keepAliveDurationNs : J
    //   117: lsub
    //   118: putfield idleAtNanos : J
    //   121: iconst_0
    //   122: istore #5
    //   124: iload #5
    //   126: ireturn
    //   127: aload #4
    //   129: invokeinterface size : ()I
    //   134: istore #5
    //   136: goto -> 124
  }
  
  long cleanup(long paramLong) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore #4
    //   5: aconst_null
    //   6: astore #5
    //   8: ldc2_w -9223372036854775808
    //   11: lstore #6
    //   13: aload_0
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield connections : Ljava/util/Deque;
    //   19: invokeinterface iterator : ()Ljava/util/Iterator;
    //   24: astore #8
    //   26: aload #8
    //   28: invokeinterface hasNext : ()Z
    //   33: ifeq -> 106
    //   36: aload #8
    //   38: invokeinterface next : ()Ljava/lang/Object;
    //   43: checkcast okhttp3/internal/io/RealConnection
    //   46: astore #9
    //   48: aload_0
    //   49: aload #9
    //   51: lload_1
    //   52: invokespecial pruneAndGetAllocationCount : (Lokhttp3/internal/io/RealConnection;J)I
    //   55: ifle -> 64
    //   58: iinc #3, 1
    //   61: goto -> 26
    //   64: iload #4
    //   66: iconst_1
    //   67: iadd
    //   68: istore #10
    //   70: lload_1
    //   71: aload #9
    //   73: getfield idleAtNanos : J
    //   76: lsub
    //   77: lstore #11
    //   79: iload #10
    //   81: istore #4
    //   83: lload #11
    //   85: lload #6
    //   87: lcmp
    //   88: ifle -> 26
    //   91: lload #11
    //   93: lstore #6
    //   95: aload #9
    //   97: astore #5
    //   99: iload #10
    //   101: istore #4
    //   103: goto -> 26
    //   106: lload #6
    //   108: aload_0
    //   109: getfield keepAliveDurationNs : J
    //   112: lcmp
    //   113: ifge -> 125
    //   116: iload #4
    //   118: aload_0
    //   119: getfield maxIdleConnections : I
    //   122: if_icmple -> 151
    //   125: aload_0
    //   126: getfield connections : Ljava/util/Deque;
    //   129: aload #5
    //   131: invokeinterface remove : (Ljava/lang/Object;)Z
    //   136: pop
    //   137: aload_0
    //   138: monitorexit
    //   139: aload #5
    //   141: invokevirtual socket : ()Ljava/net/Socket;
    //   144: invokestatic closeQuietly : (Ljava/net/Socket;)V
    //   147: lconst_0
    //   148: lstore_1
    //   149: lload_1
    //   150: lreturn
    //   151: iload #4
    //   153: ifle -> 176
    //   156: aload_0
    //   157: getfield keepAliveDurationNs : J
    //   160: lload #6
    //   162: lsub
    //   163: lstore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: goto -> 149
    //   169: astore #5
    //   171: aload_0
    //   172: monitorexit
    //   173: aload #5
    //   175: athrow
    //   176: iload_3
    //   177: ifle -> 190
    //   180: aload_0
    //   181: getfield keepAliveDurationNs : J
    //   184: lstore_1
    //   185: aload_0
    //   186: monitorexit
    //   187: goto -> 149
    //   190: aload_0
    //   191: iconst_0
    //   192: putfield cleanupRunning : Z
    //   195: ldc2_w -1
    //   198: lstore_1
    //   199: aload_0
    //   200: monitorexit
    //   201: goto -> 149
    // Exception table:
    //   from	to	target	type
    //   15	26	169	finally
    //   26	58	169	finally
    //   70	79	169	finally
    //   106	125	169	finally
    //   125	139	169	finally
    //   156	166	169	finally
    //   171	173	169	finally
    //   180	187	169	finally
    //   190	195	169	finally
    //   199	201	169	finally
  }
  
  boolean connectionBecameIdle(RealConnection paramRealConnection) {
    assert Thread.holdsLock(this);
    if (paramRealConnection.noNewStreams || this.maxIdleConnections == 0) {
      this.connections.remove(paramRealConnection);
      return true;
    } 
    notifyAll();
    return false;
  }
  
  public int connectionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connections : Ljava/util/Deque;
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
  
  public void evictAll() {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield connections : Ljava/util/Deque;
    //   14: invokeinterface iterator : ()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface hasNext : ()Z
    //   26: ifeq -> 78
    //   29: aload_2
    //   30: invokeinterface next : ()Ljava/lang/Object;
    //   35: checkcast okhttp3/internal/io/RealConnection
    //   38: astore_3
    //   39: aload_3
    //   40: getfield allocations : Ljava/util/List;
    //   43: invokeinterface isEmpty : ()Z
    //   48: ifeq -> 20
    //   51: aload_3
    //   52: iconst_1
    //   53: putfield noNewStreams : Z
    //   56: aload_1
    //   57: aload_3
    //   58: invokeinterface add : (Ljava/lang/Object;)Z
    //   63: pop
    //   64: aload_2
    //   65: invokeinterface remove : ()V
    //   70: goto -> 20
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: invokeinterface iterator : ()Ljava/util/Iterator;
    //   86: astore_1
    //   87: aload_1
    //   88: invokeinterface hasNext : ()Z
    //   93: ifeq -> 114
    //   96: aload_1
    //   97: invokeinterface next : ()Ljava/lang/Object;
    //   102: checkcast okhttp3/internal/io/RealConnection
    //   105: invokevirtual socket : ()Ljava/net/Socket;
    //   108: invokestatic closeQuietly : (Ljava/net/Socket;)V
    //   111: goto -> 87
    //   114: return
    // Exception table:
    //   from	to	target	type
    //   10	20	73	finally
    //   20	70	73	finally
    //   74	76	73	finally
    //   78	80	73	finally
  }
  
  RealConnection get(Address paramAddress, StreamAllocation paramStreamAllocation) {
    // Byte code:
    //   0: getstatic okhttp3/ConnectionPool.$assertionsDisabled : Z
    //   3: ifne -> 21
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifne -> 21
    //   13: new java/lang/AssertionError
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: athrow
    //   21: aload_0
    //   22: getfield connections : Ljava/util/Deque;
    //   25: invokeinterface iterator : ()Ljava/util/Iterator;
    //   30: astore_3
    //   31: aload_3
    //   32: invokeinterface hasNext : ()Z
    //   37: ifeq -> 103
    //   40: aload_3
    //   41: invokeinterface next : ()Ljava/lang/Object;
    //   46: checkcast okhttp3/internal/io/RealConnection
    //   49: astore #4
    //   51: aload #4
    //   53: getfield allocations : Ljava/util/List;
    //   56: invokeinterface size : ()I
    //   61: aload #4
    //   63: getfield allocationLimit : I
    //   66: if_icmpge -> 31
    //   69: aload_1
    //   70: aload #4
    //   72: invokevirtual route : ()Lokhttp3/Route;
    //   75: getfield address : Lokhttp3/Address;
    //   78: invokevirtual equals : (Ljava/lang/Object;)Z
    //   81: ifeq -> 31
    //   84: aload #4
    //   86: getfield noNewStreams : Z
    //   89: ifne -> 31
    //   92: aload_2
    //   93: aload #4
    //   95: invokevirtual acquire : (Lokhttp3/internal/io/RealConnection;)V
    //   98: aload #4
    //   100: astore_1
    //   101: aload_1
    //   102: areturn
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -> 101
  }
  
  public int idleConnectionCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: getfield connections : Ljava/util/Deque;
    //   8: invokeinterface iterator : ()Ljava/util/Iterator;
    //   13: astore_2
    //   14: aload_2
    //   15: invokeinterface hasNext : ()Z
    //   20: ifeq -> 51
    //   23: aload_2
    //   24: invokeinterface next : ()Ljava/lang/Object;
    //   29: checkcast okhttp3/internal/io/RealConnection
    //   32: getfield allocations : Ljava/util/List;
    //   35: invokeinterface isEmpty : ()Z
    //   40: istore_3
    //   41: iload_3
    //   42: ifeq -> 14
    //   45: iinc #1, 1
    //   48: goto -> 14
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_1
    //   54: ireturn
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Exception table:
    //   from	to	target	type
    //   4	14	55	finally
    //   14	41	55	finally
  }
  
  void put(RealConnection paramRealConnection) {
    assert Thread.holdsLock(this);
    if (!this.cleanupRunning) {
      this.cleanupRunning = true;
      executor.execute(this.cleanupRunnable);
    } 
    this.connections.add(paramRealConnection);
  }
  
  static {
    boolean bool;
    if (!ConnectionPool.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    $assertionsDisabled = bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\ConnectionPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */