package net.gree.unitywebview;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.View;
import com.unity3d.player.UnityPlayerActivity;

public class CUnityPlayerActivity extends UnityPlayerActivity {
  public void onCreate(Bundle paramBundle) {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFormat(2);
    this.mUnityPlayer = new CUnityPlayer((ContextWrapper)this);
    setContentView((View)this.mUnityPlayer);
    this.mUnityPlayer.requestFocus();
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\net\gre\\unitywebview\CUnityPlayerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */