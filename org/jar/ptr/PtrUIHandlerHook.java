package org.jar.ptr;

public abstract class PtrUIHandlerHook implements Runnable {
  private static final byte STATUS_IN_HOOK = 1;
  
  private static final byte STATUS_PREPARE = 0;
  
  private static final byte STATUS_RESUMED = 2;
  
  private Runnable mResumeAction;
  
  private byte mStatus = (byte)0;
  
  public void reset() {
    this.mStatus = (byte)0;
  }
  
  public void resume() {
    if (this.mResumeAction != null)
      this.mResumeAction.run(); 
    this.mStatus = (byte)2;
  }
  
  public void setResumeAction(Runnable paramRunnable) {
    this.mResumeAction = paramRunnable;
  }
  
  public void takeOver() {
    takeOver(null);
  }
  
  public void takeOver(Runnable paramRunnable) {
    if (paramRunnable != null)
      this.mResumeAction = paramRunnable; 
    switch (this.mStatus) {
      case 2:
        resume();
        break;
      case 0:
        this.mStatus = (byte)1;
        run();
        break;
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\ptr\PtrUIHandlerHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */