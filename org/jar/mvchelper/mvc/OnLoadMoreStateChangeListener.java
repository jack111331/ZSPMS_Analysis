package org.jar.mvchelper.mvc;

public interface OnLoadMoreStateChangeListener<DATA> {
  void onEndLoadMore(IDataAdapter<DATA> paramIDataAdapter, DATA paramDATA);
  
  void onStartLoadMore(IDataAdapter<DATA> paramIDataAdapter);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\OnLoadMoreStateChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */