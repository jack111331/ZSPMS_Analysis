package com.herosdk.listener;

import android.content.Context;
import android.util.Log;
import com.herosdk.b.a;
import com.herosdk.bean.OrderInfo;
import com.herosdk.d.bb;
import com.herosdk.d.x;

public class y implements IPayListener {
  private static String a = "frameLib.PL";
  
  private static final int d = 2;
  
  private final int b = 10;
  
  private final int c = 3000;
  
  private IPayListener e = null;
  
  private int f = 0;
  
  public y(IPayListener paramIPayListener) {
    this.e = paramIPayListener;
  }
  
  private OrderInfo a(String paramString1, String paramString2) {
    // Byte code:
    //   0: getstatic com/herosdk/d/j.a : Ljava/util/List;
    //   3: ifnull -> 98
    //   6: getstatic com/herosdk/d/j.a : Ljava/util/List;
    //   9: invokeinterface size : ()I
    //   14: ifle -> 98
    //   17: getstatic com/herosdk/d/j.a : Ljava/util/List;
    //   20: invokeinterface iterator : ()Ljava/util/Iterator;
    //   25: astore_3
    //   26: aload_3
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 98
    //   35: aload_3
    //   36: invokeinterface next : ()Ljava/lang/Object;
    //   41: checkcast com/herosdk/bean/OrderInfo
    //   44: astore #4
    //   46: aload_1
    //   47: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   50: ifne -> 75
    //   53: aload #4
    //   55: ifnull -> 26
    //   58: aload #4
    //   60: invokevirtual getSdkOrderId : ()Ljava/lang/String;
    //   63: aload_1
    //   64: invokevirtual equals : (Ljava/lang/Object;)Z
    //   67: ifeq -> 26
    //   70: aload #4
    //   72: astore_1
    //   73: aload_1
    //   74: areturn
    //   75: aload #4
    //   77: ifnull -> 26
    //   80: aload #4
    //   82: invokevirtual getCpOrderId : ()Ljava/lang/String;
    //   85: aload_2
    //   86: invokevirtual equals : (Ljava/lang/Object;)Z
    //   89: ifeq -> 26
    //   92: aload #4
    //   94: astore_1
    //   95: goto -> 73
    //   98: aconst_null
    //   99: astore_1
    //   100: goto -> 73
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    Log.d(a, "cspr");
    a.a().a((Context)x.a().x(), paramString2, paramString3, new ab(this, paramString1));
  }
  
  public void onCancel(String paramString) {
    Log.d(a, "onCancel");
    bb.a(new ae(this, paramString));
  }
  
  public void onFailed(String paramString1, String paramString2) {
    Log.d(a, "onFailed, msg:" + paramString2);
    bb.a(new ad(this, paramString1, paramString2));
  }
  
  public void onSuccess(String paramString1, String paramString2, String paramString3) {
    Log.d(a, "onSuccess");
    bb.a(new z(this, paramString1, paramString2, paramString3));
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */