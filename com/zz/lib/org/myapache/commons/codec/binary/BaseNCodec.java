package com.zz.lib.org.myapache.commons.codec.binary;

import com.zz.lib.org.myapache.commons.codec.BinaryDecoder;
import com.zz.lib.org.myapache.commons.codec.BinaryEncoder;
import com.zz.lib.org.myapache.commons.codec.DecoderException;
import com.zz.lib.org.myapache.commons.codec.EncoderException;

public abstract class BaseNCodec implements BinaryDecoder, BinaryEncoder {
  private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
  
  private static final int DEFAULT_BUFFER_SIZE = 8192;
  
  protected static final int MASK_8BITS = 255;
  
  public static final int MIME_CHUNK_SIZE = 76;
  
  protected static final byte PAD_DEFAULT = 61;
  
  public static final int PEM_CHUNK_SIZE = 64;
  
  protected final byte PAD = (byte)61;
  
  protected byte[] buffer;
  
  private final int chunkSeparatorLength;
  
  protected int currentLinePos;
  
  private final int encodedBlockSize;
  
  protected boolean eof;
  
  protected final int lineLength;
  
  protected int modulus;
  
  protected int pos;
  
  private int readPos;
  
  private final int unencodedBlockSize;
  
  protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.unencodedBlockSize = paramInt1;
    this.encodedBlockSize = paramInt2;
    if (paramInt3 > 0 && paramInt4 > 0) {
      paramInt1 = paramInt3 / paramInt2 * paramInt2;
    } else {
      paramInt1 = 0;
    } 
    this.lineLength = paramInt1;
    this.chunkSeparatorLength = paramInt4;
  }
  
  protected static boolean isWhiteSpace(byte paramByte) {
    switch (paramByte) {
      default:
        return false;
      case 9:
      case 10:
      case 13:
      case 32:
        break;
    } 
    return true;
  }
  
  private void reset() {
    this.buffer = null;
    this.pos = 0;
    this.readPos = 0;
    this.currentLinePos = 0;
    this.modulus = 0;
    this.eof = false;
  }
  
  private void resizeBuffer() {
    if (this.buffer == null) {
      this.buffer = new byte[getDefaultBufferSize()];
      this.pos = 0;
      this.readPos = 0;
      return;
    } 
    byte[] arrayOfByte = new byte[this.buffer.length * 2];
    System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.buffer.length);
    this.buffer = arrayOfByte;
  }
  
  int available() {
    return (this.buffer != null) ? (this.pos - this.readPos) : 0;
  }
  
  protected boolean containsAlphabetOrPad(byte[] paramArrayOfbyte) {
    boolean bool = false;
    if (paramArrayOfbyte == null)
      return bool; 
    int i = paramArrayOfbyte.length;
    byte b = 0;
    while (true) {
      boolean bool1 = bool;
      if (b < i) {
        byte b1 = paramArrayOfbyte[b];
        if (61 == b1 || isInAlphabet(b1))
          return true; 
        b++;
        continue;
      } 
      return bool1;
    } 
  }
  
  public Object decode(Object paramObject) throws DecoderException {
    if (paramObject instanceof byte[])
      return decode((byte[])paramObject); 
    if (paramObject instanceof String)
      return decode((String)paramObject); 
    throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
  }
  
  abstract void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public byte[] decode(String paramString) {
    return decode(StringUtils.getBytesUtf8(paramString));
  }
  
  public byte[] decode(byte[] paramArrayOfbyte) {
    reset();
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0) {
      decode(paramArrayOfbyte, 0, paramArrayOfbyte.length);
      decode(paramArrayOfbyte, 0, -1);
      paramArrayOfbyte = new byte[this.pos];
      readResults(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    } 
    return paramArrayOfbyte;
  }
  
  public Object encode(Object paramObject) throws EncoderException {
    if (!(paramObject instanceof byte[]))
      throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]"); 
    return encode((byte[])paramObject);
  }
  
  abstract void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public byte[] encode(byte[] paramArrayOfbyte) {
    reset();
    if (paramArrayOfbyte != null && paramArrayOfbyte.length != 0) {
      encode(paramArrayOfbyte, 0, paramArrayOfbyte.length);
      encode(paramArrayOfbyte, 0, -1);
      paramArrayOfbyte = new byte[this.pos - this.readPos];
      readResults(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    } 
    return paramArrayOfbyte;
  }
  
  public String encodeAsString(byte[] paramArrayOfbyte) {
    return StringUtils.newStringUtf8(encode(paramArrayOfbyte));
  }
  
  public String encodeToString(byte[] paramArrayOfbyte) {
    return StringUtils.newStringUtf8(encode(paramArrayOfbyte));
  }
  
  protected void ensureBufferSize(int paramInt) {
    if (this.buffer == null || this.buffer.length < this.pos + paramInt)
      resizeBuffer(); 
  }
  
  protected int getDefaultBufferSize() {
    return 8192;
  }
  
  public long getEncodedLength(byte[] paramArrayOfbyte) {
    long l1 = ((paramArrayOfbyte.length + this.unencodedBlockSize - 1) / this.unencodedBlockSize) * this.encodedBlockSize;
    long l2 = l1;
    if (this.lineLength > 0)
      l2 = l1 + (this.lineLength + l1 - 1L) / this.lineLength * this.chunkSeparatorLength; 
    return l2;
  }
  
  boolean hasData() {
    return (this.buffer != null);
  }
  
  protected abstract boolean isInAlphabet(byte paramByte);
  
  public boolean isInAlphabet(String paramString) {
    return isInAlphabet(StringUtils.getBytesUtf8(paramString), true);
  }
  
  public boolean isInAlphabet(byte[] paramArrayOfbyte, boolean paramBoolean) {
    for (byte b = 0;; b++) {
      if (b >= paramArrayOfbyte.length)
        return true; 
      if (!isInAlphabet(paramArrayOfbyte[b]) && (!paramBoolean || (paramArrayOfbyte[b] != 61 && !isWhiteSpace(paramArrayOfbyte[b]))))
        return false; 
    } 
  }
  
  int readResults(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (this.buffer != null) {
      paramInt2 = Math.min(available(), paramInt2);
      System.arraycopy(this.buffer, this.readPos, paramArrayOfbyte, paramInt1, paramInt2);
      this.readPos += paramInt2;
      paramInt1 = paramInt2;
      if (this.readPos >= this.pos) {
        this.buffer = null;
        paramInt1 = paramInt2;
      } 
      return paramInt1;
    } 
    return this.eof ? -1 : 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\BaseNCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */