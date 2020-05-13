package com.google.zxing.oned.rss;

public final class RSSUtils {
  private static int combins(int paramInt1, int paramInt2) {
    int n;
    int i = paramInt1 - paramInt2;
    int j = i;
    int k = paramInt2;
    if (i > paramInt2) {
      k = i;
      j = paramInt2;
    } 
    paramInt2 = 1;
    int m = 1;
    i = paramInt1;
    paramInt1 = m;
    while (true) {
      m = paramInt2;
      n = paramInt1;
      if (i > k) {
        n = paramInt2 * i;
        paramInt2 = n;
        m = paramInt1;
        if (paramInt1 <= j) {
          paramInt2 = n / paramInt1;
          m = paramInt1 + 1;
        } 
        i--;
        paramInt1 = m;
        continue;
      } 
      break;
    } 
    while (n <= j) {
      m /= n;
      n++;
    } 
    return m;
  }
  
  public static int getRSSvalue(int[] paramArrayOfint, int paramInt, boolean paramBoolean) {
    int[] arrayOfInt = paramArrayOfint;
    int i = arrayOfInt.length;
    int j = 0;
    int k = 0;
    while (j < i) {
      k += arrayOfInt[j];
      j++;
    } 
    int m = arrayOfInt.length;
    byte b = 0;
    j = 0;
    int n = 0;
    int i1 = k;
    k = j;
    while (true) {
      int i2 = m - 1;
      if (b < i2) {
        int i3 = 1 << b;
        k |= i3;
        byte b1 = 1;
        while (b1 < paramArrayOfint[b]) {
          int i4 = i1 - b1;
          int i5 = m - b;
          int i6 = i5 - 2;
          i = combins(i4 - 1, i6);
          j = i;
          if (paramBoolean) {
            j = i;
            if (k == 0) {
              int i7 = i5 - 1;
              j = i;
              if (i4 - i7 >= i7)
                j = i - combins(i4 - i5, i6); 
            } 
          } 
          if (i5 - 1 > 1) {
            i6 = i4 - i6;
            i = 0;
            while (i6 > paramInt) {
              i += combins(i4 - i6 - 1, i5 - 3);
              i6--;
            } 
            i = j - i * (i2 - b);
          } else {
            i = j;
            if (i4 > paramInt)
              i = j - 1; 
          } 
          n += i;
          b1++;
          k &= i3 ^ 0xFFFFFFFF;
        } 
        i1 -= b1;
        b++;
        continue;
      } 
      return n;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\oned\rss\RSSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */