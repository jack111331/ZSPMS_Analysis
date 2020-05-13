package com.google.zxing.datamatrix.encoder;

import com.google.zxing.Dimension;

public class SymbolInfo {
  static final SymbolInfo[] PROD_SYMBOLS;
  
  private static SymbolInfo[] symbols;
  
  private final int dataCapacity;
  
  private final int dataRegions;
  
  private final int errorCodewords;
  
  public final int matrixHeight;
  
  public final int matrixWidth;
  
  private final boolean rectangular;
  
  private final int rsBlockData;
  
  private final int rsBlockError;
  
  static {
    SymbolInfo[] arrayOfSymbolInfo = new SymbolInfo[30];
    arrayOfSymbolInfo[0] = new SymbolInfo(false, 3, 5, 8, 8, 1);
    arrayOfSymbolInfo[1] = new SymbolInfo(false, 5, 7, 10, 10, 1);
    arrayOfSymbolInfo[2] = new SymbolInfo(true, 5, 7, 16, 6, 1);
    arrayOfSymbolInfo[3] = new SymbolInfo(false, 8, 10, 12, 12, 1);
    arrayOfSymbolInfo[4] = new SymbolInfo(true, 10, 11, 14, 6, 2);
    arrayOfSymbolInfo[5] = new SymbolInfo(false, 12, 12, 14, 14, 1);
    arrayOfSymbolInfo[6] = new SymbolInfo(true, 16, 14, 24, 10, 1);
    arrayOfSymbolInfo[7] = new SymbolInfo(false, 18, 14, 16, 16, 1);
    arrayOfSymbolInfo[8] = new SymbolInfo(false, 22, 18, 18, 18, 1);
    arrayOfSymbolInfo[9] = new SymbolInfo(true, 22, 18, 16, 10, 2);
    arrayOfSymbolInfo[10] = new SymbolInfo(false, 30, 20, 20, 20, 1);
    arrayOfSymbolInfo[11] = new SymbolInfo(true, 32, 24, 16, 14, 2);
    arrayOfSymbolInfo[12] = new SymbolInfo(false, 36, 24, 22, 22, 1);
    arrayOfSymbolInfo[13] = new SymbolInfo(false, 44, 28, 24, 24, 1);
    arrayOfSymbolInfo[14] = new SymbolInfo(true, 49, 28, 22, 14, 2);
    arrayOfSymbolInfo[15] = new SymbolInfo(false, 62, 36, 14, 14, 4);
    arrayOfSymbolInfo[16] = new SymbolInfo(false, 86, 42, 16, 16, 4);
    arrayOfSymbolInfo[17] = new SymbolInfo(false, 114, 48, 18, 18, 4);
    arrayOfSymbolInfo[18] = new SymbolInfo(false, 144, 56, 20, 20, 4);
    arrayOfSymbolInfo[19] = new SymbolInfo(false, 174, 68, 22, 22, 4);
    arrayOfSymbolInfo[20] = new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42);
    arrayOfSymbolInfo[21] = new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56);
    arrayOfSymbolInfo[22] = new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36);
    arrayOfSymbolInfo[23] = new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48);
    arrayOfSymbolInfo[24] = new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56);
    arrayOfSymbolInfo[25] = new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68);
    arrayOfSymbolInfo[26] = new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56);
    arrayOfSymbolInfo[27] = new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68);
    arrayOfSymbolInfo[28] = new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62);
    arrayOfSymbolInfo[29] = new DataMatrixSymbolInfo144();
    PROD_SYMBOLS = arrayOfSymbolInfo;
    symbols = arrayOfSymbolInfo;
  }
  
  public SymbolInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    this(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt1, paramInt2);
  }
  
  SymbolInfo(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    this.rectangular = paramBoolean;
    this.dataCapacity = paramInt1;
    this.errorCodewords = paramInt2;
    this.matrixWidth = paramInt3;
    this.matrixHeight = paramInt4;
    this.dataRegions = paramInt5;
    this.rsBlockData = paramInt6;
    this.rsBlockError = paramInt7;
  }
  
  private int getHorizontalDataRegions() {
    int i = this.dataRegions;
    if (i != 4)
      if (i != 16) {
        if (i != 36) {
          switch (i) {
            default:
              throw new IllegalStateException("Cannot handle this number of data regions");
            case 1:
              return 1;
            case 2:
              break;
          } 
        } else {
          return 6;
        } 
      } else {
        return 4;
      }  
    return 2;
  }
  
  private int getVerticalDataRegions() {
    int i = this.dataRegions;
    if (i != 4) {
      if (i != 16) {
        if (i != 36) {
          switch (i) {
            default:
              throw new IllegalStateException("Cannot handle this number of data regions");
            case 1:
            case 2:
              break;
          } 
          return 1;
        } 
        return 6;
      } 
      return 4;
    } 
    return 2;
  }
  
  public static SymbolInfo lookup(int paramInt) {
    return lookup(paramInt, SymbolShapeHint.FORCE_NONE, true);
  }
  
  public static SymbolInfo lookup(int paramInt, SymbolShapeHint paramSymbolShapeHint) {
    return lookup(paramInt, paramSymbolShapeHint, true);
  }
  
  public static SymbolInfo lookup(int paramInt, SymbolShapeHint paramSymbolShapeHint, Dimension paramDimension1, Dimension paramDimension2, boolean paramBoolean) {
    for (SymbolInfo symbolInfo : symbols) {
      if ((paramSymbolShapeHint != SymbolShapeHint.FORCE_SQUARE || !symbolInfo.rectangular) && (paramSymbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.rectangular) && (paramDimension1 == null || (symbolInfo.getSymbolWidth() >= paramDimension1.getWidth() && symbolInfo.getSymbolHeight() >= paramDimension1.getHeight())) && (paramDimension2 == null || (symbolInfo.getSymbolWidth() <= paramDimension2.getWidth() && symbolInfo.getSymbolHeight() <= paramDimension2.getHeight())) && paramInt <= symbolInfo.dataCapacity)
        return symbolInfo; 
    } 
    if (!paramBoolean)
      return null; 
    throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(paramInt)));
  }
  
  private static SymbolInfo lookup(int paramInt, SymbolShapeHint paramSymbolShapeHint, boolean paramBoolean) {
    return lookup(paramInt, paramSymbolShapeHint, null, null, paramBoolean);
  }
  
  public static SymbolInfo lookup(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    SymbolShapeHint symbolShapeHint;
    if (paramBoolean1) {
      symbolShapeHint = SymbolShapeHint.FORCE_NONE;
    } else {
      symbolShapeHint = SymbolShapeHint.FORCE_SQUARE;
    } 
    return lookup(paramInt, symbolShapeHint, paramBoolean2);
  }
  
  public static void overrideSymbolSet(SymbolInfo[] paramArrayOfSymbolInfo) {
    symbols = paramArrayOfSymbolInfo;
  }
  
  public int getCodewordCount() {
    return this.dataCapacity + this.errorCodewords;
  }
  
  public final int getDataCapacity() {
    return this.dataCapacity;
  }
  
  public int getDataLengthForInterleavedBlock(int paramInt) {
    return this.rsBlockData;
  }
  
  public final int getErrorCodewords() {
    return this.errorCodewords;
  }
  
  public final int getErrorLengthForInterleavedBlock(int paramInt) {
    return this.rsBlockError;
  }
  
  public int getInterleavedBlockCount() {
    return this.dataCapacity / this.rsBlockData;
  }
  
  public final int getSymbolDataHeight() {
    return getVerticalDataRegions() * this.matrixHeight;
  }
  
  public final int getSymbolDataWidth() {
    return getHorizontalDataRegions() * this.matrixWidth;
  }
  
  public final int getSymbolHeight() {
    return getSymbolDataHeight() + (getVerticalDataRegions() << 1);
  }
  
  public final int getSymbolWidth() {
    return getSymbolDataWidth() + (getHorizontalDataRegions() << 1);
  }
  
  public final String toString() {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    if (this.rectangular) {
      str = "Rectangular Symbol:";
    } else {
      str = "Square Symbol:";
    } 
    stringBuilder.append(str);
    stringBuilder.append(" data region ");
    stringBuilder.append(this.matrixWidth);
    stringBuilder.append('x');
    stringBuilder.append(this.matrixHeight);
    stringBuilder.append(", symbol size ");
    stringBuilder.append(getSymbolWidth());
    stringBuilder.append('x');
    stringBuilder.append(getSymbolHeight());
    stringBuilder.append(", symbol data size ");
    stringBuilder.append(getSymbolDataWidth());
    stringBuilder.append('x');
    stringBuilder.append(getSymbolDataHeight());
    stringBuilder.append(", codewords ");
    stringBuilder.append(this.dataCapacity);
    stringBuilder.append('+');
    stringBuilder.append(this.errorCodewords);
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\SymbolInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */