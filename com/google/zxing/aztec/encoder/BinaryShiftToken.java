package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class BinaryShiftToken extends Token {
  private final short binaryShiftByteCount;
  
  private final short binaryShiftStart;
  
  BinaryShiftToken(Token paramToken, int paramInt1, int paramInt2) {
    super(paramToken);
    this.binaryShiftStart = (short)(short)paramInt1;
    this.binaryShiftByteCount = (short)(short)paramInt2;
  }
  
  public void appendTo(BitArray paramBitArray, byte[] paramArrayOfbyte) {
    for (byte b = 0; b < this.binaryShiftByteCount; b++) {
      if (b == 0 || (b == 31 && this.binaryShiftByteCount <= 62)) {
        paramBitArray.appendBits(31, 5);
        if (this.binaryShiftByteCount > 62) {
          paramBitArray.appendBits(this.binaryShiftByteCount - 31, 16);
        } else if (b == 0) {
          paramBitArray.appendBits(Math.min(this.binaryShiftByteCount, 31), 5);
        } else {
          paramBitArray.appendBits(this.binaryShiftByteCount - 31, 5);
        } 
      } 
      paramBitArray.appendBits(paramArrayOfbyte[this.binaryShiftStart + b], 8);
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("<");
    stringBuilder.append(this.binaryShiftStart);
    stringBuilder.append("::");
    stringBuilder.append(this.binaryShiftStart + this.binaryShiftByteCount - 1);
    stringBuilder.append('>');
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\aztec\encoder\BinaryShiftToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */