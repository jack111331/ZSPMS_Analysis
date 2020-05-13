package org.jar.mvchelper.mvc;

public interface IDataAdapter<DATA> {
  DATA getData();
  
  boolean isEmpty();
  
  void notifyDataChanged(DATA paramDATA, boolean paramBoolean);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\IDataAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */