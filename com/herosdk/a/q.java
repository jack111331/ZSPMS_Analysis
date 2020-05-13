package com.herosdk.a;

import android.text.TextUtils;
import android.util.Log;
import com.herosdk.d.az;
import com.herosdk.d.bb;
import com.herosdk.d.r;
import com.herosdk.error.ErrorUtils;
import com.herosdk.listener.ICommonListener;

class q implements ICommonListener {
  q(n paramn) {}
  
  public void onFailed(int paramInt, String paramString) {
    try {
      String str = n.B();
      StringBuilder stringBuilder = new StringBuilder();
      this();
      Log.d(str, stringBuilder.append("RND tARN failed:").append(paramString).toString());
      if (!TextUtils.isEmpty(paramString)) {
        r r = new r();
        this(this, paramString);
        bb.a(r);
      } 
      if (n.b(this.a) != null)
        n.b(this.a).onFailed(paramInt, paramString); 
      return;
    } catch (Exception exception) {
      return;
    } finally {
      r.a().b();
    } 
  }
  
  public void onSuccess(int paramInt, String paramString) {
    Log.d(n.B(), "RND tARN success");
    try {
      f.d(this.a.a);
      az.a = Boolean.valueOf(false);
      if (n.b(this.a) != null)
        n.b(this.a).onSuccess(paramInt, paramString); 
      return;
    } catch (Exception exception) {
      ErrorUtils.printExceptionInfo(exception);
      return;
    } finally {
      r.a().b();
    } 
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */