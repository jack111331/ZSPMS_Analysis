package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

final class BoundingBox {
  private final ResultPoint bottomLeft;
  
  private final ResultPoint bottomRight;
  
  private final BitMatrix image;
  
  private final int maxX;
  
  private final int maxY;
  
  private final int minX;
  
  private final int minY;
  
  private final ResultPoint topLeft;
  
  private final ResultPoint topRight;
  
  BoundingBox(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4) throws NotFoundException {
    boolean bool2;
    boolean bool1 = false;
    if (paramResultPoint1 == null || paramResultPoint2 == null) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    if (paramResultPoint3 == null || paramResultPoint4 == null)
      bool1 = true; 
    if (!bool2 || !bool1) {
      ResultPoint resultPoint1;
      ResultPoint resultPoint2;
      if (bool2) {
        resultPoint1 = new ResultPoint(0.0F, paramResultPoint3.getY());
        resultPoint2 = new ResultPoint(0.0F, paramResultPoint4.getY());
      } else {
        resultPoint1 = paramResultPoint1;
        resultPoint2 = paramResultPoint2;
        if (bool1) {
          paramResultPoint3 = new ResultPoint((paramBitMatrix.getWidth() - 1), paramResultPoint1.getY());
          paramResultPoint4 = new ResultPoint((paramBitMatrix.getWidth() - 1), paramResultPoint2.getY());
          resultPoint2 = paramResultPoint2;
          resultPoint1 = paramResultPoint1;
        } 
      } 
      this.image = paramBitMatrix;
      this.topLeft = resultPoint1;
      this.bottomLeft = resultPoint2;
      this.topRight = paramResultPoint3;
      this.bottomRight = paramResultPoint4;
      this.minX = (int)Math.min(resultPoint1.getX(), resultPoint2.getX());
      this.maxX = (int)Math.max(paramResultPoint3.getX(), paramResultPoint4.getX());
      this.minY = (int)Math.min(resultPoint1.getY(), paramResultPoint3.getY());
      this.maxY = (int)Math.max(resultPoint2.getY(), paramResultPoint4.getY());
      return;
    } 
    throw NotFoundException.getNotFoundInstance();
  }
  
  BoundingBox(BoundingBox paramBoundingBox) {
    this.image = paramBoundingBox.image;
    this.topLeft = paramBoundingBox.getTopLeft();
    this.bottomLeft = paramBoundingBox.getBottomLeft();
    this.topRight = paramBoundingBox.getTopRight();
    this.bottomRight = paramBoundingBox.getBottomRight();
    this.minX = paramBoundingBox.getMinX();
    this.maxX = paramBoundingBox.getMaxX();
    this.minY = paramBoundingBox.getMinY();
    this.maxY = paramBoundingBox.getMaxY();
  }
  
  static BoundingBox merge(BoundingBox paramBoundingBox1, BoundingBox paramBoundingBox2) throws NotFoundException {
    return (paramBoundingBox1 == null) ? paramBoundingBox2 : ((paramBoundingBox2 == null) ? paramBoundingBox1 : new BoundingBox(paramBoundingBox1.image, paramBoundingBox1.topLeft, paramBoundingBox1.bottomLeft, paramBoundingBox2.topRight, paramBoundingBox2.bottomRight));
  }
  
  BoundingBox addMissingRows(int paramInt1, int paramInt2, boolean paramBoolean) throws NotFoundException {
    // Byte code:
    //   0: aload_0
    //   1: getfield topLeft : Lcom/google/zxing/ResultPoint;
    //   4: astore #4
    //   6: aload_0
    //   7: getfield bottomLeft : Lcom/google/zxing/ResultPoint;
    //   10: astore #5
    //   12: aload_0
    //   13: getfield topRight : Lcom/google/zxing/ResultPoint;
    //   16: astore #6
    //   18: aload_0
    //   19: getfield bottomRight : Lcom/google/zxing/ResultPoint;
    //   22: astore #7
    //   24: iload_1
    //   25: ifle -> 101
    //   28: iload_3
    //   29: ifeq -> 41
    //   32: aload_0
    //   33: getfield topLeft : Lcom/google/zxing/ResultPoint;
    //   36: astore #8
    //   38: goto -> 47
    //   41: aload_0
    //   42: getfield topRight : Lcom/google/zxing/ResultPoint;
    //   45: astore #8
    //   47: aload #8
    //   49: invokevirtual getY : ()F
    //   52: f2i
    //   53: iload_1
    //   54: isub
    //   55: istore #9
    //   57: iload #9
    //   59: istore_1
    //   60: iload #9
    //   62: ifge -> 67
    //   65: iconst_0
    //   66: istore_1
    //   67: new com/google/zxing/ResultPoint
    //   70: dup
    //   71: aload #8
    //   73: invokevirtual getX : ()F
    //   76: iload_1
    //   77: i2f
    //   78: invokespecial <init> : (FF)V
    //   81: astore #10
    //   83: iload_3
    //   84: ifeq -> 94
    //   87: aload #10
    //   89: astore #4
    //   91: goto -> 101
    //   94: aload #4
    //   96: astore #8
    //   98: goto -> 109
    //   101: aload #6
    //   103: astore #10
    //   105: aload #4
    //   107: astore #8
    //   109: iload_2
    //   110: ifle -> 198
    //   113: iload_3
    //   114: ifeq -> 126
    //   117: aload_0
    //   118: getfield bottomLeft : Lcom/google/zxing/ResultPoint;
    //   121: astore #4
    //   123: goto -> 132
    //   126: aload_0
    //   127: getfield bottomRight : Lcom/google/zxing/ResultPoint;
    //   130: astore #4
    //   132: aload #4
    //   134: invokevirtual getY : ()F
    //   137: f2i
    //   138: iload_2
    //   139: iadd
    //   140: istore_2
    //   141: iload_2
    //   142: istore_1
    //   143: iload_2
    //   144: aload_0
    //   145: getfield image : Lcom/google/zxing/common/BitMatrix;
    //   148: invokevirtual getHeight : ()I
    //   151: if_icmplt -> 164
    //   154: aload_0
    //   155: getfield image : Lcom/google/zxing/common/BitMatrix;
    //   158: invokevirtual getHeight : ()I
    //   161: iconst_1
    //   162: isub
    //   163: istore_1
    //   164: new com/google/zxing/ResultPoint
    //   167: dup
    //   168: aload #4
    //   170: invokevirtual getX : ()F
    //   173: iload_1
    //   174: i2f
    //   175: invokespecial <init> : (FF)V
    //   178: astore #4
    //   180: iload_3
    //   181: ifeq -> 187
    //   184: goto -> 202
    //   187: aload #5
    //   189: astore #7
    //   191: aload #4
    //   193: astore #5
    //   195: goto -> 210
    //   198: aload #5
    //   200: astore #4
    //   202: aload #7
    //   204: astore #5
    //   206: aload #4
    //   208: astore #7
    //   210: new com/google/zxing/pdf417/decoder/BoundingBox
    //   213: dup
    //   214: aload_0
    //   215: getfield image : Lcom/google/zxing/common/BitMatrix;
    //   218: aload #8
    //   220: aload #7
    //   222: aload #10
    //   224: aload #5
    //   226: invokespecial <init> : (Lcom/google/zxing/common/BitMatrix;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)V
    //   229: areturn
  }
  
  ResultPoint getBottomLeft() {
    return this.bottomLeft;
  }
  
  ResultPoint getBottomRight() {
    return this.bottomRight;
  }
  
  int getMaxX() {
    return this.maxX;
  }
  
  int getMaxY() {
    return this.maxY;
  }
  
  int getMinX() {
    return this.minX;
  }
  
  int getMinY() {
    return this.minY;
  }
  
  ResultPoint getTopLeft() {
    return this.topLeft;
  }
  
  ResultPoint getTopRight() {
    return this.topRight;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\pdf417\decoder\BoundingBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */