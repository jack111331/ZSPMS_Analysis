package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

abstract class AI01decoder extends AbstractExpandedDecoder {
  static final int GTIN_SIZE = 40;
  
  AI01decoder(BitArray paramBitArray) {
    super(paramBitArray);
  }
  
  private static void appendCheckDigit(StringBuilder paramStringBuilder, int paramInt) {
    boolean bool = false;
    byte b = 0;
    int i = 0;
    while (b < 13) {
      int j = paramStringBuilder.charAt(b + paramInt) - 48;
      int k = j;
      if ((b & 0x1) == 0)
        k = j * 3; 
      i += k;
      b++;
    } 
    paramInt = 10 - i % 10;
    if (paramInt == 10)
      paramInt = bool; 
    paramStringBuilder.append(paramInt);
  }
  
  final void encodeCompressedGtin(StringBuilder paramStringBuilder, int paramInt) {
    paramStringBuilder.append("(01)");
    int i = paramStringBuilder.length();
    paramStringBuilder.append('9');
    encodeCompressedGtinWithoutAI(paramStringBuilder, paramInt, i);
  }
  
  final void encodeCompressedGtinWithoutAI(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
    for (byte b = 0; b < 4; b++) {
      int i = getGeneralDecoder().extractNumericValueFromBitArray(b * 10 + paramInt1, 10);
      if (i / 100 == 0)
        paramStringBuilder.append('0'); 
      if (i / 10 == 0)
        paramStringBuilder.append('0'); 
      paramStringBuilder.append(i);
    } 
    appendCheckDigit(paramStringBuilder, paramInt2);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\AI01decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */