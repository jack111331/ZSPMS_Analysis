package com.unionpay.mobile.android.pboctransaction.sdapdu;

import java.util.ArrayList;
import java.util.HashSet;

public final class b {
  public static String[] a;
  
  public static int b = 0;
  
  private static ArrayList<String> c = new ArrayList<String>();
  
  public static void a() {
    HashSet<String> hashSet = b();
    a = new String[hashSet.size()];
    hashSet.toArray((Object[])a);
  }
  
  private static HashSet<String> b() {
    // Byte code:
    //   0: new java/util/HashSet
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_0
    //   8: new java/lang/ProcessBuilder
    //   11: astore_1
    //   12: aload_1
    //   13: iconst_0
    //   14: anewarray java/lang/String
    //   17: invokespecial <init> : ([Ljava/lang/String;)V
    //   20: aload_1
    //   21: iconst_1
    //   22: anewarray java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc 'mount'
    //   29: aastore
    //   30: invokevirtual command : ([Ljava/lang/String;)Ljava/lang/ProcessBuilder;
    //   33: iconst_1
    //   34: invokevirtual redirectErrorStream : (Z)Ljava/lang/ProcessBuilder;
    //   37: invokevirtual start : ()Ljava/lang/Process;
    //   40: astore_1
    //   41: aload_1
    //   42: invokevirtual waitFor : ()I
    //   45: pop
    //   46: aload_1
    //   47: invokevirtual getInputStream : ()Ljava/io/InputStream;
    //   50: astore_2
    //   51: sipush #1024
    //   54: newarray byte
    //   56: astore_3
    //   57: ldc ''
    //   59: astore_1
    //   60: aload_2
    //   61: aload_3
    //   62: invokevirtual read : ([B)I
    //   65: iconst_m1
    //   66: if_icmpeq -> 116
    //   69: new java/lang/StringBuilder
    //   72: astore #4
    //   74: aload #4
    //   76: invokespecial <init> : ()V
    //   79: aload #4
    //   81: aload_1
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: astore #5
    //   87: new java/lang/String
    //   90: astore #4
    //   92: aload #4
    //   94: aload_3
    //   95: invokespecial <init> : ([B)V
    //   98: aload #5
    //   100: aload #4
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual toString : ()Ljava/lang/String;
    //   108: astore #4
    //   110: aload #4
    //   112: astore_1
    //   113: goto -> 60
    //   116: aload_2
    //   117: invokevirtual close : ()V
    //   120: aload_1
    //   121: ldc '\\n'
    //   123: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   126: astore_1
    //   127: aload_1
    //   128: arraylength
    //   129: istore #6
    //   131: iconst_0
    //   132: istore #7
    //   134: iload #7
    //   136: iload #6
    //   138: if_icmpge -> 258
    //   141: aload_1
    //   142: iload #7
    //   144: aaload
    //   145: astore #4
    //   147: aload #4
    //   149: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   152: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   155: ldc 'asec'
    //   157: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   160: ifne -> 252
    //   163: aload #4
    //   165: ldc '(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*'
    //   167: invokevirtual matches : (Ljava/lang/String;)Z
    //   170: ifeq -> 252
    //   173: aload #4
    //   175: ldc ' '
    //   177: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   180: astore #4
    //   182: aload #4
    //   184: arraylength
    //   185: istore #8
    //   187: iconst_0
    //   188: istore #9
    //   190: iload #9
    //   192: iload #8
    //   194: if_icmpge -> 252
    //   197: aload #4
    //   199: iload #9
    //   201: aaload
    //   202: astore_3
    //   203: aload_3
    //   204: ldc '/'
    //   206: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   209: ifeq -> 233
    //   212: aload_3
    //   213: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   216: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   219: ldc 'vold'
    //   221: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   224: ifne -> 233
    //   227: aload_0
    //   228: aload_3
    //   229: invokevirtual add : (Ljava/lang/Object;)Z
    //   232: pop
    //   233: iinc #9, 1
    //   236: goto -> 190
    //   239: astore #4
    //   241: ldc ''
    //   243: astore_1
    //   244: aload #4
    //   246: invokevirtual printStackTrace : ()V
    //   249: goto -> 120
    //   252: iinc #7, 1
    //   255: goto -> 134
    //   258: aload_0
    //   259: areturn
    //   260: astore #4
    //   262: goto -> 244
    // Exception table:
    //   from	to	target	type
    //   8	57	239	java/lang/Exception
    //   60	110	260	java/lang/Exception
    //   116	120	260	java/lang/Exception
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\sdapdu\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */