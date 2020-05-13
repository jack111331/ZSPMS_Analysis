package com.bun.lib;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.support.annotation.Keep;

@Keep
public class sysParamters {
  @Keep
  private static volatile sysParamters d;
  
  @Keep
  private String a;
  
  @Keep
  private String b;
  
  @Keep
  private String c;
  
  @Keep
  private String sdk_version = "10012";
  
  @Keep
  private String sdk_vname = "1.0.12";
  
  @Keep
  private static native PackageInfo a(Context paramContext, String paramString);
  
  @Keep
  public static native String a(Context paramContext);
  
  @Keep
  public static native String a(String paramString1, String paramString2);
  
  @Keep
  public static native String e();
  
  @Keep
  public static native sysParamters f();
  
  @Keep
  public static native String g();
  
  @Keep
  private static native String h();
  
  @Keep
  public native String a();
  
  @Keep
  public native String b();
  
  @Keep
  public native String c();
  
  @Keep
  public native String d();
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\bun\lib\sysParamters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */