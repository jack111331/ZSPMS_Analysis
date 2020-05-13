package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

public final class d {
  private static Context a;
  
  public static final Context a() {
    return (a == null) ? null : a;
  }
  
  public static final void a(Context paramContext) {
    a = paramContext;
  }
  
  public static final String b() {
    return (a() == null) ? "" : a().getPackageName();
  }
  
  public static final File c() {
    return (a() == null) ? null : a().getFilesDir();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\ope\\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */