package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;
import java.nio.charset.StandardCharsets;

final class EncoderContext {
  private final StringBuilder codewords;
  
  private Dimension maxSize;
  
  private Dimension minSize;
  
  private final String msg;
  
  private int newEncoding;
  
  int pos;
  
  private SymbolShapeHint shape;
  
  private int skipAtEnd;
  
  private SymbolInfo symbolInfo;
  
  EncoderContext(String paramString) {
    byte[] arrayOfByte = paramString.getBytes(StandardCharsets.ISO_8859_1);
    StringBuilder stringBuilder = new StringBuilder(arrayOfByte.length);
    int i = arrayOfByte.length;
    byte b = 0;
    while (b < i) {
      char c = (char)(arrayOfByte[b] & 0xFF);
      if (c != '?' || paramString.charAt(b) == '?') {
        stringBuilder.append(c);
        b++;
        continue;
      } 
      throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
    } 
    this.msg = stringBuilder.toString();
    this.shape = SymbolShapeHint.FORCE_NONE;
    this.codewords = new StringBuilder(paramString.length());
    this.newEncoding = -1;
  }
  
  private int getTotalMessageCharCount() {
    return this.msg.length() - this.skipAtEnd;
  }
  
  public int getCodewordCount() {
    return this.codewords.length();
  }
  
  public StringBuilder getCodewords() {
    return this.codewords;
  }
  
  public char getCurrent() {
    return this.msg.charAt(this.pos);
  }
  
  public char getCurrentChar() {
    return this.msg.charAt(this.pos);
  }
  
  public String getMessage() {
    return this.msg;
  }
  
  public int getNewEncoding() {
    return this.newEncoding;
  }
  
  public int getRemainingCharacters() {
    return getTotalMessageCharCount() - this.pos;
  }
  
  public SymbolInfo getSymbolInfo() {
    return this.symbolInfo;
  }
  
  public boolean hasMoreCharacters() {
    return (this.pos < getTotalMessageCharCount());
  }
  
  public void resetEncoderSignal() {
    this.newEncoding = -1;
  }
  
  public void resetSymbolInfo() {
    this.symbolInfo = null;
  }
  
  public void setSizeConstraints(Dimension paramDimension1, Dimension paramDimension2) {
    this.minSize = paramDimension1;
    this.maxSize = paramDimension2;
  }
  
  public void setSkipAtEnd(int paramInt) {
    this.skipAtEnd = paramInt;
  }
  
  public void setSymbolShape(SymbolShapeHint paramSymbolShapeHint) {
    this.shape = paramSymbolShapeHint;
  }
  
  public void signalEncoderChange(int paramInt) {
    this.newEncoding = paramInt;
  }
  
  public void updateSymbolInfo() {
    updateSymbolInfo(getCodewordCount());
  }
  
  public void updateSymbolInfo(int paramInt) {
    if (this.symbolInfo == null || paramInt > this.symbolInfo.getDataCapacity())
      this.symbolInfo = SymbolInfo.lookup(paramInt, this.shape, this.minSize, this.maxSize, true); 
  }
  
  public void writeCodeword(char paramChar) {
    this.codewords.append(paramChar);
  }
  
  public void writeCodewords(String paramString) {
    this.codewords.append(paramString);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\EncoderContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */