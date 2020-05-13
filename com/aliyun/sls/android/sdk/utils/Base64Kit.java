package com.aliyun.sls.android.sdk.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class Base64Kit {
  private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
  
  private static byte[] codes = new byte[256];
  
  static {
    byte b;
    for (b = 0; b < 'Ā'; b++)
      codes[b] = (byte)-1; 
    for (b = 65; b <= 90; b++)
      codes[b] = (byte)(byte)(b - 65); 
    for (b = 97; b <= 122; b++)
      codes[b] = (byte)(byte)(b + 26 - 97); 
    for (b = 48; b <= 57; b++)
      codes[b] = (byte)(byte)(b + 52 - 48); 
    codes[43] = (byte)62;
    codes[47] = (byte)63;
  }
  
  public static String decode(String paramString) {
    return new String(decode(paramString.toCharArray()));
  }
  
  public static void decode(File paramFile) throws IOException {
    if (!paramFile.exists()) {
      System.exit(0);
    } else {
      writeBytes(paramFile, decode(readChars(paramFile)));
    } 
  }
  
  public static byte[] decode(char[] paramArrayOfchar) {
    // Byte code:
    //   0: aload_0
    //   1: arraylength
    //   2: istore_1
    //   3: iconst_0
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_3
    //   7: iload_3
    //   8: aload_0
    //   9: arraylength
    //   10: if_icmpge -> 49
    //   13: aload_0
    //   14: iload_3
    //   15: caload
    //   16: sipush #255
    //   19: if_icmpgt -> 35
    //   22: iload_1
    //   23: istore #4
    //   25: getstatic com/aliyun/sls/android/sdk/utils/Base64Kit.codes : [B
    //   28: aload_0
    //   29: iload_3
    //   30: caload
    //   31: baload
    //   32: ifge -> 40
    //   35: iload_1
    //   36: iconst_1
    //   37: isub
    //   38: istore #4
    //   40: iinc #3, 1
    //   43: iload #4
    //   45: istore_1
    //   46: goto -> 7
    //   49: iload_1
    //   50: iconst_4
    //   51: idiv
    //   52: iconst_3
    //   53: imul
    //   54: istore_3
    //   55: iload_1
    //   56: iconst_4
    //   57: irem
    //   58: istore #4
    //   60: iload_3
    //   61: istore_1
    //   62: iload #4
    //   64: iconst_3
    //   65: if_icmpne -> 72
    //   68: iload_3
    //   69: iconst_2
    //   70: iadd
    //   71: istore_1
    //   72: iload_1
    //   73: istore_3
    //   74: iload #4
    //   76: iconst_2
    //   77: if_icmpne -> 84
    //   80: iload_1
    //   81: iconst_1
    //   82: iadd
    //   83: istore_3
    //   84: iload_3
    //   85: newarray byte
    //   87: astore #5
    //   89: iconst_0
    //   90: istore #4
    //   92: iconst_0
    //   93: istore #6
    //   95: iconst_0
    //   96: istore #7
    //   98: iload_2
    //   99: istore_3
    //   100: iload_3
    //   101: aload_0
    //   102: arraylength
    //   103: if_icmpge -> 221
    //   106: aload_0
    //   107: iload_3
    //   108: caload
    //   109: sipush #255
    //   112: if_icmple -> 121
    //   115: iconst_m1
    //   116: istore #8
    //   118: goto -> 130
    //   121: getstatic com/aliyun/sls/android/sdk/utils/Base64Kit.codes : [B
    //   124: aload_0
    //   125: iload_3
    //   126: caload
    //   127: baload
    //   128: istore #8
    //   130: iload #4
    //   132: istore #9
    //   134: iload #6
    //   136: istore_2
    //   137: iload #7
    //   139: istore_1
    //   140: iload #8
    //   142: iflt -> 205
    //   145: iinc #7, 6
    //   148: iload #6
    //   150: bipush #6
    //   152: ishl
    //   153: iload #8
    //   155: ior
    //   156: istore #6
    //   158: iload #4
    //   160: istore #9
    //   162: iload #6
    //   164: istore_2
    //   165: iload #7
    //   167: istore_1
    //   168: iload #7
    //   170: bipush #8
    //   172: if_icmplt -> 205
    //   175: iload #7
    //   177: bipush #8
    //   179: isub
    //   180: istore_1
    //   181: aload #5
    //   183: iload #4
    //   185: iload #6
    //   187: iload_1
    //   188: ishr
    //   189: sipush #255
    //   192: iand
    //   193: i2b
    //   194: i2b
    //   195: bastore
    //   196: iload #4
    //   198: iconst_1
    //   199: iadd
    //   200: istore #9
    //   202: iload #6
    //   204: istore_2
    //   205: iinc #3, 1
    //   208: iload #9
    //   210: istore #4
    //   212: iload_2
    //   213: istore #6
    //   215: iload_1
    //   216: istore #7
    //   218: goto -> 100
    //   221: iload #4
    //   223: aload #5
    //   225: arraylength
    //   226: if_icmpne -> 232
    //   229: aload #5
    //   231: areturn
    //   232: new java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial <init> : ()V
    //   239: astore_0
    //   240: aload_0
    //   241: ldc 'Miscalculated data length (wrote '
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_0
    //   248: iload #4
    //   250: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_0
    //   255: ldc ' instead of '
    //   257: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_0
    //   262: aload #5
    //   264: arraylength
    //   265: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: ldc ')'
    //   272: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: new java/lang/Error
    //   279: dup
    //   280: aload_0
    //   281: invokevirtual toString : ()Ljava/lang/String;
    //   284: invokespecial <init> : (Ljava/lang/String;)V
    //   287: athrow
  }
  
  public static String encode(String paramString) {
    return new String(encode(paramString.getBytes()));
  }
  
  public static void encode(File paramFile) throws IOException {
    if (!paramFile.exists()) {
      System.exit(0);
    } else {
      writeChars(paramFile, encode(readBytes(paramFile)));
    } 
  }
  
  public static char[] encode(byte[] paramArrayOfbyte) {
    char[] arrayOfChar = new char[(paramArrayOfbyte.length + 2) / 3 * 4];
    byte b1 = 0;
    for (byte b2 = 0; b1 < paramArrayOfbyte.length; b2 += 4) {
      int i = (paramArrayOfbyte[b1] & 0xFF) << 8;
      int j = b1 + 1;
      int k = paramArrayOfbyte.length;
      int m = 1;
      if (j < k) {
        i |= paramArrayOfbyte[j] & 0xFF;
        j = 1;
      } else {
        j = 0;
      } 
      i <<= 8;
      k = b1 + 2;
      if (k < paramArrayOfbyte.length) {
        i |= paramArrayOfbyte[k] & 0xFF;
      } else {
        m = 0;
      } 
      char[] arrayOfChar1 = alphabet;
      k = 64;
      if (m) {
        m = i & 0x3F;
      } else {
        m = 64;
      } 
      arrayOfChar[b2 + 3] = (char)arrayOfChar1[m];
      m = i >> 6;
      arrayOfChar1 = alphabet;
      i = k;
      if (j != 0)
        i = m & 0x3F; 
      arrayOfChar[b2 + 2] = (char)arrayOfChar1[i];
      j = m >> 6;
      arrayOfChar[b2 + 1] = (char)alphabet[j & 0x3F];
      arrayOfChar[b2 + 0] = (char)alphabet[j >> 6 & 0x3F];
      b1 += 3;
    } 
    return arrayOfChar;
  }
  
  private static byte[] readBytes(File paramFile) throws IOException {
    // Byte code:
    //   0: new java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: new java/io/FileInputStream
    //   13: astore_3
    //   14: aload_3
    //   15: aload_0
    //   16: invokespecial <init> : (Ljava/io/File;)V
    //   19: new java/io/BufferedInputStream
    //   22: astore_0
    //   23: aload_0
    //   24: aload_3
    //   25: invokespecial <init> : (Ljava/io/InputStream;)V
    //   28: sipush #16384
    //   31: newarray byte
    //   33: astore_2
    //   34: aload_0
    //   35: aload_2
    //   36: invokevirtual read : ([B)I
    //   39: istore #4
    //   41: iload #4
    //   43: iconst_m1
    //   44: if_icmpeq -> 63
    //   47: iload #4
    //   49: ifle -> 34
    //   52: aload_1
    //   53: aload_2
    //   54: iconst_0
    //   55: iload #4
    //   57: invokevirtual write : ([BII)V
    //   60: goto -> 34
    //   63: aload_1
    //   64: invokevirtual toByteArray : ()[B
    //   67: astore_2
    //   68: aload_3
    //   69: invokevirtual close : ()V
    //   72: aload_0
    //   73: invokevirtual close : ()V
    //   76: aload_1
    //   77: invokevirtual close : ()V
    //   80: goto -> 91
    //   83: astore_0
    //   84: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   87: aload_0
    //   88: invokevirtual println : (Ljava/lang/Object;)V
    //   91: aload_2
    //   92: areturn
    //   93: astore #5
    //   95: aload_0
    //   96: astore_2
    //   97: aload #5
    //   99: astore_0
    //   100: goto -> 110
    //   103: astore_0
    //   104: goto -> 110
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull -> 125
    //   114: aload_3
    //   115: invokevirtual close : ()V
    //   118: goto -> 125
    //   121: astore_3
    //   122: goto -> 140
    //   125: aload_2
    //   126: ifnull -> 133
    //   129: aload_2
    //   130: invokevirtual close : ()V
    //   133: aload_1
    //   134: invokevirtual close : ()V
    //   137: goto -> 147
    //   140: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   143: aload_3
    //   144: invokevirtual println : (Ljava/lang/Object;)V
    //   147: aload_0
    //   148: athrow
    // Exception table:
    //   from	to	target	type
    //   10	19	107	finally
    //   19	28	103	finally
    //   28	34	93	finally
    //   34	41	93	finally
    //   52	60	93	finally
    //   63	68	93	finally
    //   68	80	83	java/lang/Exception
    //   114	118	121	java/lang/Exception
    //   129	133	121	java/lang/Exception
    //   133	137	121	java/lang/Exception
  }
  
  private static char[] readChars(File paramFile) throws IOException {
    // Byte code:
    //   0: new java/io/CharArrayWriter
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_1
    //   8: aconst_null
    //   9: astore_2
    //   10: new java/io/FileReader
    //   13: astore_3
    //   14: aload_3
    //   15: aload_0
    //   16: invokespecial <init> : (Ljava/io/File;)V
    //   19: new java/io/BufferedReader
    //   22: astore_0
    //   23: aload_0
    //   24: aload_3
    //   25: invokespecial <init> : (Ljava/io/Reader;)V
    //   28: sipush #16384
    //   31: newarray char
    //   33: astore_2
    //   34: aload_0
    //   35: aload_2
    //   36: invokevirtual read : ([C)I
    //   39: istore #4
    //   41: iload #4
    //   43: iconst_m1
    //   44: if_icmpeq -> 63
    //   47: iload #4
    //   49: ifle -> 34
    //   52: aload_1
    //   53: aload_2
    //   54: iconst_0
    //   55: iload #4
    //   57: invokevirtual write : ([CII)V
    //   60: goto -> 34
    //   63: aload_1
    //   64: invokevirtual close : ()V
    //   67: aload_0
    //   68: invokevirtual close : ()V
    //   71: aload_3
    //   72: invokevirtual close : ()V
    //   75: goto -> 86
    //   78: astore_0
    //   79: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   82: aload_0
    //   83: invokevirtual println : (Ljava/lang/Object;)V
    //   86: aload_1
    //   87: invokevirtual toCharArray : ()[C
    //   90: areturn
    //   91: astore #5
    //   93: aload_0
    //   94: astore_2
    //   95: aload #5
    //   97: astore_0
    //   98: goto -> 108
    //   101: astore_0
    //   102: goto -> 108
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_3
    //   108: aload_1
    //   109: invokevirtual close : ()V
    //   112: aload_2
    //   113: ifnull -> 120
    //   116: aload_2
    //   117: invokevirtual close : ()V
    //   120: aload_3
    //   121: ifnull -> 139
    //   124: aload_3
    //   125: invokevirtual close : ()V
    //   128: goto -> 139
    //   131: astore_3
    //   132: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   135: aload_3
    //   136: invokevirtual println : (Ljava/lang/Object;)V
    //   139: aload_0
    //   140: athrow
    // Exception table:
    //   from	to	target	type
    //   10	19	105	finally
    //   19	28	101	finally
    //   28	34	91	finally
    //   34	41	91	finally
    //   52	60	91	finally
    //   63	75	78	java/lang/Exception
    //   108	112	131	java/lang/Exception
    //   116	120	131	java/lang/Exception
    //   124	128	131	java/lang/Exception
  }
  
  private static void writeBytes(File paramFile, byte[] paramArrayOfbyte) throws IOException {
    OutputStream outputStream;
    byte[] arrayOfByte = null;
    try {
      outputStream = new FileOutputStream();
    } finally {
      paramFile = null;
      outputStream = null;
    } 
    if (paramArrayOfbyte != null)
      try {
        paramArrayOfbyte.close();
      } catch (Exception exception) {} 
    if (outputStream != null)
      outputStream.close(); 
    throw paramFile;
  }
  
  private static void writeChars(File paramFile, char[] paramArrayOfchar) throws IOException {
    Writer writer;
    char[] arrayOfChar = null;
    try {
      writer = new FileWriter();
    } finally {
      paramFile = null;
      writer = null;
    } 
    if (paramArrayOfchar != null)
      try {
        paramArrayOfchar.close();
      } catch (Exception exception) {} 
    if (writer != null)
      writer.close(); 
    throw paramFile;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sd\\utils\Base64Kit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */