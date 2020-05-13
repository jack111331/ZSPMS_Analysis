package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class s {
  private static s b;
  
  public Map<String, String> a = null;
  
  private Context c;
  
  private s(Context paramContext) {
    this.c = paramContext;
  }
  
  public static s a(Context paramContext) {
    if (b == null)
      b = new s(paramContext); 
    return b;
  }
  
  private static HttpURLConnection a(String paramString1, String paramString2) {
    try {
      HttpURLConnection httpURLConnection;
      URL uRL = new URL();
      this(paramString2);
      if (a.b() != null) {
        httpURLConnection = (HttpURLConnection)uRL.openConnection(a.b());
      } else if (httpURLConnection != null && httpURLConnection.toLowerCase(Locale.US).contains("wap")) {
        paramString2 = System.getProperty("http.proxyHost");
        String str = System.getProperty("http.proxyPort");
        InetSocketAddress inetSocketAddress = new InetSocketAddress();
        this(paramString2, Integer.parseInt(str));
        Proxy proxy = new Proxy();
        this(Proxy.Type.HTTP, inetSocketAddress);
        HttpURLConnection httpURLConnection1 = (HttpURLConnection)uRL.openConnection(proxy);
      } else {
        httpURLConnection = (HttpURLConnection)uRL.openConnection();
      } 
      httpURLConnection.setConnectTimeout(30000);
      httpURLConnection.setReadTimeout(10000);
      httpURLConnection.setDoOutput(true);
      httpURLConnection.setDoInput(true);
      httpURLConnection.setRequestMethod("POST");
      httpURLConnection.setUseCaches(false);
      httpURLConnection.setInstanceFollowRedirects(false);
      return httpURLConnection;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      return null;
    } 
  }
  
  private HttpURLConnection a(String paramString1, byte[] paramArrayOfbyte, String paramString2, Map<String, String> paramMap) {
    if (paramString1 == null) {
      x.e("destUrl is null.", new Object[0]);
      return null;
    } 
    HttpURLConnection httpURLConnection = a(paramString2, paramString1);
    if (httpURLConnection == null) {
      x.e("Failed to get HttpURLConnection object.", new Object[0]);
      return null;
    } 
    try {
      httpURLConnection.setRequestProperty("wup_version", "3.0");
      if (paramMap != null && paramMap.size() > 0)
        for (Map.Entry<String, String> entry : paramMap.entrySet())
          httpURLConnection.setRequestProperty((String)entry.getKey(), URLEncoder.encode((String)entry.getValue(), "utf-8"));  
      httpURLConnection.setRequestProperty("A37", URLEncoder.encode(paramString2, "utf-8"));
      httpURLConnection.setRequestProperty("A38", URLEncoder.encode(paramString2, "utf-8"));
      OutputStream outputStream = httpURLConnection.getOutputStream();
      if (paramArrayOfbyte == null) {
        outputStream.write(0);
      } else {
        outputStream.write(paramArrayOfbyte);
      } 
      return httpURLConnection;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throwable.printStackTrace(); 
      x.e("Failed to upload, please check your network.", new Object[0]);
      return null;
    } 
  }
  
  private static Map<String, String> a(HttpURLConnection paramHttpURLConnection) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Map<String, List<String>> map = paramHttpURLConnection.getHeaderFields();
    if (map == null || map.size() == 0)
      return null; 
    for (String str : map.keySet()) {
      List list = map.get(str);
      if (list.size() > 0)
        hashMap.put(str, list.get(0)); 
    } 
    return (Map)hashMap;
  }
  
  private static byte[] b(HttpURLConnection paramHttpURLConnection) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new java/io/BufferedInputStream
    //   9: astore_1
    //   10: aload_1
    //   11: aload_0
    //   12: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   15: invokespecial <init> : (Ljava/io/InputStream;)V
    //   18: aload_1
    //   19: astore_0
    //   20: new java/io/ByteArrayOutputStream
    //   23: astore_2
    //   24: aload_1
    //   25: astore_0
    //   26: aload_2
    //   27: invokespecial <init> : ()V
    //   30: aload_1
    //   31: astore_0
    //   32: sipush #1024
    //   35: newarray byte
    //   37: astore_3
    //   38: aload_1
    //   39: astore_0
    //   40: aload_1
    //   41: aload_3
    //   42: invokevirtual read : ([B)I
    //   45: istore #4
    //   47: iload #4
    //   49: ifle -> 65
    //   52: aload_1
    //   53: astore_0
    //   54: aload_2
    //   55: aload_3
    //   56: iconst_0
    //   57: iload #4
    //   59: invokevirtual write : ([BII)V
    //   62: goto -> 38
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: invokevirtual flush : ()V
    //   71: aload_1
    //   72: astore_0
    //   73: aload_2
    //   74: invokevirtual toByteArray : ()[B
    //   77: astore_3
    //   78: aload_1
    //   79: invokevirtual close : ()V
    //   82: goto -> 90
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual printStackTrace : ()V
    //   90: aload_3
    //   91: areturn
    //   92: astore_3
    //   93: goto -> 105
    //   96: astore_1
    //   97: aconst_null
    //   98: astore_0
    //   99: goto -> 139
    //   102: astore_3
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: astore_0
    //   107: aload_3
    //   108: invokestatic a : (Ljava/lang/Throwable;)Z
    //   111: ifne -> 120
    //   114: aload_1
    //   115: astore_0
    //   116: aload_3
    //   117: invokevirtual printStackTrace : ()V
    //   120: aload_1
    //   121: ifnull -> 136
    //   124: aload_1
    //   125: invokevirtual close : ()V
    //   128: goto -> 136
    //   131: astore_0
    //   132: aload_0
    //   133: invokevirtual printStackTrace : ()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_1
    //   139: aload_0
    //   140: ifnull -> 155
    //   143: aload_0
    //   144: invokevirtual close : ()V
    //   147: goto -> 155
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual printStackTrace : ()V
    //   155: aload_1
    //   156: athrow
    // Exception table:
    //   from	to	target	type
    //   6	18	102	java/lang/Throwable
    //   6	18	96	finally
    //   20	24	92	java/lang/Throwable
    //   20	24	138	finally
    //   26	30	92	java/lang/Throwable
    //   26	30	138	finally
    //   32	38	92	java/lang/Throwable
    //   32	38	138	finally
    //   40	47	92	java/lang/Throwable
    //   40	47	138	finally
    //   54	62	92	java/lang/Throwable
    //   54	62	138	finally
    //   67	71	92	java/lang/Throwable
    //   67	71	138	finally
    //   73	78	92	java/lang/Throwable
    //   73	78	138	finally
    //   78	82	85	java/lang/Throwable
    //   107	114	138	finally
    //   116	120	138	finally
    //   124	128	131	java/lang/Throwable
    //   143	147	150	java/lang/Throwable
  }
  
  public final byte[] a(String paramString, byte[] paramArrayOfbyte, v paramv, Map<String, String> paramMap) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: iconst_0
    //   4: istore #6
    //   6: aload_1
    //   7: ifnonnull -> 23
    //   10: ldc_w 'Failed for no URL.'
    //   13: iconst_0
    //   14: anewarray java/lang/Object
    //   17: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   20: pop
    //   21: aconst_null
    //   22: areturn
    //   23: aload_2
    //   24: ifnonnull -> 33
    //   27: lconst_0
    //   28: lstore #7
    //   30: goto -> 38
    //   33: aload_2
    //   34: arraylength
    //   35: i2l
    //   36: lstore #7
    //   38: ldc_w 'request: %s, send: %d (pid=%d | tid=%d)'
    //   41: iconst_4
    //   42: anewarray java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: lload #7
    //   53: invokestatic valueOf : (J)Ljava/lang/Long;
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: invokestatic myPid : ()I
    //   62: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_3
    //   68: invokestatic myTid : ()I
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: iconst_0
    //   80: istore #9
    //   82: iconst_0
    //   83: istore #10
    //   85: iconst_0
    //   86: istore #11
    //   88: iload #9
    //   90: ifgt -> 687
    //   93: iload #10
    //   95: ifgt -> 687
    //   98: iload #11
    //   100: ifeq -> 109
    //   103: iconst_0
    //   104: istore #11
    //   106: goto -> 176
    //   109: iinc #9, 1
    //   112: iload #9
    //   114: iconst_1
    //   115: if_icmple -> 176
    //   118: new java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 'try time: '
    //   125: invokespecial <init> : (Ljava/lang/String;)V
    //   128: astore #12
    //   130: aload #12
    //   132: iload #9
    //   134: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload #12
    //   140: invokevirtual toString : ()Ljava/lang/String;
    //   143: iload #6
    //   145: anewarray java/lang/Object
    //   148: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   151: pop
    //   152: new java/util/Random
    //   155: dup
    //   156: invokestatic currentTimeMillis : ()J
    //   159: invokespecial <init> : (J)V
    //   162: sipush #10000
    //   165: invokevirtual nextInt : (I)I
    //   168: i2l
    //   169: ldc2_w 10000
    //   172: ladd
    //   173: invokestatic sleep : (J)V
    //   176: aload_0
    //   177: getfield c : Landroid/content/Context;
    //   180: invokestatic c : (Landroid/content/Context;)Ljava/lang/String;
    //   183: astore #12
    //   185: aload #12
    //   187: ifnonnull -> 205
    //   190: ldc_w 'Failed to request for network not avail'
    //   193: iload #6
    //   195: anewarray java/lang/Object
    //   198: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   201: pop
    //   202: goto -> 88
    //   205: aload_3
    //   206: lload #7
    //   208: invokevirtual a : (J)V
    //   211: aload_0
    //   212: aload_1
    //   213: aload_2
    //   214: aload #12
    //   216: aload #4
    //   218: invokespecial a : (Ljava/lang/String;[BLjava/lang/String;Ljava/util/Map;)Ljava/net/HttpURLConnection;
    //   221: astore #13
    //   223: aload #13
    //   225: ifnull -> 662
    //   228: aload #13
    //   230: invokevirtual getResponseCode : ()I
    //   233: istore #14
    //   235: iload #14
    //   237: sipush #200
    //   240: if_icmpne -> 305
    //   243: aload_0
    //   244: aload #13
    //   246: invokestatic a : (Ljava/net/HttpURLConnection;)Ljava/util/Map;
    //   249: putfield a : Ljava/util/Map;
    //   252: aload #13
    //   254: invokestatic b : (Ljava/net/HttpURLConnection;)[B
    //   257: astore #5
    //   259: aload #5
    //   261: ifnonnull -> 270
    //   264: lconst_0
    //   265: lstore #15
    //   267: goto -> 276
    //   270: aload #5
    //   272: arraylength
    //   273: i2l
    //   274: lstore #15
    //   276: aload_3
    //   277: lload #15
    //   279: invokevirtual b : (J)V
    //   282: aload #13
    //   284: invokevirtual disconnect : ()V
    //   287: goto -> 302
    //   290: astore_1
    //   291: aload_1
    //   292: invokestatic a : (Ljava/lang/Throwable;)Z
    //   295: ifne -> 302
    //   298: aload_1
    //   299: invokevirtual printStackTrace : ()V
    //   302: aload #5
    //   304: areturn
    //   305: iload #14
    //   307: sipush #301
    //   310: if_icmpeq -> 346
    //   313: iload #14
    //   315: sipush #302
    //   318: if_icmpeq -> 346
    //   321: iload #14
    //   323: sipush #303
    //   326: if_icmpeq -> 346
    //   329: iload #14
    //   331: sipush #307
    //   334: if_icmpne -> 340
    //   337: goto -> 346
    //   340: iconst_0
    //   341: istore #6
    //   343: goto -> 349
    //   346: iconst_1
    //   347: istore #6
    //   349: iload #6
    //   351: ifeq -> 502
    //   354: aload #13
    //   356: ldc_w 'Location'
    //   359: invokevirtual getHeaderField : (Ljava/lang/String;)Ljava/lang/String;
    //   362: astore #5
    //   364: aload #5
    //   366: ifnonnull -> 433
    //   369: new java/lang/StringBuilder
    //   372: astore #5
    //   374: aload #5
    //   376: ldc_w 'Failed to redirect: %d'
    //   379: invokespecial <init> : (Ljava/lang/String;)V
    //   382: aload #5
    //   384: iload #14
    //   386: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload #5
    //   392: invokevirtual toString : ()Ljava/lang/String;
    //   395: iconst_0
    //   396: anewarray java/lang/Object
    //   399: invokestatic e : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   402: pop
    //   403: aload #13
    //   405: invokevirtual disconnect : ()V
    //   408: goto -> 426
    //   411: astore_1
    //   412: aload_1
    //   413: invokestatic a : (Ljava/lang/Throwable;)Z
    //   416: ifne -> 408
    //   419: aload_1
    //   420: invokevirtual printStackTrace : ()V
    //   423: goto -> 408
    //   426: aconst_null
    //   427: areturn
    //   428: astore #5
    //   430: goto -> 496
    //   433: iinc #10, 1
    //   436: ldc_w 'redirect code: %d ,to:%s'
    //   439: iconst_2
    //   440: anewarray java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: iload #14
    //   447: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   450: aastore
    //   451: dup
    //   452: iconst_1
    //   453: aload #5
    //   455: aastore
    //   456: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   459: pop
    //   460: aload #5
    //   462: astore_1
    //   463: iconst_0
    //   464: istore #9
    //   466: iconst_1
    //   467: istore #11
    //   469: goto -> 502
    //   472: astore_1
    //   473: goto -> 478
    //   476: astore #12
    //   478: aload #5
    //   480: astore #12
    //   482: iconst_0
    //   483: istore #9
    //   485: aload_1
    //   486: astore #5
    //   488: aload #12
    //   490: astore_1
    //   491: goto -> 496
    //   494: astore #5
    //   496: iconst_1
    //   497: istore #11
    //   499: goto -> 601
    //   502: new java/lang/StringBuilder
    //   505: astore #5
    //   507: aload #5
    //   509: ldc_w 'response code '
    //   512: invokespecial <init> : (Ljava/lang/String;)V
    //   515: aload #5
    //   517: iload #14
    //   519: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload #5
    //   525: invokevirtual toString : ()Ljava/lang/String;
    //   528: iconst_0
    //   529: anewarray java/lang/Object
    //   532: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   535: pop
    //   536: aload #13
    //   538: invokevirtual getContentLength : ()I
    //   541: i2l
    //   542: lstore #17
    //   544: lload #17
    //   546: lstore #15
    //   548: lload #17
    //   550: lconst_0
    //   551: lcmp
    //   552: ifge -> 558
    //   555: lconst_0
    //   556: lstore #15
    //   558: aload_3
    //   559: lload #15
    //   561: invokevirtual b : (J)V
    //   564: aload #13
    //   566: invokevirtual disconnect : ()V
    //   569: goto -> 587
    //   572: astore #5
    //   574: aload #5
    //   576: invokestatic a : (Ljava/lang/Throwable;)Z
    //   579: ifne -> 587
    //   582: aload #5
    //   584: invokevirtual printStackTrace : ()V
    //   587: goto -> 637
    //   590: astore #5
    //   592: goto -> 601
    //   595: astore_1
    //   596: goto -> 640
    //   599: astore #5
    //   601: aload #5
    //   603: invokestatic a : (Ljava/lang/Throwable;)Z
    //   606: ifne -> 614
    //   609: aload #5
    //   611: invokevirtual printStackTrace : ()V
    //   614: aload #13
    //   616: invokevirtual disconnect : ()V
    //   619: goto -> 637
    //   622: astore #5
    //   624: aload #5
    //   626: invokestatic a : (Ljava/lang/Throwable;)Z
    //   629: ifne -> 637
    //   632: aload #5
    //   634: invokevirtual printStackTrace : ()V
    //   637: goto -> 678
    //   640: aload #13
    //   642: invokevirtual disconnect : ()V
    //   645: goto -> 660
    //   648: astore_2
    //   649: aload_2
    //   650: invokestatic a : (Ljava/lang/Throwable;)Z
    //   653: ifne -> 660
    //   656: aload_2
    //   657: invokevirtual printStackTrace : ()V
    //   660: aload_1
    //   661: athrow
    //   662: ldc_w 'Failed to execute post.'
    //   665: iconst_0
    //   666: anewarray java/lang/Object
    //   669: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   672: pop
    //   673: aload_3
    //   674: lconst_0
    //   675: invokevirtual b : (J)V
    //   678: aconst_null
    //   679: astore #5
    //   681: iconst_0
    //   682: istore #6
    //   684: goto -> 202
    //   687: aload #5
    //   689: areturn
    // Exception table:
    //   from	to	target	type
    //   228	235	599	java/io/IOException
    //   228	235	595	finally
    //   243	259	599	java/io/IOException
    //   243	259	595	finally
    //   270	276	599	java/io/IOException
    //   270	276	595	finally
    //   276	282	599	java/io/IOException
    //   276	282	595	finally
    //   282	287	290	java/lang/Throwable
    //   354	364	494	java/io/IOException
    //   354	364	595	finally
    //   369	403	428	java/io/IOException
    //   369	403	595	finally
    //   403	408	411	java/lang/Throwable
    //   436	460	472	java/io/IOException
    //   436	460	595	finally
    //   502	544	590	java/io/IOException
    //   502	544	595	finally
    //   558	564	590	java/io/IOException
    //   558	564	595	finally
    //   564	569	572	java/lang/Throwable
    //   601	614	595	finally
    //   614	619	622	java/lang/Throwable
    //   640	645	648	java/lang/Throwable
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */