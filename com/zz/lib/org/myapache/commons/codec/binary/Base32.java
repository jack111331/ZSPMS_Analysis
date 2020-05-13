package com.zz.lib.org.myapache.commons.codec.binary;

public class Base32 extends BaseNCodec {
  private static final int BITS_PER_ENCODED_BYTE = 5;
  
  private static final int BYTES_PER_ENCODED_BLOCK = 8;
  
  private static final int BYTES_PER_UNENCODED_BLOCK = 5;
  
  private static final byte[] CHUNK_SEPARATOR = new byte[] { 13, 10 };
  
  private static final byte[] DECODE_TABLE;
  
  private static final byte[] ENCODE_TABLE = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 
      54, 55 };
  
  private static final byte[] HEX_DECODE_TABLE;
  
  private static final byte[] HEX_ENCODE_TABLE = new byte[] { 
      48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86 };
  
  private static final int MASK_5BITS = 31;
  
  private long bitWorkArea;
  
  private final int decodeSize;
  
  private final byte[] decodeTable;
  
  private final int encodeSize;
  
  private final byte[] encodeTable;
  
  private final byte[] lineSeparator;
  
  public Base32() {
    this(false);
  }
  
  public Base32(int paramInt) {
    this(paramInt, CHUNK_SEPARATOR);
  }
  
  public Base32(int paramInt, byte[] paramArrayOfbyte) {
    this(paramInt, paramArrayOfbyte, false);
  }
  
  public Base32(int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
    super(5, 8, paramInt, i);
    int i;
    if (paramBoolean) {
      this.encodeTable = HEX_ENCODE_TABLE;
      this.decodeTable = HEX_DECODE_TABLE;
    } else {
      this.encodeTable = ENCODE_TABLE;
      this.decodeTable = DECODE_TABLE;
    } 
    if (paramInt > 0) {
      String str;
      if (paramArrayOfbyte == null)
        throw new IllegalArgumentException("lineLength " + paramInt + " > 0, but lineSeparator is null"); 
      if (containsAlphabetOrPad(paramArrayOfbyte)) {
        str = StringUtils.newStringUtf8(paramArrayOfbyte);
        throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + str + "]");
      } 
      this.encodeSize = str.length + 8;
      this.lineSeparator = new byte[str.length];
      System.arraycopy(str, 0, this.lineSeparator, 0, str.length);
    } else {
      this.encodeSize = 8;
      this.lineSeparator = null;
    } 
    this.decodeSize = this.encodeSize - 1;
  }
  
  public Base32(boolean paramBoolean) {
    this(0, (byte[])null, paramBoolean);
  }
  
  void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (this.eof);
    if (paramInt2 < 0)
      this.eof = true; 
    byte b = 0;
    while (true) {
      if (b < paramInt2) {
        byte b1 = paramArrayOfbyte[paramInt1];
        if (b1 == 61) {
          this.eof = true;
        } else {
          ensureBufferSize(this.decodeSize);
          if (b1 >= 0 && b1 < this.decodeTable.length) {
            b1 = this.decodeTable[b1];
            if (b1 >= 0) {
              this.modulus = (this.modulus + 1) % 8;
              this.bitWorkArea = (this.bitWorkArea << 5L) + b1;
              if (this.modulus == 0) {
                byte[] arrayOfByte = this.buffer;
                int i = this.pos;
                this.pos = i + 1;
                arrayOfByte[i] = (byte)(byte)(int)(this.bitWorkArea >> 32L & 0xFFL);
                arrayOfByte = this.buffer;
                i = this.pos;
                this.pos = i + 1;
                arrayOfByte[i] = (byte)(byte)(int)(this.bitWorkArea >> 24L & 0xFFL);
                arrayOfByte = this.buffer;
                i = this.pos;
                this.pos = i + 1;
                arrayOfByte[i] = (byte)(byte)(int)(this.bitWorkArea >> 16L & 0xFFL);
                arrayOfByte = this.buffer;
                i = this.pos;
                this.pos = i + 1;
                arrayOfByte[i] = (byte)(byte)(int)(this.bitWorkArea >> 8L & 0xFFL);
                arrayOfByte = this.buffer;
                i = this.pos;
                this.pos = i + 1;
                arrayOfByte[i] = (byte)(byte)(int)(this.bitWorkArea & 0xFFL);
              } 
            } 
          } 
          b++;
          paramInt1++;
          continue;
        } 
      } 
      if (this.eof && this.modulus >= 2) {
        ensureBufferSize(this.decodeSize);
        switch (this.modulus) {
          default:
            return;
          case 2:
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 2L & 0xFFL);
          case 3:
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 7L & 0xFFL);
          case 4:
            this.bitWorkArea >>= 4L;
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 8L & 0xFFL);
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea & 0xFFL);
          case 5:
            this.bitWorkArea >>= 1L;
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 16L & 0xFFL);
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 8L & 0xFFL);
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea & 0xFFL);
          case 6:
            this.bitWorkArea >>= 6L;
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 16L & 0xFFL);
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 8L & 0xFFL);
            paramArrayOfbyte = this.buffer;
            paramInt1 = this.pos;
            this.pos = paramInt1 + 1;
            paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea & 0xFFL);
          case 7:
            break;
        } 
        this.bitWorkArea >>= 3L;
        paramArrayOfbyte = this.buffer;
        paramInt1 = this.pos;
        this.pos = paramInt1 + 1;
        paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 24L & 0xFFL);
        paramArrayOfbyte = this.buffer;
        paramInt1 = this.pos;
        this.pos = paramInt1 + 1;
        paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 16L & 0xFFL);
        paramArrayOfbyte = this.buffer;
        paramInt1 = this.pos;
        this.pos = paramInt1 + 1;
        paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea >> 8L & 0xFFL);
        paramArrayOfbyte = this.buffer;
        paramInt1 = this.pos;
        this.pos = paramInt1 + 1;
        paramArrayOfbyte[paramInt1] = (byte)(byte)(int)(this.bitWorkArea & 0xFFL);
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
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 3L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea << 2L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
            case 2:
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 11L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 6L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 1L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea << 4L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
            case 3:
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 19L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 14L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 9L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 4L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea << 1L) & 0x1F];
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
              paramArrayOfbyte = this.buffer;
              paramInt2 = this.pos;
              this.pos = paramInt2 + 1;
              paramArrayOfbyte[paramInt2] = (byte)61;
            case 4:
              break;
          } 
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 27L) & 0x1F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 22L) & 0x1F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 17L) & 0x1F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 12L) & 0x1F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 7L) & 0x1F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 2L) & 0x1F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)this.encodeTable[(int)(this.bitWorkArea << 3L) & 0x1F];
          paramArrayOfbyte = this.buffer;
          paramInt2 = this.pos;
          this.pos = paramInt2 + 1;
          paramArrayOfbyte[paramInt2] = (byte)61;
        } 
        return;
      } 
      byte b = 0;
      while (true) {
        if (b < paramInt2) {
          ensureBufferSize(this.encodeSize);
          this.modulus = (this.modulus + 1) % 5;
          byte b1 = paramArrayOfbyte[paramInt1];
          int i = b1;
          if (b1 < 0)
            i = b1 + 256; 
          this.bitWorkArea = (this.bitWorkArea << 8L) + i;
          if (this.modulus == 0) {
            byte[] arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 35L) & 0x1F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 30L) & 0x1F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 25L) & 0x1F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 20L) & 0x1F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 15L) & 0x1F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 10L) & 0x1F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[(int)(this.bitWorkArea >> 5L) & 0x1F];
            arrayOfByte = this.buffer;
            i = this.pos;
            this.pos = i + 1;
            arrayOfByte[i] = (byte)this.encodeTable[(int)this.bitWorkArea & 0x1F];
            this.currentLinePos += 8;
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
  
  public boolean isInAlphabet(byte paramByte) {
    return (paramByte >= 0 && paramByte < this.decodeTable.length && this.decodeTable[paramByte] != -1);
  }
  
  static {
    byte[] arrayOfByte = new byte[91];
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
    arrayOfByte[43] = (byte)-1;
    arrayOfByte[44] = (byte)-1;
    arrayOfByte[45] = (byte)-1;
    arrayOfByte[46] = (byte)-1;
    arrayOfByte[47] = (byte)63;
    arrayOfByte[48] = (byte)-1;
    arrayOfByte[49] = (byte)-1;
    arrayOfByte[50] = (byte)26;
    arrayOfByte[51] = (byte)27;
    arrayOfByte[52] = (byte)28;
    arrayOfByte[53] = (byte)29;
    arrayOfByte[54] = (byte)30;
    arrayOfByte[55] = (byte)31;
    arrayOfByte[56] = (byte)-1;
    arrayOfByte[57] = (byte)-1;
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
    DECODE_TABLE = arrayOfByte;
  }
  
  static {
    arrayOfByte = new byte[88];
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
    arrayOfByte[43] = (byte)-1;
    arrayOfByte[44] = (byte)-1;
    arrayOfByte[45] = (byte)-1;
    arrayOfByte[46] = (byte)-1;
    arrayOfByte[47] = (byte)63;
    arrayOfByte[49] = (byte)1;
    arrayOfByte[50] = (byte)2;
    arrayOfByte[51] = (byte)3;
    arrayOfByte[52] = (byte)4;
    arrayOfByte[53] = (byte)5;
    arrayOfByte[54] = (byte)6;
    arrayOfByte[55] = (byte)7;
    arrayOfByte[56] = (byte)8;
    arrayOfByte[57] = (byte)9;
    arrayOfByte[58] = (byte)-1;
    arrayOfByte[59] = (byte)-1;
    arrayOfByte[60] = (byte)-1;
    arrayOfByte[61] = (byte)-1;
    arrayOfByte[62] = (byte)-1;
    arrayOfByte[63] = (byte)-1;
    arrayOfByte[64] = (byte)-1;
    arrayOfByte[65] = (byte)10;
    arrayOfByte[66] = (byte)11;
    arrayOfByte[67] = (byte)12;
    arrayOfByte[68] = (byte)13;
    arrayOfByte[69] = (byte)14;
    arrayOfByte[70] = (byte)15;
    arrayOfByte[71] = (byte)16;
    arrayOfByte[72] = (byte)17;
    arrayOfByte[73] = (byte)18;
    arrayOfByte[74] = (byte)19;
    arrayOfByte[75] = (byte)20;
    arrayOfByte[76] = (byte)21;
    arrayOfByte[77] = (byte)22;
    arrayOfByte[78] = (byte)23;
    arrayOfByte[79] = (byte)24;
    arrayOfByte[80] = (byte)25;
    arrayOfByte[81] = (byte)26;
    arrayOfByte[82] = (byte)27;
    arrayOfByte[83] = (byte)28;
    arrayOfByte[84] = (byte)29;
    arrayOfByte[85] = (byte)30;
    arrayOfByte[86] = (byte)31;
    arrayOfByte[87] = (byte)32;
    HEX_DECODE_TABLE = arrayOfByte;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\lib\org\myapache\commons\codec\binary\Base32.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */