package com.zz.lib.org.myapache.commons.codec.binary;

import java.math.BigInteger;

public class Base64 extends BaseNCodec {
  private static final int BITS_PER_ENCODED_BYTE = 6;
  
  private static final int BYTES_PER_ENCODED_BLOCK = 4;
  
  private static final int BYTES_PER_UNENCODED_BLOCK = 3;
  
  static final byte[] CHUNK_SEPARATOR = new byte[] { 13, 10 };
  
  private static final byte[] DECODE_TABLE;
  
  private static final int MASK_6BITS = 63;
  
  private static final byte[] STANDARD_ENCODE_TABLE = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] URL_SAFE_ENCODE_TABLE = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  private int bitWorkArea;
  
  private final int decodeSize;
  
  private final byte[] decodeTable;
  
  private final int encodeSize;
  
  private final byte[] encodeTable;
  
  private final byte[] lineSeparator;
  
  static {
    byte[] arrayOfByte = new byte[123];
    arrayOfByte[0] = (byte)-1;
    arrayOfByte[1] = (byte)-1;
    arrayOfByte[2] = (byte)-1;
    arrayOfByte[3] = (byte)-1;
    arrayOfByte[4] = (byte)-1;
    arrayOfByte[5] = (byte)-1;
    arrayOfByte[6] = (byte)-1;
    arrayOfByte[7] = (byte)-1;
    arrayOfByte[8] = (byte)-1;
    arrayOfByte[9] = (byte)-1;
    arrayOfByte[10] = (byte)-1;
    arrayOfByte[11] = (byte)-1;
    arrayOfByte[12] = (byte)-1;
    arrayOfByte[13] = (byte)-1;
    arrayOfByte[14] = (byte)-1;
    arrayOfByte[15] = (byte)-1;
    arrayOfByte[16] = (byte)-1;
    arrayOfByte[17] = (byte)-1;
    arrayOfByte[18] = (byte)-1;
    arrayOfByte[19] = (byte)-1;
    arrayOfByte[20] = (byte)-1;
    arrayOfByte[21] = (byte)-1;
    arrayOfByte[22] = (byte)-1;
    arrayOfByte[23] = (byte)-1;
    arrayOfByte[24] = (byte)-1;
    arrayOfByte[25] = (byte)-1;
    arrayOfByte[26] = (byte)-1;
    arrayOfByte[27] = (byte)-1;
    arrayOfByte[28] = (byte)-1;
    arrayOfByte[29] = (byte)-1;
    arrayOfByte[30] = (byte)-1;
    arrayOfByte[31] = (byte)-1;
    arrayOfByte[32] = (byte)-1;
    arrayOfByte[33] = (byte)-1;
    arrayOfByte[34] = (byte)-1;
    arrayOfByte[35] = (byte)-1;
    arrayOfByte[36] = (byte)-1;
    arrayOfByte[37] = (byte)-1;
    arrayOfByte[38] = (byte)-1;
    arrayOfByte[39] = (byte)-1;
    arrayOfByte[40] = (byte)-1;
    arrayOfByte[41] = (byte)-1;
    arrayOfByte[42] = (byte)-1;
    arrayOfByte[43] = (byte)62;
    arrayOfByte[44] = (byte)-1;
    arrayOfByte[45] = (byte)62;
    arrayOfByte[46] = (byte)-1;
    arrayOfByte[47] = (byte)63;
    arrayOfByte[48] = (byte)52;
    arrayOfByte[49] = (byte)53;
    arrayOfByte[50] = (byte)54;
    arrayOfByte[51] = (byte)55;
    arrayOfByte[52] = (byte)56;
    arrayOfByte[53] = (byte)57;
    arrayOfByte[54] = (byte)58;
    arrayOfByte[55] = (byte)59;
    arrayOfByte[56] = (byte)60;
    arrayOfByte[57] = (byte)61;
    arrayOfByte[58] = (byte)-1;
    arrayOfByte[59] = (byte)-1;
    arrayOfByte[60] = (byte)-1;
    arrayOfByte[61] = (byte)-1;
    arrayOfByte[62] = (byte)-1;
    arrayOfByte[63] = (byte)-1;
    arrayOfByte[64] = (byte)-1;
    arrayOfByte[66] = (byte)1;
    arrayOfByte[67] = (byte)2;
    arrayOfByte[68] = (byte)3;
    arrayOfByte[69] = (byte)4;
    arrayOfByte[70] = (byte)5;
    arrayOfByte[71] = (byte)6;
    arrayOfByte[72] = (byte)7;
    arrayOfByte[73] = (byte)8;
    arrayOfByte[74] = (byte)9;
    arrayOfByte[75] = (byte)10;
    arrayOfByte[76] = (byte)11;
    arrayOfByte[77] = (byte)12;
    arrayOfByte[78] = (byte)13;
    arrayOfByte[79] = (byte)14;
    arrayOfByte[80] = (byte)15;
    arrayOfByte[81] = (byte)16;
    arrayOfByte[82] = (byte)17;
    arrayOfByte[83] = (byte)18;
    arrayOfByte[84] = (byte)19;
    arrayOfByte[85] = (byte)20;
    arrayOfByte[86] = (byte)21;
    arrayOfByte[87] = (byte)22;
    arrayOfByte[88] = (byte)23;
    arrayOfByte[89] = (byte)24;
    arrayOfByte[90] = (byte)25;
    arrayOfByte[91] = (byte)-1;
    arrayOfByte[92] = (byte)-1;
    arrayOfByte[93] = (byte)-1;
    arrayOfByte[94] = (byte)-1;
    arrayOfByte[95] = (byte)63;
    arrayOfByte[96] = (byte)-1;
    arrayOfByte[97] = (byte)26;
    arrayOfByte[98] = (byte)27;
    arrayOfByte[99] = (byte)28;
    arrayOfByte[100] = (byte)29;
    arrayOfByte[101] = (byte)30;
    arrayOfByte[102] = (byte)31;
    arrayOfByte[103] = (byte)32;
    arrayOfByte[104] = (byte)33;
    arrayOfByte[105] = (byte)34;
    arrayOfByte[106] = (byte)35;
    arrayOfByte[107] = (byte)36;
    arrayOfByte[108] = (byte)37;
    arrayOfByte[109] = (byte)38;
    arrayOfByte[110] = (byte)39;
    arrayOfByte[111] = (byte)40;
    arrayOfByte[112] = (byte)41;
    arrayOfByte[113] = (byte)42;
    arrayOfByte[114] = (byte)43;
    arrayOfByte[115] = (byte)44;
    arrayOfByte[116] = (byte)45;
    arrayOfByte[117] = (byte)46;
    arrayOfByte[118] = (byte)47;
    arrayOfByte[119] = (byte)48;
    arrayOfByte[120] = (byte)49;
    arrayOfByte[121] = (byte)50;
    arrayOfByte[122] = (byte)51;
    DECODE_TABLE = arrayOfByte;
  }
  
  public Base64() {
    this(0);
  }
  
  public Base64(int paramInt) {
    this(paramInt, CHUNK_SEPARATOR);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfbyte) {
    this(paramInt, paramArrayOfbyte, false);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
    super(3, 4, paramInt, i);
    int i;
    this.decodeTable = DECODE_TABLE;
    if (paramArrayOfbyte != null) {
      String str;
      if (containsAlphabetOrPad(paramArrayOfbyte)) {
        str = StringUtils.newStringUtf8(paramArrayOfbyte);
        throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + str + "]");
      } 
      if (paramInt > 0) {
        this.encodeSize = str.length + 4;
        this.lineSeparator = new byte[str.length];
        System.arraycopy(str, 0, this.lineSeparator, 0, str.length);
      } else {
        this.encodeSize = 4;
        this.lineSeparator = null;
      } 
    } else {
      this.encodeSize = 4;
      this.lineSeparator = null;
    } 
    this.decodeSize = this.encodeSize - 1;
    if (paramBoolean) {
      paramArrayOfbyte = URL_SAFE_ENCODE_TABLE;
    } else {
      paramArrayOfbyte = STANDARD_ENCODE_TABLE;
    } 
    this.encodeTable = paramArrayOfbyte;
  }
  
  public Base64(boolean paramBoolean) {
    this(76, CHUNK_SEPARATOR, paramBoolean);
  }
  
  public static byte[] decodeBase64(String paramString) {
    return (new Base64()).decode(paramString);
  }
  
  public static byte[] decodeBase64(byte[] paramArrayOfbyte) {
    return (new Base64()).decode(paramArrayOfbyte);
  }
  
  public static BigInteger decodeInteger(byte[] paramArrayOfbyte) {
    return new BigInteger(1, decodeBase64(paramArrayOfbyte));
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfbyte) {
    return encodeBase64(paramArrayOfbyte, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean) {
    return encodeBase64(paramArrayOfbyte, paramBoolean, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean1, boolean paramBoolean2) {
    return encodeBase64(paramArrayOfbyte, paramBoolean1, paramBoolean2, 2147483647);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfbyte, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {
    Base64 base64;
    byte[] arrayOfByte = paramArrayOfbyte;
    if (paramArrayOfbyte != null) {
      if (paramArrayOfbyte.length == 0)
        return paramArrayOfbyte; 
    } else {
      return arrayOfByte;
    } 
    if (paramBoolean1) {
      base64 = new Base64(paramBoolean2);
    } else {
      base64 = new Base64(0, CHUNK_SEPARATOR, paramBoolean2);
    } 
    long l = base64.getEncodedLength(paramArrayOfbyte);
    if (l > paramInt)
      throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maximum size of " + paramInt); 
    return base64.encode(paramArrayOfbyte);
  }
  
  public static byte[] encodeBase64Chunked(byte[] paramArrayOfbyte) {
    return encodeBase64(paramArrayOfbyte, true);
  }
  
  public static String encodeBase64String(byte[] paramArrayOfbyte) {
    return StringUtils.newStringUtf8(encodeBase64(paramArrayOfbyte, false));
  }
  
  public static byte[] encodeBase64URLSafe(byte[] paramArrayOfbyte) {
    return encodeBase64(paramArrayOfbyte, false, true);
  }
  
  public static String encodeBase64URLSafeString(byte[] paramArrayOfbyte) {
    return StringUtils.newStringUtf8(encodeBase64(paramArrayOfbyte, false, true));
  }
  
  public static byte[] encodeInteger(BigInteger paramBigInteger) {
    if (paramBigInteger == null)
      throw new NullPointerException("encodeInteger called with null parameter"); 
    return encodeBase64(toIntegerBytes(paramBigInteger), false);
  }
  
  public static boolean isArrayByteBase64(byte[] paramArrayOfbyte) {
    return isBase64(paramArrayOfbyte);
  }
  
  public static boolean isBase64(byte paramByte) {
    return !(paramByte != 61 && (paramByte < 0 || paramByte >= DECODE_TABLE.length || DECODE_TABLE[paramByte] == -1));
  }
  
  public static boolean isBase64(String paramString) {
    return isBase64(StringUtils.getBytesUtf8(paramString));
  }
  
  public static boolean isBase64(byte[] paramArrayOfbyte) {
    for (byte b = 0;; b++) {
      if (b >= paramArrayOfbyte.length)
        return true; 
      if (!isBase64(paramArrayOfbyte[b]) && !isWhiteSpace(paramArrayOfbyte[b]))
        return false; 
    } 
  }
  
  static byte[] toIntegerBytes(BigInteger paramBigInteger) {
    int i = paramBigInteger.bitLength() + 7 >> 3 << 3;
    byte[] arrayOfByte2 = paramBigInteger.toByteArray();
    if (paramBigInteger.bitLength() % 8 != 0 && paramBigInteger.bitLength() / 8 + 1 == i / 8)
      return arrayOfByte2; 
    boolean bool = false;
    int j = arrayOfByte2.length;
    int k = j;
    if (paramBigInteger.bitLength() % 8 == 0) {
      bool = true;
      k = j - 1;
    } 
    j = i / 8;
    byte[] arrayOfByte1 = new byte[i / 8];
    System.arraycopy(arrayOfByte2, bool, arrayOfByte1, j - k, k);
    return arrayOfByte1;
  }
  
  void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (this.eof);
    if (paramInt2 < 0)
      this.eof = true; 
    byte b = 0;
    while (true) {
      if (b < paramInt2) {
        ensureBufferSize(this.decodeSize);
        byte b1 = paramArrayOfbyte[paramInt1];
        if (b1 == 61) {
          this.eof = true;
        } else {
          if (b1 >= 0 && b1 < DECODE_TABLE.length) {
            b1 = DECODE_TABLE[b1];
            if (b1 >= 0) {
              this.modulus = (this.modulus + 1) % 4;
              this.bitWorkArea = (this.bitWorkArea << 6) + b1;
              if (this.modulus == 0) {
                byte[] arrayOfByte = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                arrayOfByte[i] = (byte)(byte)(this.bitWorkArea >> 16 & 0xFF);
                arrayOfByte = this.buffer;
                i = this.pos;
                this.pos = i + 1;
                arrayOfByte[i] = (byte)(byte)(this.bitWorkArea >> 8 & 0xFF);
                arrayOfByte = this.buffer;
                i = this.pos;
                this.pos = i + 1;
                arrayOfByte[i] = (byte)(byte)(this.bitWorkArea & 0xFF);
              } 
            } 
          } 
          b++;
          paramInt1++;
          continue;
        } 
      } 
      if (this.eof && this.modulus != 0) {
        ensureBufferSize(this.decodeSize);
        switch (this.modulus) {
          default:
            return;
          case 2:
            this.bitWorkArea >>= 4;
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(this.bitWorkArea & 0xFF);
          case 3:
            break;
        } 
        this.bitWorkArea >>= 2;
        paramArrayOfbyte = this.buffer;
        paramInt1 = this.pos;
        this.pos = paramInt1 + 1;
        paramArrayOfbyte[paramInt1] = (byte)(byte)(this.bitWorkArea >> 8 & 0xFF);
        paramArrayOfbyte = this.buffer;
        paramInt1 = this.pos;
        this.pos = paramInt1 + 1;
        paramArrayOfbyte[paramInt1] = (byte)(byte)(this.bitWorkArea & 0xFF);
      } 
    } 
  }
  
  void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (!this.eof) {
      if (paramInt2 < 0) {
        this.eof = true;
        if (this.modulus != 0 || this.lineLength != 0) {
          ensureBufferSize(this.encodeSize);
          paramInt1 = this.pos;
          switch (this.modulus) {
            default:
              this.currentLinePos += this.pos - paramInt1;
              if (this.lineLength > 0 && this.currentLinePos > 0) {
                System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
                this.pos += this.lineSeparator.length;
              } 
              return;
            case 1:
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[this.bitWorkArea >> 2 & 0x3F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[this.bitWorkArea << 4 & 0x3F];
              if (this.encodeTable == STANDARD_ENCODE_TABLE) {
                paramArrayOfbyte = this.buffer;
                paramInt2 = this.pos;
                this.pos = paramInt2 + 1;
                paramArrayOfbyte[paramInt2] = (byte)61;
                paramArrayOfbyte = this.buffer;
                paramInt2 = this.pos;
                this.pos = paramInt2 + 1;
                paramArrayOfbyte[paramInt2] = (byte)61;
              } 
            case 2:
              break;
          } 
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[this.bitWorkArea >> 10 & 0x3F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[this.bitWorkArea >> 4 & 0x3F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[this.bitWorkArea << 2 & 0x3F];
          if (this.encodeTable == STANDARD_ENCODE_TABLE) {
            paramArrayOfbyte = this.buffer;
            paramInt2 = this.pos;
            this.pos = paramInt2 + 1;
            paramArrayOfbyte[paramInt2] = (byte)61;
          } 
        } 
        return;
      } 
      byte b = 0;
      while (true) {
        if (b < paramInt2) {
          ensureBufferSize(this.encodeSize);
          this.modulus = (this.modulus + 1) % 3;
          byte b1 = paramArrayOfbyte[paramInt1];
          int i = b1;
          if (b1 < 0)
            i = b1 + 256; 
          this.bitWorkArea = (this.bitWorkArea << 8) + i;
          if (this.modulus == 0) {
            byte[] arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[this.bitWorkArea >> 18 & 0x3F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[this.bitWorkArea >> 12 & 0x3F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[this.bitWorkArea >> 6 & 0x3F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[this.bitWorkArea & 0x3F];
            this.currentLinePos += 4;
            if (this.lineLength > 0 && this.lineLength <= this.currentLinePos) {
              System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
              this.pos += this.lineSeparator.length;
              this.currentLinePos = 0;
            } 
          } 
          b++;
          paramInt1++;
          continue;
        } 
        return;
      } 
    } 
  }
  
  protected boolean isInAlphabet(byte paramByte) {
    return (paramByte >= 0 && paramByte < this.decodeTable.length && this.decodeTable[paramByte] != -1);
  }
  
  public boolean isUrlSafe() {
    return (this.encodeTable == URL_SAFE_ENCODE_TABLE);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */