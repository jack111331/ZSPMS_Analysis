package com.unionpay.mobile.android.pboctransaction.simapdu;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.utils.l;
import java.util.ArrayList;
import org.simalliance.openmobileapi.Channel;
import org.simalliance.openmobileapi.Reader;
import org.simalliance.openmobileapi.SEService;

public final class b implements c {
  private static b d = new b();
  
  private SEService a = null;
  
  private Channel[] b = new Channel[3];
  
  private com.unionpay.mobile.android.pboctransaction.b c;
  
  private Handler.Callback e = new c(this);
  
  private Handler f = new Handler(this.e);
  
  private String a(String paramString, int paramInt) throws a.a {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: iconst_0
    //   6: istore #5
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_1
    //   11: ifnonnull -> 21
    //   14: aload #4
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: new java/lang/StringBuilder
    //   24: astore #4
    //   26: aload #4
    //   28: ldc '====>'
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: ldc 'plugin-sim'
    //   35: aload #4
    //   37: aload_1
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual toString : ()Ljava/lang/String;
    //   44: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   47: pop
    //   48: aload_1
    //   49: getstatic java/util/Locale.CHINA : Ljava/util/Locale;
    //   52: invokevirtual toUpperCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   55: astore_1
    //   56: iload_2
    //   57: istore #6
    //   59: iload_2
    //   60: aload_0
    //   61: getfield b : [Lorg/simalliance/openmobileapi/Channel;
    //   64: arraylength
    //   65: if_icmple -> 71
    //   68: iconst_0
    //   69: istore #6
    //   71: aload_1
    //   72: ldc '00A40400'
    //   74: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   77: ifne -> 101
    //   80: aload_1
    //   81: ldc '01A40400'
    //   83: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   86: ifne -> 101
    //   89: iload #5
    //   91: istore_2
    //   92: aload_1
    //   93: ldc '02A40400'
    //   95: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   98: ifeq -> 103
    //   101: iconst_1
    //   102: istore_2
    //   103: iload_2
    //   104: ifeq -> 196
    //   107: aload_0
    //   108: iload #6
    //   110: invokespecial a : (I)V
    //   113: aload_0
    //   114: aload_1
    //   115: bipush #10
    //   117: aload_1
    //   118: bipush #8
    //   120: bipush #9
    //   122: invokevirtual substring : (II)Ljava/lang/String;
    //   125: bipush #16
    //   127: invokestatic parseInt : (Ljava/lang/String;I)I
    //   130: bipush #16
    //   132: imul
    //   133: aload_1
    //   134: bipush #9
    //   136: bipush #10
    //   138: invokevirtual substring : (II)Ljava/lang/String;
    //   141: bipush #16
    //   143: invokestatic parseInt : (Ljava/lang/String;I)I
    //   146: iadd
    //   147: iconst_2
    //   148: imul
    //   149: bipush #10
    //   151: iadd
    //   152: invokevirtual substring : (II)Ljava/lang/String;
    //   155: invokestatic a : (Ljava/lang/String;)[B
    //   158: iload #6
    //   160: invokespecial b : ([BI)Ljava/lang/String;
    //   163: astore_3
    //   164: aload_3
    //   165: astore_1
    //   166: aload_3
    //   167: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   170: ifeq -> 17
    //   173: ldc 'plugin-sim'
    //   175: ldc ' writeApdu openchannel exception!!!'
    //   177: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   180: pop
    //   181: new com/unionpay/mobile/android/pboctransaction/simapdu/a$a
    //   184: astore_1
    //   185: aload_1
    //   186: invokespecial <init> : ()V
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: aload_1
    //   197: invokestatic a : (Ljava/lang/String;)[B
    //   200: astore #4
    //   202: aload_3
    //   203: astore_1
    //   204: aload #4
    //   206: ifnull -> 225
    //   209: aload_0
    //   210: getfield b : [Lorg/simalliance/openmobileapi/Channel;
    //   213: iload #6
    //   215: aaload
    //   216: aload #4
    //   218: invokevirtual transmit : ([B)[B
    //   221: invokestatic a : ([B)Ljava/lang/String;
    //   224: astore_1
    //   225: new java/lang/StringBuilder
    //   228: astore_3
    //   229: aload_3
    //   230: ldc '<===='
    //   232: invokespecial <init> : (Ljava/lang/String;)V
    //   235: ldc 'plugin-sim'
    //   237: aload_3
    //   238: aload_1
    //   239: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual toString : ()Ljava/lang/String;
    //   245: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   248: pop
    //   249: goto -> 17
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual printStackTrace : ()V
    //   257: new com/unionpay/mobile/android/pboctransaction/simapdu/a$a
    //   260: astore_1
    //   261: aload_1
    //   262: invokespecial <init> : ()V
    //   265: aload_1
    //   266: athrow
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual printStackTrace : ()V
    //   272: aload_3
    //   273: astore_1
    //   274: goto -> 225
    // Exception table:
    //   from	to	target	type
    //   21	56	191	finally
    //   59	68	191	finally
    //   71	89	191	finally
    //   92	101	191	finally
    //   107	164	191	finally
    //   166	191	191	finally
    //   196	202	252	java/io/IOException
    //   196	202	267	java/lang/Exception
    //   196	202	191	finally
    //   209	225	252	java/io/IOException
    //   209	225	267	java/lang/Exception
    //   209	225	191	finally
    //   225	249	191	finally
    //   253	267	191	finally
    //   268	272	191	finally
  }
  
  private void a(int paramInt) {
    k.a("plugin-sim", "closeChannel(int) +++");
    if (this.b[paramInt] != null && paramInt <= this.b.length) {
      try {
        this.b[paramInt].close();
      } catch (Exception exception) {
        exception.printStackTrace();
        k.a("plugin-sim", " mChannel[channel].close() exception!!!");
      } 
      this.b[paramInt] = null;
    } 
    k.a("plugin-sim", "closeChannel(int) ---");
  }
  
  private String b(byte[] paramArrayOfbyte, int paramInt) {
    try {
      Reader[] arrayOfReader = this.a.getReaders();
      if (arrayOfReader.length > 0) {
        Channel channel = arrayOfReader[0].openSession().openLogicalChannel(paramArrayOfbyte);
        if (channel != null) {
          this.b[paramInt] = channel;
          return e.a(channel.getSelectResponse());
        } 
      } 
    } catch (Throwable throwable) {
      throwable.printStackTrace();
    } 
    return "";
  }
  
  public static b e() {
    // Byte code:
    //   0: ldc com/unionpay/mobile/android/pboctransaction/simapdu/b
    //   2: monitorenter
    //   3: getstatic com/unionpay/mobile/android/pboctransaction/simapdu/b.d : Lcom/unionpay/mobile/android/pboctransaction/simapdu/b;
    //   6: astore_0
    //   7: ldc com/unionpay/mobile/android/pboctransaction/simapdu/b
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/unionpay/mobile/android/pboctransaction/simapdu/b
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public final String a(String paramString) {
    return "";
  }
  
  public final ArrayList<c> a(d paramd) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore #4
    //   7: ldc 'plugin-sim'
    //   9: ldc ' SIMEngine.readList() +++'
    //   11: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   14: pop
    //   15: new java/util/ArrayList
    //   18: astore #5
    //   20: aload #5
    //   22: iconst_1
    //   23: invokespecial <init> : (I)V
    //   26: aload_1
    //   27: ldc 'A0000003330101'
    //   29: invokevirtual a : (Ljava/lang/String;)Ljava/lang/String;
    //   32: astore #6
    //   34: new java/lang/StringBuilder
    //   37: astore #7
    //   39: aload #7
    //   41: ldc 'full AID:'
    //   43: invokespecial <init> : (Ljava/lang/String;)V
    //   46: ldc 'plugin-sim'
    //   48: aload #7
    //   50: aload #6
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual toString : ()Ljava/lang/String;
    //   58: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aload #4
    //   64: astore #7
    //   66: aload #6
    //   68: ifnull -> 85
    //   71: aload #6
    //   73: invokevirtual length : ()I
    //   76: bipush #16
    //   78: if_icmpge -> 88
    //   81: aload #4
    //   83: astore #7
    //   85: aload #7
    //   87: areturn
    //   88: new com/unionpay/mobile/android/pboctransaction/AppIdentification
    //   91: astore #7
    //   93: aload #7
    //   95: aload #6
    //   97: aconst_null
    //   98: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload #5
    //   103: aload #7
    //   105: invokevirtual add : (Ljava/lang/Object;)Z
    //   108: pop
    //   109: aload #5
    //   111: invokevirtual size : ()I
    //   114: ifle -> 329
    //   117: new java/util/ArrayList
    //   120: astore #7
    //   122: aload #7
    //   124: invokespecial <init> : ()V
    //   127: aload #5
    //   129: invokevirtual iterator : ()Ljava/util/Iterator;
    //   132: astore_3
    //   133: aload_3
    //   134: invokeinterface hasNext : ()Z
    //   139: ifeq -> 323
    //   142: aload_3
    //   143: invokeinterface next : ()Ljava/lang/Object;
    //   148: checkcast com/unionpay/mobile/android/pboctransaction/AppIdentification
    //   151: astore #4
    //   153: ldc '06'
    //   155: aload #4
    //   157: invokevirtual b : ()Ljava/lang/String;
    //   160: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   163: ifne -> 133
    //   166: aload_1
    //   167: aload #4
    //   169: invokevirtual a : (Lcom/unionpay/mobile/android/pboctransaction/AppIdentification;)Ljava/lang/String;
    //   172: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   175: astore_2
    //   176: new java/lang/StringBuilder
    //   179: astore #5
    //   181: aload #5
    //   183: ldc ' cardNumber='
    //   185: invokespecial <init> : (Ljava/lang/String;)V
    //   188: ldc 'nfcphone'
    //   190: aload #5
    //   192: aload_2
    //   193: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual toString : ()Ljava/lang/String;
    //   199: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   202: pop
    //   203: aload_2
    //   204: ifnull -> 133
    //   207: aload_2
    //   208: invokevirtual length : ()I
    //   211: ifle -> 133
    //   214: new com/unionpay/mobile/android/model/a
    //   217: astore #5
    //   219: aload #5
    //   221: bipush #16
    //   223: aload #4
    //   225: invokevirtual a : ()Ljava/lang/String;
    //   228: ldc ''
    //   230: aload_2
    //   231: iconst_1
    //   232: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   235: aload #7
    //   237: aload #5
    //   239: invokevirtual add : (Ljava/lang/Object;)Z
    //   242: pop
    //   243: new java/lang/StringBuilder
    //   246: astore #4
    //   248: aload #4
    //   250: ldc_w ' valid Number= '
    //   253: invokespecial <init> : (Ljava/lang/String;)V
    //   256: ldc 'nfcphone'
    //   258: aload #4
    //   260: aload_2
    //   261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual toString : ()Ljava/lang/String;
    //   267: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   270: pop
    //   271: goto -> 133
    //   274: astore_2
    //   275: aload #7
    //   277: astore_1
    //   278: aload_2
    //   279: astore #7
    //   281: ldc 'plugin-sim'
    //   283: new java/lang/StringBuilder
    //   286: dup
    //   287: ldc_w ' SimEngine Exception = '
    //   290: invokespecial <init> : (Ljava/lang/String;)V
    //   293: aload #7
    //   295: invokevirtual getMessage : ()Ljava/lang/String;
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual toString : ()Ljava/lang/String;
    //   304: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   307: pop
    //   308: ldc 'plugin-sim'
    //   310: ldc_w ' SIMEngine.readList() ---'
    //   313: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   316: pop
    //   317: aload_1
    //   318: astore #7
    //   320: goto -> 85
    //   323: aload #7
    //   325: astore_1
    //   326: goto -> 308
    //   329: ldc 'plugin-sim'
    //   331: ldc_w ' SIMEngine --- there has no PBOC aids!!!'
    //   334: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   337: pop
    //   338: aload_3
    //   339: astore_1
    //   340: goto -> 308
    //   343: astore #7
    //   345: aload_2
    //   346: astore_1
    //   347: goto -> 281
    // Exception table:
    //   from	to	target	type
    //   15	62	343	java/lang/Throwable
    //   71	81	343	java/lang/Throwable
    //   88	127	343	java/lang/Throwable
    //   127	133	274	java/lang/Throwable
    //   133	203	274	java/lang/Throwable
    //   207	271	274	java/lang/Throwable
    //   329	338	343	java/lang/Throwable
  }
  
  public final void a() {
    k.c("plugin-sim", "SIMEngine.destroy() +++ ");
    k.c("plugin-sim", " mSEService = " + this.a);
    d();
    if (this.a != null && this.a.isConnected()) {
      k.a("TAG", " mSEService.isConnected() = " + this.a.isConnected());
      k.c("plugin-sim", " mSEService.shutdown() ");
      this.a.shutdown();
    } 
    k.c("plugin-sim", "SIMEngine.destroy() --- ");
  }
  
  public final void a(com.unionpay.mobile.android.pboctransaction.b paramb, Context paramContext) {
    this.c = paramb;
    try {
      if (l.a() != null && l.a().isConnected()) {
        this.a = l.a();
        this.f.sendEmptyMessage(1);
        return;
      } 
      this.f.sendEmptyMessage(2);
    } catch (Throwable throwable) {
      throwable.printStackTrace();
      Log.e("plugin-sim", " service ERROR!!!");
      this.f.sendEmptyMessage(2);
    } 
  }
  
  public final byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    k.c("plugin-sim", " SIMEngine.sendApdu() +++");
    a.a a2 = null;
    try {
      paramArrayOfbyte = e.a(a(e.a(paramArrayOfbyte), paramInt));
    } catch (a a1) {
      a1.printStackTrace();
      k.c("plugin-sim", " " + a1.getMessage());
      a1 = a2;
    } 
    k.c("plugin-sim", " SIMEngine.sendApdu() ---");
    return (byte[])a1;
  }
  
  public final void b() {}
  
  public final void c() {
    d();
  }
  
  public final void d() {
    k.a("plugin-sim", "closeChannels() +++");
    for (byte b1 = 0; b1 < this.b.length; b1++)
      a(b1); 
    k.a("plugin-sim", "closeChannels() ---");
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\simapdu\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */