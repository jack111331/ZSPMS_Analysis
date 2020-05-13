package com.google.zxing.datamatrix.encoder;

final class ASCIIEncoder implements Encoder {
  private static char encodeASCIIDigits(char paramChar1, char paramChar2) {
    if (HighLevelEncoder.isDigit(paramChar1) && HighLevelEncoder.isDigit(paramChar2))
      return (char)((paramChar1 - 48) * 10 + paramChar2 - 48 + 130); 
    StringBuilder stringBuilder = new StringBuilder("not digits: ");
    stringBuilder.append(paramChar1);
    stringBuilder.append(paramChar2);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void encode(EncoderContext paramEncoderContext) {
    if (HighLevelEncoder.determineConsecutiveDigitCount(paramEncoderContext.getMessage(), paramEncoderContext.pos) >= 2) {
      paramEncoderContext.writeCodeword(encodeASCIIDigits(paramEncoderContext.getMessage().charAt(paramEncoderContext.pos), paramEncoderContext.getMessage().charAt(paramEncoderContext.pos + 1)));
      paramEncoderContext.pos += 2;
      return;
    } 
    char c = paramEncoderContext.getCurrentChar();
    int i = HighLevelEncoder.lookAheadTest(paramEncoderContext.getMessage(), paramEncoderContext.pos, getEncodingMode());
    if (i != getEncodingMode()) {
      switch (i) {
        default:
          throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(i)));
        case 5:
          paramEncoderContext.writeCodeword('ç');
          paramEncoderContext.signalEncoderChange(5);
          return;
        case 4:
          paramEncoderContext.writeCodeword('ð');
          paramEncoderContext.signalEncoderChange(4);
          return;
        case 3:
          paramEncoderContext.writeCodeword('î');
          paramEncoderContext.signalEncoderChange(3);
          return;
        case 2:
          paramEncoderContext.writeCodeword('ï');
          paramEncoderContext.signalEncoderChange(2);
          return;
        case 1:
          break;
      } 
      paramEncoderContext.writeCodeword('æ');
      paramEncoderContext.signalEncoderChange(1);
      return;
    } 
    if (HighLevelEncoder.isExtendedASCII(c)) {
      paramEncoderContext.writeCodeword('ë');
      paramEncoderContext.writeCodeword((char)(c - 128 + 1));
      paramEncoderContext.pos++;
      return;
    } 
    paramEncoderContext.writeCodeword((char)(c + 1));
    paramEncoderContext.pos++;
  }
  
  public int getEncodingMode() {
    return 0;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\ASCIIEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */