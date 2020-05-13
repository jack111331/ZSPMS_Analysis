package com.google.zxing.datamatrix.encoder;

final class Base256Encoder implements Encoder {
  private static char randomize255State(char paramChar, int paramInt) {
    int i = paramChar + paramInt * 149 % 255 + 1;
    return (i <= 255) ? (char)i : (char)(i - 256);
  }
  
  public void encode(EncoderContext paramEncoderContext) {
    StringBuilder stringBuilder = new StringBuilder();
    boolean bool = false;
    stringBuilder.append(false);
    while (paramEncoderContext.hasMoreCharacters()) {
      stringBuilder.append(paramEncoderContext.getCurrentChar());
      paramEncoderContext.pos++;
      if (HighLevelEncoder.lookAheadTest(paramEncoderContext.getMessage(), paramEncoderContext.pos, getEncodingMode()) != getEncodingMode()) {
        paramEncoderContext.signalEncoderChange(0);
        break;
      } 
    } 
    int i = stringBuilder.length() - 1;
    int j = paramEncoderContext.getCodewordCount() + i + 1;
    paramEncoderContext.updateSymbolInfo(j);
    if (paramEncoderContext.getSymbolInfo().getDataCapacity() - j > 0) {
      j = 1;
    } else {
      j = 0;
    } 
    if (paramEncoderContext.hasMoreCharacters() || j != 0)
      if (i <= 249) {
        stringBuilder.setCharAt(0, (char)i);
      } else if (i <= 1555) {
        stringBuilder.setCharAt(0, (char)(i / 250 + 249));
        stringBuilder.insert(1, (char)(i % 250));
      } else {
        throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(i)));
      }  
    i = stringBuilder.length();
    for (j = bool; j < i; j++)
      paramEncoderContext.writeCodeword(randomize255State(stringBuilder.charAt(j), paramEncoderContext.getCodewordCount() + 1)); 
  }
  
  public int getEncodingMode() {
    return 5;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\Base256Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */