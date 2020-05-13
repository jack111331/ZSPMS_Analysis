package com.tencent.tp;

import android.content.Context;
import android.os.AsyncTask;

class a extends AsyncTask {
  protected Context a;
  
  public a(Context paramContext) {
    this.a = paramContext;
  }
  
  private String a(Context paramContext) {
    String str;
    try {
      str = z.a(paramContext);
    } catch (Throwable throwable) {
      str = "";
    } 
    return str;
  }
  
  private void a() {
    p.a(this.a);
    TssSdkRuntime.doSyncInitalizeTask2(this.a);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Language:");
    stringBuilder.append(z.m());
    u.a(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Country:");
    stringBuilder.append(z.e());
    u.a(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("cpu_model:");
    stringBuilder.append(a(this.a));
    u.a(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("simulator_name:");
    stringBuilder.append(z.b(this.a));
    u.a(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("adb:");
    stringBuilder.append(TssSdkRuntime.getAdbEnabledOverUsb(this.a));
    u.a(stringBuilder.toString());
    u.a("info:on initialize done");
  }
  
  protected Void a(Void... paramVarArgs) {
    try {
      a();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("*#07#:");
      stringBuilder.append(exception.toString());
      u.a(stringBuilder.toString());
    } 
    return null;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\tp\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */