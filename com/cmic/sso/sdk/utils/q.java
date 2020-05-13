package com.cmic.sso.sdk.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.cmic.sso.sdk.a.b;

public class q {
  private static final String a = q.class.getSimpleName();
  
  private static q c;
  
  private Context b;
  
  private q(Context paramContext) {
    this.b = paramContext;
  }
  
  public static final q a(Context paramContext) {
    if (c == null)
      c = new q(paramContext); 
    return c;
  }
  
  public String a() {
    // Byte code:
    //   0: invokestatic a : ()Lcom/cmic/sso/sdk/a/b;
    //   3: aload_0
    //   4: getfield b : Landroid/content/Context;
    //   7: invokevirtual a : (Landroid/content/Context;)Lcom/cmic/sso/sdk/a/b$b;
    //   10: astore_1
    //   11: aload_1
    //   12: aload_1
    //   13: invokevirtual f : ()I
    //   16: invokevirtual f : (I)Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   26: ifeq -> 179
    //   29: aload_0
    //   30: getfield b : Landroid/content/Context;
    //   33: ldc 'phone'
    //   35: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   38: checkcast android/telephony/TelephonyManager
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual getSubscriberId : ()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   55: ifeq -> 179
    //   58: aload_3
    //   59: invokevirtual getSimOperator : ()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_2
    //   64: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   67: ifeq -> 94
    //   70: ldc ''
    //   72: astore_1
    //   73: aload_1
    //   74: areturn
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual printStackTrace : ()V
    //   80: goto -> 49
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual printStackTrace : ()V
    //   88: ldc ''
    //   90: astore_1
    //   91: goto -> 73
    //   94: invokestatic a : ()Ljava/lang/String;
    //   97: astore_3
    //   98: new java/lang/StringBuilder
    //   101: astore_1
    //   102: aload_1
    //   103: invokespecial <init> : ()V
    //   106: aload_1
    //   107: aload_2
    //   108: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_3
    //   112: aload_3
    //   113: invokevirtual length : ()I
    //   116: bipush #11
    //   118: isub
    //   119: aload_3
    //   120: invokevirtual length : ()I
    //   123: invokevirtual substring : (II)Ljava/lang/String;
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual toString : ()Ljava/lang/String;
    //   132: astore_2
    //   133: aload_2
    //   134: astore_1
    //   135: aload_2
    //   136: ldc '460'
    //   138: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   141: ifne -> 147
    //   144: ldc ''
    //   146: astore_1
    //   147: getstatic com/cmic/sso/sdk/utils/q.a : Ljava/lang/String;
    //   150: astore_3
    //   151: new java/lang/StringBuilder
    //   154: astore_2
    //   155: aload_2
    //   156: invokespecial <init> : ()V
    //   159: aload_3
    //   160: aload_2
    //   161: ldc 'imsi='
    //   163: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_1
    //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual toString : ()Ljava/lang/String;
    //   173: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)V
    //   176: goto -> 73
    //   179: aload_1
    //   180: astore_2
    //   181: goto -> 133
    // Exception table:
    //   from	to	target	type
    //   0	20	83	java/lang/Exception
    //   22	42	83	java/lang/Exception
    //   42	47	75	java/lang/Exception
    //   51	70	83	java/lang/Exception
    //   76	80	83	java/lang/Exception
    //   94	133	83	java/lang/Exception
    //   135	144	83	java/lang/Exception
    //   147	176	83	java/lang/Exception
  }
  
  public String a(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifne -> 17
    //   9: aload_1
    //   10: invokevirtual length : ()I
    //   13: iconst_5
    //   14: if_icmpge -> 22
    //   17: ldc '0'
    //   19: astore_1
    //   20: aload_1
    //   21: areturn
    //   22: aload_1
    //   23: iconst_0
    //   24: iconst_5
    //   25: invokevirtual substring : (II)Ljava/lang/String;
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual hashCode : ()I
    //   33: lookupswitch default -> 124, 49679470 -> 186, 49679471 -> 240, 49679472 -> 198, 49679473 -> 283, 49679474 -> 226, 49679475 -> 298, 49679476 -> 254, 49679477 -> 212, 49679479 -> 268, 49679502 -> 313
    //   124: iconst_m1
    //   125: istore_2
    //   126: iload_2
    //   127: tableswitch default -> 180, 0 -> 328, 1 -> 328, 2 -> 328, 3 -> 328, 4 -> 342, 5 -> 342, 6 -> 342, 7 -> 356, 8 -> 356, 9 -> 356
    //   180: ldc '0'
    //   182: astore_1
    //   183: goto -> 20
    //   186: aload_1
    //   187: ldc '46000'
    //   189: invokevirtual equals : (Ljava/lang/Object;)Z
    //   192: ifeq -> 124
    //   195: goto -> 126
    //   198: aload_1
    //   199: ldc '46002'
    //   201: invokevirtual equals : (Ljava/lang/Object;)Z
    //   204: ifeq -> 124
    //   207: iconst_1
    //   208: istore_2
    //   209: goto -> 126
    //   212: aload_1
    //   213: ldc '46007'
    //   215: invokevirtual equals : (Ljava/lang/Object;)Z
    //   218: ifeq -> 124
    //   221: iconst_2
    //   222: istore_2
    //   223: goto -> 126
    //   226: aload_1
    //   227: ldc '46004'
    //   229: invokevirtual equals : (Ljava/lang/Object;)Z
    //   232: ifeq -> 124
    //   235: iconst_3
    //   236: istore_2
    //   237: goto -> 126
    //   240: aload_1
    //   241: ldc '46001'
    //   243: invokevirtual equals : (Ljava/lang/Object;)Z
    //   246: ifeq -> 124
    //   249: iconst_4
    //   250: istore_2
    //   251: goto -> 126
    //   254: aload_1
    //   255: ldc '46006'
    //   257: invokevirtual equals : (Ljava/lang/Object;)Z
    //   260: ifeq -> 124
    //   263: iconst_5
    //   264: istore_2
    //   265: goto -> 126
    //   268: aload_1
    //   269: ldc '46009'
    //   271: invokevirtual equals : (Ljava/lang/Object;)Z
    //   274: ifeq -> 124
    //   277: bipush #6
    //   279: istore_2
    //   280: goto -> 126
    //   283: aload_1
    //   284: ldc '46003'
    //   286: invokevirtual equals : (Ljava/lang/Object;)Z
    //   289: ifeq -> 124
    //   292: bipush #7
    //   294: istore_2
    //   295: goto -> 126
    //   298: aload_1
    //   299: ldc '46005'
    //   301: invokevirtual equals : (Ljava/lang/Object;)Z
    //   304: ifeq -> 124
    //   307: bipush #8
    //   309: istore_2
    //   310: goto -> 126
    //   313: aload_1
    //   314: ldc '46011'
    //   316: invokevirtual equals : (Ljava/lang/Object;)Z
    //   319: ifeq -> 124
    //   322: bipush #9
    //   324: istore_2
    //   325: goto -> 126
    //   328: getstatic com/cmic/sso/sdk/utils/q.a : Ljava/lang/String;
    //   331: ldc '中国移动'
    //   333: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   336: ldc '1'
    //   338: astore_1
    //   339: goto -> 20
    //   342: getstatic com/cmic/sso/sdk/utils/q.a : Ljava/lang/String;
    //   345: ldc '中国联通'
    //   347: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   350: ldc '2'
    //   352: astore_1
    //   353: goto -> 20
    //   356: getstatic com/cmic/sso/sdk/utils/q.a : Ljava/lang/String;
    //   359: ldc '中国电信'
    //   361: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   364: ldc '3'
    //   366: astore_1
    //   367: goto -> 20
  }
  
  public String b() {
    String str;
    try {
      b.b b = b.a().a(this.b);
      String str1 = b.f((b.f() + 1) % 2);
      str = str1;
      if (str1 == null)
        str = ""; 
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  public String c() {
    String str;
    try {
      b.b b = b.a().a(this.b);
      String str2 = b.g(b.f());
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
        str1 = ((TelephonyManager)this.b.getSystemService("phone")).getDeviceId(); 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      h.b("UMC_SDK", stringBuilder.append("imei is ").append(str1).toString());
      str = str1;
      if (str1 == null)
        str = "none"; 
    } catch (Exception exception) {
      str = "none";
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\cmic\sso\sd\\utils\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */