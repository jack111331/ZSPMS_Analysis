package org.jar.mvchelper.mvc;

import android.view.View;

public class MVCNormalHelper<DATA> extends MVCHelper<DATA> {
  public MVCNormalHelper(View paramView) {
    super(new RefreshView(paramView));
  }
  
  public MVCNormalHelper(View paramView, ILoadViewFactory.ILoadView paramILoadView) {
    super(new RefreshView(paramView), paramILoadView);
  }
  
  public MVCNormalHelper(View paramView, ILoadViewFactory.ILoadView paramILoadView, ILoadViewFactory.ILoadMoreView paramILoadMoreView) {
    super(new RefreshView(paramView), paramILoadView, paramILoadMoreView);
  }
  
  private static class RefreshView implements IRefreshView {
    private View contentView;
    
    public RefreshView(View param1View) {
      this.contentView = param1View;
    }
    
    public View getContentView() {
      return this.contentView;
    }
    
    public View getSwitchView() {
      return this.contentView;
    }
    
    public void setOnRefreshListener(IRefreshView.OnRefreshListener param1OnRefreshListener) {}
    
    public void showRefreshComplete() {}
    
    public void showRefreshing() {}
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\MVCNormalHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */