package com.tencent.wxop.stat.b;

import android.util.Log;
import com.tencent.wxop.stat.c;

public final class b {
  private String a = "default";
  
  private boolean ch = true;
  
  private int cp = 2;
  
  public b() {}
  
  public b(String paramString) {
    this.a = paramString;
  }
  
  private String c() {
    String str = null;
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null)
      return str; 
    int i = arrayOfStackTraceElement.length;
    byte b1 = 0;
    while (true) {
      String str1 = str;
      if (b1 < i) {
        StackTraceElement stackTraceElement = arrayOfStackTraceElement[b1];
        if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName()))
          return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]"; 
        b1++;
        continue;
      } 
      return str1;
    } 
  }
  
  public final void a(Throwable paramThrowable) {
    if (this.cp <= 6) {
      Log.e(this.a, "", paramThrowable);
      c.F();
    } 
  }
  
  public final void ap() {
    this.ch = false;
  }
  
  public final void b(Object paramObject) {
    if (this.ch && this.cp <= 4) {
      String str = c();
      if (str == null) {
        paramObject = paramObject.toString();
      } else {
        paramObject = str + " - " + paramObject;
      } 
      Log.i(this.a, (String)paramObject);
      c.F();
    } 
  }
  
  public final void b(Throwable paramThrowable) {
    if (this.ch)
      a(paramThrowable); 
  }
  
  public final void c(Object paramObject) {
    if (this.ch)
      warn(paramObject); 
  }
  
  public final void d(Object paramObject) {
    if (this.ch)
      error(paramObject); 
  }
  
  public final void debug(Object paramObject) {
    if (this.cp <= 3) {
      String str = c();
      if (str == null) {
        paramObject = paramObject.toString();
      } else {
        paramObject = str + " - " + paramObject;
      } 
      Log.d(this.a, (String)paramObject);
      c.F();
    } 
  }
  
  public final void e(Object paramObject) {
    if (this.ch)
      debug(paramObject); 
  }
  
  public final void error(Object paramObject) {
    if (this.cp <= 6) {
      String str = c();
      if (str == null) {
        paramObject = paramObject.toString();
      } else {
        paramObject = str + " - " + paramObject;
      } 
      Log.e(this.a, (String)paramObject);
      c.F();
    } 
  }
  
  public final void warn(Object paramObject) {
    if (this.cp <= 5) {
      String str = c();
      if (str == null) {
        paramObject = paramObject.toString();
      } else {
        paramObject = str + " - " + paramObject;
      } 
      Log.w(this.a, (String)paramObject);
      c.F();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\wxop\stat\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */