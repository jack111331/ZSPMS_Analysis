package com.haru.heroshare;

import com.herosdk.HeroSdk;
import com.herosdk.bean.ShareInfo;
import com.herosdk.listener.IShareListener;
import com.unity3d.player.UnityPlayer;

public class HeroShareAgent {
  private static final String CALL_BACK_METHOD = "ShareResultCallback";
  
  private static final String GAME_OBJECT = "ShareAgent";
  
  public static void share(boolean paramBoolean, int paramInt1, int paramInt2, final int shareId, String paramString1, int paramInt4, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
    ShareInfo shareInfo = new ShareInfo();
    if (paramString5 != null && !paramString5.isEmpty())
      shareInfo.setTitle(paramString5); 
    if (paramString1 != null && !paramString1.isEmpty())
      shareInfo.setText(paramString1); 
    if (paramString4 != null && !paramString4.isEmpty())
      shareInfo.setUrl(paramString4); 
    if (paramString2 != null && !paramString2.isEmpty())
      shareInfo.setImagePath(paramString2); 
    if (paramBoolean)
      paramInt2 = 0; 
    HeroSdk.getInstance().share(UnityPlayer.currentActivity, shareInfo, paramBoolean, paramInt2, new IShareListener() {
          public void onShareCancel(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-1,");
            stringBuilder.append(shareId);
            UnityPlayer.UnitySendMessage("ShareAgent", "ShareResultCallback", stringBuilder.toString());
          }
          
          public void onShareFailed(int param1Int, String param1String) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("1,");
            stringBuilder.append(shareId);
            UnityPlayer.UnitySendMessage("ShareAgent", "ShareResultCallback", stringBuilder.toString());
          }
          
          public void onShareSucceed(int param1Int) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0,");
            stringBuilder.append(shareId);
            UnityPlayer.UnitySendMessage("ShareAgent", "ShareResultCallback", stringBuilder.toString());
          }
        });
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\haru\heroshare\HeroShareAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */