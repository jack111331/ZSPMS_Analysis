package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser {
  private final BitMatrix mappingBitMatrix;
  
  private final BitMatrix readMappingMatrix;
  
  private final Version version;
  
  BitMatrixParser(BitMatrix paramBitMatrix) throws FormatException {
    int i = paramBitMatrix.getHeight();
    if (i >= 8 && i <= 144 && (i & 0x1) == 0) {
      this.version = readVersion(paramBitMatrix);
      this.mappingBitMatrix = extractDataRegion(paramBitMatrix);
      this.readMappingMatrix = new BitMatrix(this.mappingBitMatrix.getWidth(), this.mappingBitMatrix.getHeight());
      return;
    } 
    throw FormatException.getFormatInstance();
  }
  
  private BitMatrix extractDataRegion(BitMatrix paramBitMatrix) {
    int i = this.version.getSymbolSizeRows();
    int j = this.version.getSymbolSizeColumns();
    if (paramBitMatrix.getHeight() == i) {
      int k = this.version.getDataRegionSizeRows();
      int m = this.version.getDataRegionSizeColumns();
      int n = i / k;
      int i1 = j / m;
      BitMatrix bitMatrix = new BitMatrix(i1 * m, n * k);
      for (j = 0; j < n; j++) {
        for (i = 0; i < i1; i++) {
          for (byte b = 0; b < k; b++) {
            for (byte b1 = 0; b1 < m; b1++) {
              if (paramBitMatrix.get((m + 2) * i + 1 + b1, (k + 2) * j + 1 + b))
                bitMatrix.set(i * m + b1, j * k + b); 
            } 
          } 
        } 
      } 
      return bitMatrix;
    } 
    throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
  }
  
  private int readCorner1(int paramInt1, int paramInt2) {
    int i = paramInt1 - 1;
    int j = readModule(i, 0, paramInt1, paramInt2) << 1;
    int k = j;
    if (readModule(i, 1, paramInt1, paramInt2))
      k = j | 0x1; 
    j = k << 1;
    k = j;
    if (readModule(i, 2, paramInt1, paramInt2))
      k = j | 0x1; 
    j = k << 1;
    k = j;
    if (readModule(0, paramInt2 - 2, paramInt1, paramInt2))
      k = j | 0x1; 
    j = k << 1;
    i = paramInt2 - 1;
    k = j;
    if (readModule(0, i, paramInt1, paramInt2))
      k = j | 0x1; 
    j = k << 1;
    k = j;
    if (readModule(1, i, paramInt1, paramInt2))
      k = j | 0x1; 
    j = k << 1;
    k = j;
    if (readModule(2, i, paramInt1, paramInt2))
      k = j | 0x1; 
    j = k << 1;
    k = j;
    if (readModule(3, i, paramInt1, paramInt2))
      k = j | 0x1; 
    return k;
  }
  
  private int readCorner2(int paramInt1, int paramInt2) {
    int i = readModule(paramInt1 - 3, 0, paramInt1, paramInt2) << 1;
    int j = i;
    if (readModule(paramInt1 - 2, 0, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(paramInt1 - 1, 0, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(0, paramInt2 - 4, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(0, paramInt2 - 3, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(0, paramInt2 - 2, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    int k = paramInt2 - 1;
    j = i;
    if (readModule(0, k, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(1, k, paramInt1, paramInt2))
      j = i | 0x1; 
    return j;
  }
  
  private int readCorner3(int paramInt1, int paramInt2) {
    int i = paramInt1 - 1;
    int j = readModule(i, 0, paramInt1, paramInt2) << 1;
    int k = paramInt2 - 1;
    int m = j;
    if (readModule(i, k, paramInt1, paramInt2))
      m = j | 0x1; 
    j = m << 1;
    i = paramInt2 - 3;
    m = j;
    if (readModule(0, i, paramInt1, paramInt2))
      m = j | 0x1; 
    j = m << 1;
    int n = paramInt2 - 2;
    m = j;
    if (readModule(0, n, paramInt1, paramInt2))
      m = j | 0x1; 
    j = m << 1;
    m = j;
    if (readModule(0, k, paramInt1, paramInt2))
      m = j | 0x1; 
    j = m << 1;
    m = j;
    if (readModule(1, i, paramInt1, paramInt2))
      m = j | 0x1; 
    j = m << 1;
    m = j;
    if (readModule(1, n, paramInt1, paramInt2))
      m = j | 0x1; 
    j = m << 1;
    m = j;
    if (readModule(1, k, paramInt1, paramInt2))
      m = j | 0x1; 
    return m;
  }
  
  private int readCorner4(int paramInt1, int paramInt2) {
    int i = readModule(paramInt1 - 3, 0, paramInt1, paramInt2) << 1;
    int j = i;
    if (readModule(paramInt1 - 2, 0, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(paramInt1 - 1, 0, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(0, paramInt2 - 2, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    int k = paramInt2 - 1;
    j = i;
    if (readModule(0, k, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(1, k, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(2, k, paramInt1, paramInt2))
      j = i | 0x1; 
    i = j << 1;
    j = i;
    if (readModule(3, k, paramInt1, paramInt2))
      j = i | 0x1; 
    return j;
  }
  
  private boolean readModule(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt1 < 0) {
      i = paramInt1 + paramInt3;
      j = paramInt2 + 4 - (paramInt3 + 4 & 0x7);
    } 
    paramInt2 = i;
    paramInt1 = j;
    if (j < 0) {
      paramInt1 = j + paramInt4;
      paramInt2 = i + 4 - (paramInt4 + 4 & 0x7);
    } 
    this.readMappingMatrix.set(paramInt1, paramInt2);
    return this.mappingBitMatrix.get(paramInt1, paramInt2);
  }
  
  private int readUtah(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = paramInt1 - 2;
    int j = paramInt2 - 2;
    int k = readModule(i, j, paramInt3, paramInt4) << 1;
    int m = paramInt2 - 1;
    int n = k;
    if (readModule(i, m, paramInt3, paramInt4))
      n = k | 0x1; 
    k = n << 1;
    i = paramInt1 - 1;
    n = k;
    if (readModule(i, j, paramInt3, paramInt4))
      n = k | 0x1; 
    k = n << 1;
    n = k;
    if (readModule(i, m, paramInt3, paramInt4))
      n = k | 0x1; 
    k = n << 1;
    n = k;
    if (readModule(i, paramInt2, paramInt3, paramInt4))
      n = k | 0x1; 
    k = n << 1;
    n = k;
    if (readModule(paramInt1, j, paramInt3, paramInt4))
      n = k | 0x1; 
    k = n << 1;
    n = k;
    if (readModule(paramInt1, m, paramInt3, paramInt4))
      n = k | 0x1; 
    k = n << 1;
    n = k;
    if (readModule(paramInt1, paramInt2, paramInt3, paramInt4))
      n = k | 0x1; 
    return n;
  }
  
  private static Version readVersion(BitMatrix paramBitMatrix) throws FormatException {
    return Version.getVersionForDimensions(paramBitMatrix.getHeight(), paramBitMatrix.getWidth());
  }
  
  Version getVersion() {
    return this.version;
  }
  
  byte[] readCodewords() throws FormatException {
    Object object1;
    Object object2;
    Object object3;
    Object object4;
    Object object5;
    Object object6;
    Object object7;
    byte[] arrayOfByte = new byte[this.version.getTotalCodewords()];
    int i = this.mappingBitMatrix.getHeight();
    int j = this.mappingBitMatrix.getWidth();
    byte b = 4;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    while (true) {
      int k;
      int m;
      if (object1 == i && object2 == null && object3 == null) {
        arrayOfByte[object4] = (byte)(byte)readCorner1(i, j);
        int i4 = object1 - 2;
        i2 = object2 + 2;
        i3 = object4 + 1;
        boolean bool = true;
        Object object14 = object5;
        Object object15 = object6;
        Object object16 = object7;
        continue;
      } 
      int i1 = i - 2;
      if (object1 == i1 && object2 == null && (j & 0x3) != 0 && object5 == null) {
        arrayOfByte[object4] = (byte)(byte)readCorner2(i, j);
        i1 = object1 - 2;
        i2 = object2 + 2;
        i3 = object4 + 1;
        boolean bool = true;
        Object object14 = object3;
        Object object15 = object6;
        Object object16 = object7;
        continue;
      } 
      if (object1 == i + 4 && object2 == 2 && (j & 0x7) == 0 && object6 == null) {
        arrayOfByte[object4] = (byte)(byte)readCorner3(i, j);
        i1 = object1 - 2;
        i2 = object2 + 2;
        i3 = object4 + 1;
        boolean bool = true;
        Object object14 = object3;
        Object object15 = object5;
        Object object16 = object7;
        continue;
      } 
      Object object8 = object1;
      Object object9 = object2;
      Object object10 = object4;
      if (object1 == i1) {
        object8 = object1;
        object9 = object2;
        object10 = object4;
        if (object2 == null) {
          object8 = object1;
          object9 = object2;
          object10 = object4;
          if ((j & 0x7) == 4) {
            object8 = object1;
            object9 = object2;
            object10 = object4;
            if (object7 == null) {
              arrayOfByte[object4] = (byte)(byte)readCorner4(i, j);
              i1 = object1 - 2;
              i2 = object2 + 2;
              i3 = object4 + 1;
              boolean bool = true;
              object10 = object3;
              Object object14 = object5;
              Object object15 = object6;
              continue;
            } 
          } 
        } 
      } 
      while (true) {
        Object object = object10;
        if (i2 < i) {
          object = object10;
          if (i3 >= 0) {
            object = object10;
            if (!this.readMappingMatrix.get(i3, i2)) {
              arrayOfByte[object10] = (byte)(byte)readUtah(i2, i3, i, j);
              i1 = object10 + 1;
            } 
          } 
        } 
        m = i2 - 2;
        n = i3 + 2;
        if (m >= 0) {
          i2 = m;
          i3 = n;
          int i4 = i1;
          if (n >= j)
            break; 
          continue;
        } 
        break;
      } 
      int i3 = m + 1;
      int i2 = n + 3;
      int n = i3;
      while (true) {
        i3 = i1;
        if (n >= 0) {
          i3 = i1;
          if (i2 < j) {
            i3 = i1;
            if (!this.readMappingMatrix.get(i2, n)) {
              arrayOfByte[i1] = (byte)(byte)readUtah(n, i2, i, j);
              i3 = i1 + 1;
            } 
          } 
        } 
        k = n + 2;
        m = i2 - 2;
        if (k < i) {
          n = k;
          i2 = m;
          i1 = i3;
          if (m < 0)
            break; 
          continue;
        } 
        break;
      } 
      i1 = k + 3;
      i2 = m + 1;
      Object object13 = object7;
      Object object12 = object6;
      Object object11 = object5;
      object10 = object3;
      continue;
      object1 = SYNTHETIC_LOCAL_VARIABLE_11;
      object2 = SYNTHETIC_LOCAL_VARIABLE_12;
      object3 = SYNTHETIC_LOCAL_VARIABLE_14;
      object4 = SYNTHETIC_LOCAL_VARIABLE_13;
      object5 = SYNTHETIC_LOCAL_VARIABLE_15;
      object6 = SYNTHETIC_LOCAL_VARIABLE_16;
      object7 = SYNTHETIC_LOCAL_VARIABLE_17;
      if (SYNTHETIC_LOCAL_VARIABLE_11 >= i) {
        object1 = SYNTHETIC_LOCAL_VARIABLE_11;
        object2 = SYNTHETIC_LOCAL_VARIABLE_12;
        object3 = SYNTHETIC_LOCAL_VARIABLE_14;
        object4 = SYNTHETIC_LOCAL_VARIABLE_13;
        object5 = SYNTHETIC_LOCAL_VARIABLE_15;
        object6 = SYNTHETIC_LOCAL_VARIABLE_16;
        object7 = SYNTHETIC_LOCAL_VARIABLE_17;
        if (SYNTHETIC_LOCAL_VARIABLE_12 >= j) {
          if (SYNTHETIC_LOCAL_VARIABLE_13 == this.version.getTotalCodewords())
            return arrayOfByte; 
          throw FormatException.getFormatInstance();
        } 
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\decoder\BitMatrixParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */