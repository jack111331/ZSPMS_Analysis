package com.google.gson.stream;

final class StringPool {
  private final String[] pool = new String[512];
  
  public String get(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: iload_2
    //   4: istore #5
    //   6: iload #5
    //   8: iload_2
    //   9: iload_3
    //   10: iadd
    //   11: if_icmpge -> 32
    //   14: iload #4
    //   16: bipush #31
    //   18: imul
    //   19: aload_1
    //   20: iload #5
    //   22: caload
    //   23: iadd
    //   24: istore #4
    //   26: iinc #5, 1
    //   29: goto -> 6
    //   32: iload #4
    //   34: iload #4
    //   36: bipush #20
    //   38: iushr
    //   39: iload #4
    //   41: bipush #12
    //   43: iushr
    //   44: ixor
    //   45: ixor
    //   46: istore #5
    //   48: iload #5
    //   50: iload #5
    //   52: bipush #7
    //   54: iushr
    //   55: iload #5
    //   57: iconst_4
    //   58: iushr
    //   59: ixor
    //   60: ixor
    //   61: aload_0
    //   62: getfield pool : [Ljava/lang/String;
    //   65: arraylength
    //   66: iconst_1
    //   67: isub
    //   68: iand
    //   69: istore #4
    //   71: aload_0
    //   72: getfield pool : [Ljava/lang/String;
    //   75: iload #4
    //   77: aaload
    //   78: astore #6
    //   80: aload #6
    //   82: ifnull -> 94
    //   85: aload #6
    //   87: invokevirtual length : ()I
    //   90: iload_3
    //   91: if_icmpeq -> 115
    //   94: new java/lang/String
    //   97: dup
    //   98: aload_1
    //   99: iload_2
    //   100: iload_3
    //   101: invokespecial <init> : ([CII)V
    //   104: astore_1
    //   105: aload_0
    //   106: getfield pool : [Ljava/lang/String;
    //   109: iload #4
    //   111: aload_1
    //   112: aastore
    //   113: aload_1
    //   114: areturn
    //   115: iconst_0
    //   116: istore #5
    //   118: iload #5
    //   120: iload_3
    //   121: if_icmpge -> 168
    //   124: aload #6
    //   126: iload #5
    //   128: invokevirtual charAt : (I)C
    //   131: aload_1
    //   132: iload_2
    //   133: iload #5
    //   135: iadd
    //   136: caload
    //   137: if_icmpeq -> 162
    //   140: new java/lang/String
    //   143: dup
    //   144: aload_1
    //   145: iload_2
    //   146: iload_3
    //   147: invokespecial <init> : ([CII)V
    //   150: astore_1
    //   151: aload_0
    //   152: getfield pool : [Ljava/lang/String;
    //   155: iload #4
    //   157: aload_1
    //   158: aastore
    //   159: goto -> 113
    //   162: iinc #5, 1
    //   165: goto -> 118
    //   168: aload #6
    //   170: astore_1
    //   171: goto -> 113
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\google\gson\stream\StringPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */