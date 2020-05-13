package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TraceFileHelper {
  private static String a(BufferedReader paramBufferedReader) throws IOException {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < 3; b++) {
      String str = paramBufferedReader.readLine();
      if (str == null)
        return null; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("\n");
      stringBuffer.append(stringBuilder.toString());
    } 
    return stringBuffer.toString();
  }
  
  private static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs) throws IOException {
    if (paramBufferedReader == null || paramVarArgs == null)
      return null; 
    while (true) {
      String str = paramBufferedReader.readLine();
      if (str != null) {
        int i = paramVarArgs.length;
        for (byte b = 0; b < i; b++) {
          Pattern pattern = paramVarArgs[b];
          if (pattern.matcher(str).matches())
            return new Object[] { pattern, str }; 
        } 
        continue;
      } 
      return null;
    } 
  }
  
  private static String b(BufferedReader paramBufferedReader) throws IOException {
    StringBuffer stringBuffer = new StringBuffer();
    while (true) {
      String str = paramBufferedReader.readLine();
      if (str != null && str.trim().length() > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuffer.append(stringBuilder.toString());
        continue;
      } 
      break;
    } 
    return stringBuffer.toString();
  }
  
  public static a readFirstDumpInfo(String paramString, boolean paramBoolean) {
    if (paramString == null) {
      x.e("path:%s", new Object[] { paramString });
      return null;
    } 
    a a = new a();
    readTraceFile(paramString, new b(a, paramBoolean) {
          public final boolean a(long param1Long) {
            x.c("process end %d", new Object[] { Long.valueOf(param1Long) });
            return false;
          }
          
          public final boolean a(long param1Long1, long param1Long2, String param1String) {
            x.c("new process %s", new Object[] { param1String });
            this.a.a = param1Long1;
            this.a.b = param1String;
            this.a.c = param1Long2;
            return !!this.b;
          }
          
          public final boolean a(String param1String1, int param1Int, String param1String2, String param1String3) {
            x.c("new thread %s", new Object[] { param1String1 });
            if (this.a.d == null)
              this.a.d = (Map)new HashMap<String, String>(); 
            Map<String, String[]> map = this.a.d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int);
            map.put(param1String1, new String[] { param1String2, param1String3, stringBuilder.toString() });
            return true;
          }
        });
    if (a.a > 0L && a.c > 0L && a.b != null)
      return a; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.a);
    stringBuilder.append(" ");
    stringBuilder.append(a.c);
    stringBuilder.append(" ");
    stringBuilder.append(a.b);
    x.e("first dump error %s", new Object[] { stringBuilder.toString() });
    return null;
  }
  
  public static a readTargetDumpInfo(String paramString1, String paramString2, boolean paramBoolean) {
    if (paramString1 == null || paramString2 == null)
      return null; 
    a a = new a();
    readTraceFile(paramString2, new b(a, paramString1, paramBoolean) {
          public final boolean a(long param1Long) {
            x.c("process end %d", new Object[] { Long.valueOf(param1Long) });
            return (this.a.a <= 0L || this.a.c <= 0L || this.a.b == null);
          }
          
          public final boolean a(long param1Long1, long param1Long2, String param1String) {
            x.c("new process %s", new Object[] { param1String });
            if (!param1String.equals(this.b))
              return true; 
            this.a.a = param1Long1;
            this.a.b = param1String;
            this.a.c = param1Long2;
            return !!this.c;
          }
          
          public final boolean a(String param1String1, int param1Int, String param1String2, String param1String3) {
            x.c("new thread %s", new Object[] { param1String1 });
            if (this.a.a <= 0L || this.a.c <= 0L || this.a.b == null)
              return true; 
            if (this.a.d == null)
              this.a.d = (Map)new HashMap<String, String>(); 
            Map<String, String[]> map = this.a.d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int);
            map.put(param1String1, new String[] { param1String2, param1String3, stringBuilder.toString() });
            return true;
          }
        });
    return (a.a > 0L && a.c > 0L && a.b != null) ? a : null;
  }
  
  public static void readTraceFile(String paramString, b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 698
    //   4: aload_1
    //   5: ifnonnull -> 11
    //   8: goto -> 698
    //   11: new java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokespecial <init> : (Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: invokevirtual exists : ()Z
    //   24: ifne -> 28
    //   27: return
    //   28: aload_2
    //   29: invokevirtual lastModified : ()J
    //   32: pop2
    //   33: aload_2
    //   34: invokevirtual length : ()J
    //   37: pop2
    //   38: aconst_null
    //   39: astore_3
    //   40: aconst_null
    //   41: astore #4
    //   43: aload #4
    //   45: astore_0
    //   46: new java/io/BufferedReader
    //   49: astore #5
    //   51: aload #4
    //   53: astore_0
    //   54: new java/io/FileReader
    //   57: astore #6
    //   59: aload #4
    //   61: astore_0
    //   62: aload #6
    //   64: aload_2
    //   65: invokespecial <init> : (Ljava/io/File;)V
    //   68: aload #4
    //   70: astore_0
    //   71: aload #5
    //   73: aload #6
    //   75: invokespecial <init> : (Ljava/io/Reader;)V
    //   78: ldc '-{5}\spid\s\d+\sat\s\d+-\d+-\d+\s\d{2}:\d{2}:\d{2}\s-{5}'
    //   80: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   83: astore_0
    //   84: ldc '-{5}\send\s\d+\s-{5}'
    //   86: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   89: astore_2
    //   90: ldc 'Cmd\sline:\s(\S+)'
    //   92: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   95: astore_3
    //   96: ldc '".+"\s(daemon\s){0,1}prio=\d+\stid=\d+\s.*'
    //   98: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   101: astore #6
    //   103: new java/text/SimpleDateFormat
    //   106: astore #4
    //   108: aload #4
    //   110: ldc 'yyyy-MM-dd HH:mm:ss'
    //   112: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   115: invokespecial <init> : (Ljava/lang/String;Ljava/util/Locale;)V
    //   118: aload #5
    //   120: iconst_1
    //   121: anewarray java/util/regex/Pattern
    //   124: dup
    //   125: iconst_0
    //   126: aload_0
    //   127: aastore
    //   128: invokestatic a : (Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   131: astore #7
    //   133: aload #7
    //   135: ifnull -> 525
    //   138: aload #7
    //   140: iconst_1
    //   141: aaload
    //   142: invokevirtual toString : ()Ljava/lang/String;
    //   145: ldc '\s'
    //   147: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   150: astore #8
    //   152: aload #8
    //   154: iconst_2
    //   155: aaload
    //   156: invokestatic parseLong : (Ljava/lang/String;)J
    //   159: lstore #9
    //   161: new java/lang/StringBuilder
    //   164: astore #7
    //   166: aload #7
    //   168: invokespecial <init> : ()V
    //   171: aload #7
    //   173: aload #8
    //   175: iconst_4
    //   176: aaload
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload #7
    //   183: ldc ' '
    //   185: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload #7
    //   191: aload #8
    //   193: iconst_5
    //   194: aaload
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload #4
    //   201: aload #7
    //   203: invokevirtual toString : ()Ljava/lang/String;
    //   206: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   209: invokevirtual getTime : ()J
    //   212: lstore #11
    //   214: aload #5
    //   216: iconst_1
    //   217: anewarray java/util/regex/Pattern
    //   220: dup
    //   221: iconst_0
    //   222: aload_3
    //   223: aastore
    //   224: invokestatic a : (Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   227: astore #7
    //   229: aload #7
    //   231: ifnonnull -> 253
    //   234: aload #5
    //   236: invokevirtual close : ()V
    //   239: return
    //   240: astore_0
    //   241: aload_0
    //   242: invokestatic a : (Ljava/lang/Throwable;)Z
    //   245: ifne -> 252
    //   248: aload_0
    //   249: invokevirtual printStackTrace : ()V
    //   252: return
    //   253: aload_3
    //   254: aload #7
    //   256: iconst_1
    //   257: aaload
    //   258: invokevirtual toString : ()Ljava/lang/String;
    //   261: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   264: astore #7
    //   266: aload #7
    //   268: invokevirtual find : ()Z
    //   271: pop
    //   272: aload #7
    //   274: iconst_1
    //   275: invokevirtual group : (I)Ljava/lang/String;
    //   278: pop
    //   279: aload_1
    //   280: lload #9
    //   282: lload #11
    //   284: aload #7
    //   286: iconst_1
    //   287: invokevirtual group : (I)Ljava/lang/String;
    //   290: invokeinterface a : (JJLjava/lang/String;)Z
    //   295: istore #13
    //   297: iload #13
    //   299: ifne -> 321
    //   302: aload #5
    //   304: invokevirtual close : ()V
    //   307: return
    //   308: astore_0
    //   309: aload_0
    //   310: invokestatic a : (Ljava/lang/Throwable;)Z
    //   313: ifne -> 320
    //   316: aload_0
    //   317: invokevirtual printStackTrace : ()V
    //   320: return
    //   321: aload #5
    //   323: iconst_2
    //   324: anewarray java/util/regex/Pattern
    //   327: dup
    //   328: iconst_0
    //   329: aload #6
    //   331: aastore
    //   332: dup
    //   333: iconst_1
    //   334: aload_2
    //   335: aastore
    //   336: invokestatic a : (Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   339: astore #7
    //   341: aload #7
    //   343: ifnull -> 118
    //   346: aload #7
    //   348: iconst_0
    //   349: aaload
    //   350: aload #6
    //   352: if_acmpne -> 476
    //   355: aload #7
    //   357: iconst_1
    //   358: aaload
    //   359: invokevirtual toString : ()Ljava/lang/String;
    //   362: astore #7
    //   364: ldc '".+"'
    //   366: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   369: aload #7
    //   371: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   374: astore #8
    //   376: aload #8
    //   378: invokevirtual find : ()Z
    //   381: pop
    //   382: aload #8
    //   384: invokevirtual group : ()Ljava/lang/String;
    //   387: astore #8
    //   389: aload #8
    //   391: iconst_1
    //   392: aload #8
    //   394: invokevirtual length : ()I
    //   397: iconst_1
    //   398: isub
    //   399: invokevirtual substring : (II)Ljava/lang/String;
    //   402: astore #8
    //   404: aload #7
    //   406: ldc 'NATIVE'
    //   408: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   411: pop
    //   412: ldc 'tid=\d+'
    //   414: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   417: aload #7
    //   419: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   422: astore #7
    //   424: aload #7
    //   426: invokevirtual find : ()Z
    //   429: pop
    //   430: aload #7
    //   432: invokevirtual group : ()Ljava/lang/String;
    //   435: astore #7
    //   437: aload_1
    //   438: aload #8
    //   440: aload #7
    //   442: aload #7
    //   444: ldc '='
    //   446: invokevirtual indexOf : (Ljava/lang/String;)I
    //   449: iconst_1
    //   450: iadd
    //   451: invokevirtual substring : (I)Ljava/lang/String;
    //   454: invokestatic parseInt : (Ljava/lang/String;)I
    //   457: aload #5
    //   459: invokestatic a : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   462: aload #5
    //   464: invokestatic b : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   467: invokeinterface a : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z
    //   472: pop
    //   473: goto -> 321
    //   476: aload_1
    //   477: aload #7
    //   479: iconst_1
    //   480: aaload
    //   481: invokevirtual toString : ()Ljava/lang/String;
    //   484: ldc '\s'
    //   486: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   489: iconst_2
    //   490: aaload
    //   491: invokestatic parseLong : (Ljava/lang/String;)J
    //   494: invokeinterface a : (J)Z
    //   499: istore #13
    //   501: iload #13
    //   503: ifne -> 118
    //   506: aload #5
    //   508: invokevirtual close : ()V
    //   511: return
    //   512: astore_0
    //   513: aload_0
    //   514: invokestatic a : (Ljava/lang/Throwable;)Z
    //   517: ifne -> 524
    //   520: aload_0
    //   521: invokevirtual printStackTrace : ()V
    //   524: return
    //   525: aload #5
    //   527: invokevirtual close : ()V
    //   530: return
    //   531: astore_0
    //   532: aload_0
    //   533: invokestatic a : (Ljava/lang/Throwable;)Z
    //   536: ifne -> 543
    //   539: aload_0
    //   540: invokevirtual printStackTrace : ()V
    //   543: return
    //   544: astore_0
    //   545: goto -> 671
    //   548: astore_0
    //   549: aload #5
    //   551: astore_1
    //   552: aload_0
    //   553: astore #5
    //   555: goto -> 571
    //   558: astore_1
    //   559: aload_0
    //   560: astore #5
    //   562: aload_1
    //   563: astore_0
    //   564: goto -> 671
    //   567: astore #5
    //   569: aload_3
    //   570: astore_1
    //   571: aload_1
    //   572: astore_0
    //   573: aload #5
    //   575: invokestatic a : (Ljava/lang/Throwable;)Z
    //   578: ifne -> 588
    //   581: aload_1
    //   582: astore_0
    //   583: aload #5
    //   585: invokevirtual printStackTrace : ()V
    //   588: aload_1
    //   589: astore_0
    //   590: aload #5
    //   592: invokevirtual getClass : ()Ljava/lang/Class;
    //   595: invokevirtual getName : ()Ljava/lang/String;
    //   598: astore #4
    //   600: aload_1
    //   601: astore_0
    //   602: new java/lang/StringBuilder
    //   605: astore_3
    //   606: aload_1
    //   607: astore_0
    //   608: aload_3
    //   609: invokespecial <init> : ()V
    //   612: aload_1
    //   613: astore_0
    //   614: aload_3
    //   615: aload #5
    //   617: invokevirtual getMessage : ()Ljava/lang/String;
    //   620: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload_1
    //   625: astore_0
    //   626: ldc 'trace open fail:%s : %s'
    //   628: iconst_2
    //   629: anewarray java/lang/Object
    //   632: dup
    //   633: iconst_0
    //   634: aload #4
    //   636: aastore
    //   637: dup
    //   638: iconst_1
    //   639: aload_3
    //   640: invokevirtual toString : ()Ljava/lang/String;
    //   643: aastore
    //   644: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   647: pop
    //   648: aload_1
    //   649: ifnull -> 670
    //   652: aload_1
    //   653: invokevirtual close : ()V
    //   656: return
    //   657: astore_0
    //   658: aload_0
    //   659: invokestatic a : (Ljava/lang/Throwable;)Z
    //   662: ifne -> 669
    //   665: aload_0
    //   666: invokevirtual printStackTrace : ()V
    //   669: return
    //   670: return
    //   671: aload #5
    //   673: ifnull -> 696
    //   676: aload #5
    //   678: invokevirtual close : ()V
    //   681: goto -> 696
    //   684: astore_1
    //   685: aload_1
    //   686: invokestatic a : (Ljava/lang/Throwable;)Z
    //   689: ifne -> 696
    //   692: aload_1
    //   693: invokevirtual printStackTrace : ()V
    //   696: aload_0
    //   697: athrow
    //   698: return
    // Exception table:
    //   from	to	target	type
    //   46	51	567	java/lang/Exception
    //   46	51	558	finally
    //   54	59	567	java/lang/Exception
    //   54	59	558	finally
    //   62	68	567	java/lang/Exception
    //   62	68	558	finally
    //   71	78	567	java/lang/Exception
    //   71	78	558	finally
    //   78	118	548	java/lang/Exception
    //   78	118	544	finally
    //   118	133	548	java/lang/Exception
    //   118	133	544	finally
    //   138	229	548	java/lang/Exception
    //   138	229	544	finally
    //   234	239	240	java/io/IOException
    //   253	297	548	java/lang/Exception
    //   253	297	544	finally
    //   302	307	308	java/io/IOException
    //   321	341	548	java/lang/Exception
    //   321	341	544	finally
    //   355	473	548	java/lang/Exception
    //   355	473	544	finally
    //   476	501	548	java/lang/Exception
    //   476	501	544	finally
    //   506	511	512	java/io/IOException
    //   525	530	531	java/io/IOException
    //   573	581	558	finally
    //   583	588	558	finally
    //   590	600	558	finally
    //   602	606	558	finally
    //   608	612	558	finally
    //   614	624	558	finally
    //   626	648	558	finally
    //   652	656	657	java/io/IOException
    //   676	681	684	java/io/IOException
  }
  
  public static final class a {
    public long a;
    
    public String b;
    
    public long c;
    
    public Map<String, String[]> d;
  }
  
  public static interface b {
    boolean a(long param1Long);
    
    boolean a(long param1Long1, long param1Long2, String param1String);
    
    boolean a(String param1String1, int param1Int, String param1String2, String param1String3);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\TraceFileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */