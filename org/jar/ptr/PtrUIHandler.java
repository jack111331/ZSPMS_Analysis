package org.jar.ptr;

import org.jar.ptr.indicator.PtrIndicator;

public interface PtrUIHandler {
  void onUIPositionChange(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, PtrIndicator paramPtrIndicator);
  
  void onUIRefreshBegin(PtrFrameLayout paramPtrFrameLayout);
  
  void onUIRefreshComplete(PtrFrameLayout paramPtrFrameLayout);
  
  void onUIRefreshPrepare(PtrFrameLayout paramPtrFrameLayout);
  
  void onUIReset(PtrFrameLayout paramPtrFrameLayout);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\ptr\PtrUIHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */