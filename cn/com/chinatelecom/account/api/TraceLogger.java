package cn.com.chinatelecom.account.api;

public interface TraceLogger {
  void debug(String paramString1, String paramString2);
  
  void info(String paramString1, String paramString2);
  
  void warn(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\cn\com\chinatelecom\account\api\TraceLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */