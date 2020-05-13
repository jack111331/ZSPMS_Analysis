package com.cmic.sso.sdk.utils;

import android.content.Context;

public class s {
  public static byte[] a(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   4: astore_2
    //   5: aload_0
    //   6: invokevirtual getPackageName : ()Ljava/lang/String;
    //   9: aload_1
    //   10: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   13: ifeq -> 60
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual getPackageName : ()Ljava/lang/String;
    //   21: bipush #64
    //   23: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   26: astore_0
    //   27: aload_0
    //   28: getfield packageName : Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual equals : (Ljava/lang/Object;)Z
    //   35: ifeq -> 60
    //   38: aload_0
    //   39: getfield signatures : [Landroid/content/pm/Signature;
    //   42: iconst_0
    //   43: aaload
    //   44: invokevirtual toByteArray : ()[B
    //   47: astore_0
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual printStackTrace : ()V
    //   55: aconst_null
    //   56: astore_0
    //   57: goto -> 48
    //   60: aload_2
    //   61: bipush #64
    //   63: invokevirtual getInstalledPackages : (I)Ljava/util/List;
    //   66: invokeinterface iterator : ()Ljava/util/Iterator;
    //   71: astore_2
    //   72: aload_2
    //   73: invokeinterface hasNext : ()Z
    //   78: ifeq -> 115
    //   81: aload_2
    //   82: invokeinterface next : ()Ljava/lang/Object;
    //   87: checkcast android/content/pm/PackageInfo
    //   90: astore_0
    //   91: aload_0
    //   92: getfield packageName : Ljava/lang/String;
    //   95: aload_1
    //   96: invokevirtual equals : (Ljava/lang/Object;)Z
    //   99: ifeq -> 72
    //   102: aload_0
    //   103: getfield signatures : [Landroid/content/pm/Signature;
    //   106: iconst_0
    //   107: aaload
    //   108: invokevirtual toByteArray : ()[B
    //   111: astore_0
    //   112: goto -> 48
    //   115: aconst_null
    //   116: astore_0
    //   117: goto -> 48
    // Exception table:
    //   from	to	target	type
    //   16	27	50	android/content/pm/PackageManager$NameNotFoundException
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */