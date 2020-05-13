package com.google.zxing.datamatrix.encoder;

class C40Encoder implements Encoder {
  private int backtrackOneCharacter(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, int paramInt) {
    int i = paramStringBuilder1.length();
    paramStringBuilder1.delete(i - paramInt, i);
    paramEncoderContext.pos--;
    paramInt = encodeChar(paramEncoderContext.getCurrentChar(), paramStringBuilder2);
    paramEncoderContext.resetSymbolInfo();
    return paramInt;
  }
  
  private static String encodeToCodewords(CharSequence paramCharSequence, int paramInt) {
    paramInt = paramCharSequence.charAt(paramInt) * 1600 + paramCharSequence.charAt(paramInt + 1) * 40 + paramCharSequence.charAt(paramInt + 2) + 1;
    return new String(new char[] { (char)(paramInt / 256), (char)(paramInt % 256) });
  }
  
  static void writeNextTriplet(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder) {
    paramEncoderContext.writeCodewords(encodeToCodewords(paramStringBuilder, 0));
    paramStringBuilder.delete(0, 3);
  }
  
  public void encode(EncoderContext paramEncoderContext) {
    StringBuilder stringBuilder = new StringBuilder();
    while (true) {
      while (true)
        break; 
      if (stringBuilder.length() % 3 == 0 && HighLevelEncoder.lookAheadTest(paramEncoderContext.getMessage(), paramEncoderContext.pos, getEncodingMode()) != getEncodingMode()) {
        paramEncoderContext.signalEncoderChange(0);
        break;
      } 
    } 
    handleEOD(paramEncoderContext, stringBuilder);
  }
  
  int encodeChar(char paramChar, StringBuilder paramStringBuilder) {
    if (paramChar == ' ') {
      paramStringBuilder.append('\003');
      return 1;
    } 
    if (paramChar >= '0' && paramChar <= '9') {
      paramStringBuilder.append((char)(paramChar - 48 + 4));
      return 1;
    } 
    if (paramChar >= 'A' && paramChar <= 'Z') {
      paramStringBuilder.append((char)(paramChar - 65 + 14));
      return 1;
    } 
    if (paramChar < ' ') {
      paramStringBuilder.append(false);
      paramStringBuilder.append(paramChar);
      return 2;
    } 
    if (paramChar >= '!' && paramChar <= '/') {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - 33));
      return 2;
    } 
    if (paramChar >= ':' && paramChar <= '@') {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - 58 + 15));
      return 2;
    } 
    if (paramChar >= '[' && paramChar <= '_') {
      paramStringBuilder.append('\001');
      paramStringBuilder.append((char)(paramChar - 91 + 22));
      return 2;
    } 
    if (paramChar >= '`' && paramChar <= '') {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - 96));
      return 2;
    } 
    paramStringBuilder.append("\001\036");
    return encodeChar((char)(paramChar - 128), paramStringBuilder) + 2;
  }
  
  public int getEncodingMode() {
    return 1;
  }
  
  void handleEOD(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder) {
    int i = paramStringBuilder.length() / 3;
    int j = paramStringBuilder.length() % 3;
    i = paramEncoderContext.getCodewordCount() + (i << 1);
    paramEncoderContext.updateSymbolInfo(i);
    i = paramEncoderContext.getSymbolInfo().getDataCapacity() - i;
    if (j == 2) {
      paramStringBuilder.append(false);
      while (paramStringBuilder.length() >= 3)
        writeNextTriplet(paramEncoderContext, paramStringBuilder); 
      if (paramEncoderContext.hasMoreCharacters())
        paramEncoderContext.writeCodeword('þ'); 
    } else if (i == 1 && j == 1) {
      while (paramStringBuilder.length() >= 3)
        writeNextTriplet(paramEncoderContext, paramStringBuilder); 
      if (paramEncoderContext.hasMoreCharacters())
        paramEncoderContext.writeCodeword('þ'); 
      paramEncoderContext.pos--;
    } else if (j == 0) {
      while (paramStringBuilder.length() >= 3)
        writeNextTriplet(paramEncoderContext, paramStringBuilder); 
      if (i > 0 || paramEncoderContext.hasMoreCharacters())
        paramEncoderContext.writeCodeword('þ'); 
    } else {
      throw new IllegalStateException("Unexpected case. Please report!");
    } 
    paramEncoderContext.signalEncoderChange(0);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\C40Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */