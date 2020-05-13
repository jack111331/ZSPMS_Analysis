package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;

public class SerializeBeanInfo {
  protected final Class<?> beanType;
  
  protected int features;
  
  protected final FieldInfo[] fields;
  
  protected final JSONType jsonType;
  
  protected final FieldInfo[] sortedFields;
  
  protected final String typeKey;
  
  protected final String typeName;
  
  public SerializeBeanInfo(Class<?> paramClass, JSONType paramJSONType, String paramString1, String paramString2, int paramInt, FieldInfo[] paramArrayOfFieldInfo1, FieldInfo[] paramArrayOfFieldInfo2) {
    this.beanType = paramClass;
    this.jsonType = paramJSONType;
    this.typeName = paramString1;
    this.typeKey = paramString2;
    this.features = paramInt;
    this.fields = paramArrayOfFieldInfo1;
    this.sortedFields = paramArrayOfFieldInfo2;
  }
}


/* Location:              D:\Code\Crack\dex-tools-2.1-20190905-lanchon\zspns-pcgw-P36417A-0429-dex2jar.jar!\com\alibaba\fastjson\serializer\SerializeBeanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */