package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class SimpleToken extends Token {
  private final short bitCount;
  
  private final short value;
  
  SimpleToken(Token paramToken, int paramInt1, int paramInt2) {
    super(paramToken);
    this.value = (short)(short)paramInt1;
    this.bitCount = (short)(short)paramInt2;
  }
  
  void appendTo(BitArray paramBitArray, byte[] paramArrayOfbyte) {
    paramBitArray.appendBits(this.value, this.bitCount);
  }
  
  public String toString() {
    short s1 = this.value;
    short s2 = this.bitCount;
    short s3 = this.bitCount;
    StringBuilder stringBuilder = new StringBuilder("<");
    stringBuilder.append(Integer.toBinaryString(s1 & (1 << s2) - 1 | 1 << s3 | 1 << this.bitCount).substring(1));
    stringBuilder.append('>');
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\encoder\SimpleToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */