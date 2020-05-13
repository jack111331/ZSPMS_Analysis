package okio;

import java.io.IOException;
import java.io.InterruptedIOException;

public class AsyncTimeout extends Timeout {
  private static final int TIMEOUT_WRITE_SIZE = 65536;
  
  private static AsyncTimeout head;
  
  private boolean inQueue;
  
  private AsyncTimeout next;
  
  private long timeoutAt;
  
  static AsyncTimeout awaitTimeout() throws InterruptedException {
    // Byte code:
    //   0: ldc okio/AsyncTimeout
    //   2: monitorenter
    //   3: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   6: getfield next : Lokio/AsyncTimeout;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull -> 26
    //   14: ldc okio/AsyncTimeout
    //   16: invokevirtual wait : ()V
    //   19: aconst_null
    //   20: astore_0
    //   21: ldc okio/AsyncTimeout
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokestatic nanoTime : ()J
    //   30: invokespecial remainingNanos : (J)J
    //   33: lstore_1
    //   34: lload_1
    //   35: lconst_0
    //   36: lcmp
    //   37: ifle -> 65
    //   40: lload_1
    //   41: ldc2_w 1000000
    //   44: ldiv
    //   45: lstore_3
    //   46: ldc okio/AsyncTimeout
    //   48: lload_3
    //   49: lload_1
    //   50: lload_3
    //   51: ldc2_w 1000000
    //   54: lmul
    //   55: lsub
    //   56: l2i
    //   57: invokevirtual wait : (JI)V
    //   60: aconst_null
    //   61: astore_0
    //   62: goto -> 21
    //   65: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   68: aload_0
    //   69: getfield next : Lokio/AsyncTimeout;
    //   72: putfield next : Lokio/AsyncTimeout;
    //   75: aload_0
    //   76: aconst_null
    //   77: putfield next : Lokio/AsyncTimeout;
    //   80: goto -> 21
    //   83: astore_0
    //   84: ldc okio/AsyncTimeout
    //   86: monitorexit
    //   87: aload_0
    //   88: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	83	finally
    //   14	19	83	finally
    //   26	34	83	finally
    //   40	60	83	finally
    //   65	80	83	finally
  }
  
  private static boolean cancelScheduledTimeout(AsyncTimeout paramAsyncTimeout) {
    // Byte code:
    //   0: ldc okio/AsyncTimeout
    //   2: monitorenter
    //   3: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull -> 47
    //   11: aload_1
    //   12: getfield next : Lokio/AsyncTimeout;
    //   15: aload_0
    //   16: if_acmpne -> 39
    //   19: aload_1
    //   20: aload_0
    //   21: getfield next : Lokio/AsyncTimeout;
    //   24: putfield next : Lokio/AsyncTimeout;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield next : Lokio/AsyncTimeout;
    //   32: iconst_0
    //   33: istore_2
    //   34: ldc okio/AsyncTimeout
    //   36: monitorexit
    //   37: iload_2
    //   38: ireturn
    //   39: aload_1
    //   40: getfield next : Lokio/AsyncTimeout;
    //   43: astore_1
    //   44: goto -> 7
    //   47: iconst_1
    //   48: istore_2
    //   49: goto -> 34
    //   52: astore_0
    //   53: ldc okio/AsyncTimeout
    //   55: monitorexit
    //   56: aload_0
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	52	finally
    //   11	32	52	finally
    //   39	44	52	finally
  }
  
  private long remainingNanos(long paramLong) {
    return this.timeoutAt - paramLong;
  }
  
  private static void scheduleTimeout(AsyncTimeout paramAsyncTimeout, long paramLong, boolean paramBoolean) {
    // Byte code:
    //   0: ldc okio/AsyncTimeout
    //   2: monitorenter
    //   3: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   6: ifnonnull -> 39
    //   9: new okio/AsyncTimeout
    //   12: astore #4
    //   14: aload #4
    //   16: invokespecial <init> : ()V
    //   19: aload #4
    //   21: putstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   24: new okio/AsyncTimeout$Watchdog
    //   27: astore #4
    //   29: aload #4
    //   31: invokespecial <init> : ()V
    //   34: aload #4
    //   36: invokevirtual start : ()V
    //   39: invokestatic nanoTime : ()J
    //   42: lstore #5
    //   44: lload_1
    //   45: lconst_0
    //   46: lcmp
    //   47: ifeq -> 139
    //   50: iload_3
    //   51: ifeq -> 139
    //   54: aload_0
    //   55: lload_1
    //   56: aload_0
    //   57: invokevirtual deadlineNanoTime : ()J
    //   60: lload #5
    //   62: lsub
    //   63: invokestatic min : (JJ)J
    //   66: lload #5
    //   68: ladd
    //   69: putfield timeoutAt : J
    //   72: aload_0
    //   73: lload #5
    //   75: invokespecial remainingNanos : (J)J
    //   78: lstore_1
    //   79: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   82: astore #4
    //   84: aload #4
    //   86: getfield next : Lokio/AsyncTimeout;
    //   89: ifnull -> 107
    //   92: lload_1
    //   93: aload #4
    //   95: getfield next : Lokio/AsyncTimeout;
    //   98: lload #5
    //   100: invokespecial remainingNanos : (J)J
    //   103: lcmp
    //   104: ifge -> 187
    //   107: aload_0
    //   108: aload #4
    //   110: getfield next : Lokio/AsyncTimeout;
    //   113: putfield next : Lokio/AsyncTimeout;
    //   116: aload #4
    //   118: aload_0
    //   119: putfield next : Lokio/AsyncTimeout;
    //   122: aload #4
    //   124: getstatic okio/AsyncTimeout.head : Lokio/AsyncTimeout;
    //   127: if_acmpne -> 135
    //   130: ldc okio/AsyncTimeout
    //   132: invokevirtual notify : ()V
    //   135: ldc okio/AsyncTimeout
    //   137: monitorexit
    //   138: return
    //   139: lload_1
    //   140: lconst_0
    //   141: lcmp
    //   142: ifeq -> 162
    //   145: aload_0
    //   146: lload #5
    //   148: lload_1
    //   149: ladd
    //   150: putfield timeoutAt : J
    //   153: goto -> 72
    //   156: astore_0
    //   157: ldc okio/AsyncTimeout
    //   159: monitorexit
    //   160: aload_0
    //   161: athrow
    //   162: iload_3
    //   163: ifeq -> 177
    //   166: aload_0
    //   167: aload_0
    //   168: invokevirtual deadlineNanoTime : ()J
    //   171: putfield timeoutAt : J
    //   174: goto -> 72
    //   177: new java/lang/AssertionError
    //   180: astore_0
    //   181: aload_0
    //   182: invokespecial <init> : ()V
    //   185: aload_0
    //   186: athrow
    //   187: aload #4
    //   189: getfield next : Lokio/AsyncTimeout;
    //   192: astore #4
    //   194: goto -> 84
    // Exception table:
    //   from	to	target	type
    //   3	39	156	finally
    //   39	44	156	finally
    //   54	72	156	finally
    //   72	84	156	finally
    //   84	107	156	finally
    //   107	135	156	finally
    //   145	153	156	finally
    //   166	174	156	finally
    //   177	187	156	finally
    //   187	194	156	finally
  }
  
  public final void enter() {
    if (this.inQueue)
      throw new IllegalStateException("Unbalanced enter/exit"); 
    long l = timeoutNanos();
    boolean bool = hasDeadline();
    if (l != 0L || bool) {
      this.inQueue = true;
      scheduleTimeout(this, l, bool);
    } 
  }
  
  final IOException exit(IOException paramIOException) throws IOException {
    if (exit())
      paramIOException = newTimeoutException(paramIOException); 
    return paramIOException;
  }
  
  final void exit(boolean paramBoolean) throws IOException {
    if (exit() && paramBoolean)
      throw newTimeoutException(null); 
  }
  
  public final boolean exit() {
    boolean bool = false;
    if (this.inQueue) {
      this.inQueue = false;
      bool = cancelScheduledTimeout(this);
    } 
    return bool;
  }
  
  protected IOException newTimeoutException(IOException paramIOException) {
    InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null)
      interruptedIOException.initCause(paramIOException); 
    return interruptedIOException;
  }
  
  public final Sink sink(final Sink sink) {
    return new Sink() {
        public void close() throws IOException {
          AsyncTimeout.this.enter();
          try {
            sink.close();
            return;
          } catch (IOException iOException) {
            throw AsyncTimeout.this.exit(iOException);
          } finally {
            AsyncTimeout.this.exit(false);
          } 
        }
        
        public void flush() throws IOException {
          AsyncTimeout.this.enter();
          try {
            sink.flush();
            return;
          } catch (IOException iOException) {
            throw AsyncTimeout.this.exit(iOException);
          } finally {
            AsyncTimeout.this.exit(false);
          } 
        }
        
        public Timeout timeout() {
          return AsyncTimeout.this;
        }
        
        public String toString() {
          return "AsyncTimeout.sink(" + sink + ")";
        }
        
        public void write(Buffer param1Buffer, long param1Long) throws IOException {
          Util.checkOffsetAndCount(param1Buffer.size, 0L, param1Long);
          label21: while (param1Long > 0L) {
            long l = 0L;
            Segment segment = param1Buffer.head;
            while (true) {
              long l1 = l;
              if (l < 65536L) {
                l += (param1Buffer.head.limit - param1Buffer.head.pos);
                if (l >= param1Long) {
                  l1 = param1Long;
                } else {
                  segment = segment.next;
                  continue;
                } 
              } 
              AsyncTimeout.this.enter();
              try {
                sink.write(param1Buffer, l1);
                param1Long -= l1;
                AsyncTimeout.this.exit(true);
              } catch (IOException iOException) {
                throw AsyncTimeout.this.exit(iOException);
              } finally {
                AsyncTimeout.this.exit(false);
              } 
              continue label21;
            } 
          } 
        }
      };
  }
  
  public final Source source(final Source source) {
    return new Source() {
        public void close() throws IOException {
          try {
            source.close();
            return;
          } catch (IOException iOException) {
            throw AsyncTimeout.this.exit(iOException);
          } finally {
            AsyncTimeout.this.exit(false);
          } 
        }
        
        public long read(Buffer param1Buffer, long param1Long) throws IOException {
          AsyncTimeout.this.enter();
          try {
            param1Long = source.read(param1Buffer, param1Long);
            return param1Long;
          } catch (IOException iOException) {
            throw AsyncTimeout.this.exit(iOException);
          } finally {
            AsyncTimeout.this.exit(false);
          } 
        }
        
        public Timeout timeout() {
          return AsyncTimeout.this;
        }
        
        public String toString() {
          return "AsyncTimeout.source(" + source + ")";
        }
      };
  }
  
  protected void timedOut() {}
  
  private static final class Watchdog extends Thread {
    public Watchdog() {
      super("Okio Watchdog");
      setDaemon(true);
    }
    
    public void run() {
      while (true) {
        try {
          while (true) {
            AsyncTimeout asyncTimeout = AsyncTimeout.awaitTimeout();
            if (asyncTimeout != null)
              asyncTimeout.timedOut(); 
          } 
          break;
        } catch (InterruptedException interruptedException) {}
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okio\AsyncTimeout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */