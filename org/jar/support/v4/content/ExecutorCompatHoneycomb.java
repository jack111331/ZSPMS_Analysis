package org.jar.support.v4.content;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

class ExecutorCompatHoneycomb {
  public static Executor getParallelExecutor() {
    return AsyncTask.THREAD_POOL_EXECUTOR;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\support\v4\content\ExecutorCompatHoneycomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */