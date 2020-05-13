package okhttp3.internal;

public abstract class NamedRunnable implements Runnable {
  protected final String name;
  
  public NamedRunnable(String paramString, Object... paramVarArgs) {
    this.name = Util.format(paramString, paramVarArgs);
  }
  
  protected abstract void execute();
  
  public final void run() {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.name);
    try {
      execute();
      return;
    } finally {
      Thread.currentThread().setName(str);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\okhttp3\internal\NamedRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */