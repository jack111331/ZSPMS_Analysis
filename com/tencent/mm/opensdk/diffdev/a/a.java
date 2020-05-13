package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

public final class a implements IDiffDevOAuth {
  private List<OAuthListener> h = new ArrayList<OAuthListener>();
  
  private Handler handler = null;
  
  private d i;
  
  private OAuthListener j = new b(this);
  
  public final void addListener(OAuthListener paramOAuthListener) {
    if (!this.h.contains(paramOAuthListener))
      this.h.add(paramOAuthListener); 
  }
  
  public final boolean auth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, OAuthListener paramOAuthListener) {
    StringBuilder stringBuilder = new StringBuilder("start auth, appId = ");
    stringBuilder.append(paramString1);
    Log.i("MicroMsg.SDK.DiffDevOAuth", stringBuilder.toString());
    if (paramString1 == null || paramString1.length() <= 0 || paramString2 == null || paramString2.length() <= 0) {
      Log.d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", new Object[] { paramString1, paramString2 }));
      return false;
    } 
    if (this.handler == null)
      this.handler = new Handler(Looper.getMainLooper()); 
    addListener(paramOAuthListener);
    if (this.i != null) {
      Log.d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
      return true;
    } 
    this.i = new d(paramString1, paramString2, paramString3, paramString4, paramString5, this.j);
    d d1 = this.i;
    if (Build.VERSION.SDK_INT >= 11) {
      d1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    } else {
      d1.execute((Object[])new Void[0]);
    } 
    return true;
  }
  
  public final void detach() {
    Log.i("MicroMsg.SDK.DiffDevOAuth", "detach");
    this.h.clear();
    stopAuth();
  }
  
  public final void removeAllListeners() {
    this.h.clear();
  }
  
  public final void removeListener(OAuthListener paramOAuthListener) {
    this.h.remove(paramOAuthListener);
  }
  
  public final boolean stopAuth() {
    boolean bool;
    Log.i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
    try {
      if (this.i == null) {
        bool = true;
      } else {
        bool = this.i.a();
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("stopAuth fail, ex = ");
      stringBuilder.append(exception.getMessage());
      Log.w("MicroMsg.SDK.DiffDevOAuth", stringBuilder.toString());
      bool = false;
    } 
    this.i = null;
    return bool;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\tencent\mm\opensdk\diffdev\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */