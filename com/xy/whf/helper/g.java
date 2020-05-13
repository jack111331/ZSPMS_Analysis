package com.xy.whf.helper;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class g {
  public static final String a = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "yywhfsdk";
  
  private static String b = a + File.separator + "XNlcml" + File.separator + "dXNlcmluZmWhf3.dat";
  
  public static String a() {
    String str;
    try {
      str = c.c(a(b));
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public static String a(Context paramContext, String paramString) {
    return a(paramContext, paramString, "");
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2) {
    return paramContext.getSharedPreferences("yywhfSps", 0).getString(paramString1, paramString2);
  }
  
  public static String a(String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore_3
    //   6: new java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial <init> : (Ljava/lang/String;)V
    //   14: astore #4
    //   16: new java/lang/StringBuilder
    //   19: astore #5
    //   21: aload #5
    //   23: ldc ''
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload #4
    //   30: invokevirtual exists : ()Z
    //   33: ifeq -> 293
    //   36: new java/io/InputStreamReader
    //   39: astore_0
    //   40: new java/io/FileInputStream
    //   43: astore_1
    //   44: aload_1
    //   45: aload #4
    //   47: invokespecial <init> : (Ljava/io/File;)V
    //   50: aload_0
    //   51: aload_1
    //   52: ldc 'utf-8'
    //   54: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   57: new java/io/BufferedReader
    //   60: astore_1
    //   61: aload_1
    //   62: aload_0
    //   63: invokespecial <init> : (Ljava/io/Reader;)V
    //   66: aload_1
    //   67: invokevirtual readLine : ()Ljava/lang/String;
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull -> 143
    //   75: aload #5
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: ldc ''
    //   82: invokevirtual equals : (Ljava/lang/Object;)Z
    //   85: ifne -> 96
    //   88: aload #5
    //   90: ldc '\\r\\n'
    //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload #5
    //   98: aload_3
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: goto -> 66
    //   106: astore_2
    //   107: aload_0
    //   108: astore_3
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: astore_1
    //   113: aload_0
    //   114: astore_2
    //   115: aload_3
    //   116: astore #4
    //   118: aload_1
    //   119: invokevirtual printStackTrace : ()V
    //   122: aload_3
    //   123: ifnull -> 130
    //   126: aload_3
    //   127: invokevirtual close : ()V
    //   130: aload_0
    //   131: ifnull -> 138
    //   134: aload_0
    //   135: invokevirtual close : ()V
    //   138: ldc ''
    //   140: astore_3
    //   141: aload_3
    //   142: areturn
    //   143: aload_0
    //   144: astore_3
    //   145: aload_1
    //   146: astore_0
    //   147: aload_0
    //   148: astore_2
    //   149: aload_3
    //   150: astore #4
    //   152: aload #5
    //   154: invokevirtual toString : ()Ljava/lang/String;
    //   157: astore_1
    //   158: aload_3
    //   159: ifnull -> 166
    //   162: aload_3
    //   163: invokevirtual close : ()V
    //   166: aload_1
    //   167: astore_3
    //   168: aload_0
    //   169: ifnull -> 141
    //   172: aload_0
    //   173: invokevirtual close : ()V
    //   176: aload_1
    //   177: astore_3
    //   178: goto -> 141
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual printStackTrace : ()V
    //   186: aload_1
    //   187: astore_3
    //   188: goto -> 141
    //   191: astore_3
    //   192: aload_3
    //   193: invokevirtual printStackTrace : ()V
    //   196: goto -> 166
    //   199: astore_3
    //   200: aload_3
    //   201: invokevirtual printStackTrace : ()V
    //   204: goto -> 130
    //   207: astore_0
    //   208: aload_0
    //   209: invokevirtual printStackTrace : ()V
    //   212: goto -> 138
    //   215: astore_3
    //   216: aconst_null
    //   217: astore_0
    //   218: aload_2
    //   219: astore_1
    //   220: aload_0
    //   221: ifnull -> 228
    //   224: aload_0
    //   225: invokevirtual close : ()V
    //   228: aload_1
    //   229: ifnull -> 236
    //   232: aload_1
    //   233: invokevirtual close : ()V
    //   236: aload_3
    //   237: athrow
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual printStackTrace : ()V
    //   243: goto -> 228
    //   246: astore_0
    //   247: aload_0
    //   248: invokevirtual printStackTrace : ()V
    //   251: goto -> 236
    //   254: astore_3
    //   255: aload_2
    //   256: astore_1
    //   257: goto -> 220
    //   260: astore_3
    //   261: goto -> 220
    //   264: astore_3
    //   265: aload #4
    //   267: astore_0
    //   268: aload_2
    //   269: astore_1
    //   270: goto -> 220
    //   273: astore_1
    //   274: aconst_null
    //   275: astore_0
    //   276: goto -> 113
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_2
    //   282: aload_0
    //   283: astore_3
    //   284: aload_2
    //   285: astore_0
    //   286: goto -> 113
    //   289: astore_1
    //   290: goto -> 113
    //   293: aconst_null
    //   294: astore_0
    //   295: aload_1
    //   296: astore_3
    //   297: goto -> 147
    // Exception table:
    //   from	to	target	type
    //   16	57	273	java/lang/Exception
    //   16	57	215	finally
    //   57	66	279	java/lang/Exception
    //   57	66	254	finally
    //   66	71	106	java/lang/Exception
    //   66	71	260	finally
    //   75	96	106	java/lang/Exception
    //   75	96	260	finally
    //   96	103	106	java/lang/Exception
    //   96	103	260	finally
    //   118	122	264	finally
    //   126	130	199	java/io/IOException
    //   134	138	207	java/io/IOException
    //   152	158	289	java/lang/Exception
    //   152	158	264	finally
    //   162	166	191	java/io/IOException
    //   172	176	181	java/io/IOException
    //   224	228	238	java/io/IOException
    //   232	236	246	java/io/IOException
  }
  
  public static void a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore #4
    //   7: aload_1
    //   8: invokestatic c : (Ljava/lang/String;)V
    //   11: aload_2
    //   12: astore #4
    //   14: new java/io/File
    //   17: astore #5
    //   19: aload_2
    //   20: astore #4
    //   22: aload #5
    //   24: aload_1
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: aload_2
    //   29: astore #4
    //   31: aload #5
    //   33: invokevirtual exists : ()Z
    //   36: ifne -> 48
    //   39: aload_2
    //   40: astore #4
    //   42: aload #5
    //   44: invokevirtual createNewFile : ()Z
    //   47: pop
    //   48: aload_2
    //   49: astore #4
    //   51: new java/io/FileOutputStream
    //   54: astore_1
    //   55: aload_2
    //   56: astore #4
    //   58: aload_1
    //   59: aload #5
    //   61: invokespecial <init> : (Ljava/io/File;)V
    //   64: aload_1
    //   65: aload_0
    //   66: invokevirtual getBytes : ()[B
    //   69: invokevirtual write : ([B)V
    //   72: aload_1
    //   73: ifnull -> 80
    //   76: aload_1
    //   77: invokevirtual close : ()V
    //   80: return
    //   81: astore_0
    //   82: aload_0
    //   83: invokevirtual printStackTrace : ()V
    //   86: goto -> 80
    //   89: astore_1
    //   90: aload_3
    //   91: astore_0
    //   92: aload_0
    //   93: astore #4
    //   95: aload_1
    //   96: invokevirtual printStackTrace : ()V
    //   99: aload_0
    //   100: ifnull -> 80
    //   103: aload_0
    //   104: invokevirtual close : ()V
    //   107: goto -> 80
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual printStackTrace : ()V
    //   115: goto -> 80
    //   118: astore_0
    //   119: aload #4
    //   121: ifnull -> 129
    //   124: aload #4
    //   126: invokevirtual close : ()V
    //   129: aload_0
    //   130: athrow
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual printStackTrace : ()V
    //   136: goto -> 129
    //   139: astore_0
    //   140: aload_1
    //   141: astore #4
    //   143: goto -> 119
    //   146: astore #4
    //   148: aload_1
    //   149: astore_0
    //   150: aload #4
    //   152: astore_1
    //   153: goto -> 92
    // Exception table:
    //   from	to	target	type
    //   7	11	89	java/lang/Exception
    //   7	11	118	finally
    //   14	19	89	java/lang/Exception
    //   14	19	118	finally
    //   22	28	89	java/lang/Exception
    //   22	28	118	finally
    //   31	39	89	java/lang/Exception
    //   31	39	118	finally
    //   42	48	89	java/lang/Exception
    //   42	48	118	finally
    //   51	55	89	java/lang/Exception
    //   51	55	118	finally
    //   58	64	89	java/lang/Exception
    //   58	64	118	finally
    //   64	72	146	java/lang/Exception
    //   64	72	139	finally
    //   76	80	81	java/lang/Exception
    //   95	99	118	finally
    //   103	107	110	java/lang/Exception
    //   124	129	131	java/lang/Exception
  }
  
  public static void b(String paramString) {
    if (paramString != null)
      try {
        a(c.d(paramString), b);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  private static void c(String paramString) {
    paramString = d(paramString);
    if (!LangHelper.isNullOrEmpty(paramString)) {
      File file = new File(paramString);
      if (!file.exists())
        file.mkdirs(); 
    } 
  }
  
  private static String d(String paramString) {
    if (paramString.isEmpty())
      return ""; 
    int i = paramString.lastIndexOf(File.separator);
    return (i == -1) ? "" : paramString.substring(0, i);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\xy\whf\helper\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */