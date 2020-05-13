package net.gree.unitywebview;

import android.webkit.JavascriptInterface;
import com.unity3d.player.UnityPlayer;

class CWebViewPluginInterface {
  private String mGameObject;
  
  private CWebViewPlugin mPlugin;
  
  public CWebViewPluginInterface(CWebViewPlugin paramCWebViewPlugin, String paramString) {
    this.mPlugin = paramCWebViewPlugin;
    this.mGameObject = paramString;
  }
  
  @JavascriptInterface
  public void call(String paramString) {
    call("CallFromJS", paramString);
  }
  
  public void call(final String method, final String message) {
    UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
          public void run() {
            if (CWebViewPluginInterface.this.mPlugin.IsInitialized())
              UnityPlayer.UnitySendMessage(CWebViewPluginInterface.this.mGameObject, method, message); 
          }
        });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\net\gre\\unitywebview\CWebViewPluginInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */