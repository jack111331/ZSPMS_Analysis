package org.apache.http.params;

public interface HttpParams {
  HttpParams copy();
  
  boolean getBooleanParameter(String paramString, boolean paramBoolean);
  
  double getDoubleParameter(String paramString, double paramDouble);
  
  int getIntParameter(String paramString, int paramInt);
  
  long getLongParameter(String paramString, long paramLong);
  
  Object getParameter(String paramString);
  
  boolean isParameterFalse(String paramString);
  
  boolean isParameterTrue(String paramString);
  
  boolean removeParameter(String paramString);
  
  HttpParams setBooleanParameter(String paramString, boolean paramBoolean);
  
  HttpParams setDoubleParameter(String paramString, double paramDouble);
  
  HttpParams setIntParameter(String paramString, int paramInt);
  
  HttpParams setLongParameter(String paramString, long paramLong);
  
  HttpParams setParameter(String paramString, Object paramObject);
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\org\apache\http\params\HttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */