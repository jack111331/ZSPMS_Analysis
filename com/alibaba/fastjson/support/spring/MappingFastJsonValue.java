package com.alibaba.fastjson.support.spring;

public class MappingFastJsonValue {
  private String jsonpFunction;
  
  private Object value;
  
  public MappingFastJsonValue(Object paramObject) {
    this.value = paramObject;
  }
  
  public String getJsonpFunction() {
    return this.jsonpFunction;
  }
  
  public Object getValue() {
    return this.value;
  }
  
  public void setJsonpFunction(String paramString) {
    this.jsonpFunction = paramString;
  }
  
  public void setValue(Object paramObject) {
    this.value = paramObject;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\support\spring\MappingFastJsonValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */