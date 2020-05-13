package com.unionpay.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

final class g {
  private static volatile g a = null;
  
  private static ba e = null;
  
  private final CRC32 b = new CRC32();
  
  private Handler c = null;
  
  private final HandlerThread d = new HandlerThread("NetWorkThread");
  
  static {
    (a()).d.start();
    (a()).c = new l((a()).d.getLooper());
  }
  
  public static g a() {
    // Byte code:
    //   0: getstatic com/unionpay/sdk/g.a : Lcom/unionpay/sdk/g;
    //   3: ifnonnull -> 30
    //   6: ldc com/unionpay/sdk/g
    //   8: monitorenter
    //   9: getstatic com/unionpay/sdk/g.a : Lcom/unionpay/sdk/g;
    //   12: ifnonnull -> 27
    //   15: new com/unionpay/sdk/g
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/unionpay/sdk/g.a : Lcom/unionpay/sdk/g;
    //   27: ldc com/unionpay/sdk/g
    //   29: monitorexit
    //   30: getstatic com/unionpay/sdk/g.a : Lcom/unionpay/sdk/g;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/unionpay/sdk/g
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
  }
  
  private final void a(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfbyte, Object paramObject, int paramInt, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload #8
    //   4: ifne -> 218
    //   7: aload #5
    //   9: invokestatic a : ([B)[B
    //   12: astore #5
    //   14: aload_0
    //   15: getfield b : Ljava/util/zip/CRC32;
    //   18: invokevirtual reset : ()V
    //   21: aload_0
    //   22: getfield b : Ljava/util/zip/CRC32;
    //   25: aload #5
    //   27: invokevirtual update : ([B)V
    //   30: iload #7
    //   32: ifne -> 164
    //   35: new java/lang/StringBuilder
    //   38: astore #9
    //   40: aload #9
    //   42: invokespecial <init> : ()V
    //   45: aload #9
    //   47: aload_1
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc '?crc='
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: getfield b : Ljava/util/zip/CRC32;
    //   60: invokevirtual getValue : ()J
    //   63: invokestatic toHexString : (J)Ljava/lang/String;
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: astore_1
    //   73: getstatic com/unionpay/sdk/ab.mContext : Landroid/content/Context;
    //   76: aload_3
    //   77: aload_2
    //   78: aload_1
    //   79: aload #4
    //   81: aload #5
    //   83: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)Lcom/unionpay/sdk/b$d;
    //   86: astore_1
    //   87: invokestatic elapsedRealtime : ()J
    //   90: putstatic com/unionpay/sdk/ab.e : J
    //   93: new com/unionpay/sdk/bb
    //   96: astore_2
    //   97: aload_2
    //   98: invokespecial <init> : ()V
    //   101: aload_2
    //   102: getfield a : Landroid/os/Bundle;
    //   105: ldc 'statusCode'
    //   107: aload_1
    //   108: getfield a : I
    //   111: invokevirtual putInt : (Ljava/lang/String;I)V
    //   114: aload_2
    //   115: getfield a : Landroid/os/Bundle;
    //   118: ldc 'responseMsg'
    //   120: aload_1
    //   121: getfield b : Ljava/lang/String;
    //   124: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_2
    //   128: getfield a : Landroid/os/Bundle;
    //   131: ldc 'action'
    //   133: getstatic com/unionpay/sdk/g.e : Lcom/unionpay/sdk/ba;
    //   136: getfield d : Ljava/lang/String;
    //   139: invokevirtual putString : (Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_2
    //   143: aload #6
    //   145: putfield b : Ljava/lang/Object;
    //   148: aload_2
    //   149: iload #7
    //   151: putfield c : I
    //   154: invokestatic a : ()Lcom/unionpay/sdk/ah;
    //   157: aload_2
    //   158: invokevirtual post : (Ljava/lang/Object;)V
    //   161: aload_0
    //   162: monitorexit
    //   163: return
    //   164: new java/lang/StringBuilder
    //   167: astore #9
    //   169: aload #9
    //   171: invokespecial <init> : ()V
    //   174: aload #9
    //   176: aload_1
    //   177: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc '?crc='
    //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_0
    //   186: getfield b : Ljava/util/zip/CRC32;
    //   189: invokevirtual getValue : ()J
    //   192: invokestatic toHexString : (J)Ljava/lang/String;
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual toString : ()Ljava/lang/String;
    //   201: astore_1
    //   202: goto -> 73
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    //   210: astore_1
    //   211: goto -> 161
    //   214: astore_1
    //   215: goto -> 161
    //   218: goto -> 14
    // Exception table:
    //   from	to	target	type
    //   7	14	210	java/lang/Throwable
    //   7	14	205	finally
    //   14	30	210	java/lang/Throwable
    //   14	30	205	finally
    //   35	73	210	java/lang/Throwable
    //   35	73	205	finally
    //   73	154	210	java/lang/Throwable
    //   73	154	205	finally
    //   154	161	214	java/lang/Throwable
    //   154	161	205	finally
    //   164	202	210	java/lang/Throwable
    //   164	202	205	finally
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) {
    ByteArrayOutputStream byteArrayOutputStream;
    Deflater deflater = new Deflater(9);
    deflater.setInput(paramArrayOfbyte);
    try {
      ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
      this(paramArrayOfbyte.length);
      try {
        deflater.finish();
        byte[] arrayOfByte = new byte[1024];
      } finally {
        if (byteArrayOutputStream1 != null)
          try {
            byteArrayOutputStream1.close();
          } catch (Exception exception) {} 
      } 
      try {
        exception.close();
      } catch (Exception exception1) {}
      exception.close();
      byteArrayOutputStream = (ByteArrayOutputStream)exception.toByteArray();
      ay.a("Original: " + paramArrayOfbyte.length);
      return (byte[])byteArrayOutputStream;
    } finally {
      paramArrayOfbyte = null;
    } 
    if (byteArrayOutputStream != null)
      try {
        byteArrayOutputStream.close();
      } catch (Exception exception) {} 
    throw paramArrayOfbyte;
  }
  
  public final void onTDEBEventSubmitRequest(ba paramba) {
    Message message = new Message();
    message.obj = paramba;
    this.c.sendMessage(message);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\sdk\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */