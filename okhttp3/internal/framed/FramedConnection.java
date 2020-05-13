package okhttp3.internal.framed;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class FramedConnection implements Closeable {
  private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  
  private static final ExecutorService executor = new ThreadPoolExecutor(0, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Util.threadFactory("OkHttp FramedConnection", true));
  
  long bytesLeftInWriteWindow;
  
  final boolean client;
  
  private final Set<Integer> currentPushRequests = new LinkedHashSet<Integer>();
  
  final FrameWriter frameWriter;
  
  private final String hostname;
  
  private long idleStartTimeNs = System.nanoTime();
  
  private int lastGoodStreamId;
  
  private final Listener listener;
  
  private int nextPingId;
  
  private int nextStreamId;
  
  Settings okHttpSettings = new Settings();
  
  final Settings peerSettings = new Settings();
  
  private Map<Integer, Ping> pings;
  
  final Protocol protocol;
  
  private final ExecutorService pushExecutor;
  
  private final PushObserver pushObserver;
  
  final Reader readerRunnable;
  
  private boolean receivedInitialPeerSettings = false;
  
  private boolean shutdown;
  
  final Socket socket;
  
  private final Map<Integer, FramedStream> streams = new HashMap<Integer, FramedStream>();
  
  long unacknowledgedBytesRead = 0L;
  
  final Variant variant;
  
  private FramedConnection(Builder paramBuilder) throws IOException {
    this.protocol = paramBuilder.protocol;
    this.pushObserver = paramBuilder.pushObserver;
    this.client = paramBuilder.client;
    this.listener = paramBuilder.listener;
    if (paramBuilder.client) {
      b2 = 1;
    } else {
      b2 = 2;
    } 
    this.nextStreamId = b2;
    if (paramBuilder.client && this.protocol == Protocol.HTTP_2)
      this.nextStreamId += 2; 
    byte b2 = b1;
    if (paramBuilder.client)
      b2 = 1; 
    this.nextPingId = b2;
    if (paramBuilder.client)
      this.okHttpSettings.set(7, 0, 16777216); 
    this.hostname = paramBuilder.hostname;
    if (this.protocol == Protocol.HTTP_2) {
      this.variant = new Http2();
      this.pushExecutor = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.threadFactory(Util.format("OkHttp %s Push Observer", new Object[] { this.hostname }), true));
      this.peerSettings.set(7, 0, 65535);
      this.peerSettings.set(5, 0, 16384);
    } else if (this.protocol == Protocol.SPDY_3) {
      this.variant = new Spdy3();
      this.pushExecutor = null;
    } else {
      throw new AssertionError(this.protocol);
    } 
    this.bytesLeftInWriteWindow = this.peerSettings.getInitialWindowSize(65536);
    this.socket = paramBuilder.socket;
    this.frameWriter = this.variant.newWriter(paramBuilder.sink, this.client);
    this.readerRunnable = new Reader(this.variant.newReader(paramBuilder.source, this.client));
  }
  
  private void close(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2) throws IOException {
    // Byte code:
    //   0: getstatic okhttp3/internal/framed/FramedConnection.$assertionsDisabled : Z
    //   3: ifne -> 21
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifeq -> 21
    //   13: new java/lang/AssertionError
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: athrow
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual shutdown : (Lokhttp3/internal/framed/ErrorCode;)V
    //   28: aload_3
    //   29: astore_1
    //   30: aconst_null
    //   31: astore #4
    //   33: aconst_null
    //   34: astore #5
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: getfield streams : Ljava/util/Map;
    //   42: invokeinterface isEmpty : ()Z
    //   47: ifne -> 95
    //   50: aload_0
    //   51: getfield streams : Ljava/util/Map;
    //   54: invokeinterface values : ()Ljava/util/Collection;
    //   59: aload_0
    //   60: getfield streams : Ljava/util/Map;
    //   63: invokeinterface size : ()I
    //   68: anewarray okhttp3/internal/framed/FramedStream
    //   71: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   76: checkcast [Lokhttp3/internal/framed/FramedStream;
    //   79: astore #4
    //   81: aload_0
    //   82: getfield streams : Ljava/util/Map;
    //   85: invokeinterface clear : ()V
    //   90: aload_0
    //   91: iconst_0
    //   92: invokespecial setIdle : (Z)V
    //   95: aload_0
    //   96: getfield pings : Ljava/util/Map;
    //   99: ifnull -> 138
    //   102: aload_0
    //   103: getfield pings : Ljava/util/Map;
    //   106: invokeinterface values : ()Ljava/util/Collection;
    //   111: aload_0
    //   112: getfield pings : Ljava/util/Map;
    //   115: invokeinterface size : ()I
    //   120: anewarray okhttp3/internal/framed/Ping
    //   123: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   128: checkcast [Lokhttp3/internal/framed/Ping;
    //   131: astore #5
    //   133: aload_0
    //   134: aconst_null
    //   135: putfield pings : Ljava/util/Map;
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: astore_3
    //   142: aload #4
    //   144: ifnull -> 208
    //   147: aload #4
    //   149: arraylength
    //   150: istore #6
    //   152: iconst_0
    //   153: istore #7
    //   155: aload_1
    //   156: astore_3
    //   157: iload #7
    //   159: iload #6
    //   161: if_icmpge -> 208
    //   164: aload #4
    //   166: iload #7
    //   168: aaload
    //   169: astore_3
    //   170: aload_3
    //   171: aload_2
    //   172: invokevirtual close : (Lokhttp3/internal/framed/ErrorCode;)V
    //   175: aload_1
    //   176: astore_3
    //   177: iinc #7, 1
    //   180: aload_3
    //   181: astore_1
    //   182: goto -> 155
    //   185: astore_1
    //   186: goto -> 30
    //   189: astore_1
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_1
    //   193: athrow
    //   194: astore #8
    //   196: aload_1
    //   197: astore_3
    //   198: aload_1
    //   199: ifnull -> 177
    //   202: aload #8
    //   204: astore_3
    //   205: goto -> 177
    //   208: aload #5
    //   210: ifnull -> 242
    //   213: aload #5
    //   215: arraylength
    //   216: istore #6
    //   218: iconst_0
    //   219: istore #7
    //   221: iload #7
    //   223: iload #6
    //   225: if_icmpge -> 242
    //   228: aload #5
    //   230: iload #7
    //   232: aaload
    //   233: invokevirtual cancel : ()V
    //   236: iinc #7, 1
    //   239: goto -> 221
    //   242: aload_0
    //   243: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   246: invokeinterface close : ()V
    //   251: aload_3
    //   252: astore_1
    //   253: aload_0
    //   254: getfield socket : Ljava/net/Socket;
    //   257: invokevirtual close : ()V
    //   260: aload_1
    //   261: ifnull -> 282
    //   264: aload_1
    //   265: athrow
    //   266: astore_2
    //   267: aload_3
    //   268: astore_1
    //   269: aload_3
    //   270: ifnonnull -> 253
    //   273: aload_2
    //   274: astore_1
    //   275: goto -> 253
    //   278: astore_1
    //   279: goto -> 260
    //   282: return
    // Exception table:
    //   from	to	target	type
    //   23	28	185	java/io/IOException
    //   38	95	189	finally
    //   95	138	189	finally
    //   138	140	189	finally
    //   170	175	194	java/io/IOException
    //   190	192	189	finally
    //   242	251	266	java/io/IOException
    //   253	260	278	java/io/IOException
  }
  
  private FramedStream newStream(int paramInt, List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
    // Byte code:
    //   0: iload_3
    //   1: ifne -> 57
    //   4: iconst_1
    //   5: istore #5
    //   7: iload #4
    //   9: ifne -> 63
    //   12: iconst_1
    //   13: istore #4
    //   15: aload_0
    //   16: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   19: astore #6
    //   21: aload #6
    //   23: monitorenter
    //   24: aload_0
    //   25: monitorenter
    //   26: aload_0
    //   27: getfield shutdown : Z
    //   30: ifeq -> 69
    //   33: new java/io/IOException
    //   36: astore_2
    //   37: aload_2
    //   38: ldc_w 'shutdown'
    //   41: invokespecial <init> : (Ljava/lang/String;)V
    //   44: aload_2
    //   45: athrow
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    //   51: astore_2
    //   52: aload #6
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    //   57: iconst_0
    //   58: istore #5
    //   60: goto -> 7
    //   63: iconst_0
    //   64: istore #4
    //   66: goto -> 15
    //   69: aload_0
    //   70: getfield nextStreamId : I
    //   73: istore #7
    //   75: aload_0
    //   76: aload_0
    //   77: getfield nextStreamId : I
    //   80: iconst_2
    //   81: iadd
    //   82: putfield nextStreamId : I
    //   85: new okhttp3/internal/framed/FramedStream
    //   88: astore #8
    //   90: aload #8
    //   92: iload #7
    //   94: aload_0
    //   95: iload #5
    //   97: iload #4
    //   99: aload_2
    //   100: invokespecial <init> : (ILokhttp3/internal/framed/FramedConnection;ZZLjava/util/List;)V
    //   103: iload_3
    //   104: ifeq -> 126
    //   107: aload_0
    //   108: getfield bytesLeftInWriteWindow : J
    //   111: lconst_0
    //   112: lcmp
    //   113: ifeq -> 126
    //   116: aload #8
    //   118: getfield bytesLeftInWriteWindow : J
    //   121: lconst_0
    //   122: lcmp
    //   123: ifne -> 202
    //   126: iconst_1
    //   127: istore #9
    //   129: aload #8
    //   131: invokevirtual isOpen : ()Z
    //   134: ifeq -> 159
    //   137: aload_0
    //   138: getfield streams : Ljava/util/Map;
    //   141: iload #7
    //   143: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   146: aload #8
    //   148: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   153: pop
    //   154: aload_0
    //   155: iconst_0
    //   156: invokespecial setIdle : (Z)V
    //   159: aload_0
    //   160: monitorexit
    //   161: iload_1
    //   162: ifne -> 208
    //   165: aload_0
    //   166: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   169: iload #5
    //   171: iload #4
    //   173: iload #7
    //   175: iload_1
    //   176: aload_2
    //   177: invokeinterface synStream : (ZZIILjava/util/List;)V
    //   182: aload #6
    //   184: monitorexit
    //   185: iload #9
    //   187: ifeq -> 199
    //   190: aload_0
    //   191: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   194: invokeinterface flush : ()V
    //   199: aload #8
    //   201: areturn
    //   202: iconst_0
    //   203: istore #9
    //   205: goto -> 129
    //   208: aload_0
    //   209: getfield client : Z
    //   212: ifeq -> 228
    //   215: new java/lang/IllegalArgumentException
    //   218: astore_2
    //   219: aload_2
    //   220: ldc_w 'client streams shouldn't have associated stream IDs'
    //   223: invokespecial <init> : (Ljava/lang/String;)V
    //   226: aload_2
    //   227: athrow
    //   228: aload_0
    //   229: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   232: iload_1
    //   233: iload #7
    //   235: aload_2
    //   236: invokeinterface pushPromise : (IILjava/util/List;)V
    //   241: goto -> 182
    // Exception table:
    //   from	to	target	type
    //   24	26	51	finally
    //   26	46	46	finally
    //   47	49	46	finally
    //   49	51	51	finally
    //   52	55	51	finally
    //   69	103	46	finally
    //   107	126	46	finally
    //   129	159	46	finally
    //   159	161	46	finally
    //   165	182	51	finally
    //   182	185	51	finally
    //   208	228	51	finally
    //   228	241	51	finally
  }
  
  private void pushDataLater(final int streamId, BufferedSource paramBufferedSource, final int byteCount, final boolean inFinished) throws IOException {
    final Buffer buffer = new Buffer();
    paramBufferedSource.require(byteCount);
    paramBufferedSource.read(buffer, byteCount);
    if (buffer.size() != byteCount)
      throw new IOException(buffer.size() + " != " + byteCount); 
    this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Data[%s]", new Object[] { this.hostname, Integer.valueOf(streamId) }) {
          public void execute() {
            try {
              boolean bool = FramedConnection.this.pushObserver.onData(streamId, (BufferedSource)buffer, byteCount, inFinished);
              if (bool)
                FramedConnection.this.frameWriter.rstStream(streamId, ErrorCode.CANCEL); 
              if (bool || inFinished)
                synchronized (FramedConnection.this) {
                  FramedConnection.this.currentPushRequests.remove(Integer.valueOf(streamId));
                  return;
                }  
            } catch (IOException iOException) {}
          }
        });
  }
  
  private void pushHeadersLater(final int streamId, final List<Header> requestHeaders, final boolean inFinished) {
    this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[] { this.hostname, Integer.valueOf(streamId) }) {
          public void execute() {
            // Byte code:
            //   0: aload_0
            //   1: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
            //   4: invokestatic access$2700 : (Lokhttp3/internal/framed/FramedConnection;)Lokhttp3/internal/framed/PushObserver;
            //   7: aload_0
            //   8: getfield val$streamId : I
            //   11: aload_0
            //   12: getfield val$requestHeaders : Ljava/util/List;
            //   15: aload_0
            //   16: getfield val$inFinished : Z
            //   19: invokeinterface onHeaders : (ILjava/util/List;Z)Z
            //   24: istore_1
            //   25: iload_1
            //   26: ifeq -> 48
            //   29: aload_0
            //   30: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
            //   33: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
            //   36: aload_0
            //   37: getfield val$streamId : I
            //   40: getstatic okhttp3/internal/framed/ErrorCode.CANCEL : Lokhttp3/internal/framed/ErrorCode;
            //   43: invokeinterface rstStream : (ILokhttp3/internal/framed/ErrorCode;)V
            //   48: iload_1
            //   49: ifne -> 59
            //   52: aload_0
            //   53: getfield val$inFinished : Z
            //   56: ifeq -> 88
            //   59: aload_0
            //   60: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
            //   63: astore_2
            //   64: aload_2
            //   65: monitorenter
            //   66: aload_0
            //   67: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
            //   70: invokestatic access$2800 : (Lokhttp3/internal/framed/FramedConnection;)Ljava/util/Set;
            //   73: aload_0
            //   74: getfield val$streamId : I
            //   77: invokestatic valueOf : (I)Ljava/lang/Integer;
            //   80: invokeinterface remove : (Ljava/lang/Object;)Z
            //   85: pop
            //   86: aload_2
            //   87: monitorexit
            //   88: return
            //   89: astore_3
            //   90: aload_2
            //   91: monitorexit
            //   92: aload_3
            //   93: athrow
            //   94: astore_2
            //   95: goto -> 88
            // Exception table:
            //   from	to	target	type
            //   29	48	94	java/io/IOException
            //   52	59	94	java/io/IOException
            //   59	66	94	java/io/IOException
            //   66	88	89	finally
            //   90	92	89	finally
            //   92	94	94	java/io/IOException
          }
        });
  }
  
  private void pushRequestLater(int paramInt, List<Header> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield currentPushRequests : Ljava/util/Set;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface contains : (Ljava/lang/Object;)Z
    //   15: ifeq -> 29
    //   18: aload_0
    //   19: iload_1
    //   20: getstatic okhttp3/internal/framed/ErrorCode.PROTOCOL_ERROR : Lokhttp3/internal/framed/ErrorCode;
    //   23: invokevirtual writeSynResetLater : (ILokhttp3/internal/framed/ErrorCode;)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: getfield currentPushRequests : Ljava/util/Set;
    //   33: iload_1
    //   34: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   37: invokeinterface add : (Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: getfield pushExecutor : Ljava/util/concurrent/ExecutorService;
    //   49: new okhttp3/internal/framed/FramedConnection$4
    //   52: dup
    //   53: aload_0
    //   54: ldc_w 'OkHttp %s Push Request[%s]'
    //   57: iconst_2
    //   58: anewarray java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: aload_0
    //   64: getfield hostname : Ljava/lang/String;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: iload_1
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: aastore
    //   75: iload_1
    //   76: aload_2
    //   77: invokespecial <init> : (Lokhttp3/internal/framed/FramedConnection;Ljava/lang/String;[Ljava/lang/Object;ILjava/util/List;)V
    //   80: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   85: goto -> 28
    //   88: astore_2
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_2
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   2	28	88	finally
    //   29	45	88	finally
    //   89	91	88	finally
  }
  
  private void pushResetLater(final int streamId, final ErrorCode errorCode) {
    this.pushExecutor.execute((Runnable)new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[] { this.hostname, Integer.valueOf(streamId) }) {
          public void execute() {
            FramedConnection.this.pushObserver.onReset(streamId, errorCode);
            synchronized (FramedConnection.this) {
              FramedConnection.this.currentPushRequests.remove(Integer.valueOf(streamId));
              return;
            } 
          }
        });
  }
  
  private boolean pushedStream(int paramInt) {
    return (this.protocol == Protocol.HTTP_2 && paramInt != 0 && (paramInt & 0x1) == 0);
  }
  
  private Ping removePing(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield pings : Ljava/util/Map;
    //   6: ifnull -> 30
    //   9: aload_0
    //   10: getfield pings : Ljava/util/Map;
    //   13: iload_1
    //   14: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   17: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast okhttp3/internal/framed/Ping
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  private void setIdle(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 18
    //   6: invokestatic nanoTime : ()J
    //   9: lstore_2
    //   10: aload_0
    //   11: lload_2
    //   12: putfield idleStartTimeNs : J
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: ldc2_w 9223372036854775807
    //   21: lstore_2
    //   22: goto -> 10
    //   25: astore #4
    //   27: aload_0
    //   28: monitorexit
    //   29: aload #4
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   6	10	25	finally
    //   10	15	25	finally
  }
  
  private void writePing(boolean paramBoolean, int paramInt1, int paramInt2, Ping paramPing) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   4: astore #5
    //   6: aload #5
    //   8: monitorenter
    //   9: aload #4
    //   11: ifnull -> 19
    //   14: aload #4
    //   16: invokevirtual send : ()V
    //   19: aload_0
    //   20: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   23: iload_1
    //   24: iload_2
    //   25: iload_3
    //   26: invokeinterface ping : (ZII)V
    //   31: aload #5
    //   33: monitorexit
    //   34: return
    //   35: astore #4
    //   37: aload #5
    //   39: monitorexit
    //   40: aload #4
    //   42: athrow
    // Exception table:
    //   from	to	target	type
    //   14	19	35	finally
    //   19	34	35	finally
    //   37	40	35	finally
  }
  
  private void writePingLater(final boolean reply, final int payload1, final int payload2, final Ping ping) {
    executor.execute((Runnable)new NamedRunnable("OkHttp %s ping %08x%08x", new Object[] { this.hostname, Integer.valueOf(payload1), Integer.valueOf(payload2) }) {
          public void execute() {
            try {
              FramedConnection.this.writePing(reply, payload1, payload2, ping);
            } catch (IOException iOException) {}
          }
        });
  }
  
  void addBytesToWriteWindow(long paramLong) {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L)
      notifyAll(); 
  }
  
  public void close() throws IOException {
    close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
  }
  
  public void flush() throws IOException {
    this.frameWriter.flush();
  }
  
  public long getIdleStartTimeNs() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield idleStartTimeNs : J
    //   6: lstore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: lload_1
    //   10: lreturn
    //   11: astore_3
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_3
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public Protocol getProtocol() {
    return this.protocol;
  }
  
  FramedStream getStream(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast okhttp3/internal/framed/FramedStream
    //   18: astore_2
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_2
    //   22: areturn
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	23	finally
  }
  
  public boolean isIdle() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield idleStartTimeNs : J
    //   6: lstore_1
    //   7: lload_1
    //   8: ldc2_w 9223372036854775807
    //   11: lcmp
    //   12: ifeq -> 21
    //   15: iconst_1
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_3
    //   23: goto -> 17
    //   26: astore #4
    //   28: aload_0
    //   29: monitorexit
    //   30: aload #4
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
  }
  
  public int maxConcurrentStreams() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield peerSettings : Lokhttp3/internal/framed/Settings;
    //   6: ldc 2147483647
    //   8: invokevirtual getMaxConcurrentStreams : (I)I
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
  
  public FramedStream newStream(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
    return newStream(0, paramList, paramBoolean1, paramBoolean2);
  }
  
  public int openStreamCount() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
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
  
  public Ping ping() throws IOException {
    // Byte code:
    //   0: new okhttp3/internal/framed/Ping
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield shutdown : Z
    //   14: ifeq -> 35
    //   17: new java/io/IOException
    //   20: astore_2
    //   21: aload_2
    //   22: ldc_w 'shutdown'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload_2
    //   29: athrow
    //   30: astore_2
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_2
    //   34: athrow
    //   35: aload_0
    //   36: getfield nextPingId : I
    //   39: istore_3
    //   40: aload_0
    //   41: aload_0
    //   42: getfield nextPingId : I
    //   45: iconst_2
    //   46: iadd
    //   47: putfield nextPingId : I
    //   50: aload_0
    //   51: getfield pings : Ljava/util/Map;
    //   54: ifnonnull -> 70
    //   57: new java/util/HashMap
    //   60: astore_2
    //   61: aload_2
    //   62: invokespecial <init> : ()V
    //   65: aload_0
    //   66: aload_2
    //   67: putfield pings : Ljava/util/Map;
    //   70: aload_0
    //   71: getfield pings : Ljava/util/Map;
    //   74: iload_3
    //   75: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   78: aload_1
    //   79: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   84: pop
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_0
    //   88: iconst_0
    //   89: iload_3
    //   90: ldc_w 1330343787
    //   93: aload_1
    //   94: invokespecial writePing : (ZIILokhttp3/internal/framed/Ping;)V
    //   97: aload_1
    //   98: areturn
    // Exception table:
    //   from	to	target	type
    //   10	30	30	finally
    //   31	33	30	finally
    //   35	70	30	finally
    //   70	87	30	finally
  }
  
  public FramedStream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean) throws IOException {
    if (this.client)
      throw new IllegalStateException("Client cannot push requests."); 
    if (this.protocol != Protocol.HTTP_2)
      throw new IllegalStateException("protocol != HTTP_2"); 
    return newStream(paramInt, paramList, paramBoolean, false);
  }
  
  FramedStream removeStream(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield streams : Ljava/util/Map;
    //   6: iload_1
    //   7: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   10: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast okhttp3/internal/framed/FramedStream
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull -> 40
    //   23: aload_0
    //   24: getfield streams : Ljava/util/Map;
    //   27: invokeinterface isEmpty : ()Z
    //   32: ifeq -> 40
    //   35: aload_0
    //   36: iconst_1
    //   37: invokespecial setIdle : (Z)V
    //   40: aload_0
    //   41: invokevirtual notifyAll : ()V
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	48	finally
    //   23	40	48	finally
    //   40	44	48	finally
  }
  
  public void setSettings(Settings paramSettings) throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield shutdown : Z
    //   13: ifeq -> 39
    //   16: new java/io/IOException
    //   19: astore_1
    //   20: aload_1
    //   21: ldc_w 'shutdown'
    //   24: invokespecial <init> : (Ljava/lang/String;)V
    //   27: aload_1
    //   28: athrow
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    //   34: astore_1
    //   35: aload_2
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    //   39: aload_0
    //   40: getfield okHttpSettings : Lokhttp3/internal/framed/Settings;
    //   43: aload_1
    //   44: invokevirtual merge : (Lokhttp3/internal/framed/Settings;)V
    //   47: aload_0
    //   48: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   51: aload_1
    //   52: invokeinterface settings : (Lokhttp3/internal/framed/Settings;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: monitorexit
    //   61: return
    // Exception table:
    //   from	to	target	type
    //   7	9	34	finally
    //   9	29	29	finally
    //   30	32	29	finally
    //   32	34	34	finally
    //   35	37	34	finally
    //   39	59	29	finally
    //   59	61	34	finally
  }
  
  public void shutdown(ErrorCode paramErrorCode) throws IOException {
    synchronized (this.frameWriter) {
      /* monitor enter ThisExpression{ObjectType{okhttp3/internal/framed/FramedConnection}} */
      try {
        if (this.shutdown) {
          /* monitor exit ThisExpression{ObjectType{okhttp3/internal/framed/FramedConnection}} */
          return;
        } 
        this.shutdown = true;
        int i = this.lastGoodStreamId;
        /* monitor exit ThisExpression{ObjectType{okhttp3/internal/framed/FramedConnection}} */
        this.frameWriter.goAway(i, paramErrorCode, Util.EMPTY_BYTE_ARRAY);
        return;
      } finally {}
    } 
    /* monitor exit ThisExpression{ObjectType{okhttp3/internal/framed/FramedConnection}} */
    throw paramErrorCode;
  }
  
  public void start() throws IOException {
    start(true);
  }
  
  void start(boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      this.frameWriter.connectionPreface();
      this.frameWriter.settings(this.okHttpSettings);
      int i = this.okHttpSettings.getInitialWindowSize(65536);
      if (i != 65536)
        this.frameWriter.windowUpdate(0, (i - 65536)); 
    } 
    (new Thread((Runnable)this.readerRunnable)).start();
  }
  
  public void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong) throws IOException {
    // Byte code:
    //   0: lload #4
    //   2: lstore #6
    //   4: lload #4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne -> 104
    //   11: aload_0
    //   12: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokeinterface data : (ZILokio/Buffer;I)V
    //   24: return
    //   25: lload #6
    //   27: aload_0
    //   28: getfield bytesLeftInWriteWindow : J
    //   31: invokestatic min : (JJ)J
    //   34: l2i
    //   35: aload_0
    //   36: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   39: invokeinterface maxDataLength : ()I
    //   44: invokestatic min : (II)I
    //   47: istore #8
    //   49: aload_0
    //   50: aload_0
    //   51: getfield bytesLeftInWriteWindow : J
    //   54: iload #8
    //   56: i2l
    //   57: lsub
    //   58: putfield bytesLeftInWriteWindow : J
    //   61: aload_0
    //   62: monitorexit
    //   63: lload #6
    //   65: iload #8
    //   67: i2l
    //   68: lsub
    //   69: lstore #6
    //   71: aload_0
    //   72: getfield frameWriter : Lokhttp3/internal/framed/FrameWriter;
    //   75: astore #9
    //   77: iload_2
    //   78: ifeq -> 174
    //   81: lload #6
    //   83: lconst_0
    //   84: lcmp
    //   85: ifne -> 174
    //   88: iconst_1
    //   89: istore #10
    //   91: aload #9
    //   93: iload #10
    //   95: iload_1
    //   96: aload_3
    //   97: iload #8
    //   99: invokeinterface data : (ZILokio/Buffer;I)V
    //   104: lload #6
    //   106: lconst_0
    //   107: lcmp
    //   108: ifle -> 24
    //   111: aload_0
    //   112: monitorenter
    //   113: aload_0
    //   114: getfield bytesLeftInWriteWindow : J
    //   117: lconst_0
    //   118: lcmp
    //   119: ifgt -> 25
    //   122: aload_0
    //   123: getfield streams : Ljava/util/Map;
    //   126: iload_1
    //   127: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   130: invokeinterface containsKey : (Ljava/lang/Object;)Z
    //   135: ifne -> 167
    //   138: new java/io/IOException
    //   141: astore_3
    //   142: aload_3
    //   143: ldc_w 'stream closed'
    //   146: invokespecial <init> : (Ljava/lang/String;)V
    //   149: aload_3
    //   150: athrow
    //   151: astore_3
    //   152: new java/io/InterruptedIOException
    //   155: astore_3
    //   156: aload_3
    //   157: invokespecial <init> : ()V
    //   160: aload_3
    //   161: athrow
    //   162: astore_3
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_3
    //   166: athrow
    //   167: aload_0
    //   168: invokevirtual wait : ()V
    //   171: goto -> 113
    //   174: iconst_0
    //   175: istore #10
    //   177: goto -> 91
    // Exception table:
    //   from	to	target	type
    //   25	63	162	finally
    //   113	151	151	java/lang/InterruptedException
    //   113	151	162	finally
    //   152	162	162	finally
    //   163	165	162	finally
    //   167	171	151	java/lang/InterruptedException
    //   167	171	162	finally
  }
  
  void writeSynReply(int paramInt, boolean paramBoolean, List<Header> paramList) throws IOException {
    this.frameWriter.synReply(paramBoolean, paramInt, paramList);
  }
  
  void writeSynReset(int paramInt, ErrorCode paramErrorCode) throws IOException {
    this.frameWriter.rstStream(paramInt, paramErrorCode);
  }
  
  void writeSynResetLater(final int streamId, final ErrorCode errorCode) {
    executor.submit((Runnable)new NamedRunnable("OkHttp %s stream %d", new Object[] { this.hostname, Integer.valueOf(streamId) }) {
          public void execute() {
            try {
              FramedConnection.this.writeSynReset(streamId, errorCode);
            } catch (IOException iOException) {}
          }
        });
  }
  
  void writeWindowUpdateLater(final int streamId, final long unacknowledgedBytesRead) {
    executor.execute((Runnable)new NamedRunnable("OkHttp Window Update %s stream %d", new Object[] { this.hostname, Integer.valueOf(streamId) }) {
          public void execute() {
            try {
              FramedConnection.this.frameWriter.windowUpdate(streamId, unacknowledgedBytesRead);
            } catch (IOException iOException) {}
          }
        });
  }
  
  static {
    boolean bool;
    if (!FramedConnection.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    $assertionsDisabled = bool;
  }
  
  public static class Builder {
    private boolean client;
    
    private String hostname;
    
    private FramedConnection.Listener listener = FramedConnection.Listener.REFUSE_INCOMING_STREAMS;
    
    private Protocol protocol = Protocol.SPDY_3;
    
    private PushObserver pushObserver = PushObserver.CANCEL;
    
    private BufferedSink sink;
    
    private Socket socket;
    
    private BufferedSource source;
    
    public Builder(boolean param1Boolean) throws IOException {
      this.client = param1Boolean;
    }
    
    public FramedConnection build() throws IOException {
      return new FramedConnection(this);
    }
    
    public Builder listener(FramedConnection.Listener param1Listener) {
      this.listener = param1Listener;
      return this;
    }
    
    public Builder protocol(Protocol param1Protocol) {
      this.protocol = param1Protocol;
      return this;
    }
    
    public Builder pushObserver(PushObserver param1PushObserver) {
      this.pushObserver = param1PushObserver;
      return this;
    }
    
    public Builder socket(Socket param1Socket) throws IOException {
      return socket(param1Socket, ((InetSocketAddress)param1Socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(param1Socket)), Okio.buffer(Okio.sink(param1Socket)));
    }
    
    public Builder socket(Socket param1Socket, String param1String, BufferedSource param1BufferedSource, BufferedSink param1BufferedSink) {
      this.socket = param1Socket;
      this.hostname = param1String;
      this.source = param1BufferedSource;
      this.sink = param1BufferedSink;
      return this;
    }
  }
  
  public static abstract class Listener {
    public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
        public void onStream(FramedStream param2FramedStream) throws IOException {
          param2FramedStream.close(ErrorCode.REFUSED_STREAM);
        }
      };
    
    public void onSettings(FramedConnection param1FramedConnection) {}
    
    public abstract void onStream(FramedStream param1FramedStream) throws IOException;
  }
  
  static final class null extends Listener {
    public void onStream(FramedStream param1FramedStream) throws IOException {
      param1FramedStream.close(ErrorCode.REFUSED_STREAM);
    }
  }
  
  class Reader extends NamedRunnable implements FrameReader.Handler {
    final FrameReader frameReader;
    
    private Reader(FrameReader param1FrameReader) {
      super("OkHttp %s", new Object[] { FramedConnection.access$1100(this$0) });
      this.frameReader = param1FrameReader;
    }
    
    private void ackSettingsLater(final Settings peerSettings) {
      FramedConnection.executor.execute((Runnable)new NamedRunnable("OkHttp %s ACK Settings", new Object[] { FramedConnection.access$1100(this.this$0) }) {
            public void execute() {
              try {
                FramedConnection.this.frameWriter.ackSettings(peerSettings);
              } catch (IOException iOException) {}
            }
          });
    }
    
    public void ackSettings() {}
    
    public void alternateService(int param1Int1, String param1String1, ByteString param1ByteString, String param1String2, int param1Int2, long param1Long) {}
    
    public void data(boolean param1Boolean, int param1Int1, BufferedSource param1BufferedSource, int param1Int2) throws IOException {
      if (FramedConnection.this.pushedStream(param1Int1)) {
        FramedConnection.this.pushDataLater(param1Int1, param1BufferedSource, param1Int2, param1Boolean);
        return;
      } 
      FramedStream framedStream = FramedConnection.this.getStream(param1Int1);
      if (framedStream == null) {
        FramedConnection.this.writeSynResetLater(param1Int1, ErrorCode.INVALID_STREAM);
        param1BufferedSource.skip(param1Int2);
        return;
      } 
      framedStream.receiveData(param1BufferedSource, param1Int2);
      if (param1Boolean)
        framedStream.receiveFin(); 
    }
    
    protected void execute() {
      // Byte code:
      //   0: getstatic okhttp3/internal/framed/ErrorCode.INTERNAL_ERROR : Lokhttp3/internal/framed/ErrorCode;
      //   3: astore_1
      //   4: getstatic okhttp3/internal/framed/ErrorCode.INTERNAL_ERROR : Lokhttp3/internal/framed/ErrorCode;
      //   7: astore_2
      //   8: aload_1
      //   9: astore_3
      //   10: aload_1
      //   11: astore #4
      //   13: aload_0
      //   14: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
      //   17: getfield client : Z
      //   20: ifne -> 37
      //   23: aload_1
      //   24: astore_3
      //   25: aload_1
      //   26: astore #4
      //   28: aload_0
      //   29: getfield frameReader : Lokhttp3/internal/framed/FrameReader;
      //   32: invokeinterface readConnectionPreface : ()V
      //   37: aload_1
      //   38: astore_3
      //   39: aload_1
      //   40: astore #4
      //   42: aload_0
      //   43: getfield frameReader : Lokhttp3/internal/framed/FrameReader;
      //   46: aload_0
      //   47: invokeinterface nextFrame : (Lokhttp3/internal/framed/FrameReader$Handler;)Z
      //   52: ifne -> 37
      //   55: aload_1
      //   56: astore_3
      //   57: aload_1
      //   58: astore #4
      //   60: getstatic okhttp3/internal/framed/ErrorCode.NO_ERROR : Lokhttp3/internal/framed/ErrorCode;
      //   63: astore_1
      //   64: aload_1
      //   65: astore_3
      //   66: aload_1
      //   67: astore #4
      //   69: getstatic okhttp3/internal/framed/ErrorCode.CANCEL : Lokhttp3/internal/framed/ErrorCode;
      //   72: astore #5
      //   74: aload_0
      //   75: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
      //   78: aload_1
      //   79: aload #5
      //   81: invokestatic access$1200 : (Lokhttp3/internal/framed/FramedConnection;Lokhttp3/internal/framed/ErrorCode;Lokhttp3/internal/framed/ErrorCode;)V
      //   84: aload_0
      //   85: getfield frameReader : Lokhttp3/internal/framed/FrameReader;
      //   88: invokestatic closeQuietly : (Ljava/io/Closeable;)V
      //   91: return
      //   92: astore #4
      //   94: aload_3
      //   95: astore #4
      //   97: getstatic okhttp3/internal/framed/ErrorCode.PROTOCOL_ERROR : Lokhttp3/internal/framed/ErrorCode;
      //   100: astore_3
      //   101: aload_3
      //   102: astore #4
      //   104: getstatic okhttp3/internal/framed/ErrorCode.PROTOCOL_ERROR : Lokhttp3/internal/framed/ErrorCode;
      //   107: astore_1
      //   108: aload_0
      //   109: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
      //   112: aload_3
      //   113: aload_1
      //   114: invokestatic access$1200 : (Lokhttp3/internal/framed/FramedConnection;Lokhttp3/internal/framed/ErrorCode;Lokhttp3/internal/framed/ErrorCode;)V
      //   117: aload_0
      //   118: getfield frameReader : Lokhttp3/internal/framed/FrameReader;
      //   121: invokestatic closeQuietly : (Ljava/io/Closeable;)V
      //   124: goto -> 91
      //   127: astore_3
      //   128: aload_0
      //   129: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
      //   132: aload #4
      //   134: aload_2
      //   135: invokestatic access$1200 : (Lokhttp3/internal/framed/FramedConnection;Lokhttp3/internal/framed/ErrorCode;Lokhttp3/internal/framed/ErrorCode;)V
      //   138: aload_0
      //   139: getfield frameReader : Lokhttp3/internal/framed/FrameReader;
      //   142: invokestatic closeQuietly : (Ljava/io/Closeable;)V
      //   145: aload_3
      //   146: athrow
      //   147: astore #4
      //   149: goto -> 138
      //   152: astore #4
      //   154: goto -> 117
      //   157: astore #4
      //   159: goto -> 84
      // Exception table:
      //   from	to	target	type
      //   13	23	92	java/io/IOException
      //   13	23	127	finally
      //   28	37	92	java/io/IOException
      //   28	37	127	finally
      //   42	55	92	java/io/IOException
      //   42	55	127	finally
      //   60	64	92	java/io/IOException
      //   60	64	127	finally
      //   69	74	92	java/io/IOException
      //   69	74	127	finally
      //   74	84	157	java/io/IOException
      //   97	101	127	finally
      //   104	108	127	finally
      //   108	117	152	java/io/IOException
      //   128	138	147	java/io/IOException
    }
    
    public void goAway(int param1Int, ErrorCode param1ErrorCode, ByteString param1ByteString) {
      FramedConnection framedConnection;
      FramedStream framedStream;
      if (param1ByteString.size() > 0);
      synchronized (FramedConnection.this) {
        FramedStream[] arrayOfFramedStream = (FramedStream[])FramedConnection.this.streams.values().toArray((Object[])new FramedStream[FramedConnection.this.streams.size()]);
        FramedConnection.access$1602(FramedConnection.this, true);
        int i = arrayOfFramedStream.length;
        for (byte b = 0; b < i; b++) {
          framedStream = arrayOfFramedStream[b];
          if (framedStream.getId() > param1Int && framedStream.isLocallyInitiated()) {
            framedStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
            FramedConnection.this.removeStream(framedStream.getId());
          } 
        } 
      } 
    }
    
    public void headers(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, List<Header> param1List, HeadersMode param1HeadersMode) {
      ExecutorService executorService;
      FramedStream framedStream1;
      NamedRunnable namedRunnable;
      if (FramedConnection.this.pushedStream(param1Int1)) {
        FramedConnection.this.pushHeadersLater(param1Int1, param1List, param1Boolean2);
        return;
      } 
      synchronized (FramedConnection.this) {
        if (FramedConnection.this.shutdown)
          return; 
      } 
      FramedStream framedStream2 = FramedConnection.this.getStream(param1Int1);
      if (framedStream2 == null) {
        if (param1HeadersMode.failIfStreamAbsent()) {
          FramedConnection.this.writeSynResetLater(param1Int1, ErrorCode.INVALID_STREAM);
          /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_7} */
          return;
        } 
        if (param1Int1 <= FramedConnection.this.lastGoodStreamId) {
          /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_7} */
          return;
        } 
        if (param1Int1 % 2 == FramedConnection.this.nextStreamId % 2) {
          /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_7} */
          return;
        } 
        framedStream1 = new FramedStream();
        this(param1Int1, FramedConnection.this, param1Boolean1, param1Boolean2, param1List);
        FramedConnection.access$1702(FramedConnection.this, param1Int1);
        FramedConnection.this.streams.put(Integer.valueOf(param1Int1), framedStream1);
        executorService = FramedConnection.executor;
        namedRunnable = new NamedRunnable() {
            public void execute() {
              try {
                FramedConnection.this.listener.onStream(newStream);
              } catch (IOException iOException) {
                Platform.get().log(4, "FramedConnection.Listener failure for " + FramedConnection.this.hostname, iOException);
              } 
            }
          };
        super(this, "OkHttp %s stream %d", new Object[] { FramedConnection.access$1100(this.this$0), Integer.valueOf(param1Int1) }, framedStream1);
        executorService.execute((Runnable)namedRunnable);
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_7} */
        return;
      } 
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_7} */
      if (framedStream1.failIfStreamPresent()) {
        namedRunnable.closeLater(ErrorCode.PROTOCOL_ERROR);
        FramedConnection.this.removeStream(param1Int1);
        return;
      } 
      namedRunnable.receiveHeaders((List<Header>)executorService, (HeadersMode)framedStream1);
      if (param1Boolean2)
        namedRunnable.receiveFin(); 
    }
    
    public void ping(boolean param1Boolean, int param1Int1, int param1Int2) {
      if (param1Boolean) {
        Ping ping = FramedConnection.this.removePing(param1Int1);
        if (ping != null)
          ping.receive(); 
        return;
      } 
      FramedConnection.this.writePingLater(true, param1Int1, param1Int2, null);
    }
    
    public void priority(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {}
    
    public void pushPromise(int param1Int1, int param1Int2, List<Header> param1List) {
      FramedConnection.this.pushRequestLater(param1Int2, param1List);
    }
    
    public void rstStream(int param1Int, ErrorCode param1ErrorCode) {
      if (FramedConnection.this.pushedStream(param1Int)) {
        FramedConnection.this.pushResetLater(param1Int, param1ErrorCode);
        return;
      } 
      FramedStream framedStream = FramedConnection.this.removeStream(param1Int);
      if (framedStream != null)
        framedStream.receiveRstStream(param1ErrorCode); 
    }
    
    public void settings(boolean param1Boolean, Settings param1Settings) {
      long l = 0L;
      Settings settings = null;
      synchronized (FramedConnection.this) {
        FramedStream[] arrayOfFramedStream;
        int i = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
        if (param1Boolean)
          FramedConnection.this.peerSettings.clear(); 
        FramedConnection.this.peerSettings.merge(param1Settings);
        if (FramedConnection.this.getProtocol() == Protocol.HTTP_2)
          ackSettingsLater(param1Settings); 
        int j = FramedConnection.this.peerSettings.getInitialWindowSize(65536);
        long l1 = l;
        param1Settings = settings;
        if (j != -1) {
          l1 = l;
          param1Settings = settings;
          if (j != i) {
            l = (j - i);
            if (!FramedConnection.this.receivedInitialPeerSettings) {
              FramedConnection.this.addBytesToWriteWindow(l);
              FramedConnection.access$2302(FramedConnection.this, true);
            } 
            l1 = l;
            param1Settings = settings;
            if (!FramedConnection.this.streams.isEmpty()) {
              arrayOfFramedStream = (FramedStream[])FramedConnection.this.streams.values().toArray((Object[])new FramedStream[FramedConnection.this.streams.size()]);
              l1 = l;
            } 
          } 
        } 
        ExecutorService executorService = FramedConnection.executor;
        NamedRunnable namedRunnable = new NamedRunnable() {
            public void execute() {
              FramedConnection.this.listener.onSettings(FramedConnection.this);
            }
          };
        super(this, "OkHttp %s settings", new Object[] { FramedConnection.access$1100(this.this$0) });
        executorService.execute((Runnable)namedRunnable);
        if (arrayOfFramedStream != null && l1 != 0L) {
          i = arrayOfFramedStream.length;
          j = 0;
          while (j < i) {
            synchronized (arrayOfFramedStream[j]) {
              null.addBytesToWriteWindow(l1);
              j++;
            } 
          } 
        } 
      } 
    }
    
    public void windowUpdate(int param1Int, long param1Long) {
      // Byte code:
      //   0: iload_1
      //   1: ifne -> 50
      //   4: aload_0
      //   5: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
      //   8: astore #4
      //   10: aload #4
      //   12: monitorenter
      //   13: aload_0
      //   14: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
      //   17: astore #5
      //   19: aload #5
      //   21: aload #5
      //   23: getfield bytesLeftInWriteWindow : J
      //   26: lload_2
      //   27: ladd
      //   28: putfield bytesLeftInWriteWindow : J
      //   31: aload_0
      //   32: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
      //   35: invokevirtual notifyAll : ()V
      //   38: aload #4
      //   40: monitorexit
      //   41: return
      //   42: astore #5
      //   44: aload #4
      //   46: monitorexit
      //   47: aload #5
      //   49: athrow
      //   50: aload_0
      //   51: getfield this$0 : Lokhttp3/internal/framed/FramedConnection;
      //   54: iload_1
      //   55: invokevirtual getStream : (I)Lokhttp3/internal/framed/FramedStream;
      //   58: astore #4
      //   60: aload #4
      //   62: ifnull -> 41
      //   65: aload #4
      //   67: monitorenter
      //   68: aload #4
      //   70: lload_2
      //   71: invokevirtual addBytesToWriteWindow : (J)V
      //   74: aload #4
      //   76: monitorexit
      //   77: goto -> 41
      //   80: astore #5
      //   82: aload #4
      //   84: monitorexit
      //   85: aload #5
      //   87: athrow
      // Exception table:
      //   from	to	target	type
      //   13	41	42	finally
      //   44	47	42	finally
      //   68	77	80	finally
      //   82	85	80	finally
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object[] param1ArrayOfObject) {
      super(param1String, param1ArrayOfObject);
    }
    
    public void execute() {
      try {
        FramedConnection.this.listener.onStream(newStream);
      } catch (IOException iOException) {
        Platform.get().log(4, "FramedConnection.Listener failure for " + FramedConnection.this.hostname, iOException);
      } 
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object... param1VarArgs) {
      super(param1String, param1VarArgs);
    }
    
    public void execute() {
      FramedConnection.this.listener.onSettings(FramedConnection.this);
    }
  }
  
  class null extends NamedRunnable {
    null(String param1String, Object[] param1ArrayOfObject) {
      super(param1String, param1ArrayOfObject);
    }
    
    public void execute() {
      try {
        FramedConnection.this.frameWriter.ackSettings(peerSettings);
      } catch (IOException iOException) {}
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\FramedConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */