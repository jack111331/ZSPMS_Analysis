package okhttp3.internal.http;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.RouteDatabase;
import okhttp3.internal.io.RealConnection;

public final class StreamAllocation {
  public final Address address;
  
  private boolean canceled;
  
  private RealConnection connection;
  
  private final ConnectionPool connectionPool;
  
  private int refusedStreamCount;
  
  private boolean released;
  
  private Route route;
  
  private final RouteSelector routeSelector;
  
  private HttpStream stream;
  
  public StreamAllocation(ConnectionPool paramConnectionPool, Address paramAddress) {
    this.connectionPool = paramConnectionPool;
    this.address = paramAddress;
    this.routeSelector = new RouteSelector(paramAddress, routeDatabase());
  }
  
  private void deallocate(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aconst_null
    //   4: astore #5
    //   6: aload_0
    //   7: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   10: astore #6
    //   12: aload #6
    //   14: monitorenter
    //   15: iload_3
    //   16: ifeq -> 24
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield stream : Lokhttp3/internal/http/HttpStream;
    //   24: iload_2
    //   25: ifeq -> 33
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield released : Z
    //   33: aload #4
    //   35: astore #7
    //   37: aload_0
    //   38: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   41: ifnull -> 157
    //   44: iload_1
    //   45: ifeq -> 56
    //   48: aload_0
    //   49: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   52: iconst_1
    //   53: putfield noNewStreams : Z
    //   56: aload #4
    //   58: astore #7
    //   60: aload_0
    //   61: getfield stream : Lokhttp3/internal/http/HttpStream;
    //   64: ifnonnull -> 157
    //   67: aload_0
    //   68: getfield released : Z
    //   71: ifne -> 88
    //   74: aload #4
    //   76: astore #7
    //   78: aload_0
    //   79: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   82: getfield noNewStreams : Z
    //   85: ifeq -> 157
    //   88: aload_0
    //   89: aload_0
    //   90: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   93: invokespecial release : (Lokhttp3/internal/io/RealConnection;)V
    //   96: aload #5
    //   98: astore #7
    //   100: aload_0
    //   101: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   104: getfield allocations : Ljava/util/List;
    //   107: invokeinterface isEmpty : ()Z
    //   112: ifeq -> 152
    //   115: aload_0
    //   116: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   119: invokestatic nanoTime : ()J
    //   122: putfield idleAtNanos : J
    //   125: aload #5
    //   127: astore #7
    //   129: getstatic okhttp3/internal/Internal.instance : Lokhttp3/internal/Internal;
    //   132: aload_0
    //   133: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   136: aload_0
    //   137: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   140: invokevirtual connectionBecameIdle : (Lokhttp3/ConnectionPool;Lokhttp3/internal/io/RealConnection;)Z
    //   143: ifeq -> 152
    //   146: aload_0
    //   147: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   150: astore #7
    //   152: aload_0
    //   153: aconst_null
    //   154: putfield connection : Lokhttp3/internal/io/RealConnection;
    //   157: aload #6
    //   159: monitorexit
    //   160: aload #7
    //   162: ifnull -> 173
    //   165: aload #7
    //   167: invokevirtual socket : ()Ljava/net/Socket;
    //   170: invokestatic closeQuietly : (Ljava/net/Socket;)V
    //   173: return
    //   174: astore #7
    //   176: aload #6
    //   178: monitorexit
    //   179: aload #7
    //   181: athrow
    // Exception table:
    //   from	to	target	type
    //   19	24	174	finally
    //   28	33	174	finally
    //   37	44	174	finally
    //   48	56	174	finally
    //   60	74	174	finally
    //   78	88	174	finally
    //   88	96	174	finally
    //   100	125	174	finally
    //   129	152	174	finally
    //   152	157	174	finally
    //   157	160	174	finally
    //   176	179	174	finally
  }
  
  private RealConnection findConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) throws IOException, RouteException {
    // Byte code:
    //   0: aload_0
    //   1: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   4: astore #5
    //   6: aload #5
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield released : Z
    //   13: ifeq -> 39
    //   16: new java/lang/IllegalStateException
    //   19: astore #6
    //   21: aload #6
    //   23: ldc 'released'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload #6
    //   30: athrow
    //   31: astore #6
    //   33: aload #5
    //   35: monitorexit
    //   36: aload #6
    //   38: athrow
    //   39: aload_0
    //   40: getfield stream : Lokhttp3/internal/http/HttpStream;
    //   43: ifnull -> 61
    //   46: new java/lang/IllegalStateException
    //   49: astore #6
    //   51: aload #6
    //   53: ldc 'stream != null'
    //   55: invokespecial <init> : (Ljava/lang/String;)V
    //   58: aload #6
    //   60: athrow
    //   61: aload_0
    //   62: getfield canceled : Z
    //   65: ifeq -> 83
    //   68: new java/io/IOException
    //   71: astore #6
    //   73: aload #6
    //   75: ldc 'Canceled'
    //   77: invokespecial <init> : (Ljava/lang/String;)V
    //   80: aload #6
    //   82: athrow
    //   83: aload_0
    //   84: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   87: astore #6
    //   89: aload #6
    //   91: ifnull -> 108
    //   94: aload #6
    //   96: getfield noNewStreams : Z
    //   99: ifne -> 108
    //   102: aload #5
    //   104: monitorexit
    //   105: aload #6
    //   107: areturn
    //   108: getstatic okhttp3/internal/Internal.instance : Lokhttp3/internal/Internal;
    //   111: aload_0
    //   112: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   115: aload_0
    //   116: getfield address : Lokhttp3/Address;
    //   119: aload_0
    //   120: invokevirtual get : (Lokhttp3/ConnectionPool;Lokhttp3/Address;Lokhttp3/internal/http/StreamAllocation;)Lokhttp3/internal/io/RealConnection;
    //   123: astore #6
    //   125: aload #6
    //   127: ifnull -> 142
    //   130: aload_0
    //   131: aload #6
    //   133: putfield connection : Lokhttp3/internal/io/RealConnection;
    //   136: aload #5
    //   138: monitorexit
    //   139: goto -> 105
    //   142: aload_0
    //   143: getfield route : Lokhttp3/Route;
    //   146: astore #7
    //   148: aload #5
    //   150: monitorexit
    //   151: aload #7
    //   153: astore #6
    //   155: aload #7
    //   157: ifnonnull -> 192
    //   160: aload_0
    //   161: getfield routeSelector : Lokhttp3/internal/http/RouteSelector;
    //   164: invokevirtual next : ()Lokhttp3/Route;
    //   167: astore #6
    //   169: aload_0
    //   170: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   173: astore #7
    //   175: aload #7
    //   177: monitorenter
    //   178: aload_0
    //   179: aload #6
    //   181: putfield route : Lokhttp3/Route;
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield refusedStreamCount : I
    //   189: aload #7
    //   191: monitorexit
    //   192: new okhttp3/internal/io/RealConnection
    //   195: dup
    //   196: aload #6
    //   198: invokespecial <init> : (Lokhttp3/Route;)V
    //   201: astore #6
    //   203: aload_0
    //   204: aload #6
    //   206: invokevirtual acquire : (Lokhttp3/internal/io/RealConnection;)V
    //   209: aload_0
    //   210: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   213: astore #7
    //   215: aload #7
    //   217: monitorenter
    //   218: getstatic okhttp3/internal/Internal.instance : Lokhttp3/internal/Internal;
    //   221: aload_0
    //   222: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   225: aload #6
    //   227: invokevirtual put : (Lokhttp3/ConnectionPool;Lokhttp3/internal/io/RealConnection;)V
    //   230: aload_0
    //   231: aload #6
    //   233: putfield connection : Lokhttp3/internal/io/RealConnection;
    //   236: aload_0
    //   237: getfield canceled : Z
    //   240: ifeq -> 274
    //   243: new java/io/IOException
    //   246: astore #6
    //   248: aload #6
    //   250: ldc 'Canceled'
    //   252: invokespecial <init> : (Ljava/lang/String;)V
    //   255: aload #6
    //   257: athrow
    //   258: astore #6
    //   260: aload #7
    //   262: monitorexit
    //   263: aload #6
    //   265: athrow
    //   266: astore #6
    //   268: aload #7
    //   270: monitorexit
    //   271: aload #6
    //   273: athrow
    //   274: aload #7
    //   276: monitorexit
    //   277: aload #6
    //   279: iload_1
    //   280: iload_2
    //   281: iload_3
    //   282: aload_0
    //   283: getfield address : Lokhttp3/Address;
    //   286: invokevirtual connectionSpecs : ()Ljava/util/List;
    //   289: iload #4
    //   291: invokevirtual connect : (IIILjava/util/List;Z)V
    //   294: aload_0
    //   295: invokespecial routeDatabase : ()Lokhttp3/internal/RouteDatabase;
    //   298: aload #6
    //   300: invokevirtual route : ()Lokhttp3/Route;
    //   303: invokevirtual connected : (Lokhttp3/Route;)V
    //   306: goto -> 105
    // Exception table:
    //   from	to	target	type
    //   9	31	31	finally
    //   33	36	31	finally
    //   39	61	31	finally
    //   61	83	31	finally
    //   83	89	31	finally
    //   94	105	31	finally
    //   108	125	31	finally
    //   130	139	31	finally
    //   142	151	31	finally
    //   178	192	266	finally
    //   218	258	258	finally
    //   260	263	258	finally
    //   268	271	266	finally
    //   274	277	258	finally
  }
  
  private RealConnection findHealthyConnection(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) throws IOException, RouteException {
    while (true) {
      null = findConnection(paramInt1, paramInt2, paramInt3, paramBoolean1);
      synchronized (this.connectionPool) {
        if (null.successCount == 0)
          return null; 
        if (!null.isHealthy(paramBoolean2)) {
          noNewStreams();
          continue;
        } 
        return null;
      } 
    } 
  }
  
  private void release(RealConnection paramRealConnection) {
    byte b = 0;
    int i = paramRealConnection.allocations.size();
    while (b < i) {
      if (((Reference<StreamAllocation>)paramRealConnection.allocations.get(b)).get() == this) {
        paramRealConnection.allocations.remove(b);
        return;
      } 
      b++;
    } 
    throw new IllegalStateException();
  }
  
  private RouteDatabase routeDatabase() {
    return Internal.instance.routeDatabase(this.connectionPool);
  }
  
  public void acquire(RealConnection paramRealConnection) {
    paramRealConnection.allocations.add(new WeakReference<StreamAllocation>(this));
  }
  
  public void cancel() {
    RealConnection realConnection;
    synchronized (this.connectionPool) {
      this.canceled = true;
      HttpStream httpStream = this.stream;
      realConnection = this.connection;
      if (httpStream != null) {
        httpStream.cancel();
        return;
      } 
    } 
    if (realConnection != null)
      realConnection.cancel(); 
  }
  
  public RealConnection connection() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public boolean hasMoreRoutes() {
    return (this.route != null || this.routeSelector.hasNext());
  }
  
  public HttpStream newStream(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) throws RouteException, IOException {
    try {
      RealConnection realConnection = findHealthyConnection(paramInt1, paramInt2, paramInt3, paramBoolean1, paramBoolean2);
      if (realConnection.framedConnection != null) {
        Http2xStream http2xStream = new Http2xStream();
        this(this, realConnection.framedConnection);
      } else {
        realConnection.socket().setSoTimeout(paramInt2);
        realConnection.source.timeout().timeout(paramInt2, TimeUnit.MILLISECONDS);
        realConnection.sink.timeout().timeout(paramInt3, TimeUnit.MILLISECONDS);
        null = new Http1xStream(this, realConnection.source, realConnection.sink);
      } 
      synchronized (this.connectionPool) {
        this.stream = null;
        return null;
      } 
    } catch (IOException iOException) {
      throw new RouteException(iOException);
    } 
  }
  
  public void noNewStreams() {
    deallocate(true, false, false);
  }
  
  public void release() {
    deallocate(false, true, false);
  }
  
  public HttpStream stream() {
    synchronized (this.connectionPool) {
      return this.stream;
    } 
  }
  
  public void streamFailed(IOException paramIOException) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   6: astore_3
    //   7: aload_3
    //   8: monitorenter
    //   9: aload_1
    //   10: instanceof okhttp3/internal/framed/StreamResetException
    //   13: ifeq -> 81
    //   16: aload_1
    //   17: checkcast okhttp3/internal/framed/StreamResetException
    //   20: astore_1
    //   21: aload_1
    //   22: getfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   25: getstatic okhttp3/internal/framed/ErrorCode.REFUSED_STREAM : Lokhttp3/internal/framed/ErrorCode;
    //   28: if_acmpne -> 41
    //   31: aload_0
    //   32: aload_0
    //   33: getfield refusedStreamCount : I
    //   36: iconst_1
    //   37: iadd
    //   38: putfield refusedStreamCount : I
    //   41: aload_1
    //   42: getfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   45: getstatic okhttp3/internal/framed/ErrorCode.REFUSED_STREAM : Lokhttp3/internal/framed/ErrorCode;
    //   48: if_acmpne -> 62
    //   51: iload_2
    //   52: istore #4
    //   54: aload_0
    //   55: getfield refusedStreamCount : I
    //   58: iconst_1
    //   59: if_icmple -> 70
    //   62: iconst_1
    //   63: istore #4
    //   65: aload_0
    //   66: aconst_null
    //   67: putfield route : Lokhttp3/Route;
    //   70: aload_3
    //   71: monitorexit
    //   72: aload_0
    //   73: iload #4
    //   75: iconst_0
    //   76: iconst_1
    //   77: invokespecial deallocate : (ZZZ)V
    //   80: return
    //   81: iload_2
    //   82: istore #4
    //   84: aload_0
    //   85: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   88: ifnull -> 70
    //   91: iload_2
    //   92: istore #4
    //   94: aload_0
    //   95: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   98: invokevirtual isMultiplexed : ()Z
    //   101: ifne -> 70
    //   104: iconst_1
    //   105: istore_2
    //   106: iload_2
    //   107: istore #4
    //   109: aload_0
    //   110: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   113: getfield successCount : I
    //   116: ifne -> 70
    //   119: aload_0
    //   120: getfield route : Lokhttp3/Route;
    //   123: ifnull -> 142
    //   126: aload_1
    //   127: ifnull -> 142
    //   130: aload_0
    //   131: getfield routeSelector : Lokhttp3/internal/http/RouteSelector;
    //   134: aload_0
    //   135: getfield route : Lokhttp3/Route;
    //   138: aload_1
    //   139: invokevirtual connectFailed : (Lokhttp3/Route;Ljava/io/IOException;)V
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield route : Lokhttp3/Route;
    //   147: iload_2
    //   148: istore #4
    //   150: goto -> 70
    //   153: astore_1
    //   154: aload_3
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Exception table:
    //   from	to	target	type
    //   9	41	153	finally
    //   41	51	153	finally
    //   54	62	153	finally
    //   65	70	153	finally
    //   70	72	153	finally
    //   84	91	153	finally
    //   94	104	153	finally
    //   109	126	153	finally
    //   130	142	153	finally
    //   142	147	153	finally
    //   154	156	153	finally
  }
  
  public void streamFinished(boolean paramBoolean, HttpStream paramHttpStream) {
    // Byte code:
    //   0: aload_0
    //   1: getfield connectionPool : Lokhttp3/ConnectionPool;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_2
    //   8: ifnull -> 19
    //   11: aload_2
    //   12: aload_0
    //   13: getfield stream : Lokhttp3/internal/http/HttpStream;
    //   16: if_acmpeq -> 75
    //   19: new java/lang/IllegalStateException
    //   22: astore #4
    //   24: new java/lang/StringBuilder
    //   27: astore #5
    //   29: aload #5
    //   31: invokespecial <init> : ()V
    //   34: aload #4
    //   36: aload #5
    //   38: ldc_w 'expected '
    //   41: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield stream : Lokhttp3/internal/http/HttpStream;
    //   48: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc_w ' but was '
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: invokevirtual toString : ()Ljava/lang/String;
    //   64: invokespecial <init> : (Ljava/lang/String;)V
    //   67: aload #4
    //   69: athrow
    //   70: astore_2
    //   71: aload_3
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    //   75: iload_1
    //   76: ifne -> 94
    //   79: aload_0
    //   80: getfield connection : Lokhttp3/internal/io/RealConnection;
    //   83: astore_2
    //   84: aload_2
    //   85: aload_2
    //   86: getfield successCount : I
    //   89: iconst_1
    //   90: iadd
    //   91: putfield successCount : I
    //   94: aload_3
    //   95: monitorexit
    //   96: aload_0
    //   97: iload_1
    //   98: iconst_0
    //   99: iconst_1
    //   100: invokespecial deallocate : (ZZZ)V
    //   103: return
    // Exception table:
    //   from	to	target	type
    //   11	19	70	finally
    //   19	70	70	finally
    //   71	73	70	finally
    //   79	94	70	finally
    //   94	96	70	finally
  }
  
  public String toString() {
    return this.address.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\http\StreamAllocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */