package com.herosdk.listener;

import android.os.Bundle;

public interface IVoiceDictateListener {
  void onBeginOfSpeech();
  
  void onEndOfSpeech();
  
  void onError(int paramInt, String paramString);
  
  @Deprecated
  void onEvent(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle);
  
  void onInitFailed(String paramString);
  
  void onInitSuccess();
  
  void onResult(String paramString);
  
  @Deprecated
  void onVolumeChanged(int paramInt, byte[] paramArrayOfbyte);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\herosdk\listener\IVoiceDictateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */