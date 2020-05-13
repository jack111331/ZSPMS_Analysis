package com.herosdk.d;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.herosdk.bean.RoleInfo;
import java.util.Timer;

public class ap {
  public static final int a = 500;
  
  private static final String b = "frameLib.rous";
  
  private static volatile ap c = null;
  
  private static final int i = 300000;
  
  private static final int j = 60000;
  
  private Timer d = null;
  
  private Timer e = null;
  
  private Boolean f = Boolean.valueOf(false);
  
  private Activity g = null;
  
  private RoleInfo h = null;
  
  private boolean k = false;
  
  private boolean l = true;
  
  private Handler m = new Handler();
  
  private Runnable n;
  
  public static ap a() {
    // Byte code:
    //   0: getstatic com/herosdk/d/ap.c : Lcom/herosdk/d/ap;
    //   3: ifnonnull -> 30
    //   6: ldc com/herosdk/d/ap
    //   8: monitorenter
    //   9: getstatic com/herosdk/d/ap.c : Lcom/herosdk/d/ap;
    //   12: ifnonnull -> 27
    //   15: new com/herosdk/d/ap
    //   18: astore_0
    //   19: aload_0
    //   20: invokespecial <init> : ()V
    //   23: aload_0
    //   24: putstatic com/herosdk/d/ap.c : Lcom/herosdk/d/ap;
    //   27: ldc com/herosdk/d/ap
    //   29: monitorexit
    //   30: getstatic com/herosdk/d/ap.c : Lcom/herosdk/d/ap;
    //   33: areturn
    //   34: astore_0
    //   35: ldc com/herosdk/d/ap
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	34	finally
    //   27	30	34	finally
    //   35	38	34	finally
  }
  
  public void a(Activity paramActivity, RoleInfo paramRoleInfo) {
    try {
      if (this.d == null) {
        Log.d("frameLib.rous", "rpt_ol_msg...if");
        Timer timer = new Timer();
        this();
        this.d = timer;
        timer = this.d;
        as as = new as();
        this(this, paramActivity, paramRoleInfo);
        timer.schedule(as, 0L, 300000L);
        return;
      } 
      Log.d("frameLib.rous", "rpt_ol_msg...else");
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(Application paramApplication) {
    try {
      if (Build.VERSION.SDK_INT >= 14) {
        aq aq = new aq();
        this(this);
        paramApplication.registerActivityLifecycleCallbacks(aq);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void b() {
    try {
      if (this.d != null) {
        Log.d("frameLib.rous", "srt");
        this.d.cancel();
        this.d = null;
        this.f = Boolean.valueOf(true);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void c() {
    try {
      if (this.d != null && this.e == null) {
        Log.d("frameLib.rous", "stmt");
        Timer timer1 = new Timer();
        this();
        this.e = timer1;
        Timer timer2 = this.e;
        at at = new at();
        this(this);
        timer2.schedule(at, 60000L);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void d() {
    try {
      if (this.e != null) {
        Log.d("frameLib.rous", "smt");
        this.e.cancel();
        this.e = null;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */