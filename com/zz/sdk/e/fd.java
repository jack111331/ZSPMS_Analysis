package com.zz.sdk.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zz.sdk.b.a.al;
import com.zz.sdk.b.o;
import com.zz.sdk.i.t;
import java.util.HashMap;

class fd extends BroadcastReceiver {
  private static final String a = "action.send.sms";
  
  private static final String b = "action.send.check";
  
  private static fd c = null;
  
  private HashMap d = new HashMap<Object, Object>();
  
  private ff e;
  
  private o a(String paramString) {
    paramString = b(paramString);
    return (paramString != null) ? (o)this.d.remove(paramString) : null;
  }
  
  protected static fd a() {
    // Byte code:
    //   0: ldc com/zz/sdk/e/fd
    //   2: monitorenter
    //   3: getstatic com/zz/sdk/e/fd.c : Lcom/zz/sdk/e/fd;
    //   6: ifnonnull -> 21
    //   9: new com/zz/sdk/e/fd
    //   12: astore_0
    //   13: aload_0
    //   14: invokespecial <init> : ()V
    //   17: aload_0
    //   18: putstatic com/zz/sdk/e/fd.c : Lcom/zz/sdk/e/fd;
    //   21: getstatic com/zz/sdk/e/fd.c : Lcom/zz/sdk/e/fd;
    //   24: astore_0
    //   25: ldc com/zz/sdk/e/fd
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: astore_0
    //   31: ldc com/zz/sdk/e/fd
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Exception table:
    //   from	to	target	type
    //   3	21	30	finally
    //   21	25	30	finally
  }
  
  private static al b(t paramt, o paramo) {
    return paramt.a(1001, paramo);
  }
  
  private String b(String paramString) {
    return (paramString != null && paramString.startsWith("action.send.sms")) ? paramString.substring("action.send.sms".length() + 1) : null;
  }
  
  protected String a(String paramString, o paramo) {
    String str = "action.send.sms." + paramString;
    this.d.put(paramString, paramo);
    return str;
  }
  
  protected void a(ff paramff) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield e : Lcom/zz/sdk/e/ff;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  protected void b(ff paramff) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Lcom/zz/sdk/e/ff;
    //   6: aload_1
    //   7: if_acmpne -> 18
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield e : Lcom/zz/sdk/e/ff;
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_1
    //   19: ifnonnull -> 15
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield e : Lcom/zz/sdk/e/ff;
    //   27: goto -> 15
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	30	finally
    //   22	27	30	finally
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: invokevirtual getAction : ()Ljava/lang/String;
    //   7: invokespecial b : (Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull -> 41
    //   15: aload_3
    //   16: invokevirtual length : ()I
    //   19: ifle -> 41
    //   22: aload_0
    //   23: getfield d : Ljava/util/HashMap;
    //   26: aload_3
    //   27: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast com/zz/sdk/b/o
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull -> 46
    //   38: aload_0
    //   39: monitorexit
    //   40: return
    //   41: aconst_null
    //   42: astore_2
    //   43: goto -> 34
    //   46: aload_0
    //   47: invokevirtual getResultCode : ()I
    //   50: istore #4
    //   52: new java/lang/StringBuilder
    //   55: astore #5
    //   57: aload #5
    //   59: invokespecial <init> : ()V
    //   62: aload #5
    //   64: ldc 'receiver action -> '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_3
    //   70: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc ' code -> '
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload #4
    //   80: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   83: invokevirtual toString : ()Ljava/lang/String;
    //   86: invokestatic a : (Ljava/lang/Object;)V
    //   89: aload_0
    //   90: getfield e : Lcom/zz/sdk/e/ff;
    //   93: ifnull -> 112
    //   96: aload_0
    //   97: getfield e : Lcom/zz/sdk/e/ff;
    //   100: aload_3
    //   101: iload #4
    //   103: aload_2
    //   104: invokeinterface a : (Ljava/lang/String;ILcom/zz/sdk/b/o;)Z
    //   109: ifne -> 38
    //   112: iload #4
    //   114: iconst_m1
    //   115: if_icmpne -> 175
    //   118: new com/zz/sdk/e/fe
    //   121: astore #5
    //   123: aload #5
    //   125: aload_0
    //   126: ldc 'send-sms-feed-onBack'
    //   128: aload_2
    //   129: aload_1
    //   130: invokespecial <init> : (Lcom/zz/sdk/e/fd;Ljava/lang/String;Lcom/zz/sdk/b/o;Landroid/content/Context;)V
    //   133: aload #5
    //   135: invokevirtual start : ()V
    //   138: new java/lang/StringBuilder
    //   141: astore_2
    //   142: aload_2
    //   143: invokespecial <init> : ()V
    //   146: aload_1
    //   147: aload_2
    //   148: ldc '支付成功！详情：\\n'
    //   150: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_3
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual toString : ()Ljava/lang/String;
    //   160: iconst_1
    //   161: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   164: invokevirtual show : ()V
    //   167: goto -> 38
    //   170: astore_1
    //   171: aload_0
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: ldc 'D: sms-pay failed!'
    //   177: invokestatic a : (Ljava/lang/Object;)V
    //   180: new java/lang/StringBuilder
    //   183: astore_2
    //   184: aload_2
    //   185: invokespecial <init> : ()V
    //   188: aload_1
    //   189: aload_2
    //   190: ldc '支付失败！详情：\\n'
    //   192: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_3
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual toString : ()Ljava/lang/String;
    //   202: iconst_1
    //   203: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   206: invokevirtual show : ()V
    //   209: goto -> 38
    // Exception table:
    //   from	to	target	type
    //   2	11	170	finally
    //   15	34	170	finally
    //   46	112	170	finally
    //   118	167	170	finally
    //   175	209	170	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\zz\sdk\e\fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */