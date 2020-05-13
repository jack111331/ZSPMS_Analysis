package cn.com.chinatelecom.account.api.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class a {
  private static Executor b = Executors.newSingleThreadExecutor();
  
  public Handler a = new Handler(Looper.getMainLooper());
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */