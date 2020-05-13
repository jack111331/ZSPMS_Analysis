package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.l;
import java.util.Timer;

public class af {
  private static volatile af dd = null;
  
  private Timer dc = null;
  
  private Context h = null;
  
  private af(Context paramContext) {
    this.h = paramContext.getApplicationContext();
    this.dc = new Timer(false);
  }
  
  public static af Y(Context paramContext) {
    // Byte code:
    //   0: getstatic com/tencent/wxop/stat/af.dd : Lcom/tencent/wxop/stat/af;
    //   3: ifnonnull -> 31
    //   6: ldc com/tencent/wxop/stat/af
    //   8: monitorenter
    //   9: getstatic com/tencent/wxop/stat/af.dd : Lcom/tencent/wxop/stat/af;
    //   12: ifnonnull -> 28
    //   15: new com/tencent/wxop/stat/af
    //   18: astore_1
    //   19: aload_1
    //   20: aload_0
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: aload_1
    //   25: putstatic com/tencent/wxop/stat/af.dd : Lcom/tencent/wxop/stat/af;
    //   28: ldc com/tencent/wxop/stat/af
    //   30: monitorexit
    //   31: getstatic com/tencent/wxop/stat/af.dd : Lcom/tencent/wxop/stat/af;
    //   34: areturn
    //   35: astore_0
    //   36: ldc com/tencent/wxop/stat/af
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Exception table:
    //   from	to	target	type
    //   9	28	35	finally
    //   28	31	35	finally
  }
  
  public final void ah() {
    if (c.j() == d.aG) {
      long l = (c.u() * 60 * 1000);
      if (c.k())
        l.av().b("setupPeriodTimer delay:" + l); 
      ag ag = new ag(this);
      if (this.dc != null) {
        if (c.k())
          l.av().b("setupPeriodTimer schedule delay:" + l); 
        this.dc.schedule(ag, l);
        return;
      } 
    } else {
      return;
    } 
    if (c.k())
      l.av().c("setupPeriodTimer schedule timer == null"); 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */