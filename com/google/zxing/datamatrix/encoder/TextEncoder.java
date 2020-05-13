package com.google.zxing.datamatrix.encoder;

final class TextEncoder extends C40Encoder {
  int encodeChar(char paramChar, StringBuilder paramStringBuilder) {
    if (paramChar == ' ') {
      paramStringBuilder.append('\003');
      return 1;
    } 
    if (paramChar >= '0' && paramChar <= '9') {
      paramStringBuilder.append((char)(paramChar - 48 + 4));
      return 1;
    } 
    if (paramChar >= 'a' && paramChar <= 'z') {
      paramStringBuilder.append((char)(paramChar - 97 + 14));
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
    if (paramChar == '`') {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - 96));
      return 2;
    } 
    if (paramChar >= 'A' && paramChar <= 'Z') {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - 65 + 1));
      return 2;
    } 
    if (paramChar >= '{' && paramChar <= '') {
      paramStringBuilder.append('\002');
      paramStringBuilder.append((char)(paramChar - 123 + 27));
      return 2;
    } 
    paramStringBuilder.append("\001\036");
    return encodeChar((char)(paramChar - 128), paramStringBuilder) + 2;
  }
  
  public int getEncodingMode() {
    return 2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\TextEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */