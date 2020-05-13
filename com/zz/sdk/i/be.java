package com.zz.sdk.i;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class be {
  public static final String a = ".";
  
  public static StringBuilder a(InputStream paramInputStream) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: ldc ''
    //   6: invokespecial <init> : (Ljava/lang/String;)V
    //   9: astore_1
    //   10: new java/io/BufferedReader
    //   13: astore_2
    //   14: new java/io/InputStreamReader
    //   17: astore_3
    //   18: aload_3
    //   19: aload_0
    //   20: invokespecial <init> : (Ljava/io/InputStream;)V
    //   23: aload_2
    //   24: aload_3
    //   25: invokespecial <init> : (Ljava/io/Reader;)V
    //   28: aload_2
    //   29: invokevirtual readLine : ()Ljava/lang/String;
    //   32: astore_0
    //   33: aload_0
    //   34: ifnull -> 80
    //   37: aload_1
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: ldc ''
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: ifne -> 56
    //   49: aload_1
    //   50: ldc '\\r\\n'
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_1
    //   57: aload_0
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -> 28
    //   65: astore_0
    //   66: aload_2
    //   67: astore_0
    //   68: aload_0
    //   69: ifnull -> 76
    //   72: aload_0
    //   73: invokevirtual close : ()V
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: areturn
    //   80: aload_2
    //   81: invokevirtual close : ()V
    //   84: aload_1
    //   85: astore_0
    //   86: aload_2
    //   87: ifnull -> 78
    //   90: aload_2
    //   91: invokevirtual close : ()V
    //   94: aload_1
    //   95: astore_0
    //   96: goto -> 78
    //   99: astore_0
    //   100: new java/lang/RuntimeException
    //   103: dup
    //   104: ldc 'IOException occurred. '
    //   106: aload_0
    //   107: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: athrow
    //   111: astore_0
    //   112: new java/lang/RuntimeException
    //   115: dup
    //   116: ldc 'IOException occurred. '
    //   118: aload_0
    //   119: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: athrow
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull -> 134
    //   130: aload_2
    //   131: invokevirtual close : ()V
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: new java/lang/RuntimeException
    //   140: dup
    //   141: ldc 'IOException occurred. '
    //   143: aload_0
    //   144: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: athrow
    //   148: astore_0
    //   149: goto -> 126
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_0
    //   155: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   10	28	152	java/io/IOException
    //   10	28	123	finally
    //   28	33	65	java/io/IOException
    //   28	33	148	finally
    //   37	56	65	java/io/IOException
    //   37	56	148	finally
    //   56	62	65	java/io/IOException
    //   56	62	148	finally
    //   72	76	111	java/io/IOException
    //   80	84	65	java/io/IOException
    //   80	84	148	finally
    //   90	94	99	java/io/IOException
    //   130	134	136	java/io/IOException
  }
  
  public static StringBuilder a(String paramString) {
    try {
      FileInputStream fileInputStream = new FileInputStream();
      this(paramString);
      StringBuilder stringBuilder = a(fileInputStream);
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
      fileNotFoundException = null;
    } 
    return (StringBuilder)fileNotFoundException;
  }
  
  public static boolean a(String paramString, InputStream paramInputStream) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore #4
    //   7: aconst_null
    //   8: astore #5
    //   10: new java/io/File
    //   13: astore #6
    //   15: new java/lang/StringBuilder
    //   18: astore #7
    //   20: aload #7
    //   22: invokespecial <init> : ()V
    //   25: aload #6
    //   27: aload #7
    //   29: aload_0
    //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc '.temp'
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: invokespecial <init> : (Ljava/lang/String;)V
    //   44: aload #6
    //   46: invokevirtual exists : ()Z
    //   49: ifne -> 61
    //   52: aload #6
    //   54: invokevirtual toString : ()Ljava/lang/String;
    //   57: invokestatic n : (Ljava/lang/String;)Z
    //   60: pop
    //   61: new java/io/FileOutputStream
    //   64: astore #7
    //   66: aload #7
    //   68: aload #6
    //   70: invokespecial <init> : (Ljava/io/File;)V
    //   73: sipush #1024
    //   76: newarray byte
    //   78: astore #4
    //   80: aload_1
    //   81: aload #4
    //   83: invokevirtual read : ([B)I
    //   86: istore #8
    //   88: iload #8
    //   90: iconst_m1
    //   91: if_icmpeq -> 131
    //   94: aload #7
    //   96: aload #4
    //   98: iconst_0
    //   99: iload #8
    //   101: invokevirtual write : ([BII)V
    //   104: goto -> 80
    //   107: astore_0
    //   108: iload_2
    //   109: istore #9
    //   111: aload #7
    //   113: ifnull -> 128
    //   116: aload #7
    //   118: invokevirtual close : ()V
    //   121: aload_1
    //   122: invokevirtual close : ()V
    //   125: iload_2
    //   126: istore #9
    //   128: iload #9
    //   130: ireturn
    //   131: aload #7
    //   133: invokevirtual flush : ()V
    //   136: new java/io/File
    //   139: astore #4
    //   141: aload #4
    //   143: aload_0
    //   144: invokespecial <init> : (Ljava/lang/String;)V
    //   147: aload #6
    //   149: aload #4
    //   151: invokevirtual renameTo : (Ljava/io/File;)Z
    //   154: istore #9
    //   156: iload #9
    //   158: istore_2
    //   159: iload_2
    //   160: istore #9
    //   162: aload #7
    //   164: ifnull -> 128
    //   167: aload #7
    //   169: invokevirtual close : ()V
    //   172: aload_1
    //   173: invokevirtual close : ()V
    //   176: iload_2
    //   177: istore #9
    //   179: goto -> 128
    //   182: astore_0
    //   183: iload_2
    //   184: istore #9
    //   186: goto -> 128
    //   189: astore_0
    //   190: aload_3
    //   191: astore #7
    //   193: iload_2
    //   194: istore #9
    //   196: aload #7
    //   198: ifnull -> 128
    //   201: aload #7
    //   203: invokevirtual close : ()V
    //   206: aload_1
    //   207: invokevirtual close : ()V
    //   210: iload_2
    //   211: istore #9
    //   213: goto -> 128
    //   216: astore_0
    //   217: iload_2
    //   218: istore #9
    //   220: goto -> 128
    //   223: astore_0
    //   224: aload #4
    //   226: astore #7
    //   228: aload #7
    //   230: ifnull -> 242
    //   233: aload #7
    //   235: invokevirtual close : ()V
    //   238: aload_1
    //   239: invokevirtual close : ()V
    //   242: aload_0
    //   243: athrow
    //   244: astore_1
    //   245: goto -> 242
    //   248: astore_0
    //   249: goto -> 228
    //   252: astore_0
    //   253: goto -> 193
    //   256: astore_0
    //   257: iload_2
    //   258: istore #9
    //   260: goto -> 128
    //   263: astore_0
    //   264: aload #5
    //   266: astore #7
    //   268: goto -> 108
    // Exception table:
    //   from	to	target	type
    //   10	61	263	java/io/FileNotFoundException
    //   10	61	189	java/io/IOException
    //   10	61	223	finally
    //   61	73	263	java/io/FileNotFoundException
    //   61	73	189	java/io/IOException
    //   61	73	223	finally
    //   73	80	107	java/io/FileNotFoundException
    //   73	80	252	java/io/IOException
    //   73	80	248	finally
    //   80	88	107	java/io/FileNotFoundException
    //   80	88	252	java/io/IOException
    //   80	88	248	finally
    //   94	104	107	java/io/FileNotFoundException
    //   94	104	252	java/io/IOException
    //   94	104	248	finally
    //   116	125	256	java/io/IOException
    //   131	156	107	java/io/FileNotFoundException
    //   131	156	252	java/io/IOException
    //   131	156	248	finally
    //   167	176	182	java/io/IOException
    //   201	210	216	java/io/IOException
    //   233	242	244	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic n : (Ljava/lang/String;)Z
    //   4: pop
    //   5: new java/io/FileWriter
    //   8: astore_3
    //   9: aload_3
    //   10: aload_0
    //   11: iload_2
    //   12: invokespecial <init> : (Ljava/lang/String;Z)V
    //   15: aload_3
    //   16: astore_0
    //   17: aload_3
    //   18: aload_1
    //   19: invokevirtual write : (Ljava/lang/String;)V
    //   22: aload_3
    //   23: astore_0
    //   24: aload_3
    //   25: invokevirtual close : ()V
    //   28: aload_3
    //   29: ifnull -> 36
    //   32: aload_3
    //   33: invokevirtual close : ()V
    //   36: iconst_1
    //   37: ireturn
    //   38: astore_0
    //   39: new java/lang/RuntimeException
    //   42: dup
    //   43: ldc 'IOException occurred. '
    //   45: aload_0
    //   46: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   49: athrow
    //   50: astore #4
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: astore_0
    //   56: new java/lang/RuntimeException
    //   59: astore_3
    //   60: aload_1
    //   61: astore_0
    //   62: aload_3
    //   63: ldc 'IOException occurred. '
    //   65: aload #4
    //   67: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: aload_1
    //   71: astore_0
    //   72: aload_3
    //   73: athrow
    //   74: astore_1
    //   75: aload_0
    //   76: ifnull -> 83
    //   79: aload_0
    //   80: invokevirtual close : ()V
    //   83: aload_1
    //   84: athrow
    //   85: astore_0
    //   86: new java/lang/RuntimeException
    //   89: dup
    //   90: ldc 'IOException occurred. '
    //   92: aload_0
    //   93: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   96: athrow
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: goto -> 75
    //   103: astore #4
    //   105: aload_3
    //   106: astore_1
    //   107: goto -> 54
    // Exception table:
    //   from	to	target	type
    //   0	15	50	java/io/IOException
    //   0	15	97	finally
    //   17	22	103	java/io/IOException
    //   17	22	74	finally
    //   24	28	103	java/io/IOException
    //   24	28	74	finally
    //   32	36	38	java/io/IOException
    //   56	60	74	finally
    //   62	70	74	finally
    //   72	74	74	finally
    //   79	83	85	java/io/IOException
  }
  
  public static List b(InputStream paramInputStream) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new java/util/ArrayList
    //   7: dup
    //   8: invokespecial <init> : ()V
    //   11: astore_3
    //   12: aload_0
    //   13: ifnull -> 162
    //   16: aload_1
    //   17: astore #4
    //   19: new java/io/BufferedReader
    //   22: astore #5
    //   24: aload_1
    //   25: astore #4
    //   27: new java/io/InputStreamReader
    //   30: astore #6
    //   32: aload_1
    //   33: astore #4
    //   35: aload #6
    //   37: aload_0
    //   38: invokespecial <init> : (Ljava/io/InputStream;)V
    //   41: aload_1
    //   42: astore #4
    //   44: aload #5
    //   46: aload #6
    //   48: invokespecial <init> : (Ljava/io/Reader;)V
    //   51: aload #5
    //   53: invokevirtual readLine : ()Ljava/lang/String;
    //   56: astore_0
    //   57: aload_0
    //   58: ifnull -> 117
    //   61: aload_3
    //   62: aload_0
    //   63: invokeinterface add : (Ljava/lang/Object;)Z
    //   68: pop
    //   69: goto -> 51
    //   72: astore #4
    //   74: aload #5
    //   76: astore_0
    //   77: aload #4
    //   79: astore #5
    //   81: aload_0
    //   82: astore #4
    //   84: new java/lang/RuntimeException
    //   87: astore_2
    //   88: aload_0
    //   89: astore #4
    //   91: aload_2
    //   92: ldc 'IOException occurred. '
    //   94: aload #5
    //   96: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_0
    //   100: astore #4
    //   102: aload_2
    //   103: athrow
    //   104: astore_0
    //   105: aload #4
    //   107: ifnull -> 115
    //   110: aload #4
    //   112: invokevirtual close : ()V
    //   115: aload_0
    //   116: athrow
    //   117: aload #5
    //   119: invokevirtual close : ()V
    //   122: aload_3
    //   123: astore_0
    //   124: aload #5
    //   126: ifnull -> 136
    //   129: aload #5
    //   131: invokevirtual close : ()V
    //   134: aload_3
    //   135: astore_0
    //   136: aload_0
    //   137: areturn
    //   138: astore_0
    //   139: new java/lang/RuntimeException
    //   142: dup
    //   143: ldc 'IOException occurred. '
    //   145: aload_0
    //   146: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: athrow
    //   150: astore_0
    //   151: new java/lang/RuntimeException
    //   154: dup
    //   155: ldc 'IOException occurred. '
    //   157: aload_0
    //   158: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: athrow
    //   162: aconst_null
    //   163: astore_0
    //   164: goto -> 136
    //   167: astore_0
    //   168: aload #5
    //   170: astore #4
    //   172: goto -> 105
    //   175: astore #5
    //   177: aload_2
    //   178: astore_0
    //   179: goto -> 81
    // Exception table:
    //   from	to	target	type
    //   19	24	175	java/io/IOException
    //   19	24	104	finally
    //   27	32	175	java/io/IOException
    //   27	32	104	finally
    //   35	41	175	java/io/IOException
    //   35	41	104	finally
    //   44	51	175	java/io/IOException
    //   44	51	104	finally
    //   51	57	72	java/io/IOException
    //   51	57	167	finally
    //   61	69	72	java/io/IOException
    //   61	69	167	finally
    //   84	88	104	finally
    //   91	99	104	finally
    //   102	104	104	finally
    //   110	115	150	java/io/IOException
    //   117	122	72	java/io/IOException
    //   117	122	167	finally
    //   129	134	138	java/io/IOException
  }
  
  public static byte[] b(String paramString) {
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
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: sipush #1024
    //   22: newarray byte
    //   24: astore_0
    //   25: aload_3
    //   26: aload_0
    //   27: invokevirtual read : ([B)I
    //   30: istore #4
    //   32: iload #4
    //   34: iconst_m1
    //   35: if_icmpeq -> 74
    //   38: aload_1
    //   39: aload_0
    //   40: iconst_0
    //   41: iload #4
    //   43: invokevirtual write : ([BII)V
    //   46: goto -> 25
    //   49: astore_0
    //   50: aload_3
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull -> 60
    //   56: aload_1
    //   57: invokevirtual close : ()V
    //   60: aload_0
    //   61: ifnull -> 68
    //   64: aload_0
    //   65: invokevirtual close : ()V
    //   68: iconst_0
    //   69: newarray byte
    //   71: astore_2
    //   72: aload_2
    //   73: areturn
    //   74: aload_1
    //   75: invokevirtual toByteArray : ()[B
    //   78: astore_0
    //   79: aload_1
    //   80: ifnull -> 87
    //   83: aload_1
    //   84: invokevirtual close : ()V
    //   87: aload_0
    //   88: astore_2
    //   89: aload_3
    //   90: ifnull -> 72
    //   93: aload_3
    //   94: invokevirtual close : ()V
    //   97: aload_0
    //   98: astore_2
    //   99: goto -> 72
    //   102: astore_3
    //   103: aload_0
    //   104: astore_2
    //   105: goto -> 72
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_3
    //   111: aload_1
    //   112: ifnull -> 119
    //   115: aload_1
    //   116: invokevirtual close : ()V
    //   119: aload_3
    //   120: ifnull -> 127
    //   123: aload_3
    //   124: invokevirtual close : ()V
    //   127: aload_0
    //   128: athrow
    //   129: astore_3
    //   130: goto -> 127
    //   133: astore_0
    //   134: goto -> 111
    //   137: astore_0
    //   138: goto -> 68
    //   141: astore_0
    //   142: aload_2
    //   143: astore_0
    //   144: goto -> 52
    // Exception table:
    //   from	to	target	type
    //   10	19	141	java/lang/Exception
    //   10	19	108	finally
    //   19	25	49	java/lang/Exception
    //   19	25	133	finally
    //   25	32	49	java/lang/Exception
    //   25	32	133	finally
    //   38	46	49	java/lang/Exception
    //   38	46	133	finally
    //   56	60	137	java/lang/Exception
    //   64	68	137	java/lang/Exception
    //   74	79	49	java/lang/Exception
    //   74	79	133	finally
    //   83	87	102	java/lang/Exception
    //   93	97	102	java/lang/Exception
    //   115	119	129	java/lang/Exception
    //   123	127	129	java/lang/Exception
  }
  
  public static List c(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: new java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial <init> : (Ljava/lang/String;)V
    //   12: astore_3
    //   13: new java/util/ArrayList
    //   16: dup
    //   17: invokespecial <init> : ()V
    //   20: astore #4
    //   22: aload_3
    //   23: ifnull -> 171
    //   26: aload_3
    //   27: invokevirtual isFile : ()Z
    //   30: ifeq -> 171
    //   33: aload_1
    //   34: astore_0
    //   35: new java/io/BufferedReader
    //   38: astore #5
    //   40: aload_1
    //   41: astore_0
    //   42: new java/io/FileReader
    //   45: astore #6
    //   47: aload_1
    //   48: astore_0
    //   49: aload #6
    //   51: aload_3
    //   52: invokespecial <init> : (Ljava/io/File;)V
    //   55: aload_1
    //   56: astore_0
    //   57: aload #5
    //   59: aload #6
    //   61: invokespecial <init> : (Ljava/io/Reader;)V
    //   64: aload #5
    //   66: invokevirtual readLine : ()Ljava/lang/String;
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull -> 124
    //   74: aload #4
    //   76: aload_0
    //   77: invokeinterface add : (Ljava/lang/Object;)Z
    //   82: pop
    //   83: goto -> 64
    //   86: astore #4
    //   88: aload #5
    //   90: astore_0
    //   91: new java/lang/RuntimeException
    //   94: astore_2
    //   95: aload #5
    //   97: astore_0
    //   98: aload_2
    //   99: ldc 'IOException occurred. '
    //   101: aload #4
    //   103: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload #5
    //   108: astore_0
    //   109: aload_2
    //   110: athrow
    //   111: astore #5
    //   113: aload_0
    //   114: ifnull -> 121
    //   117: aload_0
    //   118: invokevirtual close : ()V
    //   121: aload #5
    //   123: athrow
    //   124: aload #5
    //   126: invokevirtual close : ()V
    //   129: aload #4
    //   131: astore_0
    //   132: aload #5
    //   134: ifnull -> 145
    //   137: aload #5
    //   139: invokevirtual close : ()V
    //   142: aload #4
    //   144: astore_0
    //   145: aload_0
    //   146: areturn
    //   147: astore_0
    //   148: new java/lang/RuntimeException
    //   151: dup
    //   152: ldc 'IOException occurred. '
    //   154: aload_0
    //   155: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: athrow
    //   159: astore_0
    //   160: new java/lang/RuntimeException
    //   163: dup
    //   164: ldc 'IOException occurred. '
    //   166: aload_0
    //   167: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   170: athrow
    //   171: aconst_null
    //   172: astore_0
    //   173: goto -> 145
    //   176: astore_0
    //   177: aload #5
    //   179: astore #4
    //   181: aload_0
    //   182: astore #5
    //   184: aload #4
    //   186: astore_0
    //   187: goto -> 113
    //   190: astore #4
    //   192: aload_2
    //   193: astore #5
    //   195: goto -> 88
    // Exception table:
    //   from	to	target	type
    //   35	40	190	java/io/IOException
    //   35	40	111	finally
    //   42	47	190	java/io/IOException
    //   42	47	111	finally
    //   49	55	190	java/io/IOException
    //   49	55	111	finally
    //   57	64	190	java/io/IOException
    //   57	64	111	finally
    //   64	70	86	java/io/IOException
    //   64	70	176	finally
    //   74	83	86	java/io/IOException
    //   74	83	176	finally
    //   91	95	111	finally
    //   98	106	111	finally
    //   109	111	111	finally
    //   117	121	159	java/io/IOException
    //   124	129	86	java/io/IOException
    //   124	129	176	finally
    //   137	142	147	java/io/IOException
  }
  
  public static String d(String paramString) {
    int i = paramString.lastIndexOf(".");
    int j = paramString.lastIndexOf(File.separator);
    if (j == -1) {
      if (i != -1)
        paramString = paramString.substring(0, i); 
      return paramString;
    } 
    return (i == -1) ? paramString.substring(j + 1) : ((j < i) ? paramString.substring(j + 1, i) : paramString.substring(j + 1));
  }
  
  public static String e(String paramString) {
    int i = paramString.lastIndexOf(File.separator);
    if (i != -1)
      paramString = paramString.substring(i + 1); 
    return paramString;
  }
  
  public static String f(String paramString) {
    int i = paramString.lastIndexOf(File.separator);
    return (i == -1) ? "" : paramString.substring(0, i);
  }
  
  public static String g(String paramString) {
    int i = paramString.lastIndexOf(".");
    int j = paramString.lastIndexOf(File.separator);
    return (i == -1) ? "" : ((j >= i) ? "" : paramString.substring(i + 1));
  }
  
  public static boolean h(String paramString) {
    File file = new File(paramString);
    return (file.exists() && file.isDirectory()) ? true : file.mkdirs();
  }
  
  public static boolean i(String paramString) {
    return h(paramString);
  }
  
  public static boolean j(String paramString) {
    File file = new File(paramString);
    return (file.exists() && file.isFile());
  }
  
  public static boolean k(String paramString) {
    File file = new File(paramString);
    return (file.exists() && file.isDirectory());
  }
  
  public static boolean l(String paramString) {
    byte b = 0;
    null = false;
    File file = new File(paramString);
    if (file.exists()) {
      if (file.isFile())
        return file.delete(); 
      if (file.isDirectory()) {
        File[] arrayOfFile = file.listFiles();
        int i = arrayOfFile.length;
        while (b < i) {
          File file1 = arrayOfFile[b];
          if (file1.isFile()) {
            file1.delete();
          } else if (file1.isDirectory()) {
            l(file1.getAbsolutePath());
          } 
          b++;
        } 
        null = file.delete();
      } 
      return null;
    } 
    return true;
  }
  
  public static long m(String paramString) {
    File file = new File(paramString);
    return (file.exists() && file.isFile()) ? file.length() : -1L;
  }
  
  public static boolean n(String paramString) {
    boolean bool;
    try {
      h(f(paramString));
      File file = new File();
      this(paramString);
      bool = file.createNewFile();
    } catch (Exception exception) {
      exception.printStackTrace();
      bool = false;
    } 
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\i\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */