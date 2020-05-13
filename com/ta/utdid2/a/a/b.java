package com.ta.utdid2.a.a;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;

public class b {
  static {
    boolean bool;
    if (!b.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
  
  public static byte[] decode(String paramString, int paramInt) {
    return decode(paramString.getBytes(), paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt) {
    return decode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  public static byte[] decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    b b1 = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!b1.process(paramArrayOfbyte, paramInt1, paramInt2, true))
      throw new IllegalArgumentException("bad base-64"); 
    if (b1.op == b1.output.length)
      return b1.output; 
    paramArrayOfbyte = new byte[b1.op];
    System.arraycopy(b1.output, 0, paramArrayOfbyte, 0, b1.op);
    return paramArrayOfbyte;
  }
  
  public static byte[] encode(byte[] paramArrayOfbyte, int paramInt) {
    return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramInt);
  }
  
  @SuppressLint({"Assert"})
  public static byte[] encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    c c = new c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    if (c.do_padding) {
      paramInt3 = i;
      if (paramInt2 % 3 > 0)
        paramInt3 = i + 4; 
    } 
    paramInt3 = i;
    switch (paramInt2 % 3) {
      case 0:
        i = paramInt3;
        if (c.do_newline) {
          i = paramInt3;
          if (paramInt2 > 0) {
            int j = (paramInt2 - 1) / 57;
            if (c.do_cr) {
              i = 2;
            } else {
              break;
            } 
            i = paramInt3 + i * (j + 1);
          } 
        } 
        c.output = new byte[i];
        c.process(paramArrayOfbyte, paramInt1, paramInt2, true);
        if (!a && c.op != i)
          throw new AssertionError(); 
        return c.output;
      default:
        paramInt3 = i;
      case 1:
        paramInt3 = i + 2;
      case 2:
        paramInt3 = i + 3;
    } 
    i = 1;
  }
  
  public static String encodeToString(byte[] paramArrayOfbyte, int paramInt) {
    try {
      return new String(encode(paramArrayOfbyte, paramInt), "US-ASCII");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  static abstract class a {
    public int op;
    
    public byte[] output;
  }
  
  static class b extends a {
    private static final int[] a = new int[] { 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1 };
    
    private static final int[] b = new int[] { 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1 };
    
    private final int[] c;
    
    private int state;
    
    private int value;
    
    public b(int param1Int, byte[] param1ArrayOfbyte) {
      int[] arrayOfInt;
      this.output = param1ArrayOfbyte;
      if ((param1Int & 0x8) == 0) {
        arrayOfInt = a;
      } else {
        arrayOfInt = b;
      } 
      this.c = arrayOfInt;
      this.state = 0;
      this.value = 0;
    }
    
    public boolean process(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      int m;
      int n;
      if (this.state == 6)
        return false; 
      int i = param1Int2 + param1Int1;
      param1Int2 = this.state;
      int j = this.value;
      int k = 0;
      byte[] arrayOfByte = this.output;
      int[] arrayOfInt = this.c;
      while (true) {
        m = k;
        n = j;
        if (param1Int1 < i) {
          m = k;
          int i1 = j;
          n = param1Int1;
          if (param1Int2 == 0) {
            i1 = param1Int1;
            param1Int1 = j;
            while (i1 + 4 <= i) {
              j = arrayOfInt[param1ArrayOfbyte[i1] & 0xFF] << 18 | arrayOfInt[param1ArrayOfbyte[i1 + 1] & 0xFF] << 12 | arrayOfInt[param1ArrayOfbyte[i1 + 2] & 0xFF] << 6 | arrayOfInt[param1ArrayOfbyte[i1 + 3] & 0xFF];
              param1Int1 = j;
              if (j >= 0) {
                arrayOfByte[k + 2] = (byte)(byte)j;
                arrayOfByte[k + 1] = (byte)(byte)(j >> 8);
                arrayOfByte[k] = (byte)(byte)(j >> 16);
                k += 3;
                i1 += 4;
                param1Int1 = j;
              } 
            } 
            m = k;
            n = param1Int1;
            if (i1 < i) {
              n = i1;
              i1 = param1Int1;
              m = k;
            } else {
              break;
            } 
          } 
          param1Int1 = n + 1;
          j = arrayOfInt[param1ArrayOfbyte[n] & 0xFF];
          switch (param1Int2) {
            case 0:
              if (j >= 0) {
                param1Int2++;
                k = m;
                break;
              } 
              if (j != -1) {
                this.state = 6;
                return false;
              } 
              k = m;
              j = i1;
              break;
            case 1:
              if (j >= 0) {
                j = i1 << 6 | j;
                param1Int2++;
                k = m;
                break;
              } 
              if (j != -1) {
                this.state = 6;
                return false;
              } 
              k = m;
              j = i1;
              break;
            case 2:
              if (j >= 0) {
                j = i1 << 6 | j;
                param1Int2++;
                k = m;
                break;
              } 
              if (j == -2) {
                arrayOfByte[m] = (byte)(byte)(i1 >> 4);
                param1Int2 = 4;
                k = m + 1;
                j = i1;
                break;
              } 
              if (j != -1) {
                this.state = 6;
                return false;
              } 
              k = m;
              j = i1;
              break;
            case 3:
              if (j >= 0) {
                j = i1 << 6 | j;
                arrayOfByte[m + 2] = (byte)(byte)j;
                arrayOfByte[m + 1] = (byte)(byte)(j >> 8);
                arrayOfByte[m] = (byte)(byte)(j >> 16);
                k = m + 3;
                param1Int2 = 0;
                break;
              } 
              if (j == -2) {
                arrayOfByte[m + 1] = (byte)(byte)(i1 >> 2);
                arrayOfByte[m] = (byte)(byte)(i1 >> 10);
                k = m + 2;
                param1Int2 = 5;
                j = i1;
                break;
              } 
              if (j != -1) {
                this.state = 6;
                return false;
              } 
              k = m;
              j = i1;
              break;
            case 4:
              if (j == -2) {
                param1Int2++;
                k = m;
                j = i1;
                break;
              } 
              if (j != -1) {
                this.state = 6;
                return false;
              } 
              k = m;
              j = i1;
              break;
            case 5:
              if (j != -1) {
                this.state = 6;
                return false;
              } 
              k = m;
              j = i1;
              break;
          } 
          continue;
        } 
        break;
      } 
      if (!param1Boolean) {
        this.state = param1Int2;
        this.value = n;
        this.op = m;
        return true;
      } 
      param1Int1 = m;
      switch (param1Int2) {
        default:
          param1Int1 = m;
        case 0:
          this.state = param1Int2;
          this.op = param1Int1;
          return true;
        case 1:
          this.state = 6;
          return false;
        case 2:
          arrayOfByte[m] = (byte)(byte)(n >> 4);
          param1Int1 = m + 1;
        case 3:
          j = m + 1;
          arrayOfByte[m] = (byte)(byte)(n >> 10);
          param1Int1 = j + 1;
          arrayOfByte[j] = (byte)(byte)(n >> 2);
        case 4:
          break;
      } 
      this.state = 6;
      return false;
    }
  }
  
  static class c extends a {
    private static final byte[] a = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 43, 47 };
    
    private static final byte[] b = new byte[] { 
        65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
        75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
        85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
        101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
        111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
        121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
        56, 57, 45, 95 };
    
    int a;
    
    private final byte[] c;
    
    private int count;
    
    private final byte[] d;
    
    public final boolean do_cr;
    
    public final boolean do_newline;
    
    public final boolean do_padding;
    
    public c(int param1Int, byte[] param1ArrayOfbyte) {
      boolean bool2;
      this.output = param1ArrayOfbyte;
      if ((param1Int & 0x1) == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      this.do_padding = bool2;
      if ((param1Int & 0x2) == 0) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      this.do_newline = bool2;
      if ((param1Int & 0x4) != 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      this.do_cr = bool2;
      if ((param1Int & 0x8) == 0) {
        int i = a;
      } else {
        param1ArrayOfbyte = b;
      } 
      this.d = param1ArrayOfbyte;
      this.c = new byte[2];
      this.a = 0;
      if (this.do_newline) {
        param1Int = 19;
      } else {
        param1Int = -1;
      } 
      this.count = param1Int;
    }
    
    public boolean process(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, boolean param1Boolean) {
      // Byte code:
      //   0: aload_0
      //   1: getfield d : [B
      //   4: astore #5
      //   6: aload_0
      //   7: getfield output : [B
      //   10: astore #6
      //   12: iconst_0
      //   13: istore #7
      //   15: aload_0
      //   16: getfield count : I
      //   19: istore #8
      //   21: iload_3
      //   22: iload_2
      //   23: iadd
      //   24: istore #9
      //   26: aload_0
      //   27: getfield a : I
      //   30: tableswitch default -> 56, 0 -> 347, 1 -> 358, 2 -> 424
      //   56: iconst_m1
      //   57: istore #10
      //   59: iload_2
      //   60: istore_3
      //   61: iload #10
      //   63: istore_2
      //   64: iload_2
      //   65: iconst_m1
      //   66: if_icmpeq -> 1206
      //   69: aload #6
      //   71: iconst_0
      //   72: aload #5
      //   74: iload_2
      //   75: bipush #18
      //   77: ishr
      //   78: bipush #63
      //   80: iand
      //   81: baload
      //   82: i2b
      //   83: bastore
      //   84: aload #6
      //   86: iconst_1
      //   87: aload #5
      //   89: iload_2
      //   90: bipush #12
      //   92: ishr
      //   93: bipush #63
      //   95: iand
      //   96: baload
      //   97: i2b
      //   98: bastore
      //   99: aload #6
      //   101: iconst_2
      //   102: aload #5
      //   104: iload_2
      //   105: bipush #6
      //   107: ishr
      //   108: bipush #63
      //   110: iand
      //   111: baload
      //   112: i2b
      //   113: bastore
      //   114: iconst_4
      //   115: istore #7
      //   117: aload #6
      //   119: iconst_3
      //   120: aload #5
      //   122: iload_2
      //   123: bipush #63
      //   125: iand
      //   126: baload
      //   127: i2b
      //   128: bastore
      //   129: iinc #8, -1
      //   132: iload #8
      //   134: ifne -> 1201
      //   137: iload #7
      //   139: istore_2
      //   140: aload_0
      //   141: getfield do_cr : Z
      //   144: ifeq -> 156
      //   147: iconst_5
      //   148: istore_2
      //   149: aload #6
      //   151: iconst_4
      //   152: bipush #13
      //   154: i2b
      //   155: bastore
      //   156: iload_2
      //   157: iconst_1
      //   158: iadd
      //   159: istore #7
      //   161: aload #6
      //   163: iload_2
      //   164: bipush #10
      //   166: i2b
      //   167: bastore
      //   168: bipush #19
      //   170: istore #8
      //   172: iload #7
      //   174: istore_2
      //   175: iload_3
      //   176: iconst_3
      //   177: iadd
      //   178: iload #9
      //   180: if_icmpgt -> 490
      //   183: aload_1
      //   184: iload_3
      //   185: baload
      //   186: sipush #255
      //   189: iand
      //   190: bipush #16
      //   192: ishl
      //   193: aload_1
      //   194: iload_3
      //   195: iconst_1
      //   196: iadd
      //   197: baload
      //   198: sipush #255
      //   201: iand
      //   202: bipush #8
      //   204: ishl
      //   205: ior
      //   206: aload_1
      //   207: iload_3
      //   208: iconst_2
      //   209: iadd
      //   210: baload
      //   211: sipush #255
      //   214: iand
      //   215: ior
      //   216: istore #7
      //   218: aload #6
      //   220: iload_2
      //   221: aload #5
      //   223: iload #7
      //   225: bipush #18
      //   227: ishr
      //   228: bipush #63
      //   230: iand
      //   231: baload
      //   232: i2b
      //   233: bastore
      //   234: aload #6
      //   236: iload_2
      //   237: iconst_1
      //   238: iadd
      //   239: aload #5
      //   241: iload #7
      //   243: bipush #12
      //   245: ishr
      //   246: bipush #63
      //   248: iand
      //   249: baload
      //   250: i2b
      //   251: bastore
      //   252: aload #6
      //   254: iload_2
      //   255: iconst_2
      //   256: iadd
      //   257: aload #5
      //   259: iload #7
      //   261: bipush #6
      //   263: ishr
      //   264: bipush #63
      //   266: iand
      //   267: baload
      //   268: i2b
      //   269: bastore
      //   270: aload #6
      //   272: iload_2
      //   273: iconst_3
      //   274: iadd
      //   275: aload #5
      //   277: iload #7
      //   279: bipush #63
      //   281: iand
      //   282: baload
      //   283: i2b
      //   284: bastore
      //   285: iinc #3, 3
      //   288: iinc #2, 4
      //   291: iinc #8, -1
      //   294: iload #8
      //   296: ifne -> 1198
      //   299: aload_0
      //   300: getfield do_cr : Z
      //   303: ifeq -> 1195
      //   306: iload_2
      //   307: iconst_1
      //   308: iadd
      //   309: istore #8
      //   311: aload #6
      //   313: iload_2
      //   314: bipush #13
      //   316: i2b
      //   317: bastore
      //   318: iload #8
      //   320: istore_2
      //   321: iload_2
      //   322: iconst_1
      //   323: iadd
      //   324: istore #8
      //   326: aload #6
      //   328: iload_2
      //   329: bipush #10
      //   331: i2b
      //   332: bastore
      //   333: bipush #19
      //   335: istore #7
      //   337: iload #8
      //   339: istore_2
      //   340: iload #7
      //   342: istore #8
      //   344: goto -> 175
      //   347: iconst_m1
      //   348: istore #10
      //   350: iload_2
      //   351: istore_3
      //   352: iload #10
      //   354: istore_2
      //   355: goto -> 64
      //   358: iload_2
      //   359: iconst_2
      //   360: iadd
      //   361: iload #9
      //   363: if_icmpgt -> 56
      //   366: aload_0
      //   367: getfield c : [B
      //   370: iconst_0
      //   371: baload
      //   372: istore #10
      //   374: iload_2
      //   375: iconst_1
      //   376: iadd
      //   377: istore_3
      //   378: aload_1
      //   379: iload_2
      //   380: baload
      //   381: istore #11
      //   383: aload_1
      //   384: iload_3
      //   385: baload
      //   386: istore_2
      //   387: aload_0
      //   388: iconst_0
      //   389: putfield a : I
      //   392: iload #10
      //   394: sipush #255
      //   397: iand
      //   398: bipush #16
      //   400: ishl
      //   401: iload #11
      //   403: sipush #255
      //   406: iand
      //   407: bipush #8
      //   409: ishl
      //   410: ior
      //   411: iload_2
      //   412: sipush #255
      //   415: iand
      //   416: ior
      //   417: istore_2
      //   418: iinc #3, 1
      //   421: goto -> 64
      //   424: iload_2
      //   425: iconst_1
      //   426: iadd
      //   427: iload #9
      //   429: if_icmpgt -> 56
      //   432: aload_0
      //   433: getfield c : [B
      //   436: iconst_0
      //   437: baload
      //   438: istore #10
      //   440: aload_0
      //   441: getfield c : [B
      //   444: iconst_1
      //   445: baload
      //   446: istore #11
      //   448: iload_2
      //   449: iconst_1
      //   450: iadd
      //   451: istore_3
      //   452: aload_1
      //   453: iload_2
      //   454: baload
      //   455: istore_2
      //   456: aload_0
      //   457: iconst_0
      //   458: putfield a : I
      //   461: iload #10
      //   463: sipush #255
      //   466: iand
      //   467: bipush #16
      //   469: ishl
      //   470: iload #11
      //   472: sipush #255
      //   475: iand
      //   476: bipush #8
      //   478: ishl
      //   479: ior
      //   480: iload_2
      //   481: sipush #255
      //   484: iand
      //   485: ior
      //   486: istore_2
      //   487: goto -> 64
      //   490: iload #4
      //   492: ifeq -> 1058
      //   495: iload_3
      //   496: aload_0
      //   497: getfield a : I
      //   500: isub
      //   501: iload #9
      //   503: iconst_1
      //   504: isub
      //   505: if_icmpne -> 708
      //   508: aload_0
      //   509: getfield a : I
      //   512: ifle -> 694
      //   515: aload_0
      //   516: getfield c : [B
      //   519: astore_1
      //   520: iconst_1
      //   521: istore #7
      //   523: aload_1
      //   524: iconst_0
      //   525: baload
      //   526: istore #10
      //   528: iload #10
      //   530: sipush #255
      //   533: iand
      //   534: iconst_4
      //   535: ishl
      //   536: istore #10
      //   538: aload_0
      //   539: aload_0
      //   540: getfield a : I
      //   543: iload #7
      //   545: isub
      //   546: putfield a : I
      //   549: iload_2
      //   550: iconst_1
      //   551: iadd
      //   552: istore #11
      //   554: aload #6
      //   556: iload_2
      //   557: aload #5
      //   559: iload #10
      //   561: bipush #6
      //   563: ishr
      //   564: bipush #63
      //   566: iand
      //   567: baload
      //   568: i2b
      //   569: bastore
      //   570: iload #11
      //   572: iconst_1
      //   573: iadd
      //   574: istore #7
      //   576: aload #6
      //   578: iload #11
      //   580: aload #5
      //   582: iload #10
      //   584: bipush #63
      //   586: iand
      //   587: baload
      //   588: i2b
      //   589: bastore
      //   590: iload #7
      //   592: istore_2
      //   593: aload_0
      //   594: getfield do_padding : Z
      //   597: ifeq -> 627
      //   600: iload #7
      //   602: iconst_1
      //   603: iadd
      //   604: istore #10
      //   606: aload #6
      //   608: iload #7
      //   610: bipush #61
      //   612: i2b
      //   613: bastore
      //   614: iload #10
      //   616: iconst_1
      //   617: iadd
      //   618: istore_2
      //   619: aload #6
      //   621: iload #10
      //   623: bipush #61
      //   625: i2b
      //   626: bastore
      //   627: iload_2
      //   628: istore #7
      //   630: aload_0
      //   631: getfield do_newline : Z
      //   634: ifeq -> 670
      //   637: iload_2
      //   638: istore #7
      //   640: aload_0
      //   641: getfield do_cr : Z
      //   644: ifeq -> 659
      //   647: aload #6
      //   649: iload_2
      //   650: bipush #13
      //   652: i2b
      //   653: bastore
      //   654: iload_2
      //   655: iconst_1
      //   656: iadd
      //   657: istore #7
      //   659: aload #6
      //   661: iload #7
      //   663: bipush #10
      //   665: i2b
      //   666: bastore
      //   667: iinc #7, 1
      //   670: iload_3
      //   671: istore #10
      //   673: getstatic com/ta/utdid2/a/a/b$c.a : Z
      //   676: ifne -> 1029
      //   679: aload_0
      //   680: getfield a : I
      //   683: ifeq -> 1029
      //   686: new java/lang/AssertionError
      //   689: dup
      //   690: invokespecial <init> : ()V
      //   693: athrow
      //   694: aload_1
      //   695: iload_3
      //   696: baload
      //   697: istore #10
      //   699: iinc #3, 1
      //   702: iconst_0
      //   703: istore #7
      //   705: goto -> 528
      //   708: iload_3
      //   709: aload_0
      //   710: getfield a : I
      //   713: isub
      //   714: iload #9
      //   716: iconst_2
      //   717: isub
      //   718: if_icmpne -> 953
      //   721: aload_0
      //   722: getfield a : I
      //   725: iconst_1
      //   726: if_icmple -> 928
      //   729: aload_0
      //   730: getfield c : [B
      //   733: astore #12
      //   735: iconst_1
      //   736: istore #7
      //   738: aload #12
      //   740: iconst_0
      //   741: baload
      //   742: istore #10
      //   744: aload_0
      //   745: getfield a : I
      //   748: ifle -> 942
      //   751: aload_0
      //   752: getfield c : [B
      //   755: iload #7
      //   757: baload
      //   758: istore #11
      //   760: iinc #7, 1
      //   763: iload #11
      //   765: sipush #255
      //   768: iand
      //   769: iconst_2
      //   770: ishl
      //   771: iload #10
      //   773: sipush #255
      //   776: iand
      //   777: bipush #10
      //   779: ishl
      //   780: ior
      //   781: istore #10
      //   783: aload_0
      //   784: aload_0
      //   785: getfield a : I
      //   788: iload #7
      //   790: isub
      //   791: putfield a : I
      //   794: iload_2
      //   795: iconst_1
      //   796: iadd
      //   797: istore #11
      //   799: aload #6
      //   801: iload_2
      //   802: aload #5
      //   804: iload #10
      //   806: bipush #12
      //   808: ishr
      //   809: bipush #63
      //   811: iand
      //   812: baload
      //   813: i2b
      //   814: bastore
      //   815: iload #11
      //   817: iconst_1
      //   818: iadd
      //   819: istore #7
      //   821: aload #6
      //   823: iload #11
      //   825: aload #5
      //   827: iload #10
      //   829: bipush #6
      //   831: ishr
      //   832: bipush #63
      //   834: iand
      //   835: baload
      //   836: i2b
      //   837: bastore
      //   838: iload #7
      //   840: iconst_1
      //   841: iadd
      //   842: istore_2
      //   843: aload #6
      //   845: iload #7
      //   847: aload #5
      //   849: iload #10
      //   851: bipush #63
      //   853: iand
      //   854: baload
      //   855: i2b
      //   856: bastore
      //   857: aload_0
      //   858: getfield do_padding : Z
      //   861: ifeq -> 1192
      //   864: iload_2
      //   865: iconst_1
      //   866: iadd
      //   867: istore #7
      //   869: aload #6
      //   871: iload_2
      //   872: bipush #61
      //   874: i2b
      //   875: bastore
      //   876: iload #7
      //   878: istore_2
      //   879: iload_2
      //   880: istore #7
      //   882: aload_0
      //   883: getfield do_newline : Z
      //   886: ifeq -> 922
      //   889: iload_2
      //   890: istore #7
      //   892: aload_0
      //   893: getfield do_cr : Z
      //   896: ifeq -> 911
      //   899: aload #6
      //   901: iload_2
      //   902: bipush #13
      //   904: i2b
      //   905: bastore
      //   906: iload_2
      //   907: iconst_1
      //   908: iadd
      //   909: istore #7
      //   911: aload #6
      //   913: iload #7
      //   915: bipush #10
      //   917: i2b
      //   918: bastore
      //   919: iinc #7, 1
      //   922: iload_3
      //   923: istore #10
      //   925: goto -> 673
      //   928: aload_1
      //   929: iload_3
      //   930: baload
      //   931: istore #10
      //   933: iinc #3, 1
      //   936: iconst_0
      //   937: istore #7
      //   939: goto -> 744
      //   942: aload_1
      //   943: iload_3
      //   944: baload
      //   945: istore #11
      //   947: iinc #3, 1
      //   950: goto -> 763
      //   953: iload_3
      //   954: istore #10
      //   956: iload_2
      //   957: istore #7
      //   959: aload_0
      //   960: getfield do_newline : Z
      //   963: ifeq -> 673
      //   966: iload_3
      //   967: istore #10
      //   969: iload_2
      //   970: istore #7
      //   972: iload_2
      //   973: ifle -> 673
      //   976: iload_3
      //   977: istore #10
      //   979: iload_2
      //   980: istore #7
      //   982: iload #8
      //   984: bipush #19
      //   986: if_icmpeq -> 673
      //   989: aload_0
      //   990: getfield do_cr : Z
      //   993: ifeq -> 1189
      //   996: iload_2
      //   997: iconst_1
      //   998: iadd
      //   999: istore #7
      //   1001: aload #6
      //   1003: iload_2
      //   1004: bipush #13
      //   1006: i2b
      //   1007: bastore
      //   1008: iload #7
      //   1010: istore_2
      //   1011: iload_2
      //   1012: iconst_1
      //   1013: iadd
      //   1014: istore #7
      //   1016: aload #6
      //   1018: iload_2
      //   1019: bipush #10
      //   1021: i2b
      //   1022: bastore
      //   1023: iload_3
      //   1024: istore #10
      //   1026: goto -> 673
      //   1029: iload #7
      //   1031: istore #11
      //   1033: getstatic com/ta/utdid2/a/a/b$c.a : Z
      //   1036: ifne -> 1098
      //   1039: iload #7
      //   1041: istore #11
      //   1043: iload #10
      //   1045: iload #9
      //   1047: if_icmpeq -> 1098
      //   1050: new java/lang/AssertionError
      //   1053: dup
      //   1054: invokespecial <init> : ()V
      //   1057: athrow
      //   1058: iload_3
      //   1059: iload #9
      //   1061: iconst_1
      //   1062: isub
      //   1063: if_icmpne -> 1112
      //   1066: aload_0
      //   1067: getfield c : [B
      //   1070: astore #6
      //   1072: aload_0
      //   1073: getfield a : I
      //   1076: istore #7
      //   1078: aload_0
      //   1079: iload #7
      //   1081: iconst_1
      //   1082: iadd
      //   1083: putfield a : I
      //   1086: aload #6
      //   1088: iload #7
      //   1090: aload_1
      //   1091: iload_3
      //   1092: baload
      //   1093: i2b
      //   1094: bastore
      //   1095: iload_2
      //   1096: istore #11
      //   1098: aload_0
      //   1099: iload #11
      //   1101: putfield op : I
      //   1104: aload_0
      //   1105: iload #8
      //   1107: putfield count : I
      //   1110: iconst_1
      //   1111: ireturn
      //   1112: iload_2
      //   1113: istore #11
      //   1115: iload_3
      //   1116: iload #9
      //   1118: iconst_2
      //   1119: isub
      //   1120: if_icmpne -> 1098
      //   1123: aload_0
      //   1124: getfield c : [B
      //   1127: astore #6
      //   1129: aload_0
      //   1130: getfield a : I
      //   1133: istore #7
      //   1135: aload_0
      //   1136: iload #7
      //   1138: iconst_1
      //   1139: iadd
      //   1140: putfield a : I
      //   1143: aload #6
      //   1145: iload #7
      //   1147: aload_1
      //   1148: iload_3
      //   1149: baload
      //   1150: i2b
      //   1151: bastore
      //   1152: aload_0
      //   1153: getfield c : [B
      //   1156: astore #6
      //   1158: aload_0
      //   1159: getfield a : I
      //   1162: istore #7
      //   1164: aload_0
      //   1165: iload #7
      //   1167: iconst_1
      //   1168: iadd
      //   1169: putfield a : I
      //   1172: aload #6
      //   1174: iload #7
      //   1176: aload_1
      //   1177: iload_3
      //   1178: iconst_1
      //   1179: iadd
      //   1180: baload
      //   1181: i2b
      //   1182: bastore
      //   1183: iload_2
      //   1184: istore #11
      //   1186: goto -> 1098
      //   1189: goto -> 1011
      //   1192: goto -> 879
      //   1195: goto -> 321
      //   1198: goto -> 175
      //   1201: iconst_4
      //   1202: istore_2
      //   1203: goto -> 175
      //   1206: iload #7
      //   1208: istore_2
      //   1209: goto -> 175
    }
    
    static {
      boolean bool;
      if (!b.class.desiredAssertionStatus()) {
        bool = true;
      } else {
        bool = false;
      } 
      a = bool;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\t\\utdid2\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */