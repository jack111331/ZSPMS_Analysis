package org.jar.mvchelper.mvc;

import android.view.View;

public interface ILoadViewFactory {
  ILoadMoreView madeLoadMoreView();
  
  ILoadView madeLoadView();
  
  public static interface FootViewAdder {
    View addFootView(int param1Int);
    
    View addFootView(View param1View);
    
    View getContentView();
  }
  
  public static interface ILoadMoreView {
    void init(ILoadViewFactory.FootViewAdder param1FootViewAdder, View.OnClickListener param1OnClickListener);
    
    void showFail(Exception param1Exception);
    
    void showLoading();
    
    void showNomore();
    
    void showNormal();
  }
  
  public static interface ILoadView {
    void init(View param1View, View.OnClickListener param1OnClickListener);
    
    void restore();
    
    void showEmpty();
    
    void showFail(Exception param1Exception);
    
    void showLoading();
    
    void tipFail(Exception param1Exception);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\ILoadViewFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */