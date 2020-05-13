package okio;

final class Base64 {
  private static final byte[] MAP = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 43, 47 };
  
  private static final byte[] URL_MAP = new byte[] { 
      65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
      75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
      85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
      101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
      111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
      121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
      56, 57, 45, 95 };
  
  public static byte[] decode(String paramString) {
    int k;
    int i = paramString.length();
    while (true) {
      Object object;
      if (i > 0) {
        char c = paramString.charAt(i - 1);
        if (c == '=' || c == '\n' || c == '\r' || c == ' ' || c == '\t') {
          i--;
          continue;
        } 
      } 
      byte[] arrayOfByte = new byte[(int)(i * 6L / 8L)];
      int n = 0;
      boolean bool = false;
      byte b = 0;
      int m = 0;
      while (true) {
        int i1;
        if (b < i) {
          Object object1;
          char c = paramString.charAt(b);
          if (c >= 'A' && c <= 'Z') {
            int i3 = c - 65;
          } else if (c >= 'a' && c <= 'z') {
            int i3 = c - 71;
          } else if (c >= '0' && c <= '9') {
            int i3 = c + 4;
          } else if (c == '+' || c == '-') {
            byte b1 = 62;
          } else if (c == '/' || c == '_') {
            byte b1 = 63;
          } else {
            int i3 = n;
            object1 = object;
            if (c != '\n') {
              i3 = n;
              object1 = object;
              if (c != '\r') {
                i3 = n;
                object1 = object;
                if (c != ' ') {
                  if (c == '\t') {
                    object1 = object;
                  } else {
                    return null;
                  } 
                  continue;
                } 
              } 
            } 
            n = i3;
          } 
          i1 = object << 6 | (byte)object1;
          k = ++n;
          int i2 = i1;
          if (n % 4 == 0) {
            i2 = m + 1;
            arrayOfByte[m] = (byte)(byte)(i1 >> 16);
            k = i2 + 1;
            arrayOfByte[i2] = (byte)(byte)(i1 >> 8);
            m = k + 1;
            arrayOfByte[k] = (byte)(byte)i1;
            i2 = i1;
            continue;
          } 
        } else {
          int i2;
          n %= 4;
          if (n == 1)
            return null; 
          if (n == 2) {
            i2 = m + 1;
            arrayOfByte[m] = (byte)(byte)(i1 << 12 >> 16);
          } else {
            i2 = m;
            if (n == 3) {
              n = i1 << 6;
              i1 = m + 1;
              arrayOfByte[m] = (byte)(byte)(n >> 16);
              i2 = i1 + 1;
              arrayOfByte[i1] = (byte)(byte)(n >> 8);
            } 
          } 
          byte[] arrayOfByte1 = arrayOfByte;
          if (i2 != arrayOfByte.length) {
            arrayOfByte1 = new byte[i2];
            System.arraycopy(arrayOfByte, 0, arrayOfByte1, 0, i2);
          } 
          return arrayOfByte1;
        } 
        n = k;
        b++;
        object = SYNTHETIC_LOCAL_VARIABLE_8;
      } 
    } 
    int j = k;
  }
  
  public static String encode(byte[] paramArrayOfbyte) {
    return encode(paramArrayOfbyte, MAP);
  }
  
  private static String encode(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: iconst_2
    //   3: iadd
    //   4: iconst_4
    //   5: imul
    //   6: iconst_3
    //   7: idiv
    //   8: newarray byte
    //   10: astore_2
    //   11: aload_0
    //   12: arraylength
    //   13: aload_0
    //   14: arraylength
    //   15: iconst_3
    //   16: irem
    //   17: isub
    //   18: istore_3
    //   19: iconst_0
    //   20: istore #4
    //   22: iconst_0
    //   23: istore #5
    //   25: iload #4
    //   27: iload_3
    //   28: if_icmpge -> 154
    //   31: iload #5
    //   33: iconst_1
    //   34: iadd
    //   35: istore #6
    //   37: aload_2
    //   38: iload #5
    //   40: aload_1
    //   41: aload_0
    //   42: iload #4
    //   44: baload
    //   45: sipush #255
    //   48: iand
    //   49: iconst_2
    //   50: ishr
    //   51: baload
    //   52: i2b
    //   53: bastore
    //   54: iload #6
    //   56: iconst_1
    //   57: iadd
    //   58: istore #5
    //   60: aload_2
    //   61: iload #6
    //   63: aload_1
    //   64: aload_0
    //   65: iload #4
    //   67: baload
    //   68: iconst_3
    //   69: iand
    //   70: iconst_4
    //   71: ishl
    //   72: aload_0
    //   73: iload #4
    //   75: iconst_1
    //   76: iadd
    //   77: baload
    //   78: sipush #255
    //   81: iand
    //   82: iconst_4
    //   83: ishr
    //   84: ior
    //   85: baload
    //   86: i2b
    //   87: bastore
    //   88: iload #5
    //   90: iconst_1
    //   91: iadd
    //   92: istore #6
    //   94: aload_2
    //   95: iload #5
    //   97: aload_1
    //   98: aload_0
    //   99: iload #4
    //   101: iconst_1
    //   102: iadd
    //   103: baload
    //   104: bipush #15
    //   106: iand
    //   107: iconst_2
    //   108: ishl
    //   109: aload_0
    //   110: iload #4
    //   112: iconst_2
    //   113: iadd
    //   114: baload
    //   115: sipush #255
    //   118: iand
    //   119: bipush #6
    //   121: ishr
    //   122: ior
    //   123: baload
    //   124: i2b
    //   125: bastore
    //   126: iload #6
    //   128: iconst_1
    //   129: iadd
    //   130: istore #5
    //   132: aload_2
    //   133: iload #6
    //   135: aload_1
    //   136: aload_0
    //   137: iload #4
    //   139: iconst_2
    //   140: iadd
    //   141: baload
    //   142: bipush #63
    //   144: iand
    //   145: baload
    //   146: i2b
    //   147: bastore
    //   148: iinc #4, 3
    //   151: goto -> 25
    //   154: aload_0
    //   155: arraylength
    //   156: iconst_3
    //   157: irem
    //   158: tableswitch default -> 180, 1 -> 196, 2 -> 267
    //   180: new java/lang/String
    //   183: dup
    //   184: aload_2
    //   185: iconst_0
    //   186: iload #5
    //   188: ldc 'US-ASCII'
    //   190: invokespecial <init> : ([BIILjava/lang/String;)V
    //   193: astore_0
    //   194: aload_0
    //   195: areturn
    //   196: iload #5
    //   198: iconst_1
    //   199: iadd
    //   200: istore #4
    //   202: aload_2
    //   203: iload #5
    //   205: aload_1
    //   206: aload_0
    //   207: iload_3
    //   208: baload
    //   209: sipush #255
    //   212: iand
    //   213: iconst_2
    //   214: ishr
    //   215: baload
    //   216: i2b
    //   217: bastore
    //   218: iload #4
    //   220: iconst_1
    //   221: iadd
    //   222: istore #5
    //   224: aload_2
    //   225: iload #4
    //   227: aload_1
    //   228: aload_0
    //   229: iload_3
    //   230: baload
    //   231: iconst_3
    //   232: iand
    //   233: iconst_4
    //   234: ishl
    //   235: baload
    //   236: i2b
    //   237: bastore
    //   238: iload #5
    //   240: iconst_1
    //   241: iadd
    //   242: istore #4
    //   244: aload_2
    //   245: iload #5
    //   247: bipush #61
    //   249: i2b
    //   250: bastore
    //   251: aload_2
    //   252: iload #4
    //   254: bipush #61
    //   256: i2b
    //   257: bastore
    //   258: iload #4
    //   260: iconst_1
    //   261: iadd
    //   262: istore #5
    //   264: goto -> 180
    //   267: iload #5
    //   269: iconst_1
    //   270: iadd
    //   271: istore #4
    //   273: aload_2
    //   274: iload #5
    //   276: aload_1
    //   277: aload_0
    //   278: iload_3
    //   279: baload
    //   280: sipush #255
    //   283: iand
    //   284: iconst_2
    //   285: ishr
    //   286: baload
    //   287: i2b
    //   288: bastore
    //   289: iload #4
    //   291: iconst_1
    //   292: iadd
    //   293: istore #5
    //   295: aload_2
    //   296: iload #4
    //   298: aload_1
    //   299: aload_0
    //   300: iload_3
    //   301: baload
    //   302: iconst_3
    //   303: iand
    //   304: iconst_4
    //   305: ishl
    //   306: aload_0
    //   307: iload_3
    //   308: iconst_1
    //   309: iadd
    //   310: baload
    //   311: sipush #255
    //   314: iand
    //   315: iconst_4
    //   316: ishr
    //   317: ior
    //   318: baload
    //   319: i2b
    //   320: bastore
    //   321: iload #5
    //   323: iconst_1
    //   324: iadd
    //   325: istore #4
    //   327: aload_2
    //   328: iload #5
    //   330: aload_1
    //   331: aload_0
    //   332: iload_3
    //   333: iconst_1
    //   334: iadd
    //   335: baload
    //   336: bipush #15
    //   338: iand
    //   339: iconst_2
    //   340: ishl
    //   341: baload
    //   342: i2b
    //   343: bastore
    //   344: iload #4
    //   346: iconst_1
    //   347: iadd
    //   348: istore #5
    //   350: aload_2
    //   351: iload #4
    //   353: bipush #61
    //   355: i2b
    //   356: bastore
    //   357: goto -> 180
    //   360: astore_0
    //   361: new java/lang/AssertionError
    //   364: dup
    //   365: aload_0
    //   366: invokespecial <init> : (Ljava/lang/Object;)V
    //   369: athrow
    // Exception table:
    //   from	to	target	type
    //   180	194	360	java/io/UnsupportedEncodingException
  }
  
  public static String encodeUrl(byte[] paramArrayOfbyte) {
    return encode(paramArrayOfbyte, URL_MAP);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okio\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */