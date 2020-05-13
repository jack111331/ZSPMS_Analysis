package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializable;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONPObject implements JSONSerializable {
  private static final int BrowserSecureMask = SerializerFeature.BrowserSecure.mask;
  
  public static String SECURITY_PREFIX = "/**/";
  
  private String function;
  
  private final List<Object> parameters = new ArrayList();
  
  public JSONPObject() {}
  
  public JSONPObject(String paramString) {
    this.function = paramString;
  }
  
  public void addParameter(Object paramObject) {
    this.parameters.add(paramObject);
  }
  
  public String getFunction() {
    return this.function;
  }
  
  public List<Object> getParameters() {
    return this.parameters;
  }
  
  public void setFunction(String paramString) {
    this.function = paramString;
  }
  
  public String toJSONString() {
    return toString();
  }
  
  public String toString() {
    return JSON.toJSONString(this);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject, Type paramType, int paramInt) throws IOException {
    paramObject = paramJSONSerializer.out;
    if ((BrowserSecureMask & paramInt) != 0 || paramObject.isEnabled(BrowserSecureMask))
      paramObject.write(SECURITY_PREFIX); 
    paramObject.write(this.function);
    paramObject.write(40);
    for (paramInt = 0; paramInt < this.parameters.size(); paramInt++) {
      if (paramInt != 0)
        paramObject.write(44); 
      paramJSONSerializer.write(this.parameters.get(paramInt));
    } 
    paramObject.write(41);
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\JSONPObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */