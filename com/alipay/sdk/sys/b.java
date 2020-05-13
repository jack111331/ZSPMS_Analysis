package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.data.c;
import com.ta.utdid2.device.UTDevice;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public final class b {
  private static b b;
  
  public Context a;
  
  public static b a() {
    if (b == null)
      b = new b(); 
    return b;
  }
  
  private static String a(String[] paramArrayOfString) {
    Process process;
    try {
      ProcessBuilder processBuilder = new ProcessBuilder();
      this(paramArrayOfString);
      processBuilder.redirectErrorStream(false);
      Process process1 = processBuilder.start();
      try {
        DataOutputStream dataOutputStream = new DataOutputStream();
        this(process1.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream();
        this(process1.getInputStream());
        String str = dataInputStream.readLine();
      } catch (Throwable throwable) {
      
      } finally {
        try {
          process.destroy();
        } catch (Exception null) {}
      } 
      return (String)paramArrayOfString;
    } catch (Throwable throwable) {
      process = null;
      return "";
    } finally {
      paramArrayOfString = null;
    } 
    try {
      process.destroy();
    } catch (Exception exception) {}
    throw paramArrayOfString;
  }
  
  public static boolean b() {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: iconst_0
    //   3: istore_1
    //   4: iload_1
    //   5: iconst_5
    //   6: if_icmpge -> 138
    //   9: new java/lang/StringBuilder
    //   12: astore_2
    //   13: aload_2
    //   14: invokespecial <init> : ()V
    //   17: aload_2
    //   18: iconst_5
    //   19: anewarray java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc '/system/xbin/'
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: ldc '/system/bin/'
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: ldc '/system/sbin/'
    //   36: aastore
    //   37: dup
    //   38: iconst_3
    //   39: ldc '/sbin/'
    //   41: aastore
    //   42: dup
    //   43: iconst_4
    //   44: ldc '/vendor/bin/'
    //   46: aastore
    //   47: iload_1
    //   48: aaload
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 'su'
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: astore_2
    //   61: new java/io/File
    //   64: astore_3
    //   65: aload_3
    //   66: aload_2
    //   67: invokespecial <init> : (Ljava/lang/String;)V
    //   70: aload_3
    //   71: invokevirtual exists : ()Z
    //   74: ifeq -> 131
    //   77: iconst_3
    //   78: anewarray java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: ldc 'ls'
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: ldc '-l'
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: aload_2
    //   94: aastore
    //   95: invokestatic a : ([Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_2
    //   99: aload_2
    //   100: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   103: ifne -> 127
    //   106: aload_2
    //   107: ldc 'root'
    //   109: invokevirtual indexOf : (Ljava/lang/String;)I
    //   112: istore_1
    //   113: aload_2
    //   114: ldc 'root'
    //   116: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   119: istore #4
    //   121: iload_1
    //   122: iload #4
    //   124: if_icmpne -> 129
    //   127: iconst_0
    //   128: istore_0
    //   129: iload_0
    //   130: ireturn
    //   131: iinc #1, 1
    //   134: goto -> 4
    //   137: astore_2
    //   138: iconst_0
    //   139: istore_0
    //   140: goto -> 129
    // Exception table:
    //   from	to	target	type
    //   9	121	137	java/lang/Exception
  }
  
  private Context d() {
    return this.a;
  }
  
  private static c e() {
    return c.a();
  }
  
  public final void a(Context paramContext) {
    this.a = paramContext.getApplicationContext();
  }
  
  public final String c() {
    String str = "";
    try {
      String str1 = UTDevice.getUtdid(this.a);
      str = str1;
    } catch (Throwable throwable) {
      a.a("third", "GetUtdidEx", throwable);
    } 
    return str;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\sdk\sys\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */