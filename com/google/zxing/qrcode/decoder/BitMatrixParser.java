package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
  private final BitMatrix bitMatrix;
  
  private boolean mirror;
  
  private FormatInformation parsedFormatInfo;
  
  private Version parsedVersion;
  
  BitMatrixParser(BitMatrix paramBitMatrix) throws FormatException {
    int i = paramBitMatrix.getHeight();
    if (i >= 21 && (i & 0x3) == 1) {
      this.bitMatrix = paramBitMatrix;
      return;
    } 
    throw FormatException.getFormatInstance();
  }
  
  private int copyBit(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool;
    if (this.mirror) {
      bool = this.bitMatrix.get(paramInt2, paramInt1);
    } else {
      bool = this.bitMatrix.get(paramInt1, paramInt2);
    } 
    return bool ? (paramInt3 << 1 | 0x1) : (paramInt3 << 1);
  }
  
  void mirror() {
    for (int i = 0; i < this.bitMatrix.getWidth(); i = j) {
      int j = i + 1;
      for (int k = j; k < this.bitMatrix.getHeight(); k++) {
        if (this.bitMatrix.get(i, k) != this.bitMatrix.get(k, i)) {
          this.bitMatrix.flip(k, i);
          this.bitMatrix.flip(i, k);
        } 
      } 
    } 
  }
  
  byte[] readCodewords() throws FormatException {
    FormatInformation formatInformation = readFormatInformation();
    Version version = readVersion();
    DataMask dataMask = DataMask.values()[formatInformation.getDataMask()];
    int i = this.bitMatrix.getHeight();
    dataMask.unmaskBitMatrix(this.bitMatrix, i);
    BitMatrix bitMatrix = version.buildFunctionPattern();
    byte[] arrayOfByte = new byte[version.getTotalCodewords()];
    int j = i - 1;
    int k = j;
    int m = 0;
    int n = 1;
    int i1 = 0;
    int i2 = 0;
    while (k > 0) {
      int i3 = k;
      if (k == 6)
        i3 = k - 1; 
      int i4 = m;
      int i5 = 0;
      k = i2;
      m = i1;
      i1 = i4;
      i2 = i5;
      while (i2 < i) {
        if (n) {
          i5 = j - i2;
        } else {
          i5 = i2;
        } 
        i4 = m;
        m = i1;
        byte b = 0;
        i1 = i4;
        int i6 = k;
        while (b < 2) {
          int i7 = i3 - b;
          int i8 = m;
          k = i6;
          i4 = i1;
          if (!bitMatrix.get(i7, i5)) {
            k = i6 + 1;
            i1 <<= 1;
            if (this.bitMatrix.get(i7, i5))
              i1 |= 0x1; 
            if (k == 8) {
              arrayOfByte[m] = (byte)(byte)i1;
              i8 = m + 1;
              k = 0;
              i4 = 0;
            } else {
              i4 = i1;
              i8 = m;
            } 
          } 
          b++;
          m = i8;
          i6 = k;
          i1 = i4;
        } 
        i2++;
        k = m;
        m = i1;
        i1 = k;
        k = i6;
      } 
      n ^= 0x1;
      i3 -= 2;
      i4 = i1;
      i1 = m;
      i2 = k;
      k = i3;
      m = i4;
    } 
    if (m == version.getTotalCodewords())
      return arrayOfByte; 
    throw FormatException.getFormatInstance();
  }
  
  FormatInformation readFormatInformation() throws FormatException {
    if (this.parsedFormatInfo != null)
      return this.parsedFormatInfo; 
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < 6) {
      j = copyBit(i, 8, j);
      i++;
    } 
    i = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, j)));
    for (j = 5; j >= 0; j--)
      i = copyBit(8, j, i); 
    int k = this.bitMatrix.getHeight();
    int m = k - 1;
    j = bool;
    while (m >= k - 7) {
      j = copyBit(8, m, j);
      m--;
    } 
    for (m = k - 8; m < k; m++)
      j = copyBit(m, 8, j); 
    this.parsedFormatInfo = FormatInformation.decodeFormatInformation(i, j);
    if (this.parsedFormatInfo != null)
      return this.parsedFormatInfo; 
    throw FormatException.getFormatInstance();
  }
  
  Version readVersion() throws FormatException {
    if (this.parsedVersion != null)
      return this.parsedVersion; 
    int i = this.bitMatrix.getHeight();
    int j = (i - 17) / 4;
    if (j <= 6)
      return Version.getVersionForNumber(j); 
    int k = i - 11;
    byte b = 5;
    boolean bool = false;
    j = 5;
    int m = 0;
    while (j >= 0) {
      for (int n = i - 9; n >= k; n--)
        m = copyBit(n, j, m); 
      j--;
    } 
    Version version = Version.decodeVersionInformation(m);
    j = b;
    m = bool;
    if (version != null) {
      j = b;
      m = bool;
      if (version.getDimensionForVersion() == i) {
        this.parsedVersion = version;
        return version;
      } 
    } 
    while (j >= 0) {
      for (int n = i - 9; n >= k; n--)
        m = copyBit(j, n, m); 
      j--;
    } 
    version = Version.decodeVersionInformation(m);
    if (version != null && version.getDimensionForVersion() == i) {
      this.parsedVersion = version;
      return version;
    } 
    throw FormatException.getFormatInstance();
  }
  
  void remask() {
    if (this.parsedFormatInfo == null)
      return; 
    DataMask dataMask = DataMask.values()[this.parsedFormatInfo.getDataMask()];
    int i = this.bitMatrix.getHeight();
    dataMask.unmaskBitMatrix(this.bitMatrix, i);
  }
  
  void setMirror(boolean paramBoolean) {
    this.parsedVersion = null;
    this.parsedFormatInfo = null;
    this.mirror = paramBoolean;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\BitMatrixParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */