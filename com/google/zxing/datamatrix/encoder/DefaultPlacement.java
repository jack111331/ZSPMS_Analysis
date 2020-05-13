package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement {
  private final byte[] bits;
  
  private final CharSequence codewords;
  
  private final int numcols;
  
  private final int numrows;
  
  public DefaultPlacement(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    this.codewords = paramCharSequence;
    this.numcols = paramInt1;
    this.numrows = paramInt2;
    this.bits = new byte[paramInt1 * paramInt2];
    Arrays.fill(this.bits, (byte)-1);
  }
  
  private void corner1(int paramInt) {
    module(this.numrows - 1, 0, paramInt, 1);
    module(this.numrows - 1, 1, paramInt, 2);
    module(this.numrows - 1, 2, paramInt, 3);
    module(0, this.numcols - 2, paramInt, 4);
    module(0, this.numcols - 1, paramInt, 5);
    module(1, this.numcols - 1, paramInt, 6);
    module(2, this.numcols - 1, paramInt, 7);
    module(3, this.numcols - 1, paramInt, 8);
  }
  
  private void corner2(int paramInt) {
    module(this.numrows - 3, 0, paramInt, 1);
    module(this.numrows - 2, 0, paramInt, 2);
    module(this.numrows - 1, 0, paramInt, 3);
    module(0, this.numcols - 4, paramInt, 4);
    module(0, this.numcols - 3, paramInt, 5);
    module(0, this.numcols - 2, paramInt, 6);
    module(0, this.numcols - 1, paramInt, 7);
    module(1, this.numcols - 1, paramInt, 8);
  }
  
  private void corner3(int paramInt) {
    module(this.numrows - 3, 0, paramInt, 1);
    module(this.numrows - 2, 0, paramInt, 2);
    module(this.numrows - 1, 0, paramInt, 3);
    module(0, this.numcols - 2, paramInt, 4);
    module(0, this.numcols - 1, paramInt, 5);
    module(1, this.numcols - 1, paramInt, 6);
    module(2, this.numcols - 1, paramInt, 7);
    module(3, this.numcols - 1, paramInt, 8);
  }
  
  private void corner4(int paramInt) {
    module(this.numrows - 1, 0, paramInt, 1);
    module(this.numrows - 1, this.numcols - 1, paramInt, 2);
    module(0, this.numcols - 3, paramInt, 3);
    module(0, this.numcols - 2, paramInt, 4);
    module(0, this.numcols - 1, paramInt, 5);
    module(1, this.numcols - 3, paramInt, 6);
    module(1, this.numcols - 2, paramInt, 7);
    module(1, this.numcols - 1, paramInt, 8);
  }
  
  private boolean hasBit(int paramInt1, int paramInt2) {
    return (this.bits[paramInt2 * this.numcols + paramInt1] >= 0);
  }
  
  private void module(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    int i = paramInt1;
    int j = paramInt2;
    if (paramInt1 < 0) {
      i = paramInt1 + this.numrows;
      j = paramInt2 + 4 - (this.numrows + 4) % 8;
    } 
    paramInt2 = i;
    paramInt1 = j;
    if (j < 0) {
      paramInt1 = j + this.numcols;
      paramInt2 = i + 4 - (this.numcols + 4) % 8;
    } 
    paramInt3 = this.codewords.charAt(paramInt3);
    boolean bool = true;
    if ((paramInt3 & 1 << 8 - paramInt4) == 0)
      bool = false; 
    setBit(paramInt1, paramInt2, bool);
  }
  
  private void setBit(int paramInt1, int paramInt2, boolean paramBoolean) {
    this.bits[paramInt2 * this.numcols + paramInt1] = (byte)(byte)paramBoolean;
  }
  
  private void utah(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt1 - 2;
    int j = paramInt2 - 2;
    module(i, j, paramInt3, 1);
    int k = paramInt2 - 1;
    module(i, k, paramInt3, 2);
    i = paramInt1 - 1;
    module(i, j, paramInt3, 3);
    module(i, k, paramInt3, 4);
    module(i, paramInt2, paramInt3, 5);
    module(paramInt1, j, paramInt3, 6);
    module(paramInt1, k, paramInt3, 7);
    module(paramInt1, paramInt2, paramInt3, 8);
  }
  
  public final boolean getBit(int paramInt1, int paramInt2) {
    return (this.bits[paramInt2 * this.numcols + paramInt1] == 1);
  }
  
  final byte[] getBits() {
    return this.bits;
  }
  
  final int getNumcols() {
    return this.numcols;
  }
  
  final int getNumrows() {
    return this.numrows;
  }
  
  public final void place() {
    int i = 4;
    int j = 0;
    int k = 0;
    while (true) {
      int m = k;
      if (i == this.numrows) {
        m = k;
        if (!j) {
          corner1(k);
          m = k + 1;
        } 
      } 
      int n = m;
      if (i == this.numrows - 2) {
        n = m;
        if (!j) {
          n = m;
          if (this.numcols % 4 != 0) {
            corner2(m);
            n = m + 1;
          } 
        } 
      } 
      k = n;
      if (i == this.numrows - 2) {
        k = n;
        if (!j) {
          k = n;
          if (this.numcols % 8 == 4) {
            corner3(n);
            k = n + 1;
          } 
        } 
      } 
      m = i;
      int i1 = j;
      n = k;
      if (i == this.numrows + 4) {
        m = i;
        i1 = j;
        n = k;
        if (j == 2) {
          m = i;
          i1 = j;
          n = k;
          if (this.numcols % 8 == 0) {
            corner4(k);
            n = k + 1;
            i1 = j;
            m = i;
          } 
        } 
      } 
      while (true) {
        j = n;
        if (m < this.numrows) {
          j = n;
          if (i1 >= 0) {
            j = n;
            if (!hasBit(i1, m)) {
              utah(m, i1, n);
              j = n + 1;
            } 
          } 
        } 
        k = m - 2;
        i = i1 + 2;
        if (k >= 0) {
          m = k;
          i1 = i;
          n = j;
          if (i >= this.numcols)
            break; 
          continue;
        } 
        break;
      } 
      k++;
      n = i + 3;
      i = j;
      j = n;
      while (true) {
        n = i;
        if (k >= 0) {
          n = i;
          if (j < this.numcols) {
            n = i;
            if (!hasBit(j, k)) {
              utah(k, j, i);
              n = i + 1;
            } 
          } 
        } 
        m = k + 2;
        i1 = j - 2;
        if (m < this.numrows) {
          k = m;
          j = i1;
          i = n;
          if (i1 < 0)
            break; 
          continue;
        } 
        break;
      } 
      m += 3;
      i1++;
      i = m;
      j = i1;
      k = n;
      if (m >= this.numrows) {
        i = m;
        j = i1;
        k = n;
        if (i1 >= this.numcols) {
          if (!hasBit(this.numcols - 1, this.numrows - 1)) {
            setBit(this.numcols - 1, this.numrows - 1, true);
            setBit(this.numcols - 2, this.numrows - 2, true);
          } 
          return;
        } 
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\datamatrix\encoder\DefaultPlacement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */