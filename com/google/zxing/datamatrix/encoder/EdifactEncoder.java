package com.google.zxing.datamatrix.encoder;

final class EdifactEncoder implements Encoder {
  private static void encodeChar(char paramChar, StringBuilder paramStringBuilder) {
    if (paramChar >= ' ' && paramChar <= '?') {
      paramStringBuilder.append(paramChar);
      return;
    } 
    if (paramChar >= '@' && paramChar <= '^') {
      paramStringBuilder.append((char)(paramChar - 64));
      return;
    } 
    HighLevelEncoder.illegalCharacter(paramChar);
  }
  
  private static String encodeToCodewords(CharSequence paramCharSequence, int paramInt) {
    int i = paramCharSequence.length() - paramInt;
    if (i != 0) {
      byte b1;
      byte b2;
      char c1 = paramCharSequence.charAt(paramInt);
      char c = Character.MIN_VALUE;
      if (i >= 2) {
        b1 = paramCharSequence.charAt(paramInt + 1);
      } else {
        b1 = 0;
      } 
      if (i >= 3) {
        b2 = paramCharSequence.charAt(paramInt + 2);
      } else {
        b2 = 0;
      } 
      if (i >= 4)
        c = paramCharSequence.charAt(paramInt + 3); 
      paramInt = (c1 << 18) + (b1 << 12) + (b2 << 6) + c;
      char c2 = (char)(paramInt >> 16 & 0xFF);
      char c3 = (char)(paramInt >> 8 & 0xFF);
      char c4 = (char)(paramInt & 0xFF);
      paramCharSequence = new StringBuilder(3);
      paramCharSequence.append(c2);
      if (i >= 2)
        paramCharSequence.append(c3); 
      if (i >= 3)
        paramCharSequence.append(c4); 
      return paramCharSequence.toString();
    } 
    throw new IllegalStateException("StringBuilder must not be empty");
  }
  
  private static void handleEOD(EncoderContext paramEncoderContext, CharSequence paramCharSequence) {
    try {
      int i = paramCharSequence.length();
      if (i == 0)
        return; 
      boolean bool = true;
      if (i == 1) {
        paramEncoderContext.updateSymbolInfo();
        int j = paramEncoderContext.getSymbolInfo().getDataCapacity() - paramEncoderContext.getCodewordCount();
        int k = paramEncoderContext.getRemainingCharacters();
        int m = j;
        if (k > j) {
          paramEncoderContext.updateSymbolInfo(paramEncoderContext.getCodewordCount() + 1);
          j = paramEncoderContext.getSymbolInfo().getDataCapacity();
          m = paramEncoderContext.getCodewordCount();
          m = j - m;
        } 
        if (k <= m && m <= 2)
          return; 
      } 
      if (i <= 4) {
        boolean bool1;
        int j = i - 1;
        paramCharSequence = encodeToCodewords(paramCharSequence, 0);
        if ((paramEncoderContext.hasMoreCharacters() ^ true) != 0 && j <= 2) {
          bool1 = bool;
        } else {
          bool1 = false;
        } 
        bool = bool1;
        if (j <= 2) {
          paramEncoderContext.updateSymbolInfo(paramEncoderContext.getCodewordCount() + j);
          bool = bool1;
          if (paramEncoderContext.getSymbolInfo().getDataCapacity() - paramEncoderContext.getCodewordCount() >= 3) {
            paramEncoderContext.updateSymbolInfo(paramEncoderContext.getCodewordCount() + paramCharSequence.length());
            bool = false;
          } 
        } 
        if (bool) {
          paramEncoderContext.resetSymbolInfo();
          paramEncoderContext.pos -= j;
        } else {
          paramEncoderContext.writeCodewords((String)paramCharSequence);
        } 
        return;
      } 
      IllegalStateException illegalStateException = new IllegalStateException();
      this("Count must not exceed 4");
      throw illegalStateException;
    } finally {
      paramEncoderContext.signalEncoderChange(0);
    } 
  }
  
  public void encode(EncoderContext paramEncoderContext) {
    StringBuilder stringBuilder = new StringBuilder();
    while (paramEncoderContext.hasMoreCharacters()) {
      encodeChar(paramEncoderContext.getCurrentChar(), stringBuilder);
      paramEncoderContext.pos++;
      if (stringBuilder.length() >= 4) {
        paramEncoderContext.writeCodewords(encodeToCodewords(stringBuilder, 0));
        stringBuilder.delete(0, 4);
        if (HighLevelEncoder.lookAheadTest(paramEncoderContext.getMessage(), paramEncoderContext.pos, getEncodingMode()) != getEncodingMode()) {
          paramEncoderContext.signalEncoderChange(0);
          break;
        } 
      } 
    } 
    stringBuilder.append('\037');
    handleEOD(paramEncoderContext, stringBuilder);
  }
  
  public int getEncodingMode() {
    return 4;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\EdifactEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */