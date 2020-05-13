package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class z {
  private static Map<String, String> a;
  
  private static boolean b;
  
  public static Context a(Context paramContext) {
    if (paramContext == null)
      return paramContext; 
    Context context = paramContext.getApplicationContext();
    return (context == null) ? paramContext : context;
  }
  
  public static SharedPreferences a(String paramString, Context paramContext) {
    return (paramContext != null) ? paramContext.getSharedPreferences(paramString, 0) : null;
  }
  
  private static BufferedReader a(File paramFile) {
    if (paramFile == null || !paramFile.exists() || !paramFile.canRead())
      return null; 
    try {
      InputStreamReader inputStreamReader = new InputStreamReader();
      FileInputStream fileInputStream = new FileInputStream();
      this(paramFile);
      this(fileInputStream, "utf-8");
      return new BufferedReader(inputStreamReader);
    } catch (Throwable throwable) {
      x.a(throwable);
      return null;
    } 
  }
  
  public static BufferedReader a(String paramString1, String paramString2) {
    if (paramString1 == null)
      return null; 
    try {
      File file = new File();
      this(paramString1, paramString2);
      return (!file.exists() || !file.canRead()) ? null : a(file);
    } catch (NullPointerException nullPointerException) {
      x.a(nullPointerException);
      return null;
    } 
  }
  
  public static Object a(String paramString1, String paramString2, Object paramObject, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject) {
    try {
      Method method = Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
      method.setAccessible(true);
      return method.invoke(null, paramArrayOfObject);
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static <T> T a(byte[] paramArrayOfbyte, Parcelable.Creator<T> paramCreator) {
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    parcel.setDataPosition(0);
    try {
      Object object = paramCreator.createFromParcel(parcel);
      if (parcel != null)
        parcel.recycle(); 
      return (T)object;
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      if (parcel != null)
        parcel.recycle(); 
      return null;
    } finally {}
    if (parcel != null)
      parcel.recycle(); 
    throw paramArrayOfbyte;
  }
  
  public static String a() {
    return a(System.currentTimeMillis());
  }
  
  public static String a(long paramLong) {
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
      this("yyyy-MM-dd HH:mm:ss", Locale.US);
      Date date = new Date();
      this(paramLong);
      return simpleDateFormat.format(date);
    } catch (Exception exception) {
      return (new Date()).toString();
    } 
  }
  
  public static String a(Context paramContext, int paramInt, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'android.permission.READ_LOGS'
    //   3: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   6: istore_3
    //   7: aconst_null
    //   8: astore #4
    //   10: aconst_null
    //   11: astore_0
    //   12: iload_3
    //   13: ifne -> 28
    //   16: ldc 'no read_log permission!'
    //   18: iconst_0
    //   19: anewarray java/lang/Object
    //   22: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   25: pop
    //   26: aconst_null
    //   27: areturn
    //   28: aload_2
    //   29: ifnonnull -> 60
    //   32: iconst_4
    //   33: anewarray java/lang/String
    //   36: astore_2
    //   37: aload_2
    //   38: iconst_0
    //   39: ldc 'logcat'
    //   41: aastore
    //   42: aload_2
    //   43: iconst_1
    //   44: ldc '-d'
    //   46: aastore
    //   47: aload_2
    //   48: iconst_2
    //   49: ldc '-v'
    //   51: aastore
    //   52: aload_2
    //   53: iconst_3
    //   54: ldc 'threadtime'
    //   56: aastore
    //   57: goto -> 95
    //   60: bipush #6
    //   62: anewarray java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: ldc 'logcat'
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: ldc '-d'
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: ldc '-v'
    //   79: aastore
    //   80: dup
    //   81: iconst_3
    //   82: ldc 'threadtime'
    //   84: aastore
    //   85: dup
    //   86: iconst_4
    //   87: ldc '-s'
    //   89: aastore
    //   90: dup
    //   91: iconst_5
    //   92: aload_2
    //   93: aastore
    //   94: astore_2
    //   95: new java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial <init> : ()V
    //   102: astore #5
    //   104: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   107: aload_2
    //   108: invokevirtual exec : ([Ljava/lang/String;)Ljava/lang/Process;
    //   111: astore_2
    //   112: new java/io/BufferedReader
    //   115: astore_0
    //   116: new java/io/InputStreamReader
    //   119: astore #6
    //   121: aload #6
    //   123: aload_2
    //   124: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   127: invokespecial <init> : (Ljava/io/InputStream;)V
    //   130: aload_0
    //   131: aload #6
    //   133: invokespecial <init> : (Ljava/io/Reader;)V
    //   136: aload_0
    //   137: invokevirtual readLine : ()Ljava/lang/String;
    //   140: astore #6
    //   142: aload #6
    //   144: ifnull -> 193
    //   147: aload #5
    //   149: aload #6
    //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload #5
    //   157: ldc '\\n'
    //   159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: iload_1
    //   164: ifle -> 136
    //   167: aload #5
    //   169: invokevirtual length : ()I
    //   172: iload_1
    //   173: if_icmple -> 136
    //   176: aload #5
    //   178: iconst_0
    //   179: aload #5
    //   181: invokevirtual length : ()I
    //   184: iload_1
    //   185: isub
    //   186: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: goto -> 136
    //   193: aload #5
    //   195: invokevirtual toString : ()Ljava/lang/String;
    //   198: astore_0
    //   199: aload_2
    //   200: ifnull -> 252
    //   203: aload_2
    //   204: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   207: invokevirtual close : ()V
    //   210: goto -> 220
    //   213: astore #6
    //   215: aload #6
    //   217: invokevirtual printStackTrace : ()V
    //   220: aload_2
    //   221: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   224: invokevirtual close : ()V
    //   227: goto -> 237
    //   230: astore #6
    //   232: aload #6
    //   234: invokevirtual printStackTrace : ()V
    //   237: aload_2
    //   238: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   241: invokevirtual close : ()V
    //   244: goto -> 252
    //   247: astore_2
    //   248: aload_2
    //   249: invokevirtual printStackTrace : ()V
    //   252: aload_0
    //   253: areturn
    //   254: astore #6
    //   256: aload_2
    //   257: astore_0
    //   258: aload #6
    //   260: astore_2
    //   261: goto -> 408
    //   264: astore #6
    //   266: goto -> 278
    //   269: astore_2
    //   270: goto -> 408
    //   273: astore #6
    //   275: aload #4
    //   277: astore_2
    //   278: aload_2
    //   279: astore_0
    //   280: aload #6
    //   282: invokestatic a : (Ljava/lang/Throwable;)Z
    //   285: ifne -> 295
    //   288: aload_2
    //   289: astore_0
    //   290: aload #6
    //   292: invokevirtual printStackTrace : ()V
    //   295: aload_2
    //   296: astore_0
    //   297: new java/lang/StringBuilder
    //   300: astore #4
    //   302: aload_2
    //   303: astore_0
    //   304: aload #4
    //   306: ldc '\\n[error:'
    //   308: invokespecial <init> : (Ljava/lang/String;)V
    //   311: aload_2
    //   312: astore_0
    //   313: aload #4
    //   315: aload #6
    //   317: invokevirtual toString : ()Ljava/lang/String;
    //   320: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload_2
    //   325: astore_0
    //   326: aload #4
    //   328: ldc ']'
    //   330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: pop
    //   334: aload_2
    //   335: astore_0
    //   336: aload #5
    //   338: aload #4
    //   340: invokevirtual toString : ()Ljava/lang/String;
    //   343: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload_2
    //   348: astore_0
    //   349: aload #5
    //   351: invokevirtual toString : ()Ljava/lang/String;
    //   354: astore #6
    //   356: aload_2
    //   357: ifnull -> 405
    //   360: aload_2
    //   361: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   364: invokevirtual close : ()V
    //   367: goto -> 375
    //   370: astore_0
    //   371: aload_0
    //   372: invokevirtual printStackTrace : ()V
    //   375: aload_2
    //   376: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   379: invokevirtual close : ()V
    //   382: goto -> 390
    //   385: astore_0
    //   386: aload_0
    //   387: invokevirtual printStackTrace : ()V
    //   390: aload_2
    //   391: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   394: invokevirtual close : ()V
    //   397: goto -> 405
    //   400: astore_0
    //   401: aload_0
    //   402: invokevirtual printStackTrace : ()V
    //   405: aload #6
    //   407: areturn
    //   408: aload_0
    //   409: ifnull -> 461
    //   412: aload_0
    //   413: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
    //   416: invokevirtual close : ()V
    //   419: goto -> 429
    //   422: astore #6
    //   424: aload #6
    //   426: invokevirtual printStackTrace : ()V
    //   429: aload_0
    //   430: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   433: invokevirtual close : ()V
    //   436: goto -> 446
    //   439: astore #6
    //   441: aload #6
    //   443: invokevirtual printStackTrace : ()V
    //   446: aload_0
    //   447: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   450: invokevirtual close : ()V
    //   453: goto -> 461
    //   456: astore_0
    //   457: aload_0
    //   458: invokevirtual printStackTrace : ()V
    //   461: aload_2
    //   462: athrow
    // Exception table:
    //   from	to	target	type
    //   104	112	273	java/lang/Throwable
    //   104	112	269	finally
    //   112	136	264	java/lang/Throwable
    //   112	136	254	finally
    //   136	142	264	java/lang/Throwable
    //   136	142	254	finally
    //   147	163	264	java/lang/Throwable
    //   147	163	254	finally
    //   167	190	264	java/lang/Throwable
    //   167	190	254	finally
    //   193	199	264	java/lang/Throwable
    //   193	199	254	finally
    //   203	210	213	java/io/IOException
    //   220	227	230	java/io/IOException
    //   237	244	247	java/io/IOException
    //   280	288	269	finally
    //   290	295	269	finally
    //   297	302	269	finally
    //   304	311	269	finally
    //   313	324	269	finally
    //   326	334	269	finally
    //   336	347	269	finally
    //   349	356	269	finally
    //   360	367	370	java/io/IOException
    //   375	382	385	java/io/IOException
    //   390	397	400	java/io/IOException
    //   412	419	422	java/io/IOException
    //   429	436	439	java/io/IOException
    //   446	453	456	java/io/IOException
  }
  
  public static String a(Context paramContext, String paramString) {
    if (paramString == null || paramString.trim().equals(""))
      return ""; 
    if (a == null) {
      a = new HashMap<String, String>();
      ArrayList<String> arrayList = c(paramContext, "getprop");
      if (arrayList != null && arrayList.size() > 0) {
        x.b(z.class, "Successfully get 'getprop' list.", new Object[0]);
        Pattern pattern = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
          Matcher matcher = pattern.matcher(iterator.next());
          if (matcher.find())
            a.put(matcher.group(1), matcher.group(2)); 
        } 
        x.b(z.class, "System properties number: %d.", new Object[] { Integer.valueOf(a.size()) });
      } 
    } 
    return a.containsKey(paramString) ? a.get(paramString) : "fail";
  }
  
  public static String a(File paramFile, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 244
    //   4: aload_0
    //   5: invokevirtual exists : ()Z
    //   8: ifeq -> 244
    //   11: aload_0
    //   12: invokevirtual canRead : ()Z
    //   15: ifne -> 21
    //   18: goto -> 244
    //   21: new java/lang/StringBuilder
    //   24: astore_3
    //   25: aload_3
    //   26: invokespecial <init> : ()V
    //   29: new java/io/BufferedReader
    //   32: astore #4
    //   34: new java/io/InputStreamReader
    //   37: astore #5
    //   39: new java/io/FileInputStream
    //   42: astore #6
    //   44: aload #6
    //   46: aload_0
    //   47: invokespecial <init> : (Ljava/io/File;)V
    //   50: aload #5
    //   52: aload #6
    //   54: ldc 'utf-8'
    //   56: invokespecial <init> : (Ljava/io/InputStream;Ljava/lang/String;)V
    //   59: aload #4
    //   61: aload #5
    //   63: invokespecial <init> : (Ljava/io/Reader;)V
    //   66: aload #4
    //   68: astore_0
    //   69: aload #4
    //   71: invokevirtual readLine : ()Ljava/lang/String;
    //   74: astore #6
    //   76: aload #6
    //   78: ifnull -> 154
    //   81: aload #4
    //   83: astore_0
    //   84: aload_3
    //   85: aload #6
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload #4
    //   93: astore_0
    //   94: aload_3
    //   95: ldc '\\n'
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: iload_1
    //   102: ifle -> 66
    //   105: aload #4
    //   107: astore_0
    //   108: aload_3
    //   109: invokevirtual length : ()I
    //   112: iload_1
    //   113: if_icmple -> 66
    //   116: iload_2
    //   117: ifeq -> 136
    //   120: aload #4
    //   122: astore_0
    //   123: aload_3
    //   124: iload_1
    //   125: aload_3
    //   126: invokevirtual length : ()I
    //   129: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: goto -> 154
    //   136: aload #4
    //   138: astore_0
    //   139: aload_3
    //   140: iconst_0
    //   141: aload_3
    //   142: invokevirtual length : ()I
    //   145: iload_1
    //   146: isub
    //   147: invokevirtual delete : (II)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: goto -> 66
    //   154: aload #4
    //   156: astore_0
    //   157: aload_3
    //   158: invokevirtual toString : ()Ljava/lang/String;
    //   161: astore_3
    //   162: aload #4
    //   164: invokevirtual close : ()V
    //   167: goto -> 176
    //   170: astore_0
    //   171: aload_0
    //   172: invokestatic a : (Ljava/lang/Throwable;)Z
    //   175: pop
    //   176: aload_3
    //   177: areturn
    //   178: astore_3
    //   179: goto -> 193
    //   182: astore #4
    //   184: aconst_null
    //   185: astore_0
    //   186: goto -> 224
    //   189: astore_3
    //   190: aconst_null
    //   191: astore #4
    //   193: aload #4
    //   195: astore_0
    //   196: aload_3
    //   197: invokestatic a : (Ljava/lang/Throwable;)Z
    //   200: pop
    //   201: aload #4
    //   203: ifnull -> 220
    //   206: aload #4
    //   208: invokevirtual close : ()V
    //   211: goto -> 220
    //   214: astore_0
    //   215: aload_0
    //   216: invokestatic a : (Ljava/lang/Throwable;)Z
    //   219: pop
    //   220: aconst_null
    //   221: areturn
    //   222: astore #4
    //   224: aload_0
    //   225: ifnull -> 241
    //   228: aload_0
    //   229: invokevirtual close : ()V
    //   232: goto -> 241
    //   235: astore_0
    //   236: aload_0
    //   237: invokestatic a : (Ljava/lang/Throwable;)Z
    //   240: pop
    //   241: aload #4
    //   243: athrow
    //   244: aconst_null
    //   245: areturn
    // Exception table:
    //   from	to	target	type
    //   21	66	189	java/lang/Throwable
    //   21	66	182	finally
    //   69	76	178	java/lang/Throwable
    //   69	76	222	finally
    //   84	91	178	java/lang/Throwable
    //   84	91	222	finally
    //   94	101	178	java/lang/Throwable
    //   94	101	222	finally
    //   108	116	178	java/lang/Throwable
    //   108	116	222	finally
    //   123	133	178	java/lang/Throwable
    //   123	133	222	finally
    //   139	151	178	java/lang/Throwable
    //   139	151	222	finally
    //   157	162	178	java/lang/Throwable
    //   157	162	222	finally
    //   162	167	170	java/lang/Exception
    //   196	201	222	finally
    //   206	211	214	java/lang/Exception
    //   228	232	235	java/lang/Exception
  }
  
  public static String a(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    try {
      StringWriter stringWriter = new StringWriter();
      this();
      PrintWriter printWriter = new PrintWriter();
      this(stringWriter);
      paramThrowable.printStackTrace(printWriter);
      return stringWriter.getBuffer().toString();
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return "fail";
    } 
  }
  
  public static String a(Date paramDate) {
    if (paramDate == null)
      return null; 
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
      this("yyyy-MM-dd HH:mm:ss", Locale.US);
      return simpleDateFormat.format(paramDate);
    } catch (Exception exception) {
      return (new Date()).toString();
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return ""; 
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < paramArrayOfbyte.length; b++) {
      String str = Integer.toHexString(paramArrayOfbyte[b] & 0xFF);
      if (str.length() == 1)
        stringBuffer.append("0"); 
      stringBuffer.append(str);
    } 
    return stringBuffer.toString().toUpperCase();
  }
  
  public static Thread a(Runnable paramRunnable, String paramString) {
    try {
      Thread thread = new Thread();
      this(paramRunnable);
      thread.setName(paramString);
      thread.start();
      return thread;
    } catch (Throwable throwable) {
      x.e("[Util] Failed to start a thread to execute task with message: %s", new Object[] { throwable.getMessage() });
      return null;
    } 
  }
  
  public static Map<String, String> a(int paramInt, boolean paramBoolean) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(12);
    Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
    if (map == null)
      return null; 
    Thread thread = Looper.getMainLooper().getThread();
    if (!map.containsKey(thread))
      map.put(thread, thread.getStackTrace()); 
    Thread.currentThread().getId();
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<Thread, StackTraceElement> entry : map.entrySet()) {
      byte b = 0;
      stringBuilder.setLength(0);
      if (entry.getValue() != null && ((StackTraceElement[])entry.getValue()).length != 0) {
        StackTraceElement[] arrayOfStackTraceElement = (StackTraceElement[])entry.getValue();
        int i = arrayOfStackTraceElement.length;
        while (b < i) {
          StackTraceElement stackTraceElement = arrayOfStackTraceElement[b];
          if (paramInt > 0 && stringBuilder.length() >= paramInt) {
            StringBuilder stringBuilder2 = new StringBuilder("\n[Stack over limit size :");
            stringBuilder2.append(paramInt);
            stringBuilder2.append(" , has been cut!]");
            stringBuilder.append(stringBuilder2.toString());
            break;
          } 
          stringBuilder.append(stackTraceElement.toString());
          stringBuilder.append("\n");
          b++;
        } 
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(((Thread)entry.getKey()).getName());
        stringBuilder1.append("(");
        stringBuilder1.append(((Thread)entry.getKey()).getId());
        stringBuilder1.append(")");
        hashMap.put(stringBuilder1.toString(), stringBuilder.toString());
      } 
    } 
    return (Map)hashMap;
  }
  
  public static Map<String, PlugInBean> a(Parcel paramParcel) {
    HashMap<Object, Object> hashMap;
    Bundle bundle = paramParcel.readBundle();
    paramParcel = null;
    if (bundle == null)
      return null; 
    ArrayList<String> arrayList = new ArrayList();
    ArrayList<PlugInBean> arrayList1 = new ArrayList();
    int i = ((Integer)bundle.get("pluginNum")).intValue();
    boolean bool = false;
    byte b;
    for (b = 0; b < i; b++) {
      StringBuilder stringBuilder = new StringBuilder("pluginKey");
      stringBuilder.append(b);
      arrayList.add(bundle.getString(stringBuilder.toString()));
    } 
    for (b = 0; b < i; b++) {
      StringBuilder stringBuilder1 = new StringBuilder("pluginVal");
      stringBuilder1.append(b);
      stringBuilder1.append("plugInId");
      String str1 = bundle.getString(stringBuilder1.toString());
      StringBuilder stringBuilder2 = new StringBuilder("pluginVal");
      stringBuilder2.append(b);
      stringBuilder2.append("plugInUUID");
      String str2 = bundle.getString(stringBuilder2.toString());
      StringBuilder stringBuilder3 = new StringBuilder("pluginVal");
      stringBuilder3.append(b);
      stringBuilder3.append("plugInVersion");
      arrayList1.add(new PlugInBean(str1, bundle.getString(stringBuilder3.toString()), str2));
    } 
    if (arrayList.size() == arrayList1.size()) {
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(arrayList.size());
      b = bool;
      while (true) {
        hashMap = hashMap1;
        if (b < arrayList.size()) {
          hashMap1.put(arrayList.get(b), PlugInBean.class.cast(arrayList1.get(b)));
          b++;
          continue;
        } 
        break;
      } 
    } else {
      x.e("map plugin parcel error!", new Object[0]);
    } 
    return (Map)hashMap;
  }
  
  public static void a(Parcel paramParcel, Map<String, PlugInBean> paramMap) {
    if (paramMap == null || paramMap.size() <= 0) {
      paramParcel.writeBundle(null);
      return;
    } 
    int i = paramMap.size();
    ArrayList<String> arrayList = new ArrayList(i);
    ArrayList arrayList1 = new ArrayList(i);
    for (Map.Entry<String, PlugInBean> entry : paramMap.entrySet()) {
      arrayList.add(entry.getKey());
      arrayList1.add(entry.getValue());
    } 
    Bundle bundle = new Bundle();
    bundle.putInt("pluginNum", arrayList.size());
    boolean bool = false;
    byte b = 0;
    while (true) {
      i = bool;
      if (b < arrayList.size()) {
        StringBuilder stringBuilder = new StringBuilder("pluginKey");
        stringBuilder.append(b);
        bundle.putString(stringBuilder.toString(), arrayList.get(b));
        b++;
        continue;
      } 
      break;
    } 
    while (i < arrayList.size()) {
      StringBuilder stringBuilder = new StringBuilder("pluginVal");
      stringBuilder.append(i);
      stringBuilder.append("plugInId");
      bundle.putString(stringBuilder.toString(), ((PlugInBean)arrayList1.get(i)).a);
      stringBuilder = new StringBuilder("pluginVal");
      stringBuilder.append(i);
      stringBuilder.append("plugInUUID");
      bundle.putString(stringBuilder.toString(), ((PlugInBean)arrayList1.get(i)).c);
      stringBuilder = new StringBuilder("pluginVal");
      stringBuilder.append(i);
      stringBuilder.append("plugInVersion");
      bundle.putString(stringBuilder.toString(), ((PlugInBean)arrayList1.get(i)).b);
      i++;
    } 
    paramParcel.writeBundle(bundle);
  }
  
  public static void a(Class<?> paramClass, String paramString, Object paramObject1, Object paramObject2) {
    try {
      Field field = paramClass.getDeclaredField(paramString);
      field.setAccessible(true);
      field.set(null, paramObject1);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong) {
    x.c("[Util] Try to lock file:%s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(paramContext.getFilesDir());
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString);
      String str = stringBuilder.toString();
      File file = new File();
      this(str);
      if (file.exists()) {
        if (System.currentTimeMillis() - file.lastModified() < paramLong)
          return false; 
        x.c("[Util] Lock file (%s) is expired, unlock it.", new Object[] { paramString });
        b(paramContext, paramString);
      } 
      if (file.createNewFile()) {
        x.c("[Util] Successfully locked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        return true;
      } 
      x.c("[Util] Failed to locked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      return false;
    } catch (Throwable throwable) {
      x.a(throwable);
      return false;
    } 
  }
  
  public static boolean a(File paramFile1, File paramFile2, int paramInt) {
    // Byte code:
    //   0: ldc_w 'rqdp{  ZF start}'
    //   3: iconst_0
    //   4: anewarray java/lang/Object
    //   7: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: ifnull -> 434
    //   15: aload_1
    //   16: ifnull -> 434
    //   19: aload_0
    //   20: aload_1
    //   21: invokevirtual equals : (Ljava/lang/Object;)Z
    //   24: ifeq -> 30
    //   27: goto -> 434
    //   30: aload_0
    //   31: invokevirtual exists : ()Z
    //   34: ifeq -> 421
    //   37: aload_0
    //   38: invokevirtual canRead : ()Z
    //   41: ifne -> 47
    //   44: goto -> 421
    //   47: aload_1
    //   48: invokevirtual getParentFile : ()Ljava/io/File;
    //   51: ifnull -> 72
    //   54: aload_1
    //   55: invokevirtual getParentFile : ()Ljava/io/File;
    //   58: invokevirtual exists : ()Z
    //   61: ifne -> 72
    //   64: aload_1
    //   65: invokevirtual getParentFile : ()Ljava/io/File;
    //   68: invokevirtual mkdirs : ()Z
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual exists : ()Z
    //   76: ifne -> 99
    //   79: aload_1
    //   80: invokevirtual createNewFile : ()Z
    //   83: pop
    //   84: goto -> 99
    //   87: astore_3
    //   88: aload_3
    //   89: invokestatic a : (Ljava/lang/Throwable;)Z
    //   92: ifne -> 99
    //   95: aload_3
    //   96: invokevirtual printStackTrace : ()V
    //   99: aload_1
    //   100: invokevirtual exists : ()Z
    //   103: ifeq -> 419
    //   106: aload_1
    //   107: invokevirtual canRead : ()Z
    //   110: ifne -> 116
    //   113: goto -> 419
    //   116: aconst_null
    //   117: astore #4
    //   119: new java/io/FileInputStream
    //   122: astore_3
    //   123: aload_3
    //   124: aload_0
    //   125: invokespecial <init> : (Ljava/io/File;)V
    //   128: new java/util/zip/ZipOutputStream
    //   131: astore #5
    //   133: new java/io/BufferedOutputStream
    //   136: astore #4
    //   138: new java/io/FileOutputStream
    //   141: astore #6
    //   143: aload #6
    //   145: aload_1
    //   146: invokespecial <init> : (Ljava/io/File;)V
    //   149: aload #4
    //   151: aload #6
    //   153: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   156: aload #5
    //   158: aload #4
    //   160: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   163: aload #5
    //   165: bipush #8
    //   167: invokevirtual setMethod : (I)V
    //   170: new java/util/zip/ZipEntry
    //   173: astore_1
    //   174: aload_1
    //   175: aload_0
    //   176: invokevirtual getName : ()Ljava/lang/String;
    //   179: invokespecial <init> : (Ljava/lang/String;)V
    //   182: aload #5
    //   184: aload_1
    //   185: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   188: sipush #5000
    //   191: newarray byte
    //   193: astore_0
    //   194: aload_3
    //   195: aload_0
    //   196: invokevirtual read : ([B)I
    //   199: istore_2
    //   200: iload_2
    //   201: ifle -> 215
    //   204: aload #5
    //   206: aload_0
    //   207: iconst_0
    //   208: iload_2
    //   209: invokevirtual write : ([BII)V
    //   212: goto -> 194
    //   215: aload #5
    //   217: invokevirtual flush : ()V
    //   220: aload #5
    //   222: invokevirtual closeEntry : ()V
    //   225: aload_3
    //   226: invokevirtual close : ()V
    //   229: goto -> 237
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual printStackTrace : ()V
    //   237: aload #5
    //   239: invokevirtual close : ()V
    //   242: goto -> 250
    //   245: astore_0
    //   246: aload_0
    //   247: invokevirtual printStackTrace : ()V
    //   250: ldc_w 'rqdp{  ZF end}'
    //   253: iconst_0
    //   254: anewarray java/lang/Object
    //   257: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   260: pop
    //   261: iconst_1
    //   262: ireturn
    //   263: astore_1
    //   264: aload #5
    //   266: astore_0
    //   267: goto -> 374
    //   270: astore_1
    //   271: aload #5
    //   273: astore_0
    //   274: goto -> 286
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_0
    //   280: goto -> 374
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_0
    //   286: aload_1
    //   287: astore #5
    //   289: aload_3
    //   290: astore_1
    //   291: goto -> 309
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_3
    //   297: aload_3
    //   298: astore_0
    //   299: goto -> 374
    //   302: astore #5
    //   304: aconst_null
    //   305: astore_0
    //   306: aload #4
    //   308: astore_1
    //   309: aload #5
    //   311: invokestatic a : (Ljava/lang/Throwable;)Z
    //   314: ifne -> 322
    //   317: aload #5
    //   319: invokevirtual printStackTrace : ()V
    //   322: aload_1
    //   323: ifnull -> 338
    //   326: aload_1
    //   327: invokevirtual close : ()V
    //   330: goto -> 338
    //   333: astore_1
    //   334: aload_1
    //   335: invokevirtual printStackTrace : ()V
    //   338: aload_0
    //   339: ifnull -> 354
    //   342: aload_0
    //   343: invokevirtual close : ()V
    //   346: goto -> 354
    //   349: astore_0
    //   350: aload_0
    //   351: invokevirtual printStackTrace : ()V
    //   354: ldc_w 'rqdp{  ZF end}'
    //   357: iconst_0
    //   358: anewarray java/lang/Object
    //   361: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   364: pop
    //   365: iconst_0
    //   366: ireturn
    //   367: astore #5
    //   369: aload_1
    //   370: astore_3
    //   371: aload #5
    //   373: astore_1
    //   374: aload_3
    //   375: ifnull -> 390
    //   378: aload_3
    //   379: invokevirtual close : ()V
    //   382: goto -> 390
    //   385: astore_3
    //   386: aload_3
    //   387: invokevirtual printStackTrace : ()V
    //   390: aload_0
    //   391: ifnull -> 406
    //   394: aload_0
    //   395: invokevirtual close : ()V
    //   398: goto -> 406
    //   401: astore_0
    //   402: aload_0
    //   403: invokevirtual printStackTrace : ()V
    //   406: ldc_w 'rqdp{  ZF end}'
    //   409: iconst_0
    //   410: anewarray java/lang/Object
    //   413: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   416: pop
    //   417: aload_1
    //   418: athrow
    //   419: iconst_0
    //   420: ireturn
    //   421: ldc_w 'rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}'
    //   424: iconst_0
    //   425: anewarray java/lang/Object
    //   428: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   431: pop
    //   432: iconst_0
    //   433: ireturn
    //   434: ldc_w 'rqdp{  err ZF 1R!}'
    //   437: iconst_0
    //   438: anewarray java/lang/Object
    //   441: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   444: pop
    //   445: iconst_0
    //   446: ireturn
    // Exception table:
    //   from	to	target	type
    //   47	72	87	java/lang/Throwable
    //   72	84	87	java/lang/Throwable
    //   119	128	302	java/lang/Throwable
    //   119	128	294	finally
    //   128	163	283	java/lang/Throwable
    //   128	163	277	finally
    //   163	194	270	java/lang/Throwable
    //   163	194	263	finally
    //   194	200	270	java/lang/Throwable
    //   194	200	263	finally
    //   204	212	270	java/lang/Throwable
    //   204	212	263	finally
    //   215	225	270	java/lang/Throwable
    //   215	225	263	finally
    //   225	229	232	java/io/IOException
    //   237	242	245	java/io/IOException
    //   309	322	367	finally
    //   326	330	333	java/io/IOException
    //   342	346	349	java/io/IOException
    //   378	382	385	java/io/IOException
    //   394	398	401	java/io/IOException
  }
  
  public static boolean a(Runnable paramRunnable) {
    if (paramRunnable != null) {
      w w = w.a();
      if (w != null)
        return w.a(paramRunnable); 
      String[] arrayOfString = paramRunnable.getClass().getName().split("\\.");
      if (a(paramRunnable, arrayOfString[arrayOfString.length - 1]) != null)
        return true; 
    } 
    return false;
  }
  
  public static boolean a(String paramString) {
    return !(paramString != null && paramString.trim().length() > 0);
  }
  
  public static byte[] a(int paramInt) {
    // Byte code:
    //   0: ldc com/tencent/bugly/proguard/z
    //   2: monitorenter
    //   3: bipush #16
    //   5: newarray byte
    //   7: astore_1
    //   8: new java/io/DataInputStream
    //   11: astore_2
    //   12: new java/io/FileInputStream
    //   15: astore_3
    //   16: new java/io/File
    //   19: astore #4
    //   21: aload #4
    //   23: ldc_w '/dev/urandom'
    //   26: invokespecial <init> : (Ljava/lang/String;)V
    //   29: aload_3
    //   30: aload #4
    //   32: invokespecial <init> : (Ljava/io/File;)V
    //   35: aload_2
    //   36: aload_3
    //   37: invokespecial <init> : (Ljava/io/InputStream;)V
    //   40: aload_2
    //   41: astore_3
    //   42: aload_2
    //   43: aload_1
    //   44: invokevirtual readFully : ([B)V
    //   47: aload_2
    //   48: invokevirtual close : ()V
    //   51: ldc com/tencent/bugly/proguard/z
    //   53: monitorexit
    //   54: aload_1
    //   55: areturn
    //   56: astore_1
    //   57: goto -> 69
    //   60: astore_2
    //   61: aconst_null
    //   62: astore_3
    //   63: goto -> 133
    //   66: astore_1
    //   67: aconst_null
    //   68: astore_2
    //   69: aload_2
    //   70: astore_3
    //   71: ldc_w 'Failed to read from /dev/urandom : %s'
    //   74: iconst_1
    //   75: anewarray java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_1
    //   81: aastore
    //   82: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   85: pop
    //   86: aload_2
    //   87: ifnull -> 94
    //   90: aload_2
    //   91: invokevirtual close : ()V
    //   94: ldc_w 'AES'
    //   97: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/KeyGenerator;
    //   100: astore_2
    //   101: new java/security/SecureRandom
    //   104: astore_3
    //   105: aload_3
    //   106: invokespecial <init> : ()V
    //   109: aload_2
    //   110: sipush #128
    //   113: aload_3
    //   114: invokevirtual init : (ILjava/security/SecureRandom;)V
    //   117: aload_2
    //   118: invokevirtual generateKey : ()Ljavax/crypto/SecretKey;
    //   121: invokeinterface getEncoded : ()[B
    //   126: astore_3
    //   127: ldc com/tencent/bugly/proguard/z
    //   129: monitorexit
    //   130: aload_3
    //   131: areturn
    //   132: astore_2
    //   133: aload_3
    //   134: ifnull -> 152
    //   137: aload_3
    //   138: invokevirtual close : ()V
    //   141: goto -> 152
    //   144: astore_3
    //   145: goto -> 170
    //   148: astore_3
    //   149: goto -> 154
    //   152: aload_2
    //   153: athrow
    //   154: aload_3
    //   155: invokestatic b : (Ljava/lang/Throwable;)Z
    //   158: ifne -> 165
    //   161: aload_3
    //   162: invokevirtual printStackTrace : ()V
    //   165: ldc com/tencent/bugly/proguard/z
    //   167: monitorexit
    //   168: aconst_null
    //   169: areturn
    //   170: ldc com/tencent/bugly/proguard/z
    //   172: monitorexit
    //   173: aload_3
    //   174: athrow
    // Exception table:
    //   from	to	target	type
    //   3	40	66	java/lang/Exception
    //   3	40	60	finally
    //   42	47	56	java/lang/Exception
    //   42	47	132	finally
    //   47	51	148	java/lang/Exception
    //   47	51	144	finally
    //   71	86	132	finally
    //   90	94	148	java/lang/Exception
    //   90	94	144	finally
    //   94	127	148	java/lang/Exception
    //   94	127	144	finally
    //   137	141	148	java/lang/Exception
    //   137	141	144	finally
    //   152	154	148	java/lang/Exception
    //   152	154	144	finally
    //   154	165	144	finally
  }
  
  @TargetApi(19)
  public static byte[] a(int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      SecretKeySpec secretKeySpec = new SecretKeySpec();
      this(paramArrayOfbyte2, "AES");
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      if (Build.VERSION.SDK_INT < 21 || b) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec();
        this(paramArrayOfbyte2);
        cipher.init(paramInt, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(paramArrayOfbyte1);
      } 
      int i = cipher.getBlockSize();
      GCMParameterSpec gCMParameterSpec = new GCMParameterSpec();
      this(i << 3, paramArrayOfbyte2);
      try {
        cipher.init(paramInt, secretKeySpec, gCMParameterSpec);
      } catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
        b = true;
        throw invalidAlgorithmParameterException;
      } 
      return cipher.doFinal((byte[])invalidAlgorithmParameterException);
    } catch (Exception exception) {
      if (!x.b(exception))
        exception.printStackTrace(); 
      return null;
    } 
  }
  
  public static byte[] a(Parcelable paramParcelable) {
    Parcel parcel = Parcel.obtain();
    paramParcelable.writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    return arrayOfByte;
  }
  
  public static byte[] a(File paramFile, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 266
    //   4: aload_1
    //   5: invokevirtual length : ()I
    //   8: ifne -> 14
    //   11: goto -> 266
    //   14: ldc_w 'rqdp{  ZF start}'
    //   17: iconst_0
    //   18: anewarray java/lang/Object
    //   21: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: aload_1
    //   26: ldc_w 'UTF-8'
    //   29: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   32: astore_0
    //   33: new java/io/ByteArrayInputStream
    //   36: astore_3
    //   37: aload_3
    //   38: aload_0
    //   39: invokespecial <init> : ([B)V
    //   42: new java/io/ByteArrayOutputStream
    //   45: astore #4
    //   47: aload #4
    //   49: invokespecial <init> : ()V
    //   52: new java/util/zip/ZipOutputStream
    //   55: astore_1
    //   56: aload_1
    //   57: aload #4
    //   59: invokespecial <init> : (Ljava/io/OutputStream;)V
    //   62: aload_1
    //   63: astore_0
    //   64: aload_1
    //   65: bipush #8
    //   67: invokevirtual setMethod : (I)V
    //   70: aload_1
    //   71: astore_0
    //   72: new java/util/zip/ZipEntry
    //   75: astore #5
    //   77: aload_1
    //   78: astore_0
    //   79: aload #5
    //   81: aload_2
    //   82: invokespecial <init> : (Ljava/lang/String;)V
    //   85: aload_1
    //   86: astore_0
    //   87: aload_1
    //   88: aload #5
    //   90: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
    //   93: aload_1
    //   94: astore_0
    //   95: sipush #1024
    //   98: newarray byte
    //   100: astore_2
    //   101: aload_1
    //   102: astore_0
    //   103: aload_3
    //   104: aload_2
    //   105: invokevirtual read : ([B)I
    //   108: istore #6
    //   110: iload #6
    //   112: ifle -> 128
    //   115: aload_1
    //   116: astore_0
    //   117: aload_1
    //   118: aload_2
    //   119: iconst_0
    //   120: iload #6
    //   122: invokevirtual write : ([BII)V
    //   125: goto -> 101
    //   128: aload_1
    //   129: astore_0
    //   130: aload_1
    //   131: invokevirtual closeEntry : ()V
    //   134: aload_1
    //   135: astore_0
    //   136: aload_1
    //   137: invokevirtual flush : ()V
    //   140: aload_1
    //   141: astore_0
    //   142: aload_1
    //   143: invokevirtual finish : ()V
    //   146: aload_1
    //   147: astore_0
    //   148: aload #4
    //   150: invokevirtual toByteArray : ()[B
    //   153: astore_2
    //   154: aload_1
    //   155: invokevirtual close : ()V
    //   158: goto -> 166
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual printStackTrace : ()V
    //   166: ldc_w 'rqdp{  ZF end}'
    //   169: iconst_0
    //   170: anewarray java/lang/Object
    //   173: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   176: pop
    //   177: aload_2
    //   178: areturn
    //   179: astore_2
    //   180: goto -> 192
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_0
    //   186: goto -> 237
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore_0
    //   194: aload_2
    //   195: invokestatic a : (Ljava/lang/Throwable;)Z
    //   198: ifne -> 207
    //   201: aload_1
    //   202: astore_0
    //   203: aload_2
    //   204: invokevirtual printStackTrace : ()V
    //   207: aload_1
    //   208: ifnull -> 223
    //   211: aload_1
    //   212: invokevirtual close : ()V
    //   215: goto -> 223
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual printStackTrace : ()V
    //   223: ldc_w 'rqdp{  ZF end}'
    //   226: iconst_0
    //   227: anewarray java/lang/Object
    //   230: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   233: pop
    //   234: aconst_null
    //   235: areturn
    //   236: astore_1
    //   237: aload_0
    //   238: ifnull -> 253
    //   241: aload_0
    //   242: invokevirtual close : ()V
    //   245: goto -> 253
    //   248: astore_0
    //   249: aload_0
    //   250: invokevirtual printStackTrace : ()V
    //   253: ldc_w 'rqdp{  ZF end}'
    //   256: iconst_0
    //   257: anewarray java/lang/Object
    //   260: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload_1
    //   265: athrow
    //   266: aconst_null
    //   267: areturn
    // Exception table:
    //   from	to	target	type
    //   25	62	189	java/lang/Throwable
    //   25	62	183	finally
    //   64	70	179	java/lang/Throwable
    //   64	70	236	finally
    //   72	77	179	java/lang/Throwable
    //   72	77	236	finally
    //   79	85	179	java/lang/Throwable
    //   79	85	236	finally
    //   87	93	179	java/lang/Throwable
    //   87	93	236	finally
    //   95	101	179	java/lang/Throwable
    //   95	101	236	finally
    //   103	110	179	java/lang/Throwable
    //   103	110	236	finally
    //   117	125	179	java/lang/Throwable
    //   117	125	236	finally
    //   130	134	179	java/lang/Throwable
    //   130	134	236	finally
    //   136	140	179	java/lang/Throwable
    //   136	140	236	finally
    //   142	146	179	java/lang/Throwable
    //   142	146	236	finally
    //   148	154	179	java/lang/Throwable
    //   148	154	236	finally
    //   154	158	161	java/io/IOException
    //   194	201	236	finally
    //   203	207	236	finally
    //   211	215	218	java/io/IOException
    //   241	245	248	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    String str;
    if (paramArrayOfbyte == null || paramInt == -1)
      return paramArrayOfbyte; 
    int i = paramArrayOfbyte.length;
    if (paramInt == 2) {
      str = "Gzip";
    } else {
      str = "zip";
    } 
    x.c("[Util] Zip %d bytes data with type %s", new Object[] { Integer.valueOf(i), str });
    try {
      ae ae = ad.a(paramInt);
      return (ae == null) ? null : ae.a(paramArrayOfbyte);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, String paramString) {
    if (paramArrayOfbyte == null)
      return null; 
    try {
      return a(a(paramArrayOfbyte, 2), 1, paramString);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, int paramInt, String paramString) {
    if (paramArrayOfbyte == null || paramInt == -1)
      return paramArrayOfbyte; 
    x.c("rqdp{  enD:} %d %d", new Object[] { Integer.valueOf(paramArrayOfbyte.length), Integer.valueOf(paramInt) });
    try {
      aj aj = a.a(paramInt);
      if (aj == null)
        return null; 
      aj.a(paramString);
      return aj.b(paramArrayOfbyte);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static long b() {
    try {
      long l = (System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 86400000L;
      int i = TimeZone.getDefault().getRawOffset();
      return l * 86400000L - i;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return -1L;
    } 
  }
  
  public static String b(String paramString1, String paramString2) {
    return (a.b() != null && (a.b()).E != null) ? (a.b()).E.getString(paramString1, paramString2) : "";
  }
  
  public static String b(Throwable paramThrowable) {
    if (paramThrowable == null)
      return ""; 
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    paramThrowable.printStackTrace(printWriter);
    printWriter.flush();
    return stringWriter.toString();
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length == 0)
      return "NULL"; 
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
      messageDigest.update(paramArrayOfbyte);
      return a(messageDigest.digest());
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static Map<String, String> b(Parcel paramParcel) {
    HashMap<Object, Object> hashMap;
    Bundle bundle = paramParcel.readBundle();
    paramParcel = null;
    if (bundle == null)
      return null; 
    ArrayList arrayList1 = bundle.getStringArrayList("keys");
    ArrayList arrayList2 = bundle.getStringArrayList("values");
    byte b = 0;
    if (arrayList1 != null && arrayList2 != null && arrayList1.size() == arrayList2.size()) {
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>(arrayList1.size());
      while (true) {
        hashMap = hashMap1;
        if (b < arrayList1.size()) {
          hashMap1.put(arrayList1.get(b), arrayList2.get(b));
          b++;
          continue;
        } 
        break;
      } 
    } else {
      x.e("map parcel error!", new Object[0]);
    } 
    return (Map)hashMap;
  }
  
  public static void b(long paramLong) {
    try {
      Thread.sleep(paramLong);
      return;
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
      return;
    } 
  }
  
  public static void b(Parcel paramParcel, Map<String, String> paramMap) {
    if (paramMap == null || paramMap.size() <= 0) {
      paramParcel.writeBundle(null);
      return;
    } 
    int i = paramMap.size();
    ArrayList arrayList1 = new ArrayList(i);
    ArrayList arrayList2 = new ArrayList(i);
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      arrayList1.add(entry.getKey());
      arrayList2.add(entry.getValue());
    } 
    Bundle bundle = new Bundle();
    bundle.putStringArrayList("keys", arrayList1);
    bundle.putStringArrayList("values", arrayList2);
    paramParcel.writeBundle(bundle);
  }
  
  public static void b(String paramString) {
    if (paramString == null)
      return; 
    File file = new File(paramString);
    if (file.isFile() && file.exists() && file.canWrite())
      file.delete(); 
  }
  
  public static boolean b(Context paramContext, String paramString) {
    x.c("[Util] Try to unlock file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(paramContext.getFilesDir());
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString);
      String str = stringBuilder.toString();
      File file = new File();
      this(str);
      if (file.exists()) {
        if (file.delete()) {
          x.c("[Util] Successfully unlocked file: %s (pid=%d | tid=%d)", new Object[] { paramString, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
          return true;
        } 
        return false;
      } 
      return true;
    } catch (Throwable throwable) {
      x.a(throwable);
      return false;
    } 
  }
  
  public static byte[] b(int paramInt, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    try {
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec();
      this(paramArrayOfbyte2);
      PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      cipher.init(1, publicKey);
      return cipher.doFinal(paramArrayOfbyte1);
    } catch (Exception exception) {
      if (!x.b(exception))
        exception.printStackTrace(); 
      return null;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt) {
    String str;
    if (paramArrayOfbyte == null || paramInt == -1)
      return paramArrayOfbyte; 
    int i = paramArrayOfbyte.length;
    if (paramInt == 2) {
      str = "Gzip";
    } else {
      str = "zip";
    } 
    x.c("[Util] Unzip %d bytes data with type %s", new Object[] { Integer.valueOf(i), str });
    try {
      ae ae = ad.a(paramInt);
      return (ae == null) ? null : ae.b(paramArrayOfbyte);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  public static byte[] b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, String paramString) {
    try {
      return b(b(paramArrayOfbyte, 1, paramString), 2);
    } catch (Exception exception) {
      if (!x.a(exception))
        exception.printStackTrace(); 
      return null;
    } 
  }
  
  private static byte[] b(byte[] paramArrayOfbyte, int paramInt, String paramString) {
    if (paramArrayOfbyte == null || paramInt == -1)
      return paramArrayOfbyte; 
    try {
      aj aj = a.a(paramInt);
      if (aj == null)
        return null; 
      aj.a(paramString);
      return aj.a(paramArrayOfbyte);
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      x.d("encrytype %d %s", new Object[] { Integer.valueOf(paramInt), paramString });
      return null;
    } 
  }
  
  public static long c(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte == null)
      return -1L; 
    try {
      String str = new String();
      this(paramArrayOfbyte, "utf-8");
      return Long.parseLong(str);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return -1L;
    } 
  }
  
  private static ArrayList<String> c(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic f : (Landroid/content/Context;)Z
    //   4: ifeq -> 28
    //   7: new java/util/ArrayList
    //   10: dup
    //   11: iconst_1
    //   12: anewarray java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 'unknown(low memory)'
    //   20: aastore
    //   21: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   24: invokespecial <init> : (Ljava/util/Collection;)V
    //   27: areturn
    //   28: new java/util/ArrayList
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_3
    //   38: ldc_w '/system/bin/sh'
    //   41: astore_0
    //   42: new java/io/File
    //   45: astore #4
    //   47: aload #4
    //   49: ldc_w '/system/bin/sh'
    //   52: invokespecial <init> : (Ljava/lang/String;)V
    //   55: aload #4
    //   57: invokevirtual exists : ()Z
    //   60: ifeq -> 84
    //   63: new java/io/File
    //   66: astore #4
    //   68: aload #4
    //   70: ldc_w '/system/bin/sh'
    //   73: invokespecial <init> : (Ljava/lang/String;)V
    //   76: aload #4
    //   78: invokevirtual canExecute : ()Z
    //   81: ifne -> 88
    //   84: ldc_w 'sh'
    //   87: astore_0
    //   88: new java/util/ArrayList
    //   91: astore #4
    //   93: aload #4
    //   95: iconst_2
    //   96: anewarray java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload_0
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: ldc_w '-c'
    //   108: aastore
    //   109: invokestatic asList : ([Ljava/lang/Object;)Ljava/util/List;
    //   112: invokespecial <init> : (Ljava/util/Collection;)V
    //   115: aload #4
    //   117: aload_1
    //   118: invokeinterface add : (Ljava/lang/Object;)Z
    //   123: pop
    //   124: invokestatic getRuntime : ()Ljava/lang/Runtime;
    //   127: aload #4
    //   129: iconst_3
    //   130: anewarray java/lang/String
    //   133: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   138: checkcast [Ljava/lang/String;
    //   141: invokevirtual exec : ([Ljava/lang/String;)Ljava/lang/Process;
    //   144: astore_1
    //   145: new java/io/BufferedReader
    //   148: astore_0
    //   149: new java/io/InputStreamReader
    //   152: astore #4
    //   154: aload #4
    //   156: aload_1
    //   157: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   160: invokespecial <init> : (Ljava/io/InputStream;)V
    //   163: aload_0
    //   164: aload #4
    //   166: invokespecial <init> : (Ljava/io/Reader;)V
    //   169: aload_0
    //   170: invokevirtual readLine : ()Ljava/lang/String;
    //   173: astore #4
    //   175: aload #4
    //   177: ifnull -> 190
    //   180: aload_2
    //   181: aload #4
    //   183: invokevirtual add : (Ljava/lang/Object;)Z
    //   186: pop
    //   187: goto -> 169
    //   190: new java/io/InputStreamReader
    //   193: astore #4
    //   195: aload #4
    //   197: aload_1
    //   198: invokevirtual getErrorStream : ()Ljava/io/InputStream;
    //   201: invokespecial <init> : (Ljava/io/InputStream;)V
    //   204: new java/io/BufferedReader
    //   207: dup
    //   208: aload #4
    //   210: invokespecial <init> : (Ljava/io/Reader;)V
    //   213: astore #5
    //   215: aload_0
    //   216: astore_1
    //   217: aload #5
    //   219: astore #4
    //   221: aload #5
    //   223: invokevirtual readLine : ()Ljava/lang/String;
    //   226: astore_3
    //   227: aload_3
    //   228: ifnull -> 246
    //   231: aload_0
    //   232: astore_1
    //   233: aload #5
    //   235: astore #4
    //   237: aload_2
    //   238: aload_3
    //   239: invokevirtual add : (Ljava/lang/Object;)Z
    //   242: pop
    //   243: goto -> 215
    //   246: aload_0
    //   247: invokevirtual close : ()V
    //   250: goto -> 258
    //   253: astore_0
    //   254: aload_0
    //   255: invokevirtual printStackTrace : ()V
    //   258: aload #5
    //   260: invokevirtual close : ()V
    //   263: goto -> 271
    //   266: astore_0
    //   267: aload_0
    //   268: invokevirtual printStackTrace : ()V
    //   271: aload_2
    //   272: areturn
    //   273: astore_1
    //   274: aload_0
    //   275: astore_3
    //   276: aload #5
    //   278: astore_0
    //   279: aload_1
    //   280: astore #5
    //   282: goto -> 322
    //   285: astore_3
    //   286: aconst_null
    //   287: astore #4
    //   289: aload_0
    //   290: astore_1
    //   291: aload_3
    //   292: astore_0
    //   293: goto -> 380
    //   296: astore #5
    //   298: aconst_null
    //   299: astore_1
    //   300: aload_0
    //   301: astore_3
    //   302: aload_1
    //   303: astore_0
    //   304: goto -> 322
    //   307: astore_0
    //   308: aconst_null
    //   309: astore #4
    //   311: aload_3
    //   312: astore_1
    //   313: goto -> 380
    //   316: astore #5
    //   318: aconst_null
    //   319: astore_3
    //   320: aload_3
    //   321: astore_0
    //   322: aload_3
    //   323: astore_1
    //   324: aload_0
    //   325: astore #4
    //   327: aload #5
    //   329: invokestatic a : (Ljava/lang/Throwable;)Z
    //   332: ifne -> 345
    //   335: aload_3
    //   336: astore_1
    //   337: aload_0
    //   338: astore #4
    //   340: aload #5
    //   342: invokevirtual printStackTrace : ()V
    //   345: aload_3
    //   346: ifnull -> 361
    //   349: aload_3
    //   350: invokevirtual close : ()V
    //   353: goto -> 361
    //   356: astore_1
    //   357: aload_1
    //   358: invokevirtual printStackTrace : ()V
    //   361: aload_0
    //   362: ifnull -> 377
    //   365: aload_0
    //   366: invokevirtual close : ()V
    //   369: goto -> 377
    //   372: astore_0
    //   373: aload_0
    //   374: invokevirtual printStackTrace : ()V
    //   377: aconst_null
    //   378: areturn
    //   379: astore_0
    //   380: aload_1
    //   381: ifnull -> 396
    //   384: aload_1
    //   385: invokevirtual close : ()V
    //   388: goto -> 396
    //   391: astore_1
    //   392: aload_1
    //   393: invokevirtual printStackTrace : ()V
    //   396: aload #4
    //   398: ifnull -> 414
    //   401: aload #4
    //   403: invokevirtual close : ()V
    //   406: goto -> 414
    //   409: astore_1
    //   410: aload_1
    //   411: invokevirtual printStackTrace : ()V
    //   414: aload_0
    //   415: athrow
    // Exception table:
    //   from	to	target	type
    //   42	76	316	java/lang/Throwable
    //   42	76	307	finally
    //   76	84	316	java/lang/Throwable
    //   76	84	307	finally
    //   88	169	316	java/lang/Throwable
    //   88	169	307	finally
    //   169	175	296	java/lang/Throwable
    //   169	175	285	finally
    //   180	187	296	java/lang/Throwable
    //   180	187	285	finally
    //   190	215	296	java/lang/Throwable
    //   190	215	285	finally
    //   221	227	273	java/lang/Throwable
    //   221	227	379	finally
    //   237	243	273	java/lang/Throwable
    //   237	243	379	finally
    //   246	250	253	java/io/IOException
    //   258	263	266	java/io/IOException
    //   327	335	379	finally
    //   340	345	379	finally
    //   349	353	356	java/io/IOException
    //   365	369	372	java/io/IOException
    //   384	388	391	java/io/IOException
    //   401	406	409	java/io/IOException
  }
  
  public static boolean c(String paramString) {
    boolean bool;
    if (paramString != null && paramString.trim().length() > 0) {
      bool = false;
    } else {
      bool = true;
    } 
    if (bool)
      return false; 
    if (paramString.length() > 255) {
      x.a("URL(%s)'s length is larger than 255.", new Object[] { paramString });
      return false;
    } 
    if (!paramString.toLowerCase().startsWith("http")) {
      x.a("URL(%s) is not start with \"http\".", new Object[] { paramString });
      return false;
    } 
    return true;
  }
  
  public static byte[] c(long paramLong) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(paramLong);
      return stringBuilder.toString().getBytes("utf-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */