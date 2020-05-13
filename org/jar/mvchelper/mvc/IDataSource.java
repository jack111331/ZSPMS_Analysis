package org.jar.mvchelper.mvc;

import org.jar.mvchelper.task.ISuperTask;

public interface IDataSource<DATA> extends ISuperTask<DATA> {
  boolean hasMore();
  
  DATA loadMore() throws Exception;
  
  DATA refresh() throws Exception;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\IDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */