package com.alipay.sdk.encrypt;

import java.io.IOException;

public final class c {
  public static byte[] a(byte[] paramArrayOfbyte) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new java/io/ByteArrayInputStream
    //   5: astore_2
    //   6: aload_2
    //   7: aload_0
    //   8: invokespecial <init> : ([B)V
    //   11: new java/io/ByteArrayOutputStream
    //   14: astore_0
    //   15: aload_0
    //   16: invokespecial <init> : ()V
    //   19: new java/util/zip/GZIPOutputStream
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   28: sipush #4096
    //   31: newarray byte
    //   33: astore #4
    //   35: aload_2
    //   36: aload #4
    //   38: invokevirtual read : ([B)I
    //   41: istore #5
    //   43: iload #5
    //   45: iconst_m1
    //   46: if_icmpeq -> 101
    //   49: aload_3
    //   50: aload #4
    //   52: iconst_0
    //   53: iload #5
    //   55: invokevirtual write : ([BII)V
    //   58: goto -> 35
    //   61: astore #6
    //   63: aload_2
    //   64: astore #4
    //   66: aload_0
    //   67: astore_1
    //   68: aload_3
    //   69: astore_2
    //   70: aload #6
    //   72: astore_0
    //   73: aload #4
    //   75: ifnull -> 83
    //   78: aload #4
    //   80: invokevirtual close : ()V
    //   83: aload_1
    //   84: ifnull -> 91
    //   87: aload_1
    //   88: invokevirtual close : ()V
    //   91: aload_2
    //   92: ifnull -> 99
    //   95: aload_2
    //   96: invokevirtual close : ()V
    //   99: aload_0
    //   100: athrow
    //   101: aload_3
    //   102: invokevirtual flush : ()V
    //   105: aload_3
    //   106: invokevirtual finish : ()V
    //   109: aload_0
    //   110: invokevirtual toByteArray : ()[B
    //   113: astore #4
    //   115: aload_2
    //   116: invokevirtual close : ()V
    //   119: aload_0
    //   120: invokevirtual close : ()V
    //   123: aload_3
    //   124: invokevirtual close : ()V
    //   127: aload #4
    //   129: areturn
    //   130: astore_2
    //   131: goto -> 119
    //   134: astore_0
    //   135: goto -> 123
    //   138: astore_0
    //   139: goto -> 127
    //   142: astore #4
    //   144: goto -> 83
    //   147: astore #4
    //   149: goto -> 91
    //   152: astore_2
    //   153: goto -> 99
    //   156: astore_0
    //   157: aconst_null
    //   158: astore_2
    //   159: aconst_null
    //   160: astore #4
    //   162: goto -> 73
    //   165: astore_0
    //   166: aconst_null
    //   167: astore #6
    //   169: aload_2
    //   170: astore #4
    //   172: aload #6
    //   174: astore_2
    //   175: goto -> 73
    //   178: astore #6
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_0
    //   183: astore_1
    //   184: aload_2
    //   185: astore #4
    //   187: aload #6
    //   189: astore_0
    //   190: aload_3
    //   191: astore_2
    //   192: goto -> 73
    // Exception table:
    //   from	to	target	type
    //   2	11	156	finally
    //   11	19	165	finally
    //   19	28	178	finally
    //   28	35	61	finally
    //   35	43	61	finally
    //   49	58	61	finally
    //   78	83	142	java/lang/Exception
    //   87	91	147	java/lang/Exception
    //   95	99	152	java/lang/Exception
    //   101	115	61	finally
    //   115	119	130	java/lang/Exception
    //   119	123	134	java/lang/Exception
    //   123	127	138	java/lang/Exception
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) throws IOException {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new java/io/ByteArrayInputStream
    //   5: astore_2
    //   6: aload_2
    //   7: aload_0
    //   8: invokespecial <init> : ([B)V
    //   11: new java/util/zip/GZIPInputStream
    //   14: astore_3
    //   15: aload_3
    //   16: aload_2
    //   17: invokespecial <init> : (Ljava/io/InputStream;)V
    //   20: sipush #4096
    //   23: newarray byte
    //   25: astore_0
    //   26: new java/io/ByteArrayOutputStream
    //   29: astore #4
    //   31: aload #4
    //   33: invokespecial <init> : ()V
    //   36: aload_3
    //   37: aload_0
    //   38: iconst_0
    //   39: sipush #4096
    //   42: invokevirtual read : ([BII)I
    //   45: istore #5
    //   47: iload #5
    //   49: iconst_m1
    //   50: if_icmpeq -> 83
    //   53: aload #4
    //   55: aload_0
    //   56: iconst_0
    //   57: iload #5
    //   59: invokevirtual write : ([BII)V
    //   62: goto -> 36
    //   65: astore_0
    //   66: aload #4
    //   68: astore_1
    //   69: aload_1
    //   70: invokevirtual close : ()V
    //   73: aload_3
    //   74: invokevirtual close : ()V
    //   77: aload_2
    //   78: invokevirtual close : ()V
    //   81: aload_0
    //   82: athrow
    //   83: aload #4
    //   85: invokevirtual flush : ()V
    //   88: aload #4
    //   90: invokevirtual toByteArray : ()[B
    //   93: astore_0
    //   94: aload #4
    //   96: invokevirtual close : ()V
    //   99: aload_3
    //   100: invokevirtual close : ()V
    //   103: aload_2
    //   104: invokevirtual close : ()V
    //   107: aload_0
    //   108: areturn
    //   109: astore_1
    //   110: goto -> 99
    //   113: astore_3
    //   114: goto -> 103
    //   117: astore_2
    //   118: goto -> 107
    //   121: astore_1
    //   122: goto -> 73
    //   125: astore_3
    //   126: goto -> 77
    //   129: astore_2
    //   130: goto -> 81
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_2
    //   138: goto -> 69
    //   141: astore_0
    //   142: aconst_null
    //   143: astore_3
    //   144: goto -> 69
    //   147: astore_0
    //   148: goto -> 69
    // Exception table:
    //   from	to	target	type
    //   2	11	133	finally
    //   11	20	141	finally
    //   20	36	147	finally
    //   36	47	65	finally
    //   53	62	65	finally
    //   69	73	121	java/lang/Exception
    //   73	77	125	java/lang/Exception
    //   77	81	129	java/lang/Exception
    //   83	94	65	finally
    //   94	99	109	java/lang/Exception
    //   99	103	113	java/lang/Exception
    //   103	107	117	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\encrypt\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */