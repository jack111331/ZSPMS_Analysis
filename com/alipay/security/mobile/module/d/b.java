package com.alipay.security.mobile.module.d;

import com.alipay.security.mobile.module.http.v2.a;
import java.io.File;
import org.json.JSONObject;

public final class b {
  private File a = null;
  
  private a b = null;
  
  public b(String paramString, a parama) {
    this.a = new File(paramString);
    this.b = parama;
  }
  
  private static String a(String paramString) {
    String str;
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("type", "id");
      jSONObject.put("error", paramString);
      paramString = jSONObject.toString();
    } catch (Exception exception) {
      str = "";
    } 
    return str;
  }
  
  private void b() {
    (new Thread(new c(this))).start();
  }
  
  final void a() {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield a : Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield a : Ljava/io/File;
    //   20: invokevirtual exists : ()Z
    //   23: ifeq -> 13
    //   26: aload_0
    //   27: getfield a : Ljava/io/File;
    //   30: invokevirtual isDirectory : ()Z
    //   33: ifeq -> 13
    //   36: aload_0
    //   37: getfield a : Ljava/io/File;
    //   40: invokevirtual list : ()[Ljava/lang/String;
    //   43: arraylength
    //   44: ifeq -> 13
    //   47: new java/util/ArrayList
    //   50: astore_3
    //   51: aload_3
    //   52: invokespecial <init> : ()V
    //   55: aload_0
    //   56: getfield a : Ljava/io/File;
    //   59: invokevirtual list : ()[Ljava/lang/String;
    //   62: astore_2
    //   63: aload_2
    //   64: arraylength
    //   65: istore #4
    //   67: iconst_0
    //   68: istore #5
    //   70: iload #5
    //   72: iload #4
    //   74: if_icmpge -> 94
    //   77: aload_3
    //   78: aload_2
    //   79: iload #5
    //   81: aaload
    //   82: invokeinterface add : (Ljava/lang/Object;)Z
    //   87: pop
    //   88: iinc #5, 1
    //   91: goto -> 70
    //   94: aload_3
    //   95: invokestatic sort : (Ljava/util/List;)V
    //   98: aload_3
    //   99: aload_3
    //   100: invokeinterface size : ()I
    //   105: iconst_1
    //   106: isub
    //   107: invokeinterface get : (I)Ljava/lang/Object;
    //   112: checkcast java/lang/String
    //   115: astore_2
    //   116: aload_3
    //   117: invokeinterface size : ()I
    //   122: istore #5
    //   124: invokestatic getInstance : ()Ljava/util/Calendar;
    //   127: invokevirtual getTime : ()Ljava/util/Date;
    //   130: astore #6
    //   132: new java/text/SimpleDateFormat
    //   135: astore #7
    //   137: aload #7
    //   139: ldc 'yyyyMMdd'
    //   141: invokespecial <init> : (Ljava/lang/String;)V
    //   144: aload #7
    //   146: aload #6
    //   148: invokevirtual format : (Ljava/util/Date;)Ljava/lang/String;
    //   151: astore #7
    //   153: new java/lang/StringBuilder
    //   156: astore #6
    //   158: aload #6
    //   160: invokespecial <init> : ()V
    //   163: aload_2
    //   164: aload #6
    //   166: aload #7
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc '.log'
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual toString : ()Ljava/lang/String;
    //   179: invokevirtual equals : (Ljava/lang/Object;)Z
    //   182: ifeq -> 299
    //   185: aload_3
    //   186: invokeinterface size : ()I
    //   191: iconst_2
    //   192: if_icmplt -> 13
    //   195: aload_3
    //   196: aload_3
    //   197: invokeinterface size : ()I
    //   202: iconst_2
    //   203: isub
    //   204: invokeinterface get : (I)Ljava/lang/Object;
    //   209: checkcast java/lang/String
    //   212: astore_2
    //   213: iinc #5, -1
    //   216: aload_0
    //   217: getfield a : Ljava/io/File;
    //   220: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   223: aload_2
    //   224: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   227: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   230: astore_2
    //   231: aload_0
    //   232: getfield b : Lcom/alipay/security/mobile/module/http/v2/a;
    //   235: aload_2
    //   236: invokeinterface a : (Ljava/lang/String;)Z
    //   241: ifne -> 296
    //   244: iinc #5, -1
    //   247: iload_1
    //   248: iload #5
    //   250: if_icmpge -> 13
    //   253: aload_3
    //   254: iload_1
    //   255: invokeinterface get : (I)Ljava/lang/Object;
    //   260: checkcast java/lang/String
    //   263: astore_2
    //   264: new java/io/File
    //   267: astore #6
    //   269: aload #6
    //   271: aload_0
    //   272: getfield a : Ljava/io/File;
    //   275: aload_2
    //   276: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   279: aload #6
    //   281: invokevirtual delete : ()Z
    //   284: pop
    //   285: iinc #1, 1
    //   288: goto -> 247
    //   291: astore_2
    //   292: aload_0
    //   293: monitorexit
    //   294: aload_2
    //   295: athrow
    //   296: goto -> 247
    //   299: goto -> 216
    // Exception table:
    //   from	to	target	type
    //   4	9	291	finally
    //   16	67	291	finally
    //   77	88	291	finally
    //   94	213	291	finally
    //   216	244	291	finally
    //   253	285	291	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alipay\security\mobile\module\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */