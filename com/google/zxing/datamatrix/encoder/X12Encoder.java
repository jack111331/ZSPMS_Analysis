package com.google.zxing.datamatrix.encoder;

final class X12Encoder extends C40Encoder {
  public void encode(EncoderContext paramEncoderContext) {
    StringBuilder stringBuilder = new StringBuilder();
    while (paramEncoderContext.hasMoreCharacters()) {
      char c = paramEncoderContext.getCurrentChar();
      paramEncoderContext.pos++;
      encodeChar(c, stringBuilder);
      if (stringBuilder.length() % 3 == 0) {
        writeNextTriplet(paramEncoderContext, stringBuilder);
        if (HighLevelEncoder.lookAheadTest(paramEncoderContext.getMessage(), paramEncoderContext.pos, getEncodingMode()) != getEncodingMode()) {
          paramEncoderContext.signalEncoderChange(0);
          break;
        } 
      } 
    } 
    handleEOD(paramEncoderContext, stringBuilder);
  }
  
  int encodeChar(char paramChar, StringBuilder paramStringBuilder) {
    if (paramChar != '\r') {
      if (paramChar != ' ') {
        if (paramChar != '*') {
          if (paramChar != '>') {
            if (paramChar >= '0' && paramChar <= '9') {
              paramStringBuilder.append((char)(paramChar - 48 + 4));
            } else if (paramChar >= 'A' && paramChar <= 'Z') {
              paramStringBuilder.append((char)(paramChar - 65 + 14));
            } else {
              HighLevelEncoder.illegalCharacter(paramChar);
            } 
          } else {
            paramStringBuilder.append('\002');
          } 
        } else {
          paramStringBuilder.append('\001');
        } 
      } else {
        paramStringBuilder.append('\003');
      } 
    } else {
      paramStringBuilder.append(false);
    } 
    return 1;
  }
  
  public int getEncodingMode() {
    return 3;
  }
  
  void handleEOD(EncoderContext paramEncoderContext, StringBuilder paramStringBuilder) {
    paramEncoderContext.updateSymbolInfo();
    int i = paramEncoderContext.getSymbolInfo().getDataCapacity() - paramEncoderContext.getCodewordCount();
    int j = paramStringBuilder.length();
    paramEncoderContext.pos -= j;
    if (paramEncoderContext.getRemainingCharacters() > 1 || i > 1 || paramEncoderContext.getRemainingCharacters() != i)
      paramEncoderContext.writeCodeword('þ'); 
    if (paramEncoderContext.getNewEncoding() < 0)
      paramEncoderContext.signalEncoderChange(0); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\X12Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */