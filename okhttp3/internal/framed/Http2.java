package okhttp3.internal.framed;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

public final class Http2 implements Variant {
  private static final ByteString CONNECTION_PREFACE;
  
  static final byte FLAG_ACK = 1;
  
  static final byte FLAG_COMPRESSED = 32;
  
  static final byte FLAG_END_HEADERS = 4;
  
  static final byte FLAG_END_PUSH_PROMISE = 4;
  
  static final byte FLAG_END_STREAM = 1;
  
  static final byte FLAG_NONE = 0;
  
  static final byte FLAG_PADDED = 8;
  
  static final byte FLAG_PRIORITY = 32;
  
  static final int INITIAL_MAX_FRAME_SIZE = 16384;
  
  static final byte TYPE_CONTINUATION = 9;
  
  static final byte TYPE_DATA = 0;
  
  static final byte TYPE_GOAWAY = 7;
  
  static final byte TYPE_HEADERS = 1;
  
  static final byte TYPE_PING = 6;
  
  static final byte TYPE_PRIORITY = 2;
  
  static final byte TYPE_PUSH_PROMISE = 5;
  
  static final byte TYPE_RST_STREAM = 3;
  
  static final byte TYPE_SETTINGS = 4;
  
  static final byte TYPE_WINDOW_UPDATE = 8;
  
  private static final Logger logger = Logger.getLogger(FrameLogger.class.getName());
  
  static {
    CONNECTION_PREFACE = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  }
  
  private static IllegalArgumentException illegalArgument(String paramString, Object... paramVarArgs) {
    throw new IllegalArgumentException(Util.format(paramString, paramVarArgs));
  }
  
  private static IOException ioException(String paramString, Object... paramVarArgs) throws IOException {
    throw new IOException(Util.format(paramString, paramVarArgs));
  }
  
  private static int lengthWithoutPadding(int paramInt, byte paramByte, short paramShort) throws IOException {
    int i = paramInt;
    if ((paramByte & 0x8) != 0)
      i = paramInt - 1; 
    if (paramShort > i)
      throw ioException("PROTOCOL_ERROR padding %s > remaining length %s", new Object[] { Short.valueOf(paramShort), Integer.valueOf(i) }); 
    return (short)(i - paramShort);
  }
  
  private static int readMedium(BufferedSource paramBufferedSource) throws IOException {
    return (paramBufferedSource.readByte() & 0xFF) << 16 | (paramBufferedSource.readByte() & 0xFF) << 8 | paramBufferedSource.readByte() & 0xFF;
  }
  
  private static void writeMedium(BufferedSink paramBufferedSink, int paramInt) throws IOException {
    paramBufferedSink.writeByte(paramInt >>> 16 & 0xFF);
    paramBufferedSink.writeByte(paramInt >>> 8 & 0xFF);
    paramBufferedSink.writeByte(paramInt & 0xFF);
  }
  
  public Protocol getProtocol() {
    return Protocol.HTTP_2;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean) {
    return new Reader(paramBufferedSource, 4096, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean) {
    return new Writer(paramBufferedSink, paramBoolean);
  }
  
  static final class ContinuationSource implements Source {
    byte flags;
    
    int left;
    
    int length;
    
    short padding;
    
    private final BufferedSource source;
    
    int streamId;
    
    public ContinuationSource(BufferedSource param1BufferedSource) {
      this.source = param1BufferedSource;
    }
    
    private void readContinuationHeader() throws IOException {
      int i = this.streamId;
      int j = Http2.readMedium(this.source);
      this.left = j;
      this.length = j;
      byte b = (byte)(this.source.readByte() & 0xFF);
      this.flags = (byte)(byte)(this.source.readByte() & 0xFF);
      if (Http2.logger.isLoggable(Level.FINE))
        Http2.logger.fine(Http2.FrameLogger.formatHeader(true, this.streamId, this.length, b, this.flags)); 
      this.streamId = this.source.readInt() & Integer.MAX_VALUE;
      if (b != 9)
        throw Http2.ioException("%s != TYPE_CONTINUATION", new Object[] { Byte.valueOf(b) }); 
      if (this.streamId != i)
        throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]); 
    }
    
    public void close() throws IOException {}
    
    public long read(Buffer param1Buffer, long param1Long) throws IOException {
      while (this.left == 0) {
        this.source.skip(this.padding);
        this.padding = (short)0;
        if ((this.flags & 0x4) != 0)
          return -1L; 
        readContinuationHeader();
      } 
      param1Long = this.source.read(param1Buffer, Math.min(param1Long, this.left));
      if (param1Long == -1L)
        return -1L; 
      this.left = (int)(this.left - param1Long);
      return param1Long;
    }
    
    public Timeout timeout() {
      return this.source.timeout();
    }
  }
  
  static final class FrameLogger {
    private static final String[] BINARY;
    
    private static final String[] FLAGS = new String[64];
    
    private static final String[] TYPES = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
    
    static {
      BINARY = new String[256];
      byte b;
      for (b = 0; b < BINARY.length; b++) {
        BINARY[b] = Util.format("%8s", new Object[] { Integer.toBinaryString(b) }).replace(' ', '0');
      } 
      FLAGS[0] = "";
      FLAGS[1] = "END_STREAM";
      int[] arrayOfInt1 = new int[1];
      arrayOfInt1[0] = 1;
      FLAGS[8] = "PADDED";
      int i = arrayOfInt1.length;
      for (b = 0; b < i; b++) {
        int k = arrayOfInt1[b];
        FLAGS[k | 0x8] = FLAGS[k] + "|PADDED";
      } 
      FLAGS[4] = "END_HEADERS";
      FLAGS[32] = "PRIORITY";
      FLAGS[36] = "END_HEADERS|PRIORITY";
      int[] arrayOfInt2 = new int[3];
      arrayOfInt2[0] = 4;
      arrayOfInt2[1] = 32;
      arrayOfInt2[2] = 36;
      int j = arrayOfInt2.length;
      for (b = 0; b < j; b++) {
        int k = arrayOfInt2[b];
        int m = arrayOfInt1.length;
        for (i = 0; i < m; i++) {
          int n = arrayOfInt1[i];
          FLAGS[n | k] = FLAGS[n] + '|' + FLAGS[k];
          FLAGS[n | k | 0x8] = FLAGS[n] + '|' + FLAGS[k] + "|PADDED";
        } 
      } 
      for (b = 0; b < FLAGS.length; b++) {
        if (FLAGS[b] == null)
          FLAGS[b] = BINARY[b]; 
      } 
    }
    
    static String formatFlags(byte param1Byte1, byte param1Byte2) {
      String str;
      if (param1Byte2 == 0)
        return ""; 
      switch (param1Byte1) {
        default:
          if (param1Byte2 < FLAGS.length) {
            null = FLAGS[param1Byte2];
          } else {
            null = BINARY[param1Byte2];
          } 
          if (param1Byte1 == 5 && (param1Byte2 & 0x4) != 0)
            return null.replace("HEADERS", "PUSH_PROMISE"); 
          break;
        case 4:
        case 6:
          return (param1Byte2 == 1) ? "ACK" : BINARY[param1Byte2];
        case 2:
        case 3:
        case 7:
        case 8:
          return BINARY[param1Byte2];
      } 
      if (param1Byte1 == 0 && (param1Byte2 & 0x20) != 0)
        str = SYNTHETIC_LOCAL_VARIABLE_2.replace("PRIORITY", "COMPRESSED"); 
      return str;
    }
    
    static String formatHeader(boolean param1Boolean, int param1Int1, int param1Int2, byte param1Byte1, byte param1Byte2) {
      String str1;
      if (param1Byte1 < TYPES.length) {
        str1 = TYPES[param1Byte1];
      } else {
        str1 = Util.format("0x%02x", new Object[] { Byte.valueOf(param1Byte1) });
      } 
      String str2 = formatFlags(param1Byte1, param1Byte2);
      if (param1Boolean) {
        String str = "<<";
        return Util.format("%s 0x%08x %5d %-13s %s", new Object[] { str, Integer.valueOf(param1Int1), Integer.valueOf(param1Int2), str1, str2 });
      } 
      String str3 = ">>";
      return Util.format("%s 0x%08x %5d %-13s %s", new Object[] { str3, Integer.valueOf(param1Int1), Integer.valueOf(param1Int2), str1, str2 });
    }
  }
  
  static final class Reader implements FrameReader {
    private final boolean client;
    
    private final Http2.ContinuationSource continuation;
    
    final Hpack.Reader hpackReader;
    
    private final BufferedSource source;
    
    Reader(BufferedSource param1BufferedSource, int param1Int, boolean param1Boolean) {
      this.source = param1BufferedSource;
      this.client = param1Boolean;
      this.continuation = new Http2.ContinuationSource(this.source);
      this.hpackReader = new Hpack.Reader(param1Int, this.continuation);
    }
    
    private void readData(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      boolean bool;
      short s1 = 1;
      short s2 = 0;
      if ((param1Byte & 0x1) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      if ((param1Byte & 0x20) == 0)
        s1 = 0; 
      if (s1)
        throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]); 
      short s3 = s2;
      if ((param1Byte & 0x8) != 0) {
        s1 = (short)(this.source.readByte() & 0xFF);
        s3 = s1;
      } 
      param1Int1 = Http2.lengthWithoutPadding(param1Int1, param1Byte, s3);
      param1Handler.data(bool, param1Int2, this.source, param1Int1);
      this.source.skip(s3);
    }
    
    private void readGoAway(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int1 < 8)
        throw Http2.ioException("TYPE_GOAWAY length < 8: %s", new Object[] { Integer.valueOf(param1Int1) }); 
      if (param1Int2 != 0)
        throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]); 
      param1Int2 = this.source.readInt();
      int i = this.source.readInt();
      param1Int1 -= 8;
      ErrorCode errorCode = ErrorCode.fromHttp2(i);
      if (errorCode == null)
        throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(i) }); 
      ByteString byteString = ByteString.EMPTY;
      if (param1Int1 > 0)
        byteString = this.source.readByteString(param1Int1); 
      param1Handler.goAway(param1Int2, errorCode, byteString);
    }
    
    private List<Header> readHeaderBlock(int param1Int1, short param1Short, byte param1Byte, int param1Int2) throws IOException {
      Http2.ContinuationSource continuationSource = this.continuation;
      this.continuation.left = param1Int1;
      continuationSource.length = param1Int1;
      this.continuation.padding = (short)param1Short;
      this.continuation.flags = (byte)param1Byte;
      this.continuation.streamId = param1Int2;
      this.hpackReader.readHeaders();
      return this.hpackReader.getAndResetHeaderList();
    }
    
    private void readHeaders(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      boolean bool1;
      boolean bool2;
      if (param1Int2 == 0)
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]); 
      if ((param1Byte & 0x1) != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      if ((param1Byte & 0x8) != 0) {
        short s = (short)(this.source.readByte() & 0xFF);
        bool2 = s;
      } else {
        boolean bool = false;
        bool2 = bool;
      } 
      int i = param1Int1;
      if ((param1Byte & 0x20) != 0) {
        readPriority(param1Handler, param1Int2);
        i = param1Int1 - 5;
      } 
      param1Handler.headers(false, bool1, param1Int2, -1, readHeaderBlock(Http2.lengthWithoutPadding(i, param1Byte, bool2), bool2, param1Byte, param1Int2), HeadersMode.HTTP_20_HEADERS);
    }
    
    private void readPing(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      boolean bool = true;
      if (param1Int1 != 8)
        throw Http2.ioException("TYPE_PING length != 8: %s", new Object[] { Integer.valueOf(param1Int1) }); 
      if (param1Int2 != 0)
        throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]); 
      param1Int1 = this.source.readInt();
      param1Int2 = this.source.readInt();
      if ((param1Byte & 0x1) == 0)
        bool = false; 
      param1Handler.ping(bool, param1Int1, param1Int2);
    }
    
    private void readPriority(FrameReader.Handler param1Handler, int param1Int) throws IOException {
      boolean bool;
      int i = this.source.readInt();
      if ((Integer.MIN_VALUE & i) != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      param1Handler.priority(param1Int, i & Integer.MAX_VALUE, (this.source.readByte() & 0xFF) + 1, bool);
    }
    
    private void readPriority(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int1 != 5)
        throw Http2.ioException("TYPE_PRIORITY length: %d != 5", new Object[] { Integer.valueOf(param1Int1) }); 
      if (param1Int2 == 0)
        throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]); 
      readPriority(param1Handler, param1Int2);
    }
    
    private void readPushPromise(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      short s1 = 0;
      if (param1Int2 == 0)
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]); 
      short s2 = s1;
      if ((param1Byte & 0x8) != 0) {
        s1 = (short)(this.source.readByte() & 0xFF);
        s2 = s1;
      } 
      param1Handler.pushPromise(param1Int2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Http2.lengthWithoutPadding(param1Int1 - 4, param1Byte, s2), s2, param1Byte, param1Int2));
    }
    
    private void readRstStream(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int1 != 4)
        throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", new Object[] { Integer.valueOf(param1Int1) }); 
      if (param1Int2 == 0)
        throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]); 
      param1Int1 = this.source.readInt();
      ErrorCode errorCode = ErrorCode.fromHttp2(param1Int1);
      if (errorCode == null)
        throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(param1Int1) }); 
      param1Handler.rstStream(param1Int2, errorCode);
    }
    
    private void readSettings(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int2 != 0)
        throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]); 
      if ((param1Byte & 0x1) != 0) {
        if (param1Int1 != 0)
          throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]); 
        param1Handler.ackSettings();
        return;
      } 
      if (param1Int1 % 6 != 0)
        throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", new Object[] { Integer.valueOf(param1Int1) }); 
      Settings settings = new Settings();
      param1Int2 = 0;
      while (param1Int2 < param1Int1) {
        short s1 = this.source.readShort();
        int i = this.source.readInt();
        short s = s1;
        switch (s1) {
          default:
            s = s1;
          case 1:
          case 6:
            settings.set(s, 0, i);
            param1Int2 += 6;
            continue;
          case 2:
            s = s1;
            if (i != 0) {
              s = s1;
              if (i != 1)
                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]); 
            } 
          case 3:
            s = 4;
          case 4:
            s = 7;
            if (i < 0)
              throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]); 
          case 5:
            break;
        } 
        if (i >= 16384) {
          s = s1;
          if (i > 16777215)
            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) }); 
        } 
        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", new Object[] { Integer.valueOf(i) });
      } 
      param1Handler.settings(false, settings);
      if (settings.getHeaderTableSize() >= 0)
        this.hpackReader.headerTableSizeSetting(settings.getHeaderTableSize()); 
    }
    
    private void readWindowUpdate(FrameReader.Handler param1Handler, int param1Int1, byte param1Byte, int param1Int2) throws IOException {
      if (param1Int1 != 4)
        throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", new Object[] { Integer.valueOf(param1Int1) }); 
      long l = this.source.readInt() & 0x7FFFFFFFL;
      if (l == 0L)
        throw Http2.ioException("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) }); 
      param1Handler.windowUpdate(param1Int2, l);
    }
    
    public void close() throws IOException {
      this.source.close();
    }
    
    public boolean nextFrame(FrameReader.Handler param1Handler) throws IOException {
      int i;
      boolean bool = true;
      try {
        this.source.require(9L);
        i = Http2.readMedium(this.source);
        if (i < 0 || i > 16384)
          throw Http2.ioException("FRAME_SIZE_ERROR: %s", new Object[] { Integer.valueOf(i) }); 
      } catch (IOException iOException) {
        return false;
      } 
      byte b1 = (byte)(this.source.readByte() & 0xFF);
      byte b2 = (byte)(this.source.readByte() & 0xFF);
      int j = this.source.readInt() & Integer.MAX_VALUE;
      if (Http2.logger.isLoggable(Level.FINE))
        Http2.logger.fine(Http2.FrameLogger.formatHeader(true, j, i, b1, b2)); 
      switch (b1) {
        default:
          this.source.skip(i);
          return bool;
        case 0:
          readData((FrameReader.Handler)iOException, i, b2, j);
          return bool;
        case 1:
          readHeaders((FrameReader.Handler)iOException, i, b2, j);
          return bool;
        case 2:
          readPriority((FrameReader.Handler)iOException, i, b2, j);
          return bool;
        case 3:
          readRstStream((FrameReader.Handler)iOException, i, b2, j);
          return bool;
        case 4:
          readSettings((FrameReader.Handler)iOException, i, b2, j);
          return bool;
        case 5:
          readPushPromise((FrameReader.Handler)iOException, i, b2, j);
          return bool;
        case 6:
          readPing((FrameReader.Handler)iOException, i, b2, j);
          return bool;
        case 7:
          readGoAway((FrameReader.Handler)iOException, i, b2, j);
          return bool;
        case 8:
          break;
      } 
      readWindowUpdate((FrameReader.Handler)iOException, i, b2, j);
      return bool;
    }
    
    public void readConnectionPreface() throws IOException {
      if (!this.client) {
        ByteString byteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
        if (Http2.logger.isLoggable(Level.FINE))
          Http2.logger.fine(Util.format("<< CONNECTION %s", new Object[] { byteString.hex() })); 
        if (!Http2.CONNECTION_PREFACE.equals(byteString))
          throw Http2.ioException("Expected a connection header but was %s", new Object[] { byteString.utf8() }); 
      } 
    }
  }
  
  static final class Writer implements FrameWriter {
    private final boolean client;
    
    private boolean closed;
    
    private final Buffer hpackBuffer;
    
    private final Hpack.Writer hpackWriter;
    
    private int maxFrameSize;
    
    private final BufferedSink sink;
    
    Writer(BufferedSink param1BufferedSink, boolean param1Boolean) {
      this.sink = param1BufferedSink;
      this.client = param1Boolean;
      this.hpackBuffer = new Buffer();
      this.hpackWriter = new Hpack.Writer(this.hpackBuffer);
      this.maxFrameSize = 16384;
    }
    
    private void writeContinuationFrames(int param1Int, long param1Long) throws IOException {
      while (param1Long > 0L) {
        boolean bool;
        int i = (int)Math.min(this.maxFrameSize, param1Long);
        param1Long -= i;
        if (param1Long == 0L) {
          byte b = 4;
          bool = b;
        } else {
          boolean bool1 = false;
          bool = bool1;
        } 
        frameHeader(param1Int, i, (byte)9, bool);
        this.sink.write(this.hpackBuffer, i);
      } 
    }
    
    public void ackSettings(Settings param1Settings) throws IOException {
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
      //   27: aload_1
      //   28: aload_0
      //   29: getfield maxFrameSize : I
      //   32: invokevirtual getMaxFrameSize : (I)I
      //   35: putfield maxFrameSize : I
      //   38: aload_0
      //   39: iconst_0
      //   40: iconst_0
      //   41: iconst_4
      //   42: iconst_1
      //   43: invokevirtual frameHeader : (IIBB)V
      //   46: aload_0
      //   47: getfield sink : Lokio/BufferedSink;
      //   50: invokeinterface flush : ()V
      //   55: aload_0
      //   56: monitorexit
      //   57: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	55	21	finally
    }
    
    public void close() throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iconst_1
      //   4: putfield closed : Z
      //   7: aload_0
      //   8: getfield sink : Lokio/BufferedSink;
      //   11: invokeinterface close : ()V
      //   16: aload_0
      //   17: monitorexit
      //   18: return
      //   19: astore_1
      //   20: aload_0
      //   21: monitorexit
      //   22: aload_1
      //   23: athrow
      // Exception table:
      //   from	to	target	type
      //   2	16	19	finally
    }
    
    public void connectionPreface() throws IOException {
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
      //   27: getfield client : Z
      //   30: istore_2
      //   31: iload_2
      //   32: ifne -> 38
      //   35: aload_0
      //   36: monitorexit
      //   37: return
      //   38: invokestatic access$100 : ()Ljava/util/logging/Logger;
      //   41: getstatic java/util/logging/Level.FINE : Ljava/util/logging/Level;
      //   44: invokevirtual isLoggable : (Ljava/util/logging/Level;)Z
      //   47: ifeq -> 74
      //   50: invokestatic access$100 : ()Ljava/util/logging/Logger;
      //   53: ldc '>> CONNECTION %s'
      //   55: iconst_1
      //   56: anewarray java/lang/Object
      //   59: dup
      //   60: iconst_0
      //   61: invokestatic access$000 : ()Lokio/ByteString;
      //   64: invokevirtual hex : ()Ljava/lang/String;
      //   67: aastore
      //   68: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   71: invokevirtual fine : (Ljava/lang/String;)V
      //   74: aload_0
      //   75: getfield sink : Lokio/BufferedSink;
      //   78: invokestatic access$000 : ()Lokio/ByteString;
      //   81: invokevirtual toByteArray : ()[B
      //   84: invokeinterface write : ([B)Lokio/BufferedSink;
      //   89: pop
      //   90: aload_0
      //   91: getfield sink : Lokio/BufferedSink;
      //   94: invokeinterface flush : ()V
      //   99: goto -> 35
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	31	21	finally
      //   38	74	21	finally
      //   74	99	21	finally
    }
    
    public void data(boolean param1Boolean, int param1Int1, Buffer param1Buffer, int param1Int2) throws IOException {
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
      //   26: iconst_0
      //   27: istore #5
      //   29: iload #5
      //   31: istore #6
      //   33: iload_1
      //   34: ifeq -> 45
      //   37: iconst_1
      //   38: i2b
      //   39: istore #5
      //   41: iload #5
      //   43: istore #6
      //   45: aload_0
      //   46: iload_2
      //   47: iload #6
      //   49: aload_3
      //   50: iload #4
      //   52: invokevirtual dataFrame : (IBLokio/Buffer;I)V
      //   55: aload_0
      //   56: monitorexit
      //   57: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   45	55	21	finally
    }
    
    void dataFrame(int param1Int1, byte param1Byte, Buffer param1Buffer, int param1Int2) throws IOException {
      frameHeader(param1Int1, param1Int2, (byte)0, param1Byte);
      if (param1Int2 > 0)
        this.sink.write(param1Buffer, param1Int2); 
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
    
    void frameHeader(int param1Int1, int param1Int2, byte param1Byte1, byte param1Byte2) throws IOException {
      if (Http2.logger.isLoggable(Level.FINE))
        Http2.logger.fine(Http2.FrameLogger.formatHeader(false, param1Int1, param1Int2, param1Byte1, param1Byte2)); 
      if (param1Int2 > this.maxFrameSize)
        throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", new Object[] { Integer.valueOf(this.maxFrameSize), Integer.valueOf(param1Int2) }); 
      if ((Integer.MIN_VALUE & param1Int1) != 0)
        throw Http2.illegalArgument("reserved bit set: %s", new Object[] { Integer.valueOf(param1Int1) }); 
      Http2.writeMedium(this.sink, param1Int2);
      this.sink.writeByte(param1Byte1 & 0xFF);
      this.sink.writeByte(param1Byte2 & 0xFF);
      this.sink.writeInt(Integer.MAX_VALUE & param1Int1);
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
      //   27: getfield httpCode : I
      //   30: iconst_m1
      //   31: if_icmpne -> 44
      //   34: ldc 'errorCode.httpCode == -1'
      //   36: iconst_0
      //   37: anewarray java/lang/Object
      //   40: invokestatic access$500 : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
      //   43: athrow
      //   44: aload_0
      //   45: iconst_0
      //   46: aload_3
      //   47: arraylength
      //   48: bipush #8
      //   50: iadd
      //   51: bipush #7
      //   53: iconst_0
      //   54: invokevirtual frameHeader : (IIBB)V
      //   57: aload_0
      //   58: getfield sink : Lokio/BufferedSink;
      //   61: iload_1
      //   62: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   67: pop
      //   68: aload_0
      //   69: getfield sink : Lokio/BufferedSink;
      //   72: aload_2
      //   73: getfield httpCode : I
      //   76: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   81: pop
      //   82: aload_3
      //   83: arraylength
      //   84: ifle -> 98
      //   87: aload_0
      //   88: getfield sink : Lokio/BufferedSink;
      //   91: aload_3
      //   92: invokeinterface write : ([B)Lokio/BufferedSink;
      //   97: pop
      //   98: aload_0
      //   99: getfield sink : Lokio/BufferedSink;
      //   102: invokeinterface flush : ()V
      //   107: aload_0
      //   108: monitorexit
      //   109: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	44	21	finally
      //   44	98	21	finally
      //   98	107	21	finally
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
      //   27: iconst_0
      //   28: iload_1
      //   29: aload_2
      //   30: invokevirtual headers : (ZILjava/util/List;)V
      //   33: aload_0
      //   34: monitorexit
      //   35: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	33	21	finally
    }
    
    void headers(boolean param1Boolean, int param1Int, List<Header> param1List) throws IOException {
      byte b1;
      if (this.closed)
        throw new IOException("closed"); 
      this.hpackWriter.writeHeaders(param1List);
      long l = this.hpackBuffer.size();
      int i = (int)Math.min(this.maxFrameSize, l);
      if (l == i) {
        b1 = 4;
      } else {
        b1 = 0;
      } 
      byte b2 = b1;
      if (param1Boolean) {
        b1 = (byte)(b1 | 0x1);
        b2 = b1;
      } 
      frameHeader(param1Int, i, (byte)1, b2);
      this.sink.write(this.hpackBuffer, i);
      if (l > i)
        writeContinuationFrames(param1Int, l - i); 
    }
    
    public int maxDataLength() {
      return this.maxFrameSize;
    }
    
    public void ping(boolean param1Boolean, int param1Int1, int param1Int2) throws IOException {
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
      //   31: iload_1
      //   32: ifeq -> 87
      //   35: iconst_1
      //   36: istore #5
      //   38: iload #5
      //   40: istore #6
      //   42: aload_0
      //   43: iconst_0
      //   44: bipush #8
      //   46: bipush #6
      //   48: iload #6
      //   50: invokevirtual frameHeader : (IIBB)V
      //   53: aload_0
      //   54: getfield sink : Lokio/BufferedSink;
      //   57: iload_2
      //   58: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   63: pop
      //   64: aload_0
      //   65: getfield sink : Lokio/BufferedSink;
      //   68: iload_3
      //   69: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   74: pop
      //   75: aload_0
      //   76: getfield sink : Lokio/BufferedSink;
      //   79: invokeinterface flush : ()V
      //   84: aload_0
      //   85: monitorexit
      //   86: return
      //   87: iconst_0
      //   88: istore #5
      //   90: iload #5
      //   92: istore #6
      //   94: goto -> 42
      // Exception table:
      //   from	to	target	type
      //   2	24	24	finally
      //   42	84	24	finally
    }
    
    public void pushPromise(int param1Int1, int param1Int2, List<Header> param1List) throws IOException {
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
      //   27: getfield hpackWriter : Lokhttp3/internal/framed/Hpack$Writer;
      //   30: aload_3
      //   31: invokevirtual writeHeaders : (Ljava/util/List;)V
      //   34: aload_0
      //   35: getfield hpackBuffer : Lokio/Buffer;
      //   38: invokevirtual size : ()J
      //   41: lstore #4
      //   43: aload_0
      //   44: getfield maxFrameSize : I
      //   47: iconst_4
      //   48: isub
      //   49: i2l
      //   50: lload #4
      //   52: invokestatic min : (JJ)J
      //   55: l2i
      //   56: istore #6
      //   58: lload #4
      //   60: iload #6
      //   62: i2l
      //   63: lcmp
      //   64: ifne -> 139
      //   67: iconst_4
      //   68: istore #7
      //   70: iload #7
      //   72: istore #8
      //   74: aload_0
      //   75: iload_1
      //   76: iload #6
      //   78: iconst_4
      //   79: iadd
      //   80: iconst_5
      //   81: iload #8
      //   83: invokevirtual frameHeader : (IIBB)V
      //   86: aload_0
      //   87: getfield sink : Lokio/BufferedSink;
      //   90: ldc 2147483647
      //   92: iload_2
      //   93: iand
      //   94: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   99: pop
      //   100: aload_0
      //   101: getfield sink : Lokio/BufferedSink;
      //   104: aload_0
      //   105: getfield hpackBuffer : Lokio/Buffer;
      //   108: iload #6
      //   110: i2l
      //   111: invokeinterface write : (Lokio/Buffer;J)V
      //   116: lload #4
      //   118: iload #6
      //   120: i2l
      //   121: lcmp
      //   122: ifle -> 136
      //   125: aload_0
      //   126: iload_1
      //   127: lload #4
      //   129: iload #6
      //   131: i2l
      //   132: lsub
      //   133: invokespecial writeContinuationFrames : (IJ)V
      //   136: aload_0
      //   137: monitorexit
      //   138: return
      //   139: iconst_0
      //   140: istore #7
      //   142: iload #7
      //   144: istore #8
      //   146: goto -> 74
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	58	21	finally
      //   74	116	21	finally
      //   125	136	21	finally
    }
    
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
      //   27: getfield httpCode : I
      //   30: iconst_m1
      //   31: if_icmpne -> 44
      //   34: new java/lang/IllegalArgumentException
      //   37: astore_2
      //   38: aload_2
      //   39: invokespecial <init> : ()V
      //   42: aload_2
      //   43: athrow
      //   44: aload_0
      //   45: iload_1
      //   46: iconst_4
      //   47: iconst_3
      //   48: iconst_0
      //   49: invokevirtual frameHeader : (IIBB)V
      //   52: aload_0
      //   53: getfield sink : Lokio/BufferedSink;
      //   56: aload_2
      //   57: getfield httpCode : I
      //   60: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   65: pop
      //   66: aload_0
      //   67: getfield sink : Lokio/BufferedSink;
      //   70: invokeinterface flush : ()V
      //   75: aload_0
      //   76: monitorexit
      //   77: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	44	21	finally
      //   44	75	21	finally
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
      //   26: aload_0
      //   27: iconst_0
      //   28: aload_1
      //   29: invokevirtual size : ()I
      //   32: bipush #6
      //   34: imul
      //   35: iconst_4
      //   36: iconst_0
      //   37: invokevirtual frameHeader : (IIBB)V
      //   40: iconst_0
      //   41: istore_2
      //   42: iload_2
      //   43: bipush #10
      //   45: if_icmpge -> 117
      //   48: aload_1
      //   49: iload_2
      //   50: invokevirtual isSet : (I)Z
      //   53: ifne -> 62
      //   56: iinc #2, 1
      //   59: goto -> 42
      //   62: iload_2
      //   63: istore_3
      //   64: iload_3
      //   65: iconst_4
      //   66: if_icmpne -> 102
      //   69: iconst_3
      //   70: istore #4
      //   72: aload_0
      //   73: getfield sink : Lokio/BufferedSink;
      //   76: iload #4
      //   78: invokeinterface writeShort : (I)Lokio/BufferedSink;
      //   83: pop
      //   84: aload_0
      //   85: getfield sink : Lokio/BufferedSink;
      //   88: aload_1
      //   89: iload_2
      //   90: invokevirtual get : (I)I
      //   93: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   98: pop
      //   99: goto -> 56
      //   102: iload_3
      //   103: istore #4
      //   105: iload_3
      //   106: bipush #7
      //   108: if_icmpne -> 72
      //   111: iconst_4
      //   112: istore #4
      //   114: goto -> 72
      //   117: aload_0
      //   118: getfield sink : Lokio/BufferedSink;
      //   121: invokeinterface flush : ()V
      //   126: aload_0
      //   127: monitorexit
      //   128: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	40	21	finally
      //   48	56	21	finally
      //   72	99	21	finally
      //   117	126	21	finally
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
      //   27: iload_1
      //   28: iload_2
      //   29: aload_3
      //   30: invokevirtual headers : (ZILjava/util/List;)V
      //   33: aload_0
      //   34: monitorexit
      //   35: return
      // Exception table:
      //   from	to	target	type
      //   2	21	21	finally
      //   26	33	21	finally
    }
    
    public void synStream(boolean param1Boolean1, boolean param1Boolean2, int param1Int1, int param1Int2, List<Header> param1List) throws IOException {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: iload_2
      //   3: ifeq -> 26
      //   6: new java/lang/UnsupportedOperationException
      //   9: astore #5
      //   11: aload #5
      //   13: invokespecial <init> : ()V
      //   16: aload #5
      //   18: athrow
      //   19: astore #5
      //   21: aload_0
      //   22: monitorexit
      //   23: aload #5
      //   25: athrow
      //   26: aload_0
      //   27: getfield closed : Z
      //   30: ifeq -> 48
      //   33: new java/io/IOException
      //   36: astore #5
      //   38: aload #5
      //   40: ldc 'closed'
      //   42: invokespecial <init> : (Ljava/lang/String;)V
      //   45: aload #5
      //   47: athrow
      //   48: aload_0
      //   49: iload_1
      //   50: iload_3
      //   51: aload #5
      //   53: invokevirtual headers : (ZILjava/util/List;)V
      //   56: aload_0
      //   57: monitorexit
      //   58: return
      // Exception table:
      //   from	to	target	type
      //   6	19	19	finally
      //   26	48	19	finally
      //   48	56	19	finally
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
      //   42: ifle -> 62
      //   45: ldc 'windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s'
      //   47: iconst_1
      //   48: anewarray java/lang/Object
      //   51: dup
      //   52: iconst_0
      //   53: lload_2
      //   54: invokestatic valueOf : (J)Ljava/lang/Long;
      //   57: aastore
      //   58: invokestatic access$500 : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
      //   61: athrow
      //   62: aload_0
      //   63: iload_1
      //   64: iconst_4
      //   65: bipush #8
      //   67: iconst_0
      //   68: invokevirtual frameHeader : (IIBB)V
      //   71: aload_0
      //   72: getfield sink : Lokio/BufferedSink;
      //   75: lload_2
      //   76: l2i
      //   77: invokeinterface writeInt : (I)Lokio/BufferedSink;
      //   82: pop
      //   83: aload_0
      //   84: getfield sink : Lokio/BufferedSink;
      //   87: invokeinterface flush : ()V
      //   92: aload_0
      //   93: monitorexit
      //   94: return
      // Exception table:
      //   from	to	target	type
      //   2	24	24	finally
      //   45	62	24	finally
      //   62	92	24	finally
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\framed\Http2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */