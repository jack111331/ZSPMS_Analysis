package android.support.v4.content;

import android.os.Build;
import java.util.concurrent.Executor;

public final class ParallelExecutorCompat {
  public static Executor getParallelExecutor() {
    return (Build.VERSION.SDK_INT >= 11) ? ExecutorCompatHoneycomb.getParallelExecutor() : ModernAsyncTask.THREAD_POOL_EXECUTOR;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v4\content\ParallelExecutorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */