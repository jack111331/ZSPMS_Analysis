package okhttp3.internal.framed;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.util.List;
import java.util.zip.Deflater;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;
import okio.Sink;

public final class Spdy3 implements Variant {
  static final byte[] DICTIONARY;
  
  static final int FLAG_FIN = 1;
  
  static final int FLAG_UNIDIRECTIONAL = 2;
  
  static final int TYPE_DATA = 0;
  
  static final int TYPE_GOAWAY = 7;
  
  static final int TYPE_HEADERS = 8;
  
  static final int TYPE_PING = 6;
  
  static final int TYPE_RST_STREAM = 3;
  
  static final int TYPE_SETTINGS = 4;
  
  static final int TYPE_SYN_REPLY = 2;
  
  static final int TYPE_SYN_STREAM = 1;
  
  static final int TYPE_WINDOW_UPDATE = 9;
  
  static final int VERSION = 3;
  
  static {
    try {
      DICTIONARY = "\000\000\000\007options\000\000\000\004head\000\000\000\004post\000\000\000\003put\000\000\000\006delete\000\000\000\005trace\000\000\000\006accept\000\000\000\016accept-charset\000\000\000\017accept-encoding\000\000\000\017accept-language\000\000\000\raccept-ranges\000\000\000\003age\000\000\000\005allow\000\000\000\rauthorization\000\000\000\rcache-control\000\000\000\nconnection\000\000\000\fcontent-base\000\000\000\020content-encoding\000\000\000\020content-language\000\000\000\016content-length\000\000\000\020content-location\000\000\000\013content-md5\000\000\000\rcontent-range\000\000\000\fcontent-type\000\000\000\004date\000\000\000\004etag\000\000\000\006expect\000\000\000\007expires\000\000\000\004from\000\000\000\004host\000\000\000\bif-match\000\000\000\021if-modified-since\000\000\000\rif-none-match\000\000\000\bif-range\000\000\000\023if-unmodified-since\000\000\000\rlast-modified\000\000\000\blocation\000\000\000\fmax-forwards\000\000\000\006pragma\000\000\000\022proxy-authenticate\000\000\000\023proxy-authorization\000\000\000\005range\000\000\000\007referer\000\000\000\013retry-after\000\000\000\006server\000\000\000\002te\000\000\000\007trailer\000\000\000\021transfer-encoding\000\000\000\007upgrade\000\000\000\nuser-agent\000\000\000\004vary\000\000\000\003via\000\000\000\007warning\000\000\000\020www-authenticate\000\000\000\006method\000\000\000\003get\000\000\000\006status\000\000\000\006200 OK\000\000\000\007version\000\000\000\bHTTP/1.1\000\000\000\003url\000\000\000\006public\000\000\000\nset-cookie\000\000\000\nkeep-alive\000\000\000\006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
      return;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError();
    } 
  }
  
  public Protocol getProtocol() {
    return Protocol.SPDY_3;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean) {
    return new Reader(paramBufferedSource, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean) {
    return new Writer(paramBufferedSink, paramBoolean);
  }
  
  static final class Reader implements FrameReader {
    private final boolean client;
    
    private final NameValueBlockReader headerBlockReader;
    
    private final BufferedSource source;
    
    Reader(BufferedSource param1BufferedSource, boolean param1Boolean) {
      this.source = param1BufferedSource;
      this.headerBlockReader = new NameValueBlockReader(this.source);
      this.client = param1Boolean;
    }
    
    private static IOException ioException(String param1String, Object... param1VarArgs) throws IOException {
      throw new IOException(Util.format(param1String, param1VarArgs));
    }
    
    private void readGoAway(FrameReader.Handler param1Handler, int param1Int1, int param1Int2) throws IOException {
      if (param1Int2 != 8)
        throw ioException("TYPE_GOAWAY length: %d != 8", new Object[] { Integer.valueOf(param1Int2) }); 
      param1Int2 = this.source.readInt();
      param1Int1 = this.source.readInt();
      ErrorCode errorCode = ErrorCode.fromSpdyGoAway(param1Int1);
      if (errorCode == null)
        throw ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(param1Int1) }); 
      param1Handler.goAway(param1Int2 & Integer.MAX_VALUE, errorCode, ByteString.EMPTY);
    }
    
    private void readHeaders(FrameReader.Handler param1Handler, int param1Int1, int param1Int2) throws IOException {
      param1Handler.headers(false, false, this.source.readInt() & Integer.MAX_VALUE, -1, this.headerBlockReader.readNameValueBlock(param1Int2 - 4), HeadersMode.SPDY_HEADERS);
    }
    
    private void readPing(FrameReader.Handler param1Handler, int param1Int1, int param1Int2) throws IOException {
      boolean bool2;
      boolean bool = true;
      if (param1Int2 != 4)
        throw ioException("TYPE_PING length: %d != 4", new Object[] { Integer.valueOf(param1Int2) }); 
      param1Int1 = this.source.readInt();
      boolean bool1 = this.client;
      if ((param1Int1 & 0x1) == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if (bool1 == bool2) {
        bool2 = bool;
      } else {
        bool2 = false;
      } 
      param1Handler.ping(bool2, param1Int1, 0);
    }
    
    private void readRstStream(FrameReader.Handler param1Handler, int param1Int1, int param1Int2) throws IOException {
      if (param1Int2 != 8)
        throw ioException("TYPE_RST_STREAM length: %d != 8", new Object[] { Integer.valueOf(param1Int2) }); 
      param1Int1 = this.source.readInt();
      param1Int2 = this.source.readInt();
      ErrorCode errorCode = ErrorCode.fromSpdy3Rst(param1Int2);
      if (errorCode == null)
        throw ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(param1Int2) }); 
      param1Handler.rstStream(param1Int1 & Integer.MAX_VALUE, errorCode);
    }
    
    private void readSettings(FrameReader.Handler param1Handler, int param1Int1, int param1Int2) throws IOException {
      boolean bool = true;
      int i = this.source.readInt();
      if (param1Int2 != i * 8 + 4)
        throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] { Integer.valueOf(param1Int2), Integer.valueOf(i) }); 
      Settings settings = new Settings();
      for (param1Int2 = 0; param1Int2 < i; param1Int2++) {
        int j = this.source.readInt();
        settings.set(j & 0xFFFFFF, (0xFF000000 & j) >>> 24, this.source.readInt());
      } 
      if ((param1Int1 & 0x1) == 0)
        bool = false; 
      param1Handler.settings(bool, settings);
    }
    
    private void readSynReply(FrameReader.Handler param1Handler, int param1Int1, int param1Int2) throws IOException {
      boolean bool;
      int i = this.source.readInt();
      List<Header> list = this.headerBlockReader.readNameValueBlock(param1Int2 - 4);
      if ((param1Int1 & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      param1Handler.headers(false, bool, i & Integer.MAX_VALUE, -1, list, HeadersMode.SPDY_REPLY);
    }
    
    private void readSynStream(FrameReader.Handler param1Handler, int param1Int1, int param1Int2) throws IOException {
      boolean bool2;
      boolean bool1 = true;
      int i = this.source.readInt();
      int j = this.source.readInt();
      this.source.readShort();
      List<Header> list = this.headerBlockReader.readNameValueBlock(param1Int2 - 10);
      if ((param1Int1 & 0x1) != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      if ((param1Int1 & 0x2) == 0)
        bool1 = false; 
      param1Handler.headers(bool1, bool2, i & Integer.MAX_VALUE, j & Integer.MAX_VALUE, list, HeadersMode.SPDY_SYN_STREAM);
    }
    
    private void readWindowUpdate(FrameReader.Handler param1Handler, int param1Int1, int param1Int2) throws IOException {
      if (param1Int2 != 8)
        throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] { Integer.valueOf(param1Int2) }); 
      param1Int1 = this.source.readInt();
      long l = (this.source.readInt() & Integer.MAX_VALUE);
      if (l == 0L)
        throw ioException("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) }); 
      param1Handler.windowUpdate(param1Int1 & Integer.MAX_VALUE, l);
    }
    
    public void close() throws IOException {
      this.headerBlockReader.close();
    }
    
    public boolean nextFrame(FrameReader.Handler param1Handler) throws IOException {
      int i;
      int j;
      int k;
      null = false;
      boolean bool = true;
      try {
        int m;
        i = this.source.readInt();
        j = this.source.readInt();
        if ((Integer.MIN_VALUE & i) != 0) {
          m = 1;
        } else {
          m = 0;
        } 
        k = (0xFF000000 & j) >>> 24;
        j &= 0xFFFFFF;
        if (m) {
          m = (0x7FFF0000 & i) >>> 16;
          if (m != 3)
            throw new ProtocolException("version != 3: " + m); 
          switch (i & 0xFFFF) {
            default:
              this.source.skip(j);
              return bool;
            case 1:
              readSynStream(param1Handler, k, j);
              return bool;
            case 2:
              readSynReply(param1Handler, k, j);
              return bool;
            case 3:
              readRstStream(param1Handler, k, j);
              return bool;
            case 4:
              readSettings(param1Handler, k, j);
              return bool;
            case 6:
              readPing(param1Handler, k, j);
              return bool;
            case 7:
              readGoAway(param1Handler, k, j);
              return bool;
            case 8:
              readHeaders(param1Handler, k, j);
              return bool;
            case 9:
              break;
          } 
          readWindowUpdate(param1Handler, k, j);
          return bool;
        } 
      } catch (IOException iOException) {
        return false;
      } 
      if ((k & 0x1) != 0)
        null = true; 
      iOException.data(null, i & Integer.MAX_VALUE, this.source, j);
      return bool;
    }
    
    public void readConnectionPreface() {}
  }
  
  static final class Writer implements FrameWriter {
    private final boolean client;
    
    private boolean closed;
    
    private final Buffer headerBlockBuffer;
    
    private final BufferedSink headerBlockOut;
    
    private final BufferedSink sink;
    
    Writer(BufferedSink param1BufferedSink, boolean param1Boolean) {
      this.sink = param1BufferedSink;
      this.client = param1Boolean;
      Deflater deflater = new Deflater();
      deflater.setDictionary(Spdy3.DICTIONARY);
      this.headerBlockBuffer = new Buffer();
      this.headerBlockOut = Okio.buffer((Sink)new DeflaterSink((Sink)this.headerBlockBuffer, deflater));
    }
    
    private void writeNameValueBlockToBuffer(List<Header> param1List) throws IOException {
      this.headerBlockOut.writeInt(param1List.size());
      byte b = 0;
      int i = param1List.size();
      while (b < i) {
        ByteString byteString = ((Header)param1List.get(b)).name;
        this.headerBlockOut.writeInt(byteString.size());
        this.headerBlockOut.write(byteString);
        byteString = ((Header)param1List.get(b)).value;
        this.headerBlockOut.writeInt(byteString.size());
        this.headerBlockOut.write(byteString);
        b++;
      } 
      this.headerBlockOut.flush();
    }
    
    public void ackSettings(Settings param1Settings) {}
    
    public void close() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield closed : Z
      //   7: aload_0
      //   8: getfield sink : Lokio/BufferedSink;
      //   11: aload_0
      //   12: getfield headerBlockOut : Lokio/BufferedSink;
      //   15: invokestatic closeAll : (Ljava/io/Closeable;Ljava/io/Closeable;)V
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
    
    public void connectionPreface() {
      /* monitor enter ThisExpression{InnerObjectType{ObjectType{okhttp3/internal/framed/Spdy3}.Lokhttp3/internal/framed/Spdy3$Writer;}} */
      /* monitor exit ThisExpression{InnerObjectType{ObjectType{okhttp3/internal/framed/Spdy3}.Lokhttp3/internal/framed/Spdy3$Writer;}} */
    }
    
    public void data(boolean param1Boolean, int param1Int1, Buffer param1Buffer, int param1Int2) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_1
      //   3: ifeq -> 22
      //   6: iconst_1
      //   7: istore #5
      //   9: aload_0
      //   10: iload_2
      //   11: iload #5
      //   13: aload_3
      //   14: iload #4
      //   16: invokevirtual sendDataFrame : (IILokio/Buffer;I)V
      //   19: aload_0
      //   20: monitorexit
      //   21: return
      //   22: iconst_0
      //   23: istore #5
      //   25: goto -> 9
      //   28: astore_3
      //   29: aload_0
      //   30: monitorexit
      //   31: aload_3
      //   32: athrow
      // Exception table:
      //   from	to	target	type
      //   9	19	28	finally
    }
    
    public void flush() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifeq -> 26
      //   9: new java/io/IOException
      //   12: astore_1
      //   13: aload_1
      //   14: ldc 'closed'
      //   16: invokespecial <init> : (Ljava/lang/String;)V
      //   19: aload_1
      //   20: athrow
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      //   26: aload_0
      //   27: getfield sink : Lokio/BufferedSink;
      //   30: invokeinterface flush : ()V
      //   35: aload_0
      //   36: monitorexit
      //   37: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	35	21	finally
    }
    
    public void goAway(int param1Int, ErrorCode param1ErrorCode, byte[] param1ArrayOfbyte) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifeq -> 26
      //   9: new java/io/IOException
      //   12: astore_2
      //   13: aload_2
      //   14: ldc 'closed'
      //   16: invokespecial <init> : (Ljava/lang/String;)V
      //   19: aload_2
      //   20: athrow
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: athrow
      //   26: aload_2
      //   27: getfield spdyGoAwayCode : I
      //   30: iconst_m1
      //   31: if_icmpne -> 46
      //   34: new java/lang/IllegalArgumentException
      //   37: astore_2
      //   38: aload_2
      //   39: ldc 'errorCode.spdyGoAwayCode == -1'
      //   41: invokespecial <init> : (Ljava/lang/String;)V
      //   44: aload_2
      //   45: athrow
      //   46: aload_0
      //   47: getfield sink : Lokio/BufferedSink;
      //   50: ldc -2147287033
      //   52: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   57: pop
      //   58: aload_0
      //   59: getfield sink : Lokio/BufferedSink;
      //   62: bipush #8
      //   64: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   69: pop
      //   70: aload_0
      //   71: getfield sink : Lokio/BufferedSink;
      //   74: iload_1
      //   75: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   80: pop
      //   81: aload_0
      //   82: getfield sink : Lokio/BufferedSink;
      //   85: aload_2
      //   86: getfield spdyGoAwayCode : I
      //   89: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   94: pop
      //   95: aload_0
      //   96: getfield sink : Lokio/BufferedSink;
      //   99: invokeinterface flush : ()V
      //   104: aload_0
      //   105: monitorexit
      //   106: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	46	21	finally
      //   46	104	21	finally
    }
    
    public void headers(int param1Int, List<Header> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifeq -> 26
      //   9: new java/io/IOException
      //   12: astore_2
      //   13: aload_2
      //   14: ldc 'closed'
      //   16: invokespecial <init> : (Ljava/lang/String;)V
      //   19: aload_2
      //   20: athrow
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: athrow
      //   26: aload_0
      //   27: aload_2
      //   28: invokespecial writeNameValueBlockToBuffer : (Ljava/util/List;)V
      //   31: aload_0
      //   32: getfield headerBlockBuffer : Lokio/Buffer;
      //   35: invokevirtual size : ()J
      //   38: ldc2_w 4
      //   41: ladd
      //   42: l2i
      //   43: istore_3
      //   44: aload_0
      //   45: getfield sink : Lokio/BufferedSink;
      //   48: ldc -2147287032
      //   50: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   55: pop
      //   56: aload_0
      //   57: getfield sink : Lokio/BufferedSink;
      //   60: ldc 16777215
      //   62: iload_3
      //   63: iand
      //   64: iconst_0
      //   65: ior
      //   66: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   71: pop
      //   72: aload_0
      //   73: getfield sink : Lokio/BufferedSink;
      //   76: ldc 2147483647
      //   78: iload_1
      //   79: iand
      //   80: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   85: pop
      //   86: aload_0
      //   87: getfield sink : Lokio/BufferedSink;
      //   90: aload_0
      //   91: getfield headerBlockBuffer : Lokio/Buffer;
      //   94: invokeinterface writeAll : (Lokio/Source;)J
      //   99: pop2
      //   100: aload_0
      //   101: monitorexit
      //   102: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	100	21	finally
    }
    
    public int maxDataLength() {
      return 16383;
    }
    
    public void ping(boolean param1Boolean, int param1Int1, int param1Int2) throws IOException {
      // Byte code:
      //   0: iconst_1
      //   1: istore #4
      //   3: aload_0
      //   4: monitorenter
      //   5: aload_0
      //   6: getfield closed : Z
      //   9: ifeq -> 34
      //   12: new java/io/IOException
      //   15: astore #5
      //   17: aload #5
      //   19: ldc 'closed'
      //   21: invokespecial <init> : (Ljava/lang/String;)V
      //   24: aload #5
      //   26: athrow
      //   27: astore #5
      //   29: aload_0
      //   30: monitorexit
      //   31: aload #5
      //   33: athrow
      //   34: aload_0
      //   35: getfield client : Z
      //   38: istore #6
      //   40: iload_2
      //   41: iconst_1
      //   42: iand
      //   43: iconst_1
      //   44: if_icmpne -> 82
      //   47: iconst_1
      //   48: istore #7
      //   50: iload #6
      //   52: iload #7
      //   54: if_icmpeq -> 88
      //   57: iload #4
      //   59: istore #7
      //   61: iload_1
      //   62: iload #7
      //   64: if_icmpeq -> 94
      //   67: new java/lang/IllegalArgumentException
      //   70: astore #5
      //   72: aload #5
      //   74: ldc 'payload != reply'
      //   76: invokespecial <init> : (Ljava/lang/String;)V
      //   79: aload #5
      //   81: athrow
      //   82: iconst_0
      //   83: istore #7
      //   85: goto -> 50
      //   88: iconst_0
      //   89: istore #7
      //   91: goto -> 61
      //   94: aload_0
      //   95: getfield sink : Lokio/BufferedSink;
      //   98: ldc -2147287034
      //   100: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   105: pop
      //   106: aload_0
      //   107: getfield sink : Lokio/BufferedSink;
      //   110: iconst_4
      //   111: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   116: pop
      //   117: aload_0
      //   118: getfield sink : Lokio/BufferedSink;
      //   121: iload_2
      //   122: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   127: pop
      //   128: aload_0
      //   129: getfield sink : Lokio/BufferedSink;
      //   132: invokeinterface flush : ()V
      //   137: aload_0
      //   138: monitorexit
      //   139: return
      // Exception table:
      //   from	to	target	type
      //   5	27	27	finally
      //   34	40	27	finally
      //   67	82	27	finally
      //   94	137	27	finally
    }
    
    public void pushPromise(int param1Int1, int param1Int2, List<Header> param1List) throws IOException {}
    
    public void rstStream(int param1Int, ErrorCode param1ErrorCode) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifeq -> 26
      //   9: new java/io/IOException
      //   12: astore_2
      //   13: aload_2
      //   14: ldc 'closed'
      //   16: invokespecial <init> : (Ljava/lang/String;)V
      //   19: aload_2
      //   20: athrow
      //   21: astore_2
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_2
      //   25: athrow
      //   26: aload_2
      //   27: getfield spdyRstCode : I
      //   30: iconst_m1
      //   31: if_icmpne -> 44
      //   34: new java/lang/IllegalArgumentException
      //   37: astore_2
      //   38: aload_2
      //   39: invokespecial <init> : ()V
      //   42: aload_2
      //   43: athrow
      //   44: aload_0
      //   45: getfield sink : Lokio/BufferedSink;
      //   48: ldc -2147287037
      //   50: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   55: pop
      //   56: aload_0
      //   57: getfield sink : Lokio/BufferedSink;
      //   60: bipush #8
      //   62: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   67: pop
      //   68: aload_0
      //   69: getfield sink : Lokio/BufferedSink;
      //   72: ldc 2147483647
      //   74: iload_1
      //   75: iand
      //   76: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   81: pop
      //   82: aload_0
      //   83: getfield sink : Lokio/BufferedSink;
      //   86: aload_2
      //   87: getfield spdyRstCode : I
      //   90: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   95: pop
      //   96: aload_0
      //   97: getfield sink : Lokio/BufferedSink;
      //   100: invokeinterface flush : ()V
      //   105: aload_0
      //   106: monitorexit
      //   107: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	44	21	finally
      //   44	105	21	finally
    }
    
    void sendDataFrame(int param1Int1, int param1Int2, Buffer param1Buffer, int param1Int3) throws IOException {
      if (this.closed)
        throw new IOException("closed"); 
      if (param1Int3 > 16777215L)
        throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + param1Int3); 
      this.sink.writeInt(Integer.MAX_VALUE & param1Int1);
      this.sink.writeInt((param1Int2 & 0xFF) << 24 | 0xFFFFFF & param1Int3);
      if (param1Int3 > 0)
        this.sink.write(param1Buffer, param1Int3); 
    }
    
    public void settings(Settings param1Settings) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifeq -> 26
      //   9: new java/io/IOException
      //   12: astore_1
      //   13: aload_1
      //   14: ldc 'closed'
      //   16: invokespecial <init> : (Ljava/lang/String;)V
      //   19: aload_1
      //   20: athrow
      //   21: astore_1
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_1
      //   25: athrow
      //   26: aload_1
      //   27: invokevirtual size : ()I
      //   30: istore_2
      //   31: aload_0
      //   32: getfield sink : Lokio/BufferedSink;
      //   35: ldc -2147287036
      //   37: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   42: pop
      //   43: aload_0
      //   44: getfield sink : Lokio/BufferedSink;
      //   47: iload_2
      //   48: bipush #8
      //   50: imul
      //   51: iconst_4
      //   52: iadd
      //   53: ldc 16777215
      //   55: iand
      //   56: iconst_0
      //   57: ior
      //   58: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   63: pop
      //   64: aload_0
      //   65: getfield sink : Lokio/BufferedSink;
      //   68: iload_2
      //   69: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   74: pop
      //   75: iconst_0
      //   76: istore_2
      //   77: iload_2
      //   78: bipush #10
      //   80: if_icmpgt -> 144
      //   83: aload_1
      //   84: iload_2
      //   85: invokevirtual isSet : (I)Z
      //   88: ifne -> 97
      //   91: iinc #2, 1
      //   94: goto -> 77
      //   97: aload_1
      //   98: iload_2
      //   99: invokevirtual flags : (I)I
      //   102: istore_3
      //   103: aload_0
      //   104: getfield sink : Lokio/BufferedSink;
      //   107: iload_3
      //   108: sipush #255
      //   111: iand
      //   112: bipush #24
      //   114: ishl
      //   115: iload_2
      //   116: ldc 16777215
      //   118: iand
      //   119: ior
      //   120: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   125: pop
      //   126: aload_0
      //   127: getfield sink : Lokio/BufferedSink;
      //   130: aload_1
      //   131: iload_2
      //   132: invokevirtual get : (I)I
      //   135: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   140: pop
      //   141: goto -> 91
      //   144: aload_0
      //   145: getfield sink : Lokio/BufferedSink;
      //   148: invokeinterface flush : ()V
      //   153: aload_0
      //   154: monitorexit
      //   155: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	75	21	finally
      //   83	91	21	finally
      //   97	141	21	finally
      //   144	153	21	finally
    }
    
    public void synReply(boolean param1Boolean, int param1Int, List<Header> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifeq -> 26
      //   9: new java/io/IOException
      //   12: astore_3
      //   13: aload_3
      //   14: ldc 'closed'
      //   16: invokespecial <init> : (Ljava/lang/String;)V
      //   19: aload_3
      //   20: athrow
      //   21: astore_3
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_3
      //   25: athrow
      //   26: aload_0
      //   27: aload_3
      //   28: invokespecial writeNameValueBlockToBuffer : (Ljava/util/List;)V
      //   31: iload_1
      //   32: ifeq -> 129
      //   35: iconst_1
      //   36: istore #4
      //   38: aload_0
      //   39: getfield headerBlockBuffer : Lokio/Buffer;
      //   42: invokevirtual size : ()J
      //   45: ldc2_w 4
      //   48: ladd
      //   49: l2i
      //   50: istore #5
      //   52: aload_0
      //   53: getfield sink : Lokio/BufferedSink;
      //   56: ldc -2147287038
      //   58: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   63: pop
      //   64: aload_0
      //   65: getfield sink : Lokio/BufferedSink;
      //   68: iload #4
      //   70: sipush #255
      //   73: iand
      //   74: bipush #24
      //   76: ishl
      //   77: ldc 16777215
      //   79: iload #5
      //   81: iand
      //   82: ior
      //   83: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   88: pop
      //   89: aload_0
      //   90: getfield sink : Lokio/BufferedSink;
      //   93: ldc 2147483647
      //   95: iload_2
      //   96: iand
      //   97: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   102: pop
      //   103: aload_0
      //   104: getfield sink : Lokio/BufferedSink;
      //   107: aload_0
      //   108: getfield headerBlockBuffer : Lokio/Buffer;
      //   111: invokeinterface writeAll : (Lokio/Source;)J
      //   116: pop2
      //   117: aload_0
      //   118: getfield sink : Lokio/BufferedSink;
      //   121: invokeinterface flush : ()V
      //   126: aload_0
      //   127: monitorexit
      //   128: return
      //   129: iconst_0
      //   130: istore #4
      //   132: goto -> 38
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	31	21	finally
      //   38	126	21	finally
    }
    
    public void synStream(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, List<Header> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifeq -> 31
      //   9: new java/io/IOException
      //   12: astore #5
      //   14: aload #5
      //   16: ldc 'closed'
      //   18: invokespecial <init> : (Ljava/lang/String;)V
      //   21: aload #5
      //   23: athrow
      //   24: astore #5
      //   26: aload_0
      //   27: monitorexit
      //   28: aload #5
      //   30: athrow
      //   31: aload_0
      //   32: aload #5
      //   34: invokespecial writeNameValueBlockToBuffer : (Ljava/util/List;)V
      //   37: ldc2_w 10
      //   40: aload_0
      //   41: getfield headerBlockBuffer : Lokio/Buffer;
      //   44: invokevirtual size : ()J
      //   47: ladd
      //   48: l2i
      //   49: istore #6
      //   51: iload_1
      //   52: ifeq -> 171
      //   55: iconst_1
      //   56: istore #7
      //   58: iload_2
      //   59: ifeq -> 177
      //   62: iconst_2
      //   63: istore #8
      //   65: aload_0
      //   66: getfield sink : Lokio/BufferedSink;
      //   69: ldc -2147287039
      //   71: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   76: pop
      //   77: aload_0
      //   78: getfield sink : Lokio/BufferedSink;
      //   81: iload #7
      //   83: iload #8
      //   85: ior
      //   86: sipush #255
      //   89: iand
      //   90: bipush #24
      //   92: ishl
      //   93: ldc 16777215
      //   95: iload #6
      //   97: iand
      //   98: ior
      //   99: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   104: pop
      //   105: aload_0
      //   106: getfield sink : Lokio/BufferedSink;
      //   109: ldc 2147483647
      //   111: iload_3
      //   112: iand
      //   113: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   118: pop
      //   119: aload_0
      //   120: getfield sink : Lokio/BufferedSink;
      //   123: ldc 2147483647
      //   125: iload #4
      //   127: iand
      //   128: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   133: pop
      //   134: aload_0
      //   135: getfield sink : Lokio/BufferedSink;
      //   138: iconst_0
      //   139: invokeinterface writeShort : (I)Lokio/BufferedSink;
      //   144: pop
      //   145: aload_0
      //   146: getfield sink : Lokio/BufferedSink;
      //   149: aload_0
      //   150: getfield headerBlockBuffer : Lokio/Buffer;
      //   153: invokeinterface writeAll : (Lokio/Source;)J
      //   158: pop2
      //   159: aload_0
      //   160: getfield sink : Lokio/BufferedSink;
      //   163: invokeinterface flush : ()V
      //   168: aload_0
      //   169: monitorexit
      //   170: return
      //   171: iconst_0
      //   172: istore #7
      //   174: goto -> 58
      //   177: iconst_0
      //   178: istore #8
      //   180: goto -> 65
      // Exception table:
      //   from	to	target	type
      //   2	24	24	finally
      //   31	51	24	finally
      //   65	168	24	finally
    }
    
    public void windowUpdate(int param1Int, long param1Long) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield closed : Z
      //   6: ifeq -> 31
      //   9: new java/io/IOException
      //   12: astore #4
      //   14: aload #4
      //   16: ldc 'closed'
      //   18: invokespecial <init> : (Ljava/lang/String;)V
      //   21: aload #4
      //   23: athrow
      //   24: astore #4
      //   26: aload_0
      //   27: monitorexit
      //   28: aload #4
      //   30: athrow
      //   31: lload_2
      //   32: lconst_0
      //   33: lcmp
      //   34: ifeq -> 45
      //   37: lload_2
      //   38: ldc2_w 2147483647
      //   41: lcmp
      //   42: ifle -> 82
      //   45: new java/lang/IllegalArgumentException
      //   48: astore #4
      //   50: new java/lang/StringBuilder
      //   53: astore #5
      //   55: aload #5
      //   57: invokespecial <init> : ()V
      //   60: aload #4
      //   62: aload #5
      //   64: ldc 'windowSizeIncrement must be between 1 and 0x7fffffff: '
      //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   69: lload_2
      //   70: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   73: invokevirtual toString : ()Ljava/lang/String;
      //   76: invokespecial <init> : (Ljava/lang/String;)V
      //   79: aload #4
      //   81: athrow
      //   82: aload_0
      //   83: getfield sink : Lokio/BufferedSink;
      //   86: ldc -2147287031
      //   88: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   93: pop
      //   94: aload_0
      //   95: getfield sink : Lokio/BufferedSink;
      //   98: bipush #8
      //   100: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   105: pop
      //   106: aload_0
      //   107: getfield sink : Lokio/BufferedSink;
      //   110: iload_1
      //   111: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   116: pop
      //   117: aload_0
      //   118: getfield sink : Lokio/BufferedSink;
      //   121: lload_2
      //   122: l2i
      //   123: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   128: pop
      //   129: aload_0
      //   130: getfield sink : Lokio/BufferedSink;
      //   133: invokeinterface flush : ()V
      //   138: aload_0
      //   139: monitorexit
      //   140: return
      // Exception table:
      //   from	to	target	type
      //   2	24	24	finally
      //   45	82	24	finally
      //   82	138	24	finally
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\Spdy3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */