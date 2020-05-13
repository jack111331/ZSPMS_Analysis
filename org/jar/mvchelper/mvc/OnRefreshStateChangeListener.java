package org.jar.mvchelper.mvc;

public interface OnRefreshStateChangeListener<DATA> {
  void onEndRefresh(IDataAdapter<DATA> paramIDataAdapter, DATA paramDATA);
  
  void onStartRefresh(IDataAdapter<DATA> paramIDataAdapter);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\OnRefreshStateChangeListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */