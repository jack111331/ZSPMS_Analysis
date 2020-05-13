package cn.com.chinatelecom.account.api.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class f {
  private static ExecutorService a = Executors.newFixedThreadPool(3);
  
  public static void a(Runnable paramRunnable) {
    a.execute(paramRunnable);
  }
  
  public static Future b(Runnable paramRunnable) {
    return a.submit(paramRunnable);
  }
  
  public static abstract class a implements Runnable {
    private boolean a = false;
    
    public void a(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public boolean a() {
      return this.a;
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */