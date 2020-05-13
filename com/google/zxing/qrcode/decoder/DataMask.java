package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

enum DataMask {
  DATA_MASK_000 {
    boolean isMasked(int param1Int1, int param1Int2) {
      return ((param1Int1 + param1Int2 & 0x1) == 0);
    }
  },
  DATA_MASK_001 {
    boolean isMasked(int param1Int1, int param1Int2) {
      return ((param1Int1 & 0x1) == 0);
    }
  },
  DATA_MASK_010 {
    boolean isMasked(int param1Int1, int param1Int2) {
      return (param1Int2 % 3 == 0);
    }
  },
  DATA_MASK_011 {
    boolean isMasked(int param1Int1, int param1Int2) {
      return ((param1Int1 + param1Int2) % 3 == 0);
    }
  },
  DATA_MASK_100 {
    boolean isMasked(int param1Int1, int param1Int2) {
      return ((param1Int1 / 2 + param1Int2 / 3 & 0x1) == 0);
    }
  },
  DATA_MASK_101 {
    boolean isMasked(int param1Int1, int param1Int2) {
      return (param1Int1 * param1Int2 % 6 == 0);
    }
  },
  DATA_MASK_110 {
    boolean isMasked(int param1Int1, int param1Int2) {
      return (param1Int1 * param1Int2 % 6 < 3);
    }
  },
  DATA_MASK_111 {
    boolean isMasked(int param1Int1, int param1Int2) {
      return ((param1Int1 + param1Int2 + param1Int1 * param1Int2 % 3 & 0x1) == 0);
    }
  };
  
  static {
    $VALUES = new DataMask[] { DATA_MASK_000, DATA_MASK_001, DATA_MASK_010, DATA_MASK_011, DATA_MASK_100, DATA_MASK_101, DATA_MASK_110, DATA_MASK_111 };
  }
  
  abstract boolean isMasked(int paramInt1, int paramInt2);
  
  final void unmaskBitMatrix(BitMatrix paramBitMatrix, int paramInt) {
    for (byte b = 0; b < paramInt; b++) {
      for (byte b1 = 0; b1 < paramInt; b1++) {
        if (isMasked(b, b1))
          paramBitMatrix.flip(b1, b); 
      } 
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\qrcode\decoder\DataMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */