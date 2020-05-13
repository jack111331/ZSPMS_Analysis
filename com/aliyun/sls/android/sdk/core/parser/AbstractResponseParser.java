package com.aliyun.sls.android.sdk.core.parser;

import com.aliyun.sls.android.sdk.SLSLog;
import com.aliyun.sls.android.sdk.core.Result;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Response;

public abstract class AbstractResponseParser<T extends Result> implements ResponseParser {
  private Map<String, String> parseResponseHeader(Response paramResponse) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Headers headers = paramResponse.headers();
    for (byte b = 0; b < headers.size(); b++)
      hashMap.put(headers.name(b), headers.value(b)); 
    return (Map)hashMap;
  }
  
  public static void safeCloseResponse(Response paramResponse) {
    try {
      paramResponse.body().close();
    } catch (Exception exception) {}
  }
  
  public boolean needCloseResponse() {
    return true;
  }
  
  public T parse(Response paramResponse) throws IOException {
    Exception exception;
    try {
      Result result1 = ((Class<Result>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
      Result result2 = result1;
      if (result1 != null) {
        result1.setRequestId(paramResponse.header("x-log-requestid"));
        result1.setStatusCode(paramResponse.code());
        result1.setResponseHeader(parseResponseHeader(paramResponse));
        result2 = (Result)parseData(paramResponse, (T)result1);
      } 
      if (needCloseResponse())
        safeCloseResponse(paramResponse); 
      return (T)result2;
    } catch (Exception null) {
      IOException iOException = new IOException();
      this(exception.getMessage(), exception);
      exception.printStackTrace();
      SLSLog.logThrowable2Local(exception);
      throw iOException;
    } finally {}
    if (needCloseResponse())
      safeCloseResponse(paramResponse); 
    throw exception;
  }
  
  public abstract T parseData(Response paramResponse, T paramT) throws Exception;
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\aliyun\sls\android\sdk\core\parser\AbstractResponseParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */