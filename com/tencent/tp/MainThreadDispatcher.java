package com.tencent.tp;

import android.os.Handler;
import android.os.Looper;

public class MainThreadDispatcher {
  public static final String TAG = "TssSDK";
  
  private static native void handleNativeCallBack(NativeRunnable paramNativeRunnable);
  
  private static native void handleNativeFuncCallback(long paramLong1, long paramLong2);
  
  private static Runnable parseNativeRunnable(NativeRunnable paramNativeRunnable) {
    return new a(paramNativeRunnable);
  }
  
  public static void post(NativeRunnable paramNativeRunnable) {
    (new Handler(Looper.getMainLooper())).post(parseNativeRunnable(paramNativeRunnable));
  }
  
  public static void postAtTime(NativeRunnable paramNativeRunnable, long paramLong) {
    (new Handler(Looper.getMainLooper())).postAtTime(parseNativeRunnable(paramNativeRunnable), paramLong);
  }
  
  public static void postDelayed(NativeRunnable paramNativeRunnable, long paramLong) {
    (new Handler(Looper.getMainLooper())).postDelayed(parseNativeRunnable(paramNativeRunnable), paramLong);
  }
  
  public static class NativeRunnable {
    public long callbackFuncPtr = 0L;
    
    public String clazz_name = null;
    
    public long dataPtr = 0L;
    
    public byte[] method_cmd_data = null;
    
    public String method_name = null;
    
    public String method_signature = null;
    
    public Object obj_receiver = null;
  }
  
  static class a implements Runnable {
    MainThreadDispatcher.NativeRunnable a;
    
    public a(MainThreadDispatcher.NativeRunnable param1NativeRunnable) {
      this.a = param1NativeRunnable;
    }
    
    public void run() {
      if (this.a.callbackFuncPtr != 0L)
        MainThreadDispatcher.handleNativeFuncCallback(this.a.callbackFuncPtr, this.a.dataPtr); 
      if (this.a.clazz_name != null && this.a.method_name != null && this.a.method_signature != null)
        MainThreadDispatcher.handleNativeCallBack(this.a); 
    }
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\MainThreadDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */