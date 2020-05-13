package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class RealBufferedSource implements BufferedSource {
  public final Buffer buffer = new Buffer();
  
  boolean closed;
  
  public final Source source;
  
  RealBufferedSource(Source paramSource) {
    if (paramSource == null)
      throw new IllegalArgumentException("source == null"); 
    this.source = paramSource;
  }
  
  public Buffer buffer() {
    return this.buffer;
  }
  
  public void close() throws IOException {
    if (!this.closed) {
      this.closed = true;
      this.source.close();
      this.buffer.clear();
    } 
  }
  
  public boolean exhausted() throws IOException {
    if (this.closed)
      throw new IllegalStateException("closed"); 
    return (this.buffer.exhausted() && this.source.read(this.buffer, 8192L) == -1L);
  }
  
  public long indexOf(byte paramByte) throws IOException {
    return indexOf(paramByte, 0L);
  }
  
  public long indexOf(byte paramByte, long paramLong) throws IOException {
    if (this.closed)
      throw new IllegalStateException("closed"); 
    while (true) {
      long l = this.buffer.indexOf(paramByte, paramLong);
      if (l != -1L)
        return l; 
      l = this.buffer.size;
      if (this.source.read(this.buffer, 8192L) == -1L)
        return -1L; 
      paramLong = Math.max(paramLong, l);
    } 
  }
  
  public long indexOf(ByteString paramByteString) throws IOException {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong) throws IOException {
    if (this.closed)
      throw new IllegalStateException("closed"); 
    while (true) {
      long l = this.buffer.indexOf(paramByteString, paramLong);
      if (l != -1L)
        return l; 
      l = this.buffer.size;
      if (this.source.read(this.buffer, 8192L) == -1L)
        return -1L; 
      paramLong = Math.max(paramLong, l - paramByteString.size() + 1L);
    } 
  }
  
  public long indexOfElement(ByteString paramByteString) throws IOException {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong) throws IOException {
    if (this.closed)
      throw new IllegalStateException("closed"); 
    while (true) {
      long l = this.buffer.indexOfElement(paramByteString, paramLong);
      if (l != -1L)
        return l; 
      l = this.buffer.size;
      if (this.source.read(this.buffer, 8192L) == -1L)
        return -1L; 
      paramLong = Math.max(paramLong, l);
    } 
  }
  
  public InputStream inputStream() {
    return new InputStream() {
        public int available() throws IOException {
          if (RealBufferedSource.this.closed)
            throw new IOException("closed"); 
          return (int)Math.min(RealBufferedSource.this.buffer.size, 2147483647L);
        }
        
        public void close() throws IOException {
          RealBufferedSource.this.close();
        }
        
        public int read() throws IOException {
          if (RealBufferedSource.this.closed)
            throw new IOException("closed"); 
          return (RealBufferedSource.this.buffer.size == 0L && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 8192L) == -1L) ? -1 : (RealBufferedSource.this.buffer.readByte() & 0xFF);
        }
        
        public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
          if (RealBufferedSource.this.closed)
            throw new IOException("closed"); 
          Util.checkOffsetAndCount(param1ArrayOfbyte.length, param1Int1, param1Int2);
          return (RealBufferedSource.this.buffer.size == 0L && RealBufferedSource.this.source.read(RealBufferedSource.this.buffer, 8192L) == -1L) ? -1 : RealBufferedSource.this.buffer.read(param1ArrayOfbyte, param1Int1, param1Int2);
        }
        
        public String toString() {
          return RealBufferedSource.this + ".inputStream()";
        }
      };
  }
  
  public int read(byte[] paramArrayOfbyte) throws IOException {
    return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    Util.checkOffsetAndCount(paramArrayOfbyte.length, paramInt1, paramInt2);
    if (this.buffer.size == 0L && this.source.read(this.buffer, 8192L) == -1L)
      return -1; 
    paramInt2 = (int)Math.min(paramInt2, this.buffer.size);
    return this.buffer.read(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public long read(Buffer paramBuffer, long paramLong) throws IOException {
    long l = -1L;
    if (paramBuffer == null)
      throw new IllegalArgumentException("sink == null"); 
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong); 
    if (this.closed)
      throw new IllegalStateException("closed"); 
    if (this.buffer.size == 0L && this.source.read(this.buffer, 8192L) == -1L)
      return l; 
    paramLong = Math.min(paramLong, this.buffer.size);
    return this.buffer.read(paramBuffer, paramLong);
  }
  
  public long readAll(Sink paramSink) throws IOException {
    if (paramSink == null)
      throw new IllegalArgumentException("sink == null"); 
    long l1 = 0L;
    while (this.source.read(this.buffer, 8192L) != -1L) {
      long l = this.buffer.completeSegmentByteCount();
      if (l > 0L) {
        l1 += l;
        paramSink.write(this.buffer, l);
      } 
    } 
    long l2 = l1;
    if (this.buffer.size() > 0L) {
      l2 = l1 + this.buffer.size();
      paramSink.write(this.buffer, this.buffer.size());
    } 
    return l2;
  }
  
  public byte readByte() throws IOException {
    require(1L);
    return this.buffer.readByte();
  }
  
  public byte[] readByteArray() throws IOException {
    this.buffer.writeAll(this.source);
    return this.buffer.readByteArray();
  }
  
  public byte[] readByteArray(long paramLong) throws IOException {
    require(paramLong);
    return this.buffer.readByteArray(paramLong);
  }
  
  public ByteString readByteString() throws IOException {
    this.buffer.writeAll(this.source);
    return this.buffer.readByteString();
  }
  
  public ByteString readByteString(long paramLong) throws IOException {
    require(paramLong);
    return this.buffer.readByteString(paramLong);
  }
  
  public long readDecimalLong() throws IOException {
    require(1L);
    for (byte b = 0; request((b + 1)); b++) {
      byte b1 = this.buffer.getByte(b);
      if ((b1 < 48 || b1 > 57) && (b != 0 || b1 != 45)) {
        if (b == 0)
          throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", new Object[] { Byte.valueOf(b1) })); 
        break;
      } 
    } 
    return this.buffer.readDecimalLong();
  }
  
  public void readFully(Buffer paramBuffer, long paramLong) throws IOException {
    try {
      require(paramLong);
      this.buffer.readFully(paramBuffer, paramLong);
      return;
    } catch (EOFException eOFException) {
      paramBuffer.writeAll(this.buffer);
      throw eOFException;
    } 
  }
  
  public void readFully(byte[] paramArrayOfbyte) throws IOException {
    try {
      require(paramArrayOfbyte.length);
      this.buffer.readFully(paramArrayOfbyte);
      return;
    } catch (EOFException eOFException) {
      for (int i = 0; this.buffer.size > 0L; i += j) {
        int j = this.buffer.read(paramArrayOfbyte, i, (int)this.buffer.size);
        if (j == -1)
          throw new AssertionError(); 
      } 
      throw eOFException;
    } 
  }
  
  public long readHexadecimalUnsignedLong() throws IOException {
    require(1L);
    for (byte b = 0; request((b + 1)); b++) {
      byte b1 = this.buffer.getByte(b);
      if ((b1 < 48 || b1 > 57) && (b1 < 97 || b1 > 102) && (b1 < 65 || b1 > 70)) {
        if (b == 0)
          throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", new Object[] { Byte.valueOf(b1) })); 
        break;
      } 
    } 
    return this.buffer.readHexadecimalUnsignedLong();
  }
  
  public int readInt() throws IOException {
    require(4L);
    return this.buffer.readInt();
  }
  
  public int readIntLe() throws IOException {
    require(4L);
    return this.buffer.readIntLe();
  }
  
  public long readLong() throws IOException {
    require(8L);
    return this.buffer.readLong();
  }
  
  public long readLongLe() throws IOException {
    require(8L);
    return this.buffer.readLongLe();
  }
  
  public short readShort() throws IOException {
    require(2L);
    return this.buffer.readShort();
  }
  
  public short readShortLe() throws IOException {
    require(2L);
    return this.buffer.readShortLe();
  }
  
  public String readString(long paramLong, Charset paramCharset) throws IOException {
    require(paramLong);
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null"); 
    return this.buffer.readString(paramLong, paramCharset);
  }
  
  public String readString(Charset paramCharset) throws IOException {
    if (paramCharset == null)
      throw new IllegalArgumentException("charset == null"); 
    this.buffer.writeAll(this.source);
    return this.buffer.readString(paramCharset);
  }
  
  public String readUtf8() throws IOException {
    this.buffer.writeAll(this.source);
    return this.buffer.readUtf8();
  }
  
  public String readUtf8(long paramLong) throws IOException {
    require(paramLong);
    return this.buffer.readUtf8(paramLong);
  }
  
  public int readUtf8CodePoint() throws IOException {
    require(1L);
    byte b = this.buffer.getByte(0L);
    if ((b & 0xE0) == 192) {
      require(2L);
      return this.buffer.readUtf8CodePoint();
    } 
    if ((b & 0xF0) == 224) {
      require(3L);
      return this.buffer.readUtf8CodePoint();
    } 
    if ((b & 0xF8) == 240)
      require(4L); 
    return this.buffer.readUtf8CodePoint();
  }
  
  public String readUtf8Line() throws IOException {
    long l = indexOf((byte)10);
    return (l == -1L) ? ((this.buffer.size != 0L) ? readUtf8(this.buffer.size) : null) : this.buffer.readUtf8Line(l);
  }
  
  public String readUtf8LineStrict() throws IOException {
    long l = indexOf((byte)10);
    if (l == -1L) {
      Buffer buffer = new Buffer();
      this.buffer.copyTo(buffer, 0L, Math.min(32L, this.buffer.size()));
      throw new EOFException("\\n not found: size=" + this.buffer.size() + " content=" + buffer.readByteString().hex() + "…");
    } 
    return this.buffer.readUtf8Line(l);
  }
  
  public boolean request(long paramLong) throws IOException {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifge -> 33
    //   6: new java/lang/IllegalArgumentException
    //   9: dup
    //   10: new java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial <init> : ()V
    //   17: ldc 'byteCount < 0: '
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: lload_1
    //   23: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   26: invokevirtual toString : ()Ljava/lang/String;
    //   29: invokespecial <init> : (Ljava/lang/String;)V
    //   32: athrow
    //   33: aload_0
    //   34: getfield closed : Z
    //   37: ifeq -> 50
    //   40: new java/lang/IllegalStateException
    //   43: dup
    //   44: ldc 'closed'
    //   46: invokespecial <init> : (Ljava/lang/String;)V
    //   49: athrow
    //   50: aload_0
    //   51: getfield buffer : Lokio/Buffer;
    //   54: getfield size : J
    //   57: lload_1
    //   58: lcmp
    //   59: ifge -> 89
    //   62: aload_0
    //   63: getfield source : Lokio/Source;
    //   66: aload_0
    //   67: getfield buffer : Lokio/Buffer;
    //   70: ldc2_w 8192
    //   73: invokeinterface read : (Lokio/Buffer;J)J
    //   78: ldc2_w -1
    //   81: lcmp
    //   82: ifne -> 50
    //   85: iconst_0
    //   86: istore_3
    //   87: iload_3
    //   88: ireturn
    //   89: iconst_1
    //   90: istore_3
    //   91: goto -> 87
  }
  
  public void require(long paramLong) throws IOException {
    if (!request(paramLong))
      throw new EOFException(); 
  }
  
  public int select(Options paramOptions) throws IOException {
    if (this.closed)
      throw new IllegalStateException("closed"); 
    while (true) {
      int i = this.buffer.selectPrefix(paramOptions);
      if (i == -1)
        return -1; 
      int j = paramOptions.byteStrings[i].size();
      if (j <= this.buffer.size) {
        this.buffer.skip(j);
        return i;
      } 
      if (this.source.read(this.buffer, 8192L) == -1L)
        return -1; 
    } 
  }
  
  public void skip(long paramLong) throws IOException {
    if (this.closed)
      throw new IllegalStateException("closed"); 
    while (paramLong > 0L) {
      if (this.buffer.size == 0L && this.source.read(this.buffer, 8192L) == -1L)
        throw new EOFException(); 
      long l = Math.min(paramLong, this.buffer.size());
      this.buffer.skip(l);
      paramLong -= l;
    } 
  }
  
  public Timeout timeout() {
    return this.source.timeout();
  }
  
  public String toString() {
    return "buffer(" + this.source + ")";
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okio\RealBufferedSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */