package android.support.v4.util;

public final class Pools {
  public static interface Pool<T> {
    T acquire();
    
    boolean release(T param1T);
  }
  
  public static class SimplePool<T> implements Pool<T> {
    private final Object[] mPool;
    
    private int mPoolSize;
    
    public SimplePool(int param1Int) {
      if (param1Int <= 0)
        throw new IllegalArgumentException("The max pool size must be > 0"); 
      this.mPool = new Object[param1Int];
    }
    
    private boolean isInPool(T param1T) {
      boolean bool = false;
      for (byte b = 0;; b++) {
        boolean bool1 = bool;
        if (b < this.mPoolSize) {
          if (this.mPool[b] == param1T)
            return true; 
        } else {
          return bool1;
        } 
      } 
    }
    
    public T acquire() {
      if (this.mPoolSize > 0) {
        int i = this.mPoolSize - 1;
        Object object = this.mPool[i];
        this.mPool[i] = null;
        this.mPoolSize--;
        return (T)object;
      } 
      return null;
    }
    
    public boolean release(T param1T) {
      if (isInPool(param1T))
        throw new IllegalStateException("Already in the pool!"); 
      if (this.mPoolSize < this.mPool.length) {
        this.mPool[this.mPoolSize] = param1T;
        this.mPoolSize++;
        return true;
      } 
      return false;
    }
  }
  
  public static class SynchronizedPool<T> extends SimplePool<T> {
    private final Object mLock = new Object();
    
    public SynchronizedPool(int param1Int) {
      super(param1Int);
    }
    
    public T acquire() {
      synchronized (this.mLock) {
        return super.acquire();
      } 
    }
    
    public boolean release(T param1T) {
      synchronized (this.mLock) {
        return super.release(param1T);
      } 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\android\support\v\\util\Pools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */