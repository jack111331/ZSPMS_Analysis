package com.herosdk.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.herosdk.error.ErrorUtils;

final class ay implements Runnable {
  ay(Object paramObject, Context paramContext, String paramString) {}
  
  public void run() {
    try {
      ax.a(o.b("GMd7603UXo3NK1vNHEDhyg==", o.b()));
      String str = this.a.getClass().getSimpleName();
      SharedPreferences.Editor editor = this.b.getSharedPreferences(ax.a(), 0).edit();
      if ("String".equals(str)) {
        editor.putString(this.c, (String)this.a);
      } else if ("Integer".equals(str)) {
        editor.putInt(this.c, ((Integer)this.a).intValue());
      } else if ("Boolean".equals(str)) {
        editor.putBoolean(this.c, ((Boolean)this.a).booleanValue());
      } else if ("Float".equals(str)) {
        editor.putFloat(this.c, ((Float)this.a).floatValue());
      } else if ("Long".equals(str)) {
        editor.putLong(this.c, ((Long)this.a).longValue());
      } 
      editor.commit();
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\d\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */