package org.jar.mvchelper.mvc;

public interface ResponseSender<DATA> extends ProgressSender {
  void sendData(DATA paramDATA);
  
  void sendError(Exception paramException);
  
  void sendProgress(long paramLong1, long paramLong2, Object paramObject);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\jar\mvchelper\mvc\ResponseSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */