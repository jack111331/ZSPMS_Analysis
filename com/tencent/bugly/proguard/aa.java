package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;

public final class aa implements Runnable {
  private final Handler a;
  
  private final String b;
  
  private long c;
  
  private final long d;
  
  private boolean e;
  
  private long f;
  
  aa(Handler paramHandler, String paramString, long paramLong) {
    this.a = paramHandler;
    this.b = paramString;
    this.c = paramLong;
    this.d = paramLong;
    this.e = true;
  }
  
  public final void a() {
    if (!this.e)
      return; 
    this.e = false;
    this.f = SystemClock.uptimeMillis();
    this.a.postAtFrontOfQueue(this);
  }
  
  public final void a(long paramLong) {
    this.c = Long.MAX_VALUE;
  }
  
  public final boolean b() {
    return (!this.e && SystemClock.uptimeMillis() > this.f + this.c);
  }
  
  public final int c() {
    return this.e ? 0 : ((SystemClock.uptimeMillis() - this.f < this.c) ? 1 : 3);
  }
  
  public final Thread d() {
    return this.a.getLooper().getThread();
  }
  
  public final String e() {
    return this.b;
  }
  
  public final void f() {
    this.c = this.d;
  }
  
  public final void run() {
    this.e = true;
    this.c = this.d;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\bugly\proguard\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */