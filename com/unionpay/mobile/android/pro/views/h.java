package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.mobile.android.utils.l;
import org.simalliance.openmobileapi.Reader;

public class h extends l {
  public h(Context paramContext) {
    super(paramContext);
  }
  
  public final void C() {
    StringBuffer stringBuffer = new StringBuffer("000");
    l l1 = null;
    b b = this.a;
    if (b.ba)
      l1 = new l(); 
    if (l1 != null && l.a() != null && l.a().isConnected())
      for (Reader reader : l.a().getReaders()) {
        if (reader != null) {
          if (reader.getName().toLowerCase().startsWith("sim"))
            stringBuffer.setCharAt(0, '1'); 
          if (reader.getName().toLowerCase().startsWith("ese"))
            stringBuffer.setCharAt(1, '1'); 
          if (reader.getName().toLowerCase().startsWith("sd"))
            stringBuffer.setCharAt(2, '1'); 
        } 
      }  
    d(stringBuffer.toString());
  }
  
  public b D() {
    return null;
  }
  
  protected final void u() {
    try {
      Class.forName("org.simalliance.openmobileapi.SEService");
      b b = this.a;
      b.ba = true;
    } catch (Exception exception) {
      exception.printStackTrace();
      b b = this.a;
      b.ba = false;
      v();
    } 
  }
  
  public final void z() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 'uppay-pro'
    //   4: ldc 'checkAndGetSDCardsList +++'
    //   6: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   9: pop
    //   10: ldc '00'
    //   12: aload_0
    //   13: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   16: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   19: getfield c : Ljava/lang/String;
    //   22: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   25: ifne -> 46
    //   28: ldc '95'
    //   30: aload_0
    //   31: getfield a : Lcom/unionpay/mobile/android/model/b;
    //   34: getfield I : Lcom/unionpay/mobile/android/plugin/c;
    //   37: getfield c : Ljava/lang/String;
    //   40: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   43: ifeq -> 86
    //   46: iconst_1
    //   47: istore_1
    //   48: aload_0
    //   49: invokevirtual D : ()Lcom/unionpay/mobile/android/pro/pboc/engine/b;
    //   52: astore_2
    //   53: new com/unionpay/mobile/android/pro/views/i
    //   56: astore_3
    //   57: aload_3
    //   58: aload_0
    //   59: invokespecial <init> : (Lcom/unionpay/mobile/android/pro/views/h;)V
    //   62: aload_2
    //   63: ifnull -> 91
    //   66: aload_0
    //   67: invokevirtual D : ()Lcom/unionpay/mobile/android/pro/pboc/engine/b;
    //   70: aload_3
    //   71: iload_1
    //   72: invokevirtual a : (Lcom/unionpay/mobile/android/pro/pboc/engine/a;Z)V
    //   75: ldc 'uppay-pro'
    //   77: ldc 'checkAndGetSDCardsList ---'
    //   79: invokestatic c : (Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: iconst_0
    //   87: istore_1
    //   88: goto -> 48
    //   91: aload_3
    //   92: aconst_null
    //   93: invokeinterface a : (Ljava/util/ArrayList;)V
    //   98: goto -> 75
    //   101: astore_2
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_2
    //   105: athrow
    // Exception table:
    //   from	to	target	type
    //   2	46	101	finally
    //   48	62	101	finally
    //   66	75	101	finally
    //   75	85	101	finally
    //   91	98	101	finally
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\co\\unionpay\mobile\android\pro\views\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */