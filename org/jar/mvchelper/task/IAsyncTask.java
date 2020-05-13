package org.jar.mvchelper.task;

import org.jar.mvchelper.mvc.RequestHandle;
import org.jar.mvchelper.mvc.ResponseSender;

public interface IAsyncTask<DATA> extends ISuperTask<DATA> {
  RequestHandle execute(ResponseSender<DATA> paramResponseSender) throws Exception;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\task\IAsyncTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */