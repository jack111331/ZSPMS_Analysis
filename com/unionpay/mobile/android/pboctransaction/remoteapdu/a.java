package com.unionpay.mobile.android.pboctransaction.remoteapdu;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import com.unionpay.mobile.android.model.c;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.tsm.connect.IInitCallback;
import com.unionpay.mobile.tsm.connect.IRemoteApdu;
import java.util.ArrayList;

public final class a implements c {
  b a;
  
  private IRemoteApdu b = null;
  
  private boolean c = false;
  
  private Context d = null;
  
  private Handler e = null;
  
  private boolean f = false;
  
  private final Handler.Callback g = new b(this);
  
  private final ServiceConnection h = new c(this);
  
  private final IInitCallback.Stub i = new d(this);
  
  public final String a(String paramString) {
    return "";
  }
  
  public final ArrayList<c> a(d paramd) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 'plugin-tsm'
    //   4: ldc 'RemoteApduEngine.readList() +++'
    //   6: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: aload_0
    //   11: getfield c : Z
    //   14: ifeq -> 241
    //   17: ldc 'D15600010100016111000000B0004101'
    //   19: astore_3
    //   20: new java/lang/StringBuilder
    //   23: astore #4
    //   25: aload #4
    //   27: ldc 'sid='
    //   29: invokespecial <init> : (Ljava/lang/String;)V
    //   32: ldc 'plugin-tsm'
    //   34: aload #4
    //   36: aload_3
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual toString : ()Ljava/lang/String;
    //   43: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   46: pop
    //   47: aload_0
    //   48: getfield b : Lcom/unionpay/mobile/tsm/connect/IRemoteApdu;
    //   51: astore #5
    //   53: new java/lang/StringBuilder
    //   56: astore #4
    //   58: aload #4
    //   60: ldc '00a4040010'
    //   62: invokespecial <init> : (Ljava/lang/String;)V
    //   65: aload #5
    //   67: aload #4
    //   69: aload_3
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual toString : ()Ljava/lang/String;
    //   76: iconst_0
    //   77: invokeinterface writeApdu : (Ljava/lang/String;I)Ljava/lang/String;
    //   82: astore #4
    //   84: aload #4
    //   86: astore_3
    //   87: aload #4
    //   89: ifnull -> 118
    //   92: aload #4
    //   94: astore_3
    //   95: aload #4
    //   97: ldc '9000'
    //   99: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   102: ifeq -> 118
    //   105: aload_0
    //   106: getfield b : Lcom/unionpay/mobile/tsm/connect/IRemoteApdu;
    //   109: ldc '80CA2F0000'
    //   111: iconst_0
    //   112: invokeinterface writeApdu : (Ljava/lang/String;I)Ljava/lang/String;
    //   117: astore_3
    //   118: aload_3
    //   119: invokestatic b : (Ljava/lang/String;)Ljava/util/ArrayList;
    //   122: astore_3
    //   123: aload_2
    //   124: astore #4
    //   126: aload_3
    //   127: ifnull -> 280
    //   130: aload_2
    //   131: astore #4
    //   133: aload_3
    //   134: invokevirtual size : ()I
    //   137: ifle -> 280
    //   140: new java/util/ArrayList
    //   143: dup
    //   144: invokespecial <init> : ()V
    //   147: astore #4
    //   149: aload_3
    //   150: invokevirtual iterator : ()Ljava/util/Iterator;
    //   153: astore_2
    //   154: aload_2
    //   155: invokeinterface hasNext : ()Z
    //   160: ifeq -> 280
    //   163: aload_2
    //   164: invokeinterface next : ()Ljava/lang/Object;
    //   169: checkcast com/unionpay/mobile/android/pboctransaction/AppIdentification
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual c : ()Z
    //   177: ifeq -> 154
    //   180: ldc '06'
    //   182: aload_3
    //   183: invokevirtual b : ()Ljava/lang/String;
    //   186: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   189: ifne -> 154
    //   192: aload_1
    //   193: aload_3
    //   194: invokevirtual a : (Lcom/unionpay/mobile/android/pboctransaction/AppIdentification;)Ljava/lang/String;
    //   197: invokestatic c : (Ljava/lang/String;)Ljava/lang/String;
    //   200: astore #5
    //   202: aload #5
    //   204: ifnull -> 154
    //   207: aload #5
    //   209: invokevirtual length : ()I
    //   212: ifle -> 154
    //   215: aload #4
    //   217: new com/unionpay/mobile/android/model/a
    //   220: dup
    //   221: iconst_4
    //   222: aload_3
    //   223: invokevirtual a : ()Ljava/lang/String;
    //   226: ldc ''
    //   228: aload #5
    //   230: iconst_1
    //   231: invokespecial <init> : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   234: invokevirtual add : (Ljava/lang/Object;)Z
    //   237: pop
    //   238: goto -> 154
    //   241: ldc 'D15600010100016111000000B0004001'
    //   243: astore_3
    //   244: goto -> 20
    //   247: astore_3
    //   248: aload_3
    //   249: invokevirtual printStackTrace : ()V
    //   252: ldc 'plugin-tsm'
    //   254: new java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial <init> : ()V
    //   261: aload_3
    //   262: invokevirtual getMessage : ()Ljava/lang/String;
    //   265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual toString : ()Ljava/lang/String;
    //   271: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   274: pop
    //   275: aconst_null
    //   276: astore_3
    //   277: goto -> 123
    //   280: ldc 'plugin-tsm'
    //   282: ldc 'RemoteApduEngine.readList() ---'
    //   284: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)I
    //   287: pop
    //   288: aload #4
    //   290: areturn
    // Exception table:
    //   from	to	target	type
    //   10	17	247	java/lang/Exception
    //   20	84	247	java/lang/Exception
    //   95	118	247	java/lang/Exception
    //   118	123	247	java/lang/Exception
  }
  
  public final void a() {
    d();
    if (this.d != null) {
      Context context = this.d;
      k.a("plugin-tsm", "unbindTSMService() ++");
      if (this.f) {
        try {
          context.unbindService(this.h);
        } catch (Exception exception) {}
        this.f = false;
      } 
    } 
  }
  
  public final void a(b paramb, Context paramContext) {
    this.a = paramb;
    this.d = paramContext;
    this.e = new Handler(this.g);
    try {
      Intent intent = new Intent();
      this("com.unionpay.mobile.tsm.PBOCService");
      intent.setPackage("com.unionpay.mobile.tsm");
      paramContext.startService(intent);
      if (this.e != null)
        this.e.sendMessageDelayed(Message.obtain(this.e, 3000), 8000L); 
      if (!paramContext.bindService(intent, this.h, 1) && this.a != null) {
        k.a("plugin-tsm", "startTSMService.initFailed()");
        this.a.b();
      } 
    } catch (Exception exception) {}
  }
  
  public final void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public final byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    Exception exception2 = null;
    byte[] arrayOfByte = null;
    if (paramArrayOfbyte == null)
      return arrayOfByte; 
    String str = e.a(paramArrayOfbyte);
    k.a("plugin-tsm", "[---->]" + str);
    try {
      str = this.b.writeApdu(str, paramInt);
      k.a("plugin-tsm", "[<----]" + str);
      byte[] arrayOfByte1 = e.a(str);
    } catch (Exception exception1) {
      exception1.printStackTrace();
      exception1 = exception2;
    } 
    return (byte[])exception1;
  }
  
  public final void b() {}
  
  public final void c() {
    d();
  }
  
  public final void d() {
    if (this.b != null)
      try {
        this.b.closeChannel(0);
        this.b.closeChannel(1);
        this.b.closeChannel(2);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pboctransaction\remoteapdu\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */