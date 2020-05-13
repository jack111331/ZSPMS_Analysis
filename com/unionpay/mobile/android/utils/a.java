package com.unionpay.mobile.android.utils;

import java.io.IOException;

public class a {
  private static final byte[] b = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] c = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
      -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9 };
  
  private static final byte[] d = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  private static final byte[] e = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
      -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9 };
  
  private static final byte[] f = new byte[] { 
      45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 
      57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 
      74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 
      84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 
      99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 
      109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 
      119, 120, 121, 122 };
  
  private static final byte[] g = new byte[] { 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
      -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 
      3, 4, 5, 6, 7, 8, 9, 10, -9, -9, 
      -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 
      16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 
      26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 
      36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 
      41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 
      51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 
      61, 62, 63, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
      -9, -9, -9, -9, -9, -9, -9 };
  
  public static byte[] a(String paramString) throws IOException {
    return b(paramString);
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, int paramInt) throws IOException {
    if (paramArrayOfbyte == null)
      throw new NullPointerException("Cannot decode null source array."); 
    if (paramInt + 0 > paramArrayOfbyte.length)
      throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(0), Integer.valueOf(paramInt) })); 
    if (paramInt == 0)
      return new byte[0]; 
    if (paramInt < 4)
      throw new IllegalArgumentException("Base64-encoded string must have at least four characters, but length specified was " + paramInt); 
    byte[] arrayOfByte1 = c;
    byte[] arrayOfByte2 = new byte[paramInt * 3 / 4];
    byte[] arrayOfByte3 = new byte[4];
    int i = 0;
    int j = 0;
    int k = 0;
    while (true) {
      if (i < paramInt + 0) {
        byte b = arrayOfByte1[paramArrayOfbyte[i] & 0xFF];
        if (b >= -5) {
          if (b >= -1) {
            int m = j + 1;
            arrayOfByte3[j] = (byte)paramArrayOfbyte[i];
            if (m > 3) {
              if (3 >= arrayOfByte3.length)
                throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and still process four bytes.", new Object[] { Integer.valueOf(arrayOfByte3.length), Integer.valueOf(0) })); 
              if (!k || k + 2 >= arrayOfByte2.length)
                throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[] { Integer.valueOf(arrayOfByte2.length), Integer.valueOf(k) })); 
              byte[] arrayOfByte = c;
              if (arrayOfByte3[2] == 61) {
                j = arrayOfByte[arrayOfByte3[0]];
                arrayOfByte2[k] = (byte)(byte)(((arrayOfByte[arrayOfByte3[1]] & 0xFF) << 12 | (j & 0xFF) << 18) >>> 16);
                j = 1;
              } else if (arrayOfByte3[3] == 61) {
                m = arrayOfByte[arrayOfByte3[0]];
                j = arrayOfByte[arrayOfByte3[1]];
                j = (arrayOfByte[arrayOfByte3[2]] & 0xFF) << 6 | (m & 0xFF) << 18 | (j & 0xFF) << 12;
                arrayOfByte2[k] = (byte)(byte)(j >>> 16);
                arrayOfByte2[k + 1] = (byte)(byte)(j >>> 8);
                j = 2;
              } else {
                byte b1 = arrayOfByte[arrayOfByte3[0]];
                j = arrayOfByte[arrayOfByte3[1]];
                m = arrayOfByte[arrayOfByte3[2]];
                j = arrayOfByte[arrayOfByte3[3]] & 0xFF | (b1 & 0xFF) << 18 | (j & 0xFF) << 12 | (m & 0xFF) << 6;
                arrayOfByte2[k] = (byte)(byte)(j >> 16);
                arrayOfByte2[k + 1] = (byte)(byte)(j >> 8);
                arrayOfByte2[k + 2] = (byte)(byte)j;
                j = 3;
              } 
              j += k;
              if (paramArrayOfbyte[i] == 61) {
                k = j;
              } else {
                k = 0;
                m = i + 1;
                i = j;
                j = k;
                k = i;
                i = m;
              } 
            } else {
              j = k;
              k = m;
              m = i + 1;
              i = j;
              j = k;
              k = i;
              i = m;
            } 
          } else {
            int m = k;
            k = j;
            j = m;
            m = i + 1;
            i = j;
            j = k;
            k = i;
            i = m;
          } 
        } else {
          throw new IOException(String.format("Bad Base64 input character decimal %d in array position %d", new Object[] { Integer.valueOf(paramArrayOfbyte[i] & 0xFF), Integer.valueOf(i) }));
        } 
      } 
      paramArrayOfbyte = new byte[k];
      System.arraycopy(arrayOfByte2, 0, paramArrayOfbyte, 0, k);
      return paramArrayOfbyte;
    } 
  }
  
  private static byte[] b(String paramString) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: ifnonnull -> 18
    //   8: new java/lang/NullPointerException
    //   11: dup
    //   12: ldc 'Input string was null.'
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: ldc 'US-ASCII'
    //   21: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   24: astore_3
    //   25: aload_3
    //   26: astore_0
    //   27: aload_0
    //   28: aload_0
    //   29: arraylength
    //   30: invokestatic a : ([BI)[B
    //   33: astore #4
    //   35: aload #4
    //   37: astore #5
    //   39: aload #4
    //   41: ifnull -> 175
    //   44: aload #4
    //   46: astore #5
    //   48: aload #4
    //   50: arraylength
    //   51: iconst_4
    //   52: if_icmplt -> 175
    //   55: aload #4
    //   57: astore #5
    //   59: ldc 35615
    //   61: aload #4
    //   63: iconst_0
    //   64: baload
    //   65: sipush #255
    //   68: iand
    //   69: aload #4
    //   71: iconst_1
    //   72: baload
    //   73: bipush #8
    //   75: ishl
    //   76: ldc 65280
    //   78: iand
    //   79: ior
    //   80: if_icmpne -> 175
    //   83: sipush #2048
    //   86: newarray byte
    //   88: astore #5
    //   90: new java/io/ByteArrayOutputStream
    //   93: astore #6
    //   95: aload #6
    //   97: invokespecial <init> : ()V
    //   100: new java/io/ByteArrayInputStream
    //   103: astore_3
    //   104: aload_3
    //   105: aload #4
    //   107: invokespecial <init> : ([B)V
    //   110: new java/util/zip/GZIPInputStream
    //   113: astore_0
    //   114: aload_0
    //   115: aload_3
    //   116: invokespecial <init> : (Ljava/io/InputStream;)V
    //   119: aload_0
    //   120: aload #5
    //   122: invokevirtual read : ([B)I
    //   125: istore #7
    //   127: iload #7
    //   129: iflt -> 187
    //   132: aload #6
    //   134: aload #5
    //   136: iconst_0
    //   137: iload #7
    //   139: invokevirtual write : ([BII)V
    //   142: goto -> 119
    //   145: astore_2
    //   146: aload_0
    //   147: astore #5
    //   149: aload_3
    //   150: astore_0
    //   151: aload_2
    //   152: astore_3
    //   153: aload_3
    //   154: invokevirtual printStackTrace : ()V
    //   157: aload #6
    //   159: invokevirtual close : ()V
    //   162: aload #5
    //   164: invokevirtual close : ()V
    //   167: aload_0
    //   168: invokevirtual close : ()V
    //   171: aload #4
    //   173: astore #5
    //   175: aload #5
    //   177: areturn
    //   178: astore_3
    //   179: aload_0
    //   180: invokevirtual getBytes : ()[B
    //   183: astore_0
    //   184: goto -> 27
    //   187: aload #6
    //   189: invokevirtual toByteArray : ()[B
    //   192: astore #5
    //   194: aload #6
    //   196: invokevirtual close : ()V
    //   199: aload_0
    //   200: invokevirtual close : ()V
    //   203: aload_3
    //   204: invokevirtual close : ()V
    //   207: goto -> 175
    //   210: astore_0
    //   211: goto -> 175
    //   214: astore_0
    //   215: aconst_null
    //   216: astore #6
    //   218: aconst_null
    //   219: astore_3
    //   220: aload_1
    //   221: astore #5
    //   223: aload #6
    //   225: invokevirtual close : ()V
    //   228: aload #5
    //   230: invokevirtual close : ()V
    //   233: aload_3
    //   234: invokevirtual close : ()V
    //   237: aload_0
    //   238: athrow
    //   239: astore #6
    //   241: goto -> 199
    //   244: astore_0
    //   245: goto -> 203
    //   248: astore_3
    //   249: goto -> 162
    //   252: astore_3
    //   253: goto -> 167
    //   256: astore_0
    //   257: aload #4
    //   259: astore #5
    //   261: goto -> 175
    //   264: astore #6
    //   266: goto -> 228
    //   269: astore #5
    //   271: goto -> 233
    //   274: astore_3
    //   275: goto -> 237
    //   278: astore_0
    //   279: aconst_null
    //   280: astore_3
    //   281: aload_1
    //   282: astore #5
    //   284: goto -> 223
    //   287: astore_0
    //   288: aload_1
    //   289: astore #5
    //   291: goto -> 223
    //   294: astore_2
    //   295: aload_0
    //   296: astore #5
    //   298: aload_2
    //   299: astore_0
    //   300: goto -> 223
    //   303: astore_2
    //   304: aload_0
    //   305: astore_3
    //   306: aload_2
    //   307: astore_0
    //   308: goto -> 223
    //   311: astore_3
    //   312: aconst_null
    //   313: astore #6
    //   315: aconst_null
    //   316: astore_0
    //   317: aload_2
    //   318: astore #5
    //   320: goto -> 153
    //   323: astore_3
    //   324: aconst_null
    //   325: astore_0
    //   326: aload_2
    //   327: astore #5
    //   329: goto -> 153
    //   332: astore #5
    //   334: aload_3
    //   335: astore_0
    //   336: aload #5
    //   338: astore_3
    //   339: aload_2
    //   340: astore #5
    //   342: goto -> 153
    // Exception table:
    //   from	to	target	type
    //   18	25	178	java/io/UnsupportedEncodingException
    //   90	100	311	java/io/IOException
    //   90	100	214	finally
    //   100	110	323	java/io/IOException
    //   100	110	278	finally
    //   110	119	332	java/io/IOException
    //   110	119	287	finally
    //   119	127	145	java/io/IOException
    //   119	127	294	finally
    //   132	142	145	java/io/IOException
    //   132	142	294	finally
    //   153	157	303	finally
    //   157	162	248	java/lang/Exception
    //   162	167	252	java/lang/Exception
    //   167	171	256	java/lang/Exception
    //   187	194	145	java/io/IOException
    //   187	194	294	finally
    //   194	199	239	java/lang/Exception
    //   199	203	244	java/lang/Exception
    //   203	207	210	java/lang/Exception
    //   223	228	264	java/lang/Exception
    //   228	233	269	java/lang/Exception
    //   233	237	274	java/lang/Exception
  }
  
  static {
    boolean bool;
    if (!a.class.desiredAssertionStatus()) {
      bool = true;
    } else {
      bool = false;
    } 
    a = bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\androi\\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */