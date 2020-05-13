package org.jar.mvchelper.mvc;

import org.jar.mvchelper.task.ISuperTask;

public interface IAsyncDataSource<DATA> extends ISuperTask<DATA> {
  boolean hasMore();
  
  RequestHandle loadMore(ResponseSender<DATA> paramResponseSender) throws Exception;
  
  RequestHandle refresh(ResponseSender<DATA> paramResponseSender) throws Exception;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\IAsyncDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */