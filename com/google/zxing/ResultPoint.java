package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

public class ResultPoint {
  private final float x;
  
  private final float y;
  
  public ResultPoint(float paramFloat1, float paramFloat2) {
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  private static float crossProductZ(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3) {
    float f1 = paramResultPoint2.x;
    float f2 = paramResultPoint2.y;
    return (paramResultPoint3.x - f1) * (paramResultPoint1.y - f2) - (paramResultPoint3.y - f2) * (paramResultPoint1.x - f1);
  }
  
  public static float distance(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2) {
    return MathUtils.distance(paramResultPoint1.x, paramResultPoint1.y, paramResultPoint2.x, paramResultPoint2.y);
  }
  
  public static void orderBestPatterns(ResultPoint[] paramArrayOfResultPoint) {
    ResultPoint resultPoint1;
    ResultPoint resultPoint2;
    ResultPoint resultPoint3;
    float f1 = distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[1]);
    float f2 = distance(paramArrayOfResultPoint[1], paramArrayOfResultPoint[2]);
    float f3 = distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[2]);
    if (f2 >= f1 && f2 >= f3) {
      resultPoint1 = paramArrayOfResultPoint[0];
      resultPoint2 = paramArrayOfResultPoint[1];
      resultPoint3 = paramArrayOfResultPoint[2];
    } else if (f3 >= f2 && f3 >= f1) {
      resultPoint1 = paramArrayOfResultPoint[1];
      resultPoint2 = paramArrayOfResultPoint[0];
      resultPoint3 = paramArrayOfResultPoint[2];
    } else {
      resultPoint1 = paramArrayOfResultPoint[2];
      resultPoint2 = paramArrayOfResultPoint[0];
      resultPoint3 = paramArrayOfResultPoint[1];
    } 
    ResultPoint resultPoint4 = resultPoint2;
    ResultPoint resultPoint5 = resultPoint3;
    if (crossProductZ(resultPoint2, resultPoint1, resultPoint3) < 0.0F) {
      resultPoint5 = resultPoint2;
      resultPoint4 = resultPoint3;
    } 
    paramArrayOfResultPoint[0] = resultPoint4;
    paramArrayOfResultPoint[1] = resultPoint1;
    paramArrayOfResultPoint[2] = resultPoint5;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject instanceof ResultPoint) {
      paramObject = paramObject;
      return (this.x == ((ResultPoint)paramObject).x && this.y == ((ResultPoint)paramObject).y);
    } 
    return false;
  }
  
  public final float getX() {
    return this.x;
  }
  
  public final float getY() {
    return this.y;
  }
  
  public final int hashCode() {
    return Float.floatToIntBits(this.x) * 31 + Float.floatToIntBits(this.y);
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("(");
    stringBuilder.append(this.x);
    stringBuilder.append(',');
    stringBuilder.append(this.y);
    stringBuilder.append(')');
    return stringBuilder.toString();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\zxing\ResultPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */