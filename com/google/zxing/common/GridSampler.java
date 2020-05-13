package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler {
  private static GridSampler gridSampler = new DefaultGridSampler();
  
  protected static void checkAndNudgePoints(BitMatrix paramBitMatrix, float[] paramArrayOffloat) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getWidth : ()I
    //   4: istore_2
    //   5: aload_0
    //   6: invokevirtual getHeight : ()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore #4
    //   13: iconst_1
    //   14: istore #5
    //   16: iload #4
    //   18: aload_1
    //   19: arraylength
    //   20: if_icmpge -> 153
    //   23: iload #5
    //   25: ifeq -> 153
    //   28: aload_1
    //   29: iload #4
    //   31: faload
    //   32: f2i
    //   33: istore #5
    //   35: iload #4
    //   37: iconst_1
    //   38: iadd
    //   39: istore #6
    //   41: aload_1
    //   42: iload #6
    //   44: faload
    //   45: f2i
    //   46: istore #7
    //   48: iload #5
    //   50: iconst_m1
    //   51: if_icmplt -> 149
    //   54: iload #5
    //   56: iload_2
    //   57: if_icmpgt -> 149
    //   60: iload #7
    //   62: iconst_m1
    //   63: if_icmplt -> 149
    //   66: iload #7
    //   68: iload_3
    //   69: if_icmpgt -> 149
    //   72: iload #5
    //   74: iconst_m1
    //   75: if_icmpne -> 89
    //   78: aload_1
    //   79: iload #4
    //   81: fconst_0
    //   82: fastore
    //   83: iconst_1
    //   84: istore #5
    //   86: goto -> 109
    //   89: iload #5
    //   91: iload_2
    //   92: if_icmpne -> 106
    //   95: aload_1
    //   96: iload #4
    //   98: iload_2
    //   99: iconst_1
    //   100: isub
    //   101: i2f
    //   102: fastore
    //   103: goto -> 83
    //   106: iconst_0
    //   107: istore #5
    //   109: iload #7
    //   111: iconst_m1
    //   112: if_icmpne -> 126
    //   115: aload_1
    //   116: iload #6
    //   118: fconst_0
    //   119: fastore
    //   120: iconst_1
    //   121: istore #5
    //   123: goto -> 143
    //   126: iload #7
    //   128: iload_3
    //   129: if_icmpne -> 143
    //   132: aload_1
    //   133: iload #6
    //   135: iload_3
    //   136: iconst_1
    //   137: isub
    //   138: i2f
    //   139: fastore
    //   140: goto -> 120
    //   143: iinc #4, 2
    //   146: goto -> 16
    //   149: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   152: athrow
    //   153: aload_1
    //   154: arraylength
    //   155: iconst_2
    //   156: isub
    //   157: istore #4
    //   159: iconst_1
    //   160: istore #5
    //   162: iload #4
    //   164: iflt -> 297
    //   167: iload #5
    //   169: ifeq -> 297
    //   172: aload_1
    //   173: iload #4
    //   175: faload
    //   176: f2i
    //   177: istore #5
    //   179: iload #4
    //   181: iconst_1
    //   182: iadd
    //   183: istore #7
    //   185: aload_1
    //   186: iload #7
    //   188: faload
    //   189: f2i
    //   190: istore #6
    //   192: iload #5
    //   194: iconst_m1
    //   195: if_icmplt -> 293
    //   198: iload #5
    //   200: iload_2
    //   201: if_icmpgt -> 293
    //   204: iload #6
    //   206: iconst_m1
    //   207: if_icmplt -> 293
    //   210: iload #6
    //   212: iload_3
    //   213: if_icmpgt -> 293
    //   216: iload #5
    //   218: iconst_m1
    //   219: if_icmpne -> 233
    //   222: aload_1
    //   223: iload #4
    //   225: fconst_0
    //   226: fastore
    //   227: iconst_1
    //   228: istore #5
    //   230: goto -> 253
    //   233: iload #5
    //   235: iload_2
    //   236: if_icmpne -> 250
    //   239: aload_1
    //   240: iload #4
    //   242: iload_2
    //   243: iconst_1
    //   244: isub
    //   245: i2f
    //   246: fastore
    //   247: goto -> 227
    //   250: iconst_0
    //   251: istore #5
    //   253: iload #6
    //   255: iconst_m1
    //   256: if_icmpne -> 270
    //   259: aload_1
    //   260: iload #7
    //   262: fconst_0
    //   263: fastore
    //   264: iconst_1
    //   265: istore #5
    //   267: goto -> 287
    //   270: iload #6
    //   272: iload_3
    //   273: if_icmpne -> 287
    //   276: aload_1
    //   277: iload #7
    //   279: iload_3
    //   280: iconst_1
    //   281: isub
    //   282: i2f
    //   283: fastore
    //   284: goto -> 264
    //   287: iinc #4, -2
    //   290: goto -> 162
    //   293: invokestatic getNotFoundInstance : ()Lcom/google/zxing/NotFoundException;
    //   296: athrow
    //   297: return
  }
  
  public static GridSampler getInstance() {
    return gridSampler;
  }
  
  public static void setGridSampler(GridSampler paramGridSampler) {
    gridSampler = paramGridSampler;
  }
  
  public abstract BitMatrix sampleGrid(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, float paramFloat10, float paramFloat11, float paramFloat12, float paramFloat13, float paramFloat14, float paramFloat15, float paramFloat16) throws NotFoundException;
  
  public abstract BitMatrix sampleGrid(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, PerspectiveTransform paramPerspectiveTransform) throws NotFoundException;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\common\GridSampler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */