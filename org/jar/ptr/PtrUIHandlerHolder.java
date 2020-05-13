package org.jar.ptr;

import org.jar.ptr.indicator.PtrIndicator;

class PtrUIHandlerHolder implements PtrUIHandler {
  private PtrUIHandler mHandler;
  
  private PtrUIHandlerHolder mNext;
  
  public static void addHandler(PtrUIHandlerHolder paramPtrUIHandlerHolder, PtrUIHandler paramPtrUIHandler) {
    if (paramPtrUIHandler == null)
      return; 
    if (paramPtrUIHandlerHolder == null)
      return; 
    PtrUIHandlerHolder ptrUIHandlerHolder = paramPtrUIHandlerHolder;
    if (paramPtrUIHandlerHolder.mHandler == null) {
      paramPtrUIHandlerHolder.mHandler = paramPtrUIHandler;
      return;
    } 
    while (true) {
      if (ptrUIHandlerHolder.contains(paramPtrUIHandler))
        return; 
      if (ptrUIHandlerHolder.mNext == null) {
        paramPtrUIHandlerHolder = new PtrUIHandlerHolder();
        paramPtrUIHandlerHolder.mHandler = paramPtrUIHandler;
        ptrUIHandlerHolder.mNext = paramPtrUIHandlerHolder;
        return;
      } 
      ptrUIHandlerHolder = ptrUIHandlerHolder.mNext;
    } 
  }
  
  private boolean contains(PtrUIHandler paramPtrUIHandler) {
    boolean bool;
    if (this.mHandler != null && this.mHandler == paramPtrUIHandler) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public static PtrUIHandlerHolder create() {
    return new PtrUIHandlerHolder();
  }
  
  private PtrUIHandler getHandler() {
    return this.mHandler;
  }
  
  public static PtrUIHandlerHolder removeHandler(PtrUIHandlerHolder paramPtrUIHandlerHolder, PtrUIHandler paramPtrUIHandler) {
    if (paramPtrUIHandlerHolder == null || paramPtrUIHandler == null || paramPtrUIHandlerHolder.mHandler == null)
      return paramPtrUIHandlerHolder; 
    PtrUIHandlerHolder ptrUIHandlerHolder1 = paramPtrUIHandlerHolder;
    PtrUIHandlerHolder ptrUIHandlerHolder2 = null;
    PtrUIHandlerHolder ptrUIHandlerHolder3 = paramPtrUIHandlerHolder;
    while (true) {
      PtrUIHandlerHolder ptrUIHandlerHolder;
      if (ptrUIHandlerHolder3.contains(paramPtrUIHandler)) {
        if (ptrUIHandlerHolder2 == null) {
          ptrUIHandlerHolder = ptrUIHandlerHolder3.mNext;
          ptrUIHandlerHolder3.mNext = null;
          paramPtrUIHandlerHolder = ptrUIHandlerHolder;
        } else {
          ptrUIHandlerHolder2.mNext = ptrUIHandlerHolder3.mNext;
          ptrUIHandlerHolder3.mNext = null;
          paramPtrUIHandlerHolder = ptrUIHandlerHolder2.mNext;
          ptrUIHandlerHolder = ptrUIHandlerHolder1;
        } 
      } else {
        paramPtrUIHandlerHolder = ptrUIHandlerHolder3.mNext;
        ptrUIHandlerHolder = ptrUIHandlerHolder1;
        ptrUIHandlerHolder2 = ptrUIHandlerHolder3;
      } 
      ptrUIHandlerHolder1 = ptrUIHandlerHolder;
      ptrUIHandlerHolder3 = paramPtrUIHandlerHolder;
      if (paramPtrUIHandlerHolder == null) {
        paramPtrUIHandlerHolder = ptrUIHandlerHolder;
        if (ptrUIHandlerHolder == null)
          paramPtrUIHandlerHolder = new PtrUIHandlerHolder(); 
        return paramPtrUIHandlerHolder;
      } 
    } 
  }
  
  public boolean hasHandler() {
    boolean bool;
    if (this.mHandler != null) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public void onUIPositionChange(PtrFrameLayout paramPtrFrameLayout, boolean paramBoolean, byte paramByte, PtrIndicator paramPtrIndicator) {
    PtrUIHandler ptrUIHandler;
    PtrUIHandlerHolder ptrUIHandlerHolder = this;
    do {
      ptrUIHandler = ptrUIHandlerHolder.getHandler();
      if (ptrUIHandler != null)
        ptrUIHandler.onUIPositionChange(paramPtrFrameLayout, paramBoolean, paramByte, paramPtrIndicator); 
      ptrUIHandler = ptrUIHandlerHolder.mNext;
      PtrUIHandler ptrUIHandler1 = ptrUIHandler;
    } while (ptrUIHandler != null);
  }
  
  public void onUIRefreshBegin(PtrFrameLayout paramPtrFrameLayout) {
    PtrUIHandler ptrUIHandler;
    PtrUIHandlerHolder ptrUIHandlerHolder = this;
    do {
      ptrUIHandler = ptrUIHandlerHolder.getHandler();
      if (ptrUIHandler != null)
        ptrUIHandler.onUIRefreshBegin(paramPtrFrameLayout); 
      ptrUIHandler = ptrUIHandlerHolder.mNext;
      PtrUIHandler ptrUIHandler1 = ptrUIHandler;
    } while (ptrUIHandler != null);
  }
  
  public void onUIRefreshComplete(PtrFrameLayout paramPtrFrameLayout) {
    PtrUIHandler ptrUIHandler;
    PtrUIHandlerHolder ptrUIHandlerHolder = this;
    do {
      ptrUIHandler = ptrUIHandlerHolder.getHandler();
      if (ptrUIHandler != null)
        ptrUIHandler.onUIRefreshComplete(paramPtrFrameLayout); 
      ptrUIHandler = ptrUIHandlerHolder.mNext;
      PtrUIHandler ptrUIHandler1 = ptrUIHandler;
    } while (ptrUIHandler != null);
  }
  
  public void onUIRefreshPrepare(PtrFrameLayout paramPtrFrameLayout) {
    PtrUIHandler ptrUIHandler;
    if (!hasHandler())
      return; 
    PtrUIHandlerHolder ptrUIHandlerHolder = this;
    do {
      ptrUIHandler = ptrUIHandlerHolder.getHandler();
      if (ptrUIHandler != null)
        ptrUIHandler.onUIRefreshPrepare(paramPtrFrameLayout); 
      ptrUIHandler = ptrUIHandlerHolder.mNext;
      PtrUIHandler ptrUIHandler1 = ptrUIHandler;
    } while (ptrUIHandler != null);
  }
  
  public void onUIReset(PtrFrameLayout paramPtrFrameLayout) {
    PtrUIHandler ptrUIHandler;
    PtrUIHandlerHolder ptrUIHandlerHolder = this;
    do {
      ptrUIHandler = ptrUIHandlerHolder.getHandler();
      if (ptrUIHandler != null)
        ptrUIHandler.onUIReset(paramPtrFrameLayout); 
      ptrUIHandler = ptrUIHandlerHolder.mNext;
      PtrUIHandler ptrUIHandler1 = ptrUIHandler;
    } while (ptrUIHandler != null);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\ptr\PtrUIHandlerHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */