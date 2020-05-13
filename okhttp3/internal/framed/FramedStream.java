package okhttp3.internal.framed;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream {
  long bytesLeftInWriteWindow;
  
  private final FramedConnection connection;
  
  private ErrorCode errorCode = null;
  
  private final int id;
  
  private final StreamTimeout readTimeout = new StreamTimeout();
  
  private final List<Header> requestHeaders;
  
  private List<Header> responseHeaders;
  
  final FramedDataSink sink;
  
  private final FramedDataSource source;
  
  long unacknowledgedBytesRead = 0L;
  
  private final StreamTimeout writeTimeout = new StreamTimeout();
  
  static {
    boolean bool;
    if (!FramedStream.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    $assertionsDisabled = bool;
  }
  
  FramedStream(int paramInt, FramedConnection paramFramedConnection, boolean paramBoolean1, boolean paramBoolean2, List<Header> paramList) {
    if (paramFramedConnection == null)
      throw new NullPointerException("connection == null"); 
    if (paramList == null)
      throw new NullPointerException("requestHeaders == null"); 
    this.id = paramInt;
    this.connection = paramFramedConnection;
    this.bytesLeftInWriteWindow = paramFramedConnection.peerSettings.getInitialWindowSize(65536);
    this.source = new FramedDataSource(paramFramedConnection.okHttpSettings.getInitialWindowSize(65536));
    this.sink = new FramedDataSink();
    FramedDataSource.access$102(this.source, paramBoolean2);
    FramedDataSink.access$202(this.sink, paramBoolean1);
    this.requestHeaders = paramList;
  }
  
  private void cancelStreamIfNecessary() throws IOException {
    // Byte code:
    //   0: getstatic okhttp3/internal/framed/FramedStream.$assertionsDisabled : Z
    //   3: ifne -> 21
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifeq -> 21
    //   13: new java/lang/AssertionError
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: athrow
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield source : Lokhttp3/internal/framed/FramedStream$FramedDataSource;
    //   27: invokestatic access$100 : (Lokhttp3/internal/framed/FramedStream$FramedDataSource;)Z
    //   30: ifne -> 84
    //   33: aload_0
    //   34: getfield source : Lokhttp3/internal/framed/FramedStream$FramedDataSource;
    //   37: invokestatic access$300 : (Lokhttp3/internal/framed/FramedStream$FramedDataSource;)Z
    //   40: ifeq -> 84
    //   43: aload_0
    //   44: getfield sink : Lokhttp3/internal/framed/FramedStream$FramedDataSink;
    //   47: invokestatic access$200 : (Lokhttp3/internal/framed/FramedStream$FramedDataSink;)Z
    //   50: ifne -> 63
    //   53: aload_0
    //   54: getfield sink : Lokhttp3/internal/framed/FramedStream$FramedDataSink;
    //   57: invokestatic access$400 : (Lokhttp3/internal/framed/FramedStream$FramedDataSink;)Z
    //   60: ifeq -> 84
    //   63: iconst_1
    //   64: istore_1
    //   65: aload_0
    //   66: invokevirtual isOpen : ()Z
    //   69: istore_2
    //   70: aload_0
    //   71: monitorexit
    //   72: iload_1
    //   73: ifeq -> 94
    //   76: aload_0
    //   77: getstatic okhttp3/internal/framed/ErrorCode.CANCEL : Lokhttp3/internal/framed/ErrorCode;
    //   80: invokevirtual close : (Lokhttp3/internal/framed/ErrorCode;)V
    //   83: return
    //   84: iconst_0
    //   85: istore_1
    //   86: goto -> 65
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    //   94: iload_2
    //   95: ifne -> 83
    //   98: aload_0
    //   99: getfield connection : Lokhttp3/internal/framed/FramedConnection;
    //   102: aload_0
    //   103: getfield id : I
    //   106: invokevirtual removeStream : (I)Lokhttp3/internal/framed/FramedStream;
    //   109: pop
    //   110: goto -> 83
    // Exception table:
    //   from	to	target	type
    //   23	63	89	finally
    //   65	72	89	finally
    //   90	92	89	finally
  }
  
  private void checkOutNotClosed() throws IOException {
    if (this.sink.closed)
      throw new IOException("stream closed"); 
    if (this.sink.finished)
      throw new IOException("stream finished"); 
    if (this.errorCode != null)
      throw new StreamResetException(this.errorCode); 
  }
  
  private boolean closeInternal(ErrorCode paramErrorCode) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: getstatic okhttp3/internal/framed/FramedStream.$assertionsDisabled : Z
    //   5: ifne -> 23
    //   8: aload_0
    //   9: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   12: ifeq -> 23
    //   15: new java/lang/AssertionError
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: athrow
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   29: ifnull -> 36
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: getfield source : Lokhttp3/internal/framed/FramedStream$FramedDataSource;
    //   40: invokestatic access$100 : (Lokhttp3/internal/framed/FramedStream$FramedDataSource;)Z
    //   43: ifeq -> 66
    //   46: aload_0
    //   47: getfield sink : Lokhttp3/internal/framed/FramedStream$FramedDataSink;
    //   50: invokestatic access$200 : (Lokhttp3/internal/framed/FramedStream$FramedDataSink;)Z
    //   53: ifeq -> 66
    //   56: aload_0
    //   57: monitorexit
    //   58: goto -> 34
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    //   66: aload_0
    //   67: aload_1
    //   68: putfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   71: aload_0
    //   72: invokevirtual notifyAll : ()V
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_0
    //   78: getfield connection : Lokhttp3/internal/framed/FramedConnection;
    //   81: aload_0
    //   82: getfield id : I
    //   85: invokevirtual removeStream : (I)Lokhttp3/internal/framed/FramedStream;
    //   88: pop
    //   89: iconst_1
    //   90: istore_2
    //   91: goto -> 34
    // Exception table:
    //   from	to	target	type
    //   25	34	61	finally
    //   36	58	61	finally
    //   62	64	61	finally
    //   66	77	61	finally
  }
  
  private void waitForIo() throws InterruptedIOException {
    try {
      wait();
      return;
    } catch (InterruptedException interruptedException) {
      throw new InterruptedIOException();
    } 
  }
  
  void addBytesToWriteWindow(long paramLong) {
    this.bytesLeftInWriteWindow += paramLong;
    if (paramLong > 0L)
      notifyAll(); 
  }
  
  public void close(ErrorCode paramErrorCode) throws IOException {
    if (closeInternal(paramErrorCode))
      this.connection.writeSynReset(this.id, paramErrorCode); 
  }
  
  public void closeLater(ErrorCode paramErrorCode) {
    if (closeInternal(paramErrorCode))
      this.connection.writeSynResetLater(this.id, paramErrorCode); 
  }
  
  public FramedConnection getConnection() {
    return this.connection;
  }
  
  public ErrorCode getErrorCode() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield errorCode : Lokhttp3/internal/framed/ErrorCode;
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
  
  public int getId() {
    return this.id;
  }
  
  public List<Header> getRequestHeaders() {
    return this.requestHeaders;
  }
  
  public List<Header> getResponseHeaders() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield readTimeout : Lokhttp3/internal/framed/FramedStream$StreamTimeout;
    //   6: invokevirtual enter : ()V
    //   9: aload_0
    //   10: getfield responseHeaders : Ljava/util/List;
    //   13: ifnonnull -> 45
    //   16: aload_0
    //   17: getfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   20: ifnonnull -> 45
    //   23: aload_0
    //   24: invokespecial waitForIo : ()V
    //   27: goto -> 9
    //   30: astore_1
    //   31: aload_0
    //   32: getfield readTimeout : Lokhttp3/internal/framed/FramedStream$StreamTimeout;
    //   35: invokevirtual exitAndThrowIfTimedOut : ()V
    //   38: aload_1
    //   39: athrow
    //   40: astore_1
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_1
    //   44: athrow
    //   45: aload_0
    //   46: getfield readTimeout : Lokhttp3/internal/framed/FramedStream$StreamTimeout;
    //   49: invokevirtual exitAndThrowIfTimedOut : ()V
    //   52: aload_0
    //   53: getfield responseHeaders : Ljava/util/List;
    //   56: ifnull -> 68
    //   59: aload_0
    //   60: getfield responseHeaders : Ljava/util/List;
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: new okhttp3/internal/framed/StreamResetException
    //   71: astore_1
    //   72: aload_1
    //   73: aload_0
    //   74: getfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   77: invokespecial <init> : (Lokhttp3/internal/framed/ErrorCode;)V
    //   80: aload_1
    //   81: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	40	finally
    //   9	27	30	finally
    //   31	40	40	finally
    //   45	64	40	finally
    //   68	82	40	finally
  }
  
  public Sink getSink() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield responseHeaders : Ljava/util/List;
    //   6: ifnonnull -> 33
    //   9: aload_0
    //   10: invokevirtual isLocallyInitiated : ()Z
    //   13: ifne -> 33
    //   16: new java/lang/IllegalStateException
    //   19: astore_1
    //   20: aload_1
    //   21: ldc 'reply before requesting the sink'
    //   23: invokespecial <init> : (Ljava/lang/String;)V
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_0
    //   36: getfield sink : Lokhttp3/internal/framed/FramedStream$FramedDataSink;
    //   39: areturn
    // Exception table:
    //   from	to	target	type
    //   2	28	28	finally
    //   29	31	28	finally
    //   33	35	28	finally
  }
  
  public Source getSource() {
    return this.source;
  }
  
  public boolean isLocallyInitiated() {
    boolean bool = true;
    if ((this.id & 0x1) == 1) {
      null = true;
    } else {
      null = false;
    } 
    return (this.connection.client == null) ? bool : false;
  }
  
  public boolean isOpen() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield source : Lokhttp3/internal/framed/FramedStream$FramedDataSource;
    //   21: invokestatic access$100 : (Lokhttp3/internal/framed/FramedStream$FramedDataSource;)Z
    //   24: ifne -> 37
    //   27: aload_0
    //   28: getfield source : Lokhttp3/internal/framed/FramedStream$FramedDataSource;
    //   31: invokestatic access$300 : (Lokhttp3/internal/framed/FramedStream$FramedDataSource;)Z
    //   34: ifeq -> 66
    //   37: aload_0
    //   38: getfield sink : Lokhttp3/internal/framed/FramedStream$FramedDataSink;
    //   41: invokestatic access$200 : (Lokhttp3/internal/framed/FramedStream$FramedDataSink;)Z
    //   44: ifne -> 57
    //   47: aload_0
    //   48: getfield sink : Lokhttp3/internal/framed/FramedStream$FramedDataSink;
    //   51: invokestatic access$400 : (Lokhttp3/internal/framed/FramedStream$FramedDataSink;)Z
    //   54: ifeq -> 66
    //   57: aload_0
    //   58: getfield responseHeaders : Ljava/util/List;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull -> 13
    //   66: iconst_1
    //   67: istore_1
    //   68: goto -> 13
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   4	9	71	finally
    //   17	37	71	finally
    //   37	57	71	finally
    //   57	62	71	finally
  }
  
  public Timeout readTimeout() {
    return (Timeout)this.readTimeout;
  }
  
  void receiveData(BufferedSource paramBufferedSource, int paramInt) throws IOException {
    assert !Thread.holdsLock(this);
    this.source.receive(paramBufferedSource, paramInt);
  }
  
  void receiveFin() {
    // Byte code:
    //   0: getstatic okhttp3/internal/framed/FramedStream.$assertionsDisabled : Z
    //   3: ifne -> 21
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifeq -> 21
    //   13: new java/lang/AssertionError
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: athrow
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield source : Lokhttp3/internal/framed/FramedStream$FramedDataSource;
    //   27: iconst_1
    //   28: invokestatic access$102 : (Lokhttp3/internal/framed/FramedStream$FramedDataSource;Z)Z
    //   31: pop
    //   32: aload_0
    //   33: invokevirtual isOpen : ()Z
    //   36: istore_1
    //   37: aload_0
    //   38: invokevirtual notifyAll : ()V
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_1
    //   44: ifne -> 59
    //   47: aload_0
    //   48: getfield connection : Lokhttp3/internal/framed/FramedConnection;
    //   51: aload_0
    //   52: getfield id : I
    //   55: invokevirtual removeStream : (I)Lokhttp3/internal/framed/FramedStream;
    //   58: pop
    //   59: return
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    // Exception table:
    //   from	to	target	type
    //   23	43	60	finally
    //   61	63	60	finally
  }
  
  void receiveHeaders(List<Header> paramList, HeadersMode paramHeadersMode) {
    // Byte code:
    //   0: getstatic okhttp3/internal/framed/FramedStream.$assertionsDisabled : Z
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
    //   23: iconst_1
    //   24: istore #4
    //   26: aload_0
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield responseHeaders : Ljava/util/List;
    //   32: ifnonnull -> 83
    //   35: aload_2
    //   36: invokevirtual failIfHeadersAbsent : ()Z
    //   39: ifeq -> 58
    //   42: getstatic okhttp3/internal/framed/ErrorCode.PROTOCOL_ERROR : Lokhttp3/internal/framed/ErrorCode;
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: ifnull -> 134
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual closeLater : (Lokhttp3/internal/framed/ErrorCode;)V
    //   57: return
    //   58: aload_0
    //   59: aload_1
    //   60: putfield responseHeaders : Ljava/util/List;
    //   63: aload_0
    //   64: invokevirtual isOpen : ()Z
    //   67: istore #4
    //   69: aload_0
    //   70: invokevirtual notifyAll : ()V
    //   73: aload_3
    //   74: astore_1
    //   75: goto -> 46
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    //   83: aload_2
    //   84: invokevirtual failIfHeadersPresent : ()Z
    //   87: ifeq -> 97
    //   90: getstatic okhttp3/internal/framed/ErrorCode.STREAM_IN_USE : Lokhttp3/internal/framed/ErrorCode;
    //   93: astore_1
    //   94: goto -> 46
    //   97: new java/util/ArrayList
    //   100: astore_2
    //   101: aload_2
    //   102: invokespecial <init> : ()V
    //   105: aload_2
    //   106: aload_0
    //   107: getfield responseHeaders : Ljava/util/List;
    //   110: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   115: pop
    //   116: aload_2
    //   117: aload_1
    //   118: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   123: pop
    //   124: aload_0
    //   125: aload_2
    //   126: putfield responseHeaders : Ljava/util/List;
    //   129: aload_3
    //   130: astore_1
    //   131: goto -> 46
    //   134: iload #4
    //   136: ifne -> 57
    //   139: aload_0
    //   140: getfield connection : Lokhttp3/internal/framed/FramedConnection;
    //   143: aload_0
    //   144: getfield id : I
    //   147: invokevirtual removeStream : (I)Lokhttp3/internal/framed/FramedStream;
    //   150: pop
    //   151: goto -> 57
    // Exception table:
    //   from	to	target	type
    //   28	46	78	finally
    //   46	48	78	finally
    //   58	73	78	finally
    //   79	81	78	finally
    //   83	94	78	finally
    //   97	129	78	finally
  }
  
  void receiveRstStream(ErrorCode paramErrorCode) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   6: ifnonnull -> 18
    //   9: aload_0
    //   10: aload_1
    //   11: putfield errorCode : Lokhttp3/internal/framed/ErrorCode;
    //   14: aload_0
    //   15: invokevirtual notifyAll : ()V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public void reply(List<Header> paramList, boolean paramBoolean) throws IOException {
    // Byte code:
    //   0: getstatic okhttp3/internal/framed/FramedStream.$assertionsDisabled : Z
    //   3: ifne -> 21
    //   6: aload_0
    //   7: invokestatic holdsLock : (Ljava/lang/Object;)Z
    //   10: ifeq -> 21
    //   13: new java/lang/AssertionError
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: athrow
    //   21: iconst_0
    //   22: istore_3
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_1
    //   26: ifnonnull -> 47
    //   29: new java/lang/NullPointerException
    //   32: astore_1
    //   33: aload_1
    //   34: ldc_w 'responseHeaders == null'
    //   37: invokespecial <init> : (Ljava/lang/String;)V
    //   40: aload_1
    //   41: athrow
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: aload_0
    //   48: getfield responseHeaders : Ljava/util/List;
    //   51: ifnull -> 67
    //   54: new java/lang/IllegalStateException
    //   57: astore_1
    //   58: aload_1
    //   59: ldc_w 'reply already sent'
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: aload_1
    //   66: athrow
    //   67: aload_0
    //   68: aload_1
    //   69: putfield responseHeaders : Ljava/util/List;
    //   72: iload_2
    //   73: ifne -> 87
    //   76: aload_0
    //   77: getfield sink : Lokhttp3/internal/framed/FramedStream$FramedDataSink;
    //   80: iconst_1
    //   81: invokestatic access$202 : (Lokhttp3/internal/framed/FramedStream$FramedDataSink;Z)Z
    //   84: pop
    //   85: iconst_1
    //   86: istore_3
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_0
    //   90: getfield connection : Lokhttp3/internal/framed/FramedConnection;
    //   93: aload_0
    //   94: getfield id : I
    //   97: iload_3
    //   98: aload_1
    //   99: invokevirtual writeSynReply : (IZLjava/util/List;)V
    //   102: iload_3
    //   103: ifeq -> 113
    //   106: aload_0
    //   107: getfield connection : Lokhttp3/internal/framed/FramedConnection;
    //   110: invokevirtual flush : ()V
    //   113: return
    // Exception table:
    //   from	to	target	type
    //   29	42	42	finally
    //   43	45	42	finally
    //   47	67	42	finally
    //   67	72	42	finally
    //   76	85	42	finally
    //   87	89	42	finally
  }
  
  public Timeout writeTimeout() {
    return (Timeout)this.writeTimeout;
  }
  
  final class FramedDataSink implements Sink {
    private static final long EMIT_BUFFER_SIZE = 16384L;
    
    private boolean closed;
    
    private boolean finished;
    
    private final Buffer sendBuffer = new Buffer();
    
    static {
      boolean bool;
      if (!FramedStream.class.desiredAssertionStatus()) {
        bool = true;
      } else {
        bool = false;
      } 
      $assertionsDisabled = bool;
    }
    
    private void emitDataFrame(boolean param1Boolean) throws IOException {
      synchronized (FramedStream.this) {
        FramedStream.this.writeTimeout.enter();
      } 
      FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
      FramedStream.this.checkOutNotClosed();
      long l = Math.min(FramedStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
      FramedStream framedStream = FramedStream.this;
      framedStream.bytesLeftInWriteWindow -= l;
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
      FramedStream.this.writeTimeout.enter();
      try {
        FramedConnection framedConnection = FramedStream.this.connection;
        int i = FramedStream.this.id;
        if (param1Boolean && l == this.sendBuffer.size()) {
          param1Boolean = true;
        } else {
          param1Boolean = false;
        } 
        framedConnection.writeData(i, param1Boolean, this.sendBuffer, l);
        return;
      } finally {
        FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
      } 
    }
    
    public void close() throws IOException {
      assert !Thread.holdsLock(FramedStream.this);
      synchronized (FramedStream.this) {
        if (this.closed)
          return; 
        if (!FramedStream.this.sink.finished)
          if (this.sendBuffer.size() > 0L) {
            while (this.sendBuffer.size() > 0L)
              emitDataFrame(true); 
          } else {
            FramedStream.this.connection.writeData(FramedStream.this.id, true, null, 0L);
          }  
      } 
      synchronized (FramedStream.this) {
        this.closed = true;
        FramedStream.this.connection.flush();
        FramedStream.this.cancelStreamIfNecessary();
        return;
      } 
    }
    
    public void flush() throws IOException {
      assert !Thread.holdsLock(FramedStream.this);
      synchronized (FramedStream.this) {
        FramedStream.this.checkOutNotClosed();
        while (this.sendBuffer.size() > 0L) {
          emitDataFrame(false);
          FramedStream.this.connection.flush();
        } 
      } 
    }
    
    public Timeout timeout() {
      return (Timeout)FramedStream.this.writeTimeout;
    }
    
    public void write(Buffer param1Buffer, long param1Long) throws IOException {
      assert !Thread.holdsLock(FramedStream.this);
      this.sendBuffer.write(param1Buffer, param1Long);
      while (this.sendBuffer.size() >= 16384L)
        emitDataFrame(false); 
    }
  }
  
  private final class FramedDataSource implements Source {
    private boolean closed;
    
    private boolean finished;
    
    private final long maxByteCount;
    
    private final Buffer readBuffer = new Buffer();
    
    private final Buffer receiveBuffer = new Buffer();
    
    static {
      boolean bool;
      if (!FramedStream.class.desiredAssertionStatus()) {
        bool = true;
      } else {
        bool = false;
      } 
      $assertionsDisabled = bool;
    }
    
    private FramedDataSource(long param1Long) {
      this.maxByteCount = param1Long;
    }
    
    private void checkNotClosed() throws IOException {
      if (this.closed)
        throw new IOException("stream closed"); 
      if (FramedStream.this.errorCode != null)
        throw new StreamResetException(FramedStream.this.errorCode); 
    }
    
    private void waitUntilReadable() throws IOException {
      FramedStream.this.readTimeout.enter();
      try {
        while (this.readBuffer.size() == 0L && !this.finished && !this.closed && FramedStream.this.errorCode == null)
          FramedStream.this.waitForIo(); 
      } finally {
        FramedStream.this.readTimeout.exitAndThrowIfTimedOut();
      } 
    }
    
    public void close() throws IOException {
      synchronized (FramedStream.this) {
        this.closed = true;
        this.readBuffer.clear();
        FramedStream.this.notifyAll();
        FramedStream.this.cancelStreamIfNecessary();
        return;
      } 
    }
    
    public long read(Buffer param1Buffer, long param1Long) throws IOException {
      if (param1Long < 0L)
        throw new IllegalArgumentException("byteCount < 0: " + param1Long); 
      synchronized (FramedStream.this) {
        waitUntilReadable();
        checkNotClosed();
        if (this.readBuffer.size() == 0L) {
          param1Long = -1L;
          return param1Long;
        } 
        param1Long = this.readBuffer.read(param1Buffer, Math.min(param1Long, this.readBuffer.size()));
        FramedStream framedStream = FramedStream.this;
        framedStream.unacknowledgedBytesRead += param1Long;
        if (FramedStream.this.unacknowledgedBytesRead >= (FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)) {
          FramedStream.this.connection.writeWindowUpdateLater(FramedStream.this.id, FramedStream.this.unacknowledgedBytesRead);
          FramedStream.this.unacknowledgedBytesRead = 0L;
        } 
        FramedConnection framedConnection = FramedStream.this.connection;
        /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{okhttp3/internal/framed/FramedConnection}, name=null} */
        try {
          FramedConnection framedConnection1 = FramedStream.this.connection;
          framedConnection1.unacknowledgedBytesRead += param1Long;
          if (FramedStream.this.connection.unacknowledgedBytesRead >= (FramedStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2)) {
            FramedStream.this.connection.writeWindowUpdateLater(0, FramedStream.this.connection.unacknowledgedBytesRead);
            FramedStream.this.connection.unacknowledgedBytesRead = 0L;
          } 
          /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{okhttp3/internal/framed/FramedConnection}, name=null} */
        } finally {}
        return param1Long;
      } 
    }
    
    void receive(BufferedSource param1BufferedSource, long param1Long) throws IOException {
      long l = param1Long;
      assert false;
      while (true) {
        boolean bool;
        if (l > 0L) {
          synchronized (FramedStream.this) {
            boolean bool1;
            bool = this.finished;
            if (this.readBuffer.size() + l > this.maxByteCount) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            if (bool1) {
              param1BufferedSource.skip(l);
              FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
              return;
            } 
          } 
        } else {
          return;
        } 
        if (bool) {
          param1BufferedSource.skip(l);
          return;
        } 
        param1Long = param1BufferedSource.read(this.receiveBuffer, l);
        if (param1Long == -1L)
          throw new EOFException(); 
        l -= param1Long;
        synchronized (FramedStream.this) {
          boolean bool1;
          if (this.readBuffer.size() == 0L) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          this.readBuffer.writeAll((Source)this.receiveBuffer);
          if (bool1)
            FramedStream.this.notifyAll(); 
        } 
      } 
    }
    
    public Timeout timeout() {
      return (Timeout)FramedStream.this.readTimeout;
    }
  }
  
  class StreamTimeout extends AsyncTimeout {
    public void exitAndThrowIfTimedOut() throws IOException {
      if (exit())
        throw newTimeoutException(null); 
    }
    
    protected IOException newTimeoutException(IOException param1IOException) {
      SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
      if (param1IOException != null)
        socketTimeoutException.initCause(param1IOException); 
      return socketTimeoutException;
    }
    
    protected void timedOut() {
      FramedStream.this.closeLater(ErrorCode.CANCEL);
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\FramedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */