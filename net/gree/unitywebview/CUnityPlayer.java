package net.gree.unitywebview;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.SurfaceView;
import android.view.View;
import com.unity3d.player.UnityPlayer;

public class CUnityPlayer extends UnityPlayer {
  public CUnityPlayer(ContextWrapper paramContextWrapper) {
    super((Context)paramContextWrapper);
  }
  
  public void addView(View paramView) {
    if (paramView instanceof SurfaceView)
      ((SurfaceView)paramView).setZOrderOnTop(false); 
    super.addView(paramView);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\net\gre\\unitywebview\CUnityPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */