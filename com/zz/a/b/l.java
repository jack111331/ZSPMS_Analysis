package com.zz.a.b;

import android.os.Environment;
import android.util.Pair;
import com.zz.lib.org.myapache.commons.codec.binary.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class l {
  public static final String a = "/Android/data/code/game/ZM.DAT";
  
  private static final String b = "www.douwan.cn";
  
  private static final Pattern c = Pattern.compile("\\d+");
  
  public static Pair a() {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: new java/io/File
    //   5: dup
    //   6: new java/io/File
    //   9: dup
    //   10: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   13: ldc '/Android/data/code/game/ZM.DAT'
    //   15: iconst_0
    //   16: ldc '/Android/data/code/game/ZM.DAT'
    //   18: ldc '/'
    //   20: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   23: invokevirtual substring : (II)Ljava/lang/String;
    //   26: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   29: ldc '/Android/data/code/game/ZM.DAT'
    //   31: ldc '/Android/data/code/game/ZM.DAT'
    //   33: ldc '/'
    //   35: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   38: iconst_1
    //   39: iadd
    //   40: ldc '/Android/data/code/game/ZM.DAT'
    //   42: invokevirtual length : ()I
    //   45: invokevirtual substring : (II)Ljava/lang/String;
    //   48: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   51: astore_1
    //   52: new java/io/FileInputStream
    //   55: astore_2
    //   56: aload_2
    //   57: aload_1
    //   58: invokespecial <init> : (Ljava/io/File;)V
    //   61: aload_2
    //   62: astore_3
    //   63: aload_1
    //   64: invokevirtual length : ()J
    //   67: lstore #4
    //   69: lload #4
    //   71: l2i
    //   72: istore #6
    //   74: iload #6
    //   76: ifne -> 103
    //   79: aload_0
    //   80: astore_3
    //   81: aload_2
    //   82: ifnull -> 91
    //   85: aload_2
    //   86: invokevirtual close : ()V
    //   89: aload_0
    //   90: astore_3
    //   91: aload_3
    //   92: areturn
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual printStackTrace : ()V
    //   98: aload_0
    //   99: astore_3
    //   100: goto -> 91
    //   103: aload_2
    //   104: astore_3
    //   105: iload #6
    //   107: newarray byte
    //   109: astore #7
    //   111: aload_2
    //   112: astore_3
    //   113: aload_2
    //   114: aload #7
    //   116: invokevirtual read : ([B)I
    //   119: pop
    //   120: aload_2
    //   121: astore_3
    //   122: new java/lang/String
    //   125: astore_1
    //   126: aload_2
    //   127: astore_3
    //   128: aload_1
    //   129: aload #7
    //   131: invokespecial <init> : ([B)V
    //   134: aload_2
    //   135: astore_3
    //   136: aload_1
    //   137: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   140: ldc '\|\|'
    //   142: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   145: astore #7
    //   147: aload #7
    //   149: ifnull -> 202
    //   152: aload_2
    //   153: astore_3
    //   154: aload #7
    //   156: arraylength
    //   157: iconst_2
    //   158: if_icmpne -> 202
    //   161: aload_2
    //   162: astore_3
    //   163: new android/util/Pair
    //   166: astore_1
    //   167: aload_2
    //   168: astore_3
    //   169: aload_1
    //   170: aload #7
    //   172: iconst_0
    //   173: aaload
    //   174: aload #7
    //   176: iconst_1
    //   177: aaload
    //   178: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   181: aload_2
    //   182: ifnull -> 189
    //   185: aload_2
    //   186: invokevirtual close : ()V
    //   189: aload_1
    //   190: astore_3
    //   191: goto -> 91
    //   194: astore_3
    //   195: aload_3
    //   196: invokevirtual printStackTrace : ()V
    //   199: goto -> 189
    //   202: aload_0
    //   203: astore_3
    //   204: aload_2
    //   205: ifnull -> 91
    //   208: aload_2
    //   209: invokevirtual close : ()V
    //   212: aload_0
    //   213: astore_3
    //   214: goto -> 91
    //   217: astore_3
    //   218: aload_3
    //   219: invokevirtual printStackTrace : ()V
    //   222: aload_0
    //   223: astore_3
    //   224: goto -> 91
    //   227: astore_1
    //   228: aconst_null
    //   229: astore_2
    //   230: aload_2
    //   231: astore_3
    //   232: aload_1
    //   233: invokevirtual printStackTrace : ()V
    //   236: aload_0
    //   237: astore_3
    //   238: aload_2
    //   239: ifnull -> 91
    //   242: aload_2
    //   243: invokevirtual close : ()V
    //   246: aload_0
    //   247: astore_3
    //   248: goto -> 91
    //   251: astore_3
    //   252: aload_3
    //   253: invokevirtual printStackTrace : ()V
    //   256: aload_0
    //   257: astore_3
    //   258: goto -> 91
    //   261: astore_2
    //   262: aconst_null
    //   263: astore_3
    //   264: aload_3
    //   265: ifnull -> 272
    //   268: aload_3
    //   269: invokevirtual close : ()V
    //   272: aload_2
    //   273: athrow
    //   274: astore_3
    //   275: aload_3
    //   276: invokevirtual printStackTrace : ()V
    //   279: goto -> 272
    //   282: astore_2
    //   283: goto -> 264
    //   286: astore_1
    //   287: goto -> 230
    // Exception table:
    //   from	to	target	type
    //   52	61	227	java/lang/Exception
    //   52	61	261	finally
    //   63	69	286	java/lang/Exception
    //   63	69	282	finally
    //   85	89	93	java/io/IOException
    //   105	111	286	java/lang/Exception
    //   105	111	282	finally
    //   113	120	286	java/lang/Exception
    //   113	120	282	finally
    //   122	126	286	java/lang/Exception
    //   122	126	282	finally
    //   128	134	286	java/lang/Exception
    //   128	134	282	finally
    //   136	147	286	java/lang/Exception
    //   136	147	282	finally
    //   154	161	286	java/lang/Exception
    //   154	161	282	finally
    //   163	167	286	java/lang/Exception
    //   163	167	282	finally
    //   169	181	286	java/lang/Exception
    //   169	181	282	finally
    //   185	189	194	java/io/IOException
    //   208	212	217	java/io/IOException
    //   232	236	282	finally
    //   242	246	251	java/io/IOException
    //   268	272	274	java/io/IOException
  }
  
  public static String a(String paramString) {
    if (paramString == null)
      return ""; 
    try {
      byte[] arrayOfByte = Base64.encodeBase64(MessageDigest.getInstance("MD5").digest(paramString.getBytes("utf-8")));
      String str = new String();
      this(arrayOfByte, "utf-8");
      paramString = str;
    } catch (Exception exception) {}
    return paramString;
  }
  
  public static void a(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null) {
      paramString1 = b(paramString1 + "||" + paramString2);
      File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/code/game/ZM.DAT".substring(0, "/Android/data/code/game/ZM.DAT".lastIndexOf("/")));
      if ((file.exists() && !file.isFile()) || file.mkdirs()) {
        file = new File(file, "/Android/data/code/game/ZM.DAT".substring("/Android/data/code/game/ZM.DAT".lastIndexOf("/") + 1, "/Android/data/code/game/ZM.DAT".length()));
        if (file.exists() && file.isFile())
          file.delete(); 
        try {
          FileOutputStream fileOutputStream = new FileOutputStream();
          this(file);
          fileOutputStream.write(paramString1.getBytes());
          fileOutputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
      } 
    } 
  }
  
  public static String b(String paramString) {
    try {
      byte[] arrayOfByte1 = paramString.getBytes("utf-8");
      byte[] arrayOfByte2 = "www.douwan.cn".getBytes();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      for (byte b = 0; b < arrayOfByte1.length; b++) {
        byte b1 = arrayOfByte1[b];
        byte b2 = arrayOfByte2[b % arrayOfByte2.length];
        StringBuilder stringBuilder1 = new StringBuilder();
        this();
        stringBuilder.append(stringBuilder1.append("%").append((b1 & 0xFF) + (b2 & 0xFF)).toString());
      } 
      String str = stringBuilder.toString();
      paramString = str;
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
    } 
    return paramString;
  }
  
  public static String c(String paramString) {
    String str2 = paramString;
    if (paramString != null) {
      if (paramString.length() == 0)
        return paramString; 
    } else {
      return str2;
    } 
    Matcher matcher = c.matcher(paramString);
    ArrayList<Integer> arrayList = new ArrayList();
    while (matcher.find()) {
      String str;
      try {
        arrayList.add(Integer.valueOf(matcher.group()));
        continue;
      } catch (Exception exception) {
        exception.printStackTrace();
        str = paramString;
      } 
      return str;
    } 
    String str1 = paramString;
    if (arrayList.size() > 0)
      try {
        byte[] arrayOfByte1 = new byte[arrayList.size()];
        byte[] arrayOfByte2 = "www.douwan.cn".getBytes();
        for (byte b = 0; b < arrayOfByte1.length; b++)
          arrayOfByte1[b] = (byte)(byte)(((Integer)arrayList.get(b)).intValue() - (arrayOfByte2[b % arrayOfByte2.length] & 0xFF)); 
        String str = new String(arrayOfByte1, "utf-8");
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        str1 = paramString;
      }  
    return str1;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\a\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */