package android.support.v4.util;

class ContainerHelpers {
  static final int[] EMPTY_INTS = new int[0];
  
  static final long[] EMPTY_LONGS = new long[0];
  
  static final Object[] EMPTY_OBJECTS = new Object[0];
  
  static int binarySearch(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_1
    //   3: iconst_1
    //   4: isub
    //   5: istore #4
    //   7: iload_3
    //   8: istore_1
    //   9: iload_1
    //   10: iload #4
    //   12: if_icmpgt -> 57
    //   15: iload_1
    //   16: iload #4
    //   18: iadd
    //   19: iconst_1
    //   20: iushr
    //   21: istore_3
    //   22: aload_0
    //   23: iload_3
    //   24: iaload
    //   25: istore #5
    //   27: iload #5
    //   29: iload_2
    //   30: if_icmpge -> 40
    //   33: iload_3
    //   34: iconst_1
    //   35: iadd
    //   36: istore_1
    //   37: goto -> 9
    //   40: iload_3
    //   41: istore #4
    //   43: iload #5
    //   45: iload_2
    //   46: if_icmple -> 62
    //   49: iload_3
    //   50: iconst_1
    //   51: isub
    //   52: istore #4
    //   54: goto -> 9
    //   57: iload_1
    //   58: iconst_m1
    //   59: ixor
    //   60: istore #4
    //   62: iload #4
    //   64: ireturn
  }
  
  static int binarySearch(long[] paramArrayOflong, int paramInt, long paramLong) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iload_1
    //   4: iconst_1
    //   5: isub
    //   6: istore #5
    //   8: iload #4
    //   10: istore_1
    //   11: iload #5
    //   13: istore #4
    //   15: iload_1
    //   16: iload #4
    //   18: if_icmpgt -> 70
    //   21: iload_1
    //   22: iload #4
    //   24: iadd
    //   25: iconst_1
    //   26: iushr
    //   27: istore #5
    //   29: aload_0
    //   30: iload #5
    //   32: laload
    //   33: lstore #6
    //   35: lload #6
    //   37: lload_2
    //   38: lcmp
    //   39: ifge -> 50
    //   42: iload #5
    //   44: iconst_1
    //   45: iadd
    //   46: istore_1
    //   47: goto -> 15
    //   50: iload #5
    //   52: istore #4
    //   54: lload #6
    //   56: lload_2
    //   57: lcmp
    //   58: ifle -> 75
    //   61: iload #5
    //   63: iconst_1
    //   64: isub
    //   65: istore #4
    //   67: goto -> 15
    //   70: iload_1
    //   71: iconst_m1
    //   72: ixor
    //   73: istore #4
    //   75: iload #4
    //   77: ireturn
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static int idealByteArraySize(int paramInt) {
    for (byte b = 4;; b++) {
      int i = paramInt;
      if (b < 32) {
        if (paramInt <= (1 << b) - 12)
          return (1 << b) - 12; 
      } else {
        return i;
      } 
    } 
  }
  
  public static int idealIntArraySize(int paramInt) {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public static int idealLongArraySize(int paramInt) {
    return idealByteArraySize(paramInt * 8) / 8;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v\\util\ContainerHelpers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */